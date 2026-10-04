package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ApplicationProtocolConfig {
    public static final ApplicationProtocolConfig DISABLED = new ApplicationProtocolConfig();
    private final Protocol protocol;
    private final SelectedListenerFailureBehavior selectedBehavior;
    private final SelectorFailureBehavior selectorBehavior;
    private final List<String> supportedProtocols;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Protocol {
        NONE,
        NPN,
        ALPN,
        NPN_AND_ALPN
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SelectedListenerFailureBehavior {
        ACCEPT,
        FATAL_ALERT,
        CHOOSE_MY_LAST_PROTOCOL
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SelectorFailureBehavior {
        FATAL_ALERT,
        NO_ADVERTISE,
        CHOOSE_MY_LAST_PROTOCOL
    }

    public ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, Iterable<String> iterable) {
        this(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, ApplicationProtocolUtil.toList(iterable));
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
        return this.selectedBehavior;
    }

    public SelectorFailureBehavior selectorFailureBehavior() {
        return this.selectorBehavior;
    }

    public List<String> supportedProtocols() {
        return this.supportedProtocols;
    }

    public ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, String... strArr) {
        this(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, ApplicationProtocolUtil.toList(strArr));
    }

    private ApplicationProtocolConfig(Protocol protocol, SelectorFailureBehavior selectorFailureBehavior, SelectedListenerFailureBehavior selectedListenerFailureBehavior, List<String> list) {
        this.supportedProtocols = Collections.unmodifiableList((List) ObjectUtil.checkNotNull(list, "supportedProtocols"));
        this.protocol = (Protocol) ObjectUtil.checkNotNull(protocol, "protocol");
        this.selectorBehavior = (SelectorFailureBehavior) ObjectUtil.checkNotNull(selectorFailureBehavior, "selectorBehavior");
        this.selectedBehavior = (SelectedListenerFailureBehavior) ObjectUtil.checkNotNull(selectedListenerFailureBehavior, "selectedBehavior");
        Protocol protocol2 = Protocol.NONE;
        if (protocol != protocol2) {
            ObjectUtil.checkNonEmpty(list, "supportedProtocols");
            return;
        }
        throw new IllegalArgumentException("protocol (" + protocol2 + ") must not be " + protocol2 + '.');
    }

    private ApplicationProtocolConfig() {
        this.supportedProtocols = Collections.EMPTY_LIST;
        this.protocol = Protocol.NONE;
        this.selectorBehavior = SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        this.selectedBehavior = SelectedListenerFailureBehavior.ACCEPT;
    }
}
