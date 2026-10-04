package com.samsung.android.sdk.pen.setting.colorpalette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0003./0B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 J\u0016\u0010!\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 J\u0010\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0010\u0010$\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J.\u0010&\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingLayoutV2;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "swatchList", "", "", "maxSelectCount", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "mListControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListControl;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingLayoutV2$IEventListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingLayoutV2$OnActionListener;", "mSelectItemEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "mListSelectItemEventListener", "mBtnClickListener", "Landroid/view/View$OnClickListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getSelectPaletteList", "", "selectList", "", "setSelectPaletteList", "setOnActionListener", "actionListener", "setOnSelectItemEventListener", "initView", "initListView", "paletteData", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "itemLayoutID", "initBackground", "view", "Landroid/view/ViewGroup;", "sendSelectResult", "Companion", "IEventListener", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenColorSettingLayoutV2 extends FrameLayout {
    private static final int CANCEL_BUTTON = 2;
    private static final int DONE_BUTTON = 1;

    @NotNull
    private static final String TAG = "SpenColorSettingLayoutV2";
    private static final boolean USE_CIRCLE_COLOR_CHIP = true;

    @Nullable
    private OnActionListener mActionListener;

    @NotNull
    private final View.OnClickListener mBtnClickListener;

    @Nullable
    private SpenConsumedListener mConsumedListener;

    @Nullable
    private IEventListener mEventListener;
    private SpenColorSettingListControl mListControl;

    @NotNull
    private final OnSelectItemEventListener mListSelectItemEventListener;

    @Nullable
    private OnSelectItemEventListener mSelectItemEventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingLayoutV2$IEventListener;", "", "onChangeSelected", "", XmlErrorCodes.LIST, "", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface IEventListener {
        void onChangeSelected(@Nullable List<Integer> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingLayoutV2$OnActionListener;", "", "onCancel", "", "OnDone", "count", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void OnDone(int count);

        void onCancel();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorSettingLayoutV2(@NotNull Context context, @NotNull List<Integer> swatchList, int i) {
        super(new ContextThemeWrapper(context, C7932R.style.BasicUITheme));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swatchList, "swatchList");
        this.mListSelectItemEventListener = new OnSelectItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingLayoutV2$mListSelectItemEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemChanged(int position, boolean selected) {
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemChanged(position, selected);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemUnchanged(int position, OnSelectItemEventListener.UnchangedReason reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemUnchanged(position, reason);
                    return;
                }
                SpenColorSettingListControl spenColorSettingListControl = this.this$0.mListControl;
                if (spenColorSettingListControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListControl");
                    spenColorSettingListControl = null;
                }
                spenColorSettingListControl.notifyItemUnchanged(reason);
            }
        };
        this.mBtnClickListener = new ViewOnClickListenerC0157a(this, 28);
        View.inflate(getContext(), C7932R.layout.setting_color_setting_layout_v2, this);
        initView(context);
        initListView(context, SpenPaletteUtil.getDefinedPaletteData(context, swatchList), i, C7932R.layout.setting_color_setting_popup_list_item_v70);
        initBackground(context, this);
    }

    private final void initBackground(Context context, ViewGroup view) {
        view.setElevation(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        view.setBackgroundResource(C7932R.drawable.dialog_bg);
        view.setClipChildren(false);
        SpenSettingUtil.setShadowAlpha(view, 0.5f);
    }

    private final void initListView(Context context, List<SpenColorPaletteData> paletteData, int maxSelectCount, int itemLayoutID) {
        View viewFindViewById = findViewById(C7932R.id.setting_top_divider);
        View viewFindViewById2 = findViewById(C7932R.id.setting_bottom_divider);
        View viewFindViewById3 = findViewById(C7932R.id.palette_list);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ListView");
        SpenColorSettingListControl spenColorSettingListControl = new SpenColorSettingListControl(context, paletteData, maxSelectCount);
        this.mListControl = spenColorSettingListControl;
        spenColorSettingListControl.setListInfo((ListView) viewFindViewById3, viewFindViewById, viewFindViewById2);
        SpenColorSettingListControl spenColorSettingListControl2 = this.mListControl;
        SpenColorSettingListControl spenColorSettingListControl3 = null;
        if (spenColorSettingListControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
            spenColorSettingListControl2 = null;
        }
        spenColorSettingListControl2.setListItemInfo(itemLayoutID, C7932R.drawable.color_circle_shape, C7932R.drawable.blank_stroke_dot_detail);
        SpenColorSettingListControl spenColorSettingListControl4 = this.mListControl;
        if (spenColorSettingListControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
        } else {
            spenColorSettingListControl3 = spenColorSettingListControl4;
        }
        spenColorSettingListControl3.setListSelectItemEventListener(this.mListSelectItemEventListener);
    }

    private final void initView(Context context) {
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        spenConsumedListener.setConsumedListener(this, findViewById(C7932R.id.top_bg));
        findViewById(C7932R.id.top_bg).setClipToOutline(true);
        TextView textView = (TextView) findViewById(C7932R.id.title_text);
        SpenSettingUtilText.FontName fontName = SpenSettingUtilText.FontName.MEDIUM;
        SpenSettingUtilText.setTypeFace(context, fontName, textView);
        SpenSettingUtilText.applyUpToLargeLevel(getContext(), 17.0f, textView);
        String string = context.getResources().getString(C7932R.string.pen_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        View viewFindViewById = findViewById(C7932R.id.done);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        SpenShowButtonShapeText spenShowButtonShapeText = (SpenShowButtonShapeText) viewFindViewById;
        spenShowButtonShapeText.setTag(1);
        spenShowButtonShapeText.setOnClickListener(this.mBtnClickListener);
        spenShowButtonShapeText.setContentDescription(((Object) spenShowButtonShapeText.getText()) + " " + string);
        spenShowButtonShapeText.setButtonShapeEnabled(true);
        View viewFindViewById2 = findViewById(C7932R.id.cancel);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText");
        SpenShowButtonShapeText spenShowButtonShapeText2 = (SpenShowButtonShapeText) viewFindViewById2;
        spenShowButtonShapeText2.setTag(2);
        spenShowButtonShapeText2.setOnClickListener(this.mBtnClickListener);
        spenShowButtonShapeText2.setContentDescription(((Object) spenShowButtonShapeText2.getText()) + " " + string);
        spenShowButtonShapeText2.setButtonShapeEnabled(true);
        SpenSettingUtilText.setTypeFace(context, fontName, spenShowButtonShapeText, spenShowButtonShapeText2);
        SpenSettingUtilText.applyUpToLargeLevel(context, 16.0f, spenShowButtonShapeText, spenShowButtonShapeText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mBtnClickListener$lambda$0(SpenColorSettingLayoutV2 spenColorSettingLayoutV2, View view) {
        OnActionListener onActionListener;
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) tag).intValue();
        if (iIntValue != 1) {
            if (iIntValue == 2 && (onActionListener = spenColorSettingLayoutV2.mActionListener) != null) {
                onActionListener.onCancel();
                return;
            }
            return;
        }
        int iSendSelectResult = spenColorSettingLayoutV2.sendSelectResult();
        OnActionListener onActionListener2 = spenColorSettingLayoutV2.mActionListener;
        if (onActionListener2 != null) {
            onActionListener2.OnDone(iSendSelectResult);
        }
    }

    private final int sendSelectResult() {
        IEventListener iEventListener = this.mEventListener;
        if (iEventListener == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
            spenColorSettingListControl = null;
        }
        if (!spenColorSettingListControl.getSelectedList(arrayList)) {
            return 0;
        }
        iEventListener.onChangeSelected(arrayList);
        return arrayList.size();
    }

    public final void close() {
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        SpenColorSettingListControl spenColorSettingListControl = null;
        this.mConsumedListener = null;
        SpenColorSettingListControl spenColorSettingListControl2 = this.mListControl;
        if (spenColorSettingListControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
        } else {
            spenColorSettingListControl = spenColorSettingListControl2;
        }
        spenColorSettingListControl.close();
    }

    public final boolean getSelectPaletteList(@Nullable List<Integer> selectList) {
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
            spenColorSettingListControl = null;
        }
        return spenColorSettingListControl.getSelectedList(selectList);
    }

    public final void setColorTheme(int theme) {
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
            spenColorSettingListControl = null;
        }
        spenColorSettingListControl.setColorTheme(theme);
    }

    public final void setEventListener(@Nullable IEventListener listener) {
        this.mEventListener = listener;
    }

    public final void setOnActionListener(@Nullable OnActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    public final void setOnSelectItemEventListener(@Nullable OnSelectItemEventListener listener) {
        this.mSelectItemEventListener = listener;
    }

    public final boolean setSelectPaletteList(@Nullable List<Integer> selectList) {
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListControl");
            spenColorSettingListControl = null;
        }
        return spenColorSettingListControl.setSelectedList(selectList);
    }
}
