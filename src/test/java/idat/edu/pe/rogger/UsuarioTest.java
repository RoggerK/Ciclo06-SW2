package idat.edu.pe.rogger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UsuarioTest {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Test
	void contextLoads() {
		String contrasenia = passwordEncoder.encode("123");
		System.out.println(contrasenia);
	}

}
