package com.ys.service

import com.ys.dto.Product
import com.ys.respository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    val repository: ProductRepository
) {
    fun save(product: Product): Product {
        return repository.save(product)
    }

    fun findAll(): List<Product> {
        return repository.findAll()
    }
}