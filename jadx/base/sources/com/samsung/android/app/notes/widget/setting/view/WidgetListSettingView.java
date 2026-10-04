package com.samsung.android.app.notes.widget.setting.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.setting.model.WidgetListSettingModel;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetListSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter;
import com.samsung.android.app.notes.widget.setting.view.adapter.PreviewListAdapter;
import com.samsung.android.app.notes.widget.setting.view.preview.IWidgetPreviewLayoutManager;
import com.samsung.android.app.notes.widget.setting.view.preview.TopWidgetListPreviewManager;
import com.samsung.android.app.notes.widget.setting.view.preview.WidgetListPreviewManager;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J(\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0002J\u0018\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002J\b\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020-H\u0016J\b\u0010:\u001a\u00020 H\u0016J\b\u0010;\u001a\u00020 H\u0016J\b\u0010<\u001a\u00020 H\u0016J\b\u0010=\u001a\u00020 H\u0016J\u0010\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020+H\u0014J\u0012\u0010@\u001a\u00020 2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/WidgetListSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/app/notes/widget/setting/view/WidgetListSettingContract;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPresenter", "Lcom/samsung/android/app/notes/widget/setting/presenter/WidgetListSettingPresenter;", "mPreviewManager", "Lcom/samsung/android/app/notes/widget/setting/view/preview/IWidgetPreviewLayoutManager;", "mPreview", "mPreviewBackground", "Landroid/widget/ImageView;", "mPreviewListView", "Landroidx/recyclerview/widget/RecyclerView;", "mPreviewListBackground", "mPreviewTitleView", "Landroid/widget/TextView;", "mPreviewAdapter", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/PreviewListAdapter;", "mPreviewEmptyView", "mPreviewSettingView", "mPreviewSettingAddButton", "mNoteListView", "mAdapter", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter;", "mTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mAddButton", "Landroid/widget/ImageButton;", "init", "", "initPreview", "initWidgetPreview", "initPreviewSetting", "setListWidgetTitleStyle", "updateEmptyAndListVisibility", "initSettingList", "initItemMoveHelper", "updateViewItem", "view", "isViewCleared", "", "position", "", "itemCount", "updateViewDriver", "fromPosition", "toPosition", "updateNoteListHeight", "updateNoteListOverlay", "initBackgroundColor", "updateWidgetPreview", "updateAddButtonState", "updateNoteListLayout", "updateWidgetPreviewAlpha", "alpha", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "updateNoteListPreview", "setEnableBackgroundColorView", "enable", "setPresenter", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "isOneItemList", "()Lkotlin/Unit;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListSettingView.kt\ncom/samsung/android/app/notes/widget/setting/view/WidgetListSettingView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
public final class WidgetListSettingView extends BaseWidgetSettingView implements WidgetListSettingContract {

    @NotNull
    private static final String TAG = "WidgetListSettingView";
    private static final int WIDGET_LIST_VISIBLE_COUNT = 3;

    @Nullable
    private NoteListAdapter mAdapter;

    @Nullable
    private ImageButton mAddButton;

    @Nullable
    private RecyclerView mNoteListView;

    @Nullable
    private WidgetListSettingPresenter mPresenter;

    @Nullable
    private View mPreview;

    @Nullable
    private PreviewListAdapter mPreviewAdapter;

    @Nullable
    private ImageView mPreviewBackground;

    @Nullable
    private TextView mPreviewEmptyView;

    @Nullable
    private ImageView mPreviewListBackground;

    @Nullable
    private RecyclerView mPreviewListView;

    @Nullable
    private IWidgetPreviewLayoutManager mPreviewManager;

    @Nullable
    private ImageView mPreviewSettingAddButton;

    @Nullable
    private ImageView mPreviewSettingView;

    @Nullable
    private TextView mPreviewTitleView;

    @Nullable
    private ItemTouchHelper mTouchHelper;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView$initItemMoveHelper$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"com/samsung/android/app/notes/widget/setting/view/WidgetListSettingView$initItemMoveHelper$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "fromPosition", "", "toPosition", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", "srcViewHolder", "dstViewHolder", "onSelectedChanged", "", "actionState", "clearView", "onSwiped", "i", "isLongPressDragEnabled", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetListSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListSettingView.kt\ncom/samsung/android/app/notes/widget/setting/view/WidgetListSettingView$initItemMoveHelper$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
    public static final class C70071 extends ItemTouchHelper.Callback {
        private int fromPosition = -1;
        private int toPosition = -1;

        public C70071() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void clearView$lambda$1(WidgetListSettingView widgetListSettingView, C70071 c70071) {
            widgetListSettingView.updateViewDriver(c70071.fromPosition, c70071.toPosition);
            c70071.fromPosition = -1;
            c70071.toPosition = -1;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            WidgetListSettingModel mModel;
            List<String> noteList;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            WidgetListSettingPresenter widgetListSettingPresenter = WidgetListSettingView.this.mPresenter;
            Integer numValueOf = (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            WidgetListSettingView widgetListSettingView = WidgetListSettingView.this;
            View itemView = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            widgetListSettingView.updateViewItem(itemView, true, viewHolder.getPosition(), iIntValue);
            Logger.m8697d(WidgetListSettingView.TAG, "clearView ");
            if (this.fromPosition == -1 || this.toPosition == -1) {
                return;
            }
            recyclerView.post(new RunnableC4199v(WidgetListSettingView.this, this, 7));
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder srcViewHolder, RecyclerView.ViewHolder dstViewHolder) {
            WidgetListSettingModel mModel;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(srcViewHolder, "srcViewHolder");
            Intrinsics.checkNotNullParameter(dstViewHolder, "dstViewHolder");
            int bindingAdapterPosition = srcViewHolder.getBindingAdapterPosition();
            int bindingAdapterPosition2 = dstViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || bindingAdapterPosition2 == -1) {
                return false;
            }
            this.toPosition = bindingAdapterPosition2;
            WidgetListSettingPresenter widgetListSettingPresenter = WidgetListSettingView.this.mPresenter;
            if (widgetListSettingPresenter != null && (mModel = widgetListSettingPresenter.getMModel()) != null) {
                mModel.swapItem(bindingAdapterPosition, bindingAdapterPosition2);
            }
            NoteListAdapter noteListAdapter = WidgetListSettingView.this.mAdapter;
            if (noteListAdapter != null) {
                noteListAdapter.notifyItemMoved(bindingAdapterPosition, bindingAdapterPosition2);
            }
            PreviewListAdapter previewListAdapter = WidgetListSettingView.this.mPreviewAdapter;
            if (previewListAdapter != null) {
                previewListAdapter.notifyItemMoved(bindingAdapterPosition, bindingAdapterPosition2);
            }
            RecyclerView recyclerView2 = WidgetListSettingView.this.mPreviewListView;
            if (recyclerView2 == null) {
                return true;
            }
            recyclerView2.scrollToPosition(bindingAdapterPosition2);
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            WidgetListSettingModel mModel;
            List<String> noteList;
            super.onSelectedChanged(viewHolder, actionState);
            WidgetListSettingPresenter widgetListSettingPresenter = WidgetListSettingView.this.mPresenter;
            Integer numValueOf = (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            if (actionState == 2) {
                this.fromPosition = viewHolder != null ? viewHolder.getBindingAdapterPosition() : -1;
            }
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                WidgetListSettingView.this.updateViewItem(view, false, viewHolder.getPosition(), iIntValue);
            }
            AbstractC4539a.m3203m(actionState, "onSelectedChanged ", WidgetListSettingView.TAG);
            Logger.m8697d(WidgetListSettingView.TAG, "oldpos: " + (viewHolder != null ? Integer.valueOf(viewHolder.getOldPosition()) : null) + ", pos: " + (viewHolder != null ? Integer.valueOf(viewHolder.getPosition()) : null));
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetListSettingView(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
    }

    private final void initBackgroundColor() {
        getMParent().findViewById(C11391R.id.widget_setting_background_color_container).setVisibility(0);
        int dimensionPixelSize = getMParent().getResources().getDimensionPixelSize(C11391R.dimen.widget_setting_bg_color_overlay);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_background_color_round_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        updateRoundCornerViewHeight(viewFindViewById, dimensionPixelSize);
    }

    private final void initItemMoveHelper() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new C70071());
        this.mTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.mNoteListView);
    }

    private final void initPreview() {
        IWidgetPreviewLayoutManager widgetListPreviewManager;
        if (BaseWidgetUtils.INSTANCE.isFoldSettingLayout()) {
            Resources resources = getMParent().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            widgetListPreviewManager = new TopWidgetListPreviewManager(resources);
        } else {
            Resources resources2 = getMParent().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            widgetListPreviewManager = new WidgetListPreviewManager(resources2);
        }
        this.mPreviewManager = widgetListPreviewManager;
        View mParent = getMParent();
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        this.mPreview = widgetListPreviewManager.initPreview(mParent, widgetListSettingPresenter != null ? widgetListSettingPresenter.getOneUiWidgetSource() : null);
        initWidgetPreview();
    }

    private final void initPreviewSetting() {
        ImageView imageView = this.mPreviewSettingView;
        if (imageView != null) {
            imageView.setImageResource(C11391R.drawable.widget_ic_setting);
        }
        if (WidgetUtils.INSTANCE.isSupportSettingByQuickOption()) {
            ImageView imageView2 = this.mPreviewSettingView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView3 = this.mPreviewSettingView;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
    }

    private final void initSettingList() {
        WidgetListSettingModel mModel;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        List<String> noteList = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_setting_control_list, (ViewGroup) null);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(C11391R.id.widget_note_list_add);
        this.mAddButton = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new ViewOnClickListenerC0157a(this, 10));
        }
        this.mNoteListView = (RecyclerView) viewInflate.findViewById(C11391R.id.widget_setting_note_list);
        View view = this.mPreview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view != null ? view.getContext() : null);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mNoteListView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        initItemMoveHelper();
        isOneItemList();
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        if (widgetListSettingPresenter != null && (mModel = widgetListSettingPresenter.getMModel()) != null) {
            noteList = mModel.getNoteList();
        }
        NoteListAdapter noteListAdapter = new NoteListAdapter(TypeIntrinsics.asMutableList(noteList), new NoteListAdapter.OnStartDragListener() { // from class: com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView.initSettingList.2
            @Override // com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.OnStartDragListener
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
                ItemTouchHelper itemTouchHelper;
                if (WidgetListSettingView.this.mTouchHelper == null || viewHolder == null || (itemTouchHelper = WidgetListSettingView.this.mTouchHelper) == null) {
                    return;
                }
                itemTouchHelper.startDrag(viewHolder);
            }
        }, new NoteListAdapter.ItemLayoutHeightListener() { // from class: com.samsung.android.app.notes.widget.setting.view.WidgetListSettingView.initSettingList.3
            @Override // com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.ItemLayoutHeightListener
            public void onItemRemoved(int position) {
                WidgetListSettingModel mModel2;
                WidgetListSettingView.this.updateNoteListLayout();
                WidgetListSettingView.this.isOneItemList();
                NoteListAdapter noteListAdapter2 = WidgetListSettingView.this.mAdapter;
                if (noteListAdapter2 != null) {
                    noteListAdapter2.notifyDataSetChanged();
                }
                WidgetListSettingPresenter widgetListSettingPresenter2 = WidgetListSettingView.this.mPresenter;
                if (widgetListSettingPresenter2 != null && (mModel2 = widgetListSettingPresenter2.getMModel()) != null) {
                    mModel2.removeDisplayList(position);
                }
                PreviewListAdapter previewListAdapter = WidgetListSettingView.this.mPreviewAdapter;
                if (previewListAdapter != null) {
                    previewListAdapter.notifyDataSetChanged();
                }
                WidgetListSettingView.this.updateEmptyAndListVisibility();
            }
        });
        this.mAdapter = noteListAdapter;
        RecyclerView recyclerView2 = this.mNoteListView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(noteListAdapter);
        }
        updateNoteListLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSettingList$lambda$0(WidgetListSettingView widgetListSettingView, View view) {
        WidgetListSettingPresenter widgetListSettingPresenter = widgetListSettingView.mPresenter;
        if (widgetListSettingPresenter != null) {
            widgetListSettingPresenter.onNotePickerClicked();
        }
    }

    private final void initWidgetPreview() {
        WidgetListSettingModel mModel;
        View view = this.mPreview;
        List<String> noteList = null;
        this.mPreviewTitleView = view != null ? (TextView) view.findViewById(C11391R.id.widget_title) : null;
        View view2 = this.mPreview;
        this.mPreviewBackground = view2 != null ? (ImageView) view2.findViewById(C11391R.id.background) : null;
        View view3 = this.mPreview;
        this.mPreviewListView = view3 != null ? (RecyclerView) view3.findViewById(C11391R.id.widget_list_view) : null;
        View view4 = this.mPreview;
        this.mPreviewListBackground = view4 != null ? (ImageView) view4.findViewById(C11391R.id.inside_background) : null;
        View view5 = this.mPreview;
        this.mPreviewEmptyView = view5 != null ? (TextView) view5.findViewById(C11391R.id.widget_list_empty_text) : null;
        View view6 = this.mPreview;
        this.mPreviewSettingView = view6 != null ? (ImageView) view6.findViewById(C11391R.id.widget_settings) : null;
        View view7 = this.mPreview;
        this.mPreviewSettingAddButton = view7 != null ? (ImageView) view7.findViewById(C11391R.id.widget_add) : null;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMParent().getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mPreviewListView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        if (widgetListSettingPresenter != null && (mModel = widgetListSettingPresenter.getMModel()) != null) {
            noteList = mModel.getNoteList();
        }
        PreviewListAdapter previewListAdapter = new PreviewListAdapter(noteList, isDarkTheme());
        this.mPreviewAdapter = previewListAdapter;
        RecyclerView recyclerView2 = this.mPreviewListView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(previewListAdapter);
        }
        setListWidgetTitleStyle();
        updateEmptyAndListVisibility();
        initPreviewSetting();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit isOneItemList() {
        WidgetListSettingModel mModel;
        List<String> noteList;
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= 1) {
            ItemTouchHelper itemTouchHelper = this.mTouchHelper;
            if (itemTouchHelper != null) {
                itemTouchHelper.attachToRecyclerView(null);
            }
        } else {
            ItemTouchHelper itemTouchHelper2 = this.mTouchHelper;
            if (itemTouchHelper2 != null) {
                itemTouchHelper2.attachToRecyclerView(this.mNoteListView);
            }
        }
        return Unit.INSTANCE;
    }

    private final void setListWidgetTitleStyle() {
        int dimensionPixelSize;
        if (BaseWidgetUtils.INSTANCE.isFoldWidgetLayout()) {
            TextView textView = this.mPreviewTitleView;
            if (textView != null) {
                textView.setTextAppearance(C11391R.style.ShowNoteTitleTextPhone);
            }
            TextView textView2 = this.mPreviewTitleView;
            Resources resources = textView2 != null ? textView2.getResources() : null;
            Intrinsics.checkNotNull(resources);
            dimensionPixelSize = resources.getDimensionPixelSize(C11391R.dimen.widget_title_margin_phone);
        } else {
            TextView textView3 = this.mPreviewTitleView;
            if (textView3 != null) {
                textView3.setTextAppearance(C11391R.style.ShowNoteTitleText);
            }
            TextView textView4 = this.mPreviewTitleView;
            Resources resources2 = textView4 != null ? textView4.getResources() : null;
            Intrinsics.checkNotNull(resources2);
            dimensionPixelSize = resources2.getDimensionPixelSize(C11391R.dimen.widget_title_margin);
        }
        TextView textView5 = this.mPreviewTitleView;
        ViewGroup.LayoutParams layoutParams = textView5 != null ? textView5.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginEnd(dimensionPixelSize);
        marginLayoutParams.setMarginStart(dimensionPixelSize);
        TextView textView6 = this.mPreviewTitleView;
        if (textView6 != null) {
            textView6.setLayoutParams(marginLayoutParams);
        }
    }

    private final void updateAddButtonState() {
        WidgetListSettingModel mModel;
        if (this.mAddButton == null || this.mPreviewSettingAddButton == null) {
            return;
        }
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        List<String> noteList = (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null) ? null : mModel.getNoteList();
        if (noteList == null || noteList.size() < 10) {
            ImageButton imageButton = this.mAddButton;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.mAddButton;
            if (imageButton2 != null) {
                imageButton2.setEnabled(true);
            }
            ImageView imageView = this.mPreviewSettingAddButton;
            if (imageView != null) {
                imageView.setEnabled(true);
            }
            ImageView imageView2 = this.mPreviewSettingAddButton;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        ImageButton imageButton3 = this.mAddButton;
        if (imageButton3 != null) {
            imageButton3.setEnabled(false);
        }
        ImageButton imageButton4 = this.mAddButton;
        if (imageButton4 != null) {
            imageButton4.setVisibility(4);
        }
        ImageView imageView3 = this.mPreviewSettingAddButton;
        if (imageView3 != null) {
            imageView3.setEnabled(false);
        }
        ImageView imageView4 = this.mPreviewSettingAddButton;
        if (imageView4 != null) {
            imageView4.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyAndListVisibility() {
        WidgetListSettingModel mModel;
        List<String> noteList;
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        if (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null || !noteList.isEmpty()) {
            TextView textView = this.mPreviewEmptyView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            RecyclerView recyclerView = this.mPreviewListView;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView2 = this.mPreviewEmptyView;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        RecyclerView recyclerView2 = this.mPreviewListView;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
    }

    private final void updateNoteListHeight() {
        WidgetListSettingModel mModel;
        List<String> noteList;
        float fApplyDimension = TypedValue.applyDimension(1, 56.0f, getMParent().getContext().getResources().getDisplayMetrics());
        RecyclerView recyclerView = this.mNoteListView;
        Double dValueOf = null;
        ViewGroup.LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        if (widgetListSettingPresenter != null && (mModel = widgetListSettingPresenter.getMModel()) != null && (noteList = mModel.getNoteList()) != null) {
            dValueOf = Double.valueOf(noteList.size());
        }
        Intrinsics.checkNotNull(dValueOf);
        int iMin = (int) Math.min(3.0d, dValueOf.doubleValue());
        if (layoutParams != null) {
            layoutParams.height = (int) (fApplyDimension * iMin);
        }
        RecyclerView recyclerView2 = this.mNoteListView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNoteListLayout() {
        updateNoteListHeight();
        updateNoteListOverlay();
        updateAddButtonState();
    }

    private final void updateNoteListOverlay() {
        WidgetListSettingModel mModel;
        List<String> noteList;
        float fApplyDimension = TypedValue.applyDimension(1, 56.0f, getMParent().getContext().getResources().getDisplayMetrics());
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull((widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size()));
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_note_list_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        updateRoundCornerViewHeight(viewFindViewById, (int) (fApplyDimension * ((int) (Math.min(3.0d, r2.intValue()) + ((double) 1)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewDriver(int fromPosition, int toPosition) {
        WidgetListSettingModel mModel;
        List<String> noteList;
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListSettingPresenter == null || (mModel = widgetListSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        NoteListAdapter noteListAdapter = this.mAdapter;
        if (noteListAdapter != null) {
            noteListAdapter.notifyItemRangeChanged(Math.min(fromPosition, toPosition), Math.max(fromPosition, toPosition) - Math.min(fromPosition, toPosition), new Object());
        }
        PreviewListAdapter previewListAdapter = this.mPreviewAdapter;
        if (previewListAdapter != null) {
            previewListAdapter.notifyItemRangeChanged(Math.min(fromPosition, toPosition), Math.max(fromPosition, toPosition) - Math.min(fromPosition, toPosition), new Object());
        }
        int i = iIntValue - 1;
        if (fromPosition >= i || toPosition == i) {
            NoteListAdapter noteListAdapter2 = this.mAdapter;
            if (noteListAdapter2 != null) {
                noteListAdapter2.notifyItemRangeChanged(iIntValue - 2, 2, new Object());
            }
            PreviewListAdapter previewListAdapter2 = this.mPreviewAdapter;
            if (previewListAdapter2 != null) {
                previewListAdapter2.notifyItemRangeChanged(iIntValue - 2, 2, new Object());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewItem(View view, boolean isViewCleared, int position, int itemCount) {
        if (isViewCleared) {
            view.findViewById(C11391R.id.divider).setVisibility(position < itemCount + (-1) ? 0 : 4);
            view.setBackgroundResource(C11391R.drawable.widget_list_remove);
        } else {
            view.findViewById(C11391R.id.divider).setVisibility(4);
            view.setBackgroundResource(C11391R.drawable.widget_list_highlight);
        }
    }

    private final void updateWidgetPreview() {
        int color;
        int color2;
        Drawable drawable;
        WidgetLogger.m5154d(TAG, "updateWidgetPreview#");
        boolean zIsDarkTheme = isDarkTheme();
        if (zIsDarkTheme) {
            color = ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_black_theme_text_color);
            color2 = ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_list_glance_onSurface_color_dark);
            drawable = ContextCompat.getDrawable(getMParent().getContext(), C11391R.drawable.widget_list_glance_setting_preview_add_icon_background_dark);
        } else {
            color = ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_white_theme_text_color);
            color2 = ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_list_glance_onSurface_color_light);
            drawable = ContextCompat.getDrawable(getMParent().getContext(), C11391R.drawable.widget_list_glance_setting_preview_add_icon_background_light);
        }
        TextView textView = this.mPreviewTitleView;
        if (textView != null) {
            textView.setTextColor(color);
        }
        TextView textView2 = this.mPreviewEmptyView;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
        ImageView imageView = this.mPreviewSettingView;
        if (imageView != null) {
            imageView.setColorFilter(color);
        }
        PreviewListAdapter previewListAdapter = this.mPreviewAdapter;
        if (previewListAdapter != null) {
            previewListAdapter.updatePreviewItemColor(zIsDarkTheme);
        }
        ImageView imageView2 = this.mPreviewSettingAddButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(color2);
        }
        ImageView imageView3 = this.mPreviewSettingAddButton;
        if (imageView3 != null) {
            imageView3.setBackground(drawable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetListSettingPresenter widgetListSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetListSettingPresenter);
        return widgetListSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        super.init();
        initPreview();
        initSettingList();
        initBackgroundColor();
        updateWidgetSettingDarkMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void setEnableBackgroundColorView(boolean enable) {
        super.setEnableBackgroundColorView(enable);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.setting.presenter.WidgetListSettingPresenter");
        this.mPresenter = (WidgetListSettingPresenter) presenter;
    }

    @Override // com.samsung.android.app.notes.widget.setting.view.WidgetListSettingContract
    public void updateNoteListPreview() {
        updateNoteListLayout();
        PreviewListAdapter previewListAdapter = this.mPreviewAdapter;
        if (previewListAdapter != null) {
            previewListAdapter.notifyDataSetChanged();
        }
        NoteListAdapter noteListAdapter = this.mAdapter;
        if (noteListAdapter != null) {
            noteListAdapter.notifyDataSetChanged();
        }
        isOneItemList();
        updateEmptyAndListVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        boolean zIsBlackBackground = isBlackBackground();
        int color = zIsBlackBackground ? ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_list_bg_color_black) : ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_bg_color);
        WidgetLogger.m5154d(TAG, "updateWidgetBackgroundColor# " + color);
        ImageView imageView = this.mPreviewBackground;
        if (imageView != null) {
            updateBackgroundColor(imageView, C11391R.drawable.widget_list_background_white, color);
        }
        int color2 = zIsBlackBackground ? ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_inside_background_color_black) : ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_inside_background_color_white);
        ImageView imageView2 = this.mPreviewListBackground;
        if (imageView2 != null) {
            updateBackgroundColor(imageView2, C11391R.drawable.widget_inside_background, color2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewAlpha(int alpha) {
        Drawable drawable;
        ImageView imageView = this.mPreviewBackground;
        if (imageView != null) {
            imageView.setImageAlpha(alpha);
        }
        ImageView imageView2 = this.mPreviewBackground;
        if (imageView2 != null) {
            imageView2.invalidate();
        }
        ImageView imageView3 = this.mPreviewListBackground;
        if (imageView3 != null) {
            imageView3.setImageAlpha(alpha);
        }
        ImageView imageView4 = this.mPreviewListBackground;
        if (imageView4 != null) {
            imageView4.invalidate();
        }
        ImageView imageView5 = this.mPreviewSettingAddButton;
        Drawable background = imageView5 != null ? imageView5.getBackground() : null;
        LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
        if (layerDrawable != null && (drawable = layerDrawable.getDrawable(0)) != null) {
            drawable.setAlpha(alpha);
        }
        ImageView imageView6 = this.mPreviewSettingAddButton;
        if (imageView6 != null) {
            imageView6.invalidate();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewTheme() {
        updateWidgetBackgroundColor();
        updateWidgetPreview();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetSettingDarkMode() {
        menuEnableUpdate();
        updateWidgetBackgroundColor();
        updateWidgetPreviewAlpha(getPreviewAlpha());
        updateWidgetPreview();
    }
}
