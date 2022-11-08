import java.util.Vector;

public class FilaVector implements IFilaVector<Object> {
  public Vector<Object> fila;
  public int inicio, fim;

  public FilaVector () {
    inicio = fim = 0;
    fila = new Vector<>(); 
  }

  public void enqueue(Object elem) {
    if (inicio == 0)
        inicio++;
    fim++;
    fila.add(elem);
  }

  public Object dequeue() {
    if (inicio != 0) {
        Object elem = fila.elementAt(inicio);
        fila.add(inicio, fila.elementAt(inicio+1));
        fila.remove(fim);
        fim--;
        if (fim == 0)
            inicio = 0;
        return elem;
    }
    return null;
  }
  
  public Object first() {
    if (inicio != 0) 
        return fila.elementAt(inicio);
    return null;
  }

  public boolean isEmpty() {
    return inicio == fim;
  }
  
}