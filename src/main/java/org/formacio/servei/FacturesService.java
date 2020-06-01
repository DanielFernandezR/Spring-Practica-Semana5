package org.formacio.servei;

import java.util.Optional;

import org.formacio.domain.Factura;
import org.formacio.domain.LiniaFactura;
import org.formacio.repositori.FacturesRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FacturesService {

	@Autowired
	private FacturesRepositori repositorioFacturas;
	/*
	 * Aquest metode ha de carregar la factura amb id idFactura i afegir una nova linia amb les dades
	 * passades (producte i totalProducte)
	 * 
	 * S'ha de retornar la factura modificada
	 * 
	 * Per implementar aquest metode necessitareu una referencia (dependencia) a FacturesRepositori
	 */
	public Factura afegirProducte (long idFactura, String producte, int totalProducte) {
		Optional<Factura> factura = repositorioFacturas.findById(idFactura);
		LiniaFactura nuevaLinea = new LiniaFactura();
		nuevaLinea.setProducte(producte);
		nuevaLinea.setTotal(totalProducte);
		factura.get().getLinies().add(nuevaLinea);
		repositorioFacturas.save(factura.get());
		return factura.get();
	}
}
