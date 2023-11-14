package com.ys.service

import com.ys.dto.Address
import com.ys.dto.User
import com.ys.respository.AddressRepository
import com.ys.respository.UserRepository
import org.springframework.stereotype.Service

@Service
class Service(
    val uR: UserRepository,
    val aR: AddressRepository
) {

    fun saveUser(user: User): User {
        return uR.save(user)
    }

    fun saveAddress(address: Set<Address>): List<Address> {
        return address.map { aR.save(it) }
    }

    fun allAddresses(): List<Address> {
        return aR.findAll()
    }

    fun allUsers(): List<User> {
        return uR.findAll()
    }
}