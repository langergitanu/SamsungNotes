package com.samsung.android.app.notes.widget.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p042J1.AbstractC0144b;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ(\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/util/WidgetBRHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isCalledBySmartSwitch", "", "oldWidgetUuid", "restoreWidgetInfoToSharedPref", "", "oldWidgetUUID", "appWidgetID", "", "oldWidgetID", "restoreNoteListWidgetInfo", "restoreCreatorWidgetInfo", "restoreSingleInfo", "restoreWidgetInfo", "context", "Landroid/content/Context;", "newWidgetID", "checkNMemoTask", "restoreWidgetInfoWithoutUUID", "oldWidgetId", "newWidgetId", "deleteWidgetInfoWithoutUuid", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetBRHelper {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetBRHelper INSTANCE = new WidgetBRHelper();

    @NotNull
    private static final String TAG = "WidgetBRHelper";

    private WidgetBRHelper() {
    }

    @JvmStatic
    public static final void deleteWidgetInfoWithoutUuid(int oldWidgetId) {
        WidgetLogger.m5154d(TAG, "deleteWidgetInfoWithoutUuid# oldWidgetId : " + oldWidgetId);
        C0073a c0073a = AbstractC0144b.f399a;
        String string = INSTANCE.toString();
        c0073a.getClass();
        File parentFile = C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile();
        if (parentFile == null) {
            Debugger.m8607d("SC$SS$MigrationWidgetUtils", "deleteRestoredWidgetInfo memoDir == null");
            return;
        }
        try {
            if (new File(AbstractC0155m.m387b(AbstractC0155m.m387b(AbstractC0155m.m387b(parentFile.getAbsolutePath(), Constants.DOCUMENT_DIR_NAME), "SSWL"), Integer.toString(oldWidgetId)) + ".widget").delete()) {
                Debugger.m8614f("SC$SS$MigrationWidgetUtils", "deleteRestoredWidgetInfo success to delete widgetID file: " + oldWidgetId + " by " + string);
                return;
            }
            Debugger.m8614f("SC$SS$MigrationWidgetUtils", "deleteRestoredWidgetInfo failed to delete widgetID file: " + oldWidgetId + " by " + string);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("Failed to Migration.restoreWidgetInfo() - "), "SC$SS$MigrationWidgetUtils");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[PHI: r11
      0x00fc: PHI (r11v8 int) = (r11v6 int), (r11v7 int) binds: [B:34:0x00fa, B:37:0x0100] A[DONT_GENERATE, DONT_INLINE]] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void restoreWidgetInfoToSharedPref(@Nullable String oldWidgetUUID, int appWidgetID, int oldWidgetID) {
        if (oldWidgetUUID == null) {
            WidgetLogger.m5154d(TAG, "restoreWidgetInfoToSharedPref# oldWidgetUUID: oldWidgetUUID is null, appWidgetId " + appWidgetID);
        } else {
            WidgetLogger.m5154d(TAG, "restoreWidgetInfoToSharedPref# oldWidgetUUID: " + oldWidgetUUID + " appWidgetId " + appWidgetID);
        }
        AbstractC0144b.f399a.getClass();
        int iM198p = C0073a.m198p(oldWidgetID, BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY);
        int iM198p2 = C0073a.m198p(oldWidgetID, BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR);
        int iM198p3 = C0073a.m198p(oldWidgetID, BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE);
        boolean z = C0073a.m198p(oldWidgetID, BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE) == 1;
        String strM197o = C0073a.m197o(oldWidgetID, BaseWidgetConstant.WIDGET_HOME_MODE);
        boolean z2 = C0073a.m198p(oldWidgetID, BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING) == 1;
        int iM198p4 = C0073a.m198p(oldWidgetID, BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE);
        boolean z3 = C0073a.m198p(oldWidgetID, BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF) != 0;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iM198p, iM198p2, "### Restored transparency : ", " , background color : ", ", id: ");
        AbstractC2821a.m2235z(sbM1173s, appWidgetID, iM198p3, ", darkMode : ", ", isReverse : ");
        sbM1173s.append(z);
        sbM1173s.append(", homeMode : ");
        sbM1173s.append(strM197o);
        sbM1173s.append(", matchSetting ");
        sbM1173s.append(z2);
        sbM1173s.append(", backgroundShape ");
        sbM1173s.append(iM198p4);
        sbM1173s.append(", backgroundOnOff : ");
        sbM1173s.append(z3);
        WidgetLogger.m5155i(TAG, sbM1173s.toString());
        SharedPreferences.Editor editorEdit = BaseWidgetPreferenceManager.INSTANCE.getWidgetPref().edit();
        if (iM198p != -1) {
            if (!z) {
                iM198p = 100 - iM198p;
            }
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                int i = 75;
                if (iM198p <= 0) {
                    iM198p = 75;
                    z3 = false;
                } else if (10 <= iM198p && iM198p < 51) {
                    iM198p = 50;
                } else if (iM198p <= 90) {
                    iM198p = i;
                } else {
                    i = 100;
                    if (iM198p == 100) {
                    }
                }
            }
            editorEdit.putInt(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, iM198p);
            editorEdit.putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE, true);
        }
        if (iM198p2 != -1) {
            editorEdit.putInt(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, iM198p2);
        }
        if (iM198p3 != -1) {
            editorEdit.putInt(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, iM198p3);
        }
        if (strM197o != null && strM197o.length() != 0) {
            editorEdit.putString(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.WIDGET_HOME_MODE, strM197o);
        }
        if (iM198p4 != -1) {
            editorEdit.putInt(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, iM198p4);
        }
        editorEdit.putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, z2);
        StringBuilder sb = new StringBuilder(BaseWidgetConstant.WIDGET_ID);
        sb.append(appWidgetID);
        editorEdit.putString(sb.toString(), oldWidgetUUID);
        editorEdit.putBoolean(BaseWidgetConstant.WIDGET_ID + appWidgetID + BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, z3);
        editorEdit.apply();
    }

    @JvmStatic
    public static final boolean restoreWidgetInfoWithoutUUID(int oldWidgetId, int newWidgetId) {
        FileInputStream fileInputStream;
        WidgetLogger.m5154d(TAG, "restoreWidgetInfoWithoutUUID# oldWidgetId : " + oldWidgetId + " , newWidgetID : " + newWidgetId);
        if (oldWidgetId != 0 && newWidgetId != 0) {
            AbstractC0144b.f399a.getClass();
            PostLaunchManager.getInstance().executeBaseLogics();
            File parentFile = C0322h.m670a().f815a.getAppContext().getFilesDir().getParentFile();
            if (parentFile != null) {
                String strM387b = AbstractC0155m.m387b(parentFile.getAbsolutePath(), "SDocData/SSWL");
                FileInputStream fileInputStream2 = null;
                fileInputStream2 = null;
                fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(AbstractC0155m.m387b(strM387b, Integer.toString(oldWidgetId)) + ".widget");
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                } catch (JSONException e2) {
                    e = e2;
                }
                try {
                    JSONObject jSONObjectM394i = AbstractC0155m.m394i(fileInputStream);
                    JSONArray jSONArray = jSONObjectM394i != null ? jSONObjectM394i.getJSONArray("file_info") : null;
                    if ((jSONArray != null ? jSONArray.getJSONObject(0) : null) != null) {
                        C0073a.m193d(fileInputStream);
                        return true;
                    }
                    C0073a.m193d(fileInputStream);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfo() - " + e.getMessage());
                    C0073a.m193d(fileInputStream2);
                    return false;
                } catch (JSONException e5) {
                    e = e5;
                    fileInputStream2 = fileInputStream;
                    Debugger.m8609e("SC$SS$MigrationWidgetUtils", "Failed to Migration.restoreWidgetInfo() - " + e.getMessage());
                    C0073a.m193d(fileInputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    C0073a.m193d(fileInputStream2);
                    throw th;
                }
            }
        }
        return false;
    }

    public final boolean isCalledBySmartSwitch(@Nullable String oldWidgetUuid) {
        return oldWidgetUuid != null;
    }

    public final void restoreCreatorWidgetInfo(int appWidgetID, int oldWidgetID) throws Throwable {
        restoreWidgetInfoToSharedPref(null, appWidgetID, oldWidgetID);
        AbstractC0144b.f399a.getClass();
        String strM197o = C0073a.m197o(oldWidgetID, "widget_creator_selected");
        WidgetLogger.m5155i(TAG, "### Restored creator: selected list: " + strM197o);
        if (TextUtils.isEmpty(strM197o)) {
            return;
        }
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        Intrinsics.checkNotNull(strM197o);
        companion.saveCreatorSelectedList(appWidgetID, strM197o);
    }

    public final void restoreNoteListWidgetInfo(int appWidgetID, int oldWidgetID) {
        restoreWidgetInfoToSharedPref(null, appWidgetID, oldWidgetID);
        AbstractC0144b.f399a.getClass();
        String strM197o = C0073a.m197o(oldWidgetID, "note_list_widget_uuid_list");
        WidgetLogger.m5155i(TAG, "### Restored noteList: " + strM197o);
        if (TextUtils.isEmpty(strM197o)) {
            return;
        }
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        widgetPreferenceManager.saveNoteUuidList(appWidgetID, widgetPreferenceManager.convertStringToList(strM197o));
    }

    public final void restoreSingleInfo(int appWidgetID, int oldWidgetID) {
        restoreWidgetInfoToSharedPref(null, appWidgetID, oldWidgetID);
        AbstractC0144b.f399a.getClass();
        String strM197o = C0073a.m197o(oldWidgetID, "uuid");
        WidgetLogger.m5155i(TAG, "### Restored single uuid: " + strM197o);
        if (TextUtils.isEmpty(strM197o)) {
            return;
        }
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        Intrinsics.checkNotNull(strM197o);
        companion.saveUuid(appWidgetID, strM197o);
    }

    @Nullable
    public final String restoreWidgetInfo(@NotNull Context context, int oldWidgetID, int newWidgetID, boolean checkNMemoTask) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetLogger.m5155i(TAG, "restoreWidgetInfo# oldWidgetId : " + oldWidgetID + " , newWidgetID : " + newWidgetID);
        if (oldWidgetID != 0 && newWidgetID != 0) {
            String str = C0148f.f420k;
            C0148f c0148f = AbstractC0147e.f419a;
            C0073a c0073a = AbstractC0144b.f399a;
            c0073a.getClass();
            String strM196n = C0073a.m196n(oldWidgetID);
            if (c0148f.f434d || (checkNMemoTask && c0148f.f435e)) {
                if (strM196n == null) {
                    WidgetLogger.m5156w(TAG, "restoreWidgetInfo# oldWidgetUUID is null");
                    c0073a.m199a(oldWidgetID, newWidgetID);
                    return strM196n;
                }
                MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(strM196n);
                if (mainListDocumentData != null) {
                    Intrinsics.checkNotNullExpressionValue(mainListDocumentData.getFilePath(), "getFilePath(...)");
                    if (mainListDocumentData.getIsDeleted() == 1) {
                        c0073a.m199a(oldWidgetID, newWidgetID);
                        return null;
                    }
                } else {
                    WidgetLogger.m5156w(TAG, "restoreWidgetInfo# mainListDocumentData is null");
                }
            }
            return strM196n;
        }
        return null;
    }
}
