public class HeapArray {
  public int[] heap;
  public int size;
  public int capacidade;

  public HeapArray(int capacidade) {
    this.capacidade = capacidade;
    size = 0;
    heap = new int[capacidade + 1];
  }

  public int parent(int index) {
    return index / 2;
  }

  public int leftChild(int index) {
    return (2 * index);
  }

  public int rightChild(int index) {
    return (2 * index) + 1;
  }

  public void downHeap(int index) {
    int esq = leftChild(index);
    int dir = rightChild(index);
    int menor = index;
    if ((esq <= size) && (esq>0)) {
      if (heap[esq] < heap[menor]) {
        menor = esq;
      }
    }
    if ((dir <= size && (dir>0))) {
      if (heap[dir] < heap[menor]) {
        menor = dir;
      }
    }
    if (menor != index) {
      int aux;
      aux = heap[menor];
      heap[menor] = heap[index];
      heap[index] = aux;
      downHeap(menor);
    }
  }

  public void upHeap(int index) {
    int aux = heap[index];
    while (index > 0 && aux > heap[parent(index)]) {
      heap[index] = heap[parent(index)];
      index = parent(index);
    }
    heap[index] = aux;
  }

  public void decreaseKey(int index, int elem) {
    heap[index] = elem;
    while ((index > 1) && (heap[parent(index)] > heap[index])) {
      int aux;
      aux = heap[parent(index)];
      heap[parent(index)] = heap[index];
      heap[index] = aux;
      index = parent(index);
    }
  }

  public void insert(int elem) {
    size++;
    decreaseKey(size, elem);
  }

  public int removeMin() {
    int minm = heap[1];
    heap[1] = heap[size];
    size--;
    downHeap(1);
    return minm;
  }

  public int min() {
    return heap[1];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void print() {
    for (int i = 1; i <= size; i++) {
      System.out.print(heap[i]);
      System.out.println();
    }
  }
}