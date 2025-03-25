public class NodoOld
{
  private int value;
  public NodoOld left = null;
  public NodoOld right = null;

  public NodoOld(int value)
  {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void insert(int value) {
    if (value > this.value) {
      if (this.right == null) {
        this.right = new NodoOld(value);
        return;
      }

      this.right.insert(value);

      return;
    }

    if (value < this.value) {
      if (this.left == null) {
        this.left = new NodoOld(value);
        return;
      }

      this.left.insert(value);
    }
  }

  public void search(int value) {
    if (value == this.value) {
      System.out.println("Success to find: " + value);

      return;
    }

    if (value > this.value) {
      if (this.right == null) {
        System.out.println("Error to find: " + value);

        return;
      } else {
        this.right.search(value);

        return;
      }
    }

    if (this.left == null) {
      System.out.println("Error to find: " + value);
    } else {
      this.left.search(value);
    }
  }

  public void remove(int value) {
    recursiveRemove(value, this, null, true, true);
  }

  private void recursiveRemove(int value, NodoOld current, NodoOld prev, boolean isInLeft, boolean isRoot) {
    if (value != current.getValue()) {
      NodoOld direction = value > current.getValue() ? current.right : current.left;
      recursiveRemove(value, direction, current, value < current.getValue(), false);

      return;
    }

    // se for uma folha
    if (current.left == null && current.right == null) {
      if (isRoot) {
        // remove raiz
      }
      else if (isInLeft) {
        prev.left = null;
      }
      else prev.right = null;
    }

    // só tem filho na direita
    else if (current.left == null && current.right != null) {
      if (isInLeft) {
        prev.left = current.right;
      }
      else prev.right = current.right;
    }

    // só tem filho na esquerda
    else if (current.right == null && current.left != null) {
      if (isInLeft) {
        prev.left = current.left;
      }
      else prev.right = current.left;
    }

    // tem ambos filhos e precisa pegar o maior elemento da subárvore a esquerda
    else {
      NodoOld substitute = getLatestRight(value, current.left, current);
    }
  }

  public NodoOld getLatestRight(int value, NodoOld current, NodoOld prev) {
    if (current.right != null) return getLatestRight(value, current.right, current);

    if (current.left != null) {
      prev.right = current.left;
    } else prev.right = null;

    return current;
  }
}
