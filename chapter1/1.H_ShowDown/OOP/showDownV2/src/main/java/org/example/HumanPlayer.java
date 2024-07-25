package main.java.org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.List.of;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;
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
    protected Optional<ExchangeHands> makeExchangeHandsDecision() {
        printf("Would you like to perform hands exchange? (y/n): ");
        String answer = in.next().toLowerCase().trim();
        if (answer.equals("y")) {
            List<Player> players = showDown.getPlayers().stream()
                    .filter(p -> p != this)
                    .toList();
            return of(selectExchangeHandsTarget(players));
        } else {
            return empty();
        }
    }

    private ExchangeHands selectExchangeHandsTarget(List<Player> players) {
        printPlayerChoices(players);
        int targetIndex = in.nextInt();
        if (targetIndex >= players.size() || targetIndex < 0) {
            return selectExchangeHandsTarget(players);
        }
        return new ExchangeHands(this, players.get(targetIndex));
    }

    private void printPlayerChoices(List<Player> players) {
        printf("Select the target %s:",
                range(0, players.size())
                .mapToObj(i -> format("(%d) %s", i, players.get(i).getName()))
                        .collect(joining(" ")));
    }

    @Override
    protected Optional<Card> showCard() {
        //如果有玩家在換牌之後，發現沒有牌出了，此時該玩家可以不必出牌，並在此輪無法參與比大小決勝。
        if (hand.getCards().isEmpty() && exchangeHands != null) {
            return empty();
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
        String handDes = range(0, hand.getCards().size())
                        .mapToObj(index -> (index + 1) + "." + hand.getCards().get(index))
                        .collect(joining(", "));
        System.out.println("Please choose your showCard: " + handDes);
    }

    private String printAllPlayers(List<Player> players) {
        return players.stream()
                .map(player -> "ID:" + player.getId() + ",Name:" + player.getName())
                .collect(joining(" , "));
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
