package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.CustomToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItem;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 P2\u00020\u0001:\u0001PB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u0002042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001e0&H\u0002J\b\u00107\u001a\u000204H\u0007J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\"H\u0002J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?J\u0016\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"J\u0016\u0010C\u001a\u0002042\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"J\u000e\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\u0017J\u0006\u0010H\u001a\u000204J\u0006\u0010I\u001a\u000204R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&8F¢\u0006\u0006\u001a\u0004\b'\u0010 R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0&8F¢\u0006\u0006\u001a\u0004\b)\u0010 R\u001a\u0010*\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010,\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u0011\u0010.\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b.\u0010\u0018R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bO\u0010M¨\u0006Q"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "presenter", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter;", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/CustomToolbarPresenter;)V", "previewView", "Landroid/view/ViewGroup;", "customToolbarAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "kotlin.jvm.PlatformType", "previewDivider", "isDragging", "", "()Z", "setDragging", "(Z)V", "isTabletLayout", "toolbarDisplayList", "", "", "getToolbarDisplayList", "()Ljava/util/List;", "deletionMarkerIndex", "", "getDeletionMarkerIndex", "()I", "hiddenToolbarItemList", "", "getHiddenToolbarItemList", "visibleToolbarItemList", "getVisibleToolbarItemList", "isQuickColorVisibleInTablet", "setQuickColorVisibleInTablet", "isQuickSizeVisibleInTablet", "setQuickSizeVisibleInTablet", "isDefaultState", "itemTouchHelperCallback", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemTouchHelperCallback;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "reset", "", "updateToolbarDisplayList", "toolbarList", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "applyPreview", "updateBottomSpace", "convertDpToPixel", "", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "onReorderTouch", "holder", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemHolder;", "onItemMove", "fromPos", "toPos", "scrollBy", "dx", "dy", "onLayoutTypeChanged", "isTablet", "onSharedPreferenceChanged", "saveOrderListToSharedPreference", "quickColorAdapterContract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/ToolbarContract$IAdapter;", "getQuickColorAdapterContract", "()Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/ToolbarContract$IAdapter;", "quickSizeAdapterContract", "getQuickSizeAdapterContract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCustomToolbarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomToolbarView.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,360:1\n756#2,10:361\n967#2,7:371\n774#2:381\n865#2,2:382\n967#2,7:384\n756#2,10:391\n1332#3,3:378\n*S KotlinDebug\n*F\n+ 1 CustomToolbarView.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView\n*L\n45#1:361,10\n49#1:371,7\n245#1:381\n245#1:382,2\n252#1:384,7\n253#1:391,10\n108#1:378,3\n*E\n"})
public final class CustomToolbarView {

    @NotNull
    public static final String DELETION_MARKER = "DELETION_MARKER";
    private static final int QUICK_COLOR_DELTA_POSITION_COUNT = 3;
    private static final int QUICK_SIZE_DELTA_POSITION_COUNT = 1;

    @NotNull
    private static final String TAG = "CustomToolbarView";

    @NotNull
    private final Activity activity;

    @NotNull
    private final CustomToolbarAdapter customToolbarAdapter;
    private boolean isDragging;
    private boolean isQuickColorVisibleInTablet;
    private boolean isQuickSizeVisibleInTablet;
    private boolean isTabletLayout;

    @NotNull
    private final ItemTouchHelper itemTouchHelper;

    @NotNull
    private final CustomToolbarItemTouchHelperCallback itemTouchHelperCallback;

    @NotNull
    private final CustomToolbarPresenter presenter;
    private final View previewDivider;

    @NotNull
    private final ViewGroup previewView;

    @NotNull
    private final RecyclerView recyclerView;
    private final NestedScrollView scrollView;

    @NotNull
    private final List<String> toolbarDisplayList;

