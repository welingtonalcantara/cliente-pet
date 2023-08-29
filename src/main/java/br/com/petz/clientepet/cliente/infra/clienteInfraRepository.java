package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class clienteInfraRepository implements ClienteRepository {
	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] clienteInfraRepository - salva");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] clienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] clienteInfraRepository - salva");
		List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
		log.info("[finaliza] clienteInfraRepository - salva");
		return todosClientes;
	}

	@Override
	public Cliente buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] buscaClienteAtravesId");
		//----clienteSpringDataJPARepository retorna um optional. eu quero que vc pegue o que tá dentro do optional
		// (que deve ser um cliente) e caso não tiver lance uma execeptional
		Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
				.orElseThrow(() -> new RuntimeException("cliente não encontrado!"));
		log.info("[finaliza] buscaClienteAtravesId");
		return cliente;
	}

}
