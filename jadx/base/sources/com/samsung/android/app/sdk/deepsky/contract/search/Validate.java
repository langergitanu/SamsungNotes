package com.samsung.android.app.sdk.deepsky.contract.search;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/Validate;", "", "()V", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Validate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0087\bø\u0001\u0000J3\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u0001H\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/contract/search/Validate$Companion;", "", "()V", "checkTrue", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "notNull", "T", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void checkTrue(boolean value, @NotNull Function0<? extends Object> lazyMessage) {
            Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
            if (!value) {
                throw new SearchException(lazyMessage.invoke().toString());
            }
        }

        @JvmStatic
        @NotNull
        public final <T> T notNull(@Nullable T value, @NotNull Function0<? extends Object> lazyMessage) {
            Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
            if (value != null) {
                return value;
            }
            throw new SearchException(lazyMessage.invoke().toString());
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final void checkTrue(boolean z, @NotNull Function0<? extends Object> function0) {
        INSTANCE.checkTrue(z, function0);
    }

    @JvmStatic
    @NotNull
    public static final <T> T notNull(@Nullable T t, @NotNull Function0<? extends Object> function0) {
        return (T) INSTANCE.notNull(t, function0);
    }
}
