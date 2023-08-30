package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
//@AllArgsConstructor //cria com tudo
@RequiredArgsConstructor //cria só com o que é final
public class ClienteController implements ClienteAPI {
	//final que dizer que depois que eu criei eu não posso mais modificar
	//uso pq preciso de uma instancia de ClienteService, ou seja, quando o spring da new na minha classe
	// ClienteController ele manda uma instancia de clienteService
	//eu notifico o spring pra fazer isso pra mim atravéz do lombok (@AllArgsConstructor e @RequiredArgsConstructor)
	// ele vai criar um construtor só com as coisas que são final
	private final ClienteService clienteService;	

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		//começa a implementar controller - aula 03 01:04:00
		//chamo clienteService e digo pra ele criar cliente e passo o clienteRequest e quero como resposta 
		//o ClienteResponse
		//clienteCriado é igual a clienteService.criaCliente(clienteRequest);
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getTodosClientes() {
		log.info("[inicia] ClienteController - getTodosClientes");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finaliza] ClienteController - getTodosClientes");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getclientesAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteController - getclientesAtravesId");
		log.info("[idCliente] {}", idCliente);
		//esse cara vem de clienteservice
		ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteController - getclientesAtravesId");		
		return clienteDetalhado;
	}

	@Override
	public void deletaClientesAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClientesAtravesId");
		log.info("[idCliente] {}", idCliente);
		clienteService.deletaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteController - deletaClientesAtravesId");
	}

	@Override
	public void patchAlteraCliente(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteController - patchAlteraCliente");
		log.info("[idCliente] {}", idCliente);
		clienteService.patchAlteraCliente(idCliente, clienteAlteracaoRequest);
		log.info("[finaliza] ClienteController - patchAlteraCliente");
	}
}
