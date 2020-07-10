package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;


@Service
public interface IUsuarioService {

		public void guardar( Usuario unUsuario );
		public Iterable<Usuario> listarUsuario();
		public void eliminar();
		public Usuario modificar();
		public Optional<Usuario> encontrarUsuario(String nombreUsuario);
	
}
