package br.com.petz.clientepet.cliente.applicantion.repository;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClienteAtravesId(UUID idcliente);
	void deletaCliente(Cliente cliente);
}
