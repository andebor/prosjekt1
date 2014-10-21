package model;
import java.util.Date;
public class ModelReservations {
	
	private int reservation_id;
	private String koie_name;
	private Date startdate;
	private Date enddate;
	private String tenant_name;
	private String tenant_number;
	private String tenant_epost;
	public ModelReservations(int reservation_id, String koie_name, Date startdate, Date enddate, String tenant_name, 
			String tenant_number, String tenant_epost){
		this.reservation_id = reservation_id;
		this.koie_name = koie_name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.tenant_name = tenant_name;
		this.tenant_number = tenant_number;
		this.tenant_epost = tenant_epost;
	}
	public String getKoiename() {
		return koie_name;
	}
	public Date getStartdate() {
		return startdate;
	}
	public String getTenantname() {
		return tenant_name;
	}
	
	public String getTenantepost(){
		return tenant_epost;
	}
	
}