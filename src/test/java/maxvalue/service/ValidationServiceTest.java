package maxvalue.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ValidationService.class)
public class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;

    @Test
    public void shouldValidateRange() {
        assertTrue(validationService.validate(3,3,4));
    }

    @Test
    public void shouldValidateParamNo() {
        String []arr = {"a","a","a"};
        assertTrue(validationService.validate(arr,3));
    }

    @Test
    public void shouldValidateParams() {
        int i = 1, j = 2;
        assertTrue(validationService.validate(i,j));
    }
}
