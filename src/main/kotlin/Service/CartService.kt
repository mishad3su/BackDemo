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
            .orElseThrow { ProductNotFoundExceprion ("Товар не найден")}

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
}
