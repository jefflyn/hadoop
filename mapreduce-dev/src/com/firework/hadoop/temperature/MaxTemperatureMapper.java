package com.firework.hadoop.temperature;

// cc MaxTemperatureMapper Mapper for maximum temperature example
// vv MaxTemperatureMapper
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper
  extends Mapper<LongWritable, Text, Text, FloatWritable> {

  //private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    if(key.get() == 0L) return;
    //031350 99999  19490101    35.4 24    33.3 23   956.7 24  9999.9  0    7.9 24    8.2 24   22.0  999.9    39.0    30.0  99.99  999.9  011000
    String line = value.toString();
    String year = line.substring(13, 20);
    String airTemperature = line.substring(26, 32);
    
    if (airTemperature != null) {
      airTemperature = airTemperature.trim();
    }
    
    float tempt = Float.valueOf(airTemperature);
    context.write(new Text(year), new FloatWritable(tempt));
  }
}
// ^^ MaxTemperatureMapper
