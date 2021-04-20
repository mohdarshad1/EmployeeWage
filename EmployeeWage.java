import java.util.Scanner;

public class EmployeeWage {


	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation\n");
		EmployeeWage emp=new EmployeeWage();
		emp.companyInfo();	
	} 
	
	public void companyInfo() {
		
		Scanner sc=new Scanner(System.in);
		 int wagePerHour;
		 int noofWorkingDays;
		 int noofMaxHours;
		 String companyName;
		 
		 System.out.println("Enter your Company Name");
		 companyName=sc.nextLine();
		 System.out.println("Enter Wage per Hour");
		 wagePerHour=sc.nextInt();
		 System.out.println("Enter no. of working days per mMnth");
		 noofWorkingDays=sc.nextInt();
		 System.out.println("Enter the no. of max hours per Month");
		 noofMaxHours=sc.nextInt();
		 calcSalary(companyName, wagePerHour, noofWorkingDays, noofMaxHours);
		 
	}

	public void calcSalary (String companyName, int wagePerHour, int noofWorkingDays,int noofMaxHours) {
		
		  	int fullDayHour;
			final int fullTime=1;
			final int partTime=2;
			int EmpWage=0;
			int noofdays=0;
			int noofhours=0;
			
			while (noofdays<noofWorkingDays && noofhours<noofMaxHours) {
				
				int value=(int)((Math.random()*10)%3);
				
				switch (value)
				{
				case fullTime: {
							fullDayHour=8;
							break;
				}
				case partTime: {
							fullDayHour=4;
							break;
				}
				
				default: {
							fullDayHour=0;
							break;
						}
				}
				
				noofhours=noofhours+fullDayHour;
				noofdays=noofdays+1;
				int wage=wagePerHour*fullDayHour;
				 EmpWage=EmpWage+wage;
			}
			
			System.out.println("Wage of the Employee for "+companyName+ " is "+EmpWage);
	}
	
}
