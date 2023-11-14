package com.ys.dto

import jakarta.persistence.*
import org.springframework.context.annotation.Lazy
import java.io.Serializable


@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId : Long? = null,

    @Column
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    var addresses: Set<Address> = HashSet(),

    @Column
    val userName : String
): Serializable
