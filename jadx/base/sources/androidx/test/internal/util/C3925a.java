package androidx.test.internal.util;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.util.Checks;

/* JADX INFO: renamed from: androidx.test.internal.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3925a implements ServiceLoaderWrapper.Factory {
    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public final Object create() {
        return Checks.ThreadCheckerSingleton.lambda$static$0();
    }
}
