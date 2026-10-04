package opennlp.tools.util;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SequenceCodec<T> {
    public static final String DEFAULT_PREFIX = "default-";

    boolean areOutcomesCompatible(String[] strArr);

    SequenceValidator<T> createSequenceValidator();

    Span[] decode(List<T> list);

    T[] encode(Span[] spanArr, int i);
}
