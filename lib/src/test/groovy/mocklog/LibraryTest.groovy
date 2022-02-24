package mocklog


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

import static org.mockito.Mockito.mockStatic

class LibraryTest extends Specification {
    def "test mocking out static property"() {
        setup:
        def loggedValue
        def logger = Mock(Logger) {
            1 * debug(_ as String) >> { arg ->
                loggedValue = arg[0]
            }
        }
        def mockFactory = mockStatic(LoggerFactory)
        mockFactory.when(() -> LoggerFactory.getLogger((Library))).thenReturn(logger)

        when:
        new Library().someMethod('Jeff')

        then:
        loggedValue == 'Hello Jeff'
    }
}
