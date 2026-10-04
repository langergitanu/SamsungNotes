package org.apache.commons.lang3.function;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = new C8416h(29);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(long j) {
        return null;
    }

    static <R, E extends Throwable> FailableLongFunction<R, E> nop() {
        return NOP;
    }

    R apply(long j);
}
