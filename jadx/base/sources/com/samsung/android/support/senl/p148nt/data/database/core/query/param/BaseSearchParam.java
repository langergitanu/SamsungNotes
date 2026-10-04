package com.samsung.android.support.senl.p148nt.data.database.core.query.param;

import com.samsung.android.support.senl.p145cm.base.common.constants.AppUpdateConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u0013\u0010\n\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/query/param/BaseSearchParam;", "T", "", "<init>", "()V", "targetFolderUuid", "", "filterParam", "Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SearchFilterParam;", "getTargetFolderUuid", "setTargetFolderUuid", "(Ljava/lang/String;)Ljava/lang/Object;", "getFilterParam", "setFilterParam", "(Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SearchFilterParam;)Ljava/lang/Object;", "toString", AppUpdateConstants.UPDATE_TYPE.SELF, "()Ljava/lang/Object;", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseSearchParam<T> {

    @NotNull
    private String targetFolderUuid = "";

    @NotNull
    private SearchFilterParam filterParam = new SearchFilterParam();

    @NotNull
    public final SearchFilterParam getFilterParam() {
        return this.filterParam;
    }

    @NotNull
    public final String getTargetFolderUuid() {
        return this.targetFolderUuid;
    }

    public abstract T self();

    public final T setFilterParam(@NotNull SearchFilterParam filterParam) {
        Intrinsics.checkNotNullParameter(filterParam, "filterParam");
        this.filterParam = filterParam;
        return self();
    }

    public final T setTargetFolderUuid(@NotNull String targetFolderUuid) {
        Intrinsics.checkNotNullParameter(targetFolderUuid, "targetFolderUuid");
        this.targetFolderUuid = targetFolderUuid;
        return self();
    }

    @NotNull
    public String toString() {
        return ", targetFolderUuid: " + this.targetFolderUuid + this.filterParam;
    }
}
