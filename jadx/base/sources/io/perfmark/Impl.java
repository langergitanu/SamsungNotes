package io.perfmark;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Impl {
    private static final long NO_LINK_ID = Long.MIN_VALUE;
    static final long NO_TAG_ID = Long.MIN_VALUE;
    static final String NO_TAG_NAME = "";
    static final Tag NO_TAG = new Tag("", Long.MIN_VALUE);
    static final Link NO_LINK = new Link(Long.MIN_VALUE);

    public Impl(Tag tag) {
        if (tag != NO_TAG) {
            throw new AssertionError("nope");
        }
    }

    public static Link packLink(long j) {
        return new Link(j);
    }

    public static Tag packTag(@Nullable String str, long j) {
        return new Tag(str, j);
    }

    public static long unpackLinkId(Link link) {
        return link.linkId;
    }

    public static long unpackTagId(Tag tag) {
        return tag.tagId;
    }

    @Nullable
    public static String unpackTagName(Tag tag) {
        return tag.tagName;
    }

    public void attachTag(Tag tag) {
    }

    public Tag createTag(@Nullable String str, long j) {
        return NO_TAG;
    }

    public void event(String str) {
    }

    public Link linkOut() {
        return NO_LINK;
    }

    public void setEnabled(boolean z) {
    }

    public <T> void startTask(T t, StringFunction<? super T> stringFunction) {
    }

    public void stopTask() {
    }

    public void attachTag(String str, long j) {
    }

    public void event(String str, Tag tag) {
    }

    public boolean setEnabled(boolean z, boolean z2) {
        return false;
    }

    public void startTask(String str) {
    }

    public void stopTask(String str) {
    }

    public void attachTag(String str, long j, long j2) {
    }

    public void event(String str, String str2) {
    }

    public void startTask(String str, Tag tag) {
    }

    public void stopTask(String str, Tag tag) {
    }

    public <T> void attachTag(String str, T t, StringFunction<? super T> stringFunction) {
    }

    public void startTask(String str, String str2) {
    }

    public void stopTask(String str, String str2) {
    }

    public void attachTag(String str, String str2) {
    }

    public void linkIn(Link link) {
    }
}
