package codechicken.nei;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TMIUninstaller {
	private static File jarFile;
	public static InstallerGui mainframe;
	
	public static class InstallerGui
		extends JFrame {
		private static final long serialVersionUID = 1L;
		private JTextField labelInfo;
		private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		
		public InstallerGui() {
			setTitle("TMI Uninstaller");
			initComponents();
		}
		
		private class ResizeListener
			implements LayoutManager
		{
			private ResizeListener() {}
			
			public void addLayoutComponent(String name, Component comp) {}
			
			public void layoutContainer(Container parent) {
				int w = TMIUninstaller.InstallerGui.this.getContentPane().getWidth();
				TMIUninstaller.InstallerGui.this.labelInfo.setBounds(10, 45, w - 20, 20);
				TMIUninstaller.InstallerGui.this.labelInfo.setScrollOffset(1000);
				TMIUninstaller.InstallerGui.this.labelInfo.update(TMIUninstaller.InstallerGui.this.getGraphics());
			}

			
			public Dimension minimumLayoutSize(Container parent) {
				return new Dimension(150, 100);
			}

			
			public Dimension preferredLayoutSize(Container parent) {
				return new Dimension(250, 120);
			}


			
			public void removeLayoutComponent(Component comp) {}
		}

		
		private void initComponents() {
			setLayout(new ResizeListener());
			add(getLabelInfo());
			setSize(358, 270);
		}

		
		public class InstallerListener
			implements ActionListener
		{
			public void actionPerformed(ActionEvent e) {}
		}
		
		public JTextField getLabelInfo() {
			if (this.labelInfo == null) {
				this.labelInfo = new JTextField();
				this.labelInfo.setFont(new Font("Tahoma", 0, 13));
				this.labelInfo.setHorizontalAlignment(0);
				this.labelInfo.setEditable(false);
				this.labelInfo.setText("Uninstalling TMI");
			} 
			return this.labelInfo;
		}


		
		public static void installLnF() {
			try {
				String lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
				UIManager.setLookAndFeel(lnfClassname);
			}
			catch (Exception e) {
				
				System.err.println("Cannot install com.sun.java.swing.plaf.windows.WindowsLookAndFeel on this platform:" + e.getMessage());
			} 
		}
	}




	
	public static void main(String[] args) {
		jarFile = new File(args[0]);
		
		InstallerGui.installLnF();
		mainframe = new InstallerGui();
		mainframe.setDefaultCloseOperation(3);
		
		mainframe.setLocationRelativeTo((Component)null);
		mainframe.pack();
		mainframe.setVisible(true);
		
		if (!jarFile.exists()) {
			mainframe.getLabelInfo().setText("Invalid Minecraft.jar");
		} else {
			uninstall();
		} 
	}

	
	private static File getJarFile() {
		try {
			//return new File(TMIUninstaller.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			String rawJarPath = URLDecoder.decode(TMIUninstaller.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
			
			// fix path
			rawJarPath = rawJarPath.replace("jar:", "").replace("file:/", "").replace("file:\\", ""); /* replace scheme part */
			if(rawJarPath.contains(".jar!")) {
				rawJarPath = rawJarPath.substring(0, rawJarPath.lastIndexOf(".jar!") + ".jar".length());
			}
			
			// cleanup
			rawJarPath = new File(rawJarPath).getAbsolutePath();
			
			// log
			System.out.println("[NotEnoughItems Fix] original jar path = " + ((TMIUninstaller.class).getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
			System.out.println("[NotEnoughItems Fix] new jar path = " + rawJarPath);
			
			// return file
			return new File(rawJarPath);
		/*
		} catch (URISyntaxException e) {			
			return null;
		*/
		} catch (Exception e) {
			return null;
		}
	}

	
	public static void deleteTMIUninstaller() throws IOException {
		System.out.println("Removing TMI Uninstaller");
		deleteDir(new File(getJarFile().getParentFile(), "TMIUninstaller"), true);
	}

	
	public static boolean TMIInstalled() {
		File jarFile = getJarFile();
		if (!jarFile.getName().endsWith(".jar")) {
			return false;
		}
		
		try {
			ZipFile zip = new ZipFile(jarFile);
			ZipEntry tmi = zip.getEntry("mod_TooManyItems.class");
			zip.close();
			return (tmi != null);
		}
		catch (Exception e) {
			
			return false;
		} 
	}

	
	public static void runTMIUninstaller() throws IOException {
		System.out.println("Installing Uninstaller.");
		File jarFile = getJarFile();
		File uninstDir = new File(jarFile.getParentFile(), "TMIUninstaller");
		if (!uninstDir.exists()) {
			uninstDir.mkdirs();
		}
		System.out.println("Installing Uninstaller: " + uninstDir.getPath());
		
		FileInputStream fileinputstream = new FileInputStream(jarFile);
		ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
		
		while (true) {
			ZipEntry zipentry = zipinputstream.getNextEntry();
			if (zipentry == null) {
				break;
			}
			
			String fullname = zipentry.getName().replace('\\', '/');
			if (!zipentry.isDirectory() && fullname.replace('/', '.').startsWith(TMIUninstaller.class.getCanonicalName())) {
				
				File outFile = new File(uninstDir, fullname);
				System.out.println("Extracting File: " + outFile.getPath());
				
				if (!outFile.getParentFile().exists()) {
					outFile.getParentFile().mkdirs();
				}
				outFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(outFile);
				
				byte[] buffer = new byte[65535];
				int read = 0;
				while ((read = zipinputstream.read(buffer)) != -1)
				{
					fout.write(buffer, 0, read);
				}
				fout.close();
			} 
		} 
		
		fileinputstream.close();
		
		String javaBin = String.valueOf(System.getProperty("java.home")) + File.separator + "bin" + File.separator + "java";
		
		String classpath = uninstDir.getAbsolutePath();
		String className = TMIUninstaller.class.getCanonicalName();
		
		String jarPath = jarFile.getPath();
		
		System.out.println("Running Process: " + javaBin + " -cp \"" + classpath + "\" \"" + className + "\" \"" + jarPath + "\"");
		
		ProcessBuilder builder = new ProcessBuilder(new String[] { javaBin, "-cp", classpath, className, jarPath });
		builder.start();
	}

	
	public static void deleteDir(File directory, boolean remove) throws IOException {
		System.out.println("Deleting Dir: " + directory.getPath());
		if (!directory.exists()) {
			
			if (!remove)
				directory.mkdirs();  return;
		}  byte b;
		int i;
		File[] arrayOfFile;
		for (i = (arrayOfFile = directory.listFiles()).length, b = 0; b < i; ) { File file = arrayOfFile[b];
			
			if (file.isDirectory()) {
				
				deleteDir(file, true);

			
			}
			else if (!file.delete()) {
				
				throw new IOException("Delete Failed: " + file);
			} 
			b++; }
		
		if (remove) {
			
			try {
				
				if (!directory.delete())
				{
					throw new IOException("Delete Failed: " + directory);
				}
			}
			catch (SecurityException e) {
				
				throw e;
			} 
		}
	}

	
	public static void uninstall() {
		File backupfile = new File(jarFile.getParentFile(), String.valueOf(jarFile.getName()) + ".bak");
		
		try {
			if (!backupfile.exists()) {
				backupfile.createNewFile();
			}
			FileOutputStream backout = new FileOutputStream(backupfile);
			FileInputStream jarin = new FileInputStream(jarFile);
			backout.getChannel().transferFrom(jarin.getChannel(), 0L, jarFile.length());
			
			backout.close(); jarin.close();
			
			ZipInputStream zipin = new ZipInputStream(new FileInputStream(backupfile));
			ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(jarFile));
			byte[] buffer = new byte[20000];
			int read = 0;
			
			while (true) {
				ZipEntry entry = zipin.getNextEntry();
				if (entry == null) {
					break;
				}
				
				if (entry.isDirectory())
					continue;  String name = entry.getName();
				if (name.startsWith("TMI") || name.startsWith("_tmi") || name.startsWith("tmi.png") || name.startsWith("mod_TooManyItems")) {
					continue;
				}
				
				zipout.putNextEntry(new ZipEntry(name));
				InputStream in = zipin;
				while ((read = in.read(buffer)) != -1)
				{
					zipout.write(buffer, 0, read);
				}
				zipout.closeEntry();
				zipin.closeEntry();
			} 
			zipin.close();
			zipout.close();
			
			mainframe.getLabelInfo().setText("Uninstall Completed. Close this and restart minecraft.");
		}
		catch (Exception e) {
			
			e.printStackTrace();
			mainframe.getLabelInfo().setText("Invalid Minecraft.jar");
			
			try {
				FileInputStream backin = new FileInputStream(backupfile);
				FileOutputStream jarout = new FileOutputStream(jarFile);
				jarout.getChannel().transferFrom(backin.getChannel(), 0L, backupfile.length());
				
				backin.close(); jarout.close();
			}
			catch (Exception e1) {
				
				e1.printStackTrace();
			} 
		} 
	}
}


/* Location:              C:\Users\na_th_an\Downloads\NotEnoughItems-Client 1.3.zip!\codechicken\nei\TMIUninstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */