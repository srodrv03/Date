import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public	class MainDate{
		
		public static void main(String arg[]){
		
		Date today,tomorrow;
		
		try {
			today = new Date(4, 3, 2017);
			tomorrow = new Date(15,3,2018);
			today.isSameYear(tomorrow);
			System.out.println("mes en el que estas "+today.RandomTriesForEqualDateWhile());
		
			
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		
	}
	}
