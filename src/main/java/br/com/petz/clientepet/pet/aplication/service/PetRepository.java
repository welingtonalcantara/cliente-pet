package br.com.petz.clientepet.pet.aplication.service;

import br.com.petz.clientepet.pet.domain.Pet;

//abstração da interface que salva nosso contrato
public interface PetRepository {
	Pet salvaPet(Pet pet);

}
