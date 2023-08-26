package br.com.petz.clientepet.cliente.application.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	//estou recebendo no @RequestBody
	//contrato definido
	ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienterequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	//estou recebendo no @RequestBody
	//contrato definido
	List<ClienteListResponse> getTodosClientes();
}
