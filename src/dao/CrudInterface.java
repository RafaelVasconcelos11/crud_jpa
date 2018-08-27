package dao;

import java.util.List;

import model.Cliente;
import model.Preferencias;

public interface CrudInterface {
	
	Cliente salvar(Cliente cliente);
	Cliente remover(Long id);
	Cliente ativar(Long id);
	Cliente desativar(Long id);
	List<Cliente> listar();

}
