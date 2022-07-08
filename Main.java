package ProjetoLibrary_PEOO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Arquivos.gerarBiblioteca();
        MenuUsuario mUsuario=new MenuUsuario();
        MenuLivro mLivro = new MenuLivro();
        Scanner key =new Scanner(System.in);
        int op=0;
        while(op!=3){
            System.out.println("Bem-vindo(a) a Biblioteca da Universidade Estadual do Ceará(UECE)!\n\n"
            +"1.Área Usuários;\n"
            +"2.Área Livros;\n"
            +"3.Sair;");
            op = key.nextInt();
            if(op==1){
                mUsuario.exibirMenuUsuario();
            }
            else if(op==2){
                mLivro.exibirMenuLivro();
            } else if(op == 3){
                System.exit(0);
            }else{
                System.out.println("Operação Inválida!");
            }
        }

        key.close();
    }
    
    
}
