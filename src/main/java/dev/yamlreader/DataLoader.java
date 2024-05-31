package dev.yamlreader;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.yamlreader.product.ProductRepository;
import dev.yamlreader.store.Store;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);
    private final ObjectMapper objectMapper;
    private final ProductRepository productRepository;

    public DataLoader(ObjectMapper objectMapper, ProductRepository productRepository) {
        this.objectMapper = objectMapper;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/products.yaml")) {
            Store store = objectMapper.readValue(inputStream, Store.class);
            store.products().forEach(productRepository::create);
        } catch (IOException e) {
            log.error("Unable to load products: " + e.getMessage());
        }

    }

}
