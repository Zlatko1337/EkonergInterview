package hr.ekonerg.ekonerginterview;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import hr.ekonerg.ekonerginterview.service.IExcelDataService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "hr.ekonerg.ekonerginterview" })
@EnableJpaRepositories(basePackages = "hr.ekonerg.ekonerginterview.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = "hr.ekonerg.ekonerginterview.entity")
public class EkonergInterviewApplication {

	@Autowired
	IExcelDataService excelservice;

	public static void main(String[] args) {
		if (!Desktop.isDesktopSupported()) {
			System.out.println("App needs a desktop manager to run, exiting.");
			System.exit(1);
		}

		SpringApplicationBuilder builder = new SpringApplicationBuilder(EkonergInterviewApplication.class);
		builder.headless(false).run(args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openBrowserAfterStartup() throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("http://localhost:8080/"));
	}

	@PostConstruct
	public void excelToDatabase() throws IOException {
		excelservice.saveExcelData(excelservice.getExcelDataAsList());
	}

}
