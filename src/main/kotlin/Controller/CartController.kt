package com.Main.BackDemo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(private val cartService: CartService) {

    @PostMapping("/add")
    fun addToCart(@RequestBody request: AddToCartRequest): CartItemDto {
        return cartService.addToCart(request)
    }

    @DeleteMapping("/remove/{productId}")
    fun removeFromCart(@PathVariable productId: Long) {
        cartService.removeFromCart(productId)
    }
    @GetMapping
    fun getCart(): List<CartItemDto> {
        return cartService.getCart()
    }
}