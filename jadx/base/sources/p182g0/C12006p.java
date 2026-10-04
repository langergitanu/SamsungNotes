package p182g0;

import android.util.Log;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;

/* JADX INFO: renamed from: g0.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12006p extends VariableComparator.IntVar {
    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.IntVar
    public final boolean compare(int i) {
        if (getValue() == i) {
            return true;
        }
        Log.i("WCon_Page", " !! equals() - NE - mFormatVersion[" + getValue() + " - " + i + "]");
        return false;
    }
}
