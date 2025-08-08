package mockito2;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder_CallsProcessPaymentOnce() {
        // Arrange
        PaymentService paymentServiceMock = mock(PaymentService.class);
        OrderService orderService = new OrderService(paymentServiceMock);

        // Act
        orderService.placeOrder();

        // Assert
        verify(paymentServiceMock, times(1)).processPayment();
    }
}
