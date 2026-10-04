package com.samsung.android.support.senl.addons.brush.view.menu;

import android.graphics.Rect;
import android.view.View;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/menu/BrushMenuInfo;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout;", "isOpen", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/SpenSettingBrushLayout;Z)V", "mPenRect", "Landroid/graphics/Rect;", "mColorRect", "mPenAlign", "", "mColorAlign", "penRect", "getPenRect", "()Landroid/graphics/Rect;", "colorRect", "getColorRect", "penAlign", "getPenAlign", "()I", "colorAlign", "getColorAlign", "isEquals", "info", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushMenuInfo implements IBrushMenuInfo {
    private static final float PEN_ITEM_RATIO = 0.244f;
    private int mColorAlign;

    @NotNull
    private final Rect mColorRect;
    private int mPenAlign;

    @NotNull
    private final Rect mPenRect;

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushMenuInfo");

    public BrushMenuInfo(@Nullable SpenSettingBrushLayout spenSettingBrushLayout, boolean z) {
        Rect rect = new Rect();
        this.mPenRect = rect;
        Rect rect2 = new Rect();
        this.mColorRect = rect2;
        this.mPenAlign = 3;
        this.mColorAlign = 3;
        if (spenSettingBrushLayout == null) {
            return;
        }
        Rect rect3 = new Rect();
        spenSettingBrushLayout.getPenRect(rect3);
        if (!TabletUtil.isTabletUi() && !z) {
            int penAlign = spenSettingBrushLayout.getPenAlign();
            if (penAlign == 1 || penAlign == 2) {
                rect3.top += (int) (rect3.height() * 0.756f);
            } else if (penAlign == 3) {
                if (spenSettingBrushLayout.getResources().getConfiguration().getLayoutDirection() == 0) {
                    rect3.right = (int) (rect3.width() * PEN_ITEM_RATIO);
                } else {
                    rect3.left = rect3.right - ((int) (rect3.width() * PEN_ITEM_RATIO));
                }
            }
        }
        rect.set(rect3);
        spenSettingBrushLayout.getColorRect(rect2);
        this.mPenAlign = spenSettingBrushLayout.getPenAlign();
        this.mColorAlign = spenSettingBrushLayout.getColorAlign();
        Object penView = spenSettingBrushLayout.getPenView();
        Intrinsics.checkNotNull(penView, "null cannot be cast to non-null type android.view.View");
        int visibility = ((View) penView).getVisibility();
        int visibility2 = spenSettingBrushLayout.getColorView().getVisibility();
        String str = TAG;
        int i = this.mPenAlign;
        int i2 = this.mColorAlign;
        int visibility3 = spenSettingBrushLayout.getVisibility();
        StringBuilder sb = new StringBuilder("BrushMenuInfo. rect: ");
        sb.append(rect);
        sb.append(SQLKeyword.COMMA);
        sb.append(rect2);
        sb.append(", align: ");
        AbstractC2821a.m2235z(sb, i, i2, SQLKeyword.COMMA, ", visibility: ");
        AbstractC2821a.m2235z(sb, visibility, visibility2, SQLKeyword.COMMA, SQLKeyword.COMMA);
        sb.append(visibility3);
        Logger.m7104i(str, sb.toString());
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo
    /* JADX INFO: renamed from: getColorAlign, reason: from getter */
    public int getMColorAlign() {
        return this.mColorAlign;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo
    @NotNull
    /* JADX INFO: renamed from: getColorRect, reason: from getter */
    public Rect getMColorRect() {
        return this.mColorRect;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo
    /* JADX INFO: renamed from: getPenAlign, reason: from getter */
    public int getMPenAlign() {
        return this.mPenAlign;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo
    @NotNull
    /* JADX INFO: renamed from: getPenRect, reason: from getter */
    public Rect getMPenRect() {
        return this.mPenRect;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.IBrushMenuInfo
    public boolean isEquals(@Nullable IBrushMenuInfo info) {
        return info != null && Intrinsics.areEqual(this.mPenRect, info.getMPenRect()) && Intrinsics.areEqual(this.mColorRect, info.getMColorRect()) && this.mPenAlign == info.getMPenAlign() && this.mColorAlign == info.getMColorAlign();
    }
}
