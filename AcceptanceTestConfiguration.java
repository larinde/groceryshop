/**
 *
 */
package at.sitsolutions.services.ebv.licenceholder;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import at.sitsolutions.services.ebv.licenceholder.steps.LicenceHolderServiceSteps;

@Configuration
//@Import({LicenceHolderServiceSteps.class, LicenceHolderRestClient.class})
@ComponentScan("at.sitsolutions.services.ebv.licenceholder.*")
public class AcceptanceTestConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        HttpMessageConverter  jsonMessageConverter = new
//        List<HttpMessageConverter<?>> messageConverters;
        RestTemplate restTemplate = new RestTemplate(requestFactory);
//		restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    public LicenceHolderRestClient licenceHolderRestClient() {
    	String baseUrl = "http://localhost:9988/ebv-licenceholder/rest/licenceholders";
    	//String baseUrl = "https://bc-api.dev.imcplus.net/ebv-licenceholder/rest/licenceholders"
        return new LicenceHolderRestClient(baseUrl, restTemplate());
    }

    @Bean
    public LicenceHolderServiceSteps licenceHolderServiceSteps() {
    	return new LicenceHolderServiceSteps(licenceHolderRestClient());

	}

}
