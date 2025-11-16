public class Ticket {
	private String ticketID;
	private String customerName;

	public Ticket(String ticketID, String customerName) {
		this.ticketID = ticketID;
		this.customerName = customerName;
	}

	public String getTicketID() {
		return ticketID;
	}

	public String getCustomerName() {
		return customerName;
	}

	@Override
	public String toString() {
		return ticketID + " (" + customerName + ")";
	}
}