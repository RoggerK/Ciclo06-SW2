package idat.edu.pe.rogger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto; // si idProducto el P en base de datos sera id_producto
	private String nombreProducto; // si nombreProducto el P en base de datos sera nombre_producto
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@OneToOne
	private Proveedor proveedor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //sin "cascade" devolvera todo, "PERSIST" lo que desees sin datos repeditos, "MERGE" te junta la operacion
	@JoinTable(
			name = "producto_cliente", //nombre de la tabla intermedia
			joinColumns = @JoinColumn(
					name = "id_producto", //id de la tabla en bd
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references producto(id_producto)")
			), 
			inverseJoinColumns = @JoinColumn(
					name = "id_cliente", //id de la tabla en bd
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references cliente(id_cliente)")
			)
	)
	private List<Cliente> clientes = new ArrayList<>();
}
