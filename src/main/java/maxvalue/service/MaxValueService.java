package maxvalue.service;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MaxValueService {

    private static Logger logger = LoggerFactory.getLogger(MaxValueService.class);

    public Integer findMax(int[] integers) {
        logger.info("finding max value");
        List integerList = Arrays.asList(ArrayUtils.toObject(integers));
        return (Integer) Collections.max(integerList);
    }

    public int[] update(int[] integers, int startIndex, int endIndex, int updateValue) {
        logger.info("updating the integer list");
        for (int i = startIndex; i <= endIndex; i++) {
            integers[i-1] += updateValue;
        }
        return integers;
    }
}
