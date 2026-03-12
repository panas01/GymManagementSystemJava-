package GYM_CW;

public class PremiumMember extends GymMember {
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    // Accessor methods
    public double getPremiumCharge() { return premiumCharge; }
    public String getPersonalTrainer() { return personalTrainer; }
    public boolean getIsFullPayment() { return isFullPayment; }
    public double getPaidAmount() { return paidAmount; }
    public double getDiscountAmount() { return discountAmount; }

    public String payDueAmount(double paidAmount) {
        if (this.isFullPayment) {
            return "Payment is already full.";
        }
        this.paidAmount += paidAmount;
        if (this.paidAmount > premiumCharge) {
            this.paidAmount -= paidAmount; // Revert the payment
            return "Paid amount exceeds premium charge of " + premiumCharge;
        }
        double remainingAmount = premiumCharge - this.paidAmount;
        if (this.paidAmount == premiumCharge) {
            this.isFullPayment = true;
        }
        return "Payment successful. Remaining amount to be paid: " + remainingAmount;
    }

    public void calculateDiscount() {
        if (this.isFullPayment) {
            this.discountAmount = 0.10 * premiumCharge; // 10% discount
        } else {
            this.discountAmount = 0;
        }
    }

    public void revertPremiumMember() {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 10; // Premium members might earn more points
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder(super.display());
        sb.append("Personal Trainer: ").append(personalTrainer).append("\n");
        sb.append("Paid Amount: ").append(paidAmount).append("\n");
        sb.append("Is Full Payment: ").append(isFullPayment).append("\n");
        double remainingAmount = premiumCharge - paidAmount;
        sb.append("Remaining Amount: ").append(remainingAmount).append("\n");
        if (isFullPayment) {
            sb.append("Discount Amount: ").append(discountAmount).append("\n");
        }
        return sb.toString();
    }
}