package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.json.JSONException;
import p042J1.AbstractC0155m;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6837b implements InterfaceC6851b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ File f4254a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean[] f4255b;

    public C6837b(File file, boolean[] zArr) {
        this.f4254a = file;
        this.f4255b = zArr;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6851b
    /* JADX INFO: renamed from: a */
    public final void mo5001a(Header header, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr;
        File file = this.f4254a;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.createNewFile()) {
                        Debugger.m8609e("NT$LegacyNoteServiceHelper", "createNewFile returned false. It may already exists.");
                    }
                    fileOutputStream = new FileOutputStream(file.getAbsolutePath());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
            try {
                bArr = new byte[131072];
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                Debugger.m8609e("NT$LegacyNoteServiceHelper", e.toString());
                if (fileOutputStream2 == null) {
                    return;
                } else {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e3) {
                        Debugger.m8609e("NT$LegacyNoteServiceHelper", e3.toString());
                    }
                }
                throw th;
            }
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        break;
                    } catch (JSONException e5) {
                        Debugger.m8609e("NT$LegacyNoteServiceHelper", e5.getMessage());
                    }
                }
            }
            if (AbstractC0155m.m393h(file.getAbsolutePath()).getInt("rcode") == 32006) {
                Debugger.m8607d("NT$LegacyNoteServiceHelper", "Downloading snb - not valid file > Deleting file : " + Logger.getEncode(file.getName()));
                if (!file.delete()) {
                    Debugger.m8609e("NT$LegacyNoteServiceHelper", "Deleting " + Logger.getEncode(file.getName()) + " failed");
                }
            }
            this.f4255b[0] = true;
            fileOutputStream.close();
        } catch (Exception e6) {
            Debugger.m8609e("NT$LegacyNoteServiceHelper", e6.toString());
        }
    }
}
