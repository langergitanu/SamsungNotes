package androidx.glance.appwidget.components;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.glance.appwidget.C2902R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nj\u0002\b\u0010j\u0002\b\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/appwidget/components/IconButtonShape;", "", VMetaDataKey.META_KEY_SHAPE, "", "cornerRadius", "ripple", "defaultSize", "Landroidx/compose/ui/unit/Dp;", "(Ljava/lang/String;IIIIF)V", "getCornerRadius", "()I", "getDefaultSize-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "getRipple", "getShape", "Square", "Circle", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nButtons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buttons.kt\nandroidx/glance/appwidget/components/IconButtonShape\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,470:1\n154#2:471\n154#2:472\n*S KotlinDebug\n*F\n+ 1 Buttons.kt\nandroidx/glance/appwidget/components/IconButtonShape\n*L\n355#1:471\n362#1:472\n*E\n"})
final class IconButtonShape {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IconButtonShape[] $VALUES;
    public static final IconButtonShape Circle;
    public static final IconButtonShape Square;
    private final int cornerRadius;
    private final float defaultSize;
    private final int ripple;
    private final int shape;

    private static final /* synthetic */ IconButtonShape[] $values() {
        return new IconButtonShape[]{Square, Circle};
    }

    static {
        Square = new IconButtonShape("Square", 0, C2902R.drawable.glance_component_btn_square, C2902R.dimen.glance_component_square_icon_button_corners, ButtonsKt.isAtLeastApi31() ? 0 : C2902R.drawable.glance_component_square_button_ripple, C2256Dp.m20968constructorimpl(60));
        Circle = new IconButtonShape("Circle", 1, C2902R.drawable.glance_component_btn_circle, C2902R.dimen.glance_component_circle_icon_button_corners, ButtonsKt.isAtLeastApi31() ? 0 : C2902R.drawable.glance_component_circle_button_ripple, C2256Dp.m20968constructorimpl(48));
        IconButtonShape[] iconButtonShapeArr$values = $values();
        $VALUES = iconButtonShapeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(iconButtonShapeArr$values);
    }

    private IconButtonShape(@DrawableRes String str, @DimenRes int i, @DrawableRes int i2, int i4, int i5, float f) {
        this.shape = i2;
        this.cornerRadius = i4;
        this.ripple = i5;
        this.defaultSize = f;
    }

    @NotNull
    public static EnumEntries<IconButtonShape> getEntries() {
        return $ENTRIES;
    }

    public static IconButtonShape valueOf(String str) {
        return (IconButtonShape) Enum.valueOf(IconButtonShape.class, str);
    }

    public static IconButtonShape[] values() {
        return (IconButtonShape[]) $VALUES.clone();
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX INFO: renamed from: getDefaultSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDefaultSize() {
        return this.defaultSize;
    }

    public final int getRipple() {
        return this.ripple;
    }

    public final int getShape() {
        return this.shape;
    }
}
