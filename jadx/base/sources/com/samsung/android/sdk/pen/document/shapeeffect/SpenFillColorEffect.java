package com.samsung.android.sdk.pen.document.shapeeffect;

import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 52\u00020\u0001:\u0003345B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(J\u0012\u0010)\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005J\b\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(J\b\u00101\u001a\u00020\u0005H\u0002J\u000e\u00102\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010\b¨\u00066"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect;", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "<init>", "()V", "type", "", "colorType", "getColorType", "()I", "setColorType", "(I)V", "solidColor", "getSolidColor", "setSolidColor", "gradientType", "getGradientType", "setGradientType", "linearGradientAngle", "getLinearGradientAngle", "setLinearGradientAngle", "gradientPosition", "Landroid/graphics/PointF;", "getGradientPosition", "()Landroid/graphics/PointF;", "setGradientPosition", "(Landroid/graphics/PointF;)V", "isGradientRotatable", "", "()Z", "setGradientRotatable", "(Z)V", "currentId", "colorList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientContainer;", "Lkotlin/collections/ArrayList;", "setGradientColor", "", "id", "gradientColor", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientColor;", "getContainer", "getGradientColor", "getGradientColorId", "index", "gradientColorCount", "getGradientColorCount", "resetGradientColor", "appendGradientColor", "newId", "removeGradientColor", "GradientContainer", "GradientColor", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFillColorEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFillColorEffect.kt\ncom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,329:1\n1#2:330\n*E\n"})
public final class SpenFillColorEffect extends SpenFillEffectBase {
    public static final int COLOR_GRADIENT = 1;
    public static final int COLOR_SOLID = 0;
    public static final int GRADIENT_LINEAR = 0;
    public static final int GRADIENT_PATH = 3;
    public static final int GRADIENT_RADIAL = 1;
    public static final int GRADIENT_RECTANGULAR = 2;

    @NotNull
    private final ArrayList<GradientContainer> colorList;
    private int colorType;
    private int currentId;

    @Nullable
    private PointF gradientPosition;
    private int gradientType;
    private boolean isGradientRotatable;
    private int linearGradientAngle;

    @ColorInt
    private int solidColor;

