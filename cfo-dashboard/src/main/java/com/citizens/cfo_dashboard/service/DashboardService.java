package com.citizens.cfo_dashboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizens.cfo_dashboard.repo.APInvoiceRepo;
import com.citizens.cfo_dashboard.repo.ARInvoiceRepo;

@Service
public class DashboardService {

	@Autowired
	private APInvoiceRepo apInvoiceRepo;

	@Autowired
	private ARInvoiceRepo arInvoiceRepo;

	@Transactional
	public List<Map<String, Object>> getReport(Integer ipid) {
		List<Map<String, Object>> response = new ArrayList<>();
		int arValue = arInvoiceRepo.findByIpId(ipid);
		int apValue = apInvoiceRepo.findByIpId(ipid);

		Map<String, Object> arMap = getArMap(arValue);
		Map<String, Object> apMap = getApMap(apValue);
		Map<String, Object> netCashMap = getNetCashMap(arValue - apValue);
		Map<String, Object> orderBookMap = getOrderBookMap();

		response.add(arMap);
		response.add(apMap);
		response.add(netCashMap);
		response.add(orderBookMap);

		return response;
	}

	private Map<String, Object> getApMap(int apValue) {
		Map<String, Object> apMap = new HashMap<String, Object>();
		apMap.put("name", "Accounts Payables");
		apMap.put("value", apValue);
		apMap.put("alerts", "This is the primary content of the panel.");
		return apMap;
	}

	private Map<String, Object> getArMap(int arValue) {
		Map<String, Object> arMap = new HashMap<String, Object>();
		arMap.put("name", "Accounts Receivables");
		arMap.put("value", arValue);
		arMap.put("alerts", "This is the primary content of the panel.");
		return arMap;
	}

	private Map<String, Object> getNetCashMap(int netCashValue) {
		Map<String, Object> ncMap = new HashMap<String, Object>();
		ncMap.put("name", "Net Cash");
		ncMap.put("value", netCashValue);
		return ncMap;
	}

	private Map<String, Object> getOrderBookMap() {
		Map<String, Object> ncMap = new HashMap<String, Object>();
		ncMap.put("name", "Order Book");
		ncMap.put("value", 12095800);
		return ncMap;
	}

}