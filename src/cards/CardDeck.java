/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of cards that can be manipulated in various ways.
 * @author cas
 * @param <T> 
 */
public class CardDeck<T extends Card> {

    private final List<T> deck;
    private static final Random shuffler = new Random();

    /**
     * Create a new deck of cards.
     */
    public CardDeck() {
        deck = new ArrayList<>();
    }

    /**
     * Add a card to the deck.
     * @param newCard 
     */
    public void addCard(T newCard) {
        deck.add(newCard);
    }

    /**
     * Get the size of the deck
     * @return how many cards are in the deck.
     */
    public int getDeckSize() {
        return deck.size();
    }

    /**
     * Standard Fisher-Yates shuffle for the deck of cards.
     */
    public void shuffle() {
        for(int i = getDeckSize() - 1; i > 0; i--) {
            int cardSwapIndex = shuffler.nextInt(i + 1);
            if(cardSwapIndex != i) {
                T swappedCard = deck.get(cardSwapIndex);
                T currentCard = deck.get(i);
                deck.set(i, swappedCard);
                deck.set(cardSwapIndex, currentCard);
            }
        }
    }

    /**
     * Deal a card, removing it from the deck. An exception is thrown if the
     * deck is empty, so the caller will always be responsible for checking
     * the size of the deck to make sure it is not empty before attempting to
     * deal a card.
     * @return a card from the deck
     */
    public T dealOneCard() {
        if(getDeckSize() < 1) {
            throw new EmptyDeckException();
        }
        
        T dealtCard = deck.remove(0);
        return dealtCard;
    }

    /**
     * Merge two decks of cards together. The other deck must not be null.
     * @param otherDeck 
     */
    public void merge(CardDeck<T> otherDeck) {
        while(otherDeck.getDeckSize() > 0) {
            T otherDeckCard = otherDeck.dealOneCard();
            addCard(otherDeckCard);
        }
    }
}
