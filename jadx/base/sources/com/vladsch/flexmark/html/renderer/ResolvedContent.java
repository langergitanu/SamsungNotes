package com.vladsch.flexmark.html.renderer;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ResolvedContent {

    @Nullable
    private final byte[] content;

    @NotNull
    private final ResolvedLink resolvedLink;

    @NotNull
    private final LinkStatus status;

    public ResolvedContent(@NotNull ResolvedLink resolvedLink, @NotNull LinkStatus linkStatus, @Nullable byte[] bArr) {
        this.resolvedLink = resolvedLink;
        this.status = linkStatus;
        this.content = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ResolvedContent resolvedContent = (ResolvedContent) obj;
        if (this.resolvedLink.equals(resolvedContent.resolvedLink) && this.status.equals(resolvedContent.status)) {
            return Arrays.equals(this.content, resolvedContent.content);
        }
        return false;
    }

    @Nullable
    public byte[] getContent() {
        return this.content;
    }

    @NotNull
    public ResolvedLink getResolvedLink() {
        return this.resolvedLink;
    }

    @NotNull
    public LinkStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return Arrays.hashCode(this.content) + ((this.status.hashCode() + (this.resolvedLink.hashCode() * 31)) * 31);
    }

    public ResolvedContent withContent(@Nullable byte[] bArr) {
        return Arrays.equals(this.content, bArr) ? this : new ResolvedContent(this.resolvedLink, this.status, bArr);
    }

    public ResolvedContent withStatus(@NotNull LinkStatus linkStatus) {
        return linkStatus == this.status ? this : new ResolvedContent(this.resolvedLink, linkStatus, this.content);
    }
}
