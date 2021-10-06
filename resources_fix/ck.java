import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;


public class ck extends Thread {
	public File a;
	
	public ck(File paramFile, Minecraft paramMinecraft) {
		this.b = paramMinecraft;
		setName("Resource download thread");
		setDaemon(true);
		this.a = new File(paramFile, "resources/");
		System.out.println ("Resources directory seems to be " + paramFile + "/resources");
		if (!this.a.exists() && !this.a.mkdirs()) throw new RuntimeException("The working directory could not be created: " + this.a); 
	}
	private Minecraft b; private boolean c = false;
	public void run() {
		try {
			String theURL = null;
			try {
				theURL = System.getenv("RESOURCES_URL");				
			} catch (Exception e) {
			
			}
			if (theURL == null || "".equals(theURL)) {
				theURL = "https://betacraft.pl/MinecraftResources/";
				System.out.println("RESOURCES_URL not defined, using default");
			} else {
				System.out.println("Resources URL read from env RESOURCES_URL");
			}
			System.out.println ("Resources URL: " + theURL);
			
			//URL uRL = new URL("http://s3.amazonaws.com/MinecraftResources/");
			URL uRL = new URL(theURL);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(uRL.openStream());
			NodeList nodeList = document.getElementsByTagName("Contents");
			
			for (int b = 0; b < 2; b++) {
				for (int b1 = 0; b1 < nodeList.getLength(); b1++) {					
					Node node = nodeList.item(b1);
					if (node.getNodeType() == 1) {
						Element element = (Element)node;
						
						String str = ((Element)element.getElementsByTagName("Key").item(0)).getChildNodes().item(0).getNodeValue();
						
						long l = Long.parseLong(((Element)element.getElementsByTagName("Size").item(0)).getChildNodes().item(0).getNodeValue());
						
						if (l > 0L) {							
							a(uRL, str, l, b);
							if (this.c)
								return;  } 
					} 
				} 
			} 
			System.out.println ("DONE!");
		} catch (Exception exception) {
			a(this.a, "");
			exception.printStackTrace();
		} 
	}
	
	public void a() {
		a(this.a, "");
	}
	
	private void a(File paramFile, String paramString) {
		File[] arrayOfFile = paramFile.listFiles();
		for (byte b = 0; b < arrayOfFile.length; b++) {
			if (arrayOfFile[b].isDirectory()) {
				a(arrayOfFile[b], paramString + arrayOfFile[b].getName() + "/");
			} else {
				try {
					System.out.println ("$$$>>>" + paramString + arrayOfFile[b].getName());
					this.b.a(paramString + arrayOfFile[b].getName(), arrayOfFile[b]);
				} catch (Exception exception) {
					System.out.println("Failed to add " + paramString + arrayOfFile[b].getName());
				} 
			} 
		} 
	}



	
	private void a(URL paramURL, String paramString, long paramLong, int paramInt) {
		try {
			int i = paramString.indexOf("/");
			String str = paramString.substring(0, i);
			
			if (str.equals("sound") || str.equals("newsound")) {
				if (paramInt != 0)
					return; 
			} else if (paramInt != 1) {
				return;
			} 
		
			File file = new File(this.a, paramString);
			if (!file.exists() || file.length() != paramLong) {
				System.out.println ("File " + this.a + "/" + paramString + " does not exist or is outdated - downloading");
				file.getParentFile().mkdirs();
				String str1 = paramString.replaceAll(" ", "%20");
				a(new URL(paramURL, str1), file, paramLong);
				if (this.c)
					return; 
			} else {
				System.out.println ("File " + this.a + "/" + paramString + " exists.");
			}  
			
			this.b.a(paramString, file);
		} catch (Exception exception) {
			exception.printStackTrace();
		} 
	}
	
	private void a(URL paramURL, File paramFile, long paramLong) {
		byte[] arrayOfByte = new byte[4096];
		
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			dataInputStream = new DataInputStream(paramURL.openStream());
			dataOutputStream = new DataOutputStream(new FileOutputStream(paramFile));
			
			int i = 0;
			while ((i = dataInputStream.read(arrayOfByte)) >= 0) {
				dataOutputStream.write(arrayOfByte, 0, i);
				if (this.c)
					return; 
			}
		} catch (Exception e) {
			System.out.println ("Exception reading " + paramURL + " or writing " + paramFile);
		} finally {
			try {
				dataInputStream.close();
				dataOutputStream.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	// This function is called on exit to interrupt the process.
	public void b() {
		this.c = true;
	}
}


/* Location:              D:\Games\Minecraft 1.2.5 Modded\data\.minecraft\bin\minecraft.jar!\ck.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */