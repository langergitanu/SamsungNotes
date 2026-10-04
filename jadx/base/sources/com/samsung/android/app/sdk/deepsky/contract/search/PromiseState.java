package com.samsung.android.app.sdk.deepsky.contract.search;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/PromiseState;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "PENDING", "FULFILLED", "REJECTED", "UNKNOWN", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public enum PromiseState {
    PENDING("pending"),
    FULFILLED("fulfilled"),
    REJECTED("rejected"),
    UNKNOWN("unknown");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String id;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/PromiseState$Companion;", "", "()V", "fromId", "Lcom/samsung/android/app/sdk/deepsky/contract/search/PromiseState;", "id", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nsearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/PromiseState$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,355:1\n1282#2,2:356\n*S KotlinDebug\n*F\n+ 1 search.kt\ncom/samsung/android/app/sdk/deepsky/contract/search/PromiseState$Companion\n*L\n299#1:356,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PromiseState fromId(@NotNull String id) {
            PromiseState promiseState;
            Intrinsics.checkNotNullParameter(id, "id");
            PromiseState[] promiseStateArrValues = PromiseState.values();
            int length = promiseStateArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    promiseState = null;
                    break;
                }
                promiseState = promiseStateArrValues[i];
                if (Intrinsics.areEqual(promiseState.getId(), id)) {
                    break;
                }
                i++;
            }
            return promiseState == null ? PromiseState.UNKNOWN : promiseState;
        }

        private Companion() {
        }
    }

    PromiseState(String str) {
        this.id = str;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }
}
