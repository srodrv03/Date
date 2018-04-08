import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public	class MainDate{
		
		public static void main(String arg[]){
		
		Date today,tomorrow;
		
		try {
			today = new Date(3, 2, 2017);
			tomorrow = new Date(15,3,2018);
			today.isSameYear(tomorrow);
			System.out.println("mes en el que estas "+today.getMonth());
			System.out.println("dias que quedan	"+today.DayLeftOfMonth());
			System.out.println("Meses que quedan	"+today.MonthsLeft());
			System.out.println("Meses qcon mismos dias	"+today.MonthsWithSameDays());
			System.out.println("Dias que han pasado desde el principio del año	"+today.DaysPastOfYear());
			System.out.println("en que estacion estamos 	"+today.getSeasonName());
			System.out.println("Dia de la semana	"+today.DayOfWeek());
			System.out.println("intentos para la fecha	"+today.RandomTriesForEqualDate2());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	}
