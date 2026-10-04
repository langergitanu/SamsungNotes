package com.samsung.android.sdk.pen.setting.color;

import android.content.Context;
import android.content.res.Resources;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00142\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0018\u0010\u001b\u001a\u00020\u00142\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dJ\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\nX\u0082.¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0011\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mActiveTable", "", "", "mColorValueTables", "", "", "[[I", "mColorNameTables", "", "[[Ljava/lang/String;", "mVisibleColorValueTables", "mColorValueIdTables", "mColorNameIdTables", "value", "", "isInitComplete", "()Z", "close", "", "getValidTaleIDs", "tableIDs", "getColorTables", "tables", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "initColorTables", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorPaletteUtil {
    public static final int TABLE_LIST_SIZE = 23;
    public static final int TABLE_SIZE = 8;

    @NotNull
    private static final String TAG = "SpenColorSettingUtil";
    private boolean isInitComplete;
    private List<Integer> mActiveTable;
    private int[] mColorNameIdTables;
    private String[][] mColorNameTables;
    private int[] mColorValueIdTables;
    private int[][] mColorValueTables;
    private int[][] mVisibleColorValueTables;

    public SpenColorPaletteUtil(@Nullable Context context) {
        boolean zInitColorTables = initColorTables(context);
        this.isInitComplete = zInitColorTables;
        AbstractC4539a.m3208r("SpenColorSettingUtil() init=", TAG, zInitColorTables);
    }

    private final boolean initColorTables(Context context) {
        boolean z;
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        this.mActiveTable = new ArrayList(23);
        this.mColorValueIdTables = new int[24];
        this.mColorNameIdTables = new int[24];
        int[][] iArr = new int[24][];
        for (int i = 0; i < 24; i++) {
            iArr[i] = new int[0];
        }
        this.mColorValueTables = iArr;
        String[][] strArr = new String[24][];
        for (int i2 = 0; i2 < 24; i2++) {
            strArr[i2] = new String[0];
        }
        this.mColorNameTables = strArr;
        int[][] iArr2 = new int[24][];
        for (int i4 = 0; i4 < 24; i4++) {
            iArr2[i4] = new int[0];
        }
        this.mVisibleColorValueTables = iArr2;
        int identifier = 0;
        int identifier2 = 0;
        int i5 = 1;
        while (i5 <= 23) {
            try {
                identifier = resources.getIdentifier("spen_setting_swatch_" + i5, "array", packageName);
                identifier2 = resources.getIdentifier("spen_setting_swatch_name_" + i5, "array", packageName);
                int identifier3 = resources.getIdentifier("spen_setting_swatch_adaptive_" + i5, "array", packageName);
                if (identifier > 0) {
                    List<Integer> list = this.mActiveTable;
                    int[][] iArr3 = null;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActiveTable");
                        list = null;
                    }
                    ((ArrayList) list).add(Integer.valueOf(i5));
                    int[] iArr4 = this.mColorValueIdTables;
                    if (iArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mColorValueIdTables");
                        iArr4 = null;
                    }
                    int i6 = i5 - 1;
                    iArr4[i6] = identifier;
                    int[][] iArr5 = this.mColorValueTables;
                    if (iArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mColorValueTables");
                        iArr5 = null;
                    }
                    int[] intArray = resources.getIntArray(identifier);
                    Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
                    iArr5[i6] = intArray;
                    if (identifier2 > 0) {
                        int[] iArr6 = this.mColorNameIdTables;
                        if (iArr6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorNameIdTables");
                            iArr6 = null;
                        }
                        iArr6[i6] = identifier2;
                        String[][] strArr2 = this.mColorNameTables;
                        if (strArr2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorNameTables");
                            strArr2 = null;
                        }
                        String[] stringArray = resources.getStringArray(identifier2);
                        z = z2;
                        try {
                            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
                            strArr2[i6] = stringArray;
                        } catch (Exception unused) {
                            AbstractC0000a.m26w(AbstractC0622a.m1173s(i5, identifier, "initColorTables() [", "] colorId=", " nameId="), TAG, identifier2);
                            return z;
                        }
                    } else {
                        z = z2;
                        int[] iArr7 = this.mColorNameIdTables;
                        if (iArr7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorNameIdTables");
                            iArr7 = null;
                        }
                        iArr7[i6] = z ? 1 : 0;
                    }
                    if (identifier3 > 0) {
                        int[][] iArr8 = this.mVisibleColorValueTables;
                        if (iArr8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVisibleColorValueTables");
                        } else {
                            iArr3 = iArr8;
                        }
                        int[] intArray2 = resources.getIntArray(identifier3);
                        Intrinsics.checkNotNullExpressionValue(intArray2, "getIntArray(...)");
                        iArr3[i6] = intArray2;
                    } else {
                        int[][] iArr9 = this.mVisibleColorValueTables;
                        if (iArr9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVisibleColorValueTables");
                        } else {
                            iArr3 = iArr9;
                        }
                        int[] intArray3 = resources.getIntArray(identifier);
                        Intrinsics.checkNotNullExpressionValue(intArray3, "getIntArray(...)");
                        iArr3[i6] = intArray3;
                    }
                } else {
                    z = z2;
                }
                i5++;
                z2 = z;
            } catch (Exception unused2) {
                z = z2;
            }
        }
        return true;
    }

    public final void close() {
        this.isInitComplete = false;
        List<Integer> list = this.mActiveTable;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActiveTable");
            list = null;
        }
        list.clear();
        this.mColorNameTables = new String[0][];
        this.mColorValueTables = new int[0][];
        this.mVisibleColorValueTables = new int[0][];
    }

    public final boolean getColorTables(@Nullable List<SpenColorPaletteData> tables) {
        if (this.isInitComplete && tables != null) {
            ArrayList arrayList = new ArrayList();
            for (SpenColorPaletteData spenColorPaletteData : tables) {
                if (spenColorPaletteData != null) {
                    List<Integer> list = this.mActiveTable;
                    int[][] iArr = null;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActiveTable");
                        list = null;
                    }
                    int iIndexOf = list.indexOf(Integer.valueOf(spenColorPaletteData.index));
                    if (iIndexOf < 0) {
                        arrayList.add(spenColorPaletteData);
                    } else {
                        int[] iArr2 = this.mColorNameIdTables;
                        if (iArr2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorNameIdTables");
                            iArr2 = null;
                        }
                        spenColorPaletteData.nameId = iArr2[iIndexOf];
                        int[] iArr3 = this.mColorValueIdTables;
                        if (iArr3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorValueIdTables");
                            iArr3 = null;
                        }
                        spenColorPaletteData.valueId = iArr3[iIndexOf];
                        int[][] iArr4 = this.mColorValueTables;
                        if (iArr4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorValueTables");
                            iArr4 = null;
                        }
                        System.arraycopy(iArr4[iIndexOf], 0, spenColorPaletteData.values, 0, 8);
                        String[][] strArr = this.mColorNameTables;
                        if (strArr == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mColorNameTables");
                            strArr = null;
                        }
                        System.arraycopy(strArr[iIndexOf], 0, spenColorPaletteData.names, 0, 8);
                        int[][] iArr5 = this.mVisibleColorValueTables;
                        if (iArr5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVisibleColorValueTables");
                        } else {
                            iArr = iArr5;
                        }
                        System.arraycopy(iArr[iIndexOf], 0, spenColorPaletteData.themeValues, 0, 8);
                    }
                }
            }
            if (arrayList.size() > 0) {
                CollectionsKt.toMutableList((Collection) tables).removeAll(arrayList);
                return true;
            }
        }
        return false;
    }

    public final boolean getValidTaleIDs(@Nullable List<Integer> tableIDs) {
        if (!this.isInitComplete) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (tableIDs != null) {
            Iterator<Integer> it = tableIDs.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                List<Integer> list = this.mActiveTable;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActiveTable");
                    list = null;
                }
                if (list.indexOf(Integer.valueOf(iIntValue)) < 0) {
                    arrayList.add(Integer.valueOf(iIntValue));
                }
            }
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        if (tableIDs == null) {
            return true;
        }
        tableIDs.removeAll(arrayList);
        return true;
    }

    /* JADX INFO: renamed from: isInitComplete, reason: from getter */
    public final boolean getIsInitComplete() {
        return this.isInitComplete;
    }
}
