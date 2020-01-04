package abcBank;

public class ChequeBookRequest extends CustomerRequest{

	private int accountNo;
	private String custName;
	private String reqDate;
	private String cardName;
	private String reason;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String sattus) {
		this.status = sattus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request=request;
	}
	
	
}
