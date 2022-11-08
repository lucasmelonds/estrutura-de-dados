class Main {
  public static void main(String[] args) {
    Lista lista = new Lista(10);
    System.out.println("Array:");
    lista.insertFirst(1);
    lista.insertFirst(2);
    lista.insertFirst(3);
    lista.insertLast(4);
    lista.insertLast(5);
    lista.insertLast(6);
    //lista.insertBefore(1, 3);
    //lista.insertAfter(0, 4);
    System.out.println(lista.first());
    System.out.println(lista.last());
    //lista.mostra();

    System.out.println();
    
    ListaDL listadl = new ListaDL();
    System.out.println("Duplamente encadeada:");
    listadl.insertFirst(1);
    listadl.insertFirst(2);
    listadl.insertFirst(3);
    listadl.insertLast(4);
    listadl.insertLast(5);
    listadl.insertLast(6);
    System.out.println("Inicio:");
    System.out.println(listadl.first());
    System.out.println("Fim:");
    System.out.println(listadl.last());
    //System.out.println(listadl.remove(listadl.inicio));
    //System.out.println(listadl.elemAtRank(1));
  }
}

