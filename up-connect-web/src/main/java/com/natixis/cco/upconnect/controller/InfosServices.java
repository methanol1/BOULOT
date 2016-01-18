package com.natixis.cco.upconnect.controller;

import java.util.ArrayList;
import java.util.List;

import com.natixis.cco.upconnect.manager.VersionService;

public class InfosServices {

	List<VersionService> services;

	public List<VersionService> getServices() {
		return services;
	}

	public void setServices(List<VersionService> services) {
		this.services = services;
	}

	public void addInfoService(VersionService info) {
		if (null == services) {
			services = new ArrayList<VersionService>();
		}
		services.add(info);
	}

	@Override
	public String toString() {
		return "InfosServices [services=" + services + "]";
	}

}
