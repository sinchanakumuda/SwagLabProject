package utilities;
import java.util.Random;

public class JavaUtility {
	
	public int toGetRandomCount()
	{
		Random r=new Random();
		int num=r.nextInt(1000);
		return num;
	}
	
	public String toGetRandomAlpha()
	{
		Random r=new Random();
		char num=(char)('A'+r.nextInt(26));
		String res=num+"";
		return res;
	}

	

}
