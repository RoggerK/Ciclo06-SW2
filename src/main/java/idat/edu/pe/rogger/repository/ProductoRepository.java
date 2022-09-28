package idat.edu.pe.rogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.rogger.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
}
