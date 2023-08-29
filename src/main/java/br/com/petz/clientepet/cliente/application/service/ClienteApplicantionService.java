package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicantionService implements ClienteService {
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicantionService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicantionService - criaCliente");
		return ClienteResponse.builder()
				.idcliente(cliente.getIdcliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicantionService - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicantionService - buscaTodosClientes");
		return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicantionService - buscaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteApplicantionService - buscaClienteAtravesId");				
		return new ClienteDetalhadoResponse(cliente);
	}

}
