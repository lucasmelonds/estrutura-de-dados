import java.util.ArrayList;

class ArvoreAVL extends ArvoreBinaria{
  public No root;
  public int tamanho;
  
  public ArvoreAVL() { 
    this.root = null;
    this.tamanho = 0;
  }

  public void RE(No no, boolean rotdupla) {
    No FDir = no.dir;
    No FEsq = FDir.esq;
    if (no.pai != null && !rotdupla) {
      no.pai.dir = FDir;
    } 
    else if (no.pai != null && rotdupla) {
      no.pai.esq = FDir;
    } else {
      root = FDir;
    }
    if (FEsq != null) FEsq.pai = no;
    no.dir = FEsq;
    FDir.pai = no.pai;
    FDir.esq = no;
    no.pai = FDir;
    no.bal = no.bal + 1 - Math.min(FDir.bal, 0);
    FDir.bal = FDir.bal + 1 + Math.max(no.bal, 0);
  }

  public void RD(No no, boolean rotdupla) {
    No FEsq = no.esq;
    No FDir = FEsq.dir;
    if (no.pai != null && !rotdupla) {
      no.pai.esq = FEsq;
    } 
    else if (no.pai != null && rotdupla) {
      no.pai.dir = FEsq;
    } else {
      root = FEsq;
    }
    if (FDir != null) FDir.pai = no;
    no.esq = FDir;
    FEsq.pai = no.pai;
    FEsq.dir = no;
    no.pai = FEsq;
    no.bal = no.bal - 1 - Math.max(FEsq.bal, 0);
    FEsq.bal = FEsq.bal - 1 + Math.min(no.bal, 0);
  }

  public void verifica(No atual, int op) {
    if (op == 0) {
      while (atual.bal != 0 && atual.pai != null) {
        if (atual.elem < atual.pai.elem) atual.pai.bal++;
        else atual.pai.bal--;
        atual = atual.pai;

        if (atual.bal <= -2 && atual.dir != null && atual.dir.bal > 0) {
          System.out.println("ROTAÇÃO DUPLA ESQUERDA");
          RD(atual.dir, true);
          RE(atual, false);
          continue;
        } 
        else if (atual.bal >= 2 && atual.esq != null && atual.esq.bal < 0) {
          System.out.println("ROTAÇÃO DUPLA DIREITA");
          RE(atual.esq, true);
          RD(atual, false);
          continue;
        } 
        else if (atual.bal <= -2) {
          RE(atual, false);
          continue;
        } 
        else if (atual.bal >= 2) {
          RD(atual, false);
          continue;
        }
      }
    } else {
      do {
        System.out.println("Verificar Remoção");
        if (atual.bal <= -2 && atual.dir != null && atual.dir.bal > 0) {
          System.out.println("ROTAÇÃO DUPLA ESQUERDA");
          RD(atual.dir, true);
          RE(atual, false);
          continue;
        } 
        else if (atual.bal >= 2 && atual.esq != null && atual.esq.bal < 0) {
          System.out.println("ROTAÇÃO DUPLA DIREITA");
          RE(atual.esq, true);
          RD(atual, false);
          continue;
        } 
        else if (atual.bal <= -2) {
          RE(atual, false);
          continue;
        } 
        else if (atual.bal >= 2) {
          RD(atual, false);
          continue;
        }

        if (atual.elem < atual.pai.elem) atual.pai.bal--;
        else atual.pai.bal++;
        if (atual.pai != null) {
          atual = atual.pai;
        } else {
          break;
        }
      } while (atual.bal == 0);
    }
  }


  public void insere(long valor) {
    No novo = new No(valor);
    tamanho++;

    if (root == null) root = novo;
    else  { 
      No atual = root;
      No anterior;
      while(true) {
        anterior = atual;
        novo.pai = anterior;
        if (valor <= atual.elem) {
          atual = atual.esq;
          if (atual == null) {
            anterior.esq = novo;
            anterior.bal++;
            verifica(anterior, 0);
            return;
          } 
        } 
        else { 
           atual = atual.dir;
           if (atual == null) {
             anterior.dir = novo;
             anterior.bal--;
             verifica(anterior, 0);
             return;
           }
        }
      }
    }
  }

