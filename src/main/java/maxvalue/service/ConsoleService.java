package maxvalue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ConsoleService {

    private static Logger logger = LoggerFactory.getLogger(ConsoleService.class);

    @Autowired
    private MaxValueService maxValueService;

    @Autowired
    private ValidationService validationService;

    private BufferedReader reader;

    private int x = 0, y = 0, i = 0, j = 0, k = 0;

    private String[] input = {};

    private int[] integers;

    public void execute() {
        boolean executeFlag = false;
        while (!executeFlag) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            readAndValidate();
            readValidateAndUpdate();
            executeFlag = continueExecute();
        }
    }

    /**reads and validates x and y parameters
     * */
    public void readAndValidate() {
        logger.info("input values for x and y");
        boolean readValidateFlag = false;
        while (!readValidateFlag) {
            input = read();
            readValidateFlag = validationService.validate(input, 2);

            if (readValidateFlag) {
                try {
                    x = Integer.parseInt(input[0]);
                    y = Integer.parseInt(input[1]);
                    readValidateFlag = validateRange(x, y);
                } catch (NumberFormatException e) {
                    logger.info("invalid input of X and Y");
                    readValidateFlag = false;
                }
            }
        }
    }

    public String[] read() {
        try {
            input = reader.readLine().split("\\s");
        } catch (IOException e) {
            logger.error("IO Exception occurred! Application restart may require!" + e);
        }
        return input;
    }

    public boolean validateRange(int x, int y) {
        return validationService.validate(x, 3, (int) Math.pow(10, 7))
                && validationService.validate(y, 1, 2 * ((int) Math.pow(10, 5)));
    }

    /**this method reads and validates input params and updates the list
     * */
    public void readValidateAndUpdate() {
        int counter = 0;
        integers = new int[x];

        while (counter < y) {
            boolean flag = readAndValidate(false);
            flag = validateRange(i, j, k, flag);
            updateIntegers(i, j, k, flag);
            if (flag) {
                counter++;
            }
        }
        logger.info("Max value in the list: " + maxValueService.findMax(integers));
    }

    public boolean readAndValidate(boolean inputCheck) {
        while (!inputCheck) {
            input = read();
            inputCheck = validationService.validate(input, 3);

            if (inputCheck) {
                try {
                    i = Integer.parseInt(input[0]);
                    j = Integer.parseInt(input[1]);
                    k = Integer.parseInt(input[2]);
                } catch (NumberFormatException e) {
                    logger.info("invalid input of i,j, k params");
                    inputCheck = false;
                }
            }
        }
        return inputCheck;
    }

    public boolean validateRange(int i, int j, int k, boolean inputCheck) {
        return inputCheck && validationService.validate(i, j)
                && validationService.validate(i, 1, x)
                && validationService.validate(j, 1, x)
                && validationService.validate(k, 0, (int) Math.pow(10, 9));
    }

    public void updateIntegers(int i, int j, int k, boolean inputCheck) {
        if (inputCheck) {
            integers = maxValueService.update(integers, i, j, k);
        }
    }

    public boolean continueExecute() {
        logger.info("Do you wish to continue? Enter yes to continue, any other input exits the app");
        String[] input = read();
        return !input[0].equalsIgnoreCase("yes");
    }

}



