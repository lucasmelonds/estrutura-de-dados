class Main {
  public static void main(String[] args) {
     VetorDuplaEncadeada V2 = new VetorDuplaEncadeada();
    
    System.out.println("Encadeada:");
    V2.insertAtRank(0, 1);
    V2.insertAtRank(1, 2);
    V2.insertAtRank(2, 3);
    V2.insertAtRank(3, 4);
    System.out.println(V2.elemAtRank(0));
    System.out.println(V2.elemAtRank(1));
    System.out.println(V2.elemAtRank(2));
    System.out.println(V2.elemAtRank(3));

    System.out.println();

    System.out.println("Mudando o elemento:");
    V2.replaceAtRank(3, 5);
    System.out.println(V2.elemAtRank(0));
    System.out.println(V2.elemAtRank(1));
    System.out.println(V2.elemAtRank(2));
    System.out.println(V2.elemAtRank(3));
    
    System.out.println();
    
    System.out.println("Removido:");
    System.out.println(V2.removeAtRank(3));

    System.out.println();

    System.out.println("Encadeada:");
    System.out.println(V2.elemAtRank(0));
    System.out.println(V2.elemAtRank(1));
    System.out.println(V2.elemAtRank(2));
    System.out.println(V2.elemAtRank(3));


    
    Vetor vetor = new Vetor(10);
    vetor.insertAtRank(0, 1);
    vetor.insertAtRank(1, 2);
    vetor.insertAtRank(2, 3);
    vetor.insertAtRank(3, 4);

    System.out.println("Vetor:");
    System.out.println(vetor.elemAtRank(0));
    System.out.println(vetor.elemAtRank(1));
    System.out.println(vetor.elemAtRank(2));
    System.out.println(vetor.elemAtRank(3));

    System.out.println();

    System.out.println("Mudando o elemento:");
    vetor.replaceAtRank(3, 5);
    System.out.println(vetor.elemAtRank(0));
    System.out.println(vetor.elemAtRank(1));
    System.out.println(vetor.elemAtRank(2));
    System.out.println(vetor.elemAtRank(3));

    System.out.println();
    
    System.out.println("Removido:");
    System.out.println(vetor.removeAtRank(3));

    System.out.println();
    
    System.out.println("Vetor:");
    System.out.println(vetor.elemAtRank(0));
    System.out.println(vetor.elemAtRank(1));
    System.out.println(vetor.elemAtRank(2));
    System.out.println(vetor.elemAtRank(3));

    System.out.println();
  }
}