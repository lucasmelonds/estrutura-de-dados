

public class Node {
  
  private Object elemento;
  private Node prox;
  
  public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
  public Object getElemento() {
    return elemento;
  }
  
  public void setProx(Node prox) {
		this.prox = prox;
	}
  public Node getProx() {
    return prox;
  }
}

