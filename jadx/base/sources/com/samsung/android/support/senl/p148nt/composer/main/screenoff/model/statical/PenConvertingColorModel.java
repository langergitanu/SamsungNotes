package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.res.TypedArray;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR1\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenConvertingColorModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mConvertingColorSet", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "value", "", "isPreInitialized", "()Z", "init", "", "initConvertingColorSet", "convertingColorSet", "getConvertingColorSet", "()Ljava/util/HashMap;", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenConvertingColorModel {

    @NotNull
    public static final PenConvertingColorModel INSTANCE = new PenConvertingColorModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("PenConvertingColorModel");
    private static boolean isPreInitialized;

    @Nullable
    private static HashMap<Integer, Integer> mConvertingColorSet;

    private PenConvertingColorModel() {
    }

    private final void initConvertingColorSet() {
        Integer numValueOf;
        HashMap<Integer, Integer> map;
        HashMap<Integer, Integer> map2;
        mConvertingColorSet = new HashMap<>();
        TypedArrayCompat.Companion companion = TypedArrayCompat.INSTANCE;
        TypedArray typedArrayObtainTypedArray = companion.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_paired_color_set);
        TypedArray typedArrayObtainTypedArray2 = companion.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_saved_color_set);
        TypedArray typedArrayObtainTypedArray3 = companion.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_color_palette_set);
        TypedArray typedArrayObtainTypedArray4 = companion.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_saved_color_palette_set);
        if (typedArrayObtainTypedArray != null) {
            try {
                try {
                    numValueOf = Integer.valueOf(typedArrayObtainTypedArray.length());
                } catch (Exception e) {
                    SOLogger.INSTANCE.SOLoggerE(TAG, "initConvertingColorSet# exception " + e.getMessage());
                    HashMap<Integer, Integer> map3 = mConvertingColorSet;
                    if (map3 != null) {
                        map3.clear();
                    }
                    if (typedArrayObtainTypedArray != null) {
                        typedArrayObtainTypedArray.recycle();
                    }
                    if (typedArrayObtainTypedArray2 != null) {
                        typedArrayObtainTypedArray2.recycle();
                    }
                    if (typedArrayObtainTypedArray3 != null) {
                        typedArrayObtainTypedArray3.recycle();
                    }
                    if (typedArrayObtainTypedArray4 != null) {
                        typedArrayObtainTypedArray4.recycle();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
                if (typedArrayObtainTypedArray2 != null) {
                    typedArrayObtainTypedArray2.recycle();
                }
                if (typedArrayObtainTypedArray3 != null) {
                    typedArrayObtainTypedArray3.recycle();
                }
                if (typedArrayObtainTypedArray4 != null) {
                    typedArrayObtainTypedArray4.recycle();
                }
                throw th;
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            Integer numValueOf2 = null;
            Integer numValueOf3 = null;
            for (int i = 0; i < iIntValue; i++) {
                if (typedArrayObtainTypedArray != null) {
                    numValueOf2 = Integer.valueOf(typedArrayObtainTypedArray.getColor(i, 0));
                }
                if (typedArrayObtainTypedArray2 != null) {
                    numValueOf3 = Integer.valueOf(typedArrayObtainTypedArray2.getColor(i, 0));
                }
                if (numValueOf2 != null && numValueOf3 != null && (map2 = mConvertingColorSet) != null) {
                    map2.put(numValueOf2, numValueOf2);
                }
            }
        }
        Integer numValueOf4 = typedArrayObtainTypedArray3 != null ? Integer.valueOf(typedArrayObtainTypedArray3.length()) : null;
        if (numValueOf4 != null) {
            int iIntValue2 = numValueOf4.intValue();
            for (int i2 = 0; i2 < iIntValue2; i2++) {
                Integer numValueOf5 = typedArrayObtainTypedArray3 != null ? Integer.valueOf(typedArrayObtainTypedArray3.getColor(i2, 0)) : null;
                Integer numValueOf6 = typedArrayObtainTypedArray4 != null ? Integer.valueOf(typedArrayObtainTypedArray4.getColor(i2, 0)) : null;
                if (numValueOf5 != null && numValueOf6 != null && (map = mConvertingColorSet) != null) {
                    map.put(numValueOf5, numValueOf6);
                }
            }
        }
        if (typedArrayObtainTypedArray != null) {
            typedArrayObtainTypedArray.recycle();
        }
        if (typedArrayObtainTypedArray2 != null) {
            typedArrayObtainTypedArray2.recycle();
        }
        if (typedArrayObtainTypedArray3 != null) {
            typedArrayObtainTypedArray3.recycle();
        }
        if (typedArrayObtainTypedArray4 != null) {
            typedArrayObtainTypedArray4.recycle();
        }
    }

    @Nullable
    public final HashMap<Integer, Integer> getConvertingColorSet() {
        if (mConvertingColorSet == null) {
            initConvertingColorSet();
        }
        return mConvertingColorSet;
    }

    public final void init() {
        isPreInitialized = true;
        initConvertingColorSet();
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        HashMap<Integer, Integer> map = mConvertingColorSet;
        if (map != null) {
            map.clear();
        }
        mConvertingColorSet = null;
    }
}
