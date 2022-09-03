package com.usapresidents.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PresidentsControllerExceptionMessages {

    ENTITY_FOR_PROVIDED_ID_NOT_EXISTS("No such entity(id) exists!"),
    ENTITY_FOR_PROVIDED_NAME_NOT_EXISTS("No such entity(name) exists!");

    private final String message;

}

