package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unju.edm.model.ValidarCondicionSanitaria;

@Repository
public interface ICondicionRepository extends JpaRepository <ValidarCondicionSanitaria,Long> {
	@Query("from ValidarCondicionSanitaria e order by e.id")
	public List<ValidarCondicionSanitaria> listarCondiciones();
	
}
