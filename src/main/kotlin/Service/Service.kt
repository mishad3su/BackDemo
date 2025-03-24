package com.Main.BackDemo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val productRepository: ProductRepository,
    private val cartItemRepository: CartItemRepository
) {
    fun addToCart(productId:Long, quantity: Int): CartItem {
        val product = productRepository.findById(productId)
            .orElseThrow { IllegalArgumentException("Товар не найден")}
        val cartItem = CartItem(productId = product.id!!, quantity = quantity)
        return cartItemRepository.save(cartItem)
    }

    @Transactional
    fun removeFromCart(productId: Long) {
        cartItemRepository.deleteByProductId(productId)
    }

    fun getCart(): List<CartItem> {
        return cartItemRepository.findAll()
    }
}
