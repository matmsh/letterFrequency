package net.sf.frequency;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IntSumReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();

	/**
	 * values is a list of values (for a common key) : 1,1,1, The values come
	 * from ("a",1), ("b",1), ...
	 */
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		result.set(sum);
		context.write(key, result);
	}
}