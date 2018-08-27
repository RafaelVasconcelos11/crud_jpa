package teste;

import dao.PreferenciasDAO;
import model.Cliente;
import model.Preferencias;

public class PreferenciasTeste {

	public static void main(String[] args) {
		
		//Preferencias preferencias = new Preferencias();
		PreferenciasDAO dao = new PreferenciasDAO();
		/*
		preferencias.setId_cliente((long) 5);
		preferencias.setPreferencia("Preferencia teste3");
		
		preferencias = dao.salvar(preferencias);
		*/
		
		/*
		for(Preferencias preferencias : dao.listarPreferenciasCliente((long) 5)){
			
			System.out.println("Prefencias do cliente: " + preferencias.getPreferencia());
			
		}*/
		
		for(Preferencias preferencias : dao.listarPreferenciasClientePorMatricula("52416")) {
			
			System.out.println(preferencias.getPreferencia());
			
		}
		
		
	}
	
}
