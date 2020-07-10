package ar.edu.unju.edm.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioRepository;


@Service
public class IUsuarioServicioImp implements IUsuarioService {
	@Autowired
	IUsuarioRepository iUsuario;
	
	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		iUsuario.save(usuario);
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Optional<Usuario> encontrarUsuario (String nombreUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario);
		return usuarioEncontrado;
	}

	@Override
	public Iterable<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return iUsuario.findAll();
	}
	
	

}
