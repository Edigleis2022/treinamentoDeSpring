package br.edu.ifmsnv.matricula.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EstudanteRequest {
	
	
		@Size(max = 80, message = "Informe o nome completo")
		@NotBlank
		private String nome;
		
		@NotBlank
		@Size(min = 11, message = "Informe o seu CPF")
		private String cpf;
		
		@Size(max = 150, message = "Informe o seu email")
		@NotBlank
		private String Email;
		
		@Size(max = 50, message = "Informa uma senha até 50 letras")
		@NotBlank
		private String Senha;
		
		
		
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getSenha() {
			return Senha;
		}
		public void setSenha(String senha) {
			Senha = senha;
		}
		
}
