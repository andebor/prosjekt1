package model;

import java.util.Date;

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
		 

		public ModelReports(int reportId, String koie_name, int status, Date startdate, Date enddate, boolean smoke_detector, 
				int wood, String remarks_of_defects, boolean forgotten, String comments, Date timeStamp){
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

		public String getKoieName() {
			return koieName.substring(0,1).toUpperCase() + koieName.substring(1);
		}

		public Date getStartDate() {
			return startDate;
		}
		
		public Date getEndDate(){
			return endDate;
		}
		public int getWood() {
			return wood;
		}
		
		public int getStatus(){
			return status;
		}
		
		public Date getTimeStamp(){
			return timeStamp;
		}
		
		public int getReportId(){
			return reportId;
		}
		
		public boolean getSmokeDetector(){
			return smokeDetector;
		}
		
		public String getDefects(){
			return remarksOfDefects;
		}
		
		public boolean getForgotten(){
			return forgotten;
		}
		
		public String getComments(){
			return comments;
		}


}
