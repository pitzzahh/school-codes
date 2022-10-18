package atm;

import io.github.pitzzahh.util.utilities.classes.enums.Gender;
import io.github.pitzzahh.util.utilities.classes.Person;
import io.github.pitzzahh.atm.service.AtmService;
import io.github.pitzzahh.util.utilities.Print;
import io.github.pitzzahh.atm.entity.Client;
import io.github.pitzzahh.atm.dao.InMemory;
import io.github.pitzzahh.atm.entity.Loan;
import java.util.Collection;
import java.time.LocalDate;
import java.util.Optional;
import java.time.Month;
import java.util.Map;

public class Atm {
    public static void main(String[] args) {
        var service = new AtmService(new InMemory());

        service.saveClient()
                .apply(makeTrexie());

        getTrexie(service).ifPresent(Print::println);

        var loan =  new Loan(
                makeTrexie().accountNumber(),
                LocalDate.now(),
                1000,
                true
        );

        service.requestLoan().apply(loan);
        service.requestLoan().apply(loan);
        service.declineLoan().apply(loan);

        var apply1 = service.getMessage().apply(makeTrexie().accountNumber());

        apply1.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(makeTrexie().accountNumber()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .toList()
                .forEach(Print::println);

        getTrexie(service).ifPresent(Print::println);
    }

    private static Optional<Client> getTrexie(AtmService service) {
        return service.getClientByAccountNumber().apply(makeTrexie().accountNumber());
    }

    private static Client makeTrexie() {
        return  new Client(
                "123123123",
                "123123",
                new Person(
                        "Trexie",
                        "Preña",
                        Gender.FEMALE,
                        "Earth",
                        LocalDate.of(2001, Month.OCTOBER, 10)
                ),
                5000,
                false
        );
    }
}
