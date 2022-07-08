package ProjetoLibrary_PEOO;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuUsuario {

    Usuário user = new Usuário();
    public void exibirMenuUsuario(){
        Scanner key = new Scanner(System.in);
        boolean flag = false;
        int op;
        while(!flag){
            
            System.out.println("Menu do Usuário\n"
            +"1.Adicionar Usuário;\n"
            +"2.Remover Usuário;\n"
            +"3.Pesquisar Usuário;\n"
            +"4.Listar Usuários;\n"
            +"5.Alterar Usuário;\n"
            +"6.Sair do Menu Usuário;");
            op = key.nextInt();
            switch(op){
                case 1:
                        try {
                            user.adicionarUsuario();
                        } catch (Exception e) {
                            System.out.println("Erro na operação!");
                        }
                    break;
                case 2:
                        try {
                            user.deletarUsuario();
                        } catch(FileNotFoundException e) {
                            System.out.println("Erro na operação!");
                        }
                    break;
                case 3:
                    try{
                        user.pesquisarUsuario();
                    } catch(Exception e){
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 4:
                    try{
                        user.listarUsuarios();
                    } catch(Exception e){
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 5:
                    try{
                        user.alterarDados();
                    } catch(Exception e){
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("OPÇÃO INVALIDA");
                    break;
            }
        }
    }
}
    

