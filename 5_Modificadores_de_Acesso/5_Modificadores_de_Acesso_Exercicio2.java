class Empresa {
	String nome;
	String cnpj;
	Funcionario[] empregados;

	void adiciona(Funcionario f) {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] == null) {
				empregados[i] = f;
				break;
			} 
		}
	}

	void mostraEmpregados() {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null) {
				System.out.println("Funcionario na posição: " + i);
				System.out.println("R$" + this.empregados[i].salario);
			}
		}
	}

	void mostraTodasAsInformacoes() {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null) {
				empregados[i].mostra();
			}
		}
	}

	boolean contem(Funcionario f) {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null && empregados[i].nome.equals(f.nome)) {
				return true;
			}
		}

		return false;
	}
}

class TestaEmpresa {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.empregados = new Funcionario[10];

		Funcionario f1 = new Funcionario();
		f1.nome = "Maria";
        f1.salario = 1000d;
        f1.dataEntradaBanco = new Data();
        f1.departamento.nome = "Departamento 1";
        empresa.adiciona(f1);

        Funcionario f2 = new Funcionario();
        f2.nome = "José";
        f2.salario = 1700d;
        f2.dataEntradaBanco = new Data();
        f2.departamento.nome = "Departamento 2";
        empresa.adiciona(f2);

        Funcionario f3 = new Funcionario();
        f3.nome = "Marcos";
        f3.salario = 1700d;
        f3.dataEntradaBanco = new Data();
        f3.departamento.nome = "Departamento 2";
        
        empresa.mostraTodasAsInformacoes();

        System.out.println("Empresa contem o funcionario " + f1.nome + ": " + empresa.contem(f1));
        System.out.println("Empresa contem o funcionario " + f2.nome + ": " + empresa.contem(f2));
        System.out.println("Empresa contem o funcionario " + f3.nome + ": " + empresa.contem(f3));
	}
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
	private String nome;
	private Departamento departamento;
	private Double salario;
	private Data dataEntradaBanco;
	private String rg;

	public Funcionario() {
		this.departamento = new Departamento();
	}

	public Double getSalario() {
		return this.salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Data getDataEntradaBanco() {
		return this.dataEntradaBanco;
	}

	public void setDataEntradaBanco(Data dataEntradaBanco) {
		this.dataEntradaBanco = dataEntradaBanco;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void recebeAumento(Double aumento) {
		this.salario += aumento;
	}

	public Double calculaGanhoAnual() {
		return this.salario * 12;
	}

	public void mostra() {
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