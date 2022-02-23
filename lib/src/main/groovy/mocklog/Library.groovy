package mocklog

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Library {
    private static final Logger LOGGER = LoggerFactory.getLogger(Library)

    void someMethod(String name) {
        LOGGER.debug "Hello $name"
    }
}
