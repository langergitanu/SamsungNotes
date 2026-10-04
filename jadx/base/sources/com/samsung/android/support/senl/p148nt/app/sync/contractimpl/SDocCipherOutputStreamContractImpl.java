package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.samsung.android.support.senl.document.SDocCipherOutputStream;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocCipherOutputStreamContractImpl {
    public void close(Object obj) throws IOException {
        ((SDocCipherOutputStream) obj).close();
    }

    public Object create(String str) {
        return new SDocCipherOutputStream(ApplicationManager.getInstance().getAppContext(), str);
    }

    public void write(Object obj, byte[] bArr, int i) throws IOException {
        ((SDocCipherOutputStream) obj).write(bArr, i);
    }
}
