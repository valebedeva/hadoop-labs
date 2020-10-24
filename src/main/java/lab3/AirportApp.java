package lab3;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;


public class AirportApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines_time = sc.textFile("/time_data.csv");
        JavaRDD<String> lines_desc = sc.textFile("/desc_data.csv");
        JavaPairRDD<String, String> id_desc = lines_time.map(s -> s.split(",")).mapToPair(
                s -> new Tuple2<>(s[0], s[1])
        );


    }
}
