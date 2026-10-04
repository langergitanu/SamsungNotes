package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@GwtIncompatible
@DoNotMock("Use an instance of one of the Finalizable*Reference classes")
@J2ktIncompatible
@ElementTypesAreNonnullByDefault
public interface FinalizableReference {
    void finalizeReferent();
}
