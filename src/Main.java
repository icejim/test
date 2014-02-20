import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



public class Main {
	
	public enum Color implements Runnable {
		WHITE(21) {
			@Override
			public String color() {
				return "copper";
			}
		}

		,
		BLACK(22) {
			@Override
			public String color() {
				  return "silver";
			}
		};
//		, RED(23), YELLOW(24), BLUE(25);

		 private int code;
		 
		 private Color(int c) {
		   code = c;
		 }
		 
		 public int getCode() {
		   return code;
		 }

		@Override
		public String toString() {
			// only capitalize the first letter
			String s = super.toString();
			return s.substring(0, 1) + s.substring(1).toLowerCase();
		}
		
		public abstract String color();
		
		@Override
		public void run() {
			System.out.println("Enum in Java implement interfaces");

		}

	}

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws Exception {
//		List<String> mrList = new ArrayList<String>();
//		for (String mr : mrList) {
//			System.out.println(mr);
//		}
//		Color color = Color.BLACK;
//		color.run();
//		System.out.println(color.color());
//		System.out.println(color.code);
		
//		String dataFileName = "C:/myTabSeparatedFile.txt";
//		BufferedReader bReader = new BufferedReader(
//                new FileReader(dataFileName));
// 
//        String line;
// 
//        /**
//         * Looping the read block until all lines in the file are read.
//         */
//        while ((line = bReader.readLine()) != null) {
// 
//            /**
//             * Splitting the content of tabbed separated line
//             */
//            String datavalue[] = line.split("\t");
//            for (int i = 0; i < datavalue.length; i++) {
//            	System.out.println("<li>"+datavalue[i]+"</li>");
//			}
//            
//        }
//        bReader.close();
		
//		try {
//			String filename = "Bao,Junran DBST 120516 FV.doc";
//			String test = MimeUtility.encodeWord(filename);
//			String test2 = URLEncoder.encode(filename, "utf-8");
//			String test3 = new QCodec("utf-8").encode(filename); 
//			System.out.println(test);
//			System.out.println(test2);
//			System.out.println(test3);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar c = Calendar.getInstance();
//		c.setTime(new Date());
//		c.add(Calendar.DATE, 7);
//		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 12, 0, 0);		
//		String dstartdate = sf.format(c.getTime());
//		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 12, 30, 0);		
//		String denddate = sf.format(c.getTime());
//		
//		TimeZone timeZoneSH = TimeZone.getTimeZone("Asia/Shanghai");
//		TimeZone timeZoneLA = TimeZone.getTimeZone("America/Los_Angeles");
//		
//		sf.setTimeZone(timeZoneLA);
//		Date display_start_date = null;
//		Date display_end_date = null;
//		try 
//		{
//			display_start_date = sf.parse(dstartdate);
//			display_end_date = sf.parse(denddate);
//			System.out.println("America/Los_Angeles:" + display_start_date);
//			System.out.println("America/Los_Angeles:" + display_end_date);
//			
//			sf.setTimeZone(timeZoneSH);
//			String startdate = sf.format(display_start_date);
//			String enddate = sf.format(display_end_date);
//			sf.setTimeZone(timeZoneLA);
//			System.out.println("Asia/Shanghai:" + sf.parse(startdate));
//			System.out.println("Asia/Shanghai:" + sf.parse(enddate));
//		} 
//		catch (ParseException e) 
//		{
//		}
		    	
//		SimpleDateFormat outputFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy");
//		outputFormat.setTimeZone(timeZoneSH);
//		System.out.println("Asia/Shanghai:" + outputFormat.format(date));
//		outputFormat.setTimeZone(timeZoneNY);
//		System.out.println("America/Los_Angeles:" + outputFormat.format(date));

		try {

	         // create a new array of 2 strings
//	         String[] cmdArray = new String[2];
//
//	         // first argument is the program we want to open
//	         cmdArray[0] = "aws";
//
//	         // second argument is a txt file we want to open with notepad
//	         cmdArray[1] = "s3";

	         String[] cmdArray = new String[] { "aws", "s3", "cp",
						"c:/123.txt",
						"s3://dochoostorage/123.txt"};
	         // create a process and execute cmdArray
	         Process process = Runtime.getRuntime().exec(cmdArray);
	         String lsString = null;
	         BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(process.getInputStream()));
				while ((lsString = bufferedReader.readLine()) != null) {
					System.out.println("[inputStream]" + lsString);
				}
				BufferedReader errbufferedReader = new BufferedReader(
						new InputStreamReader(process.getErrorStream()));
				while ((lsString = errbufferedReader.readLine()) != null) {
					System.out.println("[errorStream]" + lsString);
				}
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
    }
	
	

}
