package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.ImportPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0004J\b\u0010!\u001a\u00020\u0017H\u0004J\b\u0010\"\u001a\u00020\u0017H\u0004J\b\u0010#\u001a\u00020\u0017H\u0016J\u0006\u0010$\u001a\u00020\u0017J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J \u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020'J\b\u0010.\u001a\u00020\u0017H\u0004J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u001dH\u0004J\u0016\u00101\u001a\u00020\u00172\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103H\u0016J\u0016\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001dJ\u0016\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0013\u0010;\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportView;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/ImportPresenterContract$IRecyclerView;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/view/ImportViewContract;)V", "mActionMenuController", "Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController;", "getMActionMenuController", "()Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController;", "setMActionMenuController", "(Lcom/samsung/android/support/senl/nt/app/main/common/view/ActionMenuController;)V", "mNoNote", "Landroid/widget/TextView;", "mRecyclerView", "Lcom/samsung/android/support/senl/nt/app/common/penrecyclerview/PenRecyclerView;", "mMultiFloatingView", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;", "getMMultiFloatingView", "()Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;", "setMMultiFloatingView", "(Lcom/google/android/material/oneui/floatingactioncontainer/FloatingTopLayout;)V", "onViewCreated", "", "initLayout", "addPaddingNoTextView", "floatingToolbarLayout", "Lcom/google/android/material/oneui/floatingactioncontainer/FloatingToolbarLayout;", "getRecyclerViewTopPadding", "", "initializeToolbar", "defaultTitle", "", "startActionMode", "finishActionMode", "onDestroyView", "onItemLongPressed", "setAllItemChecked", "checked", "", "onConfigurationChanged", "prepareOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "checkedItemCount", "isMenuVisible", "invalidateOptionsMenu", "setFastScrollerEnabled", "listItemCount", "setAdapter", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "updateSelectedItemCount", TextConst.KEY_PARAM_NUMBER, "numberOfChecked", "onCustomKeyEvent", "keyCode", "event", "Landroid/view/KeyEvent;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class ImportView implements ImportPresenterContract.IRecyclerView {

    @NotNull
    private static final String TAG = "ImportView";

    @NotNull
    private final ImportViewContract contract;

    @Nullable
    private ActionMenuController mActionMenuController;

    @Nullable
    private FloatingTopLayout mMultiFloatingView;

    @JvmField
    @Nullable
    protected TextView mNoNote;

    @JvmField
    @Nullable
    protected PenRecyclerView mRecyclerView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.settings.importnotes.common.view.ImportView$updateSelectedItemCount$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.settings.importnotes.common.view.ImportView$updateSelectedItemCount$1", m14021f = "ImportView.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C88001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ int $number;
        final /* synthetic */ int $numberOfChecked;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88001(int i, int i2, Activity activity, Continuation<? super C88001> continuation) {
            super(2, continuation);
            this.$numberOfChecked = i;
            this.$number = i2;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ImportView.this.new C88001(this.$numberOfChecked, this.$number, this.$activity, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ActionMenuController mActionMenuController = ImportView.this.getMActionMenuController();
            if (mActionMenuController != null) {
                int i = this.$numberOfChecked;
                mActionMenuController.updateSelectedNoteCount(i == this.$number, i);
            }
            Activity activity = this.$activity;
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C88001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ImportView(@NotNull ImportViewContract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int initLayout$lambda$2() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startActionMode$lambda$5(ImportView importView, boolean z) {
        MainLogger.m7258i(TAG, "selectAll, onClick, " + z);
        importView.setAllItemChecked(z);
    }

    public void addPaddingNoTextView(@Nullable FloatingToolbarLayout floatingToolbarLayout) {
        int height = floatingToolbarLayout != null ? floatingToolbarLayout.getHeight() : 0;
        TextView textView = this.mNoNote;
        if (textView != null) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop() - height, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public final void finishActionMode() {
        ActionMenuController actionMenuController = this.mActionMenuController;
        if (actionMenuController != null) {
            actionMenuController.finishActionMode();
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.contract.getActivity();
    }

    @Nullable
    public final ActionMenuController getMActionMenuController() {
        return this.mActionMenuController;
    }

    @Nullable
    public final FloatingTopLayout getMMultiFloatingView() {
        return this.mMultiFloatingView;
    }

    public int getRecyclerViewTopPadding() {
        return 0;
    }

    public void initLayout() {
        FloatingBottomLayout floatingBottomLayout;
        Activity activity = getActivity();
        FloatingToolbarLayout floatingToolbarLayout = activity != null ? (FloatingToolbarLayout) activity.findViewById(C8003R.id.sesl_floating_toolbar_layout) : null;
        Activity activity2 = getActivity();
        this.mNoNote = activity2 != null ? (TextView) activity2.findViewById(C8003R.id.nonote) : null;
        Activity activity3 = getActivity();
        this.mRecyclerView = activity3 != null ? (PenRecyclerView) activity3.findViewById(C8003R.id.recyclerview) : null;
        Activity activity4 = getActivity();
        this.mMultiFloatingView = activity4 != null ? (FloatingTopLayout) activity4.findViewById(C8003R.id.multi_floating_bar) : null;
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        if (penRecyclerView != null) {
            penRecyclerView.setLayoutManager(new LinearLayoutManager(penRecyclerView.getContext()), 1);
            if (floatingToolbarLayout != null) {
                floatingToolbarLayout.setRecyclerView(penRecyclerView);
            }
            Activity activity5 = getActivity();
            if (activity5 != null && (floatingBottomLayout = (FloatingBottomLayout) activity5.findViewById(C8003R.id.floating_bottom_layout)) != null) {
                floatingBottomLayout.setRecyclerView(penRecyclerView);
            }
            FloatingTopLayout floatingTopLayout = this.mMultiFloatingView;
            if (floatingTopLayout != null) {
                floatingTopLayout.setRecyclerView(penRecyclerView);
            }
            penRecyclerView.seslSetFadingEdgeEnabled(true);
        }
        PenRecyclerView penRecyclerView2 = this.mRecyclerView;
        if (penRecyclerView2 != null) {
            penRecyclerView2.setPaddingRelative(penRecyclerView2.getPaddingStart(), getRecyclerViewTopPadding(), penRecyclerView2.getPaddingEnd(), penRecyclerView2.getPaddingBottom());
        }
        this.mActionMenuController = new ActionMenuController(this.contract.getFragment(), this.mRecyclerView, null, new C8416h(3));
        TextView textView = this.mNoNote;
        if (textView != null) {
            textView.post(new RunnableC8515c(this, floatingToolbarLayout, 11));
        }
    }

    public final void initializeToolbar(@Nullable String defaultTitle) {
        ActionMenuController actionMenuController;
        if (CommonUtil.isNotAvailableActivity(this.contract.getActivity()) || (actionMenuController = this.mActionMenuController) == null) {
            return;
        }
        actionMenuController.setToolbarTitle(defaultTitle);
    }

    public final void invalidateOptionsMenu() {
        Activity activity = this.contract.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || activity == null) {
            return;
        }
        activity.invalidateOptionsMenu();
    }

    public void onConfigurationChanged() {
    }

    public final boolean onCustomKeyEvent(int keyCode, @NotNull KeyEvent event) {
        PenRecyclerView penRecyclerView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 29) {
            if (event.getAction() != 0 || (event.getMetaState() & 4096) != 4096) {
                return false;
            }
            setAllItemChecked(true);
            return true;
        }
        if (keyCode != 113 && keyCode != 114) {
            MainLogger.m7255e(TAG, "unexpected keycode: " + keyCode);
        } else if (event.getAction() == 0 && event.getRepeatCount() == 0) {
            PenRecyclerView penRecyclerView2 = this.mRecyclerView;
            if (penRecyclerView2 != null) {
                Intrinsics.checkNotNull(penRecyclerView2);
                penRecyclerView2.startDragMouseMultiSelection();
                return true;
            }
        } else if (event.getAction() == 1 && (penRecyclerView = this.mRecyclerView) != null) {
            Intrinsics.checkNotNull(penRecyclerView);
            penRecyclerView.cancelDragMouseMultiSelection();
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        AbstractC8014b.m7201c(hashCode(), "onDestroyView, ", TAG);
    }

    public final void onItemLongPressed() {
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        if (penRecyclerView != null) {
            penRecyclerView.seslStartLongPressMultiSelection();
        }
    }

    public void onViewCreated() {
    }

    public final void prepareOptionsMenu(@Nullable Menu menu, int checkedItemCount, boolean isMenuVisible) {
        if (CommonUtil.isNotAvailableActivity(this.contract.getActivity())) {
            return;
        }
        boolean z = checkedItemCount != 0;
        MenuItem menuItemFindItem = menu != null ? menu.findItem(C8003R.id.action_import) : null;
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(z);
        }
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(isMenuVisible);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.importnotes.common.ImportPresenterContract.IRecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        Intrinsics.checkNotNull(penRecyclerView);
        penRecyclerView.setAdapter(adapter);
    }

    public void setAllItemChecked(boolean checked) {
        PenRecyclerView penRecyclerView = this.mRecyclerView;
        if (penRecyclerView != null) {
            int childCount = penRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                PenRecyclerView penRecyclerView2 = this.mRecyclerView;
                Intrinsics.checkNotNull(penRecyclerView2);
                CheckBox checkBox = (CheckBox) penRecyclerView2.getChildAt(i).findViewById(C8003R.id.checkbox);
                if (checkBox != null) {
                    checkBox.setChecked(checked);
                }
            }
        }
    }

    public final void setFastScrollerEnabled(int listItemCount) {
        if (listItemCount >= 70) {
            PenRecyclerView penRecyclerView = this.mRecyclerView;
            if (penRecyclerView != null) {
                penRecyclerView.seslSetFastScrollerEnabled(true);
                return;
            }
            return;
        }
        PenRecyclerView penRecyclerView2 = this.mRecyclerView;
        if (penRecyclerView2 != null) {
            penRecyclerView2.seslSetFastScrollerEnabled(false);
        }
    }

    public final void setMActionMenuController(@Nullable ActionMenuController actionMenuController) {
        this.mActionMenuController = actionMenuController;
    }

    public final void setMMultiFloatingView(@Nullable FloatingTopLayout floatingTopLayout) {
        this.mMultiFloatingView = floatingTopLayout;
    }

    public final void startActionMode() {
        ActionMenuController actionMenuController = this.mActionMenuController;
        if (actionMenuController != null) {
            actionMenuController.startActionMode(new C7737b(this, 24));
        }
    }

    public final void updateSelectedItemCount(int number, int numberOfChecked) {
        Activity activity = this.contract.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity) || number <= 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C88001(numberOfChecked, number, activity, null), 3, null);
    }
}
