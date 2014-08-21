package Others;
/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Scanner;

*//**
 * 
 *//*

*//**
 * @author STONE
 *
 *//*
public class AddHeandToCpp {

	*//**
	 * @param args
	 * @throws Exception 
	 *//*
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println(new DecimalFormat("#.0").format(6577.90));
		System.out.println("输入要添加的头文件名(如XX.h)...");
		final 	String head=scanner.next();
	    String currentPath = System.getProperty("user.dir");
		File currentFile = new File(currentPath);
		System.out.println("开始扫描cpp文件...");
		if (currentFile.isDirectory()) {
		     File[] files=currentFile.listFiles(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					//System.out.println(name);
					return name.matches(".*\\.cpp");
				}
			}); 
		     System.out.println("cpp文件共有:"+files.length);
		     System.out.println("处理中...");
		     for (File file : files) {
				System.out.println("修改--"+file.getName());
				if (file.isFile()) {		
					insertStringInFile(file,1,"#include \""+head+"\"");
				}
			}
		     System.out.println("处理完成...输入quit结束！");
		     while(scanner.hasNext()){
		    	 if(scanner.next().toLowerCase().equals("quit"))break;
		     }
		     scanner.close();
		}

	}
	 *//**
	   * 在文件里面的指定行插入一行数据
	   * 
	   * @param inFile
	   *          文件
	   * @param lineno
	   *          行号
	   * @param lineToBeInserted
	   *          要插入的数据
	   * @throws Exception
	   *           IO操作引发的异常
	   *//*
	  public static void insertStringInFile(File inFile, int lineno, String lineToBeInserted)
	      throws Exception {
	    // 临时文件
	    File outFile = File.createTempFile("name", ".tmp");
	    // 输入
	    FileInputStream fis = new FileInputStream(inFile);
	    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
	    // 输出
	    FileOutputStream fos = new FileOutputStream(outFile);
	    PrintWriter out = new PrintWriter(fos);
	    // 保存一行数据
	    String thisLine;
	    // 行号从1开始
	    int i = 1;
	    while ((thisLine = in.readLine()) != null) {
	      // 如果行号等于目标行，则输出要插入的数据
	      if (i == lineno) {
	        out.println(lineToBeInserted);
	      }
	      // 输出读取到的数据
	      out.println(thisLine);
	      // 行号增加
	      i++;
	    }
	    out.flush();
	    out.close();
	    in.close();
	    // 删除原始文件
	    inFile.delete();
	    // 把临时文件改名为原文件名
	    outFile.renameTo(inFile);
	  }

}
*/