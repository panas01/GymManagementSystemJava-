package GYM_CW;

public class RegularMember extends GymMember {
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    // Accessor methods
    public int getAttendanceLimit() { return attendanceLimit; }
    public boolean getIsEligibleForUpgrade() { return isEligibleForUpgrade; }
    public String getRemovalReason() { return removalReason; }
    public String getReferralSource() { return referralSource; }
    public String getPlan() { return plan; }
    public double getPrice() { return price; }

    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 5;
        if (this.getAttendance() >= attendanceLimit) {
            this.isEligibleForUpgrade = true;
        }
    }

    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) {
            return "Member is not eligible for upgrade. Attendance must be >= " + attendanceLimit;
        }
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Member is already subscribed to the " + newPlan + " plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selected.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " successfully. New price: " + newPrice;
    }

    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder(super.display());
        sb.append("Plan: ").append(plan).append("\n");
        sb.append("Price: ").append(price).append("\n");
        if (!removalReason.isEmpty()) {
            sb.append("Removal Reason: ").append(removalReason).append("\n");
        }
        return sb.toString();
    }
}