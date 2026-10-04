package com.google.common.hash;

import androidx.glance.AbstractC2821a;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c */
    private final int f3381c;

    /* JADX INFO: renamed from: d */
    private final int f3382d;

    /* JADX INFO: renamed from: k0 */
    private final long f3383k0;

    /* JADX INFO: renamed from: k1 */
    private final long f3384k1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* JADX INFO: renamed from: b */
        private long f3385b;

        /* JADX INFO: renamed from: c */
        private final int f3386c;

        /* JADX INFO: renamed from: d */
        private final int f3387d;
        private long finalM;

        /* JADX INFO: renamed from: v0 */
        private long f3388v0;

        /* JADX INFO: renamed from: v1 */
        private long f3389v1;

        /* JADX INFO: renamed from: v2 */
        private long f3390v2;

        /* JADX INFO: renamed from: v3 */
        private long f3391v3;

        public SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f3385b = 0L;
            this.finalM = 0L;
            this.f3386c = i;
            this.f3387d = i2;
            this.f3388v0 = 8317987319222330741L ^ j;
            this.f3389v1 = 7237128888997146477L ^ j2;
            this.f3390v2 = 7816392313619706465L ^ j;
            this.f3391v3 = 8387220255154660723L ^ j2;
        }

        private void processM(long j) {
            this.f3391v3 ^= j;
            sipRound(this.f3386c);
            this.f3388v0 = j ^ this.f3388v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f3388v0;
                long j2 = this.f3389v1;
                this.f3388v0 = j + j2;
                this.f3390v2 += this.f3391v3;
                this.f3389v1 = Long.rotateLeft(j2, 13);
                long jRotateLeft = Long.rotateLeft(this.f3391v3, 16);
                long j3 = this.f3389v1;
                long j5 = this.f3388v0;
                this.f3389v1 = j3 ^ j5;
                this.f3391v3 = jRotateLeft ^ this.f3390v2;
                long jRotateLeft2 = Long.rotateLeft(j5, 32);
                long j6 = this.f3390v2;
                long j7 = this.f3389v1;
                this.f3390v2 = j6 + j7;
                this.f3388v0 = jRotateLeft2 + this.f3391v3;
                this.f3389v1 = Long.rotateLeft(j7, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f3391v3, 21);
                long j8 = this.f3389v1;
                long j9 = this.f3390v2;
                this.f3389v1 = j8 ^ j9;
                this.f3391v3 = jRotateLeft3 ^ this.f3388v0;
                this.f3390v2 = Long.rotateLeft(j9, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j = this.finalM ^ (this.f3385b << 56);
            this.finalM = j;
            processM(j);
            this.f3390v2 ^= 255;
            sipRound(this.f3387d);
            return HashCode.fromLong(((this.f3388v0 ^ this.f3389v1) ^ this.f3390v2) ^ this.f3391v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            this.f3385b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f3385b += (long) byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i;
                i += 8;
            }
        }
    }

    public SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f3381c = i;
        this.f3382d = i2;
        this.f3383k0 = j;
        this.f3384k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            if (this.f3381c == sipHashFunction.f3381c && this.f3382d == sipHashFunction.f3382d && this.f3383k0 == sipHashFunction.f3383k0 && this.f3384k1 == sipHashFunction.f3384k1) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f3381c) ^ this.f3382d)) ^ this.f3383k0) ^ this.f3384k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f3381c, this.f3382d, this.f3383k0, this.f3384k1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Hashing.sipHash");
        sb.append(this.f3381c);
        sb.append("");
        sb.append(this.f3382d);
        sb.append("(");
        sb.append(this.f3383k0);
        sb.append(SQLKeyword.COMMA);
        return AbstractC2821a.m2224o(sb, ")", this.f3384k1);
    }
}
