package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int randomNumber()
	{
		Random rand=new Random();
		int number=rand.nextInt(1000);
		return number;
	}
	public String currentDate()
	{
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		String currentdate = sim.format(d);
		return currentdate;
		
	}
	
	public String expectedDate()
	{
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH,15);
		String expecteddate = sim.format(cal.getTime());
		return expecteddate;
		
	}
	public char randomAlphabets() 
	{ 
		char letter;
		Random rand = new Random(); 
		if (rand.nextBoolean()) { letter = (char) ('a' + rand.nextInt(26)); 
		} else
		{ 
			letter = (char) ('A' + rand.nextInt(26));
		}
		return letter;
		
	}
	public CharSequence togetRequiredDate(int i) {
		// TODO Auto-generated method stub
		return null;
	} 

}
