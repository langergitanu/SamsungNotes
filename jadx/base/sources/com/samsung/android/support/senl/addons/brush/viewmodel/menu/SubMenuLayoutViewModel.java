package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationExtraEvent;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.RotationExtraEvent;
import com.samsung.android.support.senl.addons.base.utils.DrawableUtils;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0016\u0018\u0000 g2\u00020\u0001:\u0001gB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\u0006\u0010)\u001a\u00020\u000bJ\b\u0010*\u001a\u00020\u0017H\u0014J\b\u0010+\u001a\u00020\u0017H\u0014J\b\u0010,\u001a\u00020\u0017H\u0014J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\u001a\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0002J\n\u00109\u001a\u0004\u0018\u000106H\u0002J\n\u0010:\u001a\u0004\u0018\u000106H\u0002J\n\u0010;\u001a\u0004\u0018\u000106H\u0002J\n\u0010<\u001a\u0004\u0018\u000106H\u0002J\n\u0010=\u001a\u0004\u0018\u000106H\u0002J\n\u0010>\u001a\u0004\u0018\u000106H\u0002JP\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000bJ0\u0010J\u001a\u00020\u00172\u0006\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OH\u0002J \u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u00020A2\u0006\u0010S\u001a\u00020A2\u0006\u0010T\u001a\u00020OH\u0002J\u0010\u0010U\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010AJ\u0018\u0010V\u001a\u00020\u00172\u0006\u0010W\u001a\u00020A2\u0006\u0010T\u001a\u00020OH\u0002J\u0018\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020A2\u0006\u0010T\u001a\u00020OH\u0002J\n\u0010Z\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010[\u001a\u00020\u00172\b\u0010\\\u001a\u0004\u0018\u00010\rJ\u0012\u0010]\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010_\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010a\u001a\u00020\u000bH\u0002J\u0010\u0010b\u001a\u00020\u00172\u0006\u0010K\u001a\u00020AH\u0002J\u001a\u0010b\u001a\u00020\u00172\b\u0010K\u001a\u0004\u0018\u00010A2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010c\u001a\u00020\u000bH\u0002J\b\u0010d\u001a\u00020\u000bH\u0002J\b\u0010e\u001a\u00020\u000bH\u0002J\b\u0010f\u001a\u00020\u000bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/SubMenuLayoutViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mScreenModel", "mMenuSizeInjector", "mSubMenuBottomMargin", "", "mBrushMenuInfo", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/IBrushMenuInfo;", "mOrientationListener", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode$OnRotationChangeListener;", "mCallBack", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getData", "", "id", "", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "updateSubMenuMarginBottom", "orientation", "setToolbarIconMarginPx", "bottomMargin", "getZoomTextMarginEndPx", "getZoomTextMarginTopPx", "getPanningBarWidthPx", "getPanningBarHeightPx", "getPanningBarVerticalPaddingEndPx", "getPanningBarVerticalMarginBottomPx", "getPanningBarVerticalMarginEndPx", "getPanningBarHorizontalMarginBottomPx", "getPanningBarHorizontalMarginEndPx", "getToolbarMarginBottomPx", "getToolbarIconMarginPx", "getSubMenuStrokeSizePx", "clearModels", "closeCallbacks", "closeSubViewModels", "getPenUpButtonWidthHeightPx", "getDoneButtonWidthPx", "getDoneButtonHeightPx", "getToolbarWidthPx", "getToolbarHeightPx", "getToolbarChildButtonSizePx", "getToolbarChildButtonMarginPx", "getRoundRipple", "getRotationExtraEvent", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationExtraEvent;", "data", "type", "getPenupRotationDescription", "getEraserRotationDescription", "getUndoRotationDescription", "getRedoRotationDescription", "getBottomRotationPivot", "getTopRightRotationPivot", SubMenuLayoutViewModel.BINDING_ID_ON_LAYOUT_CHANGE, "view", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "updatePenUpDoneButtonPosition", "subMenuLayout", "penUpLayout", "doneLayout", "isPenUp", "", "isDone", "setLayoutBottom", "targetView", "subMenuView", "isOverlapped", "setLayoutRect", "setLayoutMarginStart", "penUpView", "setLayoutMarginEnd", "doneView", "getBrushMenuInfo", "setBrushMenuInfo", "info", "getZoomTextMarginData", "getPanningBarData", "getToolbarData", "getOtherData", "getMenuSize", "updateSubMenuPosition", "getPenUpDescription", "getEraserDescription", "getUndoDescription", "getRedoDescription", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SubMenuLayoutViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_BOTTOM_ROTATION_PIVOT = "bottomRotationPivot";

    @NotNull
    private static final String BINDING_ID_BRUSH_MENU_INFO = "brushMenuInfo";

    @NotNull
    private static final String BINDING_ID_DONE_BUTTON_HEIGHT_PX = "doneButtonHeightPx";

    @NotNull
    private static final String BINDING_ID_DONE_BUTTON_WIDTH_PX = "doneButtonWidthPx";

    @NotNull
    private static final String BINDING_ID_ERASER_DESCRIPTION = "eraserDescription";

    @NotNull
    private static final String BINDING_ID_ERASER_ROTATION_DESCRIPTION = "eraserRotationDescription";

    @NotNull
    private static final String BINDING_ID_ON_LAYOUT_CHANGE = "onLayoutChange";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_HEIGHT_PX = "panningBarHeightPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_H_MARGIN_BOTTOM_PX = "panningBarHorizontalMarginBottomPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_H_MARGIN_END_PX = "panningBarHorizontalMarginEndPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_PREFIX = "panningBar";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_V_MARGIN_BOTTOM_PX = "panningBarVerticalMarginBottomPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_V_MARGIN_END_PX = "panningBarVerticalMarginEndPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_V_PADDING_END_PX = "panningBarVerticalPaddingEndPx";

    @NotNull
    private static final String BINDING_ID_PANNINGBAR_WIDTH_PX = "panningBarWidthPx";

    @NotNull
    private static final String BINDING_ID_PENUP_BUTTON_WIDTH_HEIGHT_PX = "penUpButtonWidthHeightPx";

    @NotNull
    private static final String BINDING_ID_PENUP_DESCRIPTION = "penupDescription";

    @NotNull
    private static final String BINDING_ID_PENUP_ROTATION_DESCRIPTION = "penupRotationDescription";

    @NotNull
    private static final String BINDING_ID_REDO_DESCRIPTION = "redoDescription";

    @NotNull
    private static final String BINDING_ID_REDO_ROTATION_DESCRIPTION = "redoRotationDescription";

    @NotNull
    private static final String BINDING_ID_ROUND_RIPPLE = "roundRipple";

    @NotNull
    private static final String BINDING_ID_SUBMENU_STROKE_SIZE_PX = "subMenuStrokeSizePx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_CHILD_BUTTON_MARGIN_PX = "toolbarChildButtonMarginPx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_CHILD_BUTTON_SIZE_PX = "toolbarChildButtonSizePx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_HEIGHT_PX = "toolbarHeightPx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_ICON_MARGIN_PX = "toolbarIconMarginPx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_MARGIN_BOTTOM_PX = "toolbarMarginBottomPx";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_PREFIX = "toolbar";

    @NotNull
    private static final String BINDING_ID_TOOLBAR_WIDTH_PX = "toolbarWidthPx";

    @NotNull
    private static final String BINDING_ID_TOP_RIGHT_ROTATION_PIVOT = "topRightRotationPivot";

    @NotNull
    private static final String BINDING_ID_UNDO_DESCRIPTION = "undoDescription";

    @NotNull
    private static final String BINDING_ID_UNDO_ROTATION_DESCRIPTION = "undoRotationDescription";

    @NotNull
    private static final String BINDING_ID_ZOOM_TEXT_MARGIN_END_PX = "zoomTextMarginEndPx";

    @NotNull
    private static final String BINDING_ID_ZOOM_TEXT_MARGIN_TOP_PX = "zoomTextMarginTopPx";

    @NotNull
    private static final String BINDING_ID_ZOOM_TEXT_PREFIX = "zoomText";

    @NotNull
    private static final String TAG = Logger.createTag("SubMenuLayoutViewModel.");

    @Nullable
    private IBrushMenuInfo mBrushMenuInfo;

    @Nullable
    private IBaseModel.Observer mCallBack;

    @Nullable
    private IMenuSizeInjector mMenuSizeInjector;

    @NotNull
    private final IRotationMode.OnRotationChangeListener mOrientationListener;

    @Nullable
    private IScreenModel mScreenModel;
    private int mSubMenuBottomMargin;

    public SubMenuLayoutViewModel(@NotNull IMenuSizeInjector injector, @NotNull IScreenModel screenModel) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        Intrinsics.checkNotNullParameter(screenModel, "screenModel");
        IRotationMode.OnRotationChangeListener onRotationChangeListener = new IRotationMode.OnRotationChangeListener() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.SubMenuLayoutViewModel$mOrientationListener$1
            @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode.OnRotationChangeListener
            public void onRotationChanged(IRotationEvent action) {
                this.this$0.notifyChanged("penupRotationDescription");
                this.this$0.notifyChanged("eraserRotationDescription");
                this.this$0.notifyChanged("undoRotationDescription");
                this.this$0.notifyChanged("redoRotationDescription");
                this.this$0.notifyChanged("bottomRotationPivot");
                this.this$0.notifyChanged("topRightRotationPivot");
            }
        };
        this.mOrientationListener = onRotationChangeListener;
        this.mCallBack = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.SubMenuLayoutViewModel$mCallBack$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                if (id.intValue() == 2) {
                    this.this$0.updateSubMenuMarginBottom();
                }
            }
        };
        this.mMenuSizeInjector = injector;
        this.mScreenModel = screenModel;
        Intrinsics.checkNotNull(screenModel);
        IBaseModel.Observer observer = this.mCallBack;
        Intrinsics.checkNotNull(observer);
        screenModel.addObserver(observer);
        IScreenModel iScreenModel = this.mScreenModel;
        Intrinsics.checkNotNull(iScreenModel);
        iScreenModel.addRotationChangeListener(onRotationChangeListener);
        updateSubMenuMarginBottom();
    }

    private final IRotationExtraEvent getBottomRotationPivot() {
        return getRotationExtraEvent(2, 2);
    }

    /* JADX INFO: renamed from: getBrushMenuInfo, reason: from getter */
    private final IBrushMenuInfo getMBrushMenuInfo() {
        return this.mBrushMenuInfo;
    }

    private final int getDoneButtonHeightPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getDoneButtonHeightPx();
    }

    private final int getDoneButtonWidthPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getDoneButtonWidthPx();
    }

    private final int getEraserDescription() {
        return C7944R.string.base_string_eraser;
    }

    private final IRotationExtraEvent getEraserRotationDescription() {
        return getRotationExtraEvent(C7944R.string.base_string_eraser, 1);
    }

    private final int getMenuSize() {
        IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
        if ((iBrushMenuInfo != null ? iBrushMenuInfo.getMColorRect() : null) == null) {
            return 0;
        }
        IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo2);
        int iWidth = iBrushMenuInfo2.getMColorRect().width();
        IBrushMenuInfo iBrushMenuInfo3 = this.mBrushMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo3);
        if (iWidth > iBrushMenuInfo3.getMColorRect().height()) {
            IBrushMenuInfo iBrushMenuInfo4 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo4);
            return iBrushMenuInfo4.getMColorRect().height();
        }
        IBrushMenuInfo iBrushMenuInfo5 = this.mBrushMenuInfo;
        Intrinsics.checkNotNull(iBrushMenuInfo5);
        return iBrushMenuInfo5.getMColorRect().width();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object getOtherData(String id) {
        switch (id.hashCode()) {
            case -1930945048:
                if (id.equals(BINDING_ID_PENUP_DESCRIPTION)) {
                    return Integer.valueOf(getPenUpDescription());
                }
                break;
            case -1737924305:
                if (id.equals(BINDING_ID_PENUP_BUTTON_WIDTH_HEIGHT_PX)) {
                    return Integer.valueOf(getPenUpButtonWidthHeightPx());
                }
                break;
            case -1670865800:
                if (id.equals(BINDING_ID_UNDO_DESCRIPTION)) {
                    return Integer.valueOf(getUndoDescription());
                }
                break;
            case -1643493602:
                if (id.equals(BINDING_ID_REDO_DESCRIPTION)) {
                    return Integer.valueOf(getRedoDescription());
                }
                break;
            case -1633284214:
                if (id.equals(BINDING_ID_PENUP_ROTATION_DESCRIPTION)) {
                    return getPenupRotationDescription();
                }
                break;
            case -1603450873:
                if (id.equals(BINDING_ID_BRUSH_MENU_INFO)) {
                    return getMBrushMenuInfo();
                }
                break;
            case -1442929984:
                if (id.equals(BINDING_ID_REDO_ROTATION_DESCRIPTION)) {
                    return getRedoRotationDescription();
                }
                break;
            case -997930237:
                if (id.equals(BINDING_ID_DONE_BUTTON_HEIGHT_PX)) {
                    return Integer.valueOf(getDoneButtonHeightPx());
                }
                break;
            case -741178758:
                if (id.equals(BINDING_ID_DONE_BUTTON_WIDTH_PX)) {
                    return Integer.valueOf(getDoneButtonWidthPx());
                }
                break;
            case -611290786:
                if (id.equals(BINDING_ID_ROUND_RIPPLE)) {
                    return Integer.valueOf(getRoundRipple());
                }
                break;
            case 78788829:
                if (id.equals(BINDING_ID_TOP_RIGHT_ROTATION_PIVOT)) {
                    return getTopRightRotationPivot();
                }
                break;
            case 420511481:
                if (id.equals(BINDING_ID_BOTTOM_ROTATION_PIVOT)) {
                    return getBottomRotationPivot();
                }
                break;
            case 994190194:
                if (id.equals(BINDING_ID_ERASER_ROTATION_DESCRIPTION)) {
                    return getEraserRotationDescription();
                }
                break;
            case 1128726042:
                if (id.equals(BINDING_ID_UNDO_ROTATION_DESCRIPTION)) {
                    return getUndoRotationDescription();
                }
                break;
            case 1277860304:
                if (id.equals(BINDING_ID_ERASER_DESCRIPTION)) {
                    return Integer.valueOf(getEraserDescription());
                }
                break;
            case 1561107360:
                if (id.equals(BINDING_ID_SUBMENU_STROKE_SIZE_PX)) {
                    return Integer.valueOf(getSubMenuStrokeSizePx());
                }
                break;
        }
        return super.getData(id);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object getPanningBarData(String id) {
        switch (id.hashCode()) {
            case -1803105140:
                if (id.equals(BINDING_ID_PANNINGBAR_WIDTH_PX)) {
                    return Integer.valueOf(getPanningBarWidthPx());
                }
                break;
            case -1165726193:
                if (id.equals(BINDING_ID_PANNINGBAR_H_MARGIN_END_PX)) {
                    return Integer.valueOf(getPanningBarHorizontalMarginEndPx());
                }
                break;
            case -385516803:
                if (id.equals(BINDING_ID_PANNINGBAR_V_MARGIN_END_PX)) {
                    return Integer.valueOf(getPanningBarVerticalMarginEndPx());
                }
                break;
            case 256663705:
                if (id.equals(BINDING_ID_PANNINGBAR_V_MARGIN_BOTTOM_PX)) {
                    return Integer.valueOf(getPanningBarVerticalMarginBottomPx());
                }
                break;
            case 442090289:
                if (id.equals(BINDING_ID_PANNINGBAR_HEIGHT_PX)) {
                    return Integer.valueOf(getPanningBarHeightPx());
                }
                break;
            case 1401732167:
                if (id.equals(BINDING_ID_PANNINGBAR_H_MARGIN_BOTTOM_PX)) {
                    return Integer.valueOf(getPanningBarHorizontalMarginBottomPx());
                }
                break;
            case 1840589802:
                if (id.equals(BINDING_ID_PANNINGBAR_V_PADDING_END_PX)) {
                    return Integer.valueOf(getPanningBarVerticalPaddingEndPx());
                }
                break;
        }
        return super.getData(id);
    }

    private final int getPanningBarHeightPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarHeightPx();
    }

    private final int getPanningBarHorizontalMarginBottomPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarHorizontalMarginBottomPx();
    }

    private final int getPanningBarHorizontalMarginEndPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarHorizontalMarginEndPx();
    }

    private final int getPanningBarVerticalMarginBottomPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarVerticalMarginBottomPx();
    }

    private final int getPanningBarVerticalMarginEndPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarVerticalMarginEndPx();
    }

    private final int getPanningBarVerticalPaddingEndPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarVerticalPaddingEndPx();
    }

    private final int getPanningBarWidthPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPanningBarWidthPx();
    }

    private final int getPenUpButtonWidthHeightPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getPenUpButtonWidthHeightPx();
    }

    private final int getPenUpDescription() {
        return C7944R.string.brush_penup_name;
    }

    private final IRotationExtraEvent getPenupRotationDescription() {
        return getRotationExtraEvent(C7944R.string.brush_penup_name, 1);
    }

    private final int getRedoDescription() {
        return C7944R.string.base_string_redo;
    }

    private final IRotationExtraEvent getRedoRotationDescription() {
        return getRotationExtraEvent(C7944R.string.base_string_redo, 1);
    }

    private final IRotationExtraEvent getRotationExtraEvent(int data, int type) {
        IScreenModel iScreenModel = this.mScreenModel;
        if (iScreenModel == null) {
            return null;
        }
        Intrinsics.checkNotNull(iScreenModel);
        return new RotationExtraEvent(iScreenModel.getMRotationInfo(), data, type);
    }

    private final int getRoundRipple() {
        return DrawableUtils.TYPE_CIRCLE;
    }

    private final int getToolbarChildButtonMarginPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getToolbarChildButtonMarginPx();
    }

    private final int getToolbarChildButtonSizePx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getToolbarChildButtonSizePx();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object getToolbarData(String id) {
        switch (id.hashCode()) {
            case -1857742221:
                if (id.equals(BINDING_ID_TOOLBAR_WIDTH_PX)) {
                    return Integer.valueOf(getToolbarWidthPx());
                }
                break;
            case -1403763268:
                if (id.equals(BINDING_ID_TOOLBAR_MARGIN_BOTTOM_PX)) {
                    return Integer.valueOf(getMSubMenuBottomMargin());
                }
                break;
            case -1251659222:
                if (id.equals(BINDING_ID_TOOLBAR_HEIGHT_PX)) {
                    return Integer.valueOf(getToolbarHeightPx());
                }
                break;
            case 282006121:
                if (id.equals(BINDING_ID_TOOLBAR_CHILD_BUTTON_MARGIN_PX)) {
                    return Integer.valueOf(getToolbarChildButtonMarginPx());
                }
                break;
            case 985428746:
                if (id.equals(BINDING_ID_TOOLBAR_ICON_MARGIN_PX)) {
                    return Integer.valueOf(getToolbarIconMarginPx());
                }
                break;
            case 1953991868:
                if (id.equals(BINDING_ID_TOOLBAR_CHILD_BUTTON_SIZE_PX)) {
                    return Integer.valueOf(getToolbarChildButtonSizePx());
                }
                break;
        }
        return super.getData(id);
    }

    private final int getToolbarHeightPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getToolbarHeightPx();
    }

    private final int getToolbarIconMarginPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getToolbarIconMarginPx();
    }

    /* JADX INFO: renamed from: getToolbarMarginBottomPx, reason: from getter */
    private final int getMSubMenuBottomMargin() {
        return this.mSubMenuBottomMargin;
    }

    private final int getToolbarWidthPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getToolbarWidthPx();
    }

    private final IRotationExtraEvent getTopRightRotationPivot() {
        return getRotationExtraEvent(9, 2);
    }

    private final int getUndoDescription() {
        return C7944R.string.base_string_undo;
    }

    private final IRotationExtraEvent getUndoRotationDescription() {
        return getRotationExtraEvent(C7944R.string.base_string_undo, 1);
    }

    private final Object getZoomTextMarginData(String id) {
        return Intrinsics.areEqual(id, BINDING_ID_ZOOM_TEXT_MARGIN_END_PX) ? Integer.valueOf(getZoomTextMarginEndPx()) : Intrinsics.areEqual(id, BINDING_ID_ZOOM_TEXT_MARGIN_TOP_PX) ? Integer.valueOf(getZoomTextMarginTopPx()) : super.getData(id);
    }

    private final int getZoomTextMarginEndPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getZoomTextMarginEndPx();
    }

    private final int getZoomTextMarginTopPx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getZoomTextMargiTopPx();
    }

    private final void setLayoutBottom(View targetView, View subMenuView, boolean isOverlapped) {
        targetView.post(new RunnableC7967b(this, targetView, subMenuView, isOverlapped));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLayoutBottom$lambda$0(SubMenuLayoutViewModel subMenuLayoutViewModel, View view, View view2, boolean z) {
        if (subMenuLayoutViewModel.mMenuSizeInjector == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (!z) {
            int i = marginLayoutParams.bottomMargin;
            int i2 = marginLayoutParams2.bottomMargin;
            if (i != i2) {
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i2);
                view.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        int i4 = marginLayoutParams.bottomMargin;
        int i5 = marginLayoutParams2.bottomMargin;
        if (i4 == i5) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, view2.getHeight() + (i5 * 2));
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private final void setLayoutMarginEnd(View doneView, boolean isOverlapped) {
        doneView.post(new RunnableC7966a(this, doneView, isOverlapped, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLayoutMarginEnd$lambda$2(SubMenuLayoutViewModel subMenuLayoutViewModel, View view, boolean z) {
        if (subMenuLayoutViewModel.mMenuSizeInjector == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        IMenuSizeInjector iMenuSizeInjector = subMenuLayoutViewModel.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        int toolbarIconMarginPx = iMenuSizeInjector.getToolbarIconMarginPx();
        if (z) {
            marginLayoutParams.setMarginEnd(toolbarIconMarginPx + subMenuLayoutViewModel.getMenuSize());
            view.setLayoutParams(marginLayoutParams);
        } else if (marginLayoutParams.getMarginEnd() != toolbarIconMarginPx) {
            marginLayoutParams.setMarginEnd(toolbarIconMarginPx);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private final void setLayoutMarginStart(View penUpView, boolean isOverlapped) {
        penUpView.post(new RunnableC7966a(this, penUpView, isOverlapped, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLayoutMarginStart$lambda$1(SubMenuLayoutViewModel subMenuLayoutViewModel, View view, boolean z) {
        if (subMenuLayoutViewModel.mMenuSizeInjector == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        IMenuSizeInjector iMenuSizeInjector = subMenuLayoutViewModel.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        int toolbarIconMarginPx = iMenuSizeInjector.getToolbarIconMarginPx();
        if (z) {
            marginLayoutParams.setMarginStart(toolbarIconMarginPx + subMenuLayoutViewModel.getMenuSize());
            view.setLayoutParams(marginLayoutParams);
        } else if (marginLayoutParams.getMarginStart() != toolbarIconMarginPx) {
            marginLayoutParams.setMarginStart(toolbarIconMarginPx);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private final void setToolbarIconMarginPx(int bottomMargin) {
        if (this.mSubMenuBottomMargin != bottomMargin) {
            this.mSubMenuBottomMargin = bottomMargin;
            notifyChanged(BINDING_ID_TOOLBAR_MARGIN_BOTTOM_PX);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f A[PHI: r12
      0x006f: PHI (r12v5 boolean) = (r12v2 boolean), (r12v8 boolean) binds: [B:26:0x00ab, B:15:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updatePenUpDoneButtonPosition(View subMenuLayout, View penUpLayout, View doneLayout, boolean isPenUp, boolean isDone) {
        boolean z;
        Object parent = subMenuLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width = ((View) parent).getWidth();
        int[] iArr = new int[2];
        int layoutDirection = subMenuLayout.getContext().getResources().getConfiguration().getLayoutDirection();
        subMenuLayout.getLocationInWindow(iArr);
        boolean z2 = false;
        int i = iArr[0];
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        int toolbarWidthPx = iMenuSizeInjector.getToolbarWidthPx() + i;
        if (layoutDirection == 0) {
            IMenuSizeInjector iMenuSizeInjector2 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector2);
            int toolbarIconMarginPx = width - iMenuSizeInjector2.getToolbarIconMarginPx();
            IMenuSizeInjector iMenuSizeInjector3 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector3);
            int doneButtonWidthPx = toolbarIconMarginPx - iMenuSizeInjector3.getDoneButtonWidthPx();
            if (isDone) {
                doneButtonWidthPx -= getMenuSize();
            }
            z = doneButtonWidthPx <= toolbarWidthPx;
            IMenuSizeInjector iMenuSizeInjector4 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector4);
            int toolbarIconMarginPx2 = iMenuSizeInjector4.getToolbarIconMarginPx();
            IMenuSizeInjector iMenuSizeInjector5 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector5);
            int penUpButtonWidthHeightPx = iMenuSizeInjector5.getPenUpButtonWidthHeightPx() + toolbarIconMarginPx2;
            if (isPenUp) {
                penUpButtonWidthHeightPx += getMenuSize();
            }
            if (penUpButtonWidthHeightPx >= i) {
            }
        } else if (layoutDirection != 1) {
            z = false;
        } else {
            int[] iArr2 = new int[2];
            doneLayout.getLocationInWindow(iArr2);
            int width2 = doneLayout.getWidth() + iArr2[0];
            if (isDone) {
                width2 += getMenuSize();
            }
            z = width2 >= i;
            IMenuSizeInjector iMenuSizeInjector6 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector6);
            int toolbarIconMarginPx3 = width - iMenuSizeInjector6.getToolbarIconMarginPx();
            IMenuSizeInjector iMenuSizeInjector7 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector7);
            int penUpButtonWidthHeightPx2 = toolbarIconMarginPx3 - iMenuSizeInjector7.getPenUpButtonWidthHeightPx();
            if (isPenUp) {
                penUpButtonWidthHeightPx2 -= getMenuSize();
            }
            if (penUpButtonWidthHeightPx2 <= toolbarWidthPx) {
                z2 = true;
            }
        }
        setLayoutBottom(penUpLayout, subMenuLayout, z2);
        setLayoutBottom(doneLayout, subMenuLayout, z);
        Logger.m7100d(TAG, "Submenu isOverlap?? " + z2 + SQLKeyword.COMMA + z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubMenuMarginBottom() {
        IScreenModel iScreenModel = this.mScreenModel;
        Integer numValueOf = iScreenModel != null ? Integer.valueOf(iScreenModel.getMOrientation()) : null;
        Intrinsics.checkNotNull(numValueOf);
        updateSubMenuMarginBottom(numValueOf.intValue());
    }

    private final void updateSubMenuPosition(View subMenuLayout) {
        IScreenModel iScreenModel = this.mScreenModel;
        if (iScreenModel != null) {
            Intrinsics.checkNotNull(iScreenModel);
            updateSubMenuPosition(subMenuLayout, iScreenModel.getMOrientation());
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        IScreenModel iScreenModel = this.mScreenModel;
        if (iScreenModel != null) {
            Intrinsics.checkNotNull(iScreenModel);
            IBaseModel.Observer observer = this.mCallBack;
            Intrinsics.checkNotNull(observer);
            iScreenModel.removeObserver(observer);
            IScreenModel iScreenModel2 = this.mScreenModel;
            Intrinsics.checkNotNull(iScreenModel2);
            iScreenModel2.removeRotationChangeListener(this.mOrientationListener);
            this.mScreenModel = null;
        }
        this.mMenuSizeInjector = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallBack = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return id == null ? super.getData(id) : StringsKt.m14145S(id, BINDING_ID_ZOOM_TEXT_PREFIX) ? getZoomTextMarginData(id) : StringsKt.m14145S(id, BINDING_ID_PANNINGBAR_PREFIX) ? getPanningBarData(id) : StringsKt.m14145S(id, BINDING_ID_TOOLBAR_PREFIX) ? getToolbarData(id) : getOtherData(id);
    }

    public final int getSubMenuStrokeSizePx() {
        IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
        Intrinsics.checkNotNull(iMenuSizeInjector);
        return iMenuSizeInjector.getSubMenuStrokeSizePx();
    }

    public final void onLayoutChange(@Nullable View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int i = right - left;
        int i2 = bottom - top;
        int i4 = oldBottom - oldTop;
        if ((oldRight - oldLeft == i && i4 == i2) || this.mMenuSizeInjector == null || !(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        View childAt = viewGroup.getChildAt(2);
        View childAt2 = viewGroup.getChildAt(0);
        View childAt3 = viewGroup.getChildAt(3);
        int i5 = i < i2 ? 1 : 2;
        if ((childAt instanceof LinearLayout) && (childAt2 instanceof FrameLayout) && (childAt3 instanceof Button)) {
            updateSubMenuPosition(childAt, i5);
            updatePenUpDoneButtonPosition(childAt, childAt2, childAt3, false, false);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        LayoutChangeEvent layoutChangeEvent;
        if (Intrinsics.areEqual(BINDING_ID_ON_LAYOUT_CHANGE, action != null ? action.getMBindId() : null) && (layoutChangeEvent = (LayoutChangeEvent) action.getData()) != null) {
            onLayoutChange(layoutChangeEvent.mView, layoutChangeEvent.mLeft, layoutChangeEvent.mTop, layoutChangeEvent.mRight, layoutChangeEvent.mBottom, layoutChangeEvent.mOldLeft, layoutChangeEvent.mOldTop, layoutChangeEvent.mOldRight, layoutChangeEvent.mOldBottom);
        }
        super.perform(action);
    }

    public final void setBrushMenuInfo(@Nullable IBrushMenuInfo info) {
        this.mBrushMenuInfo = info;
        notifyChanged(BINDING_ID_BRUSH_MENU_INFO);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setLayoutRect(@Nullable View view) {
        boolean z;
        boolean z2;
        if (this.mBrushMenuInfo == null || view == null) {
            return;
        }
        View viewFindViewById = view.findViewById(C7944R.id.brush_sub_menu_layout);
        View viewFindViewById2 = view.findViewById(C7944R.id.brush_penup_layout);
        View viewFindViewById3 = view.findViewById(C7944R.id.brush_done_button);
        if ((viewFindViewById instanceof LinearLayout) && (viewFindViewById2 instanceof FrameLayout) && (viewFindViewById3 instanceof Button)) {
            updateSubMenuPosition(viewFindViewById);
            IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector);
            int toolbarIconMarginPx = iMenuSizeInjector.getToolbarIconMarginPx();
            int width = view.getWidth();
            IMenuSizeInjector iMenuSizeInjector2 = this.mMenuSizeInjector;
            Intrinsics.checkNotNull(iMenuSizeInjector2);
            int toolbarIconMarginPx2 = width - iMenuSizeInjector2.getToolbarIconMarginPx();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int height = (view.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - CommonUtil.getStatusBarHeight(view.getContext());
            int layoutDirection = view.getResources().getConfiguration().getLayoutDirection();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            if (layoutDirection == 0) {
                FrameLayout frameLayout = (FrameLayout) viewFindViewById2;
                rect.set(toolbarIconMarginPx, height - frameLayout.getHeight(), frameLayout.getWidth() + toolbarIconMarginPx, height);
                Button button = (Button) viewFindViewById3;
                rect2.set(toolbarIconMarginPx2 - button.getWidth(), height - button.getHeight(), toolbarIconMarginPx2, height);
            } else if (layoutDirection == 1) {
                Button button2 = (Button) viewFindViewById3;
                rect.set(toolbarIconMarginPx2 - button2.getWidth(), height - button2.getHeight(), toolbarIconMarginPx2, height);
                FrameLayout frameLayout2 = (FrameLayout) viewFindViewById2;
                rect2.set(toolbarIconMarginPx, height - frameLayout2.getHeight(), frameLayout2.getWidth() + toolbarIconMarginPx, height);
            }
            IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo);
            if (!iBrushMenuInfo.getMPenRect().intersects(rect.left, rect.top, rect.right, rect.bottom)) {
                IBrushMenuInfo iBrushMenuInfo2 = this.mBrushMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo2);
                z = iBrushMenuInfo2.getMColorRect().intersects(rect.left, rect.top, rect.right, rect.bottom);
            }
            IBrushMenuInfo iBrushMenuInfo3 = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo3);
            if (!iBrushMenuInfo3.getMPenRect().intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                IBrushMenuInfo iBrushMenuInfo4 = this.mBrushMenuInfo;
                Intrinsics.checkNotNull(iBrushMenuInfo4);
                z2 = iBrushMenuInfo4.getMColorRect().intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
            setLayoutMarginEnd(viewFindViewById3, z2);
            setLayoutMarginStart(viewFindViewById2, z);
            Logger.m7100d(TAG, "Brush menu isOverlap?? " + z + SQLKeyword.COMMA + z2);
            updatePenUpDoneButtonPosition(viewFindViewById, viewFindViewById2, viewFindViewById3, z, z2);
        }
    }

    private final void updateSubMenuMarginBottom(int orientation) {
        Integer numValueOf;
        if (orientation == 1) {
            IMenuSizeInjector iMenuSizeInjector = this.mMenuSizeInjector;
            numValueOf = iMenuSizeInjector != null ? Integer.valueOf(iMenuSizeInjector.getToolbarMarginBottomPx()) : null;
            Intrinsics.checkNotNull(numValueOf);
            setToolbarIconMarginPx(numValueOf.intValue());
            return;
        }
        if (orientation != 2) {
            return;
        }
        IMenuSizeInjector iMenuSizeInjector2 = this.mMenuSizeInjector;
        numValueOf = iMenuSizeInjector2 != null ? Integer.valueOf(iMenuSizeInjector2.getToolbarLandMarginBottomPx()) : null;
        Intrinsics.checkNotNull(numValueOf);
        setToolbarIconMarginPx(numValueOf.intValue());
    }

    private final void updateSubMenuPosition(View subMenuLayout, int orientation) {
        if (subMenuLayout == null || this.mBrushMenuInfo == null) {
            return;
        }
        if (!TabletUtil.isTabletUi()) {
            updateSubMenuMarginBottom(orientation);
            IBrushMenuInfo iBrushMenuInfo = this.mBrushMenuInfo;
            Intrinsics.checkNotNull(iBrushMenuInfo);
            if (iBrushMenuInfo.getMColorAlign() == 2) {
                int layoutDirection = subMenuLayout.getResources().getConfiguration().getLayoutDirection();
                if (layoutDirection == 0) {
                    subMenuLayout.setTranslationX(getMenuSize() / 2.0f);
                    return;
                } else {
                    if (layoutDirection != 1) {
                        return;
                    }
                    subMenuLayout.setTranslationX((-getMenuSize()) / 2.0f);
                    return;
                }
            }
            subMenuLayout.setTranslationX(0.0f);
            return;
        }
        subMenuLayout.setTranslationX(0.0f);
    }
}
