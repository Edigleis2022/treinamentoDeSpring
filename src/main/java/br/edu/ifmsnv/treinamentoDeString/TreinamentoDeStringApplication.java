package br.edu.ifmsnv.treinamentoDeString;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TreinamentoDeStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoDeStringApplication.class, args);
	}
	
	@GetMapping("/olamundo")
	public ResponseEntity<String> olamundo(){
		return ResponseEntity.ok("Ola Mundo, eu voltei!!!");
	}
	
	@GetMapping("/datahora")
	public ResponseEntity<Date> datahora(){
		var datahora = new Date();
		return ResponseEntity.ok(datahora);	
	}
	
}
