package com.ys.service

import com.ys.dto.Address
import com.ys.respository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    val repository: AddressRepository
) {
    fun save(address: Set<Address>): List<Address> {
        return address.map { repository.save(it) }
    }

    fun findAll(): List<Address> {
        return repository.findAll()
    }
}