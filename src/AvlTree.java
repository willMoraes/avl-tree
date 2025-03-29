public class AvlTree {
  Nodo root = null;

  private int height(Nodo node) {
    return (node != null) ? node.getHeight() : -1;
  }

  private void updateHeight(Nodo node) {
    if (node != null) {
      // max pega o maior valor inteiro entre dois inteiros
      node.setHeight(Math.max(height(node.getRight()), height(node.getLeft())) + 1);
    }
  }

  public int balanceFactor(Nodo node) {
    if (node == null) {
      return 0;
    }

    return height(node.getRight()) - height(node.getLeft());
  }

  void insert(int value) {
    root = this.insert(value, this.root);
  }

  private Nodo insert(int value, Nodo current) {
    if (current == null) {
      return new Nodo(value);
    }

    if (value > current.getValue()) {
      current.setRight(this.insert(value, current.getRight()));
    } else if (value < current.getValue()){
      current.setLeft(this.insert(value, current.getLeft()));
    } else {
      return current;
    }

    updateHeight(current);

    return rebalance(current);
  }

  Nodo search(int value) {
    return this.search(value, root);
  }

  private Nodo search(int value, Nodo current) {
    if (current == null) {
      System.out.print(" ");
      return null;
    }

    if (value == current.getValue()) {
      System.out.print(" " + current.getValue());
      return current;
    } else if (value > current.getValue()) {
      System.out.print(" " + current.getValue());
      return search(value, current.getRight());
    } else {
      System.out.print(" " + current.getValue());
      return search(value, current.getLeft());
    }
  }

  void remove(int value) {
    root = this.remove(value, root);
  }

  private Nodo remove(int value, Nodo current) {
    if (current == null) {
      return current;
    }

    // navega recursivamente até encontrar o elemento que será excluído
    if (current.getValue() > value) {
      current.setLeft(remove(value, current.getLeft()));
    } else if (current.getValue() < value) {
      current.setRight(remove(value, current.getRight()));
    }

    // Podem haver 3 cenários:
    // a. node é uma folha
    // b. node tem somente um filho
    // c. node tem dois filhos

    // cenário a
    else if (current.getLeft() == null && current.getRight() == null) {
      if (current.getValue() == root.getValue()) root = null;
      current = null;
    }

    // cenário b
    else if (current.getRight() == null) {
      current = current.getLeft();
    }

    else if (current.getLeft() == null) {
      current = current.getRight();
    }

    // cenário c
    else {
      Nodo substitute = getSubstitute(current);
      current.setValue(substitute.getValue());
    }

    updateHeight(current);
    return rebalance(current);
  }

  // encontra o valor mais a direita da subárvore esquerda de toRemove
  // apos encontrá-lo, remove esse valor de sua posição original
  private Nodo getSubstitute(Nodo toRemove) {
    Nodo current = toRemove.getLeft();
    Nodo prev = toRemove;

    while (current.getRight() != null) {
      prev = current;
      current = current.getRight();
    }

    if (prev != toRemove) {
      prev.setRight(current.getLeft());
    } else {
      toRemove.setLeft(current.getLeft());
    }

    return current;
  }

  String printInOrder() {
    return this.printInOrder(root);
  }

  private String printInOrder(Nodo current) {
    if (current == null) return "";

    return this.printInOrder(current.getLeft()) + current.getValue() + " " + this.printInOrder(current.getRight());
  }

  String printPreOrder() {
    return this.printPreOrder(root);
  }

  private String printPreOrder(Nodo current) {
    if (current == null) return "";

    return current.getValue() + " " + this.printPreOrder(current.getLeft()) + this.printPreOrder(current.getRight());
  }

  String printPostOrder() {
    return this.printPostOrder(root);
  }

  private String printPostOrder(Nodo current) {
    if (current == null) return "";

    return this.printPostOrder(current.getLeft()) + this.printPostOrder(current.getRight()) + current.getValue() + " ";
  }

  void clean() {
    this.root = null;
  }

  private Nodo rotateRight(Nodo node) {
    Nodo leftChild = node.getLeft();

    node.setLeft(leftChild.getRight());
    leftChild.setRight(node);

    updateHeight(node);
    updateHeight(leftChild);

    return leftChild;
  }

  private Nodo rotateLeft(Nodo node) {
    Nodo rightChild = node.getRight();

    node.setRight(rightChild.getLeft());
    rightChild.setLeft(node);

    updateHeight(node);
    updateHeight(rightChild);

    return rightChild;
  }

  private Nodo rebalance(Nodo node) {
    if (node == null) {
      return node;
    }

    int bf = balanceFactor(node);
    Nodo left = node.getLeft();
    Nodo right = node.getRight();

    if (bf < -1 ) {
      if (balanceFactor(left) <= 0) {
        node = rotateRight(node);
      } else {
        node.setLeft(rotateLeft(left));
        node = rotateRight(node);
      }
    }

    if (bf > 1) {
      if (balanceFactor(right) >= 0) {
        node = rotateLeft(node);
      } else {
        node.setRight(rotateRight(right));
        node = rotateLeft(node);
      }
    }

    return node;
  }
}
