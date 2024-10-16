package com.newproject.basicprojectskeleton.util.mapper;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import com.newproject.basicprojectskeleton.presentation.dto.input.ClientSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.ClientSaveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    Client toClient(ClientSaveRequest clientSaveRequest);

    ClientSaveResponse toClientSaveResponse(Client client);
}
