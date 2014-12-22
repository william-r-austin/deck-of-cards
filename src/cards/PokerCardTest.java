/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

/**
 * Perform some operations to test the poker deck implementation.
 */
public class PokerCardTest {
    
    public static void main(String args[]) {
        
        /**
         * Create a standard deck and deal all of the cards from it without
         * shuffling it first.
         */
        System.out.println("1. Standard Poker Deck.");
        CardDeck<PokerCard> testDeck = getStandardPokerDeck();
        while(testDeck.getDeckSize() > 0) {
            PokerCard dealtCard = testDeck.dealOneCard();
            System.out.println("The dealt card was: " + dealtCard.getSymbol() + " (" + dealtCard.getName() + ")");
        }
        
        /**
         * Create a standard deck and shuffle it before dealing all of the 
         * cards from it.
         */
        System.out.println("\n\n2. Shuffled Poker Deck.");
        testDeck = getStandardPokerDeck();
        testDeck.shuffle();
        while(testDeck.getDeckSize() > 0) {
            PokerCard dealtCard = testDeck.dealOneCard();
            System.out.println("The dealt card was: " + dealtCard.getSymbol() + " (" + dealtCard.getName() + ")");
        }
        
        /**
         * Create an empty poker deck. Verify that the shuffle operation is 
         * successful, but the deal card operation fails.
         */
        System.out.println("\n\n3. Empty Poker Deck.");
        testDeck = new CardDeck<>();
        testDeck.shuffle();
        try {
            PokerCard dealtCard = testDeck.dealOneCard();
            System.out.println("The dealt card was: " + dealtCard.getSymbol() + " (" + dealtCard.getName() + ")");
        } catch(EmptyDeckException ede) {
            System.out.print("Caught an empty deck exception while dealing cards.");
        }
        
        /**
         * Create a poker deck with one card and verify that the shuffle and 
         * deal operations are successful.
         */
        System.out.println("\n\n4. One Card Poker Deck.");
        testDeck = new CardDeck<>();
        testDeck.addCard(new PokerCard(PokerCard.Rank.Five, PokerCard.Suit.Diamonds));
        testDeck.shuffle();
        while(testDeck.getDeckSize() > 0) {
            PokerCard dealtCard = testDeck.dealOneCard();
            System.out.println("The dealt card was: " + dealtCard.getSymbol() + " (" + dealtCard.getName() + ")");
        }
        
        /**
         * Create a poker deck with two cards and verify that the shuffle and 
         * deal operations are successful.
         */
        System.out.println("\n\n5. Two Card Poker Deck.");
        testDeck = new CardDeck<>();
        testDeck.addCard(new PokerCard(PokerCard.Rank.Five, PokerCard.Suit.Diamonds));
        testDeck.addCard(new PokerCard(PokerCard.Rank.Jack, PokerCard.Suit.Clubs));
        testDeck.shuffle();
        while(testDeck.getDeckSize() > 0) {
            PokerCard dealtCard = testDeck.dealOneCard();
            System.out.println("The dealt card was: " + dealtCard.getSymbol() + " (" + dealtCard.getName() + ")");
        }
    }
    
    /**
     * Helper method for creating a standard 52 card poker deck.
     * @return poker deck
     */
    public static CardDeck<PokerCard> getStandardPokerDeck() {
        CardDeck<PokerCard> cardDeck = new CardDeck<>();

        for (PokerCard.Suit pokerCardSuit : PokerCard.Suit.values()) {
            for (PokerCard.Rank pokerCardRank : PokerCard.Rank.values()) {
                PokerCard pokerCard = new PokerCard(pokerCardRank, pokerCardSuit);
                cardDeck.addCard(pokerCard);
            }
        }

        return cardDeck;
    }
}
