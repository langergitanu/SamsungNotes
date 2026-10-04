package com.samsung.android.support.senl.p148nt.app.provider;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.memolist.MemoListActivity;
import com.samsung.android.lib.galaxyfinder.search.api.SamsungSearchProvider;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.api.search.Basic2SearchResult;
import com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult;
import com.samsung.android.lib.galaxyfinder.search.api.search.item.Basic2SearchResultItem;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.search.NotesSearchManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.domain.search.FinderSearchNoteUseCase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesSamsungSearchProvider extends SamsungSearchProvider {
    private static final String TAG = "NotesSamsungSearchProvider";

    @RequiresApi(api = 35)
    private int addResultItems(Basic2SearchResult basic2SearchResult, Cursor cursor, String str) {
        if (cursor == null) {
            return 0;
        }
        int columnIndex = cursor.getColumnIndex("suggest_intent_extra_data");
        int columnIndex2 = cursor.getColumnIndex(NotesSearchManager.FINDER_SEARCH_THUMBNAIL);
        int columnIndex3 = cursor.getColumnIndex(NotesSearchManager.FINDER_SEARCH_TITLE);
        int columnIndex4 = cursor.getColumnIndex(NotesSearchManager.FINDER_SEARCH_BODY_CONTENT);
        if (columnIndex < 0 || columnIndex2 < 0 || columnIndex3 < 0 || columnIndex4 < 0) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(columnIndex, columnIndex2, "addResultItems, invalid index, uuid/thumbnail/primary/secondary: ", "/", "/");
            sbM1173s.append(columnIndex3);
            sbM1173s.append("/");
            sbM1173s.append(columnIndex4);
            Logger.m8698e(TAG, sbM1173s.toString());
            return 0;
        }
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndex);
            String string2 = cursor.getString(columnIndex2);
            basic2SearchResult.addResultItem(new Basic2SearchResultItem(string, string2 != null ? Uri.parse(string2) : null, cursor.getString(columnIndex3), cursor.getString(columnIndex4), null, makeIntentResultItemPayload(string, str), null));
        }
        int count = cursor.getCount();
        basic2SearchResult.setTotalCount(count);
        return count;
    }

    @Nullable
    private Intent makeIntent(@NonNull String str, int i) {
        Context context = getContext();
        if (context == null) {
            Logger.m8703w(TAG, "makeIntent, context is null");
            return null;
        }
        MultiTaskManager.getInstance().initialize(MemoListActivity.class);
        Intent intent = new Intent(str);
        if (i > 0) {
            intent.addFlags(i);
        }
        MultiTaskManager.getInstance().updateActivityClass(context, intent);
        return intent;
    }

    private IntentResultItemPayload makeIntentResultItemPayload(String str, String str2) {
        Intent intentMakeAppLaunchIntent = makeAppLaunchIntent();
        if (intentMakeAppLaunchIntent == null) {
            AbstractC4539a.m3214x("addResultItems, invalid item, uuid: ", str, TAG);
            return null;
        }
        intentMakeAppLaunchIntent.putExtra("intent_extra_data_key", str);
        intentMakeAppLaunchIntent.putExtra("query", str2);
        return new IntentResultItemPayload(intentMakeAppLaunchIntent);
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.SamsungSearchProvider
    @Nullable
    public String getModuleLabel() {
        Context context = getContext();
        if (context != null) {
            return context.getString(C8003R.string.app_name);
        }
        Logger.m8703w(TAG, "getModuleLabel, context is null");
        return super.getModuleLabel();
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.SamsungSearchProvider
    @NonNull
    @RequiresApi(api = 35)
    public SearchResult<?> getSearchResult(@NonNull String str, int i, @Nullable CancellationSignal cancellationSignal) {
        Basic2SearchResult basic2SearchResult = new Basic2SearchResult(str);
        Context context = getContext();
        if (context == null) {
            Logger.m8703w(TAG, "getSearchResult, context is null");
            return basic2SearchResult;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iAddResultItems = 0;
        try {
            Cursor cursorInvoke = new FinderSearchNoteUseCase(NotesDataRepositoryFactory.newInstance(context).createSearchRepository()).invoke(new FinderSearchNoteUseCase.Param(str, i, ""));
            try {
                iAddResultItems = addResultItems(basic2SearchResult, cursorInvoke, str);
                if (cursorInvoke != null) {
                    cursorInvoke.close();
                }
            } finally {
            }
        } catch (SQLException e) {
            Logger.m8698e(TAG, "getSearchResult, e: " + e.getMessage());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sbM778t = AbstractC0541b.m778t(iAddResultItems, "query, result: ", ", execution time: ");
        sbM778t.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
        Logger.m8702i(TAG, sbM778t.toString());
        return basic2SearchResult;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.SamsungSearchProvider
    @Nullable
    public Intent makeAppLaunchIntent() {
        return makeIntent(Constants.ACTION_VIEW_FROM_FINDER, 0);
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.SamsungSearchProvider
    @Nullable
    public Intent makeInAppSearchIntent() {
        return makeIntent("android.intent.action.SEARCH", ComposerConstants.ACTIVITY_FLAG_CALLEE);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }
}
