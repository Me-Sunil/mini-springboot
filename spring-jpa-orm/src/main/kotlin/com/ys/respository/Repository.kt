package com.ys.respository

import com.ys.dto.Address
import com.ys.dto.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>

@Repository
interface AddressRepository : JpaRepository<Address, Long>

