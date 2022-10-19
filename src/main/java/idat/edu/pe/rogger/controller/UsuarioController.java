package idat.edu.pe.rogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.rogger.dto.UsuarioDTORequest;
import idat.edu.pe.rogger.dto.UsuarioDTOResponse;
import idat.edu.pe.rogger.security.TokenUtil;

@RestController
public class UsuarioController {
	@Autowired
	private TokenUtil util;

	@Autowired
	private UserDetailsService service;

	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest request) {
		UserDetails user = service.loadUserByUsername(request.getUsuario());
		if (user.getPassword().equals(request.getContrasenia())) {
			return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
		} else {
			throw new UsernameNotFoundException("Usuario y/o Contraseña incorrecto ");
		}
		
	}

}
