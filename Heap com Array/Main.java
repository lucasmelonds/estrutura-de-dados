class Main {
  public static void main(String[] args) {
    HeapArray heap = new HeapArray(15);
    heap.insert(1);
    heap.insert(4);
    heap.insert(2);
    heap.insert(5);
    heap.insert(13);
    heap.insert(6);
    heap.insert(17);
    heap.print();

    System.out.println();

    System.out.println(heap.removeMin());

    System.out.println();

    heap.print();

    System.out.println();

    System.out.println(heap.min());

    System.out.println();

    HeapAB heapab = new HeapAB();

    heapab.insert(8, 3);
    heapab.insert(4, 2);
    heapab.insert(1, 5);
    heapab.insert(14, 1);
    heapab.insert(9, 4);

    heapab.print();

    System.out.println(heapab.min());

    System.out.println();

    heap.removeMin();

    heap.print();
  }
}