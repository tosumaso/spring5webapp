package guru.springframework.sfgpetclinic;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
    			Arguments.of("FL",50,10),
    			Arguments.of("OH",20,80),
    			Arguments.of("MI",30,50));
	}
}
