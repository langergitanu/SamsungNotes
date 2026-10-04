package com.samsung.android.sdk.composer.document.sdoc;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0004J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u000b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000eJ\"\u0010\u000f\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000eJ\"\u0010\u0010\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000eJ\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014J.\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J.\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J.\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J.\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J.\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J.\u0010+\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0014H\u0002¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDocComposerUtil;", "", "doc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "<init>", "(Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;)V", "finalize", "", "insertContent", "content", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "insertContents", "contentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertContentUnit", "insertContentUnitNext", "insertContentUnitEnd", "removeContents", "beginIndex", "", "beginPos", TextConst.KEY_END_INDEX, "endPos", "setTaskStyle", "taskStyle", "setAlignment", "alignment", "setBold", "enabled", "", "setItalic", "setUnderline", "setTextColor", "color", "setFontSize", "size", "", "divideTextContentByEnter", "start", "end", "divideTaskStyleByEnter", "performEnter", "setTextBackgroundColor", "throwUncheckedException", "errno", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSDocComposerUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSDocComposerUtil.kt\ncom/samsung/android/sdk/composer/document/sdoc/SpenSDocComposerUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,526:1\n1#2:527\n*E\n"})
public final class SpenSDocComposerUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenSDocComposerUtil";
    private static long mHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0083 J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0083 J-\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0083 J-\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0083 J\u0011\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0083 J1\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J\u0019\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0019H\u0083 J9\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J9\u0010!\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J9\u0010\"\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J9\u0010#\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J!\u0010%\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0019H\u0083 J\u0011\u0010(\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0083 J\u0011\u0010)\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0083 J\u0019\u0010*\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0019H\u0083 J9\u0010,\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 J9\u0010/\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDocComposerUtil$Companion;", "", "<init>", "()V", "mHandle", "", SearchConstants.TargetContents.TAG, "", "SDocComposerUtil_init", "doc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "SDocComposerUtil_finalize", "", "handle", "SDocComposerUtil_insertContents", "", "contentList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "Lkotlin/collections/ArrayList;", "SDocComposerUtil_insertContentUnit", "SDocComposerUtil_insertContentUnitNext", "SDocComposerUtil_insertContentUnitEnd", "SDocComposerUtil_removeContents", "beginIndex", "", "beginPos", TextConst.KEY_END_INDEX, "endPos", "SDocComposerUtil_setTaskStyle", "taskStyle", "SDocComposerUtil_setBold", "enabled", "SDocComposerUtil_setItalic", "SDocComposerUtil_setUnderline", "SDocComposerUtil_setTextColor", "color", "SDocComposerUtil_DivideTextContentByEnter", "start", "end", "SDocComposerUtil_DivideTaskStyleByEnter", "SDocComposerUtil_PerformEnter", "SDocComposerUtil_setAlignment", "alignment", "SDocComposerUtil_setFontSize", "size", "", "SDocComposerUtil_setTextBackgroundColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_DivideTaskStyleByEnter(long handle) {
            return SpenSDocComposerUtil.SDocComposerUtil_DivideTaskStyleByEnter(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_DivideTextContentByEnter(long handle, int start, int end) {
            return SpenSDocComposerUtil.SDocComposerUtil_DivideTextContentByEnter(handle, start, end);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_PerformEnter(long handle) {
            return SpenSDocComposerUtil.SDocComposerUtil_PerformEnter(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void SDocComposerUtil_finalize(long handle) {
            SpenSDocComposerUtil.SDocComposerUtil_finalize(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long SDocComposerUtil_init(SpenSDoc doc) {
            return SpenSDocComposerUtil.SDocComposerUtil_init(doc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_insertContentUnit(long handle, ArrayList<SpenContentBase> contentList) {
            return SpenSDocComposerUtil.SDocComposerUtil_insertContentUnit(handle, contentList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_insertContentUnitEnd(long handle) {
            return SpenSDocComposerUtil.SDocComposerUtil_insertContentUnitEnd(handle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_insertContentUnitNext(long handle, ArrayList<SpenContentBase> contentList) {
            return SpenSDocComposerUtil.SDocComposerUtil_insertContentUnitNext(handle, contentList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_insertContents(long handle, ArrayList<SpenContentBase> contentList) {
            return SpenSDocComposerUtil.SDocComposerUtil_insertContents(handle, contentList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_removeContents(long handle, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_removeContents(handle, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setAlignment(long handle, int alignment) {
            return SpenSDocComposerUtil.SDocComposerUtil_setAlignment(handle, alignment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setBold(long handle, boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setBold(handle, enabled, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setFontSize(long handle, float size, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setFontSize(handle, size, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setItalic(long handle, boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setItalic(handle, enabled, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setTaskStyle(long handle, int taskStyle) {
            return SpenSDocComposerUtil.SDocComposerUtil_setTaskStyle(handle, taskStyle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setTextBackgroundColor(long handle, int color, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setTextBackgroundColor(handle, color, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setTextColor(long handle, int color, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setTextColor(handle, color, beginIndex, beginPos, endIndex, endPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean SDocComposerUtil_setUnderline(long handle, boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
            return SpenSDocComposerUtil.SDocComposerUtil_setUnderline(handle, enabled, beginIndex, beginPos, endIndex, endPos);
        }

        private Companion() {
        }
    }

    public SpenSDocComposerUtil(@NotNull SpenSDoc doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        long jSDocComposerUtil_init = INSTANCE.SDocComposerUtil_init(doc);
        mHandle = jSDocComposerUtil_init;
        if (jSDocComposerUtil_init == 0) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_DivideTaskStyleByEnter(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_DivideTextContentByEnter(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_PerformEnter(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void SDocComposerUtil_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long SDocComposerUtil_init(SpenSDoc spenSDoc);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_insertContentUnit(long j, ArrayList<SpenContentBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_insertContentUnitEnd(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_insertContentUnitNext(long j, ArrayList<SpenContentBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_insertContents(long j, ArrayList<SpenContentBase> arrayList);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_removeContents(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setAlignment(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setBold(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setFontSize(long j, float f, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setItalic(long j, boolean z, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setTaskStyle(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setTextBackgroundColor(long j, int i, int i2, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setTextColor(long j, int i, int i2, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean SDocComposerUtil_setUnderline(long j, boolean z, int i, int i2, int i4, int i5);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenSDoc(" + this + ") is already closed");
    }

    public final void divideTaskStyleByEnter() {
        if (INSTANCE.SDocComposerUtil_DivideTaskStyleByEnter(mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void divideTextContentByEnter(int start, int end) {
        if (INSTANCE.SDocComposerUtil_DivideTextContentByEnter(mHandle, start, end)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void finalize() {
        try {
            long j = mHandle;
            if (j != 0) {
                INSTANCE.SDocComposerUtil_finalize(j);
            }
        } finally {
            mHandle = 0L;
        }
    }

    public final void insertContent(@Nullable SpenContentBase content) {
        if (content == null) {
            throw new IllegalArgumentException("content can not be null.");
        }
        ArrayList<SpenContentBase> arrayList = new ArrayList<>(1);
        arrayList.add(content);
        insertContents(arrayList);
    }

    public final void insertContentUnit(@Nullable ArrayList<SpenContentBase> contentList) {
        if (contentList == null) {
            throw new IllegalArgumentException("content list can not be null.");
        }
        if (INSTANCE.SDocComposerUtil_insertContentUnit(mHandle, contentList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertContentUnitEnd() {
        if (INSTANCE.SDocComposerUtil_insertContentUnitEnd(mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertContentUnitNext(@Nullable ArrayList<SpenContentBase> contentList) {
        if (contentList == null) {
            throw new IllegalArgumentException("content list can not be null.");
        }
        if (INSTANCE.SDocComposerUtil_insertContentUnitNext(mHandle, contentList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertContents(@Nullable ArrayList<SpenContentBase> contentList) {
        if (contentList == null) {
            throw new IllegalArgumentException("content list can not be null.");
        }
        if (INSTANCE.SDocComposerUtil_insertContents(mHandle, contentList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void performEnter() {
        if (INSTANCE.SDocComposerUtil_PerformEnter(mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeContents(int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_removeContents(mHandle, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAlignment(int alignment) {
        if (INSTANCE.SDocComposerUtil_setAlignment(mHandle, alignment)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBold(boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setBold(mHandle, enabled, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFontSize(float size, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setFontSize(mHandle, size, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setItalic(boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setItalic(mHandle, enabled, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTaskStyle(int taskStyle) {
        if (INSTANCE.SDocComposerUtil_setTaskStyle(mHandle, taskStyle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextBackgroundColor(int color, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setTextBackgroundColor(mHandle, color, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextColor(int color, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setTextColor(mHandle, color, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setUnderline(boolean enabled, int beginIndex, int beginPos, int endIndex, int endPos) {
        if (INSTANCE.SDocComposerUtil_setUnderline(mHandle, enabled, beginIndex, beginPos, endIndex, endPos)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
