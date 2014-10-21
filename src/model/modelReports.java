package model;

import java.util.Date;

public class ModelReports {
		
		private int report_id;
		private String koieName;
		private boolean status;
		private Date startDate;
		private Date endDate;
		private boolean smoke_detector;
		private boolean wood;
		private String remarks_of_defects;
		private boolean forgotten;
		private String comments;
		private Date timeStamp;
		 

		public ModelReports(int report_id, String koie_name, boolean status, Date startdate, Date enddate, boolean smoke_detector, 
				boolean wood, String remarks_of_defects, boolean forgotten, String comments, Date timeStamp){
			this.report_id = report_id;
			this.koieName = koie_name;
			this.status = status;
			this.startDate = startdate;
			this.endDate = enddate;
			this.smoke_detector = smoke_detector;
			this.wood = wood;
			this.remarks_of_defects = remarks_of_defects;
			this.forgotten = forgotten;
			this.comments = comments;
			this.timeStamp = timeStamp;
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
		public boolean getWood() {
			return wood;
		}
		
		public boolean getStatus(){
			return status;
		}
		
		public Date getTimeStamp(){
			return timeStamp;
		}


}
