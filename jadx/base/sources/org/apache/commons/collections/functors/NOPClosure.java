package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NOPClosure implements Closure, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    private NOPClosure() {
    }

    public static Closure getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
    }
}
