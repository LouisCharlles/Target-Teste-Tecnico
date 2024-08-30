
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <Gson> void main(String[] args) {

//        1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
//        Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
//        Imprimir(SOMA);
//        Ao final do processamento, qual será o valor da variável SOMA?

        int INDICE = 13;
        int SOMA = 0;
        int K = 0;
        while (K<INDICE){
            K = K + 1;
            SOMA = SOMA + K;
        }
        System.out.println("O valor total da variável SOMA é: "+SOMA);
//
//        2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
//
//        IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
//
        int antes = 0; int depois = 1;
        List<Integer> fibonacci = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero:");
        int numero = scanner.nextInt();

        for(int i = 0;i<=numero;i++){
            int temporario = depois;
            depois+=antes;
            antes=temporario;
            fibonacci.add(depois);
        }

        System.out.println(fibonacci);

        //        3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
//• O menor valor de faturamento ocorrido em um dia do mês;
//• O maior valor de faturamento ocorrido em um dia do mês;
//• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
//
//                IMPORTANTE:
//        a) Usar o faturamentos.json ou xml disponível como fonte dos dados do faturamento mensal;
//        b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;

        try {
        // Ler os dados do JSON usando Gson
        com.google.gson.Gson gson = new com.google.gson.Gson();
        Type faturamentoListType = new TypeToken<List<Faturamento>>(){}.getType();
        List<Faturamento> faturamentos = gson.fromJson(new FileReader("src/faturamentos.json"), faturamentoListType);

        // Inicializar variáveis para os cálculos
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double somaFaturamento = 0.0;
        int diasComFaturamento = 0;

        // Percorrer o vetor de faturamento
        for (Faturamento f : faturamentos) {
            if (f.valor > 0) { // Ignorar dias sem faturamento
                if (f.valor < menorValor) {
                    menorValor = f.valor;
                }
                if (f.valor > maiorValor) {
                    maiorValor = f.valor;
                }
                somaFaturamento += f.valor;
                diasComFaturamento++;
            }
        }

        // Calcular a média mensal
        double mediaMensal = somaFaturamento / diasComFaturamento;

        // Contar o número de dias com faturamento acima da média
        int diasAcimaDaMedia = 0;
        for (Faturamento f : faturamentos) {
            if (f.valor > 0 && f.valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        // Exibir os resultados
        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

    } catch (IOException e) {
        e.printStackTrace();
    }


//        4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
//• SP – R$67.836,43
//• RJ – R$36.678,66
//• MG – R$29.229,88
//• ES – R$27.165,48
//• Outros – R$19.849,53
//
//        Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  
//
        // Valores de faturamento por estado
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        // Calcular o faturamento total
        double faturamentoTotal = sp + rj + mg + es + outros;

        // Calcular os percentuais de representação
        double percentualSP = (sp / faturamentoTotal) * 100;
        double percentualRJ = (rj / faturamentoTotal) * 100;
        double percentualMG = (mg / faturamentoTotal) * 100;
        double percentualES = (es / faturamentoTotal) * 100;
        double percentualOutros = (outros / faturamentoTotal) * 100;

        // Exibir os resultados
        System.out.println("Percentual de representação por estado:\n");
        System.out.printf("SP: %.2f%%\n", percentualSP);
        System.out.printf("RJ: %.2f%%\n", percentualRJ);
        System.out.printf("MG: %.2f%%\n", percentualMG);
        System.out.printf("ES: %.2f%%\n", percentualES);
        System.out.printf("Outros: %.2f%%\n", percentualOutros);

//        5) Escreva um programa que inverta os caracteres de um string.
//
//        IMPORTANTE:
//        a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
//        b) Evite usar funções prontas, como, por exemplo, reverse;

        System.out.print("Digite uma string para inverter: ");
        scanner.nextLine();
        String input = scanner.nextLine();
        scanner.close();

        // Convertendo a string para um array de caracteres
        char[] caracteres = input.toCharArray();

        // Invertendo a string manualmente
        int n = caracteres.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[n - 1 - i];
            caracteres[n - 1 - i] = temp;
        }

        // Convertendo o array de caracteres de volta para uma string
        String invertida = new String(caracteres);

        // Exibindo a string invertida
        System.out.println("String invertida: " + invertida);
    }
}

class Faturamento{
    int dia;
    double valor;
}
