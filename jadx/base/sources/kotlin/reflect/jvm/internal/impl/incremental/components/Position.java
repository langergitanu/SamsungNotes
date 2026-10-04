package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Position implements Serializable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Position NO_POSITION = new Position(-1, -1);
    private final int column;
    private final int line;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Position getNO_POSITION() {
            return Position.NO_POSITION;
        }

        private Companion() {
        }
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        return this.line == position.line && this.column == position.column;
    }

    public int hashCode() {
        return Integer.hashCode(this.column) + (Integer.hashCode(this.line) * 31);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Position(line=");
        sb.append(this.line);
        sb.append(", column=");
        return AbstractC0000a.m13j(sb, this.column, PropertyUtils.MAPPED_DELIM2);
    }
}
