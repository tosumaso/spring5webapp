package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;

class OwnerTest implements ModelTests{

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
                        () -> assertEquals("Buck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Did Not Match"),
                        () -> assertEquals("1231231234", owner.getTelephone())
                ));

        assertThat(owner.getCity(), is("Key West"));
    }
    
    @DisplayName("Value Source Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @ValueSource(strings = {"Spring","Framework","Tom"})
    void testValueSorce(String val) {
    	System.out.println(val);
    }
    
    @DisplayName("Enum Source Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @EnumSource(OwnerType.class)
    void EnumTest(OwnerType ownerType) {
    	System.out.println(ownerType);
    }
    
    @DisplayName("CSV Input Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @CsvSource({
    	"FL,1,1",
    	"OH,2,2",
    	"MI,1,1"
    })
    void csvInputTest(String stateName, int val1, int val2) {
    	System.out.println(stateName + "=" + val1 + "=" +val2);
    }
    
    @DisplayName("CSV From File Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @CsvFileSource(resources ="/input.csv",numLinesToSkip =1)
    void csvFromFileTest(String stateName, int val1, int val2) {
    	System.out.println(stateName + "=" + val1 + "=" +val2);
    }
    
    @DisplayName("Method Provider Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
    	System.out.println(stateName + "=" + val1 + "=" +val2);
    }
    
    static Stream<Arguments> getArgs(){
    	return Stream.of(
    			Arguments.of("FL",5,1),
    			Arguments.of("OH",2,8),
    			Arguments.of("MI",3,5));
    }
    
    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name= "{displayName} - [{index}] - {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
    	System.out.println(stateName + "=" + val1 + "=" +val2);
    }
}