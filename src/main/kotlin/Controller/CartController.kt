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

    @PatchMapping("/update/{productId}")
     fun updateQuantity(
         @PathVariable productId: Long,
         @RequestParam newQuantity: Int
     ): CartItemDto {
         return cartService.updateQuantity(productId, newQuantity)
     }

    @GetMapping
    fun getTotal(): Map<String, Double> {
        return mapOf("Всего"  to cartService.getCartTotal())
    }
}
