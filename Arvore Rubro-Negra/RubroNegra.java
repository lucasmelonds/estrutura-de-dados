import java.util.ArrayList;

public class RubroNegra {
  public No root;
  public int tamanho;

  public RubroNegra() {
    this.root = null;
    this.tamanho = 0;
  }

  public void verificarInsercao(No atual) {
    if (atual != null && atual != this.root && atual.pai != this.root) {
      No pai = atual.pai != null ? atual.pai : null;
      No avo = atual.pai.pai != null ? atual.pai.pai : null;
      No tio = avo.elem > pai.elem ? atual.pai.pai.dir : atual.pai.pai.esq;
      boolean isRotacionarDir = avo.elem > pai.elem && pai.elem > atual.elem;
      boolean isRotacionarEsq = avo.elem < pai.elem && pai.elem < atual.elem;
      boolean isRotacionarDuplaEsq = avo.elem < pai.elem && pai.elem > atual.elem;
      boolean isRotacionarDuplaDir = avo.elem > pai.elem && pai.elem < atual.elem;
      if (pai != null && avo != null) {
        if (atual.cor == 1 && atual.cor == pai.cor && tio != null && tio.cor == 1) {
          avo.cor = 1;
          pai.cor = 0;
          tio.cor = 0;
        }
        else if (atual.cor == 1 && atual.cor == pai.cor && (tio == null || tio.cor == 0) && isRotacionarDir) {
          this.RD(avo, false);
          avo.cor = 1;
          pai.cor = 0;
        }
        else if (atual.cor == 1 && atual.cor == pai.cor && (tio == null || tio.cor == 0) && isRotacionarEsq) {
          this.RE(avo, false);
          avo.cor = 1;
          pai.cor = 0;
        }
        else if (atual.cor == 1 && atual.cor == pai.cor && (tio == null || tio.cor == 0) && isRotacionarDuplaEsq) {
          this.RD(pai, true);
          this.RE(avo, false);
          atual.cor = 0;
          avo.cor = 1;
          pai.cor = 1;
        }
        else if (atual.cor == 1 && atual.cor == pai.cor && (tio == null || tio.cor == 0) && isRotacionarDuplaDir) {
          this.RE(pai, true);
          this.RD(avo, false);
          atual.cor = 0;
          avo.cor = 1;
          pai.cor = 1;
        }
        this.verificarInsercao(atual.pai);
        this.root.cor = 0;
      }
    }
  }

  public void inserir(long elem) {
    No novo = new No(elem);
    novo.cor = 1;
    tamanho++;

    if (this.root == null) {
      novo.cor = 0;
      this.root = novo;
      this.root.cor = 0;
    } else {
      No atual = this.root;
      No anterior;
      while (true) {
        anterior = atual;
        novo.pai = anterior;
        if (elem <= atual.elem) {
          atual = atual.esq;
          if (atual == null) {
            anterior.esq = novo;
            this.verificarInsercao(novo);
            return;
          }
        } else {
          atual = atual.dir;
          if (atual == null) {
            anterior.dir = novo;
            this.verificarInsercao(novo);
            return;
          }
        }
      }
    }
  }

