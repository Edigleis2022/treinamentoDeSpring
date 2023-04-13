package br.edu.ifmsnv.matricula.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifmsnv.matricula.controller.dto.EstudanteRequest;
import br.edu.ifmsnv.matricula.controller.dto.EstudanteResponse;
import br.edu.ifmsnv.matricula.controller.mapper.EstudanteMapper;
import br.edu.ifmsnv.matricula.model.dto.EstudanteDto;
import br.edu.ifmsnv.matricula.model.services.EstudanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/estudante")
@Tag(name = "Aluno", description = "Gerenciamento de estudantes")
public class EstudanteController {
	private final EstudanteService estudanteService;
	
	public EstudanteController(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}

	@GetMapping
	public ResponseEntity<String> olamundo() {
		return ResponseEntity.ok("Olá Mundo");
	}

	//fazendo a criação
	@Operation(summary = "Novo recurso", description = "Serviço para cadastrar um recurso")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operação de sucesso", 
				content = @Content(mediaType = "application/json", 
				
				schema = @Schema(implementation = EstudanteResponse.class))),
			@ApiResponse(responseCode = "500", description = "Falha no serviço", content = @Content) })
	@PostMapping
	public ResponseEntity<EstudanteResponse> create(@RequestBody @Valid EstudanteRequest estudanteRequest) {
		
		EstudanteDto estudante = EstudanteMapper.requestToDto(estudanteRequest);
		EstudanteDto estudanteDto2 = estudanteService.create(estudante);
		
		EstudanteResponse estudanteResponse =EstudanteMapper.dtoToResponse(estudanteDto2);
		return ResponseEntity.ok(estudanteResponse);
	}
	
	@Operation(summary = "Atualizar recurso", description = "Seriço para atualizar um recurso")
	
	@ApiResponse(value = {
			@ApiResponse(responseCode = "200", description = "Operação de sucesso", 
			content = @Content(mediaType = "application/json", schema=@Schema(implementation = EstudateResponse.class))),
			@ApiResponse(responseCode = "400", description = "Solicitaão incorreta", 
			content = @Content(mediaType = "application/json", schema=@Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado",
			content = @Content(mediaType = "application/json", schema=@Schema(implementation = ErrorResponse.class)));
					@ApiResponse(responseCode = "500", description = "Falha no serviço", 
					content = @Content)
	});
	
	
@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponse> update(PathVariable UUID id, @RequesBody @Valid EstudanteRequest estudanteRequest){
		EstudanteDto estudanteDto = EstudanteMapperToDto(estudanteRequest);
		EstudanteDto2 estudanteDto = estudante.update(id, EstudanteDto),
		EstudanteResponse estudanteReponse = EstudanteMapperToresponse(estudanteDto2);
		
		return ResponseEntity.ok(estudanteResponse)
		};
		
		
	
}
