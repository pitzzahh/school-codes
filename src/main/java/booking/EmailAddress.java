package booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailAddress {

    private String name;
    private String domain;

    @Override
    public String toString() {
        return getName() + '@' + getDomain();
    }

}
