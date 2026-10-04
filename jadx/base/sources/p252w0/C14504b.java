package p252w0;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.SSLMemoSync;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;

/* JADX INFO: renamed from: w0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14504b extends AbstractC14503a implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public boolean f10335a;

    @Override // p252w0.AbstractC14503a
    /* JADX INFO: renamed from: a */
    public final void mo15110a(boolean z) {
        AbstractC4539a.m3215y("setExtraData. fromSmartSwitch : ", "SSLMemoImportHelper", z);
        this.f10335a = z;
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
        C14504b c14504b;
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
                c14504b = this;
                c14504b.mSync = new SSLMemoSync(this.mContext, c14504b, 3, this.mDownloadList, this.f10335a);
                throw th;
            }
            c14504b = this;
            c14504b.mSync = new SSLMemoSync(c14504b.mContext, this, 2, c14504b.f10335a);
            ImportBaseTask importBaseTask = c14504b.mSync;
            if (importBaseTask != null) {
                c14504b.mState = 3;
                importBaseTask.executeOnExecutor(c14504b.mExecutor, new Void[0]);
            }
        }
    }
}
