public class Fila {
  
  public Object[] fila;
  public int capacidade;
  public int tamanho;
  public int inicio, fim;

  public Fila (int tamanho, int capacidade) {
    this.tamanho = tamanho;
    inicio = fim = 0;
    fila = new Object[tamanho]; 
    capacidade = 0;
  }

  public void enqueue(Object o) {
    if (isEmpty()) {
        if (inicio == 0){
            capacidade *= 2;
        }
      fim++;
      fila[fim] = o;
      capacidade++;
    }
  }

  public Object first() {
    return fila[inicio];
  }

  public Object dequeue()  {
    inicio = (inicio++) % tamanho;
    return fila[inicio];
  }

  public void mostra() {
    for (int i = 0 ; i <= fila.length ; ++i) 
      System.out.println(fila[i]);
  }

  public boolean isEmpty() {
    return inicio == fim;
  }

  public int size() {
    return (tamanho - inicio + fim) % tamanho;
  }
}