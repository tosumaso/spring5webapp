package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelRepeatedTest;

public class PersonRepeatedTest implements ModelRepeatedTest{
	
//  @RepeatedTest(value=10, name="{displayName} : {currentRepetition} - {totalRepetitions}")
//  @DisplayName("My Repeated Name")
//  void myRepeatedTest() {
//  	
//  }
  
  @RepeatedTest(5)
  void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
  	System.out.println(testInfo.getDisplayName() + ":" + repetitionInfo.getCurrentRepetition());
  	System.out.println(testInfo.getTags() + ":" + testInfo.getTestMethod() + ":" + testInfo.getTestClass());
  }
  
  @RepeatedTest(value=10, name="{displayName} : {currentRepetition} | {totalRepetitions}")
  @DisplayName("My Assignment Repeated Test")
  void myAssignmentRepeated() {
  	
  }
}
