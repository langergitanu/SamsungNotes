package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001c¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/TextBox;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/Element;", "id", "", "left", "", "top", "width", "height", "borderShape", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "fontSize", "fontColor", "textAlignment", "textStyle", "generated", "", "editable", "text", "linedPaperEnabled", "linedPagerColor", "paragraphType", "gravity", "<init>", "(Ljava/lang/String;IIIILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;IIIIZZLjava/lang/String;ZIII)V", "getId", "()Ljava/lang/String;", "getLeft", "()I", "getTop", "getWidth", "getHeight", "getBorderShape", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/loader/BorderShape;", "getFontSize", "getFontColor", "getTextAlignment", "getTextStyle", "getGenerated", "()Z", "getEditable", "getText", "getLinedPaperEnabled", "getLinedPagerColor", "getParagraphType", "getGravity", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class TextBox extends Element {

    @NotNull
    private final BorderShape borderShape;
    private final boolean editable;
    private final int fontColor;
    private final int fontSize;
    private final boolean generated;
    private final int gravity;
    private final int height;

    @NotNull
    private final String id;
    private final int left;
    private final int linedPagerColor;
    private final boolean linedPaperEnabled;
    private final int paragraphType;

    @NotNull
    private final String text;
    private final int textAlignment;
    private final int textStyle;
    private final int top;
    private final int width;

    public /* synthetic */ TextBox(String str, int i, int i2, int i4, int i5, BorderShape borderShape, int i6, int i7, int i8, int i9, boolean z, boolean z2, String str2, boolean z3, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i4, i5, (i13 & 32) != 0 ? new BorderShape(false, false, false, false, 0, 0.0f, 0, 127, null) : borderShape, i6, i7, i8, i9, (i13 & 1024) != 0 ? false : z, (i13 & 2048) != 0 ? true : z2, (i13 & 4096) != 0 ? "" : str2, (i13 & 8192) != 0 ? false : z3, (i13 & 16384) != 0 ? 0 : i10, (32768 & i13) != 0 ? 0 : i11, (i13 & 65536) != 0 ? 0 : i12);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    @NotNull
    public BorderShape getBorderShape() {
        return this.borderShape;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public boolean getGenerated() {
        return this.generated;
    }

    public final int getGravity() {
        return this.gravity;
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

    public final int getLinedPagerColor() {
        return this.linedPagerColor;
    }

    public final boolean getLinedPaperEnabled() {
        return this.linedPaperEnabled;
    }

    public final int getParagraphType() {
        return this.paragraphType;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int getTextAlignment() {
        return this.textAlignment;
    }

    public int getTextStyle() {
        return this.textStyle;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getTop() {
        return this.top;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.Element
    public int getWidth() {
        return this.width;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextBox(@NotNull String id, int i, int i2, int i4, int i5, @NotNull BorderShape borderShape, int i6, int i7, int i8, int i9, boolean z, boolean z2, @NotNull String text, boolean z3, int i10, int i11, int i12) {
        super(id, i, i2, i4, i5, 0, 0, 0, 0, null, 992, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(borderShape, "borderShape");
        Intrinsics.checkNotNullParameter(text, "text");
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
        this.generated = z;
        this.editable = z2;
        this.text = text;
        this.linedPaperEnabled = z3;
        this.linedPagerColor = i10;
        this.paragraphType = i11;
        this.gravity = i12;
    }
}
