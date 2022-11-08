import java.util.ArrayList;

class ArvoreBinaria {
  private No root;
  public int tamanho;
  
  public ArvoreBinaria() { 
    root = null;
    tamanho = 0;
  } 

  public void insere(int valor) {
    No novo = new No(); 
    novo.elem = valor;
    novo.dir = null;
    novo.esq = null;
    novo.pai = null;
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
            return;
          } 
        } 
        else { 
           atual = atual.dir;
           if (atual == null) {
             anterior.dir = novo;
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
      else if (filho_esq) pai.esq = null;
           else pai.dir = null; 
    }
    else if (atual.dir == null) {
       if (atual == root) root = atual.esq;
       else if (filho_esq) pai.esq = atual.esq;
            else pai.dir = atual.esq; 
    }
    else if (atual.esq == null) {
       if (atual == root) root = atual.dir; 
       else if (filho_esq) pai.esq = atual.dir;
            else pai.dir = atual.dir;
    } else {
      No sucessor = no_sucessor(atual);
      if (atual == root) root = sucessor;
      else if(filho_esq) pai.esq = sucessor; 
           else pai.dir = sucessor; 
      sucessor.esq = atual.esq;
    }
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

  public void inOrder(No atual) {
    if (atual != null) {
      inOrder(atual.esq);
      System.out.print(atual.elem + " ");
      inOrder(atual.dir);
    }
  }
  
  public void preOrder(No atual) {
    if (atual != null) {
      System.out.print(atual.elem + " ");
      preOrder(atual.esq);
      preOrder(atual.dir);
    }
  }
  
  public void posOrder(No atual) {
    if (atual != null) {
      posOrder(atual.esq);
      posOrder(atual.dir);
      System.out.print(atual.elem + " ");
    }
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

  public int size(){
		return tamanho;
	}
	
	public boolean isEmpty(){
		return tamanho == 0;
	}

  public No leftChild(No no) {
		return no.esq;
	}
	
	public No rightChild(No no) {
		return no.dir;
	}
	
	public Boolean hasLeft(No no) {
		return no.esq != null;
	}
	
	public Boolean hasRight(No no) {
		return no.dir != null;
	}

  public No parent(No no) {
		return no.pai;
	}
		
	public Boolean isInternal(No no) {
		return no.dir != null || no.esq != null;
	}
	
	public Boolean isExternal(No no) {
		return (no.dir == null && no.esq == null);
	}
	
	public No root() {
		return root;
	}
  
	public Boolean isRoot(No no) {
		return no == root;
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

  public void lista() {
    System.out.print("Exibindo em ordem: ");
    inOrder(root);
    System.out.print("\nExibindo em pos-ordem: ");
    posOrder(root);
    System.out.print("\nExibindo em pre-ordem: \n");
    preOrder(root);
  }

  public void desenharArvore() { // Maior para o menor
    int linhas = height(root);
    int colunas = tamanho;
    long esquemaArvore[][] = new long[linhas + 1][colunas];
    ArrayList<No> valores = new ArrayList();
    valores = children(root, valores);
    
    for (int i = 0; i < colunas; i++) {
      No valor = valores.get(i);
      esquemaArvore[depth(valor)][i] = valor.elem;
    }

    for (int i = 0; i < esquemaArvore.length; i++) {
      System.out.println();
      for (int j = 0; j < esquemaArvore[0].length; j++) {
        if (esquemaArvore[i][j] == 0)
          System.out.print(" ");
        else if (esquemaArvore[i][j] > 9)
          System.out.print(esquemaArvore[i][j]);
        else
          System.out.print(" " + esquemaArvore[i][j]);
      }
      System.out.println();
    }
  }
}