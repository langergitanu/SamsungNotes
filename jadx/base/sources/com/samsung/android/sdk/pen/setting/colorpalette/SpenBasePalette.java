package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\"\u001a\u00020\u0011J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\rJ&\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013J&\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013J\u0016\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013J\u0016\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0013J\u001e\u00104\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013J\u000e\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\rJ\u0016\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0013J\u0006\u0010<\u001a\u00020\u0011J\u000e\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020?J(\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0013H\u0002J\u0018\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u0013H\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010\u000b2\u0006\u0010H\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBasePalette;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPaletteTouchControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteTouchControl;", "mChild", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBaseColorView;", "mEnableColorHover", "", "mChildShape", "Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "setColor", "", "childAt", "", "colorInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "setRes", "resInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteResInfo;", "setInit", "setSelected", "selected", "needAnimation", "setActionListener", "actionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteActionListener;", "getSelectorDrawable", "Landroid/graphics/drawable/Drawable;", "close", "setColorHoverEnabled", "enable", "setSelectedChildLayout", "sMarginStart", "sMarginTop", "sMarginEnd", "sMarginBottom", "setUnSelectedChildLayout", "uMarginStart", "uMarginTop", "uMarginEnd", "uMarginBottom", "setSelectorSize", "width", "height", "setFixedSelectorColor", "fixedSelectorColor", "setChildCornerRadius", "corner", "radius", "setSelectorIcon", "isSupported", "setSelectorDegree", "flipDir", "degree", "resetChildPriority", "setInfo", "childInfo", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBasePalette$ChildInfo;", "setChildMargin", "index", ActionHandler.PARAMS, "Landroid/widget/RelativeLayout$LayoutParams;", "prevId", "getColorView", VMetaDataKey.META_KEY_SHAPE, "getChild", "pos", "Companion", "ChildInfo", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBasePalette extends RelativeLayout implements SpenPaletteInterface {
    public static final int CORNER_LEFT_BOTTOM = 8;
    public static final int CORNER_LEFT_TOP = 1;
    public static final int CORNER_RIGHT_BOTTOM = 4;
    public static final int CORNER_RIGHT_TOP = 2;

    @NotNull
    private static final String TAG = "SpenBasePalette";

    @NotNull
    private List<SpenBaseColorView> mChild;

    @NotNull
    private ColorChipShape mChildShape;
    private boolean mEnableColorHover;

    @NotNull
    private SpenPaletteTouchControl mPaletteTouchControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBasePalette(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteTouchControl = new SpenPaletteTouchControl(this, ViewConfiguration.get(context).getScaledTouchSlop());
        this.mChild = new ArrayList();
        this.mEnableColorHover = false;
        this.mChildShape = ColorChipShape.RECTANGLE;
    }

    private final SpenBaseColorView getChild(int pos) {
        if (this.mChild.size() > pos) {
            return this.mChild.get(pos);
        }
        return null;
    }

    private final SpenBaseColorView getColorView(ColorChipShape shape, int radius) {
        if (shape == ColorChipShape.CIRCLE) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return new SpenChipView(context);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        return new SpenRectColorView(context2, radius);
    }

    private final void setChildMargin(int index, ChildInfo childInfo, RelativeLayout.LayoutParams params, int prevId) {
        boolean z = childInfo.getBetweenMargin() != -1;
        if (z && index == 0) {
            return;
        }
        if (childInfo.getOrientation() == 0) {
            if (index != 0) {
                params.addRule(17, prevId);
            }
            if (z) {
                params.setMarginStart(childInfo.getBetweenMargin());
                return;
            } else {
                if (childInfo.getMarginFront() != -1) {
                    params.setMarginStart(childInfo.getMarginFront());
                    params.setMarginEnd(childInfo.getMarginEnd());
                    return;
                }
                return;
            }
        }
        if (index != 0) {
            params.addRule(3, prevId);
        }
        if (z) {
            params.topMargin = childInfo.getBetweenMargin();
        } else if (childInfo.getMarginFront() != -1) {
            params.topMargin = childInfo.getMarginFront();
            params.bottomMargin = childInfo.getMarginEnd();
        }
    }

    public final void close() {
        this.mPaletteTouchControl.close();
        this.mChild.clear();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteInterface
    @Nullable
    public Drawable getSelectorDrawable(int childAt) {
        SpenBaseColorView child = getChild(childAt);
        if (child != null) {
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
        if (this.mChildShape == ColorChipShape.RECTANGLE && childAt >= 0 && childAt < getChildCount()) {
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
        if (this.mChildShape == ColorChipShape.RECTANGLE && getChildCount() > childAt) {
            SpenBaseColorView child = getChild(childAt);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setFixedSelectorColor(fixedSelectorColor);
            }
        }
    }

    public final void setInfo(@NotNull ChildInfo childInfo) {
        Intrinsics.checkNotNullParameter(childInfo, "childInfo");
        Log.i(TAG, "setInfo() col=" + childInfo + ".count type=" + childInfo + ".shape");
        this.mChildShape = childInfo.getShape();
        int[] iArr = {C7932R.id.col1, C7932R.id.col2, C7932R.id.col3, C7932R.id.col4, C7932R.id.col5, C7932R.id.col6, C7932R.id.col7, C7932R.id.col8, C7932R.id.col9};
        int count = childInfo.getCount();
        int i = 0;
        while (i < count) {
            SpenBaseColorView colorView = getColorView(childInfo.getShape(), childInfo.getRadius());
            colorView.setId(iArr[i]);
            colorView.setTag(String.valueOf(i));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(childInfo.getWidth(), childInfo.getHeight());
            setChildMargin(i, childInfo, layoutParams, i == 0 ? 0 : iArr[i - 1]);
            addView(colorView, layoutParams);
            this.mChild.add(colorView);
            i++;
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
            if (resInfo.getSelectorResourceId() != 0) {
                child.setSelectorRes(resInfo.getSelectorResourceId());
            }
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
        if (this.mChildShape != ColorChipShape.RECTANGLE) {
            return;
        }
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
        if (this.mChildShape != ColorChipShape.RECTANGLE) {
            return;
        }
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
        if (this.mChildShape != ColorChipShape.RECTANGLE) {
            return;
        }
        int size = this.mChild.size();
        for (int i = 0; i < size; i++) {
            SpenBaseColorView child = getChild(i);
            SpenRectColorView spenRectColorView = child instanceof SpenRectColorView ? (SpenRectColorView) child : null;
            if (spenRectColorView != null) {
                spenRectColorView.setUnselectedMargin(uMarginTop, uMarginStart, uMarginEnd, uMarginBottom);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBasePalette$ChildInfo;", "", "<init>", "()V", VMetaDataKey.META_KEY_SHAPE, "Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "getShape", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "setShape", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "betweenMargin", "getBetweenMargin", "setBetweenMargin", "marginFront", "getMarginFront", "setMarginFront", "marginEnd", "getMarginEnd", "setMarginEnd", "radius", "getRadius", "setRadius", "orientation", "getOrientation", "setOrientation", "setMargin", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ChildInfo {
        private int count;
        private int height;
        private int orientation;
        private int radius;
        private int width;

        @NotNull
        private ColorChipShape shape = ColorChipShape.CIRCLE;
        private int betweenMargin = -1;
        private int marginFront = -1;
        private int marginEnd = -1;

        public final int getBetweenMargin() {
            return this.betweenMargin;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getMarginEnd() {
            return this.marginEnd;
        }

        public final int getMarginFront() {
            return this.marginFront;
        }

        public final int getOrientation() {
            return this.orientation;
        }

        public final int getRadius() {
            return this.radius;
        }

        @NotNull
        public final ColorChipShape getShape() {
            return this.shape;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setBetweenMargin(int i) {
            this.betweenMargin = i;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setMargin(int marginFront, int marginEnd) {
            this.betweenMargin = -1;
            this.marginFront = marginFront;
            this.marginEnd = marginEnd;
        }

        public final void setMarginEnd(int i) {
            this.marginEnd = i;
        }

        public final void setMarginFront(int i) {
            this.marginFront = i;
        }

        public final void setOrientation(int i) {
            this.orientation = i;
        }

        public final void setRadius(int i) {
            this.radius = i;
        }

        public final void setShape(@NotNull ColorChipShape colorChipShape) {
            Intrinsics.checkNotNullParameter(colorChipShape, "<set-?>");
            this.shape = colorChipShape;
        }

        public final void setWidth(int i) {
            this.width = i;
        }

        public final void setMargin(int betweenMargin) {
            this.marginFront = -1;
            this.marginEnd = -1;
            this.betweenMargin = betweenMargin;
        }
    }
}
