package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\fJ\u001a\u0010&\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenView;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOrientation", "", "mPenNameStringId", "mAutoDescriptionUpdate", "", "mProhibitTooltipText", "mColorName", "", "setPenInfo", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenColor", "", "color", "setPenResourceInfo", "penResource", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "colorName", "orientation", "getOrientation", "()I", "setOrientation", "(I)V", "getPenMaskEnabled", "enablePenMask", "enable", "setFixedContentDescription", "description", "setProhibitTooltipText", "isProhibit", "setAttributes", "setTalkBackDescription", "isButton", "updateFixedTalkBack", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenView extends SpenPenBaseView {
    public static final int BOTTOM = 80;
    public static final int END = 8388613;
    public static final int HORIZONTAL = 0;
    public static final int START = 8388611;

    @NotNull
    private static final String TAG = "SpenBrushPenView";
    public static final int TOP = 48;
    public static final int VERTICAL = 1;
    private boolean mAutoDescriptionUpdate;

    @Nullable
    private String mColorName;
    private int mOrientation;
    private int mPenNameStringId;
    private boolean mProhibitTooltipText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SpenBrushPenView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C7932R.styleable.SpenBrushPenView);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mOrientation = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenBrushPenView_orientation, 1);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void setTalkBackDescription(String description, boolean isButton) {
        if (isButton) {
            SpenSettingUtilAccessibility.setAccessibilityNodeInfoToButton(this, description);
        } else {
            setContentDescription(description);
        }
    }

    private final void updateFixedTalkBack() {
        if (this.mAutoDescriptionUpdate || this.mPenNameStringId <= 0) {
            return;
        }
        String string = getContext().getResources().getString(this.mPenNameStringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.mColorName;
        if (string2 == null) {
            string2 = getContext().getResources().getString(C7932R.string.pen_palette_color_custom);
        }
        setTalkBackDescription(AbstractC0541b.m757C(string, SQLKeyword.COMMA, string2), false);
    }

    public final void enablePenMask(boolean enable) {
        enableColorMask(enable);
    }

    /* JADX INFO: renamed from: getOrientation, reason: from getter */
    public final int getMOrientation() {
        return this.mOrientation;
    }

    public final boolean getPenMaskEnabled() {
        return getColorMaskEnabled();
    }

    public final void setFixedContentDescription(@Nullable String description) {
        AbstractC6670b.m4756q("setFixedContentDescription() description=", description, TAG);
        this.mAutoDescriptionUpdate = false;
        setHoverDescription(description);
    }

    public final void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView, com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenColor(int color) {
        setPenColor(color, null);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView, com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        SpenSettingPenResource brushPenResource = SpenBrushPenResource.getBrushPenResource(getContext(), penInfo.name);
        if (brushPenResource == null) {
            AbstractC4539a.m3207q("setPenInfo() penResource is null [", penInfo.name, "]", TAG);
            return false;
        }
        if (getTag() == null || !Intrinsics.areEqual(penInfo.name, getTag().toString())) {
            AbstractC4539a.m3207q("Changed Pen. Pen(", penInfo.name, ")", TAG);
            setPenResourceInfo(brushPenResource, this.mAutoDescriptionUpdate);
        } else {
            AbstractC4539a.m3207q("Not Changed Pen. Pen(", penInfo.name, ")", TAG);
        }
        return super.setPenInfo(penInfo);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView
    public void setPenResourceInfo(@NotNull SpenSettingPenResource penResource) {
        Intrinsics.checkNotNullParameter(penResource, "penResource");
        setPenResourceInfo(penResource, this.mAutoDescriptionUpdate);
        int stringId = penResource.getStringId();
        this.mPenNameStringId = stringId;
        if (!this.mAutoDescriptionUpdate || stringId <= 0) {
            return;
        }
        String string = getContext().getResources().getString(this.mPenNameStringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setHoverDescription(string);
        setTalkBackDescription(string, true);
    }

    public final void setProhibitTooltipText(boolean isProhibit) {
        this.mProhibitTooltipText = isProhibit;
        if (isProhibit) {
            SpenSettingUtilHover.setHoverText(this, null, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenBrushPenView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setAttributes(context, attributeSet);
        this.mAutoDescriptionUpdate = true;
        this.mProhibitTooltipText = false;
        this.mPenNameStringId = 0;
    }

    public final void setPenColor(int color, @Nullable String colorName) {
        super.setPenColor(color);
        this.mColorName = colorName;
        updateFixedTalkBack();
    }

    public /* synthetic */ SpenBrushPenView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
