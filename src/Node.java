
public class Node {

    public int value;
    private Node left;
    private Node right;
    private int altura;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right=null;
        this.altura = 0;
    }
    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "value=" + value + "";
    }


    public int getAltura() {
        
        return altura;
    }


    public void setAltura(int altura) {
        this.altura = altura;
    }

    


}

