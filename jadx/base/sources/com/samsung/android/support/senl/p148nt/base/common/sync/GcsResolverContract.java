package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J.\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0010H&¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract;", "", "requestConnectSessionAsync", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/SesUiListener;", "requestDisConnectSessionAsync", "getSpaceName", "", "context", "Landroid/content/Context;", "spaceId", "updateWriterName", "groupId", GroupContract.Group.LEADER_ID, Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract$GcsCallback;", "GcsCallback", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface GcsResolverContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/GcsResolverContract$GcsCallback;", "T", "", "onResult", "", "result", "(Ljava/lang/Object;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface GcsCallback<T> {
        void onResult(T result);
    }

    @Nullable
    String getSpaceName(@Nullable Context context, @Nullable String spaceId);

    void requestConnectSessionAsync(@Nullable SesUiListener listener);

    void requestDisConnectSessionAsync(@Nullable SesUiListener listener);

    void updateWriterName(@Nullable String groupId, @Nullable String ownerId, @Nullable GcsCallback<String> callback);
}
