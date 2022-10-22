package com.example.sam.mapper;

public interface Mapper<Entity, Dto> {
    Dto toDto(Entity e);
    Entity toEntity(Dto dto);
}
