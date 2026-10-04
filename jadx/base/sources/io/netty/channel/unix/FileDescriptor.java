package io.netty.channel.unix;

import io.netty.channel.unix.Errors;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FileDescriptor {
    private static final int STATE_ALL_MASK = 7;
    private static final int STATE_CLOSED_MASK = 1;
    private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
    private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
    private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, "state");

    /* JADX INFO: renamed from: fd */
    final int f8867fd;
    volatile int state;

    public FileDescriptor(int i) {
        ObjectUtil.checkPositiveOrZero(i, "fd");
        this.f8867fd = i;
    }

    private static native int close(int i);

    public static FileDescriptor from(String str) throws Errors.NativeIoException {
        int iOpen = open((String) ObjectUtil.checkNotNull(str, "path"));
        if (iOpen >= 0) {
            return new FileDescriptor(iOpen);
        }
        throw Errors.newIOException(AbstractCircuitBreaker.PROPERTY_NAME, iOpen);
    }

    public static int inputShutdown(int i) {
        return i | 2;
    }

    public static boolean isClosed(int i) {
        return (i & 1) != 0;
    }

    public static boolean isInputShutdown(int i) {
        return (i & 2) != 0;
    }

    public static boolean isOutputShutdown(int i) {
        return (i & 4) != 0;
    }

    private static native long newPipe();

    private static native int open(String str);

    public static int outputShutdown(int i) {
        return i | 4;
    }

    public static FileDescriptor[] pipe() throws Errors.NativeIoException {
        long jNewPipe = newPipe();
        if (jNewPipe >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (jNewPipe >>> 32)), new FileDescriptor((int) jNewPipe)};
        }
        throw Errors.newIOException("newPipe", (int) jNewPipe);
    }

    private static native int read(int i, ByteBuffer byteBuffer, int i2, int i4);

    private static native int readAddress(int i, long j, int i2, int i4);

    private static native int write(int i, ByteBuffer byteBuffer, int i2, int i4);

    private static native int writeAddress(int i, long j, int i2, int i4);

    private static native long writev(int i, ByteBuffer[] byteBufferArr, int i2, int i4, long j);

    private static native long writevAddresses(int i, long j, int i2);

    public final boolean casState(int i, int i2) {
        return stateUpdater.compareAndSet(this, i, i2);
    }

    public void close() throws Errors.NativeIoException {
        int iClose;
        if (markClosed() && (iClose = close(this.f8867fd)) < 0) {
            throw Errors.newIOException("close", iClose);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FileDescriptor) && this.f8867fd == ((FileDescriptor) obj).f8867fd;
    }

    public int hashCode() {
        return this.f8867fd;
    }

    public final int intValue() {
        return this.f8867fd;
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public boolean markClosed() {
        int i;
        do {
            i = this.state;
            if (isClosed(i)) {
                return false;
            }
        } while (!casState(i, i | 7));
        return true;
    }

    public final int read(ByteBuffer byteBuffer, int i, int i2) {
        int i4 = read(this.f8867fd, byteBuffer, i, i2);
        if (i4 > 0) {
            return i4;
        }
        if (i4 == 0) {
            return -1;
        }
        return Errors.ioResult("read", i4);
    }

    public final int readAddress(long j, int i, int i2) {
        int address = readAddress(this.f8867fd, j, i, i2);
        if (address > 0) {
            return address;
        }
        if (address == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", address);
    }

    public String toString() {
        return AbstractC0000a.m13j(new StringBuilder("FileDescriptor{fd="), this.f8867fd, '}');
    }

    public final int write(ByteBuffer byteBuffer, int i, int i2) {
        int iWrite = write(this.f8867fd, byteBuffer, i, i2);
        return iWrite >= 0 ? iWrite : Errors.ioResult("write", iWrite);
    }

    public final int writeAddress(long j, int i, int i2) {
        int iWriteAddress = writeAddress(this.f8867fd, j, i, i2);
        return iWriteAddress >= 0 ? iWriteAddress : Errors.ioResult("writeAddress", iWriteAddress);
    }

    public final long writev(ByteBuffer[] byteBufferArr, int i, int i2, long j) {
        long jWritev = writev(this.f8867fd, byteBufferArr, i, Math.min(Limits.IOV_MAX, i2), j);
        return jWritev >= 0 ? jWritev : Errors.ioResult("writev", (int) jWritev);
    }

    public final long writevAddresses(long j, int i) {
        long jWritevAddresses = writevAddresses(this.f8867fd, j, i);
        return jWritevAddresses >= 0 ? jWritevAddresses : Errors.ioResult("writevAddresses", (int) jWritevAddresses);
    }

    public static FileDescriptor from(File file) {
        return from(((File) ObjectUtil.checkNotNull(file, "file")).getPath());
    }
}
