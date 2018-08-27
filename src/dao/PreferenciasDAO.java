package dao;

import java.util.List;

import javax.persistence.EntityManager;

import connection.Conexao;
import model.Cliente;
import model.Preferencias;

public class PreferenciasDAO {
	
	public Preferencias salvar(Preferencias preferencias) {
		
		EntityManager em = new Conexao().getEntityManager();
		try {
			
			em.getTransaction().begin();
			em.persist(preferencias);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			
			System.out.println("Erro: " + e);
			
		}finally {
			em.close();
		}
		return preferencias;
		
	}
	
	public List<Preferencias> listar() {
		
		EntityManager em = new Conexao().getEntityManager();
		List<Preferencias> preferencias = null;
		
		try {
			
			preferencias = em.createQuery("from Preferencias p").getResultList();
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return preferencias;
		
	}

	public List<Preferencias> listarPreferenciasCliente(Long id) {
		
		EntityManager em = new Conexao().getEntityManager();
		List<Preferencias> preferencias = null;
		
		try {
			
			preferencias = em.createQuery("from Preferencias p where id_cliente = " + id).getResultList();
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return preferencias;
		
	}
	
	public List<Preferencias> listarPreferenciasClientePorMatricula(String matricula) {
		
		EntityManager em = new Conexao().getEntityManager();
		List<Preferencias> preferencias = null;
		Cliente cliente = null;
		
		try {
			
			cliente = (Cliente) em.createQuery("from Cliente c where matricula = " + matricula).getSingleResult();
			preferencias = em.createQuery("from Preferencias p where id_cliente = " + cliente.getId()).getResultList();
			
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
		return preferencias;
		
	}
}
