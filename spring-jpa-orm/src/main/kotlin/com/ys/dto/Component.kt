package com.ys.dto

import jakarta.persistence.*
import java.io.Serializable


@Entity
@Table(name = "components")
class Component(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val componentUniqueId: Long? = null,

    @Column
    val componentName: String,

    @ManyToOne
    @JoinColumn(name = "recommendation_id", nullable = false)
    val recommendation : Recommendation

) : Serializable
