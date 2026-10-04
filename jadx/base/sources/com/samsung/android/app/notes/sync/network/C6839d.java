package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6839d implements InterfaceC6851b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f4259a;

    public C6839d(String str) {
        this.f4259a = str;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b
    /* JADX INFO: renamed from: a */
    public final void mo5001a(Header header, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    File file = new File(this.f4259a);
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                        Debugger.m8609e("NT$MemoServiceHelper", FileUtils.logPath(parentFile.getAbsolutePath()) + " mkdirs failed");
                    }
                    if (file.exists() && !file.delete()) {
                        Debugger.m8609e("NT$MemoServiceHelper", FileUtils.logPath(file.getAbsolutePath()) + " deleted failed");
                    }
                    if (!file.createNewFile()) {
                        Debugger.m8609e("NT$MemoServiceHelper", FileUtils.logPath(file.getAbsolutePath()) + " createNewFile failed");
                    }
                    fileOutputStream = new FileOutputStream(file.getAbsolutePath());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                Debugger.m8609e("NT$MemoServiceHelper", "FileNotFoundException " + e.getMessage());
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (IOException e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                Debugger.m8609e("NT$MemoServiceHelper", "IOException " + e.getMessage());
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        Debugger.m8609e("NT$MemoServiceHelper", e6.toString());
                    }
                }
                throw th;
            }
        } catch (Exception e7) {
            Debugger.m8609e("NT$MemoServiceHelper", e7.toString());
        }
    }
}
