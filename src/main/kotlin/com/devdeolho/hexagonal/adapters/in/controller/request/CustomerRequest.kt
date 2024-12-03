package com.devdeolho.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:
    NotBlank(message = "Name must not be blank")
    val name: String,
    @field:
    NotBlank(message = "CPF must not be blank")
    val cpf: String,
    @field:
    NotBlank(message = "Zip code must not be blank")
    val zipCode: String
)
