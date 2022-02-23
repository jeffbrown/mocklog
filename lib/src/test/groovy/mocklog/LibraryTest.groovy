package mocklog

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

class LibraryTest extends Specification {
    def "test mocking out static property"() {
        setup:
        def loggedValue
        def logger = Mock(Logger) {
            1 * debug(_ as String) >> { arg ->
                loggedValue = arg[0]
            }
        }
        GroovySpy(LoggerFactory, global: true)
        1 * LoggerFactory.getLogger(_) >> logger

        when:
        new Library().someMethod('Jeff')

        then:
        loggedValue == 'Hello Jeff'
    }
}
