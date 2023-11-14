package com.ys.service

import com.ys.dto.User
import com.ys.respository.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(
    val repository: UserRepository,
) {

    fun save(user: User): User {
        return repository.save(user)
    }

    fun findAll(): List<User> {
        return repository.findAll()
    }

    fun findByUserName(userName : String): Optional<User> {
        return repository.findByUserName(userName)
    }

    fun echoUser(user: User){
        println("${user.userId} - ${user.userName} - ${user.addresses}")
    }
}