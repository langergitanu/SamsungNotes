package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpicker.C7543e;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.presenter.ToolbarContract;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020$J\b\u0010(\u001a\u00020\"H\u0002J\u000e\u0010)\u001a\u00020\"2\u0006\u0010'\u001a\u00020$J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0003J\b\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0011*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0011*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "view", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;)V", "getView", "()Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mHolderLayout", "kotlin.jvm.PlatformType", "mIcon", "Landroid/widget/ImageView;", "mIcon2", "mTitleLayout", "Landroid/view/ViewGroup;", "mTitle", "Landroid/widget/TextView;", "mExpand", "mReorder", "itemResource", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarItem$ItemResource;", "adapterContract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/presenter/ToolbarContract$IAdapter;", "listPopupWindow", "Landroidx/appcompat/widget/ListPopupWindow;", "setBackground", "", "bgType", "", "decorate", "itemName", "pos", "updateReorder", "updateBackground", "setPopupListContract", "initListPopupWindow", "showPopup", "hidePopup", "updateIcon", "updateTitle", "adapters", "Landroid/widget/ArrayAdapter;", "getAdapters", "()Landroid/widget/ArrayAdapter;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public final class CustomToolbarItemHolder extends RecyclerView.ViewHolder {
    public static final int ITEM_BACKGROUND_NORMAL = 0;
    public static final int ITEM_BACKGROUND_ROUND = 1;
    public static final int ITEM_BACKGROUND_ROUND_BOTTOM = 3;
    public static final int ITEM_BACKGROUND_ROUND_TOP = 2;
    public static final int ITEM_BACKGROUND_SELECTED = 4;

    @NotNull
    private static final String TAG = "CustomToolbarItemHolder";

    @Nullable
    private ToolbarContract.IAdapter adapterContract;
    private CustomToolbarItem.ItemResource itemResource;

    @Nullable
    private ListPopupWindow listPopupWindow;
    private final View mExpand;
    private final View mHolderLayout;
    private final ImageView mIcon;
    private final ImageView mIcon2;

    @NotNull
    private final View mReorder;
    private final TextView mTitle;
    private final ViewGroup mTitleLayout;
    public String name;

    @NotNull
    private final CustomToolbarView view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbarItemHolder(@NotNull View itemView, @NotNull CustomToolbarView view) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.mHolderLayout = itemView.findViewById(C8003R.id.toolbar_item_holder);
        this.mIcon = (ImageView) itemView.findViewById(C8003R.id.custom_toolbar_menu_icon);
        this.mIcon2 = (ImageView) itemView.findViewById(C8003R.id.custom_toolbar_menu_icon2);
        this.mTitleLayout = (ViewGroup) itemView.findViewById(C8003R.id.toolbar_title_container);
        this.mTitle = (TextView) itemView.findViewById(C8003R.id.toolbar_title);
        this.mExpand = itemView.findViewById(C8003R.id.toolbar_expand_icon);
        View viewFindViewById = itemView.findViewById(C8003R.id.reorder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mReorder = viewFindViewById;
        viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(CustomToolbarItemHolder customToolbarItemHolder, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return true;
        }
        customToolbarItemHolder.view.onReorderTouch(customToolbarItemHolder);
        return true;
    }

    private final ArrayAdapter<String> getAdapters() {
        final Context context = this.mTitle.getContext();
        final int i = C8003R.layout.toolbar_droplist_item;
        ToolbarContract.IAdapter iAdapter = this.adapterContract;
        Intrinsics.checkNotNull(iAdapter);
        final String[] contentDescriptions = iAdapter.getContentDescriptions();
        Intrinsics.checkNotNull(contentDescriptions);
        return new ArrayAdapter<String>(context, i, contentDescriptions) { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemHolder$adapters$1
            private View checkImage;
            private ImageView contentImage;

            public final View getCheckImage() {
                return this.checkImage;
            }

            public final ImageView getContentImage() {
                return this.contentImage;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                if (convertView == null) {
                    convertView = LayoutInflater.from(this.this$0.mTitle.getContext()).inflate(C8003R.layout.toolbar_droplist_item, (ViewGroup) null);
                    this.contentImage = (ImageView) convertView.findViewById(C8003R.id.content_image);
                    this.checkImage = convertView.findViewById(C8003R.id.check_image);
                }
                ImageView imageView = this.contentImage;
                Intrinsics.checkNotNull(imageView);
                ToolbarContract.IAdapter iAdapter2 = this.this$0.adapterContract;
                Intrinsics.checkNotNull(iAdapter2);
                imageView.setImageResource(iAdapter2.getDrawableIconId(position));
                ToolbarContract.IAdapter iAdapter3 = this.this$0.adapterContract;
                Intrinsics.checkNotNull(iAdapter3);
                if (iAdapter3.getSelectedItem() == position) {
                    View view = this.checkImage;
                    Intrinsics.checkNotNull(view);
                    view.setVisibility(0);
                } else {
                    View view2 = this.checkImage;
                    Intrinsics.checkNotNull(view2);
                    view2.setVisibility(4);
                }
                Intrinsics.checkNotNull(convertView);
                convertView.setContentDescription(getItem(position));
                return convertView;
            }

            public final void setCheckImage(View view) {
                this.checkImage = view;
            }

            public final void setContentImage(ImageView imageView) {
                this.contentImage = imageView;
            }
        };
    }

    private final void hidePopup() {
        ListPopupWindow listPopupWindow = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow);
        if (listPopupWindow.isShowing()) {
            ListPopupWindow listPopupWindow2 = this.listPopupWindow;
            Intrinsics.checkNotNull(listPopupWindow2);
            listPopupWindow2.dismiss();
        }
        this.listPopupWindow = null;
    }

    @SuppressLint({"RestrictedApi"})
    private final void initListPopupWindow() {
        if (this.listPopupWindow != null) {
            return;
        }
        this.listPopupWindow = new ListPopupWindow(this.mTitle.getContext());
        ArrayAdapter<String> adapters = getAdapters();
        ListPopupWindow listPopupWindow = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow);
        listPopupWindow.setAdapter(adapters);
        ListPopupWindow listPopupWindow2 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow2);
        listPopupWindow2.setOnItemClickListener(new C7543e(this, 1));
        ListPopupWindow listPopupWindow3 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow3);
        listPopupWindow3.setAnchorView(this.mExpand);
        ListPopupWindow listPopupWindow4 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow4);
        listPopupWindow4.setModal(true);
        ListPopupWindow listPopupWindow5 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow5);
        listPopupWindow5.setDropDownGravity(8388691);
        ListPopupWindow listPopupWindow6 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow6);
        listPopupWindow6.setOverlapAnchor(true);
        ListPopupWindow listPopupWindow7 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow7);
        listPopupWindow7.setInputMethodMode(2);
        ListPopupWindow listPopupWindow8 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow8);
        ToolbarContract.IAdapter iAdapter = this.adapterContract;
        Intrinsics.checkNotNull(iAdapter);
        Activity activity = iAdapter.getActivity();
        ListPopupWindow listPopupWindow9 = this.listPopupWindow;
        Intrinsics.checkNotNull(listPopupWindow9);
        listPopupWindow8.setWidth(ViewUtil.measureContentWidth(activity, adapters, listPopupWindow9.getListView()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListPopupWindow$lambda$3(CustomToolbarItemHolder customToolbarItemHolder, AdapterView adapterView, View view, int i, long j) {
        AbstractC8014b.m7201c(i, "onItemClick ", TAG);
        ToolbarContract.IAdapter iAdapter = customToolbarItemHolder.adapterContract;
        Intrinsics.checkNotNull(iAdapter);
        iAdapter.setSelectedItem(i);
        customToolbarItemHolder.updateIcon();
        customToolbarItemHolder.hidePopup();
    }

    private final void setPopupListContract() {
        if (Intrinsics.areEqual("QuickColor", getName())) {
            this.adapterContract = this.view.getQuickColorAdapterContract();
            this.mExpand.setVisibility(0);
            final int i = 0;
            this.mTitleLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CustomToolbarItemHolder f6298b;

                {
                    this.f6298b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            CustomToolbarItemHolder.setPopupListContract$lambda$1(this.f6298b, view);
                            break;
                        default:
                            CustomToolbarItemHolder.setPopupListContract$lambda$2(this.f6298b, view);
                            break;
                    }
                }
            });
            return;
        }
        if (!Intrinsics.areEqual("QuickSize", getName())) {
            this.adapterContract = null;
            this.mExpand.setVisibility(8);
            this.mTitleLayout.setOnClickListener(null);
        } else {
            this.adapterContract = this.view.getQuickSizeAdapterContract();
            this.mExpand.setVisibility(0);
            final int i2 = 1;
            this.mTitleLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.settings.detail.customizetoolbar.view.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CustomToolbarItemHolder f6298b;

                {
                    this.f6298b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            CustomToolbarItemHolder.setPopupListContract$lambda$1(this.f6298b, view);
                            break;
                        default:
                            CustomToolbarItemHolder.setPopupListContract$lambda$2(this.f6298b, view);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPopupListContract$lambda$1(CustomToolbarItemHolder customToolbarItemHolder, View view) {
        MainLogger.m7258i(TAG, "onClick QuickColor");
        customToolbarItemHolder.showPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPopupListContract$lambda$2(CustomToolbarItemHolder customToolbarItemHolder, View view) {
        MainLogger.m7258i(TAG, "onClick QuickSize");
        customToolbarItemHolder.showPopup();
    }

    private final void showPopup() {
        initListPopupWindow();
        try {
            ListPopupWindow listPopupWindow = this.listPopupWindow;
            Intrinsics.checkNotNull(listPopupWindow);
            if (listPopupWindow.isShowing()) {
                ListPopupWindow listPopupWindow2 = this.listPopupWindow;
                Intrinsics.checkNotNull(listPopupWindow2);
                listPopupWindow2.dismiss();
            }
            ListPopupWindow listPopupWindow3 = this.listPopupWindow;
            Intrinsics.checkNotNull(listPopupWindow3);
            listPopupWindow3.show();
        } catch (WindowManager.BadTokenException e) {
            AbstractC6670b.m4738C("showPopup# ", e.getMessage(), TAG);
        }
    }

    private final void updateIcon() {
        ToolbarContract.IAdapter iAdapter = this.adapterContract;
        if (iAdapter != null) {
            ImageView imageView = this.mIcon;
            Intrinsics.checkNotNull(iAdapter);
            ToolbarContract.IAdapter iAdapter2 = this.adapterContract;
            Intrinsics.checkNotNull(iAdapter2);
            imageView.setImageResource(iAdapter.getDrawableIconId(iAdapter2.getSelectedItem()));
        } else {
            ImageView imageView2 = this.mIcon;
            Resources resources = imageView2.getResources();
            CustomToolbarItem.ItemResource itemResource = this.itemResource;
            if (itemResource == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemResource");
                itemResource = null;
            }
            imageView2.setImageDrawable(ResourcesCompat.getDrawable(resources, itemResource.getIconId(), null));
        }
        if (Intrinsics.areEqual(getName(), "Style") || Intrinsics.areEqual(getName(), "QuickColor") || Intrinsics.areEqual(getName(), "QuickSize")) {
            this.mIcon.setColorFilter((ColorFilter) null);
        } else {
            this.mIcon.setColorFilter(this.mIcon.getResources().getColor(C8003R.color.rich_text_toolbar_image, null));
        }
        if (!Intrinsics.areEqual(getName(), "LaserPen")) {
            this.mIcon2.setVisibility(8);
        } else {
            this.mIcon2.setImageDrawable(ResourcesCompat.getDrawable(this.mIcon.getResources(), C8003R.drawable.comp_hw_toolbar_ic_laser_pen_color_rainbow, null));
            this.mIcon2.setVisibility(0);
        }
    }

    private final void updateReorder() {
        Resources resources = this.mReorder.getResources();
        CustomToolbarItem.ItemResource itemResource = this.itemResource;
        if (itemResource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemResource");
            itemResource = null;
        }
        String string = resources.getString(itemResource.getNameId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = this.mReorder.getResources().getString(C8003R.string.reorder_folder);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str = string + " " + string2;
        this.mReorder.setContentDescription(str);
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mReorder, str);
    }

    private final void updateTitle() {
        Context context = this.mTitle.getContext();
        TextView textView = this.mTitle;
        CustomToolbarItem.ItemResource itemResource = this.itemResource;
        if (itemResource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemResource");
            itemResource = null;
        }
        textView.setText(context.getString(itemResource.getNameId()));
    }

    public final void decorate(@NotNull String itemName, int pos) {
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        CustomToolbarItem.ItemResource itemResource = CustomToolbarItem.INSTANCE.getItemMap().get(itemName);
        if (itemResource == null) {
            return;
        }
        setName(itemName);
        this.itemResource = itemResource;
        updateBackground(pos);
        setPopupListContract();
        updateIcon();
        updateTitle();
        updateReorder();
    }

    @NotNull
    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    @NotNull
    public final CustomToolbarView getView() {
        return this.view;
    }

    public final void setBackground(int bgType) {
        Context context = this.mHolderLayout.getContext();
        this.mHolderLayout.setBackground(bgType != 0 ? bgType != 1 ? bgType != 2 ? bgType != 3 ? bgType != 4 ? ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg) : ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg_selected) : ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg_bottom) : ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg_top) : ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg_round) : ContextCompat.getDrawable(context, C8003R.drawable.custom_toolbar_list_item_bg));
        if (bgType == 4) {
            this.mHolderLayout.setElevation(TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
        } else {
            this.mHolderLayout.setElevation(0.0f);
        }
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void updateBackground(int pos) {
        int deletionMarkerIndex = this.view.getDeletionMarkerIndex();
        int size = this.view.getToolbarDisplayList().size();
        if (pos == 0 || pos == deletionMarkerIndex + 1) {
            if (pos == deletionMarkerIndex - 1 || pos == size - 1) {
                setBackground(1);
                return;
            } else {
                setBackground(2);
                return;
            }
        }
        if (pos == deletionMarkerIndex - 1 || pos == size - 1) {
            setBackground(3);
        } else {
            setBackground(0);
        }
    }
}
