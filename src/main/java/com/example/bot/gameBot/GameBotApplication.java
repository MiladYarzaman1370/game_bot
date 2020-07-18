package com.example.bot.gameBot;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class GameBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(GameBotApplication.class, args);
	}
	@Bean
	public ServletWebServerFactory serveltContainer(){
		TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory(){
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint=new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDEITIAL");
				SecurityCollection securityCollection=new SecurityCollection();
				securityCollection.addPattern("/*");
				securityConstraint.addCollection(securityCollection);
				context.addConstraint(securityConstraint);
			}
		};
        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
		return tomcat;
	}

	private Connector httpToHttpsRedirectConnector() {
		Connector connector=new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8082);
		connector.setSecure(false);
		connector.setRedirectPort(443);
		return connector;
	}

}
