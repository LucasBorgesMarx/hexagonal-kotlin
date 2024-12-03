package com.devdeolho.hexagonal.adapters.`in`.consumer

import com.devdeolho.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.devdeolho.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {
    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "devdeolho")
    fun handleCustomerMessage(customerMessage: CustomerMessage) {
        val customer = customerMessage.toCustomer()
        updateCustomerInputPort.update(customer, customerMessage.zipCode)

        // Assuming you have a logger set up
        logger.info("Mensagem recebida: {}", customerMessage)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ReceiveValidatedCustomerDataConsumer::class.java)
    }
}
