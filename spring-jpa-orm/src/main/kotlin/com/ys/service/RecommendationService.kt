package com.ys.service

import com.ys.dto.Recommendation
import com.ys.respository.RecommendationRepository
import org.springframework.stereotype.Service

@Service
class RecommendationService(
    val repository: RecommendationRepository
) {
    fun save(recommendation: Recommendation): Recommendation {
        return repository.save(recommendation)
    }

    fun findAll(): List<Recommendation> {
        return repository.findAll()
    }
}