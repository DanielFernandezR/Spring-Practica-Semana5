package org.formacio.repositori;

import org.formacio.domain.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface FacturesRepositori extends Repository<Factura, Long> {

	@Query("select sum(linea.total) from Factura facturas join facturas.linies linea where facturas.client.nom = ?1")
	public Number totalClient(String client);
	
}
