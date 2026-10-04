package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/DayOfWeekTextBox;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "id", "", "left", "", "top", "width", "height", "borderShape", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "fontSize", "fontColor", "textAlignment", "textStyle", "displayType", "targetId", "<init>", "(Ljava/lang/String;IIIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;IIIIILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLeft", "()I", "getTop", "getWidth", "getHeight", "getBorderShape", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "getFontSize", "getFontColor", "getTextAlignment", "getTextStyle", "getDisplayType", "getTargetId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class DayOfWeekTextBox extends TextBox {

    @NotNull
    private final BorderShape borderShape;
    private final int displayType;
    private final int fontColor;
    private final int fontSize;
    private final int height;

    @NotNull
    private final String id;
    private final int left;

    @NotNull
    private final String targetId;
    private final int textAlignment;
    private final int textStyle;
    private final int top;
    private final int width;

    public /* synthetic */ DayOfWeekTextBox(String str, int i, int i2, int i4, int i5, BorderShape borderShape, int i6, int i7, int i8, int i9, int i10, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, i5, (i11 & 32) != 0 ? new BorderShape(false, false, false, false, 0, 0.0f, 0, 127, null) : borderShape, i6, i7, i8, i9, i10, str2);
    }

    public static /* synthetic */ DayOfWeekTextBox copy$default(DayOfWeekTextBox dayOfWeekTextBox, String str, int i, int i2, int i4, int i5, BorderShape borderShape, int i6, int i7, int i8, int i9, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dayOfWeekTextBox.id;
        }
        if ((i11 & 2) != 0) {
            i = dayOfWeekTextBox.left;
        }
        if ((i11 & 4) != 0) {
            i2 = dayOfWeekTextBox.top;
        }
        if ((i11 & 8) != 0) {
            i4 = dayOfWeekTextBox.width;
        }
        if ((i11 & 16) != 0) {
            i5 = dayOfWeekTextBox.height;
        }
        if ((i11 & 32) != 0) {
            borderShape = dayOfWeekTextBox.borderShape;
        }
        if ((i11 & 64) != 0) {
            i6 = dayOfWeekTextBox.fontSize;
        }
        if ((i11 & 128) != 0) {
            i7 = dayOfWeekTextBox.fontColor;
        }
        if ((i11 & 256) != 0) {
            i8 = dayOfWeekTextBox.textAlignment;
        }
        if ((i11 & 512) != 0) {
            i9 = dayOfWeekTextBox.textStyle;
        }
        if ((i11 & 1024) != 0) {
            i10 = dayOfWeekTextBox.displayType;
        }
        if ((i11 & 2048) != 0) {
            str2 = dayOfWeekTextBox.targetId;
        }
        int i12 = i10;
        String str3 = str2;
        int i13 = i8;
        int i14 = i9;
        int i15 = i6;
        int i16 = i7;
        int i17 = i5;
        BorderShape borderShape2 = borderShape;
        return dayOfWeekTextBox.copy(str, i, i2, i4, i17, borderShape2, i15, i16, i13, i14, i12, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getTextStyle() {
        return this.textStyle;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getDisplayType() {
        return this.displayType;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTargetId() {
        return this.targetId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final BorderShape getBorderShape() {
        return this.borderShape;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFontColor() {
        return this.fontColor;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getTextAlignment() {
        return this.textAlignment;
    }

    @NotNull
    public final DayOfWeekTextBox copy(@NotNull String id, int left, int top, int width, int height, @NotNull BorderShape borderShape, int fontSize, int fontColor, int textAlignment, int textStyle, int displayType, @NotNull String targetId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(borderShape, "borderShape");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        return new DayOfWeekTextBox(id, left, top, width, height, borderShape, fontSize, fontColor, textAlignment, textStyle, displayType, targetId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayOfWeekTextBox)) {
            return false;
        }
        DayOfWeekTextBox dayOfWeekTextBox = (DayOfWeekTextBox) other;
        return Intrinsics.areEqual(this.id, dayOfWeekTextBox.id) && this.left == dayOfWeekTextBox.left && this.top == dayOfWeekTextBox.top && this.width == dayOfWeekTextBox.width && this.height == dayOfWeekTextBox.height && Intrinsics.areEqual(this.borderShape, dayOfWeekTextBox.borderShape) && this.fontSize == dayOfWeekTextBox.fontSize && this.fontColor == dayOfWeekTextBox.fontColor && this.textAlignment == dayOfWeekTextBox.textAlignment && this.textStyle == dayOfWeekTextBox.textStyle && this.displayType == dayOfWeekTextBox.displayType && Intrinsics.areEqual(this.targetId, dayOfWeekTextBox.targetId);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    @NotNull
    public BorderShape getBorderShape() {
        return this.borderShape;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox
    public int getFontColor() {
        return this.fontColor;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox
    public int getFontSize() {
        return this.fontSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getHeight() {
        return this.height;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getLeft() {
        return this.left;
    }

    @NotNull
    public final String getTargetId() {
        return this.targetId;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox
    public int getTextAlignment() {
        return this.textAlignment;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox
    public int getTextStyle() {
        return this.textStyle;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getTop() {
        return this.top;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.TextBox, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.targetId.hashCode() + AbstractC0622a.m1157c(this.displayType, AbstractC0622a.m1157c(this.textStyle, AbstractC0622a.m1157c(this.textAlignment, AbstractC0622a.m1157c(this.fontColor, AbstractC0622a.m1157c(this.fontSize, (this.borderShape.hashCode() + AbstractC0622a.m1157c(this.height, AbstractC0622a.m1157c(this.width, AbstractC0622a.m1157c(this.top, AbstractC0622a.m1157c(this.left, this.id.hashCode() * 31, 31), 31), 31), 31)) * 31, 31), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        int i = this.left;
        int i2 = this.top;
        int i4 = this.width;
        int i5 = this.height;
        BorderShape borderShape = this.borderShape;
        int i6 = this.fontSize;
        int i7 = this.fontColor;
        int i8 = this.textAlignment;
        int i9 = this.textStyle;
        int i10 = this.displayType;
        String str2 = this.targetId;
        StringBuilder sbM780v = AbstractC0541b.m780v("DayOfWeekTextBox(id=", i, str, ", left=", ", top=");
        AbstractC2821a.m2235z(sbM780v, i2, i4, ", width=", ", height=");
        sbM780v.append(i5);
        sbM780v.append(", borderShape=");
        sbM780v.append(borderShape);
        sbM780v.append(", fontSize=");
        AbstractC2821a.m2235z(sbM780v, i6, i7, ", fontColor=", ", textAlignment=");
        AbstractC2821a.m2235z(sbM780v, i8, i9, ", textStyle=", ", displayType=");
        sbM780v.append(i10);
        sbM780v.append(", targetId=");
        sbM780v.append(str2);
        sbM780v.append(")");
        return sbM780v.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayOfWeekTextBox(@NotNull String id, int i, int i2, int i4, int i5, @NotNull BorderShape borderShape, int i6, int i7, int i8, int i9, int i10, @NotNull String targetId) {
        super(id, i, i2, i4, i5, borderShape, i6, i7, i8, i9, false, false, null, false, 0, 0, 0, 130048, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(borderShape, "borderShape");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        this.id = id;
        this.left = i;
        this.top = i2;
        this.width = i4;
        this.height = i5;
        this.borderShape = borderShape;
        this.fontSize = i6;
        this.fontColor = i7;
        this.textAlignment = i8;
        this.textStyle = i9;
        this.displayType = i10;
        this.targetId = targetId;
    }
}
