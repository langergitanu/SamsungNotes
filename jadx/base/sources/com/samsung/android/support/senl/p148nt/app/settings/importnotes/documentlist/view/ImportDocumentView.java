package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.spr.drawable.SprDrawable;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportViewContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.holder.ImportDocumentRecyclerViewHolder;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialog;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001TB!\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0016J\u0016\u0010)\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0006\u0010.\u001a\u00020\u001eJ\b\u0010/\u001a\u00020\u001eH\u0016J\u0010\u00100\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u000102J\u0006\u00103\u001a\u00020\u001eJ\b\u0010<\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020\u001eH\u0016J\u0012\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010DH\u0016J\b\u0010I\u001a\u00020\u001eH\u0002J\b\u0010J\u001a\u00020\u001eH\u0016J\b\u0010K\u001a\u00020\u001eH\u0016J\b\u0010L\u001a\u00020\u001eH\u0016J\b\u0010M\u001a\u00020\u001eH\u0016J\u0018\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020\u001eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u00104\u001a\u0004\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u0001098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R$\u0010?\u001a\u00020$2\u0006\u0010?\u001a\u00020$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010@R\u0016\u0010E\u001a\u0004\u0018\u00010F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010S\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010@¨\u0006U"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialogContract$IView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IListPopupWindow;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;", "mImport", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentViewContract;", "<init>", "(Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentViewContract;)V", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenter;", "mDialog", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/dialog/ImportDocumentDialog;", "mCategorySpinnerLayout", "Landroid/widget/LinearLayout;", "mSpinnerText", "Landroid/widget/TextView;", "mSpinnerPopupMenu", "Landroidx/appcompat/widget/ListPopupWindow;", "value", "", "selectedCategoryPosition", "getSelectedCategoryPosition", "()I", "onCreate", "", "onViewCreated", "onDestroy", "initLayout", "setAllItemChecked", "checked", "", "initSpinnerLayout", "updateSpinnerTitle", "position", "getRecyclerViewTopPadding", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "updateSelectedItemCount", "updateNoNotes", "dismissHoverPopup", "onConfigurationChanged", "prepareOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onActionDoneOptionsItemSelected", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getChildFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "activityFinish", "registerImportListRequest", "unregisterImportListRequest", "isCancelDownloadingEnded", "()Z", "setCancelDownloadingEnded", "(Z)V", "isFragmentAdded", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter;", "spinnerListView", "Landroid/widget/ListView;", "getSpinnerListView", "()Landroid/widget/ListView;", "restoreDialog", "showCancelDownloadingDialog", "dismissCancelDownloadingDialog", "showProgressDialog", "dismissProgressDialog", "showNoteDataWarningDialog", "type", "size", "", "showErrorDialog", "isCancelDownloadingDialogAdded", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportDocumentView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportDocumentView.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
public final class ImportDocumentView extends ImportView implements ImportDocumentDialogContract.IView, ImportDocumentPresenterContract.IView, ImportDocumentPresenterContract.IListPopupWindow, ImportDocumentPresenterContract.IDialog {
    private static final int DELAY_TIME_DROP_DOWN_SHOW = 100;

    @NotNull
    private static final String TAG = "ST$ImportDocumentView";

    @Nullable
    private LinearLayout mCategorySpinnerLayout;

    @NotNull
    private final ImportDocumentDialog mDialog;

    @NotNull
    private final ImportDocumentViewContract mImport;

    @NotNull
    private final ImportDocumentPresenter mPresenter;

    @Nullable
    private ListPopupWindow mSpinnerPopupMenu;

