package TierraMedia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
class tierraMediaTest {

	@Test
	void testSistema() throws IOException {
		Sistema sistema = new Sistema();
		sistema.probarSistema();
	}

}
