package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.app.DialogCompat;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.INTEGER;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BackgroundColorUtil {
    public static final int BG_COLOR = 0;
    public static final int DARK_THEME = 2;
    public static final int REVERSE_COLOR = 1;
    private static final String TAG = Logger.createTag("ColorUtil");
    private static INTEGER mWhiteColor = null;
    private static INTEGER mBlackColor = null;
    private static boolean mLockStatusColorLock = false;

    public static int getBackgroundThemeColor(Context context, int i, boolean z, boolean z2) {
        return isComposerViewDarkTheme(context, i, z, z2) ? getBlackColor(context) : i;
    }

    public static int[] getBackgroundThemeColorTable(Context context, int i, boolean z, boolean z2) {
        int blackColor = getBlackColor(context);
        int color = ContextCompat.getColor(context, C9086R.color.composer_default_button_color_light);
        int color2 = ContextCompat.getColor(context, C9086R.color.composer_default_button_color_dark);
        int[] iArr = new int[3];
        int backgroundThemeColor = getBackgroundThemeColor(context, i, z, z2);
        iArr[0] = backgroundThemeColor;
        if (backgroundThemeColor == blackColor) {
            iArr[1] = color2;
            iArr[2] = 1;
        } else {
            iArr[1] = color;
            iArr[2] = 0;
        }
        if (isDarkModeNote(context, z, z2)) {
            iArr[0] = ColorUtils.blendARGB(iArr[0], -16777216, 0.1f);
        }
        return iArr;
    }

    public static int getBlackColor(Context context) {
        if (mBlackColor == null) {
            mBlackColor = new INTEGER(ContextCompat.getColor(context, C9086R.color.composer_main_background_dark));
        }
        return mBlackColor.getValue();
    }

    public static int getColorAdjustment(Context context, int i) {
        return i;
    }

    private static int getCutoutColor(Activity activity, int i, boolean z, boolean z2, int i2, int i4, int i5) {
        int color = ContextCompat.getColor(activity, C9086R.color.composer_background_light);
        int color2 = ContextCompat.getColor(activity, C9086R.color.composer_background_dark);
        return isDarkModeNote(activity, z, z2) ? i == i5 ? ColorUtils.blendARGB(ColorUtils.blendARGB(i2, color2, 0.1f), color2, 0.1f) : i == i4 ? ColorUtils.blendARGB(color2, i2, 0.5f) : ColorUtils.blendARGB(color2, ColorUtils.blendARGB(i2, color2, 0.1f), 0.5f) : i == i4 ? color : ColorUtils.blendARGB(color, i2, 0.5f);
    }

    public static int getDefaultBackgroundColor(int i) {
        return DocumentBackgroundUtils.getDefaultBackgroundColor(i);
    }

    public static boolean getDefaultBackgroundInvert() {
        int settingDarkModeNote = getSettingDarkModeNote();
        String str = TAG;
        AbstractC0000a.m3D(settingDarkModeNote, "getDefaultBackgroundInvert# type: ", str);
        if (settingDarkModeNote == 0) {
            return getSettingDarkModeNoteIndividuallyInfo();
        }
        if (settingDarkModeNote == 1) {
            return true;
        }
        if (settingDarkModeNote != 2) {
            Logger.m11000e(str, "getDefaultBackgroundInvert# unexpected type: " + settingDarkModeNote);
        }
        return false;
    }

    private static int getDimColor(Activity activity, int i, int i2, int i4) {
        int color = ContextCompat.getColor(activity, C9086R.color.composer_window_background_color_light);
        return i == i2 ? color : i == i4 ? ContextCompat.getColor(activity, C9086R.color.composer_window_background_color_dark) : ColorUtils.blendARGB(color, i, 0.3f);
    }

    public static DocumentBackgroundUtils.InvertBackgroundColorType getInvertBackgroundColorType(List<SpenWPage> list) {
        return DocumentBackgroundUtils.getInvertBackgroundColorType(list);
    }

    public static int getSettingDarkModeNote() {
        return 0;
    }

    public static boolean getSettingDarkModeNoteIndividuallyInfo() {
        return DocumentBackgroundUtils.getDefaultInvertBackground();
    }

    public static int getWhiteColor(Context context) {
        if (mWhiteColor == null) {
            mWhiteColor = new INTEGER(ContextCompat.getColor(context, C9086R.color.composer_main_background_light));
        }
        return mWhiteColor.getValue();
    }

    public static boolean hasBackgroundImage(List<SpenWPage> list) {
        if (list == null) {
            return false;
        }
        for (SpenWPage spenWPage : list) {
            if (spenWPage.hasPDF()) {
                return true;
            }
            if (spenWPage.getTemplateType() == 12 && spenWPage.hasBackgroundImage()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBackgroundDarkTheme(Context context, int i, boolean z, boolean z2) {
        return isComposerViewDarkTheme(context, i, z, z2) || i == getBlackColor(context);
    }

    public static boolean isComposerViewDarkTheme(Context context, int i, boolean z, boolean z2) {
        return isDarkModeNote(context, z, z2) && i == getWhiteColor(context);
    }

    private static boolean isDarkModeNote(Context context, boolean z, boolean z2) {
        if (!ContextUtils.isNightMode(context)) {
            return false;
        }
        int settingDarkModeNote = getSettingDarkModeNote();
        String str = TAG;
        AbstractC0000a.m3D(settingDarkModeNote, "getDefaultBackgroundInvert# type: ", str);
        if (settingDarkModeNote == 0) {
            return z;
        }
        if (settingDarkModeNote == 1) {
            return !z2;
        }
        if (settingDarkModeNote != 2) {
            Logger.m11000e(str, "getDefaultBackgroundInvert# unexpected type: " + settingDarkModeNote);
        }
        return false;
    }

    public static void setBlurInfoPopup(Context context, View view) {
        if (context == null || !FeatureInfo.isSupportBackgroundBlurDialog()) {
            return;
        }
        DialogCompat.INSTANCE.getInstance().setBlurInfoPopup(view, context.getResources().getDimensionPixelSize(C9086R.dimen.sesl_menu_popup_corner_radius), ContextUtils.isNightMode(context));
    }

    public static void setColorTheme(Context context, ViewGroup viewGroup, int i, boolean z, boolean z2) {
        if (context == null || viewGroup == null) {
            Logger.m11003i(TAG, "setColorTheme# context or viewGroup is null");
            return;
        }
        AbstractC8014b.m7215q(AbstractC2821a.m2226q("setColorTheme# themeColor : ", i, ", invert : ", z, ", hasBackgroundImage : "), z2, TAG);
        int[] backgroundThemeColorTable = getBackgroundThemeColorTable(context, i, z, z2);
        setThemeToView(viewGroup, backgroundThemeColorTable[1]);
        viewGroup.setBackgroundColor(backgroundThemeColorTable[0]);
    }

    public static void setCutoutColor(Activity activity, int i, boolean z, boolean z2) {
        if (activity != null) {
            int backgroundThemeColor = getBackgroundThemeColor(activity, i, z, z2);
            int whiteColor = getWhiteColor(activity);
            int blackColor = getBlackColor(activity);
            if (ModelFeature.getFeature().isFoldableModel() && DisplayDeviceTypeCompat.INSTANCE.getInstance().getDisplayDeviceType(activity) == 0) {
                DisplayCutoutCompat.getInstance().setDisplayCutoutBGColor(activity, getCutoutColor(activity, i, z, z2, backgroundThemeColor, whiteColor, blackColor));
            } else {
                DisplayCutoutCompat.getInstance().setDisplayCutoutBGColor(activity, getDimColor(activity, backgroundThemeColor, whiteColor, blackColor));
            }
        }
    }

    public static void setNavigationBar(Activity activity, int i, boolean z, boolean z2) {
        if (activity != null) {
            int backgroundThemeColor = getBackgroundThemeColor(activity, i, z, z2);
            int whiteColor = getWhiteColor(activity);
            int blackColor = getBlackColor(activity);
            int dimColor = getDimColor(activity, backgroundThemeColor, whiteColor, blackColor);
            if (backgroundThemeColor == blackColor) {
                SystemUi.setNavigationBarTheme(activity, dimColor, false);
            } else {
                SystemUi.setNavigationBarTheme(activity, dimColor, true);
            }
        }
    }

    public static void setStatusBar(Activity activity, int i, boolean z, boolean z2) {
        if (mLockStatusColorLock || activity == null) {
            return;
        }
        int[] backgroundThemeColorTable = getBackgroundThemeColorTable(activity, i, z, z2);
        SystemUi.setStatusBarTheme(activity, backgroundThemeColorTable[0], backgroundThemeColorTable[2] != 1);
        activity.getWindow().setBackgroundDrawable(new ColorDrawable(backgroundThemeColorTable[0]));
    }

    public static void setStatusBarColorLock(boolean z) {
        mLockStatusColorLock = z;
    }

    private static void setThemeToView(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                setThemeToView((ViewGroup) childAt, i);
            } else if (childAt instanceof ImageView) {
                ((ImageView) childAt).setColorFilter(i);
                childAt.invalidate();
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i);
            }
        }
    }

    public static void updateAntiGreenishColor(View view) {
        if (view == null || view.getContext() == null || !ContextUtils.isNightMode(view.getContext())) {
            return;
        }
        view.setBackgroundColor(FloatingFeature.INSTANCE.getAntiGreenishColor());
    }
}
