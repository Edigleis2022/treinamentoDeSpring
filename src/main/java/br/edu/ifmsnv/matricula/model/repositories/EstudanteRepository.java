package br.edu.ifmsnv.matricula.model.repositories;

import java.util.UUID;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifmsnv.matricula.model.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, UUID>{

}