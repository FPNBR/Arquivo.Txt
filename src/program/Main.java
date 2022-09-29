package program;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        String opcao;

        System.out.print("##--Menu--##\n\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("| Opção 0 - Sair do programa             |\n");
        System.out.print("| Opção 1 - Criar arquivo txt e inserir conteúdo     |\n");
        System.out.print("| Opção 2 - Ler arquivo txt         |\n");
        System.out.print("| Opção 3 - Deletar o arquivo txt          |\n");
        System.out.println("|-----------------------------|\n");
        System.out.print("Digite uma opção: ");

        do {
            opcao = sc.nextLine();

            switch (opcao) {
                case "0":
                    System.out.println("Programa encerrado\n");
                    break;
                case "1":
                    System.out.print("Digite o nome do arquivo: ");
                    String nomeArq = sc.nextLine();
                    FileWriter arq = new FileWriter("/Users/felipe/Documents/Java Projetos/Walter Travadasso/" + nomeArq + ".txt");
                    System.out.println("Arquivo criado com sucesso!");
                    System.out.print("Digite o conteúdo do arquivo: ");
                    String conteudoArq = sc.nextLine();
                    PrintWriter gravarArq = new PrintWriter(arq);
                    gravarArq.printf(conteudoArq);
                    arq.close();
                    System.out.println("Conteúdo inserido com sucesso!");
                    break;
                case "2":
                    System.out.print("Informe o nome de arquivo de texto:\n");
                    String nomeArqTexto = sc.nextLine();
                    System.out.print("\nConteúdo do arquivo de texto:\n");
                    try {
                        FileReader arqTexto = new FileReader(nomeArqTexto);
                        BufferedReader lerArq = new BufferedReader(arqTexto);
                        String linha = lerArq.readLine();
                        while (linha != null) {
                            System.out.printf("%s\n", linha);
                            linha = lerArq.readLine();
                        }
                        arqTexto.close();
                    } catch (IOException e) {
                        System.err.printf("Erro na abertura do arquivo: %s.\n",
                                e.getMessage());
                    }
                        break;
                case "3":
                    System.out.print("Informe o nome de arquivo de texto:\n");
                    String nomeArqTextoDeletar = sc.nextLine();
                    File myObj = new File(nomeArqTextoDeletar);
                    if (myObj.delete()) {
                        System.out.println("Arquivo: " + myObj.getName() + " deletado");
                    } else {
                        System.out.println("Arquivo não encontrado");
                    }
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
                    break;
            }
        } while (!opcao.equals("0"));
        sc.close();
    }
}