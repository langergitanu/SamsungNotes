package com.samsung.android.support.senl.p148nt.base.common.sync;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 *2\u00020\u0001:\u0003()*J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J.\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0010H&J,\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0018\u0010\u000f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013\u0018\u00010\u0010H&J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u001e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH&J,\u0010\u001f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013\u0018\u00010 2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\bH&J\u001c\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\bH&J\u0014\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\bH&J&\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020\u0012H&R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract;", "", "requestConnectSessionAsync", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/sync/SesUiListener;", "requestDisConnectSessionAsync", "getSpaceName", "", "context", "Landroid/content/Context;", "spaceId", "updateWriterName", "groupId", GroupContract.Group.LEADER_ID, Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract$CoeditCallback;", "getMemberList", "", "", "Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract$MemberInfo;", "currentUserOwnerId", "getCurrentUserOwnerId", "()Ljava/lang/String;", "isStandaloneSpace", "(Ljava/lang/String;)Ljava/lang/Boolean;", "requestDeleteCoeditNote", "uuid", "requestDeleteCoeditSpace", "title", "requestLeaveCoeditSpace", "getMemberListLiveData", "Landroidx/lifecycle/LiveData;", "getLeaderId", "getCoeditNoteUserInfo", "Lcom/samsung/android/support/senl/nt/base/common/sync/UserInfo;", "docUuid", "getCoeditMemberManageIntent", "Landroid/content/Intent;", "isPickMode", "CoeditCallback", "MemberInfo", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface CoeditResolverContract {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String READ_AUTHORITY = "R";

    @NotNull
    public static final String WRITE_AUTHORITY = "W";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract$CoeditCallback;", "T", "", "onResult", "", "result", "(Ljava/lang/Object;)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface CoeditCallback<T> {
        void onResult(T result);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract$Companion;", "", "<init>", "()V", "READ_AUTHORITY", "", "WRITE_AUTHORITY", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String READ_AUTHORITY = "R";

        @NotNull
        public static final String WRITE_AUTHORITY = "W";

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sync/CoeditResolverContract$MemberInfo;", "", "memberId", "", "memberName", "authority", "uri", GroupContract.Group.EXPIRE_TIME, "", "status", "", "optionalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;)V", "getMemberId", "()Ljava/lang/String;", "setMemberId", "(Ljava/lang/String;)V", "getMemberName", "setMemberName", "getAuthority", "setAuthority", "getUri", "setUri", "getExpireTime", "()J", "setExpireTime", "(J)V", "getStatus", "()I", "setStatus", "(I)V", "getOptionalId", "setOptionalId", "hasReadAuthority", "", "hasWriteAuthority", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MemberInfo {

        @Nullable
        private String authority;
        private long expireTime;

        @NotNull
        private String memberId;

        @Nullable
        private String memberName;

        @Nullable
        private String optionalId;
        private int status;

        @Nullable
        private String uri;

        public MemberInfo(@NotNull String memberId, @Nullable String str, @Nullable String str2, @Nullable String str3, long j, int i, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(memberId, "memberId");
            this.memberId = memberId;
            this.memberName = str;
            this.authority = str2;
            this.uri = str3;
            this.expireTime = j;
            this.status = i;
            this.optionalId = str4;
        }

        @Nullable
        public final String getAuthority() {
            return this.authority;
        }

        public final long getExpireTime() {
            return this.expireTime;
        }

        @NotNull
        public final String getMemberId() {
            return this.memberId;
        }

        @Nullable
        public final String getMemberName() {
            return this.memberName;
        }

        @Nullable
        public final String getOptionalId() {
            return this.optionalId;
        }

        public final int getStatus() {
            return this.status;
        }

        @Nullable
        public final String getUri() {
            return this.uri;
        }

        public final boolean hasReadAuthority() {
            String str = this.authority;
            return str != null && StringsKt.m14162r(str, "R");
        }

        public final boolean hasWriteAuthority() {
            String str = this.authority;
            return str != null && StringsKt.m14162r(str, "W");
        }

        public final void setAuthority(@Nullable String str) {
            this.authority = str;
        }

        public final void setExpireTime(long j) {
            this.expireTime = j;
        }

        public final void setMemberId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.memberId = str;
        }

        public final void setMemberName(@Nullable String str) {
            this.memberName = str;
        }

        public final void setOptionalId(@Nullable String str) {
            this.optionalId = str;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final void setUri(@Nullable String str) {
            this.uri = str;
        }
    }

    @Nullable
    Intent getCoeditMemberManageIntent(@Nullable String groupId, @Nullable String title, boolean isPickMode);

    @Nullable
    UserInfo getCoeditNoteUserInfo(@Nullable String spaceId, @Nullable String docUuid);

    @Nullable
    String getCurrentUserOwnerId();

    @Nullable
    String getLeaderId(@Nullable String groupId);

    @Nullable
    List<MemberInfo> getMemberList(@Nullable String groupId);

    boolean getMemberList(@Nullable String groupId, @Nullable CoeditCallback<List<MemberInfo>> callback);

    @Nullable
    LiveData<List<MemberInfo>> getMemberListLiveData(@Nullable Context context, @NotNull String groupId);

    @Nullable
    String getSpaceName(@Nullable Context context, @Nullable String spaceId);

    @Nullable
    Boolean isStandaloneSpace(@Nullable String spaceId);

    void requestConnectSessionAsync(@Nullable SesUiListener listener);

    void requestDeleteCoeditNote(@Nullable String spaceId, @Nullable String uuid);

    void requestDeleteCoeditSpace(@Nullable String groupId, @Nullable String title);

    void requestDisConnectSessionAsync(@Nullable SesUiListener listener);

    void requestLeaveCoeditSpace(@Nullable String groupId, @Nullable String spaceId);

    void updateWriterName(@Nullable String groupId, @Nullable String ownerId, @Nullable CoeditCallback<String> callback);
}
