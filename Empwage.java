//UseCase 7=> Refactor code to compute Employee Wage

class Empwage {

	public static final int isFullTime = 1;
	public static final int isPartTime = 2;
	public static final int wagePerHour = 20;
	public static final int workDayPerMonth = 20;
	public static final int workHourPerMonth = 100;
	
	public void computeWage(){
	
		int workHour = 0;
		int monthWage = 0;
		int workDay = 0;

		while(workHour < workHourPerMonth && workDay < workDayPerMonth){
			
			workDay++;		
			int check = (int)(Math.random()*3)+1;

			switch(check){
				case isFullTime:
					workHour = 8;
					break;

				case isPartTime:
					workHour = 4;
					break;
				default:
					workHour = 0;
					break;
			}
			int dailyWage = workHour * wagePerHour;
			monthWage = monthWage + dailyWage;
			System.out.println("wage of day "+workDay+" is:"+dailyWage);
		}
		System.out.println("Total Month wage is:"+monthWage);
	}
	public static void main(String[] args){
	
		Empwage obj = new Empwage();
		obj.computeWage();
	}
}
