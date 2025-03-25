public class Nodo
{
  private int value;
  private Nodo left = null;
  private Nodo right = null;

  public Nodo(int value)
  {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Nodo getLeft() {
    return left;
  }

  public Nodo getRight() {
    return right;
  }

  public void setLeft(Nodo left) {
    this.left = left;
  }

  public void setRight(Nodo right) {
    this.right = right;
  }
}
