package com.ebikerrent.alquilerbicicletas;


import com.ebikerrent.alquilerbicicletas.entity.Caracteristica;
import com.ebikerrent.alquilerbicicletas.entity.Categoria;
import com.ebikerrent.alquilerbicicletas.entity.Usuario;
import com.ebikerrent.alquilerbicicletas.repository.CaracteristicaRepository;
import com.ebikerrent.alquilerbicicletas.repository.CategoriaRepository;
import com.ebikerrent.alquilerbicicletas.repository.UsuarioRepository;
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
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
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
		@PostConstruct
		private void inicializarCategorias() {
			if (categoriaRepository.count() == 0) {
				Categoria categoria1 = new Categoria();
				categoria1.setTitulo("Ruta");
				categoriaRepository.save(categoria1);

				Categoria categoria2 = new Categoria();
				categoria2.setTitulo("MountainBike");
				categoriaRepository.save(categoria2);

				Categoria categoria3 = new Categoria();
				categoria3.setTitulo("Urbana");
				categoriaRepository.save(categoria3);
			}
		}
	@PostConstruct
	private void inicializarCaracteriscticas() {
		if (caracteristicaRepository.count() == 0) {
			Caracteristica caracteristica1 = new Caracteristica();
			caracteristica1.setNombre("Ambulancia");
			caracteristica1.setIcono("https://i.imgur.com/dBMQaSM.png");
			caracteristicaRepository.save(caracteristica1);

			Caracteristica caracteristica2 = new Caracteristica();
			caracteristica2.setNombre("Bateria extra");
			caracteristica2.setIcono("https://i.imgur.com/SU5Qi9O.png");
			caracteristicaRepository.save(caracteristica2);

			Caracteristica caracteristica3 = new Caracteristica();
			caracteristica3.setNombre("GoPro");
			caracteristica3.setIcono("https://i.imgur.com/XTLd8JW.png");
			caracteristicaRepository.save(caracteristica3);

			Caracteristica caracteristica4 = new Caracteristica();
			caracteristica4.setNombre("Cafe/Mate");
			caracteristica4.setIcono("https://i.imgur.com/TWorg4O.png");
			caracteristicaRepository.save(caracteristica4);

			Caracteristica caracteristica6 = new Caracteristica();
			caracteristica6.setNombre("PlayList");
			caracteristica6.setIcono("https://i.imgur.com/MyulwjF.png");
			caracteristicaRepository.save(caracteristica6);

		}
	}

}
