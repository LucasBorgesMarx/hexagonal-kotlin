package com.devdeolho.hexagonal.config

import com.devdeolho.hexagonal.adapters.out.FindCustomerAdapter
import com.devdeolho.hexagonal.application.core.usecase.FindCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerConfig {
    @Bean
    fun findCustomerById(findCustomerAdapter: FindCustomerAdapter) =
        FindCustomerUseCase(findCustomerAdapter)
}