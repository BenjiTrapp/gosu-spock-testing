package de.benjitrapp.test.gosu

class HelloWorld {
  function helloWorld(name : String) : String {
    return name
  }

  function compareAndReturnBiggestNumber(m1 : MockMe, m2: MockMe):int {
    var tmp1 = m1.mockVal
    var tmp2 = m2.mockedValue

    assert tmp1 >= 0 || tmp2 >= 0

    if(tmp1 == tmp2){
      return tmp1
    }

    return tmp1 > tmp2 ? tmp1:tmp2;
  }
}