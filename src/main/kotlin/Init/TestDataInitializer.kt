package com.Main.BackDemo

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class TestDataInitializer (
    private val productRepository: ProductRepository
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        if (productRepository.count() == 0L) {
            val products = listOf(
                Product(
                    name = "Моторное масло 5W-30",
                    price = 2500.00
                ),
                Product(
                    name = "Тормозные колодки",
                    price = 3400.00
                )
            )
            productRepository.saveAll(products)
        }
    }
}