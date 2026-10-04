package com.samsung.android.sdk.pen.setting;

import android.graphics.Point;
import android.util.Log;
import android.view.View;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.common.SettingViewLongClickListener;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 52\u00020\u0001:\u0003567B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005J\b\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\u001c\u0010.\u001a\u00020\u00182\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010/\u001a\u0004\u0018\u00010\u00032\u0006\u00100\u001a\u000201H&J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0013H&J\b\u00104\u001a\u00020\u0018H&R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject;", "Lcom/samsung/android/sdk/pen/setting/common/SettingViewLongClickListener;", "view", "Landroid/view/View;", "alignment", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;", "<init>", "(Landroid/view/View;ILcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;)V", "mView", "mAlignment", "mLongClickTouchX", "", "mLongClickTouchY", "mLongClickListener", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$ActionListener;", "onLongClick", "", VPathDataCmd.RCurveTo, "touchDownX", "touchDownY", "close", "", "value", "actionListener", "getActionListener", "()Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$ActionListener;", "setActionListener", "(Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$ActionListener;)V", "getAlignment", "()I", "setAlignment", "(I)V", "getView", "()Landroid/view/View;", "makeShadowBuilder", "Lcom/samsung/android/sdk/pen/setting/SpenBrushDragShadowBuilder;", "viewRadius", "getNextMovement", "Lcom/samsung/android/sdk/pen/setting/SpenBrushNextMovement;", "getViewType", "Lcom/samsung/android/sdk/pen/setting/SpenBrushViewType;", "getTagName", "", "setViewLongClickListener", "getCurrentGuideView", "guideControl", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideControl;", "notifyActionPositionChanged", "needUpdatePartner", "notifyActionLongClicked", "Companion", "ActionListener", "LongClickListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenBrushMoveObject implements SettingViewLongClickListener {

    @NotNull
    private static final String TAG = "SpenBrushMoveObject";

    @Nullable
    private ActionListener mActionListener;
    private int mAlignment;

    @Nullable
    private final LongClickListener mLongClickListener;
    private float mLongClickTouchX;
    private float mLongClickTouchY;

    @NotNull
    private View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$ActionListener;", "", "onPenPositionChanged", "", "align", "", "needUpdateColor", "", "onColorPositionChanged", "needUpdatePen", "onPenLongClicked", "onColorLongClicked", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onColorLongClicked();

        void onColorPositionChanged(int align, boolean needUpdatePen);

        void onPenLongClicked();

        void onPenPositionChanged(int align, boolean needUpdateColor);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject$LongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "moveObject", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveObject;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LongClickListener {
        boolean onLongClick(@Nullable View view, @Nullable SpenBrushMoveObject moveObject);
    }

    public SpenBrushMoveObject(@NotNull View view, int i, @Nullable LongClickListener longClickListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mView = view;
        this.mAlignment = i;
        this.mLongClickListener = longClickListener;
        view.setTag(getTagName());
        setViewLongClickListener(this.mView, this);
    }

    public final void close() {
        this.mActionListener = null;
    }

    @Nullable
    /* JADX INFO: renamed from: getActionListener, reason: from getter */
    public final ActionListener getMActionListener() {
        return this.mActionListener;
    }

    /* JADX INFO: renamed from: getAlignment, reason: from getter */
    public final int getMAlignment() {
        return this.mAlignment;
    }

    @Nullable
    public abstract View getCurrentGuideView(@NotNull SpenBrushGuideControl guideControl);

    @NotNull
    public abstract SpenBrushNextMovement getNextMovement();

    @NotNull
    public abstract String getTagName();

    @NotNull
    /* JADX INFO: renamed from: getView, reason: from getter */
    public final View getMView() {
        return this.mView;
    }

    @NotNull
    public abstract SpenBrushViewType getViewType();

    @NotNull
    public final SpenBrushDragShadowBuilder makeShadowBuilder(int viewRadius) {
        return new SpenBrushDragShadowBuilder(getMView(), new Point((int) this.mLongClickTouchX, (int) this.mLongClickTouchY), viewRadius);
    }

    public abstract void notifyActionLongClicked();

    public abstract void notifyActionPositionChanged(boolean needUpdatePartner);

    @Override // com.samsung.android.sdk.pen.setting.common.SettingViewLongClickListener
    public boolean onLongClick(@NotNull View v, float touchDownX, float touchDownY) {
        Intrinsics.checkNotNullParameter(v, "v");
        StringBuilder sb = new StringBuilder("onLongClick [");
        sb.append(v);
        sb.append("] POS[");
        Log.d(TAG, AbstractC1038a.m1216q(sb, touchDownX, SQLKeyword.COMMA, touchDownY, "]"));
        this.mLongClickTouchX = touchDownX;
        this.mLongClickTouchY = touchDownY;
        LongClickListener longClickListener = this.mLongClickListener;
        if (longClickListener == null) {
            return false;
        }
        longClickListener.onLongClick(v, this);
        return false;
    }

    public final void setActionListener(@Nullable ActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    public final void setAlignment(int i) {
        this.mAlignment = i;
    }

    public abstract void setViewLongClickListener(@Nullable View view, @Nullable SettingViewLongClickListener listener);
}
