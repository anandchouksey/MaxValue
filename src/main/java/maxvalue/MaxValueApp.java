package maxvalue;

import maxvalue.service.ConsoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MaxValueApp {

    public static void main(String args[]) {
        ApplicationContext applicationContext = SpringApplication.run(MaxValueApp.class, args);
        ConsoleService consoleService = applicationContext.getBean(ConsoleService.class);
        consoleService.execute();
    }
}
