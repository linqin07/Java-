package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	
	public static void main(String[] args) {
//		Logger logger = LogManager.getLogger(Test.class);
//		logger.info("ssss");
//		${sys:user.home}
//		${sys:catalina.home}
		
		Logger logger = LogManager.getLogger("romdom");
		logger.info("Rde");
	}
}
