package com.samsung.android.support.senl.addons.brush.viewmodel.panningbar;

import android.graphics.PointF;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.panningbar.IPanningBarLayoutInjector;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.PanningBarViewModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 12\u00020\u0001:\u000212B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0017\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0013H\u0014J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/PanningBarViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/PanningBarViewModel$IPanningBarTouchListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/PanningBarViewModel$IPanningBarTouchListener;)V", "mHorizontalVisibility", "", "mVerticalVisibility", "mPanningBarLayout", "Lcom/samsung/android/support/senl/addons/base/model/panningbar/IPanningBarLayoutInjector;", "mTouchListener", "getData", "", "id", "", "setPanningBarLayout", "", "injector", "onPropertyChanged", "propertyId", "", "(Ljava/lang/Integer;)V", "updatePanningBar", "onRequestScroll", "dx", "", "dy", "isShown", "getListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/IPanningBarListener;", "mPanningBarListener", "getVerticalVisibility", "getHorizontalVisibility", "setVerticalVisibility", "visibility", "setHorizontalVisibility", "getPanningBarWidthPx", "getPanningBarHeightPx", "getPanningBarVerticalPaddingEndPx", "getPanningBarVerticalMarginBottomPx", "getPanningBarVerticalMarginEndPx", "getPanningBarHorizontalMarginBottomPx", "getPanningBarHorizontalMarginEndPx", "closeSubViewModels", "clearModels", "closeCallbacks", "Companion", "IPanningBarTouchListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PanningBarViewModel extends AbsModelControlViewModel {

    @NotNull
    private static final String BINDING_ID_HEIGHT_PX = "panningBarHeightPx";

    @NotNull
    private static final String BINDING_ID_HORIZONTAL_MARGIN_BOTTOM_PX = "panningBarHorizontalMarginBottomPx";

    @NotNull
    private static final String BINDING_ID_HORIZONTAL_MARGIN_END_PX = "panningBarHorizontalMarginEndPx";

    @NotNull
    private static final String BINDING_ID_HORIZONTAL_VISIBILITY = "horizontalVisibility";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_LISTENER = "panningbarListener";

    @NotNull
    private static final String BINDING_ID_VERTICAL_MARGIN_BOTTOM_PX = "panningBarVerticalMarginBottomPx";

    @NotNull
    private static final String BINDING_ID_VERTICAL_MARGIN_END_PX = "panningBarVerticalMarginEndPx";

    @NotNull
    private static final String BINDING_ID_VERTICAL_PADDING_END_PX = "panningBarVerticalPaddingEndPx";

    @NotNull
    private static final String BINDING_ID_VERTICAL_VISIBILITY = "verticalVisibility";

    @NotNull
    private static final String BINDING_ID_WIDTH_PX = "panningBarWidthPx";

    @NotNull
    private static final String TAG = Logger.createBrushTag("PanningBarViewModel");
    private boolean mHorizontalVisibility;

    @Nullable
    private IPanningBarLayoutInjector mPanningBarLayout;

    @Nullable
    private IPanningBarListener mPanningBarListener;

    @Nullable
    private IPanningBarTouchListener mTouchListener;
    private boolean mVerticalVisibility;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/PanningBarViewModel$IPanningBarTouchListener;", "", "onTouch", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPanningBarTouchListener {
        void onTouch();
    }

    public PanningBarViewModel(@Nullable IFacade iFacade, @Nullable IPanningBarTouchListener iPanningBarTouchListener) {
        super(iFacade);
        this.mTouchListener = iPanningBarTouchListener;
        this.mPanningBarListener = new IPanningBarListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.PanningBarViewModel$mPanningBarListener$1
            @Override // com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.IPanningBarListener
            public void onScroll(float dx, float dy) {
                this.this$0.onRequestScroll(dx, dy);
            }

            @Override // com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.IPanningBarListener
            public void onTouch() {
                if (this.this$0.mTouchListener != null) {
                    PanningBarViewModel.IPanningBarTouchListener iPanningBarTouchListener2 = this.this$0.mTouchListener;
                    Intrinsics.checkNotNull(iPanningBarTouchListener2);
                    iPanningBarTouchListener2.onTouch();
                }
            }
        };
    }

    /* JADX INFO: renamed from: getHorizontalVisibility, reason: from getter */
    private final boolean getMHorizontalVisibility() {
        return this.mHorizontalVisibility;
    }

    private final int getPanningBarHeightPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarHeightPx();
    }

    private final int getPanningBarHorizontalMarginBottomPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarHorizontalMarginBottomPx();
    }

    private final int getPanningBarHorizontalMarginEndPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarHorizontalMarginEndPx();
    }

    private final int getPanningBarVerticalMarginBottomPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarVerticalMarginBottomPx();
    }

    private final int getPanningBarVerticalMarginEndPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarVerticalMarginEndPx();
    }

    private final int getPanningBarVerticalPaddingEndPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarVerticalPaddingEndPx();
    }

    private final int getPanningBarWidthPx() {
        IPanningBarLayoutInjector iPanningBarLayoutInjector = this.mPanningBarLayout;
        Intrinsics.checkNotNull(iPanningBarLayoutInjector);
        return iPanningBarLayoutInjector.getPanningBarWidthPx();
    }

    /* JADX INFO: renamed from: getVerticalVisibility, reason: from getter */
    private final boolean getMVerticalVisibility() {
        return this.mVerticalVisibility;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestScroll(float dx, float dy) {
        IFacade mFacade = getMFacade();
        IView<?> view = mFacade != null ? mFacade.getView() : null;
        if (view != null) {
            PointF pan = view.getPan();
            if (pan != null) {
                pan.x += dx;
                pan.y += dy;
            }
            view.setPan(pan);
        }
        Logger.m7100d(TAG, "Panning scroll " + dx + SQLKeyword.COMMA + dy);
    }

    private final void setHorizontalVisibility(boolean visibility) {
        this.mHorizontalVisibility = visibility;
        notifyChanged(BINDING_ID_HORIZONTAL_VISIBILITY);
    }

    private final void setVerticalVisibility(boolean visibility) {
        this.mVerticalVisibility = visibility;
        notifyChanged(BINDING_ID_VERTICAL_VISIBILITY);
    }

    private final void updatePanningBar() {
        if (getMFacade() == null) {
            return;
        }
        IFacade mFacade = getMFacade();
        Intrinsics.checkNotNull(mFacade);
        IView<?> view = mFacade.getView();
        if (view != null) {
            boolean zIsHScrollable = view.isHScrollable();
            if (zIsHScrollable && !this.mHorizontalVisibility) {
                setHorizontalVisibility(true);
            } else if (!zIsHScrollable && this.mHorizontalVisibility) {
                setHorizontalVisibility(false);
            }
            boolean zIsVScrollable = view.isVScrollable();
            if (zIsVScrollable && !this.mVerticalVisibility) {
                setVerticalVisibility(true);
            } else {
                if (zIsVScrollable || !this.mVerticalVisibility) {
                    return;
                }
                setVerticalVisibility(false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mHorizontalVisibility = false;
        this.mVerticalVisibility = false;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mPanningBarListener = null;
        this.mTouchListener = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        if (id != null) {
            switch (id.hashCode()) {
                case -1803105140:
                    if (id.equals(BINDING_ID_WIDTH_PX)) {
                        return Integer.valueOf(getPanningBarWidthPx());
                    }
                    break;
                case -1165726193:
                    if (id.equals(BINDING_ID_HORIZONTAL_MARGIN_END_PX)) {
                        return Integer.valueOf(getPanningBarHorizontalMarginEndPx());
                    }
                    break;
                case -385516803:
                    if (id.equals(BINDING_ID_VERTICAL_MARGIN_END_PX)) {
                        return Integer.valueOf(getPanningBarVerticalMarginEndPx());
                    }
                    break;
                case 256663705:
                    if (id.equals(BINDING_ID_VERTICAL_MARGIN_BOTTOM_PX)) {
                        return Integer.valueOf(getPanningBarVerticalMarginBottomPx());
                    }
                    break;
                case 442090289:
                    if (id.equals(BINDING_ID_HEIGHT_PX)) {
                        return Integer.valueOf(getPanningBarHeightPx());
                    }
                    break;
                case 513428264:
                    if (id.equals(BINDING_ID_VERTICAL_VISIBILITY)) {
                        return Boolean.valueOf(getMVerticalVisibility());
                    }
                    break;
                case 552070742:
                    if (id.equals(BINDING_ID_HORIZONTAL_VISIBILITY)) {
                        return Boolean.valueOf(getMHorizontalVisibility());
                    }
                    break;
                case 1003745910:
                    if (id.equals(BINDING_ID_PANNINGBAR_LISTENER)) {
                        return getMPanningBarListener();
                    }
                    break;
                case 1401732167:
                    if (id.equals(BINDING_ID_HORIZONTAL_MARGIN_BOTTOM_PX)) {
                        return Integer.valueOf(getPanningBarHorizontalMarginBottomPx());
                    }
                    break;
                case 1840589802:
                    if (id.equals(BINDING_ID_VERTICAL_PADDING_END_PX)) {
                        return Integer.valueOf(getPanningBarVerticalPaddingEndPx());
                    }
                    break;
            }
        }
        return super.getData(id);
    }

    @Nullable
    /* JADX INFO: renamed from: getListener, reason: from getter */
    public final IPanningBarListener getMPanningBarListener() {
        return this.mPanningBarListener;
    }

    public final boolean isShown() {
        return getMVerticalVisibility() || getMHorizontalVisibility();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel
    public void onPropertyChanged(@Nullable Integer propertyId) {
        if ((propertyId != null && propertyId.intValue() == 11100) || ((propertyId != null && propertyId.intValue() == 11101) || (propertyId != null && propertyId.intValue() == 11202))) {
            updatePanningBar();
        }
    }

    public final void setPanningBarLayout(@NotNull IPanningBarLayoutInjector injector) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        this.mPanningBarLayout = injector;
    }
}
