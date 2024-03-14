package com.ebikerrent.alquilerbicicletas;


import com.ebikerrent.alquilerbicicletas.entity.Usuario;
import com.ebikerrent.alquilerbicicletas.repository.UsuarioRepository;
import com.ebikerrent.alquilerbicicletas.service.impl.UsuarioService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@SpringBootApplication
@RestController
public class AlquilerBicicletasApplication {
	@Autowired
	private UsuarioRepository usuarioRepository;
	private static final Logger LOGGER= LoggerFactory.getLogger(AlquilerBicicletasApplication.class);
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SpringApplication.run(AlquilerBicicletasApplication.class, args) ;
		LOGGER.info("---eBikeRent EJECUTANDOSE---");
		LOGGER.info("---eBikeRent EJECUTANDOSE---");
		LOGGER.info("---eBikeRent EJECUTANDOSE---");
		LOGGER.info("---eBikeRent EJECUTANDOSE---");
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@PostConstruct
	public void inicializar() {
		if (usuarioRepository.findByMail("admin@admin.com") == null) {
			Usuario user = new Usuario();
			user.setNombre("Admin");
			user.setApellido("Admin");
			user.setMail("admin@admin.com");
			user.setPassword("password");
			user.setEsAdmin(true);
			usuarioRepository.save(user);
		}
	}

}
