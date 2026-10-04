package com.samsung.android.support.senl.p148nt.base.common.access.hashtag;

import com.samsung.android.support.senl.p148nt.base.common.tag.HashTagData;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tH\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/hashtag/HashTagAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HASH_TAG_NOTES_ACTIVITY_CLASS", "Ljava/lang/Class;", "sContract", "Lcom/samsung/android/support/senl/nt/base/common/access/hashtag/HashTagAccessHandler$HashTagAccessContract;", "getSContract", "()Lcom/samsung/android/support/senl/nt/base/common/access/hashtag/HashTagAccessHandler$HashTagAccessContract;", "setSContract", "(Lcom/samsung/android/support/senl/nt/base/common/access/hashtag/HashTagAccessHandler$HashTagAccessContract;)V", "getHashTagNotesActivityClass", "setHashTagNotesActivityClass", "", "executor", "setContract", "contract", "getContract", "HashTagAccessContract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HashTagAccessHandler {

    @Nullable
    private static Class<?> HASH_TAG_NOTES_ACTIVITY_CLASS = null;

    @NotNull
    public static final HashTagAccessHandler INSTANCE = new HashTagAccessHandler();

    @NotNull
    private static final String TAG = "HashTagAccessHandler";

    @Nullable
    private static HashTagAccessContract sContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/hashtag/HashTagAccessHandler$HashTagAccessContract;", "", "getHashTagData", "", "Lcom/samsung/android/support/senl/nt/base/common/tag/HashTagData;", "docUuid", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface HashTagAccessContract {
        @Nullable
        List<HashTagData> getHashTagData(@Nullable String docUuid);
    }

    private HashTagAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final HashTagAccessContract getContract() {
        return sContract;
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getHashTagNotesActivityClass() {
        return HASH_TAG_NOTES_ACTIVITY_CLASS;
    }

    @JvmStatic
    public static final void setContract(@NotNull HashTagAccessContract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        sContract = contract;
    }

    @JvmStatic
    public static final void setHashTagNotesActivityClass(@Nullable Class<?> executor) {
        if (HASH_TAG_NOTES_ACTIVITY_CLASS != null) {
            Logger.m8698e(TAG, "setHashTagNotesActivityClass, twice access! only first trial is accepted");
        } else {
            HASH_TAG_NOTES_ACTIVITY_CLASS = executor;
            Logger.m8697d(TAG, "setHashTagNotesActivityClass. ");
        }
    }

    @Nullable
    public final HashTagAccessContract getSContract() {
        return sContract;
    }

    public final void setSContract(@Nullable HashTagAccessContract hashTagAccessContract) {
        sContract = hashTagAccessContract;
    }
}
