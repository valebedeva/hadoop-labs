package lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class DescriptionMapper extends Mapper<LongWritable, Text, KeyPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String str = value.toString();
        int numSplitter = str.indexOf(TimeDelayCounterJob.SPLITTER);
        String idAirport = str.substring(1, numSplitter-1);
        String description = str.substring(numSplitter+1);
        context.write(new KeyPair(new Text(idAirport),
                                  new Text(TimeDelayCounterJob.MARK_DESCRIPTION)),
                      new Text(description));
    }
}