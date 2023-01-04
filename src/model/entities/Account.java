package model.entities;

import model.exceptions.DomainExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withDrawLimit;
	}

	public void setWithdrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;  
	}
	
	public void withDraw(Double amount) {
		
		if (amount > balance) {
			throw new DomainExceptions("Not enough balance");
		}
		if (amount > withDrawLimit) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		
		balance -= amount;  
	}
	
	public String toString() {
		return String.format("%.2f", balance);
	}
}
