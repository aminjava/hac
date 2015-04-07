import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.thebuzzmedia.imgscalr.Scalr;


public class BatchResize {

	public static void main(String[] args) throws IOException {
		
		int dirCount = 0;
		Scanner scanner = new Scanner(System.in);

        System.out.print("Source Directory:\t");
        String srcDir = scanner.nextLine();

        System.out.print("Enter Destination Directory:\t");
        String  destDir = scanner.nextLine();
        if(srcDir.contains(destDir)){
        	System.out.println("Destination Directory should be out of Source dir due to recursive scanning of directories .");
        }else if (new File(srcDir).isDirectory() && new File(destDir).isDirectory()){
        	File src = new File(srcDir);
        	String[] filelist = src.list();
        	File flt = new File(destDir);
			if(!flt.exists()){
				flt.mkdir();
			}
		long startTime = System.nanoTime();	
			for (int i = 0; i < filelist.length; i++) {
				String _currfl =srcDir+File.separator+ filelist[i];
				File workFl = new File(_currfl);
				if(workFl.isFile()){
					
				String _destFile = destDir + File.separator + filelist[i];
			//	System.out.print("resizing :"+_currfl);
				ImageResizer.createResizedCopy(_currfl, 1550, _destFile);
			//	System.out.println(".... Done");
				}
				else{
					dirCount++;
				}
			}
			
			long endTime = System.nanoTime();
			long totTime = endTime - startTime;
			System.out.println("Time to resize "+TimeUnit.NANOSECONDS.toSeconds(totTime) +" seconds" );
		}
        	
        }
		
	}
