package maxvalue.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MaxValueService.class)
public class MaxValueServiceTest {

    @Autowired
    private MaxValueService maxValueService;

    @Test
    public void shouldFindMaxInteger() {
        int[] arr= {1,2,3};
        int result = maxValueService.findMax(arr);
        assertEquals(result,3);
    }

    @Test
    public void shouldUpdateIntegers() {
        int[] arr= {1,2,3};
        arr = maxValueService.update(arr,1,2,3);
        assertEquals(arr[0],4);
    }
}
