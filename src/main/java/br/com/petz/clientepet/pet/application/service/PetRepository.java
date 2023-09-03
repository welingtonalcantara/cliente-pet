package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;
//abstração da interface que salva nosso contrato
//criamos essa interface para ela criar uma camada de flexibilização entre o 
//repository ( ainda na camada de aplicação) com a nossa camada de infraestrutura
public interface PetRepository {
	Pet salvaPet(Pet pet);
	List<Pet> buscaPetsDoClienteComID(UUID idCliente);
}
