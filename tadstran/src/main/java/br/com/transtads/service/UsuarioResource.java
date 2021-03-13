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

import br.com.transtads.dao.UsuarioDao;
import br.com.transtads.persistence.Usuario;



public class UsuarioResource {
	UsuarioDao UsuarioDao;
	@Context
	private UriInfo context;

	public UsuarioResource() {
		UsuarioDao = new UsuarioDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Usuario> Usuarios = UsuarioDao.getList();
		if(Usuarios.isEmpty()) {
			return Response.noContent().build();
		}
		else {			
			return Response.ok(Response.Status.OK).entity(Usuarios).build();
		}
	}

	@GET
	@Path("/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("id") int id) {
		Usuario Usuario = UsuarioDao.getById(id);
		System.out.print(Usuario);
		if(Usuario != null) {
			return Response
					.ok(Response.Status.OK)
					.entity(Usuario)
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
	public Response InserirUsuario(Usuario Usuario) {
		UsuarioDao.inserir(Usuario);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/alterar")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AlterarUsuario(Usuario Usuario) {
		UsuarioDao.alterar(Usuario);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/excluir/{id}")  
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ExcluirUsuario(@PathParam("id") int id) {
		Usuario Usuario = UsuarioDao.getById(id);
		UsuarioDao.excluir(Usuario);
		return Response.ok().build();
	}

	private String JsonNenhumResultadoEncontrado() {
		return "{\"message\" : " + "\"nenhum resultado encontrado!\"" + " }";
	}

	private String JsonInsercaoRealizadaComSucesso() {
		return "{\"message\" : " + "\"Inserção realizada com sucesso!\"" + " }";
	}
}
