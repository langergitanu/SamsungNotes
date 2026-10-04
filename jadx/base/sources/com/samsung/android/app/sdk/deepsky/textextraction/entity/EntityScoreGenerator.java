package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import android.graphics.Point;
import android.graphics.Rect;
import com.samsung.android.app.sdk.deepsky.textextraction.util.EntityUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010\u0012\u001a\u00020\u0010*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0010*\u00020\u0006H\u0002¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityScoreGenerator;", "", "()V", "checkRect", "", "rect", "Landroid/graphics/Rect;", "measureEntityScore", "", "text", "", "entityType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "imageRect", "normalize", "value", "", "maxValue", "distance", "Landroid/graphics/Point;", "to", "maxDistance", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEntityScoreGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityScoreGenerator.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityScoreGenerator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n1#2:89\n*E\n"})
public final class EntityScoreGenerator {
    private static final float DISTANCE_SCORE_IGNORED = 0.0f;
    private static final float ENTITY_SCORE_CENTER_OF_IMAGE = 1.0f;
    private static final float ENTITY_SCORE_LOW = 0.7f;
    private static final float ENTITY_SCORE_NORMAL = 0.8f;
    private static final float RATIO_SCORE_DISTANCE = 0.1f;
    private static final float RATIO_SCORE_ENTITY = 0.9f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EntityType.values().length];
            try {
                iArr[EntityType.PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EntityType.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EntityType.URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void checkRect(Rect rect) {
        if (rect.width() < 1) {
            throw new IllegalArgumentException("width < 1");
        }
        if (rect.height() < 1) {
            throw new IllegalArgumentException("height < 1");
        }
        if (rect.left > rect.right) {
            throw new IllegalArgumentException("left > right");
        }
        if (rect.top > rect.bottom) {
            throw new IllegalArgumentException("top > bottom");
        }
    }

    private final double distance(Point point, Point point2) {
        return Math.sqrt(Math.pow(((double) point.y) - ((double) point2.y), 2.0d) + Math.pow(((double) point.x) - ((double) point2.x), 2.0d));
    }

    private final double maxDistance(Rect rect) {
        return Math.max(rect.width(), rect.height());
    }

    private final float normalize(double value, double maxValue) {
        return (float) (Math.abs(maxValue - value) / maxValue);
    }

    public final float measureEntityScore(@NotNull String text, @NotNull EntityType entityType, @NotNull Rect rect, @Nullable Rect imageRect) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(entityType, "entityType");
        Intrinsics.checkNotNullParameter(rect, "rect");
        float fNormalize = 0.0f;
        if (EntityUtils.INSTANCE.isDateTimeEntity(entityType)) {
            return 0.0f;
        }
        if (imageRect != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                checkRect(imageRect);
                objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            if (((Unit) objM22215constructorimpl) != null) {
                if (rect.contains(imageRect.centerX(), imageRect.centerY())) {
                    return 1.0f;
                }
                fNormalize = normalize(distance(new Point(imageRect.centerX(), imageRect.centerY()), new Point(rect.centerX(), rect.centerY())), maxDistance(imageRect));
            }
        }
        float f = 0.8f;
        if (WhenMappings.$EnumSwitchMapping$0[entityType.ordinal()] == 1 && text.length() <= 4) {
            f = 0.7f;
        }
        return (fNormalize * 0.1f) + (f * 0.9f);
    }
}
