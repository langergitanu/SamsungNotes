package p239s1;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;

/* JADX INFO: renamed from: s1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14465c {

    /* JADX INFO: renamed from: a */
    public IServerNoteInfoListener f10260a;

    /* JADX INFO: renamed from: a */
    public final void m15052a(int i) {
        IServerNoteInfoListener iServerNoteInfoListener = this.f10260a;
        if (iServerNoteInfoListener != null) {
            try {
                iServerNoteInfoListener.onFailed(i);
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("handleErrorResult() : fail to call , "), "SyncServerNoteInfoHelper");
            }
        }
    }
}
