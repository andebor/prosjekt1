package model;

import java.util.Date;

public class modelReports {
		
		private int report_id;
		private String koie_name;
		private boolean status;
		private Date startdate;
		private Date enddate;
		private boolean smoke_detector;
		private boolean wood;
		private String remarks_of_defects;
		private boolean forgotten;
		private String comments;
		 

		public modelReports(int report_id, String koie_name, boolean status, Date startdate, Date enddate, boolean smoke_detector, 
				boolean wood, String remarks_of_defects, boolean forgotten, String comments){
			this.report_id = report_id;
			this.koie_name = koie_name;
			this.status = status;
			this.startdate = startdate;
			this.enddate = enddate;
			this.smoke_detector = smoke_detector;
			this.wood = wood;
			this.remarks_of_defects = remarks_of_defects;
			this.forgotten = forgotten;
			this.comments = comments;
		}

		public String getKoienam() {
			return koie_name;
		}

		public Date getStartdate() {
			return startdate;
		}

		public boolean getWood() {
			return wood;
		}


}
