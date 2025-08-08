// File: mockito4/AccountService.java
package mockito4;

public class AccountService {
    private AccountRepository repository;
    private NotificationService notifier;

    public AccountService(AccountRepository repository, NotificationService notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    public boolean transfer(String fromId, String toId, double amount) {
        Account from = repository.findById(fromId);
        Account to = repository.findById(toId);

        if (from == null || to == null) {
            return false;
        }

        if (from.getBalance() < amount) {
            return false;
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repository.update(from);
        repository.update(to);
        notifier.send(fromId, "Transferred Rs." + amount + " to " + toId);

        return true;
    }
}