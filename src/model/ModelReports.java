package model;

import java.util.Date;
/**
 * 
 * Class for storing data retrieved from the queries in database.DbReports
 *
 */
public class ModelReports {

	private int reportId;
	private String koieName;
	private int status;
	private Date startDate;
	private Date endDate;
	private boolean smokeDetector;
	private int wood;
	private String remarksOfDefects;
	private boolean forgotten;
	private String comments;
	private Date timeStamp;
	
	/**
	 * Constructor for constructing one report
	 * @param reportId 
	 * @param koie_name The koie name
	 * @param status The status of the report. Tells us whether everything is okay, something is forgotten, or
	 *  some equipment is broken/missing
	 * @param startdate The start date of the koie stay
	 * @param enddate The end date of the koie stay
	 * @param smoke_detector Whether or not the smoke detector is working
	 * @param wood How much wood there is left
	 * @param remarks_of_defects String of equipment that is missing/not working separated with a comma
	 * @param forgotten Tells us if something is forgotten
	 * @param comments Comments on what is forgotten/random comments
	 * @param timeStamp Time of report delivery.
	 */
	public ModelReports(int reportId, String koie_name, int status,
			Date startdate, Date enddate, boolean smoke_detector, int wood,
			String remarks_of_defects, boolean forgotten, String comments,
			Date timeStamp) {
		this.reportId = reportId;
		this.koieName = koie_name;
		this.status = status;
		this.startDate = startdate;
		this.endDate = enddate;
		this.smokeDetector = smoke_detector;
		this.wood = wood;
		this.remarksOfDefects = remarks_of_defects;
		this.forgotten = forgotten;
		this.comments = comments;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * 
	 * @return The koie name
	 */
	public String getKoieName() {
		return koieName.substring(0, 1).toUpperCase() + koieName.substring(1);
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
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 
	 * @return How much wood remaining
	 */
	public int getWood() {
		return wood;
	}
	
	/**
	 * 
	 * @return General status of the koie
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * 
	 * @return Time when the report was delivered
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * 
	 * @return The report ID
	 */
	public int getReportId() {
		return reportId;
	}
	
	/**
	 * 
	 * @return Whether the smoke detector worked or not
	 */
	public boolean getSmokeDetector() {
		return smokeDetector;
	}
	/**
	 * 
	 * @return String of defects on equipmentS
	 */
	public String getDefects() {
		return remarksOfDefects;
	}

	/**
	 * 
	 * @return If something is forgotten or not
	 */
	public boolean getForgotten() {
		return forgotten;
	}
	
	/**
	 * 
	 * @return Additional comments
	 */
	public String getComments() {
		return comments;
	}

}
