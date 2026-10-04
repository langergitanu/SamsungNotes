package com.samsung.android.app.notes.sync.synchronization.managers;

import android.content.Context;
import android.text.TextUtils;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.opencsv.bean.C6618c;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6880g;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteItem;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.scpm.pam.kps.ScpmKps;
import com.samsung.scsp.pam.kps.lite.ScspKpsLite;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p010C.RunnableC0037b;
import p025F0.C0094i;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p178f0.C11980c;
import p211o0.C13569c;
import p236r1.AbstractC14447b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6906i implements InterfaceC0122a, InterfaceC6683a {

    /* JADX INFO: renamed from: d */
    public static C6906i f4481d;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4482a;

    /* JADX INFO: renamed from: b */
    public Object f4483b;

    /* JADX INFO: renamed from: c */
    public Object f4484c;

    public /* synthetic */ C6906i(int i, boolean z) {
        this.f4482a = i;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C6906i m5136c() {
        try {
            if (f4481d == null) {
                C6906i c6906i = new C6906i(0, false);
                SyncStateManager$SyncFailState syncStateManager$SyncFailState = SyncStateManager$SyncFailState.UNKNOWN;
                c6906i.f4483b = syncStateManager$SyncFailState;
                c6906i.f4484c = syncStateManager$SyncFailState;
                f4481d = c6906i;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4481d;
    }

    /* JADX INFO: renamed from: a */
    public void m5137a(String str) {
        ((ArrayList) this.f4484c).add(str);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady() for request delete");
        shareOldService.requestDelete((String) this.f4483b, (List) this.f4484c);
    }

    /* JADX INFO: renamed from: d */
    public void m5138d(XmlPullParser xmlPullParser) throws XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        ServerNoteItem serverNoteItem = null;
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase(FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE)) {
                    serverNoteItem = new ServerNoteItem();
                } else if (serverNoteItem != null) {
                    if (name.equalsIgnoreCase("serverId")) {
                        serverNoteItem.serverId = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("resourceId")) {
                        serverNoteItem.resourceId = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("isUpdatedByDevice")) {
                        serverNoteItem.isUpdatedByDevice = AbstractC14517a.m15131P(xmlPullParser);
                    } else if (name.equalsIgnoreCase("syncModifiedTime")) {
                        serverNoteItem.syncModifiedTime = AbstractC14517a.m15133R(xmlPullParser);
                    } else if (name.equalsIgnoreCase("isDeleted")) {
                        serverNoteItem.isDeleted = AbstractC14517a.m15131P(xmlPullParser);
                    } else if (name.equalsIgnoreCase(SyncDBSchema.SyncInfo.COMMIT_ID)) {
                        serverNoteItem.commitId = AbstractC14517a.m15134S(xmlPullParser);
                    } else if (name.equalsIgnoreCase("sdkVersion")) {
                        serverNoteItem.sdkVersion = AbstractC14517a.m15132Q(xmlPullParser);
                    }
                }
            } else if (eventType != 3 && eventType != 4) {
                Debugger.m8615i("ServerNoteInfoItem", "parseNode - invalid eventType = [" + eventType + "]");
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (eventType == 3 && xmlPullParser.getName().equals(FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE)) {
                break;
            }
        }
        if (serverNoteItem != null) {
            ((ArrayList) this.f4483b).add(serverNoteItem);
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m5139e() {
        try {
            this.f4484c = new ScpmKps((Context) this.f4483b, CommonUtils.getAppServiceId(), C13569c.m14375c().f9619b.getE2EEDeviceType(), new ScspKpsLite(AbstractC14447b.f10233a));
        } catch (Exception unused) {
            Debugger.m8609e("SCloudEdpHelper", "[EDP] requestKeySync() : fail to new ScpmKps!");
        }
        if (((ScpmKps) this.f4484c) == null) {
            return false;
        }
        CompletableFuture completableFuture = new CompletableFuture();
        ((ScpmKps) this.f4484c).requestKeySync("si-6vqcx5t", "si-6vqcx5t", new C6618c(this, completableFuture, 15));
        return ((Boolean) completableFuture.get(60000L, TimeUnit.MILLISECONDS)).booleanValue();
    }

    /* JADX INFO: renamed from: f */
    public void m5140f(SyncStateManager$SyncFailState syncStateManager$SyncFailState) {
        Debugger.m8615i("SyncStateManager", "setSyncFailState() : syncFailState = " + syncStateManager$SyncFailState + ", callee: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        this.f4484c = syncStateManager$SyncFailState;
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        switch (this.f4482a) {
            case 2:
                CompletableFuture completableFuture = (CompletableFuture) this.f4483b;
                C6903f c6903f = (C6903f) this.f4484c;
                C0094i c0094i = (C0094i) c6903f.f4474b;
                MSLogger.m8632d("CreateNote", "result createNote, onResult : " + c0124c);
                if (c0124c != null) {
                    try {
                        int i = c0124c.f387b;
                        if (i == -1) {
                            C6903f.m5117a(c6903f, completableFuture, "CreateNote HTTP_Failed");
                        } else if (i == 401) {
                            new SenlThreadFactory("CreateNote401RequestToken").newThread(new RunnableC0037b(this, 1)).start();
                        } else if (i == 429) {
                            C6903f.m5117a(c6903f, completableFuture, "HTTP_TOO_MANY_REQUESTS");
                        } else {
                            JSONObject jSONObject = new JSONObject(c0124c.f386a);
                            String string = jSONObject.getString("id");
                            String string2 = jSONObject.getString("createdDateTime");
                            MSLogger.m8632d("CreateNote", "createdDateTime : " + string2 + ",connectedNotesId : " + string);
                            if (TextUtils.isEmpty(string)) {
                                AbstractC6784f.f4180a.m4943b(c0094i.f306c, c0094i.f305b, c0094i.f304a);
                                C6903f.m5117a(c6903f, completableFuture, TelemetryEventStrings.Value.FAILED);
                            } else {
                                c0094i.f305b = string;
                                c6903f.f4475c = string2;
                                C6785g c6785g = AbstractC6784f.f4180a;
                                String str = c0094i.f306c;
                                c6785g.getClass();
                                C6785g.m4942p(str, string);
                                C6903f.m5117a(c6903f, completableFuture, "finished create note.");
                            }
                        }
                    } catch (Exception e) {
                        AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), "CreateNote");
                        C6903f.m5117a(c6903f, completableFuture, "failed create note.");
                        return;
                    }
                }
                break;
            default:
                MSLogger.m8632d("UpdateNote", "result deleteAttachmentNote, onResult : " + c0124c);
                C6742k.m4840c((C6742k) this.f4484c, (CompletableFuture) this.f4483b, "finished delete prev attachment.");
                break;
        }
    }

    public /* synthetic */ C6906i(Object obj, CompletableFuture completableFuture, int i) {
        this.f4482a = i;
        this.f4484c = obj;
        this.f4483b = completableFuture;
    }

    public /* synthetic */ C6906i(boolean z) {
        this.f4482a = 6;
    }

    public C6906i(int i) {
        this.f4482a = i;
        switch (i) {
            case 6:
                this.f4484c = new C11980c();
                break;
            default:
                this.f4483b = new ArrayList();
                this.f4484c = new ArrayList();
                break;
        }
    }

    public C6906i(C6880g c6880g) {
        this.f4482a = 7;
        this.f4483b = new ArrayList();
        this.f4484c = c6880g;
    }

    public C6906i(String str, List list) {
        this.f4482a = 5;
        this.f4483b = str;
        this.f4484c = list;
    }
}
