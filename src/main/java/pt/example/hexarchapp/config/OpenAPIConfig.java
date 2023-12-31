package pt.example.hexarchapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(getInfo());
    }

    private Info getInfo() {
        Map<String, String> properties = getMavenProperties();
        return new Info()
                .title(properties.getOrDefault("name", "Hex Arch App"))
                .version(properties.getOrDefault("version", ""))
                .description(properties.getOrDefault("description", ""));
    }

    public Map<String, String> getMavenProperties() {
        Map<String, String> mavenMap = new HashMap<>();
        try {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(new FileReader("pom.xml"));
            mavenMap.put("version", model.getVersion());
            mavenMap.put("name", model.getName());
            mavenMap.put("description", model.getDescription());
        } catch (Exception ignored) {
            // Ignored
        }
        return mavenMap;
    }
}
