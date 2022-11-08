class Main {
  public static void main(String[] args) {
    FilaVector F = new FilaVector();
    F.enqueue(7);
    F.enqueue(8);
    F.enqueue(9);
    System.out.println(F.first());
    System.out.println(F.dequeue());
    System.out.println(F.first());
  }
}