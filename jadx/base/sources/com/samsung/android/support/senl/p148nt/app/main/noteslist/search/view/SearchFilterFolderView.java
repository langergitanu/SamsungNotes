package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p091W2.C0331a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterFolderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mInsideFolderSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "mListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterFolderView$Listener;", "initLayout", "", "initialize", NotesConstants.KEY_FOLDER_UUID, "", "isInsideFolderChecked", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isFilterEnabled", "Listener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SearchFilterFolderView extends FrameLayout {

    @NotNull
    private static final String TAG = "SearchFilterFolderView";

    @Nullable
    private SwitchCompat mInsideFolderSwitch;

    @Nullable
    private Listener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterFolderView$Listener;", "", "onFolderFilterChanged", "", "enabled", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onFolderFilterChanged(boolean enabled);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterFolderView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    private final void initLayout() {
        LayoutInflater.from(getContext()).inflate(C8003R.layout.search_filter_folder_view, (ViewGroup) this, true);
        this.mInsideFolderSwitch = (SwitchCompat) findViewById(C8003R.id.search_inside_folder_switch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(SearchFilterFolderView searchFilterFolderView, CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        MainLogger.m7254d(TAG, "onCheckedChanged# isChecked : " + z);
        Listener listener = searchFilterFolderView.mListener;
        if (listener != null) {
            listener.onFolderFilterChanged(z);
        }
        CommonSamsungAnalytics.INSTANCE.insertLog("222", NotesSAConstants.EVENT_SEARCH_INSIDE_FOLDERS, z ? NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON : NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF);
    }

    public final void initialize(@NotNull String folderUuid, boolean isInsideFolderChecked, @NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
        View viewFindViewById = findViewById(C8003R.id.search_inside_folder);
        if (FeatureUtils.isPreDefinedFolderUuid(folderUuid) || Intrinsics.areEqual(FolderConstants.MyFolders.UUID, folderUuid)) {
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                return;
            }
            return;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        SwitchCompat switchCompat = this.mInsideFolderSwitch;
        Intrinsics.checkNotNull(switchCompat);
        switchCompat.setChecked(isInsideFolderChecked);
        SwitchCompat switchCompat2 = this.mInsideFolderSwitch;
        Intrinsics.checkNotNull(switchCompat2);
        switchCompat2.setOnCheckedChangeListener(new C0331a(this, 4));
        CommonSamsungAnalytics.INSTANCE.insertLog("222", NotesSAConstants.EVENT_SEARCH_INSIDE_FOLDERS);
    }

    public final boolean isFilterEnabled() {
        SwitchCompat switchCompat = this.mInsideFolderSwitch;
        if (switchCompat != null) {
            return switchCompat.isChecked();
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterFolderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterFolderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
    }
}
