package com.ys.component

import com.ys.dto.Address
import com.ys.dto.User
import com.ys.service.Service
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DExecutor(
    val rService: Service
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun home() {
        logger.info("Running")
        val user = User(userName = "Sunil");

        val addressOne = Address(cityName = "BLR", country = "India", user = user)
        val addressTwo = Address(cityName = "HYD", country = "Pak", user = user)
        // Save Objects
        val addresses = setOf(addressOne, addressTwo)
        user.addresses = addresses

        rService.saveUser(user)
        rService.saveAddress(addresses)

        // Print Objects
        println()

        rService.allUsers().forEach {
            println(it.userId)
            it.addresses.forEach {
                println(it)
            }
        }

        // Update Address Two

        addressTwo.country = "ENG"
        rService.saveAddress(setOf(addressTwo))


        // Print Objects
        println()

        rService.allUsers().forEach {
            println(it.userId)
            it.addresses.forEach {
                println(it)
            }
        }

        // Update Address By Fetching

        val add = rService.allAddresses();
        val address = add.find { it.country == "India" && user.userName == "Sunil" } ?: throw Error("No Entity")

        address.cityName = "NEW_CITY"
        rService.saveAddress(setOf(address))


        // Print Objects
        println()

        rService.allUsers().forEach {
            println(it.userId)
            it.addresses.forEach {
                println(it)
            }
        }

    }
}