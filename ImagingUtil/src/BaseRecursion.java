

import java.io.File;

public abstract class BaseRecursion {
	
		private int i = 0;
	//	String rootDoot = "C:/root/testdir";
		private File fl;
		String destdir = "";
		public static int dirCount = 0;
		
		public BaseRecursion()
		{
		
		}
		
		public BaseRecursion(String loc)
		{
			System.out.println("Location set :"+loc);
			 fl = new File(loc);
			 startDigging( fl);
			 
		}
		
		public BaseRecursion(String loc,String _destdir )
		{
			System.out.println("Location set :"+loc);
			System.out.println("Dest set :"+_destdir);
			
			 fl = new File(loc);
			if(!new File(_destdir).exists()){
			 new File(_destdir).mkdirs();
			}
			destdir = _destdir;
			 startDigging( fl);
			 
		}
		public abstract void  executeDirTask(File fl);
		
		public abstract void executeFileTask(File fl);

		
		public final void startDigging(File fl)
		{
			if(fl.isDirectory())
			{			
				File[] lfs =  fl.listFiles();
				
				for (int i = 0; i < lfs.length; i++) {
					File fln = lfs[i];
					
					if(fln.isDirectory())
					{
						dirCount++;
						executeDirTask(fln);
						startDigging(fln);
					}
					else
					{
						String name = fln.getName();
						executeFileTask(fln);						
						
						
						
					}
					
				}
				
				
			}
		
			
		}
		
		

	}



