package dao;

import java.util.List;

import javax.persistence.EntityManager;

import connection.Conexao;
import model.Cliente;

public class ClienteDAO implements CrudInterface{
	

	@Override
	public Cliente salvar(Cliente cliente) {
		EntityManager em = new Conexao().getEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			
			System.out.println("Erro: " + e);
			
		}finally {
			em.close();
		}
		return cliente;
	}

	@Override
	public Cliente remover(Long id) {
		
		EntityManager em = new Conexao().getEntityManager();
		Cliente cliente = null;
		
		try {
			
			cliente = em.find(Cliente.class, id);
			if(cliente != null) {
				
				em.getTransaction().begin();
				em.remove(cliente);
				em.getTransaction().commit();
			}else{
				
				System.out.println("O cliente referente ao código '"+ id + "' não está cadastrado!");
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro: " + e);
		}finally {
			em.close();
		}
		
		return cliente;
	}

	@Override
	public Cliente ativar(Long id) {
		
		EntityManager em = new Conexao().getEntityManager();
		Cliente cliente = null;
		
		try {
			
			cliente = em.find(Cliente.class, id);
			if(cliente != null) {
				cliente.setAtivo(true);
				em.getTransaction().begin();
				em.merge(cliente);
				em.getTransaction().commit();
			}else{
				
				System.out.println("O cliente referente ao código '"+ id + "' não está cadastrado!");
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro: " + e);
		}finally {
			em.close();
		}
		
		return cliente;
	}

	@Override
	public Cliente desativar(Long id) {
		
		EntityManager em = new Conexao().getEntityManager();
		Cliente cliente = null;
		
		try {
			
			cliente = em.find(Cliente.class, id);
			if(cliente != null) {
				cliente.setAtivo(false);
				em.getTransaction().begin();
				em.merge(cliente);
				em.getTransaction().commit();
			}else{
				
				System.out.println("O cliente referente ao código '"+ id + "' não está cadastrado!");
				
			}
			
		}catch (Exception e) {
			System.out.println("Erro: " + e);
		}finally {
			em.close();
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> listar() {
		
		EntityManager em = new Conexao().getEntityManager();
		List<Cliente> clientes = null;
		
		try {
			
			clientes = em.createQuery("from Cliente c").getResultList();
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return clientes;
		
	}

	


	
}
