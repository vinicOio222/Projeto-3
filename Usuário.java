package ProjetoLibrary_PEOO;

import java.io.*;
import java.util.Scanner;


public class Usuário {
    private String nome;
    private int matricula; 
    private double debitoUsuario;

    public void adicionarUsuario(){
        String dados = "";
        String matricula = "";
        String nome = "";
        int op = 0;
        String tipo = "";

        Scanner key1 = new Scanner(System.in);
        Scanner key2 = new Scanner(System.in);
        Scanner key3 = new Scanner(System.in);

        System.out.println("Insira o NÚMERO DE MATRÍCULA do usuário :");
        matricula = key1.nextLine();
        System.out.println("Insira o NOME do usuário: ");
        nome = key2.nextLine();
        System.out.println("Insira o TIPO de USUÁRIO:\n\n"
                          +"1.Aluno;\n"
                          +"2.Professor;\n");

        op = key3.nextInt();

        if(op == 1){
        File arquivo = new File(Arquivos.usuarios + matricula + ".txt");
        if(matricula.length() == 7){
            tipo = "Aluno";
            dados+= nome + "\n"+  matricula + "\n" + tipo + "\n";
        }else{
            System.out.println("Número de Matrícula INVÁLIDO!");
        }

        Arquivos.escritorArquivos(arquivo, dados);
      }else{
        tipo = "Professor";
        File arquivo = new File(Arquivos.usuarios + matricula + ".txt");
        if(matricula.length() == 7){
            dados+= nome + "\n"+  matricula + "\n" + tipo + "\n";
        }else{
            System.out.println("Número de Matrícula INVÁLIDO!");
        }
        Arquivos.escritorArquivos(arquivo, dados);
      }

    }

    public void deletarUsuario() throws FileNotFoundException{
        String matricula = "";
        Scanner key = new Scanner(System.in);
        System.out.println("Digite o NÚMERO DE MATRÍCULA do USUÁRIO: ");
        matricula = key.nextLine();
        File arquivo = new File(Arquivos.usuarios + matricula + ".txt");
        arquivo.delete();
        System.out.println("Usuário Removido!");
    }

    public void pesquisarUsuario()throws Exception{
        Scanner key = new Scanner(System.in);
        System.out.println("Insira o NÚMERO DE MATRÍCULA do usuário: ");
        String matricula = key.nextLine();
        File usuario = new File(Arquivos.usuarios + matricula + ".txt");
        String[]dados = Arquivos.leitorArquivos(usuario).split("\n");
        System.out.println("Usuário Encontrado: ");
        String mostrarDados = "Nome: " + dados[0] + "\n" + "Matrícula: " + dados [1]+ "\n" + "Tipo de Usuário: " + dados[2] + "\n";
        System.out.println(mostrarDados); 

    }

    public void listarUsuarios(){
        File usuario = new File(Arquivos.usuarios);
        System.out.println("========== Usuários cadastrados ========== ");
        for(File usuarios : usuario.listFiles()){
            String []dados = Arquivos.leitorArquivos(usuarios).split("\n");
            System.out.println();
            System.out.println("Nome: " + dados[0] + "\n" + "Matrícula: " + dados [1]+ "\n" + "Tipo de Usuário: " + dados[2] + "\n");

        }
        System.out.println("============================");
    }

    public void alterarDados() throws Exception{
        Scanner key = new Scanner(System.in);
        System.out.println("Insira o NÚMERO DE MATRÍCULA do usuário: ");
        String matricula = key.nextLine();
        File usuario = new File(Arquivos.usuarios + matricula + ".txt");
        String[] dados = Arquivos.leitorArquivos(usuario).split("\t");
        System.out.println("Insira o NOVO NOME do usuário: ");
        String novoNome = key.nextLine();
        if(novoNome.equals(" ")){
            novoNome = dados[0];

        }
    
        System.out.println("Insira o NOVO NÚMERO DE MATRICULA");
        String novaMatricula = key.nextLine();
        if(novaMatricula.equals(" ")){
            novaMatricula = dados[1];
        }
        usuario.delete();
        File novoUsuario = new File(Arquivos.usuarios + novaMatricula + ".txt");
        String salvaDados =  novoNome + "\t" + novaMatricula + "\n";
        Arquivos.editarArquivo(novoUsuario, salvaDados);
    
  }

  public void multarUsuarioA() throws Exception{
    Scanner key = new Scanner(System.in);
    System.out.println("Digite o NÚMERO DE DIAS DE ATRASO: ");
    int dias = key.nextInt();
    double multa = 0.50*dias;
    System.out.println("Total com multa: R$"+ String.format("%.2f",multa));
}

public void multarUsuarioP() throws Exception{
    Scanner key = new Scanner(System.in);
    System.out.println("Digite o NÚMERO DE DIAS DE ATRASO: ");
    int dias = key.nextInt();
    double multa = 0.80*dias;
    System.out.println("Total com multa: R$"+ String.format("%.2f",multa));
}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

   public void setMatricula(int matricula) {
    this.matricula = matricula;
   }
}
