# SimCache

O **SimCache** é um simulador de cache desenvolvido em Java. Permitindo explorar e experimentar o comportamento de uma cache, podendo escolher o número de conjuntos, tamanho do bloco, nível de associatividade e política de substituição, sendo endereçada à byte com endereços de 32 bits.

## Como executar

Para executar o projeto, siga estas etapas:

1. Clone este repositório para o seu sistema local usando o Git:

    ```bash
    git clone git@github.com:PedroIvoKuhn/SimCache.git
    ```
    
2. Abra o terminal na pasta src.

3. Compile o código utilizando o comando:

    ```bash
    javac cache_simulator.java
    ```

4. Para rodar basta utilizar um comando nesse formato:

    ```bash
    java cache_simulator <nsets> <bsize> <assoc> <substituição> <flag_saida> <arquivo_de_entrada>
    ```
    
## Funcionalidades

Cada campo possui os seguintes significados:

  - **nsets** - número de conjuntos na cache *(número total de 'linhas' ou 'entradas').*
  - **bsize** - tamanho do bloco em bytes.
  - **assoc** - grau de associatividade
  - **substituição** - política de substituição, que pode ser Random [R], FIFO [F] ou LRU [L]. *(podendo ser minúsculo e caso não seja uma letra válida será utilizado Random)*
  - **flag_saida** - flag que escolhe o formato de saída ( 0 - Modo amigável, 1 - Modo simples)
  - **arquivo_de_entrada** - arquivo com os endereços para acesso à cache.

## Endereços

No caminho `src/enderecos` possui todos os arquivos em duas versões, utilize a _.bin_ os arquivos _.txt_ servem para facilitar a visualização dos valores. Os arquivos contém 100, 1000, 10.000 e 186.676 endereços
  
## Exemplo de execução

Considerando a seguinte linha de comando, utilizando o arquivo de entrada "bin_10000.bin":
```bash
 java cache_simulator 16 2 8 R 1 bin_10000.bin
```
O resultado esperado é: `10000, 0.9317, 0.0683, 0.1874,0.7848, 0.0278`
