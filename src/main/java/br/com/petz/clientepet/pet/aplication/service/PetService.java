package br.com.petz.clientepet.pet.aplication.service;

import java.util.UUID;

import javax.validation.Valid;

import br.com.petz.clientepet.pet.aplication.api.PetRequest;
import br.com.petz.clientepet.pet.aplication.api.PetResponse;

public interface PetService {

	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);

}
