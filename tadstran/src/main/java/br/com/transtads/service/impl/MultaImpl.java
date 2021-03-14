package br.com.transtads.service.impl;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import br.com.transtads.response.MultaResponse;


public class MultaImpl {

	private static String path = "/multa";

	public MultaImpl() {
	}

	public List<MultaResponse> getListaMulta() {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<MultaResponse> retorno = response.readEntity(new GenericType<List<MultaResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public List<MultaResponse> getMultasByRenavan(String search) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/'+"renavam"+'/' + search);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			List<MultaResponse> retorno = response.readEntity(new GenericType<List<MultaResponse>>() {
			});
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}
	
	public MultaResponse getMulta(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + '/' + id);
		Response response = responseConfig.getClient().get();
		if (response.getStatus() == 200) {
			MultaResponse retorno = response.readEntity(MultaResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	public Boolean inserirMulta(MultaResponse Multa) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/inserir");
		if (!Multa.getDescricao().isEmpty() && !Multa.getDocumento().isEmpty()) {
			Response response = responseConfig.getClient().post(Entity.json(Multa));
			if (response.getStatus() == 200) {
				return true;
			} else {
				String retorno = response.readEntity(String.class);
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean alterarMulta(MultaResponse Multa) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/alterar");
		if (!Multa.getDescricao().isEmpty() && !Multa.getDocumento().isEmpty()) {
			Response response = responseConfig.getClient().put(Entity.json(Multa));
			if (response.getStatus() == 200) {
				return true;
			} else {
				String retorno = response.readEntity(String.class);
				return false;
			}
		} else {
			return false;
		}
	}

	public MultaResponse excluirMulta(int id) {
		ResponseConfiguration responseConfig = new ResponseConfiguration(path + "/excluir/" + id);
		Response response = responseConfig.getClient().delete();
		if (response.getStatus() == 200) {
			MultaResponse retorno = response.readEntity(MultaResponse.class);
			return retorno;
		} else {
			String retorno = response.readEntity(String.class);
			return null;
		}
	}

	
}
