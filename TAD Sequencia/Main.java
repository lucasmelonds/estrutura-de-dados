class Main {
  public static void main(String[] args) {
    Sequencia seqdl = new Sequencia();
    System.out.println("Sequencia:");
    seqdl.insertFirst(2);
    seqdl.insertFirst(1);
    seqdl.insertLast(3);
    seqdl.insertLast(4);
    System.out.println(seqdl.elemAtRank(0));
    System.out.println(seqdl.elemAtRank(1));
    System.out.println(seqdl.elemAtRank(3));
    System.out.println(seqdl.last());
    
    System.out.println();
    
    seqdl.insertAtRank(2, 5);
    System.out.println(seqdl.elemAtRank(0));
    System.out.println(seqdl.elemAtRank(1));
    System.out.println(seqdl.elemAtRank(2));
    System.out.println(seqdl.elemAtRank(3));
    System.out.println(seqdl.last());
    
    System.out.println();
    
    seqdl.swapElements(seqdl.atRank(1), seqdl.atRank(2));
    System.out.println(seqdl.elemAtRank(0));
    System.out.println(seqdl.elemAtRank(1));
    System.out.println(seqdl.elemAtRank(2));
    System.out.println(seqdl.elemAtRank(3));
    System.out.println(seqdl.last());

    System.out.println();

    seqdl.remove(seqdl.first());
    System.out.println(seqdl.elemAtRank(0));
    System.out.println(seqdl.elemAtRank(1));
    System.out.println(seqdl.elemAtRank(2));
    System.out.println(seqdl.last());
    
    System.out.println();

    seqdl.insertAfter(seqdl.first(), 6);
    System.out.println(seqdl.elemAtRank(0));
    System.out.println(seqdl.elemAtRank(1));
    System.out.println(seqdl.elemAtRank(2));
    System.out.println(seqdl.last());
  }
}