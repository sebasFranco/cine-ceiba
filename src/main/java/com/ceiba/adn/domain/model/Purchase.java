package com.ceiba.adn.domain.model;

import java.util.Calendar;
import java.util.List;

import com.ceiba.adn.domain.Exceptions.InvalidPurchaseTimeException;
import com.ceiba.adn.domain.constant.MovieTime;
import com.ceiba.adn.domain.constant.TicketValue;

public class Purchase {

	private Long id;
	private Long chair;
	private Long idClient;
	private int purchaseTime;
	private int purchaseDay;
	private double total;

	public Purchase() {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChair() {
		return chair;
	}

	public void setChair(Long chair) {
		this.chair = chair;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public int getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(int purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public int getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(int purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void validatePurchaseTime(int actualTime) {
		
		if (actualTime < MovieTime.MOVIE_TIME) {
			if (actualTime >= 7 && actualTime < 10) {
				this.setTotal(TicketValue.INITIAL_VALUE * 0.5);
			} else if (actualTime >= 14 && actualTime < 18) {
				this.setTotal(TicketValue.INITIAL_VALUE * 1.5);
			} else {
				this.setTotal(TicketValue.INITIAL_VALUE);
			}
		} else {
			throw new InvalidPurchaseTimeException("Solamente puede comprar boletas maximo hasta 1 hora antes de la funcion");
		}
	}

	public void validatePurchaseDay(int dayOfWeek) {

		List<Integer> dayList = List.of(Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		if (dayList.contains(dayOfWeek)) {
			this.setTotal(this.getTotal() * 2);
		}
	}

}
