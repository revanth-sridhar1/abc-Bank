package abcBank;

public class DisputedTransaction extends CustomerRequest{

	private String custName;
	private String merhName;
	private int cardNo;
	private String dateOfTransaction;
	private int amtDisputed;
	private String reason;
	private String response;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMerhName() {
		return merhName;
	}
	public void setMerhName(String merhName) {
		this.merhName = merhName;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public int getAmtDisputed() {
		return amtDisputed;
	}
	public void setAmtDisputed(int amtDisputed) {
		this.amtDisputed = amtDisputed;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
