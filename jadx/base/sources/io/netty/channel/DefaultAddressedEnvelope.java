package io.netty.channel;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultAddressedEnvelope<M, A extends SocketAddress> implements AddressedEnvelope<M, A> {
    private final M message;
    private final A recipient;
    private final A sender;

    public DefaultAddressedEnvelope(M m, A a, A a3) {
        ObjectUtil.checkNotNull(m, "message");
        if (a == null && a3 == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.message = m;
        this.sender = a3;
        this.recipient = a;
    }

    @Override // io.netty.channel.AddressedEnvelope
    public M content() {
        return this.message;
    }

    @Override // io.netty.channel.AddressedEnvelope
    public A recipient() {
        return this.recipient;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        M m = this.message;
        if (m instanceof ReferenceCounted) {
            return ((ReferenceCounted) m).refCnt();
        }
        return 1;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return ReferenceCountUtil.release(this.message);
    }

    @Override // io.netty.channel.AddressedEnvelope
    public A sender() {
        return this.sender;
    }

    public String toString() {
        if (this.sender == null) {
            return StringUtil.simpleClassName(this) + "(=> " + this.recipient + SQLKeyword.COMMA + this.message + PropertyUtils.MAPPED_DELIM2;
        }
        return StringUtil.simpleClassName(this) + PropertyUtils.MAPPED_DELIM + this.sender + " => " + this.recipient + SQLKeyword.COMMA + this.message + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return ReferenceCountUtil.release(this.message, i);
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain() {
        ReferenceCountUtil.retain(this.message);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch() {
        ReferenceCountUtil.touch(this.message);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain(int i) {
        ReferenceCountUtil.retain(this.message, i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch(Object obj) {
        ReferenceCountUtil.touch(this.message, obj);
        return this;
    }

    public DefaultAddressedEnvelope(M m, A a) {
        this(m, a, null);
    }
}
