package ProjetoLibrary_PEOO;

import java.io.*;
import java.util.Scanner;

public class EmprestimoDevolucao {

    public void alugarLivro() throws Exception{
        Scanner key = new Scanner(System.in);
        System.out.println("Digite o NÚMERO DE MATRÍCULA DO USUÁRIO: ");
        String matricula = key.nextLine();
        System.out.println("Selecione o TIPO DO USUÁRIO:\n"
                            +"1.Aluno;\n"
                            +"2.Professor\n");
        int tipo = key.nextInt();
        if(tipo == 1){
        File verificarLivroAlugado = new File(Arquivos.livrosEmprestados + matricula + ".txt");
        if(verificarLivroAlugado.length() == 0) {
            System.out.println("========== Catálogo ==========\n");
            File livros = new File(Arquivos.livros);
            for(File livro: livros.listFiles()){
                String[] dados = Arquivos.leitorArquivos(livro).split("\n");
                System.out.println("===============================");
                System.out.print("Código do Livro:" + livro.getName().replace(".txt", "") + "\n");
                System.out.println("Título : " +dados[0]+ "\n"+ "Autor :"+dados[1]+ "\n"+ "Assunto :"+dados[2]+ "\n"+ "Editora:" + dados[3] + "\n");
            }
            System.out.println("===============================");
            String codigoLivro1 = key.nextLine();
            String codigoLivro2 = key.nextLine();
            String codigoLivro3 = key.nextLine();
            double preco = 0;
            int livrosTotal = 0;
            String aluguel = "";
            String salvaDados = "";
            for(File livro : livros.listFiles()){
                String codigoLivro = livro.getName().replace(".txt","");
                String[] dados = Arquivos.leitorArquivos(livro).split("\n");
                if(codigoLivro1.equals(codigoLivro) || codigoLivro2.equals(codigoLivro) || codigoLivro3.equals(codigoLivro)){
                        aluguel+= dados[0] + "\n";
                        File historicoCliente=new File(Arquivos.historicoCliente+ matricula+".txt");
                        Arquivos.escritorArquivos(historicoCliente, dados[0]+"\n");
                        File historicoLivros =new File(Arquivos.historicoLivro,"historico.txt");
                        Arquivos.escritorArquivos(historicoLivros, dados[0]+"\n");
                        livrosTotal++;
                }
            }
            salvaDados+= "Total: R$," + preco + ";"+ livrosTotal + "\n" + "\n" + aluguel + "\n";
            File aluguelLivro = new File(Arquivos.livrosEmprestados + matricula + ".txt");
            Arquivos.editarArquivo(aluguelLivro, salvaDados);
            System.out.println("Aluguel efetuado com sucesso!");
        } else {
            System.out.println("O usuário possui pendências no sistema bibliotecário!");
        }
      }else{
        File verificarLivroAlugado = new File(Arquivos.livrosEmprestados + matricula + ".txt");
        if(verificarLivroAlugado.length() == 0) {
            System.out.println("========== Catálogo ==========\n");
            File livros = new File(Arquivos.livros);
            for(File livro: livros.listFiles()){
                String[] dados = Arquivos.leitorArquivos(livro).split("\n");
                System.out.println("===============================");
                System.out.print("Código do Livro:" + livro.getName().replace(".txt", "") + "\n");
                System.out.println("Título : " +dados[0]+ "\n"+ "Autor :"+dados[1]+ "\n"+ "Assunto :"+dados[2]+ "\n"+ "Editora:" + dados[3] + "\n");
            }
            System.out.println("===============================");
            String codigoLivro1 = key.nextLine();
            String codigoLivro2 = key.nextLine();
            String codigoLivro3 = key.nextLine();
            String codigoLivro4 = key.nextLine();
            double preco = 0;
            int livrosTotal = 0;
            String aluguel = "";
            String salvaDados = "";
            for(File livro : livros.listFiles()){
                String codigoLivro = livro.getName().replace(".txt","");
                String[] dados = Arquivos.leitorArquivos(livro).split("\n");
                if(codigoLivro1.equals(codigoLivro) || codigoLivro2.equals(codigoLivro) || codigoLivro3.equals(codigoLivro) || codigoLivro4.equals(codigoLivro)){
                        aluguel+= dados[0] + "\n";
                        File historicoCliente=new File(Arquivos.historicoCliente+ matricula+".txt");
                        Arquivos.escritorArquivos(historicoCliente, dados[0]+"\n");
                        File historicoLivros =new File(Arquivos.historicoLivro,"historico.txt");
                        Arquivos.escritorArquivos(historicoLivros, dados[0]+"\n");
                        livrosTotal++;
                }
            }
            salvaDados+= livrosTotal + "\n" + aluguel + "\n";
            File aluguelLivro = new File(Arquivos.livrosEmprestados + matricula + ".txt");
            Arquivos.editarArquivo(aluguelLivro, salvaDados);
            System.out.println("Aluguel efetuado com sucesso!");
        } else {
            System.out.println("O usuário possui pendências no sistema bibliotecário!");
        }
      }
    }

    public void devolverLivro() throws Exception {
        Scanner key = new Scanner(System.in);
        System.out.println("Insira o NÚMERO DE MATRÍCULA DO USUÁRIO: ");
        String matricula = key.nextLine();
        File verificaLivroAlugado = new File(Arquivos.livrosEmprestados + matricula + ".txt");
            if(verificaLivroAlugado.length() != 0) {
            File aluguelLivro = new File(Arquivos.livrosEmprestados + matricula + ".txt");
            String[] dados = Arquivos.leitorArquivos(aluguelLivro).split("\n");
            int option=0;
            String valor ="";
            System.out.println("O Usuário fez a devolução com atraso?\n"
                              +"1.Sim;\n"
                              +"2.Não;\n");
            option = key.nextInt();
            switch(option){
                case 1:
                int op = 0;
                System.out.println("Insira o TIPO de USUÁRIO:\n\n"
                +"1.Aluno;\n"
                +"2.Professor;\n");
                op = key.nextInt();
                if(op == 1){              
                Usuário cliente = new Usuário();
                cliente.multarUsuarioA();
                aluguelLivro.delete();
                }else{
                Usuário cliente = new Usuário();
                cliente.multarUsuarioP();
                aluguelLivro.delete();
                }
                break;
                case 2:
                aluguelLivro.delete();
                System.out.println("Devolução feita com sucesso!");
                break;
            }     
        }
        else{
            System.out.println("Usuário sem pendências com o sistema!");
        }
    }
}
