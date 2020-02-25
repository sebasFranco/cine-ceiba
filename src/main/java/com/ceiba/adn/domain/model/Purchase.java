package com.ceiba.adn.domain.model;

import java.util.Calendar;
import java.util.List;

import com.ceiba.adn.domain.constant.MovieTime;
import com.ceiba.adn.domain.constant.TicketValue;
import com.ceiba.adn.domain.exceptions.InvalidPurchaseTimeException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public Purchase() {
	}

	public Purchase(Long id, Long chair, Long idClient, int purchaseTime, int purchaseDay, double total) {
		super();
		this.id = id;
		this.chair = chair;
		this.idClient = idClient;
		this.purchaseTime = purchaseTime;
		this.purchaseDay = purchaseDay;
		this.total = total;
	}

	public Purchase(Long chair) {
		this.chair = chair;
	}

	public Long getId() {
		return id;
	}

	public Long getChair() {
		return chair;
	}

	public Long getIdClient() {
		return idClient;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

	public double getTotal() {
		return total;
	}

	public void validatePurchaseTime(int actualTime) {

		if (actualTime < MovieTime.MOVIE_TIME) {
			if (actualTime >= 7 && actualTime < 10) {
				this.total = TicketValue.INITIAL_VALUE * 0.5;
			} else if (actualTime >= 14 && actualTime < 18) {
				this.total = TicketValue.INITIAL_VALUE * 1.5;
			} else {
				this.total = TicketValue.INITIAL_VALUE;
			}
		} else {
			throw new InvalidPurchaseTimeException(
					"Solamente puede comprar boletas maximo hasta 1 hora antes de la funcion");
		}
		this.purchaseTime = actualTime;
	}

	public void validatePurchaseDay(int dayOfWeek) {

		List<Integer> dayList = List.of(Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		if (dayList.contains(dayOfWeek)) {
			this.total = this.total * 2;
		}
		this.purchaseDay = dayOfWeek;
	}

}
