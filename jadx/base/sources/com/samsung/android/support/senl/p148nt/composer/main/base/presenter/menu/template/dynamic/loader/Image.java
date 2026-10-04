package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Image;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "id", "", "left", "", "top", "width", "height", "marginLeft", "marginRight", "marginTop", "marginBottom", "borderShape", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "src", "generated", "", "maskType", "text", "<init>", "(Ljava/lang/String;IIIIIIIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;Ljava/lang/String;ZILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLeft", "()I", "getTop", "getWidth", "getHeight", "getMarginLeft", "getMarginRight", "getMarginTop", "getMarginBottom", "getBorderShape", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "getSrc", "getGenerated", "()Z", "getMaskType", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class Image extends Element {

    @NotNull
    private final BorderShape borderShape;
    private final boolean generated;
    private final int height;

    @NotNull
    private final String id;
    private final int left;
    private final int marginBottom;
    private final int marginLeft;
    private final int marginRight;
    private final int marginTop;
    private final int maskType;

    @NotNull
    private final String src;

    @NotNull
    private final String text;
    private final int top;
    private final int width;

    public /* synthetic */ Image(String str, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, BorderShape borderShape, String str2, boolean z, int i10, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, i5, (i11 & 32) != 0 ? 0 : i6, (i11 & 64) != 0 ? 0 : i7, (i11 & 128) != 0 ? 0 : i8, (i11 & 256) != 0 ? 0 : i9, (i11 & 512) != 0 ? new BorderShape(false, false, false, false, 0, 0.0f, 0, 127, null) : borderShape, str2, (i11 & 2048) != 0 ? false : z, (i11 & 4096) != 0 ? 0 : i10, (i11 & 8192) != 0 ? "" : str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final BorderShape getBorderShape() {
        return this.borderShape;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getGenerated() {
        return this.generated;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getMaskType() {
        return this.maskType;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getText() {
        return this.text;
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMarginLeft() {
        return this.marginLeft;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getMarginRight() {
        return this.marginRight;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getMarginTop() {
        return this.marginTop;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getMarginBottom() {
        return this.marginBottom;
    }

    @NotNull
    public final Image copy(@NotNull String id, int left, int top, int width, int height, int marginLeft, int marginRight, int marginTop, int marginBottom, @NotNull BorderShape borderShape, @NotNull String src, boolean generated, int maskType, @NotNull String text) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(borderShape, "borderShape");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(text, "text");
        return new Image(id, left, top, width, height, marginLeft, marginRight, marginTop, marginBottom, borderShape, src, generated, maskType, text);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image image = (Image) other;
        return Intrinsics.areEqual(this.id, image.id) && this.left == image.left && this.top == image.top && this.width == image.width && this.height == image.height && this.marginLeft == image.marginLeft && this.marginRight == image.marginRight && this.marginTop == image.marginTop && this.marginBottom == image.marginBottom && Intrinsics.areEqual(this.borderShape, image.borderShape) && Intrinsics.areEqual(this.src, image.src) && this.generated == image.generated && this.maskType == image.maskType && Intrinsics.areEqual(this.text, image.text);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    @NotNull
    public BorderShape getBorderShape() {
        return this.borderShape;
    }

    public final boolean getGenerated() {
        return this.generated;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getHeight() {
        return this.height;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getLeft() {
        return this.left;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getMarginBottom() {
        return this.marginBottom;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getMarginLeft() {
        return this.marginLeft;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getMarginRight() {
        return this.marginRight;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getMarginTop() {
        return this.marginTop;
    }

    public final int getMaskType() {
        return this.maskType;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getTop() {
        return this.top;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.text.hashCode() + AbstractC0622a.m1157c(this.maskType, AbstractC0622a.m1160f(this.generated, AbstractC1038a.m1202c((this.borderShape.hashCode() + AbstractC0622a.m1157c(this.marginBottom, AbstractC0622a.m1157c(this.marginTop, AbstractC0622a.m1157c(this.marginRight, AbstractC0622a.m1157c(this.marginLeft, AbstractC0622a.m1157c(this.height, AbstractC0622a.m1157c(this.width, AbstractC0622a.m1157c(this.top, AbstractC0622a.m1157c(this.left, this.id.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31, this.src), 31), 31);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        int i = this.left;
        int i2 = this.top;
        int i4 = this.width;
        int i5 = this.height;
        int i6 = this.marginLeft;
        int i7 = this.marginRight;
        int i8 = this.marginTop;
        int i9 = this.marginBottom;
        BorderShape borderShape = this.borderShape;
        String str2 = this.src;
        boolean z = this.generated;
        int i10 = this.maskType;
        String str3 = this.text;
        StringBuilder sbM780v = AbstractC0541b.m780v("Image(id=", i, str, ", left=", ", top=");
        AbstractC2821a.m2235z(sbM780v, i2, i4, ", width=", ", height=");
        AbstractC2821a.m2235z(sbM780v, i5, i6, ", marginLeft=", ", marginRight=");
        AbstractC2821a.m2235z(sbM780v, i7, i8, ", marginTop=", ", marginBottom=");
        sbM780v.append(i9);
        sbM780v.append(", borderShape=");
        sbM780v.append(borderShape);
        sbM780v.append(", src=");
        sbM780v.append(str2);
        sbM780v.append(", generated=");
        sbM780v.append(z);
        sbM780v.append(", maskType=");
        sbM780v.append(i10);
        sbM780v.append(", text=");
        sbM780v.append(str3);
        sbM780v.append(")");
        return sbM780v.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Image(@NotNull String id, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, @NotNull BorderShape borderShape, @NotNull String src, boolean z, int i10, @NotNull String text) {
        super(id, i, i2, i4, i5, 0, 0, 0, 0, null, 992, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(borderShape, "borderShape");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = id;
        this.left = i;
        this.top = i2;
        this.width = i4;
        this.height = i5;
        this.marginLeft = i6;
        this.marginRight = i7;
        this.marginTop = i8;
        this.marginBottom = i9;
        this.borderShape = borderShape;
        this.src = src;
        this.generated = z;
        this.maskType = i10;
        this.text = text;
    }
}
