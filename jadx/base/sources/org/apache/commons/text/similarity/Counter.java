package org.apache.commons.text.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Counter {
    private Counter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$of$0(CharSequence charSequence, Integer num) {
        return Integer.valueOf(num != null ? 1 + num.intValue() : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$of$1(Map map, CharSequence charSequence) {
        map.compute(charSequence, new C13964a());
    }

    /* JADX INFO: renamed from: of */
    public static Map<CharSequence, Integer> m14960of(CharSequence[] charSequenceArr) {
        HashMap map = new HashMap();
        Stream.of((Object[]) charSequenceArr).forEach(new C13965b(map, 0));
        return map;
    }
}
