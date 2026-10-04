package com.samsung.android.support.senl.p148nt.app.common.util;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DrawableUtils {
    public static int getColorStyle(Context context, int i) {
        int[] intArray = context.getResources().getIntArray(C8003R.array.folder_mark_color);
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i == intArray[i2]) {
                switch (i2) {
                    case 0:
                    case 12:
                        return C8003R.style.DefaultFolderColorGrey;
                    case 1:
                    case 13:
                        return C8003R.style.FolderColorRed;
                    case 2:
                    case 14:
                        return C8003R.style.FolderColorOrange;
                    case 3:
                    case 15:
                        return C8003R.style.FolderColorYellow;
                    case 4:
                    case 16:
                        return C8003R.style.FolderColorLightGreen;
                    case 5:
                    case 17:
                        return C8003R.style.FolderColorGreen;
                    case 6:
                    case 18:
                        return C8003R.style.FolderColorLightBlue;
                    case 7:
                    case 19:
                        return C8003R.style.FolderColorPink;
                    case 8:
                    case 20:
                        return C8003R.style.FolderColorViolet;
                    case 9:
                    case 21:
                        return C8003R.style.FolderColorSkyBlue;
                    case 10:
                    case 22:
                        return C8003R.style.FolderColorBlue;
                    case 11:
                    case 23:
                        return C8003R.style.FolderColorLightBrown;
                }
            }
        }
        return C8003R.style.DefaultFolderColorGrey;
    }

    public static int getConvertedNewFolderColor(Context context, int i) {
        int newFolderColor = getNewFolderColor(context, i);
        return newFolderColor == C8003R.color.new_folder_color_default ? C8003R.color.new_folder_color_default_high_contrast : newFolderColor;
    }

    public static int getFolderBlur(Context context, int i, boolean z) {
        int[] intArray = context.getResources().getIntArray(C8003R.array.folder_mark_color);
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i == intArray[i2]) {
                switch (i2) {
                    case 0:
                    case 12:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_1 : C8003R.drawable.sub_folder_icon_blur_light_1;
                    case 1:
                    case 13:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_2 : C8003R.drawable.sub_folder_icon_blur_light_2;
                    case 2:
                    case 14:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_3 : C8003R.drawable.sub_folder_icon_blur_light_3;
                    case 3:
                    case 15:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_4 : C8003R.drawable.sub_folder_icon_blur_light_4;
                    case 4:
                    case 16:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_5 : C8003R.drawable.sub_folder_icon_blur_light_5;
                    case 5:
                    case 17:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_6 : C8003R.drawable.sub_folder_icon_blur_light_6;
                    case 6:
                    case 18:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_7 : C8003R.drawable.sub_folder_icon_blur_light_7;
                    case 7:
                    case 19:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_11 : C8003R.drawable.sub_folder_icon_blur_light_11;
                    case 8:
                    case 20:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_9 : C8003R.drawable.sub_folder_icon_blur_light_9;
                    case 9:
                    case 21:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_10 : C8003R.drawable.sub_folder_icon_blur_light_10;
                    case 10:
                    case 22:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_8 : C8003R.drawable.sub_folder_icon_blur_light_8;
                    case 11:
                    case 23:
                        return z ? C8003R.drawable.sub_folder_icon_blur_dark_12 : C8003R.drawable.sub_folder_icon_blur_light_12;
                }
            }
        }
        return z ? C8003R.drawable.sub_folder_icon_blur_dark_1 : C8003R.drawable.sub_folder_icon_blur_light_1;
    }

    public static int getNewFolderColor(Context context, int i) {
        int[] intArray = context.getResources().getIntArray(C8003R.array.folder_mark_color);
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i == intArray[i2]) {
                switch (i2) {
                    case 0:
                    case 12:
                        return C8003R.color.new_folder_color_default;
                    case 1:
                    case 13:
                        return C8003R.color.new_folder_color_red;
                    case 2:
                    case 14:
                        return C8003R.color.new_folder_color_orange;
                    case 3:
                    case 15:
                        return C8003R.color.new_folder_color_yellow;
                    case 4:
                    case 16:
                        return C8003R.color.new_folder_color_light_green;
                    case 5:
                    case 17:
                        return C8003R.color.new_folder_color_green;
                    case 6:
                    case 18:
                        return C8003R.color.new_folder_color_light_blue;
                    case 7:
                    case 19:
                        return C8003R.color.new_folder_color_pink;
                    case 8:
                    case 20:
                        return C8003R.color.new_folder_color_violet;
                    case 9:
                    case 21:
                        return C8003R.color.new_folder_color_light_purple;
                    case 10:
                    case 22:
                        return C8003R.color.new_folder_color_blue;
                    case 11:
                    case 23:
                        return C8003R.color.new_folder_color_light_brown;
                }
            }
        }
        return C8003R.color.new_folder_color_default;
    }

    public static Drawable getRippleDrawable(Context context, int i, int i2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_selected}, ResourcesCompat.getDrawable(context.getResources(), i2, context.getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme()));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme()));
        return stateListDrawable;
    }

    public static Drawable setCircularRippleSelected(Context context) {
        return getRippleDrawable(context, C8003R.drawable.view_circular_ripple_pressed, C8003R.drawable.view_circular_ripple_selected);
    }

    public static Drawable setRippleSelected(Context context) {
        return getRippleDrawable(context, C8003R.drawable.view_ripple_pressed, C8003R.drawable.view_ripple_selected);
    }

    public static Drawable setRoundedRectangleRippleSelected(Context context) {
        return getRippleDrawable(context, C8003R.drawable.view_rounded_rantangle_ripple_pressed, C8003R.drawable.view_rounded_rantangle_ripple_selected);
    }
}
