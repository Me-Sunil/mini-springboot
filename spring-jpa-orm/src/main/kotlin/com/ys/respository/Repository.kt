package com.ys.respository

import com.ys.dto.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): Optional<User>
}

@Repository
interface AddressRepository : JpaRepository<Address, Long>

@Repository
interface ProductRepository : JpaRepository<Product, Long>

@Repository
interface RecommendationRepository : JpaRepository<Recommendation, Long>

@Repository
interface ComponentRepository : JpaRepository<Component, Long>

