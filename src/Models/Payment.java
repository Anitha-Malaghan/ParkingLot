package Models;

public class Payment extends BaseEntity{
    private int number;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
