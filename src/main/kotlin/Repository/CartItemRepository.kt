package com.Main.BackDemo

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>

interface CartItemRepository : JpaRepository<CartItem, Long> {
    fun deleteByProductId(ProductId: Long)
}
