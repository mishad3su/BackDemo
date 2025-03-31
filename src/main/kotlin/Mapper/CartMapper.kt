package com.Main.BackDemo

object CartMapper {
    fun toDto(cartItem: CartItem): CartItemDto {
        return CartItemDto(
            id = cartItem.id,
            productId = cartItem.productId,
            quantity = cartItem.quantity
        )
    }
    fun toEntity(dto: CartItemDto): CartItem {
        return CartItem(
            id = dto.id,
            productId = dto.productId,
            quantity = dto.quantity
        )
    }
}