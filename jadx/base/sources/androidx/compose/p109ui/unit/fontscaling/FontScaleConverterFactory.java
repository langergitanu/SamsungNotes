package androidx.compose.p109ui.unit.fontscaling;

import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SparseArrayCompat;
import androidx.compose.p109ui.unit.InlineClassHelperKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\tH\u0007J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\tH\u0082\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\tH\u0007J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\rH\u0002J&\u0010$\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, m13886d2 = {"Landroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory;", "", "()V", "CommonFontSizes", "", "LookupTablesWriteLock", "", "[Ljava/lang/Object;", "MinScaleForNonLinear", "", "ScaleKeyMultiplier", "sLookupTables", "Landroidx/collection/SparseArrayCompat;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "getSLookupTables$annotations", "getSLookupTables", "()Landroidx/collection/SparseArrayCompat;", "setSLookupTables", "(Landroidx/collection/SparseArrayCompat;)V", "createInterpolatedTableBetween", "start", "end", "interpolationPoint", "forScale", "fontScale", "get", "scaleKey", "getKey", "", "getScaleFromKey", "key", "isNonLinearFontScalingActive", "", "put", "", "fontScaleConverter", "putInto", "table", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nFontScaleConverterFactory.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontScaleConverterFactory.android.kt\nandroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/unit/InlineClassHelperKt\n*L\n1#1,235:1\n54#2,7:236\n*S KotlinDebug\n*F\n+ 1 FontScaleConverterFactory.android.kt\nandroidx/compose/ui/unit/fontscaling/FontScaleConverterFactory\n*L\n99#1:236,7\n*E\n"})
public final class FontScaleConverterFactory {
    public static final int $stable;

    @NotNull
    private static final float[] CommonFontSizes;

    @NotNull
    public static final FontScaleConverterFactory INSTANCE;

    @NotNull
    private static final Object[] LookupTablesWriteLock;
    private static final float MinScaleForNonLinear = 1.03f;
    private static final float ScaleKeyMultiplier = 100.0f;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static volatile SparseArrayCompat<FontScaleConverter> sLookupTables;

    static {
        FontScaleConverterFactory fontScaleConverterFactory = new FontScaleConverterFactory();
        INSTANCE = fontScaleConverterFactory;
        CommonFontSizes = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        sLookupTables = new SparseArrayCompat<>(0, 1, null);
        Object[] objArr = new Object[0];
        LookupTablesWriteLock = objArr;
        synchronized (objArr) {
            fontScaleConverterFactory.putInto(sLookupTables, 1.15f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.3f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.5f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            fontScaleConverterFactory.putInto(sLookupTables, 1.8f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            fontScaleConverterFactory.putInto(sLookupTables, 2.0f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
            Unit unit = Unit.INSTANCE;
        }
        if (fontScaleConverterFactory.getScaleFromKey(sLookupTables.keyAt(0)) - 0.01f <= MinScaleForNonLinear) {
            InlineClassHelperKt.throwIllegalStateException("You should only apply non-linear scaling to font scales > 1");
        }
        $stable = 8;
    }

    private FontScaleConverterFactory() {
    }

    private final FontScaleConverter createInterpolatedTableBetween(FontScaleConverter start, FontScaleConverter end, float interpolationPoint) {
        float[] fArr = CommonFontSizes;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float f = CommonFontSizes[i];
            fArr2[i] = MathUtils.INSTANCE.lerp(start.convertSpToDp(f), end.convertSpToDp(f), interpolationPoint);
        }
        return new FontScaleConverterTable(CommonFontSizes, fArr2);
    }

    private final FontScaleConverter get(float scaleKey) {
        return sLookupTables.get(getKey(scaleKey));
    }

    private final int getKey(float fontScale) {
        return (int) (fontScale * 100.0f);
    }

    private final float getScaleFromKey(int key) {
        return key / 100.0f;
    }

    private final void put(float scaleKey, FontScaleConverter fontScaleConverter) {
        synchronized (LookupTablesWriteLock) {
            SparseArrayCompat<FontScaleConverter> sparseArrayCompatM15210clone = sLookupTables.m15210clone();
            INSTANCE.putInto(sparseArrayCompatM15210clone, scaleKey, fontScaleConverter);
            sLookupTables = sparseArrayCompatM15210clone;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void putInto(SparseArrayCompat<FontScaleConverter> table, float scaleKey, FontScaleConverter fontScaleConverter) {
        table.put(getKey(scaleKey), fontScaleConverter);
    }

    @AnyThread
    @Nullable
    public final FontScaleConverter forScale(float fontScale) {
        FontScaleConverter fontScaleConverterValueAt;
        if (!isNonLinearFontScalingActive(fontScale)) {
            return null;
        }
        FontScaleConverter fontScaleConverter = INSTANCE.get(fontScale);
        if (fontScaleConverter != null) {
            return fontScaleConverter;
        }
        int iIndexOfKey = sLookupTables.indexOfKey(getKey(fontScale));
        if (iIndexOfKey >= 0) {
            return sLookupTables.valueAt(iIndexOfKey);
        }
        int i = -(iIndexOfKey + 1);
        int i2 = i - 1;
        float scaleFromKey = 1.0f;
        if (i >= sLookupTables.size()) {
            FontScaleConverterTable fontScaleConverterTable = new FontScaleConverterTable(new float[]{1.0f}, new float[]{fontScale});
            put(fontScale, fontScaleConverterTable);
            return fontScaleConverterTable;
        }
        if (i2 < 0) {
            float[] fArr = CommonFontSizes;
            fontScaleConverterValueAt = new FontScaleConverterTable(fArr, fArr);
        } else {
            scaleFromKey = getScaleFromKey(sLookupTables.keyAt(i2));
            fontScaleConverterValueAt = sLookupTables.valueAt(i2);
        }
        FontScaleConverter fontScaleConverterCreateInterpolatedTableBetween = createInterpolatedTableBetween(fontScaleConverterValueAt, sLookupTables.valueAt(i), MathUtils.INSTANCE.constrainedMap(0.0f, 1.0f, scaleFromKey, getScaleFromKey(sLookupTables.keyAt(i)), fontScale));
        put(fontScale, fontScaleConverterCreateInterpolatedTableBetween);
        return fontScaleConverterCreateInterpolatedTableBetween;
    }

    @NotNull
    public final SparseArrayCompat<FontScaleConverter> getSLookupTables() {
        return sLookupTables;
    }

    @AnyThread
    public final boolean isNonLinearFontScalingActive(float fontScale) {
        return fontScale >= MinScaleForNonLinear;
    }

    public final void setSLookupTables(@NotNull SparseArrayCompat<FontScaleConverter> sparseArrayCompat) {
        sLookupTables = sparseArrayCompat;
    }

    @VisibleForTesting
    public static /* synthetic */ void getSLookupTables$annotations() {
    }
}
