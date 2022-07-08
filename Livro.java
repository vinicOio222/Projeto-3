package ProjetoLibrary_PEOO;

import java.io.*;
import java.util.Scanner;

public class Livro {
    private String codigoLivro;
    private String titulo;
    private String autor;
    private String assunto;
    private String editora;
    private double preco;


    public void adicionarLivro(){
        Scanner key = new Scanner(System.in);
        String dados = "";
        System.out.println("Insira o CÓDIGO do livro: ");
        String codigo = key.nextLine();
        System.out.println("Insira o TÍTULO do livro: ");
        String titulo = key.nextLine();
        System.out.println("Insira o NOME DO AUTOR do livro: ");
        String autor = key.nextLine();
        System.out.println("Insira o ASSUNTO do livro: ");
        String assunto = key.nextLine();
        System.out.println("Insira a EDITORA do livro: ");
        String editora = key.nextLine();

        dados+= titulo + "\n" + autor + "\n" + assunto + "\n" + editora + "\n";
        File arquivo = new File(Arquivos.livros + codigo + ".txt");
        Arquivos.escritorArquivos(arquivo, dados);
    }

    public void removerLivro(){
        Scanner key = new Scanner(System.in);
        System.out.println("Digite o codigo do livro : ");
        String codigo = key.nextLine();
        File arquivo = new File(Arquivos.livros + codigo + ".txt");
        arquivo.delete();
        System.out.println("Livro removido");
    }

    
    public void pesquisarLivro()throws Exception{
        Scanner key = new Scanner(System.in);
        System.out.println("Insira o CÓDIGO do livro: ");
        String codigo = key.nextLine();
        File livro = new File(Arquivos.livros + codigo + ".txt");
        String[]dados = Arquivos.leitorArquivos(livro).split("\n");
        System.out.println("========== Livro Encontrado ========== ");
        System.out.println("Titulo: " +dados[0]+ "\n" +"Autor: " +dados[1]+"\n"+ "Assunto: "+dados[2]+ "\n"+ "Editora: "+dados[3]+ "\n");
        System.out.println("=========================\n");
    }

    public void listarLivros(){
        File livro = new File(Arquivos.livros);
        System.out.println("========== Livros Cadastrados ========== ");
        for(File livros : livro.listFiles()){
            String[] dados = Arquivos.leitorArquivos(livros).split("\n");
            System.out.println("\n");
            System.out.println("Titulo: " +dados[0]+ "\n" +"Autor: " +dados[1]+"\n"+ "Assunto: "+dados[2]+ "\n"+ "Editora: "+dados[3]+ "\n");
        }
        System.out.println("=========================\n");
    }

    public void alterarDados() throws Exception{
        Scanner key = new Scanner(System.in);
        System.out.println("Digite o CÓDIGO do livro : ");
        String codigo = key.nextLine();
        File livro = new File(Arquivos.livros + codigo + ".txt");
        String[] dados = Arquivos.leitorArquivos(livro).split(",");

        System.out.println("Digite o NOVO CÓDIGO:");
        String novoCodigo = key.nextLine();
    
        System.out.println("Digite o NOVO TÍTULO :");
        String novoTitulo = key.nextLine();
        if(novoTitulo.equals(" ")){
            novoTitulo = dados[0];
        }
        System.out.println("Digite o NOVO AUTOR :");
        String novoAutor = key.nextLine();
        if(novoAutor.equals(" ")){
            novoAutor = dados[1];
        }
        System.out.println("Digite o NOVO ASSUNTO :");
        String novoAssunto = key.nextLine();
        if(novoAssunto.equals(" ")){
            novoAssunto = dados[2];
        }
        System.out.println("Digite a NOVA EDITORA :");
        String novaEditora = key.nextLine();
        if(novaEditora.equals(" ")){
            novaEditora = dados[3];
        }
        System.out.println("Digite o NOVO PREÇO :");
        String novoPreco = key.nextLine();
        if(novoPreco.equals("")){
            novoPreco = dados[4];
        }
        File novoLivro = new File(Arquivos.livros + novoCodigo + ".txt");
        livro.delete();
        String salvaDados = novoTitulo + "\n" + novoAutor + "\n" + novoAssunto + "\n" + novaEditora + "\n ";
        Arquivos.editarArquivo(novoLivro, salvaDados);
       }

       public String getCodigoLivro() {
           return codigoLivro;
       }

       public void setCodigoFilme(String codigoLivro) {
           this.codigoLivro = codigoLivro;
       }

       public String getTitulo() {
           return titulo;
       }

       public void setTitulo(String titulo) {
           this.titulo = titulo;
       }

       public String getAutor() {
           return autor;
       }

       public void setAutor(String autor) {
           this.autor = autor;
       }

       public String getAssunto() {
           return assunto;
       }

       public void setAssunto(String assunto) {
           this.assunto = assunto;
       }

       public String getEditora() {
           return editora;
       }

       public void setEditora(String editora) {
           this.editora = editora;
       }

   }
