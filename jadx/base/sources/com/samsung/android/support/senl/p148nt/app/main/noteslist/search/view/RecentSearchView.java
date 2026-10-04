package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxSearchView;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/RecentSearchView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mClearButton", "Landroid/widget/TextView;", "mFlexboxSearchView", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView;", "mClearClickListener", "Landroid/view/View$OnClickListener;", "initLayout", "", "initialize", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView$Listener;", "updateSearchContainer", "updateTextColorForClearAllButton", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentSearchView extends FrameLayout {

    @NotNull
    private static final String TAG = "RecentSearchView";

    @Nullable
    private TextView mClearButton;

    @NotNull
    private final View.OnClickListener mClearClickListener;

    @Nullable
    private FlexboxSearchView mFlexboxSearchView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentSearchView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClearClickListener = new ViewOnClickListenerC7602a(2);
        initLayout();
    }

    private final void initLayout() {
        LayoutInflater.from(getContext()).inflate(C8003R.layout.search_recent_search_view, (ViewGroup) this, true);
        View viewFindViewById = findViewById(C8003R.id.search_header);
        if (viewFindViewById != null) {
            viewFindViewById.setContentDescription(getResources().getString(C8003R.string.recent_search) + SQLKeyword.COMMA + getResources().getString(C8003R.string.base_string_header));
        }
        TextView textView = (TextView) findViewById(C8003R.id.clear_search_history);
        this.mClearButton = textView;
        if (textView != null) {
            textView.setAccessibilityDelegate(new VoiceAssistAsButton());
            textView.setOnClickListener(this.mClearClickListener);
        }
        this.mFlexboxSearchView = (FlexboxSearchView) findViewById(C8003R.id.flexbox_search_view);
        updateTextColorForClearAllButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClearClickListener$lambda$0(View view) {
        MainLogger.m7254d(TAG, "onClick# clear");
        CommonSamsungAnalytics.INSTANCE.insertLog("221", NotesSAConstants.EVENT_SEARCH_CLEAR_RECENT_SEARCHES);
        RecentSearchDatabaseHelper.AsyncExecutor.deleteAllSearchKeywords();
    }

    public final void initialize(@NotNull FlexboxSearchView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FlexboxSearchView flexboxSearchView = this.mFlexboxSearchView;
        if (flexboxSearchView != null) {
            flexboxSearchView.initialize(listener);
        }
    }

    public final void updateSearchContainer() {
        FlexboxSearchView flexboxSearchView = this.mFlexboxSearchView;
        if (flexboxSearchView != null) {
            flexboxSearchView.updateSearchContainer();
        }
    }

    public final void updateTextColorForClearAllButton() {
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(getContext())) {
            int color = getResources().getColor(C8003R.color.recent_search_list_clear_history_text_color_btn_shape, null);
            TextView textView = this.mClearButton;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.mClearButton;
            if (textView2 != null) {
                textView2.setBackgroundResource(C8003R.drawable.recent_search_button_shape_bg);
                return;
            }
            return;
        }
        if (SettingsCompat.INSTANCE.getInstance().isHighTextContrastEnabled(getContext())) {
            int color2 = getResources().getColor(C8003R.color.filter_list_item_header_text_color, null);
            TextView textView3 = this.mClearButton;
            if (textView3 != null) {
                textView3.setTextColor(color2);
            }
            TextView textView4 = this.mClearButton;
            if (textView4 != null) {
                textView4.setBackground(null);
                return;
            }
            return;
        }
        int color3 = getResources().getColor(C8003R.color.recent_search_list_clear_history_text_color, null);
        TextView textView5 = this.mClearButton;
        if (textView5 != null) {
            textView5.setTextColor(color3);
        }
        TextView textView6 = this.mClearButton;
        if (textView6 != null) {
            textView6.setBackground(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClearClickListener = new ViewOnClickListenerC7602a(2);
        initLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClearClickListener = new ViewOnClickListenerC7602a(2);
        initLayout();
    }
}
