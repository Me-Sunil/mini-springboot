package com.ys.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable


@Entity
class Recommendation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uniqueId: Long? = null,

    @Column(unique = true)
    val recommendationId: String,

    @Column
    @OneToMany(mappedBy = "recommendation", cascade = [CascadeType.ALL])
    var components: Set<Component> = HashSet(),

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product

) : Serializable
