package main.java.org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static main.java.org.example.Utils.printf;

public class HumanPlayer extends Player {
    private final static Scanner in = new Scanner(System.in);

    @Override
    public void nameHimself(int order) {
        printf("Input your name (P%d): ", order);
        String name = in.next();
        if (name.isEmpty()) {
            nameHimself(order);
        } else {
            setName(name);
        }
    }

    @Override
    protected Optional<Card> showCard() {
        //如果有玩家在換牌之後，發現沒有牌出了，此時該玩家可以不必出牌，並在此輪無法參與比大小決勝。
        if (hand.getCards().isEmpty() && exchangeHands != null) {
            return Optional.empty();
        }

        //CLI用數字選擇出哪張牌
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        Card card = null;
        boolean validInput = false;

        while (!validInput) {
            printHands();
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number >= 1 && number <= hand.getCards().size()) {
                    validInput = true;
                    card = hand.getCards().remove(number - 1);

                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + hand.getCards().size());
                    scanner.nextLine();
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and " + hand.getCards().size());
                scanner.nextLine();
            }
        }

        System.out.println("You have chosen card: " + card.toString());
        return Optional.of(card);
    }

    @Override
    protected boolean makeExchangeHandsDecision() {
        if (hasUsedExchangeHands) {
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        boolean invalidInput = false;

        while(!invalidInput) {
            System.out.println("Please make a decision to exchange hand, 1 is exchange, 0 is not exchange.");
            if (scanner.hasNextInt()) {
                String decicion = scanner.nextLine();
                invalidInput = true;
                return "1".equals(decicion);
            } else {
                System.out.println("Invalid input");
                return false;
            }

        }
        return false;
    }

    private void printHands() {
        String handDes = IntStream.range(0, hand.getCards().size())
                        .mapToObj(index -> (index + 1) + "." + hand.getCards().get(index))
                        .collect(Collectors.joining(", "));
        System.out.println("Please choose your showCard: " + handDes);
    }

    private String printAllPlayers(List<Player> players) {
        return players.stream()
                .map(player -> "ID:" + player.getId() + ",Name:" + player.getName())
                .collect(Collectors.joining(" , "));
    }

    @Override
    protected Player chooseExchangee(List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        Player exchangee = null;

        while (!validInput) {
            System.out.println("Please choose a player by ID (cannot choose yourself), " + printAllPlayers(players));
            if (scanner.hasNextInt()) {
                int chosenId = scanner.nextInt();
                scanner.nextLine();

                if (chosenId > 0 && chosenId <= players.size() && players.get(chosenId - 1) != this) {
                    exchangee = players.get(chosenId - 1);
                    validInput = true;
                    System.out.println("You have chosen an exchangee named: " + exchangee.getName());
                } else {
                    if (chosenId == this.getId()) {
                        System.out.println("Cannot choose myself.");
                    } else {
                        System.out.println("Invalid input. Please enter a valid player ID.");
                    }
                }
            } else {
                scanner.next();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return exchangee;
    }
}
