package com.samsung.android.sesl.visualeffect.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.animation.PathInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0014¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/DomainColorUtil;", "", "<init>", "()V", "calibrateByLightness", "", "color", "interpolator", "Landroid/view/animation/PathInterpolator;", "downscaledBitmap", "Landroid/graphics/Bitmap;", "bitmap", "threshold", "convertColorPalette", "palette", "Lcom/samsung/android/sesl/visualeffect/utils/DomainColorUtil$ColorPalette;", "extract", "extractAsync", "", "onFinished", "Lkotlin/Function1;", "ColorPalette", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDomainColorUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DomainColorUtil.kt\ncom/samsung/android/sesl/visualeffect/utils/DomainColorUtil\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,97:1\n52#2:98\n1062#3:99\n470#4:100\n*S KotlinDebug\n*F\n+ 1 DomainColorUtil.kt\ncom/samsung/android/sesl/visualeffect/utils/DomainColorUtil\n*L\n80#1:98\n85#1:99\n86#1:100\n*E\n"})
public final class DomainColorUtil {

    @NotNull
    public static final DomainColorUtil INSTANCE = new DomainColorUtil();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003`\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/utils/DomainColorUtil$ColorPalette;", "", "divider", "", "<init>", "(Ljava/lang/String;II)V", "getDivider", "()I", "Palette64", "Palette512", "createCountMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ColorPalette {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ColorPalette[] $VALUES;
        private final int divider;
        public static final ColorPalette Palette64 = new ColorPalette("Palette64", 0, (int) Math.ceil(63.75d));
        public static final ColorPalette Palette512 = new ColorPalette("Palette512", 1, (int) Math.ceil(31.875d));

        private static final /* synthetic */ ColorPalette[] $values() {
            return new ColorPalette[]{Palette64, Palette512};
        }

        static {
            ColorPalette[] colorPaletteArr$values = $values();
            $VALUES = colorPaletteArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(colorPaletteArr$values);
        }

        private ColorPalette(String str, int i, int i2) {
            this.divider = i2;
        }

        @NotNull
        public static EnumEntries<ColorPalette> getEntries() {
            return $ENTRIES;
        }

        public static ColorPalette valueOf(String str) {
            return (ColorPalette) Enum.valueOf(ColorPalette.class, str);
        }

        public static ColorPalette[] values() {
            return (ColorPalette[]) $VALUES.clone();
        }

        @NotNull
        public final HashMap<String, Integer> createCountMap() {
            return new HashMap<>();
        }

        public final int getDivider() {
            return this.divider;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.utils.DomainColorUtil$extractAsync$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.sesl.visualeffect.utils.DomainColorUtil$extractAsync$1", m14021f = "DomainColorUtil.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C78981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Function1<Integer, Unit> $onFinished;
        final /* synthetic */ ColorPalette $palette;
        int label;

        /* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.utils.DomainColorUtil$extractAsync$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.sesl.visualeffect.utils.DomainColorUtil$extractAsync$1$1", m14021f = "DomainColorUtil.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $color;
            final /* synthetic */ Function1<Integer, Unit> $onFinished;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function1<? super Integer, Unit> function1, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onFinished = function1;
                this.$color = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$onFinished, this.$color, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$onFinished.invoke(Boxing.boxInt(this.$color));
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C78981(Bitmap bitmap, ColorPalette colorPalette, Function1<? super Integer, Unit> function1, Continuation<? super C78981> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.$palette = colorPalette;
            this.$onFinished = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C78981(this.$bitmap, this.$palette, this.$onFinished, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this.$onFinished, DomainColorUtil.INSTANCE.extract(this.$bitmap, this.$palette), null), 3, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C78981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private DomainColorUtil() {
    }

    public static /* synthetic */ int calibrateByLightness$default(DomainColorUtil domainColorUtil, int i, PathInterpolator pathInterpolator, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pathInterpolator = new PathInterpolator(0.8f, 0.0f, 0.45f, 0.45f);
        }
        return domainColorUtil.calibrateByLightness(i, pathInterpolator);
    }

    private final int convertColorPalette(@ColorInt int color, ColorPalette palette) {
        Color colorValueOf = Color.valueOf(color);
        int divider = palette.getDivider();
        float f = divider;
        return Color.argb(RangesKt.coerceAtMost(MathKt.roundToInt((colorValueOf.alpha() * 255.0f) / f) * divider, 255), RangesKt.coerceAtMost(MathKt.roundToInt((colorValueOf.red() * 255.0f) / f) * divider, 255), RangesKt.coerceAtMost(MathKt.roundToInt((colorValueOf.green() * 255.0f) / f) * divider, 255), RangesKt.coerceAtMost(MathKt.roundToInt((colorValueOf.blue() * 255.0f) / f) * divider, 255));
    }

    private final Bitmap downscaledBitmap(Bitmap bitmap, int threshold) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        while (width * height > threshold) {
            width /= 2;
            height /= 2;
        }
        if (width == bitmap.getWidth() && height == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap downscaledBitmap$default(DomainColorUtil domainColorUtil, Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 40000;
        }
        return domainColorUtil.downscaledBitmap(bitmap, i);
    }

    @ColorInt
    public final int calibrateByLightness(@ColorInt int color, @NotNull PathInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Color colorValueOf = Color.valueOf(color);
        float fAlpha = colorValueOf.alpha();
        float fRed = colorValueOf.red() * fAlpha;
        float fGreen = colorValueOf.green() * fAlpha;
        float fBlue = colorValueOf.blue() * fAlpha;
        float f = fBlue * fBlue;
        float fSqrt = ((float) Math.sqrt(f + ((fGreen * fGreen) + (fRed * fRed)))) / ((float) Math.sqrt(3.0d));
        float interpolation = interpolator.getInterpolation(fSqrt) / fSqrt;
        return Color.valueOf(colorValueOf.red() * interpolation, colorValueOf.green() * interpolation, colorValueOf.blue() * interpolation, fAlpha).toArgb();
    }

    public final int extract(@NotNull Bitmap bitmap, @NotNull ColorPalette palette) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(palette, "palette");
        Bitmap bitmapDownscaledBitmap$default = downscaledBitmap$default(this, bitmap, 0, 2, null);
        HashMap<String, Integer> mapCreateCountMap = palette.createCountMap();
        int width = bitmapDownscaledBitmap$default.getWidth();
        for (int i = 0; i < width; i++) {
            int height = bitmapDownscaledBitmap$default.getHeight();
            for (int i2 = 0; i2 < height; i2++) {
                String hexString = ColorUtil.INSTANCE.toHexString(convertColorPalette(bitmapDownscaledBitmap$default.getPixel(i, i2), palette));
                mapCreateCountMap.put(hexString, Integer.valueOf(mapCreateCountMap.getOrDefault(hexString, 0).intValue() + 1));
            }
        }
        return Color.parseColor((String) ((Map.Entry) MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(mapCreateCountMap), new Comparator() { // from class: com.samsung.android.sesl.visualeffect.utils.DomainColorUtil$extract$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) ((Pair) t2).getSecond(), (Integer) ((Pair) t).getSecond());
            }
        })).entrySet().iterator().next()).getKey());
    }

    public final void extractAsync(@NotNull Bitmap bitmap, @NotNull ColorPalette palette, @NotNull Function1<? super Integer, Unit> onFinished) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(palette, "palette");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C78981(bitmap, palette, onFinished, null), 3, null);
    }
}
