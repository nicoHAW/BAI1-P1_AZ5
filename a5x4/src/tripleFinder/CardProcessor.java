package tripleFinder;

import java.util.*;

import cards.Card.*;
import cards.*;

/**
 * CardProcessor takes Object of DataType Card and collects cards as long as there are three of the same Rank. 
 *@param Card - CardProcessors takes an Object of Datatype Card - no null allowed.
 *@return Returns an ArrayList<Card> holding three Cards of the same Rank in no specifical order.
 *@exception Returns error if given card is null. 
 *@method process(Card card) takes an objects of datatype Card and sorts it in a list until three of the same rank is reached - returns a ArrayList of the three cards.
 */
public class CardProcessor implements CardProcessor_I {
    // ----- FELD VARIABLES -----

    private Map<Rank, List> cardMap;

    //----- CONSTRUCTOR -----
    public CardProcessor() {
        this.cardMap = new HashMap<>();
    }


    //----- METHODS -----

    /**
     *process(Card card) takes an objects of data type Card and sorts it in a list until three of the same rank is reached - returns a ArrayList of the three cards.
     *@param Card - CardProcessors takes an Object of data type Card - no null allowed.
     *@return Returns an ArrayList<Card> holding three Cards of the same Rank in no specifical order.
     *@exception Returns error if given card is null. 
     */
    @Override
    public List<Card> process(Card card) {

        List<Card> cardList;

        //----- ASSERT -----
        assert card != null : "Bitte gültige Übergeben";


        //----- STATEMENTS -----
        Rank cardRank = card.getRank();        

        /* MapCheck
         * -----------
         * 1. Checks if cardMap contains a Key with cardRank of given Card. 
         * 1.1 No: Creates a new ArrayList with data type Card and puts it in cardMap connect to key cardRank.
         * 1.2 Yes: Asks for list connected to cardRank of given Card und sets it to a variable
         * 2. Adds card to the ArrayList
         * 
         * If cardMap doesn't has a Key with Current Rank create a new ArrayList and put
         * ArrayList with Key of current cardRank in HaspMap
         */
        if (!this.cardMap.containsKey(cardRank)) { 
            cardList = new ArrayList<Card>();
            this.cardMap.put(cardRank, cardList);            
        } else {
            cardList = this.cardMap.get(cardRank);
        } //if else

        cardList.add(card);

        // Drilling Check
        // ----------
        if (cardList.size() == 3) {    
            return cardList;
        } return null;

    } // method

    // CLEAR
    @Override
    public void reset() {
        this.cardMap.clear();   
    } //reset


}
