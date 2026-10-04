package com.samsung.android.support.senl.p148nt.coedit.service.task;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.task.SnapUploadTask;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import java.util.ArrayList;
import java.util.HashMap;
import p001A.AbstractC0000a;
import p075S.AbstractC0256h;
import p079T.AbstractC0298p;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SnapUploadTask {
    private static final String TAG = "SnapUploadTask";

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.service.task.SnapUploadTask$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC90821 implements Runnable {
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ String val$refResourceId;
        final /* synthetic */ String val$spaceId;
        final /* synthetic */ Handler val$uiHandler;
        final /* synthetic */ String val$uuid;

        public RunnableC90821(String str, String str2, Context context, String str3, Handler handler) {
            this.val$uuid = str;
            this.val$refResourceId = str2;
            this.val$appContext = context;
            this.val$spaceId = str3;
            this.val$uiHandler = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(Context context) {
            ToastHandler.show(context, C8996R.string.co_edit_unexpected_server_error_try_again_later, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            NotesDocumentEntity notesDocumentEntityM9f;
            NoteDbResolver noteDbResolver = new NoteDbResolver(this.val$uuid);
            if (TextUtils.isEmpty(noteDbResolver.getWorkspaceId())) {
                CoeditLogger.m8923i(SnapUploadTask.TAG, "onSnapUploadCompleted, success to send snap : " + this.val$refResourceId);
                noteDbResolver.setWorkspaceId(this.val$refResourceId);
            }
            if (TextUtils.isEmpty(noteDbResolver.getItemId())) {
                CoeditLogger.m8919d(SnapUploadTask.TAG, "[CS5] onSnapUploadCompleted, itemId is not defined, need to request itemId");
                Context context = this.val$appContext;
                String str = this.val$spaceId;
                String str2 = this.val$uuid;
                String str3 = this.val$refResourceId;
                StringBuilder sbM16m = AbstractC0000a.m16m("[CS5] coeditCreateNote : spaceId = ", str, ", docUuid = ", str2, ", refResId = ");
                sbM16m.append(str3);
                Debugger.m8607d("Mde$SesShareUtil", sbM16m.toString());
                ArrayList arrayList = new ArrayList();
                if (str2 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(context, str2);
                    AbstractC0000a.m18o(context, context, context);
                } else {
                    notesDocumentEntityM9f = null;
                }
                String strM583e = AbstractC0298p.m583e(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getTitle() : "");
                if (TextUtils.isEmpty(strM583e)) {
                    strM583e = str2;
                }
                ShareApi.SharedItemWithUriListRequest sharedItemWithUriListRequest = new ShareApi.SharedItemWithUriListRequest(strM583e);
                sharedItemWithUriListRequest.setResourceId(str3);
                C0283a.m562d().getClass();
                sharedItemWithUriListRequest.setCreator(C0283a.m561c());
                HashMap map = new HashMap();
                map.put("uuid", str2);
                map.put("lastModifiedAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : 0L));
                map.put("createdAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCreatedAt() : -1L));
                map.put("DoclastModifiedAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getLastModifiedAt() : -1L));
                C0283a.m562d().getClass();
                String userName = SesCoeditGroupReadResolver.getInstance().getUserName(SesCoeditShareReadResolver.getInstance().getGroupId(str), C0283a.m561c());
                if (userName == null) {
                    try {
                        userName = AbstractC0256h.m542b();
                    } catch (Exception e) {
                        Debugger.m8607d("Mde$SesShareUtil", "[CS5-1] coeditCreateNote getUserName failed : " + e.getMessage());
                    }
                }
                map.put("creatorName", userName);
                sharedItemWithUriListRequest.setMetaData(map);
                arrayList.add(sharedItemWithUriListRequest);
                C6906i c6906i = new C6906i(4);
                if (C6715o.m4808q().m4801j()) {
                    try {
                        c6906i = AbstractC0298p.m586h(context, str, str2, arrayList);
                    } catch (Exception e2) {
                        Debugger.m8609e("Mde$SesShareUtil", e2.toString());
                    }
                } else {
                    try {
                        try {
                            C6715o.m4808q().m4796c(3);
                            c6906i = AbstractC0298p.m586h(context, str, str2, arrayList);
                        } catch (Exception e3) {
                            Debugger.m8609e("Mde$SesShareUtil", e3.toString());
                        }
                    } finally {
                        C6715o.m4808q().m4797d(3, null);
                    }
                }
                ArrayList arrayList2 = (ArrayList) c6906i.f4483b;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    CoeditLogger.m8923i(SnapUploadTask.TAG, "[CS5-1] onSnapUploadCompleted, finish to upload item to SES, successListSize: " + arrayList2.size());
                } else {
                    CoeditLogger.m8920e(SnapUploadTask.TAG, "[CS5-2] onSnapUploadCompleted, fail to upload item to SES, show a error toast!");
                    Handler handler = this.val$uiHandler;
                    final Context context2 = this.val$appContext;
                    handler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.service.task.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            SnapUploadTask.RunnableC90821.lambda$run$0(context2);
                        }
                    });
                }
            }
        }
    }

    public static void onSnapUploadCompleted(Context context, String str, String str2, String str3, Handler handler) {
        if (TextUtils.isEmpty(str2) || str2.equals(str)) {
            CoeditLogger.m8920e(TAG, "[CS5-2] onSnapUploadCompleted, fail to update item, uuid = " + str);
        } else {
            RunnableC90821 runnableC90821 = new RunnableC90821(str, str2, context, str3, handler);
            if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning(str)) {
                new SenlThreadFactory(AbstractC0541b.m772n("SnapUploadTask/CoeditNoteUploader-", str)).newThread(runnableC90821).start();
            } else {
                runnableC90821.run();
            }
        }
    }
}
