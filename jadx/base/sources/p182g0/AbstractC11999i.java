package p182g0;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import java.util.List;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: g0.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC11999i implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f8707a;

    /* JADX INFO: renamed from: b */
    public long f8708b;

    /* JADX INFO: renamed from: c */
    public String f8709c;

    /* JADX INFO: renamed from: a */
    public List mo13601a() {
        return null;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC11999i)) {
            return false;
        }
        AbstractC11999i abstractC11999i = (AbstractC11999i) obj;
        if (!TextUtils.equals(this.f8707a, abstractC11999i.f8707a)) {
            StringBuilder sb = new StringBuilder(" !! equals() - NE - id[");
            sb.append(this.f8707a);
            sb.append(" - ");
            AbstractC4539a.m3209s(sb, abstractC11999i.f8707a, "]", "WCon_NoteTree");
            return false;
        }
        if (this.f8708b != abstractC11999i.f8708b) {
            Log.i("WCon_NoteTree", " !! equals() - NE - modifiedTime[" + this.f8708b + " - " + abstractC11999i.f8708b + "]");
            return false;
        }
        if (!TextUtils.equals(this.f8709c, abstractC11999i.f8709c)) {
            Log.e("WCon_NoteTree", " !! equals() - NE - hash[" + this.f8709c + " - " + abstractC11999i.f8709c + "]");
        }
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Node[id=");
        sb.append(this.f8707a);
        sb.append(", hash=");
        return AbstractC0622a.m1170p(this.f8709c, "]", sb);
    }
}
