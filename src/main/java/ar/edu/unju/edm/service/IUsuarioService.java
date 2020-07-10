package ar.edu.unju.edm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;


@Service
public interface IUsuarioService {

		public void guardar( Usuario unUsuario );
		public Iterable<Usuario> listarUsuario();
		public void eliminar(Long id);
		public Usuario modificar(Usuario unUsuario) throws Exception ;
		public Optional<Usuario> encontrarUsuario(Long id) ;
	
}
