package com.Main.BackDemo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val productRepository: ProductRepository,
    private val cartItemRepository: CartItemRepository
) {
    fun addToCart(request: AddToCartRequest): CartItemDto {
        val product = productRepository.findById(request.productId)
            .orElseThrow { ProductNotFoundException ("Товар не найден")}

        val cartItem = cartItemRepository.save(
            CartItem(
                productId = product.id!!,
                quantity = request.quantity
            )
        )

        return CartMapper.toDto(cartItem)
    }

    @Transactional
    fun removeFromCart(productId: Long) {
        cartItemRepository.deleteByProductId(productId)
    }

    fun getCart(): List<CartItemDto> {
        return cartItemRepository.findAll()
            .map {CartMapper.toDto(it)}
    }

    fun updateQuantity(productId: Long, newQuantity: Int): CartItemDto {
        require(newQuantity > 0) { "Количество должно быть положительным" }

        val cartItem = cartItemRepository.findById(productId)
            .orElseThrow { CartItemNotFoundException ("Товар не найден в корзине") }

        cartItem.quantity = newQuantity
        cartItemRepository.save(cartItem)

        return CartMapper.toDto(cartItem)
    }

    fun getCartTotal(): Double {
        val cartItems = cartItemRepository.findAll()
        return cartItems.sumOf { item ->
            val product = productRepository.findById(item.productId)
                .orElseThrow {ProductNotFoundException ("Товар не найден") }
            product.price * item.quantity
        }
    }
}
