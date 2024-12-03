package com.devdeolho.hexagonal.config

import com.devdeolho.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.devdeolho.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.devdeolho.hexagonal.application.core.usecase.FindCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {
    @Bean
    fun deleteCustomer(
        findCustomerUseCase: FindCustomerUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(
        findCustomerUseCase,
        deleteCustomerByIdAdapter
    )
}