package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import com.samsung.android.support.senl.p148nt.base.winset.view.dynamical.IChangeable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock;", "Lcom/samsung/android/support/senl/nt/base/winset/view/dynamical/IChangeable;", "AlignmentParam", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IDock extends IChangeable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock$AlignmentParam;", "", "<init>", "()V", "mStartMargin", "", "getMStartMargin", "()I", "setMStartMargin", "(I)V", "mEndMargin", "getMEndMargin", "setMEndMargin", "dockingSize", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AlignmentParam {

        @JvmField
        public int dockingSize;
        private int mEndMargin;
        private int mStartMargin;

        public final int getMEndMargin() {
            return this.mEndMargin;
        }

        public final int getMStartMargin() {
            return this.mStartMargin;
        }

        public final void setMEndMargin(int i) {
            this.mEndMargin = i;
        }

        public final void setMStartMargin(int i) {
            this.mStartMargin = i;
        }
    }
}
