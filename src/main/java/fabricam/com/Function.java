package fabricam.com;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;


import java.util.Optional;

public class Function {
    /**
     * This function consume KafkaEvents on the localhost. Change the topic, brokerList, and consumerGroup to fit your enviornment.
     * The function is trigged one for each KafkaEvent
     * @param kafkaEventData
     * @param context
     */
    @FunctionName("KafkaTrigger")
    public void runOne(
            @KafkaTrigger(name = "kafkaTrigger", 
                          topic = "test", 
                          brokerList = "my-release-kafka-0.my-release-kafka-headless.default.svc.cluster.local:9092",
                          consumerGroup="$Default") String kafkaEventData,
            final ExecutionContext context) {
        context.getLogger().info(kafkaEventData);
    }
}
