package br.edu.ifmsnv.matricula.model.services;

import org.springframework.stereotype.Service;

import br.edu.ifmsnv.matricula.model.dto.EstudanteDto;
import br.edu.ifmsnv.matricula.model.entities.Estudante;
import br.edu.ifmsnv.matricula.model.mapper.EstudanteMapper;
import br.edu.ifmsnv.matricula.model.repositories.EstudanteRepository;
import br.edu.ifmsnv.treinamentoDeString.config.utils.MD5;

@Service
public class EstudanteService {
	private final EstudanteRepository repository;

	public EstudanteService(EstudanteRepository repository) {
		super();
		this.repository = repository;
	}

	public EstudanteDto create(EstudanteDto estudanteDto2) {
		estudanteDto2.setNome(estudanteDto2.getNome().toUpperCase());
		estudanteDto2.setEmail(estudanteDto2.getEmail().toLowerCase());
		estudanteDto2.setSenha( MD5.encode(estudanteDto2.getSenha()));
		
		Estudante estudante = EstudanteMapper.dtoToEntity(estudanteDto2);
		repository.save(estudante);
		
		return EstudanteMapper.entityToDto(estudante);
	}
	
	
	
}
