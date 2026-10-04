package p126c1;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: c1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC4207b {

    /* JADX INFO: renamed from: a */
    public static final String f1851a = "SS$".concat("CoverItemHelper");

    /* JADX INFO: renamed from: a */
    public static void m2483a(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                AbstractC0299q.m646q(f1851a, "closeCloseable IOException while closing closeable");
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static HashMap m2484b(String str) throws Throwable {
        FileInputStream fileInputStream;
        int length;
        String str2 = f1851a;
        AbstractC0299q.m643n(str2, "createCoverItems");
        HashMap map = new HashMap();
        FileInputStream fileInputStream2 = null;
        JSONArray jSONArray = null;
        fileInputStream2 = null;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(str);
                try {
                    JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream3);
                    if (jSONObjectM394i != null) {
                        try {
                            jSONArray = jSONObjectM394i.getJSONArray("cover_info");
                            length = jSONArray.length();
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream3;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream3;
                            m2483a(fileInputStream2);
                            throw th;
                        }
                    } else {
                        length = 0;
                    }
                    if (length < 1) {
                        AbstractC0299q.m646q(str2, "createCoverItems size error");
                        m2483a(fileInputStream3);
                        return map;
                    }
                    AbstractC0299q.m643n(str2, "createCoverItems size " + length);
                    int i = 0;
                    while (i < length) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("documentUUID");
                        String string2 = jSONObject.getString(DBSchema.DocumentCover.TEMPLATE_UUID);
                        String string3 = jSONObject.getString("title");
                        int i2 = jSONObject.getInt(DBSchema.DocumentCover.TITLE_ALIGNMENT);
                        String string4 = jSONObject.getString(DBSchema.DocumentCover.SUMMARY);
                        int i4 = jSONObject.getInt(DBSchema.DocumentCover.SUMMARY_ALIGNMENT);
                        String string5 = jSONObject.getString("categoryUUID");
                        String string6 = jSONObject.getString("backgroundColor");
                        JSONArray jSONArray2 = jSONArray;
                        fileInputStream = fileInputStream3;
                        try {
                            try {
                                long j = jSONObject.getLong("createdAt");
                                int i5 = i;
                                HashMap map2 = map;
                                try {
                                    long j2 = jSONObject.getLong("lastModifiedAt");
                                    int i6 = jSONObject.getInt("isEnabled");
                                    int i7 = i6 != 1 ? 0 : 1;
                                    int i8 = length;
                                    C4206a c4206a = new C4206a();
                                    c4206a.f1839a = string;
                                    c4206a.f1840b = string2;
                                    c4206a.f1841c = string3;
                                    c4206a.f1842d = i2;
                                    c4206a.f1843e = string4;
                                    c4206a.f1844f = i4;
                                    c4206a.f1845g = string5;
                                    c4206a.f1846h = string6;
                                    c4206a.f1847i = j;
                                    c4206a.f1848j = j2;
                                    c4206a.f1849k = i6;
                                    c4206a.f1850l = i7;
                                    map = map2;
                                    map.put(string, c4206a);
                                    i = i5 + 1;
                                    fileInputStream3 = fileInputStream;
                                    jSONArray = jSONArray2;
                                    length = i8;
                                } catch (Exception e2) {
                                    e = e2;
                                    map = map2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream2 = fileInputStream;
                            m2483a(fileInputStream2);
                            throw th;
                        }
                    }
                    m2483a(fileInputStream3);
                    return map;
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream = fileInputStream3;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream3;
                }
                fileInputStream2 = fileInputStream;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e6) {
            e = e6;
        }
        AbstractC0299q.m643n(str2, "createCoverItems failed to " + e.getMessage());
        m2483a(fileInputStream2);
        return map;
    }

    /* JADX INFO: renamed from: c */
    public static String m2485c(String str) throws Throwable {
        String string;
        FileInputStream fileInputStream;
        String str2 = f1851a;
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
            string = AbstractC0155m.m394i(fileInputStream).getString("cover_version");
            m2483a(fileInputStream);
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            AbstractC0299q.m643n(str2, "getCoverVersion failed to " + e.getMessage());
            m2483a(fileInputStream2);
            string = CoverConstants.VERSION;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            m2483a(fileInputStream2);
            throw th;
        }
        AbstractC0299q.m643n(str2, "getCoverVersion " + string);
        return string;
    }
}
