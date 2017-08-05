package de.benjitrapp.test.gosu

import org.junit.Test
import org.junit.runner.RunWith
import spock.lang.Specification
/**
 * CAUTION: This class is still under construction to evaluate mocking frameworks in combination with
 *          Spock and GOSU. Currently a lot of tests will fail!
 */
class HelloMockSpec extends Specification{
  HelloWorld hw

  def setup(){
    hw = new HelloWorld()
  }

  def "comparing two values and getting the biggest of the mocked class back"(){
    given: "two mock instances of MockMe"
    MockMe mockMe1 = Mock(MockMe.class)
    MockMe mockMe2 = Mock(MockMe.class)

    when: "the values of the MockMe are passed to the HW.compare method and should return the values 21 and 42"
    mockMe1.mockVal >> 21
    mockMe2.mockedValue >> 42
    def result = hw.compareAndReturnBiggestNumber(mockMe1,mockMe2)

    then: "after the comparison, the value 42 is assumed to be returned"
    result == 42
  }

  def "mock that throws a runtime exception"(){
    given:
    MockMe mockMe = Mock(MockMe.class)

    when:
    mockMe.mockedValue >> { throw new RuntimeException("BAM")}
    def result = mockMe.mockedValue

    then:
    thrown(RuntimeException.class)
    result == null
  }

  def "helloWorldMock class should return mocked - Using mock()"(){
    given:
    String MOCKED = "MOCKED"
    HelloWorld helloWorldMock = Mock(HelloWorld.class)

    when:
    helloWorldMock.helloWorld(_) >> MOCKED
    String result = helloWorldMock.helloWorld("test")

    then:
    result == MOCKED
  }
}
