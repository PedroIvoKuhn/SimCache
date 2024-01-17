import java.util.Scanner;

import entities.Cache;

public class cache_simulator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Vias: ");
        int vias = sc.nextInt();

        System.out.print("linhas: ");
        int linhas = sc.nextInt();

        System.out.print("Bsize: ");
        int bsize = sc.nextInt();

        System.out.print("Substituicao: ");
        String subs = sc.next();
        sc.nextLine();
        
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

        //cache.run(tag, indice, subs);
        cache.run(1, 0, subs);
        cache.run(2, 0, subs);
        cache.run(3, 0, subs);
        cache.run(2, 0, subs);
        cache.run(5, 0, subs);
        cache.run(2, 0, subs);
        cache.run(7, 0, subs);
        cache.run(2, 0, subs);
        cache.run(9, 0, subs);
        cache.run(2, 0, subs);
        

        cache.printCache();

        sc.close();
    }
}