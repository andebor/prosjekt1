
package model;
import java.util.Date;

/**
 * 
 * Class for storing data retrieved from the queries in database.DbReservations
 *
 */
public class ModelReservations {
	
	private int reservation_id;
	private String koieName;
	private Date startDate;
	private Date endDate;
	private String tenantName;
	private String tenantNumber;
	private String tenantEmail;
	/**
	 * Constructor for constructing one reservation.
	 * @param reservation_id 
	 * @param koie_name The koie name
	 * @param startdate The start date of the koie stay
	 * @param enddate The end date of the koie stay
	 * @param tenant_name Name of the tenant
	 * @param tenant_number The tenants cell phone number
	 * @param tenant_email The tenants email
	 */
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
	
	/**
	 * 
	 * @return The reservation id
	 */
	public int getReservationId(){
		return reservation_id;
	}
	
	/**
	 * 
	 * @return The koie name
	 */
	public String getKoieName() {
		return koieName;
	}
	/**
	 * 
	 * @return The start date of the koie stay
	 */
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 
	 * @return The end date of the koie stay
	 */
	
	public Date getEndDate(){
		return endDate;
	}
	
	/**
	 * 
	 * @return The name of the tenant
	 */
	public String getTenantName() {
		return tenantName;
	}
	
	/**
	 * 
	 * @return The tenants cell phone number
	 */
	public String getTenantNumber() {
		return tenantNumber;
	}
	
	/**
	 * 
	 * @return The tenants email
	 */
	public String getTenantEmail(){
		return tenantEmail;
	}
	
}