package br.edu.ifmsnv.matricula.model.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.ifmsnv.matricula.model.dto.EstudanteDto;
import br.edu.ifmsnv.matricula.model.entities.Estudante;
import br.edu.ifmsnv.matricula.model.mapper.EstudanteMapper;
import br.edu.ifmsnv.matricula.model.repositories.EstudanteRepository;
import br.edu.ifmsnv.treinamentoDeString.config.utils.MD5;
import jakarta.transaction.Transactional;

@Service
public class EstudanteService {
	private final EstudanteRepository repository;

	public EstudanteService(EstudanteRepository repository) {
		super();
		this.repository = repository;
	}

	public EstudanteDto create(EstudanteDto estudanteDto2) {
		
		if(repository.existByCpf(estudanteDto2.getCpf())) {
			throw new RuntimeException("CPF já existe para outro estudante");
		}
		if(repository.existByEmail(estudanteDto2.getEmail())) {
			throw new RuntimeException("Email já existe para outro estudante");
		}
		
		//if(repository.existByCpfOrEmail(estudanteDto.getCpf(), estudante.getEmail())) {
		//	throw new RuntimeException("Email já existe para outro estudante");
		//}
		
		estudanteDto2.setNome(estudanteDto2.getNome().toUpperCase());
		estudanteDto2.setEmail(estudanteDto2.getEmail().toLowerCase());
		estudanteDto2.setSenha( MD5.encode(estudanteDto2.getSenha()));
		
		Estudante estudante = EstudanteMapper.dtoToEntity(estudanteDto2);
		repository.save(estudante);
		
		return EstudanteMapper.entityToDto(estudante);
	}
	
	public Optional<Estudante> findByid(UUID id){
		Optional<Estudante> estudanteOptional = repository.findById(id);
		return estudanteOptional.map( estudante -> EstudanteMapper.entityToDto(estudante));
	}
	
	@Transactional
	public EstudanteDto update(UUID id, EstudanteDto estudanteInput) {
		Optional<Estudante> estudanteOptional = repository.findById(id);
		Estudante estudante = estudanteOptional.orElseThrow(() -> new EntityNotFoundException(message: "Estudante não encontrado"));
	
	estudante.setNome( estudanteInput.getNome().toUpperCase() );
	estudante.setCpf( estudanteInput.getCpf() );
	estudante.setEmail( estudanteInput.getEmail() );
	repository.save(estudante);
	
	return EstudanteMapper.entityToDto(estudante);
	}
}
