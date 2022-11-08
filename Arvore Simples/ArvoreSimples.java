import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreSimples 
{
	//Atributos da arvore
	No raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new No(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da arvore */
	public No root()
	{
		return raiz;
	}
	/** Retorna o No pai de um No */
	public No parent(No v)
	{
		return (v.parent());
	}

	/** retorna os filhos de um No */
	public Iterator<Object> children(No v)
	{
		return v.children();
	}
	/** Testa se um No é interno */
	public boolean isInternal(No v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um No é externo*/
	public boolean isExternal(No v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um No é a raiz */
	public boolean isRoot(No v)
	{
		return v == raiz;
	}
	/** Adiciona um filho a um No */
	public void addChild(No v, Object o)
	{
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	}
	/** Remove um No
	 *  Só pode remover Nos externos e que tenham um pai (nao seja raiz)
	*/
	public Object remove(No v)
	{
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			System.out.println("Erro");
		Object o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posição */
	public void swapElements(No v, No w)
	{
		/*Metodo que serve de exercicio
		 * Este metodo devera fazer com que o objeto
		 * que estava na posicao v fique na posicaoo w
		 * e fazer com que o objeto que estava na posicaoo w
		 * fique na posicaoo v
		 */  
		Object aux = v.element(); 
		v.setElement(w.element());
		w.setElement(aux);
	}
	/** Retorna a profundidade de um No */
	public int depth(No v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(No v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da arvore */
	public int height()
	{
		// Metodo que serve de exercicio
		int altura = 0;
		return altura;
	}
	/** Retorna um iterator com os elementos armazenados na arvore */
	public Iterator<Object> elements()
	{
		// Metodo que serve de exercicio
		ArrayList<Object> v = new ArrayList<Object>();
		preOrderElement(v, raiz);
		return v.iterator();
	}
	/** Retorna um iterator com as posicoes (Nos) da arvore */
	public Iterator<Object> Nos()
	{
		// Metodo que serve de exercicio
		ArrayList<Object> v = new ArrayList<Object>();
		preOrderNo(v, raiz);
		return v.iterator();
	}
	/** Retorna o n�mero de Nos da arvore
	 */
	public int size()
	{
	 // Metodo que serve de exercicio
		return 0;
	}
	/** Retorna se a avore esta vazia. Sempre vai ser falso, pois nao permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(No v, Object o)
	{
	 // Metodo que serve de exercicio
		return null;
	}

  // Método para visitar os nós antes de seus descendentes
  public void preOrderElement(ArrayList<Object> v, No n){
		v.add(n.element());
		Iterator<No> i = n.children(); 
		while(i.hasNext()){
		preOrderElement(v, i.next());
		}
	}

  // Método para visitar os nós depois de seus descendentes
	public void preOrderNo(ArrayList<Object> v, No n){
		v.add(n);
		Iterator<No> i = n.children(); 
		while(i.hasNext()){
		preOrderElement(v, i.next());
		}
	}

}