package net.sf.frequency;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 
 * Type of input key = Object,
 * Type of input value =Text,
 * Type of output key= Text,
 * Type of output value = IntWritable
 * 
 *
 */
public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	private final static LetterSplitter splitter = new LetterSplitter();

	private Text keyOut = new Text();
	
	/**
	 * For each word in the line, split it to letters. An upper case letters will be 
	 * converted to lower case.  
	 * 
	 * @param offset : key in. The position of 1st char in  value from beginning of document. 
	 * @param value a Line
	 * @param context Output context
	 */
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		StringTokenizer itr = new StringTokenizer(value.toString());
		while (itr.hasMoreTokens()) {

			String word = itr.nextToken();

			List<String> letters = splitter.split(word);
			for (String letter : letters) {
				keyOut.set(letter);
				context.write(keyOut, one);
			}

		}
	}

}