  public No buscar(int valor) {
    if (root == null) return null;
    No atual = root;  
    while (atual.elem != valor) {
      if(valor < atual.elem ) atual = atual.esq; 
      else atual = atual.dir; 
      if (atual == null) return null; 
    } 
    return atual; 
  }

  public boolean remove(int valor) {
    if (root == null) return false;
    No atual = root;
    No pai = root;
    boolean filho_esq = true;
    tamanho--;
  
    while (atual.elem != valor) {
      pai = atual;
      if(valor < atual.elem ) { 
        atual = atual.esq;
        filho_esq = true;
      }
      else { 
        atual = atual.dir; 
        filho_esq = false; 
      }
      if (atual == null) return false;
    }
    
    if (atual.esq == null && atual.dir == null) {
      if (atual == root ) root = null;
      else if (filho_esq) {
        pai.esq = null;
        pai.bal--;
      } else {
        pai.dir = null;
        pai.bal++;
        atual = null;
    }
    }
    else if (atual.dir == null) {
       if (atual == root) root = atual.esq;
       else if (filho_esq) {
        pai.esq = atual.esq;
        if (atual.esq != null) {
          atual.esq.pai = pai;
        }
        atual = null;
        pai.bal--;
      } else {
        pai.dir = atual.esq;
        atual.esq.pai = pai;
        pai.bal++;
        atual = null;
      }
    }
    else if (atual.esq == null) {
      if (atual == root)
        root = atual.dir;
      else if (filho_esq) {
        pai.esq = atual.dir;
        pai.bal--;
      } else {
        atual.dir.pai = pai;
        atual.pai.dir = atual.dir;
        atual = null;
        pai.bal++;
      }
    }
    else {
      No sucessor = no_sucessor(atual);
      if (atual == root)
        root = sucessor;
      else if (filho_esq) {
        pai.esq = sucessor;
        sucessor.esq = atual.dir;
        sucessor.pai = pai;
        pai.bal--;
      } else {
        sucessor.pai = pai;
        pai.dir = sucessor;
        pai.bal++;
      }
      sucessor.esq = atual.esq;
    }
    verifica(pai, 1);
    return true;
  } 

  public No no_sucessor(No apaga) { 
     No paidosucessor = apaga;
     No sucessor = apaga;
     No atual = apaga.dir;

     while (atual != null) { 
       paidosucessor = sucessor;
       sucessor = atual;
       atual = atual.esq; 
     } 
     if (sucessor != apaga.dir) { 
       paidosucessor.esq = sucessor.dir; 
       sucessor.dir = apaga.dir; 
     }
     return sucessor;
  }
  
  public int height(No atual) {
     if(atual == null || (atual.esq == null && atual.dir == null))
       return 0;
     else {
   	if (height(atual.esq) > height(atual.dir))
   	   return ( 1 + height(atual.esq) );
   	else
	   return ( 1 + height(atual.dir) );
     }
  }

  public int depth(No atual) {
    if (atual == root)
      return 0;
    return 1 + depth(atual.pai);
  }

  public ArrayList<No> children(No atual, ArrayList<No> valores) {
    if (atual != null) {
      valores = children(atual.esq, valores);
      valores.add(atual);
      valores = children(atual.dir, valores);
    }
    return valores;
  }

  public void desenharArvore() {
    int linhas = height(root);
    int colunas = tamanho;
    No esquemaArvore[][] = new No[linhas + 1][colunas];
    ArrayList<No> valores = new ArrayList<No>();
    valores = children(root, valores);
    
    for (int i = 0; i < colunas; i++) {
      No valor = valores.get(i);
      esquemaArvore[depth(valor)][i] = valor;
    } 

    for (int i = 0; i < esquemaArvore.length; i++) {
      System.out.println();
      for (int j = 0; j < esquemaArvore[0].length; j++) {
        if (esquemaArvore[i][j] == null)
          System.out.print("\t\t");
        else if (esquemaArvore[i][j].elem > 9)
          System.out.print(esquemaArvore[i][j].elem + "[" + esquemaArvore[i][j].bal + "]");
        else
          System.out.print("\t\t" + esquemaArvore[i][j].elem + "[" + esquemaArvore[i][j].bal + "]");
      }
      System.out.println();
    }
  }
}