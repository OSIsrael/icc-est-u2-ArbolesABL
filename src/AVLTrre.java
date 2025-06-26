public class AVLTrre {
    private Node root;
    public int peso;

    public AVLTrre() {
        this.root = null;
    }

    public void insert(int value) {
        System.out.println("Valor a insertar "+ value);
        root = insertRec(root, value);
        peso++;
    }

    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.getAltura();
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setAltura(1);
            System.out.println("Nodo insertado: "+newNode.getValue()+" balance al insertar= " +getBalance(newNode));
            return newNode;
        }
        if (value < node.getValue()) {
            // ME VOY A LA IZQUIERDA
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            // ME VOY A LA DERECHA
            node.setRight(insertRec(node.getRight(), value));
        }else{
            return node;
        }

        System.out.println("Nodo actual: "+node.getValue());


        // actualizar la altura de este ancestro node
        int altura = 1+Math.max(height(node.getLeft()),height(node.getRight()));
        node.setAltura(altura);
        System.out.println("\tAltura= "+node.getAltura());
        
        int balance = getBalance(node);
        System.out.println("\tBalance= "+balance);
        //Caso Izquierda - Izquierda
        if (balance>1 && value<node.getLeft().getValue()) {
            System.out.println("Rotacion Derecha");        
        }    
        // caso Derecha - Derecha
        if(balance<-1 && value > node.getRight().getValue()){
            System.out.println("Rotacion Izquierda");
        }
        // Caso Izquierda - Derecha
        if(balance>1 && value>node.getLeft().getValue()){
            System.out.println("Cambio");
            System.out.println("Rotacion  Derecha");
        }
        // Caso Derecha - Izquierda
        if(balance<-1 && value<node.getRight().getValue()){
            System.out.println("Cambio");
            System.out.println("Rotacion Izquierda");
        }
        return node;
    }

        public int getBalance(Node node){
            if (node == null)return 0;
            
            return height(node.getLeft()) - height(node.getRight());
        }
    

    
    public boolean eq() {
        return eqRec(root);
    }

    private boolean eqRec(Node node) {
        if (node != null) {
            if (getBalance(node) == 0 || getBalance(node) == -1
                    || getBalance(node) == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
