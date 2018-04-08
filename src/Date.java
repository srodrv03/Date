

public	class Date {
		private int day, month, year;
		public Date(int day,int month,int year)throws DateException{
		// COMPRUEBO EL AÑO
		if (year < 1 ) {
			throw new DateException("Año " + year + " no valido" +" Valores posibles mayores que 0.");
		} else {
			this.year = year;
		}
		//COMPRUEBO EL MES
		if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +" Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
		//COMPRUEBO LOS DIAS
		if (day < 1 ) {
			throw new DateException("Dia " + day + " no valido" +" Valores posibles mayores de 0.");
		} else {
			this.day = day;
		}
		if (isDayOfMonthOk()==false){
			throw new DateException("La relacion Dia-Mes no es correcta");
		} else {
			this.day = day;
		}
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
		
		
		//VER SI LOS AÑOS SON IGUALES
		boolean isSameYear(Date aDate){
		if(this.year==aDate.getYear()){
			return true;
		}
		return false;
		}
		//VER SI LOS MESES SON IGUALES
		boolean isSameMonth(Date aDate){
		if(this.month==aDate.getMonth()){
			return true;
		}
		return false;
		}
		//VER SI LOS DIAS SON IGUALES
		boolean isSameDay(Date aDate){
		if(this.day==aDate.getDay()){
			return true;
		}
		return false;
		}

		boolean isSame (Date aDate){
		return this.isSameDay(aDate) && this.isSameMonth(aDate) && this.isSameYear(aDate);
		}
		//IMPRIME EL NOMBRE DEL MES
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
		//COMPRUEBA SI EL DIA PERTENECE AL MES
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
			int DayOfMonth(){
		
			int num_day;
				num_day=0;
			switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				num_day=31;
			break;
			case 4:
			case 6:
			case 9:
			case 11:
				num_day=30;
			break;
			case 2:
				num_day=28;
			break;
			}
			return num_day;
		}

		//ME DICE LOS MESES QUE QUEDAN
		String MonthsLeft(){
			StringBuilder monthsleft;
			monthsleft=new StringBuilder();
			Date auxiliar;
			try{
				auxiliar=new Date(this.day,this.month,this.year);
				for(int i=this.month+1; i<=12;i++){
					auxiliar.month=i;
					monthsleft.append(auxiliar.getMonthName()+"\n");
					
				}
			}catch (DateException e ){
				System.out.println(e.getMessage());
			}
		return monthsleft.toString();
		}

		//FECHAS HASTA FIN DE MES
		String DayLeftOfMonth(){
			StringBuilder daysleft;
			daysleft=new StringBuilder();
			Date auxiliar;
			try{
				int i=day;
				auxiliar=new Date(this.day,this.month,this.year);
				while(i<DayOfMonth()){
					auxiliar.day++;
					daysleft.append(auxiliar+"\n");
					i++;
				}
			}catch (DateException e ){
				System.out.println(e.getMessage());
			}
		return daysleft.toString();
		}
		//MESES CON LOS MISMOS DIAS
		String MonthsWhitSameDays(){
			StringBuilder month;
			month =new StringBuilder();
			Date auxiliar;
			try{
				auxiliar=new Date(this.day,this.month,this.year);
				for ( int i = 1; i <= 12; i++) {
					auxiliar.month=i;
				if ((auxiliar.DayOfMonth() == this.DayOfMonth()) && (auxiliar.month!=this.month)) {
					month.append(auxiliar.getMonthName() + "\n");
				}
				}
			}catch (DateException e ){
				System.out.println(e.getMessage());
			}
		return month.toString();
		}
		
		public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
		}
		//dia desde inicio del año
		int DaysPastOfYear(){
			int resultado;
			resultado=0;
			Date auxiliar;
			try{
				auxiliar=new Date(1,1,this.year);
				for(int i=1;i<this.month;i++){
				resultado=resultado+auxiliar.DayOfMonth();
					auxiliar.month=i+1;
				}
			}catch (DateException e ){
				System.out.println(e.getMessage());
			}
		return resultado + this.day -1;
		}



		int RandomTriesForEqualDate(){
		int intentos,d,m,y;
		intentos=0;
		try{
			do{
				m= (int)(Math.random()*12) +1;
				d= (int)(Math.random()*this.DayOfMonth()) +1;
				y= (int)(Math.random()*2018) +1;
				intentos++;	

			}while(new Date(d,m,y)!= this);
			}catch (DateException e ){
				System.out.println(e.getMessage());
			}
		return intentos;
		}

		
		String getSeasonName()throw DateException{
		String estacion = null;
		Date auxiliar;
		auxiliar=new Date(this.day,this.month,this.year);
		if((this.month==12 || this.month<=3) && ((this.month==12 && this.day>=21) ||(this.month==3 && this.day<=20))){
			estacion="invierno";
			}
		
		return estacion;
		}





}
	
	
		
