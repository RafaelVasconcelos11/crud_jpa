package teste;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteTeste {
	
	public static void main(String[] args) {
		
		ClienteTeste teste = new ClienteTeste();
		teste.listar();
		
	}
	
	public void cadastrar() {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		cliente.setNome("Rafael");
		cliente.setSobrenome("Antônio");
		cliente.setMatricula("12345");
		cliente.setAtivo(true);

		cliente = dao.salvar(cliente);
		
		System.out.println("\nCliente cadastrado: ");
		System.out.println("Código: " + cliente.getId());
		System.out.println("Nome: " + cliente.getNome() + " " + cliente.getSobrenome());
	}
	
	public void remover() {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		cliente = dao.remover((long) 4);
		
		System.out.println("Cliente removido: " + cliente.getNome());
		
	}
	
	public void ativar() {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		cliente = dao.ativar((long) 4);
		
		System.out.println("Cliente status: " + cliente.isAtivo());
		
	}
	
	public void desativar() {
		
		Cliente cliente = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		
		cliente = dao.desativar((long) 4);
		
		System.out.println("Cliente status: " + cliente.isAtivo());
		
	}
	
	public void listar() {
		
		ClienteDAO dao = new ClienteDAO();
		
		for(Cliente cliente : dao.listar()) {
			
			System.out.println("\nCódigo: " + cliente.getId());
			System.out.println("Nome completo: " + cliente.getNome() + " " + cliente.getSobrenome());
			System.out.println("Matrícula: " + cliente.getMatricula());
			
			if(cliente.isAtivo() == true) {
				
				System.out.println("Situação: Ativo");
				
			}
			
			
		}
		
	}

}
