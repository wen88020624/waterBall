package uno;

import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public class AI extends Player {
    private static final Random random = new Random();

    @Override
    public void nameSelf(int order) {
        setName(format("AI-%d", order));
    }

    @Override
    protected Card showCard() {
        Card topCard = getUno().getCardStack().peek();
        List<Card> validCardSelections = getHand().getCards().stream()
                .filter(c -> c.equalColor(topCard) || c.equalNumber(topCard))
                .toList();
        Card choice = validCardSelections.get(random.nextInt(validCardSelections.size()));
        int handIndex = getHand().getCards().indexOf(choice);
        return getHand().getCards().remove(handIndex);
    }

}
