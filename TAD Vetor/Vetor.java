
public class Vetor {
  public Object[] vetor;
  public int capacidade;
  public int size;

  public Vetor (int capacidade) {
    size = 0;
    this.capacidade = capacidade;
    vetor = new Object[capacidade];
  }
  
  public void insertAtRank (int rank, Object o) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    for (int i = size ; i < rank ; i++)
        vetor[i] = vetor[i+1];
    vetor[rank] = o;
    capacidade++;
    size++;
  }

  public Object removeAtRank(int rank){
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    Object elemento = vetor[rank];
    for (int i = rank ; i < size ; i++)
        vetor[i] = vetor[i+1];
    size--;
    return elemento;
  }

  public Object replaceAtRank(int rank, Object o) {
      if (isEmpty()) System.out.println("Vetor vazio");
      if (rank < 0 || rank > size) System.out.println("Index invalido");
      vetor[rank] = o; 
      return o;
  }

  public Object elemAtRank (int rank) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    return vetor[rank];
  }

  public boolean isEmpty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
}











