package p179f1;

import android.content.Context;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.migration.C6798g;
import com.samsung.android.scloud.lib.setting.RPCSettingStatusContract;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDocFile;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.SDocTagResolverContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.sdk.SpenSdkCompat;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p002A0.C0001a;
import p002A0.C0007g;
import p002A0.C0009i;
import p002A0.C0011k;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p090W0.C0330a;
import p094X0.C0339a;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p186h1.AbstractC12023d;

/* JADX INFO: renamed from: f1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC11983c extends AbstractC11975a {

    /* JADX INFO: renamed from: u */
    public static final String f8589u = "SS$".concat("RestoreDocTask");

    /* JADX INFO: renamed from: p */
    public final String f8590p;

    /* JADX INFO: renamed from: q */
    public final String f8591q;

    /* JADX INFO: renamed from: r */
    public final String f8592r;

    /* JADX INFO: renamed from: s */
    public final String f8593s;

    /* JADX INFO: renamed from: t */
    public final NotesDocumentRepository f8594t;

    public AbstractC11983c(C11972a c11972a) {
        super(c11972a);
        int i = c11972a.f8542g;
        if ((i & 1) != 0) {
            this.f8558h = 1;
        } else if ((i & 128) != 0) {
            this.f8558h = 128;
        } else if ((i & 64) != 0) {
            this.f8558h = 64;
        } else if ((i & 1024) != 0) {
            this.f8558h = 1024;
        } else if ((i & 2048) != 0) {
            this.f8558h = 2048;
        } else if ((i & 4096) != 0) {
            this.f8558h = 4096;
        } else if ((i & 8192) != 0) {
            this.f8558h = 8192;
        }
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        this.f8590p = C0148f.m351d();
        this.f8591q = C0148f.m352e();
        this.f8592r = AbstractC0155m.m387b(C0148f.m351d(), "SmartSwitchRestoreDB");
        this.f8593s = AbstractC0155m.m387b(C0148f.m352e(), "SSWL");
        this.f8594t = NotesDataRepositoryFactory.newInstance(AbstractC11975a.m13543f()).createDocumentDataRepository();
    }

    /* JADX INFO: renamed from: A */
    public static void m13564A(ArrayList arrayList, HashMap map) {
        if (arrayList == null) {
            return;
        }
        String str = "restoreHashTagContentOld size " + arrayList.size();
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, str);
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SDocTagResolverContractImpl sDocTagResolverContractImpl = C0322h.m670a().f830p;
        for (int i = 0; i < arrayList.size(); i++) {
            C0009i c0009i = (C0009i) arrayList.get(i);
            String str3 = c0009i.f38a;
            String str4 = (String) map.get(str3);
            if (str4 != null) {
                str3 = str4;
            }
            String str5 = c0009i.f47j;
            AbstractC0299q.m643n(str2, "restoreHashTagContentOld sDocUuid " + str3 + ", hashtagUuid " + str5);
            sDocTagResolverContractImpl.setNoteTagContent(appContext, str3, str5, c0009i.f42e, c0009i.f48k, c0009i.f49l, c0009i.f50m, C0322h.m670a().f831q.getSdocContractNo());
        }
    }

    /* JADX INFO: renamed from: B */
    public static void m13565B(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        String str = f8589u;
        AbstractC0299q.m643n(str, "restoreHashTagOld size " + size);
        Context appContext = C0322h.m670a().f815a.getAppContext();
        for (int i = 0; i < size; i++) {
            String str2 = ((C0011k) arrayList.get(i)).f60a;
            String str3 = ((C0011k) arrayList.get(i)).f63d;
            boolean z = ((C0011k) arrayList.get(i)).f62c;
            long j = ((C0011k) arrayList.get(i)).f65f;
            String str4 = ((C0011k) arrayList.get(i)).f66g;
            if (str3 == null || str3.isEmpty() || z) {
                AbstractC0299q.m643n(str, "restoreHashTagOld ignore hashtagName isDeleted " + z);
            } else {
                SDocTagResolverContractImpl sDocTagResolverContractImpl = C0322h.m670a().f830p;
                String tagUUID = sDocTagResolverContractImpl.getTagUUID(str3, true);
                if (tagUUID == null || tagUUID.isEmpty()) {
                    AbstractC0299q.m643n(str, "restoreHashTagOld add hashtagItemInfo ".concat(str3));
                    sDocTagResolverContractImpl.addTag(appContext, str2, str3, false);
                    sDocTagResolverContractImpl.setTagModifiedAndServerTimestampAndExtraInfo(str2, j, TimeManager.getCurrentTime(appContext), str4);
                } else {
                    AbstractC0299q.m643n(str, "restoreHashTagOld recovery");
                    sDocTagResolverContractImpl.recoveryTag(appContext, tagUUID, TimeManager.getCurrentTime(appContext), 0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: C */
    public static ArrayList m13566C(ArrayList arrayList) {
        AbstractC0299q.m643n(f8589u, "restorePageTemplateItems");
        ArrayList arrayList2 = new ArrayList();
        Iterator<NotesTemplateEntity> it = NotesDatabaseManager.getInstance().getNotesTemplateDao().getAll().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getUuid());
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C0007g c0007g = (C0007g) it2.next();
            NotesTemplateEntity notesTemplateEntity = new NotesTemplateEntity();
            String str = c0007g.f25a;
            if (!arrayList2.contains(str)) {
                notesTemplateEntity.setUuid(str);
                notesTemplateEntity.setSize(c0007g.f27c);
                notesTemplateEntity.setDisplayName(c0007g.f28d);
                notesTemplateEntity.setTitle(c0007g.f29e);
                notesTemplateEntity.setCreatedAt(c0007g.f30f);
                notesTemplateEntity.setLastModifiedAt(c0007g.f31g);
                notesTemplateEntity.setMimeType(c0007g.f32h);
                notesTemplateEntity.setWidth(c0007g.f33i);
                notesTemplateEntity.setHeight(c0007g.f34j);
                notesTemplateEntity.setType(c0007g.f35k);
                String str2 = c0007g.f26b;
                notesTemplateEntity.setData(str2);
                arrayList3.add(FileUtils.extractFile(str2));
                arrayList4.add(notesTemplateEntity);
            }
        }
        NotesDataRepositoryFactory.newInstance(AbstractC11975a.m13543f()).createTemplateRepository().upsert(arrayList4);
        return arrayList3;
    }

    /* JADX INFO: renamed from: D */
    public static ArrayList m13567D(String str) throws Throwable {
        ArrayList arrayList;
        JSONArray jSONArray;
        int length;
        String str2 = "deleted";
        String str3 = f8589u;
        AbstractC0299q.m643n(str3, "restoreSDocInfo");
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                        if (jSONObjectM394i != null) {
                            jSONArray = jSONObjectM394i.getJSONArray("file_info");
                            length = jSONArray.length();
                        } else {
                            jSONArray = null;
                            length = 0;
                        }
                        if (length < 1) {
                            AbstractC0299q.m643n(str3, "restoreSDocInfo size Error");
                            AbstractC11975a.m13541b(fileInputStream2);
                            return null;
                        }
                        arrayList = new ArrayList();
                        int i = 0;
                        while (i < length) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                C0009i c0009i = new C0009i(jSONObject.has(str2) ? jSONObject.getInt(str2) : 0, jSONObject.getLong("timestamp"), jSONObject.getString("uuid"), jSONObject.getString(UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME));
                                String str4 = str2;
                                int i2 = i;
                                c0009i.f41d = jSONObject.getLong("savedtime");
                                c0009i.f44g = jSONObject.getBoolean(DBSchema.DocumentPage.FAVORITE);
                                c0009i.f45h = jSONObject.getString("category_uuid");
                                c0009i.f46i = jSONObject.getLong("extra_timestamp");
                                c0009i.f52o = jSONObject.getInt("lockstate");
                                c0009i.f51n = jSONObject.getLong("createTime");
                                jSONObject.getString("filepath");
                                if (jSONObject.has("restorePath")) {
                                    c0009i.f43f = jSONObject.getString("restorePath");
                                }
                                if (jSONObject.has(DBSchema.Document.MS_SYNC_ACCOUNT_ID)) {
                                    c0009i.f53p = jSONObject.getString(DBSchema.Document.MS_SYNC_ACCOUNT_ID);
                                }
                                if (jSONObject.has("msSyncDocumentId")) {
                                    c0009i.f54q = jSONObject.getString("msSyncDocumentId");
                                }
                                if (jSONObject.has(DBSchema.Document.MS_LAST_SYNC_TIME)) {
                                    c0009i.f55r = jSONObject.getLong(DBSchema.Document.MS_LAST_SYNC_TIME);
                                }
                                if (jSONObject.has("recycle_bin_time_moved")) {
                                    jSONObject.getLong("recycle_bin_time_moved");
                                }
                                if (jSONObject.has(DBSchema.Document.MATH_MODE)) {
                                    c0009i.f56s = jSONObject.getInt(DBSchema.Document.MATH_MODE);
                                }
                                arrayList.add(c0009i);
                                i = i2 + 1;
                                str2 = str4;
                            } catch (Exception e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                AbstractC0299q.m646q(str3, "restoreSDocInfo failed to " + e.getMessage());
                                AbstractC11975a.m13541b(fileInputStream);
                                return arrayList;
                            }
                        }
                        AbstractC11975a.m13541b(fileInputStream2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        AbstractC11975a.m13541b(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    arrayList = null;
                }
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: n */
    public static void m13568n(File file, String str) {
        String str2 = f8589u;
        try {
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdirs()) {
                AbstractC0299q.m646q(str2, "copyFile failed to mkdirs path " + FileUtils.logPath(str));
            }
            if (file2.exists()) {
                AbstractC0299q.m643n(str2, "copyFile " + FileUtils.logPath(file.getName()));
                FileUtils.copyFile(file, new File(AbstractC0155m.m387b(str, file.getName())));
            }
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("copyFile exception failed to "), str2);
        }
    }

    /* JADX INFO: renamed from: q */
    public static ArrayList m13569q(String str) throws Throwable {
        FileInputStream fileInputStream;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getBookMarkItems");
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            JSONArray jSONArray = AbstractC0155m.m394i(fileInputStream).getJSONArray("bookmark_info");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C0001a c0001a = new C0001a();
                c0001a.f0a = jSONObject.getLong("bookmark_id");
                c0001a.f1b = jSONObject.getString("bookmark_doc_uuid");
                c0001a.f2c = jSONObject.getString("bookmark_page_uuid");
                c0001a.f3d = jSONObject.getInt("bookmark_index");
                c0001a.f4e = jSONObject.getInt("bookmark_favorite");
                c0001a.f5f = jSONObject.getInt("bookmark_is_deleted");
                c0001a.f6g = jSONObject.getInt("bookmark_is_dirty");
                arrayList.add(c0001a);
            }
            AbstractC11975a.m13541b(fileInputStream);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            AbstractC0299q.m646q(str2, "getBookMarkItems failed to " + e.getMessage());
            AbstractC11975a.m13541b(fileInputStream2);
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC11975a.m13541b(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: r */
    public static ArrayList m13570r(String str) throws Throwable {
        ArrayList arrayList;
        FileInputStream fileInputStream;
        JSONArray jSONArray;
        int length;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getHashTagContent");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e = e;
                arrayList = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                if (jSONObjectM394i != null) {
                    jSONArray = jSONObjectM394i.getJSONArray("hashtag_content");
                    length = jSONArray.length();
                } else {
                    jSONArray = null;
                    length = 0;
                }
                if (length < 1) {
                    AbstractC0299q.m643n(str2, "getHashTagContent not exist");
                    AbstractC11975a.m13541b(fileInputStream);
                    return null;
                }
                arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("uuid");
                        String string2 = jSONObject.getString("tag_uuid");
                        String string3 = jSONObject.getString("tag_extra_info");
                        jSONObject.getInt("deleted");
                        long j = jSONObject.getLong("timestamp");
                        long j2 = jSONObject.getLong("extra_timestamp");
                        C0009i c0009i = new C0009i();
                        c0009i.f38a = string;
                        c0009i.f39b = "hashtagContent.list";
                        c0009i.f40c = 0L;
                        c0009i.f47j = string2;
                        c0009i.f48k = j;
                        c0009i.f49l = j2;
                        c0009i.f50m = string3;
                        arrayList.add(c0009i);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        AbstractC0299q.m646q(str2, "getHashTagContent failed to " + e.getMessage());
                        AbstractC11975a.m13541b(fileInputStream2);
                        return arrayList;
                    }
                }
                AbstractC11975a.m13541b(fileInputStream);
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC11975a.m13541b(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: s */
    public static ArrayList m13571s(String str) throws Throwable {
        ArrayList arrayList;
        JSONArray jSONArray;
        int length;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getHashTagInfo");
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                        if (jSONObjectM394i != null) {
                            jSONArray = jSONObjectM394i.getJSONArray("hashtag_info");
                            length = jSONArray.length();
                        } else {
                            jSONArray = null;
                            length = 0;
                        }
                        if (length < 1) {
                            AbstractC0299q.m643n(str2, "getHashTagInfo not exist");
                            AbstractC11975a.m13541b(fileInputStream2);
                            return null;
                        }
                        arrayList = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                arrayList.add(new C0011k(jSONObject.getString("tag_uuid"), str, jSONObject.getString("name"), jSONObject.getBoolean("deleted"), jSONObject.getLong("timestamp"), jSONObject.getString("extra_info")));
                            } catch (Exception e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                AbstractC0299q.m646q(str2, "getHashTagInfo failed to " + e.getMessage());
                                AbstractC11975a.m13541b(fileInputStream);
                                return arrayList;
                            }
                        }
                        AbstractC11975a.m13541b(fileInputStream2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        AbstractC11975a.m13541b(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    arrayList = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
    }

    /* JADX INFO: renamed from: t */
    public static ArrayList m13572t(String str) throws Throwable {
        ArrayList arrayList;
        JSONArray jSONArray;
        int length;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getHashTagItem");
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    try {
                        JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                        if (jSONObjectM394i != null) {
                            jSONArray = jSONObjectM394i.getJSONArray("hashtag_info");
                            length = jSONArray.length();
                        } else {
                            jSONArray = null;
                            length = 0;
                        }
                        if (length < 1) {
                            AbstractC0299q.m643n(str2, "getHashTagItem not exist");
                            AbstractC11975a.m13541b(fileInputStream2);
                            return null;
                        }
                        arrayList = new ArrayList();
                        for (int i = 0; i < length; i++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                arrayList.add(new C0330a(Long.valueOf(jSONObject.getLong(RPCSettingStatusContract.Parameter.TAG_ID)), jSONObject.getString("doc_uuid"), jSONObject.getString("display_name"), jSONObject.getString("nomalize_name")));
                            } catch (Exception e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                AbstractC0299q.m646q(str2, "getHashTagItem failed to " + e.getMessage());
                                AbstractC11975a.m13541b(fileInputStream);
                                return arrayList;
                            }
                        }
                        AbstractC11975a.m13541b(fileInputStream2);
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    AbstractC11975a.m13541b(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                arrayList = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: u */
    public static ArrayList m13573u(String str) throws Throwable {
        FileInputStream fileInputStream;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getPageTemplateItems");
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            JSONArray jSONArray = AbstractC0155m.m394i(fileInputStream).getJSONArray("pageTemplate_info");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C0007g c0007g = new C0007g();
                c0007g.f25a = jSONObject.getString("page_template_uuid");
                c0007g.f26b = jSONObject.getString("page_template_data");
                c0007g.f27c = jSONObject.getInt("page_template_size");
                c0007g.f28d = jSONObject.getString("page_template_display_name");
                c0007g.f29e = jSONObject.getString("page_template_title");
                c0007g.f30f = jSONObject.getLong("page_template_created_at");
                c0007g.f31g = jSONObject.getLong("page_template_last_modified_at");
                c0007g.f32h = jSONObject.getString("page_template_mime_type");
                c0007g.f33i = jSONObject.getInt("page_template_width");
                c0007g.f34j = jSONObject.getInt("page_template_height");
                c0007g.f35k = jSONObject.getInt("page_template_type");
                arrayList.add(c0007g);
            }
            AbstractC11975a.m13541b(fileInputStream);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            AbstractC0299q.m646q(str2, "getPageTemplateItems failed to " + e.getMessage());
            AbstractC11975a.m13541b(fileInputStream2);
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC11975a.m13541b(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: v */
    public static ArrayList m13574v(String str) throws Throwable {
        FileInputStream fileInputStream;
        String str2 = f8589u;
        AbstractC0299q.m643n(str2, "getRecentSearchItems");
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONArray jSONArray = AbstractC0155m.m394i(fileInputStream).getJSONArray("recentSearch_info");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i).getString("recent_search_keywordS"));
            }
            AbstractC11975a.m13541b(fileInputStream);
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            AbstractC0299q.m646q(str2, "getRecentSearchItems failed to " + e.getMessage());
            AbstractC11975a.m13541b(fileInputStream2);
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC11975a.m13541b(fileInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: x */
    public static void m13575x(String str, String str2, String str3) throws Throwable {
        String str4 = f8589u;
        AbstractC0299q.m643n(str4, "makeNewWidgetInfo old " + str3 + " => new " + str2);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uuid", str2);
                jSONArray.put(jSONObject2);
                jSONObject.put("file_info", jSONArray);
                File file = new File(AbstractC0155m.m387b(str, str3) + ".widget");
                if (file.exists() && !file.delete()) {
                    AbstractC0299q.m646q(str4, "makeNewWidgetInfo failed to delete file (.widget)");
                }
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream = fileOutputStream2;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e = e;
                        AbstractC0299q.m646q(str4, "makeNewWidgetInfo failed to " + e.getMessage());
                        AbstractC11975a.m13541b(fileOutputStream);
                        return;
                    } catch (JSONException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        e = e;
                        AbstractC0299q.m646q(str4, "makeNewWidgetInfo failed to " + e.getMessage());
                        AbstractC11975a.m13541b(fileOutputStream);
                        return;
                    } catch (Exception e3) {
                        fileOutputStream = fileOutputStream2;
                        e = e3;
                        AbstractC0299q.m646q(str4, "makeNewWidgetInfo exception failed to " + e.getMessage());
                        AbstractC11975a.m13541b(fileOutputStream);
                        return;
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        AbstractC11975a.m13541b(fileOutputStream);
                        throw th;
                    }
                }
                AbstractC11975a.m13541b(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        } catch (JSONException e6) {
            e = e6;
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX INFO: renamed from: y */
    public static void m13576y(ArrayList arrayList, HashMap map) {
        AbstractC0299q.m643n(f8589u, "restoreBookMarkItems");
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < arrayList.size(); i++) {
            C0001a c0001a = (C0001a) arrayList.get(i);
            if (c0001a.f5f != 1) {
                String str = c0001a.f1b;
                String str2 = (String) map.get(str);
                NotesDocumentPageEntity notesDocumentPageEntity = new NotesDocumentPageEntity();
                if (str2 != null) {
                    str = str2;
                }
                hashSet.add(str);
                notesDocumentPageEntity.setId(c0001a.f0a);
                notesDocumentPageEntity.setDocumentUuid(str);
                notesDocumentPageEntity.setPageUuid(c0001a.f2c);
                notesDocumentPageEntity.setIndex(c0001a.f3d);
                notesDocumentPageEntity.setFavorite(c0001a.f4e);
                notesDocumentPageEntity.setIsDeleted(c0001a.f5f);
                notesDocumentPageEntity.setIsDirty(c0001a.f6g);
                String str3 = notesDocumentPageEntity.getDocumentUuid() + notesDocumentPageEntity.getPageUuid();
                if (!hashSet2.contains(str3)) {
                    arrayList2.add(notesDocumentPageEntity);
                    hashSet2.add(str3);
                }
            }
        }
        NotesDocumentPageRepository notesDocumentPageRepositoryCreateNotesDocumentPageRepository = NotesDataRepositoryFactory.newInstance(AbstractC11975a.m13543f()).createNotesDocumentPageRepository();
        notesDocumentPageRepositoryCreateNotesDocumentPageRepository.deleteByDocumentUuid(new ArrayList(hashSet));
        notesDocumentPageRepositoryCreateNotesDocumentPageRepository.insert(arrayList2);
    }

    /* JADX INFO: renamed from: z */
    public static void m13577z(ArrayList arrayList, HashMap map) {
        NotesTagRepository notesTagRepositoryCreateDocumentTagRepository = NotesDataRepositoryFactory.newInstance(C0322h.m670a().f815a.getAppContext()).createDocumentTagRepository();
        List<NotesTagEntity> all = notesTagRepositoryCreateDocumentTagRepository.getAll();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0330a c0330a = (C0330a) it.next();
            String str = c0330a.f849c;
            Long l = c0330a.f847a;
            String str2 = c0330a.f848b;
            String str3 = (String) map.get(str2);
            if (str3 != null) {
                str2 = str3;
            }
            Iterator<NotesTagEntity> it2 = all.iterator();
            boolean z = true;
            while (true) {
                boolean zHasNext = it2.hasNext();
                String str4 = f8589u;
                if (zHasNext) {
                    NotesTagEntity next = it2.next();
                    if (next.getDocUuid().equals(str2) && next.getDisplayName().equals(str)) {
                        AbstractC0299q.m643n(str4, "restoreHashTag ignore hash tag, doc uuid " + str2);
                        break;
                    } else if (next.getId().equals(l)) {
                        z = false;
                    }
                } else {
                    AbstractC0299q.m643n(str4, "restoreHashTag add hash tag, doc uuid " + str2);
                    NotesTagEntity notesTagEntity = new NotesTagEntity();
                    if (z) {
                        notesTagEntity.setId(l);
                    }
                    notesTagEntity.setDocUuid(str2);
                    notesTagEntity.setDisplayName(str);
                    notesTagEntity.setNormalizeName(c0330a.f850d);
                    notesTagRepositoryCreateDocumentTagRepository.insert(notesTagEntity);
                }
            }
        }
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        m13578m();
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f434d = false;
        if (this.f8559i == 0 && this.f8561k.isEmpty()) {
            m13551k(0, this.f8558h);
        }
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    public int mo13545c() {
        return 0;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public void mo13549i() {
        SpenSdkInitializer.initialize(AbstractC11975a.m13543f());
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f434d = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:58|(7:(3:181|60|(1:62)(2:65|(6:67|68|185|69|70|57)(15:73|75|(4:77|(1:79)(2:172|83)|70|57)|179|90|(1:92)(9:97|98|192|99|100|101|177|102|103)|170|104|105|190|106|(5:108|(1:110)(1:113)|114|(2:116|(3:118|200|135)(2:119|(1:121)))(1:124)|123)(1:125)|122|201|135)))(1:88)|190|106|(0)(0)|122|201|135)|89|179|90|(0)(0)|170|104|105) */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x03af, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03b0, code lost:
    
        r1 = r27;
        r18 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0274, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0275, code lost:
    
        r1 = r27;
        r15 = r3;
        r2 = r5;
        r5 = r6;
        r17 = r14;
        r19 = r18;
        r14 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x030e A[Catch: Exception -> 0x0367, TryCatch #17 {Exception -> 0x0367, blocks: (B:106:0x0308, B:108:0x030e, B:110:0x0361, B:114:0x036e, B:116:0x0379, B:118:0x037f, B:119:0x038e, B:121:0x0396, B:132:0x03d2), top: B:190:0x0308 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0508 A[Catch: Exception -> 0x03fb, TRY_LEAVE, TryCatch #13 {Exception -> 0x03fb, blocks: (B:135:0x03ed, B:134:0x03ea, B:138:0x03fe, B:140:0x0439, B:142:0x043f, B:143:0x0442, B:145:0x0452, B:147:0x045c, B:149:0x046d, B:150:0x0495, B:155:0x04c3, B:157:0x04d4, B:158:0x04de, B:160:0x04e4, B:162:0x04fa, B:161:0x04f4, B:153:0x04a4, B:154:0x04bd, B:146:0x0456, B:163:0x0508), top: B:187:0x00d3, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5 A[Catch: Exception -> 0x012b, TryCatch #4 {Exception -> 0x012b, blocks: (B:37:0x00bb, B:39:0x00d5, B:41:0x00db, B:43:0x00f9, B:45:0x0118, B:49:0x012f, B:51:0x0143, B:55:0x014f, B:53:0x0149, B:58:0x016f), top: B:174:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fc A[Catch: Exception -> 0x021c, TryCatch #11 {Exception -> 0x021c, blocks: (B:74:0x01e0, B:77:0x01fc, B:79:0x0206, B:86:0x022f, B:83:0x0221), top: B:183:0x01e0, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0257 A[Catch: Exception -> 0x0274, TryCatch #8 {Exception -> 0x0274, blocks: (B:90:0x024d, B:92:0x0257, B:97:0x0285, B:100:0x02a0), top: B:179:0x024d }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0285 A[Catch: Exception -> 0x0274, TRY_LEAVE, TryCatch #8 {Exception -> 0x0274, blocks: (B:90:0x024d, B:92:0x0257, B:97:0x0285, B:100:0x02a0), top: B:179:0x024d }] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v27, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v34 */
    /* JADX WARN: Type inference failed for: r15v35 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [f1.c] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [e1.a] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v37, types: [e1.a, f1.c] */
    /* JADX WARN: Type inference failed for: r1v4, types: [f1.c] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [f1.c] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo13552l() throws Throwable {
        FileInputStream fileInputStream;
        ?? r32;
        int i;
        ?? r33;
        ?? r12;
        ?? r13;
        ?? M13567D;
        int i2;
        ?? r34;
        ?? r14;
        int i4;
        String hashedAccountGuid;
        ?? r15;
        ?? r152;
        HashMap map;
        long j;
        String str;
        String str2;
        int i5;
        int formatVersion;
        ?? r16;
        int i6;
        HashMap map2;
        String str3;
        ?? r153;
        ?? r17;
        int i7;
        long modifiedTime;
        int i8;
        String str4;
        int i9;
        long createdTime;
        long j2;
        String str5;
        ImportItem importItemM13581w;
        ?? r18 = this;
        String str6 = f8589u;
        AbstractC0299q.m643n(str6, "update start");
        String str7 = r18.f8590p;
        File file = new File(AbstractC0155m.m387b(str7, "serverPasswordTime.list"));
        int i10 = 0;
        ?? r162 = 0;
        if (file.exists()) {
            AbstractC0299q.m643n(str6, "restoreServerPasswordTimeInfo");
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                        JSONArray jSONArray = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("file_info") : null;
                        JSONObject jSONObject = jSONArray != null ? jSONArray.getJSONObject(0) : null;
                        if (jSONObject != null) {
                            C0145c.m308P(jSONObject.getLong("server_password_time"), "serverPassword", "serverPasswordKey");
                        }
                    } catch (IOException e) {
                        e = e;
                        AbstractC0299q.m646q(str6, "restoreServerPasswordTimeInfo failed to " + e.getMessage());
                    } catch (JSONException e2) {
                        e = e2;
                        AbstractC0299q.m646q(str6, "restoreServerPasswordTimeInfo failed to " + e.getMessage());
                    } catch (Exception e3) {
                        e = e3;
                        AbstractC0299q.m646q(str6, "restoreServerPasswordTimeInfo exception failed to " + e.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    r162 = "restoreServerPasswordTimeInfo";
                    AbstractC11975a.m13541b(r162);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                fileInputStream = null;
                AbstractC0299q.m646q(str6, "restoreServerPasswordTimeInfo failed to " + e.getMessage());
                AbstractC11975a.m13541b(fileInputStream);
                r18.m13579o(new File(str7));
                FileUtils.printDirectory(r18.f8593s, ".widget", true);
                AbstractC12023d.m13674S(str7);
                M13567D = m13567D(AbstractC0155m.m387b(str7, "sdoc.list"));
                HashMap map3 = new HashMap();
                HashMap map4 = new HashMap();
                if (M13567D == 0) {
                    i2 = 0;
                    String str8 = str6;
                    AbstractC0299q.m643n(str8, "update syncItemInfo == null or syncItemInfo.size == 0");
                    r18.m13580p(M13567D);
                    r18.m13578m();
                    r14 = r18;
                    r34 = str8;
                    i = i2;
                    r12 = r14;
                    r33 = r34;
                }
                AbstractC0299q.m643n(r33, "update end " + i);
                r12.f8559i = i;
                return i;
            } catch (JSONException e6) {
                e = e6;
                fileInputStream = null;
                AbstractC0299q.m646q(str6, "restoreServerPasswordTimeInfo failed to " + e.getMessage());
                AbstractC11975a.m13541b(fileInputStream);
                r18.m13579o(new File(str7));
                FileUtils.printDirectory(r18.f8593s, ".widget", true);
                AbstractC12023d.m13674S(str7);
                M13567D = m13567D(AbstractC0155m.m387b(str7, "sdoc.list"));
                HashMap map32 = new HashMap();
                HashMap map42 = new HashMap();
                if (M13567D == 0) {
                }
                AbstractC0299q.m643n(r33, "update end " + i);
                r12.f8559i = i;
                return i;
            } catch (Exception e7) {
                e = e7;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                AbstractC11975a.m13541b(r162);
                throw th;
            }
            AbstractC11975a.m13541b(fileInputStream);
        } else {
            AbstractC0299q.m643n(str6, "restoreServerPasswordTimeInfo file not exist");
        }
        r18.m13579o(new File(str7));
        FileUtils.printDirectory(r18.f8593s, ".widget", true);
        try {
            AbstractC12023d.m13674S(str7);
            M13567D = m13567D(AbstractC0155m.m387b(str7, "sdoc.list"));
            HashMap map322 = new HashMap();
            HashMap map422 = new HashMap();
            try {
                if (M13567D == 0 || M13567D.isEmpty()) {
                    i2 = 0;
                    String str82 = str6;
                    AbstractC0299q.m643n(str82, "update syncItemInfo == null or syncItemInfo.size == 0");
                    r18.m13580p(M13567D);
                    r18.m13578m();
                    r14 = r18;
                    r34 = str82;
                } else {
                    AbstractC0299q.m643n(str6, "update syncItemInfo size " + M13567D.size());
                    int size = M13567D.size();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i11 = 0;
                    r18 = r18;
                    ?? r35 = M13567D;
                    while (i11 < size) {
                        String str9 = ((C0009i) r35.get(i11)).f38a;
                        String str10 = ((C0009i) r35.get(i11)).f39b;
                        File file2 = new File(AbstractC0155m.m387b(str7, str10));
                        if (file2.exists()) {
                            int i12 = ((C0009i) r35.get(i11)).f52o;
                            if ((file2.getName().endsWith(".sdoc") && LockUtils.isLockedSdocType(i12)) || LockUtils.isLockedOtherDocType(i12)) {
                                AbstractC0299q.m643n(str6, "update skip2 not supported lockState " + i12);
                                r16 = r18;
                            } else {
                                try {
                                    if (file2.getName().endsWith(".sdocx")) {
                                        try {
                                            formatVersion = SpenWNoteFile.getFormatVersion(file2.getAbsolutePath());
                                        } catch (Exception e8) {
                                            e = e8;
                                            i4 = size;
                                        }
                                        if (formatVersion < 2034) {
                                            AbstractC0299q.m643n(str6, "update skip3 unsupported previous format. version " + formatVersion);
                                            r16 = this;
                                        } else {
                                            int minFormatVersion = SpenWNoteFile.getMinFormatVersion(file2.getAbsolutePath());
                                            int sdkFormatVersion = SpenWNoteFile.getSdkFormatVersion();
                                            if (minFormatVersion > sdkFormatVersion) {
                                                StringBuilder sb = new StringBuilder();
                                                i4 = size;
                                                try {
                                                    sb.append("update skip4 unsupported forward format version min ");
                                                    sb.append(minFormatVersion);
                                                    sb.append(", sdk : ");
                                                    sb.append(sdkFormatVersion);
                                                    AbstractC0299q.m643n(str6, sb.toString());
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    try {
                                                        AbstractC0299q.m646q(str6, "update failed to get format version " + e.getMessage());
                                                        if (i12 != 5) {
                                                            hashedAccountGuid = null;
                                                        }
                                                        if (DocumentExtensionUtils.isSdocx(file2.getAbsolutePath())) {
                                                        }
                                                        boolean z = ((C0009i) r35.get(i11)).f44g;
                                                        String str11 = ((C0009i) r35.get(i11)).f45h;
                                                        int i13 = ((C0009i) r35.get(i11)).f42e;
                                                        AbstractC0299q.m643n(str6, "update need to save memo");
                                                        long j3 = j2;
                                                        HashMap map5 = map422;
                                                        int i14 = i8;
                                                        str2 = str7;
                                                        i6 = i14;
                                                        r17 = this;
                                                        r153 = r35;
                                                        long j5 = modifiedTime;
                                                        HashMap map6 = map322;
                                                        i5 = i4;
                                                        str5 = str6;
                                                        i7 = i11;
                                                        importItemM13581w = r17.m13581w(str4, str9, str11, z, i13, i9, j5, createdTime, file2);
                                                        if (importItemM13581w != null) {
                                                        }
                                                        str = str5;
                                                        i11 = i7 + 1;
                                                        str6 = str;
                                                        map322 = map2;
                                                        r35 = r153;
                                                        jCurrentTimeMillis = j;
                                                        i10 = i6;
                                                        str7 = str2;
                                                        map422 = map;
                                                        size = i5;
                                                        r18 = r17;
                                                    } catch (Exception e10) {
                                                        e = e10;
                                                        r18 = this;
                                                        r32 = str6;
                                                        r13 = r18;
                                                        AbstractC0299q.m646q(r32, "update failed updateDB exception " + e.getMessage());
                                                        r13.m13578m();
                                                        i = -1;
                                                        r12 = r13;
                                                        r33 = r32;
                                                        AbstractC0299q.m643n(r33, "update end " + i);
                                                        r12.f8559i = i;
                                                        return i;
                                                    }
                                                }
                                                r15 = this;
                                                r152 = r35;
                                                map = map422;
                                                j = jCurrentTimeMillis;
                                                str = str6;
                                                str2 = str7;
                                                i5 = i4;
                                                i6 = 0;
                                                map2 = map322;
                                                r17 = r15;
                                                r153 = r152;
                                            } else {
                                                i4 = size;
                                                if (i12 != 5) {
                                                    if (UserHandleCompat.getInstance().isSecureFolderMode()) {
                                                        AbstractC0299q.m643n(str6, "update skip5 locked sdocx file in Secure Folder Mode " + i12);
                                                    } else {
                                                        try {
                                                            hashedAccountGuid = LockUtils.getHashedAccountGuid(SpenWNoteFile.getOwnerId(file2.getAbsolutePath()));
                                                        } catch (Exception e11) {
                                                            AbstractC0299q.m646q(str6, "update failed to get owner id " + e11.getMessage());
                                                            r15 = this;
                                                            r152 = r35;
                                                            map = map422;
                                                            j = jCurrentTimeMillis;
                                                            str = str6;
                                                            str2 = str7;
                                                            i5 = i4;
                                                            i6 = 0;
                                                            map2 = map322;
                                                            r17 = r15;
                                                            r153 = r152;
                                                            i7 = i11;
                                                        }
                                                    }
                                                    r15 = this;
                                                    r152 = r35;
                                                    map = map422;
                                                    j = jCurrentTimeMillis;
                                                    str = str6;
                                                    str2 = str7;
                                                    i5 = i4;
                                                    i6 = 0;
                                                    map2 = map322;
                                                    r17 = r15;
                                                    r153 = r152;
                                                }
                                                if (DocumentExtensionUtils.isSdocx(file2.getAbsolutePath())) {
                                                    modifiedTime = ((C0009i) r35.get(i11)).f41d;
                                                    j2 = jCurrentTimeMillis;
                                                    i9 = i12;
                                                    i8 = 0;
                                                    str4 = str10;
                                                    createdTime = ((C0009i) r35.get(i11)).f51n;
                                                } else {
                                                    try {
                                                        modifiedTime = SpenSdkCompat.with(C0322h.m670a().f815a.getAppContext()).asSpenSDocFile().getModifiedTime(file2.getAbsolutePath(), false);
                                                        try {
                                                            i8 = 0;
                                                            str4 = str10;
                                                            i9 = i12;
                                                            createdTime = SpenSdkCompat.with(C0322h.m670a().f815a.getAppContext()).asSpenSDocFile().getCreatedTime(file2.getAbsolutePath(), false);
                                                            j2 = jCurrentTimeMillis;
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            r17 = this;
                                                            r153 = r35;
                                                            str2 = str7;
                                                            i5 = i4;
                                                            i6 = 0;
                                                            map = map422;
                                                            j = jCurrentTimeMillis;
                                                            str3 = str6;
                                                            map2 = map322;
                                                            i7 = i11;
                                                            str = str3;
                                                            AbstractC0299q.m646q(str, "update exception get doc data " + e.getMessage());
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        AbstractC11983c abstractC11983c = this;
                                                        map = map422;
                                                        j = jCurrentTimeMillis;
                                                        str2 = str7;
                                                        i6 = 0;
                                                        i5 = i4;
                                                        ?? r154 = r35;
                                                        map2 = map322;
                                                        str3 = str6;
                                                        r17 = abstractC11983c;
                                                        r153 = r154;
                                                        i7 = i11;
                                                        str = str3;
                                                        AbstractC0299q.m646q(str, "update exception get doc data " + e.getMessage());
                                                        i11 = i7 + 1;
                                                        str6 = str;
                                                        map322 = map2;
                                                        r35 = r153;
                                                        jCurrentTimeMillis = j;
                                                        i10 = i6;
                                                        str7 = str2;
                                                        map422 = map;
                                                        size = i5;
                                                        r18 = r17;
                                                    }
                                                }
                                                boolean z2 = ((C0009i) r35.get(i11)).f44g;
                                                String str112 = ((C0009i) r35.get(i11)).f45h;
                                                int i132 = ((C0009i) r35.get(i11)).f42e;
                                                AbstractC0299q.m643n(str6, "update need to save memo");
                                                long j32 = j2;
                                                HashMap map52 = map422;
                                                int i142 = i8;
                                                str2 = str7;
                                                i6 = i142;
                                                r17 = this;
                                                r153 = r35;
                                                long j52 = modifiedTime;
                                                HashMap map62 = map322;
                                                i5 = i4;
                                                str5 = str6;
                                                i7 = i11;
                                                importItemM13581w = r17.m13581w(str4, str9, str112, z2, i132, i9, j52, createdTime, file2);
                                                if (importItemM13581w != null) {
                                                    importItemM13581w.setSaveTime(((C0009i) r153.get(i7)).f41d);
                                                    importItemM13581w.setCreatedTime(((C0009i) r153.get(i7)).f51n);
                                                    importItemM13581w.setOwnerId(hashedAccountGuid);
                                                    importItemM13581w.setRestorePath(((C0009i) r153.get(i7)).f43f);
                                                    importItemM13581w.setMsSyncAccountId(((C0009i) r153.get(i7)).f53p);
                                                    importItemM13581w.setMsSyncDocumentid(((C0009i) r153.get(i7)).f54q);
                                                    importItemM13581w.setMsLastSyncTime(((C0009i) r153.get(i7)).f55r);
                                                    importItemM13581w.setMathMode(((C0009i) r153.get(i7)).f56s);
                                                    if (i132 == 2) {
                                                        j = j32;
                                                        importItemM13581w.setRecycleBinTimeMoved(j);
                                                    } else {
                                                        j = j32;
                                                    }
                                                    r17.f8561k.add(importItemM13581w);
                                                    if (!importItemM13581w.getChangeUUIDFlag()) {
                                                        map2 = map62;
                                                    } else if (DocumentExtensionUtils.isSdocx(str4)) {
                                                        map2 = map62;
                                                        map2.put(str9, importItemM13581w.getServerKey());
                                                        str = str5;
                                                        map = map52;
                                                        i11 = i7 + 1;
                                                        str6 = str;
                                                        map322 = map2;
                                                        r35 = r153;
                                                        jCurrentTimeMillis = j;
                                                        i10 = i6;
                                                        str7 = str2;
                                                        map422 = map;
                                                        size = i5;
                                                        r18 = r17;
                                                    } else {
                                                        map2 = map62;
                                                        if (DocumentExtensionUtils.isSdoc(str4)) {
                                                            map = map52;
                                                            map.put(str9, importItemM13581w.getServerKey());
                                                        }
                                                    }
                                                    map = map52;
                                                } else {
                                                    map2 = map62;
                                                    map = map52;
                                                    j = j32;
                                                }
                                                str = str5;
                                                i11 = i7 + 1;
                                                str6 = str;
                                                map322 = map2;
                                                r35 = r153;
                                                jCurrentTimeMillis = j;
                                                i10 = i6;
                                                str7 = str2;
                                                map422 = map;
                                                size = i5;
                                                r18 = r17;
                                            }
                                        }
                                    } else {
                                        i4 = size;
                                    }
                                    importItemM13581w = r17.m13581w(str4, str9, str112, z2, i132, i9, j52, createdTime, file2);
                                    if (importItemM13581w != null) {
                                    }
                                    str = str5;
                                    i11 = i7 + 1;
                                    str6 = str;
                                    map322 = map2;
                                    r35 = r153;
                                    jCurrentTimeMillis = j;
                                    i10 = i6;
                                    str7 = str2;
                                    map422 = map;
                                    size = i5;
                                    r18 = r17;
                                } catch (Exception e14) {
                                    e = e14;
                                    r32 = str5;
                                    r13 = r17;
                                    AbstractC0299q.m646q(r32, "update failed updateDB exception " + e.getMessage());
                                    r13.m13578m();
                                    i = -1;
                                    r12 = r13;
                                    r33 = r32;
                                    AbstractC0299q.m643n(r33, "update end " + i);
                                    r12.f8559i = i;
                                    return i;
                                }
                                hashedAccountGuid = null;
                                if (DocumentExtensionUtils.isSdocx(file2.getAbsolutePath())) {
                                }
                                boolean z22 = ((C0009i) r35.get(i11)).f44g;
                                String str1122 = ((C0009i) r35.get(i11)).f45h;
                                int i1322 = ((C0009i) r35.get(i11)).f42e;
                                AbstractC0299q.m643n(str6, "update need to save memo");
                                long j322 = j2;
                                HashMap map522 = map422;
                                int i1422 = i8;
                                str2 = str7;
                                i6 = i1422;
                                r17 = this;
                                r153 = r35;
                                long j522 = modifiedTime;
                                HashMap map622 = map322;
                                i5 = i4;
                                str5 = str6;
                                i7 = i11;
                            }
                            i5 = size;
                            r152 = r35;
                            map = map422;
                            j = jCurrentTimeMillis;
                            str = str6;
                            str2 = str7;
                            r15 = r16;
                            i6 = 0;
                            map2 = map322;
                            r17 = r15;
                            r153 = r152;
                        } else {
                            AbstractC0299q.m643n(str6, "update skip1 backupFile is not exist");
                            i5 = size;
                            map = map422;
                            j = jCurrentTimeMillis;
                            str2 = str7;
                            i6 = i10;
                            r153 = r35;
                            map2 = map322;
                            str = str6;
                            r17 = r18;
                        }
                        i7 = i11;
                        i11 = i7 + 1;
                        str6 = str;
                        map322 = map2;
                        r35 = r153;
                        jCurrentTimeMillis = j;
                        i10 = i6;
                        str7 = str2;
                        map422 = map;
                        size = i5;
                        r18 = r17;
                    }
                    HashMap map7 = map322;
                    String str12 = str7;
                    i2 = i10;
                    ?? r155 = r35;
                    M13567D = str6;
                    AbstractC0299q.m643n(M13567D, "update restore old tag list");
                    m13565B(m13571s(AbstractC0155m.m387b(str12, "hashtag.list")));
                    m13564A(m13570r(AbstractC0155m.m387b(str12, "hashtagContent.list")), map422);
                    AbstractC0299q.m643n(M13567D, "update restore new tag list");
                    ArrayList arrayListM13572t = m13572t(AbstractC0155m.m387b(str12, "hashtagNote4.list"));
                    if (arrayListM13572t != null && !arrayListM13572t.isEmpty()) {
                        m13577z(arrayListM13572t, map7);
                    }
                    ArrayList arrayListM13569q = m13569q(AbstractC0155m.m387b(str12, "bookMark.list"));
                    if (arrayListM13569q.isEmpty()) {
                        AbstractC0299q.m643n(M13567D, "update restore bookmark no items");
                    } else {
                        m13576y(arrayListM13569q, map7);
                    }
                    ArrayList arrayListM13573u = m13573u(AbstractC0155m.m387b(str12, "pageTemplate.list"));
                    if (arrayListM13573u.isEmpty()) {
                        AbstractC0299q.m643n(M13567D, "update restore pageTemplate no items");
                    } else {
                        ArrayList arrayListM13566C = m13566C(arrayListM13573u);
                        String strM387b = AbstractC0155m.m387b(str12, "pageTemplate");
                        String str13 = C0148f.f420k;
                        AbstractC0147e.f419a.getClass();
                        try {
                            FileUtils.copyDirectory(arrayListM13566C, new File(strM387b), new File(AbstractC0155m.m387b(WDocUtils.getNoteDirPath(C0322h.m670a().f815a.getAppContext()), "app_templates/added")));
                        } catch (IOException e15) {
                            AbstractC0299q.m646q(C0339a.f859a, "restoreMove failed " + e15.getMessage());
                        }
                    }
                    ArrayList arrayListM13574v = m13574v(AbstractC0155m.m387b(str12, "recentSearch.list"));
                    if (arrayListM13574v.isEmpty()) {
                        AbstractC0299q.m643n(M13567D, "update restore recentSearch no items");
                    } else {
                        AbstractC0299q.m643n(M13567D, "restoreRecentSearchItems");
                        Iterator it = arrayListM13574v.iterator();
                        while (it.hasNext()) {
                            RecentSearchDatabaseHelper.INSTANCE.getInstance().insertSearchKeyword((String) it.next());
                        }
                    }
                    C6798g.m4962h().m4966j();
                    r18.m13580p(r155);
                    r18.m13578m();
                    r14 = r18;
                    r34 = M13567D;
                }
                i = i2;
                r12 = r14;
                r33 = r34;
            } catch (Exception e16) {
                e = e16;
                r13 = r18;
                r32 = M13567D;
            }
        } catch (Exception e17) {
            e = e17;
        }
        AbstractC0299q.m643n(r33, "update end " + i);
        r12.f8559i = i;
        return i;
    }

    /* JADX INFO: renamed from: m */
    public final void m13578m() {
        String str = f8589u;
        AbstractC0299q.m643n(str, "clearSDocTempFiles");
        try {
            FileUtils.deleteFile(new File(this.f8592r));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("clearSDocTempFiles failed to deleteFile Databases_Restore_PATH "), str);
        }
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        File file = new File(C0148f.f430u);
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e2) {
                AbstractC0000a.m1B(e2, new StringBuilder("clearSDocTempFiles "), str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: o */
    public final void m13579o(File file) {
        String str = this.f8593s;
        File file2 = new File(str);
        boolean zExists = file2.exists();
        String str2 = f8589u;
        if (!zExists && !file2.mkdirs()) {
            AbstractC0299q.m643n(str2, "copyFileWidget to mkdirs widgetIdFolder path");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str3 : list) {
                        m13579o(new File(file, str3));
                    }
                    return;
                }
                return;
            }
            String name = file.getName();
            if (name.endsWith(".widget")) {
                String strM387b = AbstractC0155m.m387b(str, name);
                try {
                    try {
                        String str4 = C0148f.f420k;
                        StringBuilder sb = AbstractC0147e.f419a.f440j;
                        sb.append("copyFileWidget " + strM387b);
                        sb.append("||");
                        FileUtils.copyFile(file, new File(strM387b));
                        boolean zDelete = file.delete();
                        file = zDelete;
                        if (!zDelete) {
                            AbstractC0299q.m646q(str2, "copyFileWidget exception failed to delete waste files");
                        }
                    } catch (IOException e) {
                        AbstractC0299q.m646q(str2, "copyFileWidget exception while copying widgets " + e.getMessage());
                        boolean zDelete2 = file.delete();
                        file = zDelete2;
                        if (!zDelete2) {
                            AbstractC0299q.m646q(str2, "copyFileWidget exception failed to delete waste files");
                            file = zDelete2;
                        }
                    }
                } catch (Throwable th) {
                    if (!file.delete()) {
                        AbstractC0299q.m646q(str2, "copyFileWidget exception failed to delete waste files");
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m13580p(ArrayList arrayList) {
        File[] fileArrListFiles = new File(this.f8590p).listFiles();
        if (fileArrListFiles != null) {
            if (fileArrListFiles.length > (arrayList != null ? arrayList.size() : 0)) {
                for (File file : fileArrListFiles) {
                    if (DocumentExtensionUtils.isSdocx(file.getAbsolutePath())) {
                        String str = "copyTempFiles " + FileUtils.logPath(file.getName());
                        String str2 = f8589u;
                        AbstractC0299q.m643n(str2, str);
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    C0009i c0009i = (C0009i) it.next();
                                    if (file.getName().equals(c0009i.f39b)) {
                                        AbstractC0299q.m643n(str2, "copyTempFiles ignore copy because this file is already included in the restore item " + FileUtils.logPath(c0009i.f39b));
                                        break;
                                    }
                                } else {
                                    String str3 = C0148f.f420k;
                                    AbstractC0147e.f419a.getClass();
                                    m13568n(file, AbstractC0155m.m387b(C0148f.m352e(), "SDocTemp"));
                                    break;
                                }
                            }
                        } else {
                            String str4 = C0148f.f420k;
                            AbstractC0147e.f419a.getClass();
                            m13568n(file, AbstractC0155m.m387b(C0148f.m352e(), "SDocTemp"));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: w */
    public final ImportItem m13581w(String str, String str2, String str3, boolean z, int i, int i2, long j, long j2, File file) throws Throwable {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String strNewUUIDFromSourceUUID;
        long modifiedTime;
        long createdTime;
        boolean z6;
        long createdTime2;
        long lastModifiedAt;
        File file2 = new File(AbstractC0155m.m387b(this.f8591q, str));
        Context appContext = C0322h.m670a().f815a.getAppContext();
        NotesDocumentEntity notesDocumentEntity = this.f8594t.get(str2);
        String str4 = this.f8593s;
        String str5 = f8589u;
        boolean z7 = false;
        if (notesDocumentEntity != null) {
            AbstractC0299q.m643n(str5, "makeImportItem restoredLockState " + i2);
            if (notesDocumentEntity.getIsDeleted() != 0) {
                AbstractC0299q.m643n(str5, "makeImportItem not existing note");
                if (file2.exists()) {
                    try {
                        if (DocumentExtensionUtils.isSdocx(file2.getAbsolutePath())) {
                            lastModifiedAt = notesDocumentEntity.getLastModifiedAt();
                            createdTime2 = notesDocumentEntity.getCreatedAt();
                        } else {
                            long modifiedTime2 = SpenSdkCompat.with(appContext).asSpenSDocFile().getModifiedTime(file2.getAbsolutePath(), false);
                            createdTime2 = SpenSdkCompat.with(appContext).asSpenSDocFile().getCreatedTime(file2.getAbsolutePath(), false);
                            lastModifiedAt = modifiedTime2;
                        }
                        if (j == lastModifiedAt && j2 == createdTime2) {
                            AbstractC0299q.m643n(str5, "makeImportItem same memo is in bin, recovery");
                            z4 = true;
                            z2 = false;
                        } else {
                            AbstractC0299q.m643n(str5, "makeImportItem different doc in bin, make new");
                            z2 = true;
                            z4 = false;
                        }
                        boolean z8 = z2;
                        z3 = z8;
                        z7 = z8;
                        z5 = false;
                    } catch (Exception e) {
                        AbstractC6670b.m4762w(e, new StringBuilder("makeImportItem exception get doc data "), str5);
                        return null;
                    }
                } else {
                    AbstractC0299q.m643n(str5, "makeImportItem restoreFile is not exist, recovery");
                    z4 = true;
                    z3 = true;
                    z2 = false;
                    z5 = false;
                }
            } else {
                AbstractC0299q.m643n(str5, "makeImportItem existing note");
                if (file2.exists()) {
                    int isLock = notesDocumentEntity.getIsLock();
                    try {
                        if (DocumentExtensionUtils.isSdocx(file2.getAbsolutePath())) {
                            modifiedTime = notesDocumentEntity.getLastModifiedAt();
                            createdTime = notesDocumentEntity.getCreatedAt();
                        } else {
                            modifiedTime = SpenSDocFile.getModifiedTime(file2.getAbsolutePath(), false);
                            createdTime = SpenSDocFile.getCreatedTime(file2.getAbsolutePath(), false);
                        }
                        if (j == modifiedTime && isLock != i2) {
                            AbstractC0299q.m643n(str5, "makeImportItem lock state is updated only");
                            z5 = true;
                            z2 = false;
                            z6 = false;
                        } else if (j2 != createdTime) {
                            AbstractC0299q.m643n(str5, "makeImportItem different memo in list");
                            z2 = true;
                            z6 = true;
                            z5 = false;
                        } else {
                            if (j <= modifiedTime) {
                                if (j >= modifiedTime) {
                                    AbstractC0299q.m643n(str5, "makeImportItem same memo in list, skip");
                                    m13575x(str4, str2, str2);
                                    return null;
                                }
                                AbstractC0299q.m643n(str5, "makeImportItem changed memo in list");
                                try {
                                    String str6 = C0148f.f420k;
                                    AbstractC0147e.f419a.getClass();
                                    File file3 = new File(AbstractC0155m.m387b(C0148f.m352e(), "SDocTemp"));
                                    if (!file3.exists() && !file3.mkdirs()) {
                                        AbstractC0299q.m646q(str5, "makeImportItem failed to mkdirs mSDocTempPath path");
                                    }
                                    if (file3.exists()) {
                                        FileUtils.copyFile(file, new File(AbstractC0155m.m387b(AbstractC0155m.m387b(C0148f.m352e(), "SDocTemp"), file.getName())));
                                    }
                                    return null;
                                } catch (Exception e2) {
                                    AbstractC6670b.m4762w(e2, new StringBuilder("makeImportItem failed copy file "), str5);
                                    return null;
                                }
                            }
                            AbstractC0299q.m643n(str5, "makeImportItem previous memo in list");
                            z2 = false;
                            z6 = false;
                            z5 = false;
                        }
                        z7 = z6;
                        z4 = false;
                        z3 = true;
                    } catch (Exception e3) {
                        AbstractC6670b.m4762w(e3, new StringBuilder("makeImportItem exception get doc data "), str5);
                        return null;
                    }
                } else {
                    AbstractC0299q.m643n(str5, "makeImportItem restoreFile is not exist, recovery");
                    z4 = true;
                    z3 = true;
                    z2 = false;
                    z5 = false;
                }
            }
        } else {
            AbstractC0299q.m643n(str5, "makeImportItem not exist note");
            z2 = true;
            z3 = true;
            z4 = false;
            z5 = false;
        }
        ImportItem importItem = new ImportItem(30);
        if (z7) {
            strNewUUIDFromSourceUUID = UUIDUtils.newUUIDFromSourceUUID(appContext, str2);
            importItem.setServerKey(strNewUUIDFromSourceUUID);
            m13575x(str4, strNewUUIDFromSourceUUID, str2);
        } else {
            importItem.setServerKey(str2);
            m13575x(str4, str2, str2);
            strNewUUIDFromSourceUUID = "";
        }
        AbstractC0299q.m643n(str5, "makeImportItem changeUUID/sdocUUID/newSdocUUID " + z7 + "/" + str2 + "/" + strNewUUIDFromSourceUUID);
        importItem.setTitle(str);
        importItem.setLocalFullPath(this.f8590p);
        importItem.setDownloadCompleted(true);
        importItem.setFavorite(z);
        importItem.setDeleteType(i);
        importItem.setCategoryUUID(str3);
        long currentTime = TimeManager.getCurrentTime(appContext);
        importItem.setServerTimeStamp(currentTime);
        importItem.setCategoryServerTimeStamp(currentTime);
        importItem.setSaveNew(z2);
        importItem.setSaveRecovery(z4);
        importItem.setChangeUUIDFlag(z7);
        importItem.setNeedToCopySDocFlag(z3);
        importItem.setLockState(i2);
        if (!z7) {
            strNewUUIDFromSourceUUID = str2;
        }
        importItem.setUuidPair(str2, strNewUUIDFromSourceUUID);
        importItem.setNeedCopyToExternal(z5);
        return importItem;
    }
}
