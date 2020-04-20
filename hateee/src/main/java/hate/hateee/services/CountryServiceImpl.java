package hate.hateee.services;

import hate.hateee.clients.CountryClient;
import hate.hateee.mdls.RestSimpleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private List<CountryClient> list;

    @Override
    public Flux<RestSimpleData> getAll() {
        List<Flux<RestSimpleData>> pek = list.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(pek);
    }

    private Flux<RestSimpleData> getAll(CountryClient client) {
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}
