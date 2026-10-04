package com.samsung.android.app.notes.widget.preference;

import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J&\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J*\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\bJ\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010%\u001a\u00020\u00102\n\u0010&\u001a\u00020'\"\u00020\bJ\u0012\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\bH\u0007J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010)\u001a\u00020\bJ\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050+2\b\u0010-\u001a\u0004\u0018\u00010\u0005J\u001e\u0010.\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050+J\u001e\u00100\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050+J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010)\u001a\u00020\bJ\u000e\u00102\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\bJ\u0016\u00103\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\bJ\u0016\u00106\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\b2\u0006\u00107\u001a\u00020!J\u000e\u00108\u001a\u00020!2\u0006\u0010)\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u00069"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/preference/WidgetPreferenceManager;", "Lcom/samsung/android/support/senl/nt/base/widget/preference/BaseWidgetPreferenceManager;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getFilePath", "key", "", "pinUUID", "getPinUUID$annotations", "getPinUUID", "()Ljava/lang/String;", "pinFilePath", "getPinFilePath", "saveDocInfoForPinToHome", "", "uuid", "filePath", "clearDocInfoForPinToHome", "getWidgetPreferenceManagerReverseTransparency", "getEmptyTransparency", "saveWidgetDisplayDevicePref", "displayDevice", "saveWidgetHomeModePref", "homeMode", "getWidgetHomeModePref", "saveWidgetPref", "mUUID", "transparency", "saveWidgetPrefFilePath", "deleteWidgetPref", "allRemove", "", "deleteThemePreference", "editor", "Landroid/content/SharedPreferences$Editor;", "deleteNoteListWidgetPref", "widgetIds", "", "getNoteList", "widgetId", "getNoteUuidList", "", "convertStringToList", "data", "saveNoteUuidList", "uuidList", "saveNoteUuidListBeforeAdd", "getNoteUuidListBeforeAdd", "removeAllNoteUuidList", "saveWidgetProviderName", "providerName", "getWidgetProviderName", "saveUpdateWidgetContentDone", "isDone", "getUpdateWidgetContentDone", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetPreferenceManager extends BaseWidgetPreferenceManager {

    @NotNull
    private static final String TAG = "WidgetPreferenceManager";

    @NotNull
    public static final WidgetPreferenceManager INSTANCE = new WidgetPreferenceManager();
    public static final int $stable = 8;

    private WidgetPreferenceManager() {
    }

    private final void deleteThemePreference(SharedPreferences.Editor editor, int key) {
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_THEME);
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR);
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE);
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY);
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE);
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + "orientation");
        editor.remove(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_NIGHT_MODE);
    }

    @JvmStatic
    public static final void deleteWidgetPref(int key, boolean allRemove) {
        Logger.m8700f(TAG, "deleteWidgetPref - id : " + key + ", uuid : " + Logger.getEncode(BaseWidgetPreferenceManager.INSTANCE.getUUID(key)));
        SharedPreferences.Editor editorEdit = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).edit();
        StringBuilder sb = new StringBuilder(BaseWidgetConstant.WIDGET_ID);
        sb.append(key);
        editorEdit.remove(sb.toString());
        editorEdit.remove(BaseWidgetConstant.WIDGET_ID + key + WidgetConstant.EXTRA_KEY_FILE_PATH);
        if (allRemove) {
            INSTANCE.deleteThemePreference(editorEdit, key);
            editorEdit.remove(WidgetConstant.WIDGET_MAX_WIDTH + key);
            editorEdit.remove(WidgetConstant.WIDGET_MIN_WIDTH + key);
        }
        editorEdit.apply();
    }

    @JvmStatic
    @Nullable
    public static final String getNoteList(int widgetId) {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST, "");
    }

    @Nullable
    public static final String getPinUUID() {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(WidgetConstant.WIDGET_PIN_TO_HOME, BaseWidgetConstant.NONE);
    }

    @JvmStatic
    public static /* synthetic */ void getPinUUID$annotations() {
    }

    @JvmStatic
    @Nullable
    public static final String getWidgetHomeModePref(int key) {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_HOME_MODE, BaseWidgetConstant.NONE_HOME_MODE);
    }

    @JvmStatic
    public static final void saveDocInfoForPinToHome(@NotNull String uuid, @Nullable String filePath) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Logger.m8700f(TAG, "saveDocInfoForPinToHome - pinUUID : " + uuid + " , filePath : " + Logger.getEncode(filePath));
        SharedPreferences.Editor editorEdit = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).edit();
        editorEdit.putString(WidgetConstant.WIDGET_PIN_TO_HOME, uuid);
        editorEdit.putString(WidgetConstant.WIDGET_PIN_TO_HOME_FILE_PATH, filePath);
        editorEdit.apply();
    }

    public static /* synthetic */ void saveWidgetPref$default(WidgetPreferenceManager widgetPreferenceManager, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        widgetPreferenceManager.saveWidgetPref(i, str, str2);
    }

    public final void clearDocInfoForPinToHome() {
        Logger.m8700f(TAG, "clearDocInfoForPinToHome - pinUUID : " + getPinUUID() + " , filePath : " + Logger.getEncode(getPinFilePath()));
        SharedPreferences.Editor editorEdit = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).edit();
        editorEdit.putString(WidgetConstant.WIDGET_PIN_TO_HOME, BaseWidgetConstant.NONE);
        editorEdit.putString(WidgetConstant.WIDGET_PIN_TO_HOME_FILE_PATH, BaseWidgetConstant.NONE);
        editorEdit.apply();
    }

    @NotNull
    public final List<String> convertStringToList(@Nullable String data) {
        ArrayList arrayList = new ArrayList(10);
        try {
            JSONArray jSONArray = new JSONArray(data);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException e) {
            WidgetLogger.INSTANCE.m5157e(TAG, "convertStringToList# " + e.getMessage());
            return arrayList;
        }
    }

    public final void deleteNoteListWidgetPref(@NotNull int... widgetIds) {
        Intrinsics.checkNotNullParameter(widgetIds, "widgetIds");
        for (int i : widgetIds) {
            SharedPreferences.Editor editorEdit = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).edit();
            editorEdit.remove(BaseWidgetConstant.WIDGET_ID + i);
            editorEdit.remove(BaseWidgetConstant.WIDGET_ID + i + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST);
            deleteThemePreference(editorEdit, i);
            editorEdit.apply();
        }
    }

    public final int getEmptyTransparency(int key) {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, -1);
    }

    @Nullable
    public final String getFilePath(int key) {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + key + WidgetConstant.EXTRA_KEY_FILE_PATH, BaseWidgetConstant.NONE);
    }

    @NotNull
    public final List<String> getNoteUuidList(int widgetId) {
        return convertStringToList(getNoteList(widgetId));
    }

    @NotNull
    public final List<String> getNoteUuidListBeforeAdd(int widgetId) {
        return convertStringToList(SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST_BEFORE_ADD, ""));
    }

    @Nullable
    public final String getPinFilePath() {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(WidgetConstant.WIDGET_PIN_TO_HOME_FILE_PATH, BaseWidgetConstant.NONE);
    }

    public final boolean getUpdateWidgetContentDone(int widgetId) {
        return SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getBoolean(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.WIDGET_UPDATE_CONTENT_DONE, false);
    }

    public final int getWidgetPreferenceManagerReverseTransparency(int key) {
        return 100 - SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, 100);
    }

    @NotNull
    public final String getWidgetProviderName(int widgetId) {
        String string = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).getString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.WIDGET_PROVIDER_NAME, "");
        return string == null ? "" : string;
    }

    public final void removeAllNoteUuidList(int widgetId) {
        SharedPreferences.Editor editorEdit = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).edit();
        editorEdit.remove(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST);
        editorEdit.apply();
    }

    public final void saveNoteUuidList(int widgetId, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = uuidList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST, string);
    }

    public final void saveNoteUuidListBeforeAdd(int widgetId, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = uuidList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.EXTRA_KEY_WIDGET_NOTE_UUID_LIST_BEFORE_ADD, string);
    }

    public final void saveUpdateWidgetContentDone(int widgetId, boolean isDone) {
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putBoolean(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.WIDGET_UPDATE_CONTENT_DONE, isDone);
    }

    public final void saveWidgetDisplayDevicePref(int key, int displayDevice) {
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putInt(BaseWidgetConstant.WIDGET_ID + key + WidgetConstant.WIDGET_DISPLAY_DEVICE, displayDevice);
    }

    public final void saveWidgetHomeModePref(int key, @Nullable String homeMode) {
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.WIDGET_HOME_MODE, homeMode);
    }

    @JvmOverloads
    public final void saveWidgetPref(int i, @Nullable String str) {
        saveWidgetPref$default(this, i, str, null, 4, null);
    }

    public final void saveWidgetPrefFilePath(int key, @Nullable String filePath) {
        SharedPreferencesCompat widgetPref = BaseWidgetPreferenceManager.INSTANCE.getWidgetPref();
        if (filePath == null) {
            WidgetLogger.m5154d(TAG, "saveWidgetPrefFilePath# key : " + key + ", filePath is null");
            widgetPref.putString(BaseWidgetConstant.WIDGET_ID + key + WidgetConstant.EXTRA_KEY_FILE_PATH, BaseWidgetConstant.NONE);
            return;
        }
        WidgetLogger.m5154d(TAG, "saveWidgetPrefFilePath# key : " + key + ", filePath : " + filePath);
        StringBuilder sb = new StringBuilder(BaseWidgetConstant.WIDGET_ID);
        sb.append(key);
        sb.append(WidgetConstant.EXTRA_KEY_FILE_PATH);
        widgetPref.putString(sb.toString(), filePath);
    }

    public final void saveWidgetProviderName(int widgetId, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + widgetId + WidgetConstant.WIDGET_PROVIDER_NAME, providerName);
    }

    @JvmOverloads
    public final void saveWidgetPref(int key, @Nullable String mUUID, @Nullable String filePath) {
        String encode = Logger.getEncode(mUUID);
        String encode2 = Logger.getEncode(filePath);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("saveWidgetPref - id : ", key, " uuid: ", encode, " path: ");
        sbM1629s.append(encode2);
        Logger.m8700f(TAG, sbM1629s.toString());
        SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES).putString(BaseWidgetConstant.WIDGET_ID + key, mUUID);
        saveWidgetPrefFilePath(key, filePath);
    }

    public final void saveWidgetPref(int key, @Nullable String mUUID, @Nullable String filePath, int transparency) {
        String encode = Logger.getEncode(mUUID);
        String encode2 = Logger.getEncode(filePath);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("saveWidgetPref - id : ", key, " uuid: ", encode, " path: ");
        sbM1629s.append(encode2);
        sbM1629s.append(" transparency: ");
        sbM1629s.append(transparency);
        Logger.m8700f(TAG, sbM1629s.toString());
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance(BaseWidgetConstant.WIDGET_PREFERENCES);
        companion.putString(BaseWidgetConstant.WIDGET_ID + key, mUUID);
        saveWidgetPrefFilePath(key, filePath);
        companion.putInt(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
        companion.putBoolean(BaseWidgetConstant.WIDGET_ID + key + BaseWidgetConstant.EXTRA_KEY_WIDGET_TANSPARENCY_REVERSE, true);
    }
}
