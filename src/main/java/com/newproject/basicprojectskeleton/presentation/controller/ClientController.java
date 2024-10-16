package com.newproject.basicprojectskeleton.presentation.controller;

import com.newproject.basicprojectskeleton.persistence.entity.Client;
import com.newproject.basicprojectskeleton.presentation.dto.input.ClientSaveRequest;
import com.newproject.basicprojectskeleton.presentation.dto.output.ClientSaveResponse;
import com.newproject.basicprojectskeleton.service.implementation.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{name}")
    public Client getClient(@PathVariable String name) {
        return clientService.findByName(name);
    }

    @PostMapping("/save")
    public ClientSaveResponse saveClient(@RequestBody ClientSaveRequest client) {
        return clientService.saveClient(client);
    }

}
