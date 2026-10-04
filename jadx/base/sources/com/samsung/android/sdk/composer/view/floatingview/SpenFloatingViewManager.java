package com.samsung.android.sdk.composer.view.floatingview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.widget.TextViewCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.spen.C7932R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0007J*\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/floatingview/SpenFloatingViewManager;", "", "mView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mNativeViewId", "", "mRect", "Landroid/graphics/RectF;", "close", "", "onAddFloatingTextView", "rect", "description", "", "fontSize", "", "isUrlText", "", "nativeViewId", "onAddFloatingImageButton", "onAddFloatingImageView", "bitmap", "Landroid/graphics/Bitmap;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/view/floatingview/SpenImageFloatingViewListener;", "removeFloatingView", "getLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "parentLayout", "Landroid/view/ViewGroup;", "onHoverEvent", "event", "Landroid/view/MotionEvent;", "isLinkPreviewSupported", "url", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenFloatingViewManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenFloatingViewManager.kt\ncom/samsung/android/sdk/composer/view/floatingview/SpenFloatingViewManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,190:1\n1#2:191\n*E\n"})
public final class SpenFloatingViewManager {

    @NotNull
    private static final String[] LINK_PREVIEW_EXCEPTION_PATTERN;
    private static final boolean SUPPORT_TOOLTIP;

    @NotNull
    private static final String TAG = "SpenFloatingViewManager";
    private int mNativeViewId;

    @Nullable
    private RectF mRect;

    @Nullable
    private View mView;

    static {
        SUPPORT_TOOLTIP = Build.VERSION.SDK_INT > 26;
        LINK_PREVIEW_EXCEPTION_PATTERN = new String[]{"^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+"};
    }

    public SpenFloatingViewManager(@Nullable View view) {
        this.mView = view;
    }

