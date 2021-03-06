package com.rajkrrsingh.datagen;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Random;
/*create table index_table (study_id string,visit_code string,visit_num int,usubject_id string,patient_id string,subev int,rsn int, 
visitd timestamp,event_label string,eval_seq string,test_name string,lab_test_e string,lab string,lab_name string, 
fast_ynl string,acc_no string,spec_id string,lab_val_e string,nr_flag string,nr_chk decimal(38,5),lab_test string, 
lab_val decimal(38,5),norm_low decimal(38,5),norm_high decimal(38,5),norm_unit string,us_std_val decimal(38,5),us_std_low decimal(38,5), 
us_std_high decimal(38,5),us_std_unit string,wbc_val decimal(38,5),abs_val decimal(38,5),lab_d timestamp,lab_tm string,lab_sdy decimal(38,5), 
source string,etl_created_date timestamp,etl_updated_date timestamp)*/
public class DataGenerator{

  private static SecureRandom secureRandom = new SecureRandom();
  
  public static void main(String[] args) throws IOException {
    try {
      String userDir = System.getProperty("user.dir");
      String fullPathToFile = userDir + "/" + "tbl.data";
      File file = new File(fullPathToFile);
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      Random r = new Random();

      String content;
      for (long i = 0; i <= Integer.parseInt(args[0]); i++) {
        double value1 = r.nextDouble()*1000000L;
        double value2 = r.nextDouble()*1000000L;
        double value3 = r.nextDouble()*1000000L;
        double value4 = r.nextDouble()*1000000L;
        double value5 = r.nextDouble()*1000000L;
        double value6 = r.nextDouble()*1000000L;
        double value7 = r.nextDouble()*1000000L;
        double value8 = r.nextDouble()*1000000L;
        double value9 = r.nextDouble()*1000000L;
        double value10 = r.nextDouble()*1000000L;

        BigDecimal b1 = new BigDecimal(String.valueOf(value1)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b2 = new BigDecimal(String.valueOf(value2)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b3 = new BigDecimal(String.valueOf(value3)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b4 = new BigDecimal(String.valueOf(value4)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b5 = new BigDecimal(String.valueOf(value5)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b6 = new BigDecimal(String.valueOf(value6)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b7 = new BigDecimal(String.valueOf(value7)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b8 = new BigDecimal(String.valueOf(value8)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b9 = new BigDecimal(String.valueOf(value9)).setScale(5,BigDecimal.ROUND_HALF_UP);
        BigDecimal b10 = new BigDecimal(String.valueOf(value10)).setScale(5,BigDecimal.ROUND_HALF_UP);
        content = nextSessionId()+","+nextSessionId()+","+Integer.toString(r.nextInt())+","
                +nextSessionId()+","+nextSessionId()+","+Integer.toString(r.nextInt())+","+Integer.toString(r.nextInt())+","
                +new Timestamp((long) (1293861599+r.nextDouble()*60*60*24*365))+","+nextSessionId()+","+nextSessionId()+","+nextSessionId()+","
                +nextSessionId()+","+nextSessionId()+","+nextSessionId()+","+nextSessionId()+","+nextSessionId()+","
                +nextSessionId()+","+nextSessionId()+","+nextSessionId()+","+b1+","+nextSessionId()+","+b2+","+b3+","+b4+","+nextSessionId()+","+b5+","+b6+","+b7+","+nextSessionId()+","
                +b8+","+b9+","+new Timestamp((long) (1293861599+r.nextDouble()*60*60*24*365))+","+nextSessionId()+","+b10+","+nextSessionId()+","
                +new Timestamp((long) (1293861599+r.nextDouble()*60*60*24*365))+","+new Timestamp((long) (1293861599+r.nextDouble()*60*60*24*365));

        bw.write(content);
        bw.write("\n");
      }
      bw.close();
      System.out.println("Done. Saved data to " + file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static String nextSessionId() {
    return new BigInteger(130, secureRandom).toString(32);
  }
}