    @NotNull
    private static final SpenFillColorEffect$Companion$comparator$1 comparator = new Comparator<GradientContainer>() { // from class: com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect$Companion$comparator$1
        @Override // java.util.Comparator
        public int compare(SpenFillColorEffect.GradientContainer o12, SpenFillColorEffect.GradientContainer o22) {
            Intrinsics.checkNotNullParameter(o12, "o1");
            Intrinsics.checkNotNullParameter(o22, "o2");
            SpenFillColorEffect.GradientColor color = o12.getColor();
            Intrinsics.checkNotNull(color);
            float f = color.position;
            SpenFillColorEffect.GradientColor color2 = o22.getColor();
            Intrinsics.checkNotNull(color2);
            if (f > color2.position) {
                return 1;
            }
            SpenFillColorEffect.GradientColor color3 = o12.getColor();
            Intrinsics.checkNotNull(color3);
            float f4 = color3.position;
            SpenFillColorEffect.GradientColor color4 = o22.getColor();
            Intrinsics.checkNotNull(color4);
            return f4 == color4.position ? 0 : -1;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientColor;", "", "<init>", "()V", "color", "", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class GradientColor {

        @ColorInt
        @JvmField
        public int color = -16777216;

        @JvmField
        public float position = 1.0f;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientContainer;", "", "<init>", "()V", "id", "", "getId", "()I", "setId", "(I)V", "color", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientColor;", "getColor", "()Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientColor;", "setColor", "(Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillColorEffect$GradientColor;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class GradientContainer {

        @Nullable
        private GradientColor color;
        private int id;

        @Nullable
        public final GradientColor getColor() {
            return this.color;
        }

        public final int getId() {
            return this.id;
        }

        public final void setColor(@Nullable GradientColor gradientColor) {
            this.color = gradientColor;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    public SpenFillColorEffect() {
        super(1);
        this.colorList = new ArrayList<>();
        resetGradientColor();
        GradientColor gradientColor = new GradientColor();
        gradientColor.color = -16776961;
        gradientColor.position = 0.0f;
        appendGradientColor(gradientColor);
        gradientColor.color = -1;
        gradientColor.position = 1.0f;
        appendGradientColor(gradientColor);
    }

    private final GradientContainer getContainer(int id) {
        Iterator<GradientContainer> it = this.colorList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            GradientContainer next = it.next();
            if (next.getId() == id) {
                return next;
            }
        }
        return null;
    }

    private final int newId() {
        if (this.currentId == Integer.MAX_VALUE) {
            this.currentId = 0;
        }
        int i = this.currentId + 1;
        this.currentId = i;
        return i;
    }

    private final void resetGradientColor() {
        this.colorList.clear();
    }

    public final int appendGradientColor(@Nullable GradientColor gradientColor) {
        if (this.colorList.size() >= 10) {
            throw new IllegalStateException("E_INVALID_STATE : Maximum count of gradient colors is 10");
        }
        if (gradientColor == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        GradientContainer gradientContainer = new GradientContainer();
        gradientContainer.setId(newId());
        gradientContainer.setColor(new GradientColor());
        GradientColor color = gradientContainer.getColor();
        Intrinsics.checkNotNull(color);
        color.color = gradientColor.color;
        GradientColor color2 = gradientContainer.getColor();
        Intrinsics.checkNotNull(color2);
        color2.position = gradientColor.position;
        this.colorList.add(gradientContainer);
        Collections.sort(this.colorList, comparator);
        return gradientContainer.getId();
    }

    public final int getColorType() {
        return this.colorType;
    }

    @Nullable
    public final GradientColor getGradientColor(int id) {
        GradientContainer container = getContainer(id);
        if (container != null) {
            return container.getColor();
        }
        throw new IllegalArgumentException("id does not exist");
    }

    public final int getGradientColorCount() {
        return this.colorList.size();
    }

    public final int getGradientColorId(int index) {
        GradientContainer gradientContainer = this.colorList.get(index);
        Intrinsics.checkNotNullExpressionValue(gradientContainer, "get(...)");
        return gradientContainer.getId();
    }

    @Nullable
    public final PointF getGradientPosition() {
        return this.gradientPosition;
    }

    public final int getGradientType() {
        return this.gradientType;
    }

    public final int getLinearGradientAngle() {
        return this.linearGradientAngle;
    }

    public final int getSolidColor() {
        return this.solidColor;
    }

    /* JADX INFO: renamed from: isGradientRotatable, reason: from getter */
    public final boolean getIsGradientRotatable() {
        return this.isGradientRotatable;
    }

    public final void removeGradientColor(int id) {
        GradientContainer container = getContainer(id);
        if (container == null) {
            throw new IllegalArgumentException("");
        }
        if (this.colorList.size() < 3) {
            throw new IllegalStateException("E_INVALID_STATE : There are colors less than 3");
        }
        this.colorList.remove(container);
    }

    public final void setColorType(int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("invalid color type");
        }
        this.colorType = i;
    }

    public final void setGradientColor(int id, @Nullable GradientColor gradientColor) {
        if (gradientColor == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        GradientColor gradientColor2 = getGradientColor(id);
        if (gradientColor2 == null) {
            throw new IllegalArgumentException("id does not exist");
        }
        gradientColor2.color = gradientColor.color;
        gradientColor2.position = gradientColor.position;
        Collections.sort(this.colorList, comparator);
    }

    public final void setGradientPosition(@Nullable PointF pointF) {
        this.gradientPosition = pointF;
    }

    public final void setGradientRotatable(boolean z) {
        this.isGradientRotatable = z;
    }

    public final void setGradientType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid gradient type");
        }
        this.gradientType = i;
    }

    public final void setLinearGradientAngle(int i) {
        this.linearGradientAngle = i;
    }

    public final void setSolidColor(int i) {
        this.solidColor = i;
    }
}
