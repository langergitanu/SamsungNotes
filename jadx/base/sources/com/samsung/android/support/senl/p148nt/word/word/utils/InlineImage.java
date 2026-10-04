package com.samsung.android.support.senl.p148nt.word.word.utils;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/utils/InlineImage;", "", "<init>", "()V", "inlineImage", "Ljava/util/ArrayList;", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "Lkotlin/collections/ArrayList;", "inlineImageEmpty", "", "getInlineImage", "index", "", "addInlineImage", "", "xwpfRun", "getInlineImageRun", "clear", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InlineImage {

    @NotNull
    private final ArrayList<XWPFRun> inlineImage = new ArrayList<>();

    private final XWPFRun getInlineImage(int index) {
        XWPFRun xWPFRun = this.inlineImage.get(index);
        Intrinsics.checkNotNullExpressionValue(xWPFRun, "get(...)");
        return xWPFRun;
    }

    private final boolean inlineImageEmpty() {
        return this.inlineImage.isEmpty();
    }

    public final void addInlineImage(@NotNull XWPFRun xwpfRun) {
        Intrinsics.checkNotNullParameter(xwpfRun, "xwpfRun");
        this.inlineImage.add(xwpfRun);
    }

    public final void clear() {
        this.inlineImage.clear();
    }

    @Nullable
    public final XWPFRun getInlineImageRun(int index) {
        if (inlineImageEmpty()) {
            return null;
        }
        return getInlineImage(index);
    }
}
