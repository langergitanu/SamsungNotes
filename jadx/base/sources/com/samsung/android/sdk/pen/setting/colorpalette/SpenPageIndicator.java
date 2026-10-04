package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.compose.p109ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator;
import com.samsung.android.sdk.pen.setting.common.SpenTouchDelegateComposite;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000 O2\u00020\u0001:\u0002OPB!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ0\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0014J\b\u0010&\u001a\u00020 H\u0016J \u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016J,\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010+\u001a\u00020 2\u0006\u00107\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00108\u001a\u00020 H\u0014J\u0018\u00105\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0007H\u0004J\u001c\u0010:\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u00182\b\u0010<\u001a\u0004\u0018\u000100H\u0004J\u0012\u0010=\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020\u0005H\u0004J \u0010>\u001a\u00020 2\u0006\u0010;\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0004J\u0016\u0010B\u001a\u00020 2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00180DH\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010;\u001a\u00020?H\u0002J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010;\u001a\u00020?H\u0002J \u0010H\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u00020 2\u0006\u0010;\u001a\u00020?H\u0002R\u001e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u00103\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\u000e\"\u0004\b5\u00106R\u0014\u0010J\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u000e¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "defaultIndicatorResources", "", "supportAction", "", "<init>", "(Landroid/content/Context;IZ)V", "(Landroid/content/Context;I)V", "value", "defaultSize", "getDefaultSize", "()I", "mSpace", "mCurrent", "mContext", "defaultResId", "getDefaultResId", "isSupportAction", "()Z", "mIndicators", "", "Landroid/widget/ImageView;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator$ActionListener;", "mTouchDelegateComposite", "Lcom/samsung/android/sdk/pen/setting/common/SpenTouchDelegateComposite;", "mIndicatorClickListener", "Landroid/view/View$OnClickListener;", "onLayout", "", "changed", "left", "top", "right", "bottom", "close", "setInfo", "size", "space", "count", "updateIndicator", "position", "background", "Landroid/graphics/drawable/Drawable;", "hoverDescription", "", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "active", "getActive", "setActive", "(I)V", "indicator", "updateAllIndicatorDescription", "updateAccessibility", "setHoverDescription", "view", "description", "getIndicatorView", "setIndicatorDescription", "Landroid/view/View;", "current", ImportHandler.KEY_TOTAL, "adjustTouchTarget", "children", "", "getViewHitRect", "Landroid/graphics/Rect;", "getPosition", "setItemActive", "enable", "prevIndicator", "getPrevIndicator", "addIndicator", "index", "setIndicatorAction", "Companion", "ActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPageIndicator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPageIndicator.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,267:1\n1#2:268\n*E\n"})
public class SpenPageIndicator extends LinearLayout {

    @NotNull
    private static final String TAG = "SpenPageIndicator";
    private final int defaultResId;
    private int defaultSize;
    private final boolean isSupportAction;

    @Nullable
    private ActionListener mActionListener;

    @NotNull
    private Context mContext;
    private int mCurrent;

    @NotNull
    private final View.OnClickListener mIndicatorClickListener;

    @Nullable
    private List<ImageView> mIndicators;
    private int mSpace;

