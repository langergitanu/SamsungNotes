package com.samsung.android.support.senl.p148nt.base.common.data;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u00140\u000bR\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchCursorLoader;", "Landroidx/loader/content/CursorLoader;", "context", "Landroid/content/Context;", "observer", "Landroid/database/ContentObserver;", "<init>", "(Landroid/content/Context;Landroid/database/ContentObserver;)V", "getObserver", "()Landroid/database/ContentObserver;", "mObserver", "Landroidx/loader/content/Loader$ForceLoadContentObserver;", "Landroidx/loader/content/Loader;", "Landroid/database/Cursor;", "kotlin.jvm.PlatformType", "loadInBackground", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentSearchCursorLoader extends CursorLoader {

    @NotNull
    private final Loader<Cursor>.ForceLoadContentObserver mObserver;

    @NotNull
    private final ContentObserver observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentSearchCursorLoader(@Nullable Context context, @NotNull ContentObserver observer) {
        super(context);
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNull(context);
        this.observer = observer;
        this.mObserver = new Loader.ForceLoadContentObserver();
    }

    @NotNull
    public final ContentObserver getObserver() {
        return this.observer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    @Nullable
    public Cursor loadInBackground() {
        AbstractC2322a.m1631u(hashCode(), "RecentSearchCursorLoader#loadInBackground ", "Cursor");
        RecentSearchDatabaseHelper companion = RecentSearchDatabaseHelper.INSTANCE.getInstance();
        if (companion == null) {
            return null;
        }
        Cursor cursorQuerySearchKeywords = companion.querySearchKeywords();
        if (cursorQuerySearchKeywords == null || cursorQuerySearchKeywords.isClosed()) {
            return cursorQuerySearchKeywords;
        }
        try {
            cursorQuerySearchKeywords.getCount();
            cursorQuerySearchKeywords.registerContentObserver(this.observer);
            cursorQuerySearchKeywords.setNotificationUri(getContext().getContentResolver(), RecentSearchProvider.INSTANCE.getUri(getContext()));
            return cursorQuerySearchKeywords;
        } catch (RuntimeException e) {
            cursorQuerySearchKeywords.close();
            throw e;
        }
    }
}
