package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String NUMBER_RANGE_ERROR = "로또 번호 범위가 벗어났습니다.";

    private final int lottoNumber;

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber > MAXIMUM_NUMBER || lottoNumber < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }

    public static LottoNumber from(int number) {
        return CACHE.computeIfAbsent(number, LottoNumber::new);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
