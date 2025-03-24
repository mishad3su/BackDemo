package com.Main.BackDemo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController(private val cartService: CartService) {

    @PostMapping("/add")
    fun addToCart(@RequestParam productId: Long, @RequestParam quantity: Int): CartItem {
        return cartService.addToCart(productId, quantity)
    }

    @DeleteMapping("/remove/{productId}")
    fun removeFromCart(@PathVariable productId: Long) {
        cartService.removeFromCart(productId)
    }
    @GetMapping
    fun getCart(): List<CartItem> {
        return cartService.getCart()
    }
}