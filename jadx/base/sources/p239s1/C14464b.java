package p239s1;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import p020E.C0073a;
import p234q1.C14433b;

/* JADX INFO: renamed from: s1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14464b implements IAuthInfoReqListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Context f10257a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f10258b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C14465c f10259c;

    public C14464b(C14465c c14465c, Context context, String str) {
        this.f10259c = c14465c;
        this.f10257a = context;
        this.f10258b = str;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onError(String str, String str2) {
        Debugger.m8609e("SyncServerNoteInfoHelper", "onError() : errCode = " + str + " errMsg = " + str2);
        this.f10259c.m15052a(106);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
    public final void onReceived(String str, String str2) {
        Debugger.m8615i("SyncServerNoteInfoHelper", "onReceived()");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Debugger.m8609e("SyncServerNoteInfoHelper", "onReceived() : userToken or userId is null!");
        } else {
            C14433b.m15033p(this.f10257a).m15038n(str, str2, new C0073a(this, 12));
        }
    }
}
