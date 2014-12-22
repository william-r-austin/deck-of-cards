/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards;

/**
 * Exception for when we try to deal a card from an empty deck.
 */
public class EmptyDeckException extends RuntimeException {
    public EmptyDeckException() {
        super("The deck of cards is empty.");
    }
}
