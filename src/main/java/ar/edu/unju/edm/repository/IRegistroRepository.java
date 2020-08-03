package ar.edu.unju.edm.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.edu.unju.edm.model.RegistroTracking;

@Repository
public interface IRegistroRepository extends CrudRepository<RegistroTracking,Long> {

	@Query("from RegistroTracking e order by e.fechaHora")
	//Consulta2
		public List<RegistroTracking> findAllByOrderByfechaHoraAsc();
	//Consulta1
		public List<RegistroTracking> findByfechaHoraBetween(@JsonFormat(pattern = "yyyy-MM-dd HH:mm")LocalDateTime date1, @JsonFormat(pattern = "yyyy-MM-dd HH:mm")LocalDateTime date2);
}
