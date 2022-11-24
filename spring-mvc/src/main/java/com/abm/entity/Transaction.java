package com.abm.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "account_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "txn_no")
	private int txnNo;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "date_time")
	private LocalDateTime dateAndTime;
	
	private String type;
	private double amoount;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "acc_no")
	private Account account;

	public int getTxnNo() {
		return txnNo;
	}

	public void setTxnNo(int txnNo) {
		this.txnNo = txnNo;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmoount() {
		return amoount;
	}

	public void setAmoount(double amoount) {
		this.amoount = amoount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
