import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Bloco;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Bloco> cache = new ArrayList<>();
       
        
        System.out.println("Vias: ");
        int vias = sc.nextInt();

        System.out.println("Conjuntos: ");
        int conjuntos = sc.nextInt();

        for (int i = 0; i < vias; i++) {
            System.out.println("A");
            cache.add(new Bloco(conjuntos));
        }

        sc.close();
    }
}
