package abcBank;

public class IncreaseCreditLimit extends CustomerRequest{
	
	private String name;
	private String cardType;
	private int cardNo;
	private int currCreditLimit;
	private int maxCreditLimit;
	private int reqCreditLimit;
	private int appCreditLimit;
	private String response;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public int getCurrCreditLimit() {
		return currCreditLimit;
	}
	public void setCurrCreditLimit(int currCreditLimit) {
		this.currCreditLimit = currCreditLimit;
	}
	public int getMaxCreditLimit() {
		return maxCreditLimit;
	}
	public void setMaxCreditLimit(int maxCreditLimit) {
		this.maxCreditLimit = maxCreditLimit;
	}
	public int getReqCreditLimit() {
		return reqCreditLimit;
	}
	public void setReqCreditLimit(int reqCreditLimit) {
		this.reqCreditLimit = reqCreditLimit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAppCreditLimit() {
		return appCreditLimit;
	}
	public void setAppCreditLimit(int appCreditLimit) {
		this.appCreditLimit = appCreditLimit;
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
