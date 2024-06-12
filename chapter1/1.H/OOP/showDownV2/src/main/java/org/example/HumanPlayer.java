package org.example;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HumanPlayer extends Player {

    @Override
    public void nameHimself() {
        //CLI取名
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("P" + playerNumber + " Please name yourself: ");
            String name = scanner.nextLine();

            if (name != null && !name.trim().isEmpty()) {
                validInput = true;
                this.setName(name.trim());
            } else {
                System.out.println("Invalid input. Please enter a non-empty name.");
            }
        }

        System.out.println("You have named yourself: " + this.getName());
    }

    @Override
    protected Optional<Card> showCard() {
        //如果有玩家在換牌之後，發現沒有牌出了
        //此時該玩家可以不必出牌，並在此輪無法參與比大小決勝。
        if (hand.getCards().isEmpty() && !exchangeHands.isEmpty()) {
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
                    card = hand.getCards().remove(number);

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

    private void printHands() {
        String handDes = IntStream.range(0, hand.getCards().size())
                        .mapToObj(index -> (index + 1) + "." + hand.getCards().get(index))
                        .collect(Collectors.joining(", "));
        System.out.println("Please choose your showCard: " + handDes);
    }

    @Override
    protected Player chooseExchangee(List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        Player exchangee = null;

        while (!validInput) {
            System.out.println("Please choose a player (1 to 4), Can not choose myself, your number is: " + playerNumber);

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();

                if (number == playerNumber) {
                    System.out.println("Can not choose myself.");
                } else if (number >= 1 && number <= 4) {
                    Optional<Player> playerOpt = players.stream()
                            .filter(player -> player.playerNumber == number)
                            .findFirst();

                    if (playerOpt.isPresent()) {
                        exchangee = playerOpt.get();
                        validInput = true;
                        System.out.println("You have chosen player: P" + number);
                    } else {
                        System.out.println("No player found with number " + number);
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return exchangee;
    }
}
