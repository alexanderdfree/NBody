/*
A class for implementing simple test cases in other classes

Author: Owen Coyle

Last Updated: 10/15/2019
*/

public class Testing{
   public static void testEquals(String caseID, Object result, Object expected){
      /*
      Tests whether the output is equal to what was expected.
      Prints out a descriptive test message
      
      Inputs:
         String caseID: the ID of this test case, e.g. "Test 1"
         Object result: the actual result of some function call
         Object expected: the expected result of some function call
         
      Outputs:
         Prints: a message describing the results of the test
      
      Ex.
      testEquals("Test 1", 4.0, 3.0) -> "Test 1: result: 4.0, expected: 3.0
      testEquals("Test 2", true, true) -> "Test 2: OK"
      testEquals("Test 3", 1, 1.0) -> "Test 3: result 1, expected 1.0"
      */
      if(result.equals(expected)){
         System.out.println(caseID + ": OK");
      }
      else{
         System.out.println(caseID + ": result: " + result + ", expected: " + expected);
      }
   }
}