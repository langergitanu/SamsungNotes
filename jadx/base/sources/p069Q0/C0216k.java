package p069Q0;

import android.content.Context;
import android.database.Cursor;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p079T.AbstractC0299q;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0216k extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f647d = "SS$".concat("RecentSearchCreator");

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m495Z(Context context, C6903f c6903f, String str) {
        FileOutputStream fileOutputStream;
        IOException e;
        StringBuilder sb;
        int count;
        String str2 = f647d;
        AbstractC0299q.m643n(str2, "create start");
        Cursor cursor = null;
        FileOutputStream fileOutputStream2 = null;
        cursor = null;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            RecentSearchDatabaseHelper.Companion companion = RecentSearchDatabaseHelper.INSTANCE;
            Cursor cursorQuerySearchKeywords = companion.getInstance().querySearchKeywords();
            if (cursorQuerySearchKeywords == null) {
                count = 0;
            } else {
                try {
                    count = cursorQuerySearchKeywords.getCount();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    cursor = cursorQuerySearchKeywords;
                    try {
                        AbstractC0299q.m646q(str2, "create failed to recentSearchInfoFile " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e = e3;
                                sb = new StringBuilder("create exception while closing stream ");
                                AbstractC0000a.m1B(e, sb, str2);
                            }
                        }
                        AbstractC14517a.m15136U(c6903f, 18);
                        AbstractC0299q.m643n(str2, "create finish");
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                AbstractC0000a.m1B(e5, new StringBuilder("create exception while closing stream "), str2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    cursor = cursorQuerySearchKeywords;
                    if (cursor != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            }
            Map<String, Long> mapQuerySearchKeywordList = companion.getInstance().querySearchKeywordList(count);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = mapQuerySearchKeywordList.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            for (int i = 0; i < count; i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("recent_search_keywordS", arrayList.get(i));
                jSONArray.put(jSONObject2);
                if (i % 50 == 0) {
                    AbstractC14517a.m15136U(c6903f, 17);
                }
            }
            jSONObject.put("recentSearch_info", jSONArray);
            File file = new File(str, "recentSearch.list");
            if (file.exists() && !file.delete()) {
                AbstractC0299q.m646q(str2, "create failed to delete recentSearch.list file");
            }
            if (file.createNewFile()) {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    fileOutputStream3.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                    fileOutputStream2 = fileOutputStream3;
                } catch (Exception e6) {
                    fileOutputStream = fileOutputStream3;
                    e = e6;
                    cursor = cursorQuerySearchKeywords;
                    AbstractC0299q.m646q(str2, "create failed to recentSearchInfoFile " + e.getMessage());
                    if (cursor != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream3;
                    cursor = cursorQuerySearchKeywords;
                    if (cursor != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            }
            if (cursorQuerySearchKeywords != null) {
                cursorQuerySearchKeywords.close();
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e7) {
                    e = e7;
                    sb = new StringBuilder("create exception while closing stream ");
                    AbstractC0000a.m1B(e, sb, str2);
                }
            }
        } catch (Exception e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        AbstractC14517a.m15136U(c6903f, 18);
        AbstractC0299q.m643n(str2, "create finish");
    }
}
