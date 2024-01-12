package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cache {
    private List<Bloco> cache = new ArrayList<>();
    private int hit;
    private int compulsorio, conflito, capacidade, miss;

    public Cache(int nVias, int nConjuntos) {
        for (int i = 0; i < nVias; i++) {
            cache.add(new Bloco(nConjuntos));
        }
    }

    private int random(int nBlocos){
        Random rand = new Random();
        return rand.nextInt(nBlocos);
    }

    public void run(int tag, int indice){
        Conjunto temp;

        for (Bloco bloco : cache) {
            temp = bloco.getConjunto(indice);
            if (!temp.isValidade()) {
                compulsorio++;
                bloco.setConjunto(indice, new Conjunto(true, tag));
                return;
            }else{
                if (tag == temp.getTag()) {
                    hit++;
                    return;
                }
            }
        }
        conflito++;
        int bloco = random(cache.size());
        cache.get(bloco).setConjunto(indice, tag);

    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getCompulsorio() {
        return compulsorio;
    }

    public void setCompulsorio(int compulsorio) {
        this.compulsorio = compulsorio;
    }

    public int getConflito() {
        return conflito;
    }

    public void setConflito(int conflito) {
        this.conflito = conflito;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }

}