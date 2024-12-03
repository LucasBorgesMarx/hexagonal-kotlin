package com.devdeolho.hexagonal.application.ports.out

import com.devdeolho.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {
    fun find(zipCode: String): Address
}