  public boolean remover(long v) {
    if (root == null)
      return false;

    No atual = root;
    No pai = root;
    boolean filho_esq = true;

    while (atual.elem != v) { 
      pai = atual; 
      if (v < atual.elem) {
        atual = atual.esq;
        filho_esq = true;
      } else {
        atual = atual.dir;
        filho_esq = false;
      }
      if (atual == null)
        return false; 
    }

    this.verificarRemocao(atual);

    if (atual.esq == null && atual.dir == null) { 
      if (atual == root) { 
        root = null;
      } else if (filho_esq) {
        pai.esq = null;
      } else {
        pai.dir = null;
        atual = null;
      }
    }

    else if (atual.dir == null) { 
      if (atual == root) {
        root = atual.esq;
      } else if (filho_esq) {
        pai.esq = atual.esq;
        if (atual.esq != null) {
          atual.esq.pai = pai;
        }
        atual = null;
      } else {
        pai.dir = atual.esq;
        atual.esq.pai = pai;
        atual = null;
      }
    }

    else if (atual.esq == null) { 
      if (atual == root)
        root = atual.dir;
      else if (filho_esq) {
        pai.esq = atual.dir;
      } else {
        atual.dir.pai = pai;
        atual.pai.dir = atual.dir;
        atual = null;
      }
    }

    else { 
      No sucessor = this.no_sucessor(atual);
      if (atual == root) {
        sucessor.esq = root.esq;
        sucessor.dir = root.dir;
        root.esq.pai = sucessor;
        root.dir.pai = sucessor;
        root = sucessor;
      } else if (filho_esq) {
        atual.esq.pai = sucessor;
        atual.dir.pai = sucessor;
        pai.esq = sucessor;
        sucessor.esq = atual.dir;
        sucessor.pai = pai;
      } else {
        sucessor.pai = pai;
        pai.dir = sucessor;
      }
      sucessor.esq = atual.esq;
      atual = null;
    }

    tamanho--;
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

  public void verificarRemocao(No atual) {
    No sucessor = this.no_sucessor(atual);
    boolean sitaucao2 = atual.cor == 0 && sucessor != null && sucessor.cor == 1;
    boolean situacao3 = atual.cor == 0 && (sucessor == null || sucessor.cor == 0);
    // Situação 2
    if (sitaucao2) {
      sucessor.cor = 0;
    }
    // Situação 3
    else if (situacao3) {
      No irmao = atual.pai.elem > atual.elem ? atual.pai.dir : atual.pai.esq;
      No sobrinhoEsq = irmao != null ? irmao.esq : null;
      No sobrinhoDir = irmao != null ? irmao.dir : null;
      boolean irmaoDir = atual.pai.elem > atual.elem ? true : false;
      // CASOS
      boolean caso1 = irmao != null && irmao.cor == 1 && atual.pai.cor == 0;

      boolean caso2a = (irmao == null || irmao.cor == 0) && (atual.pai == null || atual.pai.cor == 0)
          && ((sobrinhoEsq == null || sobrinhoEsq.cor == 0) && (sobrinhoDir == null || sobrinhoDir.cor == 0));

      boolean caso2b = (irmao == null || irmao.cor == 0) && (sobrinhoEsq == null || sobrinhoEsq.cor == 0)
          && (sobrinhoDir == null || sobrinhoDir.cor == 0) && (atual.pai != null && atual.pai.cor == 1);

      boolean caso3 = (irmao == null || irmao.cor == 0) && (sobrinhoDir == null || sobrinhoDir.cor == 0)
          && (sobrinhoEsq != null && sobrinhoEsq.cor == 1);

      boolean caso4 = (irmao == null || irmao.cor == 0) && (sobrinhoDir != null && sobrinhoDir.cor == 1);

      if (caso1) {
        irmao.cor = 0;
        if (irmaoDir)
          this.RE(atual.pai, false);
        else
          this.RD(atual.pai, true);
        atual.pai.cor = 1;
        caso2b = true;
      }
      if (caso2a) {
        if (irmao != null)
          irmao.cor = 1;
        if (atual.pai == this.root) {
          return;
        } else {
          this.verificarRemocao(atual.pai);
        }
      }
      if (caso2b) {
        irmao.cor = 1;
        atual.pai.cor = 0;
      }
      if (caso3) {
        this.RD(irmao, false);
        irmao.cor = 1;
        sobrinhoEsq.cor = 0;
        caso4 = true;
      }
      if (caso4) {
        irmao.cor = atual.pai.cor;
        atual.pai.cor = 0;
        sobrinhoDir.cor = 0;
        this.RE(atual.pai, false);
      }

    } else if (atual.cor == 1 && sucessor.cor == 0) {
      sucessor.cor = 1;
      situacao3 = true;
      this.verificarRemocao(sucessor.dir);
    }
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

  public No buscar(long chave) {
    if (root == null)
      return null;
    No atual = root;
    while (atual.elem != chave) {
      if (chave < atual.elem)
        atual = atual.esq;
      else
        atual = atual.dir;
      if (atual == null)
        return null;
    }
    return atual;
  }

  private String getNomeCor(int cor) {
    return cor == 1 ? "R" : "N";
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
          System.out.print("\t");
        else if (esquemaArvore[i][j].elem > 9)
          System.out.print(esquemaArvore[i][j].elem + "[" + getNomeCor(esquemaArvore[i][j].cor) + "]");
        else
          System.out.print("\t" + esquemaArvore[i][j].elem + "[" + getNomeCor(esquemaArvore[i][j].cor) + "]");
      }
      System.out.println();
    }
  }
}

