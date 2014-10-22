package model;
import java.util.Date;
public class ModelReservations {
	
	private int reservation_id;
	private String koieName;
	private Date startDate;
	private Date endDate;
	private String tenantName;
	private String tenantNumber;
	private String tenantEmail;
	public ModelReservations(int reservation_id, String koie_name, Date startdate, Date enddate, String tenant_name, 
			String tenant_number, String tenant_email){
		this.reservation_id = reservation_id;
		this.koieName = koie_name;
		this.startDate = startdate;
		this.endDate = enddate;
		this.tenantName = tenant_name;
		this.tenantNumber = tenant_number;
		this.tenantEmail = tenant_email;
	}
	
	public int getReservationId(){
		return reservation_id;
	}
	
	public String getKoieName() {
		return koieName;
	}
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public String getTenantName() {
		return tenantName;
	}
	
	public String getTenantNumber() {
		return tenantNumber;
	}
	
	public String getTenantEmail(){
		return tenantEmail;
	}
	
}