package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\bX\u0082\u000e¢\u0006\u0002\n\u0000Rf\u0010\r\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2*\u0010\t\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenPairedColorModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mPairedColorCodeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "pairedColorSet", "getPairedColorSet", "()Ljava/util/HashMap;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenPairedColorModel$PAIRED_COLOR_TYPE;", "pairedColorType", "getPairedColorType", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenPairedColorModel$PAIRED_COLOR_TYPE;", "", "isPreInitialized", "()Z", "init", "", "context", "Landroid/content/Context;", "initPairedColorType", "initPairedColorCodeList", "initPairedColorSet", "pairedColorCodeList", "", "getPairedColorCodeList", "()Ljava/util/List;", "release", "PAIRED_COLOR_TYPE", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenPairedColorModel {
    private static boolean isPreInitialized;

    @Nullable
    private static HashMap<String, Integer> pairedColorSet;

    @NotNull
    public static final PenPairedColorModel INSTANCE = new PenPairedColorModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("PenPairedColorModel");

    @NotNull
    private static ArrayList<String> mPairedColorCodeList = new ArrayList<>();

    @NotNull
    private static PAIRED_COLOR_TYPE pairedColorType = PAIRED_COLOR_TYPE.PEN;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenPairedColorModel$PAIRED_COLOR_TYPE;", "", "<init>", "(Ljava/lang/String;I)V", "PEN", "DEVICE_COLOR", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PAIRED_COLOR_TYPE {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PAIRED_COLOR_TYPE[] $VALUES;
        public static final PAIRED_COLOR_TYPE PEN = new PAIRED_COLOR_TYPE("PEN", 0);
        public static final PAIRED_COLOR_TYPE DEVICE_COLOR = new PAIRED_COLOR_TYPE("DEVICE_COLOR", 1);

        private static final /* synthetic */ PAIRED_COLOR_TYPE[] $values() {
            return new PAIRED_COLOR_TYPE[]{PEN, DEVICE_COLOR};
        }

        static {
            PAIRED_COLOR_TYPE[] paired_color_typeArr$values = $values();
            $VALUES = paired_color_typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(paired_color_typeArr$values);
        }

        private PAIRED_COLOR_TYPE(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PAIRED_COLOR_TYPE> getEntries() {
            return $ENTRIES;
        }

        public static PAIRED_COLOR_TYPE valueOf(String str) {
            return (PAIRED_COLOR_TYPE) Enum.valueOf(PAIRED_COLOR_TYPE.class, str);
        }

        public static PAIRED_COLOR_TYPE[] values() {
            return (PAIRED_COLOR_TYPE[]) $VALUES.clone();
        }
    }

    private PenPairedColorModel() {
    }

    private final void initPairedColorCodeList() {
        Integer numValueOf;
        TypedArray typedArrayObtainTypedArray = TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_signature_color_name_list);
        if (typedArrayObtainTypedArray != null) {
            try {
                try {
                    numValueOf = Integer.valueOf(typedArrayObtainTypedArray.length());
                } catch (Exception unused) {
                    SOLogger.INSTANCE.SOLoggerE(TAG, "initPairedColorCodeList# exception");
                    mPairedColorCodeList.clear();
                    if (typedArrayObtainTypedArray != null) {
                        typedArrayObtainTypedArray.recycle();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
                throw th;
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            for (int i = 0; i < iIntValue; i++) {
                mPairedColorCodeList.add(typedArrayObtainTypedArray.getString(i));
            }
        }
        if (typedArrayObtainTypedArray != null) {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private final void initPairedColorSet() {
        pairedColorSet = new HashMap<>();
        TypedArray typedArrayObtainTypedArray = TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.screenoff_pen_paired_color_set);
        try {
            try {
                int size = mPairedColorCodeList.size();
                for (int i = 0; i < size; i++) {
                    String str = mPairedColorCodeList.get(i);
                    Integer numValueOf = typedArrayObtainTypedArray != null ? Integer.valueOf(typedArrayObtainTypedArray.getColor(i, 0)) : null;
                    Intrinsics.checkNotNull(numValueOf);
                    numValueOf.intValue();
                    HashMap<String, Integer> map = pairedColorSet;
                    if (map != null) {
                        map.put(str, numValueOf);
                    }
                }
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
            } catch (Exception unused) {
                SOLogger.INSTANCE.SOLoggerE(TAG, "initPairedColorData# exception");
                HashMap<String, Integer> map2 = pairedColorSet;
                if (map2 != null) {
                    map2.clear();
                }
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
            }
        } catch (Throwable th) {
            if (typedArrayObtainTypedArray != null) {
                typedArrayObtainTypedArray.recycle();
            }
            throw th;
        }
    }

    private final void initPairedColorType(Context context) {
        String[] stringArray = context.getResources().getStringArray(C9086R.array.screenoff_model_feature_pen_paired_color_type_device_color);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        int length = stringArray.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = stringArray[i];
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            Intrinsics.checkNotNull(str);
            if (StringsKt.m14162r(MODEL, str)) {
                pairedColorType = PAIRED_COLOR_TYPE.DEVICE_COLOR;
                break;
            }
            i++;
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPairedColorType# model/pairedColorType : " + Build.MODEL + "/" + pairedColorType);
    }

    @NotNull
    public final List<String> getPairedColorCodeList() {
        return mPairedColorCodeList;
    }

    @Nullable
    public final HashMap<String, Integer> getPairedColorSet() {
        return pairedColorSet;
    }

    @NotNull
    public final PAIRED_COLOR_TYPE getPairedColorType() {
        return pairedColorType;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isPreInitialized = true;
        initPairedColorType(context);
        initPairedColorCodeList();
        initPairedColorSet();
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        mPairedColorCodeList.clear();
        HashMap<String, Integer> map = pairedColorSet;
        if (map != null) {
            map.clear();
        }
        pairedColorSet = null;
    }
}