    @Nullable
    private SpenTouchDelegateComposite mTouchDelegateComposite;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPageIndicator$ActionListener;", "", "onIndicatorClicked", "", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onIndicatorClicked(int position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenPageIndicator(@NotNull Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ImageView addIndicator(int index) {
        Log.i(TAG, "addIndicator() index=" + index);
        ImageView imageView = new ImageView(this.mContext);
        updateIndicator(imageView, getResources().getDrawable(this.defaultResId, null), null);
        int i = this.defaultSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        imageView.setId(View.generateViewId());
        if (getPrevIndicator() > -1) {
            if (getOrientation() == 0) {
                layoutParams.setMarginStart(this.mSpace);
            } else {
                layoutParams.topMargin = this.mSpace;
            }
        }
        imageView.setSelected(false);
        addView(imageView, layoutParams);
        if (this.isSupportAction) {
            setIndicatorAction(imageView);
        }
        return imageView;
    }

    private final void adjustTouchTarget(Iterator<? extends ImageView> children) {
        Log.i(TAG, "adjustTouchTarget()");
        SpenTouchDelegateComposite spenTouchDelegateComposite = this.mTouchDelegateComposite;
        if (spenTouchDelegateComposite != null) {
            int i = this.mSpace / 2;
            int i2 = this.defaultSize / 2;
            boolean z = false;
            while (children.hasNext()) {
                ImageView next = children.next();
                Rect viewHitRect = getViewHitRect(next);
                viewHitRect.top -= i2;
                viewHitRect.left -= z ? i : i2;
                viewHitRect.right += children.hasNext() ? i : i2;
                viewHitRect.bottom += i2;
                spenTouchDelegateComposite.addDelegate(next, new TouchDelegate(viewHitRect, next));
                z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPosition(View view) {
        List<ImageView> list = this.mIndicators;
        if (list != null) {
            return CollectionsKt.indexOf((List<? extends View>) list, view);
        }
        return -1;
    }

    private final int getPrevIndicator() {
        int size;
        List<ImageView> list = this.mIndicators;
        if (list == null || (size = list.size()) <= 0) {
            return -1;
        }
        return list.get(size - 1).getId();
    }

    private final Rect getViewHitRect(View view) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        return rect;
    }

    private final void setIndicatorAction(View view) {
        view.setImportantForAccessibility(1);
        view.setOnClickListener(this.mIndicatorClickListener);
        view.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator.setIndicatorAction.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                super.onInitializeAccessibilityEvent(host, event);
                event.setClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
            }
        });
    }

    private final void setItemActive(int position, boolean enable, boolean updateAccessibility) {
        List<ImageView> list = this.mIndicators;
        if (list != null) {
            if (position < 0 || position >= list.size()) {
                AbstractC2322a.m1631u(position, "invalid position=", TAG);
                return;
            }
            ImageView imageView = list.get(position);
            imageView.setSelected(enable);
            if (updateAccessibility) {
                setIndicatorDescription(imageView, position + 1, list.size());
            }
        }
    }

    public void close() {
        List<ImageView> list = this.mIndicators;
        if (list != null) {
            list.clear();
        }
        this.mIndicators = null;
        SpenTouchDelegateComposite spenTouchDelegateComposite = this.mTouchDelegateComposite;
        if (spenTouchDelegateComposite != null) {
            spenTouchDelegateComposite.close();
        }
        this.mTouchDelegateComposite = null;
        this.mActionListener = null;
    }

    /* JADX INFO: renamed from: getActive, reason: from getter */
    public int getMCurrent() {
        return this.mCurrent;
    }

    public final int getDefaultResId() {
        return this.defaultResId;
    }

    public final int getDefaultSize() {
        return this.defaultSize;
    }

    @Nullable
    public final ImageView getIndicatorView(int position) {
        List<ImageView> list = this.mIndicators;
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    /* JADX INFO: renamed from: isSupportAction, reason: from getter */
    public final boolean getIsSupportAction() {
        return this.isSupportAction;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        List<ImageView> list;
        super.onLayout(changed, left, top, right, bottom);
        if (this.isSupportAction && changed && (list = this.mIndicators) != null) {
            adjustTouchTarget(list.iterator());
        }
    }

    public void setActionListener(@Nullable ActionListener listener) {
        this.mActionListener = listener;
    }

    public void setActive(int i) {
        setActive(i, this.isSupportAction);
    }

    public final void setHoverDescription(@Nullable ImageView view, @Nullable CharSequence description) {
        SpenSettingUtilHover.setHoverText(view, description);
    }

    public final void setIndicatorDescription(@NotNull View view, int current, int total) {
        Intrinsics.checkNotNullParameter(view, "view");
        StringBuilder sb = new StringBuilder(getContext().getString(C7932R.string.pen_string_page_indicator, Integer.valueOf(current), Integer.valueOf(total)));
        if (view.isSelected()) {
            sb.append(",");
            sb.append(getContext().getString(C7932R.string.pen_string_current_page));
        }
        view.setContentDescription(sb.toString());
    }

    public void setInfo(int size, int space, int count) {
        if (this.mIndicators == null) {
            this.mIndicators = new ArrayList();
        }
        List<ImageView> list = this.mIndicators;
        if (list != null) {
            list.clear();
        }
        removeAllViews();
        this.mCurrent = 0;
        this.mSpace = space;
        this.defaultSize = size;
        SpenTouchDelegateComposite spenTouchDelegateComposite = this.mTouchDelegateComposite;
        if (spenTouchDelegateComposite != null) {
            spenTouchDelegateComposite.removeAllDelegate();
        }
        int i = 0;
        while (i < count) {
            ImageView imageViewAddIndicator = addIndicator(i);
            if (getOrientation() == 0) {
                List<ImageView> list2 = this.mIndicators;
                if (list2 != null) {
                    list2.add(imageViewAddIndicator);
                }
            } else {
                List<ImageView> list3 = this.mIndicators;
                if (list3 != null) {
                    list3.add(0, imageViewAddIndicator);
                }
            }
            imageViewAddIndicator.setSelected(i == this.mCurrent);
            i++;
        }
        if (this.isSupportAction) {
            updateAllIndicatorDescription();
        }
    }

    public void updateAllIndicatorDescription() {
        List<ImageView> list;
        if (this.isSupportAction && (list = this.mIndicators) != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                ImageView imageView = list.get(i);
                i++;
                setIndicatorDescription(imageView, i, size);
            }
        }
    }

    public boolean updateIndicator(int position, int size, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
        List<ImageView> list;
        if (size == 0 || (list = this.mIndicators) == null) {
            return false;
        }
        ImageView imageView = list.get(position);
        updateIndicator(imageView, background, hoverDescription);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = size;
        layoutParams2.height = size;
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private SpenPageIndicator(Context context, int i, final boolean z) {
        super(context);
        this.mIndicatorClickListener = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPageIndicator$mIndicatorClickListener$1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int position;
                SpenPageIndicator.ActionListener actionListener;
                Intrinsics.checkNotNullParameter(v, "v");
                if (!z || this.mActionListener == null || (position = this.getPosition(v)) == -1 || this.mCurrent == position || (actionListener = this.mActionListener) == null) {
                    return;
                }
                actionListener.onIndicatorClicked(position);
            }
        };
        this.mContext = context;
        this.defaultResId = i == 0 ? C7932R.drawable.color_palette_v70_default_indicator : i;
        this.isSupportAction = z;
        if (z) {
            SpenTouchDelegateComposite spenTouchDelegateComposite = new SpenTouchDelegateComposite(this);
            this.mTouchDelegateComposite = spenTouchDelegateComposite;
            setTouchDelegate(spenTouchDelegateComposite);
        }
        AbstractC4539a.m3208r("supportAction=", TAG, z);
    }

    public final void setActive(int position, boolean updateAccessibility) {
        int i = this.mCurrent;
        if (i == position) {
            AbstractC2322a.m1631u(position, "same position=", TAG);
            return;
        }
        setItemActive(i, false, updateAccessibility);
        setItemActive(position, true, updateAccessibility);
        this.mCurrent = position;
    }

    public void updateIndicator(@NotNull ImageView indicator, @Nullable Drawable background, @Nullable CharSequence hoverDescription) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        indicator.setBackground(background);
        setHoverDescription(indicator, hoverDescription);
    }

    public /* synthetic */ SpenPageIndicator(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenPageIndicator(@NotNull Context context, int i) {
        this(context, i, true);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
