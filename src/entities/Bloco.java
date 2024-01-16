package entities;

import java.util.ArrayList;
import java.util.List;

public class Bloco {
    private List<Conjunto> list = new ArrayList<>();

    public Bloco(int nConjuntos) {
        for (int i = 0; i < nConjuntos; i++) {
            list.add(new Conjunto());
        }
    }

    public Conjunto getConjunto(int endereco){
        return list.get(endereco);
    }

    public void setConjunto(int endereco, Conjunto conjunto){
        list.set(endereco, conjunto);
    }

    public void setConjunto(int endereco, int tag){
        Conjunto temp = list.get(endereco);
        temp.setTag(tag);
        list.set(endereco, temp);
    }

    public void printBloco(int conjunto) {
        System.out.println(list.get(conjunto));
    }
}