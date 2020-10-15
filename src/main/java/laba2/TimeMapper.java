package laba2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TimeMapper extends Mapper<LongWritable, Text, KeyPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String[] records = value.toString().split(",");
        Text delay_time = new Text(records[18]);
        Text airport_id = new Text(records[14]);
        KeyPair key_pair = new KeyPair(airport_id, new Text("1"));
        context.write(key_pair, delay_time);
    }
}