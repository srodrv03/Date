
	class Date {
		private int day, month, year;
		Date(int day,int month,int year){
		this.day = day;
		this.month = month;
		this.year = year;
		}
		int getYear(){
			return this.year;
		}
		
		int getMonth(){
			return this.month;
		}

		int getDay(){
			return this.day;
		}

		boolean isSameYear(Date aDate){
		if(this.year==aDate.getYear()){
			return true;
		}
		return false;
		}
		
		boolean isSameMonth(Date aDate){
		if(this.month==aDate.getMonth()){
			return true;
		}
		return false;
		}
		
		boolean isSameDay(Date aDate){
		if(this.day==aDate.getDay()){
			return true;
		}
		return false;
		}

		String getMonthName(){
		String name;
		switch(this.month){
			case 1:
				name = "Enero";
				break;
			case 2:
				name = "Febrero";
				break;
			case 3:
				name = "Marzo";
				break;
			case 4:
				name = "Abril";
				break;
			case 5:
				name = "Mayo";
				break;
			case 6:
				name = "Junio";
				break;
			case 7:
				name = "Julio";
				break;
			case 8:
				name = "Agosto";
				break;
			case 9:
				name = "Septiembre";
				break;
			case 10:
				name = "Octubre";
				break;
			case 11:
				name = "Noviembre";
				break;
			case 12:
				name = "Diciembre";
				break;
			default:
				name = "No existen mas de 12 meses";
			}
			return name;
		}
		
		boolean isDayOfMonthOk(){
		
			boolean ok;
				ok = false;
			switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(this.day<=31){
					ok = true;
				 }
			break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(this.day<=30){
					ok = true;
				 }
			break;
			case 2:
				if(this.day<=28){
					ok = true;
				 }
			break;
			}
			return ok;
		}
		String MonthLeft(){
			StringBuilder month;
			month=new StringBuilder();
			for(int i=this.month;i<=12;i++){
			this.month=i;
			month.append(this.getMonthName()+"	");
		}
	return month.toString();
	}
}
	
		
