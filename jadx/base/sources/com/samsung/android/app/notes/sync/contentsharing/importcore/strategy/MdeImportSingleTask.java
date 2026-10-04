package com.samsung.android.app.notes.sync.contentsharing.importcore.strategy;

import android.content.Context;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.List;
import p060O.C0187a;
import p060O.C0189c;
import p060O.InterfaceC0188b;
import p063P.InterfaceC0193b;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p186h1.C12020a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MdeImportSingleTask extends MdeImportBaseTask {
    private static final String TAG = "MdeImportSingleTask";
    protected C0189c mDocMdeImportInfo;
    private InterfaceC0188b mMdeImportTaskContract;
    private List<String> mUuidList;

    public MdeImportSingleTask(Context context, InterfaceC0193b interfaceC0193b, String str, List<String> list) {
        super(context, interfaceC0193b, str);
        this.mMdeImportTaskContract = new C12020a(this, 7);
        this.mUuidList = list;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.importcore.strategy.MdeImportBaseTask
    public ArrayList<C0204a> importProgress() throws ShareException {
        List<String> list = this.mUuidList;
        if (list == null || list.isEmpty()) {
            Debugger.m8609e(TAG, "importProgress() : mUuidList is not valid");
            return null;
        }
        Debugger.m8607d(TAG, "importProgress() [" + hashCode() + "] : " + this.mUuidList.size());
        try {
            this.mGroupId = SesShareReadResolver.getInstance().getGroupId(this.mSpaceId);
            if (!C6716p.m4809q().m4801j()) {
                Debugger.m8609e(TAG, "SesSessionAuth is not connected");
                this.mDocMdeImportInfo.f590b.add(new C0204a("", 7));
                return this.mDocMdeImportInfo.f590b;
            }
            String strM594D = AbstractC0299q.m594D();
            this.mOwnerId = strM594D;
            Context context = this.mContext;
            String str = this.mSpaceId;
            String str2 = this.mGroupId;
            List<String> list2 = this.mUuidList;
            C0189c c0189c = new C0189c();
            c0189c.f590b = new ArrayList();
            c0189c.f589a = context;
            c0189c.f591c = str;
            c0189c.f592d = str2;
            c0189c.f593e = strM594D;
            c0189c.f594f = list2;
            this.mDocMdeImportInfo = c0189c;
            InterfaceC0188b interfaceC0188b = this.mMdeImportTaskContract;
            C0187a c0187a = new C0187a();
            c0187a.f587a = c0189c;
            c0187a.f588b = interfaceC0188b;
            C6747p c6747p = new C6747p(context);
            try {
                c6747p.m4869a();
                c0187a.m451a(c6747p);
                c6747p.m4870b();
                return this.mDocMdeImportInfo.f590b;
            } catch (Throwable th) {
                c6747p.m4870b();
                throw th;
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "fail to import : " + e.getMessage());
            throw new ShareException(ShareConstants$ResultCode.FAIL_UNKNOWN_EXCEPTION, "failed to make share copy");
        }
    }
}
