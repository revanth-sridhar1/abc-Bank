package abcBank;

public class LostStolenCard extends CustomerRequest {

	private int cardNo;
	private String cardType;
	private String response;
	
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
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
