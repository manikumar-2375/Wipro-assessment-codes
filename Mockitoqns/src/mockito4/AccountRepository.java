// File: mockito4/AccountRepository.java
package mockito4;

public interface AccountRepository {
    Account findById(String id);
    void update(Account account);
}