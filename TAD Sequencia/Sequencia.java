public class Sequencia {
  public DLNode sequencia;
  public DLNode inicio, fim;
  public int size;

  public Sequencia() {
    inicio = new DLNode();
		fim = new DLNode();
		inicio.setProx(fim);
		fim.setPrev(inicio);
    size = 0;
  }

  public DLNode atRank(int rank){
		DLNode node = new DLNode();
		if(rank <= size()/2) {
			node = inicio.getProx();
			for(int i=0; i<rank; i++){
				node = node.getProx();
			}
		} else{
			node = fim.getPrev();
			for(int i=0; i<size()-rank-1; i++){
				node = node.getPrev();
			}
		}
		return node;
	}

  public int rankOf(DLNode no){
		DLNode node = new DLNode();
	 	node = inicio.getProx();
		int rank = 0;
		while(node != no && node != fim){
			node = node.getProx();
			rank++;
		}
		return rank;
	}

  public void insertAtRank (int rank, Object o) {
    atRank(rank).setElemento(o);
  }
  
  public Object removeAtRank (int rank) {
    return remove(atRank(rank)); 
  }

  public Object elemAtRank(int rank) {
    return atRank(rank).getElemento();
  }

  public void replaceAtRank(int rank, Object o) {
    atRank(rank).setElemento(o);
  }

  public void insertFirst (Object o) {
    DLNode node = new DLNode();
    node.setElemento(o);
    node.setProx(inicio.getProx());
    node.setPrev(inicio);
    inicio.getProx().setPrev(node);
    inicio.setProx(node);
    size++;
  }

  
  public void insertLast (Object o) {
    DLNode node = new DLNode();
    node.setElemento(o);
    node.setProx(null);
    node.setPrev(fim);
    fim = node;
    fim.setProx(node);
    size++;
  }

  public void insertAfter(DLNode no, Object e) {
    DLNode node = new DLNode();
    node.setElemento(e);
    node.setPrev(no);
    node.setProx(no.getProx());
    (no.getProx()).setPrev(node);
    no.setProx(node);
    size++;
  }
  
  public void insertBefore(DLNode no, Object e) {
    DLNode node = new DLNode();
    node.setElemento(e);
    node.setProx(no);
    node.setPrev(no.getPrev());
    (no.getPrev()).setProx(node);
    no.setPrev(node);
    size++; 
  }

  public Object remove(DLNode no) {
    Object elem = no.getElemento();
    (no.getPrev()).setProx(no.getProx());
    (no.getProx()).setPrev(no.getPrev());
    no.setPrev(null);
    no.setProx(null);
    size--;
    return elem;
  }

  public void swapElements(DLNode no, DLNode no2) {
    DLNode aux = new DLNode();
    aux.setElemento(no.getElemento());
    no.setElemento(no2.getElemento());
    no2.setElemento(aux.getElemento());
  }
  
    public void replaceElements(DLNode no, Object elem) {
      no.setElemento(elem);
    }

  public DLNode first() {
    return inicio.getProx();
  }
  
  public Object last() {
    return fim.getElemento();
  }
  
  public DLNode before(DLNode no) {
    return no.getPrev();
  }
  
  public DLNode after(DLNode no) {
    return no.getProx();
  }
  
  public boolean isFirst(DLNode no) {
    return no == inicio;
  }
  
  public boolean isLast(DLNode no) {
    return no == fim;
  }

  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
}