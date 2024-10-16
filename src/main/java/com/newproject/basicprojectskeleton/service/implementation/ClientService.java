package com.newproject.basicprojectskeleton.service.implementation;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import com.newproject.basicprojectskeleton.persistence.repository.ClientRepository;
import com.newproject.basicprojectskeleton.presentation.dto.input.ClientSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.ClientSaveResponse;
import com.newproject.basicprojectskeleton.util.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client findByName(String name) {
        return clientRepository.findByName(name).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public ClientSaveResponse saveClient(ClientSaveRequest clientSaveRequest) {
        return clientMapper.toClientSaveResponse(clientRepository.save(clientMapper.toClient(clientSaveRequest)));
    }
}
