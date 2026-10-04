package p073R;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p044K.C0158a;

/* JADX INFO: renamed from: R.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0228g implements GcsResolverContract {

    /* JADX INFO: renamed from: a */
    public C6742k f673a;

    /* JADX INFO: renamed from: b */
    public ThreadPoolExecutor f674b;

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract
    public final String getSpaceName(Context context, String str) {
        return SesShareReadResolver.getInstance().getSpaceTitle(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract
    public final void requestConnectSessionAsync(SesUiListener sesUiListener) {
        Logger.m8697d("GcsComposerResolver", "requestConnectSessionAsync#");
        if (C0158a.m407a().m415h()) {
            C6716p.m4809q().m4795b(2, sesUiListener);
            if (this.f674b == null) {
                this.f674b = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new SenlThreadFactory("GcsComposerResolver"));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract
    public final void requestDisConnectSessionAsync(SesUiListener sesUiListener) {
        Logger.m8697d("GcsComposerResolver", "requestDisConnectSessionAsync#");
        if (C0158a.m407a().m415h()) {
            C6716p.m4809q().m4797d(2, sesUiListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.GcsResolverContract
    public final void updateWriterName(String str, String str2, GcsResolverContract.GcsCallback gcsCallback) {
        StringBuilder sb = new StringBuilder("updateWriterName# ");
        sb.append(DeviceInfo.isEngMode() ? AbstractC0541b.m774p("g: ", str, " o: ", str2) : "USER");
        Logger.m8697d("GcsComposerResolver", sb.toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        C6742k c6742k = this.f673a;
        if (c6742k == null || !str.equals((String) c6742k.f4110b)) {
            this.f673a = new C6742k(str);
        }
        try {
            String strM4858p = this.f673a.m4858p(str2);
            if (!TextUtils.isEmpty(strM4858p)) {
                if (gcsCallback != null) {
                    gcsCallback.onResult(strM4858p);
                    return;
                }
                return;
            }
            String userName = SesGroupReadResolver.getInstance().getUserName(str, str2);
            if (TextUtils.isEmpty(userName)) {
                this.f674b.execute(new RunnableC0227f(this, str2, gcsCallback));
            } else if (gcsCallback != null) {
                gcsCallback.onResult(userName);
            }
        } catch (Exception e) {
            Logger.m8698e("GcsComposerResolver", "updateWriterName# " + e.getMessage());
        }
    }
}
