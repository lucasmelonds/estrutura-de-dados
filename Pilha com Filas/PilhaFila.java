public class PilhaFila {
  public Fila F1;
  public Fila F2;
  
  public PilhaFila () {
    F1 = new Fila(10, 0);
    F2 = new Fila(10, 0);
  }
  
  public void push (Object o) {
    if (F1.first() == null) 
        F1.enqueue(o);
    else {
      for (int i = 0 ; i < F1.size() ; --i)
          F2.enqueue(F1.dequeue());
     }
    F1.enqueue(o);
    for (int k = 0 ; k < F2.size() ; --k)
        F1.enqueue(F2.dequeue());
  }

  public void mostra() {
    for (int i = 0 ; i < F1.size() ; ++i) 
      System.out.println(F1.fila[i]);
  }

  public Object pop() {
    if (F1.first() == null) 
      System.out.println("Pilha vazia");
    return F1.dequeue();
  }
  
  public Object top() {
    return F1.first();
  }
    
  public boolean empty() {
    return F1.first() == null;
  }
  
  public int size() {
    return F1.size();
  }
}