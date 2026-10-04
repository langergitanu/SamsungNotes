package p194k0;

import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: k0.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12954l implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9211a = -1;

    /* JADX INFO: renamed from: b */
    public int f9212b = -1;

    /* JADX INFO: renamed from: c */
    public int f9213c = -1;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12954l)) {
            return false;
        }
        C12954l c12954l = (C12954l) obj;
        if (this.f9211a != c12954l.f9211a) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - penNameID[");
            sb.append(this.f9211a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12954l.f9211a, "]", "WCon_ObjectShapePen", sb);
            return false;
        }
        if (this.f9212b != c12954l.f9212b) {
            StringBuilder sb2 = new StringBuilder(" !! equals() - NE - defaultPenNameID[");
            sb2.append(this.f9212b);
            sb2.append(" - ");
            AbstractC11014a.m12329n(c12954l.f9212b, "]", "WCon_ObjectShapePen", sb2);
            return false;
        }
        if (this.f9213c != c12954l.f9213c) {
            StringBuilder sb3 = new StringBuilder(" !! equals() - NE - mFileId[");
            sb3.append(this.f9213c);
            sb3.append(" - ");
            AbstractC11014a.m12329n(c12954l.f9213c, "]", "WCon_ObjectShapePen", sb3);
            return false;
        }
        if (!TextUtils.equals(null, null)) {
            Log.i("WCon_ObjectShapePen", " !! equals() - NE - penName[null - null]");
            return false;
        }
        if (!TextUtils.equals(null, null)) {
            Log.i("WCon_ObjectShapePen", " !! equals() - NE - defaultPenName[null - null]");
            return false;
        }
        if (TextUtils.equals(null, null)) {
            return true;
        }
        Log.i("WCon_ObjectShapePen", " !! equals() - NE - penStyle[null - null]");
        return false;
    }
}
