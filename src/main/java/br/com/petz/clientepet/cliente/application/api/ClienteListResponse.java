package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.Value;

//@value para clienteListResponse da os GETs 
@Value
public class ClienteListResponse {
	private UUID idcliente;
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String celular;
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream() //transformo o cliente em um fluso
				//.map(c -> new ClienteListResponse(c)) // pego os clientes que chegam (c) e jogo no construtor de cliente(ClienteListResponse)				
				.map(ClienteListResponse::new)//usando reference metod. Eu pego o cara que vem (clientes) e jogo no METODO NEW da minha classe ClienteListResponse
				.collect(Collectors.toList());//pego o fluxo e transformo em uma lista de ClienteListResponse
	}

	public ClienteListResponse(Cliente cliente) {
		this.idcliente = cliente.getIdcliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.email = cliente.getCpf();
		this.celular = cliente.getCelular();
	}	
}
