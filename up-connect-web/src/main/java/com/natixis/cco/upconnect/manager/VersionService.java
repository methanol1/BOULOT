package com.natixis.cco.upconnect.manager;


public class VersionService<T> {

	private String versionUP;
	private String versionMiddleConnect;
	private Class<T> content;
	public String getVersionUP() {
		return versionUP;
	}
	public void setVersionUP(String versionUP) {
		this.versionUP = versionUP;
	}
	public String getVersionMiddleConnect() {
		return versionMiddleConnect;
	}
	public void setVersionMiddleConnect(String versionMiddleConnect) {
		this.versionMiddleConnect = versionMiddleConnect;
	}
	@Override
	public String toString() {
		return "VersionService [versionUP=" + versionUP
				+ ", versionMiddleConnect=" + versionMiddleConnect + "]";
	}
	public void setContent(Class<T> class1) {
		content = class1;
	}
	public Class<T> getContent(){
		return content;
	}
	
}
