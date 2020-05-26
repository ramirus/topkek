package hate.hateee.contrls;

import hate.hateee.mdls.AllDTO;
import hate.hateee.mdls.RandomString;
import hate.hateee.mdls.RestSimpleData;
import hate.hateee.services.AllDataService;
import hate.hateee.services.CountryService;
import hate.hateee.services.MegaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ApiController {

    @Autowired
    private CountryService service;

    @Autowired
    private MegaTableService megaTableService;

    @Autowired
    private AllDataService allDataService;

    @GetMapping(value = "/restapi", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<RestSimpleData> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/mega", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<RandomString> getAllMegas() {
        return megaTableService.getAllRandom();
    }

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AllDTO> getAl() {
        return  allDataService.getAll();
    }
}

