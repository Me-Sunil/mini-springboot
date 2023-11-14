package com.ys.dto

import jakarta.persistence.*
import java.io.Serializable


@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null,

    @Column
    val userName: String,

    @Column
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
    var addresses: Set<Address> = HashSet(),

) : Serializable
