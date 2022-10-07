package booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailAddress {

    private String name;
    private String domain;

    @Override
    public String toString() {
        return getName() + '@' + getDomain();
    }

}
