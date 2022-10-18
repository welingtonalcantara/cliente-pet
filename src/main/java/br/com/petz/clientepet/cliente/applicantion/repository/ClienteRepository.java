package br.com.petz.clientepet.cliente.applicantion.repository;

import java.util.List;

import br.com.petz.clientepet.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
}
