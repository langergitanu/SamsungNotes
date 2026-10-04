package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.widget.ListPopupWindowCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatTypeListWindow {
    private static final String TAG = Logger.createTag("AiMenuResultViewRecognizedHw", AiConstants.PREFIX_TAG);
    AutoFormat.FormatType mCurrentFormatType;
    boolean mIsSimpleType;
    ListPopupWindow mListPopupWindow;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemClickListener {
        void onItemClick(AutoFormat.FormatType formatType);
    }

    public AutoFormatTypeListWindow() {
        this.mIsSimpleType = false;
    }

    public ListPopupWindow getListPopupWindow() {
        return this.mListPopupWindow;
    }

    public void hide() {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        if (listPopupWindow == null || !listPopupWindow.isShowing()) {
            return;
        }
        this.mListPopupWindow.dismiss();
    }

    public void initAutoFormatTypeListWindow(View view, final OnItemClickListener onItemClickListener) {
        PopupWindow popupWindowSeslGetPopupWindow;
        if (isInitialized()) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        final Context context = view.getContext();
        final List listAsList = Arrays.asList(AutoFormat.FormatType.Normal, AutoFormat.FormatType.Meeting);
        ArrayAdapter<AutoFormat.FormatType> arrayAdapter = new ArrayAdapter<AutoFormat.FormatType>(context, C9086R.layout.ai_menu_auto_format_type_item, listAsList) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypeListWindow.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_auto_format_type_item, (ViewGroup) null);
                }
                if (AutoFormatTypeListWindow.this.mIsSimpleType) {
                    view2.setMinimumWidth(0);
                }
                TextView textView = (TextView) view2.findViewById(C9086R.id.ai_menu_auto_format_type_item_text);
                AutoFormat.FormatType formatType = (AutoFormat.FormatType) getItem(i);
                textView.setText(formatType.getStrRes());
                if (formatType.equals(AutoFormatTypeListWindow.this.mCurrentFormatType)) {
                    int color = context.getColor(C9086R.color.ai_menu_check_color);
                    textView.setTextColor(color);
                    textView.setTypeface(textView.getTypeface(), 1);
                    ImageView imageView = (ImageView) view2.findViewById(C9086R.id.ai_menu_auto_format_type_item_check);
                    imageView.setColorFilter(color);
                    imageView.setVisibility(0);
                }
                if (i == 0) {
                    view2.setPadding(view2.getPaddingLeft(), view2.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_top_bottom_padding), view2.getPaddingRight(), view2.getPaddingBottom());
                    return view2;
                }
                if (i == getCount() - 1) {
                    view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), view2.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_context_top_bottom_padding));
                }
                return view2;
            }
        };
        int iMeasureContentWidth = ViewUtil.measureContentWidth(context, arrayAdapter);
        ListPopupWindow listPopupWindow = new ListPopupWindow(view.getContext());
        this.mListPopupWindow = listPopupWindow;
        listPopupWindow.setAdapter(arrayAdapter);
        this.mListPopupWindow.setAnchorView(view);
        if (this.mIsSimpleType) {
            this.mListPopupWindow.setWidth(iMeasureContentWidth);
            this.mListPopupWindow.setVerticalOffset((-view.getMeasuredHeight()) + ((int) ResourceUtils.convertDpToPixel(view.getContext(), 6.0f)));
        } else {
            this.mListPopupWindow.setWidth(Math.max(measuredWidth, iMeasureContentWidth));
            this.mListPopupWindow.setHorizontalOffset((int) ResourceUtils.convertDpToPixel(view.getContext(), 12.0f));
            this.mListPopupWindow.setVerticalOffset((-view.getMeasuredHeight()) - ((int) ResourceUtils.convertDpToPixel(view.getContext(), 12.0f)));
        }
        this.mListPopupWindow.setDropDownGravity(8388613);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setInputMethodMode(2);
        this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypeListWindow.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                onItemClickListener.onItemClick((AutoFormat.FormatType) listAsList.get(i));
                AutoFormatTypeListWindow.this.hide();
            }
        });
        if (FeatureInfo.isSupportBackgroundBlurDialog()) {
            BackgroundColorUtil.setBlurInfoPopup(context, this.mListPopupWindow.getListView());
        } else {
            this.mListPopupWindow.setBackgroundDrawable(context.getDrawable(C9086R.drawable.ai_menu_toolbar_bg));
        }
        if (DeviceInfo.isVSTModel() || (popupWindowSeslGetPopupWindow = ListPopupWindowCompat.getInstance().seslGetPopupWindow(this.mListPopupWindow)) == null) {
            return;
        }
        popupWindowSeslGetPopupWindow.setElevation(ResourceUtils.convertDpToPixel(context, 5.0f));
    }

    public boolean isInitialized() {
        return this.mListPopupWindow != null;
    }

    public boolean isShowing() {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        return listPopupWindow != null && listPopupWindow.isShowing();
    }

    public void setCurrentFormatType(AutoFormat.FormatType formatType) {
        this.mCurrentFormatType = formatType;
    }

    public void show(AutoFormat.FormatType formatType) {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        if (listPopupWindow == null || listPopupWindow.isShowing()) {
            return;
        }
        this.mCurrentFormatType = formatType;
        this.mListPopupWindow.show();
    }

    public AutoFormatTypeListWindow(boolean z) {
        this.mIsSimpleType = z;
    }
}
