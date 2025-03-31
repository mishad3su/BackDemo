package com.Main.BackDemo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun getProduct(id: Long): ProductDto {
        val product = productRepository.findById(id)
            .orElseThrow { ProductNotFoundException("Товар не найден.")}
        return ProductMapper.toDto(product)
    }
}
