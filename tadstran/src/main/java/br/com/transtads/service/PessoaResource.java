package br.com.transtads.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.transtads.dao.PessoaDao;
import br.com.transtads.persistence.Pessoa;


@Path("pessoa")
public class PessoaResource {
	PessoaDao PessoaDao;
	@Context
	private UriInfo context;

	public PessoaResource() {
		PessoaDao = new PessoaDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Pessoa> Pessoas = PessoaDao.getList();
		if(Pessoas.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(Pessoas).build();
		}
	}

	@GET
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPessoa(@PathParam("id") int id) {
		Pessoa Pessoa = PessoaDao.getById(id);
		System.out.print(Pessoa);
		if(Pessoa != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Pessoa)
					.build();

		}
		else {
			return Response.ok(Response.Status.NO_CONTENT).entity(JsonNenhumResultadoEncontrado()).build();
		}

	}

	@POST
	@Path("/inserir")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response InserirPessoa(Pessoa Pessoa) {
		PessoaDao.inserir(Pessoa);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/alterar")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarPessoa(Pessoa Pessoa) {
		PessoaDao.alterar(Pessoa);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/excluir/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirPessoa(@PathParam("id") int id) {
		Pessoa Pessoa = PessoaDao.getById(id);
		PessoaDao.excluir(Pessoa);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}
}
