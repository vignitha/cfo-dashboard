package com.citizens.cfo_dashboard.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ARInvoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2215277119395427370L;
	
	@Id
	private String invoiceId;
	

	private int ipId;
	private int totalAmount;

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getIpId() {
		return ipId;
	}

	public void setIpId(int ipId) {
		this.ipId = ipId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
