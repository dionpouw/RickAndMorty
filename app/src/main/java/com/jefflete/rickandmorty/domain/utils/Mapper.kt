package com.jefflete.rickandmorty.domain.utils

import com.jefflete.rickandmorty.data.local.model.CharacterEntity
import com.jefflete.rickandmorty.data.local.model.CharacterLocationEntity
import com.jefflete.rickandmorty.data.local.model.CharacterOriginEntity
import com.jefflete.rickandmorty.data.network.response.character.CharacterResponse
import com.jefflete.rickandmorty.data.network.response.character.CharacterResponseLocation
import com.jefflete.rickandmorty.data.network.response.character.CharacterResponseOrigin
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.model.Location
import com.jefflete.rickandmorty.domain.model.Origin

// Mapper: DTO to Domain
object CharacterDtoMapper {
    fun toDomain(dto: CharacterResponse): Character {
        return Character(
            id = dto.id,
            name = dto.name,
            status = dto.status,
            species = dto.species,
            type = dto.type,
            gender = dto.gender,
            origin = Origin(
                dto.origin.name, dto.origin.url
            ),
            location = Location(dto.location.name, dto.location.url),
            image = dto.image,
            episode = dto.episode,
            url = dto.url,
            created = dto.created
        )
    }

    fun toDomainList(dtos: List<CharacterResponse>): List<Character> {
        return dtos.map { toDomain(it) }
    }
}

// Mapper: Domain to DTO
object CharacterDomainDtoMapper {
    private fun toDto(domain: Character): CharacterResponse {
        return CharacterResponse(
            id = domain.id,
            name = domain.name,
            status = domain.status,
            species = domain.species,
            type = domain.type,
            gender = domain.gender,

            origin = CharacterResponseOrigin(
                domain.origin.name, domain.origin.url
            ),
            location = CharacterResponseLocation(
                domain.location.name, domain.location.url
            ),
            image = domain.image,
            episode = domain.episode,
            url = domain.url,
            created = domain.created

        )
    }

    fun toDtoList(domains: List<Character>): List<CharacterResponse> {
        return domains.map { toDto(it) }
    }
}

// Mapper: Domain to Entity
object CharacterDomainEntityMapper {
    private fun toEntity(domain: Character): CharacterEntity {
        return CharacterEntity(
            id = domain.id,
            name = domain.name,
            status = domain.status,
            species = domain.species,
            type = domain.type,
            gender = domain.gender,
            origin = CharacterOriginEntity(
                domain.origin.name, domain.origin.url
            ),
            location = CharacterLocationEntity(
                domain.location.name, domain.location.url
            ),
            image = domain.image,
            episode = domain.episode,
            url = domain.url,
            created = domain.created
        )
    }

    fun toDomain(entity: CharacterEntity): Character {
        return Character(
            id = entity.id,
            name = entity.name,
            status = entity.status,
            species = entity.species,
            type = entity.type,
            gender = entity.gender,
            origin = Origin(
                entity.origin.name, entity.origin.url
            ),
            location = Location(
                entity.location.name, entity.location.url
            ),
            image = entity.image,
            episode = entity.episode,
            url = entity.url,
            created = entity.created
        )
    }

    fun toDomainList(entities: List<CharacterEntity>): List<Character> {
        return entities.map { toDomain(it) }
    }
}
