//Cheng Chen (cc94226@live.com) 2016

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class CollectRelation {
	private static String trainlabel = "/home/che313/bioRE/bio_treelstm_data7/train/label";
	private static String testlabel = "/home/che313/bioRE/bio_treelstm_data7/test/label";
	private static String devlabel = "/home/che313/bioRE/bio_treelstm_data7/dev/label";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File train = new File(trainlabel);
		File test = new File(testlabel);
		File dev = new File(devlabel);
		
		int train_labels[] = new int[63]; 
		int test_labels[] = new int[63];
		int dev_labels[] = new int[63]; 
		
		try {
			
			//StringBuffer sb= new StringBuffer("");
	           
            FileReader trainreader = new FileReader(train);
            BufferedReader trainbr = new BufferedReader(trainreader);
            FileReader testreader = new FileReader(test);
            BufferedReader testbr = new BufferedReader(testreader);
            FileReader devreader = new FileReader(dev);
            BufferedReader devbr = new BufferedReader(devreader);
            
            for(int i = 0 ; i < 62; i++){
            	train_labels[i] = 0;
            	test_labels[i] = 0;
            	dev_labels[i] = 0;
            }
            
            String str = "";
            float count = 0;
            while((str = trainbr.readLine()) != null) {
            	int l = Integer.parseInt(str);
            	//System.out.println(l);
            	train_labels[l]++;
            	count++;
            }
            System.out.println("=============== relations distribution in train set ===============\n");
            for(int i = 1; i < 63; i++){
            	System.out.println("class " + i + " in train dataset: "+ train_labels[i] + ": " + train_labels[i]/count + "% | \t");
            }
            System.out.println("\n===================================================================\n");
            
            count = 0;
            while((str = testbr.readLine()) != null) {
            	int l = Integer.parseInt(str);
            	test_labels[l]++;
            	count++;
            }
            System.out.println("=============== relations distribution in test set ================\n");
            for(int i = 1; i < 63; i++){
            	System.out.println("class " + i + " in test dataset: "+ test_labels[i] + ": " + test_labels[i]/count+ "% | \t");
            }
            System.out.println("\n===================================================================\n");
            
            count = 0;
            while((str = devbr.readLine()) != null) {
            	int l = Integer.parseInt(str);
            	dev_labels[l]++;
            	count++;
            }
            System.out.println("=============== relations distribution in dev set =================\n");
            for(int i = 1; i < 63; i++){
            	System.out.println("class " + i + " in dev set: "+ dev_labels[i] + ": " + dev_labels[i]/count+ "% | \t");
            }
            System.out.println("\n===================================================================\n");
            
            System.out.println("============ relations distribution in whole data set =============\n");
            for(int i = 1; i < 63; i++){
            	System.out.println("class " + i + " in train set: "+ train_labels[i] + " times, and " + train_labels[i]/count + "% | \t in test set: " + test_labels[i] + " times, and " + test_labels[i]/count+ "% | \t in dev set: "+ dev_labels[i] + " times, and " + dev_labels[i]/count+ "% | \t");
            }
            System.out.println("\n===================================================================\n");
            
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
