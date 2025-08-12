package repositories;

import java.sql.DriverManager;

import entities.Funcionario;

public class FuncionarioRepository {

	public void inserir(Funcionario funcionario) {
		
		var host = "jdbc:mysql://localhost:3306/bd_projeto_aula03?useSSL=false&serverTimezone=UTC";
		var user = "root";
		var pass = "coti";
		
		try {
			
			var connection = DriverManager.getConnection(host, user, pass);
			
			var sqlEndereco = """
								insert into endereco(id, logradouro, numero, complemento,
								bairro, cidade, estado, cep)
								values(?,?,?,?,?,?,?,?)
						""";
			
			var statement = connection.prepareStatement(sqlEndereco);
			
			statement.setString(1, funcionario.getEndereco().getId().toString());
			statement.setString(2, funcionario.getEndereco().getLogradouro());
			statement.setString(3, funcionario.getEndereco().getNumero());
			statement.setString(4, funcionario.getEndereco().getComplemento());
			statement.setString(5, funcionario.getEndereco().getBairro());
			statement.setString(6, funcionario.getEndereco().getCidade());
			statement.setString(7, funcionario.getEndereco().getEstado());
			statement.setString(8, funcionario.getEndereco().getCep());
			statement.execute();
			
			var sqlFuncionario = """
								insert into funcionario(id, nome, cpf, dataadmissao, endereco_id)
								values(?,?,?,?,?)
					""";
			
			statement = connection.prepareStatement(sqlFuncionario);
			
			statement.setString(1, funcionario.getId().toString());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getCpf());
			statement.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
			statement.setString(5, funcionario.getEndereco().getId().toString());
			statement.execute();
			
			connection.close();
			
			System.out.println("\nDados Gravados Com Sucesso!");
			
			
			
		}
		catch(Exception e) {
			System.out.println("\nFalha: " + e.getMessage());
		}
				
		
	}

}
