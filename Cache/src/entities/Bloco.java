package entities;

import java.util.ArrayList;
import java.util.List;

public class Bloco {
    private List<Conjunto> list = new ArrayList<>();

    public Bloco(int nConjuntos) {
        for (int i = 0; i < nConjuntos; i++) {
            System.out.println("1");
            list.add(new Conjunto());
        }
    }

    public void addConjunto(Conjunto conjunto){
        list.add(conjunto);
    }

    public void procurar(Integer tag){
        for (Conjunto conjunto : list) {
            if (conjunto.isValidade()) {
                
            }
        }
    }
}