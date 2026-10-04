package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rB9\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J \u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\u0012\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010'\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0015J&\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J&\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006J\u0016\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006J\u0016\u00107\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006J\u001e\u00109\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0015J\u0016\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0006J\u0006\u0010A\u001a\u00020\u0017J8\u0010B\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00132\u0006\u0010D\u001a\u00020\u0006H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenRectPalette;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteInterface;", "context", "Landroid/content/Context;", "col", "", "childWidth", "childHeight", "betweenMargin", "orientation", "selectedChildCornerRadius", "<init>", "(Landroid/content/Context;IIIIII)V", "(Landroid/content/Context;IIIII)V", "mPaletteTouchControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteTouchControl;", "mChild", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBaseColorView;", "mEnableColorHover", "", "setColor", "", "childAt", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "setRes", "resInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "setInit", "setSelected", "selected", "needAnimation", "setActionListener", "actionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteActionListener;", "getSelectorDrawable", "Landroid/graphics/drawable/Drawable;", "close", "setColorHoverEnabled", "enable", "setSelectedChildLayout", "sMarginStart", "sMarginTop", "sMarginEnd", "sMarginBottom", "setUnSelectedChildLayout", "uMarginStart", "uMarginTop", "uMarginEnd", "uMarginBottom", "setSelectorSize", "width", "height", "setFixedSelectorColor", "fixedSelectorColor", "setChildCornerRadius", "corner", "radius", "setSelectorIcon", "isSupported", "setSelectorDegree", "flipDir", "degree", "resetChildPriority", "setInfo", "getChild", "pos", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRectPalette extends RelativeLayout implements SpenPaletteInterface {
    public static final int CORNER_LEFT_BOTTOM = 8;
    public static final int CORNER_LEFT_TOP = 1;
    public static final int CORNER_RIGHT_BOTTOM = 4;
    public static final int CORNER_RIGHT_TOP = 2;

    @NotNull
    private static final String TAG = "SpenRectPalette";

    @NotNull
    private List<SpenBaseColorView> mChild;
    private boolean mEnableColorHover;

    @NotNull
    private SpenPaletteTouchControl mPaletteTouchControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenRectPalette(@NotNull Context context, int i, int i2, int i4, int i5, int i6, int i7) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteTouchControl = new SpenPaletteTouchControl(this, ViewConfiguration.get(context).getScaledTouchSlop());
        this.mChild = new ArrayList();
        this.mEnableColorHover = false;
        setInfo(i, i2, i4, i5, i6, i7);
    }

    private final SpenBaseColorView getChild(int pos) {
        if (this.mChild.size() > pos) {
            return this.mChild.get(pos);
        }
        return null;
    }

    private final void setInfo(int col, int childWidth, int childHeight, int betweenMargin, int orientation, int selectedChildCornerRadius) {
        AbstractC6670b.m4744e(col, selectedChildCornerRadius, "setInfo() col=", " selectedChildRadius=", TAG);
        int[] iArr = {C7932R.id.col1, C7932R.id.col2, C7932R.id.col3, C7932R.id.col4, C7932R.id.col5, C7932R.id.col6, C7932R.id.col7, C7932R.id.col8, C7932R.id.col9};
        for (int i = 0; i < col; i++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SpenRectColorView spenRectColorView = new SpenRectColorView(context, selectedChildCornerRadius);
            spenRectColorView.setId(iArr[i]);
            spenRectColorView.setTag(String.valueOf(i));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(childWidth, childHeight);
            if (i > 0) {
                if (orientation == 0) {
                    layoutParams.addRule(17, iArr[i - 1]);
                    layoutParams.setMarginStart(betweenMargin);
                } else {
                    layoutParams.addRule(3, iArr[i - 1]);
                    layoutParams.topMargin = betweenMargin;
                }
            }
            addView(spenRectColorView, layoutParams);
            this.mChild.add(spenRectColorView);
        }
    }

    public final void close() {
        this.mPaletteTouchControl.close();
        this.mChild.clear();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    @Nullable
    public Drawable getSelectorDrawable(int childAt) {
        SpenBaseColorView child;
        if (getChildCount() > childAt && (child = getChild(childAt)) != null) {
            return child.getSelectorDrawable();
        }
        return null;
    }

    public final void resetChildPriority() {
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            this.mChild.get(i).bringToFront();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    public void setActionListener(@Nullable SpenPaletteActionListener actionListener) {
        this.mPaletteTouchControl.setPaletteActionListener(actionListener);
    }

    public final void setChildCornerRadius(int childAt, int corner, int radius) {
        if (childAt < 0 || childAt >= getChildCount()) {
            return;
        }
        SpenBaseColorView child = getChild(childAt);
        SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
        if (spenRectColorView != null) {
            int i = (corner & 1) == 1 ? radius : 0;
            int i2 = (corner & 2) == 2 ? radius : 0;
            int i4 = (corner & 4) == 4 ? radius : 0;
            if ((corner & 8) != 8) {
                radius = 0;
            }
            spenRectColorView.setRadius(i, i2, i4, radius);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    public void setColor(int childAt, @NotNull SpenPaletteColorInfo colorInfo) {
        SpenBaseColorView child;
        Intrinsics.checkNotNullParameter(colorInfo, "colorInfo");
        if (getChildCount() > childAt && (child = getChild(childAt)) != null) {
            child.setColor(colorInfo.getColor(), colorInfo.getOpacity(), colorInfo.getColorName());
            child.setOnClickListener(this.mPaletteTouchControl);
            child.setOnTouchListener(this.mPaletteTouchControl);
            child.setFocusable(true);
            child.setClickable(true);
            child.setSelected(false);
            if (this.mEnableColorHover) {
                child.setHoverDescription(colorInfo.getColorName());
            }
        }
    }

    public final void setColorHoverEnabled(boolean enable) {
        this.mEnableColorHover = enable;
    }

    public final void setFixedSelectorColor(int childAt, int fixedSelectorColor) {
        if (getChildCount() > childAt) {
            SpenBaseColorView child = getChild(childAt);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setFixedSelectorColor(fixedSelectorColor);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    public void setInit(int childAt) {
        SpenBaseColorView child;
        AbstractC6670b.m4744e(childAt, getChildCount(), "setInit(", ") childCount=", TAG);
        if (getChildCount() <= childAt || (child = getChild(childAt)) == null) {
            return;
        }
        child.setInit();
        child.setOnClickListener(null);
        child.setClickable(false);
        child.setFocusable(false);
        child.setSelected(false);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    public void setRes(int childAt, @NotNull SpenPaletteResInfo resInfo) {
        SpenBaseColorView child;
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        if (getChildCount() > childAt && (child = getChild(childAt)) != null) {
            child.setColorRes(resInfo.getResourceId());
            child.setHoverDescription(resInfo.getHoverDescription());
            child.setOnClickListener(this.mPaletteTouchControl);
            child.setClickable(true);
            child.setFocusable(true);
            child.setSelected(false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    public void setSelected(int childAt, boolean selected, boolean needAnimation) {
        SpenBaseColorView child;
        StringBuilder sbM2226q = AbstractC2821a.m2226q("setSelected() childAt=", childAt, " selected=", selected, " needAnimation=");
        sbM2226q.append(needAnimation);
        Log.i(TAG, sbM2226q.toString());
        if (getChildCount() <= childAt || (child = getChild(childAt)) == null) {
            return;
        }
        child.setSelected(selected, needAnimation);
    }

    public final void setSelectedChildLayout(int sMarginStart, int sMarginTop, int sMarginEnd, int sMarginBottom) {
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            SpenBaseColorView child = getChild(i);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setSelectedMargin(sMarginTop, sMarginStart, sMarginEnd, sMarginBottom);
            }
        }
    }

    public final boolean setSelectorDegree(int flipDir, int degree) {
        Log.i(TAG, AbstractC0622a.m1164j(flipDir, degree, "setSelectorDegree(", SQLKeyword.COMMA, ")"));
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            SpenBaseColorView spenBaseColorView = this.mChild.get(i);
            spenBaseColorView.resetDegree();
            spenBaseColorView.setResourceDegree(flipDir, degree);
        }
        return true;
    }

    public final void setSelectorIcon(boolean isSupported) {
        Log.i(TAG, "setSelectorIcon(" + isSupported + ")");
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            this.mChild.get(i).setSelectorIcon(isSupported);
        }
    }

    public final void setSelectorSize(int width, int height) {
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            SpenBaseColorView child = getChild(i);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setSelectorSize(width, height);
            }
        }
    }

    public final void setUnSelectedChildLayout(int uMarginStart, int uMarginTop, int uMarginEnd, int uMarginBottom) {
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            SpenBaseColorView child = getChild(i);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setUnselectedMargin(uMarginTop, uMarginStart, uMarginEnd, uMarginBottom);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenRectPalette(@NotNull Context context, int i, int i2, int i4, int i5, int i6) {
        this(context, i, i2, i4, i5, 0, i6);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
