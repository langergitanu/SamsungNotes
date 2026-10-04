package com.samsung.android.sdk.pen.document;

import android.graphics.RectF;
import com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui.LayoutAlignmentName;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bo\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 ý\u00012\u00020\u0001: î\u0001ï\u0001ð\u0001ñ\u0001ò\u0001ó\u0001ô\u0001õ\u0001ö\u0001÷\u0001ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB/\b\u0017\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e¢\u0006\u0004\b\u0002\u0010\u000fB7\b\u0017\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010BK\b\u0017\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000e¢\u0006\u0004\b\u0002\u0010\u0013BS\b\u0017\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0014J\u001a\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010C2\u0006\u0010i\u001a\u00020\u0005H\u0016J\b\u0010j\u001a\u00020gH\u0016J\u0010\u0010k\u001a\u00020g2\u0006\u0010l\u001a\u00020mH\u0016J(\u0010n\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0007J\u0010\u0010q\u001a\u00020g2\u0006\u0010\u000b\u001a\u00020\rH\u0007J\u0010\u0010r\u001a\u00020g2\u0006\u0010\u000b\u001a\u00020\rH\u0007J(\u0010s\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e2\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0007J\u0010\u0010t\u001a\u00020g2\u0006\u0010Y\u001a\u00020\u0012H\u0007J\u0010\u0010u\u001a\u00020g2\u0006\u0010Y\u001a\u00020\u0012H\u0007J\u0016\u0010v\u001a\u00020g2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u001dJ\u0010\u0010x\u001a\u00020g2\u0006\u0010Q\u001a\u00020\u001dH\u0007J\u0010\u0010y\u001a\u00020g2\u0006\u0010z\u001a\u00020\u0016H\u0002J\u0011\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010}\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J7\u0010~\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0082 J[\u0010\u007f\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u001a\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\u0014\u0010\u0081\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\"\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0016H\u0082 J\u001a\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0082 J$\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010\u0085\u0001\u001a\u00020\u00162\u0007\u0010\u0086\u0001\u001a\u00020\u0016H\u0082 J\u0012\u0010\u0087\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J,\u0010\u0088\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0007\u0010\u0089\u0001\u001a\u00020\u00162\u0007\u0010\u0086\u0001\u001a\u00020\u0016H\u0082 J\u001a\u0010\u008a\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u0016H\u0082 J\u0012\u0010\u008b\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J6\u0010\u008c\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010\u008d\u0001\u001a\u00020\u001d2\u0007\u0010\u008e\u0001\u001a\u00020\u001d2\u0007\u0010\u008f\u0001\u001a\u00020\u001d2\u0007\u0010\u0090\u0001\u001a\u00020\u001dH\u0082 J\u0012\u0010\u0091\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010\u0092\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010\u0093\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010\u0094\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J.\u0010\u0095\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0082 J\"\u0010\u0096\u0001\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010|\u001a\u00020\u0016H\u0082 J2\u0010\u0097\u0001\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010|\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0082 J\u001a\u0010\u0098\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\rH\u0082 J\u001a\u0010\u0099\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\rH\u0082 J.\u0010\u009a\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u001a\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000eH\u0082 J\"\u0010\u009b\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e2\u0006\u0010|\u001a\u00020\u0016H\u0082 J2\u0010\u009c\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000e2\u0006\u0010|\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0082 J\u001a\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u0012H\u0082 J\u001a\u0010\u009e\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u0012H\u0082 J\u001a\u0010\u009f\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0012\u0010 \u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010¡\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u0012\u0010¢\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010£\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0082 J\u0012\u0010¤\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010¥\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0005H\u0082 J\u0012\u0010¦\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010§\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\bH\u0082 J\u0014\u0010©\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010ª\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010«\u0001\u001a\u00020\u0005H\u0082 J\u0012\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010\u00ad\u0001\u001a\u00020g2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010®\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010¯\u0001\u001a\u00020\u0016H\u0082 J\u0012\u0010°\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010±\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0012\u0010²\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010³\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0012\u0010´\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010µ\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u001dH\u0082 J\u0012\u0010¶\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001c\u0010·\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010¸\u0001\u001a\u00020\b2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010¹\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010º\u0001\u001a\u00020\u0016H\u0082 J\u0012\u0010»\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010¼\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0082 J\u0012\u0010½\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010¾\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0016H\u0082 J\u0012\u0010¿\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\"\u0010À\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u001dH\u0082 J\u0012\u0010Á\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010Â\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010Ã\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010Ä\u0001\u001a\u00020\u0016H\u0082 J\u0012\u0010Å\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010Æ\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0082 J\u0012\u0010Ç\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010È\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0082 J\u0012\u0010É\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010Ê\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010Ë\u0001\u001a\u00020\u0016H\u0082 J\u0012\u0010Ì\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010Í\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u0012\u0010Î\u0001\u001a\u00020C2\u0006\u0010|\u001a\u00020\u0016H\u0082 J$\u0010Ï\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010Ð\u0001\u001a\u00020m2\u0007\u0010Ñ\u0001\u001a\u00020\u0016H\u0082 J\u001a\u0010Ò\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0012\u0010Ó\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010Ô\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u001dH\u0082 J\u0012\u0010Õ\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010Ö\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0082 J\u0012\u0010×\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010Ø\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0082 J\u0012\u0010Ù\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010Ú\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u001dH\u0082 J\u0012\u0010Û\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010Ü\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010Y\u001a\u00030Ý\u0001H\u0082 J\u001b\u0010Þ\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010\u000b\u001a\u00030ß\u0001H\u0082 J<\u0010à\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0001\u0018\u00010\fj\r\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0001\u0018\u0001`\u000e2\u0006\u0010|\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0082 J,\u0010á\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0001\u0018\u00010\fj\r\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0001\u0018\u0001`\u000e2\u0006\u0010|\u001a\u00020\u0016H\u0082 J<\u0010â\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u00010ß\u0001\u0018\u00010\fj\r\u0012\u0007\u0012\u0005\u0018\u00010ß\u0001\u0018\u0001`\u000e2\u0006\u0010|\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00162\u0006\u0010p\u001a\u00020\u0016H\u0082 J,\u0010ã\u0001\u001a\u001c\u0012\u0007\u0012\u0005\u0018\u00010ß\u0001\u0018\u00010\fj\r\u0012\u0007\u0012\u0005\u0018\u00010ß\u0001\u0018\u0001`\u000e2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001b\u0010ä\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010Y\u001a\u00030Ý\u0001H\u0082 J\u001b\u0010å\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0007\u0010\u000b\u001a\u00030ß\u0001H\u0082 J,\u0010æ\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0018\u0010\u000b\u001a\u0014\u0012\u0005\u0012\u00030ß\u00010\fj\t\u0012\u0005\u0012\u00030ß\u0001`\u000eH\u0082 J,\u0010ç\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0018\u0010Y\u001a\u0014\u0012\u0005\u0012\u00030Ý\u00010\fj\t\u0012\u0005\u0012\u00030Ý\u0001`\u000eH\u0082 J\u001a\u0010è\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0005H\u0082 J\u0012\u0010é\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010ê\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010_\u001a\u00020\u001dH\u0082 J\u0012\u0010ë\u0001\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u0016H\u0082 J\u001a\u0010ì\u0001\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J\u0012\u0010í\u0001\u001a\u00020\u00162\u0006\u0010|\u001a\u00020\u0016H\u0082 R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR$\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00058G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0006R$\u0010+\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR$\u0010.\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR$\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R(\u00105\u001a\u0004\u0018\u00010\b2\b\u00105\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u0010\tR$\u0010:\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR$\u0010>\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001bR\u0014\u0010A\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010)R\u0014\u0010B\u001a\u00020C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0011\u0010H\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\bI\u0010 R$\u0010K\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0019\"\u0004\bM\u0010\u001bR$\u0010N\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0019\"\u0004\bP\u0010\u001bR$\u0010R\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bRL\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XRL\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000e2\u001a\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR$\u0010\\\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010)\"\u0004\b^\u0010\u0006R$\u0010`\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010 \"\u0004\bb\u0010\"R$\u0010c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0019\"\u0004\be\u0010\u001b¨\u0006þ\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "text", "", "(Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "span", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/util/ArrayList;Z)V", "paras", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V", "color", "", "lineBorderColor", "getLineBorderColor", "()I", "setLineBorderColor", "(I)V", "width", "", "lineBorderWidth", "getLineBorderWidth", "()F", "setLineBorderWidth", "(F)V", "type", "borderType", "getBorderType", "setBorderType", "enable", "isReadOnlyEnabled", "()Z", "setReadOnlyEnabled", "textColor", "getTextColor", "setTextColor", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "size", "fontSize", "getFontSize", "setFontSize", "font", "getFont", "()Ljava/lang/String;", "setFont", "style", "textStyle", "getTextStyle", "setTextStyle", "align", "textAlignment", "getTextAlignment", "setTextAlignment", "isChanged", "drawnRect", "Landroid/graphics/RectF;", "getDrawnRect", "()Landroid/graphics/RectF;", "textLineSpacingType", "getTextLineSpacingType", "textLineSpacing", "getTextLineSpacing", "indentLevel", "textIndentLevel", "getTextIndentLevel", "setTextIndentLevel", "bulletType", "getBulletType", "setBulletType", "position", "cursorPos", "getCursorPos", "setCursorPos", "getSpan", "()Ljava/util/ArrayList;", "setSpan", "(Ljava/util/ArrayList;)V", "paragraph", "getParagraph", "setParagraph", "linedPaperEnabled", "getLinedPaperEnabled", "setLinedPaperEnabled", "thickness", "linedPagerThickness", "getLinedPagerThickness", "setLinedPagerThickness", "linedPagerColor", "getLinedPagerColor", "setLinedPagerColor", "setRect", "", "rect", "regionOnly", "clearChangedFlag", "copy", "source", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "findSpans", "startPos", "endPos", "removeSpan", "appendSpan", "findParagraphs", "removeParagraph", "appendParagraph", "setTextLineSpacingInfo", "lineSpacing", "setVereticalPan", "throwUncheckedException", "errno", "ObjectTextBox_init1", "handle", "ObjectTextBox_init2", "ObjectTextBox_init3", "ObjectTextBox_init4", "ObjectTextBox_setText", "ObjectTextBox_getText", "ObjectTextBox_insertText", "ObjectTextBox_insertTextAtCursor", "ObjectTextBox_removeText", TextConst.KEY_START_INDEX, "length", "ObjectTextBox_removeAllText", "ObjectTextBox_replaceText", "staetIndex", "ObjectTextBox_setCursorPos", "ObjectTextBox_getCursorPos", "ObjectTextBox_setMargin", "left", "top", "right", "bottom", "ObjectTextBox_getLeftMargin", "ObjectTextBox_getTopMargin", "ObjectTextBox_getRightMargin", "ObjectTextBox_getBottomMargin", "ObjectTextBox_setSpan", "ObjectTextBox_getSpan", "ObjectTextBox_findSpans", "ObjectTextBox_removeSpan", "ObjectTextBox_appendSpan", "ObjectTextBox_setParagraph", "ObjectTextBox_getParagraph", "ObjectTextBox_findParagraphs", "ObjectTextBox_removeParagraph", "ObjectTextBox_appendParagraph", "ObjectTextBox_setLineBorderColor", "ObjectTextBox_getLineBorderColor", "ObjectTextBox_setLineBorderWidth", "ObjectTextBox_getLineBorderWidth", "ObjectTextBox_setBorderType", "ObjectTextBox_getBorderType", "ObjectTextBox_enableReadOnly", "ObjectTextBox_isReadOnly", "ObjectTextBox_setHintText", "hintText", "ObjectTextBox_getHintText", "ObjectTextBox_setHintTextVisibility", "visible", "ObjectTextBox_isHintTextVisiable", "ObjectTextBox_clearChangedFlag", "ObjectTextBox_setGravity", "textGravity", "ObjectTextBox_getGravity", "ObjectTextBox_setTextColor", "ObjectTextBox_getTextColor", "ObjectTextBox_setBackgroundColor", "ObjectTextBox_getBackgroundColor", "ObjectTextBox_setFontSize", "ObjectTextBox_getFontSize", "ObjectTextBox_setFont", "ObjectTextBox_getFont", "ObjectTextBox_setTextDirection", "direction", "ObjectTextBox_getTextDirection", "ObjectTextBox_setTextStyle", "ObjectTextBox_getTextStyle", "ObjectTextBox_setTextAlignment", "ObjectTextBox_getTextAlignment", "ObjectTextBox_setTextLineSpacingInfo", "ObjectTextBox_getTextLineSpacingType", "ObjectTextBox_getTextLineSpacing", "ObjectTextBox_setTextIndentLevel", "level", "ObjectTextBox_getTextIndentLevel", "ObjectTextBox_setBulletType", "ObjectTextBox_getBulletType", "ObjectTextBox_setEllipsisType", "ObjectTextBox_getEllipsisType", "ObjectTextBox_setAutoFitOption", "textAutoFit", "ObjectTextBox_getAutoFitOption", "ObjectTextBox_isChanged", "ObjectTextBox_getDrawnRect", "ObjectTextBox_copy", "dest", "sourceHandle", "ObjectTextBox_setHintTextColor", "ObjectTextBox_getHintTextColor", "ObjectTextBox_setHintTextFontSize", "ObjectTextBox_getHintTextFontSize", "ObjectTextBox_setIMEActionType", "ObjectTextBox_getIMEActionType", "ObjectTextBox_setTextInputType", "ObjectTextBox_getTextInputType", "ObjectTextBox_setVerticalPan", "ObjectTextBox_getVerticalPan", "ObjectTextBox_appendParagraphEx", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "ObjectTextBox_appendSpanEx", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "ObjectTextBox_findParagraphEx", "ObjectTextBox_getParagraphEx", "ObjectTextBox_findSpanEx", "ObjectTextBox_getSpanEx", "ObjectTextBox_removeParagraphEx", "ObjectTextBox_removeSpanEx", "ObjectTextBox_setSpanEx", "ObjectTextBox_setParagraphEx", "ObjectTextBox_setLinedPaperEnabled", "ObjectTextBox_isLinedPaperEnabled", "ObjectTextBox_setLinedPaperThickness", "ObjectTextBox_getLinedPaperThickness", "ObjectTextBox_setLinedPaperColor", "ObjectTextBox_getLinedPaperColor", "TextParagraphInfo", "IndentLevelParagraphInfo", "AlignParagraphInfo", "LineSpacingParagraphInfo", "BulletParagraphInfo", "TextSpanInfo", "TextDirectionSpanInfo", "FontSizeSpanInfo", "FontNameSpanInfo", "ForegroundColorSpanInfo", "BackgroundColorSpanInfo", "BoldStyleSpanInfo", "ItalicStyleSpanInfo", "UnderlineStyleSpanInfo", "HyperTextStyleSpanInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectTextBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectTextBox.kt\ncom/samsung/android/sdk/pen/document/SpenObjectTextBox\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1920:1\n1#2:1921\n*E\n"})
public final class SpenObjectTextBox extends SpenObjectShape {
    private static final int ALIGN_LEFT = 0;

