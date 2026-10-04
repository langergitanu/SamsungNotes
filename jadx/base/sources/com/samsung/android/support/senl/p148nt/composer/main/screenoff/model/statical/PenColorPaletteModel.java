package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenPairedColorModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000bJB\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050#J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenColorPaletteModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mPenColorDataList", "", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenColorData;", "mPenColorDescription", "value", "", "settingPenColorPaletteSize", "getSettingPenColorPaletteSize", "()I", "", "isPreInitialized", "()Z", "init", "", "context", "Landroid/content/Context;", "initPenColorDataList", "getSettingPenColorData", "index", "getSettingPenDescription", "color", "updateColorPaletteOrder", "updatePairedPenColor", "initialize", "savedColor", "pairedColor", "currentPairedCode", "savedPairedCode", "pairedColorCodeList", "", "updateColor", "idx", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenColorPaletteModel {
    private static boolean isPreInitialized;
    private static int settingPenColorPaletteSize;

    @NotNull
    public static final PenColorPaletteModel INSTANCE = new PenColorPaletteModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("PenColorPaletteModel");

    @NotNull
    private static final List<PenColorData> mPenColorDataList = new ArrayList();

    @NotNull
    private static final List<String> mPenColorDescription = new ArrayList();

    private PenColorPaletteModel() {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initPenColorDataList(Context context) throws Throwable {
        TypedArray typedArray;
        TypedArray typedArray2;
        Resources resources = context.getResources();
        TypedArray typedArray3 = null;
        try {
            TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(C9086R.array.screenoff_pen_color_palette_set);
            try {
                TypedArray typedArrayObtainTypedArray2 = resources.obtainTypedArray(C9086R.array.screenoff_pen_color_name_list);
                if (typedArrayObtainTypedArray != null && typedArrayObtainTypedArray2 != null) {
                    settingPenColorPaletteSize = typedArrayObtainTypedArray.length();
                    StringBuilder sb = new StringBuilder();
                    int i = settingPenColorPaletteSize;
                    for (int i2 = 0; i2 < i; i2++) {
                        int color = typedArrayObtainTypedArray.getColor(i2, 0);
                        List<String> list = mPenColorDescription;
                        list.add(i2, typedArrayObtainTypedArray2.getString(i2));
                        PenColorData penColorData = new PenColorData(color, list.get(i2));
                        mPenColorDataList.add(penColorData);
                        sb.append(penColorData.getDescription());
                        sb.append(SQLKeyword.COMMA);
                    }
                    SOLogger.INSTANCE.SOLoggerD(TAG, "initPenColorDataList# lDescription " + ((Object) sb));
                    typedArrayObtainTypedArray.recycle();
                    typedArrayObtainTypedArray2.recycle();
                    return;
                }
                SOLogger.INSTANCE.SOLoggerE(TAG, "initPenColorDataList# null array");
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
                if (typedArrayObtainTypedArray2 != null) {
                    typedArrayObtainTypedArray2.recycle();
                }
            } catch (Exception unused) {
                typedArray2 = null;
                typedArray3 = typedArrayObtainTypedArray;
                try {
                    SOLogger.INSTANCE.SOLoggerE(TAG, "initPenColorDataList# exception");
                    if (typedArray3 != null) {
                        typedArray3.recycle();
                    }
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th) {
                    typedArray = typedArray2;
                    th = th;
                    if (typedArray3 != null) {
                        typedArray3.recycle();
                    }
                    if (typedArray != null) {
                        throw th;
                    }
                    typedArray.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                typedArray = null;
                typedArray3 = typedArrayObtainTypedArray;
                if (typedArray3 != null) {
                }
                if (typedArray != null) {
                }
            }
        } catch (Exception unused2) {
            typedArray2 = null;
        } catch (Throwable th3) {
            th = th3;
            typedArray = null;
        }
    }

    private final void updateColor(int idx, int color) {
        int i = settingPenColorPaletteSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            String str = mPenColorDescription.get(idx);
            List<PenColorData> list = mPenColorDataList;
            if (Intrinsics.areEqual(str, list.get(i2).getDescription())) {
                list.get(i2).setColor(color);
                break;
            }
            i2++;
        }
        int size = mPenColorDataList.size();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i4 = 0; i4 < size; i4++) {
            List<PenColorData> list2 = mPenColorDataList;
            sb.append(list2.get(i4).getDescription());
            sb.append(SQLKeyword.COMMA);
            sb2.append(Integer.toHexString(list2.get(i4).getColor()));
            sb2.append(SQLKeyword.COMMA);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str2 = TAG;
        sOLogger.SOLoggerD(str2, "updateColor# lDescription " + ((Object) sb));
        sOLogger.SOLoggerD(str2, "updateColor# lColor " + ((Object) sb2));
    }

    @NotNull
    public final PenColorData getSettingPenColorData(int index) {
        return mPenColorDataList.get(index);
    }

    public final int getSettingPenColorPaletteSize() {
        return settingPenColorPaletteSize;
    }

    @Nullable
    public final String getSettingPenDescription(int color) {
        int size = mPenColorDataList.size();
        for (int i = 0; i < size; i++) {
            PenColorData penColorData = mPenColorDataList.get(i);
            if (penColorData.getColor() == color) {
                return penColorData.getDescription();
            }
        }
        return "";
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isPreInitialized = true;
        initPenColorDataList(context);
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        mPenColorDataList.clear();
        mPenColorDescription.clear();
    }

    public final void updateColorPaletteOrder(int color) {
        AbstractC8014b.m7208j("updateColorPaletteOrder# ", Integer.toHexString(color), SOLogger.INSTANCE, TAG);
        int size = mPenColorDataList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Integer.toHexString(mPenColorDataList.get(i).getColor()));
            sb.append(SQLKeyword.COMMA);
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "updateColorPaletteOrder# lPenColorDataList before " + ((Object) sb));
        int i2 = settingPenColorPaletteSize;
        for (int i4 = 0; i4 < i2; i4++) {
            List<PenColorData> list = mPenColorDataList;
            PenColorData penColorData = list.get(0);
            if (penColorData.getColor() == color) {
                break;
            }
            list.remove(penColorData);
            list.add(penColorData);
        }
        sb.setLength(0);
        for (int i5 = 0; i5 < size; i5++) {
            sb.append(Integer.toHexString(mPenColorDataList.get(i5).getColor()));
            sb.append(SQLKeyword.COMMA);
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "updateColorPaletteOrder# lPenColorDataList after " + ((Object) sb));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int updatePairedPenColor(boolean initialize, int savedColor, int pairedColor, @Nullable String currentPairedCode, @Nullable String savedPairedCode, @NotNull List<String> pairedColorCodeList) {
        Intrinsics.checkNotNullParameter(pairedColorCodeList, "pairedColorCodeList");
        int i = savedColor | (-16777216);
        int i2 = pairedColor | (-16777216);
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strM1624n = AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(i & 16777215)}, 1, "format(...)");
        String strM1624n2 = AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf(i2 & 16777215)}, 1, "format(...)");
        String str2 = currentPairedCode == null ? "null" : currentPairedCode;
        String str3 = savedPairedCode != null ? savedPairedCode : "null";
        StringBuilder sb = new StringBuilder("updatePairedPenColor# initialize/savedColor/pairedColor/currentPairedCode/savedPairedCode : ");
        sb.append(initialize);
        sb.append("/");
        sb.append(strM1624n);
        sb.append("/");
        AbstractC2821a.m2207B(sb, strM1624n2, "/", str2, "/");
        sb.append(str3);
        sOLogger.SOLoggerD(str, sb.toString());
        if (PenPairedColorModel.PAIRED_COLOR_TYPE.PEN == PenPairedColorModel.INSTANCE.getPairedColorType() && initialize && !Intrinsics.areEqual(currentPairedCode, savedPairedCode) && pairedColorCodeList.contains(currentPairedCode)) {
            i = i2;
        }
        String str4 = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(i & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
        sOLogger.SOLoggerD(str, "updatePairedPenColor# savedColor : ".concat(str4));
        String str5 = currentPairedCode == null ? "" : currentPairedCode;
        switch (str5.hashCode()) {
            case 2098:
                if (!str5.equals("AS")) {
                    updateColor(4, i2);
                    AbstractC0000a.m24u("updatePairedPenColor# default code: ", currentPairedCode, sOLogger, str);
                } else {
                    updateColor(3, i2);
                    sOLogger.SOLoggerD(str, "updatePairedPenColor# Blue");
                }
                break;
            case 2129:
                if (!str5.equals("BS")) {
                }
                break;
            case 2415:
                if (str5.equals("KZ")) {
                    updateColor(4, i2);
                    sOLogger.SOLoggerD(str, "updatePairedPenColor# WHITE");
                    break;
                }
                break;
            case 2436:
                if (str5.equals("LP")) {
                    updateColor(1, i2);
                    sOLogger.SOLoggerD(str, "updatePairedPenColor# Orange");
                    break;
                }
                break;
            case 2558:
                if (!str5.equals("PN")) {
                }
                break;
            case 2660:
                if (!str5.equals("SW")) {
                }
                break;
            case 2749:
                if (!str5.equals("VS")) {
                }
                break;
            case 2780:
                if (!str5.equals("WS")) {
                }
                break;
            case 2825:
                if (!str5.equals("YB")) {
                }
                break;
            case 2849:
                if (str5.equals("YZ")) {
                    updateColor(0, i2);
                    sOLogger.SOLoggerD(str, "updatePairedPenColor# Yellow");
                    break;
                }
                break;
            case 2855:
                if (!str5.equals("ZA")) {
                }
                break;
            case 2856:
                if (!str5.equals("ZB")) {
                }
                break;
            case 2863:
                if (!str5.equals("ZI")) {
                }
                break;
            case 2865:
                if (!str5.equals("ZK")) {
                }
                break;
            case 2868:
                if (!str5.equals("ZN")) {
                }
                break;
            case 2872:
                if (!str5.equals("ZR")) {
                }
                break;
            case 2873:
                if (!str5.equals("ZS")) {
                }
                break;
            case 2877:
                if (!str5.equals("ZW")) {
                }
                break;
            case 67557:
                if (!str5.equals(Constants.PairedColorCode.DEFAULT)) {
                }
                break;
        }
        updateColorPaletteOrder(i);
        return i;
    }
}
