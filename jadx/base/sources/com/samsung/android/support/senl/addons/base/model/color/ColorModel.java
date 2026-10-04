package com.samsung.android.support.senl.addons.base.model.color;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/AbsBaseColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "color", "", "<init>", "(I)V", "position", "(II)V", "hsvColor", "", "(I[FI)V", "mHSV", "setColor", "", "getHSV", "hsv", "src", "compareHSV", "", "dst", "isSame", "other", "isRgbSame", "equalFloatValues", "v1", "", AuthenticationConstants.Broker.BROKER_PROTOCOL_VERSION, "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColorModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorModel.kt\ncom/samsung/android/support/senl/addons/base/model/color/ColorModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public class ColorModel extends AbsBaseColorModel implements IExtendedColor {

    @NotNull
    private static final String TAG = Logger.createTag("ColorModel");

    @NotNull
    private float[] mHSV;

    public ColorModel(int i) {
        super(i);
        float[] fArr = new float[3];
        this.mHSV = fArr;
        ColorCompat.colorToHSV(i, fArr);
    }

    private final boolean compareHSV(float[] dst, float[] src) {
        if (dst == null || src == null || dst.length != src.length || dst.length != 3) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!equalFloatValues(dst[i], src[i])) {
                return false;
            }
        }
        return true;
    }

    private final boolean equalFloatValues(float v12, float v22) {
        return Math.abs(v12 - v22) < 1.0E-7f;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    @NotNull
    /* JADX INFO: renamed from: getHSV, reason: from getter */
    public float[] getMHSV() {
        return this.mHSV;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public boolean isRgbSame(@NotNull IExtendedColor other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return (getMColor() | (-16777216)) == (other.getMColor() | (-16777216));
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public boolean isSame(@NotNull IExtendedColor other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getMColor() == other.getMColor() && compareHSV(getMHSV(), other.getMHSV());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.AbsBaseColorModel, com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    public void setColor(int color) {
        ColorCompat.colorToHSV(color, this.mHSV);
        super.setColor(color);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public void setColor(@Nullable float[] hsv) {
        if (hsv != null && hsv.length == 3) {
            if (compareHSV(hsv, this.mHSV)) {
                return;
            }
            if (hsv != null) {
                System.arraycopy(hsv, 0, this.mHSV, 0, hsv.length);
            }
            setMColor(ColorCompat.HSVToColor(hsv));
            notifyChanged(201);
            return;
        }
        throw new IllegalArgumentException("HSV has must 3 fields");
    }

    public ColorModel(int i, int i2) {
        super(i, i2);
        float[] fArr = new float[3];
        this.mHSV = fArr;
        ColorCompat.colorToHSV(i, fArr);
    }

    public ColorModel(int i, @Nullable float[] fArr, int i2) {
        super(i, i2);
        float[] fArr2 = new float[3];
        this.mHSV = fArr2;
        if (fArr != null && fArr.length == 3) {
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        } else {
            ColorCompat.colorToHSV(i, fArr2);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public void setColor(int color, @Nullable float[] hsv) {
        if (ColorCompat.HSVToColor(hsv) != ((-16777216) | color)) {
            Logger.m7101e(TAG, "Color and HSV is not matched - update HSV");
            ColorCompat.colorToHSV(color, hsv);
        }
        setColor(hsv);
        setMColor(color);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IExtendedColor
    public void setColor(@NotNull IExtendedColor src) {
        Intrinsics.checkNotNullParameter(src, "src");
        setColor(src.getMColor(), src.getMHSV());
    }
}
