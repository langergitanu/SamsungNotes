package p086V;

import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem;

/* JADX INFO: renamed from: V.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0315a implements IConvertItem {

    /* JADX INFO: renamed from: a */
    public String f812a;

    /* JADX INFO: renamed from: b */
    public int f813b;

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public final String getSrcPath() {
        return this.f812a;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public final int getWritingMode() {
        return this.f813b;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem
    public final boolean isWrappingWhenLocked() {
        return true;
    }
}
