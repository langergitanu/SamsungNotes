package com.samsung.android.support.senl.addons.base.viewmodel.zoom;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.utils.DrawableUtils;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b&\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0016J\u0006\u0010)\u001a\u00020\u0018J\u001e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\b\u0010.\u001a\u00020\u0018H&J\b\u0010/\u001a\u00020\u0018H&J\b\u00100\u001a\u00020\u0018H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\rR$\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00102\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R$\u00105\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\u0014\u00108\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/zoom/AbsZoomViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "<init>", "()V", "mPrevZoomRatio", "", "getMPrevZoomRatio", "()F", "setMPrevZoomRatio", "(F)V", "mCheckZoomInOut", "", "getMCheckZoomInOut", "()I", "setMCheckZoomInOut", "(I)V", "mZoomTextVisibility", "", AbsZoomViewModel.BINDING_ID_ZOOM_PERCENT, "mZoomInBtnEnabled", "mZoomOutBtnEnabled", "mFacade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "getData", "", "id", "", "setFacade", "facade", AbsZoomViewModel.BINDING_ID_ROUND_RECT, "getRectRipple", "visibility", AbsZoomViewModel.BINDING_ID_ZOOM_TEXT_VISIBILITY, "getZoomTextVisibility", "()Z", "setZoomTextVisibility", "(Z)V", "updateZoomText", "updateZoomInOutButton", "currentScale", "minScale", "maxScale", AbsZoomViewModel.BINDING_ID_ZOOM_IN_CLICKED, AbsZoomViewModel.BINDING_ID_ZOOM_OUT_CLICKED, "clearModels", "enable", AbsZoomViewModel.BINDING_ID_ZOOM_IN_BTN_STATE, "getZoomInBtnState", "setZoomInBtnState", AbsZoomViewModel.BINDING_ID_ZOOM_OUT_BTN_STATE, "getZoomOutBtnState", "setZoomOutBtnState", AbsZoomViewModel.BINDING_ID_ZOOM_BTN_DESCRIPTION, "getDescription", "()Ljava/lang/String;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsZoomViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_ROUND_RECT = "rectRipple";

    @NotNull
    private static final String BINDING_ID_ZOOM_BTN_DESCRIPTION = "description";

    @NotNull
    private static final String BINDING_ID_ZOOM_IN_BTN_STATE = "zoomInBtnState";

    @NotNull
    private static final String BINDING_ID_ZOOM_IN_CLICKED = "onZoomInClicked";

    @NotNull
    private static final String BINDING_ID_ZOOM_OUT_BTN_STATE = "zoomOutBtnState";

    @NotNull
    private static final String BINDING_ID_ZOOM_OUT_CLICKED = "onZoomOutClicked";

    @NotNull
    private static final String BINDING_ID_ZOOM_PERCENT = "zoomPercent";

    @NotNull
    private static final String BINDING_ID_ZOOM_TEXT_VISIBILITY = "zoomTextVisibility";

    @NotNull
    private static final String TAG = Logger.createTag("AbsZoomViewModel");
    public static final int ZOOM_DEFAULT = 0;
    public static final int ZOOM_IN = 1;
    public static final int ZOOM_OUT = 2;
    private int mCheckZoomInOut;

    @Nullable
    private IFacade mFacade;
    private boolean mZoomTextVisibility;
    private float mPrevZoomRatio = 1.0f;
    private int zoomPercent = 100;
    private boolean mZoomInBtnEnabled = true;
    private boolean mZoomOutBtnEnabled = true;

    private final String getDescription() {
        IFacade iFacade = this.mFacade;
        if ((iFacade != null ? iFacade.getView() : null) == null) {
            return "";
        }
        IFacade iFacade2 = this.mFacade;
        Intrinsics.checkNotNull(iFacade2);
        IView<?> view = iFacade2.getView();
        Intrinsics.checkNotNull(view);
        return AbstractC2322a.m1615e((int) (view.getZoomScale() * 100), "%, ");
    }

    private final int getRectRipple() {
        return DrawableUtils.TYPE_RECTANGLE;
    }

    /* JADX INFO: renamed from: getZoomInBtnState, reason: from getter */
    private final boolean getMZoomInBtnEnabled() {
        return this.mZoomInBtnEnabled;
    }

    /* JADX INFO: renamed from: getZoomOutBtnState, reason: from getter */
    private final boolean getMZoomOutBtnEnabled() {
        return this.mZoomOutBtnEnabled;
    }

    private final void setZoomInBtnState(boolean z) {
        if (this.mZoomInBtnEnabled != z) {
            AbstractC6670b.m4764y("setZoomInBtnState(), enabled - ", TAG, z);
            this.mZoomInBtnEnabled = z;
            notifyChanged(BINDING_ID_ZOOM_IN_BTN_STATE);
        }
    }

    private final void setZoomOutBtnState(boolean z) {
        if (this.mZoomOutBtnEnabled != z) {
            AbstractC6670b.m4764y("setZoomOutBtnState(), enabled - ", TAG, z);
            this.mZoomOutBtnEnabled = z;
            notifyChanged(BINDING_ID_ZOOM_OUT_BTN_STATE);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mFacade = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        if (id != null) {
            switch (id.hashCode()) {
                case -1724546052:
                    if (id.equals(BINDING_ID_ZOOM_BTN_DESCRIPTION)) {
                        return getDescription();
                    }
                    break;
                case -1608354574:
                    if (id.equals(BINDING_ID_ZOOM_PERCENT)) {
                        return Integer.valueOf(this.zoomPercent);
                    }
                    break;
                case -1457586163:
                    if (id.equals(BINDING_ID_ZOOM_IN_BTN_STATE)) {
                        return Boolean.valueOf(getMZoomInBtnEnabled());
                    }
                    break;
                case -1154365648:
                    if (id.equals(BINDING_ID_ZOOM_OUT_BTN_STATE)) {
                        return Boolean.valueOf(getMZoomOutBtnEnabled());
                    }
                    break;
                case -339807534:
                    if (id.equals(BINDING_ID_ZOOM_TEXT_VISIBILITY)) {
                        return Boolean.valueOf(getMZoomTextVisibility());
                    }
                    break;
                case -33226444:
                    if (id.equals(BINDING_ID_ROUND_RECT)) {
                        return Integer.valueOf(getRectRipple());
                    }
                    break;
            }
        }
        return super.getData(id);
    }

    public final int getMCheckZoomInOut() {
        return this.mCheckZoomInOut;
    }

    public final float getMPrevZoomRatio() {
        return this.mPrevZoomRatio;
    }

    /* JADX INFO: renamed from: getZoomTextVisibility, reason: from getter */
    public final boolean getMZoomTextVisibility() {
        return this.mZoomTextVisibility;
    }

    public abstract void onZoomInClicked();

    public abstract void onZoomOutClicked();

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (Intrinsics.areEqual("action_click", action != null ? action.getMTypeId() : null)) {
            String mBindId = action.getMBindId();
            if (Intrinsics.areEqual(BINDING_ID_ZOOM_IN_CLICKED, mBindId)) {
                onZoomInClicked();
            } else if (Intrinsics.areEqual(BINDING_ID_ZOOM_OUT_CLICKED, mBindId)) {
                onZoomOutClicked();
            }
        }
    }

    public final void setFacade(@Nullable IFacade facade) {
        this.mFacade = facade;
    }

    public final void setMCheckZoomInOut(int i) {
        this.mCheckZoomInOut = i;
    }

    public final void setMPrevZoomRatio(float f) {
        this.mPrevZoomRatio = f;
    }

    public final void setZoomTextVisibility(boolean z) {
        this.mZoomTextVisibility = z;
        notifyChanged(BINDING_ID_ZOOM_TEXT_VISIBILITY);
    }

    public final void updateZoomInOutButton(float currentScale, float minScale, float maxScale) {
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("updateZoomButton(), current/min/max= ", currentScale, "/", minScale, "/");
        sbM1176v.append(maxScale);
        Logger.m7100d(str, sbM1176v.toString());
        setZoomInBtnState(Float.compare(currentScale, maxScale) != 0);
        setZoomOutBtnState(Float.compare(currentScale, minScale) != 0);
        notifyChanged(BINDING_ID_ZOOM_BTN_DESCRIPTION);
    }

    public final void updateZoomText() {
        IFacade iFacade = this.mFacade;
        Intrinsics.checkNotNull(iFacade);
        IView<?> view = iFacade.getView();
        Intrinsics.checkNotNull(view);
        float zoomScale = view.getZoomScale();
        float f = this.mPrevZoomRatio;
        if (f > 0.0f && Float.compare(f, zoomScale) != 0) {
            setZoomTextVisibility(true);
            this.zoomPercent = MathKt.roundToInt(100 * zoomScale);
            notifyChanged(BINDING_ID_ZOOM_PERCENT);
        }
        this.mPrevZoomRatio = zoomScale;
    }
}
