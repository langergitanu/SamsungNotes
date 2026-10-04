package com.samsung.android.support.senl.addons.base.model.pen;

import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B!\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\nB)\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0006H$J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0096\u0002J#\u0010\u0015\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0096\u0002J\u001b\u0010\u0015\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0011H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/pen/AbsPenModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "<init>", "()V", "type", "", "color", "", "thickness", "(Ljava/lang/String;II)V", "position", "(Ljava/lang/String;III)V", "mPenType", "mPenClassName", "mPenThickness", "mIsSelected", "", "mEnabled", "findPenClassName", "penType", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "size", "setPenSize", "setPenType", "getSize", "getPenName", "getPenClassName", "setSelected", "selected", "getSelected", "getPenSize", "", "getAlphaColor", "getAlpha", "setAlpha", "alphaValue", "hasAlpha", "setEnabled", "enable", "isEnabled", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPenModel extends ColorModel implements IPenModel {
    private boolean mEnabled;
    private boolean mIsSelected;

    @Nullable
    private String mPenClassName;
    private int mPenThickness;

    @NotNull
    private String mPenType;

    public AbsPenModel() {
        super(0);
        this.mPenType = "";
        this.mPenThickness = 35;
        this.mEnabled = true;
    }

    private final void setPenType(String type) {
        if (type == null || Intrinsics.areEqual(this.mPenType, type)) {
            return;
        }
        this.mPenType = type;
        this.mPenClassName = findPenClassName(type);
        notifyChanged(301);
    }

    @Nullable
    public abstract String findPenClassName(@NotNull String penType);

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public float getAlpha() {
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public int getAlphaColor() {
        return getMColor();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    @Nullable
    /* JADX INFO: renamed from: getPenClassName, reason: from getter */
    public String getMPenClassName() {
        return this.mPenClassName;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    @NotNull
    /* JADX INFO: renamed from: getPenName, reason: from getter */
    public String getMPenType() {
        return this.mPenType;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public float getPenSize() {
        return getMPenThickness();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    /* JADX INFO: renamed from: getSelected, reason: from getter */
    public boolean getMIsSelected() {
        return this.mIsSelected;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    /* JADX INFO: renamed from: getSize, reason: from getter */
    public int getMPenThickness() {
        return this.mPenThickness;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public boolean hasAlpha() {
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public boolean getMEnabled() {
        return this.mEnabled;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void set(int color, int size) {
        setColor(color);
        setPenSize(size);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setAlpha(float alphaValue) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setEnabled(boolean enable) {
        if (this.mEnabled != enable) {
            this.mEnabled = enable;
            notifyChanged(303);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setPenSize(int size) {
        if (this.mPenThickness != size) {
            this.mPenThickness = size;
            notifyChanged(302);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void setSelected(boolean selected) {
        if (this.mIsSelected != selected) {
            this.mIsSelected = selected;
            notifyChanged(301);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void set(@Nullable String type, int color, int size) {
        setPenType(type);
        setColor(color);
        setPenSize(size);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPenModel(@NotNull String type, int i, int i2) {
        super(i);
        Intrinsics.checkNotNullParameter(type, "type");
        this.mEnabled = true;
        this.mPenType = type;
        this.mPenThickness = i2;
        this.mPenClassName = findPenClassName(type);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.pen.IPenModel
    public void set(@Nullable String type, int color) {
        setPenType(type);
        setColor(color);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPenModel(@NotNull String type, int i, int i2, int i4) {
        super(i, i4);
        Intrinsics.checkNotNullParameter(type, "type");
        this.mEnabled = true;
        this.mPenType = type;
        this.mPenThickness = i2;
        this.mPenClassName = findPenClassName(type);
    }
}
