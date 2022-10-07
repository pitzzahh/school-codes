package booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBookEntry {
    private String name;
    private String address;
    private long telephoneNumber;
    private EmailAddress emailAddress;


}
