package ProjetoLibrary_PEOO;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;;

public class Arquivos {
    public static final String usuarios = "Biblioteca/Usuarios/Matricula/";
    public static final String livros = "Biblioteca/Livros/";
    public static final String livrosEmprestados = "Biblioteca/Emprestimos/";
    public static final String sugestaoLivros = "Biblioteca/Sugestoes/";
    public static final String historicoCliente = "Biblioteca/Histórico/Usuário/";
    public static final String historicoLivro = "Biblioteca/Histórico/Livro/";


    public static void gerarBiblioteca(){
        ArrayList<File> diretorios = new ArrayList<File>();
        diretorios.add(new File(usuarios));
        diretorios.add(new File(livros));
        diretorios.add(new File(sugestaoLivros));
        diretorios.add(new File(livrosEmprestados));
        diretorios.add(new File(historicoCliente));
        diretorios.add(new File (historicoLivro));

        for(File diretorio: diretorios){
            if(!diretorio.exists()){
                diretorio.mkdirs();
            }
        }
    }

    public static void escritorArquivos(File arquivo, String conteudo){
        try(FileWriter escritor = new FileWriter(arquivo,true)){
            BufferedWriter bescritor = new BufferedWriter(escritor);
            bescritor.write(conteudo);
            bescritor.close();
            escritor.close();
        }catch(IOException e){
            System.out.println("Erro no registro de dados...");
        }
      }

      
      public static void editarArquivo(File arquivo, String conteudo){
        try{
            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bescritor = new BufferedWriter(escritor);
            bescritor.write(conteudo);
            bescritor.close();
            escritor.close();
        } catch(IOException e){
            System.out.println("Erro no registro de dados...");
        }
    }

     public static String  leitorArquivos(File arquivo){
        String dados = "";
        try{
            FileReader leitor = new FileReader(arquivo);
            BufferedReader bleitor = new BufferedReader(leitor);
            while(bleitor.ready()){
                dados += bleitor.readLine() + "\n";
            }
            bleitor.close();
            leitor.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado...");
        }catch(IOException e){
            System.out.println("Erro na leitura de dados...");

        }finally{

         }
        return dados;

    }
}
       