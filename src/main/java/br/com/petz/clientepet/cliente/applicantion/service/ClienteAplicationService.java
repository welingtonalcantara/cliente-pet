package br.com.petz.clientepet.cliente.applicantion.service;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.applicantion.api.ClienteRequest;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteResponse;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClienteAplicationService implements ClienteService {

	@Override
	public ClienteResponse criacliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteAplicationService - criacliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteAplicationService - criacliente");
		return null;
	}

}
