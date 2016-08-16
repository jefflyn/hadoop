package com.firework.hadoop.temperature;

// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer
  extends Reducer<Text, FloatWritable, Text, FloatWritable> {
  
  @Override
  public void reduce(Text key, Iterable<FloatWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    float maxValue = Float.MIN_VALUE;
    for (FloatWritable value : values) {
      maxValue = Math.max(maxValue, value.get());
    }
    context.write(key, new FloatWritable(maxValue));
  }
}
// ^^ MaxTemperatureReducer
