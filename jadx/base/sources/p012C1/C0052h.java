package p012C1;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.GraphItem$RequestType;
import com.samsung.android.app.notes.sync.network.networkutils.C6861l;
import com.samsung.android.app.notes.sync.network.networkutils.C6865p;
import com.samsung.android.app.notes.sync.p135db.C6734c;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.InterfaceC6897a;
import com.samsung.android.app.notes.sync.synchronization.managers.C6899b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6901d;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.sync.synchronization.managers.SyncProgressManager$SyncProgressStep;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.HashUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.ITempServerNoteListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.ServerNoteItem;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.MaxObjectLimitHelper;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.File;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import p001A.AbstractC0000a;
import p002A0.C0009i;
import p003A1.C0013b;
import p007B0.C0022e;
import p007B0.C0023f;
import p008B1.C0028a;
import p008B1.C0032e;
import p017D1.C0062c;
import p017D1.C0063d;
import p017D1.C0064e;
import p017D1.C0065f;
import p017D1.C0066g;
import p017D1.C0069j;
import p017D1.C0070k;
import p022E1.C0075a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.C0097a;
import p026F1.C0098b;
import p034H1.C0113a;
import p042J1.AbstractC0153k;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p173d0.C11971a;
import p207n1.C13540g;
import p207n1.C13541h;
import p234q1.C14434c;
import p253w1.InterfaceC14510a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: C1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0052h {

    /* JADX INFO: renamed from: a */
    public final C0077c f216a;

    /* JADX INFO: renamed from: b */
    public final C0082h f217b;

    /* JADX INFO: renamed from: c */
    public final C0013b f218c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC14510a f219d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC6897a f220e;

    /* JADX INFO: renamed from: f */
    public final C0075a f221f;

    public C0052h(C0077c c0077c, C0082h c0082h, C0013b c0013b, InterfaceC14510a interfaceC14510a, InterfaceC6897a interfaceC6897a) {
        this.f216a = c0077c;
        this.f217b = c0082h;
        this.f218c = c0013b;
        this.f219d = interfaceC14510a;
        this.f220e = interfaceC6897a;
        this.f221f = new C0075a(c0077c, c0082h);
    }

    /* JADX INFO: renamed from: g */
    public static void m92g(C0023f c0023f, C6748q c6748q) {
        C0113a c0113a = new C0113a(((C0022e) c0023f.f127c).f117b);
        c0113a.m274e(c6748q.m4873a(), ((C0022e) c0023f.f127c).f122g);
        c0113a.m270a(c6748q);
        BaseUtils.getApplicationContext();
        C6901d.m5113d(c6748q);
    }

    /* JADX INFO: renamed from: h */
    public static void m93h(SyncProgressListener syncProgressListener, int i) {
        if (syncProgressListener != null) {
            new SenlThreadFactory("NotifyDownSyncResultThread").newThread(new RunnableC0050f(syncProgressListener, i, 0)).start();
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m94a() throws SyncException {
        long j;
        C6865p c6865pM5034d;
        FolderNodeItem folderNodeItem;
        NotesDocumentEntity notesDocumentEntityM9f;
        InterfaceC14510a interfaceC14510a = this.f219d;
        C0082h c0082h = this.f217b;
        c0082h.m219f(interfaceC14510a, "SDocxChanges");
        c0082h.m218d();
        c0082h.m220g();
        C0077c c0077c = this.f216a;
        C6903f c6903f = c0077c.f265h;
        Context context = c0077c.f262e;
        c6903f.m5131p("ND");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        List<String> normalSyncablSdocxUuidList = c0077c.f267j.f4096a.getNormalSyncablSdocxUuidList();
        if (normalSyncablSdocxUuidList == null) {
            normalSyncablSdocxUuidList = new ArrayList<>();
        }
        List<String> list = normalSyncablSdocxUuidList;
        ArrayList arrayList = new ArrayList();
        long jM328m = C0145c.m328m(Long.parseLong("1464416139847"), "SyncDataSDocx", "lastSyncModifiedTime") + 1;
        String str = null;
        while (true) {
            C0097a c0097a = new C0097a();
            C6903f c6903f2 = c0077c.f265h;
            StringBuilder sb = new StringBuilder();
            if (c0097a.f318a == 3) {
                sb.append("/samsungnotes/v3");
            } else {
                sb.append("/samsungnotes/v1");
            }
            sb.append("/notes/list");
            String strM15044b = C14434c.m15043a().m15044b(sb.toString());
            j = jElapsedRealtime;
            if (TextUtils.isEmpty(str)) {
                C6861l c6861l = new C6861l(c6903f2, context, c0097a);
                c6861l.f4309j = "getNoteList";
                c6861l.f4304e = strM15044b;
                c6861l.f4301b.put("modifiedAfter", String.valueOf(jM328m));
                c6861l.m5035e();
                c6865pM5034d = c6861l.m5034d();
            } else {
                C6861l c6861l2 = new C6861l(c6903f2, context, c0097a);
                c6861l2.f4309j = "getNoteList";
                c6861l2.f4304e = strM15044b;
                String strValueOf = String.valueOf(jM328m);
                HashMap map = c6861l2.f4301b;
                map.put("modifiedAfter", strValueOf);
                map.put("notePageToken", str);
                c6861l2.m5035e();
                c6865pM5034d = c6861l2.m5034d();
            }
            C6906i c6906i = new C6906i(1, false);
            int i = c6865pM5034d.f4344a;
            int i2 = 2;
            if (i == 200) {
                String str2 = c6865pM5034d.f4346c;
                try {
                    XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(true);
                    XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    xmlPullParserNewPullParser.setInput(new StringReader(str2));
                    int eventType = xmlPullParserNewPullParser.getEventType();
                    while (true) {
                        if (eventType != 0) {
                            if (eventType == i2) {
                                String name = xmlPullParserNewPullParser.getName();
                                if (!name.equalsIgnoreCase("NoteListView")) {
                                    if (name.equalsIgnoreCase("noteList")) {
                                        c6906i.f4483b = new ArrayList();
                                    } else if (name.equalsIgnoreCase(FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE)) {
                                        c6906i.m5138d(xmlPullParserNewPullParser);
                                    } else if (name.equalsIgnoreCase("notePageToken")) {
                                        c6906i.f4484c = AbstractC14517a.m15134S(xmlPullParserNewPullParser);
                                    }
                                }
                            } else if (eventType != 3 && eventType != 4) {
                                Debugger.m8607d("ServerNoteInfoItem", "fromXMLString - invalid eventType = [" + eventType + "]");
                            }
                        }
                        eventType = AbstractC14517a.m15119D(xmlPullParserNewPullParser, 1);
                        if ((eventType == 3 && xmlPullParserNewPullParser.getName() != null && xmlPullParserNewPullParser.getName().equals("NoteListView")) || eventType == 1) {
                            break;
                        }
                        i2 = 2;
                    }
                } catch (Exception e) {
                    Debugger.m8609e("ServerNoteInfoItem", "fromXMLString : " + e.getMessage());
                    throw new SyncException(327, e.getMessage(), e);
                }
            } else if (i != 404) {
                AbstractC0299q.m600J(context, c6865pM5034d);
            }
            for (ServerNoteItem serverNoteItem : (ArrayList) c6906i.f4483b) {
                if (!serverNoteItem.isDeleted && ((folderNodeItem = (FolderNodeItem) c0077c.f270m.get(serverNoteItem.resourceId)) == null || !"deleted".equals(folderNodeItem.state))) {
                    if (serverNoteItem.isUpdatedByDevice) {
                        String str3 = serverNoteItem.resourceId;
                        if (str3 != null) {
                            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str3);
                            AbstractC0000a.m18o(context, context, context);
                        } else {
                            notesDocumentEntityM9f = null;
                        }
                        if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : -1L) >= serverNoteItem.syncModifiedTime) {
                        }
                    }
                    Debugger.m8615i("SyncNote", "calculateNewNotesInServer() : " + serverNoteItem.resourceId);
                    arrayList.add(serverNoteItem.resourceId);
                }
            }
            String str4 = (String) c6906i.f4484c;
            if (TextUtils.isEmpty(str4)) {
                break;
            }
            Debugger.m8615i("SyncNote", "calculateNewNotesInServer() : notePageToken = " + str4);
            str = str4;
            jElapsedRealtime = j;
        }
        int i4 = 0;
        int i5 = 0;
        for (String str5 : list) {
            if (arrayList.contains(str5)) {
                C6748q c6748q = new C6748q(context, str5);
                if (!c6748q.m4884l()) {
                    try {
                        BaseUtils.getApplicationContext();
                        C6901d.m5112b(c6748q, c0077c);
                        Debugger.m8615i("SyncNote", "calculateCommonSDocxNotes() : " + str5);
                    } catch (Exception e2) {
                        Debugger.m8615i("SyncNote", "calculateCommonSDocxNotes() : ignore " + str5 + " due to " + e2);
                    }
                } else if (c6748q.m4874b() == 0) {
                    Debugger.m8615i("SyncNote", "calculateCommonSDocxNotes() : [1] countOfNote + 2 <- " + str5);
                    i5 += 2;
                } else if (c6748q.m4874b() == 2) {
                    Debugger.m8615i("SyncNote", "calculateCommonSDocxNotes() : [2] countOfNote + 0 <- " + str5);
                } else {
                    Debugger.m8615i("SyncNote", "calculateCommonSDocxNotes() : [3] countOfNote + 1 <- " + str5);
                }
            }
            i5++;
        }
        try {
            ArrayList<C0009i> arrayListM41g = C0013b.m41g(this.f218c.m44f());
            List uUIDList = C0322h.m670a().f831q.getUUIDList(context);
            for (C0009i c0009i : arrayListM41g) {
                if (c0009i.f42e != C0322h.m670a().f831q.getSdocContractYes() && !uUIDList.contains(c0009i.f38a)) {
                    i4++;
                }
            }
        } catch (Exception e3) {
            AbstractC0000a.m22s("calculateOldNotesInServer() : ", e3, "SyncNote");
        }
        int size = list.size();
        int size2 = arrayList.size();
        int i6 = ((size + size2) - i5) + i4;
        StringBuilder sbM778t = AbstractC0541b.m778t(i6, "calculateSyncUiInfo() : ", " (et = ");
        sbM778t.append(SystemClock.elapsedRealtime() - j);
        sbM778t.append("), localSDocxNote = ");
        sbM778t.append(size);
        AbstractC0622a.m1180z(sbM778t, size2, i5, ", serverSDocxNote = ", ", commonSDocxNote = ");
        sbM778t.append(", serverOldNote = ");
        sbM778t.append(i4);
        Debugger.m8615i("SyncNote", sbM778t.toString());
        return i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x02f6 A[Catch: all -> 0x0278, TRY_ENTER, TryCatch #17 {all -> 0x0278, blocks: (B:90:0x024d, B:92:0x0257, B:94:0x0269, B:96:0x026e, B:113:0x02dc, B:116:0x02f6, B:118:0x0301, B:120:0x0309, B:124:0x0330, B:126:0x0334, B:127:0x0351, B:103:0x0284, B:105:0x02b1, B:107:0x02ba), top: B:159:0x024d, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0351 A[Catch: all -> 0x0278, TRY_LEAVE, TryCatch #17 {all -> 0x0278, blocks: (B:90:0x024d, B:92:0x0257, B:94:0x0269, B:96:0x026e, B:113:0x02dc, B:116:0x02f6, B:118:0x0301, B:120:0x0309, B:124:0x0330, B:126:0x0334, B:127:0x0351, B:103:0x0284, B:105:0x02b1, B:107:0x02ba), top: B:159:0x024d, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea A[Catch: all -> 0x016a, TRY_ENTER, TryCatch #4 {all -> 0x016a, blocks: (B:40:0x00d0, B:43:0x00ea, B:45:0x00f5, B:47:0x00fd), top: B:145:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0193 A[Catch: all -> 0x0116, TRY_LEAVE, TryCatch #15 {all -> 0x0116, blocks: (B:51:0x010d, B:58:0x0166, B:63:0x0172, B:65:0x0176, B:54:0x011a, B:56:0x0127, B:57:0x0130, B:66:0x0193), top: B:167:0x010d, inners: #13 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m95b() throws Throwable {
        C0082h c0082h;
        long j;
        Throwable th;
        Context context;
        Iterator<String> it;
        String str;
        Exception exc;
        C0077c c0077c = this.f216a;
        C6734c c6734c = c0077c.f267j;
        HashMap map = c0077c.f270m;
        Context context2 = c0077c.f262e;
        List<String> uuidListByConflictStrategy = c6734c.f4096a.getUuidListByConflictStrategy(1);
        String str2 = c0077c.f264g.f325d;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        long j2 = 0;
        C0075a c0075a = this.f221f;
        if (!zIsEmpty && c0077c.f264g.f324c == 1 && !uuidListByConflictStrategy.contains(str2) && SyncState.getDontSyncNewNote(str2) != 0) {
            c0075a.m212d(str2);
        }
        Iterator<String> it2 = uuidListByConflictStrategy.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            c0082h = this.f217b;
            j = j2;
            if (!zHasNext) {
                break;
            }
            String next = it2.next();
            C6748q c6748q = new C6748q(context2, next);
            String strM4881i = c6748q.m4881i();
            try {
                try {
                    if (SyncState.getDontSyncNewNote(next) != j) {
                        c0075a.m212d(next);
                        it = it2;
                    } else {
                        Debugger.m8615i("SyncNote", "handleConflictedNoteReplaced() : call updateLocalNote " + next);
                        it = it2;
                        try {
                            try {
                                str = next;
                            } catch (Exception e) {
                                e = e;
                                str = next;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = next;
                            try {
                                Debugger.m8609e("SyncNote", "handleConflictedNoteReplaced() : fail to updateLocalNote " + str);
                                if (e instanceof SyncException) {
                                    context = context2;
                                    Debugger.m8609e("SyncNote", "handleConflictedNoteReplaced() : ignored docUuid = " + str + ", e = " + e.getMessage());
                                } else {
                                    SyncException syncException = (SyncException) e;
                                    if (syncException.getExceptionCode() == 315 && syncException.getStatusCode() == 404) {
                                        FolderNodeItem folderNodeItem = (FolderNodeItem) map.get(str);
                                        InterfaceC14510a interfaceC14510a = this.f219d;
                                        exc = e;
                                        if (folderNodeItem != null) {
                                            context = context2;
                                            try {
                                                new C0069j(c0077c, c0082h, interfaceC14510a, folderNodeItem).m159a("handleConflictedNoteReplaced");
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                try {
                                                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                                                    throw th;
                                                } catch (Exception e3) {
                                                    AbstractC0000a.m21r(e3, new StringBuilder("handleConflictedNoteReplaced() : "), "SyncNote");
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            context = context2;
                                            c0082h.m222i();
                                            FolderNodeItem folderNodeItem2 = (FolderNodeItem) map.get(str);
                                            if (folderNodeItem2 != null) {
                                                new C0069j(c0077c, c0082h, interfaceC14510a, folderNodeItem2).m159a("handleConflictedNoteReplaced");
                                            } else {
                                                Debugger.m8609e("SyncNote", "handleConflictedNoteReplaced() : folderNodeItem of " + str + " is null and so pass to trash!");
                                                long currentTime = TimeManager.getCurrentTime();
                                                c0077c.f266i.m4889e(str, "trash:///", 0, currentTime, currentTime, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED, PredefinedCategory.UNCATEGORIZED.getPath());
                                            }
                                        }
                                        c0075a.m212d(str);
                                    } else {
                                        exc = e;
                                        context = context2;
                                    }
                                    try {
                                        c0082h.m224k(c6748q, syncException, str);
                                    } catch (SyncException unused) {
                                        Debugger.m8609e("SyncNote", "handleConflictedNoteReplaced() : ignored docUuid = " + str + ", e = " + exc.getMessage());
                                    }
                                }
                                try {
                                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                                } catch (Exception e5) {
                                    AbstractC0000a.m21r(e5, new StringBuilder("handleConflictedNoteReplaced() : "), "SyncNote");
                                }
                                j2 = j;
                                it2 = it;
                                context2 = context;
                            } catch (Throwable th3) {
                                th = th3;
                                context = context2;
                            }
                        }
                        try {
                            new C0070k(this.f216a, this.f217b, this.f219d, new C0097a(), next, this.f221f).m161f(strM4881i, null, c6748q, false);
                        } catch (Exception e6) {
                            e = e6;
                            Debugger.m8609e("SyncNote", "handleConflictedNoteReplaced() : fail to updateLocalNote " + str);
                            if (e instanceof SyncException) {
                            }
                            FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                        }
                    }
                    try {
                        FileUtils.deleteFile(new File(AbstractC0155m.m398m(context2)));
                    } catch (Exception e7) {
                        AbstractC0000a.m21r(e7, new StringBuilder("handleConflictedNoteReplaced() : "), "SyncNote");
                    }
                    context = context2;
                } catch (Exception e8) {
                    e = e8;
                    it = it2;
                }
                j2 = j;
                it2 = it;
                context2 = context;
            } catch (Throwable th4) {
                th = th4;
                context = context2;
                FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                throw th;
            }
        }
        Context context3 = context2;
        List<String> uuidListByConflictStrategy2 = c0077c.f267j.f4096a.getUuidListByConflictStrategy(2);
        String str3 = c0077c.f264g.f325d;
        if (!TextUtils.isEmpty(str3) && c0077c.f264g.f324c == 2 && !uuidListByConflictStrategy2.contains(str3) && SyncState.getDontSyncNewNote(str3) != j) {
            new C0065f(this.f216a, this.f217b, this.f219d, null, str3).m153a("downSyncConflictedNotes_1", j);
        }
        Iterator<String> it3 = uuidListByConflictStrategy2.iterator();
        while (it3.hasNext()) {
            String next2 = it3.next();
            Context context4 = context3;
            C6748q c6748q2 = new C6748q(context4, next2);
            String strM4881i2 = c6748q2.m4881i();
            try {
                try {
                    if (SyncState.getDontSyncNewNote(next2) != 0) {
                        try {
                            new C0065f(this.f216a, this.f217b, this.f219d, null, next2).m153a("downSyncConflictedNotes_2", 0L);
                        } catch (Exception e9) {
                            e = e9;
                            next2 = next2;
                            Debugger.m8609e("SyncNote", "handleConflictedNoteBoth() : fail to updateLocalNote " + next2);
                            if (e instanceof SyncException) {
                                Debugger.m8609e("SyncNote", "handleConflictedNoteBoth() : ignored docUuid = " + next2 + ", e = " + e.getMessage());
                            } else {
                                SyncException syncException2 = (SyncException) e;
                                if (syncException2.getExceptionCode() == 315 && syncException2.getStatusCode() == 404) {
                                    new C0065f(this.f216a, this.f217b, this.f219d, null, next2).m153a("downSyncConflictedNotes", 0L);
                                } else {
                                    try {
                                        c0082h.m224k(c6748q2, syncException2, next2);
                                    } catch (SyncException unused2) {
                                        Debugger.m8609e("SyncNote", "handleConflictedNoteBoth() : ignored docUuid = " + next2 + ", e = " + e.getMessage());
                                    }
                                }
                            }
                            try {
                                FileUtils.deleteFile(new File(AbstractC0155m.m398m(context4)));
                            } catch (Exception e10) {
                                AbstractC0000a.m21r(e10, new StringBuilder("handleConflictedNoteBoth() : "), "SyncNote");
                            }
                        }
                    } else {
                        Debugger.m8615i("SyncNote", "handleConflictedNoteBoth() : call updateLocalNote " + next2);
                        C0070k c0070k = new C0070k(this.f216a, this.f217b, this.f219d, new C0097a(), next2, this.f221f);
                        next2 = next2;
                        try {
                            c0070k.m161f(strM4881i2, null, c6748q2, false);
                        } catch (Exception e11) {
                            e = e11;
                            Debugger.m8609e("SyncNote", "handleConflictedNoteBoth() : fail to updateLocalNote " + next2);
                            if (e instanceof SyncException) {
                            }
                            FileUtils.deleteFile(new File(AbstractC0155m.m398m(context4)));
                        }
                    }
                    try {
                        FileUtils.deleteFile(new File(AbstractC0155m.m398m(context4)));
                    } catch (Exception e12) {
                        AbstractC0000a.m21r(e12, new StringBuilder("handleConflictedNoteBoth() : "), "SyncNote");
                    }
                } catch (Exception e13) {
                    e = e13;
                }
                context3 = context4;
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m96c(boolean z) {
        HashMap map = (HashMap) C6903f.m5119c().f4476d;
        if (map.isEmpty()) {
            return;
        }
        C6903f c6903fM5119c = C6903f.m5119c();
        SyncProgressManager$SyncProgressStep syncProgressManager$SyncProgressStep = SyncProgressManager$SyncProgressStep.SyncDownImmediately;
        c6903fM5119c.getClass();
        Debugger.m8615i("SyncProgressManager", "setSyncProgressStep() : " + syncProgressManager$SyncProgressStep.toString());
        c6903fM5119c.f4474b = syncProgressManager$SyncProgressStep;
        Iterator it = map.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            C0077c c0077c = this.f216a;
            if (!zHasNext) {
                C6903f c6903fM5119c2 = C6903f.m5119c();
                SyncProgressManager$SyncProgressStep syncProgressManager$SyncProgressStep2 = SyncProgressManager$SyncProgressStep.NONE;
                c6903fM5119c2.getClass();
                Debugger.m8615i("SyncProgressManager", "setSyncProgressStep() : " + syncProgressManager$SyncProgressStep2.toString());
                c6903fM5119c2.f4474b = syncProgressManager$SyncProgressStep2;
                try {
                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(c0077c.f262e)));
                    return;
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("downSyncRequestedNoteImmediately() : "), "SyncNote");
                    return;
                }
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            SyncProgressListener syncProgressListener = (SyncProgressListener) entry.getValue();
            if (syncProgressListener != null) {
                Debugger.m8615i("SyncNote", "downSyncRequestedNoteImmediately() : docUuid = " + str);
                try {
                    syncProgressListener.onStarted();
                } catch (Exception e2) {
                    Debugger.m8609e("SyncNote", "downSyncRequestedNoteImmediately() : onStarted, e = " + e2);
                    it.remove();
                }
            } else {
                Debugger.m8615i("SyncNote", "downSyncRequestedNoteImmediately() : No listener, docUuid = " + str);
            }
            C6748q c6748q = new C6748q(c0077c.f262e, str);
            if (c6748q.f4128a == null) {
                Debugger.m8609e("SyncNote", "downSyncRequestedNoteImmediately() : No local note, docUuid = " + str);
                m93h(syncProgressListener, 1);
            } else {
                String strM4881i = c6748q.m4881i();
                if (TextUtils.isEmpty(strM4881i)) {
                    Debugger.m8609e("SyncNote", "downSyncRequestedNoteImmediately() : serverId is null, docUuid = " + str);
                    m93h(syncProgressListener, 1);
                } else {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        new C0070k(this.f216a, this.f217b, this.f219d, new C0097a(), str, this.f221f).m161f(strM4881i, null, c6748q, z);
                        m93h(syncProgressListener, 0);
                    } catch (Exception e5) {
                        e = e5;
                        Debugger.m8609e("SyncNote", "downSyncRequestedNoteImmediately() : fail to downSync, docUuid = " + str + ", e = " + e);
                        m93h(syncProgressListener, 1);
                    }
                }
            }
            it.remove();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02d4 A[Catch: all -> 0x0238, TRY_LEAVE, TryCatch #7 {all -> 0x0238, blocks: (B:103:0x02d0, B:105:0x02d4, B:117:0x0308, B:85:0x01fb, B:87:0x0202, B:96:0x024a, B:97:0x0284), top: B:149:0x02d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0308 A[EDGE_INSN: B:169:0x0308->B:117:0x0308 BREAK  A[LOOP:0: B:3:0x0004->B:174:0x0004], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0244  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m97d() throws Throwable {
        C0023f c0023fM56b;
        Throwable th;
        Context context;
        C0082h c0082h;
        String str;
        int i;
        SyncDelayInfoEntity syncDelayInfoEntity;
        StringBuilder sb;
        StringBuilder sb2;
        int i2 = 0;
        boolean z = true;
        while (true) {
            C0082h c0082h2 = this.f217b;
            InterfaceC14510a interfaceC14510a = this.f219d;
            c0082h2.m219f(interfaceC14510a, "SDocxChanges");
            c0082h2.m218d();
            c0082h2.m220g();
            C0077c c0077c = this.f216a;
            C6903f c6903f = c0077c.f265h;
            Context context2 = c0077c.f262e;
            c6903f.m5131p("ND");
            try {
                String strM331p = C0145c.m331p("sync_v2_pref", "lastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiTk9URSJ9");
                C0077c c0077c2 = c0082h2.f286b;
                c0077c2.f265h.m5131p("ND");
                c0023fM56b = new C0028a(c0077c2.f265h, c0077c2.f262e, new C0097a(), strM331p).m56b();
                c0082h2.m219f(interfaceC14510a, "SDocxChanges!");
                c0082h2.m218d();
            } catch (SyncException e) {
                int i4 = i2;
                boolean z2 = z;
                if (e.getStatusCode() != 403) {
                    break;
                }
                i2 = i4 + 1;
                if (i4 >= 2) {
                    break;
                }
                c0082h2.m221h();
                this.f218c.m42d();
                z = z2;
                throw e;
            }
            if (((C0022e) c0023fM56b.f127c) == null) {
                if (!z) {
                    Debugger.m8615i("SyncNote", "downSyncServerChanges() finish");
                    return;
                }
                Debugger.m8615i("SyncNote", "downSyncServerChanges() : None");
                C0152j c0152jM378g = AbstractC0153k.m378g();
                c0152jM378g.f454c = "No server note change";
                c0152jM378g.m371b(context2);
                return;
            }
            Debugger.m8615i("SyncNote", "downSyncServerChanges()");
            C0022e c0022e = (C0022e) c0023fM56b.f127c;
            String str2 = c0022e.f116a;
            String str3 = c0022e.f117b;
            if (TextUtils.isEmpty(str2)) {
                Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "isAvailableDownSync() : skip " + str3 + " due to the empty serverId");
            } else if (((C0022e) c0023fM56b.f127c).f120e && SystemPropertiesCompat.INSTANCE.getInstance().isLDUModel()) {
                Debugger.m8615i("SyncProcessTask$SyncOperationSDocx", "ignore the downloaded lock note due to the LDU!");
            } else if (UUIDUtils.isCoeditUuid(str3)) {
                Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "isAvailableDownSync() : skip " + str3 + " due to the coEdit uuid");
            } else {
                C0022e c0022e2 = (C0022e) c0023fM56b.f127c;
                String str4 = c0022e2.f116a;
                String str5 = c0022e2.f117b;
                C6748q c6748q = new C6748q(context2, str5);
                if (!((C0022e) c0023fM56b.f127c).f119d && c6748q.f4128a != null && !str4.equals(c6748q.m4881i())) {
                    Debugger.m8614f("SyncNote", "repairServerId() : updated serverId " + str4 + " of " + str5);
                    c0077c.f266i.f4134b.updateNoteServerId(str5, str4);
                }
                int i5 = ((C0022e) c0023fM56b.f127c).f124i;
                boolean z3 = !SyncState.isHighFormatVerTest() ? i5 <= 5400 : i5 <= 4000;
                long jM4883k = c6748q.m4883k();
                C0022e c0022e3 = (C0022e) c0023fM56b.f127c;
                int i6 = i2;
                boolean z4 = z;
                long j = c0022e3.f118c;
                if (z3) {
                    try {
                        try {
                            if (!c0022e3.f119d) {
                                if (j > jM4883k) {
                                    try {
                                        i = c0022e3.f124i;
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                    try {
                                        syncDelayInfoEntity = new SyncDelayInfoEntity();
                                        syncDelayInfoEntity.setUuid(str5);
                                        syncDelayInfoEntity.setServerId(str4);
                                        syncDelayInfoEntity.setAppVersion(C0145c.m322g());
                                        syncDelayInfoEntity.setReason(12000);
                                    } catch (Exception e3) {
                                        e = e3;
                                        c0082h = c0082h2;
                                        context = context2;
                                        str = "downSyncServerChanges() finish";
                                        try {
                                            if (e instanceof SyncException) {
                                                throw e;
                                            }
                                            c0082h.m224k(c6748q, (SyncException) e, str5);
                                            try {
                                                FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                                            } catch (Exception e5) {
                                                e = e5;
                                                sb = new StringBuilder("downSyncServerChanges : ");
                                                AbstractC0000a.m21r(e, sb, "SyncNote");
                                            }
                                            AbstractC0299q.m620b0(c0023fM56b.f125a);
                                            if (!c0023fM56b.f126b) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                                                throw th;
                                            } catch (Exception e6) {
                                                AbstractC0000a.m21r(e6, new StringBuilder("downSyncServerChanges : "), "SyncNote");
                                                throw th;
                                            }
                                        }
                                    }
                                    try {
                                        syncDelayInfoEntity.setRetryCount(0);
                                        syncDelayInfoEntity.setServerTimestamp(j);
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put(DBSchema.DocumentExtra.FORMAT_VERSION, i);
                                        } catch (JSONException unused) {
                                            Debugger.m8609e("SyncDelayInfoUtils", "UpdateSyncDelayInfo() : fail to put jsonObject!");
                                        }
                                        syncDelayInfoEntity.setExtra(jSONObject.toString());
                                        C6742k.m4841o().m4847G(syncDelayInfoEntity);
                                    } catch (Exception e7) {
                                        e = e7;
                                        c0082h = c0082h2;
                                        context = context2;
                                        str = "downSyncServerChanges() finish";
                                        if (e instanceof SyncException) {
                                        }
                                    }
                                }
                                try {
                                    if (c6748q.f4128a != null) {
                                        if (c6748q.m4878f() == 1) {
                                            new C0113a(str5).m271b(((C0022e) c0023fM56b.f127c).f121f, "Local note is update and conflicted!");
                                        }
                                        if (ComposerManager.getInstance().isOpen(str5, null) && !this.f221f.m213e(str5)) {
                                            Debugger.m8609e("SyncNote", "handleLatestServerNote() : fail to notify the invalid version = " + str5);
                                        }
                                    }
                                    throw new SyncException(12000, "High formated note");
                                } catch (Exception e8) {
                                    e = e8;
                                    c0082h = c0082h2;
                                    context = context2;
                                    str = "downSyncServerChanges() finish";
                                    if (e instanceof SyncException) {
                                    }
                                }
                            }
                            context = context2;
                            if (j <= jM4883k) {
                                str = "downSyncServerChanges() finish";
                                try {
                                    sb2 = new StringBuilder();
                                    c0082h = c0082h2;
                                } catch (Exception e9) {
                                    e = e9;
                                    c0082h = c0082h2;
                                }
                                try {
                                    sb2.append("handleLatestServerNote() : ");
                                    sb2.append(str5);
                                    sb2.append(", remoteServerTimeStamp = ");
                                    sb2.append(j);
                                    sb2.append(", isServerDeleted = ");
                                    sb2.append(((C0022e) c0023fM56b.f127c).f119d);
                                    sb2.append(", localServerTimeStamp = ");
                                    sb2.append(jM4883k);
                                    sb2.append(", isLocalDeleted = ");
                                    sb2.append(c6748q.m4878f());
                                    Debugger.m8615i("SyncNote", sb2.toString());
                                    m99f(c0023fM56b, c6748q);
                                } catch (Exception e10) {
                                    e = e10;
                                    if (e instanceof SyncException) {
                                    }
                                }
                            } else {
                                str = "downSyncServerChanges() finish";
                                if (j < jM4883k) {
                                    Debugger.m8615i("SyncNote", "handleLatestLocalNote() : " + str5 + ", remoteServerTimeStamp = " + j + ", isServerDeleted = " + ((C0022e) c0023fM56b.f127c).f119d + ", localServerTimeStamp = " + jM4883k + ", isLocalDeleted = " + c6748q.m4878f());
                                    m98e(c0023fM56b, c6748q);
                                } else {
                                    Debugger.m8615i("SyncNote", "handleSameTimeNotes() : " + str5 + ", ServerTimeStamp = " + j + ", isServerDeleted = " + ((C0022e) c0023fM56b.f127c).f119d + ", isLocalDeleted = " + c6748q.m4878f());
                                    m92g(c0023fM56b, c6748q);
                                }
                            }
                            try {
                                FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                            } catch (Exception e11) {
                                e = e11;
                                sb = new StringBuilder("downSyncServerChanges : ");
                                AbstractC0000a.m21r(e, sb, "SyncNote");
                            }
                        } catch (Exception e12) {
                            e = e12;
                        }
                        AbstractC0299q.m620b0(c0023fM56b.f125a);
                        if (!c0023fM56b.f126b) {
                            Debugger.m8615i("SyncNote", str);
                            return;
                        } else {
                            z = z4 ? false : z4;
                            i2 = i6;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        context = context2;
                        FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                        throw th;
                    }
                } else {
                    context = context2;
                    if (j <= jM4883k) {
                    }
                    FileUtils.deleteFile(new File(AbstractC0155m.m398m(context)));
                    AbstractC0299q.m620b0(c0023fM56b.f125a);
                    if (!c0023fM56b.f126b) {
                    }
                }
            }
            AbstractC0299q.m620b0(c0023fM56b.f125a);
            if (!c0023fM56b.f126b) {
                Debugger.m8615i("SyncNote", "downSyncServerChanges() finish");
                return;
            } else if (z) {
                z = false;
            }
        }
        throw e;
    }

    /* JADX INFO: renamed from: e */
    public final void m98e(C0023f c0023f, C6748q c6748q) {
        String str = ((C0022e) c0023f.f127c).f117b;
        if (c6748q.m4878f() == 1) {
            Debugger.m8615i("SyncNote", "handleLatestLocalNote() : " + str + " is a deleted state locally");
            return;
        }
        C0022e c0022e = (C0022e) c0023f.f127c;
        if (!c0022e.f119d) {
            if (!c0022e.f123h) {
                new C0113a(str).m273d(c6748q, c0022e.f121f, c0022e.f122g);
                return;
            }
            Debugger.m8615i("SyncNote", "handleLatestLocalNote() : " + str + " is modified later than server");
            return;
        }
        Debugger.m8615i("SyncNote", "handleLatestLocalNote() : " + str + " is a deleted state remotely");
        if (ComposerManager.getInstance().isOpen(str, null)) {
            Debugger.m8615i("SyncNote", "handleLatestLocalNote() : The composer is closed!");
            this.f221f.m212d(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.content.Context] */
    /* JADX INFO: renamed from: f */
    public final void m99f(C0023f c0023f, C6748q c6748q) throws Throwable {
        Context context;
        long j;
        Context context2;
        ?? r5 = "handleLatestServerNote() : fail to SyncSDocxUpdateLocalNote, ";
        C0022e c0022e = (C0022e) c0023f.f127c;
        String str = c0022e.f116a;
        String str2 = c0022e.f117b;
        long jM4883k = c6748q.m4883k();
        C0022e c0022e2 = (C0022e) c0023f.f127c;
        long j2 = c0022e2.f118c;
        boolean z = c0022e2.f119d;
        InterfaceC14510a interfaceC14510a = this.f219d;
        C0082h c0082h = this.f217b;
        C0077c c0077c = this.f216a;
        if (z) {
            String encode = TextUtils.isEmpty(c0022e2.f121f) ? "ServerNote" : Logger.getEncode(((C0022e) c0023f.f127c).f121f);
            if (jM4883k == -1) {
                Debugger.m8615i("SyncNote", "handleLatestServerNote() : delete " + str2 + "(already deleted) by " + encode);
                return;
            }
            FolderNodeItem folderNodeItem = (FolderNodeItem) c0077c.f270m.get(str2);
            if (folderNodeItem != null) {
                new C0069j(c0077c, c0082h, interfaceC14510a, folderNodeItem).m159a(encode);
                return;
            }
            Debugger.m8609e("SyncNote", "handleLatestServerNote() : folderNodeItem of " + str2 + " is null and so pass to trash!");
            return;
        }
        HashMap map = c0077c.f270m;
        Context context3 = c0077c.f262e;
        FolderNodeItem folderNodeItem2 = (FolderNodeItem) map.get(str2);
        if (c6748q.f4128a != null) {
            Context context4 = context3;
            if (folderNodeItem2 != null && j2 < folderNodeItem2.syncModifiedTime && "deleted".equals(folderNodeItem2.state)) {
                new C0069j(c0077c, c0082h, interfaceC14510a, folderNodeItem2).m159a("SyncNote");
                return;
            }
            try {
                try {
                    try {
                        j = j2;
                    } catch (SyncException e) {
                        e = e;
                        context = context4;
                        j = j2;
                    }
                    try {
                        context4 = null;
                        new C0070k(this.f216a, this.f217b, this.f219d, new C0097a(), str2, this.f221f).m161f(str, ((C0022e) c0023f.f127c).f121f, c6748q, false);
                        AbstractC0153k.m379h(context4, "updateLocalNote_res");
                        return;
                    } catch (SyncException e2) {
                        e = e2;
                        context = context4;
                        Debugger.m8609e("SyncNote", "handleLatestServerNote() : fail to SyncSDocxUpdateLocalNote, " + e);
                        if (e.getExceptionCode() != 15000) {
                            throw e;
                        }
                        SyncDelayInfoEntity syncDelayInfoEntityM15162v = AbstractC14517a.m15162v(CoeditBaseConstants.COEDIT_IMPORT_MAX_STROKE_OBJECT, str2, str);
                        syncDelayInfoEntityM15162v.setServerTimestamp(j);
                        C6742k.m4841o().m4847G(syncDelayInfoEntityM15162v);
                        AbstractC0153k.m379h(context, "updateLocalNote_res");
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    AbstractC0153k.m379h(context4, "updateLocalNote_res");
                    throw th;
                }
            } catch (Exception e3) {
                throw e3;
            } catch (Throwable th2) {
                th = th2;
                context4 = context4;
                AbstractC0153k.m379h(context4, "updateLocalNote_res");
                throw th;
            }
        }
        C0097a c0097a = new C0097a();
        if (folderNodeItem2 != null && j2 < folderNodeItem2.syncModifiedTime && "deleted".equals(folderNodeItem2.state)) {
            C0158a.m407a().getClass();
            if (C0158a.m410f()) {
                return;
            }
            StringBuilder sbM15l = AbstractC0000a.m15l("handleLatestServerNote() : ignore to createLocalNote and deleteServerNote : ", str2, " ,syncModifiedTime = ");
            sbM15l.append(folderNodeItem2.syncModifiedTime);
            Debugger.m8614f("SyncNote", sbM15l.toString());
            new C0066g(this.f216a, this.f217b, this.f219d, c0097a, str2).m154a(str, folderNodeItem2.syncModifiedTime);
            return;
        }
        try {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                context2 = context3;
                try {
                    new C0062c(this.f216a, this.f217b, this.f219d, c0097a, str2, this.f221f).m143e(str, ((C0022e) c0023f.f127c).f121f);
                    Debugger.m8615i("SyncNote", "handleLatestServerNote() : createLocalNote et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                    AbstractC0153k.m379h(context2, "createLocalNote_res");
                } catch (SyncException e5) {
                    e = e5;
                    Debugger.m8609e("SyncNote", "handleLatestServerNote() : fail to createLocalNote, " + e);
                    if (e.getExceptionCode() == 315 && e.getStatusCode() == 404) {
                        C6742k.m4841o().m4855l(str2);
                    } else if (e.getExceptionCode() == 12001) {
                        C6742k.m4841o().m4847G(AbstractC14517a.m15162v(12001, str2, str));
                        AbstractC0153k.m379h(context2, "createLocalNote_res");
                        return;
                    }
                    throw e;
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                th = th3;
                AbstractC0153k.m379h(r5, "createLocalNote_res");
                throw th;
            }
        } catch (SyncException e7) {
            e = e7;
            context2 = context3;
        } catch (Exception e8) {
            throw e8;
        } catch (Throwable th4) {
            th = th4;
            r5 = context3;
            AbstractC0153k.m379h(r5, "createLocalNote_res");
            throw th;
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m100i(boolean z) {
        C0075a c0075a = this.f221f;
        C0077c c0077c = this.f216a;
        Context context = c0077c.f262e;
        Context context2 = c0077c.f262e;
        AbstractC0153k.m373b(context);
        AbstractC0153k.m374c("SyncNote", "Note (downSync)");
        try {
            try {
                c0075a.f255a.m4869a();
                if (z) {
                    m96c(true);
                } else {
                    m102k();
                    if (C6899b.m5109a().f4467a) {
                        int iM94a = m94a();
                        C0098b c0098b = new C0098b();
                        c0098b.f321a = iM94a;
                        this.f220e.mo5105b(c0098b);
                        C6899b.m5109a().f4467a = false;
                    }
                    m95b();
                    m97d();
                    C0145c.m308P(TimeManager.getCurrentTime(), "SyncDataSDocx", "lastSyncModifiedTime");
                }
                if (!z) {
                    C0158a.m407a().getClass();
                    if (!C0158a.m410f()) {
                        AbstractC0153k.m374c("SyncNote", "Note (upSync)");
                        m103l();
                        if (C0158a.m407a().m416i() && !ComposerManager.getInstance().isRunningOnEditMode()) {
                            AbstractC6784f.f4180a.m4951q();
                        }
                    }
                }
                c0075a.f255a.m4870b();
                AbstractC0153k.m379h(context2, "downSyncedNotesChanged");
                AbstractC0153k.m373b(context2);
            } finally {
                try {
                    FileUtils.deleteFile(new File(C11971a.m13526c(context2)));
                    AbstractC0153k.m379h(context2, "upSyncedNotesChanges");
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("perform() : fail to delete the temp files : "), "SyncNote");
                }
            }
        } catch (Throwable th) {
            c0075a.f255a.m4870b();
            AbstractC0153k.m379h(context2, "downSyncedNotesChanged");
            throw th;
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m101j() {
        Method declaredMethod;
        Debugger.m8607d("SyncNote", "prePerform() start");
        if (SyncState.isClearInvalidCoEditNotes()) {
            Debugger.m8615i("SyncNote", "handleInvalidCoeditNotesInServer() start");
            String str = "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiTk9URSJ9";
            while (true) {
                InterfaceC14510a interfaceC14510a = this.f219d;
                C0082h c0082h = this.f217b;
                c0082h.m219f(interfaceC14510a, "handleInvalidCoeditNotesInServer");
                c0082h.m218d();
                c0082h.m220g();
                C0077c c0077c = c0082h.f286b;
                c0077c.f265h.m5131p("ND");
                C0023f c0023fM56b = new C0028a(c0077c.f265h, c0077c.f262e, new C0097a(), str).m56b();
                C0022e c0022e = (C0022e) c0023fM56b.f127c;
                if (c0022e == null) {
                    break;
                }
                String str2 = c0022e.f117b;
                if (!c0022e.f119d && UUIDUtils.isCoeditUuid(str2)) {
                    C0097a c0097a = new C0097a();
                    C0077c c0077c2 = this.f216a;
                    new C0032e(c0077c2.f265h, c0077c2.f262e, c0097a, ((C0022e) c0023fM56b.f127c).f116a, TimeManager.getCurrentTime()).m61b();
                }
                String str3 = c0023fM56b.f125a;
                if (!c0023fM56b.f126b) {
                    break;
                } else {
                    str = str3;
                }
            }
            SyncState.setClearInvalidCoEditNotes(false);
            Debugger.m8615i("SyncNote", "handleInvalidCoeditNotesInServer() finish");
        }
        if (C0145c.m323h("SyncData", "powersaveAllowlistRequested", true)) {
            if (!C0145c.m340y()) {
                try {
                    Object objM326k = C0145c.m326k();
                    if (objM326k != null && (declaredMethod = objM326k.getClass().getDeclaredMethod("addPowerSaveWhitelistApp", String.class)) != null) {
                        Debugger.m8614f("AppUtil", "addNotesToPowerSaveAllowlistApp : call DeviceIdleService.addPowerSaveAllowlistApp");
                        declaredMethod.invoke(objM326k, "com.samsung.android.app.notes");
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    Debugger.m8609e("AppUtil", "addNotesToPowerSaveAllowlistApp : " + e);
                }
            }
            C0145c.m304L("SyncData", "powersaveAllowlistRequested", false);
        }
        Debugger.m8607d("SyncNote", "prePerform() finish");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098 A[PHI: r10
      0x0098: PHI (r10v11 ??) = (r10v25 ??), (r10v26 ??) binds: [B:6:0x0032, B:8:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [E1.b] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18, types: [E1.b, E1.c] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v12 */
    /* JADX WARN: Type inference failed for: r19v13 */
    /* JADX WARN: Type inference failed for: r19v14 */
    /* JADX WARN: Type inference failed for: r19v15 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r19v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [E1.h] */
    /* JADX WARN: Type inference failed for: r6v0, types: [E1.b, E1.c] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.samsung.android.app.notes.sync.db.q] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v4, types: [D1.e, D1.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m102k() {
        ?? M4881i;
        ?? r19;
        ?? r6;
        C0082h c0082h;
        InterfaceC14510a interfaceC14510a;
        ITempServerNoteListener tempServerNoteListener;
        ?? r192;
        ?? r10;
        String str;
        String str2;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository;
        TemporalServerNoteInfo temporalServerNoteInfo = AbstractC14517a.f10347b;
        ?? r5 = this.f217b;
        ?? r62 = this.f216a;
        if (temporalServerNoteInfo == null) {
            r192 = r62;
        } else {
            String docUuid = temporalServerNoteInfo.getDocUuid();
            Debugger.m8615i("SyncNote", "downSyncTemporalServerNoteFirst() : " + docUuid);
            M4881i = r62.f262e;
            C6748q c6748q = new C6748q(M4881i, docUuid);
            M4881i = M4881i;
            if (docUuid != null) {
                try {
                    try {
                        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
                        M4881i = notesDocumentEntity;
                        if (notesDocumentEntity != null) {
                            M4881i = c6748q.m4881i();
                            try {
                                if (TextUtils.isEmpty(M4881i)) {
                                    r19 = r62;
                                    r62 = c6748q;
                                    Debugger.m8609e("SyncNote", "downSyncTemporalServerNoteFirst() : serverId is null!");
                                    M4881i = M4881i;
                                } else {
                                    C0097a c0097a = new C0097a();
                                    try {
                                        C0077c c0077c = this.f216a;
                                        try {
                                            c0082h = this.f217b;
                                            interfaceC14510a = this.f219d;
                                            tempServerNoteListener = temporalServerNoteInfo.getTempServerNoteListener();
                                        } catch (Exception e) {
                                            e = e;
                                            r19 = r62;
                                            r6 = c6748q;
                                            M4881i = c0077c;
                                        }
                                        try {
                                            r19 = r62;
                                            r62 = c6748q;
                                            ?? c0064e = new C0064e(c0077c, c0082h, interfaceC14510a, c0097a, docUuid, this.f221f);
                                            c0064e.f244h = tempServerNoteListener;
                                            c0064e.m152g(M4881i, temporalServerNoteInfo.getFullFolderPath());
                                            M4881i = c0077c;
                                        } catch (Exception e2) {
                                            e = e2;
                                            r19 = r62;
                                            r6 = c6748q;
                                            M4881i = c0077c;
                                            if (e instanceof SyncException) {
                                                SyncException syncException = (SyncException) e;
                                                if (ComposerManager.getInstance().isOpen(docUuid, null) && !this.f221f.m213e(docUuid)) {
                                                    Debugger.m8609e("SyncNote", "handleLatestServerNote() : fail to notify the invalid version = ".concat(docUuid));
                                                }
                                                try {
                                                    r5.m224k(r6, syncException, docUuid);
                                                } catch (SyncException unused) {
                                                    Debugger.m8609e("SyncNote", "downSyncTemporalServerNoteFirst() : ignored docUuid = " + docUuid + ", e = " + e.getMessage());
                                                }
                                            } else {
                                                Debugger.m8609e("SyncNote", "downSyncTemporalServerNoteFirst() : e = " + e.getMessage());
                                            }
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        r19 = r62;
                                        r6 = c6748q;
                                        M4881i = M4881i;
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                r6 = r62;
                                M4881i = M4881i;
                                r19 = r19;
                            }
                        } else {
                            r19 = r62;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        r19 = r62;
                        r6 = c6748q;
                        M4881i = M4881i;
                    }
                    AbstractC14517a.f10347b = null;
                    r192 = r19;
                } catch (Throwable th) {
                    AbstractC14517a.f10347b = null;
                    throw th;
                }
            }
        }
        m96c(false);
        String str3 = AbstractC14517a.f10346a;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        Debugger.m8615i("SyncNote", "upSyncRequestedNoteFirst() : " + str3);
        try {
            try {
                boolean userConfirmConverting = MaxObjectLimitHelper.getUserConfirmConverting(str3);
                SyncProgressListener syncProgressListener = (SyncProgressListener) C6903f.m5119c().f4475c;
                if (userConfirmConverting) {
                    try {
                        try {
                            if (r5.m227n(str3)) {
                                ?? r102 = r192;
                                r102.f266i.f4134b.setStrokeGrouped(str3, 1);
                                Context context = r102.f262e;
                                if (str3 != null) {
                                    NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str3);
                                    syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
                                    NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
                                    NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                    str2 = str3;
                                } else {
                                    str2 = null;
                                    syncNoteDataRepositoryCreateSyncNoteDataRepository = null;
                                }
                                if (((syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getNoteSyncState(str2) : 0L) & 512) == 512) {
                                    Context applicationContext = BaseUtils.getApplicationContext();
                                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                                    SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                    syncNoteDataRepositoryCreateSyncNoteDataRepository2.removeNoteSyncStateFlag(str3, 512L);
                                }
                                MaxObjectLimitHelper.removeConfirmConverting(str3);
                                r10 = r102;
                            } else {
                                r10 = r192;
                                Debugger.m8609e("SyncNote", "upSyncLocalNote() : fail to saveStrokeGroupSync");
                            }
                        } catch (Exception e7) {
                            e = e7;
                            r10 = M4881i;
                            try {
                                Debugger.m8609e("SyncNote", "upSyncLocalNote() : fail to saveStrokeGroupSync, e = " + e);
                                r10 = r10;
                            } catch (Exception e8) {
                                e = e8;
                                if (!(e instanceof SyncException)) {
                                    throw e;
                                }
                                r5.m225l(new C6748q(r10.f262e, str3), (SyncException) e, str3);
                                str = null;
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        r10 = r192;
                    }
                } else {
                    r10 = r192;
                }
                if (syncProgressListener != null) {
                    try {
                        syncProgressListener.onStarted();
                    } catch (Exception e10) {
                        Debugger.m8609e("SyncNote", "upSyncLocalNote() : onStarted, e = " + e10);
                        C6903f.m5119c().f4475c = null;
                    }
                }
                m104m(str3);
                if (syncProgressListener != null) {
                    try {
                        syncProgressListener.onEnded(0);
                    } catch (Exception e11) {
                        Debugger.m8609e("SyncNote", "upSyncLocalNote() : onEnded, e = " + e11);
                    }
                    C6903f.m5119c().f4475c = null;
                }
                str = null;
            } catch (Throwable th2) {
                AbstractC14517a.f10346a = null;
                throw th2;
            }
        } catch (Exception e12) {
            e = e12;
            r10 = r192;
        }
        AbstractC14517a.f10346a = str;
    }

    /* JADX INFO: renamed from: l */
    public final void m103l() throws Exception {
        C0082h c0082h = this.f217b;
        InterfaceC14510a interfaceC14510a = this.f219d;
        c0082h.m219f(interfaceC14510a, "upSyncLocalChanges");
        C0077c c0077c = this.f216a;
        C6734c c6734c = c0077c.f267j;
        c6734c.getClass();
        ArrayList<String> arrayList = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : c6734c.f4096a.getIsDirtyList(1, true)) {
            if (notesDocumentEntity.isSdocx()) {
                String uuid = notesDocumentEntity.getUuid();
                if (!"coedit:///".equals(notesDocumentEntity.getCategoryUuid()) && !UUIDUtils.isCoeditUuid(uuid)) {
                    if (!UUIDUtils.isGenUuid(uuid)) {
                        arrayList.add(uuid);
                    } else if (notesDocumentEntity.getIsDeleted() == 1) {
                        arrayList.add(uuid);
                    }
                }
            }
        }
        c0077c.f271n = false;
        if (arrayList.isEmpty()) {
            Debugger.m8615i("SyncNote", "upSyncLocalChanges() : None");
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f454c = "No local change";
            c0152jM378g.m371b(c0077c.f262e);
            return;
        }
        Debugger.m8615i("SyncNote", "upSyncLocalChanges() : " + arrayList.size());
        AbstractC0299q.f771d = true;
        for (String str : arrayList) {
            c0082h.m219f(interfaceC14510a, "upSyncLocalChanges!");
            c0082h.getClass();
            if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
                throw new SyncException(354, "Cancelled SyncWDoc due to loggedOut!");
            }
            c0082h.m220g();
            m104m(str);
        }
        Debugger.m8615i("SyncNote", "upSyncLocalChanges() finish");
    }

    /* JADX INFO: renamed from: m */
    public final void m104m(final String str) throws Exception {
        C0077c c0077c = this.f216a;
        Context context = c0077c.f262e;
        C6749r c6749r = c0077c.f266i;
        final C6748q c6748q = new C6748q(context, str);
        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
        if ((notesDocumentEntity != null ? notesDocumentEntity.getIsLock() : 0) == 5) {
            String strM14294h = C13541h.m14287e().m14294h();
            if (TextUtils.isEmpty(strM14294h)) {
                Debugger.m8609e("SyncNote", "upSyncLocalNote() : " + str + " is locked but passed due to empty current guidHash");
                return;
            }
            NotesDocumentEntity notesDocumentEntity2 = c6748q.f4128a;
            String lockAccountGuid = notesDocumentEntity2 != null ? notesDocumentEntity2.getLockAccountGuid() : "";
            if (!TextUtils.isEmpty(lockAccountGuid) && lockAccountGuid.length() != 64) {
                lockAccountGuid = HashUtils.generateSha256(lockAccountGuid);
            }
            if (!LockUtils.isEmptyGuid(lockAccountGuid) && !strM14294h.equals(lockAccountGuid)) {
                Debugger.m8615i("SyncNote", "upSyncLocalNote() : " + str + " is locked but passed due to different account = " + lockAccountGuid);
                c6749r.f4134b.updateIsSyncFailed(str, 1);
                c6749r.m4888d(0, str);
                return;
            }
        }
        if (((Boolean) FolderManager.getInstance().executeOperation(new CallableC0047c(this, 1, c6748q, str))).booleanValue()) {
            if (c6748q.m4879g() == 0) {
                Debugger.m8609e("SyncNote", "upSyncLocalNote() : " + str + " is not dirty!");
                return;
            }
            try {
                String strM4881i = c6748q.m4881i();
                C0097a c0097a = new C0097a();
                if (c6748q.m4878f() == 1) {
                    if (!TextUtils.isEmpty(strM4881i)) {
                        if (!TextUtils.isEmpty(c6748q.m4877e())) {
                            AbstractC6784f.f4180a.m4945d(str, GraphItem$RequestType.DELETE, c6748q.m4883k(), c6748q.m4876d(), c6748q.m4877e());
                        }
                        new C0066g(this.f216a, this.f217b, this.f219d, c0097a, str).m154a(strM4881i, c6748q.m4883k());
                        return;
                    } else {
                        BaseUtils.getApplicationContext();
                        C6901d.m5113d(c6748q);
                        c6749r.m4885a(str, "OnlyLocal");
                        if (TextUtils.isEmpty(c6748q.m4877e())) {
                            return;
                        }
                        AbstractC6784f.f4180a.m4945d(str, GraphItem$RequestType.DELETE, c6748q.m4883k(), c6748q.m4876d(), c6748q.m4877e());
                        return;
                    }
                }
                if (TextUtils.isEmpty(strM4881i)) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    final int i = 0;
                    FolderManager.getInstance().executeOperation(new Runnable(this) { // from class: C1.g

                        /* JADX INFO: renamed from: b */
                        public final /* synthetic */ C0052h f213b;

                        {
                            this.f213b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    this.f213b.f216a.f262e.getApplicationContext();
                                    NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                                    SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                                    notesDatabaseManager.getSyncDocumentDao();
                                    new SyncNoteDataRepository();
                                    new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                                    C6748q c6748q2 = c6748q;
                                    NotesDocumentEntity notesDocumentEntity3 = c6748q2.f4128a;
                                    if (syncCategoryTreeDao.getIsSyncWithMS(notesDocumentEntity3 != null ? notesDocumentEntity3.getCategoryUuid() : null) == 1) {
                                        AbstractC6784f.f4180a.m4945d(str, GraphItem$RequestType.CREATE, c6748q2.m4883k(), c6748q2.m4876d(), "");
                                    }
                                    break;
                                default:
                                    this.f213b.f216a.f262e.getApplicationContext();
                                    NotesDatabase notesDatabaseManager2 = NotesDatabaseManager.getInstance();
                                    SyncCategoryTreeDao syncCategoryTreeDao2 = notesDatabaseManager2.getSyncCategoryTreeDao();
                                    notesDatabaseManager2.getSyncDocumentDao();
                                    new SyncNoteDataRepository();
                                    new SoftParentFolderChecker(notesDatabaseManager2.getCategoryTreeClosureDao());
                                    C6748q c6748q3 = c6748q;
                                    NotesDocumentEntity notesDocumentEntity4 = c6748q3.f4128a;
                                    int isSyncWithMS = syncCategoryTreeDao2.getIsSyncWithMS(notesDocumentEntity4 != null ? notesDocumentEntity4.getCategoryUuid() : null);
                                    String str2 = str;
                                    if (isSyncWithMS == 1) {
                                        if ((notesDocumentEntity4 != null ? notesDocumentEntity4.getIsLock() : 0) != 0) {
                                            AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.DELETE, c6748q3.m4883k(), c6748q3.m4876d(), c6748q3.m4877e());
                                        } else {
                                            AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.UPDATE, c6748q3.m4883k(), c6748q3.m4876d(), "");
                                        }
                                        break;
                                    } else if (!TextUtils.isEmpty(c6748q3.m4877e()) && c6748q3.m4878f() == 0) {
                                        AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.DELETE, c6748q3.m4883k(), c6748q3.m4876d(), c6748q3.m4877e());
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    new C0063d(this.f216a, this.f217b, this.f219d, c0097a, str).m145c(c6748q);
                    Debugger.m8615i("SyncNote", "createServerNote et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                    return;
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                final int i2 = 1;
                FolderManager.getInstance().executeOperation(new Runnable(this) { // from class: C1.g

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ C0052h f213b;

                    {
                        this.f213b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f213b.f216a.f262e.getApplicationContext();
                                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                                notesDatabaseManager.getSyncDocumentDao();
                                new SyncNoteDataRepository();
                                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                                C6748q c6748q2 = c6748q;
                                NotesDocumentEntity notesDocumentEntity3 = c6748q2.f4128a;
                                if (syncCategoryTreeDao.getIsSyncWithMS(notesDocumentEntity3 != null ? notesDocumentEntity3.getCategoryUuid() : null) == 1) {
                                    AbstractC6784f.f4180a.m4945d(str, GraphItem$RequestType.CREATE, c6748q2.m4883k(), c6748q2.m4876d(), "");
                                }
                                break;
                            default:
                                this.f213b.f216a.f262e.getApplicationContext();
                                NotesDatabase notesDatabaseManager2 = NotesDatabaseManager.getInstance();
                                SyncCategoryTreeDao syncCategoryTreeDao2 = notesDatabaseManager2.getSyncCategoryTreeDao();
                                notesDatabaseManager2.getSyncDocumentDao();
                                new SyncNoteDataRepository();
                                new SoftParentFolderChecker(notesDatabaseManager2.getCategoryTreeClosureDao());
                                C6748q c6748q3 = c6748q;
                                NotesDocumentEntity notesDocumentEntity4 = c6748q3.f4128a;
                                int isSyncWithMS = syncCategoryTreeDao2.getIsSyncWithMS(notesDocumentEntity4 != null ? notesDocumentEntity4.getCategoryUuid() : null);
                                String str2 = str;
                                if (isSyncWithMS == 1) {
                                    if ((notesDocumentEntity4 != null ? notesDocumentEntity4.getIsLock() : 0) != 0) {
                                        AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.DELETE, c6748q3.m4883k(), c6748q3.m4876d(), c6748q3.m4877e());
                                    } else {
                                        AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.UPDATE, c6748q3.m4883k(), c6748q3.m4876d(), "");
                                    }
                                    break;
                                } else if (!TextUtils.isEmpty(c6748q3.m4877e()) && c6748q3.m4878f() == 0) {
                                    AbstractC6784f.f4180a.m4945d(str2, GraphItem$RequestType.DELETE, c6748q3.m4883k(), c6748q3.m4876d(), c6748q3.m4877e());
                                    break;
                                }
                                break;
                        }
                    }
                });
                try {
                    new C0063d(this.f216a, this.f217b, this.f219d, c0097a, str).m146d(c6748q, strM4881i);
                } catch (SyncException e) {
                    if (e.getExceptionCode() != 315 || e.getStatusCode() != 404) {
                        throw e;
                    }
                    new C0063d(this.f216a, this.f217b, this.f219d, c0097a, str).m145c(c6748q);
                }
                Debugger.m8615i("SyncNote", "updateServerNote et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime2));
            } catch (Exception e2) {
                if (!(e2 instanceof SyncException)) {
                    throw e2;
                }
                this.f217b.m225l(c6748q, (SyncException) e2, str);
            }
        }
    }
}
