import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    //System.out.println("Hello world!");
    
    ArvoreSimples simples = new ArvoreSimples(1);
		simples.addChild(simples.root(), 2);
		simples.addChild(simples.root(), 3);
		simples.addChild(simples.root(), 4);
		simples.addChild(simples.root(), 5);
		Iterator Filhos = simples.elements();
    
		System.out.println("Elementos da arvore:");
    
		while(Filhos.hasNext()){
			System.out.println(Filhos.next());
		}
    
    System.out.println("");
		System.out.println(simples.root().element());
  
  }
}