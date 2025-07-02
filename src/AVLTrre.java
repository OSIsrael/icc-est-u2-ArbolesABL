public class AVLTrre {
    private Node root;
    public int peso;

    public AVLTrre() {
        this.root = null;
    }

    public void insert(int value) {
        System.out.println("Valor a insertar " + value);
        root = insertRec(root, value);
        peso++;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getAltura();
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setAltura(1);
            System.out
                    .println("Nodo insertado: " + newNode.getValue() + " balance al insertar= " + getBalance(newNode));
            return newNode;
        }
        if (value < node.getValue()) {
            // ME VOY A LA IZQUIERDA
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            // ME VOY A LA DERECHA
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }

        System.out.println("Nodo actual: " + node.getValue());

        // actualizar la altura de este ancestro node
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setAltura(altura);
        System.out.println("\tAltura= " + node.getAltura());

        int balance = getBalance(node);
        System.out.println("\tBalance= " + balance);
        // Caso Izquierda - Izquierda
        // 1. Izquierda-Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotacion Derecha (Simple) en el nodo " + node.getValue());
            return rightRotate(node);
        }

        // 2. Derecha-Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotacion Izquierda (Simple) en el nodo " + node.getValue());
            return leftRotate(node);
        }

        // 3. Izquierda-Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Rotacion Izquierda-Derecha (Doble) en el nodo " + node.getValue());
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // 4. Derecha-Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Rotacion Derecha-Izquierda (Doble) en el nodo " + node.getValue());
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public int getBalance(Node node) {
        if (node == null)
            return 0;

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

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setAltura(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setAltura(1 + Math.max(height(x.getLeft()), height(x.getRight())));

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setAltura(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setAltura(1 + Math.max(height(y.getLeft()), height(y.getRight())));

        return y;
    }

    public void inOrderPrint() {
        inOrderPrintRec(root);
        System.out.println();
    }

    private void inOrderPrintRec(Node node) {
        if (node != null) {
            inOrderPrintRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderPrintRec(node.getRight());
        }
    }

}
