package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class NetUtilInitializations {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NetUtilInitializations.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class NetworkIfaceAndInetAddress {
        private final InetAddress address;
        private final NetworkInterface iface;

        public NetworkIfaceAndInetAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
            this.iface = networkInterface;
            this.address = inetAddress;
        }

        public InetAddress address() {
            return this.address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }
    }

    private NetUtilInitializations() {
    }

    public static Inet4Address createLocalhost4() {
        try {
            return (Inet4Address) InetAddress.getByAddress(StringLookupFactory.KEY_LOCALHOST, new byte[]{127, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    public static Inet6Address createLocalhost6() {
        try {
            return (Inet6Address) InetAddress.getByAddress(StringLookupFactory.KEY_LOCALHOST, new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        r5 = r4.nextElement();
        r3 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static NetworkIfaceAndInetAddress determineLoopback(Collection<NetworkInterface> collection, Inet4Address inet4Address, Inet6Address inet6Address) {
        NetworkInterface networkInterface;
        InetAddress inetAddressNextElement;
        InetAddress inetAddress;
        InetAddress inetAddress2;
        ArrayList arrayList = new ArrayList();
        for (NetworkInterface networkInterface2 : collection) {
            if (SocketUtils.addressesFromNetworkInterface(networkInterface2).hasMoreElements()) {
                arrayList.add(networkInterface2);
            }
        }
        Iterator it = arrayList.iterator();
        loop1: while (true) {
            if (!it.hasNext()) {
                networkInterface = null;
                inetAddressNextElement = null;
                break;
            }
            networkInterface = (NetworkInterface) it.next();
            Enumeration<InetAddress> enumerationAddressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
            while (enumerationAddressesFromNetworkInterface.hasMoreElements()) {
                inetAddressNextElement = enumerationAddressesFromNetworkInterface.nextElement();
                if (inetAddressNextElement.isLoopbackAddress()) {
                    break loop1;
                }
            }
        }
        if (networkInterface == null) {
            try {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    NetworkInterface networkInterface3 = (NetworkInterface) it2.next();
                    if (networkInterface3.isLoopback()) {
                        Enumeration<InetAddress> enumerationAddressesFromNetworkInterface2 = SocketUtils.addressesFromNetworkInterface(networkInterface3);
                        if (enumerationAddressesFromNetworkInterface2.hasMoreElements()) {
                            try {
                                break;
                            } catch (SocketException e) {
                                e = e;
                                networkInterface = networkInterface3;
                                logger.warn("Failed to find the loopback interface", (Throwable) e);
                            }
                        }
                    }
                }
                if (networkInterface == null) {
                    logger.warn("Failed to find the loopback interface");
                }
            } catch (SocketException e2) {
                e = e2;
            }
        }
        if (networkInterface == null) {
            if (inetAddressNextElement == null) {
                try {
                    if (NetworkInterface.getByInetAddress(inet6Address) != null) {
                        logger.debug("Using hard-coded IPv6 localhost address: {}", inet6Address);
                        inetAddress = inet6Address;
                    } else {
                        inetAddress = inetAddressNextElement;
                    }
                } catch (Exception unused) {
                    if (inetAddressNextElement != null) {
                        inetAddress2 = inetAddressNextElement;
                    }
                    return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
                } catch (Throwable th) {
                    if (inetAddressNextElement == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                    }
                    throw th;
                }
                if (inetAddress == null) {
                    logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                    inetAddress2 = inet4Address;
                } else {
                    inetAddress2 = inetAddress;
                }
            }
            return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
        }
        logger.debug("Loopback interface: {} ({}, {})", networkInterface.getName(), networkInterface.getDisplayName(), inetAddressNextElement.getHostAddress());
        inetAddress2 = inetAddressNextElement;
        return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
    }

    public static Collection<NetworkInterface> networkInterfaces() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    arrayList.add(networkInterfaces.nextElement());
                }
            }
        } catch (NullPointerException e) {
            if (!PlatformDependent.isAndroid()) {
                throw e;
            }
        } catch (SocketException e2) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
