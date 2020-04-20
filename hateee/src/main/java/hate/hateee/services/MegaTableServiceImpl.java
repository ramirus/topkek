package hate.hateee.services;

import hate.hateee.mdls.RandomString;
import hate.hateee.reps.MegaTableRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class MegaTableServiceImpl implements MegaTableService {

    @Autowired
    private MegaTableRep rep;

    @Override
    public Flux<RandomString> getAllRandom() {
        return Flux.fromIterable(rep.getAll());
    }
}
