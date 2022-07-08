package ProjetoLibrary_PEOO;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Relatorio {
    public void relatorioLivros(){
        File file=new File(Arquivos.historicoLivro+"historico.txt");
        String[] historico=Arquivos.leitorArquivos(file).split("\n");

        Set<String> set = new HashSet<>();
        for(String livro: historico) {
            set.add(livro);
        }
        String[] livros = set.toArray(new String[set.size()]);
        int cont = 0;
        String[] nomeLivros = new String[set.size()];
        for (String nomes : livros) {
            nomeLivros[cont++] = nomes;
        }

        int[] qtd=new int[set.size()];
        for (int i = 0; i < historico.length; i++) {
            for(int j=0;j<set.size();j++){
                if (nomeLivros[j].equals(historico[i])) qtd[j]++;
            }
        }
        
        String[] dadosArray = new String[set.size()];
        String dadosString=new String();
        for(int i=0;i<set.size();i++){
            dadosArray[i]=qtd[i] + "," + nomeLivros[i] +";";
        }
        for(int i=0;i<set.size();i++){
            for(int j = 1 ; j < set.size() ; j++){
                if(qtd[i] < qtd[j]){
                    String tmp = dadosArray[i];
                    dadosArray[i] = dadosArray[j];
                    dadosArray[j] = tmp;
                }
                dadosString+=dadosArray[i];
            }
        }

        String[] dados = dadosString.split(";");
        System.out.println("=============== Livros mais alugados ================");
        for(int i=0;i<set.size();i++){
            String[] dados2 = dados[i].split(",");
            System.out.println(i+1 + "." + dados2[1] + ":" + dados2[0] + "\n");
        }
        System.out.println("=======================================================");
    }
}
    
