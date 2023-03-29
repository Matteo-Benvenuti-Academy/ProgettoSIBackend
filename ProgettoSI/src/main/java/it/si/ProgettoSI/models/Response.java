package it.si.ProgettoSI.models;

public class Response {
	
	public String status;
	public Object data;
	
	public Response(String status, Object data) {
		this.setStatus(status);
		this.setData(data);
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object obj) {
		this.data = obj;
	}

}
