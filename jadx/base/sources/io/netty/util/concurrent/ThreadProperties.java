package io.netty.util.concurrent;

import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ThreadProperties {
    /* JADX INFO: renamed from: id */
    long mo13778id();

    boolean isAlive();

    boolean isDaemon();

    boolean isInterrupted();

    String name();

    int priority();

    StackTraceElement[] stackTrace();

    Thread.State state();
}
