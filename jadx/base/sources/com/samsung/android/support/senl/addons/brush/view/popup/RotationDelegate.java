package com.samsung.android.support.senl.addons.brush.view.popup;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.material.bottomappbar.RunnableC4587a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.binding.adapters.BARotationView;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH\u0002J(\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/RotationDelegate;", "", "<init>", "()V", "mLastEvent", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "setRotationEvent", "", "event", "rotate", "view", "Lcom/samsung/android/support/senl/addons/brush/view/popup/IBrushSettingPopupView;", "type", "", "target", "Landroid/view/View;", "hideAnimation", "", "onShow", "updateSize", "setSize", "w", "h", "resetTranslation", "setWidth", "margin", "setHeight", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RotationDelegate {

    @NotNull
    private static final String TAG = Logger.createBrushTag("RotationDelegate");

    @Nullable
    private IRotationEvent mLastEvent;

    private final void resetTranslation(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setHeight(IBrushSettingPopupView view, int margin, int h, int type) {
        if (view instanceof View) {
            String str = TAG;
            Logger.m7105w(str, "setHeight : " + h);
            View view2 = (View) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (margin != 0) {
                if ((type & 1) != 0) {
                    marginLayoutParams.bottomMargin = margin;
                    Logger.m7105w(str, "setHeight - set bottom Margin: " + margin);
                } else if ((type & 2) != 0) {
                    marginLayoutParams.topMargin = margin;
                    Logger.m7105w(str, "setHeight - set top Margin: " + margin);
                }
            }
            marginLayoutParams.height = h;
            view2.setLayoutParams(marginLayoutParams);
            view2.post(new RunnableC4587a(view2, 8));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSize(IBrushSettingPopupView view, int w, int h) {
        if (view instanceof View) {
            View view2 = (View) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = w;
            marginLayoutParams.height = h;
            view2.setLayoutParams(marginLayoutParams);
            resetTranslation(view2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setWidth(IBrushSettingPopupView view, int margin, int w, int type) {
        if (view instanceof View) {
            String str = TAG;
            Logger.m7105w(str, "setWidth : " + w);
            View view2 = (View) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (margin != 0) {
                if ((type & 4) != 0) {
                    marginLayoutParams.setMarginEnd(margin);
                    Logger.m7105w(str, "setWidth - set end Margin: " + margin);
                } else if ((type & 8) != 0) {
                    marginLayoutParams.setMarginStart(margin);
                    Logger.m7105w(str, "setWidth - set start Margin: " + margin);
                }
            }
            marginLayoutParams.width = w;
            view2.setLayoutParams(marginLayoutParams);
            view2.post(new RunnableC4587a(view2, 7));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateSize(IBrushSettingPopupView view, int type) {
        int i;
        int i2;
        IBrushSettingPopupView iBrushSettingPopupView;
        RotationDelegate rotationDelegate;
        int i4;
        IRotationEvent iRotationEvent = this.mLastEvent;
        Intrinsics.checkNotNull(iRotationEvent);
        if (iRotationEvent.getMTarget() != 0) {
            IRotationEvent iRotationEvent2 = this.mLastEvent;
            Intrinsics.checkNotNull(iRotationEvent2);
            if (iRotationEvent2.getMTarget() != 180) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.View");
                View view2 = (View) view;
                Object parent = view2.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                View view3 = (View) parent;
                resetTranslation(view2);
                int width = view3.getWidth();
                int paddingRight = view3.getPaddingRight() + view3.getPaddingLeft();
                int horizontalMargin = view.getHorizontalMargin();
                int width2 = view2.getWidth();
                int height = view3.getHeight();
                int paddingBottom = view3.getPaddingBottom() + view3.getPaddingTop();
                int verticalMargin = view.getVerticalMargin();
                int height2 = view2.getHeight();
                view2.measure(0, 0);
                int measuredWidth = view2.getMeasuredWidth();
                int measuredHeight = view2.getMeasuredHeight();
                if (width2 == 0 || height2 == 0) {
                    height2 = measuredHeight;
                    width2 = measuredWidth;
                }
                int i5 = (height - paddingBottom) - verticalMargin;
                int i6 = (width - paddingRight) - horizontalMargin;
                String str = TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(measuredHeight, width, "calc H bound : ", " : ", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                AbstractC2821a.m2235z(sbM1173s, paddingRight, horizontalMargin, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, MarketingConstants.REFERRER_DELIMITER_U003D);
                sbM1173s.append(i6);
                sbM1173s.append(" : ");
                sbM1173s.append(height2);
                Logger.m7100d(str, sbM1173s.toString());
                StringBuilder sbM1173s2 = AbstractC0622a.m1173s(measuredWidth, height, "calc V bound : ", " : ", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                AbstractC2821a.m2235z(sbM1173s2, paddingBottom, verticalMargin, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, MarketingConstants.REFERRER_DELIMITER_U003D);
                sbM1173s2.append(i5);
                sbM1173s2.append(" : ");
                sbM1173s2.append(width2);
                Logger.m7100d(str, sbM1173s2.toString());
                Logger.m7100d(str, "bound : " + i5 + " : " + i6);
                if (width2 > i5) {
                    RotationDelegate rotationDelegate2 = this;
                    IBrushSettingPopupView iBrushSettingPopupView2 = view;
                    i = type;
                    rotationDelegate2.setWidth(iBrushSettingPopupView2, measuredWidth > i6 ? i6 - i5 : 0, i5, i);
                    rotationDelegate = rotationDelegate2;
                    iBrushSettingPopupView = iBrushSettingPopupView2;
                } else {
                    RotationDelegate rotationDelegate3 = this;
                    IBrushSettingPopupView iBrushSettingPopupView3 = view;
                    i = type;
                    rotationDelegate = rotationDelegate3;
                    iBrushSettingPopupView = iBrushSettingPopupView3;
                    if (measuredWidth >= width2 || measuredWidth > i6) {
                        if (i5 > measuredWidth) {
                            i2 = -measuredWidth;
                        } else {
                            i2 = i6 - i5;
                            measuredWidth = i5;
                        }
                        rotationDelegate3.setWidth(iBrushSettingPopupView3, i2, measuredWidth, i);
                        rotationDelegate = rotationDelegate3;
                        iBrushSettingPopupView = iBrushSettingPopupView3;
                    }
                }
                if (height2 > i6) {
                    rotationDelegate.setHeight(iBrushSettingPopupView, measuredHeight > i5 ? i5 - i6 : 0, i6, i);
                    return;
                }
                if (measuredHeight != height2 || measuredHeight > i5) {
                    if (i6 > measuredHeight) {
                        i4 = -measuredHeight;
                    } else if (i6 > i5) {
                        i4 = i5 - i6;
                        measuredHeight = i6;
                    } else {
                        measuredHeight = i6;
                        i4 = 0;
                    }
                    rotationDelegate.setHeight(iBrushSettingPopupView, i4, measuredHeight, i);
                    return;
                }
                return;
            }
        }
        Logger.m7105w(TAG, "update size : reset!");
        setSize(view, -2, -2);
        view.updatePosition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onShow(@NotNull IBrushSettingPopupView view, int type) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str = TAG;
        Object obj = this.mLastEvent;
        if (obj == null) {
            obj = "null";
        }
        Logger.m7100d(str, "onShow :" + obj);
        if (this.mLastEvent != null) {
            updateSize(view, type);
            IRotationEvent iRotationEvent = this.mLastEvent;
            Intrinsics.checkNotNull(iRotationEvent);
            BARotationView.setRotation((View) view, iRotationEvent, type, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void rotate(@NotNull IBrushSettingPopupView view, int type) {
        IRotationEvent iRotationEvent;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!view.isVisible() || (iRotationEvent = this.mLastEvent) == null) {
            return;
        }
        String str = TAG;
        Intrinsics.checkNotNull(iRotationEvent);
        AbstractC6670b.m4761v(iRotationEvent.getMTarget(), "rotate : ", str);
        updateSize(view, type);
        IRotationEvent iRotationEvent2 = this.mLastEvent;
        Intrinsics.checkNotNull(iRotationEvent2);
        BARotationView.setRotation((View) view, iRotationEvent2, type);
    }

    public final void setRotationEvent(@Nullable IRotationEvent event) {
        this.mLastEvent = event;
    }

    public final void onShow(@NotNull IBrushSettingPopupView view, @NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(target, "target");
        String str = TAG;
        Object obj = this.mLastEvent;
        if (obj == null) {
            obj = "null";
        }
        Logger.m7100d(str, "onShow : " + obj);
        IRotationEvent iRotationEvent = this.mLastEvent;
        if (iRotationEvent != null) {
            Intrinsics.checkNotNull(iRotationEvent);
            BARotationView.setRotation(target, iRotationEvent, type, true);
        }
    }

    public final void rotate(@NotNull IBrushSettingPopupView view, @NotNull View target, int type) {
        IRotationEvent iRotationEvent;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!view.isVisible() || (iRotationEvent = this.mLastEvent) == null) {
            return;
        }
        String str = TAG;
        Intrinsics.checkNotNull(iRotationEvent);
        AbstractC6670b.m4761v(iRotationEvent.getMTarget(), "rotate : ", str);
        IRotationEvent iRotationEvent2 = this.mLastEvent;
        Intrinsics.checkNotNull(iRotationEvent2);
        BARotationView.setRotation(target, iRotationEvent2, type, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void rotate(@NotNull IBrushSettingPopupView view, int type, boolean hideAnimation) {
        IRotationEvent iRotationEvent;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!view.isVisible() || (iRotationEvent = this.mLastEvent) == null) {
            return;
        }
        String str = TAG;
        Intrinsics.checkNotNull(iRotationEvent);
        AbstractC6670b.m4761v(iRotationEvent.getMTarget(), "reLayout : ", str);
        updateSize(view, type);
        IRotationEvent iRotationEvent2 = this.mLastEvent;
        Intrinsics.checkNotNull(iRotationEvent2);
        BARotationView.setRotation((View) view, iRotationEvent2, type, hideAnimation);
    }
}
