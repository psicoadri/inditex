package main;

public class UserMaxOrderData {

	    private long userId;
	    private long orderId;
	    private String name;
	    private String address;
	    private double total;
	    
	    
	    
		public UserMaxOrderData(long userId, long orderId, String name, String address, double total) {
			super();
			this.userId = userId;
			this.orderId = orderId;
			this.name = name;
			this.address = address;
			this.total = total;
		}
		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
		}
		public long getOrderId() {
			return orderId;
		}
		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}

	    
	}

