import de.benjitrapp.HelloWorld
import de.benjitrapp.MockMe
import spock.lang.Specification
import spock.lang.Unroll

class HelloWorldSpec extends Specification {
  MockMe mockMe1
  MockMe mockMe2
  HelloWorld hw

  def setup(){
    hw = new HelloWorld()
  }

  @Unroll
  def "test hello world gosu"(String expectedResult, String name){
    given: "an instance of the HelloWorld class"
    def helloWorld = new HelloWorld()

    when: "the helloWorld method is called"
    def result = helloWorld.helloWorld(name)

    then: "the passed value should be returned and match the expected rsult"
    result == expectedResult

    where:
    expectedResult || name
    "Hello World"  || "Hello World"
    null           || null
    "Hello"        || "hello" //This test is assumed to fail! Do not change it :-)
  }

  @Unroll
  def "comparison between two values should return the bigger value"(int value1, int value2, int expectedResult){
    given: "two valid instances of MockMe"
    mockMe1 = new MockMe(value1)
    mockMe2 = new MockMe(value2)

    when: "the MockMe instances are compared"
    def result = hw.compareAndReturnBiggestNumber(mockMe1,mockMe2)

    then: "the biggest number should be returned"
    result == expectedResult

    where:
    value1 | value2 || expectedResult
    0      | 0      || 0
    1      | 1      || 1
    1      | 42     || 42
    4711   | 1337   || 4711
  }

  def "comparison with negative values should trigger an AssertionError exception"(){
    given: "a negative value in the MockMe instances"
    mockMe1 = new MockMe(-42)
    mockMe2 = new MockMe(-4711)

    when: "the instances are compared"
    def result = hw.compareAndReturnBiggestNumber(mockMe1,mockMe2)

    then: "an AssertionError should be thrown"
    thrown(AssertionError.class)
    result == null
  }
}
