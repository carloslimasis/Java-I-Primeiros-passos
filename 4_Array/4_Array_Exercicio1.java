class Empresa {
	String nome;
	String cnpj;
	Funcionario[] funcionarios;
}

class Data {
	int dia;
	int mes;
	int ano;

	String getFormatada() {
		return this.dia + "/" + this.mes + "/" + this.ano;
	}

	void preencheData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
}

class Departamento {
	String nome;
}

class Funcionario {
	String nome;
	Departamento departamento;
	Double salario;
	Data dataEntradaBanco;
	String rg;

	void recebeAumento(Double aumento) {
		this.salario += aumento;
	}

	Double calculaGanhoAnual() {
		return this.salario * 12;
	}

	void mostra() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Departamento: " + this.departamento.nome);
		System.out.println("Salário: " + this.salario);
		
		System.out.println("Data entrada: " + this.dataEntradaBanco.getFormatada());
        
		System.out.println("RG: " + this.rg);
		System.out.println("Ganho anual: " + this.calculaGanhoAnual());		
		System.out.println("\n");		
	}
}

class Programa {
	public static void main(String[] args) {
		
		Data dataEntrada = new Data();
		dataEntrada.preencheData(1, 8,2016);
		

		Departamento departamento = new Departamento();
		departamento.nome = "Corregedoria";

		Funcionario funcionario = new Funcionario();
		funcionario.nome = "Carlos";
		funcionario.departamento = departamento;
		funcionario.salario = 222.0;
		funcionario.rg = "12345678";
		funcionario.dataEntradaBanco = dataEntrada;

		System.out.println(funcionario.dataEntradaBanco.getFormatada());

	}
}