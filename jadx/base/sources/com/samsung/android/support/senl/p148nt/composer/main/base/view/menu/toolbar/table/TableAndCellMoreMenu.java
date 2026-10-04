package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.TableCellSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p071Q2.ViewOnClickListenerC0220b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J$\u0010 \u001a\u00020\u001c2\b\b\u0001\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0010J\b\u0010/\u001a\u00020\u001cH\u0002J\u0006\u00100\u001a\u00020\u001cJ\u0006\u00101\u001a\u00020\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/TableAndCellMoreMenu;", "", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;)V", "mPresenter", "getMPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/table/TableAndCellPresenter;", "mPopupWindow", "Landroid/widget/PopupWindow;", "getMPopupWindow", "()Landroid/widget/PopupWindow;", "setMPopupWindow", "(Landroid/widget/PopupWindow;)V", "mIsClickedAll", "", "getMIsClickedAll", "()Z", "setMIsClickedAll", "(Z)V", "mContainer", "Landroid/view/View;", "getMContainer", "()Landroid/view/View;", "setMContainer", "(Landroid/view/View;)V", "setup", "", "context", "Landroid/content/Context;", "initButtons", "initButton", "id", "", "enabled", "clickListener", "Landroid/view/View$OnClickListener;", "initAddCellsButton", "isClickedRows", "addCells", "isRow", "initDeleteCellsButton", "initCalculateButton", "initStyleButtons", Constants.IntentExtraValue.SHOW, "isClickedAll", "showPopupWindow", "hide", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableAndCellMoreMenu {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;
    public View mContainer;
    private boolean mIsClickedAll;

    @Nullable
    private PopupWindow mPopupWindow;

    @NotNull
    private final TableAndCellPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/TableAndCellMoreMenu$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return TableAndCellMoreMenu.TAG;
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("TableAndCellMoreMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public TableAndCellMoreMenu(@NotNull TableAndCellPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mPresenter = presenter;
    }

    private final void initAddCellsButton(boolean isClickedRows) {
        View viewFindViewById = getMContainer().findViewById(C9086R.id.menu_add_rows);
        View viewFindViewById2 = getMContainer().findViewById(C9086R.id.menu_add_columns);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        if (this.mIsClickedAll) {
            if (this.mPresenter.getCountToAddCells(true) <= 0) {
                viewFindViewById.setVisibility(8);
            }
            if (this.mPresenter.getCountToAddCells(false) <= 0) {
                viewFindViewById2.setVisibility(8);
            }
        } else if (isClickedRows) {
            Intrinsics.checkNotNull(viewFindViewById);
            intRef.element = initAddCellsButton(viewFindViewById, true);
            viewFindViewById2.setVisibility(8);
        } else {
            Intrinsics.checkNotNull(viewFindViewById2);
            intRef.element = initAddCellsButton(viewFindViewById2, false);
            viewFindViewById.setVisibility(8);
        }
        final int i = 0;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        TableAndCellMoreMenu.initAddCellsButton$lambda$4(intRef, this, view);
                        break;
                    default:
                        TableAndCellMoreMenu.initAddCellsButton$lambda$5(intRef, this, view);
                        break;
                }
            }
        });
        final int i2 = 1;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        TableAndCellMoreMenu.initAddCellsButton$lambda$4(intRef, this, view);
                        break;
                    default:
                        TableAndCellMoreMenu.initAddCellsButton$lambda$5(intRef, this, view);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAddCellsButton$lambda$4(Ref.IntRef intRef, TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# add rows");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_ADD_ROW, String.valueOf(intRef.element));
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.addCells(intRef.element, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAddCellsButton$lambda$5(Ref.IntRef intRef, TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# add columns");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_ADD_COLUMN, String.valueOf(intRef.element));
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.addCells(intRef.element, false, true);
    }

    private final void initButton(@IdRes int id, boolean enabled, View.OnClickListener clickListener) {
        View viewFindViewById = getMContainer().findViewById(id);
        viewFindViewById.setOnClickListener(clickListener);
        viewFindViewById.setEnabled(enabled);
        viewFindViewById.setAlpha(enabled ? 1.0f : 0.4f);
        ViewCompat.INSTANCE.getInstance().setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    private final void initButtons() {
        initButton(C9086R.id.btnCut, true, new ViewOnClickListenerC10848a(this, 1));
        initButton(C9086R.id.btnCopy, true, new ViewOnClickListenerC10848a(this, 2));
        initButton(C9086R.id.btnPaste, this.mPresenter.canPaste(), new ViewOnClickListenerC10848a(this, 3));
        initButton(C9086R.id.btnResize, this.mPresenter.isResizableCell(), new ViewOnClickListenerC10848a(this, 4));
        boolean zIsClickedRows = this.mPresenter.isClickedRows();
        initAddCellsButton(zIsClickedRows);
        initDeleteCellsButton(zIsClickedRows);
        initCalculateButton();
        initStyleButtons(zIsClickedRows);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$0(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# cut");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_CUT);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.cutCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$1(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# copy");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_COPY);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.copyCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$2(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# paste");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_PASTE);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.pasteCell();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$3(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# resize");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_FIT_TO_PAGE_WIDTH);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.resizeCell();
    }

    private final void initCalculateButton() {
        View viewFindViewById = getMContainer().findViewById(C9086R.id.menu_calculate);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC10848a(this, 5));
        viewFindViewById.setVisibility(this.mPresenter.isCalculatable() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCalculateButton$lambda$7(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# calculate");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_ADD_CALCULATION_ROW);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.showCalculateAddMenu();
    }

    private final void initDeleteCellsButton(boolean isClickedRows) {
        View viewFindViewById = getMContainer().findViewById(C9086R.id.menu_delete_cells);
        int size = this.mPresenter.getSortedList().size();
        TextView textView = (TextView) getMContainer().findViewById(C9086R.id.menu_delete_cells_title);
        ImageView imageView = (ImageView) getMContainer().findViewById(C9086R.id.menu_delete_cells_image);
        if (this.mPresenter.isSelectedAllCells()) {
            textView.setText(C9086R.string.composer_ctx_menu_table_delete);
            imageView.setImageResource(C9086R.drawable.composer_delete_table);
        } else {
            if (size > 1) {
                textView.setText(textView.getResources().getQuantityString(isClickedRows ? C9086R.plurals.plurals_composer_ctx_menu_table_delete_rows : C9086R.plurals.plurals_composer_ctx_menu_table_delete_columns, size, Integer.valueOf(size)));
            } else {
                textView.setText(isClickedRows ? C9086R.string.composer_ctx_menu_table_delete_row : C9086R.string.composer_ctx_menu_table_delete_column);
            }
            imageView.setImageResource(isClickedRows ? C9086R.drawable.composer_table_delete_row : C9086R.drawable.composer_table_delete_column);
        }
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0220b(this, size, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDeleteCellsButton$lambda$6(TableAndCellMoreMenu tableAndCellMoreMenu, int i, View view) {
        Logger.m10999d(TAG, "onClick# delete cells");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, tableAndCellMoreMenu.mPresenter.isClickedRows() ? TableCellSAConstants.EVENT_TABLE_MORE_MENU_DELETE_ROW : TableCellSAConstants.EVENT_TABLE_MORE_MENU_DELETE_COLUMN, String.valueOf(i));
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.deleteCell();
    }

    private final void initStyleButtons(boolean isClickedRows) {
        View viewFindViewById = getMContainer().findViewById(C9086R.id.menu_cell_style);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC10848a(this, 6));
        if (this.mPresenter.isSelectedAllCells()) {
            viewFindViewById.setVisibility(8);
        } else {
            ((ImageView) getMContainer().findViewById(C9086R.id.menu_cell_style_image)).setImageResource(isClickedRows ? C9086R.drawable.composer_table_row_cell_style : C9086R.drawable.composer_table_column_cell_style);
        }
        getMContainer().findViewById(C9086R.id.menu_table_style).setOnClickListener(new ViewOnClickListenerC10848a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStyleButtons$lambda$8(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# cell style");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_CELL_STYLE);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.showCellStyle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initStyleButtons$lambda$9(TableAndCellMoreMenu tableAndCellMoreMenu, View view) {
        Logger.m10999d(TAG, "onClick# table style");
        ComposerSA.insertLog(TableCellSAConstants.PAGE_ID_TABLE, TableCellSAConstants.EVENT_TABLE_MORE_MENU_TABLE_STYLE);
        tableAndCellMoreMenu.hide();
        tableAndCellMoreMenu.mPresenter.showTableStyle();
    }

    private final void setup(Context context) {
        setMContainer(LayoutInflater.from(context).inflate(C9086R.layout.comp_table_and_cell_more_menu_layout, (ViewGroup) null, false));
        PopupWindow popupWindow = new PopupWindow(getMContainer(), -2, -2);
        this.mPopupWindow = popupWindow;
        OptionMenuPopupWindowHelper.setDefaultState(popupWindow, context);
        getMContainer().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.table.TableAndCellMoreMenu$setup$listener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                this.this$0.getMContainer().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.this$0.getMContainer().requestFocus();
            }
        });
        initButtons();
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
    public final View getMContainer() {
        View view = this.mContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final boolean getMIsClickedAll() {
        return this.mIsClickedAll;
    }

    @Nullable
    public final PopupWindow getMPopupWindow() {
        return this.mPopupWindow;
    }

    @NotNull
    public final TableAndCellPresenter getMPresenter() {
        return this.mPresenter;
    }

    public final void hide() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.mPopupWindow = null;
    }

    public final void setMContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mContainer = view;
    }

    public final void setMIsClickedAll(boolean z) {
        this.mIsClickedAll = z;
    }

    public final void setMPopupWindow(@Nullable PopupWindow popupWindow) {
        this.mPopupWindow = popupWindow;
    }

    public final void show(boolean isClickedAll) {
        if (this.mPresenter.getActivity() == null) {
            return;
        }
        this.mIsClickedAll = isClickedAll;
        Context activity = this.mPresenter.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        setup(activity);
        this.mPresenter.hideSoftInputAndExecute(new RunnableC9767a(this, 14));
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

    private final int initAddCellsButton(View addCells, boolean isRow) {
        int i;
        int countToAddCells = this.mPresenter.getCountToAddCells(isRow);
        int size = this.mPresenter.getSortedEditableList(isRow).size();
        if (countToAddCells <= 0 || size == 0) {
            addCells.setVisibility(8);
            return size;
        }
        TextView textView = (TextView) getMContainer().findViewById(isRow ? C9086R.id.menu_add_rows_title : C9086R.id.menu_add_columns_title);
        if (size <= countToAddCells) {
            countToAddCells = size;
        }
        if (countToAddCells > 1) {
            Resources resources = textView.getResources();
            if (isRow) {
                i = C9086R.plurals.plurals_composer_ctx_menu_table_add_rows;
            } else {
                i = C9086R.plurals.plurals_composer_ctx_menu_table_add_columns;
            }
            textView.setText(resources.getQuantityString(i, countToAddCells, Integer.valueOf(countToAddCells)));
        }
        return countToAddCells;
    }
}
