package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.menubar.setting;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenColorData;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\b\u0010\u0013\u001a\u00020\rH\u0007J!\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenColor;", "", "<init>", "()V", "mPenColorView", "Landroid/view/View;", "mPenColorData", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/PenColorData;", "mSettingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/ISettingViewManager;", "mDetector", "Landroid/view/GestureDetector;", "setPenColorView", "", "penColorView", "setPenColorData", "settingPenColorData", "setSettingViewManager", "settingViewManager", Constants.ARG_UPDATE, "updatePenColor", "view", "color", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "updatePenDescription", "description", "", "performOnClick", "GestureListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingPenColor {

    @NotNull
    private static final String TAG = SOLogger.createTag("SettingPenColor");

    @Nullable
    private GestureDetector mDetector;

    @Nullable
    private PenColorData mPenColorData;

    @Nullable
    private View mPenColorView;

    @Nullable
    private ISettingViewManager mSettingViewManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenColor$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/menubar/setting/SettingPenColor;)V", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            SettingPenColor.this.performOnClick();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performOnClick() {
        PenColorData penColorData = this.mPenColorData;
        int color = penColorData != null ? penColorData.getColor() : 0;
        AbstractC8014b.m7208j("performOnClick, color ", Integer.toHexString(color), SOLogger.INSTANCE, TAG);
        ISettingViewManager iSettingViewManager = this.mSettingViewManager;
        if (iSettingViewManager != null) {
            iSettingViewManager.onUpdatedPenColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean update$lambda$0(SettingPenColor settingPenColor, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = settingPenColor.mDetector;
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    private final void updatePenColor(View view, Integer color) {
        Drawable background = view != null ? view.getBackground() : null;
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.mutate();
        gradientDrawable.setColor(color != null ? color.intValue() : 0);
    }

    private final void updatePenDescription(View view, String description) {
        if (view != null) {
            view.setContentDescription(description);
        }
    }

    public final void setPenColorData(@NotNull PenColorData settingPenColorData) {
        Intrinsics.checkNotNullParameter(settingPenColorData, "settingPenColorData");
        this.mPenColorData = settingPenColorData;
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        View view = this.mPenColorView;
        PenColorData penColorData = this.mPenColorData;
        companion.setTooltipText(view, penColorData != null ? penColorData.getDescription() : null);
    }

    public final void setPenColorView(@Nullable View penColorView) {
        View viewFindViewById;
        this.mPenColorView = penColorView;
        if (penColorView != null && (viewFindViewById = penColorView.findViewById(C9086R.id.pen_color_item)) != null) {
            viewFindViewById.setEnabled(false);
        }
        View view = this.mPenColorView;
        this.mDetector = new GestureDetector(view != null ? view.getContext() : null, new GestureListener());
    }

    public final void setSettingViewManager(@Nullable ISettingViewManager settingViewManager) {
        this.mSettingViewManager = settingViewManager;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void update() {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        PenColorData penColorData = this.mPenColorData;
        String strM1624n = AbstractC2322a.m1624n("#%06X", new Object[]{Integer.valueOf((penColorData != null ? penColorData.getColor() : 0) & 16777215)}, 1, "format(...)");
        PenColorData penColorData2 = this.mPenColorData;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("update, color/detDescription ", strM1624n, "/", penColorData2 != null ? penColorData2.getDescription() : null));
        View view = this.mPenColorView;
        View viewFindViewById = view != null ? view.findViewById(C9086R.id.pen_color_item) : null;
        PenColorData penColorData3 = this.mPenColorData;
        updatePenColor(viewFindViewById, penColorData3 != null ? Integer.valueOf(penColorData3.getColor()) : null);
        View view2 = this.mPenColorView;
        PenColorData penColorData4 = this.mPenColorData;
        updatePenDescription(view2, penColorData4 != null ? penColorData4.getDescription() : null);
        View view3 = this.mPenColorView;
        if (view3 != null) {
            view3.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 23));
        }
        View view4 = this.mPenColorView;
        if (view4 != null) {
            view4.setOnClickListener(new ViewOnClickListenerC8556a(this, 25));
        }
    }
}
