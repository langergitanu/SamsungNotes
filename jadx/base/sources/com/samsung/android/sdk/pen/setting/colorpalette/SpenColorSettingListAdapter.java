package com.samsung.android.sdk.pen.setting.colorpalette;

import android.R;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.LayoutRes;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsCheckBox;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 '2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002'(B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingItem;", "context", "Landroid/content/Context;", "mResource", "", "objects", "", "<init>", "(Landroid/content/Context;ILjava/util/List;)V", "childIds", "", "mColorTheme", "mColorStateList", "Landroid/content/res/ColorStateList;", "mNormalItemResource", "mTransparentItemResource", "getItemId", "", "position", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "setColorTheme", "", BaseWidgetConstant.WIDGET_THEME, "setItemBackgroundResource", "normalResource", "transparentResources", "setView", "viewHolder", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListAdapter$ViewHolder;", "setColor", "view", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorChipView;", "color", "Companion", "ViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenColorSettingListAdapter extends ArrayAdapter<SpenColorSettingItem> {

    @NotNull
    private static final String TAG = "SpenColorSettingListAdapter";

    @NotNull
    private final int[] childIds;

    @NotNull
    private final ColorStateList mColorStateList;
    private int mColorTheme;
    private int mNormalItemResource;
    private final int mResource;
    private int mTransparentItemResource;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListAdapter$ViewHolder;", "", "<init>", "()V", "mCheckBox", "Landroid/widget/CheckBox;", "getMCheckBox", "()Landroid/widget/CheckBox;", "setMCheckBox", "(Landroid/widget/CheckBox;)V", "mContainer", "Landroid/view/View;", "getMContainer", "()Landroid/view/View;", "setMContainer", "(Landroid/view/View;)V", "mColor", "", "getMColor", "()[Landroid/view/View;", "setMColor", "([Landroid/view/View;)V", "[Landroid/view/View;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ViewHolder {

        @Nullable
        private CheckBox mCheckBox;

        @NotNull
        private View[] mColor = new View[8];

        @Nullable
        private View mContainer;

        @Nullable
        public final CheckBox getMCheckBox() {
            return this.mCheckBox;
        }

        @NotNull
        public final View[] getMColor() {
            return this.mColor;
        }

        @Nullable
        public final View getMContainer() {
            return this.mContainer;
        }

        public final void setMCheckBox(@Nullable CheckBox checkBox) {
            this.mCheckBox = checkBox;
        }

        public final void setMColor(@NotNull View[] viewArr) {
            Intrinsics.checkNotNullParameter(viewArr, "<set-?>");
            this.mColor = viewArr;
        }

        public final void setMContainer(@Nullable View view) {
            this.mContainer = view;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorSettingListAdapter(@NotNull Context context, @LayoutRes int i, @NotNull List<SpenColorSettingItem> objects) {
        super(context, i, objects);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objects, "objects");
        this.mResource = i;
        this.childIds = new int[]{C7932R.id.setting_pen_color_view_1, C7932R.id.setting_pen_color_view_2, C7932R.id.setting_pen_color_view_3, C7932R.id.setting_pen_color_view_4, C7932R.id.setting_pen_color_view_5, C7932R.id.setting_pen_color_view_6, C7932R.id.setting_pen_color_view_7, C7932R.id.setting_pen_color_view_8};
        this.mColorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{R.attr.state_checked}}, new int[]{-863006833, SpenSettingUtil.getPrimaryColor(context)});
    }

    private final void setColor(SpenColorChipView view, int color) {
        if (view == null) {
            return;
        }
        view.setColorResource(this.mNormalItemResource);
        view.setTransparentBackgroundResource(this.mTransparentItemResource);
        view.setColor(color);
    }

    private final void setView(int position, ViewHolder viewHolder) {
        SpenColorSettingItem item = getItem(position);
        if (item == null) {
            return;
        }
        int[] colors = this.mColorTheme == 0 ? item.getColors() : item.getVisibleColors();
        String[] names = item.getNames();
        if (colors.length < viewHolder.getMColor().length) {
            Log.i(TAG, "Not enough Color.");
            return;
        }
        int length = viewHolder.getMColor().length;
        for (int i = 0; i < length; i++) {
            setColor((SpenColorChipView) viewHolder.getMColor()[i], colors[i]);
        }
        CheckBox mCheckBox = viewHolder.getMCheckBox();
        if (mCheckBox != null) {
            mCheckBox.setChecked(item.getIsUsed());
        }
        StringBuilder sb = new StringBuilder(getContext().getResources().getString(C7932R.string.pen_string_palette_is, Integer.valueOf(position + 1)));
        sb.append(",");
        for (String str : names) {
            sb.append(" " + str);
        }
        View mContainer = viewHolder.getMContainer();
        if (mContainer != null) {
            mContainer.setContentDescription(sb.toString());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        if (convertView == null) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(this.mResource, parent, false);
            viewInflate.setBackground(null);
            if (SpenSettingUtil.needRecoilVI()) {
                viewInflate.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, C7932R.animator.spen_recoil_list_selector));
            }
            CheckBox checkBox = new CheckBox(context);
            checkBox.setClickable(false);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setFocusable(false);
            checkBox.setBackground(null);
            checkBox.setButtonTintList(this.mColorStateList);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.color_setting_popup_checkbox_size);
            View viewFindViewById = viewInflate.findViewById(C7932R.id.item_content);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewFindViewById;
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.addRule(15, -1);
                viewGroup.addView(checkBox, 0, layoutParams);
            } else {
                viewGroup.addView(checkBox, 1);
            }
            ViewHolder viewHolder2 = new ViewHolder();
            viewHolder2.setMCheckBox(checkBox);
            viewHolder2.setMContainer(viewInflate);
            for (int i = 0; i < 8; i++) {
                viewHolder2.getMColor()[i] = viewInflate.findViewById(this.childIds[i]);
            }
            viewInflate.setTag(viewHolder2);
            view = viewInflate;
            viewHolder = viewHolder2;
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingListAdapter.ViewHolder");
            view = convertView;
            viewHolder = (ViewHolder) tag;
        }
        View mContainer = viewHolder.getMContainer();
        if (mContainer != null) {
            mContainer.setAccessibilityDelegate(new SpenVoiceAssistantAsCheckBox(viewHolder.getMCheckBox()));
        }
        setView(position, viewHolder);
        Intrinsics.checkNotNull(view);
        return view;
    }

    public final void setColorTheme(int theme) {
        this.mColorTheme = theme;
    }

    public final void setItemBackgroundResource(int normalResource, int transparentResources) {
        this.mNormalItemResource = normalResource;
        this.mTransparentItemResource = transparentResources;
    }
}
