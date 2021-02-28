package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private static final List<LottoNumber> NUMBERS = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
            .boxed()
            .map(LottoNumber::from)
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(NUMBERS);
        return NUMBERS.subList(0, 6);
    }
}
