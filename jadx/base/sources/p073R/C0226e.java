package p073R;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p033H0.C0112b;
import p044K.C0158a;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p079T.AbstractC0294l;
import p079T.C0283a;

/* JADX INFO: renamed from: R.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0226e implements CoeditResolverContract {

    /* JADX INFO: renamed from: a */
    public C0112b f668a;

    /* JADX INFO: renamed from: b */
    public ThreadPoolExecutor f669b;

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final Intent getCoeditMemberManageIntent(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AbstractC0294l.m574a(str, str2, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final UserInfo getCoeditNoteUserInfo(String str, String str2) {
        NotesDocumentEntity notesDocumentEntityM9f = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (str2 != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str2);
            AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
        }
        return SesCoeditShareReadResolver.getInstance().getCoeditNoteUserInfo(BaseUtils.getApplicationContext(), str, notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getMdeItemId() : "");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final String getCurrentUserOwnerId() {
        C0283a.m562d().getClass();
        return C0283a.m561c();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final String getLeaderId(String str) {
        StringBuilder sb = new StringBuilder("getMemberList# ");
        sb.append(DeviceInfo.isEngMode() ? AbstractC0541b.m772n("g: ", str) : "USER");
        Logger.m8697d("GcsComposerResolver", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SesCoeditGroupReadResolver.getInstance().getLeaderId(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final boolean getMemberList(String str, CoeditResolverContract.CoeditCallback coeditCallback) {
        StringBuilder sb = new StringBuilder("getMemberList# ");
        sb.append(DeviceInfo.isEngMode() ? AbstractC0541b.m772n("g: ", str) : "USER");
        Logger.m8697d("GcsComposerResolver", sb.toString());
        if (TextUtils.isEmpty(str) || coeditCallback == null) {
            return false;
        }
        if (!C6715o.m4808q().m4801j()) {
            Logger.m8702i("GcsComposerResolver", "getMemberList# session disconnected");
            coeditCallback.onResult(SesCoeditGroupReadResolver.getInstance().getMemberInfoList(str));
            return false;
        }
        try {
            AbstractC0254f.m536b(str);
            coeditCallback.onResult(SesCoeditGroupReadResolver.getInstance().getMemberInfoList(str));
            return true;
        } catch (Exception e) {
            Logger.m8698e("GcsComposerResolver", "getMemberList# " + e.getMessage());
            coeditCallback.onResult(new ArrayList());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final LiveData getMemberListLiveData(Context context, String str) {
        if (context == null) {
            context = BaseUtils.getApplicationContext();
        }
        return SesCoeditGroupReadResolver.getComposerMemberInfoListLiveData(context, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final String getSpaceName(Context context, String str) {
        return SesCoeditShareReadResolver.getInstance().getSpaceTitle(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final Boolean isStandaloneSpace(String str) {
        return Boolean.valueOf(SesCoeditShareReadResolver.getInstance().getStandAlone(str));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void requestConnectSessionAsync(SesUiListener sesUiListener) {
        Logger.m8697d("GcsComposerResolver", "requestConnectSessionAsync#");
        if (C0158a.m409d(BaseUtils.getApplicationContext())) {
            C6715o.m4808q().m4795b(2, sesUiListener);
            if (this.f669b == null) {
                this.f669b = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new SenlThreadFactory("GcsComposerResolver"));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void requestDeleteCoeditNote(String str, String str2) {
        try {
            try {
                C6715o.m4808q().m4796c(3);
                AbstractC0291i.m564a(BaseUtils.getApplicationContext(), str, Collections.singletonList(str2), null, "COMPOSER");
            } catch (Exception e) {
                Logger.m8698e("GcsComposerResolver", "requestDeleteCoeditNote(). failed() " + e.getMessage());
            }
        } finally {
            C6715o.m4808q().m4797d(3, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void requestDeleteCoeditSpace(String str, String str2) {
        try {
            try {
                C6715o.m4808q().m4796c(3);
                AbstractC0267s.m543a().requestSpaceUpdate(SesCoeditShareReadResolver.getInstance().getSpaceIdByGroupId(str), "Group://Standalone " + str2, "", new C0223b(str));
            } catch (Exception e) {
                Logger.m8698e("GcsComposerResolver", "requestDeleteCoeditSpace(). failed() " + e.toString());
            }
        } finally {
            C6715o.m4808q().m4797d(3, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void requestDisConnectSessionAsync(SesUiListener sesUiListener) {
        Logger.m8697d("GcsComposerResolver", "requestDisConnectSessionAsync#");
        if (C0158a.m409d(BaseUtils.getApplicationContext())) {
            C6715o.m4808q().m4797d(2, sesUiListener);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void requestLeaveCoeditSpace(String str, String str2) {
        try {
            try {
                C6715o.m4808q().m4796c(3);
                AbstractC0254f.m535a().requestLeave(str, new C0224c(str));
            } catch (Exception e) {
                Logger.m8698e("GcsComposerResolver", "requestLeaveCoeditSpace(). failed() " + e.toString());
            }
        } finally {
            C6715o.m4808q().m4797d(3, null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final void updateWriterName(String str, String str2, CoeditResolverContract.CoeditCallback coeditCallback) {
        StringBuilder sb = new StringBuilder("updateWriterName# ");
        sb.append(DeviceInfo.isEngMode() ? AbstractC0541b.m774p("g: ", str, " o: ", str2) : "USER");
        Logger.m8697d("GcsComposerResolver", sb.toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        C0112b c0112b = this.f668a;
        if (c0112b == null || !str.equals((String) c0112b.f363b)) {
            this.f668a = new C0112b(str);
        }
        try {
            String strM266j = this.f668a.m266j(str2);
            if (!TextUtils.isEmpty(strM266j)) {
                if (coeditCallback != null) {
                    coeditCallback.onResult(strM266j);
                    return;
                }
                return;
            }
            String userName = SesCoeditGroupReadResolver.getInstance().getUserName(str, str2);
            if (TextUtils.isEmpty(userName)) {
                this.f669b.execute(new RunnableC0225d(this, str2, coeditCallback));
            } else if (coeditCallback != null) {
                coeditCallback.onResult(userName);
            }
        } catch (Exception e) {
            Logger.m8698e("GcsComposerResolver", "updateWriterName# " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract
    public final List getMemberList(String str) {
        String strM772n;
        StringBuilder sb = new StringBuilder("getMemberList# ");
        if (DeviceInfo.isEngMode()) {
            strM772n = AbstractC0541b.m772n("g: ", str);
        } else {
            strM772n = "USER";
        }
        sb.append(strM772n);
        Logger.m8697d("GcsComposerResolver", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return SesCoeditGroupReadResolver.getInstance().getMemberInfoList(str);
    }
}
