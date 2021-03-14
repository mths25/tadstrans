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

import br.com.transtads.dao.VeiculoDao;
import br.com.transtads.persistence.Veiculo;


@Path("veiculo")
public class VeiculoResource {
	VeiculoDao VeiculoDao;
	@Context
	private UriInfo context;

	public VeiculoResource() {
		VeiculoDao = new VeiculoDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Veiculo> Veiculos = VeiculoDao.getList();
		if(Veiculos.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(Veiculos).build();
		}
	}

	@GET
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getVeiculo(@PathParam("id") int id) {
		Veiculo Veiculo = VeiculoDao.getById(id);
		System.out.print(Veiculo);
		if(Veiculo != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Veiculo)
					.build();

		}
		else {
			return Response.ok(Response.Status.NO_CONTENT).entity(JsonNenhumResultadoEncontrado()).build();
		}

	}

	@GET
	@Path("/placa/{search}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getVeiculoByPlaca(@PathParam("search") String search) {
		Veiculo Veiculo = VeiculoDao.getBy("placa",search);
		System.out.print(Veiculo);
		if(Veiculo != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Veiculo)
					.build();

		}
		else {
			return Response.ok(Response.Status.NO_CONTENT).entity(JsonNenhumResultadoEncontrado()).build();
		}

	}
	

	@GET
	@Path("/renavam/{search}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getVeiculoByRenavam(@PathParam("search") String search) {
		Veiculo Veiculo = VeiculoDao.getBy("renavam",search);
		System.out.print(Veiculo);
		if(Veiculo != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Veiculo)
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
	public Response InserirVeiculo(Veiculo Veiculo) {
		VeiculoDao.inserir(Veiculo);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/alterar")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarVeiculo(Veiculo Veiculo) {
		VeiculoDao.alterar(Veiculo);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/excluir/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirVeiculo(@PathParam("id") int id) {
		Veiculo Veiculo = VeiculoDao.getById(id);
		VeiculoDao.excluir(Veiculo);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}
}
