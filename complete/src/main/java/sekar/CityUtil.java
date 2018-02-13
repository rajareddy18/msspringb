package sekar;

import java.util.*;
import java.io.*;

public class CityUtil {
    private final String filepath = "/Raja/11_tmp/input.txt";
    private static ArrayList <String> masterList = null;
    private static CityUtil tUtil = new CityUtil();

    private CityUtil() {
        masterList  = new ArrayList<String>();
        readFileInit();
    }



    /**
     * Reads the file and stores into a list.
     */
    private void readFileInit() {
        Scanner s = null;
        String tmp=null;
        int rowcnt =0;
        try {
             s = new Scanner(new File(filepath));

            while (s.hasNext()) {
                tmp = s.nextLine();
                if(tmp !=null)
                masterList.add(tmp.toLowerCase());
                //System.out.println(tmp.toLowerCase());
                rowcnt++;
            }
            System.out.println("Rows read =" + rowcnt);

        }
        catch(FileNotFoundException fex)
        {
            System.out.println("File Not Found" + fex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Exception Occured " + ex.getMessage());
        }
        finally
        {
            s.close();
        }
    }

    /**
     * loops through the list and check if value is present.
     * @param origin
     * @param destination
     * @return
     */
    public static boolean checkCityPresence(String origin, String destination) throws Exception
    {
        boolean present = false;
        String pairCheck = origin + "," + destination;
        if(pairCheck == null) return false;
        if(masterList == null) throw new Exception("Utility Uninitialized Error");

        System.out.println("Pair check is" + pairCheck);
        System.out.println(masterList);
        for(String combo : masterList)
        {
            if(pairCheck.equalsIgnoreCase(combo)) return true;

        }

        return present;

    }

    /*
    public static void main(String []args)
    {
        boolean fl = false;
        try {       fl = CityUtil.checkCityPresence("boston", "new york"); }
        catch (Exception ex)
        {
            System.out.println("Error");
        }
        System.out.println(fl);
    }
    */
}

