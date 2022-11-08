class Main {
  public static void main(String[] args) {

    System.out.println("Pilha:");
    PilhaEncadeada P1 = new PilhaEncadeada();
		P1.push(1);
		P1.push(2);
		P1.push(3);
		System.out.println(P1.top());
		P1.pop();
    System.out.println(P1.top());
		P1.pop();
    System.out.println(P1.top());

    System.out.println("Fila:");
    FilaEncadeada F1 = new FilaEncadeada();
    F1.enqueue(4);
    F1.enqueue(5);
    F1.enqueue(6);
    System.out.println(F1.first());
    System.out.println(F1.dequeue());
    System.out.println(F1.first());
    System.out.println(F1.last());
  }
}