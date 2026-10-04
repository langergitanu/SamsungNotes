package com.samsung.android.support.senl.p148nt.composer.main.popupnote.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u001e\u001a\u00020\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0005H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/popupnote/util/PopupNoteUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "DEFAULT_TEST_VALUE", "", "getPopupNoteInfo", "Landroid/app/ActivityOptions;", "context", "Landroid/content/Context;", "getActivityOptions", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "savePopupNoteInfo", "", "saveScreenInfo", "width", "height", "x", "y", "saveScreenSize", "editor", "Landroid/content/SharedPreferences$Editor;", "configuration", "Landroid/content/res/Configuration;", "saveScreenLocation", "restoreLegacyPreference", "removeLegacyPrefFiles", "legacyPrefFiles", "", "Ljava/io/File;", "getLegacyPrefFiles", "loadPreferenceIntValue", Constants.MessagePayloadKeys.FROM, "Landroid/content/SharedPreferences;", "fromKey", "to", "toKey", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupNoteUtils {
    private static final int DEFAULT_TEST_VALUE = -10000;

    @NotNull
    public static final PopupNoteUtils INSTANCE = new PopupNoteUtils();
    private static final String TAG = Logger.createTag("PopupNoteUtils");

    private PopupNoteUtils() {
    }

    private final List<File> getLegacyPrefFiles(Context context) {
        File[] fileArrListFiles;
        String parent = context.getFilesDir().getParent();
        if (parent == null) {
            parent = "";
        }
        File file = new File(AbstractC0541b.m757C(parent, File.separator, "shared_prefs"));
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
        while (it.hasNext()) {
            File file2 = (File) it.next();
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.m14162r(name, SharedPreferencesConstants.POPUPNOTE_PREFS_NAME)) {
                Intrinsics.checkNotNull(file2);
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @JvmStatic
    @TargetApi(24)
    @Nullable
    public static final ActivityOptions getPopupNoteInfo(@Nullable Context context) {
        int iMin;
        int iMin2;
        if (context == null) {
            return null;
        }
        INSTANCE.restoreLegacyPreference(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("Composer", 0);
        int i = sharedPreferences.getInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_WIDTH, 0);
        int i2 = sharedPreferences.getInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_HEIGHT, 0);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C9086R.dimen.popup_note_custom_controller_height);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C9086R.dimen.popup_note_window_margin);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        if (DeviceUtils.isTabletModel() && i2 == 0) {
            i4 = (int) (i4 * 0.67f);
            i5 = (int) (i5 * 0.67f);
        }
        int i6 = i4 - (dimensionPixelSize2 * 2);
        int statusBarHeight = i5 - (dimensionPixelSize2 + dimensionPixelSize);
        if (Build.VERSION.SDK_INT > 34) {
            statusBarHeight -= WindowManagerCompat.INSTANCE.getInstance().getStatusBarHeight(context) + InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeight(context);
        }
        if (i2 == 0) {
            iMin = i6;
            iMin2 = statusBarHeight;
        } else {
            iMin = Math.min(i, i6);
            iMin2 = Math.min(i2, statusBarHeight);
        }
        int i7 = sharedPreferences.getInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_X_POS, dimensionPixelSize2);
        int i8 = sharedPreferences.getInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_Y_POS, 0);
        int i9 = i7 + iMin;
        int i10 = displayMetrics.widthPixels;
        if (i9 > i10) {
            i7 = (i10 - iMin) - dimensionPixelSize2;
        } else if (i7 < 0) {
            i7 = dimensionPixelSize2;
        }
        int i11 = i8 + iMin2;
        int i12 = displayMetrics.heightPixels;
        if (i11 > i12) {
            dimensionPixelSize = (i12 - iMin2) - dimensionPixelSize2;
        } else if (i8 > 0) {
            dimensionPixelSize = i8;
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iMin, iMin2, "setPopupNoteInfo, width = ", ", height = ", ", x = ");
        AbstractC2821a.m2235z(sbM1173s, i7, dimensionPixelSize, ", y = ", "// screen w ");
        sbM1173s.append(i6);
        sbM1173s.append(" / h ");
        sbM1173s.append(statusBarHeight);
        Logger.m11003i(str, sbM1173s.toString());
        return ContextCompat.INSTANCE.getInstance().makeLaunchBoundOption(i7, dimensionPixelSize, iMin + i7, iMin2 + dimensionPixelSize);
    }

    private final void loadPreferenceIntValue(SharedPreferences from, String fromKey, SharedPreferences to, String toKey) {
        int i = from.getInt(fromKey, DEFAULT_TEST_VALUE);
        if (i != DEFAULT_TEST_VALUE && to.getInt(toKey, DEFAULT_TEST_VALUE) == DEFAULT_TEST_VALUE) {
            to.edit().putInt(toKey, i).apply();
            from.edit().remove(fromKey).apply();
        }
    }

    private final void removeLegacyPrefFiles(List<? extends File> legacyPrefFiles) {
        Iterator<? extends File> it = legacyPrefFiles.iterator();
        while (it.hasNext()) {
            if (!it.next().delete()) {
                Logger.m11003i(TAG, "removeLegacyPrefFiles# delete fail");
            }
        }
    }

    private final void restoreLegacyPreference(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Composer", 0);
        if (sharedPreferences.getBoolean(SharedPreferencesConstants.KEY_RESTORED_POPUPNOTE_PREF, false)) {
            return;
        }
        try {
            List<File> legacyPrefFiles = getLegacyPrefFiles(context);
            if (legacyPrefFiles != null) {
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(SharedPreferencesConstants.POPUPNOTE_PREFS_NAME, 0);
                Intrinsics.checkNotNull(sharedPreferences2);
                Intrinsics.checkNotNull(sharedPreferences);
                loadPreferenceIntValue(sharedPreferences2, SharedPreferencesConstants.KEY_CREATE_NOTE_FREEFORM_WIDTH, sharedPreferences, SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_WIDTH);
                loadPreferenceIntValue(sharedPreferences2, SharedPreferencesConstants.KEY_CREATE_NOTE_FREEFORM_HEIGHT, sharedPreferences, SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_HEIGHT);
                loadPreferenceIntValue(sharedPreferences2, SharedPreferencesConstants.KEY_CREATE_NOTE_FREEFORM_X_POSITION, sharedPreferences, SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_X_POS);
                loadPreferenceIntValue(sharedPreferences2, SharedPreferencesConstants.KEY_CREATE_NOTE_FREEFORM_Y_POSITION, sharedPreferences, SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_Y_POS);
                removeLegacyPrefFiles(legacyPrefFiles);
                Logger.m11003i(TAG, "restoreLegacyPreference success");
            }
        } finally {
            sharedPreferences.edit().putBoolean(SharedPreferencesConstants.KEY_RESTORED_POPUPNOTE_PREF, true).apply();
        }
    }

    private final void saveScreenLocation(Activity activity, SharedPreferences.Editor editor) {
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        editor.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_X_POS, iArr[0]);
        editor.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_Y_POS, iArr[1]);
        AbstractC14516b.m15114b(iArr[0], iArr[1], "saveScreenLocation, x = ", ", y = ", TAG);
    }

    private final void saveScreenSize(Context context, SharedPreferences.Editor editor, Configuration configuration) {
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(context, configuration.screenWidthDp);
        int iConvertDpToPixel2 = (int) ResourceUtils.convertDpToPixel(context, configuration.screenHeightDp);
        editor.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_WIDTH, iConvertDpToPixel);
        editor.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_HEIGHT, iConvertDpToPixel2);
        AbstractC14516b.m15114b(iConvertDpToPixel, iConvertDpToPixel2, "saveScreenSize, width = ", ", height = ", TAG);
    }

    @TargetApi(24)
    @NotNull
    public final ActivityOptions getActivityOptions(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        ContextCompat companion = ContextCompat.INSTANCE.getInstance();
        int i = iArr[0];
        return companion.makeLaunchBoundOption(i, iArr[1], activity.getResources().getDisplayMetrics().widthPixels + i, iArr[1] + activity.getResources().getDisplayMetrics().heightPixels);
    }

    public final void savePopupNoteInfo(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (WindowManagerCompat.INSTANCE.getInstance().isFreeFormWindow(activity)) {
            SharedPreferences.Editor editorEdit = activity.getSharedPreferences("Composer", 0).edit();
            Intrinsics.checkNotNull(editorEdit);
            Configuration configuration = activity.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            saveScreenSize(activity, editorEdit, configuration);
            saveScreenLocation(activity, editorEdit);
            editorEdit.apply();
        }
    }

    public final void saveScreenInfo(@NotNull Activity activity, int width, int height, int x, int y2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        SharedPreferences.Editor editorEdit = activity.getSharedPreferences("Composer", 0).edit();
        editorEdit.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_WIDTH, width);
        editorEdit.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_HEIGHT, height);
        editorEdit.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_X_POS, x);
        editorEdit.putInt(SharedPreferencesConstants.COMPOSER_SP_KEY_POPUP_NOTE_Y_POS, y2);
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "saveScreenInfo, width = ", ", height = ", " x = ");
        sbM1173s.append(x);
        sbM1173s.append(", y = ");
        sbM1173s.append(y2);
        Logger.m11003i(str, sbM1173s.toString());
        editorEdit.apply();
    }
}
