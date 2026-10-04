package com.samsung.android.sdk.pen.setting;

import android.util.Log;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/BrushFixedChildStrategy;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveStrategy;", "<init>", "()V", "mRotateDegree", "", "mColorFlipDir", "mColorFlipDegree", "mSelectorFlip", "mSelectorDegree", "moveView", "guideView", "Landroid/view/View;", "target", "align", "direction", "getPenDegree", "", "orientation", "getColorFlip", "getSelectorDegree", "getRotateDegree", "setRotateDegree", "", "degree", "setColorInfo", "getColorFlipDir", "getColorFlipDegree", "getSelectorFlipDir", "getSelectorFlipDegree", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class BrushFixedChildStrategy implements SpenBrushMoveStrategy {

    @NotNull
    private static final String TAG = "BrushFixedChildStrategy";
    private int mColorFlipDegree;
    private int mColorFlipDir;
    private int mRotateDegree;
    private int mSelectorDegree;
    private int mSelectorFlip;

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    public int getColorFlip(int align, int direction) {
        return align != 1 ? align != 2 ? (align == 3 && this.mRotateDegree == 180) ? 1 : 0 : direction == 0 ? this.mRotateDegree == 90 ? 1 : 0 : this.mRotateDegree == 270 ? 1 : 0 : direction == 0 ? this.mRotateDegree == 270 ? 1 : 0 : this.mRotateDegree == 90 ? 1 : 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /* JADX INFO: renamed from: getColorFlipDegree, reason: from getter */
    public int getMColorFlipDegree() {
        return this.mColorFlipDegree;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /* JADX INFO: renamed from: getColorFlipDir, reason: from getter */
    public int getMColorFlipDir() {
        return this.mColorFlipDir;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    public float getPenDegree(int orientation, int align, int direction) {
        return align != 1 ? align != 2 ? (align == 3 && this.mRotateDegree != 0) ? 180.0f : 0.0f : direction == 0 ? this.mRotateDegree != 270 ? 180.0f : 0.0f : this.mRotateDegree != 90 ? 180.0f : 0.0f : direction == 0 ? this.mRotateDegree != 90 ? 0.0f : 180.0f : this.mRotateDegree != 270 ? 0.0f : 180.0f;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /* JADX INFO: renamed from: getRotateDegree, reason: from getter */
    public int getMRotateDegree() {
        return this.mRotateDegree;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float getSelectorDegree(int orientation, int align, int direction) {
        float f;
        int i = 270;
        if (align == 1) {
            if (direction != 0) {
            }
            f = i;
        } else if (align != 2) {
            f = 0.0f;
        } else {
            if (direction == 0) {
                i = 90;
            }
            f = i;
        }
        int i2 = this.mRotateDegree;
        return i2 > 0 ? (f + i2) % PopOverActivityWrapper.DEFAULT_WIDTH : f;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /* JADX INFO: renamed from: getSelectorFlipDegree, reason: from getter */
    public int getMSelectorDegree() {
        return this.mSelectorDegree;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    /* JADX INFO: renamed from: getSelectorFlipDir, reason: from getter */
    public int getMSelectorFlip() {
        return this.mSelectorFlip;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    public int moveView(@NotNull View guideView, @NotNull View target, int align, int direction) {
        Intrinsics.checkNotNullParameter(guideView, "guideView");
        Intrinsics.checkNotNullParameter(target, "target");
        Log.i(TAG, "moveView() guideView=" + guideView + " targetView=" + target + " align=" + align + " direction = " + direction);
        int width = guideView.getWidth();
        int height = guideView.getHeight();
        if (width == 0 || height == 0) {
            AbstractC6670b.m4744e(width, height, "width =", " height=", TAG);
            return 0;
        }
        if (align != 1 && align != 2) {
            if (align != 3) {
                return 0;
            }
            target.setRotation(0.0f);
            target.setTranslationX(0.0f);
            target.setTranslationY(0.0f);
            return 1;
        }
        if (direction == 0) {
            target.setPivotX(0.0f);
            target.setPivotY(0.0f);
            target.setRotation(-90.0f);
            target.setTranslationY(height);
        } else {
            float f = height;
            target.setPivotX(f);
            target.setPivotY(0.0f);
            target.setRotation(90.0f);
            target.setTranslationY(f);
        }
        return 2;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    public void setColorInfo(int orientation, int align, int direction) {
        int colorFlip = getColorFlip(align, direction);
        this.mColorFlipDir = colorFlip;
        this.mColorFlipDegree = colorFlip != 0 ? 180 : 0;
        this.mSelectorFlip = colorFlip == 1 ? -1 : 0;
        this.mSelectorDegree = (int) getSelectorDegree(orientation, align, direction);
        AbstractC0000a.m26w(AbstractC0622a.m1173s(orientation, align, "setColorInfo() orientation=", " align=", " direction="), TAG, direction);
        Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(this.mColorFlipDir, this.mColorFlipDegree, "setColorInfo() colorFlip[", SQLKeyword.COMMA, "] Selector["), this.mSelectorFlip, this.mSelectorDegree, SQLKeyword.COMMA, "]"));
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveStrategy
    public void setRotateDegree(int degree) {
        AbstractC2322a.m1631u(degree, "setRotateDegree() degree=", TAG);
        this.mRotateDegree = degree;
    }
}
