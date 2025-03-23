package org.example.librarymusic.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .servers(
                        List.of(
                                new Server().url("http://localhost:8787/api/v1")
                        )
                )
                .info(
                        new Info()
                                .title("Library Music API")
                                .description("API для управления музыкальной библиотекой")
                                .version("1.0")
                )
                .addTagsItem(new Tag().name("music_controller"));
    }

    @Bean
    public GroupedOpenApi musicApi() {
        return GroupedOpenApi.builder()
                .group("music-controller") // Это имя вашей группы
                .pathsToMatch("/musics/**") // Убедитесь, что это ваши маршруты
                .build();
    }
}