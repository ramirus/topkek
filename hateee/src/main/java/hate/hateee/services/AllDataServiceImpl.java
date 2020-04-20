package hate.hateee.services;

import hate.hateee.clients.ClientWithAllData;
import hate.hateee.mdls.AllDTO;
import hate.hateee.mdls.RestSimpleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllDataServiceImpl implements AllDataService {

    @Autowired
    private List<ClientWithAllData> clientWithAllData;

    @Override
    public Flux<AllDTO> getAll() {
        List<Flux<AllDTO>> pek = clientWithAllData.stream().map(this::getAll).collect(Collectors.toList());

        WebClient client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024 * 1024 * 100))
                        .build())
                .baseUrl("http://localhost:8080/restapi")
                .build();

        Flux<AllDTO> flux = client.get()
                .accept(MediaType.ALL)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(RestSimpleData[].class))
                .flatMapIterable(Arrays::asList)
                .map(data -> AllDTO.builder()
                        .value(data.getCountryName())
                        .from("restApi")
                        .build());

        pek.add(flux);
        return Flux.merge(pek);
    }

    private Flux<AllDTO> getAll(ClientWithAllData client) {
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}
