package androidx.glance.oneui.template.layout;

import android.content.Context;
import androidx.annotation.DimenRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.template.utils.ResourceUtilsKt;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.TextPercentData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eB5\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012B?\b\u0002\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0013R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/TextSize;", "", "context", "Landroid/content/Context;", "sizeResId", "", BilouCodec.UNIT, "Landroidx/glance/text/ComplexUnit;", "fontWeight", "Landroidx/glance/text/FontWeight;", "maxFontScale", "", "(Landroid/content/Context;ILandroidx/glance/text/ComplexUnit;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "size", "(FLandroidx/glance/text/ComplexUnit;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "percentData", "Landroidx/glance/text/TextPercentData;", "(FLandroidx/glance/text/ComplexUnit;IFLandroidx/glance/text/TextPercentData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ILandroidx/glance/text/TextPercentData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IFLandroidx/glance/text/ComplexUnit;IFLandroidx/glance/text/TextPercentData;)V", "getFontWeight-WjrlUT0", "()I", "I", "getMaxFontScale", "()F", "getPercentData", "()Landroidx/glance/text/TextPercentData;", "getSize", "getSizeResId", "getUnit", "()Landroidx/glance/text/ComplexUnit;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextSize {
    public static final int $stable = TextPercentData.$stable;
    private final int fontWeight;
    private final float maxFontScale;

    @Nullable
    private final TextPercentData percentData;
    private final float size;
    private final int sizeResId;

    @NotNull
    private final ComplexUnit unit;

    public /* synthetic */ TextSize(float f, ComplexUnit complexUnit, int i, float f4, TextPercentData textPercentData, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, complexUnit, i, f4, textPercentData);
    }

    /* JADX INFO: renamed from: getFontWeight-WjrlUT0, reason: not valid java name and from getter */
    public final int getFontWeight() {
        return this.fontWeight;
    }

    public final float getMaxFontScale() {
        return this.maxFontScale;
    }

    @Nullable
    public final TextPercentData getPercentData() {
        return this.percentData;
    }

    public final float getSize() {
        return this.size;
    }

    public final int getSizeResId() {
        return this.sizeResId;
    }

    @NotNull
    public final ComplexUnit getUnit() {
        return this.unit;
    }

    public /* synthetic */ TextSize(float f, ComplexUnit complexUnit, int i, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, complexUnit, i, f4);
    }

    public /* synthetic */ TextSize(int i, TextPercentData textPercentData, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, textPercentData);
    }

    public /* synthetic */ TextSize(Context context, @DimenRes int i, ComplexUnit complexUnit, int i2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, complexUnit, i2, f);
    }

    private TextSize(@DimenRes int i, float f, ComplexUnit complexUnit, int i2, float f4, TextPercentData textPercentData) {
        this.sizeResId = i;
        this.size = f;
        this.unit = complexUnit;
        this.fontWeight = i2;
        this.maxFontScale = f4;
        this.percentData = textPercentData;
    }

    public /* synthetic */ TextSize(int i, float f, ComplexUnit complexUnit, int i2, float f4, TextPercentData textPercentData, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, f, complexUnit, i2, (i4 & 16) != 0 ? 0.0f : f4, (i4 & 32) != 0 ? null : textPercentData);
    }

    public /* synthetic */ TextSize(Context context, int i, ComplexUnit complexUnit, int i2, float f, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, complexUnit, i2, (i4 & 16) != 0 ? 0.0f : f, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextSize(Context context, int i, ComplexUnit unit, int i2, float f) {
        this(0, ResourceUtilsKt.getFloat(context, i), unit, i2, f, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unit, "unit");
    }

    public /* synthetic */ TextSize(float f, ComplexUnit complexUnit, int i, float f4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, complexUnit, i, (i2 & 8) != 0 ? 0.0f : f4, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextSize(float f, ComplexUnit unit, int i, float f4) {
        this(0, f, unit, i, f4, null, 32, null);
        Intrinsics.checkNotNullParameter(unit, "unit");
    }

    public /* synthetic */ TextSize(float f, ComplexUnit complexUnit, int i, float f4, TextPercentData textPercentData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, complexUnit, i, (i2 & 8) != 0 ? 0.0f : f4, (i2 & 16) != 0 ? null : textPercentData, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextSize(float f, ComplexUnit unit, int i, float f4, TextPercentData textPercentData) {
        this(0, f, unit, i, f4, textPercentData);
        Intrinsics.checkNotNullParameter(unit, "unit");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private TextSize(int i, TextPercentData percentData) {
        this(0, 0.0f, ComplexUnit.f1613DP, i, 0.0f, percentData);
        Intrinsics.checkNotNullParameter(percentData, "percentData");
    }
}
