// File: mockito4/AccountServiceTest.java
package mockito4;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AccountServiceTest {

    @Test
    public void testSuccessfulTransfer() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);

        Account acc1 = new Account("A1", 1000);
        Account acc2 = new Account("A2", 500);

        when(repo.findById("A1")).thenReturn(acc1);
        when(repo.findById("A2")).thenReturn(acc2);

        AccountService service = new AccountService(repo, notify);
        boolean result = service.transfer("A1", "A2", 300);

        assertTrue(result);
        assertEquals(700, acc1.getBalance(), 0.01);
        assertEquals(800, acc2.getBalance(), 0.01);
        verify(repo, times(2)).update(any(Account.class));
        verify(notify).send("A1", "Transferred Rs.300.0 to A2");
    }

    @Test
    public void testTransferFailsDueToLowBalance() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);

        Account acc1 = new Account("A1", 200);
        Account acc2 = new Account("A2", 500);

        when(repo.findById("A1")).thenReturn(acc1);
        when(repo.findById("A2")).thenReturn(acc2);

        AccountService service = new AccountService(repo, notify);
        boolean result = service.transfer("A1", "A2", 300);

        assertFalse(result);
        verify(repo, never()).update(any());
        verify(notify, never()).send(anyString(), anyString());
    }

    @Test
    public void testTransferFailsIfAccountMissing() {
        AccountRepository repo = mock(AccountRepository.class);
        NotificationService notify = mock(NotificationService.class);

        when(repo.findById("A1")).thenReturn(null);
        when(repo.findById("A2")).thenReturn(new Account("A2", 500));

        AccountService service = new AccountService(repo, notify);
        boolean result = service.transfer("A1", "A2", 100);

        assertFalse(result);
        verify(repo, never()).update(any());
        verify(notify, never()).send(anyString(), anyString());
    }
}
