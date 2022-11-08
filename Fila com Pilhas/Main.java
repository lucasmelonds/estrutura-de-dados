class Main {
  public static void main(String[] args) {
    FilaPilha pilha = new FilaPilha();
    System.out.println("Fila 1:");
    pilha.enqueue(1);
    pilha.enqueue(2);
    pilha.enqueue(3);
    pilha.mostra();

    System.out.println("Fila 2:");
    System.out.println(pilha.dequeue());
    System.out.println(pilha.dequeue());
    System.out.println(pilha.dequeue());
    pilha.mostra();
    
  }
}