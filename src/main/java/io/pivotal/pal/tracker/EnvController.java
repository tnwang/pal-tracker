package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiwang on 11/6/18.
 */
@RestController
public class EnvController {

    Map<String, String> map = new HashMap<>();

    public EnvController (@Value("${PORT:NOT SET}") String port,
                          @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                          @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex,
                          @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstanceAddr) {
        map.put("PORT",port);
        map.put("MEMORY_LIMIT",memoryLimit);
        map.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        map.put("CF_INSTANCE_ADDR",cfInstanceAddr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return map;
    }


}
