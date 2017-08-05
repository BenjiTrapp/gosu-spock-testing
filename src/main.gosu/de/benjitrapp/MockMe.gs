package de.benjitrapp

/**
 * CAUTION: This class is completely useless and used for understanding how to mock GOSU classes
 */
class MockMe {
  var _mockVal:int as readonly mockedValue = -1

  construct(notMockedValue:int){
    _mockVal = notMockedValue
  }

  // This is only for checking another mocking approach!
  property get mockVal():int{
    return _mockVal
  }
}