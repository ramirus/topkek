package hate.hateee.clients;

import hate.hateee.mdls.RestApiData;
import hate.hateee.mdls.RestSimpleData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Component
public class CountryClient {

    private WebClient client;

    public CountryClient(@Value("${rest.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 100))
                        .build())
                .baseUrl(url)
                .build();
    }

    public Flux<RestSimpleData> getAll() {
        return client.get()
                .accept(MediaType.ALL)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(RestApiData[].class))
                .flatMapIterable(Arrays::asList)
                .map(data -> RestSimpleData.builder()
                        .countryName(data.getCountryName())
//                        .language(data.getLanguage())
                        .build());
    }
}
