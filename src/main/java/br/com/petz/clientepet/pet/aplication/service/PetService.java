package br.com.petz.clientepet.pet.aplication.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.petz.clientepet.pet.aplication.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.aplication.api.PetClienteDetalheResponse;
import br.com.petz.clientepet.pet.aplication.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.aplication.api.PetRequest;
import br.com.petz.clientepet.pet.aplication.api.PetResponse;

public interface PetService {

	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);
	List<PetClienteListResponse> buscaPetsDoClienteComID(UUID idCliente);
	PetClienteDetalheResponse buscaPetDoClienteComID(UUID idCliente, UUID idPet);
	void deletaPetDoClienteComID(UUID idCliente, UUID idPet);
	void alteraPetDoClienteComID(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest);
}
