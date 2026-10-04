package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
public final class EquivalentAddressGroup {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6138")
    public static final Attributes.Key<String> ATTR_AUTHORITY_OVERRIDE = Attributes.Key.create("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");
    private final List<SocketAddress> addrs;
    private final Attributes attrs;
    private final int hashCode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Attr {
    }

    public EquivalentAddressGroup(List<SocketAddress> list) {
        this(list, Attributes.EMPTY);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EquivalentAddressGroup)) {
            return false;
        }
        EquivalentAddressGroup equivalentAddressGroup = (EquivalentAddressGroup) obj;
        if (this.addrs.size() != equivalentAddressGroup.addrs.size()) {
            return false;
        }
        for (int i = 0; i < this.addrs.size(); i++) {
            if (!this.addrs.get(i).equals(equivalentAddressGroup.addrs.get(i))) {
                return false;
            }
        }
        return this.attrs.equals(equivalentAddressGroup.attrs);
    }

    public List<SocketAddress> getAddresses() {
        return this.addrs;
    }

    public Attributes getAttributes() {
        return this.attrs;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "[" + this.addrs + "/" + this.attrs + "]";
    }

    public EquivalentAddressGroup(List<SocketAddress> list, Attributes attributes) {
        Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
        List<SocketAddress> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.addrs = listUnmodifiableList;
        this.attrs = (Attributes) Preconditions.checkNotNull(attributes, "attrs");
        this.hashCode = listUnmodifiableList.hashCode();
    }

    public EquivalentAddressGroup(SocketAddress socketAddress) {
        this(socketAddress, Attributes.EMPTY);
    }

    public EquivalentAddressGroup(SocketAddress socketAddress, Attributes attributes) {
        this((List<SocketAddress>) Collections.singletonList(socketAddress), attributes);
    }
}
