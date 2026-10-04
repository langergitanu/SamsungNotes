package p179f1;

import android.content.Intent;
import android.net.Uri;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.io.File;
import java.util.ArrayList;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p176e1.AbstractC11975a;

/* JADX INFO: renamed from: f1.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11987g extends AbstractC11975a {

    /* JADX INFO: renamed from: p */
    public static final String f8601p = "SS$".concat("RestoreSNoteTask");

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        AbstractC0299q.m643n(f8601p, "clear.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    public final int mo13545c() {
        return 0;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        AbstractC0299q.m643n(f8601p, "prepare.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    public final int mo13552l() {
        int i;
        String str = f8601p;
        AbstractC0299q.m643n(str, "Start update.");
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        m13583m(new File(C0148f.f422m), "snb", 13);
        m13583m(new File(C0148f.f423n), "snb", 20);
        m13583m(new File(C0148f.f424o), "snb", 20);
        m13583m(new File(C0148f.f425p), "snb", 20);
        m13583m(new File(C0148f.f426q), "snb", 20);
        m13583m(new File(C0148f.f426q), "spd", 20);
        if (this.f8561k.size() < 1) {
            AbstractC0299q.m643n(str, "No item found.");
            i = -6;
        } else {
            i = 0;
        }
        AbstractC0299q.m643n(str, "Finish update. result : " + i);
        return i;
    }

    /* JADX INFO: renamed from: m */
    public final void m13583m(File file, String str, int i) {
        String str2 = f8601p;
        AbstractC0299q.m643n(str2, "getRestoreData.");
        if (!file.exists()) {
            AbstractC0299q.m643n(str2, "sourceLocation not exists.");
            return;
        }
        String str3 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        ArrayList arrayListM350c = C0148f.m350c(file, str);
        if (arrayListM350c == null || arrayListM350c.isEmpty()) {
            return;
        }
        int size = arrayListM350c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0322h.m670a().f815a.getAppContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + ((String) arrayListM350c.get(i2)))));
            ImportItem importItem = new ImportItem(i);
            importItem.setLocalFullPath((String) arrayListM350c.get(i2));
            importItem.setRemoveOnConverted(true);
            this.f8561k.add(importItem);
        }
    }
}
