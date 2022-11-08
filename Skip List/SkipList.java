import java.util.ArrayList;
import java.util.List;
 
public class SkipList {
    private SkipNode inicio;
    private SkipNode fim;
 
    public SkipList() {
        inicio = new SkipNode(Integer.MIN_VALUE);
        fim = new SkipNode(Integer.MAX_VALUE);
        inicio.right = fim;
        fim.left = inicio;
    }
 
    public SkipNode search(int elem) {
        SkipNode node = inicio;
        while (node != null) {
            while (node.right != null && node.right.elem <= elem ) {
                node = node.right;
            }
            if (node.elem == elem) {
                break;
            }
            node = node.down;
        }
        return node;
    }
 
    public boolean insert(int elem) {
        List<SkipNode> attLista = new ArrayList<>();
        SkipNode node = inicio;
        while (node != null) {
            while (node.right != null && node.right.elem < elem ) {
                node = node.right;
            }
            attLista.add(node);
            node = node.down;
        }
        int level = 0;
        SkipNode newnode = null;
        while (level == 0 || random()) {
            if (newnode == null) {
                newnode = new SkipNode(elem);
            } else {
                newnode = new SkipNode(newnode);
            }
            SkipNode attNode;
            if (attLista.size() <= level) {
                novoLevel();
                attNode = this.inicio;
            } else {
                attNode = attLista.get(attLista.size() - level - 1);
            }
            newnode.right = attNode.right;
            newnode.left = attNode;
            newnode.right.left = newnode;
            attNode.right = newnode;
            level++;
        }
        return true;
    }
 
    public boolean remove(int elem) {
        List<SkipNode> attLista = new ArrayList<>();
        SkipNode node = this.inicio;
        while (node != null) {
            while (node.right != null && node.right.elem < elem ) {
                node = node.right;
            }
            if (node.right.elem == elem) {
                attLista.add(node);
            }
            node = node.down;
        }
        for (int i = 0; i < attLista.size(); i++) {
            SkipNode attNode = attLista.get(i);
            SkipNode dltNode = attNode.right;
            attNode.right = dltNode.right;
            dltNode.right.left = attNode;
            dltNode.up = null;
            dltNode.down = null;
        }
        return true;
    }
 
    private void novoLevel() {
        SkipNode novoInicio = new SkipNode(Integer.MIN_VALUE);
        SkipNode novoFim = new SkipNode(Integer.MAX_VALUE);
        novoInicio.right = novoFim;
        novoFim.left = novoInicio;
        inicio.up = novoInicio;
        novoInicio.down = inicio;
        inicio = novoInicio;
        fim.up = novoFim;
        novoFim.down = fim;
        fim = novoFim;
    }
 
    private boolean random() {
        return Math.random() >= 0.5;
    }
 
    public void print() {
        SkipNode node = this.inicio;
        while (node.down != null) {
            node = node.down;
        }
        node = node.right;
        while (node.right != null) {
            System.out.print(node.elem + " ");
            node = node.right;
        }
        System.out.println();
    }
}