package com.example;

import rx.Observable;

public interface DeckCreator {
	
	/**
	 * Creates Cartesian product given sets of card values and suits
	 * Emits every card, but does not accumulate
	 * @param cardValues
	 * @param suits
	 * @return
	 */
	static Observable<Card> createCardDeck(Observable<String> cardValues, Observable<String> suits) {
		return cardValues.flatMap(cardValue -> {
			return suits.map(cardSuit -> {
				return new Card(cardValue, cardSuit);
			});
		});
	}

}