    private final RelativeLayout.LayoutParams getLayoutParams(RectF rect, ViewGroup parentLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) rect.width(), (int) rect.height());
        layoutParams.leftMargin = (int) rect.left;
        layoutParams.topMargin = (int) Math.ceil(rect.top);
        layoutParams.rightMargin = (int) (parentLayout.getWidth() - (rect.width() + rect.left));
        return layoutParams;
    }

    private final boolean isLinkPreviewSupported(String url) {
        if (url == null || url.length() == 0) {
            return false;
        }
        for (String str : LINK_PREVIEW_EXCEPTION_PATTERN) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = url.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (new Regex(str).matches(lowerCase)) {
                return false;
            }
        }
        return true;
    }

    public final void close() {
        this.mView = null;
    }

    public final void onAddFloatingImageButton(@NotNull RectF rect, @Nullable String description, int nativeViewId) {
        Context context;
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.mNativeViewId == nativeViewId) {
            return;
        }
        removeFloatingView();
        View view = this.mView;
        SpenFloatingImageButton spenFloatingImageButton = null;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        View view2 = this.mView;
        if (view2 != null && (context = view2.getContext()) != null) {
            spenFloatingImageButton = new SpenFloatingImageButton(context);
        }
        if (spenFloatingImageButton != null) {
            spenFloatingImageButton.setLayoutParams(getLayoutParams(rect, viewGroup));
            if (SUPPORT_TOOLTIP) {
                spenFloatingImageButton.setTooltipText(description);
            } else {
                spenFloatingImageButton.setContentDescription(description);
            }
            spenFloatingImageButton.setAlpha(0.0f);
            spenFloatingImageButton.setNativeViewId(nativeViewId);
            viewGroup.addView(spenFloatingImageButton);
            View view3 = this.mView;
            if (view3 != null) {
                view3.invalidate();
            }
            this.mRect = rect;
            this.mNativeViewId = nativeViewId;
        }
    }

    public final void onAddFloatingImageView(@NotNull RectF rect, @Nullable Bitmap bitmap, @Nullable SpenImageFloatingViewListener listener, int nativeViewId) {
        Resources resources;
        Context context;
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.mNativeViewId == nativeViewId) {
            return;
        }
        removeFloatingView();
        if (bitmap == null) {
            return;
        }
        View view = this.mView;
        SpenFloatingImageView spenFloatingImageView = null;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        View view2 = this.mView;
        if (view2 != null && (context = view2.getContext()) != null) {
            spenFloatingImageView = new SpenFloatingImageView(context, nativeViewId);
        }
        if (spenFloatingImageView != null) {
            spenFloatingImageView.setLayoutParams(getLayoutParams(rect, viewGroup));
            View view3 = this.mView;
            spenFloatingImageView.setElevation((view3 == null || (resources = view3.getResources()) == null) ? 8.0f : resources.getDimension(C7932R.dimen.sticky_note_hover_preview_elevation));
            spenFloatingImageView.setClipToOutline(true);
            spenFloatingImageView.setBackgroundColor(MarketingConstants.PopupConst.DEFAULT_COLOR_BACKGROUND);
            spenFloatingImageView.setImageBitmap(bitmap);
            spenFloatingImageView.setListener(listener);
            viewGroup.addView(spenFloatingImageView);
            View view4 = this.mView;
            if (view4 != null) {
                view4.invalidate();
            }
            this.mRect = rect;
            this.mNativeViewId = nativeViewId;
        }
    }

    public final void onAddFloatingTextView(@NotNull RectF rect, @Nullable String description, float fontSize, boolean isUrlText, int nativeViewId) {
        Context context;
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.mNativeViewId == nativeViewId) {
            return;
        }
        removeFloatingView();
        View view = this.mView;
        SpenFloatingTextView spenFloatingTextView = null;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        View view2 = this.mView;
        if (view2 != null && (context = view2.getContext()) != null) {
            spenFloatingTextView = new SpenFloatingTextView(context);
        }
        RelativeLayout.LayoutParams layoutParams = getLayoutParams(rect, viewGroup);
        if (spenFloatingTextView != null) {
            spenFloatingTextView.setLayoutParams(layoutParams);
            spenFloatingTextView.setTextSize(fontSize);
            TextViewCompat.setAutoSizeTextTypeWithDefaults(spenFloatingTextView, 1);
            spenFloatingTextView.setAlpha(0.0f);
            if (isUrlText) {
                SpannableString spannableString = new SpannableString(description);
                spannableString.setSpan(new URLSpan(description), 0, description != null ? description.length() : 0, 33);
                spenFloatingTextView.setText(spannableString);
                spenFloatingTextView.setLinkPreviewEnabled(isLinkPreviewSupported(spannableString.toString()));
            } else {
                spenFloatingTextView.setText(description);
                spenFloatingTextView.setSingleLine();
            }
            spenFloatingTextView.setNativeViewId(nativeViewId);
            viewGroup.addView(spenFloatingTextView);
            View view3 = this.mView;
            if (view3 != null) {
                view3.invalidate();
            }
            this.mRect = rect;
            this.mNativeViewId = nativeViewId;
        }
    }

    public final void onHoverEvent(@NotNull MotionEvent event) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mNativeViewId == 0 || (rectF = this.mRect) == null) {
            return;
        }
        int action = event.getAction();
        if (action != 7) {
            if (action != 10) {
                return;
            }
            removeFloatingView();
        } else {
            if (rectF.contains(event.getX(), event.getY())) {
                return;
            }
            removeFloatingView();
        }
    }

    public final boolean removeFloatingView() {
        if (this.mNativeViewId == 0) {
            return false;
        }
        View view = this.mView;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                if (childAt instanceof SpenFloatingTextView) {
                    SpenFloatingTextView spenFloatingTextView = (SpenFloatingTextView) childAt;
                    if (this.mNativeViewId == spenFloatingTextView.getNativeViewId()) {
                        spenFloatingTextView.close();
                    }
                    this.mNativeViewId = 0;
                    this.mRect = null;
                    return true;
                }
                if (childAt instanceof SpenFloatingImageButton) {
                    SpenFloatingImageButton spenFloatingImageButton = (SpenFloatingImageButton) childAt;
                    if (this.mNativeViewId == spenFloatingImageButton.getNativeViewId()) {
                        spenFloatingImageButton.close();
                    }
                    this.mNativeViewId = 0;
                    this.mRect = null;
                    return true;
                }
                if (childAt instanceof SpenFloatingImageView) {
                    SpenFloatingImageView spenFloatingImageView = (SpenFloatingImageView) childAt;
                    if (this.mNativeViewId == ((int) spenFloatingImageView.getMNativeHolder())) {
                        spenFloatingImageView.close();
                        this.mNativeViewId = 0;
                        this.mRect = null;
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
