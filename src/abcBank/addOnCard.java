package abcBank;

public class addOnCard extends CustomerRequest{

	private int acoountNo;
	private String custName;
	private String reqDate;
	private String cardname;
	private String response;
	public int getAcoountNo() {
		return acoountNo;
	}
	public void setAcoountNo(int acoountNo) {
		this.acoountNo = acoountNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request=request;
	}
	
}
