package br.edu.ifmsnv.matricula.model.repositories;

import java.util.UUID;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifmsnv.matricula.model.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, UUID>{

	Boolean existByEmail(String email);
	Boolean existByCpf(String cpf);
	
	/*Desvantagem não sabe se a consulta retornada é cpf ou email*/
	Boolean existByCpfOrEmail(String cpf, String email);
	
}
