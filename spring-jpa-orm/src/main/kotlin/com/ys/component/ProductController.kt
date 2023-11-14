package com.ys.component

import com.ys.dto.Component
import com.ys.dto.Product
import com.ys.dto.Recommendation
import com.ys.service.ComponentService
import com.ys.service.ProductService
import com.ys.service.RecommendationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    val productService: ProductService,
    val recommendationService: RecommendationService,
    val componentService: ComponentService
) {
    @GetMapping("/product")
    fun getHome() {
        val productA = Product(productId = "12345")
        val productB = Product(productId = "54321")

        val recommendationAA = Recommendation(recommendationId = "123", product = productA)
        val recommendationAB = Recommendation(recommendationId = "456", product = productA)

        val recommendationBA = Recommendation(recommendationId = "789", product = productB)
        val recommendationBB = Recommendation(recommendationId = "987", product = productB)

        val componentAAA = Component(componentName = "AAA", recommendation = recommendationAA)
        val componentAAB = Component(componentName = "AAB", recommendation = recommendationAA)

        val componentABA = Component(componentName = "ABA", recommendation = recommendationAB)
        val componentABB = Component(componentName = "ABB", recommendation = recommendationAB)

        val componentBAA = Component(componentName = "BAA", recommendation = recommendationBA)
        val componentBAB = Component(componentName = "BAB", recommendation = recommendationBA)

        val componentBBA = Component(componentName = "BBA", recommendation = recommendationBB)
        val componentBBB = Component(componentName = "BBB", recommendation = recommendationBB)

        recommendationBB.components = setOf(componentBBA, componentBBB)
        recommendationBA.components = setOf(componentBAA, componentBAB)
        recommendationAB.components = setOf(componentABA, componentABB)
        recommendationAA.components = setOf(componentAAA, componentAAB)

        productA.recommendations = setOf(recommendationAA, recommendationAB)
        productB.recommendations = setOf(recommendationBA, recommendationBB)

        // Save Product
        productService.save(productA)
        productService.save(productB)

        // Save Recommendations
        recommendationService.save(recommendationBB)
        recommendationService.save(recommendationBA)
        recommendationService.save(recommendationAB)
        recommendationService.save(recommendationAA)

        // Save Component
        componentService.save(componentAAA)
        componentService.save(componentAAB)
        componentService.save(componentABA)
        componentService.save(componentABB)
        componentService.save(componentBAA)
        componentService.save(componentBAB)
        componentService.save(componentBBA)
        componentService.save(componentBBB)

        println("Save in Sequence")
    }
}