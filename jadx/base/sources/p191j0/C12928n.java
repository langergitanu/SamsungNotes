package p191j0;

import android.graphics.PointF;
import android.util.Log;
import java.util.ArrayList;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: j0.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12928n implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public PointF f9090a = new PointF();

    /* JADX INFO: renamed from: b */
    public final ArrayList f9091b = new ArrayList();

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12928n)) {
            return false;
        }
        C12928n c12928n = (C12928n) obj;
        ArrayList arrayList = c12928n.f9091b;
        if (!AbstractC0299q.m635j(this.f9090a, c12928n.f9090a)) {
            Log.i("WCon_ObjectShapeBase", " !! equals() - NE - point[" + this.f9090a + " - " + c12928n.f9090a + "]");
            return false;
        }
        ArrayList arrayList2 = this.f9091b;
        if (AbstractC0299q.m631h(arrayList2, arrayList)) {
            return true;
        }
        Log.i("WCon_ObjectShapeBase", " !! equals() - NE - mObjectList[" + arrayList2 + " - " + arrayList + "]");
        return false;
    }
}
