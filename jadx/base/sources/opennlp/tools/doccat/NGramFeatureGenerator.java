package opennlp.tools.doccat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.util.InvalidFormatException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramFeatureGenerator implements FeatureGenerator {
    private final int maxGram;
    private final int minGram;

    public NGramFeatureGenerator(int i, int i2) throws InvalidFormatException {
        if (i <= 0 || i2 <= 0) {
            throw new InvalidFormatException("Both minimum range value (minGram) & maximum range value (maxGram) should be greater than or equal to 1!");
        }
        if (i > i2) {
            throw new InvalidFormatException("Minimum range value (minGram) should be less than or equal to maximum range value (maxGram)!");
        }
        this.minGram = i;
        this.maxGram = i2;
    }

    @Override // opennlp.tools.doccat.FeatureGenerator
    public Collection<String> extractFeatures(String[] strArr, Map<String, Object> map) {
        int i;
        Objects.requireNonNull(strArr, "text must not be null");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 <= strArr.length - this.minGram; i2++) {
            StringBuilder sb = new StringBuilder("ng=");
            int i4 = 0;
            while (i4 < this.maxGram && (i = i2 + i4) < strArr.length) {
                sb.append(":");
                sb.append(strArr[i]);
                i4++;
                if (this.maxGram >= i4 && i4 >= this.minGram) {
                    arrayList.add(sb.toString());
                }
            }
        }
        return arrayList;
    }

    public NGramFeatureGenerator() {
        this(2, 2);
    }
}
