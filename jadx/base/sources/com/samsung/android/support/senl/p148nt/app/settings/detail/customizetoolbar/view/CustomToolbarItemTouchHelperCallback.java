package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005*\u0001%\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "customToolbarView", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;)V", "oldToolbarList", "", "", "oldVisibleToolbarList", "getOldVisibleToolbarList", "()Ljava/util/List;", "oldHiddenToolbarList", "getOldHiddenToolbarList", "isVisibleToolbarUpdated", "", "()Z", "isHiddenToolbarUpdated", "isToolbarOrderUpdated", "onMove", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "target", "onSwiped", "", "direction", "", "clearView", "onSelectedChanged", "actionState", "insertSALogging", "itemName", "currentDraggingView", "Landroid/view/View;", "scrollRunnable", "com/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback$scrollRunnable$1", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback$scrollRunnable$1;", "isLongPressDragEnabled", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCustomToolbarItemTouchHelperCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomToolbarItemTouchHelperCallback.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,140:1\n967#2,7:141\n756#2,10:148\n*S KotlinDebug\n*F\n+ 1 CustomToolbarItemTouchHelperCallback.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback\n*L\n17#1:141,7\n21#1:148,10\n*E\n"})
public final class CustomToolbarItemTouchHelperCallback extends ItemTouchHelper.SimpleCallback {

    @NotNull
    private static final String TAG = "CustomToolbarItemTouchHelperCallback";

    @Nullable
    private View currentDraggingView;

    @NotNull
    private final CustomToolbarView customToolbarView;

    @NotNull
    private List<String> oldToolbarList;

    @NotNull
    private final CustomToolbarItemTouchHelperCallback$scrollRunnable$1 scrollRunnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemTouchHelperCallback$scrollRunnable$1] */
    public CustomToolbarItemTouchHelperCallback(@NotNull CustomToolbarView customToolbarView) {
        super(3, 0);
        Intrinsics.checkNotNullParameter(customToolbarView, "customToolbarView");
        this.customToolbarView = customToolbarView;
        this.oldToolbarList = CollectionsKt.toList(customToolbarView.getToolbarDisplayList());
        this.scrollRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemTouchHelperCallback$scrollRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                View view = this.this$0.currentDraggingView;
                if (view != null) {
                    CustomToolbarItemTouchHelperCallback customToolbarItemTouchHelperCallback = this.this$0;
                    RecyclerView recyclerView = customToolbarItemTouchHelperCallback.customToolbarView.getRecyclerView();
                    Rect rect = new Rect();
                    recyclerView.getGlobalVisibleRect(rect);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i = iArr[1];
                    int height = view.getHeight() + i;
                    int height2 = view.getHeight() / 2;
                    int height3 = view.getHeight() / 3;
                    if (i + height2 < rect.top) {
                        customToolbarItemTouchHelperCallback.customToolbarView.scrollBy(0, -15);
                    } else if (height - height3 > rect.bottom) {
                        customToolbarItemTouchHelperCallback.customToolbarView.scrollBy(0, 15);
                    }
                    recyclerView.postDelayed(this, 5L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearView$lambda$3(CustomToolbarItemTouchHelperCallback customToolbarItemTouchHelperCallback, RecyclerView.ViewHolder viewHolder) {
        customToolbarItemTouchHelperCallback.customToolbarView.setDragging(false);
        if (customToolbarItemTouchHelperCallback.isToolbarOrderUpdated()) {
            customToolbarItemTouchHelperCallback.customToolbarView.saveOrderListToSharedPreference();
        } else if (viewHolder instanceof CustomToolbarItemHolder) {
            CustomToolbarItemHolder customToolbarItemHolder = (CustomToolbarItemHolder) viewHolder;
            customToolbarItemHolder.updateBackground(customToolbarItemHolder.getBindingAdapterPosition());
        }
    }

    private final List<String> getOldHiddenToolbarList() {
        List<String> list = this.oldToolbarList;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Object obj : list) {
            if (z) {
                arrayList.add(obj);
            } else if (Intrinsics.areEqual((String) obj, CustomToolbarView.DELETION_MARKER)) {
                arrayList.add(obj);
                z = true;
            }
        }
        return CollectionsKt.drop(arrayList, 1);
    }

    private final List<String> getOldVisibleToolbarList() {
        List<String> list = this.oldToolbarList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual((String) obj, CustomToolbarView.DELETION_MARKER)) {
                break;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    private final void insertSALogging(String itemName) {
        if (isVisibleToolbarUpdated()) {
            CommonSamsungAnalytics.INSTANCE.insertLog("234", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_REORDER);
            MainLogger.m7254d(TAG, "insertSALogging# Reorder - " + itemName);
        }
    }

    private final boolean isHiddenToolbarUpdated() {
        return !Intrinsics.areEqual(getOldHiddenToolbarList(), CollectionsKt.toList(this.customToolbarView.getHiddenToolbarItemList()));
    }

    private final boolean isToolbarOrderUpdated() {
        return !Intrinsics.areEqual(this.oldToolbarList, CollectionsKt.toList(this.customToolbarView.getToolbarDisplayList()));
    }

    private final boolean isVisibleToolbarUpdated() {
        return !Intrinsics.areEqual(getOldVisibleToolbarList(), CollectionsKt.toList(this.customToolbarView.getVisibleToolbarItemList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMove$lambda$2(CustomToolbarItemTouchHelperCallback customToolbarItemTouchHelperCallback, int i, int i2) {
        customToolbarItemTouchHelperCallback.customToolbarView.onItemMove(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSelectedChanged$lambda$4(RecyclerView.ViewHolder viewHolder) {
        ((CustomToolbarItemHolder) viewHolder).setBackground(4);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    @SuppressLint({"NotifyDataSetChanged"})
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.clearView(recyclerView, viewHolder);
        recyclerView.removeCallbacks(this.scrollRunnable);
        recyclerView.post(new RunnableC8515c(this, viewHolder, 10));
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        int absoluteAdapterPosition2 = target.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition == -1 || absoluteAdapterPosition2 == -1) {
            return false;
        }
        recyclerView.post(new RunnableC0117b(this, absoluteAdapterPosition, absoluteAdapterPosition2, 4));
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        AbstractC6670b.m4736A(actionState, "onSelectedChanged# actionState ", TAG);
        RecyclerView recyclerView = this.customToolbarView.getRecyclerView();
        if (actionState == 0) {
            if (viewHolder instanceof CustomToolbarItemHolder) {
                insertSALogging(((CustomToolbarItemHolder) viewHolder).getName());
            }
        } else {
            if (actionState != 2) {
                return;
            }
            this.currentDraggingView = viewHolder != null ? viewHolder.itemView : null;
            recyclerView.post(this.scrollRunnable);
            if (viewHolder instanceof CustomToolbarItemHolder) {
                recyclerView.post(new RunnableC8669a((CustomToolbarItemHolder) viewHolder, 6));
            }
            this.oldToolbarList = CollectionsKt.toList(this.customToolbarView.getToolbarDisplayList());
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }
}
