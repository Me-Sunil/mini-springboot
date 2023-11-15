package com.ys.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val addressId: Long? = null,

    @Column
    var cityName: String,

    @Column
    var country: String,

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = false)
    val user: User


) : Serializable {
    override fun toString(): String {
        return "Address(addressId=$addressId, cityName='$cityName', country='$country')"
    }
}
