public class PilhaArray {
  public Object[] pilha;
  public int capacidade;
  public int t;
  private int cresc;
  
  public PilhaArray (int capacidade, int crescimento) {
    this.capacidade = capacidade;
    t = -1;
    cresc = crescimento;
    if (crescimento <= 0) 
        cresc = 0;
    pilha = new Object[capacidade];
  }
  
  public void push (Object o) {
    if (t == capacidade - 1) {
        if (cresc == 0) 
            capacidade *= 2;
        else 
            capacidade += cresc;
        Object b[] = new Object[capacidade];
        for (int f = 0 ; f < pilha.length ; f++)
          b[f] = pilha[f];
        pilha = b;
    }
    pilha[++t] = o;
  }

  public void mostra() {
    for (int i = 0 ; i <= t ; ++i) 
      System.out.println(pilha[i]);
  }

  public Object pop() {
    Object r = pilha[t--];
    return r;
  }
  
  public Object top() {
    return pilha[t];
  }
    
  public boolean empty() {
    return t == -1;
  }
  
  public int size() {
    return t+1;
  }
}