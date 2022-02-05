package org.setronica.pim;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"spring.config.name=setronica"})
@SpringBootTest
class SetronicaPimApplicationTests {

	@Test
	void contextLoads() {
	}

}
