public	class Date {
		private int day, month, year;
		public Date(int day,int month,int year)throws DateException{
		// COMPRUEBO EL AÑO
		if(year < 1 ) {
			throw new DateException("Año " + year + " no valido" +" Valores posibles mayores que 0.");
		}else {
			this.year = year;
			}
		//COMPRUEBO EL MES
		if(month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +" Valores posibles entre 1 y 12.");
		}else {
			this.month = month;
			}
		//COMPRUEBO LOS DIAS
		if(day < 1 ) {
			throw new DateException("Dia " + day + " no valido" +" Valores posibles mayores de 0.");
		}else {
			this.day = day;
			}
		if(isDayOfMonthOk()==false){
			throw new DateException("La relacion Dia-Mes no es correcta");
		}else {
			this.day = day;
			}
		}
		
		public int getYear(){
			return this.year;
		}
		
		public int getMonth(){
			return this.month;
		}

		public int getDay(){
			return this.day;
		}
		
		
		//VER SI LOS AÑOS SON IGUALES
		public boolean isSameYear(Date aDate){
			if(this.year==aDate.getYear()){
				return true;
			}
		return false;
		}
		public boolean isSameYearNoIf(Date aDate){
			return this.year==aDate.getYear()?true:false;
		}

		//VER SI LOS MESES SON IGUALES
		public boolean isSameMonth(Date aDate){
			if(this.month==aDate.getMonth()){
				return true;
			}
		return false;
		}
		

		public boolean isSameMonthNoIf(Date aDate){
			return this.month==aDate.getMonth()?true:false;
		}

		//VER SI LOS DIAS SON IGUALES
		public boolean isSameDay(Date aDate){
			if(this.day==aDate.getDay()){
				return true;
			}
		return false;
		}

		public boolean isSameDayNoIf(Date aDate){
			return this.day==aDate.getDay()?true:false;
		}
		//COMPARA FECHA ENTERA
		public boolean isSame (Date aDate){
			if(this.isSameDay(aDate) && this.isSameMonth(aDate) && this.isSameYear(aDate)){
				return true;
			}
		return false;
		}
		
		public boolean isSameNoIf(Date aDate){
			return (this.isSameDay(aDate) && this.isSameMonth(aDate) && this.isSameYear(aDate))?true:false;
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
		public boolean isDayOfMonthOk(){
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
		
		//NUMERO DE DIAS DEL MES
		public int DayOfMonth(){
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
		public String MonthsLeft()throws DateException{
			StringBuilder monthsleft;
			monthsleft=new StringBuilder();
			Date auxiliar;
			auxiliar=new Date(this.day,this.month,this.year);
				for(int i=this.month+1; i<=12;i++){
					auxiliar.month=i;
					monthsleft.append(auxiliar.getMonthName()+"\n");
					
				}
			
		return monthsleft.toString();
		}

		//FECHAS HASTA FIN DE MES
		public String DayLeftOfMonth()throws DateException{
			StringBuilder daysleft;
			daysleft=new StringBuilder();
			Date auxiliar;
			int i=day;
			auxiliar=new Date(this.day,this.month,this.year);
				while(i<DayOfMonth()){
					auxiliar.day++;
					daysleft.append(auxiliar+"\n");
					i++;
				}
			
		return daysleft.toString();
		}

		//MESES CON LOS MISMOS DIAS
		public String MonthsWithSameDays()throws DateException{
			StringBuilder month;
			month =new StringBuilder();
			Date auxiliar;
			auxiliar=new Date(this.day,this.month,this.year);
				for ( int i = 1; i <= 12; i++) {
					auxiliar.month=i;
				if ((auxiliar.DayOfMonth() == this.DayOfMonth()) && (auxiliar.month!=this.month)){
					month.append(auxiliar.getMonthName()+"\n");
				}
				}
		return month.toString();
		}

		//IMPRIME FECHA
		public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
		}

		//dia desde inicio del año
		public int DaysPastOfYear()throws DateException{
			int resultado;
			resultado=0;
			Date auxiliar;
			auxiliar=new Date(1,1,this.year);
				for(int i=1;i<this.month;i++){
					resultado=resultado+auxiliar.DayOfMonth();
					auxiliar.month=i+1;
				}
		return resultado + this.day -1;
		}


		//INTENTOS PARA ACERTAR LA FECHA
		public int RandomTriesForEqualDateDoWhile()throws DateException{
			int intentos,d,m,y;
			intentos=0;
			do{
				m= (int)(Math.random()*12) +1;
				d= (int)(Math.random()*this.DayOfMonth()) +1;
				y= this.year;
				intentos++;	

			}while(!this.isSame(new Date(d,m,y)));
			
		return intentos;
		}
		public int RandomTriesForEqualDateWhile(){
			int intentos,d,m;
			intentos=0;
			boolean caso=false;
			while(caso==false){
				m= (int)(Math.random()*12) +1;
				d= (int)(Math.random()*this.DayOfMonth()) +1;
				intentos++;
				if(m==this.month && d==this.day){
					caso=true;
				}	
			}
		return intentos ;
		}

		//DICE LA ESTACION DEL AÑO
		public String getSeasonName(){
		String estacion = null;
		switch (this.month){
		case 1: 
		case 2: 
			estacion= "Invierno";
		break;
		case 3: 
			if(this.day<=21){	
				estacion = "Invierno";
			}else{
				estacion = "Primavera";
			}
		break;
		case 4: 
		case 5: 
			estacion= "Primavera";
		break;
		case 6: 
			if(this.day<=22){	
				estacion = "Primavera";
			}else{
				estacion = "Verano";
			}
		break;
		case 7: 
		case 8: 
			estacion= "Verano";
		break;
		case 9: 
			if(this.day<=24){	
				estacion = "Verano";
			}else{
				estacion = "Otoño";
			}
		break;
		case 10: 
		case 11: 
			estacion= "Otoño";
		break;
		case 12: 
			if(this.day<=22){	
				estacion = "Otoño";
			}else{
				estacion = "Invierno";
			}
		break;
		}
		return estacion;
	}
		
		//QUE DIA DE LA SEMANA ES
		public String DayOfWeek()throws DateException{
			String name_dia = null;
			int num_dia;
			Date auxiliar;
			auxiliar=new Date(this.day,this.month,this.year);
			num_dia=auxiliar.DaysPastOfYear()%7;
			switch(num_dia){
			case 0: 
				name_dia="Lunes";
			break;
			case 1: 
				name_dia="Martes";
			break;
			case 2: 
				name_dia="Miercoles";
			break;
			case 3: 
				name_dia="Jueves";
			break;
			case 4: 
				name_dia="Viernes";
			break;
			case 5: 
				name_dia="Sabado";
			break;
			case 6: 
				name_dia="Domingo";
			break;
			}
		return name_dia;
		}
}
	
	
		
