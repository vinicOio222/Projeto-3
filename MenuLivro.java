package ProjetoLibrary_PEOO;

import java.util.Scanner;


public class MenuLivro {
    Livro book = new Livro();
    EmprestimoDevolucao alugar = new EmprestimoDevolucao();
    Relatorio r = new Relatorio();
    Sugestao s = new Sugestao();
    public void exibirMenuLivro() throws Exception{
        Scanner key = new Scanner(System.in);
        int op;
        boolean flag = false;
        while(!flag){
            System.out.println("Menu do Livro\n\n"
            +"1.Adicionar Livro;\n"
            +"2.Remover Livro;\n"
            +"3.Pesquisar Livro;\n"
            +"4.Listar Livros;\n"
            +"5.Alterar Livro;\n"
            +"6.Alugar Livro;\n"
            +"7.Devolver Livro;\n"
            +"8.Relatório;\n"
            +"9.Sugestão;\n"
            +"10.Sair do Menu Livro;");           
            op = key.nextInt();
            switch(op){
                case 1:
                    book.adicionarLivro();
                    break;
                case 2:
                    book.removerLivro();
                    break;
                case 3:
                    book.pesquisarLivro();
                    break;
                case 4:
                    book.listarLivros();
                    break;
                case 5:
                    try {
                        book.alterarDados();
                    } catch (Exception e) {
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 6:
                    try {
                        alugar.alugarLivro();
                    } catch (Exception e) {
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 7:
                    try{
                        alugar.devolverLivro();
                    }catch(Exception e){
                        System.out.println("Erro na operação!");
                    }
                    break;
                case 8 :
                r.relatorioLivros();
                break;
                case 9 :
                s.sugestao();
                break;
                case 10:
                flag = true;
                break;
                default:
                    System.out.println("Operação Inválida!");
                    break;
            }
        }
    }
}