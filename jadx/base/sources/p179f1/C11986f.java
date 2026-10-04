package p179f1;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.FileInputStream;
import org.json.JSONObject;
import p010C.RunnableC0037b;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p174d1.C11972a;
import p176e1.AbstractC11975a;

/* JADX INFO: renamed from: f1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11986f extends AbstractC11975a {

    /* JADX INFO: renamed from: q */
    public static final String f8599q = "SS$".concat("RestoreQMemoTask");

    /* JADX INFO: renamed from: p */
    public final String f8600p;

    public C11986f(C11972a c11972a) {
        super(c11972a);
        this.f8558h = 512;
        this.f8600p = c11972a.f8536a;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        AbstractC0299q.m643n(f8599q, "clear.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    public final int mo13545c() {
        return 0;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        AbstractC0299q.m643n(f8599q, "prepare.");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    public final int mo13552l() {
        int length;
        String str = f8599q;
        try {
            FileInputStream fileInputStream = new FileInputStream(AbstractC0155m.m387b(this.f8600p, "QuickMemoPlusBackup_rename.json"));
            try {
                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                length = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("MemoList").length() : 0;
                fileInputStream.close();
            } finally {
            }
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("Failed to getQMemoCount() - "), str);
            length = -1;
        }
        if (length <= 0) {
            AbstractC0299q.m646q(str, "QMemo count 0.");
            return -1;
        }
        FolderManager.getInstance().executeOperation(new RunnableC0037b(this, 7));
        for (int i = 0; i < length; i++) {
            this.f8561k.add(new ImportItem(36));
        }
        return 0;
    }
}
