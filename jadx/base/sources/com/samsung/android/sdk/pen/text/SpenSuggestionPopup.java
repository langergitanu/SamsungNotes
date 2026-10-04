package com.samsung.android.sdk.pen.text;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.material.oneui.floatingdock.C4797h;
import com.samsung.android.sdk.pen.document.textspan.SpenSuggestionSpan;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0003BCDB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\"J\u0010\u0010,\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u001fJ\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020$J\u0006\u0010/\u001a\u00020*J\u001e\u00100\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u00101\u001a\u00020*J\u000e\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020$J\u000e\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020$J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020\u0019H\u0002J.\u0010:\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020*2\u0006\u0010=\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n0\u000fj\b\u0012\u0004\u0012\u00020\n`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/view/View$OnClickListener;", "mView", "Landroid/view/View;", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "pos", "Landroid/graphics/Point;", "spanText", "", "<init>", "(Landroid/view/View;Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;Landroid/graphics/Point;Ljava/lang/String;)V", "mSpan", "mSuggestionText", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mAdapter", "Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup$SuggestionAdapter;", "mPopupWindow", "Landroid/widget/PopupWindow;", "mContext", "Landroid/content/Context;", "mPosition", "mWidth", "", "mContentView", "Landroid/view/ViewGroup;", "mListView", "Landroid/widget/ListView;", "mSuggestionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$SuggestionListener;", "mSpanText", "mActionListener", "Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup$ActionListener;", "mClearHighlightOnDismiss", "", "getMClearHighlightOnDismiss", "()Z", "setMClearHighlightOnDismiss", "(Z)V", "setActionListener", "", "action", "setSuggestionListener", "clearHighlightOnDismiss", "enabled", "close", Constants.ARG_UPDATE, "dismiss", Constants.IntentExtraValue.SHOW, "selectionHighLightEnabled", "updatePosition", "point", "isShowing", "initContentView", "createPopupWindow", "calculatePopupWidth", "onItemClick", "adapterView", "Landroid/widget/AdapterView;", "view", "i", "l", "", "onClick", "ActionListener", "SuggestionAdapter", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSuggestionPopup implements AdapterView.OnItemClickListener, View.OnClickListener {
    private static final float PADDING_EXTRA = 4.0f;

    @NotNull
    private static final String TAG = "SpenSuggestionPopup";

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private SuggestionAdapter mAdapter;
    private boolean mClearHighlightOnDismiss;

    @Nullable
    private ViewGroup mContentView;

    @NotNull
    private final Context mContext;

    @Nullable
    private ListView mListView;

    @Nullable
    private PopupWindow mPopupWindow;

    @NotNull
    private Point mPosition;

    @Nullable
    private SpenSuggestionSpan mSpan;

    @NotNull
    private String mSpanText;

    @Nullable
    private SpenInputManager.SuggestionListener mSuggestionListener;

    @NotNull
    private ArrayList<String> mSuggestionText;

    @NotNull
    private final View mView;
    private int mWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup$ActionListener;", "", "onItemClicked", "", "newSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "newStr", "", "start", "", "end", "onDeleteClicked", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onDeleteClicked(int start, int end);

        void onItemClicked(@Nullable SpenSuggestionSpan newSpan, @Nullable String newStr, int start, int end);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001e\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup$SuggestionAdapter;", "Landroid/widget/BaseAdapter;", "mSuggestionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup;Ljava/util/ArrayList;)V", "mInflater", "Landroid/view/LayoutInflater;", "getCount", "", "getItem", "", "i", "getItemId", "", "getView", "Landroid/view/View;", "view", "viewGroup", "Landroid/view/ViewGroup;", "setSuggestionText", "", "suggestionList", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class SuggestionAdapter extends BaseAdapter {

        @NotNull
        private final LayoutInflater mInflater;

        @NotNull
        private ArrayList<String> mSuggestionList;
        final /* synthetic */ SpenSuggestionPopup this$0;

        public SuggestionAdapter(@NotNull SpenSuggestionPopup spenSuggestionPopup, ArrayList<String> mSuggestionList) {
            Intrinsics.checkNotNullParameter(mSuggestionList, "mSuggestionList");
            this.this$0 = spenSuggestionPopup;
            this.mSuggestionList = mSuggestionList;
            Object systemService = spenSuggestionPopup.mContext.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            this.mInflater = (LayoutInflater) systemService;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mSuggestionList.size();
        }

        @Override // android.widget.Adapter
        @NotNull
        public Object getItem(int i) {
            String str = this.mSuggestionList.get(i);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            return str;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @NotNull
        public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null) {
                View viewInflate = this.mInflater.inflate(C7932R.layout.sdk_suggestion_item, viewGroup, false);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                textView = (TextView) viewInflate;
            }
            textView.setText(this.mSuggestionList.get(i));
            return textView;
        }

        public final void setSuggestionText(@NotNull ArrayList<String> suggestionList) {
            Intrinsics.checkNotNullParameter(suggestionList, "suggestionList");
            this.mSuggestionList = suggestionList;
            notifyDataSetChanged();
        }
    }

    public SpenSuggestionPopup(@NotNull View mView, @NotNull SpenSuggestionSpan span, @NotNull Point pos, @NotNull String spanText) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(spanText, "spanText");
        this.mView = mView;
        Context context = mView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mContext = context;
        this.mSpanText = "";
        this.mClearHighlightOnDismiss = true;
        this.mSpan = span;
        this.mSuggestionText = span.getSuggestions();
        this.mPosition = pos;
        this.mSpanText = spanText;
        initContentView();
        createPopupWindow();
    }

    private final int calculatePopupWidth() {
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.text_suggestion_popup_text_size);
        Paint paint = new Paint();
        paint.setTextSize(dimensionPixelSize);
        String string = this.mContext.getString(C7932R.string.composer_delete);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int iMeasureText = (int) paint.measureText(upperCase);
        Iterator<String> it = this.mSuggestionText.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            int iMeasureText2 = (int) paint.measureText(next);
            if (iMeasureText2 > iMeasureText) {
                iMeasureText = iMeasureText2;
            }
        }
        return iMeasureText + this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.text_suggestion_popup_padding_start) + this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.text_suggestion_popup_padding_end) + ((int) TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics()));
    }

    private final void createPopupWindow() {
        dismiss();
        this.mWidth = calculatePopupWidth();
        PopupWindow popupWindow = new PopupWindow();
        this.mPopupWindow = popupWindow;
        popupWindow.setInputMethodMode(2);
        popupWindow.setFocusable(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setWidth(this.mWidth);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(this.mContentView);
        popupWindow.setAnimationStyle(C7932R.style.AnimationPopupWindow);
        popupWindow.setOnDismissListener(new C4797h(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPopupWindow$lambda$7$lambda$6(SpenSuggestionPopup spenSuggestionPopup) {
        SpenInputManager.SuggestionListener suggestionListener;
        if (!spenSuggestionPopup.mClearHighlightOnDismiss || (suggestionListener = spenSuggestionPopup.mSuggestionListener) == null) {
            return;
        }
        suggestionListener.onHighlightSuggestion(0, -1, -1, 0);
    }

    private final void initContentView() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C7932R.layout.sdk_suggestion_popup, (ViewGroup) null, true);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        this.mContentView = viewGroup;
        if (viewGroup != null) {
            ListView listView = (ListView) viewGroup.findViewById(C7932R.id.suggestionsListView);
            this.mListView = listView;
            if (listView != null) {
                listView.setDivider(null);
                SuggestionAdapter suggestionAdapter = new SuggestionAdapter(this, this.mSuggestionText);
                this.mAdapter = suggestionAdapter;
                listView.setAdapter((ListAdapter) suggestionAdapter);
                listView.setOnItemClickListener(this);
            }
            viewGroup.findViewById(C7932R.id.delete_btn).setOnClickListener(this);
        }
    }

    public final void clearHighlightOnDismiss(boolean enabled) {
        this.mClearHighlightOnDismiss = enabled;
    }

    public final void close() {
        dismiss();
        this.mSpan = null;
        this.mActionListener = null;
        this.mSuggestionListener = null;
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            popupWindow.setOnDismissListener(null);
            this.mPopupWindow = null;
        }
    }

    public final boolean getMClearHighlightOnDismiss() {
        return this.mClearHighlightOnDismiss;
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        SpenSuggestionSpan spenSuggestionSpan;
        Intrinsics.checkNotNullParameter(view, "view");
        ActionListener actionListener = this.mActionListener;
        if (actionListener == null || (spenSuggestionSpan = this.mSpan) == null) {
            return;
        }
        actionListener.onDeleteClicked(spenSuggestionSpan.getStart(), spenSuggestionSpan.getEnd());
        dismiss();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(@Nullable AdapterView<?> adapterView, @NotNull View view, int i, long l) {
        SpenSuggestionSpan spenSuggestionSpan;
        Intrinsics.checkNotNullParameter(view, "view");
        ActionListener actionListener = this.mActionListener;
        if (actionListener == null || (spenSuggestionSpan = this.mSpan) == null || actionListener == null || spenSuggestionSpan == null) {
            return;
        }
        if (spenSuggestionSpan.getSuggestionType() != 1) {
            actionListener.onItemClicked(this.mSpan, this.mSuggestionText.get(i), spenSuggestionSpan.getStart(), spenSuggestionSpan.getEnd());
            dismiss();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(this.mSpanText);
        SpenSuggestionSpan spenSuggestionSpan2 = new SpenSuggestionSpan();
        spenSuggestionSpan2.setSuggestionType(1);
        spenSuggestionSpan2.setPosition(spenSuggestionSpan.getStart(), this.mSuggestionText.get(i).length() + spenSuggestionSpan.getStart());
        spenSuggestionSpan2.setExpansion(2);
        spenSuggestionSpan2.setUnderlineColor(spenSuggestionSpan.getUnderlineColor());
        spenSuggestionSpan2.setSuggestions(arrayList);
        actionListener.onItemClicked(spenSuggestionSpan2, this.mSuggestionText.get(i), spenSuggestionSpan.getStart(), spenSuggestionSpan.getEnd());
        dismiss();
    }

    public final void setActionListener(@Nullable ActionListener action) {
        this.mActionListener = action;
    }

    public final void setMClearHighlightOnDismiss(boolean z) {
        this.mClearHighlightOnDismiss = z;
    }

    public final void setSuggestionListener(@Nullable SpenInputManager.SuggestionListener action) {
        this.mSuggestionListener = action;
    }

    public final void show(boolean selectionHighLightEnabled) {
        SpenInputManager.SuggestionListener suggestionListener;
        SpenSuggestionSpan spenSuggestionSpan;
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            Point point = this.mPosition;
            int i4 = point.x;
            int i5 = this.mWidth;
            int i6 = i4 - (i5 / 2);
            if (i6 < 0) {
                i6 = 0;
            }
            if (i6 + i5 > i) {
                i6 = i - i5;
            }
            int i7 = point.y;
            ViewGroup viewGroup = this.mContentView;
            Intrinsics.checkNotNull(viewGroup);
            int measuredHeight = viewGroup.getMeasuredHeight();
            if (i7 < 0) {
                i7 = 0;
            }
            if (i7 + measuredHeight > i2) {
                i7 = i2 - measuredHeight;
            }
            popupWindow.showAtLocation(this.mView, 0, i6, i7);
            if (!selectionHighLightEnabled || (suggestionListener = this.mSuggestionListener) == null || (spenSuggestionSpan = this.mSpan) == null) {
                return;
            }
            suggestionListener.onHighlightSuggestion(spenSuggestionSpan.getSuggestionType(), spenSuggestionSpan.getStart(), spenSuggestionSpan.getEnd(), spenSuggestionSpan.getUnderlineColor());
        }
    }

    public final void update(@NotNull SpenSuggestionSpan span, @NotNull Point pos, @NotNull String spanText) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(spanText, "spanText");
        this.mSpan = span;
        this.mPosition = pos;
        this.mSpanText = spanText;
        ArrayList<String> suggestions = span.getSuggestions();
        this.mSuggestionText = suggestions;
        SuggestionAdapter suggestionAdapter = this.mAdapter;
        if (suggestionAdapter != null) {
            suggestionAdapter.setSuggestionText(suggestions);
        }
        ListView listView = this.mListView;
        if (listView != null) {
            listView.requestLayout();
        }
        createPopupWindow();
    }

    public final void updatePosition(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        Point point2 = this.mPosition;
        if (point2.x == point.x && point2.y == point.y) {
            return;
        }
        this.mPosition = point;
        createPopupWindow();
    }
}
