package booking;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddressBookEntry {
    private String name;
    private String address;
    private long telephoneNumber;
    private EmailAddress emailAddress;


}
