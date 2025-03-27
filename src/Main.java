import java.util.Scanner;

class InstructionHandler {
  public void print() {
    System.out.println("Bem vindo ao sistema de árvore binária!");
    System.out.println("Operações disponíveis: ");
    System.out.println("i - Inserir");
    System.out.println("r - Remover");
    System.out.println("b - Buscar");
    System.out.println("pre - Pré Ordem");
    System.out.println("em - Em Ordem");
    System.out.println("pos - Pós Ordem");
    System.out.println("stop - Encerrar programa");
    System.out.println();
    System.out.println("======================================");
    System.out.println();
    System.out.println("Exemplo de uso:");
    System.out.println("Para inserir o valor 5, digite: i 5");
    System.out.println("Para remover o valor 5, digite: r 5");
    System.out.println("Para buscar o valor 5, digite: b 5");
    System.out.println("Para encerrar o programa, digite: stop");
    System.out.println();
    System.out.println("*Lembre-se de adicionar um espaço em branco entre a instrução e o valor.");
    System.out.println();
    System.out.println("======================================");
    System.out.println();
    System.out.println("Digite a operação desejada: ");
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    InstructionHandler InstructionHandler = new InstructionHandler();
    BinarySearchThree tree = new BinarySearchThree();

    InstructionHandler.print();

    while ( scanner.hasNext() ) {
      String operation = "";
      int value = 0;

      try {
        operation = scanner.next();
        value = scanner.nextInt();
      } catch (Exception e) {
        System.out.println("Operação inválida, tente novamente!");
      }

      switch ( operation ) {
        case "i":
          try {
            Integer.parseInt(String.valueOf(value));
          } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
            break;
          }

          System.out.println("Inserindo " + value);
          tree.insert(value);
          System.out.println("Valor inserido com sucesso!");
          System.out.println("In Order: " + tree.printInOrder());
          break;
        case "r":
          try {
            Integer.parseInt(String.valueOf(value));
          } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
            break;
          }

          System.out.println("Removendo " + value);
          tree.remove(value);
          System.out.println("Valor removido com sucesso!");
          System.out.println("In Order: " + tree.printInOrder());
          break;
        case "b":
          System.out.println("Buscando " + value);
          System.out.println(tree.search(value) != null ? "Valor encontrado!" : "Não encontrado!");
          break;
        case "pre":
          System.out.println("Pre Order: " + tree.printPreOrder());
        case "em":
          System.out.println("In Order: " + tree.printInOrder());
        case "pos":
          System.out.println("Post Order: " + tree.printPostOrder());
          return;
        case "stop":
          return;
        default:
          System.out.println("Operação inválida, tente novamente!");
      }
    }
    scanner.close();
  }
}
