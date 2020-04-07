package maxvalue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private static Logger logger = LoggerFactory.getLogger(ValidationService.class);

    public boolean validate(int input, int lowerLimit, int upperLimit) {
        if(input>=lowerLimit && input<=upperLimit) {
            return true;
        }
        logger.info("invalid input: "+input +" !Please enter again");
        return false;
    }

    public boolean validate(String []input, int length) {
        if(input.length!=length) {
            logger.info("invalid input! Only "+length+" param allowed");
            return false;
        }
        return true;
    }

    public boolean validate(int i, int j) {
        boolean inputCheck = i <= j;
        if(!inputCheck) {
            logger.info("invalid values for i,j");
        }
        return inputCheck;
    }
}
