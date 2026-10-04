package com.samsung.android.sdk.pen.setting.colorpicker;

import android.annotation.SuppressLint;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\f\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0005j\b\u0012\u0004\u0012\u00020\u000b`\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerSimpleDataManager;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerDataInterface;", "<init>", "()V", "mColorTableSet", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenHSVColor;", "Lkotlin/collections/ArrayList;", "close", "", "getRecentColorCount", "", "getRecentColor", "", "index", "hsv", "", "saveRecentColor", "color", "setRecentColors", "recentColors", "numOfColor", "loadRecentColors", "getDuplicateColorIndex", "getColor", "src", "position", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenColorPickerSimpleDataManager implements SpenColorPickerDataInterface {
    private static final int HSV_COLOR_SIZE = 3;

    @NotNull
    private static final String TAG = "SpenColorPickerDataManager";

    @NotNull
    private ArrayList<SpenHSVColor> mColorTableSet = new ArrayList<>();

    private final SpenHSVColor getColor(float[] src, int position) {
        return new SpenHSVColor(src[position], src[position + 1], src[position + 2]);
    }

    private final int getDuplicateColorIndex(float[] color) {
        int size = this.mColorTableSet.size();
        for (int i = 0; i < size; i++) {
            if (this.mColorTableSet.get(i).isSameColor(color)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    public void close() {
        this.mColorTableSet.clear();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    public boolean getRecentColor(int index, @Nullable float[] hsv) {
        if (hsv == null || index < 0 || this.mColorTableSet.size() <= index) {
            return false;
        }
        return this.mColorTableSet.get(index).getHSV(hsv);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    public int getRecentColorCount() {
        return this.mColorTableSet.size();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    @NotNull
    public ArrayList<Integer> loadRecentColors() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = this.mColorTableSet.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(this.mColorTableSet.get(i).getRgb()));
        }
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    public void saveRecentColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        int duplicateColorIndex = getDuplicateColorIndex(color);
        if (duplicateColorIndex > -1) {
            this.mColorTableSet.remove(duplicateColorIndex);
        }
        ArrayList<SpenHSVColor> arrayList = this.mColorTableSet;
        ArrayList<SpenHSVColor> arrayList2 = new ArrayList<>();
        this.mColorTableSet = arrayList2;
        arrayList2.add(new SpenHSVColor(color));
        this.mColorTableSet.addAll(arrayList);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataInterface
    public void setRecentColors(@NotNull float[] recentColors, int numOfColor) {
        Intrinsics.checkNotNullParameter(recentColors, "recentColors");
        AbstractC6670b.m4744e(numOfColor, recentColors.length, "setRecentColors() num=", " size=", "SpenColorPickerDataManager");
        if (recentColors.length < numOfColor * 3) {
            return;
        }
        this.mColorTableSet.clear();
        for (int i = 0; i < numOfColor; i++) {
            this.mColorTableSet.add(getColor(recentColors, i * 3));
        }
    }
}
