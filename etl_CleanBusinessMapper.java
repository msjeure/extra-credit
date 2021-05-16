import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CleanBusinessMapper
        extends Mapper<LongWritable, Text, Text, NullWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
            //split the input by ','
            String[] lines = value.toString().split(",");
            //select DCA License, License Type, License Status, Industry, Address Borough
            int length = lines.length;
            if (!lines[0].equals("DCA License Number") && length == 5){
                context.write(new Text(lines[0] + "," + lines[1] + ","  + lines[2] + "," + lines[3]+ "," + lines[4]), NullWritable.get());
            }
    }
}