package p087V0;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p186h1.AbstractC12029j;

/* JADX INFO: renamed from: V0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class CallableC0325c implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f837a = 0;

    /* JADX INFO: renamed from: b */
    public String f838b;

    /* JADX INFO: renamed from: c */
    public String f839c;

    public /* synthetic */ CallableC0325c() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        String str;
        FileInputStream fileInputStream;
        Throwable th;
        JSONArray jSONArray;
        int length;
        String str2;
        long j;
        switch (this.f837a) {
            case 0:
                return (C0324b) FolderManager.getInstance().executeOperation(new CallableC0323a(this, 0));
            default:
                String str3 = this.f838b;
                String str4 = this.f839c;
                String str5 = "categoryNameColor";
                String str6 = "restorePath";
                String str7 = "syncModifiedTime";
                String str8 = "parentFolderNodeId";
                String str9 = "timestamp";
                String str10 = AbstractC12029j.f8794a;
                AbstractC0299q.m643n(str10, TextConst.METHOD_GET_CATEGORY_INFO);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(str3);
                            try {
                                JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream2);
                                if (jSONObjectM394i != null) {
                                    try {
                                        jSONArray = jSONObjectM394i.getJSONArray("category_info");
                                        length = jSONArray.length();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str = str10;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            fileInputStream.close();
                                            throw th;
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                            throw th;
                                        }
                                    }
                                } else {
                                    jSONArray = null;
                                    length = 0;
                                }
                                if (length < 1) {
                                    AbstractC0299q.m646q(str10, "Size Error.");
                                    fileInputStream2.close();
                                } else {
                                    int i = 0;
                                    while (i < length) {
                                        fileInputStream = fileInputStream2;
                                        try {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            JSONArray jSONArray2 = jSONArray;
                                            String string = jSONObject.getString("category_uuid");
                                            int i2 = i;
                                            String string2 = jSONObject.getString("name");
                                            String uuid = PredefinedCategory.UNCATEGORIZED.getUuid();
                                            int i4 = length;
                                            if (jSONObject.has("id")) {
                                                try {
                                                    if (jSONObject.has(str8)) {
                                                        uuid = jSONObject.getString(str8);
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    str = str10;
                                                    fileInputStream.close();
                                                    throw th;
                                                }
                                            } else if (!jSONObject.has(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME)) {
                                                uuid = PredefinedCategory.OLD_NOTES.getUuid();
                                            }
                                            String str11 = str8;
                                            String str12 = uuid;
                                            long j2 = jSONObject.getLong(str9);
                                            if (jSONObject.has(str7)) {
                                                j2 = jSONObject.getLong(str7);
                                            }
                                            if (jSONObject.has(str9)) {
                                                str = str10;
                                                str2 = str9;
                                                j = jSONObject.getLong(str9);
                                            } else {
                                                str2 = str9;
                                                str = str10;
                                                j = 0;
                                            }
                                            try {
                                                String str13 = str4;
                                                long j3 = jSONObject.has(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME) ? jSONObject.getLong(RestoreDialogFragment.KEY_LAST_MODIFIED_TIME) : 0L;
                                                String str14 = str7;
                                                boolean z = jSONObject.getBoolean("deleted");
                                                String str15 = str6;
                                                String string3 = jSONObject.has(str6) ? jSONObject.getString(str6) : "";
                                                String str16 = str5;
                                                int i5 = jSONObject.has(str5) ? jSONObject.getInt(str5) : -1;
                                                NotesFolder notesFolder = new NotesFolder(string, str12, string2, string3);
                                                notesFolder.setServerTimeStamp(Long.valueOf(j2));
                                                notesFolder.setCreatedAt(j);
                                                notesFolder.setLastModifiedAt(j3);
                                                notesFolder.setIsDeleted(z ? 2 : 0);
                                                notesFolder.setDisplayNameColor(i5);
                                                if (jSONObject.has("order")) {
                                                    notesFolder.setReorder(Integer.valueOf(jSONObject.getInt("order")));
                                                }
                                                if (jSONObject.has(DBSchema.CategoryTree.IS_SYNC_WITH_MS)) {
                                                    notesFolder.setIsSyncWithMS(jSONObject.getInt(DBSchema.CategoryTree.IS_SYNC_WITH_MS));
                                                }
                                                if (jSONObject.has("recycle_bin_time_moved")) {
                                                    notesFolder.setRecycleBinTimeMoved(jSONObject.getLong("recycle_bin_time_moved"));
                                                }
                                                arrayList.add(notesFolder);
                                                i = i2 + 1;
                                                str4 = str13;
                                                fileInputStream2 = fileInputStream;
                                                jSONArray = jSONArray2;
                                                str10 = str;
                                                length = i4;
                                                str8 = str11;
                                                str7 = str14;
                                                str9 = str2;
                                                str6 = str15;
                                                str5 = str16;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                th = th;
                                                fileInputStream.close();
                                                throw th;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str = str10;
                                            th = th;
                                            fileInputStream.close();
                                            throw th;
                                        }
                                    }
                                    str = str10;
                                    fileInputStream = fileInputStream2;
                                    AbstractC12029j.m13710a(str4, arrayList);
                                    fileInputStream.close();
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                str = str10;
                                fileInputStream = fileInputStream2;
                            }
                        } catch (IOException | JSONException e) {
                            e = e;
                            str = str10;
                            AbstractC6670b.m4762w(e, new StringBuilder("Failed to restoreCategoryInfo() - "), str);
                            return arrayList;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        AbstractC6670b.m4762w(e, new StringBuilder("Failed to restoreCategoryInfo() - "), str);
                        return arrayList;
                    } catch (JSONException e3) {
                        e = e3;
                        AbstractC6670b.m4762w(e, new StringBuilder("Failed to restoreCategoryInfo() - "), str);
                        return arrayList;
                    }
                    break;
                }
                return arrayList;
        }
    }

    public CallableC0325c(String str, String str2) {
        this.f838b = str;
        this.f839c = str2;
    }
}
