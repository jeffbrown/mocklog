package mocklog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Library {
    private static final Logger LOGGER = LoggerFactory.getLogger(Library.class);

    public void someMethod(String name) {
        LOGGER.debug("Hello " + name);
    }

}
