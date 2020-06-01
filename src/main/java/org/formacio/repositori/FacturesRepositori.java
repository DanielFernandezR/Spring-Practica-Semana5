package org.formacio.repositori;

import java.util.List;

import org.formacio.domain.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FacturesRepositori extends CrudRepository<Factura, Long> {

	@Query("select sum(linea.total) from Factura facturas join facturas.linies linea where facturas.client.nom = ?1")
	public Number totalClient(String client);
	
	public List<Factura> findByClientNom(String client);
	
}
