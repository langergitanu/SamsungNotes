package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class OpenSslCachingKeyMaterialProvider extends OpenSslKeyMaterialProvider {
    private final ConcurrentMap<String, OpenSslKeyMaterial> cache;
    private volatile boolean full;
    private final int maxCachedEntries;

    public OpenSslCachingKeyMaterialProvider(X509KeyManager x509KeyManager, String str, int i) {
        super(x509KeyManager, str);
        this.cache = new ConcurrentHashMap();
        this.maxCachedEntries = i;
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public OpenSslKeyMaterial chooseKeyMaterial(ByteBufAllocator byteBufAllocator, String str) throws Throwable {
        OpenSslKeyMaterial openSslKeyMaterialChooseKeyMaterial = this.cache.get(str);
        if (openSslKeyMaterialChooseKeyMaterial == null) {
            openSslKeyMaterialChooseKeyMaterial = super.chooseKeyMaterial(byteBufAllocator, str);
            if (openSslKeyMaterialChooseKeyMaterial == null) {
                return null;
            }
            if (this.full) {
                return openSslKeyMaterialChooseKeyMaterial;
            }
            if (this.cache.size() > this.maxCachedEntries) {
                this.full = true;
                return openSslKeyMaterialChooseKeyMaterial;
            }
            OpenSslKeyMaterial openSslKeyMaterialPutIfAbsent = this.cache.putIfAbsent(str, openSslKeyMaterialChooseKeyMaterial);
            if (openSslKeyMaterialPutIfAbsent != null) {
                openSslKeyMaterialChooseKeyMaterial.release();
                openSslKeyMaterialChooseKeyMaterial = openSslKeyMaterialPutIfAbsent;
            }
        }
        return openSslKeyMaterialChooseKeyMaterial.retain();
    }

    @Override // io.netty.handler.ssl.OpenSslKeyMaterialProvider
    public void destroy() {
        do {
            Iterator<OpenSslKeyMaterial> it = this.cache.values().iterator();
            while (it.hasNext()) {
                it.next().release();
                it.remove();
            }
        } while (!this.cache.isEmpty());
    }
}
