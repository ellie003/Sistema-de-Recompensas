package leituras;
// O objetivo deste programa é armazenar dados de leituras feitos pelo usuário e acompanhar o progresso em relação a metas pré-determinadas.
// Para manter o leitor motivado, o programa implementa um sistema de recompensas que são concedidas quando as metas são atingidas. 
//Ao fazer isso, o programa espera incentivar o leitor a continuar a ler e alcançar novas metas.


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class leituras {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int leituras = 0;
        //no comeco do programa ainda nemhuma das metas foram alcancadas
        boolean[] metasAlcancadas = {false, false, false};
        
        // Definir as metas e recompensas
        int[] metas = {250, 400, 750};
        String[] recompensas = {"YouTube", "Anime", "manga"};
        
        System.out.println("Bem-vindo ao Sistema de Recompensas!");
        
        // Loop para acompanhar o progresso
        while (true) {
            System.out.print("Digite o número de paginas que você fez hoje: ");
            int quantPaginas = scanner.nextInt();
            
            // Verificar se uma meta foi alcançada
            for (int i = 0; i < metas.length; i++) {
                if (!metasAlcancadas[i] && leituras + quantPaginas >= metas[i]) {
                    metasAlcancadas[i] = true;
                    System.out.println("Parabéns! Você alcançou a meta de " + metas[i] + " leitura e ganhou a recompensa: " + recompensas[i]);
                    
                    // Armazenar os dados em um arquivo de texto
                    try {
                        FileWriter writer = new FileWriter("dados.txt", true);
                        writer.write("Meta alcançada: " + metas[i] + " vendas. Recompensa: " + recompensas[i] + "\n");
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Erro ao gravar os dados em arquivo.");
                    }
                }
            }
            
            leituras += quantPaginas;
            
            System.out.println("Você já fez " + leituras + ".");
            System.out.println("Pressione 's' para sair ou qualquer outra tecla para continuar.");
            String resposta = scanner.next();
            if (resposta.equals("s")) {
                break;
            }
        }
    System.out.println("Obrigada por usar o programa");    
    scanner.close();
   
    }
}




