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
    this.remove(value, root, null, true);
  }

  private void remove(int value, Nodo current, Nodo prev, boolean isInLeft) {
    // se o atual ainda não for o que deve ser removido
    // chama novamente o metodo recursivamente
    // verificaddo a direção que deve continuar buscando

    if (value != current.getValue()) {
      if (value > current.getValue()) {
        this.remove(value, current.getRight(), current, false);
      }

      else {
        this.remove(value, current.getLeft(), current, true);
      }

      return;
    }

    // se for a ser removido for uma folha
    if (current.getLeft() == null && current.getRight() == null) {
      if (current == root) {
        root = null;
      }

      else if (isInLeft) {
        prev.setLeft(null);
      }

      else prev.setRight(null);
    }

    // se o nó a ser removido só possua filho na direita
    else if (current.getLeft() == null & current.getRight() != null) {
      if (root == current) {
        root = current.getRight();
      }
      else if (isInLeft) {
        prev.setLeft(current.getRight());
      }
      else prev.setRight(current.getRight());
    }

    // se o nó a ser removido só possua filho na esquerda
    else if (current.getRight() == null & current.getLeft() != null) {
      if (root == current) {
        root = current.getLeft();
      }
      else if (isInLeft) {
        prev.setLeft(current.getLeft());
      }
      else prev.setRight(current.getLeft());
    }

    // se o nó a ser removido possui ambos filhos
    else {
      // Pega o maior elemento da subárvore a esquerda
      // e remove ele da sua posição original
      Nodo substitute = getSubstitute(current);

      if (root == current) {
        root = substitute;
      }
      else if (isInLeft) {
        prev.setLeft(substitute);
      }
      else {
        prev.setRight(substitute);
      }

      substitute.setLeft(current.getLeft());
      substitute.setRight(current.getRight());
    }
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
    return recursivePrintInOrder(root);
  }

  private String recursivePrintInOrder(Nodo current) {
    if (current == null) return "";

    return recursivePrintInOrder(current.getLeft()) + current.getValue() + " " + recursivePrintInOrder(current.getRight());
  }

  public void clean() {
    this.root = null;
  }
}
