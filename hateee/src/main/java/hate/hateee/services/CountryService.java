package hate.hateee.services;

import hate.hateee.mdls.RestSimpleData;
import reactor.core.publisher.Flux;

public interface CountryService {
    Flux<RestSimpleData> getAll();

}
