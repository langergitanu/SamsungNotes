package org.apache.commons.lang3.function;

import androidx.emoji2.text.flatbuffer.C2747a;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Suppliers {
    private static Supplier NUL = new C2747a(14);

    @Deprecated
    public Suppliers() {
    }

    public static <T> T get(Supplier<T> supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$0() {
        return null;
    }

    public static <T> Supplier<T> nul() {
        return NUL;
    }
}
