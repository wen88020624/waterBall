package uno;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        Card topCard = getUno().getCardStack().pop();
        List<Card> cardSelections = getHand().getCards().stream()
                .filter(card -> topCard.equalColor(card) || topCard.equalNumber(card))
                .toList();
        try {
            int choice = in.nextInt();
            if (choice < 0 || choice > getHand().size()) {
                showCard();
            }
            return

        } catch (InputMismatchException e) {
            showCard();
        }
    }

    private void printCardSelections() {
        System.out.println("Select the card to play: ");
        StringBuilder numbers = new StringBuilder();
        StringBuilder cards = new StringBuilder();

        for (int i=0; i<cardSelections.size(); i++) {
            String cardRepresentation = cardSelections.get(i).toString();
            numbers.append(format("%"+(-cardRepresentation.length())+"s", i)).append(" ");
            cards.append(cardRepresentation).append(" ");
        }

        System.out.println(numbers.toString().stripTrailing());
        System.out.println(cards.toString().stripTrailing());
    }
}
