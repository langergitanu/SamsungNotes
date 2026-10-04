package com.samsung.android.sdk.pen.widget;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010!\u001a\u00020 J\u0010\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u0015J\b\u0010$\u001a\u00020 H\u0002J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010'H\u0004J\u0018\u0010)\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010'R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mView", "mBubbleTopView", "Landroid/widget/ImageView;", "mBubbleBottomView", "value", "", "isShowing", "()Z", "mListener", "Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton$ActionListener;", "mHandler", "Landroid/os/Handler;", "MESSAGE_WHAT_HIDE", "MESSAGE_WHAT_SHOW", "MESSAGE_WHAT_GONE", "DELAY_TIME", "mWidth", "mHeight", "mIsRTL", "init", "", "close", "setListener", "l", "click", "onShow", "pos", "Landroid/graphics/RectF;", "showImpl", Constants.IntentExtraValue.SHOW, "textPosition", "ActionListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenFloatingTagConfirmButton extends RelativeLayout {
    private static final boolean SUPPORT_TOOLTIP;

    @NotNull
    private static final String TAG = "FloatingTagButton";
    private final int DELAY_TIME;
    private final int MESSAGE_WHAT_GONE;
    private final int MESSAGE_WHAT_HIDE;
    private final int MESSAGE_WHAT_SHOW;
    private boolean isShowing;

    @Nullable
    private ImageView mBubbleBottomView;

    @Nullable
    private ImageView mBubbleTopView;

    @Nullable
    private Handler mHandler;
    private int mHeight;
    private boolean mIsRTL;

    @Nullable
    private ActionListener mListener;

    @Nullable
    private RelativeLayout mView;
    private int mWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenFloatingTagConfirmButton$ActionListener;", "", "onConfirmed", "", "allow", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onConfirmed(boolean allow);
    }

    static {
        SUPPORT_TOOLTIP = Build.VERSION.SDK_INT > 26;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFloatingTagConfirmButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MESSAGE_WHAT_HIDE = 1;
        this.MESSAGE_WHAT_SHOW = 2;
        this.MESSAGE_WHAT_GONE = 3;
        this.DELAY_TIME = 3000;
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void click() {
        Log.d(TAG, "onClick");
        showImpl(false, null);
        ActionListener actionListener = this.mListener;
        if (actionListener != null) {
            actionListener.onConfirmed(true);
        }
    }

    private final void init(Context context) {
        this.mIsRTL = AbstractC0541b.m759a(context) == 1;
        this.mWidth = context.getResources().getDimensionPixelSize(C7932R.dimen.sdk_floating_tag_confirm_bubble_width);
        this.mHeight = context.getResources().getDimensionPixelSize(C7932R.dimen.sdk_floating_tag_confirm_bubble_height);
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.sdk.pen.widget.SpenFloatingTagConfirmButton.init.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                int i = msg.what;
                if (i == SpenFloatingTagConfirmButton.this.MESSAGE_WHAT_HIDE) {
                    SpenFloatingTagConfirmButton.this.show(false, null);
                    return;
                }
                if (i != SpenFloatingTagConfirmButton.this.MESSAGE_WHAT_SHOW) {
                    if (i == SpenFloatingTagConfirmButton.this.MESSAGE_WHAT_GONE) {
                        SpenFloatingTagConfirmButton.this.setVisibility(8);
                    }
                } else {
                    Object obj = msg.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.RectF");
                    SpenFloatingTagConfirmButton.this.onShow((RectF) obj);
                }
            }
        };
        View viewInflate = View.inflate(context, C7932R.layout.sdk_floating_tag_confirm_bubble_layout, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
        this.mView = relativeLayout;
        addView(relativeLayout);
        RelativeLayout relativeLayout2 = this.mView;
        if (relativeLayout2 != null) {
            ImageView imageView = (ImageView) relativeLayout2.findViewById(C7932R.id.tag_confirm_top_button);
            this.mBubbleTopView = imageView;
            if (imageView != null) {
                if (SUPPORT_TOOLTIP) {
                    imageView.setTooltipText(getContext().getString(C7932R.string.tag_confirm_button_description));
                } else {
                    imageView.setContentDescription(getContext().getString(C7932R.string.tag_confirm_button_description));
                }
                final int i = 0;
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.widget.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenFloatingTagConfirmButton f5123b;

                    {
                        this.f5123b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                this.f5123b.click();
                                break;
                            default:
                                this.f5123b.click();
                                break;
                        }
                    }
                });
            }
            ImageView imageView2 = (ImageView) relativeLayout2.findViewById(C7932R.id.tag_confirm_bottom_button);
            this.mBubbleBottomView = imageView2;
            if (imageView2 != null) {
                if (SUPPORT_TOOLTIP) {
                    imageView2.setTooltipText(getContext().getString(C7932R.string.tag_confirm_button_description));
                } else {
                    imageView2.setContentDescription(getContext().getString(C7932R.string.tag_confirm_button_description));
                }
                final int i2 = 1;
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.widget.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenFloatingTagConfirmButton f5123b;

                    {
                        this.f5123b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                this.f5123b.click();
                                break;
                            default:
                                this.f5123b.click();
                                break;
                        }
                    }
                });
            }
        }
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShow(RectF pos) {
        if (pos == null) {
            Log.e(TAG, "onShow : textPosition is null");
            return;
        }
        float f = pos.top;
        int i = this.mHeight;
        if (f > i) {
            setY(f - i);
            ImageView imageView = this.mBubbleTopView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mBubbleBottomView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else {
            setY(pos.bottom);
            ImageView imageView3 = this.mBubbleTopView;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mBubbleBottomView;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
        }
        setX(this.mIsRTL ? pos.right - this.mWidth : pos.right);
        setVisibility(0);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(this.MESSAGE_WHAT_HIDE, this.DELAY_TIME);
        }
    }

    public final void close() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        removeAllViews();
        this.mView = null;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final void setListener(@Nullable ActionListener l) {
        this.mListener = l;
    }

    public final void show(boolean show, @Nullable RectF textPosition) {
        ActionListener actionListener;
        boolean z = show != this.isShowing;
        if (show || z) {
            showImpl(show, textPosition);
        }
        if (show || (actionListener = this.mListener) == null) {
            return;
        }
        actionListener.onConfirmed(false);
    }

    public final void showImpl(boolean show, @Nullable RectF textPosition) {
        AbstractC6670b.m4759t("showImpl :", TAG, show);
        if (this.mView == null) {
            return;
        }
        if (show && textPosition == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            if (show) {
                Message message = new Message();
                message.what = this.MESSAGE_WHAT_SHOW;
                message.obj = textPosition;
                handler.sendMessage(message);
            } else {
                handler.sendEmptyMessage(this.MESSAGE_WHAT_GONE);
            }
        }
        this.isShowing = show;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFloatingTagConfirmButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MESSAGE_WHAT_HIDE = 1;
        this.MESSAGE_WHAT_SHOW = 2;
        this.MESSAGE_WHAT_GONE = 3;
        this.DELAY_TIME = 3000;
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFloatingTagConfirmButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.MESSAGE_WHAT_HIDE = 1;
        this.MESSAGE_WHAT_SHOW = 2;
        this.MESSAGE_WHAT_GONE = 3;
        this.DELAY_TIME = 3000;
        init(context);
    }
}
