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

 
        sc.close();
    }
}