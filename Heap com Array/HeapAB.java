class HeapAB {
  public No[] heap;
  public int tamanho;
  
  public HeapAB() { 
    heap = new No[10];
    tamanho = 0;
  }

  public void downheap(int i) {
    int l = 2 * i;
    int r = 2 * i + 1; 
    int small = i;     
    if(l<tamanho && heap[l].prior < heap[small].prior)
         small = l;
    if(r<tamanho && heap[r].prior < heap[small].prior)
         small = r;
    if(small!=i)
    {
        No temp = heap[i];
        heap[i] = heap[small];
        heap[small] = temp;
        downheap(small);
    }
}

  public void removeMin() {
    heap[1] = heap[--tamanho];
    heap[tamanho] = null;
    downheap(1);
}

  public void insert(int elem, int priority) {
    No node = new No(elem, priority);
    heap[tamanho++] = node;
    tamanho++;
    downheap(tamanho-1);
}

  public No min() {
    return heap[1];
  }

  public int size() {
    return tamanho;
  }

  public boolean isEmpty() {
    return tamanho == 0;
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
  
  public int filhos(No atual) {
    if(atual == null) return 0;
    if(atual.esq == null && atual.dir == null) return 1;
    return filhos(atual.esq) + filhos(atual.dir);
  }

  public void print() {
    for(int i=0;i<tamanho;i++) {
      No no = (No) heap[i];
      if(no!=null) {
        System.out.println(no.elem);
      }
    }
}
}