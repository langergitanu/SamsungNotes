package p194k0;

import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p079T.AbstractC0299q;
import p178f0.C11979b;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: k0.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12964v implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: b */
    public int f9262b;

    /* JADX INFO: renamed from: c */
    public RectF f9263c;

    /* JADX INFO: renamed from: f */
    public final C11979b f9266f;

    /* JADX INFO: renamed from: d */
    public HashMap f9264d = new HashMap();

    /* JADX INFO: renamed from: e */
    public HashMap f9265e = new HashMap();

    /* JADX INFO: renamed from: a */
    public final C12966x f9261a = new C12966x();

    public C12964v(int i, C6906i c6906i) {
        this.f9262b = i;
        this.f9266f = (C11979b) c6906i.f4483b;
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        c6742k.m4848d(this.f9262b, "type");
        c6742k.m4851h("id", this.f9261a.f9296a);
        if (!this.f9264d.isEmpty()) {
            c6742k.m4846F("attachedFileList");
            for (Map.Entry entry : this.f9264d.entrySet()) {
                if (!TextUtils.isEmpty((String) entry.getKey())) {
                    c6742k.m4846F("pair");
                    c6742k.m4853j("key", (String) entry.getKey());
                    c6742k.m4851h("value", this.f9266f.m13559e(((Integer) entry.getValue()).intValue()));
                    c6742k.m4856m("pair");
                }
            }
            c6742k.m4856m("attachedFileList");
        }
        if (!this.f9265e.isEmpty()) {
            c6742k.m4846F("customDataList");
            for (Map.Entry entry2 : this.f9265e.entrySet()) {
                if (!TextUtils.isEmpty((String) entry2.getKey())) {
                    c6742k.m4846F("pair");
                    c6742k.m4853j("key", (String) entry2.getKey());
                    c6742k.m4853j("value", (String) entry2.getValue());
                    c6742k.m4856m("pair");
                }
            }
            c6742k.m4856m("customDataList");
        }
        RectF rectF = this.f9263c;
        if (rectF != null) {
            c6742k.m4845D("rect", rectF);
        }
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12964v)) {
            return false;
        }
        C12964v c12964v = (C12964v) obj;
        C12966x c12966x = c12964v.f9261a;
        if (this.f9262b != c12964v.f9262b) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - type[");
            sb.append(this.f9262b);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12964v.f9262b, "]", "WCon_CustomObject", sb);
            return false;
        }
        C12966x c12966x2 = this.f9261a;
        if (!AbstractC0299q.m635j(c12966x2, c12966x)) {
            Log.i("WCon_CustomObject", " !! equals() - NE - uuid[" + c12966x2 + " - " + c12966x + "]");
            return false;
        }
        if (AbstractC0299q.m635j(this.f9263c, c12964v.f9263c)) {
            if (!this.f9264d.equals(c12964v.f9264d)) {
                Log.i("WCon_CustomObject", " !! equals - NE - attachedFileMap");
                return false;
            }
            if (this.f9265e.equals(c12964v.f9265e)) {
                return true;
            }
            Log.i("WCon_CustomObject", " !! equals - NE - customDataMap");
            return false;
        }
        Log.i("WCon_CustomObject", " !! equals() - NE - rect[" + this.f9263c + " - " + c12964v.f9263c + "]");
        return false;
    }
}
