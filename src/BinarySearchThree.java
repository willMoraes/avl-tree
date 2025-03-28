import static java.lang.Math.max;

public class BinarySearchThree {
  Nodo root = null;

  void insert(int value) {
    Nodo node = null;

    if (root == null) {
      root = new Nodo(value);
      node = root;
    } else {
      node = this.insert(value, this.root);
    };

    updateHeight(node);
    rebalance(node);
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

    return current;
  }

  Nodo search(int value) {
    return this.search(value, root);
  }

  private Nodo search(int value, Nodo current) {
    if (current == null) {
      System.out.println(" ");
      return null;
    }

    if (value == current.getValue()) {
      System.out.println(" " + value);
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
    Nodo node = this.remove(value, root);
    updateHeight(node);
    rebalance(node);
  }

  private Nodo remove(int value, Nodo current) {
    if (current == null) {
      return null;
    }

    else if (current.getValue() > value) {
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

    return current;
  }

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

    return leftChild;
  }

  private Nodo rotateLeft(Nodo node) {
    Nodo rightChild = node.getRight();

    node.setRight(rightChild.getLeft());
    rightChild.setLeft(node);

    return rightChild;
  }

  private int height(Nodo node) {
    return (node != null) ? node.getHeight() : -1;
  }

  private void updateHeight(Nodo node) {
    int leftHeight = node.getLeft() != null ? node.getLeft().getHeight() : -1;
    int rightHeight = node.getRight() != null ? node.getRight().getHeight() : -1;

    node.setHeight(max(rightHeight, leftHeight) + 1);
  }

  public int balanceFactor(Nodo node) {
    return height(node.getRight()) - height(node.getLeft());
  }

  private Nodo rebalance(Nodo node) {
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
