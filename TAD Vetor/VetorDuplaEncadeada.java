public class VetorDuplaEncadeada {
  public DLNode vetor;
  public DLNode inicio, fim;
  public int size;

  public VetorDuplaEncadeada () {
    size = 0;
  }

  public Object elemAtRank(int rank) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    
    DLNode aux = inicio.getProx();
		for(int i=0; i<rank;i++) aux=aux.getProx();
		return aux.getElemento();
  }

  public Object replaceAtRank(int rank, Object elem) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    
    DLNode aux = inicio.getProx();
    for(int i=0 ; i < rank ; i++) aux=aux.getProx();
    Object old = aux.getElemento();
    aux.setElemento(elem);
    return old;
  }
  
  public void insertAtRank (int rank, Object elem) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    
    vetor = inicio;
    DLNode node = new DLNode();
    node.setElemento(elem);
    if (size == 0) {
      vetor.setProx(node);
      node.setPrev(vetor);
      fim = vetor;
    }
    if (rank == size) {
      fim.setProx(node);
      node.setPrev(vetor);
      fim = node;
    }
    else {
      for (int i = 0 ; i < rank ; i++)
          vetor = vetor.getProx();
      vetor.setPrev(node);
      vetor.setProx(node);
      node.setPrev(vetor.getPrev());
      vetor.setPrev(node);
      node.setProx(vetor);
    }
    size++;
  }
  
  public Object removeAtRank (int rank) {
    if (isEmpty()) System.out.println("Vetor vazio");
    if (rank < 0 || rank > size) System.out.println("Index invalido");
    
    vetor = inicio.getProx();
    if (size == 0) {
      vetor.setProx(null);
      vetor.setPrev(null);
      inicio = vetor.getProx();
    }
    if (rank == size) {
      vetor = fim;
      vetor.setProx(null);
      vetor.setPrev(null);
      fim = vetor.getPrev();
    } 
    else {
      for (int i = 0 ; i < rank ; i++) 
          vetor = vetor.getProx();
      vetor.setProx(vetor.getProx());
      vetor.setPrev(vetor.getProx());
      
    if (vetor.getProx() != null) {
        vetor.setProx(vetor.getPrev()); 
        vetor.setPrev(vetor.getPrev()); 
      }
    }
    size--;
    return vetor.getElemento();
  }

  public int size() {
      return size;
  }
  
  public boolean isEmpty() {
      return size == 0;
  }
}