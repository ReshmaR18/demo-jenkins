package com.example.demo;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "accountdetails")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "ownerName is a mandatory field")
	private String ownerName;
	@NotBlank(message = "city is a mandatory field")
	private String city;
	@NotBlank(message = "state is a mandatory field")
	private String state;
	@Pattern(regexp = "\\d{6}", message = "pin must be 6 digits")
	private String pin;
	private float balance;
	private float overdraftBalance;
	private ACCOUNTTYPE accountType;
	@CreationTimestamp
	private Date createdDate;
	private ACCOUNTSTATUS status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		if (pin.matches("\\d{6}")) {
			this.pin = pin;
		} else {
			throw new IllegalArgumentException("Pin must be 6 digits.");
		}
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = Math.max(balance, 0); //this will change value of balance to 0 ifyou enter negative value
	}

	public float getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(float overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}

	public ACCOUNTTYPE getAccountType() {
		return accountType;
	}

	public void setAccountType(ACCOUNTTYPE accountType) {
		this.accountType = accountType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public ACCOUNTSTATUS getStatus() {
		return status;
	}

	public void setStatus(ACCOUNTSTATUS status) {
		this.status = status;
	}
}
