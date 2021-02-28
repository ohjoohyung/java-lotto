package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int VALID_LOTTO_NUMBER_COUNTS = 6;
    private static final String INVALID_LOTTO_NUMBER_COUNTS = "로또 티켓은 중복되지 않은 6자리의 숫자로 구성되어야 합니다.";
    
    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateNumberCounts(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket generateTicket(List<LottoNumber> numbers) {
        return numbers.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), LottoTicket::new));
    }

    public static LottoTicket generateTicketByInteger(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), LottoTicket::new));
    }

    private static void validateNumberCounts(int numberCounts) {
        if (numberCounts != VALID_LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNTS);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public int getMatchCounts(LottoTicket lottoTicket) {
        this.lottoNumbers.retainAll(lottoTicket.lottoNumbers);
        return this.lottoNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }
}
