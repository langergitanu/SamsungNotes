package androidx.compose.p109ui.input.nestedscroll;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface NestedScrollConnection {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m19598onPostFlingRZ2iAVY(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.super.mo15655onPostFlingRZ2iAVY(j, j2, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m19599onPostScrollDzOQY0M(@NotNull NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            return NestedScrollConnection.super.mo15656onPostScrollDzOQY0M(j, j2, i);
        }

        @Deprecated
        @Nullable
        /* JADX INFO: renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m19600onPreFlingQWom1Mo(@NotNull NestedScrollConnection nestedScrollConnection, long j, @NotNull Continuation<? super Velocity> continuation) {
            return NestedScrollConnection.super.mo15929onPreFlingQWom1Mo(j, continuation);
        }

        @Deprecated
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m19601onPreScrollOzD1aCk(@NotNull NestedScrollConnection nestedScrollConnection, long j, int i) {
            return NestedScrollConnection.super.mo15930onPreScrollOzD1aCk(j, i);
        }
    }

    /* JADX INFO: renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m19596onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
        return Velocity.m21196boximpl(Velocity.INSTANCE.m21216getZero9UxMQ8M());
    }

    /* JADX INFO: renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m19597onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
        return Velocity.m21196boximpl(Velocity.INSTANCE.m21216getZero9UxMQ8M());
    }

    @Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    default Object mo15655onPostFlingRZ2iAVY(long j, long j2, @NotNull Continuation<? super Velocity> continuation) {
        return m19596onPostFlingRZ2iAVY$suspendImpl(this, j, j2, continuation);
    }

    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    default long mo15656onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.INSTANCE.m18300getZeroF1C5BW0();
    }

    @Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    default Object mo15929onPreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        return m19597onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    default long mo15930onPreScrollOzD1aCk(long available, int source) {
        return Offset.INSTANCE.m18300getZeroF1C5BW0();
    }
}
