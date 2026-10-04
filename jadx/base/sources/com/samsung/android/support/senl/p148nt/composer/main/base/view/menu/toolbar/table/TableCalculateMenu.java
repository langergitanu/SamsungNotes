package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table;

import android.content.Context;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.SwitchCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TableManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.TableCellSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ToolbarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020)J\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/TableCalculateMenu;", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;)V", "mPresenter", "getMPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;", "mPopupWindow", "Landroid/widget/PopupWindow;", "getMPopupWindow", "()Landroid/widget/PopupWindow;", "setMPopupWindow", "(Landroid/widget/PopupWindow;)V", "mContainer", "Landroid/view/View;", "getMContainer", "()Landroid/view/View;", "setMContainer", "(Landroid/view/View;)V", "mSumSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "getMSumSwitch", "()Landroidx/appcompat/widget/SwitchCompat;", "setMSumSwitch", "(Landroidx/appcompat/widget/SwitchCompat;)V", "mAverageSwitch", "getMAverageSwitch", "setMAverageSwitch", "setupAddDialog", "", "context", "Landroid/content/Context;", "setUp", "resourceId", "", "initSwitch", "container", "initCloseButton", "setUpRemoveDialog", "", Constants.IntentExtraValue.SHOW, "showAddMenu", "showPopupWindow", "hide", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableCalculateMenu {

    @NotNull
    private static final String TAG;
    public SwitchCompat mAverageSwitch;
    public View mContainer;

    @Nullable
    private PopupWindow mPopupWindow;

    @NotNull
    private final TableAndCellPresenter mPresenter;
    public SwitchCompat mSumSwitch;

    static {
        String strCreateTag = Logger.createTag("TableCalculateMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public TableCalculateMenu(@NotNull TableAndCellPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mPresenter = presenter;
    }

    private final void initCloseButton(View container) {
        ViewOnClickListenerC10850c viewOnClickListenerC10850c = new ViewOnClickListenerC10850c(this, 2);
        View viewFindViewById = container.findViewById(C9086R.id.close_btn);
        ToolbarUtil.setBgRippleToolbar(viewFindViewById);
        ToolbarUtil.setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
        viewFindViewById.setOnClickListener(viewOnClickListenerC10850c);
        container.findViewById(C9086R.id.dialog_cancel).setOnClickListener(viewOnClickListenerC10850c);
        container.findViewById(C9086R.id.dialog_done).setOnClickListener(new ViewOnClickListenerC10850c(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCloseButton$lambda$3(TableCalculateMenu tableCalculateMenu, View view) {
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_ADD_CALCULATION, AbstractC0541b.m774p("a:", tableCalculateMenu.getMSumSwitch().isChecked() ? "1" : "0", " b:", tableCalculateMenu.getMAverageSwitch().isChecked() ? "1" : "0"));
        tableCalculateMenu.mPresenter.calculateCell(tableCalculateMenu.getMSumSwitch().isChecked(), tableCalculateMenu.getMAverageSwitch().isChecked());
        tableCalculateMenu.hide();
    }

    private final void initSwitch(View container) {
        TableManager.Calculation calculationFindCalculatedCell = this.mPresenter.findCalculatedCell();
        setMSumSwitch((SwitchCompat) container.findViewById(C9086R.id.comp_table_calculate_sum_switch_btn));
        getMSumSwitch().setChecked(calculationFindCalculatedCell.hasSum());
        container.findViewById(C9086R.id.comp_table_calculate_sum).setOnClickListener(new ViewOnClickListenerC10850c(this, 0));
        setMAverageSwitch((SwitchCompat) container.findViewById(C9086R.id.comp_table_calculate_average_switch_btn));
        getMAverageSwitch().setChecked(calculationFindCalculatedCell.hasAverage());
        container.findViewById(C9086R.id.comp_table_calculate_average).setOnClickListener(new ViewOnClickListenerC10850c(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSwitch$lambda$0(TableCalculateMenu tableCalculateMenu, View view) {
        tableCalculateMenu.getMSumSwitch().setChecked(!tableCalculateMenu.getMSumSwitch().isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSwitch$lambda$1(TableCalculateMenu tableCalculateMenu, View view) {
        tableCalculateMenu.getMAverageSwitch().setChecked(!tableCalculateMenu.getMAverageSwitch().isChecked());
    }

    private final void setUp(Context context, int resourceId) {
        setMContainer(LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null, false));
        this.mPopupWindow = new PopupWindow(getMContainer(), -2, -2);
        getMContainer().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.TableCalculateMenu$setUp$listener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                this.this$0.getMContainer().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.this$0.getMContainer().requestFocus();
            }
        });
    }

    private final boolean setUpRemoveDialog(Context context) {
        TableManager.Calculation currentCellCalculationType = this.mPresenter.getCurrentCellCalculationType();
        if (!currentCellCalculationType.hasCalculatedCell()) {
            Logger.m10999d(TAG, "setUpRemoveDialog# return: There is no calculated cell.");
            return false;
        }
        Logger.m10999d(TAG, "setUpRemoveDialog# Sum: " + currentCellCalculationType.hasSum() + ", Average: " + currentCellCalculationType.hasAverage());
        setUp(context, C9086R.layout.comp_table_calculate_remove_menu_layout);
        OptionMenuPopupWindowHelper.setDefaultState(this.mPopupWindow, context, C9086R.drawable.comp_table_calculate_remove_menu_bg);
        TextView textView = (TextView) getMContainer().findViewById(C9086R.id.comp_table_calculate_delete_menu_text);
        if (currentCellCalculationType.hasSum()) {
            textView.setText(C9086R.string.composer_table_calculate_delete_sum);
        } else if (currentCellCalculationType.hasAverage()) {
            textView.setText(C9086R.string.composer_table_calculate_delete_average);
        }
        getMContainer().setOnClickListener(new ViewOnClickListenerC0219a(this, currentCellCalculationType, 13));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpRemoveDialog$lambda$4(TableCalculateMenu tableCalculateMenu, TableManager.Calculation calculation, View view) {
        tableCalculateMenu.mPresenter.removeCalculatedCell(calculation.hasSum());
        tableCalculateMenu.hide();
    }

    private final void setupAddDialog(Context context) {
        setUp(context, C9086R.layout.comp_table_calculate_add_menu_layout);
        OptionMenuPopupWindowHelper.setDefaultState(this.mPopupWindow, context);
        initSwitch(getMContainer());
        initCloseButton(getMContainer());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPopupWindow() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.getContentView().measure(0, 0);
            RectF selectedCellRect = this.mPresenter.getSelectedCellRect(getMContainer().getMeasuredWidth());
            if (selectedCellRect != null) {
                popupWindow.showAtLocation(this.mPresenter.getAnchorView(), 0, (int) selectedCellRect.left, (int) selectedCellRect.top);
            } else {
                Logger.m10999d(TAG, "show# table rect is null");
                popupWindow.showAtLocation(this.mPresenter.getAnchorView(), 17, 0, 0);
            }
        }
    }

    @NotNull
    public final SwitchCompat getMAverageSwitch() {
        SwitchCompat switchCompat = this.mAverageSwitch;
        if (switchCompat != null) {
            return switchCompat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAverageSwitch");
        return null;
    }

    @NotNull
    public final View getMContainer() {
        View view = this.mContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    @Nullable
    public final PopupWindow getMPopupWindow() {
        return this.mPopupWindow;
    }

    @NotNull
    public final TableAndCellPresenter getMPresenter() {
        return this.mPresenter;
    }

    @NotNull
    public final SwitchCompat getMSumSwitch() {
        SwitchCompat switchCompat = this.mSumSwitch;
        if (switchCompat != null) {
            return switchCompat;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSumSwitch");
        return null;
    }

    public final void hide() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.mPopupWindow = null;
    }

    public final void setMAverageSwitch(@NotNull SwitchCompat switchCompat) {
        Intrinsics.checkNotNullParameter(switchCompat, "<set-?>");
        this.mAverageSwitch = switchCompat;
    }

    public final void setMContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mContainer = view;
    }

    public final void setMPopupWindow(@Nullable PopupWindow popupWindow) {
        this.mPopupWindow = popupWindow;
    }

    public final void setMSumSwitch(@NotNull SwitchCompat switchCompat) {
        Intrinsics.checkNotNullParameter(switchCompat, "<set-?>");
        this.mSumSwitch = switchCompat;
    }

    public final void show(boolean showAddMenu) {
        if (this.mPresenter.getActivity() == null) {
            return;
        }
        AbstractC8014b.m7220v("show# add dialog : ", TAG, showAddMenu);
        if (showAddMenu) {
            Context activity = this.mPresenter.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            setupAddDialog(activity);
        } else {
            Context activity2 = this.mPresenter.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "getActivity(...)");
            if (!setUpRemoveDialog(activity2)) {
                return;
            }
        }
        this.mPresenter.hideSoftInputAndExecute(new RunnableC9767a(this, 15));
    }

    public final void update() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            if (popupWindow == null || popupWindow.isShowing()) {
                RectF selectedCellRect = this.mPresenter.getSelectedCellRect(getMContainer().getMeasuredWidth());
                if (selectedCellRect == null) {
                    hide();
                    return;
                }
                PopupWindow popupWindow2 = this.mPopupWindow;
                if (popupWindow2 != null) {
                    popupWindow2.update((int) selectedCellRect.left, (int) selectedCellRect.top, -1, -1);
                }
            }
        }
    }
}
