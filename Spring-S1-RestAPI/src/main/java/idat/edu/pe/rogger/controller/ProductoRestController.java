package idat.edu.pe.rogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	@GetMapping
	public String saludo() {
		return "Hola a todos";
	}
}
