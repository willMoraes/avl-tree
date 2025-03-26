public class BinarySearchThreeTest {
  public static void successMessage(String message) {
      System.out.println("\u001B[32m" + message + "\u001B[0m");
  }

  public static void errorMessage(String message) {
      System.out.println("\u001B[31m" + message + "\u001B[0m");
  }

  public static void resetThree(BinarySearchThree searchThree) {
    searchThree.clean();

    searchThree.insert(50);
    searchThree.insert(20);
    searchThree.insert(5);
    searchThree.insert(15);
    searchThree.insert(10);
    searchThree.insert(9);
    searchThree.insert(12);
    searchThree.insert(17);
    searchThree.insert(16);
    searchThree.insert(2);
    searchThree.insert(70);
    searchThree.insert(60);
    searchThree.insert(25);
    searchThree.insert(30);
    searchThree.insert(33);
  }

  public static void testReset() {
    BinarySearchThree searchThree = new BinarySearchThree();

    resetThree(searchThree);

    if (searchThree.printInOrder().equals("2 5 9 10 12 15 16 17 20 25 30 33 50 60 70 ")) {
      successMessage("Árvore resetada com sucesso");
    } else {
      errorMessage("Erro ao resetar a árvore");
    }
  }

  public static void testInsert() {
    BinarySearchThree searchThree = new BinarySearchThree();

    searchThree.insert(50);
    searchThree.insert(20);
    searchThree.insert(5);
    searchThree.insert(15);
    searchThree.insert(10);
    searchThree.insert(9);
    searchThree.insert(12);
    searchThree.insert(17);
    searchThree.insert(16);
    searchThree.insert(2);
    searchThree.insert(70);
    searchThree.insert(60);
    searchThree.insert(25);
    searchThree.insert(30);
    searchThree.insert(33);

    if (searchThree.printInOrder().equals("2 5 9 10 12 15 16 17 20 25 30 33 50 60 70 ")) {
      successMessage("Elementos inseridos com sucesso");
    } else {
      errorMessage("Erro ao inserir elementos");
    }
  }

  public static void testRemove() {
    BinarySearchThree searchThree = new BinarySearchThree();

    searchThree.insert(50);
    searchThree.remove(50);

    if (searchThree.printInOrder().isEmpty()) {
      successMessage("Elemento removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento");
    }

    resetThree(searchThree);

    searchThree.remove(20);

    if (searchThree.printInOrder().equals("2 5 9 10 12 15 16 17 25 30 33 50 60 70 ")) {
      successMessage("Elemento 20 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 20");
      System.out.println("expected: " + "2 5 9 10 12 15 16 17 25 30 33 50 60 70" );
      System.out.println("received: " + searchThree.printInOrder());
    }

    searchThree.remove(5);

    if (searchThree.printInOrder().equals("2 9 10 12 15 16 17 25 30 33 50 60 70 ")) {
      successMessage("Elemento 5 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 5");
    }

    searchThree.remove(2);

    if (searchThree.printInOrder().equals("9 10 12 15 16 17 25 30 33 50 60 70 ")) {
      successMessage("Elemento 2 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 2");
    }

    searchThree.remove(17);

    if (searchThree.printInOrder().equals("9 10 12 15 16 25 30 33 50 60 70 ")) {
      successMessage("Elemento 17 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 17");
    }

    searchThree.remove(16);

    if (searchThree.printInOrder().equals("9 10 12 15 25 30 33 50 60 70 ")) {
      successMessage("Elemento 16 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 16");
    }

    searchThree.remove(33);

    if (searchThree.printInOrder().equals("9 10 12 15 25 30 50 60 70 ")) {
      successMessage("Elemento 33 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 33");
    }

    searchThree.remove(25);

    if (searchThree.printInOrder().equals("9 10 12 15 30 50 60 70 ")) {
      successMessage("Elemento 25 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 25");
    }

    searchThree.remove(70);

    if (searchThree.printInOrder().equals("9 10 12 15 30 50 60 ")) {
      successMessage("Elemento 70 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 70");
    }

    searchThree.remove(50);

    if (searchThree.printInOrder().equals("9 10 12 15 30 60 ")) {
      successMessage("Elemento 50 removido com sucesso");
    } else {
      errorMessage("Erro ao remover elemento 50");
    }
  }

  public static void testSearch() {
    BinarySearchThree searchThree = new BinarySearchThree();

    resetThree(searchThree);

    if (searchThree.search(50).getValue() == 50) {
      successMessage("Elemento 50 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 50");
    }

    if (searchThree.search(20).getValue() == 20) {
      successMessage("Elemento 20 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 20");
    }

    if (searchThree.search(5).getValue() == 5) {
      successMessage("Elemento 5 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 5");
    }

    if (searchThree.search(15).getValue() == 15) {
      successMessage("Elemento 15 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 15");
    }

    if (searchThree.search(10).getValue() == 10) {
      successMessage("Elemento 10 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 10");
    }

    if (searchThree.search(9).getValue() == 9) {
      successMessage("Elemento 9 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 9");
    }

    if (searchThree.search(12).getValue() == 12) {
      successMessage("Elemento 12 encontrado com sucesso");
    } else {
      errorMessage("Erro ao encontrar elemento 12");
    }
  }

  public static void main(String[] args) {
    testInsert();
    testSearch();
    testReset();
    testRemove();
  }
}
