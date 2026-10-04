package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0017J\u0018\u0010\u001a\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTagViewList", "", "Landroid/view/View;", "[Landroid/view/View;", "STR_BUTTON", "", "mListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView$Listener;", "mHashTagClickListener", "Landroid/view/View$OnClickListener;", "initialize", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "updateTagContainer", "loadTagBubble", "hashTagDataList", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesTagEntity;", "Listener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlexboxHashTagView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlexboxHashTagView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,91:1\n51#2:92\n45#2:93\n*S KotlinDebug\n*F\n+ 1 FlexboxHashTagView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView\n*L\n65#1:92\n66#1:93\n*E\n"})
public final class FlexboxHashTagView extends FlexboxLayout {
    private static final int MAX_TAG_LIMIT = 10;

    @NotNull
    private final String STR_BUTTON;

    @NotNull
    private final View.OnClickListener mHashTagClickListener;

    @Nullable
    private Listener mListener;

    @NotNull
    private final View[] mTagViewList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView$Listener;", "", "onHashTagSelected", "", "tag", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onHashTagSelected(@Nullable String tag);
    }

    public FlexboxHashTagView(@Nullable Context context) {
        super(context);
        this.mTagViewList = new View[10];
        String string = getResources().getString(C8003R.string.button_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.STR_BUTTON = string;
        this.mHashTagClickListener = new ViewOnClickListenerC8556a(this, 0);
    }

    private final void loadTagBubble(List<NotesTagEntity> hashTagDataList) {
        String displayName;
        if (getChildCount() != 0) {
            removeViews(0, getChildCount());
        }
        int iMin = Math.min(hashTagDataList.size(), 10);
        for (int i = 0; i < iMin; i++) {
            NotesTagEntity notesTagEntity = hashTagDataList.get(i);
            if (notesTagEntity != null && (displayName = notesTagEntity.getDisplayName()) != null) {
                this.mTagViewList[i] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_tag_item, (ViewGroup) this, false);
                View view = this.mTagViewList[i];
                if (view != null) {
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String lowerCase = displayName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    view.setTag(lowerCase);
                }
                View view2 = this.mTagViewList[i];
                if (view2 != null) {
                    view2.setOnClickListener(this.mHashTagClickListener);
                }
                View view3 = this.mTagViewList[i];
                if (view3 != null) {
                    view3.setContentDescription(displayName + SQLKeyword.COMMA + this.STR_BUTTON);
                }
                View view4 = this.mTagViewList[i];
                TextView textView = view4 != null ? (TextView) view4.findViewById(C8003R.id.tag_item_text) : null;
                if (textView != null) {
                    textView.setText(ContentUtils.convertTagText(displayName));
                }
                CharUtils.applyTextSizeUntilMediumSize(getContext(), textView, 13.0f);
                addView(this.mTagViewList[i]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mHashTagClickListener$lambda$0(FlexboxHashTagView flexboxHashTagView, View view) {
        CommonSamsungAnalytics.INSTANCE.insertLog("221", NotesSAConstants.EVENT_SEARCH_SELECT_TAGING_NOTE);
        String str = (String) view.getTag();
        Listener listener = flexboxHashTagView.mListener;
        if (listener != null) {
            listener.onHashTagSelected(str);
        }
    }

    public final void initialize(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public final void updateTagContainer() {
        if (getContext() == null) {
            return;
        }
        List<NotesTagEntity> recentTagList = DataManager.getInstance().getRecentTagList(10);
        if (recentTagList.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNull(recentTagList);
        loadTagBubble(recentTagList);
    }

    public FlexboxHashTagView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTagViewList = new View[10];
        String string = getResources().getString(C8003R.string.button_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.STR_BUTTON = string;
        this.mHashTagClickListener = new ViewOnClickListenerC8556a(this, 0);
    }

    public FlexboxHashTagView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTagViewList = new View[10];
        String string = getResources().getString(C8003R.string.button_string_button);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.STR_BUTTON = string;
        this.mHashTagClickListener = new ViewOnClickListenerC8556a(this, 0);
    }
}
