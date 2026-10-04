package androidx.glance.action;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\u00010\u0004H&J!\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H¦\u0002J(\u0010\n\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005H¦\u0002¢\u0006\u0002\u0010\u000bJ-\u0010\f\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\u0006\u0010\r\u001a\u0002H\bH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H&¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/action/ActionParameters;", "", "()V", "asMap", "", "Landroidx/glance/action/ActionParameters$Key;", "contains", "", "T", "key", "get", "(Landroidx/glance/action/ActionParameters$Key;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Landroidx/glance/action/ActionParameters$Key;Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "Key", "Pair", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class ActionParameters {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 2)
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/action/ActionParameters$Key;", "T", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "to", "Landroidx/glance/action/ActionParameters$Pair;", "value", "(Ljava/lang/Object;)Landroidx/glance/action/ActionParameters$Pair;", "toString", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Key<T> {
        public static final int $stable = 0;

        @NotNull
        private final String name;

        public Key(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public boolean equals(@Nullable Object other) {
            return (other instanceof Key) && Intrinsics.areEqual(this.name, ((Key) other).name);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        @NotNull
        /* JADX INFO: renamed from: to */
        public final Pair<T> m2236to(@NotNull T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Pair<>(this, value);
        }

        @NotNull
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 1)
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001d\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/action/ActionParameters$Pair;", "T", "", "key", "Landroidx/glance/action/ActionParameters$Key;", "value", "(Landroidx/glance/action/ActionParameters$Key;Ljava/lang/Object;)V", "getKey$glance_release", "()Landroidx/glance/action/ActionParameters$Key;", "getValue$glance_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Pair<T> {
        public static final int $stable = 0;

        @NotNull
        private final Key<T> key;

        @NotNull
        private final T value;

        public Pair(@NotNull Key<T> key, @NotNull T value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.key = key;
            this.value = value;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) other;
            return Intrinsics.areEqual(this.key, pair.key) && Intrinsics.areEqual(this.value, pair.value);
        }

        @NotNull
        public final Key<T> getKey$glance_release() {
            return this.key;
        }

        @NotNull
        public final T getValue$glance_release() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode() + this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "(" + this.key.getName() + SQLKeyword.COMMA + this.value + ")";
        }
    }

    @NotNull
    public abstract Map<Key<? extends Object>, Object> asMap();

    public abstract <T> boolean contains(@NotNull Key<T> key);

    @Nullable
    public abstract <T> T get(@NotNull Key<T> key);

    @NotNull
    public abstract <T> T getOrDefault(@NotNull Key<T> key, @NotNull T defaultValue);

    public abstract boolean isEmpty();
}
