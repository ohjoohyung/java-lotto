package lotto.domain;

public class PurchasingInfo {
    private static final String TICKET_COUNTS_RANGE_ERROR = "구매 가능한 티켓 개수 범위를 벗어났습니다.";
    private final Money money;
    private final int manualTicketCounts;

    private PurchasingInfo(Money money, int manualTicketCounts) {
        if (manualTicketCounts < 0 || money.calculatePurchasableTicketCounts() - manualTicketCounts < 0) {
            throw new IllegalArgumentException(TICKET_COUNTS_RANGE_ERROR);
        }
        this.money = money;
        this.manualTicketCounts = manualTicketCounts;
    }

    public static PurchasingInfo of(Money money, int manualTicketCounts) {
        return new PurchasingInfo(money, manualTicketCounts);
    }

    public int getManualTicketCounts() {
        return manualTicketCounts;
    }

    public int getAutoTicketCounts() {
        return money.calculatePurchasableTicketCounts() - manualTicketCounts;
    }
}
