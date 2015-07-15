package bank;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	
	private static void escrever(Object obj) {
		File dir = new File("/home/jrgvf/workspace/simplebank/logs");
		File arq = new File(dir, ("log.txt"));
		try {			 
            arq.createNewFile();
            FileWriter fw = new FileWriter(arq, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(obj + " ;");
//            pw.flush();
            pw.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}
