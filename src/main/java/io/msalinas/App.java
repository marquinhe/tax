package io.msalinas;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Application main class.
 *
 */
public class App {

	private final static ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");

	public static void main(String[] args) {
		
		System.out.println(myResources.getString("app.initial.message"));

		String fileLocation = myResources.getString("sample.file.name");
		if (args.length > 0) {
			fileLocation = args[0];
		}
		
		EmployeeRowReader reader = new EmployeeRowReader(fileLocation);		
		System.out.println(myResources.getString("app.log.information.message"));

		Map<Integer, SlipDTO> maps = reader.readFileIntoMap();
		
		System.out.println();
		System.out.println(new StringBuilder("Total number of employees in list: ").append(maps.size()));
		System.out.println();
		

		// loop map
		for (Map.Entry<Integer, SlipDTO> entry : maps.entrySet()) {
			
			
			StringBuilder sb = new StringBuilder("  -");
			SlipDTO job = (SlipDTO) entry.getValue();
			System.out.println(new StringBuilder("Payslip number ").append(entry.getKey()).append(":"));
			
			//Output (name, pay period, gross income, income tax, net income, super):
			sb.append(job.getName()+",");
			sb.append(job.getPeriod()+",");
			sb.append(job.getMonthlyIncomeGross()+",");
			sb.append(job.getMonthlyIncomeTax()+",");
			sb.append(job.getMonthlyIncomeNet()+",");
			sb.append(job.getMonthlySuper());
			
			System.out.println(sb);
		}
		
	}
		

}
