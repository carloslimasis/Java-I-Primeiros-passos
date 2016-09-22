class Empresa {
	private String nome;
	private String cnpj;
	private Funcionario[] empregados;

	public Empresa() {
		this.empregados = new Funcionario[10];
	}

	public Empresa(int numeroEmpregados) {
		this.empregados = new Funcionario[numeroEmpregados];
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void adiciona(Funcionario f) {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] == null) {
				empregados[i] = f;
				break;
			} 
		}
	}

	public void mostraEmpregados() {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null) {
				System.out.println("Funcionario na posição: " + i);
				System.out.println("R$" + this.empregados[i].getSalario());
			}
		}
	}

	public void mostraTodasAsInformacoes() {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null) {
				empregados[i].mostra();
			}
		}
	}

	public boolean contem(Funcionario f) {
		for(int i = 0; i < this.empregados.length; i++) {
			if(empregados[i] != null && empregados[i].getNome().equals(f.getNome())) {
				return true;
			}
		}

		return false;
	}

	public Funcionario getFuncionario(int posicao) {
		return this.empregados[posicao];
	}
}

class TestaFuncionario {
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		//empresa.empregados = new Funcionario[10];

		Funcionario f1 = new Funcionario();
		f1.setNome("Maria");
        f1.setSalario(1000.0);
        f1.setDataEntradaBanco(new Data(3, 3, 2013));
        f1.getDepartamento().nome = "Departamento 1";
        empresa.adiciona(f1);

        Funcionario f2 = new Funcionario();
        f2.setNome("José");
        f2.setSalario(1700.0);
        f2.setDataEntradaBanco(new Data(1, 1, 2010));
        f2.getDepartamento().nome = "Departamento 2";
        empresa.adiciona(f2);

        Funcionario f3 = new Funcionario();
        f3.setNome("Marcos");
        f3.setSalario(1700.0);
        f3.setDataEntradaBanco(new Data(2, 2, 2011));
        f3.getDepartamento().nome = "Departamento 2";
        
        empresa.mostraTodasAsInformacoes();

        System.out.println("Empresa contem o funcionario " + f1.getNome() + ": " + empresa.contem(f1));
        System.out.println("Empresa contem o funcionario " + f2.getNome() + ": " + empresa.contem(f2));
        System.out.println("Empresa contem o funcionario " + f3.getNome() + ": " + empresa.contem(f3));
	}
}

class Data {
	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (! isDataViavel(dia, mes, ano)) {
            System.out.println("A data " + getFormatada() + " não existe!");
        }
    }

	private boolean isDataViavel(int dia, int mes, int ano) {
        if (dia <= 0 || mes <= 0 || mes > 12 || ano <= 0) {
            return false;
        }

        int ultimoDiaDoMes = 31;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {
            ultimoDiaDoMes = 30;
        } else if (mes == 2) {
            ultimoDiaDoMes = 28;
            if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
                ultimoDiaDoMes = 29;
            }
        }
        if (dia > ultimoDiaDoMes) {
            return false;
        }

        return true;
    }

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

	public static int identificador = 0;

	private String nome;
	private Departamento departamento;
	private Double salario;
	private Data dataEntradaBanco;
	private String rg;

	public Funcionario() {
		this.departamento = new Departamento();
		identificador++;
	}

	public Funcionario(String nome) {
		this.nome = nome;
		this.departamento = new Departamento();
		identificador++;
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
		
		Data dataEntrada = new Data(4,4,1999);
		dataEntrada.preencheData(1, 8,2016);
		

		Departamento departamento = new Departamento();
		departamento.nome = "Corregedoria";

		Funcionario funcionario = new Funcionario();
		System.out.println(funcionario.identificador);

		funcionario.setNome("Carlos");
		funcionario.setDepartamento(departamento);
		funcionario.setSalario(222.0);
		funcionario.setRg("12345678");
		funcionario.setDataEntradaBanco(dataEntrada);

		Funcionario funcionario2 = new Funcionario();
		System.out.println(funcionario2.identificador);

		funcionario2.setNome("Carlos");
		funcionario2.setDepartamento(departamento);
		funcionario2.setSalario(222.0);
		funcionario2.setRg("12345678");
		funcionario2.setDataEntradaBanco(dataEntrada);

	}
}

class Teste {
    int x = 37;

    public static void main(String[] args) {
        System.out.println(x);
    }
}

