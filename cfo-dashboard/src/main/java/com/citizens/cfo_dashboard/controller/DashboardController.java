package com.citizens.cfo_dashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citizens.cfo_dashboard.service.DashboardService;

@RestController
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/healthcheck")
	public String test() {
		return "Everything is Fine";
	}

	@GetMapping("/getreport/{ipid}")
	public List<Map<String, Object>> getReport(@PathVariable("ipid") Integer ipid) {
		List<Map<String, Object>> response = dashboardService.getReport(ipid);
		return response;

	}

}