package org.gabriel.jwtspring.infra;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuração explícita do servlet do console H2.
 *
 * O H2 está declarado com escopo runtime, então usamos
 * ServletContextInitializer para registrar o servlet em tempo de execução.
 */
@Configuration
public class H2ConsoleConfig implements ServletContextInitializer {

	private static final Logger logger = LoggerFactory.getLogger(H2ConsoleConfig.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		try {
			// Tenta localizar o servlet do console do H2 (nomes conhecidos).
			Class<?> servletClass;
			try {
				servletClass = Class.forName("org.h2.server.web.JakartaWebServlet");
				logger.info("Usando JakartaWebServlet do H2");
			} catch (ClassNotFoundException ex) {
				servletClass = Class.forName("org.h2.server.web.WebServlet");
				logger.info("Usando WebServlet do H2");
			}

			Object servlet = servletClass.getDeclaredConstructor().newInstance();
			servletContext.addServlet("h2console", (jakarta.servlet.Servlet) servlet)
					.addMapping("/h2-console", "/h2-console/*");
			logger.info("Console H2 registrado com sucesso em /h2-console");
		} catch (Exception ex) {
			logger.error("Não foi possível registrar o console H2", ex);
		}
	}
}
