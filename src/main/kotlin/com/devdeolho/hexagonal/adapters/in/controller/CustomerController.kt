package com.devdeolho.hexagonal.adapters.`in`.controller

import com.devdeolho.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.devdeolho.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.devdeolho.hexagonal.application.ports.`in`.FindCustomerInputPort
import com.devdeolho.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.devdeolho.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerInputPort: FindCustomerInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        val customer = customerRequest.toCustomer()
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<CustomerResponse> {
        val customersList = findCustomerInputPort.findAll()
        return CustomerResponse.fromCustomers(customersList)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val foundCustomer = findCustomerInputPort.find(id)
        return CustomerResponse(foundCustomer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        val customer = customerRequest.toCustomer(id)
        updateCustomerInputPort.update(customer, customerRequest.zipCode)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        deleteCustomerByIdInputPort.delete(id)
    }

    private fun CustomerRequest.toCustomer(id: String? = null): Customer {
        return Customer(id = id, name = this.name, cpf = this.cpf)
    }
}