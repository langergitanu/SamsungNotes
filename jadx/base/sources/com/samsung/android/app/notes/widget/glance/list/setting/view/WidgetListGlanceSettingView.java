package com.samsung.android.app.notes.widget.glance.list.setting.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.p109ui.platform.ComposeView;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.list.setting.model.WidgetListGlanceSettingModel;
import com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingContract;
import com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingPresenter;
import com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000200H\u0002J\u0018\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002J\u0010\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000fH\u0002J\u0010\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0002J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u000200H\u0002J(\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0002J\u0018\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020\u000fH\u0002J\b\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u000200H\u0002J\b\u0010G\u001a\u000200H\u0003J\u001a\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020?2\b\u0010K\u001a\u0004\u0018\u00010IH\u0002J\b\u0010L\u001a\u000200H\u0002J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\u0010\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020\u000fH\u0016J\b\u0010Q\u001a\u000200H\u0016J\b\u0010R\u001a\u000200H\u0016J\b\u0010S\u001a\u000200H\u0016J\b\u0010T\u001a\u000200H\u0016J\u0012\u0010U\u001a\u0002002\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0006\u0010\\\u001a\u000200R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000b0-j\b\u0012\u0004\u0012\u00020\u000b`.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006^"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingContract;", "parent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mPresenter", "Lcom/samsung/android/app/notes/widget/glance/list/setting/presenter/WidgetListGlanceSettingPresenter;", "mPreview", "mPreviewBgShapeView", "Lcom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingBgShapeView;", "mOldPreviewBgShapeView", "mPreviewBgShapeList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mWidgetListGlanceSettingPreview", "Lcom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingPreview;", "mNoteListViewGlance", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter;", "mTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mAddButtonGlance", "Landroid/widget/ImageButton;", "<set-?>", "", "requestTime", "getRequestTime", "()J", "setRequestTime", "(J)V", "requestTime$delegate", "Landroidx/compose/runtime/MutableState;", "mBackgroundOnOff", "Landroidx/appcompat/widget/SwitchCompat;", "mBackgroundOnOffTextView", "Landroid/widget/TextView;", "mBackgroundOnOffSubTitle", "mSettingBgShapeContainer", "mBackgroundSwitchLayout", "mBackgroundShapeText", "mShapeViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "init", "", "initPreview", "initSettingBackgroundShape", "updateOldBackgroundShape", "oldResId", "resId", "getResFromShapeId", VMetaDataKey.META_KEY_SHAPE, "getShapeIdFromRes", "resourceId", "initSettingListGlance", "initItemMoveHelperGlance", "updateViewItem", "view", "isViewCleared", "", "position", "itemCount", "updateViewDriver", "fromPosition", "toPosition", "updateNoteListHeight", "updateNoteListOverlay", "initBackgroundOnOff", "getContentDescriptionSwitchString", "", "isChecked", "label", "updateWidgetPreview", "updateAddButtonStateGlance", "updateNoteListLayout", "updateWidgetPreviewAlpha", "alpha", "updateWidgetSettingDarkMode", "updateWidgetPreviewTheme", "updateWidgetBackgroundColor", "updateNoteListPreview", "setPresenter", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "isOneItemList", "()Lkotlin/Unit;", "updateBackgroundOnOff", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListGlanceSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlanceSettingView.kt\ncom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingView\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,463:1\n81#2:464\n107#2,2:465\n1#3:467\n1869#4,2:468\n*S KotlinDebug\n*F\n+ 1 WidgetListGlanceSettingView.kt\ncom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingView\n*L\n52#1:464\n52#1:465,2\n115#1:468,2\n*E\n"})
public final class WidgetListGlanceSettingView extends BaseWidgetSettingView implements WidgetListGlanceSettingContract {

    @NotNull
    private static final String COMMA_WITH_SPACE = ", ";

    @NotNull
    private static final String TAG = "WidgetListGlanceSettingView";
    private static final int WIDGET_LIST_VISIBLE_COUNT = 3;

    @Nullable
    private NoteListAdapter mAdapter;

    @Nullable
    private ImageButton mAddButtonGlance;

    @Nullable
    private SwitchCompat mBackgroundOnOff;

    @Nullable
    private TextView mBackgroundOnOffSubTitle;

    @Nullable
    private TextView mBackgroundOnOffTextView;

    @Nullable
    private TextView mBackgroundShapeText;

    @Nullable
    private View mBackgroundSwitchLayout;

    @Nullable
    private RecyclerView mNoteListViewGlance;

    @Nullable
    private WidgetListGlanceSettingBgShapeView mOldPreviewBgShapeView;

    @Nullable
    private WidgetListGlanceSettingPresenter mPresenter;

    @Nullable
    private View mPreview;

    @NotNull
    private final HashMap<Integer, WidgetListGlanceSettingBgShapeView> mPreviewBgShapeList;

    @Nullable
    private WidgetListGlanceSettingBgShapeView mPreviewBgShapeView;

    @Nullable
    private View mSettingBgShapeContainer;

    @NotNull
    private ArrayList<WidgetListGlanceSettingBgShapeView> mShapeViews;

    @Nullable
    private ItemTouchHelper mTouchHelper;

    @Nullable
    private WidgetListGlanceSettingPreview mWidgetListGlanceSettingPreview;

    /* JADX INFO: renamed from: requestTime$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState requestTime;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView$initItemMoveHelperGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"com/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingView$initItemMoveHelperGlance$1", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "fromPosition", "", "toPosition", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onMove", "", "srcViewHolder", "dstViewHolder", "onSelectedChanged", "", "actionState", "clearView", "onSwiped", "i", "isLongPressDragEnabled", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nWidgetListGlanceSettingView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListGlanceSettingView.kt\ncom/samsung/android/app/notes/widget/glance/list/setting/view/WidgetListGlanceSettingView$initItemMoveHelperGlance$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,463:1\n1#2:464\n*E\n"})
    public static final class C69451 extends ItemTouchHelper.Callback {
        private int fromPosition = -1;
        private int toPosition = -1;

        public C69451() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void clearView$lambda$1(WidgetListGlanceSettingView widgetListGlanceSettingView, C69451 c69451) {
            widgetListGlanceSettingView.updateViewDriver(c69451.fromPosition, c69451.toPosition);
            c69451.fromPosition = -1;
            c69451.toPosition = -1;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            WidgetListGlanceSettingModel mModel;
            List<String> noteList;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = WidgetListGlanceSettingView.this.mPresenter;
            Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            WidgetListGlanceSettingView widgetListGlanceSettingView = WidgetListGlanceSettingView.this;
            View itemView = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            widgetListGlanceSettingView.updateViewItem(itemView, true, viewHolder.getPosition(), iIntValue);
            Logger.m8697d("WidgetListGlanceSettingView", "clearView ");
            if (this.fromPosition == -1 || this.toPosition == -1) {
                return;
            }
            recyclerView.post(new RunnableC4199v(WidgetListGlanceSettingView.this, this, 5));
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
            WidgetListGlanceSettingModel mModel;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(srcViewHolder, "srcViewHolder");
            Intrinsics.checkNotNullParameter(dstViewHolder, "dstViewHolder");
            int bindingAdapterPosition = srcViewHolder.getBindingAdapterPosition();
            int bindingAdapterPosition2 = dstViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || bindingAdapterPosition2 == -1) {
                return false;
            }
            this.toPosition = bindingAdapterPosition2;
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = WidgetListGlanceSettingView.this.mPresenter;
            if (widgetListGlanceSettingPresenter != null && (mModel = widgetListGlanceSettingPresenter.getMModel()) != null) {
                mModel.swapItemGlance(bindingAdapterPosition, bindingAdapterPosition2);
            }
            NoteListAdapter noteListAdapter = WidgetListGlanceSettingView.this.mAdapter;
            if (noteListAdapter != null) {
                noteListAdapter.notifyItemMoved(bindingAdapterPosition, bindingAdapterPosition2);
            }
            WidgetListGlanceSettingView.this.updateWidgetPreview();
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            WidgetListGlanceSettingModel mModel;
            List<String> noteList;
            super.onSelectedChanged(viewHolder, actionState);
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = WidgetListGlanceSettingView.this.mPresenter;
            Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
            Intrinsics.checkNotNull(numValueOf);
            int iIntValue = numValueOf.intValue();
            if (actionState == 2) {
                this.fromPosition = viewHolder != null ? viewHolder.getBindingAdapterPosition() : -1;
            }
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                WidgetListGlanceSettingView.this.updateViewItem(view, false, viewHolder.getPosition(), iIntValue);
            }
            AbstractC4539a.m3203m(actionState, "onSelectedChanged ", "WidgetListGlanceSettingView");
            Logger.m8697d("WidgetListGlanceSettingView", "oldpos: " + (viewHolder != null ? Integer.valueOf(viewHolder.getOldPosition()) : null) + ", pos: " + (viewHolder != null ? Integer.valueOf(viewHolder.getPosition()) : null));
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetListGlanceSettingView(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
        this.mPreviewBgShapeList = new HashMap<>();
        this.requestTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.valueOf(System.currentTimeMillis()), null, 2, null);
        this.mShapeViews = new ArrayList<>();
    }

    private final String getContentDescriptionSwitchString(boolean isChecked, String label) {
        Context context;
        int i;
        if (isChecked) {
            context = getMParent().getContext();
            i = C11391R.string.string_on;
        } else {
            context = getMParent().getContext();
            i = C11391R.string.string_off;
        }
        return AbstractC2821a.m2221l(context.getString(i), ", ", label, getMParent().getContext().getString(C11391R.string.string_switch));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final long getRequestTime() {
        return ((Number) this.requestTime.getValue()).longValue();
    }

    private final int getResFromShapeId(int shape) {
        return shape != 0 ? shape != 1 ? shape != 2 ? shape != 3 ? shape != 4 ? C11391R.drawable.widget_setting_preview_bg_shape_00 : C11391R.drawable.widget_setting_preview_bg_shape_04 : C11391R.drawable.widget_setting_preview_bg_shape_03 : C11391R.drawable.widget_setting_preview_bg_shape_02 : C11391R.drawable.widget_setting_preview_bg_shape_01 : C11391R.drawable.widget_setting_preview_bg_shape_00;
    }

    private final int getShapeIdFromRes(int resourceId) {
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_01) {
            return 1;
        }
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_02) {
            return 2;
        }
        if (resourceId == C11391R.drawable.widget_setting_preview_bg_shape_03) {
            return 3;
        }
        return resourceId == C11391R.drawable.widget_setting_preview_bg_shape_04 ? 4 : 0;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initBackgroundOnOff() {
        WidgetListGlanceSettingModel mModel;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_glance_setting_background, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 1);
        setMBackgroundOnOffFrameView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_frame_view));
        setMBackgroundOnOffContainerView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_container));
        setMBackgroundOnOffCornerView((RoundCornerOverlayView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_round_corner));
        setMBackgroundOnOffItemView(getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_item));
        this.mBackgroundOnOffTextView = (TextView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_title);
        this.mBackgroundOnOffSubTitle = (TextView) getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_sub_title);
        View viewFindViewById2 = getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off_switch);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        SwitchCompat switchCompat = (SwitchCompat) viewFindViewById2;
        this.mBackgroundOnOff = switchCompat;
        if (switchCompat != null) {
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
            Boolean boolValueOf = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null) ? null : Boolean.valueOf(mModel.getBackgroundOnOff());
            Intrinsics.checkNotNull(boolValueOf);
            switchCompat.setChecked(boolValueOf.booleanValue());
        }
        this.mBackgroundSwitchLayout = getMParent().findViewById(C11391R.id.widget_glance_setting_background_on_off);
        TextView textView = this.mBackgroundOnOffTextView;
        String str = ((Object) (textView != null ? textView.getText() : null)) + ", ";
        SwitchCompat switchCompat2 = this.mBackgroundOnOff;
        Boolean boolValueOf2 = switchCompat2 != null ? Boolean.valueOf(switchCompat2.isChecked()) : null;
        Intrinsics.checkNotNull(boolValueOf2);
        String contentDescriptionSwitchString = getContentDescriptionSwitchString(boolValueOf2.booleanValue(), str);
        View view = this.mBackgroundSwitchLayout;
        if (view != null) {
            view.setFocusable(1);
        }
        View view2 = this.mBackgroundSwitchLayout;
        if (view2 != null) {
            view2.setContentDescription(contentDescriptionSwitchString);
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter2 = this.mPresenter;
        if ((widgetListGlanceSettingPresenter2 != null ? widgetListGlanceSettingPresenter2.getOneUiWidgetSource() : null) != null) {
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter3 = this.mPresenter;
            if (Intrinsics.areEqual(widgetListGlanceSettingPresenter3 != null ? widgetListGlanceSettingPresenter3.getOneUiWidgetSource() : null, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
                SwitchCompat switchCompat3 = this.mBackgroundOnOff;
                if (switchCompat3 != null) {
                    switchCompat3.setAlpha(0.4f);
                }
                View view3 = this.mBackgroundSwitchLayout;
                if (view3 != null) {
                    view3.setEnabled(false);
                }
                SwitchCompat switchCompat4 = this.mBackgroundOnOff;
                if (switchCompat4 != null) {
                    switchCompat4.setEnabled(false);
                }
                TextView textView2 = this.mBackgroundOnOffSubTitle;
                if (textView2 != null) {
                    textView2.setText(getMParent().getResources().getString(C11391R.string.widget_setting_background_on_off_spage_sub_title));
                }
                TextView textView3 = this.mBackgroundOnOffSubTitle;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
            }
        }
        SwitchCompat switchCompat5 = this.mBackgroundOnOff;
        if (switchCompat5 != null) {
            switchCompat5.setOnCheckedChangeListener(new C6958k(this, str, 0));
        }
        SwitchCompat switchCompat6 = this.mBackgroundOnOff;
        Boolean boolValueOf3 = switchCompat6 != null ? Boolean.valueOf(switchCompat6.isChecked()) : null;
        Intrinsics.checkNotNull(boolValueOf3);
        onBackgroundToggled(boolValueOf3.booleanValue());
        View view4 = this.mBackgroundSwitchLayout;
        if (view4 != null) {
            view4.setOnClickListener(new ViewOnClickListenerC6959l(this, 0));
        }
        View view5 = this.mBackgroundSwitchLayout;
        if (view5 != null) {
            view5.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 1));
        }
        initOpacityViewOneUi7x();
        initBackgroundColorOneUI7x();
        updateBackgroundOnOff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$6(WidgetListGlanceSettingView widgetListGlanceSettingView, String str, CompoundButton compoundButton, boolean z) {
        WidgetListGlanceSettingModel mModel;
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        NotesSamsungAnalytics.INSTANCE.insertLog("615", "6141", z ? "1. On" : "2. Off");
        SwitchCompat switchCompat = widgetListGlanceSettingView.mBackgroundOnOff;
        if (switchCompat != null) {
            switchCompat.setChecked(z);
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = widgetListGlanceSettingView.mPresenter;
        if (widgetListGlanceSettingPresenter != null && (mModel = widgetListGlanceSettingPresenter.getMModel()) != null) {
            mModel.setBackgroundOnOff(z);
        }
        widgetListGlanceSettingView.onBackgroundToggled(z);
        View view = widgetListGlanceSettingView.mBackgroundSwitchLayout;
        if (view != null) {
            SwitchCompat switchCompat2 = widgetListGlanceSettingView.mBackgroundOnOff;
            Boolean boolValueOf = switchCompat2 != null ? Boolean.valueOf(switchCompat2.isChecked()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            view.setContentDescription(widgetListGlanceSettingView.getContentDescriptionSwitchString(boolValueOf.booleanValue(), str));
        }
        widgetListGlanceSettingView.updateRoundCornerViewHeight(widgetListGlanceSettingView.getMBackgroundOnOffContainerView(), widgetListGlanceSettingView.getMBackgroundOnOffFrameView(), widgetListGlanceSettingView.getMBackgroundOnOffCornerView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundOnOff$lambda$7(WidgetListGlanceSettingView widgetListGlanceSettingView, View view) {
        SwitchCompat switchCompat = widgetListGlanceSettingView.mBackgroundOnOff;
        if (switchCompat != null) {
            switchCompat.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initBackgroundOnOff$lambda$8(WidgetListGlanceSettingView widgetListGlanceSettingView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            TextView textView = widgetListGlanceSettingView.mBackgroundOnOffTextView;
            if (textView != null) {
                textView.setPressed(true);
            }
            SwitchCompat switchCompat = widgetListGlanceSettingView.mBackgroundOnOff;
            if (switchCompat != null) {
                switchCompat.setPressed(true);
            }
        } else if (action == 1 || action == 3) {
            TextView textView2 = widgetListGlanceSettingView.mBackgroundOnOffTextView;
            if (textView2 != null) {
                textView2.setPressed(false);
            }
            SwitchCompat switchCompat2 = widgetListGlanceSettingView.mBackgroundOnOff;
            if (switchCompat2 != null) {
                switchCompat2.setPressed(false);
            }
        }
        return false;
    }

    private final void initItemMoveHelperGlance() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new C69451());
        this.mTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.mNoteListViewGlance);
    }

    private final void initPreview() {
        WidgetListGlanceSettingModel mModel;
        WidgetListGlanceSettingModel mModel2;
        WidgetListGlanceSettingModel mModel3;
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel3 = widgetListGlanceSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel3.getMinWidth());
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter2 = this.mPresenter;
        companion.insertLog("615", "6139", numValueOf + " x " + ((widgetListGlanceSettingPresenter2 == null || (mModel2 = widgetListGlanceSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel2.getMinHeight())));
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_preview_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter3 = this.mPresenter;
        if ((widgetListGlanceSettingPresenter3 != null ? widgetListGlanceSettingPresenter3.getOneUiWidgetSource() : null) != null) {
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter4 = this.mPresenter;
            if (Intrinsics.areEqual(widgetListGlanceSettingPresenter4 != null ? widgetListGlanceSettingPresenter4.getOneUiWidgetSource() : null, BaseWidgetConstant.ONE_UI_WIDGET_SOURCE_SPAGE)) {
                relativeLayout.setBackgroundColor(ContextCompat.getColor(getMParent().getContext(), C11391R.color.widget_setting_preview_background));
            }
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter5 = this.mPresenter;
        Integer numValueOf2 = (widgetListGlanceSettingPresenter5 == null || (mModel = widgetListGlanceSettingPresenter5.getMModel()) == null) ? null : Integer.valueOf(mModel.getRow());
        Intrinsics.checkNotNull(numValueOf2);
        if (numValueOf2.intValue() > 2 && getMParent().getResources().getConfiguration().orientation == 1) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = getMParent().getResources().getDimensionPixelSize(C11391R.dimen.widget_setting_preview_container_size_max_height);
            relativeLayout.setLayoutParams(layoutParams);
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter6 = this.mPresenter;
        this.mWidgetListGlanceSettingPreview = widgetListGlanceSettingPresenter6 != null ? new WidgetListGlanceSettingPreview(getMParent(), widgetListGlanceSettingPresenter6) : null;
        Context context = getMParent().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-877378066, true, new Function2<Composer, Integer, Unit>() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView$initPreview$previewCompose$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-877378066, i, -1, "com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView.initPreview.<anonymous>.<anonymous> (WidgetListGlanceSettingView.kt:90)");
                }
                WidgetListGlanceSettingPreview widgetListGlanceSettingPreview = this.this$0.mWidgetListGlanceSettingPreview;
                if (widgetListGlanceSettingPreview != null) {
                    widgetListGlanceSettingPreview.setContent(this.this$0.getRequestTime(), composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        relativeLayout.addView(composeView);
    }

    private final void initSettingBackgroundShape() {
        WidgetListGlanceSettingModel mModel;
        WidgetListGlanceSettingModel mModel2;
        WidgetListGlanceSettingModel mModel3;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel3 = widgetListGlanceSettingPresenter.getMModel()) == null) ? null : Integer.valueOf(mModel3.getRow());
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() == 2) {
            WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter2 = this.mPresenter;
            Integer numValueOf2 = (widgetListGlanceSettingPresenter2 == null || (mModel2 = widgetListGlanceSettingPresenter2.getMModel()) == null) ? null : Integer.valueOf(mModel2.getColumn());
            Intrinsics.checkNotNull(numValueOf2);
            if (numValueOf2.intValue() == 2) {
                Object systemService = getMParent().getContext().getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
                ((LinearLayout) viewFindViewById).addView(((LayoutInflater) systemService).inflate(C11391R.layout.widget_list_glance_setting_control_background_shape, (ViewGroup) null), 0);
                setMBackgroundShapeView(getMParent().findViewById(C11391R.id.widget_list_glance_setting_control_background_shape));
                this.mBackgroundShapeText = (TextView) getMParent().findViewById(C11391R.id.widget_list_setting_bg_shape_title);
                View viewFindViewById2 = getMParent().findViewById(C11391R.id.widget_list_setting_control_background_shape_container);
                Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
                this.mSettingBgShapeContainer = (LinearLayout) viewFindViewById2;
                Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_00), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_01), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_02), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_03), Integer.valueOf(C11391R.drawable.widget_setting_preview_bg_shape_04)}).iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    Context context = getMParent().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    WidgetListGlanceSettingBgShapeView widgetListGlanceSettingBgShapeView = new WidgetListGlanceSettingBgShapeView(context, null, 0, 6, null);
                    SwitchCompat switchCompat = this.mBackgroundOnOff;
                    widgetListGlanceSettingBgShapeView.setSelectable(switchCompat != null ? switchCompat.isChecked() : true);
                    widgetListGlanceSettingBgShapeView.setImageBg(iIntValue);
                    widgetListGlanceSettingBgShapeView.setOnSelectListener(new C6960m(this, iIntValue, 0));
                    this.mShapeViews.add(widgetListGlanceSettingBgShapeView);
                    WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter3 = this.mPresenter;
                    Integer numValueOf3 = (widgetListGlanceSettingPresenter3 == null || (mModel = widgetListGlanceSettingPresenter3.getMModel()) == null) ? null : Integer.valueOf(mModel.getBackgroundShape());
                    Intrinsics.checkNotNull(numValueOf3);
                    if (getResFromShapeId(numValueOf3.intValue()) == iIntValue) {
                        widgetListGlanceSettingBgShapeView.updateState(true);
                        this.mOldPreviewBgShapeView = widgetListGlanceSettingBgShapeView;
                        this.mPreviewBgShapeView = widgetListGlanceSettingBgShapeView;
                    }
                    this.mPreviewBgShapeList.put(Integer.valueOf(iIntValue), widgetListGlanceSettingBgShapeView);
                    View view = this.mSettingBgShapeContainer;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
                    ((LinearLayout) view).addView(widgetListGlanceSettingBgShapeView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSettingBackgroundShape$lambda$4$lambda$3$lambda$2(WidgetListGlanceSettingView widgetListGlanceSettingView, int i, WidgetListGlanceSettingBgShapeView selectedView) {
        Intrinsics.checkNotNullParameter(selectedView, "selectedView");
        SwitchCompat switchCompat = widgetListGlanceSettingView.mBackgroundOnOff;
        if (switchCompat == null || switchCompat.isChecked()) {
            WidgetListGlanceSettingBgShapeView widgetListGlanceSettingBgShapeView = widgetListGlanceSettingView.mPreviewBgShapeView;
            if (widgetListGlanceSettingBgShapeView != null) {
                widgetListGlanceSettingBgShapeView.updateState(false);
            }
            selectedView.updateState(true);
            WidgetListGlanceSettingBgShapeView widgetListGlanceSettingBgShapeView2 = widgetListGlanceSettingView.mPreviewBgShapeView;
            int shapeResource = widgetListGlanceSettingBgShapeView2 != null ? widgetListGlanceSettingBgShapeView2.getMResourceId() : C11391R.drawable.widget_setting_preview_bg_shape_00;
            widgetListGlanceSettingView.mPreviewBgShapeView = selectedView;
            widgetListGlanceSettingView.updateWidgetBackgroundColor();
            widgetListGlanceSettingView.updateOldBackgroundShape(shapeResource, i);
        }
        return Unit.INSTANCE;
    }

    private final void initSettingListGlance() {
        WidgetListGlanceSettingModel mModel;
        Object systemService = getMParent().getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        List<String> noteList = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_setting_control_list, (ViewGroup) null);
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewFindViewById).addView(viewInflate, 0);
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(C11391R.id.widget_note_list_add);
        this.mAddButtonGlance = imageButton;
        if (imageButton != null) {
            imageButton.setOnClickListener(new ViewOnClickListenerC6959l(this, 1));
        }
        this.mNoteListViewGlance = (RecyclerView) viewInflate.findViewById(C11391R.id.widget_setting_note_list);
        View view = this.mPreview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view != null ? view.getContext() : null);
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.mNoteListViewGlance;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        initItemMoveHelperGlance();
        isOneItemList();
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        if (widgetListGlanceSettingPresenter != null && (mModel = widgetListGlanceSettingPresenter.getMModel()) != null) {
            noteList = mModel.getNoteList();
        }
        NoteListAdapter noteListAdapter = new NoteListAdapter(TypeIntrinsics.asMutableList(noteList), new NoteListAdapter.OnStartDragListener() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView.initSettingListGlance.2
            @Override // com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.OnStartDragListener
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
                ItemTouchHelper itemTouchHelper;
                if (WidgetListGlanceSettingView.this.mTouchHelper == null || viewHolder == null || (itemTouchHelper = WidgetListGlanceSettingView.this.mTouchHelper) == null) {
                    return;
                }
                itemTouchHelper.startDrag(viewHolder);
            }
        }, new NoteListAdapter.ItemLayoutHeightListener() { // from class: com.samsung.android.app.notes.widget.glance.list.setting.view.WidgetListGlanceSettingView.initSettingListGlance.3
            @Override // com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.ItemLayoutHeightListener
            public void onItemRemoved(int position) {
                WidgetListGlanceSettingModel mModel2;
                WidgetListGlanceSettingView.this.updateNoteListLayout();
                WidgetListGlanceSettingView.this.isOneItemList();
                NoteListAdapter noteListAdapter2 = WidgetListGlanceSettingView.this.mAdapter;
                if (noteListAdapter2 != null) {
                    noteListAdapter2.notifyDataSetChanged();
                }
                WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter2 = WidgetListGlanceSettingView.this.mPresenter;
                if (widgetListGlanceSettingPresenter2 != null && (mModel2 = widgetListGlanceSettingPresenter2.getMModel()) != null) {
                    mModel2.removeDisplayListGlance(position);
                }
                WidgetListGlanceSettingView.this.updateWidgetPreview();
                WidgetListGlanceSettingView.this.updateBackgroundOnOff();
            }
        });
        this.mAdapter = noteListAdapter;
        RecyclerView recyclerView2 = this.mNoteListViewGlance;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(noteListAdapter);
        }
        updateNoteListLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSettingListGlance$lambda$5(WidgetListGlanceSettingView widgetListGlanceSettingView, View view) {
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = widgetListGlanceSettingView.mPresenter;
        if (widgetListGlanceSettingPresenter != null) {
            widgetListGlanceSettingPresenter.onNotePickerClickedGlance();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit isOneItemList() {
        WidgetListGlanceSettingModel mModel;
        List<String> noteList;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
        Intrinsics.checkNotNull(numValueOf);
        if (numValueOf.intValue() <= 1) {
            ItemTouchHelper itemTouchHelper = this.mTouchHelper;
            if (itemTouchHelper != null) {
                itemTouchHelper.attachToRecyclerView(null);
            }
        } else {
            ItemTouchHelper itemTouchHelper2 = this.mTouchHelper;
            if (itemTouchHelper2 != null) {
                itemTouchHelper2.attachToRecyclerView(this.mNoteListViewGlance);
            }
        }
        return Unit.INSTANCE;
    }

    private final void setRequestTime(long j) {
        this.requestTime.setValue(Long.valueOf(j));
    }

    private final void updateAddButtonStateGlance() {
        WidgetListGlanceSettingModel mModel;
        if (this.mAddButtonGlance == null) {
            return;
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        List<String> noteList = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null) ? null : mModel.getNoteList();
        if (noteList == null || noteList.size() < 10) {
            ImageButton imageButton = this.mAddButtonGlance;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.mAddButtonGlance;
            if (imageButton2 != null) {
                imageButton2.setEnabled(true);
                return;
            }
            return;
        }
        ImageButton imageButton3 = this.mAddButtonGlance;
        if (imageButton3 != null) {
            imageButton3.setEnabled(false);
        }
        ImageButton imageButton4 = this.mAddButtonGlance;
        if (imageButton4 != null) {
            imageButton4.setVisibility(4);
        }
    }

    private final void updateNoteListHeight() {
        WidgetListGlanceSettingModel mModel;
        List<String> noteList;
        double dCeil = Math.ceil(56 * getMParent().getContext().getResources().getDisplayMetrics().density);
        RecyclerView recyclerView = this.mNoteListViewGlance;
        Double dValueOf = null;
        ViewGroup.LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        if (widgetListGlanceSettingPresenter != null && (mModel = widgetListGlanceSettingPresenter.getMModel()) != null && (noteList = mModel.getNoteList()) != null) {
            dValueOf = Double.valueOf(noteList.size());
        }
        Intrinsics.checkNotNull(dValueOf);
        int iMin = (int) Math.min(3.0d, dValueOf.doubleValue());
        if (layoutParams != null) {
            layoutParams.height = (int) (dCeil * ((double) iMin));
        }
        RecyclerView recyclerView2 = this.mNoteListViewGlance;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNoteListLayout() {
        updateNoteListHeight();
        updateNoteListOverlay();
        updateAddButtonStateGlance();
    }

    private final void updateNoteListOverlay() {
        WidgetListGlanceSettingModel mModel;
        List<String> noteList;
        double dCeil = Math.ceil(56 * getMParent().getContext().getResources().getDisplayMetrics().density);
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull((widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size()));
        double dMin = dCeil * ((double) ((int) (Math.min(3.0d, r2.intValue()) + ((double) 1))));
        View viewFindViewById = getMParent().findViewById(C11391R.id.widget_setting_note_list_overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        updateRoundCornerViewHeight(viewFindViewById, (int) dMin);
    }

    private final void updateOldBackgroundShape(int oldResId, int resId) {
        WidgetListGlanceSettingModel mModel;
        WidgetListGlanceSettingBgShapeView widgetListGlanceSettingBgShapeView = this.mPreviewBgShapeList.get(Integer.valueOf(oldResId));
        if (widgetListGlanceSettingBgShapeView != null) {
            widgetListGlanceSettingBgShapeView.updateState(resId == oldResId);
        }
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        if (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null) {
            return;
        }
        mModel.setBackgroundShape(getShapeIdFromRes(resId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewDriver(int fromPosition, int toPosition) {
        NoteListAdapter noteListAdapter;
        WidgetListGlanceSettingModel mModel;
        List<String> noteList;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Integer numValueOf = (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null) ? null : Integer.valueOf(noteList.size());
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        NoteListAdapter noteListAdapter2 = this.mAdapter;
        if (noteListAdapter2 != null) {
            noteListAdapter2.notifyItemRangeChanged(Math.min(fromPosition, toPosition), Math.max(fromPosition, toPosition) - Math.min(fromPosition, toPosition), new Object());
        }
        int i = iIntValue - 1;
        if ((fromPosition >= i || toPosition == i) && (noteListAdapter = this.mAdapter) != null) {
            noteListAdapter.notifyItemRangeChanged(iIntValue - 2, 2, new Object());
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWidgetPreview() {
        setRequestTime(System.currentTimeMillis());
        WidgetLogger.m5154d("WidgetListGlanceSettingView", "updateWidgetPreview# time: " + getRequestTime());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    @NotNull
    public BaseWidgetSettingPresenter getPresenter() {
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        Intrinsics.checkNotNull(widgetListGlanceSettingPresenter);
        return widgetListGlanceSettingPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView
    public void init() {
        super.init();
        initSettingBackgroundShape();
        initPreview();
        initSettingListGlance();
        initBackgroundOnOff();
        updateWidgetSettingDarkMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void setPresenter(@Nullable BaseWidgetSettingPresenter presenter) {
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingPresenter");
        this.mPresenter = (WidgetListGlanceSettingPresenter) presenter;
    }

    public final void updateBackgroundOnOff() {
        WidgetListGlanceSettingModel mModel;
        List<String> noteList;
        WidgetListGlanceSettingPresenter widgetListGlanceSettingPresenter = this.mPresenter;
        if (widgetListGlanceSettingPresenter == null || (mModel = widgetListGlanceSettingPresenter.getMModel()) == null || (noteList = mModel.getNoteList()) == null || noteList.isEmpty()) {
            View mBackgroundOnOffContainerView = getMBackgroundOnOffContainerView();
            if (mBackgroundOnOffContainerView != null) {
                mBackgroundOnOffContainerView.setVisibility(8);
            }
            RoundCornerOverlayView mBackgroundOnOffCornerView = getMBackgroundOnOffCornerView();
            if (mBackgroundOnOffCornerView != null) {
                mBackgroundOnOffCornerView.setVisibility(8);
            }
            View mBackgroundShapeView = getMBackgroundShapeView();
            if (mBackgroundShapeView != null) {
                mBackgroundShapeView.setVisibility(8);
            }
        } else {
            View mBackgroundOnOffContainerView2 = getMBackgroundOnOffContainerView();
            if (mBackgroundOnOffContainerView2 != null) {
                mBackgroundOnOffContainerView2.setVisibility(0);
            }
            RoundCornerOverlayView mBackgroundOnOffCornerView2 = getMBackgroundOnOffCornerView();
            if (mBackgroundOnOffCornerView2 != null) {
                mBackgroundOnOffCornerView2.setVisibility(0);
            }
            View mBackgroundShapeView2 = getMBackgroundShapeView();
            if (mBackgroundShapeView2 != null) {
                mBackgroundShapeView2.setVisibility(0);
            }
        }
        updateRoundCornerViewHeight(getMBackgroundOnOffContainerView(), getMBackgroundOnOffFrameView(), getMBackgroundOnOffCornerView());
    }

    @Override // com.samsung.android.app.notes.widget.glance.list.setting.presenter.WidgetListGlanceSettingContract
    public void updateNoteListPreview() {
        updateNoteListLayout();
        NoteListAdapter noteListAdapter = this.mAdapter;
        if (noteListAdapter != null) {
            noteListAdapter.notifyDataSetChanged();
        }
        isOneItemList();
        updateWidgetPreview();
        updateBackgroundOnOff();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetBackgroundColor() {
        updateWidgetPreview();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewAlpha(int alpha) {
        updateWidgetPreview();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetPreviewTheme() {
        updateWidgetBackgroundColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingContract
    public void updateWidgetSettingDarkMode() {
        menuEnableUpdate();
        updateWidgetBackgroundColor();
        updateWidgetPreviewAlpha(getPreviewAlpha());
    }
}
