package com.samsung.android.sdk.pen.setting.colorpalette;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p099Y2.C0347a;
import p251v3.ViewOnClickListenerC14502a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0013\u0018\u0000 .2\u00020\u0001:\u0003./0B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\b\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001eJ\u0016\u0010\u001f\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001eJ\u0010\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0006J\u0010\u0010$\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0006J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J&\u0010)\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010+\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "swatchList", "", "", "maxSelectCount", "<init>", "(Landroid/content/Context;Ljava/util/List;I)V", "customPalette", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "(Landroid/content/Context;ILjava/util/List;)V", "mEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup$IEventListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup$OnActionListener;", "mSelectItemEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "mListControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingListControl;", "mBtnClickListener", "Landroid/view/View$OnClickListener;", "dismiss", "", "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getSelectPaletteList", "", "selectList", "", "setSelectPaletteList", "setOnActionListener", "actionListener", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setOnSelectItemEventListener", "setOrientation", "orientation", "close", "sendSelectResult", "initView", "paletteData", "initListView", "itemLayoutID", "applyWindowInsets", "Companion", "IEventListener", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSettingPopup extends Dialog {
    private static final int CANCEL_BUTTON = 2;
    private static final int DONE_BUTTON = 1;

    @NotNull
    private static final String TAG = "SpenColorSettingPopup";
    private static final boolean USE_CIRCLE_COLOR_CHIP = true;

    @Nullable
    private OnActionListener mActionListener;

    @NotNull
    private final View.OnClickListener mBtnClickListener;

    @Nullable
    private IEventListener mEventListener;

    @Nullable
    private SpenColorSettingListControl mListControl;

    @Nullable
    private OnSelectItemEventListener mSelectItemEventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup$IEventListener;", "", "onChangeSelected", "", XmlErrorCodes.LIST, "", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface IEventListener {
        void onChangeSelected(@Nullable List<Integer> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup$OnActionListener;", "", "onCancel", "", "OnDone", "count", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void OnDone(int count);

        void onCancel();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenColorSettingPopup(@NotNull Context context, @NotNull List<Integer> swatchList, int i) {
        this(context, i, SpenPaletteUtil.getDefinedPaletteData(context, swatchList));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swatchList, "swatchList");
    }

    private final void applyWindowInsets() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(decorView, new C0347a(27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyWindowInsets$lambda$8$lambda$7(View v, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        v.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void close() {
        Log.i(TAG, "#### called free()");
        this.mActionListener = null;
        this.mEventListener = null;
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl != null) {
            spenColorSettingListControl.close();
        }
        this.mListControl = null;
    }

    private final void initListView(Context context, List<SpenColorPaletteData> paletteData, int maxSelectCount, int itemLayoutID) {
        View viewFindViewById = findViewById(C7932R.id.top_divider);
        View viewFindViewById2 = findViewById(C7932R.id.bottom_divider);
        View viewFindViewById3 = findViewById(C7932R.id.palette_list);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ListView");
        final SpenColorSettingListControl spenColorSettingListControl = new SpenColorSettingListControl(context, paletteData, maxSelectCount);
        this.mListControl = spenColorSettingListControl;
        spenColorSettingListControl.setListInfo((ListView) viewFindViewById3, viewFindViewById, viewFindViewById2);
        spenColorSettingListControl.setListItemInfo(itemLayoutID, C7932R.drawable.color_circle_shape, C7932R.drawable.blank_stroke_dot_detail);
        spenColorSettingListControl.setListSelectItemEventListener(new OnSelectItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup$initListView$1$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemChanged(int position, boolean selected) {
                Log.i("SpenColorSettingPopup", "onSelectItemChanged(" + position + SQLKeyword.COMMA + selected + ")");
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemChanged(position, selected);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemUnchanged(int position, OnSelectItemEventListener.UnchangedReason reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                Log.i("SpenColorSettingPopup", "onSelectItemUnchanged(" + position + SQLKeyword.COMMA + reason + ")");
                if (this.this$0.mSelectItemEventListener == null) {
                    spenColorSettingListControl.notifyItemUnchanged(reason);
                    return;
                }
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemUnchanged(position, reason);
                }
            }
        });
    }

    private final void initView(Context context, List<SpenColorPaletteData> paletteData, int maxSelectCount) {
        setContentView(C7932R.layout.setting_color_setting_popup);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C7932R.id.top_layout);
        relativeLayout.setBackgroundResource(C7932R.drawable.spen_common_setting_bg);
        relativeLayout.setOnTouchListener(new ViewOnTouchListenerC7005f(5));
        TextView textView = (TextView) findViewById(C7932R.id.dialog_title_text);
        SpenSettingUtilText.FontName fontName = SpenSettingUtilText.FontName.MEDIUM;
        SpenSettingUtilText.setTypeFace(context, fontName, textView);
        textView.setVisibility(0);
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
        initListView(context, paletteData, maxSelectCount, C7932R.layout.setting_color_setting_popup_list_item_v70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mBtnClickListener$lambda$0(SpenColorSettingPopup spenColorSettingPopup, View view) {
        OnActionListener onActionListener;
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) tag).intValue();
        if (iIntValue == 1) {
            int iSendSelectResult = spenColorSettingPopup.sendSelectResult();
            OnActionListener onActionListener2 = spenColorSettingPopup.mActionListener;
            if (onActionListener2 != null) {
                onActionListener2.OnDone(iSendSelectResult);
            }
        } else if (iIntValue == 2 && (onActionListener = spenColorSettingPopup.mActionListener) != null) {
            onActionListener.onCancel();
        }
        spenColorSettingPopup.dismiss();
    }

    private final int sendSelectResult() {
        SpenColorSettingListControl spenColorSettingListControl;
        IEventListener iEventListener = this.mEventListener;
        if (iEventListener == null || (spenColorSettingListControl = this.mListControl) == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        if (!spenColorSettingListControl.getSelectedList(arrayList)) {
            return 0;
        }
        iEventListener.onChangeSelected(arrayList);
        return arrayList.size();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        close();
    }

    public final boolean getSelectPaletteList(@Nullable List<Integer> selectList) {
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl != null) {
            return spenColorSettingListControl.getSelectedList(selectList);
        }
        return false;
    }

    public final void setColorTheme(int theme) {
        SpenColorSettingListControl spenColorSettingListControl = this.mListControl;
        if (spenColorSettingListControl != null) {
            spenColorSettingListControl.setColorTheme(theme);
        }
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
        if (spenColorSettingListControl != null) {
            return spenColorSettingListControl.setSelectedList(selectList);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorSettingPopup(@NotNull Context context, int i, @NotNull List<SpenColorPaletteData> customPalette) {
        super(context, C7932R.style.SettingPopupDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customPalette, "customPalette");
        this.mBtnClickListener = new ViewOnClickListenerC14502a(this, 1);
        applyWindowInsets();
        SpenSettingUtil.setWindowHeight(getWindow(), -1);
        SpenSettingUtil.addSystemUiVisibility(getWindow(), 4096);
        initView(context, customPalette, i);
    }

    public final void setOrientation(int orientation) {
    }
}
