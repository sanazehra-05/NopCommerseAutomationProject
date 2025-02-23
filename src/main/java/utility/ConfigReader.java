package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	public Properties props;
	
	public Properties initProperties() {
		
		props = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config/Config.properties");
			try {
				props.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return props;
		
	}

}
