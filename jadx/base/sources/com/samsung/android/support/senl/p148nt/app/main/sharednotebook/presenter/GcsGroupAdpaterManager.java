package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupAdapter;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupHolder;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import org.jetbrains.annotations.NotNull;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupAdpaterManager implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int LOADER_ID = 100;
    public static final String TAG = "GcsGroupAdpaterManager";
    private final GcsGroupAdapter mAdapter;
    private final PenRecyclerView mSharedNotebookRecyclerView;

    public GcsGroupAdpaterManager(@NonNull PenRecyclerView penRecyclerView, GcsGroupHolder.GcsGroupHolderContract gcsGroupHolderContract) {
        this.mSharedNotebookRecyclerView = penRecyclerView;
        GcsGroupAdapter gcsGroupAdapter = new GcsGroupAdapter(gcsGroupHolderContract);
        this.mAdapter = gcsGroupAdapter;
        penRecyclerView.setAdapter(gcsGroupAdapter);
        penRecyclerView.setLayoutManager(new LinearLayoutManager(penRecyclerView.getContext()), 1);
        ViewModeUtils.updateRecyclerViewFadingEdge(penRecyclerView, false);
        if (FeatureInfo.isVSTModel()) {
            penRecyclerView.setBackgroundColor(ContextCompat.getColor(penRecyclerView.getContext(), C8003R.color.noteslist_fragment_bg_color_for_vst));
        }
    }

    public void notifyDataSetChanged() {
        this.mAdapter.notifyDataSetChanged();
    }

    public void onConfigurationChanged(Activity activity) {
        if (!WidgetInsetUtils.getCanUseWindowInsets()) {
            ViewModeUtils.updateRecyclerViewPaddingBottom(this.mSharedNotebookRecyclerView, false);
        } else {
            PenRecyclerView penRecyclerView = this.mSharedNotebookRecyclerView;
            penRecyclerView.setPadding(penRecyclerView.getPaddingStart(), this.mSharedNotebookRecyclerView.getPaddingTop(), this.mSharedNotebookRecyclerView.getPaddingEnd(), this.mSharedNotebookRecyclerView.getPaddingBottom() + ((int) ResourceUtils.convertDpToPixel(this.mSharedNotebookRecyclerView.getContext(), 60.0f)));
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    @NotNull
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.mSharedNotebookRecyclerView.getContext(), SesShareReadResolver.getInstance().getSharedContentUri(), null, null, null, "createTime DESC");
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(@NotNull Loader<Cursor> loader) {
        this.mAdapter.changeCursor(null);
    }

    public void onResume(Activity activity) {
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST);
        if (!WidgetInsetUtils.getCanUseWindowInsets()) {
            ViewModeUtils.updateRecyclerViewPaddingBottom(this.mSharedNotebookRecyclerView, false);
        } else {
            PenRecyclerView penRecyclerView = this.mSharedNotebookRecyclerView;
            penRecyclerView.setPadding(penRecyclerView.getPaddingStart(), this.mSharedNotebookRecyclerView.getPaddingTop(), this.mSharedNotebookRecyclerView.getPaddingEnd(), this.mSharedNotebookRecyclerView.getPaddingBottom() + ((int) ResourceUtils.convertDpToPixel(this.mSharedNotebookRecyclerView.getContext(), 60.0f)));
        }
    }

    public void restartLoader(LoaderManager loaderManager) {
        loaderManager.restartLoader(100, new Bundle(), this);
    }

    public void setLoader(LoaderManager loaderManager) {
        boolean zM605O;
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mSharedNotebookRecyclerView.getContext())) {
            try {
                zM605O = AbstractC0299q.m605O();
            } catch (Exception unused) {
                zM605O = false;
            }
            if (!zM605O) {
                return;
            }
        }
        if (loaderManager.getLoader(100) == null) {
            MainLogger.m7258i(TAG, "setLoader call initLoader");
            loaderManager.initLoader(100, null, this);
        } else {
            MainLogger.m7258i(TAG, "setLoader call restartLoader");
            loaderManager.restartLoader(100, null, this);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoadFinished(@NotNull Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            MainLogger.m7255e(TAG, "onLoadFinished# cursor is null or already closed");
            return;
        }
        this.mAdapter.changeCursor(cursor);
        GcsGroupAdapter gcsGroupAdapter = this.mAdapter;
        gcsGroupAdapter.setNoNoteInVisible(gcsGroupAdapter.getItemCount() > 0);
    }
}
