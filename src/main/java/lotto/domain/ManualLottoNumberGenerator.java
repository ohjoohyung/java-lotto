package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {
    private final List<List<Integer>> numberGroup;
    private int index;

    public ManualLottoNumberGenerator(List<List<Integer>> numberGroup) {
        this.numberGroup = numberGroup;
        this.index = 0;
    }

    @Override
    public List<LottoNumber> generate() {
        return numberGroup.get(index++).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
