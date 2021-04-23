import java.util.ArrayList;
import java.util.HashMap;

interface IEmpWageBuilder
{
        public void addCompany(String company, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);
        
        public void computeEmpWage();
        public int getTotalWage(String company);
}

class CompanyEmpWage
{
    // instance constants
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
    // instance variable
    int totalEmpWage;

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }
    
    @Override
    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalEmpWage + "\n";
    }
}

public class EmpWageBuilder {
    // class constants
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    
    ArrayList<CompanyEmpWage> companies;
    HashMap<String, Integer> totalEmpWages;
 
    //constructor
    public EmpWageBuilder()
    {
        companies = new  ArrayList<>();
        totalEmpWages = new HashMap<>();
    }

   public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
        totalEmpWages.put(companyName,0);
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType)
    {
        switch (empType)
        {
        case FULL_TIME:
            return 8;
        case PART_TIME:
            return 4;
        default:
            return 0;
        }
    }

    public void calculateTotalWage()
    {
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
        System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee");
        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "Workinghrs", "Wage", "Total working hrs");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(companyEmpWage.COMPANY_NAME, totalWage);
        return totalWage;
    }
    
    public int getTotalEmpWage(String companyName)
    {
    	return totalEmpWages.get(companyName);
    }
    
    public static void main(String args[])
    {
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
		empWageBuilder.addCompany("DMart", 200, 4, 20);
        empWageBuilder.addCompany("BigBazzar", 150, 4, 20);
        empWageBuilder.addCompany("More", 120, 4, 20);
        empWageBuilder.calculateTotalWage();
        String query = "BigBazzar";
        int totalWage = empWageBuilder.getTotalEmpWage(query);
        System.out.println("Total Employee Wage for " + query + " company is " + totalWage);
    }

}
