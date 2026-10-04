package io.netty.handler.codec.compression;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class ByteBufChecksum implements Checksum {
    private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
    private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
    private final ByteProcessor updateProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.ByteBufChecksum.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            ByteBufChecksum.this.update(b);
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReflectiveByteBufChecksum extends SlowByteBufChecksum {
        private final Method method;

        public ReflectiveByteBufChecksum(Checksum checksum, Method method) {
            super(checksum);
            this.method = method;
        }

        @Override // io.netty.handler.codec.compression.ByteBufChecksum
        public void update(ByteBuf byteBuf, int i, int i2) {
            if (byteBuf.hasArray()) {
                update(byteBuf.array(), byteBuf.arrayOffset() + i, i2);
            } else {
                this.method.invoke(this.checksum, CompressionUtil.safeNioBuffer(byteBuf, i, i2));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SlowByteBufChecksum extends ByteBufChecksum {
        protected final Checksum checksum;

        public SlowByteBufChecksum(Checksum checksum) {
            this.checksum = checksum;
        }

        @Override // java.util.zip.Checksum
        public long getValue() {
            return this.checksum.getValue();
        }

        @Override // java.util.zip.Checksum
        public void reset() {
            this.checksum.reset();
        }

        @Override // java.util.zip.Checksum
        public void update(int i) {
            this.checksum.update(i);
        }

        @Override // java.util.zip.Checksum
        public void update(byte[] bArr, int i, int i2) {
            this.checksum.update(bArr, i, i2);
        }
    }

    private static Method updateByteBuffer(Checksum checksum) {
        if (PlatformDependent.javaVersion() >= 8) {
            try {
                Method declaredMethod = checksum.getClass().getDeclaredMethod(Constants.ARG_UPDATE, ByteBuffer.class);
                declaredMethod.invoke(checksum, ByteBuffer.allocate(1));
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static ByteBufChecksum wrapChecksum(Checksum checksum) {
        Method method;
        Method method2;
        ObjectUtil.checkNotNull(checksum, "checksum");
        return checksum instanceof ByteBufChecksum ? (ByteBufChecksum) checksum : (!(checksum instanceof Adler32) || (method2 = ADLER32_UPDATE_METHOD) == null) ? (!(checksum instanceof CRC32) || (method = CRC32_UPDATE_METHOD) == null) ? new SlowByteBufChecksum(checksum) : new ReflectiveByteBufChecksum(checksum, method) : new ReflectiveByteBufChecksum(checksum, method2);
    }

    public void update(ByteBuf byteBuf, int i, int i2) {
        if (byteBuf.hasArray()) {
            update(byteBuf.array(), byteBuf.arrayOffset() + i, i2);
        } else {
            byteBuf.forEachByte(i, i2, this.updateProcessor);
        }
    }
}
