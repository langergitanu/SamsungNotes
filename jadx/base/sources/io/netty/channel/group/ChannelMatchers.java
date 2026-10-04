package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ServerChannel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ChannelMatchers {
    private static final ChannelMatcher ALL_MATCHER = new ChannelMatcher() { // from class: io.netty.channel.group.ChannelMatchers.1
        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return true;
        }
    };
    private static final ChannelMatcher SERVER_CHANNEL_MATCHER = isInstanceOf(ServerChannel.class);
    private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER = isNotInstanceOf(ServerChannel.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClassMatcher implements ChannelMatcher {
        private final Class<? extends Channel> clazz;

        public ClassMatcher(Class<? extends Channel> cls) {
            this.clazz = cls;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.clazz.isInstance(channel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CompositeMatcher implements ChannelMatcher {
        private final ChannelMatcher[] matchers;

        public CompositeMatcher(ChannelMatcher... channelMatcherArr) {
            this.matchers = channelMatcherArr;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            for (ChannelMatcher channelMatcher : this.matchers) {
                if (!channelMatcher.matches(channel)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InstanceMatcher implements ChannelMatcher {
        private final Channel channel;

        public InstanceMatcher(Channel channel) {
            this.channel = channel;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.channel == channel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InvertMatcher implements ChannelMatcher {
        private final ChannelMatcher matcher;

        public InvertMatcher(ChannelMatcher channelMatcher) {
            this.matcher = channelMatcher;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return !this.matcher.matches(channel);
        }
    }

    private ChannelMatchers() {
    }

    public static ChannelMatcher all() {
        return ALL_MATCHER;
    }

    public static ChannelMatcher compose(ChannelMatcher... channelMatcherArr) {
        if (channelMatcherArr.length >= 1) {
            return channelMatcherArr.length == 1 ? channelMatcherArr[0] : new CompositeMatcher(channelMatcherArr);
        }
        throw new IllegalArgumentException("matchers must at least contain one element");
    }

    public static ChannelMatcher invert(ChannelMatcher channelMatcher) {
        return new InvertMatcher(channelMatcher);
    }

    /* JADX INFO: renamed from: is */
    public static ChannelMatcher m13766is(Channel channel) {
        return new InstanceMatcher(channel);
    }

    public static ChannelMatcher isInstanceOf(Class<? extends Channel> cls) {
        return new ClassMatcher(cls);
    }

    public static ChannelMatcher isNonServerChannel() {
        return NON_SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher isNot(Channel channel) {
        return invert(m13766is(channel));
    }

    public static ChannelMatcher isNotInstanceOf(Class<? extends Channel> cls) {
        return invert(isInstanceOf(cls));
    }

    public static ChannelMatcher isServerChannel() {
        return SERVER_CHANNEL_MATCHER;
    }
}
