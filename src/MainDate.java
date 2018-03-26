
	class mainDate{
		
		public static void main(String arg[]){
		
		Date today,tomorrow;
		today = new Date(14,3,2018);
		tomorrow = new Date(15,3,2018);
		today.isSameYear(tomorrow);
		System.out.println(today.MonthLeft());
		System.out.println(today.getMonth());

	}
	}
