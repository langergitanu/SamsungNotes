package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\bJ\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eX\u0082\u0004¢\u0006\n\n\u0002\u0010\u0011\u0012\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, m13886d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "<init>", "(I)V", "getSize", "(Ljava/lang/Object;)I", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;

    @NotNull
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int i) {
        this.size = i;
        this.spreads = (T[]) new Object[i];
    }

    public final void addSpread(@NotNull T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        T[] tArr = this.spreads;
        int i = this.position;
        this.position = i + 1;
        tArr[i] = spreadArgument;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(@NotNull T t);

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int size() {
        int i = this.size - 1;
        int size = 0;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                T t = this.spreads[i2];
                size += t != null ? getSize(t) : 1;
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return size;
    }

    @NotNull
    public final T toArray(@NotNull T values, @NotNull T result) {
        int i;
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(result, "result");
        int i2 = this.size - 1;
        int i4 = 0;
        if (i2 >= 0) {
            int i5 = 0;
            int i6 = 0;
            i = 0;
            while (true) {
                T t = this.spreads[i5];
                if (t != null) {
                    if (i6 < i5) {
                        int i7 = i5 - i6;
                        System.arraycopy(values, i6, result, i, i7);
                        i += i7;
                    }
                    int size = getSize(t);
                    System.arraycopy(t, 0, result, i, size);
                    i += size;
                    i6 = i5 + 1;
                }
                if (i5 == i2) {
                    break;
                }
                i5++;
            }
            i4 = i6;
        } else {
            i = 0;
        }
        int i8 = this.size;
        if (i4 < i8) {
            System.arraycopy(values, i4, result, i, i8 - i4);
        }
        return result;
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }
}
