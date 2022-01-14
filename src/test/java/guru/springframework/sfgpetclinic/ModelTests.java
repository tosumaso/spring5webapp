package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model")
public interface ModelTests {

	//RepeatされないテストではメソッドのparameterにRepetitionInfoがDIされない: Repeatなしのテストだけエラーが発生する
	//単発のテストクラス、Repeatするテストクラスで実装するinterfaceを分け、単発のテストクラスの方はRepetitionInfoを引数に含まない
	
	@BeforeEach
	default void beforeEachConsoleOutputter(TestInfo testInfo) {
		System.out.println("Running Test" + testInfo.getDisplayName());
	}
}
