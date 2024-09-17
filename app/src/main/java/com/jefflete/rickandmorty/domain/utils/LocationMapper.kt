package com.jefflete.rickandmorty.domain.utils

import com.jefflete.rickandmorty.data.local.model.LocationEntity
import com.jefflete.rickandmorty.data.network.response.location.LocationResponse
import com.jefflete.rickandmorty.domain.model.Location

// Mapper: DTO to Domain
object LocationDtoMapper {
    fun toDomain(dto: LocationResponse): Location {
        return Location(
            id = dto.id,
            name = dto.name,
            type = dto.type,
            dimension = dto.dimension,
            residents = dto.residents,
            url = dto.url,
            created = dto.created
        )
    }

    fun toDomainList(dtos: List<LocationResponse>): List<Location> {
        return dtos.map { toDomain(it) }
    }
}

// Mapper: Domain to DTO
object LocationDomainDtoMapper {
    private fun toDto(domain: Location): LocationResponse {
        return LocationResponse(
            id = domain.id,
            name = domain.name,
            type = domain.type,
            dimension = domain.dimension,
            residents = domain.residents,
            url = domain.url,
            created = domain.created
        )
    }

    fun toDtoList(domains: List<Location>): List<LocationResponse> {
        return domains.map { toDto(it) }
    }
}

// Mapper: Domain to Entity
object LocationDomainEntityMapper {
    private fun toEntity(domain: Location): LocationEntity {
        return LocationEntity(
            id = domain.id,
            name = domain.name,
            type = domain.type,
            dimension = domain.dimension,
            residents = domain.residents,
            url = domain.url,
            created = domain.created
        )
    }

    fun toDomain(entity: LocationEntity): Location {
        return Location(
            id = entity.id,
            name = entity.name,
            type = entity.type,
            dimension = entity.dimension,
            residents = entity.residents,
            url = entity.url,
            created = entity.created
        )
    }

    fun toDomainList(entities: List<LocationEntity>): List<Location> {
        return entities.map { toDomain(it) }
    }
}
