import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable result=new IntWritable();
	public void reduce(Text key, Iterable<IntWritable> Values, Context context) throws IOException, InterruptedException
	{ int sum=0; 
		for(IntWritable val:Values)
		{
			sum+=val.get();
		}
		result.set(sum);
		context.write(key,result);
	}

}