package net.sf.frequency;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Run a Hadoop job to do letter frequency analysis on files in the directory
 *  specified by input-path in standalone.xml. 
 * 
 * The result will be in output-path="target/output" . 
 * Note that output-path must NOT  exists when this is run.  
 */
public class RunLetterFreqStandalone {

	private static final String[] CONFIGS = new String[] { "standalone.xml" };

	public static void main(String[] args) {
		String[] res = (args != null && args.length > 0 ? args : CONFIGS);
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(res);
		// shut down the context cleanly along with the VM
		ctx.registerShutdownHook();
	}

}