    @JvmField
    public static final int BORDER_TYPE_NONE = 0;
    private static final int BULLET_TYPE_NONE = 0;
    private static final int DIRECTION_LEFT_TO_RIGHT = 0;
    private static final int HYPER_TEXT_UNKNOWN = 0;
    private static final int LINE_SPACING_PIXEL = 0;
    private static final int STYLE_NONE = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int BORDER_TYPE_SQUARE = 1;

    @JvmField
    public static final int BORDER_TYPE_SHADOW = 2;

    @JvmField
    public static final int BORDER_TYPE_DOT = 3;

    @JvmField
    public static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;

    @JvmField
    public static final int STYLE_UNDERLINE = 4;

    @JvmField
    public static final int STYLE_MASK = 7;

    @JvmField
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private static final int ALIGN_RIGHT = 1;
    private static final int ALIGN_CENTER = 2;
    private static final int ALIGN_BOTH = 3;

    @JvmField
    public static final int LINE_SPACING_PERCENT = 1;
    private static final int HYPER_TEXT_EMAIL = 1;
    private static final int HYPER_TEXT_TEL = 2;

    @JvmField
    public static final int HYPER_TEXT_URL = 3;
    private static final int HYPER_TEXT_DATE = 4;
    private static final int HYPER_TEXT_ADDRESS = 5;
    private static final int BULLET_TYPE_ARROW = 1;
    private static final int BULLET_TYPE_CHECKER = 2;
    private static final int BULLET_TYPE_DIAMOND = 3;
    private static final int BULLET_TYPE_DIGIT = 4;
    private static final int BULLET_TYPE_CIRCLED_DIGIT = 5;
    private static final int BULLET_TYPE_ALPHABET = 6;
    private static final int BULLET_TYPE_ROMAN_NUMERAL = 7;
    private static final int BULLET_TYPE_SOLID_CIRCLE = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenAlignmentParagraph}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$AlignParagraphInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "<init>", "()V", "align", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AlignParagraphInfo extends TextParagraphInfo {

        @JvmField
        public int align;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, Not supported anymore.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$BackgroundColorSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "backgroundColor", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BackgroundColorSpanInfo extends TextSpanInfo {

        @JvmField
        public int backgroundColor = -16777216;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBoldSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$BoldStyleSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "isBold", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BoldStyleSpanInfo extends TextSpanInfo {

        @JvmField
        public boolean isBold = true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$BulletParagraphInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "<init>", "()V", "bulletType", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BulletParagraphInfo extends TextParagraphInfo {

        @JvmField
        public int bulletType = SpenObjectTextBox.INSTANCE.getBULLET_TYPE_NONE();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bX\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0005H\u0007J\u0011\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0005H\u0083 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003R\u001c\u0010\u0014\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0003R\u001c\u0010\u001b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\nR\u0016\u0010\u001e\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0003R\u001c\u0010 \u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\nR\u001c\u0010#\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\nR\u001c\u0010&\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\nR\u001c\u0010)\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010\nR\u001c\u0010,\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010\nR\u0016\u0010/\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b0\u0010\u0003R\u001c\u00101\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010\nR\u001c\u00104\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0003\u001a\u0004\b6\u0010\nR\u001c\u00107\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010\nR\u0016\u0010:\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0003R\u001c\u0010<\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\nR\u001c\u0010?\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010\nR\u001c\u0010B\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\u0003\u001a\u0004\bD\u0010\nR\u001c\u0010E\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010\nR\u001c\u0010H\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\u0003\u001a\u0004\bJ\u0010\nR\u001c\u0010K\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\nR\u001c\u0010N\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010\nR\u001c\u0010Q\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\nR\u001c\u0010T\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\nR\u001c\u0010W\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\nR\u001c\u0010Z\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010\n¨\u0006c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$Companion;", "", "<init>", "()V", "BORDER_TYPE_NONE", "", "getBORDER_TYPE_NONE$annotations", "BORDER_TYPE_SQUARE", "getBORDER_TYPE_SQUARE$annotations", "getBORDER_TYPE_SQUARE", "()I", "BORDER_TYPE_SHADOW", "getBORDER_TYPE_SHADOW$annotations", "BORDER_TYPE_DOT", "getBORDER_TYPE_DOT$annotations", "STYLE_NONE", "getSTYLE_NONE$annotations", "getSTYLE_NONE", "STYLE_BOLD", "getSTYLE_BOLD$annotations", "STYLE_ITALIC", "getSTYLE_ITALIC$annotations", "getSTYLE_ITALIC", "STYLE_UNDERLINE", "getSTYLE_UNDERLINE$annotations", "STYLE_MASK", "getSTYLE_MASK$annotations", "DIRECTION_LEFT_TO_RIGHT", "getDIRECTION_LEFT_TO_RIGHT$annotations", "getDIRECTION_LEFT_TO_RIGHT", "DIRECTION_RIGHT_TO_LEFT", "getDIRECTION_RIGHT_TO_LEFT$annotations", LayoutAlignmentName.ALIGN_LEFT, "getALIGN_LEFT$annotations", "getALIGN_LEFT", LayoutAlignmentName.ALIGN_RIGHT, "getALIGN_RIGHT$annotations", "getALIGN_RIGHT", "ALIGN_CENTER", "getALIGN_CENTER$annotations", "getALIGN_CENTER", "ALIGN_BOTH", "getALIGN_BOTH$annotations", "getALIGN_BOTH", "LINE_SPACING_PIXEL", "getLINE_SPACING_PIXEL$annotations", "getLINE_SPACING_PIXEL", "LINE_SPACING_PERCENT", "getLINE_SPACING_PERCENT$annotations", "HYPER_TEXT_UNKNOWN", "getHYPER_TEXT_UNKNOWN$annotations", "getHYPER_TEXT_UNKNOWN", "HYPER_TEXT_EMAIL", "getHYPER_TEXT_EMAIL$annotations", "getHYPER_TEXT_EMAIL", "HYPER_TEXT_TEL", "getHYPER_TEXT_TEL$annotations", "getHYPER_TEXT_TEL", "HYPER_TEXT_URL", "getHYPER_TEXT_URL$annotations", "HYPER_TEXT_DATE", "getHYPER_TEXT_DATE$annotations", "getHYPER_TEXT_DATE", "HYPER_TEXT_ADDRESS", "getHYPER_TEXT_ADDRESS$annotations", "getHYPER_TEXT_ADDRESS", "BULLET_TYPE_NONE", "getBULLET_TYPE_NONE$annotations", "getBULLET_TYPE_NONE", "BULLET_TYPE_ARROW", "getBULLET_TYPE_ARROW$annotations", "getBULLET_TYPE_ARROW", "BULLET_TYPE_CHECKER", "getBULLET_TYPE_CHECKER$annotations", "getBULLET_TYPE_CHECKER", "BULLET_TYPE_DIAMOND", "getBULLET_TYPE_DIAMOND$annotations", "getBULLET_TYPE_DIAMOND", "BULLET_TYPE_DIGIT", "getBULLET_TYPE_DIGIT$annotations", "getBULLET_TYPE_DIGIT", "BULLET_TYPE_CIRCLED_DIGIT", "getBULLET_TYPE_CIRCLED_DIGIT$annotations", "getBULLET_TYPE_CIRCLED_DIGIT", "BULLET_TYPE_ALPHABET", "getBULLET_TYPE_ALPHABET$annotations", "getBULLET_TYPE_ALPHABET", "BULLET_TYPE_ROMAN_NUMERAL", "getBULLET_TYPE_ROMAN_NUMERAL$annotations", "getBULLET_TYPE_ROMAN_NUMERAL", "BULLET_TYPE_SOLID_CIRCLE", "getBULLET_TYPE_SOLID_CIRCLE$annotations", "getBULLET_TYPE_SOLID_CIRCLE", "setInitialCursorPos", "", "initialCursorPos", "ObjectTextBox_setInitialCursorPos", "", "cursorPos", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenObjectTextBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectTextBox.kt\ncom/samsung/android/sdk/pen/document/SpenObjectTextBox$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1920:1\n1#2:1921\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final boolean ObjectTextBox_setInitialCursorPos(int cursorPos) {
            return SpenObjectTextBox.ObjectTextBox_setInitialCursorPos(cursorPos);
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenAlignmentParagraph#ALIGN_BOTH}.")
        public static /* synthetic */ void getALIGN_BOTH$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenAlignmentParagraph#ALIGN_CENTER}.")
        public static /* synthetic */ void getALIGN_CENTER$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenAlignmentParagraph#ALIGN_LEFT}.")
        public static /* synthetic */ void getALIGN_LEFT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenAlignmentParagraph#ALIGN_RIGHT}.")
        public static /* synthetic */ void getALIGN_RIGHT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_DOT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_NONE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, do not support.")
        public static /* synthetic */ void getBORDER_TYPE_SHADOW$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_SQUARE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_ALPHABET}.")
        public static /* synthetic */ void getBULLET_TYPE_ALPHABET$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_ARROW}.")
        public static /* synthetic */ void getBULLET_TYPE_ARROW$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_CHECKER}.")
        public static /* synthetic */ void getBULLET_TYPE_CHECKER$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_CIRCLED_DIGIT}.")
        public static /* synthetic */ void getBULLET_TYPE_CIRCLED_DIGIT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_DIAMOND}.")
        public static /* synthetic */ void getBULLET_TYPE_DIAMOND$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_DIGIT}.")
        public static /* synthetic */ void getBULLET_TYPE_DIGIT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_NONE}.")
        public static /* synthetic */ void getBULLET_TYPE_NONE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_ROMAN_NUMERAL}.")
        public static /* synthetic */ void getBULLET_TYPE_ROMAN_NUMERAL$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBulletParagraph#TYPE_SOLID_CIRCLE}.")
        public static /* synthetic */ void getBULLET_TYPE_SOLID_CIRCLE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, not supported anymore.")
        public static /* synthetic */ void getDIRECTION_LEFT_TO_RIGHT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, not supported anymore.")
        public static /* synthetic */ void getDIRECTION_RIGHT_TO_LEFT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_ADDRESS}.")
        public static /* synthetic */ void getHYPER_TEXT_ADDRESS$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_DATE}.")
        public static /* synthetic */ void getHYPER_TEXT_DATE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_EMAIL}.")
        public static /* synthetic */ void getHYPER_TEXT_EMAIL$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_TEL}.")
        public static /* synthetic */ void getHYPER_TEXT_TEL$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_UNKNOWN}.")
        public static /* synthetic */ void getHYPER_TEXT_UNKNOWN$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan#TYPE_URL}.")
        public static /* synthetic */ void getHYPER_TEXT_URL$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenLineSpacingParagraph#TYPE_PERCENT}.")
        public static /* synthetic */ void getLINE_SPACING_PERCENT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenLineSpacingParagraph#TYPE_PIXEL}.")
        public static /* synthetic */ void getLINE_SPACING_PIXEL$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenBoldSpan}.")
        public static /* synthetic */ void getSTYLE_BOLD$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenItalicSpan}.")
        public static /* synthetic */ void getSTYLE_ITALIC$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, not supported anymore.")
        public static /* synthetic */ void getSTYLE_MASK$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getSTYLE_NONE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link SpenUnderlineSpan}.")
        public static /* synthetic */ void getSTYLE_UNDERLINE$annotations() {
        }

        public final int getALIGN_BOTH() {
            return SpenObjectTextBox.ALIGN_BOTH;
        }

        public final int getALIGN_CENTER() {
            return SpenObjectTextBox.ALIGN_CENTER;
        }

        public final int getALIGN_LEFT() {
            return SpenObjectTextBox.ALIGN_LEFT;
        }

        public final int getALIGN_RIGHT() {
            return SpenObjectTextBox.ALIGN_RIGHT;
        }

        public final int getBORDER_TYPE_SQUARE() {
            return SpenObjectTextBox.BORDER_TYPE_SQUARE;
        }

        public final int getBULLET_TYPE_ALPHABET() {
            return SpenObjectTextBox.BULLET_TYPE_ALPHABET;
        }

        public final int getBULLET_TYPE_ARROW() {
            return SpenObjectTextBox.BULLET_TYPE_ARROW;
        }

        public final int getBULLET_TYPE_CHECKER() {
            return SpenObjectTextBox.BULLET_TYPE_CHECKER;
        }

        public final int getBULLET_TYPE_CIRCLED_DIGIT() {
            return SpenObjectTextBox.BULLET_TYPE_CIRCLED_DIGIT;
        }

        public final int getBULLET_TYPE_DIAMOND() {
            return SpenObjectTextBox.BULLET_TYPE_DIAMOND;
        }

        public final int getBULLET_TYPE_DIGIT() {
            return SpenObjectTextBox.BULLET_TYPE_DIGIT;
        }

        public final int getBULLET_TYPE_NONE() {
            return SpenObjectTextBox.BULLET_TYPE_NONE;
        }

        public final int getBULLET_TYPE_ROMAN_NUMERAL() {
            return SpenObjectTextBox.BULLET_TYPE_ROMAN_NUMERAL;
        }

        public final int getBULLET_TYPE_SOLID_CIRCLE() {
            return SpenObjectTextBox.BULLET_TYPE_SOLID_CIRCLE;
        }

        public final int getDIRECTION_LEFT_TO_RIGHT() {
            return SpenObjectTextBox.DIRECTION_LEFT_TO_RIGHT;
        }

        public final int getHYPER_TEXT_ADDRESS() {
            return SpenObjectTextBox.HYPER_TEXT_ADDRESS;
        }

        public final int getHYPER_TEXT_DATE() {
            return SpenObjectTextBox.HYPER_TEXT_DATE;
        }

        public final int getHYPER_TEXT_EMAIL() {
            return SpenObjectTextBox.HYPER_TEXT_EMAIL;
        }

        public final int getHYPER_TEXT_TEL() {
            return SpenObjectTextBox.HYPER_TEXT_TEL;
        }

        public final int getHYPER_TEXT_UNKNOWN() {
            return SpenObjectTextBox.HYPER_TEXT_UNKNOWN;
        }

        public final int getLINE_SPACING_PIXEL() {
            return SpenObjectTextBox.LINE_SPACING_PIXEL;
        }

        public final int getSTYLE_ITALIC() {
            return SpenObjectTextBox.STYLE_ITALIC;
        }

        public final int getSTYLE_NONE() {
            return SpenObjectTextBox.STYLE_NONE;
        }

        @JvmStatic
        public final void setInitialCursorPos(int initialCursorPos) {
            if (initialCursorPos != 0 && initialCursorPos != 1) {
                throw new IllegalArgumentException("E_INVALID_ARG");
            }
            if (!ObjectTextBox_setInitialCursorPos(initialCursorPos)) {
                throw new IllegalArgumentException("E_INVALID_ARG");
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenFontNameSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$FontNameSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "fontName", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class FontNameSpanInfo extends TextSpanInfo {

        @JvmField
        @NotNull
        public String fontName = "";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenFontSizeSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$FontSizeSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "fontSize", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class FontSizeSpanInfo extends TextSpanInfo {

        @JvmField
        public float fontSize;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenForegroundColorSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$ForegroundColorSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "foregroundColor", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ForegroundColorSpanInfo extends TextSpanInfo {

        @JvmField
        public int foregroundColor = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenHyperTextSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$HyperTextStyleSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "hyperTextType", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class HyperTextStyleSpanInfo extends TextSpanInfo {

        @JvmField
        public int hyperTextType = SpenObjectTextBox.INSTANCE.getHYPER_TEXT_UNKNOWN();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, Not supported anymore.")
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$IndentLevelParagraphInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "<init>", "()V", "indentLevel", "", "getIndentLevel", "()I", "setIndentLevel", "(I)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class IndentLevelParagraphInfo extends TextParagraphInfo {
        private int indentLevel;

        public final int getIndentLevel() {
            return this.indentLevel;
        }

        public final void setIndentLevel(int i) {
            this.indentLevel = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenItalicSpan}.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$ItalicStyleSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "isItalic", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ItalicStyleSpanInfo extends TextSpanInfo {

        @JvmField
        public boolean isItalic = true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenLineSpacingParagraph}.")
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$LineSpacingParagraphInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "<init>", "()V", "type", "", "lineSpacing", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class LineSpacingParagraphInfo extends TextParagraphInfo {

        @JvmField
        public float lineSpacing;

        @JvmField
        public int type = SpenObjectTextBox.INSTANCE.getLINE_SPACING_PIXEL();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, Note supported anymore.")
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextDirectionSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "textDirection", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextDirectionSpanInfo extends TextSpanInfo {

        @JvmField
        public int textDirection = SpenObjectTextBox.INSTANCE.getDIRECTION_LEFT_TO_RIGHT();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenTextParagraphBase}.")
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextParagraphInfo;", "", "<init>", "()V", "startPos", "", "endPos", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static class TextParagraphInfo {

        @JvmField
        public int endPos;

        @JvmField
        public int startPos;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "", "<init>", "()V", "startPos", "", "endPos", "intervalType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenTextSpanBase}.")
    public static class TextSpanInfo {
        public static final int SPAN_EXCLUSIVE_EXCLUSIVE = 2;
        public static final int SPAN_EXCLUSIVE_INCLUSIVE = 3;
        public static final int SPAN_INCLUSIVE_EXCLUSIVE = 0;
        public static final int SPAN_INCLUSIVE_INCLUSIVE = 1;

        @JvmField
        public int endPos;

        @JvmField
        public int intervalType;

        @JvmField
        public int startPos;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenUnderlineSpan}.")
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$UnderlineStyleSpanInfo;", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox$TextSpanInfo;", "<init>", "()V", "isUnderline", "", "reserved1", "", "getReserved1", "()I", "setReserved1", "(I)V", "reserved2", "getReserved2", "setReserved2", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class UnderlineStyleSpanInfo extends TextSpanInfo {

        @JvmField
        public boolean isUnderline = true;
        private int reserved1 = -1;
        private int reserved2 = -1;

        public final int getReserved1() {
            return this.reserved1;
        }

        public final int getReserved2() {
            return this.reserved2;
        }

        public final void setReserved1(int i) {
            this.reserved1 = i;
        }

        public final void setReserved2(int i) {
            this.reserved2 = i;
        }
    }

    public SpenObjectTextBox() {
        super(2, 0);
    }

    private final native boolean ObjectTextBox_appendParagraph(int handle, TextParagraphInfo paragraph);

    private final native boolean ObjectTextBox_appendParagraphEx(int handle, SpenTextParagraphBase paragraph);

    private final native boolean ObjectTextBox_appendSpan(int handle, TextSpanInfo span);

    private final native boolean ObjectTextBox_appendSpanEx(int handle, SpenTextSpanBase span);

    private final native void ObjectTextBox_clearChangedFlag(int handle);

    private final native boolean ObjectTextBox_copy(int handle, SpenObjectBase dest, int sourceHandle);

    private final native boolean ObjectTextBox_enableReadOnly(int handle, boolean enable);

    private final native ArrayList<SpenTextParagraphBase> ObjectTextBox_findParagraphEx(int handle, int startPos, int endPos);

    private final native ArrayList<TextParagraphInfo> ObjectTextBox_findParagraphs(int handle, int startPos, int endPos);

    private final native ArrayList<SpenTextSpanBase> ObjectTextBox_findSpanEx(int handle, int startPos, int endPos);

    private final native ArrayList<TextSpanInfo> ObjectTextBox_findSpans(int handle, int startPos, int endPos);

    private final native int ObjectTextBox_getAutoFitOption(int handle);

    private final native int ObjectTextBox_getBackgroundColor(int handle);

    private final native int ObjectTextBox_getBorderType(int handle);

    private final native float ObjectTextBox_getBottomMargin(int handle);

    private final native int ObjectTextBox_getBulletType(int handle);

    private final native int ObjectTextBox_getCursorPos(int handle);

    private final native RectF ObjectTextBox_getDrawnRect(int handle);

    private final native int ObjectTextBox_getEllipsisType(int handle);

    private final native String ObjectTextBox_getFont(int handle);

    private final native float ObjectTextBox_getFontSize(int handle);

    private final native int ObjectTextBox_getGravity(int handle);

    private final native String ObjectTextBox_getHintText(int handle);

    private final native int ObjectTextBox_getHintTextColor(int handle);

    private final native float ObjectTextBox_getHintTextFontSize(int handle);

    private final native int ObjectTextBox_getIMEActionType(int handle);

    private final native float ObjectTextBox_getLeftMargin(int handle);

    private final native int ObjectTextBox_getLineBorderColor(int handle);

    private final native float ObjectTextBox_getLineBorderWidth(int handle);

    private final native int ObjectTextBox_getLinedPaperColor(int handle);

    private final native float ObjectTextBox_getLinedPaperThickness(int handle);

    private final native ArrayList<TextParagraphInfo> ObjectTextBox_getParagraph(int handle);

    private final native ArrayList<SpenTextParagraphBase> ObjectTextBox_getParagraphEx(int handle);

    private final native float ObjectTextBox_getRightMargin(int handle);

    private final native ArrayList<TextSpanInfo> ObjectTextBox_getSpan(int handle);

    private final native ArrayList<SpenTextSpanBase> ObjectTextBox_getSpanEx(int handle);

    private final native String ObjectTextBox_getText(int handle);

    private final native int ObjectTextBox_getTextAlignment(int handle);

    private final native int ObjectTextBox_getTextColor(int handle);

    private final native int ObjectTextBox_getTextDirection(int handle);

    private final native int ObjectTextBox_getTextIndentLevel(int handle);

    private final native int ObjectTextBox_getTextInputType(int handle);

    private final native float ObjectTextBox_getTextLineSpacing(int handle);

    private final native int ObjectTextBox_getTextLineSpacingType(int handle);

    private final native int ObjectTextBox_getTextStyle(int handle);

    private final native float ObjectTextBox_getTopMargin(int handle);

    private final native float ObjectTextBox_getVerticalPan(int handle);

    private final native boolean ObjectTextBox_init1(int handle);

    private final native boolean ObjectTextBox_init2(int handle, String text);

    private final native boolean ObjectTextBox_init3(int handle, String text, ArrayList<TextSpanInfo> span);

    private final native boolean ObjectTextBox_init4(int handle, String text, ArrayList<TextSpanInfo> span, ArrayList<TextParagraphInfo> paras, boolean isTemplateObject);

    private final native boolean ObjectTextBox_insertText(int handle, String text, int position);

    private final native boolean ObjectTextBox_insertTextAtCursor(int handle, String text);

    private final native boolean ObjectTextBox_isChanged(int handle);

    private final native boolean ObjectTextBox_isHintTextVisiable(int handle);

    private final native boolean ObjectTextBox_isLinedPaperEnabled(int handle);

    private final native boolean ObjectTextBox_isReadOnly(int handle);

    private final native boolean ObjectTextBox_removeAllText(int handle);

    private final native boolean ObjectTextBox_removeParagraph(int handle, TextParagraphInfo paragraph);

    private final native boolean ObjectTextBox_removeParagraphEx(int handle, SpenTextParagraphBase paragraph);

    private final native boolean ObjectTextBox_removeSpan(int handle, TextSpanInfo span);

    private final native boolean ObjectTextBox_removeSpanEx(int handle, SpenTextSpanBase span);

    private final native boolean ObjectTextBox_removeText(int handle, int startIndex, int length);

    private final native boolean ObjectTextBox_replaceText(int handle, String text, int staetIndex, int length);

    private final native boolean ObjectTextBox_setAutoFitOption(int handle, int textAutoFit);

    private final native boolean ObjectTextBox_setBackgroundColor(int handle, int color);

    private final native boolean ObjectTextBox_setBorderType(int handle, int type);

    private final native boolean ObjectTextBox_setBulletType(int handle, int type);

    private final native boolean ObjectTextBox_setCursorPos(int handle, int position);

    private final native boolean ObjectTextBox_setEllipsisType(int handle, int type);

    private final native boolean ObjectTextBox_setFont(int handle, String font);

    private final native boolean ObjectTextBox_setFontSize(int handle, float size);

    private final native boolean ObjectTextBox_setGravity(int handle, int textGravity);

    private final native boolean ObjectTextBox_setHintText(int handle, String hintText);

    private final native boolean ObjectTextBox_setHintTextColor(int handle, int color);

    private final native boolean ObjectTextBox_setHintTextFontSize(int handle, float size);

    private final native boolean ObjectTextBox_setHintTextVisibility(int handle, boolean visible);

    private final native boolean ObjectTextBox_setIMEActionType(int handle, int type);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean ObjectTextBox_setInitialCursorPos(int i);

    private final native boolean ObjectTextBox_setLineBorderColor(int handle, int color);

    private final native boolean ObjectTextBox_setLineBorderWidth(int handle, float width);

    private final native boolean ObjectTextBox_setLinedPaperColor(int handle, int color);

    private final native boolean ObjectTextBox_setLinedPaperEnabled(int handle, boolean enable);

    private final native boolean ObjectTextBox_setLinedPaperThickness(int handle, float thickness);

    private final native boolean ObjectTextBox_setMargin(int handle, float left, float top, float right, float bottom);

    private final native boolean ObjectTextBox_setParagraph(int handle, ArrayList<TextParagraphInfo> paragraph);

    private final native boolean ObjectTextBox_setParagraphEx(int handle, ArrayList<SpenTextParagraphBase> paragraph);

    private final native boolean ObjectTextBox_setSpan(int handle, ArrayList<TextSpanInfo> span);

    private final native boolean ObjectTextBox_setSpanEx(int handle, ArrayList<SpenTextSpanBase> span);

    private final native boolean ObjectTextBox_setText(int handle, String text);

    private final native boolean ObjectTextBox_setTextAlignment(int handle, int align);

    private final native boolean ObjectTextBox_setTextColor(int handle, int color);

    private final native boolean ObjectTextBox_setTextDirection(int handle, int direction);

    private final native boolean ObjectTextBox_setTextIndentLevel(int handle, int level);

    private final native boolean ObjectTextBox_setTextInputType(int handle, int type);

    private final native boolean ObjectTextBox_setTextLineSpacingInfo(int handle, int type, float lineSpacing);

    private final native boolean ObjectTextBox_setTextStyle(int handle, int style);

    private final native boolean ObjectTextBox_setVerticalPan(int handle, float position);

    @JvmStatic
    public static final void setInitialCursorPos(int i) {
        INSTANCE.setInitialCursorPos(i);
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectTextBox(" + this + ") is already closed");
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #appendTextParagraph(SpenTextParagraphBase)}.")
    public final void appendParagraph(@NotNull TextParagraphInfo paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (ObjectTextBox_appendParagraph(getMHandle(), paragraph)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #appendTextSpan(SpenTextSpanBase)}. ")
    public final void appendSpan(@NotNull TextSpanInfo span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (ObjectTextBox_appendSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void clearChangedFlag() {
        ObjectTextBox_clearChangedFlag(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShapeBase, com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectTextBox_copy(getMHandle(), source, source.getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #findTextParagraph(int, int)}.")
    @NotNull
    public final ArrayList<TextParagraphInfo> findParagraphs(int startPos, int endPos) {
        return ObjectTextBox_findParagraphs(getMHandle(), startPos, endPos);
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #findTextSpan(int, int)}.")
    @NotNull
    public final ArrayList<TextSpanInfo> findSpans(int startPos, int endPos) {
        return ObjectTextBox_findSpans(getMHandle(), startPos, endPos);
    }

    public final int getBackgroundColor() {
        return ObjectTextBox_getBackgroundColor(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final int getBorderType() {
        return ObjectTextBox_getBorderType(getMHandle());
    }

    public final int getBulletType() {
        return ObjectTextBox_getBulletType(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #getCursorPosition()}.")
    public final int getCursorPos() {
        return ObjectTextBox_getCursorPos(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @NotNull
    public RectF getDrawnRect() {
        return ObjectTextBox_getDrawnRect(getMHandle());
    }

    @Nullable
    public final String getFont() {
        return ObjectTextBox_getFont(getMHandle());
    }

    public final float getFontSize() {
        return ObjectTextBox_getFontSize(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect SpenLineColorEffect}.")
    public final int getLineBorderColor() {
        return ObjectTextBox_getLineBorderColor(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final float getLineBorderWidth() {
        return ObjectTextBox_getLineBorderWidth(getMHandle());
    }

    public final int getLinedPagerColor() {
        return ObjectTextBox_getLinedPaperColor(getMHandle());
    }

    public final float getLinedPagerThickness() {
        return ObjectTextBox_getLinedPaperThickness(getMHandle());
    }

    public final boolean getLinedPaperEnabled() {
        return ObjectTextBox_isLinedPaperEnabled(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #getTextParagraph()}.")
    @Nullable
    public final ArrayList<TextParagraphInfo> getParagraph() {
        return ObjectTextBox_getParagraph(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #getTextSpan()}.")
    @Nullable
    public final ArrayList<TextSpanInfo> getSpan() {
        return ObjectTextBox_getSpan(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShape
    public int getTextAlignment() {
        return ObjectTextBox_getTextAlignment(getMHandle());
    }

    public final int getTextColor() {
        return ObjectTextBox_getTextColor(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, not supported anymore.")
    public final int getTextIndentLevel() {
        return ObjectTextBox_getTextIndentLevel(getMHandle());
    }

    public final float getTextLineSpacing() {
        return ObjectTextBox_getTextLineSpacing(getMHandle());
    }

    public final int getTextLineSpacingType() {
        return ObjectTextBox_getTextLineSpacingType(getMHandle());
    }

    public final int getTextStyle() {
        return ObjectTextBox_getTextStyle(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public boolean isChanged() {
        return ObjectTextBox_isChanged(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenObjectShape#isTextReadOnlyEnabled()}.")
    public final boolean isReadOnlyEnabled() {
        return ObjectTextBox_isReadOnly(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #removeTextParagraph(SpenTextParagraphBase)}.")
    public final void removeParagraph(@NotNull TextParagraphInfo paragraph) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        if (ObjectTextBox_removeParagraph(getMHandle(), paragraph)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #removeTextSpan(SpenTextSpanBase)}.")
    public final void removeSpan(@NotNull TextSpanInfo span) {
        Intrinsics.checkNotNullParameter(span, "span");
        if (ObjectTextBox_removeSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundColor(int i) {
        if (ObjectTextBox_setBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final void setBorderType(int i) {
        if (ObjectTextBox_setBorderType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBulletType(int i) {
        if (ObjectTextBox_setBulletType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #setCursorPosition(int)}.")
    public final void setCursorPos(int i) {
        if (ObjectTextBox_setCursorPos(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFont(@Nullable String str) {
        if (ObjectTextBox_setFont(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFontSize(float f) {
        if (ObjectTextBox_setFontSize(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect SpenLineColorEffect}.")
    public final void setLineBorderColor(int i) {
        if (ObjectTextBox_setLineBorderColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final void setLineBorderWidth(float f) {
        if (ObjectTextBox_setLineBorderWidth(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLinedPagerColor(int i) {
        if (ObjectTextBox_setLinedPaperColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLinedPagerThickness(float f) {
        if (ObjectTextBox_setLinedPaperThickness(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLinedPaperEnabled(boolean z) {
        if (ObjectTextBox_setLinedPaperEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #setTextParagraph(ArrayList)}.")
    public final void setParagraph(@Nullable ArrayList<TextParagraphInfo> arrayList) {
        if (ObjectTextBox_setParagraph(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenObjectShape#setTextReadOnlyEnabled(boolean)}.")
    public final void setReadOnlyEnabled(boolean z) {
        if (ObjectTextBox_enableReadOnly(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(@Nullable RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #setTextSpan(ArrayList)}.")
    public final void setSpan(@Nullable ArrayList<TextSpanInfo> arrayList) {
        if (arrayList != null) {
            Iterator<TextSpanInfo> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextSpanInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextSpanInfo textSpanInfo = next;
                if (textSpanInfo.startPos < 0 || textSpanInfo.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        if (ObjectTextBox_setSpan(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShape
    public void setTextAlignment(int i) {
        if (ObjectTextBox_setTextAlignment(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextColor(int i) {
        if (ObjectTextBox_setTextColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, not supported anymore.")
    public final void setTextIndentLevel(int i) {
        if (ObjectTextBox_setTextIndentLevel(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextLineSpacingInfo(int type, float lineSpacing) {
        if (type == LINE_SPACING_PIXEL) {
            if (lineSpacing < 0.0f) {
                SpenError.ThrowUncheckedException(3);
            }
        } else if (type != LINE_SPACING_PERCENT) {
            SpenError.ThrowUncheckedException(7);
        } else if (lineSpacing <= 0.0f) {
            SpenError.ThrowUncheckedException(3);
        }
        if (ObjectTextBox_setTextLineSpacingInfo(getMHandle(), type, lineSpacing)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextStyle(int i) {
        int i2 = STYLE_MASK & i;
        int i4 = STYLE_NONE;
        if (i2 == i4 && i != i4) {
            throw new IllegalArgumentException("style is invalid");
        }
        if (ObjectTextBox_setTextStyle(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #setVerticalPan(float)}.")
    public final void setVereticalPan(float position) {
        if (ObjectTextBox_setVerticalPan(getMHandle(), position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectTextBox(boolean z) {
        super(2, 0);
        if (ObjectTextBox_init4(getMHandle(), null, null, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectTextBox(@Nullable String str) {
        super(2, 0);
        if (ObjectTextBox_init2(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectTextBox(@Nullable String str, boolean z) {
        super(2, 0);
        if (ObjectTextBox_init4(getMHandle(), str, null, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenObjectTextBox#SpenObjectTextBox(String, ArrayList)}.")
    public SpenObjectTextBox(@Nullable String str, @Nullable ArrayList<TextSpanInfo> arrayList) {
        super(2, 0);
        if (arrayList != null) {
            Iterator<TextSpanInfo> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextSpanInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextSpanInfo textSpanInfo = next;
                if (textSpanInfo.startPos < 0 || textSpanInfo.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        if (ObjectTextBox_init3(getMHandle(), str, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0,  replaced by {@link SpenObjectTextBox#SpenObjectTextBox(String, ArrayList, boolean)}.")
    public SpenObjectTextBox(@Nullable String str, @Nullable ArrayList<TextSpanInfo> arrayList, boolean z) {
        super(2, 0);
        if (arrayList != null) {
            Iterator<TextSpanInfo> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextSpanInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextSpanInfo textSpanInfo = next;
                if (textSpanInfo.startPos < 0 || textSpanInfo.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        if (ObjectTextBox_init4(getMHandle(), str, arrayList, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0,  replaced by {@link SpenObjectTextBox#SpenObjectTextBox(String, ArrayList, ArrayList)}.")
    public SpenObjectTextBox(@Nullable String str, @Nullable ArrayList<TextSpanInfo> arrayList, @Nullable ArrayList<TextParagraphInfo> arrayList2) {
        super(2, 0);
        if (arrayList != null) {
            Iterator<TextSpanInfo> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextSpanInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextSpanInfo textSpanInfo = next;
                if (textSpanInfo.startPos < 0 || textSpanInfo.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        if (ObjectTextBox_init4(getMHandle(), str, arrayList, arrayList2, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link SpenObjectTextBox#SpenObjectTextBox(String, ArrayList, ArrayList, boolean)}.")
    public SpenObjectTextBox(@Nullable String str, @Nullable ArrayList<TextSpanInfo> arrayList, @Nullable ArrayList<TextParagraphInfo> arrayList2, boolean z) {
        super(2, 0);
        if (arrayList != null) {
            Iterator<TextSpanInfo> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                TextSpanInfo next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                TextSpanInfo textSpanInfo = next;
                if (textSpanInfo.startPos < 0 || textSpanInfo.endPos < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of TextSpanInfo should have positive value");
                    return;
                }
            }
        }
        if (ObjectTextBox_init4(getMHandle(), str, arrayList, arrayList2, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
