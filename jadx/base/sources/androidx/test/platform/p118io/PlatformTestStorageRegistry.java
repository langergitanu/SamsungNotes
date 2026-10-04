package androidx.test.platform.p118io;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.util.Checks;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class PlatformTestStorageRegistry {
    private static PlatformTestStorage testStorageInstance = (PlatformTestStorage) ServiceLoaderWrapper.loadSingleService(PlatformTestStorage.class, new C0347a(13));

    private PlatformTestStorageRegistry() {
    }

    public static synchronized PlatformTestStorage getInstance() {
        return testStorageInstance;
    }

    public static synchronized void registerInstance(PlatformTestStorage platformTestStorage) {
        testStorageInstance = (PlatformTestStorage) Checks.checkNotNull(platformTestStorage);
    }
}
