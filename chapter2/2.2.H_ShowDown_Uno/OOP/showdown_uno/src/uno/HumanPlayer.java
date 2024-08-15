package uno;

import java.util.Scanner;

import static java.lang.String.format;

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
    public Card showCard() {
        printCardSelections();
        int choice = in.nextInt();
        Card topCard = getUno().getCardStack().peek();
        if (isValidChoice(choice)) {
            Card choiceCard = getHand().getCards().get(choice);
            if (isValidCard(topCard, choiceCard)) {
                return getHand().getCards().remove(choice);
            }
        }
        return showCard();
    }

    private boolean isValidCard(Card topCard, Card choice) {
        return topCard.equalColor(choice)
                || topCard.equalNumber(choice);
    }

    private boolean isValidChoice(int choice) {
        return choice > 0 || choice < getHand().size();
    }

    private void printCardSelections() {
        System.out.println("Select the card to play: ");
        StringBuilder numbers = new StringBuilder();
        StringBuilder cards = new StringBuilder();

        for (int i=0; i<getHand().getCards().size(); i++) {
            String cardRepresentation = getHand().getCards().get(i).toString();
            numbers.append(format("%"+(-cardRepresentation.length())+"s", i)).append(" ");
            cards.append(cardRepresentation).append(" ");
        }

        System.out.println(numbers.toString().stripTrailing());
        System.out.println(cards.toString().stripTrailing());
    }
}
