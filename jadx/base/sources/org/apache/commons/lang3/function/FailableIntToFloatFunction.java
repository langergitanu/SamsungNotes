package org.apache.commons.lang3.function;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableIntToFloatFunction<E extends Throwable> {
    public static final FailableIntToFloatFunction NOP = new C8416h(27);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ float lambda$static$0(int i) {
        return 0.0f;
    }

    static <E extends Throwable> FailableIntToFloatFunction<E> nop() {
        return NOP;
    }

    float applyAsFloat(int i);
}
