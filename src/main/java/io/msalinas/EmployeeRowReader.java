package io.msalinas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class EmployeeRowReader {

	final static Logger logger = Logger.getLogger(EmployeeRowReader.class);

	private String fileLocation;

	public EmployeeRowReader(String inFileLocation) {
		this.fileLocation = inFileLocation;
		System.out.println(new StringBuilder("Reading rows from: ")
				.append(fileLocation));
	}

	public Map<Integer, SlipDTO> readFileIntoMap() {
		BufferedReader br = null;
		String line = "";
		Map<Integer, SlipDTO> maps = new HashMap<Integer, SlipDTO>();

		try {
			int validRowIndex = 0;
			int i = 0;
			br = new BufferedReader(new FileReader(this.fileLocation));
			while ((line = br.readLine()) != null) {

				// use comma as separator and remove spaces
				// Input (first name, last name, annual salary, super rate (%),
				// payment start date):
				
				line =  line.replace("%", "");
				String[] row = line.split("\\s*,\\s*");

				i++;
				if (validateLine(row)) {
					validRowIndex++;
					SlipDTO employeePayslip = assignStrategy(row[0], row[1],
							Integer.parseInt(row[2]),
							Double.parseDouble(row[3]), row[4]);
					maps.put(new Integer(validRowIndex), employeePayslip);
				} else {
					logger.info(new StringBuilder("Invalid row in line: ")
							.append(i));
				}

			}

		} catch (FileNotFoundException e) {
			logger.error("File not found.");
			System.out.println("File not found");
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Could not close buffered reader.");
				}
			}
		}
		return maps;
	}

	/**
	 * Assign strategy to use.
	 * 
	 * @param first name
	 * @param last name
	 * @param annual salary
	 * @param superannuation rate
	 * @return the strategy instantiated.
	 * 
	 *         Input (first name, last name, annual salary, super rate (%),
	 *         payment start date):
	 */

	private SlipDTO assignStrategy(String first, String last, int salary,
			double superAnnuation, String start_date) {

		// Default
		 SlipDTO slip = new SlipDTO(new TaxTier0(first, last, salary, superAnnuation, start_date));
		 
		 if (isTier1(salary)) {
			 slip = new SlipDTO(new TaxTier1(first, last, salary, superAnnuation, start_date));

		} else if (isTier2(salary)) {
			 slip = new SlipDTO(new TaxTier2(first, last, salary, superAnnuation, start_date));

		} else if (isTier3(salary)) {
			 slip = new SlipDTO(new TaxTier3(first, last, salary, superAnnuation, start_date));

		} else if (isTier4(salary)) {
			 slip = new SlipDTO(new TaxTier4(first, last, salary, superAnnuation, start_date));

		}

		return slip;
	}

	private boolean isTier1(int salary) {
		return 18200 < salary && salary <= 37000;
	}

	private boolean isTier2(int salary) {
		return 37000 < salary && salary <= 80000;
	}

	private boolean isTier3(int salary) {
		return 80000 <= salary && salary <= 180000;
	}

	private boolean isTier4(int salary) {
		return 180000 <= salary;
	}

	/**
	 * Validates the line
	 * 
	 * @param line
	 * @return boolean
	 */
	private boolean validateLine(String[] line) {
		boolean isValid = false;

		if (line.length == 5 && isPositiveInteger(line[2])
				&& isValidSuper(Double.parseDouble(line[3]))
				&& isValidDate(line[4])) {
			isValid = true;
		}

		return isValid;
	}

	/**
	 * test if valid date
	 * 
	 * @param str
	 * @return true if value is valid date
	 */
	private boolean isValidDate(String string) {
		// TODO Validate month
		// Problem assumption: valid and complete calendar month
		return true;
	}

	/**
	 * test if positive integer
	 * 
	 * @param str
	 * @return true if value is integer and positive
	 */
	private boolean isPositiveInteger(String str) {
		try {
			int i = Integer.parseInt(str);
			if (i >= 0) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * test if within range of 0 - 50 inclusive.
	 * 
	 * @param str
	 * @return true is value is value within range	
	 * 
	 *         and super rate(0% - 50% inclusive)
	 */
	private boolean isValidSuper(double superAnnuation) {
		return (superAnnuation <= 50 && superAnnuation >= 0);
	}

}
