package lotto.domain;

public class LottoMachine {
    private final LottoNumberGenerator manualLottoNumberGenerator;
    private final LottoNumberGenerator randomLottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator manualLottoNumberGenerator, LottoNumberGenerator randomLottoNumberGenerator) {
        this.manualLottoNumberGenerator = manualLottoNumberGenerator;
        this.randomLottoNumberGenerator = randomLottoNumberGenerator;
    }

    public LottoTickets buyLottoTickets(PurchasingInfo purchasingInfo) {
        LottoTickets manualLottoTickets = LottoTickets.generateLottoTickets(purchasingInfo.getManualTicketCounts(), manualLottoNumberGenerator);
        LottoTickets autoLottoTickets = LottoTickets.generateLottoTickets(purchasingInfo.getAutoTicketCounts(), randomLottoNumberGenerator);
        return manualLottoTickets.addAll(autoLottoTickets);
    }
}
