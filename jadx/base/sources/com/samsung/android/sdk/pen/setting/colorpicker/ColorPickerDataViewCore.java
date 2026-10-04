package com.samsung.android.sdk.pen.setting.colorpicker;

import android.content.Context;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0011R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/ColorPickerDataViewCore;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/ColorPickerThemeViewCore;", "context", "Landroid/content/Context;", "mode", "", "hsvColor", "", "supportEyedropper", "", "supportRGBCode", "mHasStorage", "<init>", "(Landroid/content/Context;I[FZZZ)V", "mDataManager", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataInterface;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setRecentColors", "recentColors", "numOfColor", "saveRecentColor", "color", "loadRecentColors", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ColorPickerDataViewCore extends ColorPickerThemeViewCore {

    @NotNull
    private static final String TAG = "SpenColorPickerDataBase";

    @NotNull
    private SpenColorPickerDataInterface mDataManager;
    private final boolean mHasStorage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPickerDataViewCore(@NotNull Context context, int i, @NotNull float[] hsvColor, boolean z, boolean z2, boolean z3) {
        super(context, i, hsvColor, z, z2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        this.mHasStorage = z3;
        this.mDataManager = z3 ? new SpenColorPickerDataManager(context) : new SpenColorPickerSimpleDataManager();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.ColorPickerThemeViewCore, com.samsung.android.sdk.pen.setting.colorpicker.ColorPickerViewCore
    public void close() {
        Log.i(TAG, "close()");
        this.mDataManager.close();
        super.close();
    }

    public final void loadRecentColors() {
        Log.i(TAG, "loadRecentColors()");
        SpenColorPickerDataInterface spenColorPickerDataInterface = this.mDataManager;
        spenColorPickerDataInterface.loadRecentColors();
        int recentColorCount = spenColorPickerDataInterface.getRecentColorCount();
        float[] fArr = new float[recentColorCount * 3];
        for (int i = 0; i < recentColorCount; i++) {
            float[] fArr2 = {0.0f, 0.0f, 0.0f};
            spenColorPickerDataInterface.getRecentColor(i, fArr2);
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[(i * 3) + i2] = fArr2[i2];
            }
        }
        super.setRecentColors(fArr, recentColorCount);
    }

    public final void saveRecentColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        float f = color[0];
        float f4 = color[1];
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("saveRecentColor() [", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA), color[2], "]", TAG);
        this.mDataManager.saveRecentColor(color);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.ColorPickerThemeViewCore
    public boolean setColorTheme(int theme) {
        if (!super.setColorTheme(theme)) {
            return false;
        }
        loadRecentColors();
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.ColorPickerThemeViewCore, com.samsung.android.sdk.pen.setting.colorpicker.ColorPickerViewCore
    public void setRecentColors(@NotNull float[] recentColors, int numOfColor) {
        Intrinsics.checkNotNullParameter(recentColors, "recentColors");
        AbstractC4539a.m3208r("setRecentColors() hasStorage=", TAG, this.mHasStorage);
        if (this.mHasStorage) {
            Log.i(TAG, "Not support recentColors");
        } else {
            this.mDataManager.setRecentColors(recentColors, numOfColor);
            super.setRecentColors(recentColors, numOfColor);
        }
    }
}
