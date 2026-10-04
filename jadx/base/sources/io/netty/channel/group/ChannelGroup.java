package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelGroup extends Set<Channel>, Comparable<ChannelGroup> {
    ChannelGroupFuture close();

    ChannelGroupFuture close(ChannelMatcher channelMatcher);

    @Deprecated
    ChannelGroupFuture deregister();

    @Deprecated
    ChannelGroupFuture deregister(ChannelMatcher channelMatcher);

    ChannelGroupFuture disconnect();

    ChannelGroupFuture disconnect(ChannelMatcher channelMatcher);

    Channel find(ChannelId channelId);

    ChannelGroup flush();

    ChannelGroup flush(ChannelMatcher channelMatcher);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj);

    @Deprecated
    ChannelGroupFuture flushAndWrite(Object obj, ChannelMatcher channelMatcher);

    String name();

    ChannelGroupFuture newCloseFuture();

    ChannelGroupFuture newCloseFuture(ChannelMatcher channelMatcher);

    ChannelGroupFuture write(Object obj);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture write(Object obj, ChannelMatcher channelMatcher, boolean z);

    ChannelGroupFuture writeAndFlush(Object obj);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher);

    ChannelGroupFuture writeAndFlush(Object obj, ChannelMatcher channelMatcher, boolean z);
}
