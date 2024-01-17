import java.util.Scanner;

import entities.Cache;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Vias: ");
        int vias = sc.nextInt();

        System.out.print("linhas: ");
        int linhas = sc.nextInt();

        System.out.print("Bsize: ");
        int bsize = sc.nextInt();

        int nIndice = 31 - Integer.numberOfLeadingZeros(linhas);
        System.out.println("nIndice: " + nIndice);

        int nOffset = 31 - Integer.numberOfLeadingZeros(bsize);
        System.out.println("nOffset: " + nOffset);

        Cache cache = new Cache(vias, linhas);

        System.out.print("Entrada: ");
        int entrada = sc.nextInt();

        entrada = entrada >>> nOffset; // tirando o offset da entrada
        int indice = entrada & ((1 << nIndice) - 1);
        entrada = entrada >>> nIndice;
        int tag = entrada;

        System.out.println("Indice: " + indice);
        System.out.println("Tag: " + tag);


        
/*
        System.out.println("==================================================");
        System.out.println("Número de bits da entrada: " + nBitsEntrada);
        System.out.println("Número de bits do indice: " + nIndice);
        System.out.println("Número de bits da tag: " + (nBitsEntrada - nIndice));
        System.out.println("Valor do indice: " + indice);
        System.out.println("Valor da tag: " + tag);
        System.out.println("==================================================");
*/
        cache.run(tag, indice);

        cache.run(1, 2);
        cache.run(1, 3);
        cache.run(1, 4);
        cache.run(2, 2);
        cache.run(2, 5);
        cache.run(1, 2);
        cache.run(0, 7);
        cache.run(0, 2);
        cache.run(2, 7);
        cache.run(1, 3);
        cache.run(1, 4);
        cache.run(2, 2);
        cache.run(2, 5);
        cache.run(1, 2);
        cache.run(0, 7);
        cache.run(0, 2);
        cache.run(2, 7);
        cache.run(1, 2);
        cache.run(0, 7);
        cache.run(0, 2);
        cache.run(2, 7);
        cache.run(1, 3);
        cache.run(1, 4);
        cache.run(2, 2);

        cache.printCache(linhas);

        sc.close();
    }
}