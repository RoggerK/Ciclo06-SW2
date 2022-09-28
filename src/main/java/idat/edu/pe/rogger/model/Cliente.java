package idat.edu.pe.rogger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String cliente;
	private String celular;
	
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //Muchos a muchos "mappedBy" = nombre de la variable del List<Cliente> clientes
	private List<Producto> productos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Items> items = new ArrayList<>();
}
