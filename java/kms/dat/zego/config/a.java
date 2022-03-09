package kms.dat.zego.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class a implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
        Path uploadImageDir = Paths.get("./src/main/resources/static/img");
        String updloadPath = uploadImageDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/img/**").addResourceLocations("file:/"+updloadPath+"/");
    }

}
