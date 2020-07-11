package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Barrio;


@Repository
public interface IBarrioRepository extends JpaRepository<Barrio,Long>{

	@Query("from Barrio e order by e.id")
	public List<Barrio> obtenerBarrios();
}
