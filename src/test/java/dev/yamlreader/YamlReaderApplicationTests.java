package dev.yamlreader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.yamlreader.product.ProductController;

@SpringBootTest
class YamlReaderApplicationTests {
	@Autowired
	ProductController productController;

	@Test
	void contextLoads() {
	}

}
