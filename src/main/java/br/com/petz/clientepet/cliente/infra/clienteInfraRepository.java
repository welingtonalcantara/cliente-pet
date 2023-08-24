package br.com.petz.clientepet.cliente.infra;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class clienteInfraRepository implements ClienteRepository {

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] clienteInfraRepository - salva");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finaliza] clienteInfraRepository - salva");
		return cliente;
	}

}
