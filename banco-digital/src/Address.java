import java.util.UUID;

public record Address(String country,
                      String zipCode,
                      String state,
                      String city,
                      String street,
                      String number,
                      String complement) {
}
