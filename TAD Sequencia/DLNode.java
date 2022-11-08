public class DLNode {
  
  private Object elemento;
  private DLNode prev, prox;
  
  public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
  public Object getElemento() {
    return elemento;
  }
  
  public void setProx(DLNode prox) {
		this.prox = prox;
	}
  public DLNode getProx() {
    return prox;
  }
  
  public void setPrev(DLNode prev) {
		this.prev = prev;
	}
  public DLNode getPrev() {
    return prev;
  }
}