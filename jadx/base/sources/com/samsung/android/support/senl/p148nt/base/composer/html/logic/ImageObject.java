package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ImageObject;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TaskObject;", "src", "", "alt", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "getAlt", "convertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class ImageObject extends TaskObject {

    @Nullable
    private final String alt;

    @Nullable
    private final String src;

    public ImageObject(@Nullable String str, @Nullable String str2) {
        super(null);
        this.src = str;
        this.alt = str2;
    }

    public static /* synthetic */ ImageObject copy$default(ImageObject imageObject, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageObject.src;
        }
        if ((i & 2) != 0) {
            str2 = imageObject.alt;
        }
        return imageObject.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlt() {
        return this.alt;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.DocumentElement
    @Nullable
    public SpenObjectBase convertObject() {
        if (this.src == null) {
            return null;
        }
        return new SpenImageObjectTemp(this.src);
    }

    @NotNull
    public final ImageObject copy(@Nullable String src, @Nullable String alt) {
        return new ImageObject(src, alt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageObject)) {
            return false;
        }
        ImageObject imageObject = (ImageObject) other;
        return Intrinsics.areEqual(this.src, imageObject.src) && Intrinsics.areEqual(this.alt, imageObject.alt);
    }

    @Nullable
    public final String getAlt() {
        return this.alt;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }

    public int hashCode() {
        String str = this.src;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.alt;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("ImageObject(src=", this.src, ", alt=", this.alt, ")");
    }
}
