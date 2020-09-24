package com.bsrakdg.moviecentral.util

/**
 * Entity is can be persistence or network level model.
 * ProjectModel is project level model.
 *
 * This class helps to separate model of domain and entity layer from project level models.
 * It is good practice for separating persistence models and network models.
 * Because they are not always the same. User mapper or converting them each other.
 *
 * */
interface EntityMapper<Entity, ProjectModel> {
    fun mapFromEntity(entityModel: Entity) : ProjectModel
    fun mapToEntity(domainModel: ProjectModel) : Entity
}