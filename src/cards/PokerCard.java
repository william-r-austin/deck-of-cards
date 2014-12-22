/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

/**
 * Models a standard poker card, where each card has a suit and a rank. Does
 * not support jokers.
 */
public class PokerCard implements Card {

    /**
     * 13 possible poker card ranks.
     */
    public enum Rank {

        Ace("A"), Two("2"), Three("3"), Four("4"), Five("5"),
        Six("6"), Seven("7"), Eight("8"), Nine("9"), Ten("10"),
        Jack("J"), Queen("Q"), King("K");

        private final String symbol;

        private Rank(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Rank symbol.
         * @return single character rank symbol
         */
        public String getSymbol() {
            return this.symbol;
        }

        /**
         * Rank name.
         * @return verbose name for the rank
         */
        public String getName() {
            return this.toString();
        }
    }

    /**
     * 4 possible poker card suits.
     */
    public enum Suit {

        Clubs("C"), Diamonds("D"), Hearts("H"), Spades("S");

        private final String symbol;

        private Suit(String symbol) {
            this.symbol = symbol;
        }

        /**
         * Suit symbol.
         * @return single character suit symbol
         */
        public String getSymbol() {
            return this.symbol;
        }
        
        /**
         * Suit Name.
         * @return verbose suit name
         */
        public String getName() {
            return this.toString();
        }
    }

    private final Rank rank;
    private final Suit suit;

    /**
     * Creates a poker card with the given suit and rank.
     * @param rank
     * @param suit 
     */
    public PokerCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    /**
     * Get the 2 character representation for the card. e.g. 8D
     * @return card symbol.
     */
    public String getSymbol() {
        return rank.getSymbol() + suit.getSymbol();
    }
    
    /**
     * Get the full card name. e.g. Eight of Diamonds
     * @return verbose identifier for the card
     */
    public String getName() {
        return rank.getName() + " of " + suit.getName();
    }
}
