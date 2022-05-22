package net.bondarik;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ClientConfig config = new ClientConfig();
        config.setClusterName("dev");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);

        Map<Long, String> hazelcastMap = hazelcastInstanceClient.getMap("data");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(5000);
            showMapContent(hazelcastMap);
        }
    }

    private static void showMapContent(Map<Long, String> map) {
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n==================\n");
    }
}
