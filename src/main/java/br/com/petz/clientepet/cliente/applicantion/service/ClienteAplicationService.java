package br.com.petz.clientepet.cliente.applicantion.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.applicantion.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteRequest;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteResponse;
import br.com.petz.clientepet.cliente.applicantion.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteAplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;
	
	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteAplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteAplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteAplicationService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteAplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteAplicationService - buscaTodosClientesAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteAplicationService - buscaTodosClientesAtravesId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteAplicationService - deletaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		//ClienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteAplicationService - deletaClienteAtravesId");
		
	}

}
