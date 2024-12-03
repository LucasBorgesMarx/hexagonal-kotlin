package com.devdeolho.hexagonal.config

import com.devdeolho.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.devdeolho.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.devdeolho.hexagonal.adapters.out.UpdateCustomerAdapter
import com.devdeolho.hexagonal.application.core.usecase.FindCustomerUseCase
import com.devdeolho.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {
    @Bean
    fun updateCustomer(
        findCustomerUseCase: FindCustomerUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = UpdateCustomerUseCase(
        findCustomerUseCase,
        findAddressByZipCodeAdapter,
        updateCustomerAdapter,
        sendCpfForValidationAdapter
    )

}