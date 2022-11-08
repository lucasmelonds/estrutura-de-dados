class Main {
  public static void main(String[] args) {
    ArvoreBinaria arvore = new ArvoreBinaria();
    arvore.insere(10);
    arvore.insere(5);
    arvore.insere(15);
    arvore.insere(2);
    arvore.insere(8);
    arvore.insere(22);
    arvore.insere(25);

    System.out.println("| Árvore Binária - Info |");
    System.out.println("Tamanho: " + arvore.size());
    System.out.println("Raiz: " + arvore.root().elem);
    arvore.lista();

    System.out.println();
    System.out.println();
    
    System.out.println("| Árvore Binária - Inserção |");
    arvore.desenharArvore();

    System.out.println();

    arvore.remove(25);
    System.out.println("| Árvore Binária - Remoção (5) |");
    arvore.desenharArvore();

    System.out.println();

    System.out.println("| Árvore Binária - Busca (15) |");
    No busca = arvore.buscar(15);
    System.out.println(busca.elem);

    System.out.println();
    
  }
}