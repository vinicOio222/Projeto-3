package ProjetoLibrary_PEOO;

import java.io.File;
import java.util.Scanner;

public class Sugestao {
    public void sugestao(){
        System.out.println("Insira o NÚMERO DE MATRÍCULA DO USUÁRIO:");
        Scanner in = new Scanner(System.in);
        String codigo = in.nextLine();
        File file = new File(Arquivos.historicoCliente + codigo + ".txt");
        String[] string = Arquivos.leitorArquivos(file).split("\n");
        int end = string.length-1;
        String[] string2= string[end].split("\n");
        String assuntoLivro = string2[0];

        File biblioteca= new File(Arquivos.livros);
        for(File sugestao:biblioteca.listFiles()){
            String[] dados= Arquivos.leitorArquivos(sugestao).split("\n");
            for(int i=0;i<dados.length;i++){
                if(dados[i].contains(assuntoLivro)){
                    System.out.println("=========== Sugestão por Assunto ==========");
                    System.out.println("Título : " +dados[0]+ "\n" + "Autor:" +dados[1]+"\n"+ "Assunto :"+dados[2]+"\n"+ "Editora: "+dados[3]+"\n");
                }
            }
        }
        System.out.println("===============================");
    }
}
    
