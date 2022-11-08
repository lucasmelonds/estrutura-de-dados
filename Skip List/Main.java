class Main {
  public static void main(String[] args) {
    SkipList list = new SkipList();
    list.insert(15);
    list.insert(10);
    list.insert(5);
    list.insert(70);
    list.insert(55);
    list.insert(20);
    list.insert(60);
    list.insert(100);
    list.insert(50);
    list.insert(90);

    System.out.println("Lista Ordenada");
    list.print();
    
    System.out.println();

    System.out.println("Buscando elemento 10");
    SkipNode print = list.search(10);
    System.out.println(print.elem);

    System.out.println();

    System.out.println("Apagando elementos");
    list.remove(15);
    list.remove(5);
    list.remove(55);
    list.print();
  }
}