class Main {
  public static void main(String[] args) {
    ArvoreAVL arvore = new ArvoreAVL();
    arvore.insere(10);
    arvore.insere(5);
    arvore.insere(15);
    arvore.insere(2);
    arvore.insere(8);
    arvore.insere(22);

   System.out.println(); System.out.println("| Árvore Binária - Info |");

    System.out.println();
    arvore.desenharArvore();

    System.out.println();
    System.out.println();
    
    System.out.println("| Árvore Binária - Inserção (25)|");
    arvore.insere(25);
    arvore.desenharArvore();

    System.out.println();

    System.out.println("| Árvore Binária - Remoção (15) |");
    arvore.remove(15);
    arvore.desenharArvore();

    System.out.println();

    System.out.println("| Árvore Binária - Busca (5) |");
    No busca = arvore.buscar(5);
    System.out.println(busca.elem);

    System.out.println();

  }
}