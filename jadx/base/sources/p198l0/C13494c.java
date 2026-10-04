package p198l0;

import p185h0.InterfaceC12016a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: l0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13494c implements InterfaceC12016a, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public int f9469a;

    /* JADX INFO: renamed from: b */
    public int f9470b;

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: a */
    public final String mo13615a() {
        return "sectionData";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: b */
    public final String mo13616b() {
        return "sectionData";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: c */
    public final boolean mo13617c(String str) {
        return true;
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: d */
    public final String mo13618d() {
        return "'sectionData/sectionData'";
    }

    @Override // p185h0.InterfaceC12016a
    /* JADX INFO: renamed from: e */
    public final String mo13619e() {
        return "'sectionData/sectionData'='0'";
    }

    @Override // p185h0.InterfaceC12016a
    public final int end() {
        return (this.f9469a + this.f9470b) - 1;
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (!(obj instanceof C13494c)) {
            return false;
        }
        C13494c c13494c = (C13494c) obj;
        if (this == c13494c) {
            return true;
        }
        return this.f9470b == c13494c.f9470b && this.f9469a == c13494c.f9469a;
    }

    @Override // p185h0.InterfaceC12016a
    public final int start() {
        return this.f9469a;
    }

    @Override // p185h0.InterfaceC12016a
    public final void end(int i) {
        this.f9470b = (i - this.f9469a) + 1;
    }

    @Override // p185h0.InterfaceC12016a
    public final void start(int i) {
        this.f9469a = i;
    }
}
