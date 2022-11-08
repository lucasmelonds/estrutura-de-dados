public class FilaPilha {
  public PilhaArray P1;
  public PilhaArray P2;

  public FilaPilha() {
    P1 = new PilhaArray(1, 0);
    P2 = new PilhaArray(1, 0);
  }

  public void enqueue(Object o) {
    P1.push(o);
    while (P1.empty()) {
      P2.push(P1.pop());
      P1.pop();
    }
    while (!P2.empty()) {
      P1.push(P2.pop());
      P2.pop();
    }
  }

  public Object dequeue() {
      if (P1.empty()) {
        System.out.println("Pilha vazia");
        System.exit(0);
      }
      Object o = P1.top();
      P1.pop();
      return o;
  }

  public void mostra() {
    for (int i = 0 ; i <= P1.t ; ++i) 
      System.out.println(P1.pilha[i]);
  }
}