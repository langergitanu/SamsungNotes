package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.samsung.android.support.senl.document.SDocCipherInputStream;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocCipherInputStreamContractImpl {
    public void close(Object obj) throws IOException {
        ((SDocCipherInputStream) obj).close();
    }

    public Object createSDocCipherInputStream(String str) {
        return new SDocCipherInputStream(ApplicationManager.getInstance().getAppContext(), str);
    }

    public int getReservedSize(Object obj) {
        return ((SDocCipherInputStream) obj).getReservedSize();
    }

    public int read(Object obj, byte[] bArr, int i) {
        return ((SDocCipherInputStream) obj).read(bArr, i);
    }
}
