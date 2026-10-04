package p007B0;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import p001A.AbstractC0000a;
import p022E1.C0077c;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p042J1.C0151i;
import p044K.C0158a;

/* JADX INFO: renamed from: B0.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0027j {

    /* JADX INFO: renamed from: a */
    public long f143a;

    /* JADX INFO: renamed from: b */
    public String f144b;

    /* JADX INFO: renamed from: c */
    public AbstractList f145c;

    /* JADX INFO: renamed from: d */
    public Object f146d;

    public C0027j(ArrayList arrayList, C0077c c0077c) {
        this.f143a = 0L;
        this.f144b = CoverStickerConstants.Category.NONE.NAME;
        this.f145c = arrayList;
        this.f146d = c0077c;
    }

    /* JADX INFO: renamed from: a */
    public static void m50a(C0027j c0027j) {
        c0027j.getClass();
        File file = new File(c0027j.f144b);
        if (!file.exists() && !file.mkdirs()) {
            Debugger.m8607d("SyncLogger", "log folder was not created");
        }
        File[] fileArrListFiles = file.listFiles();
        if (((LinkedList) c0027j.f145c) == null) {
            c0027j.f145c = new LinkedList();
        }
        if ((fileArrListFiles != null ? fileArrListFiles.length : 0) != ((LinkedList) c0027j.f145c).size()) {
            Debugger.m8607d("SyncLogger", "rearrange file log");
            c0027j.f143a = 0L;
            c0027j.f145c = new LinkedList(Arrays.asList(fileArrListFiles));
            if (fileArrListFiles == null) {
                Debugger.m8607d("SyncLogger", "no logs");
                return;
            }
            Arrays.sort(fileArrListFiles, new C0151i(c0027j));
            Iterator it = ((LinkedList) c0027j.f145c).iterator();
            while (it.hasNext()) {
                c0027j.f143a = ((File) it.next()).length() + c0027j.f143a;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static ArrayList m51b(C0027j c0027j) {
        c0027j.getClass();
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long millis = TimeUnit.MINUTES.toMillis(5L);
        for (int size = ((LinkedList) c0027j.f145c).size() - 1; size >= 0; size--) {
            File file = (File) ((LinkedList) c0027j.f145c).get(size);
            if (Math.abs(jCurrentTimeMillis - c0027j.m55f(file.getName())) >= millis) {
                break;
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: c */
    public static void m52c(C0027j c0027j, File file) {
        ((LinkedList) c0027j.f145c).add(file);
        c0027j.f143a = file.length() + c0027j.f143a;
        synchronized (c0027j) {
            while (209715200 < c0027j.f143a) {
                File file2 = (File) ((LinkedList) c0027j.f145c).pop();
                c0027j.f143a -= file2.length();
                if (!file2.delete()) {
                    Debugger.m8607d("SyncLogger", "log file was not deleted");
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m53d(C6742k c6742k) throws SyncException {
        XmlSerializer xmlSerializer = (XmlSerializer) c6742k.f4110b;
        try {
            for (FolderNodeItem folderNodeItem : (ArrayList) this.f145c) {
                c6742k.m4846F("node");
                c6742k.m4851h("id", folderNodeItem.uUid);
                c6742k.m4851h("type", folderNodeItem.type);
                c6742k.m4865w("parentFolderNodeId", folderNodeItem.parentFolderNodeId);
                c6742k.m4863u("syncModifiedTime", folderNodeItem.syncModifiedTime);
                c6742k.m4863u(GroupContract.Group.CREATED_TIME, folderNodeItem.createdTime);
                c6742k.m4863u(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, folderNodeItem.lastModifiedTime);
                C0158a.m407a().getClass();
                if (SyncState.isEdpMode() && NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(this.f144b) && folderNodeItem.type.equals("folder")) {
                    c6742k.m4865w("name", C0145c.m319d(folderNodeItem.name));
                } else {
                    String str = folderNodeItem.name;
                    xmlSerializer.startTag("", "name");
                    if (TextUtils.isEmpty(str)) {
                        xmlSerializer.text(Base64Utils.encodeBase64(" "));
                    } else {
                        xmlSerializer.text(Base64Utils.encodeBase64(str));
                    }
                    xmlSerializer.endTag("", "name");
                }
                c6742k.m4865w("state", folderNodeItem.state);
                String str2 = folderNodeItem.restorePath;
                if (!TextUtils.isEmpty(str2)) {
                    xmlSerializer.startTag("", "restorePath");
                    xmlSerializer.text(Base64Utils.encodeBase64(str2));
                    xmlSerializer.endTag("", "restorePath");
                }
                c6742k.m4863u("trashedTime", folderNodeItem.recycleBinMovedTime);
                c6742k.m4862t(DBSchema.CategoryTree.IS_SYNC_WITH_MS, folderNodeItem.isSyncWithMS);
                c6742k.m4862t("color", folderNodeItem.displayNameColor);
                c6742k.m4862t("order", folderNodeItem.reorder);
                c6742k.m4863u("requestTime", TimeManager.getCurrentTime());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("model", Build.MODEL);
                    jSONObject.put("ver", AbstractC0155m.m399n(((C0077c) this.f146d).f262e));
                } catch (JSONException unused) {
                    Debugger.m8609e("UpdateFolderItem", "getDeviceInfo() : fail to put jsonObject!");
                }
                c6742k.m4865w("requestDevice", jSONObject.toString());
                c6742k.m4856m("node");
            }
        } catch (Exception e) {
            Debugger.m8609e("UpdateFolderItem", "composeXmlForNode : " + e.getMessage());
            throw new SyncException(326, e);
        }
    }

    /* JADX INFO: renamed from: e */
    public long m54e() {
        C0077c c0077c = (C0077c) this.f146d;
        long j = this.f143a;
        if (j != 0) {
            return j;
        }
        long maxSyncModifiedTimeFromNotes = c0077c.f267j.f4096a.getMaxSyncModifiedTimeFromNotes();
        c0077c.f262e.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        long maxSyncModifiedTimeFromFolders = syncCategoryTreeDao.getMaxSyncModifiedTimeFromFolders();
        if (maxSyncModifiedTimeFromNotes < maxSyncModifiedTimeFromFolders) {
            maxSyncModifiedTimeFromNotes = maxSyncModifiedTimeFromFolders;
        }
        this.f143a = maxSyncModifiedTimeFromNotes;
        Iterator it = c0077c.f269l.entrySet().iterator();
        while (it.hasNext()) {
            NotesCategoryTreeEntity notesCategoryTreeEntity = (NotesCategoryTreeEntity) ((Map.Entry) it.next()).getValue();
            if (notesCategoryTreeEntity.getServerTimeStamp().longValue() > maxSyncModifiedTimeFromNotes) {
                maxSyncModifiedTimeFromNotes = notesCategoryTreeEntity.getServerTimeStamp().longValue();
            }
        }
        this.f143a = maxSyncModifiedTimeFromNotes;
        Iterator it2 = c0077c.f270m.entrySet().iterator();
        while (it2.hasNext()) {
            long j2 = ((FolderNodeItem) ((Map.Entry) it2.next()).getValue()).syncModifiedTime;
            if (j2 > maxSyncModifiedTimeFromNotes) {
                maxSyncModifiedTimeFromNotes = j2;
            }
        }
        return maxSyncModifiedTimeFromNotes;
    }

    /* JADX INFO: renamed from: f */
    public long m55f(String str) {
        String[] strArrSplit = str.split("_");
        try {
            Date date = ((SimpleDateFormat) this.f146d).parse(Calendar.getInstance().get(1) + "_" + strArrSplit[0] + "_" + strArrSplit[1]);
            if (date != null) {
                return date.getTime();
            }
            Debugger.m8609e("SyncLogger", "failed to parse time on " + str + ", date is null!");
            return 0L;
        } catch (ParseException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("failed to parse time on ", str, ", e =");
            sbM15l.append(e.getMessage());
            Debugger.m8609e("SyncLogger", sbM15l.toString());
            return 0L;
        }
    }

    public C0027j(String str) {
        this.f143a = 0L;
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        this.f144b = AbstractC0622a.m1170p(File.separator, str, sb);
        this.f146d = new SimpleDateFormat("yyyy_MM-dd_HH-mm-ss-SSS", Locale.getDefault());
    }
}
