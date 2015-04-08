import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ResizeDirContents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Source Directory:\t");
        String srcDir = scanner.nextLine();

        System.out.print("Enter Destination Directory:\t");
        String  destDir = scanner.nextLine();
        if(srcDir.contains(destDir)){
        	System.out.println("Destination Directory should be out of Source dir due to recursive scanning of directories .");
        }else if (new File(srcDir).isDirectory() && new File(destDir).isDirectory()){
        	long startTime = System.nanoTime();
        	FileReSize fs = new FileReSize(srcDir,destDir);
        	long endTime = System.nanoTime();
			long diff = endTime - startTime;
			System.out.println("Batch Processing time :"+ TimeUnit.NANOSECONDS.toSeconds(diff) +"  Seconds" );
       		System.out.println("Images Processed :"+ImageResizer.imgCount);
       		System.out.println("Files ignored :"+ImageResizer.nonImgCount);
       		System.out.println("Directories count :"+FileReSize.dirCount);
        }
		

	}

}
