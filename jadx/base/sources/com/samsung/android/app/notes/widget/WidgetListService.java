package com.samsung.android.app.notes.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.samsung.android.app.notes.widget.common.ListViewItem;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetListService;", "Landroid/widget/RemoteViewsService;", "<init>", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "ListViewsFactory", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetListService extends RemoteViewsService {

    @NotNull
    private static final String TAG = "WidgetListService";
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\tH\u0016J&\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J \u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetListService$ListViewsFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "mContext", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "mAppWidgetId", "", "mUuidList", "", "", "mListViewItem", "", "Landroid/widget/RemoteViews;", "mMainListEntries", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "onCreate", "", "onDataSetChanged", "initItems", "onDestroy", "getCount", "getItemId", "", "position", "hasStableIds", "", "getViewAt", "isSame", "oldList", "newList", "buildItem", "mainListDocumentData", "isInitItem", "getLoadingView", "getViewTypeCount", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ListViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        public static final int $stable = 8;
        private final int mAppWidgetId;

        @NotNull
        private final Context mContext;

        @Nullable
        private List<RemoteViews> mListViewItem;

        @Nullable
        private List<MainListDocumentData> mMainListEntries;

        @Nullable
        private List<String> mUuidList;

        public ListViewsFactory(@NotNull Context mContext, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.mContext = mContext;
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, 0);
            this.mAppWidgetId = intExtra;
            WidgetLogger.m5154d(WidgetListService.TAG, "ListViewsFactory# appWidgetId: " + intExtra);
        }

        private final void buildItem(MainListDocumentData mainListDocumentData, int position, boolean isInitItem) {
            if (!isInitItem) {
                List<MainListDocumentData> list = this.mMainListEntries;
                if (list != null) {
                    list.remove(position);
                }
                List<RemoteViews> list2 = this.mListViewItem;
                if (list2 != null) {
                    list2.remove(position);
                }
            }
            List<MainListDocumentData> list3 = this.mMainListEntries;
            if (list3 != null) {
                list3.add(position, mainListDocumentData);
            }
            boolean z = mainListDocumentData.getIsLock() != 5;
            boolean zIsDarkMode = new ThemeInfo(this.mContext, this.mAppWidgetId).isDarkMode();
            Context context = this.mContext;
            int i = this.mAppWidgetId;
            String uuid = mainListDocumentData.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            ListViewItem listViewItem = new ListViewItem(context, i, mainListDocumentData, uuid, z, zIsDarkMode);
            List<RemoteViews> list4 = this.mListViewItem;
            if (list4 != null) {
                list4.add(position, listViewItem.getRemoteViews());
            }
        }

        private final void initItems() {
            List<RemoteViews> list = this.mListViewItem;
            if (list != null) {
                Intrinsics.checkNotNull(list);
                list.clear();
            } else {
                this.mListViewItem = new ArrayList(10);
            }
            List<MainListDocumentData> list2 = this.mMainListEntries;
            if (list2 != null) {
                Intrinsics.checkNotNull(list2);
                list2.clear();
            } else {
                this.mMainListEntries = new ArrayList(10);
            }
            List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(this.mAppWidgetId);
            this.mUuidList = noteUuidList;
            Intrinsics.checkNotNull(noteUuidList);
            WidgetLogger.m5154d(WidgetListService.TAG, "initItems# mUuidList " + noteUuidList.size());
            MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createMainListDocumentDataRepository();
            List<String> list3 = this.mUuidList;
            Intrinsics.checkNotNull(list3);
            Iterator<String> it = list3.iterator();
            int i = 0;
            while (it.hasNext()) {
                MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(it.next());
                if (mainListDocumentData != null) {
                    buildItem(mainListDocumentData, i, true);
                    i++;
                }
            }
            List<MainListDocumentData> list4 = this.mMainListEntries;
            Intrinsics.checkNotNull(list4);
            WidgetLogger.m5154d(WidgetListService.TAG, "initItems# mMainListEntries " + list4.size());
        }

        private final boolean isSame(List<String> oldList, List<String> newList) {
            if (newList == null || oldList.size() != newList.size()) {
                return false;
            }
            Iterator<String> it = oldList.iterator();
            while (it.hasNext()) {
                if (!newList.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            List<MainListDocumentData> list = this.mMainListEntries;
            if (list == null) {
                return 0;
            }
            Intrinsics.checkNotNull(list);
            return list.size();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int position) {
            List<MainListDocumentData> list = this.mMainListEntries;
            if (list == null) {
                return 0L;
            }
            Intrinsics.checkNotNull(list);
            if (list.size() <= position) {
                return 0L;
            }
            List<MainListDocumentData> list2 = this.mMainListEntries;
            Intrinsics.checkNotNull(list2);
            Long id = list2.get(position).getId();
            Intrinsics.checkNotNull(id);
            return id.longValue();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getLoadingView() {
            WidgetLogger.m5155i(WidgetListService.TAG, "getLoadingView# " + this.mAppWidgetId);
            boolean zIsDarkMode = new ThemeInfo(this.mContext, this.mAppWidgetId).isDarkMode();
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), C11391R.layout.widget_list_item_loading);
            if (zIsDarkMode) {
                remoteViews.setTextColor(C11391R.id.widget_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_white));
                return remoteViews;
            }
            remoteViews.setTextColor(C11391R.id.widget_item_text_loading, ContextCompat.getColor(this.mContext, C11391R.color.widget_text_loading_color_black));
            return remoteViews;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @Nullable
        public RemoteViews getViewAt(int position) {
            WidgetLogger.m5155i(WidgetListService.TAG, "getViewAt# start " + this.mAppWidgetId + ", position : " + position);
            List<MainListDocumentData> list = this.mMainListEntries;
            Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (position >= numValueOf.intValue()) {
                WidgetLogger.INSTANCE.m5157e(WidgetListService.TAG, "getViewAt# IndexOutOfBoundsException position : " + position);
                return null;
            }
            if (DeviceUtils.isFoldableModel()) {
                if (!isSame(WidgetPreferenceManager.INSTANCE.getNoteUuidList(this.mAppWidgetId), this.mUuidList)) {
                    WidgetLogger.INSTANCE.m5157e(WidgetListService.TAG, "getViewAt# notifyAppWidgetViewDataChanged " + position);
                    AppWidgetManager.getInstance(this.mContext).notifyAppWidgetViewDataChanged(this.mAppWidgetId, C11391R.id.widget_list_view);
                    return null;
                }
                MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createMainListDocumentDataRepository();
                List<String> list2 = this.mUuidList;
                Intrinsics.checkNotNull(list2);
                MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(list2.get(position));
                List<MainListDocumentData> list3 = this.mMainListEntries;
                Intrinsics.checkNotNull(list3);
                MainListDocumentData mainListDocumentData2 = list3.get(position);
                if (mainListDocumentData == null || mainListDocumentData2 == null) {
                    WidgetLogger.INSTANCE.m5157e(WidgetListService.TAG, "getViewAt# mainListEntry or newMainListEntry null : " + position);
                    return null;
                }
                if (mainListDocumentData.getLastModifiedAt() > mainListDocumentData2.getLastModifiedAt()) {
                    WidgetLogger.m5155i(WidgetListService.TAG, "getViewAt# note was changed , position: " + position);
                    buildItem(mainListDocumentData, position, false);
                }
            }
            WidgetLogger.m5155i(WidgetListService.TAG, "getViewAt# end " + this.mAppWidgetId + ", position: " + position);
            List<RemoteViews> list4 = this.mListViewItem;
            Intrinsics.checkNotNull(list4);
            return list4.get(position);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return false;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
            WidgetLogger.m5154d(WidgetListService.TAG, "onCreate# " + this.mAppWidgetId);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            WidgetLogger.m5154d(WidgetListService.TAG, "onDataSetChanged# " + this.mAppWidgetId);
            initItems();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
            WidgetLogger.m5154d(WidgetListService.TAG, "onDestroy# " + this.mAppWidgetId);
        }
    }

    @Override // android.widget.RemoteViewsService
    @NotNull
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5154d(TAG, "onGetViewFactory#");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return new ListViewsFactory(applicationContext, intent);
    }
}
