package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\"\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthMiniLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mIcon", "Landroid/widget/ImageView;", "mIsFixedWidth", "", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayoutInterface$OnDataChangedListener;", "close", "", "onFinishInflate", "setPenInfo", "penName", "", "sizeLevel", "", "color", "setPenWidth", "isFixed", "needAnimation", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initView", "layoutResource", "setFixedWidth", "isFixedWidth", "setIconInfo", "resId", "stringId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenWidthMiniLayout extends FrameLayout implements SpenPenWidthLayoutInterface {

    @NotNull
    private static final String TAG = "SpenPenWidthMiniView";

    @Nullable
    private SpenPenWidthLayoutInterface.OnDataChangedListener mDataChangedListener;

    @Nullable
    private ImageView mIcon;
    private boolean mIsFixedWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenWidthMiniLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(Context context, int layoutResource) {
        if (layoutResource != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutResource, (ViewGroup) this, true);
        }
        this.mIcon = (ImageView) findViewById(C7932R.id.width_view);
        setFixedWidth(this.mIsFixedWidth, false);
        ImageView imageView = this.mIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new ViewOnClickListenerC7538b(this, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenPenWidthMiniLayout spenPenWidthMiniLayout, View view) {
        spenPenWidthMiniLayout.setFixedWidth(!spenPenWidthMiniLayout.mIsFixedWidth, true);
        SpenPenWidthLayoutInterface.OnDataChangedListener onDataChangedListener = spenPenWidthMiniLayout.mDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onPenWidthChanged(spenPenWidthMiniLayout.mIsFixedWidth);
        }
    }

    private final void setFixedWidth(boolean isFixedWidth, boolean needAnimation) {
        AbstractC6670b.m4758s("setPenWidth() isFixedWidth=", " needAnimation=", TAG, isFixedWidth, needAnimation);
        this.mIsFixedWidth = isFixedWidth;
        if (isFixedWidth) {
            setIconInfo(C7932R.drawable.pressure_off, C7932R.string.pen_string_fixed_thickness);
        } else {
            setIconInfo(C7932R.drawable.pressure_on, C7932R.string.pen_string_variable_thickness);
        }
    }

    private final void setIconInfo(int resId, int stringId) {
        ImageView imageView = this.mIcon;
        if (imageView == null) {
            return;
        }
        Intrinsics.checkNotNull(imageView);
        imageView.setImageResource(resId);
        ImageView imageView2 = this.mIcon;
        Intrinsics.checkNotNull(imageView2);
        String string = imageView2.getContext().getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ImageView imageView3 = this.mIcon;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(this.mIcon, string);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void close() {
        this.mIcon = null;
        this.mDataChangedListener = null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getChildCount() == 0 ? C7932R.layout.setting_pen_width_mini_layout : 0);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setDataChangedListener(@Nullable SpenPenWidthLayoutInterface.OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenWidth(boolean isFixed, boolean needAnimation) {
        AbstractC6670b.m4758s("setPenWidth() isFixedWidth=", " needAnimation=", TAG, isFixed, needAnimation);
        if (this.mIcon == null || this.mIsFixedWidth == isFixed) {
            return;
        }
        setFixedWidth(isFixed, needAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface
    public void setPenInfo(@Nullable String penName, int sizeLevel, int color) {
    }
}
