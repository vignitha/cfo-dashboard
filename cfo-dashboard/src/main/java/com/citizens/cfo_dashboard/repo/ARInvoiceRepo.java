package com.citizens.cfo_dashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citizens.cfo_dashboard.model.ARInvoice;

public interface ARInvoiceRepo extends JpaRepository<ARInvoice, String> {

	@Query(value = "Select SUM(Total_Amt) from AR_Invoice where IP_ID = :ipId", nativeQuery = true)
	public Integer findByIpId(@Param("ipId") Integer ipId);

}