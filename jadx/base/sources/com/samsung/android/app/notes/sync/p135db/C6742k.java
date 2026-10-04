package com.samsung.android.app.notes.sync.p135db;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.compose.animation.core.AnimationKt;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.microsoft.graph.http.NoteHttpTask;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteDeleteTask;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteExtensionUpdateTask;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteUpdateTask;
import com.samsung.android.app.notes.sync.network.InterfaceC6846k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6904g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.GroupMember;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupMemberResult;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.base.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p007B0.C0021d;
import p020E.C0073a;
import p025F0.C0094i;
import p033H0.C0111a;
import p033H0.C0112b;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p042J1.C0145c;
import p075S.AbstractC0272x;
import p086V.C0322h;
import p185h0.InterfaceC12019d;
import p186h1.C12020a;
import p211o0.C13571e;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6742k implements InterfaceC0122a, InterfaceC6683a, InterfaceC6846k {

    /* JADX INFO: renamed from: d */
    public static C6742k f4108d;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4109a;

    /* JADX INFO: renamed from: b */
    public Object f4110b;

    /* JADX INFO: renamed from: c */
    public Object f4111c;

    public /* synthetic */ C6742k(Object obj, Object obj2, int i) {
        this.f4109a = i;
        this.f4111c = obj;
        this.f4110b = obj2;
    }

    /* JADX INFO: renamed from: E */
    public static void m4839E(CompletableFuture completableFuture, String str) throws ExecutionException, InterruptedException, TimeoutException {
        MSLogger.m8636w("UpdateNote", str.concat(", future get"));
        completableFuture.get(600000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: c */
    public static void m4840c(C6742k c6742k, CompletableFuture completableFuture, String str) {
        MSLogger.m8636w("UpdateNote", str.concat(", future complete"));
        completableFuture.complete(0);
    }

    /* JADX INFO: renamed from: o */
    public static synchronized C6742k m4841o() {
        try {
            if (f4108d == null) {
                f4108d = new C6742k(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4108d;
    }

    /* JADX INFO: renamed from: A */
    public void m4842A(ArrayList arrayList) throws IOException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        m4846F("controlPointList");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m4843B((PointF) it.next(), "controlPoint");
        }
        m4856m("controlPointList");
    }

    /* JADX INFO: renamed from: B */
    public void m4843B(PointF pointF, String str) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        if (pointF != null) {
            m4846F(str);
            xmlSerializer.attribute("", "x", Float.toString(pointF.x));
            xmlSerializer.attribute("", "y", Float.toString(pointF.y));
            m4856m(str);
        }
    }

    /* JADX INFO: renamed from: C */
    public void m4844C(String str, Rect rect) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        if (rect != null) {
            m4846F(str);
            xmlSerializer.attribute("", "l", Integer.toString(rect.left));
            xmlSerializer.attribute("", "t", Integer.toString(rect.top));
            xmlSerializer.attribute("", "r", Integer.toString(rect.right));
            xmlSerializer.attribute("", "b", Integer.toString(rect.bottom));
            m4856m(str);
        }
    }

    /* JADX INFO: renamed from: D */
    public void m4845D(String str, RectF rectF) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        if (rectF != null) {
            m4846F(str);
            xmlSerializer.attribute("", "l", Float.toString(rectF.left));
            xmlSerializer.attribute("", "t", Float.toString(rectF.top));
            xmlSerializer.attribute("", "r", Float.toString(rectF.right));
            xmlSerializer.attribute("", "b", Float.toString(rectF.bottom));
            m4856m(str);
        }
    }

    /* JADX INFO: renamed from: F */
    public void m4846F(String str) throws IOException {
        ((XmlSerializer) this.f4110b).startTag("", str);
    }

    /* JADX INFO: renamed from: G */
    public void m4847G(SyncDelayInfoEntity syncDelayInfoEntity) {
        String uuid = syncDelayInfoEntity.getUuid();
        HashMap map = (HashMap) this.f4111c;
        if (map.containsKey(uuid)) {
            SyncDelayInfoEntity syncDelayInfoEntity2 = (SyncDelayInfoEntity) map.get(uuid);
            if (syncDelayInfoEntity.getReason() == 12001) {
                if (syncDelayInfoEntity.getReason() == syncDelayInfoEntity2.getReason() && syncDelayInfoEntity.getAppVersion().equals(syncDelayInfoEntity2.getAppVersion())) {
                    return;
                }
            } else if (syncDelayInfoEntity.getReason() == 12000 && syncDelayInfoEntity.getReason() == syncDelayInfoEntity2.getReason() && syncDelayInfoEntity.getAppVersion().equals(syncDelayInfoEntity2.getAppVersion())) {
                return;
            }
        }
        C14433b c14433b = (C14433b) this.f4110b;
        c14433b.getClass();
        Debugger.m8614f("SyncDelayInfoRepository", "update, entity : " + syncDelayInfoEntity);
        ((SyncDelayInfoDao) c14433b.f10228b).upsert(syncDelayInfoEntity);
        map.put(syncDelayInfoEntity.getUuid(), syncDelayInfoEntity);
    }

    @Override // com.samsung.android.app.notes.sync.network.InterfaceC6846k
    /* JADX INFO: renamed from: a */
    public void mo264a(int i) {
        if (i == 0) {
            C0322h.m670a().f830p.deleteTagSync((String) this.f4110b);
            C0012a c0012a = (C0012a) ((C0073a) this.f4111c).f254b;
            if (c0012a.f79t) {
                return;
            }
            c0012a.f79t = true;
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady()");
        shareOldService.requestImport((String) this.f4110b, (List) this.f4111c);
    }

    /* JADX INFO: renamed from: d */
    public void m4848d(int i, String str) throws IOException {
        ((XmlSerializer) this.f4110b).attribute("", str, Integer.toString(i));
    }

    /* JADX INFO: renamed from: e */
    public void m4849e(String str, float f) throws IOException {
        ((XmlSerializer) this.f4110b).attribute("", str, Float.toString(f));
    }

    /* JADX INFO: renamed from: f */
    public void m4850f(String str, long j) throws IOException {
        ((XmlSerializer) this.f4110b).attribute("", str, Long.toString(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[Catch: all -> 0x0061, TryCatch #0 {, blocks: (B:5:0x001b, B:9:0x0032, B:15:0x007e, B:16:0x008b, B:14:0x0064), top: B:20:0x0019, inners: #1 }] */
    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo252g(C0124c c0124c) {
        JSONArray jSONArray;
        int length;
        MSLogger.m8632d("UpdateNote", "result getAttachmentNote, onResult : " + c0124c);
        synchronized (((C6742k) this.f4111c)) {
            if (c0124c != null) {
                try {
                    jSONArray = new JSONObject(c0124c.f386a).getJSONArray("value");
                    length = jSONArray.length();
                } catch (Exception e) {
                    MSLogger.m8633e("UpdateNote", "Failed. " + e.getMessage());
                }
                if (length > 0) {
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getJSONObject(i).getString("id");
                        MSLogger.m8632d("UpdateNote", "prev attachmentId : " + string);
                        ((ArrayList) ((C6742k) this.f4111c).f4111c).add(string);
                    }
                    m4840c((C6742k) this.f4111c, (CompletableFuture) this.f4110b, "finished get prev attachment.");
                } else {
                    m4840c((C6742k) this.f4111c, (CompletableFuture) this.f4110b, "finished get prev attachment.");
                }
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void m4851h(String str, String str2) throws IOException {
        if (str2 != null) {
            ((XmlSerializer) this.f4110b).attribute("", str, str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m4852i(String str, boolean z) throws IOException {
        ((XmlSerializer) this.f4110b).attribute("", str, Boolean.toString(z));
    }

    /* JADX INFO: renamed from: j */
    public void m4853j(String str, String str2) throws IOException {
        if (str2 != null) {
            ((XmlSerializer) this.f4110b).attribute("", str, Base64Utils.encodeBase64(str2));
        }
    }

    /* JADX INFO: renamed from: k */
    public boolean m4854k() {
        String str = (String) this.f4110b;
        if (str == null) {
            return false;
        }
        try {
            this.f4111c = AbstractC0272x.m557h(str);
        } catch (Exception e) {
            Debugger.m8607d("SesGroupUserNameCache", "cacheGroupMemberInfo() : " + e.toString());
        }
        return ((GroupMemberResult) this.f4111c) != null;
    }

    /* JADX INFO: renamed from: l */
    public void m4855l(String str) {
        HashMap map = (HashMap) this.f4111c;
        if (map.containsKey(str)) {
            ((C14433b) this.f4110b).m15037k(str);
            map.remove(str);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m4856m(String str) throws IOException {
        ((XmlSerializer) this.f4110b).endTag("", str);
    }

    /* JADX INFO: renamed from: n */
    public void m4857n() throws IOException {
        ((XmlSerializer) this.f4110b).endDocument();
    }

    /* JADX INFO: renamed from: p */
    public String m4858p(String str) {
        GroupMember next;
        List<GroupMember> groupMembers;
        GroupMemberResult groupMemberResult = (GroupMemberResult) this.f4111c;
        if (groupMemberResult == null || (groupMembers = groupMemberResult.getGroupMembers()) == null) {
            next = null;
        } else {
            Iterator<GroupMember> it = groupMembers.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (str.equals(next.getId())) {
                    break;
                }
            }
            next = null;
        }
        if (next != null) {
            return next.getName();
        }
        return null;
    }

    /* JADX INFO: renamed from: q */
    public void m4859q() {
        HashMap map = (HashMap) this.f4111c;
        map.clear();
        for (SyncDelayInfoEntity syncDelayInfoEntity : ((SyncDelayInfoDao) ((C14433b) this.f4110b).f10228b).getEntityList()) {
            map.put(syncDelayInfoEntity.getUuid(), syncDelayInfoEntity);
        }
        Map<String, ?> all = SharedPreferencesCompat.getInstance("SyncControlRestoredServerNote").getAll();
        if (all != null && !all.isEmpty()) {
            for (String str : all.keySet()) {
                if (!map.containsKey(str)) {
                    m4847G(AbstractC14517a.m15162v(99999, str, (String) all.get(str)));
                }
            }
            C0145c.m316a("SyncControlRestoredServerNote");
        }
        Map<String, ?> all2 = SharedPreferencesCompat.getInstance("SyncNotDownSyncedNotes").getAll();
        if (all2 == null || all2.isEmpty()) {
            return;
        }
        Iterator<String> it = all2.keySet().iterator();
        while (it.hasNext()) {
            String strM331p = C0145c.m331p("SyncNotDownSyncedNotes", it.next(), "");
            if (!TextUtils.isEmpty(strM331p)) {
                try {
                    JSONObject jSONObject = new JSONObject(strM331p);
                    String string = jSONObject.getString("uuid");
                    if (!TextUtils.isEmpty(string)) {
                        long j = jSONObject.getLong("syncModifiedTime");
                        String string2 = jSONObject.getString("serverId");
                        int i = jSONObject.getInt("remainCount");
                        if (!map.containsKey(string) && i > 0) {
                            SyncDelayInfoEntity syncDelayInfoEntityM15162v = AbstractC14517a.m15162v(99999, string, string2);
                            syncDelayInfoEntityM15162v.setServerTimestamp(j);
                            m4847G(syncDelayInfoEntityM15162v);
                        }
                    }
                } catch (JSONException e) {
                    Debugger.m8609e("SyncDelayInfoManager", "handlePreviousNotDownSyncedNote() : fail to parse, " + e);
                }
            }
        }
        C0145c.m316a("SyncNotDownSyncedNotes");
    }

    /* JADX INFO: renamed from: r */
    public void m4860r(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        do {
            int i = 4;
            int i2 = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equalsIgnoreCase("FolderResource")) {
                    this.f4111c = new C0021d();
                } else if (name.equalsIgnoreCase("encrypted")) {
                    try {
                        ((C0021d) this.f4111c).f112a = AbstractC14517a.m15131P(xmlPullParser);
                    } catch (XmlPullParserException unused) {
                    }
                } else if (name.equalsIgnoreCase("syncModifiedTime")) {
                    ((C0021d) this.f4111c).f113b = AbstractC14517a.m15133R(xmlPullParser);
                } else if (name.equalsIgnoreCase("nodeList")) {
                    ((C0021d) this.f4111c).f114c = new ArrayList();
                    ((C0021d) this.f4111c).f115d = new ArrayList();
                } else if (name.equalsIgnoreCase("node")) {
                    int eventType2 = xmlPullParser.getEventType();
                    FolderNodeItem folderNodeItem = null;
                    xmlPullParser.require(2, null, "node");
                    while (true) {
                        if (eventType2 == i2) {
                            String name2 = xmlPullParser.getName();
                            if (name2.equalsIgnoreCase("node")) {
                                folderNodeItem = new FolderNodeItem();
                                int attributeCount = xmlPullParser.getAttributeCount();
                                for (int i4 = 0; i4 < attributeCount; i4++) {
                                    String attributeName = xmlPullParser.getAttributeName(i4);
                                    if (attributeName.equalsIgnoreCase("id")) {
                                        folderNodeItem.uUid = xmlPullParser.getAttributeValue(i4);
                                    } else if (attributeName.equalsIgnoreCase("type")) {
                                        folderNodeItem.type = xmlPullParser.getAttributeValue(i4);
                                    }
                                }
                            } else if (folderNodeItem != null) {
                                if (name2.equalsIgnoreCase("parentFolderNodeId")) {
                                    folderNodeItem.parentFolderNodeId = AbstractC14517a.m15134S(xmlPullParser);
                                } else if (name2.equalsIgnoreCase("syncModifiedTime")) {
                                    folderNodeItem.syncModifiedTime = AbstractC14517a.m15133R(xmlPullParser);
                                } else if (name2.equalsIgnoreCase(GroupContract.Group.CREATED_TIME)) {
                                    folderNodeItem.createdTime = AbstractC14517a.m15133R(xmlPullParser);
                                } else if (name2.equalsIgnoreCase(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME)) {
                                    folderNodeItem.lastModifiedTime = AbstractC14517a.m15133R(xmlPullParser);
                                } else if (name2.equalsIgnoreCase("name")) {
                                    if (((C0021d) this.f4111c).f112a && folderNodeItem.type.equals("folder")) {
                                        byte[] bArrM15129N = AbstractC14517a.m15129N(xmlPullParser);
                                        if (bArrM15129N.length != 0) {
                                            try {
                                                folderNodeItem.name = C0145c.m317b(bArrM15129N);
                                            } catch (Exception e) {
                                                AbstractC0000a.m22s("parseNode - fail to decryptByEdp -> ", e, "FolderChangeItem");
                                            }
                                        }
                                    } else {
                                        folderNodeItem.name = AbstractC14517a.m15130O(xmlPullParser);
                                    }
                                    if (!FolderUtils.isValidFolderName(folderNodeItem.name)) {
                                        folderNodeItem.name = FolderUtils.getNewFolderName(System.currentTimeMillis() % AnimationKt.MillisToNanos);
                                        Debugger.m8609e("FolderChangeItem", "parseNode - invalid fold name -> " + folderNodeItem.name);
                                    }
                                } else if (name2.equalsIgnoreCase("state")) {
                                    folderNodeItem.state = AbstractC14517a.m15134S(xmlPullParser);
                                } else if (name2.equalsIgnoreCase("restorePath")) {
                                    if (!FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL.equals(folderNodeItem.state)) {
                                        folderNodeItem.restorePath = AbstractC14517a.m15130O(xmlPullParser);
                                    }
                                } else if (name2.equalsIgnoreCase("trashedTime")) {
                                    if (!FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL.equals(folderNodeItem.state)) {
                                        folderNodeItem.recycleBinMovedTime = AbstractC14517a.m15133R(xmlPullParser);
                                    }
                                } else if (name2.equalsIgnoreCase(DBSchema.CategoryTree.IS_SYNC_WITH_MS)) {
                                    if (!xmlPullParser.isEmptyElementTag()) {
                                        folderNodeItem.isSyncWithMS = AbstractC14517a.m15132Q(xmlPullParser);
                                    }
                                } else if (name2.equalsIgnoreCase("color")) {
                                    if (!xmlPullParser.isEmptyElementTag()) {
                                        folderNodeItem.displayNameColor = AbstractC14517a.m15132Q(xmlPullParser);
                                    }
                                } else if (name2.equalsIgnoreCase("order") && !xmlPullParser.isEmptyElementTag()) {
                                    folderNodeItem.reorder = AbstractC14517a.m15132Q(xmlPullParser);
                                }
                            }
                        } else if (eventType2 != 3 && eventType2 != i) {
                            Debugger.m8615i("FolderChangeItem", "parseNode - invalid eventType = [" + eventType2 + "]");
                        }
                        eventType2 = AbstractC14517a.m15119D(xmlPullParser, 1);
                        if (eventType2 == 3 && xmlPullParser.getName().equals("node")) {
                            break;
                        }
                        i = 4;
                        i2 = 2;
                    }
                    if (folderNodeItem != null) {
                        if ("folder".equals(folderNodeItem.type)) {
                            ArrayList arrayList = ((C0021d) this.f4111c).f114c;
                            int i5 = FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state) ? 2 : "deleted".equals(folderNodeItem.state) ? 1 : 0;
                            String str = folderNodeItem.parentFolderNodeId;
                            if ("root".equals(str)) {
                                str = i5 == 0 ? "uncategorized:///" : "trash:///";
                            }
                            folderNodeItem.parentFolderNodeId = str;
                            NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(folderNodeItem.uUid, str, folderNodeItem.name, folderNodeItem.restorePath);
                            notesCategoryTreeEntity.setIsDirty(0);
                            notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(folderNodeItem.syncModifiedTime));
                            notesCategoryTreeEntity.setCreatedAt(folderNodeItem.createdTime);
                            notesCategoryTreeEntity.setLastModifiedAt(folderNodeItem.lastModifiedTime);
                            notesCategoryTreeEntity.setIsDeleted(i5);
                            notesCategoryTreeEntity.setRecycleBinTimeMoved(folderNodeItem.recycleBinMovedTime);
                            notesCategoryTreeEntity.setIsSyncWithMS(folderNodeItem.isSyncWithMS);
                            notesCategoryTreeEntity.setDisplayNameColor(folderNodeItem.displayNameColor);
                            notesCategoryTreeEntity.setReorder(Integer.valueOf(folderNodeItem.reorder));
                            arrayList.add(notesCategoryTreeEntity);
                        } else if (FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE.equals(folderNodeItem.type)) {
                            ((C0021d) this.f4111c).f115d.add(folderNodeItem);
                        }
                    }
                }
            } else if (eventType != 3 && eventType != 4) {
                Debugger.m8615i("FolderChangeItem", "parseFolderResource - invalid eventType = [" + eventType + "]");
            }
            eventType = AbstractC14517a.m15119D(xmlPullParser, 1);
            if (eventType == 3 && xmlPullParser.getName() != null && xmlPullParser.getName().equals("FolderResource")) {
                return;
            }
        } while (eventType != 1);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX INFO: renamed from: s */
    public void m4861s() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        ArrayList<String> arrayList = (ArrayList) this.f4111c;
        StringBuilder sb = new StringBuilder("perform. connectedNotesId : ");
        C0094i c0094i = (C0094i) this.f4110b;
        List<String> list = c0094i.f308e;
        String str5 = c0094i.f306c;
        sb.append(c0094i.f305b);
        MSLogger.m8632d("UpdateNote", sb.toString());
        boolean z = true;
        boolean[] zArr = new boolean[1];
        CompletableFuture completableFuture = new CompletableFuture();
        C0111a c0111aM256c = C0111a.m256c();
        String str6 = c0094i.f305b;
        C6903f c6903f = new C6903f(this, 5, zArr, completableFuture);
        c0111aM256c.getClass();
        MSLogger.m8632d("ConnectedNotesHelper", "getNotes");
        try {
            str2 = "ConnectedNotesHelper";
            str = "https://graph.microsoft.com/beta/me/notes/";
            i = 0;
        } catch (Exception e) {
            e = e;
            str = "https://graph.microsoft.com/beta/me/notes/";
            str2 = "ConnectedNotesHelper";
            i = 0;
        }
        try {
            new NoteHttpTask("https://graph.microsoft.com/beta/me/notes/" + str6 + "?nonIpmNote=1", "GET", "application/json", null, c6903f).executeOnExecutor(C0111a.f360b, new Void[0]);
            str3 = str2;
        } catch (Exception e2) {
            e = e2;
            str3 = str2;
            AbstractC6670b.m4753n(e, new StringBuilder("getNotes Failed, "), str3);
        }
        m4839E(completableFuture, "Wait for check deleted note");
        if (zArr[i]) {
            AbstractC6784f.f4180a.getClass();
            C6785g.m4940j(str5);
            MSLogger.m8632d("UpdateNote", "result bIsDismissed true create note");
            C0111a c0111aM256c2 = C0111a.m256c();
            C12020a c12020a = new C12020a(this, 4);
            c0111aM256c2.getClass();
            C0111a.m255b(c0094i, c12020a);
            return;
        }
        arrayList.clear();
        CompletableFuture completableFuture2 = new CompletableFuture();
        C0111a c0111aM256c3 = C0111a.m256c();
        String str7 = c0094i.f305b;
        C6742k c6742k = new C6742k(this, completableFuture2, 3);
        c0111aM256c3.getClass();
        MSLogger.m8632d(str3, "getAttachmentNote, connectedNotesId : " + str7);
        try {
            str4 = str;
        } catch (Exception e3) {
            e = e3;
            str4 = str;
        }
        try {
            new NoteHttpTask(str4 + str7 + "/attachments?nonIpmNote=1", "GET", "application/json", null, c6742k).executeOnExecutor(C0111a.f360b, new Void[i]);
        } catch (Exception e5) {
            e = e5;
            AbstractC6670b.m4753n(e, new StringBuilder("addAttachmentNote Failed, "), str3);
        }
        m4839E(completableFuture2, "Wait for get prev attachments.");
        for (String str8 : arrayList) {
            CompletableFuture completableFuture3 = new CompletableFuture();
            C0111a c0111aM256c4 = C0111a.m256c();
            String str9 = c0094i.f305b;
            boolean z2 = z;
            C6906i c6906i = new C6906i(this, completableFuture3, 3);
            c0111aM256c4.getClass();
            MSLogger.m8632d(str3, "deleteAttachmentNote, connectedNotesId : " + str9 + ", attachmentId : " + str8);
            try {
                new NoteDeleteTask(str4 + str9 + "/attachments/" + str8 + "?nonIpmNote=1", "DELETE", c6906i).executeOnExecutor(C0111a.f360b, new Void[i]);
            } catch (Exception e6) {
                AbstractC6670b.m4753n(e6, new StringBuilder("deleteAttachmentNote Failed, "), str3);
            }
            m4839E(completableFuture3, "Wait for delete prev attachment.");
            z = z2;
        }
        int i4 = i;
        for (String str10 : list) {
            CompletableFuture completableFuture4 = new CompletableFuture();
            C0111a c0111aM256c5 = C0111a.m256c();
            String str11 = c0094i.f305b;
            i4++;
            C6903f c6903f2 = new C6903f(this, 6, str10, completableFuture4);
            c0111aM256c5.getClass();
            C0111a.m254a(str11, str10, i4, c6903f2);
            m4839E(completableFuture4, "Wait for add attachment.");
        }
        MSLogger.m8632d("UpdateNote", "request updateNote. thumbnail size : " + list.size());
        CompletableFuture completableFuture5 = new CompletableFuture();
        C0111a c0111aM256c6 = C0111a.m256c();
        C0112b c0112b = new C0112b(this, completableFuture5);
        c0111aM256c6.getClass();
        StringBuilder sbM15l = AbstractC0000a.m15l("updateNoteExtension uuid : ", str5, " connectedNotesid : ");
        sbM15l.append(c0094i.f305b);
        MSLogger.m8632d(str3, sbM15l.toString());
        try {
            i2 = 0;
        } catch (Exception e7) {
            e = e7;
            i2 = 0;
        }
        try {
            new NoteExtensionUpdateTask(str4 + c0094i.f305b + "/extensions/Com.Samsung.Note?nonIpmNote=1", "PATCH", "application/json", c0094i, c0112b).executeOnExecutor(C0111a.f360b, new Void[0]);
        } catch (Exception e8) {
            e = e8;
            AbstractC6670b.m4753n(e, new StringBuilder("updateNoteExtension Failed, "), str3);
        }
        m4839E(completableFuture5, "Wait for update Note Extension.");
        C0111a c0111aM256c7 = C0111a.m256c();
        C14433b c14433b = new C14433b(this, 3);
        c0111aM256c7.getClass();
        StringBuilder sbM15l2 = AbstractC0000a.m15l("updateNote, uuid : ", str5, " connectedNotesid : ");
        sbM15l2.append(c0094i.f305b);
        MSLogger.m8632d(str3, sbM15l2.toString());
        try {
            new NoteUpdateTask(str4 + c0094i.f305b + "?nonIpmNote=1", "PATCH", "application/json", c0094i, c14433b).executeOnExecutor(C0111a.f360b, new Void[i2]);
        } catch (Exception e9) {
            AbstractC6670b.m4753n(e9, new StringBuilder("updateNote Failed, "), str3);
        }
    }

    /* JADX INFO: renamed from: t */
    public void m4862t(String str, int i) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        xmlSerializer.startTag("", str);
        xmlSerializer.text(Integer.toString(i));
        xmlSerializer.endTag("", str);
    }

    public String toString() {
        switch (this.f4109a) {
            case 2:
                return ((StringWriter) this.f4111c).toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: renamed from: u */
    public void m4863u(String str, long j) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        xmlSerializer.startTag("", str);
        xmlSerializer.text(Long.toString(j));
        xmlSerializer.endTag("", str);
    }

    /* JADX INFO: renamed from: v */
    public void m4864v(String str, InterfaceC12019d interfaceC12019d) throws SyncException {
        if (interfaceC12019d != null) {
            try {
                m4846F(str);
                interfaceC12019d.mo47a(this);
                m4856m(str);
            } catch (SyncException | IOException | IllegalArgumentException | IllegalStateException e) {
                Debugger.m8609e("XMLObject", "put : " + interfaceC12019d.getClass().getName() + e.getMessage());
                throw new SyncException(326, e);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public void m4865w(String str, String str2) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        xmlSerializer.startTag("", str);
        xmlSerializer.text(str2);
        xmlSerializer.endTag("", str);
    }

    /* JADX INFO: renamed from: x */
    public void m4866x(String str, String str2, List list) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m4846F(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m4867y(str2, (String) it.next());
        }
        m4856m(str);
    }

    /* JADX INFO: renamed from: y */
    public void m4867y(String str, String str2) throws IOException {
        XmlSerializer xmlSerializer = (XmlSerializer) this.f4110b;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        xmlSerializer.startTag("", str);
        xmlSerializer.attribute("", VElementFormulasCmd.FVAL, Base64Utils.encodeBase64(str2));
        xmlSerializer.endTag("", str);
    }

    /* JADX INFO: renamed from: z */
    public void m4868z(String str, String str2, List list) throws SyncException, IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        m4846F(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m4864v(str2, (InterfaceC12019d) it.next());
        }
        m4856m(str);
    }

    public C6742k(String str) {
        this.f4109a = 6;
        this.f4111c = null;
        this.f4110b = str;
    }

    public C6742k(C6904g c6904g) {
        this.f4109a = 7;
        this.f4110b = new ArrayList();
        this.f4111c = c6904g;
    }

    public C6742k(int i) {
        this.f4109a = i;
        switch (i) {
            case 1:
                break;
            case 8:
                this.f4110b = new ArrayList();
                new ArrayList();
                C13571e c13571e = new C13571e();
                c13571e.f9624a = null;
                c13571e.f9626c = false;
                this.f4111c = c13571e;
                break;
            default:
                this.f4111c = new HashMap();
                this.f4110b = new C14433b(12);
                break;
        }
    }

    public C6742k(String str, List list) {
        this.f4109a = 5;
        this.f4110b = str;
        this.f4111c = list;
    }

    public C6742k(XmlSerializer xmlSerializer) throws IOException {
        this.f4109a = 2;
        if (xmlSerializer != null) {
            this.f4110b = xmlSerializer;
            StringWriter stringWriter = new StringWriter();
            this.f4111c = stringWriter;
            xmlSerializer.setOutput(stringWriter);
            return;
        }
        throw new IllegalArgumentException("xmlSerializer is null.");
    }

    public C6742k(C0094i c0094i) {
        this.f4109a = 4;
        this.f4110b = c0094i;
        this.f4111c = new ArrayList();
    }
}
