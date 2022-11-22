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
                .apply(makePeter());

        getPeter(service).ifPresent(Print::println);

        var loan =  new Loan(
                makePeter().accountNumber(),
                LocalDate.now(),
                1000,
                true
        );

        service.requestLoan().apply(loan);
        service.requestLoan().apply(loan);
        service.declineLoan().apply(loan);

        var apply1 = service.getMessage()
                .apply(makePeter().accountNumber());

        apply1.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(makePeter().accountNumber()))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .toList()
                .forEach(Print::println);

        getPeter(service).ifPresent(Print::println);
    }

    private static Optional<Client> getPeter(AtmService service) {
        return service.getClientByAccountNumber().apply(makePeter().accountNumber());
    }

    private static Client makePeter() {
        return  new Client(
                "123123123",
                "123123",
                new Person(
                        "Peter John",
                        "Arao",
                        Gender.MALE,
                        "Earth",
                        LocalDate.of(2002, Month.AUGUST, 24)
                ),
                5000,
                false
        );
    }
}
