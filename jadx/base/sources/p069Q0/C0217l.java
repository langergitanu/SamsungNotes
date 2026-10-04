package p069Q0;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.WidgetContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: Q0.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0217l extends AbstractC14517a {

    /* JADX INFO: renamed from: d */
    public static final String f648d = "SS$".concat("WidgetInfoCreator");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX INFO: renamed from: Z */
    public final void m496Z(Context context, C6903f c6903f, String str) {
        C6903f c6903f2;
        int widgetTransparency;
        ArrayList<String[]> arrayList;
        int widgetBackgroundColor;
        int i;
        int widgetDarkMode;
        int i2;
        String noteList;
        String str2;
        String widgetHomeMode;
        Context context2 = context;
        String str3 = str;
        String str4 = f648d;
        AbstractC0299q.m643n(str4, "create start");
        try {
            FileUtils.deleteFile(new File(str3));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("create failed to delete files in BnR path "), str4);
        }
        File file = new File(str3);
        if (!file.exists() && !file.mkdirs()) {
            AbstractC0299q.m646q(str4, "create failed to mkdirs widgetIdFolder path");
        }
        try {
            try {
                WidgetContractImpl widgetContractImpl = C0322h.m670a().f827m;
                ArrayList<String[]> widgetInfoList = widgetContractImpl.getWidgetInfoList(context2);
                int size = widgetInfoList.size();
                char c = 0;
                int i4 = 0;
                while (i4 < size) {
                    ?? jSONObject = new JSONObject();
                    ?? jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    String str5 = widgetInfoList.get(i4)[c];
                    String str6 = widgetInfoList.get(i4)[1];
                    jSONObject2.put("uuid", str6);
                    ?? widgetTransparencyReverse = -1;
                    try {
                        widgetTransparency = widgetContractImpl.getWidgetTransparency(context2, Integer.parseInt(str5));
                    } catch (Exception e2) {
                        AbstractC0299q.m646q(str4, "create exception occurs while getting transparency " + e2.getMessage());
                        widgetTransparency = -1;
                    }
                    try {
                        arrayList = widgetInfoList;
                        widgetBackgroundColor = widgetContractImpl.getWidgetBackgroundColor(context2, Integer.parseInt(str5));
                    } catch (Exception e3) {
                        StringBuilder sb = new StringBuilder();
                        arrayList = widgetInfoList;
                        sb.append("create exception occurs while getting background color ");
                        sb.append(e3.getMessage());
                        AbstractC0299q.m646q(str4, sb.toString());
                        widgetBackgroundColor = -1;
                    }
                    try {
                        i = size;
                        widgetDarkMode = widgetContractImpl.getWidgetDarkMode(context2, Integer.parseInt(str5));
                    } catch (Exception e5) {
                        StringBuilder sb2 = new StringBuilder();
                        i = size;
                        sb2.append("create exception occurs while getting dark Mode ");
                        sb2.append(e5.getMessage());
                        AbstractC0299q.m646q(str4, sb2.toString());
                        widgetDarkMode = -1;
                    }
                    try {
                        i2 = i4;
                        widgetTransparencyReverse = widgetContractImpl.getWidgetTransparencyReverse(context2, Integer.parseInt(str5));
                    } catch (Exception e6) {
                        StringBuilder sb3 = new StringBuilder();
                        i2 = i4;
                        sb3.append("create exception occurs while getting reverse color ");
                        sb3.append(e6.getMessage());
                        AbstractC0299q.m646q(str4, sb3.toString());
                    }
                    ?? r9 = widgetTransparencyReverse;
                    String creatorSelectedList = null;
                    try {
                        noteList = widgetContractImpl.getNoteList(context2, Integer.parseInt(str5));
                    } catch (Exception e7) {
                        AbstractC0299q.m646q(str4, "create exception occurs while getting note list " + e7.getMessage());
                        noteList = null;
                    }
                    try {
                        str2 = ".widget";
                        widgetHomeMode = widgetContractImpl.getWidgetHomeMode(context2, Integer.parseInt(str5));
                    } catch (Exception e8) {
                        StringBuilder sb4 = new StringBuilder();
                        str2 = ".widget";
                        sb4.append("create exception occurs while getting home mode ");
                        sb4.append(e8.getMessage());
                        AbstractC0299q.m646q(str4, sb4.toString());
                        widgetHomeMode = null;
                    }
                    try {
                        creatorSelectedList = widgetContractImpl.getCreatorSelectedList(context2, Integer.parseInt(str5));
                    } catch (Exception e9) {
                        AbstractC0299q.m646q(str4, "create exception occurs while getting creator list " + e9.getMessage());
                    }
                    String str7 = creatorSelectedList;
                    boolean widgetBackgroundOnOff = widgetContractImpl.getWidgetBackgroundOnOff(context2, Integer.parseInt(str5));
                    boolean widgetMatchSetting = widgetContractImpl.getWidgetMatchSetting(context2, Integer.parseInt(str5));
                    int widgetBackgroundShape = widgetContractImpl.getWidgetBackgroundShape(context2, Integer.parseInt(str5));
                    StringBuilder sb5 = new StringBuilder();
                    WidgetContractImpl widgetContractImpl2 = widgetContractImpl;
                    sb5.append("create widgetID ");
                    sb5.append(str5);
                    sb5.append(", uuid ");
                    sb5.append(str6);
                    sb5.append(", transparency ");
                    sb5.append(widgetTransparency);
                    sb5.append(", backgroundColor ");
                    sb5.append(widgetBackgroundColor);
                    sb5.append(", darkMode ");
                    sb5.append(widgetDarkMode);
                    sb5.append(", reverseColor ");
                    sb5.append(r9 == true ? 1 : 0);
                    sb5.append(", homeMode ");
                    sb5.append(widgetHomeMode);
                    sb5.append(", backgroundOnOff ");
                    sb5.append(widgetBackgroundOnOff ? 1 : 0);
                    sb5.append(", matchSetting ");
                    sb5.append(widgetMatchSetting ? 1 : 0);
                    sb5.append(", backgroundShape ");
                    sb5.append(widgetBackgroundShape);
                    AbstractC0299q.m643n(str4, sb5.toString());
                    jSONObject2.put(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, widgetTransparency);
                    jSONObject2.put(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, widgetBackgroundColor);
                    jSONObject2.put(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, widgetDarkMode);
                    jSONObject2.put(BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE, r9 == true ? 1 : 0);
                    jSONObject2.put(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, widgetBackgroundOnOff ? 1 : 0);
                    jSONObject2.put(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, widgetMatchSetting ? 1 : 0);
                    jSONObject2.put(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, widgetBackgroundShape);
                    if (!TextUtils.isEmpty(noteList)) {
                        jSONObject2.put("note_list_widget_uuid_list", noteList);
                    }
                    if (!TextUtils.isEmpty(widgetHomeMode)) {
                        jSONObject2.put(BaseWidgetConstant.WIDGET_HOME_MODE, widgetHomeMode);
                    }
                    if (!TextUtils.isEmpty(str7)) {
                        jSONObject2.put("widget_creator_selected", str7);
                    }
                    jSONArray.put(jSONObject2);
                    jSONObject.put("file_info", jSONArray);
                    StringBuilder sb6 = new StringBuilder();
                    str3 = str;
                    sb6.append(AbstractC0155m.m387b(str3, str5));
                    sb6.append(str2);
                    File file2 = new File(sb6.toString());
                    if (file2.exists() && !file2.delete()) {
                        AbstractC0299q.m646q(str4, "create failed to delete widget.list file");
                    }
                    if (file2.createNewFile()) {
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                                fileOutputStream.close();
                            } finally {
                            }
                        } catch (IOException unused) {
                            AbstractC0299q.m646q(str4, "create failed to write widget file");
                        }
                    }
                    if (i2 % 50 == 0) {
                        c6903f2 = c6903f;
                        try {
                            AbstractC14517a.m15136U(c6903f2, 5);
                        } catch (IOException e10) {
                            e = e10;
                            AbstractC6670b.m4762w(e, new StringBuilder("backupWidgetInfo failed to backupWidgetInfo "), str4);
                            AbstractC14517a.m15136U(c6903f2, 6);
                            AbstractC0299q.m643n(str4, "create finish");
                        } catch (JSONException e11) {
                            e = e11;
                            AbstractC6670b.m4762w(e, new StringBuilder("backupWidgetInfo failed to backupWidgetInfo "), str4);
                            AbstractC14517a.m15136U(c6903f2, 6);
                            AbstractC0299q.m643n(str4, "create finish");
                        }
                    }
                    i4 = i2 + 1;
                    context2 = context;
                    widgetInfoList = arrayList;
                    size = i;
                    widgetContractImpl = widgetContractImpl2;
                    c = 0;
                }
                c6903f2 = c6903f;
                FileUtils.printDirectory(str3, ".widget", true);
            } catch (IOException e12) {
                e = e12;
                c6903f2 = c6903f;
                AbstractC6670b.m4762w(e, new StringBuilder("backupWidgetInfo failed to backupWidgetInfo "), str4);
                AbstractC14517a.m15136U(c6903f2, 6);
                AbstractC0299q.m643n(str4, "create finish");
            }
        } catch (JSONException e13) {
            e = e13;
            c6903f2 = c6903f;
            AbstractC6670b.m4762w(e, new StringBuilder("backupWidgetInfo failed to backupWidgetInfo "), str4);
            AbstractC14517a.m15136U(c6903f2, 6);
            AbstractC0299q.m643n(str4, "create finish");
        }
        AbstractC14517a.m15136U(c6903f2, 6);
        AbstractC0299q.m643n(str4, "create finish");
    }
}
