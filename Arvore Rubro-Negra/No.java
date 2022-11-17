public class No {
  public long elem;
  public No dir;
  public No esq;
  public No pai;
  public int cor;

  public No(long elem) {
    this.elem = elem;
    this.dir = this.esq = this.pai = null;
  }
}