    @Nullable
    private TextView mSpinnerText;
    private int selectedCategoryPosition;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.ImportDocumentView$initSpinnerLayout$7 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m13886d2 = {"com/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/view/ImportDocumentView$initSpinnerLayout$7", "Landroid/widget/AdapterView$OnItemClickListener;", "onItemClick", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C88077 implements AdapterView.OnItemClickListener {
        final /* synthetic */ Context $context;

        public C88077(Context context) {
            this.$context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onItemClick$lambda$0(ImportDocumentView importDocumentView) {
            ListPopupWindow listPopupWindow = importDocumentView.mSpinnerPopupMenu;
            if (listPopupWindow != null) {
                listPopupWindow.dismiss();
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int i;
            Resources resources;
            Resources resources2;
            Intrinsics.checkNotNullParameter(view, "view");
            view.postDelayed(new RunnableC8669a(ImportDocumentView.this, 12), 100L);
            String strValueOf = (String) ImportDocumentView.this.mPresenter.getCategorySpinnerItem(position);
            if (strValueOf == null) {
                return;
            }
            CharSequence text = null;
            if (position == 0) {
                Context context = this.$context;
                if (context != null && (resources2 = context.getResources()) != null) {
                    text = resources2.getText(ImportDocumentView.this.mPresenter.getDefaultCategoryText());
                }
                strValueOf = String.valueOf(text);
                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_SELECT_CATEGORY, "a");
                i = 11;
            } else if (position == ImportDocumentView.this.mPresenter.getCategorySpinnerCount() - 1) {
                Context context2 = this.$context;
                if (context2 != null && (resources = context2.getResources()) != null) {
                    text = resources.getText(C8003R.string.uncategorised);
                }
                strValueOf = String.valueOf(text);
                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_SELECT_CATEGORY, "c");
                i = 12;
            } else {
                CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_SELECT_CATEGORY, "b");
                i = 13;
            }
            if ((i == 13 || i != ImportDocumentView.this.mPresenter.getSelectedCategoryType()) && position != ImportDocumentView.this.getSelectedCategoryPosition()) {
                AbstractC8014b.m7201c(position, "mSpinnerPopupMenu onItemClick(). position : ", ImportDocumentView.TAG);
                ImportDocumentView.this.mPresenter.setSelectedCategory(strValueOf, i);
                ImportDocumentView.this.updateSelectedItemCount();
                ImportDocumentView.this.updateSpinnerTitle(position);
                ImportDocumentView.this.selectedCategoryPosition = position;
                ImportDocumentView.this.updateNoNotes();
                PenRecyclerView penRecyclerView = ((ImportView) ImportDocumentView.this).mRecyclerView;
                if (penRecyclerView != null) {
                    penRecyclerView.smoothScrollToPosition(0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportDocumentView(@Nullable DocTypeConstants docTypeConstants, @NotNull ImportViewContract contract, @NotNull ImportDocumentViewContract mImport) {
        super(contract);
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(mImport, "mImport");
        this.mImport = mImport;
        Intrinsics.checkNotNull(docTypeConstants);
        ImportDocumentPresenter importDocumentPresenter = new ImportDocumentPresenter(docTypeConstants, this, this, this, this);
        this.mPresenter = importDocumentPresenter;
        this.mDialog = new ImportDocumentDialog(docTypeConstants, importDocumentPresenter.getAppName(), this);
        importDocumentPresenter.initDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$0(View view, boolean z) {
        if (z && (view instanceof PenRecyclerView)) {
            ((PenRecyclerView) view).getChildAt(0).requestFocus();
        }
    }

    private final void initSpinnerLayout() {
        TextView textView;
        Resources resources;
        TextView textView2;
        if (this.mPresenter.hasSpinnerLayout()) {
            MainLogger.m7258i(TAG, "initSpinnerLayout()");
            Activity activity = getActivity();
            Context baseContext = activity != null ? activity.getBaseContext() : null;
            Activity activity2 = getActivity();
            View viewFindViewById = activity2 != null ? activity2.findViewById(C8003R.id.multi_floating_bar_item_container) : null;
            if (viewFindViewById != null) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.width = -2;
                viewFindViewById.setLayoutParams(layoutParams);
            }
            Activity activity3 = getActivity();
            LinearLayout linearLayout = activity3 != null ? (LinearLayout) activity3.findViewById(C8003R.id.category_spinner_layout) : null;
            this.mCategorySpinnerLayout = linearLayout;
            TextView textView3 = linearLayout != null ? (TextView) linearLayout.findViewById(C8003R.id.category_spinner_name) : null;
            this.mSpinnerText = textView3;
            CharUtils.applyTextSizeUntilLargeSize(baseContext, textView3, 18.0f);
            LinearLayout linearLayout2 = this.mCategorySpinnerLayout;
            ImageView imageView = linearLayout2 != null ? (ImageView) linearLayout2.findViewById(C8003R.id.image) : null;
            Drawable drawable = Spr.getDrawable(baseContext != null ? baseContext.getResources() : null, C8003R.drawable.tw_spinner_mtrl_am_alpha, null);
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.samsung.android.spr.drawable.SprDrawable");
            SprDrawable sprDrawable = (SprDrawable) drawable;
            if (baseContext != null) {
                sprDrawable.setTintList(ColorStateList.valueOf(ContextCompat.getColor(baseContext, C8003R.color.notes_spinner_triangle_color)));
            }
            if (imageView != null) {
                imageView.setImageDrawable(sprDrawable);
            }
            LinearLayout linearLayout3 = this.mCategorySpinnerLayout;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(new ViewOnClickListenerC8556a(this, 6));
            }
            if (ButtonBackgroundUtils.isShowButtonShapeEnabled(baseContext)) {
                TextView textView4 = this.mSpinnerText;
                if (textView4 != null) {
                    textView4.setBackgroundResource(C8003R.drawable.accessibility_show_button_spinner);
                }
                if (baseContext != null && (textView2 = this.mSpinnerText) != null) {
                    textView2.setTextColor(baseContext.getResources().getColor(C8003R.color.window_background_color, null));
                }
            } else {
                TextView textView5 = this.mSpinnerText;
                if (textView5 != null) {
                    textView5.setBackgroundResource(0);
                }
                if (baseContext != null && (textView = this.mSpinnerText) != null) {
                    textView.setTextColor(baseContext.getResources().getColor(C8003R.color.notes_title_color, null));
                }
            }
            LinearLayout linearLayout4 = this.mCategorySpinnerLayout;
            if (linearLayout4 != null) {
                linearLayout4.setBackgroundResource(C8003R.drawable.text_only_flat_button_ripple_background);
            }
            this.mSpinnerPopupMenu = baseContext != null ? new ListPopupWindow(baseContext) : null;
            this.mPresenter.initializeSpinnerAdapter();
            ListPopupWindow listPopupWindow = this.mSpinnerPopupMenu;
            if (listPopupWindow != null) {
                listPopupWindow.setAnchorView(this.mCategorySpinnerLayout);
            }
            ListPopupWindow listPopupWindow2 = this.mSpinnerPopupMenu;
            if (listPopupWindow2 != null) {
                listPopupWindow2.setModal(true);
            }
            ListPopupWindow listPopupWindow3 = this.mSpinnerPopupMenu;
            if (listPopupWindow3 != null) {
                listPopupWindow3.setDropDownGravity(8388611);
            }
            ListPopupWindow listPopupWindow4 = this.mSpinnerPopupMenu;
            if (listPopupWindow4 != null) {
                listPopupWindow4.setVerticalOffset((baseContext == null || (resources = baseContext.getResources()) == null) ? 0 : (int) resources.getDimension(C8003R.dimen.note_picker_spinner_vertical_offset));
            }
            ListPopupWindow listPopupWindow5 = this.mSpinnerPopupMenu;
            if (listPopupWindow5 != null) {
                listPopupWindow5.setOnItemClickListener(new C88077(baseContext));
            }
            updateSpinnerTitle(0);
            if (this.mPresenter.getSelectedCategory() == null) {
                ImportDocumentPresenter importDocumentPresenter = this.mPresenter;
                importDocumentPresenter.setSelectedCategory(importDocumentPresenter.getCategorySpinnerTitle(0), 11);
                return;
            }
            if (this.mPresenter.getSelectedCategoryType() == 11) {
                TextView textView6 = this.mSpinnerText;
                if (textView6 != null) {
                    textView6.setText(this.mPresenter.getDefaultCategoryText());
                    return;
                }
                return;
            }
            if (this.mPresenter.getSelectedCategoryType() == 12) {
                TextView textView7 = this.mSpinnerText;
                if (textView7 != null) {
                    textView7.setText(C8003R.string.uncategorised);
                    return;
                }
                return;
            }
            TextView textView8 = this.mSpinnerText;
            if (textView8 != null) {
                textView8.setText(this.mPresenter.getSelectedCategory());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSpinnerLayout$lambda$6(ImportDocumentView importDocumentView, View view) {
        ListPopupWindow listPopupWindow = importDocumentView.mSpinnerPopupMenu;
        if (listPopupWindow != null) {
            ListView listView = listPopupWindow.getListView();
            if (listView != null) {
                listView.setDividerHeight(0);
            }
            listPopupWindow.setSelection(0);
            listPopupWindow.setWidth(importDocumentView.mPresenter.measureCategorySpinnerContentWidth());
            listPopupWindow.show();
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_SPINNER);
    }

    private final void restoreDialog() {
        this.mDialog.restoreDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSpinnerTitle(int position) {
        Context context;
        Context context2;
        TextView textView = this.mSpinnerText;
        if (textView != null) {
            textView.setText(this.mPresenter.getCategorySpinnerTitle(position));
        }
        TextView textView2 = this.mSpinnerText;
        if (textView2 != null) {
            textView2.requestLayout();
        }
        LinearLayout linearLayout = this.mCategorySpinnerLayout;
        if (linearLayout != null) {
            TextView textView3 = this.mSpinnerText;
            String string = (textView3 == null || (context2 = textView3.getContext()) == null) ? null : context2.getString(C8003R.string.import_voice_ass_dropdown_list);
            TextView textView4 = this.mSpinnerText;
            String string2 = (textView4 == null || (context = textView4.getContext()) == null) ? null : context.getString(C8003R.string.import_voice_ass_categories);
            TextView textView5 = this.mSpinnerText;
            linearLayout.setContentDescription(string + SQLKeyword.COMMA + string2 + SQLKeyword.COMMA + ((Object) (textView5 != null ? textView5.getText() : null)));
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public void activityFinish() {
        this.mImport.activityFinish();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void dismissCancelDownloadingDialog() {
        this.mDialog.dismissCancelDownloadingDialog();
    }

    public final void dismissHoverPopup() {
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        if (penRecyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = penRecyclerView != null ? penRecyclerView.getLayoutManager() : null;
        Integer numValueOf = layoutManager != null ? Integer.valueOf(layoutManager.getChildCount()) : null;
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        for (int i = 0; i < iIntValue; i++) {
            View childAt = layoutManager.getChildAt(i);
            if (childAt != null) {
                PenRecyclerView penRecyclerView2 = this.mRecyclerView;
                ImportDocumentRecyclerViewHolder importDocumentRecyclerViewHolder = (ImportDocumentRecyclerViewHolder) (penRecyclerView2 != null ? penRecyclerView2.findContainingViewHolder(childAt) : null);
                if (importDocumentRecyclerViewHolder != null) {
                    importDocumentRecyclerViewHolder.dismissHoverPopup();
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void dismissProgressDialog() {
        this.mDialog.dismissProgressDialog();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    @Nullable
    public FragmentManager getChildFragmentManager() {
        if (this.mImport.isFragmentAdded()) {
            return this.mImport.getChildFragmentManager();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IView
    @Nullable
    public Context getContext() {
        return this.mImport.getContext();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public int getRecyclerViewTopPadding() {
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        return activity.getResources().getDimensionPixelSize(C8003R.dimen.import_document_spinner_layout_height_for_padding);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IListPopupWindow
    public int getSelectedCategoryPosition() {
        return this.selectedCategoryPosition;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IListPopupWindow
    @Nullable
    public ListView getSpinnerListView() {
        ListPopupWindow listPopupWindow = this.mSpinnerPopupMenu;
        if (listPopupWindow != null) {
            return listPopupWindow.getListView();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void initLayout() {
        PenRecyclerView penRecyclerView;
        super.initLayout();
        TextView textView = this.mNoNote;
        if (textView != null) {
            textView.setText(this.mPresenter.getNoNoteBodyText());
        }
        this.mPresenter.initRecyclerView();
        PenRecyclerView penRecyclerView2 = this.mRecyclerView;
        if (penRecyclerView2 != null) {
            penRecyclerView2.setOnPenMultiSelectionListener(new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.ImportDocumentView.initLayout.1
                @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
                public void onSelectedItemPosition(ArrayList<Integer> selectedItemPosition, int recyclerViewWidth, int penDragLeft, int penDragRight) {
                    Intrinsics.checkNotNullParameter(selectedItemPosition, "selectedItemPosition");
                    if (ImportDocumentView.this.mPresenter.toggleRecyclerViewSelectState(selectedItemPosition)) {
                        ImportDocumentView.this.updateSelectedItemCount();
                    }
                }
            });
        }
        PenRecyclerView penRecyclerView3 = this.mRecyclerView;
        if (penRecyclerView3 != null) {
            penRecyclerView3.seslSetLongPressMultiSelectionListener(new RecyclerView.SeslLongPressMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.ImportDocumentView.initLayout.2
                private final ArrayList<Integer> selectedItemPositions = new ArrayList<>();

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onItemSelected(RecyclerView recyclerView, View view, int position, long l) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    Intrinsics.checkNotNullParameter(view, "view");
                    PenRecyclerView penRecyclerView4 = ((ImportView) ImportDocumentView.this).mRecyclerView;
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = penRecyclerView4 != null ? penRecyclerView4.findViewHolderForAdapterPosition(position) : null;
                    if (viewHolderFindViewHolderForAdapterPosition == null) {
                        MainLogger.m7258i(ImportDocumentView.TAG, "holder is null!!");
                        return;
                    }
                    if (this.selectedItemPositions.contains(Integer.valueOf(position))) {
                        this.selectedItemPositions.remove(Integer.valueOf(position));
                        z = false;
                    } else {
                        this.selectedItemPositions.add(Integer.valueOf(position));
                        z = true;
                    }
                    ImportDocumentView.this.mPresenter.setCheckItem((ImportDocumentRecyclerViewHolder) viewHolderFindViewHolderForAdapterPosition, z);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionEnded(int i, int i12) {
                    this.selectedItemPositions.clear();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
                public void onLongPressMultiSelectionStarted(int i, int i12) {
                    this.selectedItemPositions.clear();
                }
            });
        }
        PenRecyclerView penRecyclerView4 = this.mRecyclerView;
        if (penRecyclerView4 != null) {
            penRecyclerView4.setOnFocusChangeListener(new ViewOnFocusChangeListenerC8808a());
        }
        PenRecyclerView penRecyclerView5 = this.mRecyclerView;
        if (penRecyclerView5 != null) {
            penRecyclerView5.setItemAnimator(null);
        }
        PenRecyclerView penRecyclerView6 = this.mRecyclerView;
        if (penRecyclerView6 != null) {
            penRecyclerView6.setHasFixedSize(true);
        }
        PenRecyclerView penRecyclerView7 = this.mRecyclerView;
        if (penRecyclerView7 != null) {
            penRecyclerView7.seslSetGoToTopEnabled(true);
        }
        InputMethodCompat companion = InputMethodCompat.INSTANCE.getInstance();
        PenRecyclerView penRecyclerView8 = this.mRecyclerView;
        if (!companion.isKeyboardConnected(penRecyclerView8 != null ? penRecyclerView8.getContext() : null) || (penRecyclerView = this.mRecyclerView) == null) {
            return;
        }
        penRecyclerView.requestFocus();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public boolean isCancelDownloadingDialogAdded() {
        return this.mDialog.isCancelDownloadingDialogAdded();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public boolean isCancelDownloadingEnded() {
        return this.mPresenter.getIsCancelDownloadingEnded();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public boolean isFragmentAdded() {
        return this.mImport.isFragmentAdded();
    }

    public final void onActionDoneOptionsItemSelected() {
        this.mPresenter.startImport();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void onConfigurationChanged() {
        Context context;
        Resources resources;
        super.onConfigurationChanged();
        ListPopupWindow listPopupWindow = this.mSpinnerPopupMenu;
        if (listPopupWindow != null) {
            ListView listView = listPopupWindow.getListView();
            listPopupWindow.setVerticalOffset((listView == null || (context = listView.getContext()) == null || (resources = context.getResources()) == null) ? 0 : (int) resources.getDimension(C8003R.dimen.note_picker_spinner_vertical_offset));
            if (listPopupWindow.isShowing()) {
                listPopupWindow.dismiss();
                listPopupWindow.setWidth(this.mPresenter.measureCategorySpinnerContentWidth());
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC8669a(listPopupWindow, 11), 100L);
            }
        }
    }

    public final void onCreate() {
        this.mPresenter.onCreate();
    }

    public final void onDestroy() {
        this.mPresenter.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void onViewCreated() {
        initLayout();
        initSpinnerLayout();
        initializeToolbar(this.mPresenter.getDefaultActionBarTitle());
        updateNoNotes();
        updateSelectedItemCount();
        restoreDialog();
        super.onViewCreated();
    }

    public final boolean prepareOptionsMenu(@Nullable Menu menu) {
        prepareOptionsMenu(menu, this.mPresenter.getCheckedItemCount(), this.mPresenter.getItemCount() != 0);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public void registerImportListRequest() {
        this.mPresenter.registerImportListRequest();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView, com.samsung.android.support.senl.nt.app.settings.importnotes.common.ImportPresenterContract.IRecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        if (penRecyclerView != null) {
            penRecyclerView.setAdapter(adapter);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView
    public void setAllItemChecked(boolean checked) {
        super.setAllItemChecked(checked);
        this.mPresenter.setAllItemChecked(checked);
        updateSelectedItemCount();
        CommonSamsungAnalytics.INSTANCE.insertLog(SettingsSAConstants.SCREEN_IMPORT_MEMO_PICKER, SettingsSAConstants.EVENT_IMPORT_MEMO_PICKER_SELECT_ALL, checked ? "1" : "0");
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public void setCancelDownloadingEnded(boolean z) {
        this.mPresenter.setCancelDownloadingEnded(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void showCancelDownloadingDialog() {
        this.mDialog.showCancelDownloadingDialog();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void showErrorDialog() {
        ImportDocumentDialog importDocumentDialog = this.mDialog;
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        importDocumentDialog.showErrorDialog(penRecyclerView != null ? penRecyclerView.getContext() : null);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void showNoteDataWarningDialog(int type, double size) {
        this.mDialog.showNoteDataWarningDialog(type, size);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IDialog
    public void showProgressDialog() {
        this.mDialog.showProgressDialog();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.view.dialog.ImportDocumentDialogContract.IView
    public void unregisterImportListRequest() {
        this.mPresenter.unregisterImportListRequest();
        updateNoNotes();
        updateSelectedItemCount();
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IView
    public void updateNoNotes() {
        ActionBar supportActionBar;
        if (getActivity() == null) {
            MainLogger.m7258i(TAG, "updateNoNotes(). activity is null");
            return;
        }
        invalidateOptionsMenu();
        if (this.mPresenter.getItemCount() == 0) {
            MainLogger.m7258i(TAG, "updateNoNotes(). No Items");
            TextView textView = this.mNoNote;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.mNoNote;
            if (textView2 != null) {
                textView2.announceForAccessibility(textView2 != null ? textView2.getText() : null);
            }
            finishActionMode();
            return;
        }
        setFastScrollerEnabled(this.mPresenter.getItemCount());
        startActionMode();
        LinearLayout linearLayout = this.mCategorySpinnerLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.setTitle((CharSequence) null);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        TextView textView3 = this.mNoNote;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IView
    public void updateSelectedItemCount() {
        updateSelectedItemCount(this.mPresenter.getItemCount(), this.mPresenter.getCheckedItemCount());
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract.IListPopupWindow
    public void setAdapter(@Nullable ImportCategorySpinnerAdapter adapter) {
        ListPopupWindow listPopupWindow = this.mSpinnerPopupMenu;
        if (listPopupWindow != null) {
            listPopupWindow.setAdapter(adapter);
        }
    }
}
