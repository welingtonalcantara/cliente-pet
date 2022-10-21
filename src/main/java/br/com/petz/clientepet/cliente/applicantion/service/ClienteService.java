package br.com.petz.clientepet.cliente.applicantion.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.cliente.applicantion.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteRequest;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClientesAtravesId(UUID idCliente);
}
