/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 11:47 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Swagger3Configuration
{
    @Value("${app.version}")
    private String appVersion;

    @Value("${server.servlet.context-path}")
    private String context;

    private Info apiInfo(){
        Contact contact = new Contact();
        contact.setName("abcbank");
        contact.setUrl("https://abcbank.com");
        contact.setEmail("yaser.rguez@gmail.com");
        License license = new License();
        license.setName("LICENSE");
        license.setUrl("LICENSE URL");
        Info info = new Info();
        info.setTitle("ABCBank Service API");
        info.setContact(contact);
        info.setDescription("API de los servicios de ABCBank");
        info.setVersion(appVersion);
        info.setTermsOfService("http://abcbank.com/terms");
        info.setLicense(new License());
        return info;
    }

    @Bean
    public OpenAPI api(){
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(apiInfo());
        openAPI.setServers(servers());
        return openAPI;
    }

    @Bean
    public List<Server> servers(){
        List<Server> servers = new ArrayList<Server>();

        Server localhost = new Server();
        localhost.setUrl("http://localhost:" + "8090" + context);
        servers.add(localhost);

        return servers;
    }
}
