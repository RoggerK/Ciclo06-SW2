package idat.edu.pe.rogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.rogger.model.Producto;
import idat.edu.pe.rogger.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repository;

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		repository.save(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
