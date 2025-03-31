package com.Main.BackDemo

object ProductMapper {
    fun toDto(product: Product): ProductDto {
        return ProductDto(
            id = product.id,
            name = product.name,
            price = product.price
        )
    }
    fun toEntity(dto: ProductDto): Product {
        return Product(
            id = dto.id,
            name = dto.name,
            price = dto.price
        )
    }
}