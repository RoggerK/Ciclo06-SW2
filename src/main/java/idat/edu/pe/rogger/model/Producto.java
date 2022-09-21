package idat.edu.pe.rogger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	private Integer idproducto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
}
