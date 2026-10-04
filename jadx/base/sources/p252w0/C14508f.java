package p252w0;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.SSSNoteSync;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;

/* JADX INFO: renamed from: w0.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14508f extends AbstractC14503a implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public boolean f10339a;

    @Override // p252w0.AbstractC14503a
    /* JADX INFO: renamed from: a */
    public final void mo15110a(boolean z) {
        AbstractC4539a.m3215y("setExtraData. fromSmartSwitch : ", "SSSNoteImportHelper", z);
        this.f10339a = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        synchronized (this) {
            onImportError(this.mType, 201, "errCode = " + str + " errMsg = " + str2, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) throws Throwable {
        int i;
        C14508f c14508f;
        synchronized (this) {
            try {
                try {
                    i = this.mRequestType;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (i != 1) {
                if (i != 2) {
                    this.mSync = null;
                    throw new UnsupportedOperationException();
                }
                c14508f = this;
                c14508f.mSync = new SSSNoteSync(this.mContext, c14508f, 3, this.mDownloadList, this.f10339a);
                throw th;
            }
            c14508f = this;
            c14508f.mSync = new SSSNoteSync(c14508f.mContext, this, 2, c14508f.f10339a);
            ImportBaseTask importBaseTask = c14508f.mSync;
            if (importBaseTask != null) {
                c14508f.mState = 3;
                importBaseTask.executeOnExecutor(c14508f.mExecutor, new Void[0]);
            }
        }
    }
}
