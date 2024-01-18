import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import entities.Cache;

public class cache_simulator {
    public static void main(String[] args) throws Exception {
        if (args.length != 6){
            //System.out.println(args.length);
            System.out.println("Numero de argumentos incorreto. Utilize:");
            System.out.println("java cache_simulator <nsets> <bsize> <assoc> <substituição> <flag_saida> arquivo_de_entrada");
            System.exit(1);
        }
        int nsets = Integer.parseInt(args[0]);
        int bsize = Integer.parseInt(args[1]);
        int assoc = Integer.parseInt(args[2]);
        String subst = args[3];
        int flagOut = Integer.parseInt(args[4]);
        String arquivoEntrada = args[5];

        System.out.printf("nsets = %d\n", nsets);
        System.out.printf("bsize = %d\n", bsize);
        System.out.printf("assoc = %d\n", assoc);
        System.out.printf("subst = %s\n", subst);
        System.out.printf("flagOut = %d\n", flagOut);
        System.out.printf("arquivo = %s\n", arquivoEntrada);
                
        int nIndice = 31 - Integer.numberOfLeadingZeros(nsets);
        System.out.println("nIndice: " + nIndice);

        int nOffset = 31 - Integer.numberOfLeadingZeros(bsize);
        System.out.println("nOffset: " + nOffset);

        Cache cache = new Cache(assoc, nsets);

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(arquivoEntrada))) {
            int entrada;
            while (inputStream.available() > 0) {
                entrada = inputStream.readInt();
                entrada = entrada >>> nOffset; // tirando o offset da entrada
                int indice = entrada & ((1 << nIndice) - 1);
                entrada = entrada >>> nIndice;
                int tag = entrada;

                cache.run(tag, indice, subst);
            }
            if (flagOut == 1) {
                cache.printSaida();
            }else{
                cache.printSaidaFormatada();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}