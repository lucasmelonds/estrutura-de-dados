public class ListaDL {
  public DLNode lista;
  public DLNode inicio, fim;
  public int size;

  public ListaDL () {
    //lista = new DLNode();
    size = 0;
  }

  public void insertFirst (Object o) {
    lista = inicio;
    DLNode node = new DLNode();
    node.setElemento(o);
    node.setProx(inicio);
    node.setPrev(null);
    inicio = node;
    inicio.setPrev(node);
    size++;
  }

  
  public void insertLast (Object o) {
    lista = inicio;
    DLNode node = new DLNode();
    node.setElemento(o);
    node.setProx(null);
    node.setPrev(fim);
    fim = node;
    fim.setProx(node);
    size++;
  }

  public void insertAfter(DLNode p, Object e) {
    DLNode node = new DLNode();
    node.setElemento(e);
    node.setPrev(p);
    node.setProx(p.getProx());
    (p.getProx()).setPrev(node);
    p.setProx(node);
    size++;
  }
  
  public void insertBefore(DLNode p, Object e) {
    DLNode node = new DLNode();
    node.setElemento(e);
    node.setProx(p);
    node.setPrev(p.getPrev());
    (p.getPrev()).setProx(node);
    p.setPrev(node);
    size++; 
  }

  public Object remove(DLNode p) {
    Object elem = p.getElemento();
    (p.getPrev()).setProx(p.getProx());
    (p.getProx()).setPrev(p.getPrev());
    p.setPrev(null);
    p.setProx(null);
    return elem;
  }

  public void swapElements(DLNode a, DLNode b) {
    if (a.getPrev() != null) {
      a.setPrev(b);
      a.setProx(b);
    } else {
      inicio = b;
    }
    if (b.getProx() != null) {
      b.setPrev(a);
      b.setProx(a);
    }
    a.setProx(b.getProx());
    b.setPrev(a.getPrev());
    b.setProx(a);
    a.setPrev(b);
  }
  
    public void replaceElements(DLNode a, Object elem) {
      a.setElemento(elem);

    }

  public Object first() {
    return inicio.getElemento();
  }
  
  public Object last() {
    return fim.getElemento();
  }
  
  public boolean isFirst(DLNode n) {
    return n == inicio;
  }
  
  public boolean isLast(DLNode n) {
    return n == fim;
  }

  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  }
}


