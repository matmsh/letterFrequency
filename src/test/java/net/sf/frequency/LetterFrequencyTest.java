package net.sf.frequency;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class LetterFrequencyTest {
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;

	@Before
	public void setUp() {
		LetterMapper mapper = new LetterMapper();
		IntSumReducer<Text> reducer = new IntSumReducer<Text>();
		mapDriver = MapDriver.newMapDriver(mapper);
		reduceDriver = ReduceDriver.newReduceDriver(reducer);
		mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
	}

	
	@Test
	public void testMapper() {
		mapDriver.withInput(new LongWritable(), new Text("As I am"));
		mapDriver.withOutput(new Text("a"), new IntWritable(1));
		mapDriver.withOutput(new Text("s"), new IntWritable(1));
		mapDriver.withOutput(new Text("i"), new IntWritable(1));
		mapDriver.withOutput(new Text("a"), new IntWritable(1));
		mapDriver.withOutput(new Text("m"), new IntWritable(1));
		mapDriver.runTest();
	}
	
	@Test
	public void testReducer() {
		List<IntWritable> values = new ArrayList<IntWritable>();
		values.add(new IntWritable(1));
		values.add(new IntWritable(1));
		values.add(new IntWritable(1));
		reduceDriver.withInput(new Text("d"), values);
		reduceDriver.withOutput(new Text("d"), new IntWritable(3));
		reduceDriver.runTest();
	}
}
