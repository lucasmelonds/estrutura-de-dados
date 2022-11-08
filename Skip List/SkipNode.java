public class SkipNode {
    public int elem;
 
    public SkipNode left;
    public SkipNode right;
    public SkipNode up;
    public SkipNode down;
 
    public SkipNode(int elem) {
        this.elem = elem;
        this.left = null;
        this.right = null;
        this.up = null;
        this.down = null;
    }
 
    public SkipNode(SkipNode menorLevel) {
        this.elem = menorLevel.elem;
        this.left = null;
        this.right = null;
        this.up = null;
        this.down = menorLevel;
    }
}