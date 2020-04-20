package hate.hateee.mdls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RestApiData {

    @JsonProperty("name")
    private String countryName;

    @JsonProperty("region")
    private String region;

    @JsonProperty("languages.name")
    private String language;
}
