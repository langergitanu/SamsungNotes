package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxHashTagView;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/RecentHashTagView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFlexboxHashTagView", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView;", "initLayout", "", "initialize", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxHashTagView$Listener;", "updateTagContainer", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentHashTagView extends FrameLayout {

    @Nullable
    private FlexboxHashTagView mFlexboxHashTagView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentHashTagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    private final void initLayout() {
        LayoutInflater.from(getContext()).inflate(C8003R.layout.search_recent_tag_view, (ViewGroup) this, true);
        View viewFindViewById = findViewById(C8003R.id.tag_header);
        if (viewFindViewById != null) {
            viewFindViewById.setContentDescription(getResources().getString(C8003R.string.tags_recent) + SQLKeyword.COMMA + getResources().getString(C8003R.string.base_string_header));
        }
        this.mFlexboxHashTagView = (FlexboxHashTagView) findViewById(C8003R.id.flexbox_tag_view);
    }

    public final void initialize(@NotNull FlexboxHashTagView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FlexboxHashTagView flexboxHashTagView = this.mFlexboxHashTagView;
        if (flexboxHashTagView != null) {
            flexboxHashTagView.initialize(listener);
        }
    }

    public final void updateTagContainer() {
        FlexboxHashTagView flexboxHashTagView = this.mFlexboxHashTagView;
        if (flexboxHashTagView != null) {
            flexboxHashTagView.updateTagContainer();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentHashTagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentHashTagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }
}
