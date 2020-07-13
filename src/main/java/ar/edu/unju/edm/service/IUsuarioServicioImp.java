package ar.edu.unju.edm.service;


import java.util.List;

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
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iUsuario.deleteById(id);
	}

	@Override
	public Usuario modificar(Usuario unUsuario) throws Exception {
		Usuario usuarioB = encontrarUsuario(unUsuario.getId());
		mapearUsuario(unUsuario, usuarioB);
		return iUsuario.save(usuarioB);
	}

	public void mapearUsuario(Usuario desde, Usuario hacia) {
		hacia.setNombreReal(desde.getNombreReal());
		hacia.setApellidoReal(desde.getApellidoReal());
		hacia.setNombreUsuario(desde.getNombreUsuario());
		// hacia.setPassword(desde.getPassword());
		hacia.setTipoUsuario(desde.getTipoUsuario());
	}

	@Override
	public Usuario encontrarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iUsuario.findById(id).orElseThrow(() -> new Exception("Error"));

	}

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return iUsuario.listarUsuarios();
	}

}