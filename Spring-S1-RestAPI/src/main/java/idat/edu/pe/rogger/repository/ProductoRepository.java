package idat.edu.pe.rogger.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import idat.edu.pe.rogger.model.Producto;

@Repository
public interface ProductoRepository {
	void guardar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id);
	List<Producto> listar();
	Producto obtener(Integer id);
}
