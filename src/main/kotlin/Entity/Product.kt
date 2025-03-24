package com.Main.BackDemo

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable=false)
    val name: String,

    @Column(nullable = false)
    val price: Double
)