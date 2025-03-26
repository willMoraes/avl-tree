public class BinarySearchThree {
  Nodo root = null;

  public void insert(int value) {
    if (root == null) root = new Nodo(value);
    else this.insert(value, this.root);
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

  public Nodo search(int value) {
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

  public void remove(int value) {
    this.remove(value, root);
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

  public String printInOrder() {
    return this.printInOrder(root);
  }

  private String printInOrder(Nodo current) {
    if (current == null) return "";

    return this.printInOrder(current.getLeft()) + current.getValue() + " " + this.printInOrder(current.getRight());
  }

  public void clean() {
    this.root = null;
  }
}
