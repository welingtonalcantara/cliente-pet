package br.com.petz.clientepet.cliente.applicantion.service;

import java.util.List;

import br.com.petz.clientepet.cliente.applicantion.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteRequest;
import br.com.petz.clientepet.cliente.applicantion.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
}
