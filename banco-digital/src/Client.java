import java.time.LocalDate;

public record Client(String id, String name, LocalDate birthYear, String fatherName, String motherName, Address address) {
}
