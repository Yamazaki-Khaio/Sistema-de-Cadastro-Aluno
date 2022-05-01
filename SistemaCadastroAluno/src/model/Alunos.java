package model;


public class Alunos {
	private String matricula;
	private String nome;
	private String nascimento;
	private String cpf;
	private String curso;
	private String email;
	
	
	public Alunos(String matricula, String nome, String nascimento,
			String cpf, String curso, String email) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.curso = curso;
		this.email = email;
				
	}
	

	public Alunos() {
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	

	
	
	
	
	
	
	
	
	

}
