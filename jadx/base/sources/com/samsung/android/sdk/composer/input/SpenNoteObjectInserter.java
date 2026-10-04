package com.samsung.android.sdk.composer.input;

import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
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
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ2\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ:\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ,\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u0015J4\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ<\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJD\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJL\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ0\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ8\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ*\u0010\t\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u0017J2\u0010\t\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fJ:\u0010\t\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJB\u0010\t\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJJ\u0010\t\u001a\u00020\n2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fJ.\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010$\u001a\u00020#J\u001e\u0010%\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010'\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\"\u0010'\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fJ*\u0010'\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010)\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020 J6\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#0\u0014j\b\u0012\u0004\u0012\u00020#`\u00152\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0014j\b\u0012\u0004\u0012\u00020\r`\u00152\u0006\u0010*\u001a\u00020 J\u001e\u0010)\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u000fJ>\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#0\u0014j\b\u0012\u0004\u0012\u00020#`\u00152\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0014j\b\u0012\u0004\u0012\u00020\r`\u00152\u0006\u0010*\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter;", "", "<init>", "()V", "mNativeHandle", "", "setNativeHandle", "", "nativeHandle", "insertObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "page", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "commitHistory", "", "withMargin", "fitWidth", "fixedMaxPage", "objectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "position", "Landroid/graphics/PointF;", "insertBodyText", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "y", "", "excludeLineAtY", "toNext", "autoFitTable", "columnPerPage", "", "onlyFirstColumn", "adjustRectInPage", "Landroid/graphics/RectF;", "objectRect", "insertTextObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getInsertObjectRect", "getInsertObjectMaxRect", "getBodyObjectRect", "cursorIndex", "getBodyObjectRectList", "isObjectFitPageWidth", "isObjectValid", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNoteObjectInserter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNoteObjectInserter.kt\ncom/samsung/android/sdk/composer/input/SpenNoteObjectInserter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
public final class SpenNoteObjectInserter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenNoteObjectInserter";
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0083 JY\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0083 J9\u0010\u0017\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0083 J9\u0010\u001b\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0083 J!\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 H\u0083 J1\u0010\"\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0083 J1\u0010#\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0083 J!\u0010$\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0083 J)\u0010%\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 JI\u0010'\u001a\u0012\u0012\u0004\u0012\u00020 0\fj\b\u0012\u0004\u0012\u00020 `\u000e2\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0010H\u0083 J\u0019\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0083 J\u0019\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\rH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/input/SpenNoteObjectInserter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_insertObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "nativeHandle", "", "page", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "fitWidth", "", "withMargin", "fixedMaxPage", "commitHistory", "x", "", "y", "Native_insertBodyText", "objectBase", "excludeLineAtY", "toNext", "Native_autoFitTable", "columnPerPage", "", "onlyFirstColumn", "Native_adjustRectInPage", "Landroid/graphics/RectF;", "objectRect", "Native_insertTextObject", "Native_getInsertObjectRect", "Native_getInsertObjectMaxRect", "Native_getBodyObjectRect", "cursorIndex", "Native_getBodyObjectRectList", "Native_isObjectFitPageWidth", "nativePtr", "Native_isObjectValid", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_adjustRectInPage(long nativeHandle, SpenWPage page, RectF objectRect) {
            return SpenNoteObjectInserter.Native_adjustRectInPage(nativeHandle, page, objectRect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_autoFitTable(long nativeHandle, SpenObjectBase objectBase, SpenWPage page, int columnPerPage, boolean onlyFirstColumn, boolean withMargin) {
            return SpenNoteObjectInserter.Native_autoFitTable(nativeHandle, objectBase, page, columnPerPage, onlyFirstColumn, withMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getBodyObjectRect(long nativeHandle, SpenObjectBase objectBase, int cursorIndex, boolean fitWidth) {
            return SpenNoteObjectInserter.Native_getBodyObjectRect(nativeHandle, objectBase, cursorIndex, fitWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<RectF> Native_getBodyObjectRectList(long nativeHandle, ArrayList<SpenObjectBase> objectList, int cursorIndex, boolean fitWidth) {
            return SpenNoteObjectInserter.Native_getBodyObjectRectList(nativeHandle, objectList, cursorIndex, fitWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getInsertObjectMaxRect(long nativeHandle, SpenWPage page, boolean withMargin) {
            return SpenNoteObjectInserter.Native_getInsertObjectMaxRect(nativeHandle, page, withMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getInsertObjectRect(long nativeHandle, SpenWPage page, SpenObjectBase objectBase, boolean fitWidth, boolean withMargin) {
            return SpenNoteObjectInserter.Native_getInsertObjectRect(nativeHandle, page, objectBase, fitWidth, withMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertBodyText(long nativeHandle, SpenObjectBase objectBase, SpenWPage page, float y2, boolean excludeLineAtY, boolean toNext) {
            return SpenNoteObjectInserter.Native_insertBodyText(nativeHandle, objectBase, page, y2, excludeLineAtY, toNext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenWPage Native_insertObject(long nativeHandle, SpenWPage page, ArrayList<SpenObjectBase> objectList, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
            return SpenNoteObjectInserter.Native_insertObject(nativeHandle, page, objectList, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_insertTextObject(long nativeHandle, SpenObjectBase objectBase, float x, float y2, boolean commitHistory) {
            return SpenNoteObjectInserter.Native_insertTextObject(nativeHandle, objectBase, x, y2, commitHistory);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isObjectFitPageWidth(long nativePtr, SpenObjectBase objectBase) {
            return SpenNoteObjectInserter.Native_isObjectFitPageWidth(nativePtr, objectBase);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isObjectValid(long nativePtr, SpenObjectBase objectBase) {
            return SpenNoteObjectInserter.Native_isObjectValid(nativePtr, objectBase);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final SpenWPage Native_insertObject(long nativeHandle, ArrayList<SpenObjectBase> objectList, float x, float y2, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
            return SpenNoteObjectInserter.Native_insertObject(nativeHandle, objectList, x, y2, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_adjustRectInPage(long j, SpenWPage spenWPage, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_autoFitTable(long j, SpenObjectBase spenObjectBase, SpenWPage spenWPage, int i, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getBodyObjectRect(long j, SpenObjectBase spenObjectBase, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<RectF> Native_getBodyObjectRectList(long j, ArrayList<SpenObjectBase> arrayList, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getInsertObjectMaxRect(long j, SpenWPage spenWPage, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getInsertObjectRect(long j, SpenWPage spenWPage, SpenObjectBase spenObjectBase, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertBodyText(long j, SpenObjectBase spenObjectBase, SpenWPage spenWPage, float f, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenWPage Native_insertObject(long j, SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, boolean z, boolean z2, boolean z3, boolean z4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native SpenWPage Native_insertObject(long j, ArrayList<SpenObjectBase> arrayList, float f, float f4, boolean z, boolean z2, boolean z3, boolean z4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_insertTextObject(long j, SpenObjectBase spenObjectBase, float f, float f4, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isObjectFitPageWidth(long j, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isObjectValid(long j, SpenObjectBase spenObjectBase);

    @NotNull
    public final RectF adjustRectInPage(@NotNull SpenWPage page, @NotNull RectF objectRect) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(objectRect, "objectRect");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_adjustRectInPage(j, page, objectRect);
        }
        throw new IllegalArgumentException("Adjust rect should be call after setDocument");
    }

    public final boolean autoFitTable(@NotNull SpenObjectBase objectBase, @NotNull SpenWPage page, int columnPerPage, boolean onlyFirstColumn, boolean withMargin) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(page, "page");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_autoFitTable(j, objectBase, page, columnPerPage, onlyFirstColumn, withMargin);
        }
        throw new IllegalArgumentException("Auto fit table should be call after setDocument");
    }

    @NotNull
    public final RectF getBodyObjectRect(@NotNull SpenObjectBase objectBase, int cursorIndex) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return INSTANCE.Native_getBodyObjectRect(this.mNativeHandle, objectBase, cursorIndex, false);
    }

    @NotNull
    public final ArrayList<RectF> getBodyObjectRectList(@NotNull ArrayList<SpenObjectBase> objectList, int cursorIndex) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        return INSTANCE.Native_getBodyObjectRectList(this.mNativeHandle, objectList, cursorIndex, false);
    }

    @NotNull
    public final RectF getInsertObjectMaxRect(@Nullable SpenWPage page, boolean withMargin) {
        long j = this.mNativeHandle;
        if (j == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (page != null) {
            return INSTANCE.Native_getInsertObjectMaxRect(j, page, withMargin);
        }
        throw new IllegalArgumentException("Invalid WPage");
    }

    @NotNull
    public final RectF getInsertObjectRect(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase) {
        return getInsertObjectRect(page, objectBase, false, true);
    }

    public final boolean insertBodyText(@NotNull SpenObjectShape objectBase, @NotNull SpenWPage page, float y2, boolean excludeLineAtY, boolean toNext) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(page, "page");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_insertBodyText(j, objectBase, page, y2, excludeLineAtY, toNext);
        }
        throw new IllegalArgumentException("Insert object should be call after setDocument");
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase) {
        return insertObject(page, objectBase, false, true, false, true);
    }

    public final boolean insertTextObject(@NotNull SpenObjectTextBox objectBase, @NotNull PointF position, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        Intrinsics.checkNotNullParameter(position, "position");
        long j = this.mNativeHandle;
        if (j != 0) {
            return INSTANCE.Native_insertTextObject(j, objectBase, position.x, position.y, commitHistory);
        }
        throw new IllegalArgumentException("Adjust rect should be call after setDocument");
    }

    public final boolean isObjectFitPageWidth(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_isObjectFitPageWidth(j, objectBase);
    }

    public final boolean isObjectValid(@NotNull SpenObjectBase objectBase) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        long j = this.mNativeHandle;
        return j != 0 && INSTANCE.Native_isObjectValid(j, objectBase);
    }

    public final void setNativeHandle(long nativeHandle) {
        this.mNativeHandle = nativeHandle;
    }

    @NotNull
    public final RectF getBodyObjectRect(@NotNull SpenObjectBase objectBase, int cursorIndex, boolean fitWidth) {
        Intrinsics.checkNotNullParameter(objectBase, "objectBase");
        return INSTANCE.Native_getBodyObjectRect(this.mNativeHandle, objectBase, cursorIndex, fitWidth);
    }

    @NotNull
    public final ArrayList<RectF> getBodyObjectRectList(@NotNull ArrayList<SpenObjectBase> objectList, int cursorIndex, boolean fitWidth) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        return INSTANCE.Native_getBodyObjectRectList(this.mNativeHandle, objectList, cursorIndex, fitWidth);
    }

    @NotNull
    public final RectF getInsertObjectRect(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean withMargin) {
        return getInsertObjectRect(page, objectBase, false, withMargin);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean commitHistory) {
        return insertObject(page, objectBase, false, true, false, commitHistory);
    }

    @NotNull
    public final RectF getInsertObjectRect(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean fitWidth, boolean withMargin) {
        long j = this.mNativeHandle;
        if (j == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (page != null && objectBase != null) {
            return INSTANCE.Native_getInsertObjectRect(j, page, objectBase, fitWidth, withMargin);
        }
        throw new IllegalArgumentException("Invalid WPage or Object");
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean withMargin, boolean commitHistory) {
        return insertObject(page, objectBase, false, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean fitWidth, boolean withMargin, boolean commitHistory) {
        return insertObject(page, objectBase, fitWidth, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable SpenObjectBase objectBase, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
        if (this.mNativeHandle == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (page != null && objectBase != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(objectBase);
            return INSTANCE.Native_insertObject(this.mNativeHandle, page, arrayList, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }
        throw new IllegalArgumentException("Invalid WPage or Object");
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable ArrayList<SpenObjectBase> objectList) {
        return insertObject(page, objectList, false, true, false, true);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable ArrayList<SpenObjectBase> objectList, boolean commitHistory) {
        return insertObject(page, objectList, false, true, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable ArrayList<SpenObjectBase> objectList, boolean withMargin, boolean commitHistory) {
        return insertObject(page, objectList, false, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable ArrayList<SpenObjectBase> objectList, boolean fitWidth, boolean withMargin, boolean commitHistory) {
        return insertObject(page, objectList, fitWidth, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenWPage page, @Nullable ArrayList<SpenObjectBase> objectList, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
        long j = this.mNativeHandle;
        if (j == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (page != null && objectList != null) {
            return INSTANCE.Native_insertObject(j, page, objectList, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }
        throw new IllegalArgumentException("Invalid WPage or Object");
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenObjectBase objectBase, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectBase, position, false, true, false, true);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenObjectBase objectBase, @NotNull PointF position, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectBase, position, false, true, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenObjectBase objectBase, @NotNull PointF position, boolean withMargin, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectBase, position, false, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenObjectBase objectBase, @NotNull PointF position, boolean fitWidth, boolean withMargin, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectBase, position, fitWidth, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable SpenObjectBase objectBase, @NotNull PointF position, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        if (this.mNativeHandle == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (objectBase != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(objectBase);
            return INSTANCE.Native_insertObject(this.mNativeHandle, arrayList, position.x, position.y, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }
        throw new IllegalArgumentException("Invalid Object");
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable ArrayList<SpenObjectBase> objectList, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectList, position, false, true, false, true);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable ArrayList<SpenObjectBase> objectList, @NotNull PointF position, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectList, position, false, true, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable ArrayList<SpenObjectBase> objectList, @NotNull PointF position, boolean withMargin, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectList, position, false, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable ArrayList<SpenObjectBase> objectList, @NotNull PointF position, boolean fitWidth, boolean withMargin, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        return insertObject(objectList, position, fitWidth, withMargin, false, commitHistory);
    }

    @NotNull
    public final SpenWPage insertObject(@Nullable ArrayList<SpenObjectBase> objectList, @NotNull PointF position, boolean fitWidth, boolean withMargin, boolean fixedMaxPage, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(position, "position");
        long j = this.mNativeHandle;
        if (j == 0) {
            throw new IllegalArgumentException("Insert object should be call after setDocument");
        }
        if (objectList != null) {
            return INSTANCE.Native_insertObject(j, objectList, position.x, position.y, fitWidth, withMargin, fixedMaxPage, commitHistory);
        }
        throw new IllegalArgumentException("Invalid Object");
    }
}
