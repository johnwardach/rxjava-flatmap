package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import rx.Observable;

public class DeckCreatorTest {
	
	List<Card> deck = new ArrayList<Card>();

	@Test
	public void testCreateCardDeck() {
		Observable<String> suits = Observable
				.just("diamond", "spade", "club", "heart");
		
		Observable<String> values = Observable
				.from(new ArrayList<String>(Arrays.asList( "2", "3", "4", "5", "6", "7", "8", "9", "10","Jack","Queen", "King","Ace")));
		
		Observable<Card> deckObservable = DeckCreator.createCardDeck(values, suits);
		deckObservable.subscribe(card -> {
			System.out.println(card);
			deck.add(card);
		});
		
	
	}
	
	
	@After
	public void lastValueShouldBeThreeDollars() {
		assertTrue(deck.get(0).getValue().equals("2"));
		assertTrue(deck.get(0).getSuit().equals("diamond"));
		assertTrue(deck.get(1).getValue().equals("2"));
		assertTrue(deck.get(1).getSuit().equals("spade"));
		assertTrue(deck.get(2).getValue().equals("2"));
		assertTrue(deck.get(2).getSuit().equals("club"));
		assertTrue(deck.get(3).getValue().equals("2"));
		assertTrue(deck.get(3).getSuit().equals("heart"));
		
		/*
		 * could go on for all 52 cards
		 */
		
		assertTrue(deck.size()==52);
	}
	


}
