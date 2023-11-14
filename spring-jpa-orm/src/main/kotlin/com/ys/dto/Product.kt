package com.ys.dto

import jakarta.persistence.*
import java.io.Serializable


@Entity
@Table(name = "product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uniqueId: Long? = null,

    @Column(unique = true)
    val productId : String,

    @Column
    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    var recommendations: Set<Recommendation> = HashSet(),

) : Serializable
