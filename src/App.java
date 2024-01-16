import java.util.Scanner;

import entities.Cache;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Vias: ");
        int vias = sc.nextInt();

        System.out.println("linhas: ");
        int linhas = sc.nextInt();

        Cache cache = new Cache(vias, linhas);
        
        cache.printCache(linhas);

        cache.run(10,0);
        cache.run(11,0);
        cache.run(12,1);
        cache.run(13,1);
        cache.run(14,2);
        cache.run(15,2);
        cache.run(16,3);
        cache.run(17,3);
        cache.run(18,0);
        cache.run(19,0);
        cache.run(20,0);

        cache.printCache(linhas);

        sc.close();
    }
}