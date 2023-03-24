package br.edu.ifmsnv.matricula.controller.dto;

public class EstudanteRequest {
		private String nome;
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
		private String cpf;
		private String Email;
		private String Senha;
}
