package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTVoiceAssistantAsButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001e\b\u0016\u0018\u0000 72\u00020\u0001:\u00017B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u001aH\u0014J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\nH\u0016J\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0010J\u0010\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0006\u0010+\u001a\u00020\u0010J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0004J\b\u00103\u001a\u00020\u001aH\u0002J\u0012\u00104\u001a\u00020\u001a2\b\u0010'\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u00105\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\fH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00108DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenBaseView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPenResource", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "mColor", "", "mColorMask", "Landroid/widget/ImageView;", "setPenInfo", "", "penName", "", "color", "sizeLevel", "particleSize", "", "isFixedWidth", "getPenName", "setPenColorEnabled", "", "enable", "setPenColor", "getPenColor", "setPenSizeLevel", "getPenSizeLevel", "setParticleSize", "getParticleSize", "setFixedWidth", "setSelected", "selected", "onFinishInflate", "setPenResourceInfo", "penResource", "supportTalkback", "setHoverDescription", "description", "hasPenResourceInfo", "animation", "setHoverResourceEnabled", "enabled", "enableColorMask", "colorMaskEnabled", "getColorMaskEnabled", "()Z", "initView", "updatePenView", "setState", "updateColorMask", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class QTPenBaseView extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenPenBaseView";
    private int mColor;

    @Nullable
    private ImageView mColorMask;

    @Nullable
    private SpenSettingPenResource mPenResource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QTPenBaseView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        this.mColorMask = (ImageView) findViewById(C9086R.id.pen_color_mask);
        setAccessibilityDelegate(new QTVoiceAssistantAsButton());
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
        AbstractC6670b.m4765z(new Object[]{str2, str3, str, spenSettingPenResource3 != null ? spenSettingPenResource3.getName() : null, Integer.valueOf(colorMaskId)}, 5, "setState(selected=%s, animation=%s) AnimatedDrawable=%s, Pen[%s], maskId=%d ", "format(...)", TAG);
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

    public final float getParticleSize() {
        return 0.0f;
    }

    /* JADX INFO: renamed from: getPenColor, reason: from getter */
    public final int getMColor() {
        return this.mColor;
    }

    @Nullable
    public final String getPenName() {
        if (getTag() == null) {
            return null;
        }
        Object tag = getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        return (String) tag;
    }

    public int getPenSizeLevel() {
        return 0;
    }

    public final boolean hasPenResourceInfo() {
        return this.mPenResource != null;
    }

    public final boolean isFixedWidth() {
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 0) {
            View.inflate(getContext(), C9086R.layout.setting_pen_view_v2, this);
        }
        initView();
        updatePenView(this.mPenResource);
        updateColorMask(this.mColor);
    }

    public final void setFixedWidth(boolean isFixedWidth) {
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

    public final void setParticleSize(float particleSize) {
    }

    public final void setPenColor(int color) {
        this.mColor = color;
        updateColorMask(color);
    }

    public final void setPenColorEnabled(boolean enable) {
    }

    public boolean setPenInfo(@NotNull String penName, int color, int sizeLevel, float particleSize, boolean isFixedWidth) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (this.mPenResource == null) {
            return false;
        }
        if (getTag() == null || !Intrinsics.areEqual(penName, getTag().toString())) {
            Log.i(TAG, "If you want to change the pen, please put the pen resource first.");
            return false;
        }
        setPenColor(color);
        return true;
    }

    public void setPenResourceInfo(@NotNull SpenSettingPenResource penResource) {
        Intrinsics.checkNotNullParameter(penResource, "penResource");
        setPenResourceInfo(penResource, true);
    }

    public void setPenSizeLevel(int sizeLevel) {
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
    public QTPenBaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    public final void setSelected(boolean selected, boolean animation) {
        AbstractC6670b.m4758s("setSelected() selected=", " animation=", TAG, selected, animation);
        super.setSelected(selected);
        setState(selected, animation);
    }
}
