/*http://www.java2novice.com/java-file-io-operations/file-list-from-folder/
URL LOADERS: https://examples.javacodegeeks.com/core-java/net/urlclassloader/java-net-urlclassloader-example/
			 https://stackoverflow.com/questions/16335305/java-class-forname-from-distant-directory
			 https://docs.oracle.com/javase/7/docs/api/java/net/URLClassLoader.html*/
import java.lang.reflect.*;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class HW10 {
	public static void main(String[] args) throws Throwable{
		System.out.println("Found following plugins:");
	    File list = new File("file:///Desktop/java/HW10/plugin");
        File[] filearr = list.listFiles();
        for(File f: filearr){
			System.out.println(f.getName());
        }
		// search block

	
	Scanner in = new Scanner(System.in);

	System.out.println("Enter A or B to use said plugin:");
	
	String reply = in.nextLine();


			URL[] location = new URL[]{new URL("file:///Desktop/java/HW10/plugin")};
			URLClassLoader loader = new URLClassLoader(location);
			Class<?> talkclass = loader.loadClass("plugin"+reply);

			Constructor<?> constructor = talkclass.getConstructor();

			Object instance = constructor.newInstance();
				
			Method saysHi = talkclass.getMethod("whoSaysHello");
			Method saysBye = talkclass.getMethod("whoSaysBye");
				
			saysHi.invoke(instance);
			saysBye.invoke(instance);
	}
}
	

	
