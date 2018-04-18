package kyh.entity;

public class CashDrawOrder {
	private Long id_cash_draw_order; 
	private String fo_membercode;
	private int fo_status;
	
	public Long getId_cash_draw_order() {
		return id_cash_draw_order;
	}
	public void setId_cash_draw_order(Long id_cash_draw_order) {
		this.id_cash_draw_order = id_cash_draw_order;
	}
	public String getFo_membercode() {
		return fo_membercode;
	}
	public void setFo_membercode(String fo_membercode) {
		this.fo_membercode = fo_membercode;
	}
	public int getFo_status() {
		return fo_status;
	}
	public void setFo_status(int fo_status) {
		this.fo_status = fo_status;
	}
	
	
}
