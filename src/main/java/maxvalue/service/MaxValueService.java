package maxvalue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class MaxValueService {

    private static Logger logger = LoggerFactory.getLogger(MaxValueService.class);

    public Integer findMax(int[] integers) {
        logger.info("finding max value");
        return Arrays.stream(integers).max().getAsInt();
    }

    public int[] update(int[] integers, int startIndex, int endIndex, int updateValue) {
        logger.info("updating the integer list");
        for (int i = startIndex; i <= endIndex; i++) {
            integers[i-1] += updateValue;
        }
        return integers;
    }
}
