

public class PilhaEncadeada {
  private Node base;

  public void push(Object o) {
    Node novo = new Node();
    novo.setElemento(o);
    novo.setProx(null);

    if (base == null) {      
        base = novo;
    }
    else {
        Node topo = last();
        topo.setProx(novo);
    }
  }

  public Node last() {
    Node aux = base;
    while (aux.getProx() != null)
			  aux = aux.getProx();
		return aux;
  }

  public Object pop() {
    if (base == null)
			  throw new NullPointerException("Pilha vazia");
    
    Object elemento;
    
    if (base.getProx() == null) {
        elemento = base.getElemento();
        base = null;
    }
    else {
        Node penult = find();
        elemento = penult.getProx().getElemento();
        penult.setProx(null);
    }
    return elemento;
  }

  public Node find() {
    Node aux = base;
    while (aux.getProx().getProx() != null) {
			  aux = aux.getProx();
		}
		return aux;
  }

  public int size() {
    if (base == null) 
        return 0;
    int size = 1;
    Node aux = base;
    while (aux.getProx() != null) {
  			aux = aux.getProx();
  			size++;
		}
    return size;
  }

  public Object top() {
		Node topo = last();
		return topo.getElemento();
	}
  
}