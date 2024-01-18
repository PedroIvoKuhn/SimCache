package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Cache {
    private List<Bloco> cache = new ArrayList<>();
    private List<Integer> listaFIFO = new ArrayList<>();
    private ArrayList<Integer>[] matriz;
    private int tamanhoBloco;
    private int hit;
    private int compulsorio, conflito, capacidade, miss;

    @SuppressWarnings("unchecked")
    public Cache(int nVias, int nConjuntos) {
        for (int i = 0; i < nVias; i++) {
            cache.add(new Bloco(nConjuntos));
        }
        for (int i = 0; i < nConjuntos; i++) {
            listaFIFO.add(0);
        }
        matriz = (ArrayList<Integer>[]) new ArrayList[nConjuntos];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new ArrayList<>();
        }
        tamanhoBloco = nConjuntos;
    }

    private int random(int nBlocos){
        Random rand = new Random();
        return rand.nextInt(nBlocos);
    }

    private Integer localizacaoTag(int valorRemovido, int indice){
        Conjunto temp;
        for (int index = 0; index < cache.size(); index++) {
            temp = cache.get(index).getConjunto(indice);
            if (temp.getTag() == valorRemovido){
                return index;
            }
        }
        return null;
    }

    public void run(int tag, int indice, String substituicao) throws Exception{
        Conjunto temp;
        boolean isLRU = false;

        if (substituicao.equals("L") || substituicao.equals("l")) {
            isLRU = true;
        }

        for (Bloco bloco : cache) {
            temp = bloco.getConjunto(indice);
            if (!temp.isValidade()) {
                compulsorio++;
                bloco.setConjunto(indice, new Conjunto(true, tag));
                if (isLRU) {
                    matriz[indice].add(tag);
                }
                return;
            }else{
                if (tag == temp.getTag()) {
                    hit++;
                    if (isLRU) {
                        matriz[indice].remove(Integer.valueOf(tag));
                        matriz[indice].add(tag);
                    }
                    return;
                }
            }
        }

        if (isLRU) {
            int valorRemovido = matriz[indice].get(0);
            Integer posicao = localizacaoTag(valorRemovido, indice);
            if(posicao == null){
                throw new Exception("Posicao não encontrada");
            }
            cache.get((int) posicao).setConjunto(indice, tag);
            matriz[indice].remove(0);
            matriz[indice].add(tag);
            return;
        }

        if (substituicao.equals("F") || substituicao.equals("f")) {
            int posiFIFO = listaFIFO.get(indice);
            if (posiFIFO == cache.size()) {
                posiFIFO = 0;
            }
            cache.get(posiFIFO).setConjunto(indice, tag);
            listaFIFO.set(indice, ++posiFIFO);
            return;
        }

        if (compulsorio == (tamanhoBloco * cache.size())) {
            capacidade++;
        }else{
            conflito++;
        }
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

    public void printSaida(){
        Locale.setDefault(Locale.US);
        int miss = capacidade + compulsorio + conflito;
        int total = hit + miss;

        System.out.printf("%d, %.4f, %.4f, %.4f,%.4f, %.4f", total, (float)hit/total, (float)miss/total, (float)compulsorio/miss, (float)capacidade/miss, (float)conflito/miss);
    }

    public void printSaidaFormatada(){
        int miss = capacidade + compulsorio + conflito;
        int total = hit + miss;

        System.out.println("=========================================");
        System.out.println("Total de acessos:\t\t" + total);
        System.out.println("Hits:\t\t\t\t" + hit);
        System.out.println("Taxa de hit:\t\t\t" + ((float)hit / total)*100 + "%");
        System.out.println("Miss:\t\t\t\t" + miss);
        System.out.println("Taxa de miss:\t\t\t" + ((float)miss / total)*100 + "%");
        System.out.println("Miss compulsorio:\t\t" + compulsorio);
        System.out.println("Taxa de miss compulsorio:\t" + ((float)compulsorio / miss)*100 + "%");
        System.out.println("Miss conflito:\t\t\t" + conflito);
        System.out.println("Taxa de miss conflito:\t\t" + ((float)conflito / miss)*100 + "%");
        System.out.println("Miss capacidade:\t\t" + capacidade);
        System.out.println("Taxa de miss capacidade:\t" + ((float)capacidade / miss)*100 + "%");
        System.out.println("=========================================");
    }
    
    public void printCache(){
        System.out.println("=========================================");
        System.out.println("Hit: " + hit);
        System.out.println("Miss Compulsorio: " + compulsorio);
        System.out.println("Miss Conflito: " + conflito);
        System.out.println("Miss Capacidade: " + capacidade);
        System.out.println("Miss : " + (capacidade + compulsorio + conflito));
        for (int i = 0; i < cache.size(); i++) {
            System.out.println("--============ Via " + i + " ============--");
            for (int j = 0; j < tamanhoBloco; j++) {
                System.out.print(j + "\t");
                cache.get(i).printBloco(j);
            }
        }
        System.out.println("=========================================");
    }

    public void printMatriz(){
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i]);
        }
    }
}