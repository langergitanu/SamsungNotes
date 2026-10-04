package com.samsung.android.support.senl.p148nt.base.common.sync;

import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/UserInfo;", "", GroupContract.Group.LEADER_ID, "", "creatorId", "creatorName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOwnerId", "()Ljava/lang/String;", "setOwnerId", "(Ljava/lang/String;)V", "getCreatorId", "setCreatorId", "getCreatorName", "setCreatorName", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UserInfo {

    @Nullable
    private String creatorId;

    @Nullable
    private String creatorName;

    @Nullable
    private String ownerId;

    public UserInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.ownerId = str;
        this.creatorId = str2;
        this.creatorName = str3;
    }

    @Nullable
    public final String getCreatorId() {
        return this.creatorId;
    }

    @Nullable
    public final String getCreatorName() {
        return this.creatorName;
    }

    @Nullable
    public final String getOwnerId() {
        return this.ownerId;
    }

    public final void setCreatorId(@Nullable String str) {
        this.creatorId = str;
    }

    public final void setCreatorName(@Nullable String str) {
        this.creatorName = str;
    }

    public final void setOwnerId(@Nullable String str) {
        this.ownerId = str;
    }
}
