package common;

public enum Command {
	Connect { 
		@Override
		public String toString() {
			return "Connect";
		}
	},
	
	Disconnect {
		@Override
		public String toString() {
			return "Disconnect";
		}
	},
	
	DatabaseUpdate {
		@Override
		public String toString() {
			return "Database Update";
		}
	},
	
	DatabaseRead{
		@Override
		public String toString() {
			return "Database Read";
		}
	},
	
	DatabaseWrite {
		@Override
		public String toString() {
			return "Database Write";
		}
	};
}
