package TierraMedia;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class tierraMediaTest {

	@Test
	void testSistema() throws IOException, SQLException {
		Sistema sistema = new Sistema();
		sistema.menu();
	}

}
