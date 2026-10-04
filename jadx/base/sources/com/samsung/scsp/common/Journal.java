package com.samsung.scsp.common;

import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface Journal {
    public static final int BEGIN = 1;
    public static final int END = 2;
    public static final int ERROR = 11;

    void apply(Consumer<List<JournalItem>> consumer);

    void begin(String str, String str2);

    void end(String str, String str2);

    void error(String str, String str2, int i);
}
