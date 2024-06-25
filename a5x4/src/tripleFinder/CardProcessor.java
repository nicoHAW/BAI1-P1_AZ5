package tripleFinder;

import java.util.*;

import cards.Card.*;
import cards.*;

public class CardProcessor implements CardProcessor_I {
     
    //----- CONSTRUCTOR -----
    public CardProcessor() {
    }

    //----- METHODS -----
    @Override
    public Object process(Card card) {

        boolean testAusgabe = true;
        
        List<Card> cardList;
        Map<Rank, List> cardMap = new HashMap<>();
        
        
        
        
        
        Rank cardRank = card.getRank();
        
        if (cardMap.containsKey(cardRank)) {
            cardList.add(card);
        } else {
            cardList = new ArrayList<>();
            cardMap.put(cardRank, cardList);
        }
        cardList.add(card);

        
        if(testAusgabe) {
            System.out.println("cardListe = " + cardList);
            System.out.println("cardListe toString = " + cardList.toString());
            System.out.println("cardListe Index = " + cardList.size());
            System.out.println("cardMap = " + cardMap);
            System.out.println("cardMap String = " + cardMap.toString());
            System.out.println("cardMap Size = " + cardMap.size());
            System.out.println("cardMap Rank = " + cardMap.get(cardRank));
            
        }
       

        


                return null;
    }

    @Override
    public void reset() {

    }

    //----- Help Method -----


    //----- CONSTRUCTOR -----


}
