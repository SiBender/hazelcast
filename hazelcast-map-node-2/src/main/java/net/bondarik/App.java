package net.bondarik;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.flakeidgen.FlakeIdGenerator;

import java.util.Map;

public class App {
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();

        Map<Long, String> map = hzInstance.getMap("data");
        FlakeIdGenerator idGenerator = hzInstance.getFlakeIdGenerator("newId");

        for(int i = 0; i < 5; i++) {
            Thread.sleep(5000);
            System.out.println("add " + i);
            map.put(idGenerator.newId(), "Node 2 message " + i);
        }
    }
}
