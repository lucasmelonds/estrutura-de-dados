public class Lista {
  public Object[] lista;
  public int capacidade;
  public int size;

  public Lista(int capacidade) {
    this.capacidade = capacidade;
    lista = new Object[capacidade];
    size = 0;
  }

  public void insertFirst (Object o) {
    if (size == capacidade - 1)
          capacidade *= 2;
    if (size() > 1) {
      Object b[] = new Object[capacidade];
      for (int i = 0 ; i <= size ; ++i)
        b[i] = lista[i];
      lista = b;
      lista[--size] = o;
    } else {
      for (int i = size ; i < 0 ; ++i)
        lista[i] = lista[i];
      lista[0] = o;
    }
    size++;
  }
  
  public void insertLast (Object o) {
    if (size == capacidade - 1) 
          capacidade *= 2;
    Object b[] = new Object[capacidade];
    for (int i = 0 ; i < size ; i++)
      b[i] = lista[i];
    lista = b;
    lista[size] = o;
    size++;
  }
  
  public void insertBefore (int rank, Object o) {
    for (int i = size ; i < rank ; i++)
        lista[i] = lista[i+1];
    lista[rank-1] = o;
    capacidade++;
    size++;
  }
  
  public void insertAfter (int rank, Object o) {
    for (int i = size ; i < rank ; i++)
        lista[i] = lista[i+1];
    lista[rank+1] = o;
    capacidade++;
    size++;
  }

  public Object replaceElements(int rank, Object o) {
      if (isEmpty()) System.out.println("Lista vazia");
      if (rank < 0 || rank > size) System.out.println("Index invalido");
      lista[rank] = o; 
      return o;
  }
  
  public Object remove (int rank) {
      if (isEmpty()) System.out.println("Lista vazia");
      if (rank < 0 || rank > size) System.out.println("Index invalido");
      Object elemento = lista[rank];
    for (int i = rank ; i < size ; i++)
        lista[i] = lista[i+1];
    size--;
    return elemento;
  }

  public void mostra() {
    for (int i = 0 ; i < size ; ++i) 
      System.out.println(lista[i]);
  }

  public Object first() {
    return lista[0];
  }
  
  public Object last() {
    return lista[size-1];
  }

  public boolean isFirst(Object o) {
    return o == lista[0];
  }
  
  public boolean isLast(Object o) {
    return o == lista[size-1];
  }

  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
}