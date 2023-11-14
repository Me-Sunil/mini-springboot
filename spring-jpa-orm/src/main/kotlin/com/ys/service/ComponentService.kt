package com.ys.service

import com.ys.dto.Component
import com.ys.respository.ComponentRepository
import org.springframework.stereotype.Service

@Service
class ComponentService(
    val repository: ComponentRepository
) {
    fun save(component: Component): Component {
        return repository.save(component)
    }

    fun findAll(): List<Component> {
        return repository.findAll()
    }
}