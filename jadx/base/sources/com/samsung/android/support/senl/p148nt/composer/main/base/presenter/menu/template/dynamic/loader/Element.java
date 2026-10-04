package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001Bc\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0001\u0003 !\"¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "", "id", "", "left", "", "top", "width", "height", "marginLeft", "marginRight", "marginTop", "marginBottom", "borderShape", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "<init>", "(Ljava/lang/String;IIIIIIIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;)V", "getId", "()Ljava/lang/String;", "getLeft", "()I", "getTop", "getWidth", "getHeight", "getMarginLeft", "getMarginRight", "getMarginTop", "getMarginBottom", "getBorderShape", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "getRectF", "Landroid/graphics/RectF;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/GeneratedImage;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Image;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class Element {

    @NotNull
    private final BorderShape borderShape;
    private final int height;

    @NotNull
    private final String id;
    private final int left;
    private final int marginBottom;
    private final int marginLeft;
    private final int marginRight;
    private final int marginTop;
    private final int top;
    private final int width;

    public /* synthetic */ Element(String str, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, BorderShape borderShape, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, i5, i6, i7, i8, i9, borderShape);
    }

    @NotNull
    public BorderShape getBorderShape() {
        return this.borderShape;
    }

    public int getHeight() {
        return this.height;
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    public int getLeft() {
        return this.left;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public int getMarginLeft() {
        return this.marginLeft;
    }

    public int getMarginRight() {
        return this.marginRight;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    @NotNull
    public final RectF getRectF() {
        return new RectF(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
    }

    public int getTop() {
        return this.top;
    }

    public int getWidth() {
        return this.width;
    }

    private Element(String str, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, BorderShape borderShape) {
        this.id = str;
        this.left = i;
        this.top = i2;
        this.width = i4;
        this.height = i5;
        this.marginLeft = i6;
        this.marginRight = i7;
        this.marginTop = i8;
        this.marginBottom = i9;
        this.borderShape = borderShape;
    }

    public /* synthetic */ Element(String str, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, BorderShape borderShape, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) != 0 ? 0 : i9, (i10 & 512) != 0 ? new BorderShape(false, false, false, false, 0, 0.0f, 0, 127, null) : borderShape, null);
    }
}
