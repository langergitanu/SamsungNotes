package org.apache.commons.lang3.stream;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import org.apache.commons.lang3.stream.Streams;

/* JADX INFO: renamed from: org.apache.commons.lang3.stream.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13901b implements BinaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9932a;

    public /* synthetic */ C13901b(int i) {
        this.f9932a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f9932a) {
            case 0:
                StringBuilder sb = (StringBuilder) obj;
                sb.append((CharSequence) obj2);
                return sb;
            case 1:
                return ((StringJoiner) obj).merge((StringJoiner) obj2);
            default:
                return Streams.ArrayCollector.lambda$combiner$0((List) obj, (List) obj2);
        }
    }
}
