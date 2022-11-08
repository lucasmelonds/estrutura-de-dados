public class FilaEncadeada {
  Node inicio, fim;
  Node base;
  int tamanho;

  public FilaEncadeada() {
    this.inicio = this.fim = null;
    tamanho = 0;
  }
  
  public void enqueue(Object o) {
    Node novo = new Node();
    novo.setElemento(o);
    novo.setProx(null);

    if (inicio == null)
        base = inicio = novo;
    else
        fim.setProx(novo);
    fim = novo;
    tamanho++;
  }

  public Object first() {
    return inicio.getElemento();
  }
  
  public Object last() {
    return fim.getElemento();
  }
  
  public Object dequeue() {
    if (inicio == null) {
      System.out.println("\nQueue Underflow");
      System.exit(-1);
    }
    Object elemento = inicio.getElemento();
    if (inicio == null)
        fim = null;
    inicio = inicio.getProx();
    tamanho --;
    return elemento;
  }
  
}