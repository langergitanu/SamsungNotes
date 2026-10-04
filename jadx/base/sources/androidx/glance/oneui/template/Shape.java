package androidx.glance.oneui.template;

import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/oneui/template/Shape;", "", "resId", "", "topLeftRadius", "topRightRadius", "bottomRightRadius", "bottomLeftRadius", "(Ljava/lang/String;IIIIII)V", "getBottomLeftRadius$glance_oneui_template_release", "()I", "getBottomRightRadius$glance_oneui_template_release", "getResId$glance_oneui_template_release", "getTopLeftRadius$glance_oneui_template_release", "getTopRightRadius$glance_oneui_template_release", "toString", "", "None", "LeftLeaf", "RightLeaf", "LeftSpeechBalloon", "RightSpeechBalloon", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class Shape {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Shape[] $VALUES;
    private final int bottomLeftRadius;
    private final int bottomRightRadius;
    private final int resId;
    private final int topLeftRadius;
    private final int topRightRadius;
    public static final Shape None = new Shape("None", 0, 0, 0, 0, 0, 0, 30, null);
    public static final Shape LeftLeaf = new Shape("LeftLeaf", 1, C3094R.drawable.sesl_shape_background_left_leaf, C3094R.dimen.sesl_glance_shape_left_leaf_corner_radius_top_left, C3094R.dimen.sesl_glance_shape_left_leaf_corner_radius_top_right, C3094R.dimen.sesl_glance_shape_left_leaf_corner_radius_bottom_right, C3094R.dimen.sesl_glance_shape_left_leaf_corner_radius_bottom_left);
    public static final Shape RightLeaf = new Shape("RightLeaf", 2, C3094R.drawable.sesl_shape_background_right_leaf, C3094R.dimen.sesl_glance_shape_right_leaf_corner_radius_top_left, C3094R.dimen.sesl_glance_shape_right_leaf_corner_radius_top_right, C3094R.dimen.sesl_glance_shape_right_leaf_corner_radius_bottom_right, C3094R.dimen.sesl_glance_shape_right_leaf_corner_radius_bottom_left);
    public static final Shape LeftSpeechBalloon = new Shape("LeftSpeechBalloon", 3, C3094R.drawable.sesl_shape_background_left_speech_balloon, C3094R.dimen.sesl_glance_shape_left_speech_balloon_corner_radius_top_left, C3094R.dimen.sesl_glance_shape_left_speech_balloon_corner_radius_top_right, C3094R.dimen.sesl_glance_shape_left_speech_balloon_corner_radius_bottom_right, C3094R.dimen.sesl_glance_shape_left_speech_balloon_corner_radius_bottom_left);
    public static final Shape RightSpeechBalloon = new Shape("RightSpeechBalloon", 4, C3094R.drawable.sesl_shape_background_right_speech_balloon, C3094R.dimen.sesl_glance_shape_right_speech_balloon_corner_radius_top_left, C3094R.dimen.sesl_glance_shape_right_speech_balloon_corner_radius_top_right, C3094R.dimen.f1605x45700580, C3094R.dimen.sesl_glance_shape_right_speech_balloon_corner_radius_bottom_left);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shape.values().length];
            try {
                iArr[Shape.LeftLeaf.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shape.RightLeaf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shape.LeftSpeechBalloon.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Shape.RightSpeechBalloon.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Shape[] $values() {
        return new Shape[]{None, LeftLeaf, RightLeaf, LeftSpeechBalloon, RightSpeechBalloon};
    }

    static {
        Shape[] shapeArr$values = $values();
        $VALUES = shapeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shapeArr$values);
    }

    private Shape(@DrawableRes String str, @DimenRes int i, @DimenRes int i2, @DimenRes int i4, @DimenRes int i5, int i6, int i7) {
        this.resId = i2;
        this.topLeftRadius = i4;
        this.topRightRadius = i5;
        this.bottomRightRadius = i6;
        this.bottomLeftRadius = i7;
    }

    @NotNull
    public static EnumEntries<Shape> getEntries() {
        return $ENTRIES;
    }

    public static Shape valueOf(String str) {
        return (Shape) Enum.valueOf(Shape.class, str);
    }

    public static Shape[] values() {
        return (Shape[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getBottomLeftRadius$glance_oneui_template_release, reason: from getter */
    public final int getBottomLeftRadius() {
        return this.bottomLeftRadius;
    }

    /* JADX INFO: renamed from: getBottomRightRadius$glance_oneui_template_release, reason: from getter */
    public final int getBottomRightRadius() {
        return this.bottomRightRadius;
    }

    /* JADX INFO: renamed from: getResId$glance_oneui_template_release, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: getTopLeftRadius$glance_oneui_template_release, reason: from getter */
    public final int getTopLeftRadius() {
        return this.topLeftRadius;
    }

    /* JADX INFO: renamed from: getTopRightRadius$glance_oneui_template_release, reason: from getter */
    public final int getTopRightRadius() {
        return this.topRightRadius;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "none" : "rightspeechballoon" : "leftspeechballoon" : "rightleaf" : "leftleaf";
    }

    public /* synthetic */ Shape(String str, int i, int i2, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i8 & 2) != 0 ? 0 : i4, (i8 & 4) != 0 ? 0 : i5, (i8 & 8) != 0 ? 0 : i6, (i8 & 16) != 0 ? 0 : i7);
    }
}
