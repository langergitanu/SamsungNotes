package p182g0;

import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: g0.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12009s implements InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: a */
    public int f8720a;

    /* JADX INFO: renamed from: b */
    public int f8721b;

    /* JADX INFO: renamed from: c */
    public int f8722c;

    /* JADX INFO: renamed from: d */
    public boolean f8723d;

    /* JADX INFO: renamed from: e */
    public int f8724e;

    /* JADX INFO: renamed from: f */
    public final int[] f8725f = new int[3];

    /* JADX INFO: renamed from: g */
    public int f8726g;

    /* JADX INFO: renamed from: h */
    public int f8727h;

    /* JADX INFO: renamed from: i */
    public int f8728i;

    /* JADX INFO: renamed from: j */
    public int f8729j;

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        VariableComparator.List listAddVar = new VariableComparator.List().addVar(new VariableComparator.IntVar("mFileId", this.f8720a)).addVar(new VariableComparator.IntVar("width", this.f8721b)).addVar(new VariableComparator.IntVar("height", this.f8722c)).addVar(new VariableComparator.BoolVar("isDarkMode", this.f8723d)).addVar(new VariableComparator.IntVar("backgroundColor", this.f8724e));
        int[] iArr = this.f8725f;
        return listAddVar.addVar(new VariableComparator.IntVar("version", iArr[0])).addVar(new VariableComparator.IntVar("version", iArr[1])).addVar(new VariableComparator.IntVar("version", iArr[2])).addVar(new VariableComparator.IntVar("cacheVersion", this.f8726g)).addVar(new VariableComparator.IntVar("property", this.f8727h)).addVar(new VariableComparator.IntVar("localeListId", this.f8728i)).addVar(new VariableComparator.IntVar("systemFontPathHash", this.f8729j));
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C12009s) {
            return VariableComparator.compare(this, (C12009s) obj, "WCon_Page");
        }
        return false;
    }
}
