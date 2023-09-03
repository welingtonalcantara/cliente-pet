package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {	
	private final PetService petService;
	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest); //passando
		log.info("[finaliza] PetController - postPet");
		//return new PetResponse(pet.getIdPet);
		return pet;
	}
	@Override
	public List<PetClienteListResponse> getPetsDoClienteComId(UUID idCliente) {
		log.info("[inicia] PetController - getPetsDoClienteComId");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComID(idCliente);
		log.info("[finish] PetController - getPetsDoClienteComId");
		return petsDoCliente;
	}
	@Override
	public PetClienteDetalhadoResponse getPetDoclienteComId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - getPetDoclienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalhadoResponse pet = petService.buscaPetDoClienteComID(idCliente, idPet);
		log.info("[finish] PetController - getPetDoclienteComId");
		return pet;
	}	

	@Override
	public void deletaClientesAtravesId(UUID idCliente, UUID idPet) {
		log.info("[start] PetController - deletaPetDoClientesAtravesId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);		
		petService.deletaPetDoClienteComID(idCliente, idPet);
		log.info("[finish] PetController - deletaPetDoClientesAtravesId");		
	}
	@Override
	public void patchPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[start] PetController - patchPet");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);	
		
		log.info("[finish] PetController - patchPet");	
	}
	


}
