package net.sf.frequency;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Run a Hadoop to do letter frequency analysis in Pseudo distributed or distributed mode.
 * 
 * At the start of each run, a groovy script to set up input directory and
 * delete output directory (if exists).
 *  
 * Before running this program, please change the values in script.properties. 
 *
 */
public class RunLetterFreqScript {

	private static final String[] CONFIGS = new String[] { "script.xml" };

	public static void main(String[] args) {
		String[] res = (args != null && args.length > 0 ? args : CONFIGS);
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(res);
		// shut down the context cleanly along with the VM
		ctx.registerShutdownHook();
	}

}
