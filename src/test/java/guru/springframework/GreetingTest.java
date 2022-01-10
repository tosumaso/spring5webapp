package guru.springframework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetingTest {
	private Greeting greeting;

	@BeforeAll
	static void beforeClass() {
		System.out.println("BEFORE ALL");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("BEFORE EACH ...");
		greeting = new Greeting();
	}
	
	@Test
	void helloWorld() {
		System.out.println(greeting.helloWorld());
	}
	
	@Test
	void helloWorld1() {
		System.out.println(greeting.helloWorld("TOM"));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("AFTER EACH ..");
	}
	
	@AfterAll
	static void afterClass() {
		System.out.println("AFTER ALL");
	}
}
