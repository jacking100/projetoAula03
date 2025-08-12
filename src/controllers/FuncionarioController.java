package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioController {
	
	public void cadastrarFuncionario() {
		
		var scanner = new Scanner(System.in);
		
		System.out.println("\nCADASTRO DE FUNCIONARIO:\n");
		
		var funcionario = new Funcionario();
		
		funcionario.setEndereco(new Endereco());
		
		funcionario.setId(UUID.randomUUID());
		
		funcionario.getEndereco().setId(UUID.randomUUID());
		
		System.out.print("INFORME O NOME DO FUNCIONARIO...........: ");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("INFORME O CPF DO FUNCIONÁRIO............: ");
		funcionario.setCpf(scanner.nextLine());
		
		System.out.print("INFORME A DATA DE ADMISSÃO (dd/MM/yyyy).: ");
		var input = scanner.nextLine();
		var dataAdmissao = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);
		
		System.out.print("INFORME O LOGRADOURO..............: ");
		funcionario.getEndereco().setLogradouro(scanner.nextLine());
		
		System.out.print("INFORME O NUMERO..............: ");
		funcionario.getEndereco().setNumero(scanner.nextLine());

		System.out.print("INFORME O COMPLEMENTO..............: ");
		funcionario.getEndereco().setComplemento(scanner.nextLine());
		
		System.out.print("INFORME O BAIRRO..............: ");
		funcionario.getEndereco().setBairro(scanner.nextLine());
		
		System.out.print("INFORME O CIDADE..............: ");
		funcionario.getEndereco().setCidade(scanner.nextLine());
		
		System.out.print("INFORME O ESTADO..............: ");
		funcionario.getEndereco().setEstado(scanner.nextLine());
		
		System.out.print("INFORME O CEP..............: ");
		funcionario.getEndereco().setCep(scanner.nextLine());
		
		System.out.println("\nDADOS DO FUNCIONARIO:");
		
		System.out.println("\tID.......................: " + funcionario.getId());
		System.out.println("\tNOME.....................: " + funcionario.getNome());
		System.out.println("\tCPF......................: " + funcionario.getCpf());
		System.out.println("\tDATA DE ADMISSÃO.........: " + funcionario.getDataAdmissao());
		System.out.println("\tLOGRADOURO...............: " + funcionario.getEndereco().getLogradouro());
		System.out.println("\tCOMPLEMENTO..............: " + funcionario.getEndereco().getComplemento());
		System.out.println("\tNUMERO...................: " + funcionario.getEndereco().getNumero());
		System.out.println("\tBAIRRO...................: " + funcionario.getEndereco().getBairro());
		System.out.println("\tCIDADE...................: " + funcionario.getEndereco().getCidade());
		System.out.println("\tESTADO...................: " + funcionario.getEndereco().getEstado());
		System.out.println("\tCEP......................: " + funcionario.getEndereco().getCep());
		
		
		
		scanner.close();
		
		var funcionarioRepository = new FuncionarioRepository();
		funcionarioRepository.inserir(funcionario);
		}

}
