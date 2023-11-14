package com.ys.component

import com.ys.dto.Address
import com.ys.dto.User
import com.ys.service.AddressService
import com.ys.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Error

@RestController
class HomeController(
    val userService: UserService,
    val addressService: AddressService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/")
    fun getHome() {
        val userA = User(userName = "A");
        val userB = User(userName = "B");

        // Address A & B
        val addressA = Address(cityName = "BLR", country = "IND", user = userA)
        val addressB = Address(cityName = "HYD", country = "PAK", user = userA)

        // Address C & D
        val addressC = Address(cityName = "BLR", country = "IND", user = userB)
        val addressD = Address(cityName = "HYD", country = "PAK", user = userB)

        // Save User A with Addresses (Cascade)
        userA.addresses = setOf(addressA, addressB)
        userService.save(userA)

        // Save User B with Addresses (Cascade)
        userB.addresses = setOf(addressC, addressD)
        userService.save(userB)

        // Print Objects
        println()

        println(userService.echoUser(userA));
        println(userService.echoUser(userB));

        val optionalUser = userService.findByUserName("A")
        val user = optionalUser.get()

        val address = user.addresses.find { it.addressId?.toInt() == 2 } ?: throw Error("Address Not Found")
        address.cityName = "KARACHI"
        addressService.save(setOf(address))

        // Print Objects
        println()

        println(userService.echoUser(userA));
        println(userService.echoUser(userB));
    }
}