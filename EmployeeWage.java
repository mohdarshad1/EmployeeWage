import java.util.Scanner;

public class EmployeeWage {
	private  CompanyWage[] companyarray = new CompanyWage[5];
	private int noofcompanies=0;
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation\n");
		EmployeeWage employeewage=new EmployeeWage();
		employeewage.CompanyInfo();

	}

	public void CompanyInfo() {

		Scanner scanner = new Scanner(System.in);
		int choice=0;
		do {
		System.out.println("Please add Company Details(max 5 companies)");
		System.out.println("Enter your Company Name");
		String companyName = scanner.nextLine();
		System.out.println("Enter wage per Hour");
		int wagePerHour = scanner.nextInt();
		System.out.println("Enter no of working days per month");
		int noofWorkingDays = scanner.nextInt();
		System.out.println("Enter the no of max hours per month");
		int noofMaxHours = scanner.nextInt();
		System.out.println("Do ypu want to add more?\n"+"1. Yes\n"+"2. No\n"+"Enter your Choice");
		choice=scanner.nextInt();
		addCompany(companyName, wagePerHour, noofWorkingDays, noofMaxHours);
		scanner.nextLine();
		noofcompanies++;
		}while(choice==1&&noofcompanies<5);
		if(noofcompanies==5)System.out.println("Max number of companies reached");
		showWage();
		scanner.close();
	}
	
	public void addCompany(String companyName, int wagePerHour, int noofWorkingDays, int noofMaxHours) {
		
		companyarray[noofcompanies]=new CompanyWage(wagePerHour, noofWorkingDays, noofMaxHours, companyName);
		calcSalary(companyarray[noofcompanies]);
	}
	

	public void calcSalary(CompanyWage calcwage) {

		int fullDayHour;
		final int fullTime = 1;
		final int partTime = 2;
		int EmpWage = 0;
		int noofdays = 0;
		int noofhours = 0;
		int value;

		while (noofdays < calcwage.getNoofWorkingDays() && noofhours < calcwage.getNoofMaxHours()) {

			value = (int) ((Math.random() * 10) % 3);

			switch (value) {
			case fullTime: {
				fullDayHour = 8;
				break;
			}
			case partTime: {
				fullDayHour = 4;
				break;
			}

			default: {
				fullDayHour = 0;
				break;
			}
			}

			noofhours = noofhours + fullDayHour;
			noofdays = noofdays + 1;
			int wage = calcwage.getWagePerHour() * fullDayHour;
			EmpWage = EmpWage + wage;
		}

		calcwage.setTotalWage(EmpWage);
	}
	
	public void showWage() {
		for(int index=0;index<noofcompanies;index++) {
			System.out.println(companyarray[index]);
		}
	}

}

class CompanyWage {

	private int wagePerHour;
	private int noofWorkingDays;
	private int noofMaxHours;
	private String companyName;
	private int totalWage;

	

	public CompanyWage(int wagePerHour, int noofWorkingDays, int noofMaxHours, String companyName) {
		super();
		this.wagePerHour = wagePerHour;
		this.noofWorkingDays = noofWorkingDays;
		this.noofMaxHours = noofMaxHours;
		this.companyName = companyName;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(int wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	public int getNoofWorkingDays() {
		return noofWorkingDays;
	}

	public void setNoofWorkingDays(int noofWorkingDays) {
		this.noofWorkingDays = noofWorkingDays;
	}

	public int getNoofMaxHours() {
		return noofMaxHours;
	}

	public void setNoofMaxHours(int noofMaxHours) {
		this.noofMaxHours = noofMaxHours;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public int getTotalWage() {
		return totalWage;
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}

	@Override
	public String toString() {
		return "Total wage of " + companyName + " is " + totalWage;
	}

}
