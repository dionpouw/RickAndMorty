package com.jefflete.rickandmorty.domain.utils

import com.jefflete.rickandmorty.data.local.model.EpisodeEntity
import com.jefflete.rickandmorty.data.network.response.episode.EpisodeResponse
import com.jefflete.rickandmorty.domain.model.Episode

// Mapper: DTO to Domain
object EpisodeDtoMapper {
    fun toDomain(dto: EpisodeResponse): Episode {
        return Episode(
            id = dto.id,
            name = dto.name,
            airDate = dto.airDate,
            episode = dto.episode,
            characters = dto.characters,
            url = dto.url,
            created = dto.created
        )
    }

    fun toDomainList(dtos: List<EpisodeResponse>): List<Episode> {
        return dtos.map { toDomain(it) }
    }
}

// Mapper: Domain to DTO
object EpisodeDomainDtoMapper {
    private fun toDto(domain: Episode): EpisodeResponse {
        return EpisodeResponse(
            id = domain.id,
            name = domain.name,
            airDate = domain.airDate,
            episode = domain.episode,
            characters = domain.characters,
            url = domain.url,
            created = domain.created
        )
    }

    fun toDtoList(domains: List<Episode>): List<EpisodeResponse> {
        return domains.map { toDto(it) }
    }
}

// Mapper: Domain to Entity
object EpisodeDomainEntityMapper {
    private fun toEntity(domain: Episode): EpisodeEntity {
        return EpisodeEntity(
            id = domain.id,
            name = domain.name,
            airDate = domain.airDate,
            episode = domain.episode,
            characters = domain.characters,
            url = domain.url,
            created = domain.created
        )
    }

    fun toDomain(entity: EpisodeEntity): Episode {
        return Episode(
            id = entity.id,
            name = entity.name,
            airDate = entity.airDate,
            episode = entity.episode,
            characters = entity.characters,
            url = entity.url,
            created = entity.created
        )
    }

    fun toDomainList(entities: List<EpisodeEntity>): List<Episode> {
        return entities.map { toDomain(it) }
    }
}