    public CustomToolbarView(@NotNull Activity activity, @NotNull View rootView, @NotNull CustomToolbarPresenter presenter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.activity = activity;
        this.presenter = presenter;
        View viewFindViewById = rootView.findViewById(C8003R.id.mutable_toolbar_preview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.previewView = (ViewGroup) viewFindViewById;
        Context baseContext = activity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
        CustomToolbarAdapter customToolbarAdapter = new CustomToolbarAdapter(baseContext, this);
        this.customToolbarAdapter = customToolbarAdapter;
        View viewFindViewById2 = rootView.findViewById(C8003R.id.custom_toolbar_recyclerview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        this.recyclerView = recyclerView;
        this.scrollView = (NestedScrollView) rootView.findViewById(C8003R.id.nested_scroll_view);
        this.previewDivider = rootView.findViewById(C8003R.id.toolbar_divider);
        this.toolbarDisplayList = new ArrayList();
        this.isQuickColorVisibleInTablet = true;
        this.isQuickSizeVisibleInTablet = true;
        CustomToolbarItemTouchHelperCallback customToolbarItemTouchHelperCallback = new CustomToolbarItemTouchHelperCallback(this);
        this.itemTouchHelperCallback = customToolbarItemTouchHelperCallback;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(customToolbarItemTouchHelperCallback);
        this.itemTouchHelper = itemTouchHelper;
        this.isTabletLayout = presenter.isTabletLayout();
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setBackgroundColor(activity.getResources().getColor(C8003R.color.round_corner_color, null));
        recyclerView.seslSetGoToTopEnabled(true);
        recyclerView.seslSetHoverBottomPadding(WidgetInsetUtils.INSTANCE.getSettingInsetsBottom());
        recyclerView.setAdapter(customToolbarAdapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        updateToolbarDisplayList(presenter.getToolbarDisplayList());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void applyPreview() {
        List<String> visibleToolbarItemList = getVisibleToolbarItemList();
        int size = visibleToolbarItemList.size() - this.previewView.getChildCount();
        for (int i = 0; i < size; i++) {
            this.activity.getLayoutInflater().inflate(C8003R.layout.settings_customize_toolbar_preview_item, this.previewView);
        }
        int i2 = 0;
        for (View view : ViewGroupKt.getChildren(this.previewView)) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            ImageView imageView = (ImageView) view2.findViewById(C8003R.id.preview_icon);
            ImageView imageView2 = (ImageView) view2.findViewById(C8003R.id.preview_icon2);
            Resources resources = imageView.getResources();
            if (i2 < visibleToolbarItemList.size()) {
                String str = visibleToolbarItemList.get(i2);
                CustomToolbarItem.ItemResource itemResource = CustomToolbarItem.INSTANCE.getItemMap().get(str);
                if (itemResource == null) {
                    return;
                }
                int iconId = itemResource.getIconId();
                String string = imageView.getContext().getString(itemResource.getNameId());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                int iHashCode = str.hashCode();
                if (iHashCode == -990258322) {
                    if (str.equals("QuickSize")) {
                        int quickSizeCount = this.presenter.getQuickSizeCount();
                        iconId = quickSizeCount != 1 ? quickSizeCount != 2 ? C8003R.drawable.settings_toolbar_list_ic_quick_size_3 : C8003R.drawable.settings_toolbar_list_ic_quick_size_2 : C8003R.drawable.settings_toolbar_list_ic_quick_size_1;
                        imageView.setColorFilter((ColorFilter) null);
                        string = this.activity.getResources().getQuantityString(C8003R.plurals.plural_pen_thicknesses, quickSizeCount, Integer.valueOf(quickSizeCount));
                        Intrinsics.checkNotNullExpressionValue(string, "getQuantityString(...)");
                    }
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iconId, null));
                    imageView.setContentDescription(string);
                    view2.setVisibility(0);
                    if (Intrinsics.areEqual(str, "LaserPen")) {
                    }
                } else if (iHashCode != -647847530) {
                    if (iHashCode == 80227729 && str.equals("Style")) {
                        imageView.setColorFilter((ColorFilter) null);
                    } else {
                        imageView.setColorFilter(imageView.getResources().getColor(C8003R.color.rich_text_toolbar_image, null));
                    }
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iconId, null));
                    imageView.setContentDescription(string);
                    view2.setVisibility(0);
                    if (Intrinsics.areEqual(str, "LaserPen")) {
                        imageView2.setImageDrawable(ResourcesCompat.getDrawable(resources, C8003R.drawable.comp_hw_toolbar_ic_laser_pen_color_rainbow, null));
                        imageView2.setVisibility(0);
                    } else {
                        imageView2.setVisibility(8);
                    }
                } else {
                    if (str.equals("QuickColor")) {
                        int quickColorCount = this.presenter.getQuickColorCount();
                        iconId = quickColorCount != 3 ? quickColorCount != 4 ? C8003R.drawable.settings_toolbar_list_ic_quick_color_5 : C8003R.drawable.settings_toolbar_list_ic_quick_color_4 : C8003R.drawable.settings_toolbar_list_ic_quick_color_3;
                        imageView.setColorFilter((ColorFilter) null);
                        string = this.activity.getResources().getQuantityString(C8003R.plurals.plural_pen_colors, quickColorCount, Integer.valueOf(quickColorCount));
                        Intrinsics.checkNotNullExpressionValue(string, "getQuantityString(...)");
                    }
                    imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iconId, null));
                    imageView.setContentDescription(string);
                    view2.setVisibility(0);
                    if (Intrinsics.areEqual(str, "LaserPen")) {
                    }
                }
            } else {
                imageView.setImageDrawable(null);
                imageView.setContentDescription(null);
                view2.setVisibility(8);
            }
            i2 = i4;
        }
        if (this.isTabletLayout) {
            View view3 = this.previewDivider;
            if (view3 != null) {
                view3.setVisibility(0);
                return;
            }
            return;
        }
        View view4 = this.previewDivider;
        if (view4 != null) {
            view4.setVisibility(8);
        }
    }

    private final float convertDpToPixel(int dp) {
        return (this.activity.getResources().getDisplayMetrics().densityDpi / 160) * dp;
    }

    private final void updateBottomSpace() {
        int iConvertDpToPixel = (int) (ResourceUtils.isTabletLayout(this.activity) ? convertDpToPixel(160) : convertDpToPixel(120));
        int dimensionPixelSize = this.activity.getResources().getDimensionPixelSize(C8003R.dimen.settings_customize_toolbar_item_height);
        int dimensionPixelSize2 = this.activity.getResources().getDimensionPixelSize(C8003R.dimen.settings_customize_toolbar_item_deletion_marker_height);
        if (!getHiddenToolbarItemList().isEmpty()) {
            dimensionPixelSize2 = getHiddenToolbarItemList().size() * dimensionPixelSize;
        }
        int i = iConvertDpToPixel - dimensionPixelSize2;
        if (i < 0) {
            i = 0;
        }
        RecyclerView recyclerView = this.recyclerView;
        recyclerView.setPaddingRelative(recyclerView.getPaddingStart(), this.recyclerView.getPaddingTop(), this.recyclerView.getPaddingEnd(), i);
    }

    private final void updateToolbarDisplayList(List<String> toolbarList) {
        this.toolbarDisplayList.clear();
        this.toolbarDisplayList.addAll(CollectionsKt.distinct(toolbarList));
        update();
    }

    public final int getDeletionMarkerIndex() {
        return this.toolbarDisplayList.indexOf(DELETION_MARKER);
    }

    @NotNull
    public final List<String> getHiddenToolbarItemList() {
        List<String> list = this.toolbarDisplayList;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Object obj : list) {
            if (z) {
                arrayList.add(obj);
            } else if (Intrinsics.areEqual((String) obj, DELETION_MARKER)) {
                arrayList.add(obj);
                z = true;
            }
        }
        return CollectionsKt.drop(arrayList, 1);
    }

    @NotNull
    public final ToolbarContract.IAdapter getQuickColorAdapterContract() {
        return new ToolbarContract.IAdapter() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.CustomToolbarView$quickColorAdapterContract$1
            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public Activity getActivity() {
                return this.this$0.activity;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public String[] getContentDescriptions() {
                int[] intArray = getActivity().getResources().getIntArray(C8003R.array.toolbar_quick_color_description);
                Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
                String[] strArr = new String[intArray.length];
                int length = intArray.length;
                for (int i = 0; i < length; i++) {
                    Resources resources = getActivity().getResources();
                    int i2 = C8003R.plurals.plural_pen_colors;
                    int i4 = intArray[i];
                    strArr[i] = resources.getQuantityString(i2, i4, Integer.valueOf(i4));
                }
                return strArr;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            @SuppressLint({"ResourceType"})
            public int getDrawableIconId(int index) {
                TypedArray typedArrayObtainTypedArray = TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C8003R.array.toolbar_quick_color_list_icon_array);
                Integer numValueOf = typedArrayObtainTypedArray != null ? Integer.valueOf(typedArrayObtainTypedArray.getResourceId(index, -1)) : null;
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return -1;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public int getSelectedItem() {
                return this.this$0.presenter.getQuickColorCount() - 3;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public void setSelectedItem(int i) {
                this.this$0.presenter.setQuickColorCount(i + 3);
            }
        };
    }

    @NotNull
    public final ToolbarContract.IAdapter getQuickSizeAdapterContract() {
        return new ToolbarContract.IAdapter() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.CustomToolbarView$quickSizeAdapterContract$1
            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public Activity getActivity() {
                return this.this$0.activity;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public String[] getContentDescriptions() {
                int[] intArray = getActivity().getResources().getIntArray(C8003R.array.toolbar_quick_size_description);
                Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
                String[] strArr = new String[intArray.length];
                int length = intArray.length;
                for (int i = 0; i < length; i++) {
                    Resources resources = getActivity().getResources();
                    int i2 = C8003R.plurals.plural_pen_thicknesses;
                    int i4 = intArray[i];
                    strArr[i] = resources.getQuantityString(i2, i4, Integer.valueOf(i4));
                }
                return strArr;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            @SuppressLint({"ResourceType"})
            public int getDrawableIconId(int index) {
                TypedArray typedArrayObtainTypedArray = TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C8003R.array.toolbar_quick_size_list_icon_array);
                Integer numValueOf = typedArrayObtainTypedArray != null ? Integer.valueOf(typedArrayObtainTypedArray.getResourceId(index, -1)) : null;
                if (typedArrayObtainTypedArray != null) {
                    typedArrayObtainTypedArray.recycle();
                }
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return -1;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public int getSelectedItem() {
                return this.this$0.presenter.getQuickSizeCount() - 1;
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract.IAdapter
            public void setSelectedItem(int i) {
                this.this$0.presenter.setQuickSizeCount(i + 1);
            }
        };
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @NotNull
    public final List<String> getToolbarDisplayList() {
        return this.toolbarDisplayList;
    }

    @NotNull
    public final List<String> getVisibleToolbarItemList() {
        List<String> list = this.toolbarDisplayList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual((String) obj, DELETION_MARKER)) {
                break;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final boolean isDefaultState() {
        return Intrinsics.areEqual(getVisibleToolbarItemList(), this.presenter.getDefaultToolbarList()) && this.presenter.getQuickColorCount() == 3 && this.presenter.getQuickSizeCount() == 1;
    }

    /* JADX INFO: renamed from: isDragging, reason: from getter */
    public final boolean getIsDragging() {
        return this.isDragging;
    }

    /* JADX INFO: renamed from: isQuickColorVisibleInTablet, reason: from getter */
    public final boolean getIsQuickColorVisibleInTablet() {
        return this.isQuickColorVisibleInTablet;
    }

    /* JADX INFO: renamed from: isQuickSizeVisibleInTablet, reason: from getter */
    public final boolean getIsQuickSizeVisibleInTablet() {
        return this.isQuickSizeVisibleInTablet;
    }

    public final boolean onItemMove(int fromPos, int toPos) {
        if (fromPos == -1 || toPos == -1) {
            return false;
        }
        if (fromPos < toPos) {
            int i = fromPos + 1;
            if (i <= toPos) {
                while (true) {
                    int i2 = i - 1;
                    Collections.swap(this.toolbarDisplayList, i2, i);
                    this.customToolbarAdapter.notifyItemMoved(i2, i);
                    if (i == toPos) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            int i4 = fromPos - 1;
            if (toPos <= i4) {
                while (true) {
                    int i5 = i4 + 1;
                    Collections.swap(this.toolbarDisplayList, i5, i4);
                    this.customToolbarAdapter.notifyItemMoved(i5, i4);
                    if (i4 == toPos) {
                        break;
                    }
                    i4--;
                }
            }
        }
        return true;
    }

    public final void onLayoutTypeChanged(boolean isTablet) {
        if (this.isTabletLayout == isTablet) {
            return;
        }
        this.isTabletLayout = isTablet;
        List<String> toolbarDisplayList = this.presenter.getToolbarDisplayList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : toolbarDisplayList) {
            String str = (String) obj;
            if (!Intrinsics.areEqual(str, "QuickColor") && !Intrinsics.areEqual(str, "QuickSize")) {
                arrayList.add(obj);
            }
        }
        if (!isTablet) {
            updateToolbarDisplayList(arrayList);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (Intrinsics.areEqual((String) obj2, DELETION_MARKER)) {
                break;
            } else {
                arrayList2.add(obj2);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList2);
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        for (Object obj3 : arrayList) {
            if (z) {
                arrayList3.add(obj3);
            } else if (Intrinsics.areEqual((String) obj3, DELETION_MARKER)) {
                arrayList3.add(obj3);
                z = true;
            }
        }
        List mutableList2 = CollectionsKt.toMutableList((Collection) CollectionsKt.drop(arrayList3, 1));
        if (this.isQuickSizeVisibleInTablet) {
            mutableList.add(0, "QuickSize");
        } else {
            mutableList2.add(0, "QuickSize");
        }
        if (this.isQuickColorVisibleInTablet) {
            mutableList.add(0, "QuickColor");
        } else {
            mutableList2.add(0, "QuickColor");
        }
        updateToolbarDisplayList(CollectionsKt.plus((Collection) CollectionsKt.plus((Collection<? extends String>) mutableList, DELETION_MARKER), (Iterable) mutableList2));
    }

    public final void onReorderTouch(@NotNull CustomToolbarItemHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainLogger.m7254d(TAG, "onReorderTouch#");
        if (this.isDragging) {
            MainLogger.m7254d(TAG, "onReorderTouch# Already dragging a item");
        } else {
            this.isDragging = true;
            this.itemTouchHelper.startDrag(holder);
        }
    }

    public final void onSharedPreferenceChanged() {
        updateToolbarDisplayList(this.presenter.getToolbarDisplayList());
    }

    public final void reset() {
        this.isQuickColorVisibleInTablet = true;
        this.isQuickSizeVisibleInTablet = true;
        CommonSamsungAnalytics.INSTANCE.insertLog("234", ComposerSAConstants.EVENT_CUSTOMIZE_TOOLBAR_RESET);
    }

    public final void saveOrderListToSharedPreference() {
        this.presenter.setVisibleToolbarList(CollectionsKt.toList(getVisibleToolbarItemList()));
        this.presenter.setHiddenToolbarList(CollectionsKt.toList(getHiddenToolbarItemList()));
        this.presenter.saveOrderList();
    }

    public final void scrollBy(int dx, int dy) {
        this.recyclerView.scrollBy(dx, dy);
    }

    public final void setDragging(boolean z) {
        this.isDragging = z;
    }

    public final void setQuickColorVisibleInTablet(boolean z) {
        this.isQuickColorVisibleInTablet = z;
    }

    public final void setQuickSizeVisibleInTablet(boolean z) {
        this.isQuickSizeVisibleInTablet = z;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void update() {
        this.customToolbarAdapter.notifyDataSetChanged();
        applyPreview();
        this.presenter.invalidateOptionsMenu();
        updateBottomSpace();
        if (this.isTabletLayout) {
            this.isQuickColorVisibleInTablet = getVisibleToolbarItemList().contains("QuickColor");
            this.isQuickSizeVisibleInTablet = getVisibleToolbarItemList().contains("QuickSize");
        }
    }
}
