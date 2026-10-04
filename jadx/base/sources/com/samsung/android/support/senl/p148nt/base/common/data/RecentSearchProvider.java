package com.samsung.android.support.senl.p148nt.base.common.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JK\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J/\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017J9\u0010\u0018\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "strings", "", "", "s", "strings1", "s1", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "contentValues", "Landroid/content/ContentValues;", OpenSessionApi.ITEM_LIMIT_DELETE, "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Constants", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentSearchProvider extends ContentProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchProvider$Companion;", "", "<init>", "()V", "getUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Uri getUri(@Nullable Context context) {
            String applicationID = ApplicationManager.INSTANCE.getInstance().getApplicationID(context);
            if (applicationID == null) {
                applicationID = "com.samsung.android.app.notes";
            }
            Uri uri = Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + applicationID + ".RecentSearchProvider/recent_search");
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            return uri;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchProvider$Constants;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Constants {
        public static final int COLUMN_ID = 0;
        public static final int COLUMN_SEARCH_KEYWORD = 1;
        public static final int COLUMN_UPDATE_TIME = 2;

        @NotNull
        public static final String CREATE_DB = "create table recent_search(_id integer primary key autoincrement, search_keyword text not null, update_time integer not null);";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String DROP_TABLE = "drop table if exists recent_search";
        public static final int MAX_ROW_LIMIT = 30;

        @NotNull
        public static final String QUERY_OLD_KEYWORDS = "select _id from recent_search ORDER BY _id desc limit -1 offset 30";

        @NotNull
        public static final String SEARCH_KEYWORD = "search_keyword";

        @NotNull
        public static final String TABLE_NAME = "recent_search";

        @NotNull
        public static final String UPDATE_TIME = "update_time";

        @NotNull
        public static final String _ID = "_id";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchProvider$Constants$Companion;", "", "<init>", "()V", "TABLE_NAME", "", "_ID", "SEARCH_KEYWORD", "UPDATE_TIME", "CREATE_DB", "DROP_TABLE", "QUERY_PROJECTION", "", "getQUERY_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "COLUMN_ID", "", "COLUMN_SEARCH_KEYWORD", "COLUMN_UPDATE_TIME", "MAX_ROW_LIMIT", "QUERY_OLD_KEYWORDS", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public static final int COLUMN_ID = 0;
            public static final int COLUMN_SEARCH_KEYWORD = 1;
            public static final int COLUMN_UPDATE_TIME = 2;

            @NotNull
            public static final String CREATE_DB = "create table recent_search(_id integer primary key autoincrement, search_keyword text not null, update_time integer not null);";

            @NotNull
            public static final String DROP_TABLE = "drop table if exists recent_search";
            public static final int MAX_ROW_LIMIT = 30;

            @NotNull
            public static final String QUERY_OLD_KEYWORDS = "select _id from recent_search ORDER BY _id desc limit -1 offset 30";

            @NotNull
            public static final String SEARCH_KEYWORD = "search_keyword";

            @NotNull
            public static final String TABLE_NAME = "recent_search";

            @NotNull
            public static final String UPDATE_TIME = "update_time";

            @NotNull
            public static final String _ID = "_id";
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            private static final String[] QUERY_PROJECTION = {"_id", "search_keyword", "update_time"};

            private Companion() {
            }

            @NotNull
            public final String[] getQUERY_PROJECTION() {
                return QUERY_PROJECTION;
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s12) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
