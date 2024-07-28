package showdown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private static final Scanner in = new Scanner(System.in);

    @Override
    public void nameSelf(int order) {
        System.out.printf("Input your name (P%d): ", order);
        String name = in.next();
        if (name.isEmpty()) {
            nameSelf(order);
        } else {
            setName(name);
        }
    }

    @Override
    protected Card showCard() {
        printCardSelections();
        try {
            int choice = in.nextInt();
            if (choice < 0 || choice >= getHand().size()) {
                return showCard();
            }
            return getHand().show(choice);
        } catch (InputMismatchException e) {
            return showCard();
        }
    }

    private void printCardSelections() {
        System.out.println("Select the card to play: ");
        StringBuilder numbers = new StringBuilder();
        StringBuilder cards = new StringBuilder();
        for (int i = 0; i < getHand().size(); i++) {
            String cardRepresentation = getHand().get(i).toString();
            numbers.append(String.format("%"+(-cardRepresentation.length())+"s", i)).append(" ");
            cards.append(cardRepresentation).append(" ");
        }

        System.out.println(numbers.toString().stripTrailing());
        System.out.println(cards.toString().stripTrailing());
    }
}
