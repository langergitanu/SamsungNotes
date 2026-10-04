package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Signal extends Error implements Constant<Signal> {
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        @Override // io.netty.util.ConstantPool
        public Signal newConstant(int i, String str) {
            return new Signal(i, str);
        }
    };
    private static final long serialVersionUID = -221145131122459977L;
    private final SignalConstant constant;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SignalConstant extends AbstractConstant<SignalConstant> {
        public SignalConstant(int i, String str) {
            super(i, str);
        }
    }

    public static Signal valueOf(String str) {
        return (Signal) pool.valueOf(str);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public void expect(Signal signal) {
        if (this == signal) {
            return;
        }
        throw new IllegalStateException("unexpected signal: " + signal);
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // io.netty.util.Constant
    /* JADX INFO: renamed from: id */
    public int mo13776id() {
        return this.constant.mo13776id();
    }

    @Override // io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return name();
    }

    private Signal(int i, String str) {
        this.constant = new SignalConstant(i, str);
    }

    public static Signal valueOf(Class<?> cls, String str) {
        return (Signal) pool.valueOf(cls, str);
    }

    @Override // java.lang.Comparable
    public int compareTo(Signal signal) {
        if (this == signal) {
            return 0;
        }
        return this.constant.compareTo(signal.constant);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        return this;
    }
}
