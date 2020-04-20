package hate.hateee.clients;

import hate.hateee.mdls.AllDTO;
import hate.hateee.mdls.RandomString;
import hate.hateee.mdls.SimpleRandom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Component
public class ClientWithAllData {

    private WebClient client;


    public ClientWithAllData(@Value("${all.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 100))
                        .build())
                .baseUrl(url)
                .build();
    }


    public Flux<AllDTO> getAll() {
        return client.get()
                .accept(MediaType.ALL)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(RandomString[].class))
                .flatMapIterable(Arrays::asList)
                .map(data -> AllDTO.builder()
                        .value(data.getSecond_random())
                        .from("DB")
                        .build());
    }
}
