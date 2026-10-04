package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0010\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0011H\u0016J\b\u0010*\u001a\u00020\u0018H\u0014J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u000bH\u0016J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0011J\u0010\u00101\u001a\u00020\u00182\b\u00102\u001a\u0004\u0018\u00010\u0016J\u0006\u00103\u001a\u00020\u0011J\u0016\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011J\u000e\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0011J\u000e\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0011J\u0010\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0004J\b\u0010=\u001a\u00020\u0018H\u0002J\u0012\u0010>\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010?\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\rH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenBaseView;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenViewInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPenResource", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "mColor", "", "mColorMask", "Landroid/widget/ImageView;", "mIsInterceptHoverEvent", "", "setPenInfo", "penInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenName", "", "setPenColorEnabled", "", "enable", "setPenColor", "color", "getPenColor", "setPenSizeLevel", "sizeLevel", "getPenSizeLevel", "setParticleSize", "particleSize", "", "getParticleSize", "setFixedWidth", "isFixedWidth", "setFixedOpacity", "isFixedOpacity", "setSelected", "selected", "onFinishInflate", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "setPenResourceInfo", "penResource", "supportTalkback", "setHoverDescription", "description", "hasPenResourceInfo", "animation", "setHoverResourceEnabled", "enabled", "setInterceptHoverEvent", "isIntercept", "enableColorMask", "colorMaskEnabled", "getColorMaskEnabled", "()Z", "initView", "updatePenView", "setState", "updateColorMask", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPenBaseView extends FrameLayout implements SpenPenViewInterface {

    @NotNull
    private static final String TAG = "SpenPenBaseView";
    private int mColor;

    @Nullable
    private ImageView mColorMask;
    private boolean mIsInterceptHoverEvent;

    @Nullable
    private SpenSettingPenResource mPenResource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenBaseView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        this.mColorMask = (ImageView) findViewById(C7932R.id.pen_color_mask);
        setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
    }

    private final void setState(boolean selected, boolean animation) {
        SpenSettingPenResource spenSettingPenResource;
        ImageView imageView = this.mColorMask;
        if (imageView == null || (spenSettingPenResource = this.mPenResource) == null) {
            return;
        }
        int colorMaskId = spenSettingPenResource.getColorMaskId(selected);
        if (colorMaskId == 0) {
            imageView.setImageResource(0);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = "false";
        String str2 = selected ? "true" : "false";
        String str3 = animation ? "true" : "false";
        SpenSettingPenResource spenSettingPenResource2 = this.mPenResource;
        if (spenSettingPenResource2 != null && spenSettingPenResource2.getMHasAnimatedResource()) {
            str = "true";
        }
        SpenSettingPenResource spenSettingPenResource3 = this.mPenResource;
        AbstractC6670b.m4765z(new Object[]{str2, str3, str, spenSettingPenResource3 != null ? spenSettingPenResource3.getName() : null, Integer.valueOf(colorMaskId)}, 5, "setState(selected=%s, animation=%s) AnimatedDrawable=%s, Pen[%s], maskId=%d ", "format(format, *args)", TAG);
        if (!animation || !spenSettingPenResource.getMHasAnimatedResource()) {
            imageView.setImageResource(spenSettingPenResource.getColorMaskId(selected));
            return;
        }
        imageView.setImageResource(spenSettingPenResource.getColorMaskId(!selected));
        Drawable drawable = imageView.getDrawable();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimatedVectorDrawable");
        ((AnimatedVectorDrawable) drawable).start();
    }

    private final void updateColorMask(int color) {
        ImageView imageView;
        if (this.mPenResource == null || (imageView = this.mColorMask) == null) {
            return;
        }
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    private final void updatePenView(SpenSettingPenResource penResource) {
        if (penResource == null) {
            return;
        }
        setBackgroundResource(penResource.getMBodyId());
        if (penResource.getMEffectId() != 0) {
            setForeground(getContext().getDrawable(penResource.getMEffectId()));
        } else {
            Log.i(TAG, "setForeground(null) - " + penResource.getName());
            setForeground(null);
        }
        setState(isSelected(), false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mIsInterceptHoverEvent) {
            return false;
        }
        return super.dispatchHoverEvent(event);
    }

    public final void enableColorMask(boolean enable) {
        AbstractC4539a.m3208r("enablePenMask() =", TAG, enable);
        ImageView imageView = this.mColorMask;
        if (imageView != null) {
            imageView.setVisibility(enable ? 0 : 8);
        }
    }

    public final boolean getColorMaskEnabled() {
        ImageView imageView = this.mColorMask;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public float getParticleSize() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    /* JADX INFO: renamed from: getPenColor, reason: from getter */
    public int getMColor() {
        return this.mColor;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    @Nullable
    public String getPenName() {
        if (getTag() == null) {
            return null;
        }
        Object tag = getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        return (String) tag;
    }

    /* JADX INFO: renamed from: getPenSizeLevel */
    public int getMSizeLevel() {
        return 0;
    }

    public final boolean hasPenResourceInfo() {
        return this.mPenResource != null;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public boolean isFixedOpacity() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public boolean isFixedWidth() {
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 0) {
            View.inflate(getContext(), C7932R.layout.setting_pen_view_v2, this);
        }
        initView();
        updatePenView(this.mPenResource);
        updateColorMask(this.mColor);
    }

    public final void setHoverDescription(@Nullable String description) {
        SpenSettingUtilHover.setHoverText(this, description);
    }

    public final void setHoverResourceEnabled(boolean enabled) {
        SpenSettingPenResource spenSettingPenResource = this.mPenResource;
        if (spenSettingPenResource != null) {
            setBackgroundResource(!enabled ? spenSettingPenResource.getMBodyId() : spenSettingPenResource.getMHoverBodyId());
        }
    }

    public final void setInterceptHoverEvent(boolean isIntercept) {
        this.mIsInterceptHoverEvent = isIntercept;
    }

    public void setPenColor(int color) {
        this.mColor = color;
        updateColorMask(color);
    }

    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        if (this.mPenResource == null) {
            return false;
        }
        if (getTag() == null || !Intrinsics.areEqual(penInfo.name, getTag().toString())) {
            Log.i(TAG, "If you want to change the pen, please put the pen resource first.");
            return false;
        }
        setPenColor(penInfo.color);
        return true;
    }

    public void setPenResourceInfo(@NotNull SpenSettingPenResource penResource) {
        Intrinsics.checkNotNullParameter(penResource, "penResource");
        setPenResourceInfo(penResource, true);
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        setState(selected, false);
    }

    public final void setPenResourceInfo(@NotNull SpenSettingPenResource penResource, boolean supportTalkback) {
        Intrinsics.checkNotNullParameter(penResource, "penResource");
        this.mPenResource = penResource;
        setTag(penResource != null ? penResource.getName() : null);
        SpenSettingPenResource spenSettingPenResource = this.mPenResource;
        if (spenSettingPenResource == null || spenSettingPenResource.getStringId() == 0) {
            return;
        }
        if (supportTalkback) {
            String string = getContext().getString(spenSettingPenResource.getStringId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            SpenSettingUtilHover.setHoverText(this, string);
            setContentDescription(string);
        }
        updatePenView(spenSettingPenResource);
        updateColorMask(this.mColor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    public final void setSelected(boolean selected, boolean animation) {
        AbstractC6670b.m4758s("setSelected() selected=", " animation=", TAG, selected, animation);
        super.setSelected(selected);
        setState(selected, animation);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setFixedOpacity(boolean isFixedOpacity) {
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setFixedWidth(boolean isFixedWidth) {
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setParticleSize(float particleSize) {
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface
    public void setPenColorEnabled(boolean enable) {
    }

    public void setPenSizeLevel(int sizeLevel) {
    }
}
