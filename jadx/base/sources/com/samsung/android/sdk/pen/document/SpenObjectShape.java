package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillEffectBase;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
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
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0003\b\u0087\u0001\b\u0016\u0018\u0000 Ý\u00022\u00020\u0001:\u0002Ý\u0002B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB\u0013\b\u0010\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0005\u0010\u000fB\u001b\b\u0010\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u0010B5\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u0017J\u0012\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010%\u001a\u0004\u0018\u00010'J#\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\u0007\u0010\u009c\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u0003J\u0012\u0010\u009e\u0001\u001a\u00030\u009a\u00012\b\u00100\u001a\u0004\u0018\u000101J,\u0010\u009f\u0001\u001a\u00030\u009a\u00012\u0007\u0010 \u0001\u001a\u00020\u00152\u0007\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u0015J#\u0010¤\u0001\u001a\u00030\u009a\u00012\u0007\u0010¥\u0001\u001a\u00020\u00032\u0007\u0010¦\u0001\u001a\u00020\u00032\u0007\u0010§\u0001\u001a\u00020\u0003J\u0010\u0010¨\u0001\u001a\u00020\u00032\u0007\u0010¥\u0001\u001a\u00020\u0003J\u0010\u0010©\u0001\u001a\u00020\u00032\u0007\u0010¥\u0001\u001a\u00020\u0003J&\u0010ª\u0001\u001a\u00030\u009a\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0003J.\u0010¯\u0001\u001a\u00030\u009a\u00012\u0006\u00105\u001a\u00020\u00032\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003J\u001a\u0010±\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0003J&\u0010²\u0001\u001a\u00030\u009a\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003J\u0011\u0010³\u0001\u001a\u00030\u009a\u00012\u0007\u0010´\u0001\u001a\u00020\u000bJ#\u0010¯\u0001\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003J#\u0010¯\u0001\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u00020\u00032\u0007\u0010¶\u0001\u001a\u00020\u000bJ\u0010\u0010·\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u0003J\u0014\u0010¸\u0001\u001a\u00030\u009a\u00012\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\u0014\u0010¹\u0001\u001a\u00030\u009a\u00012\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001J/\u0010º\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010&j\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u0001`(2\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u0003J\u0007\u0010½\u0001\u001a\u00020\u000bJ\u0011\u0010¾\u0001\u001a\u00030\u0097\u00012\u0007\u0010¿\u0001\u001a\u00020\u0003J\u0011\u0010\u009e\u0001\u001a\u00030\u009a\u00012\u0007\u0010À\u0001\u001a\u00020\u0003J\u0011\u0010Á\u0001\u001a\u00030\u009a\u00012\u0007\u0010Â\u0001\u001a\u00020\u0003J\u0012\u0010Ã\u0001\u001a\u00030\u009a\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010Ä\u0001\u001a\u00030\u009a\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001b\u0010Ä\u0001\u001a\u00030\u009a\u00012\u0007\u0010Å\u0001\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001b\u0010Æ\u0001\u001a\u00030\u009a\u00012\u0007\u0010¿\u0001\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ$\u0010Æ\u0001\u001a\u00030\u009a\u00012\u0007\u0010¿\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0011\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¿\u0001\u001a\u00020\u0003J\u001a\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¿\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u0015J\u001c\u0010É\u0001\u001a\u00030\u009a\u00012\u0007\u0010¿\u0001\u001a\u00020\u00032\t\u00105\u001a\u0005\u0018\u00010È\u0001J\u001a\u0010#\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0007\u0010Ê\u0001\u001a\u00020\u000bJ\u001a\u0010¯\u0001\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u00020\u0003J\u0012\u0010Ë\u0001\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010Ì\u0001\u001a\u00030\u009a\u00012\u0007\u0010Í\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003J\b\u0010Î\u0001\u001a\u00030\u009a\u0001J$\u0010²\u0001\u001a\u00030\u009a\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0007\u0010Í\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003J\u0012\u0010Ï\u0001\u001a\u00030\u009a\u00012\b\u0010%\u001a\u0004\u0018\u00010'J\u0012\u0010Ð\u0001\u001a\u00030\u009a\u00012\b\u00100\u001a\u0004\u0018\u000101J6\u0010Ñ\u0001\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u0003J-\u0010Ñ\u0001\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u0003J-\u0010Ò\u0001\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(2\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u0003J6\u0010Ò\u0001\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(2\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u00032\u0007\u0010À\u0001\u001a\u00020\u0003J\u0013\u0010Ó\u0001\u001a\u00020\u000b2\n\u0010Ô\u0001\u001a\u0005\u0018\u00010È\u0001J\u001a\u0010^\u001a\u00030\u009a\u00012\b\u0010\\\u001a\u0004\u0018\u00010 2\u0007\u0010Ê\u0001\u001a\u00020\u000bJ\u0014\u0010Õ\u0001\u001a\u00030\u009a\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001J\u0014\u0010Ø\u0001\u001a\u00030\u009a\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001J\b\u0010Ù\u0001\u001a\u00030\u009a\u0001J\u001a\u0010Ú\u0001\u001a\u00030\u009a\u00012\u0007\u0010Û\u0001\u001a\u00020\u00032\u0007\u0010Ü\u0001\u001a\u00020\u0003J5\u0010Ý\u0001\u001a\u00030\u009a\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00032\u0007\u0010ß\u0001\u001a\u00020\u00032\u0007\u0010à\u0001\u001a\u00020\u00032\u0007\u0010á\u0001\u001a\u00020\u00032\u0007\u0010â\u0001\u001a\u00020\u0003J\u0010\u0010ã\u0001\u001a\u00030\u009a\u00012\u0006\u0010_\u001a\u00020\u000bJ\u0013\u0010ä\u0001\u001a\u00030\u009a\u00012\u0007\u0010å\u0001\u001a\u00020\u0003H\u0002J-\u0010æ\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0082 J?\u0010è\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0082 J\u001b\u0010é\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0013\u0010ê\u0001\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010ë\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082 J\u001d\u0010ì\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082 J&\u0010í\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082 J\u0013\u0010î\u0001\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J$\u0010ï\u0001\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0082 J/\u0010ð\u0001\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082 J\u0013\u0010ñ\u0001\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010ò\u0001\u001a\u00030È\u00012\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u0003H\u0082 J&\u0010ó\u0001\u001a\u00030È\u00012\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u0015H\u0082 J(\u0010ô\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u00032\n\u0010Ô\u0001\u001a\u0005\u0018\u00010È\u0001H\u0082 J\u001d\u0010õ\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0082 J&\u0010ö\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0007\u0010Ê\u0001\u001a\u00020\u000bH\u0082 J\u0013\u0010÷\u0001\u001a\u00020 2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J%\u0010ø\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u00020\u0003H\u0082 J\u001d\u0010ù\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0082 J%\u0010ú\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010û\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J/\u0010ü\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0007\u0010ý\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010þ\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010'H\u0082 J\u001d\u0010ÿ\u0001\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101H\u0082 JB\u0010\u0080\u0002\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u0003H\u0082 J#\u0010\u0081\u0002\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J#\u0010\u0082\u0002\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 JB\u0010\u0083\u0002\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u00032\u0007\u0010À\u0001\u001a\u00020\u0003H\u0082 J#\u0010\u0084\u0002\u001a\u0012\u0012\u0004\u0012\u0002010&j\b\u0012\u0004\u0012\u000201`(2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010\u0085\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010'H\u0082 J\u001d\u0010\u0086\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101H\u0082 J/\u0010\u0087\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(H\u0082 J/\u0010\u0088\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(H\u0082 J\u001b\u0010\u0089\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0082 J\u0013\u0010\u008a\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J7\u0010\u008b\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010 \u0001\u001a\u00020\u00152\u0007\u0010¡\u0001\u001a\u00020\u00152\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u0015H\u0082 J\u0013\u0010\u008c\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u008d\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u008e\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u008f\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010\u0090\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0091\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010\u0092\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0093\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010\u0094\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010 H\u0082 J\u0013\u0010\u0095\u0002\u001a\u00020 2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010\u0096\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010 H\u0082 J\u0013\u0010\u0097\u0002\u001a\u00020 2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001f\u0010\u0098\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\n\u0010Ô\u0001\u001a\u0005\u0018\u00010È\u0001H\u0082 J\u001b\u0010\u0099\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u000bH\u0082 J\u0013\u0010\u009a\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009b\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009c\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009d\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009e\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009f\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010 \u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010¡\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010¢\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010£\u0002\u001a\u00020\u000bH\u0082 J\u001b\u0010¤\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u0003H\u0082 J\u0013\u0010¥\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¦\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0013\u0010§\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¨\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0013\u0010©\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010ª\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0082 J\u0013\u0010«\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¬\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u000bH\u0082 J\u0013\u0010\u00ad\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J&\u0010®\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010 2\u0007\u0010Ê\u0001\u001a\u00020\u000bH\u0082 J\u0013\u0010¯\u0002\u001a\u00020 2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010°\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010±\u0002\u001a\u00020\u000bH\u0082 J\u0013\u0010²\u0002\u001a\u00020\u000b2\u0007\u0010³\u0002\u001a\u00020\u0003H\u0082 J\u001b\u0010´\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u0003H\u0082 J\u0013\u0010µ\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¶\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0015H\u0082 J\u0013\u0010·\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¸\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0015H\u0082 J\u0013\u0010¹\u0002\u001a\u00020\u00152\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010º\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001f\u0010»\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0082 J\u001f\u0010¼\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0082 J\u0013\u0010½\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¾\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0003H\u0082 J\u0013\u0010¿\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010À\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Á\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J.\u0010Â\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¥\u0001\u001a\u00020\u00032\u0007\u0010¦\u0001\u001a\u00020\u00032\u0007\u0010§\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Ã\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¥\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Ä\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¥\u0001\u001a\u00020\u0003H\u0082 J8\u0010Å\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010Æ\u0002\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0003H\u0082 J%\u0010Ç\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010Û\u0001\u001a\u00020\u00032\u0007\u0010Ü\u0001\u001a\u00020\u0003H\u0082 J@\u0010È\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\b\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010Æ\u0002\u001a\u00020\u00032\u0007\u0010É\u0002\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003H\u0082 J.\u0010Ê\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010Û\u0001\u001a\u00020\u00032\u0007\u0010Ü\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u0003H\u0082 J%\u0010Ë\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0003H\u0082 J\u0014\u0010Ì\u0002\u001a\u00030\u008d\u00012\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J8\u0010Í\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010Æ\u0002\u001a\u00020\u00032\u0007\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010°\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Î\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u000bH\u0082 J\u001c\u0010Ï\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010\u0090\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Ð\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J.\u0010Ñ\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Ò\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010\u0094\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Ó\u0002\u001a\u00020\u00032\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001f\u0010Ô\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0082 J\u001f\u0010Õ\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0082 J;\u0010Ö\u0002\u001a\u0018\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010&j\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u0001`(2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u0003H\u0082 J)\u0010×\u0002\u001a\u0018\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010&j\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u0001`(2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Ø\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010Ù\u0002\u001a\u00030\u0097\u00012\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Ú\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010À\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Û\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010Â\u0001\u001a\u00020\u0003H\u0082 J@\u0010Ü\u0002\u001a\u00020\u000b2\u0007\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010Þ\u0001\u001a\u00020\u00032\u0007\u0010ß\u0001\u001a\u00020\u00032\u0007\u0010à\u0001\u001a\u00020\u00032\u0007\u0010á\u0001\u001a\u00020\u00032\u0007\u0010â\u0001\u001a\u00020\u0003H\u0082 R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\tR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R(\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RL\u0010)\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(2\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020'\u0018\u00010&j\n\u0012\u0004\u0012\u00020'\u0018\u0001`(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R!\u0010.\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8F¢\u0006\u0006\u001a\u0004\b/\u0010+RL\u00102\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010&j\n\u0012\u0004\u0012\u000201\u0018\u0001`(8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010+\"\u0004\b4\u0010-R$\u00106\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\tR\u0011\u00109\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b=\u0010;R\u0011\u0010>\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b?\u0010;R\u0011\u0010@\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bA\u0010;R$\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\tR$\u0010F\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\tR(\u0010I\u001a\u0004\u0018\u00010 2\b\u0010I\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R(\u0010M\u001a\u0004\u0018\u00010 2\b\u0010L\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\"\"\u0004\bO\u0010$R\u0011\u0010P\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bQ\u0010;R\u0011\u0010R\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bS\u0010;R\u0011\u0010T\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bU\u0010;R\u0011\u0010V\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bW\u0010;R\u0011\u0010X\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bZ\u0010YR\u0011\u0010[\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b[\u0010YR(\u0010\\\u001a\u0004\u0018\u00010 2\b\u0010\\\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010\"\"\u0004\b^\u0010$R$\u0010`\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010bR$\u0010d\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\be\u0010\u0019\"\u0004\bf\u0010\tR$\u0010h\u001a\u00020\u00152\u0006\u0010g\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010;\"\u0004\bj\u0010kR$\u0010m\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0019\"\u0004\bo\u0010\tR$\u0010q\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010\u0019\"\u0004\bs\u0010\tR$\u0010t\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bu\u0010\u0019\"\u0004\bv\u0010\tR$\u0010w\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010\u0019\"\u0004\by\u0010\tR$\u0010z\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b{\u0010\u0019\"\u0004\b|\u0010\tR$\u0010}\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010;\"\u0004\b\u007f\u0010kR'\u0010\u0080\u0001\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010Y\"\u0005\b\u0081\u0001\u0010bR(\u0010\u0083\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010Y\"\u0005\b\u0085\u0001\u0010bR\u0013\u0010\u0086\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0019R\u0013\u0010\u0088\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u0019R\u0013\u0010\u008a\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\u0019R\u0015\u0010\u008c\u0001\u001a\u00030\u008d\u00018F¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R(\u0010\u0091\u0001\u001a\u00020\u00032\u0007\u0010\u0090\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010\u0019\"\u0005\b\u0093\u0001\u0010\tR\u0013\u0010\u0094\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u0019R)\u0010\u0096\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010&j\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u0001`(8F¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010+¨\u0006Þ\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase;", "objectType", "", "unused", "<init>", "(II)V", "()V", "shapeType", "(I)V", "isTemplateObject", "", "(IZ)V", "path", "Lcom/samsung/android/sdk/pen/document/SpenPath;", "(Lcom/samsung/android/sdk/pen/document/SpenPath;)V", "(Lcom/samsung/android/sdk/pen/document/SpenPath;Z)V", "type", BuddyContract.Address.REGION, "Landroid/graphics/RectF;", Key.ROTATION, "", "isRotatedPath", "(ILcom/samsung/android/sdk/pen/document/SpenPath;Landroid/graphics/RectF;FZ)V", "getShapeType", "()I", "setShapeType", "fillPathCount", "getFillPathCount", "controlPointCount", "getControlPointCount", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "paragraph", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextParagraphBase;", "Lkotlin/collections/ArrayList;", "textParagraph", "getTextParagraph", "()Ljava/util/ArrayList;", "setTextParagraph", "(Ljava/util/ArrayList;)V", "unparsedParagraphs", "getUnparsedParagraphs", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "textSpan", "getTextSpan", "setTextSpan", "position", "cursorPosition", "getCursorPosition", "setCursorPosition", "leftMargin", "getLeftMargin", "()F", "topMargin", "getTopMargin", "rightMargin", "getRightMargin", "bottomMargin", "getBottomMargin", "textGravity", "gravity", "getGravity", "setGravity", "textAreaType", "getTextAreaType", "setTextAreaType", "penName", "getPenName", "setPenName", "penStyle", "advancedPenSetting", "getAdvancedPenSetting", "setAdvancedPenSetting", "leftBaseMargin", "getLeftBaseMargin", "topBaseMargin", "getTopBaseMargin", "rightBaseMargin", "getRightBaseMargin", "bottomBaseMargin", "getBottomBaseMargin", "isTextVisible", "()Z", "isFlippedVertically", "isFlippedHorizontally", "hintText", "getHintText", "setHintText", "enable", "isHintTextEnabled", "setHintTextEnabled", "(Z)V", "color", "hintTextColor", "getHintTextColor", "setHintTextColor", "size", "hintTextFontSize", "getHintTextFontSize", "setHintTextFontSize", "(F)V", "style", "hintTextStyle", "getHintTextStyle", "setHintTextStyle", "textAutoFit", "autoFitOption", "getAutoFitOption", "setAutoFitOption", "ellipsisType", "getEllipsisType", "setEllipsisType", "imeActionType", "getImeActionType", "setImeActionType", "textInputType", "getTextInputType", "setTextInputType", "verticalPan", "getVerticalPan", "setVerticalPan", "isTextReadOnlyEnabled", "setTextReadOnlyEnabled", "isEditable", "textEditable", "getTextEditable", "setTextEditable", "fillEffectType", "getFillEffectType", "selectedStart", "getSelectedStart", "selectedEnd", "getSelectedEnd", "textComposition", "", "getTextComposition", "()[I", "align", "textAlignment", "getTextAlignment", "setTextAlignment", "textLimit", "getTextLimit", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "getObjectSpan", "removeTextParagraph", "", "startParagraphIndex", "endParagraphIndex", "paragraphFilterType", "removeTextSpan", "setMargin", "left", "top", "right", "bottom", "setTextSectionData", "sectionIndex", "sectionStart", "sectionLength", "getTextSectionStart", "getTextSectionLength", "copyText", "source", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "insertText", "length", "setTextComposition", "replaceText", "setEditingByUser", "isEditing", "expandParagraphFilter", "expandParagraph", "setTextLimit", "appendObjectSpan", "removeObjectSpan", "findObjectSpan", "startPos", "endPos", "clearObjectSpan", "getObjectSpanAtTextIndex", "index", "spanTypeFilter", "setTextComposingState", "composingState", "setPath", "getPath", "degree", "getFillPath", "getControlPoint", "Landroid/graphics/PointF;", "moveControlPoint", "skipHistory", "insertTextAtCursor", "removeText", "startPosition", "removeAllText", "appendTextParagraph", "appendTextSpan", "findTextParagraph", "findTextSpan", "contain", "point", "setFillEffect", "effect", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "getFillEffect", "resetFillEffect", "setSelection", "start", "end", "adjustIndentLevelParagraph", "startParaIndex", "endParaIndex", "indentOffset", "direction", "maxIndent", "setTextVisibility", "throwUncheckedException", "errno", "ObjectShape_init", "handle", "ObjectShape_init2", "ObjectShape_setShapeType", "ObjectShape_getShapeType", "ObjectShape_setPath", "ObjectShape_getPath", "ObjectShape_getPathWithRotation", "ObjectShape_getFillPathCount", "ObjectShape_getFillPath", "ObjectShape_getFillPathWithRotation", "ObjectShape_getControlPointCount", "ObjectShape_getControlPoint", "ObjectShape_getControlPointWithRotation", "ObjectShape_moveControlPoint", "ObjectShape_setText", "ObjectShape_setTextWithHistory", "ObjectShape_getText", "ObjectShape_insertText", "ObjectShape_insertTextAtCursor", "ObjectShape_removeText", "ObjectShape_removeAllText", "ObjectShape_replaceText", "staetIndex", "ObjectShape_appendParagraph", "ObjectShape_appendSpan", "ObjectShape_findParagraph", "ObjectShape_getParagraph", "ObjectShape_getUnparsedParagraph", "ObjectShape_findSpan", "ObjectShape_getSpan", "ObjectShape_removeParagraph", "ObjectShape_removeSpan", "ObjectShape_setSpan", "ObjectShape_setParagraph", "ObjectShape_setCursorPos", "ObjectShape_getCursorPos", "ObjectShape_setMargin", "ObjectShape_getLeftMargin", "ObjectShape_getTopMargin", "ObjectShape_getRightMargin", "ObjectShape_getBottomMargin", "ObjectShape_setGravity", "ObjectShape_getGravity", "ObjectShape_setTextAreaType", "ObjectShape_getTextAreaType", "ObjectShape_setPenName", "ObjectShape_getPenName", "ObjectShape_setAdvancedPenSetting", "ObjectShape_getAdvancedPenSetting", "ObjectShape_contain", "ObjectShape_setTextVisibility", "ObjectShape_isTextVisible", "ObjectShape_getLeftBaseMargin", "ObjectShape_getTopBaseMargin", "ObjectShape_getRightBaseMargin", "ObjectShape_getBottomBaseMargin", "ObjectShape_isFlippedVertically", "ObjectShape_isFlippedHorizontally", "ObjectShape_isTextEditable", "ObjectShape_setTextEditable", "editable", "ObjectShape_setAutoFitOption", "ObjectShape_getAutoFitOption", "ObjectShape_setEllipsisType", "ObjectShape_getEllipsisType", "ObjectShape_setIMEActionType", "ObjectShape_getIMEActionType", "ObjectShape_setTextInputType", "ObjectShape_getTextInputType", "ObjectShape_setTextReadOnlyEnabled", "ObjectShape_isTextReadOnlyEnabled", "ObjectShape_setHintText", "ObjectShape_getHintText", "ObjectShape_setHintTextVisibility", "visible", "ObjectShape_isHintTextVisiable", "handlev", "ObjectShape_setHintTextColor", "ObjectShape_getHintTextColor", "ObjectShape_setHintTextFontSize", "ObjectShape_getHintTextFontSize", "ObjectShape_setVerticalPan", "ObjectShape_getVerticalPan", "ObjectShape_getFillEffectType", "ObjectShape_setFillEffect", "ObjectShape_getFillEffect", "ObjectShape_resetFillEffect", "ObjectShape_setHintTextStyle", "ObjectShape_getHintTextStyle", "ObjectShape_getSelectedStart", "ObjectShape_getSelectedEnd", "ObjectShape_setTextSectionData", "ObjectShape_getTextSectionStart", "ObjectShape_getTextSectionLength", "ObjectShape_copyText", "sourceHandle", "ObjectShape_setSelection", "ObjectShape_insertText2", "sourceStart", "ObjectShape_removeParagraph2", "ObjectShape_setTextComposition", "ObjectShape_getTextComposition", "ObjectShape_replaceText2", "ObjectShape_setEditingByUser", "ObjectShape_setTextAlignment", "ObjectShape_getTextAlignment", "ObjectShape_insertText3", "ObjectShape_setTextLimit", "ObjectShape_getTextLimit", "ObjectShape_appendObjectSpan", "ObjectShape_removeObjectSpan", "ObjectShape_findObjectSpan", "ObjectShape_getObjectSpan", "ObjectShape_clearObjectSpan", "ObjectShape_getObjectSpanAtTextIndex", "ObjectShape_removeSpan2", "ObjectShape_setTextComposingState", "ObjectShape_adjustIndentLevelParagraph", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectShape.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectShape.kt\ncom/samsung/android/sdk/pen/document/SpenObjectShape\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2647:1\n1#2:2648\n*E\n"})
public class SpenObjectShape extends SpenObjectShapeBase {
    public static final int AUTO_FIT_BOTH = 3;
    public static final int AUTO_FIT_NONE = 0;
    public static final int AUTO_FIT_VERTICAL = 2;
    public static final int CURSOR_POS_END = 1;
    public static final int CURSOR_POS_START = 0;
    public static final int ELLIPSIS_DOTS = 1;
    public static final int ELLIPSIS_NONE = 0;
    public static final int ELLIPSIS_TRIANGLE = 2;

    @NotNull
    private static final String EMPTY_STRING = "";
    public static final int FILL_TYPE_DARKEN = 5;
    public static final int FILL_TYPE_DARKENLESS = 4;
    public static final int FILL_TYPE_LIGHTEN = 3;
    public static final int FILL_TYPE_LIGHTENLESS = 2;
    private static final int FILL_TYPE_MAX = 6;
    public static final int FILL_TYPE_NORMAL = 1;
    public static final int FILL_TYPE_TRANSPARENT = 0;
    public static final int GRAVITY_BOTTOM = 2;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_TOP = 0;
    public static final int HINT_TEXT_STYLE_BOLD = 1;
    public static final int HINT_TEXT_STYLE_ITALIC = 2;
    private static final int HINT_TEXT_STYLE_MASK = 7;
    public static final int HINT_TEXT_STYLE_NONE = 0;
    public static final int HINT_TEXT_STYLE_UNDERLINE = 4;
    public static final int IMEACTION_PREVIOUS = 7;
    public static final int IME_ACTION_DONE = 4;
    public static final int IME_ACTION_GO = 2;
    public static final int IME_ACTION_NEXT = 6;
    public static final int IME_ACTION_NONE = 1;
    public static final int IME_ACTION_PREVIOUS = 7;
    public static final int IME_ACTION_SEARCH = 3;
    public static final int IME_ACTION_SEND = 5;
    public static final int IME_ACTION_UNSPECIFIED = 0;
    public static final int INPUT_TYPE_DATETIME = 4;
    public static final int INPUT_TYPE_NONE = 0;
    public static final int INPUT_TYPE_NUMBER = 2;
    public static final int INPUT_TYPE_PHONE = 3;
    public static final int INPUT_TYPE_TEXT = 1;

    @NotNull
    private static final String NULL_STRING = "\u0000";
    public static final int TEXT_AREA_TYPE_FREE = 1;
    public static final int TEXT_AREA_TYPE_MARGIN = 0;
    public static final int TEXT_AREA_TYPE_PATH = 2;
    public static final int TYPE_10_POINT_STAR = 15;
    public static final int TYPE_32_POINT_STAR = 16;
    public static final int TYPE_4_POINThideContextMenusetObn_STAR = 12;
    public static final int TYPE_5_POINT_STAR = 13;
    public static final int TYPE_8_POINT_STAR = 14;
    public static final int TYPE_ARC = 20;
    public static final int TYPE_BENT_ARROW = 53;
    public static final int TYPE_BENT_UP_ARROW = 54;
    public static final int TYPE_BEVEL = 40;
    public static final int TYPE_BLOCK_ARC = 39;
    public static final int TYPE_CAN = 26;
    public static final int TYPE_CHEVRON = 19;
    public static final int TYPE_CHORD = 25;
    public static final int TYPE_CIRCULAR_ARROW = 62;
    public static final int TYPE_CROSS = 17;
    public static final int TYPE_CUBE = 27;
    public static final int TYPE_CURVE = 90;
    public static final int TYPE_CURVED_DOWN_ARROW = 58;
    public static final int TYPE_CURVED_LEFT_ARROW = 55;
    public static final int TYPE_CURVED_RIGHT_ARROW = 56;
    public static final int TYPE_CURVED_UP_ARROW = 57;
    public static final int TYPE_DIAMOND = 8;
    public static final int TYPE_DONUT = 35;
    public static final int TYPE_DOUBLE_WAVE = 43;
    public static final int TYPE_DOWN_ARROW = 47;
    public static final int TYPE_DOWN_ARROW_CALLOUT = 84;
    public static final int TYPE_DOWN_RIBBON = 34;
    public static final int TYPE_EXPLOSION_1 = 28;
    public static final int TYPE_EXPLOSION_2 = 29;
    public static final int TYPE_FLOWCHART_CARD = 68;
    public static final int TYPE_FLOWCHART_DELAY = 67;
    public static final int TYPE_FLOWCHART_DISPLAY = 70;
    public static final int TYPE_FLOWCHART_DOCUMENT = 71;
    public static final int TYPE_FLOWCHART_MANUAL_INPUT = 63;
    public static final int TYPE_FLOWCHART_OFF_PAGE_CONNECTOR = 69;
    public static final int TYPE_FLOWCHART_PREDEFINED_PROCESS = 65;
    public static final int TYPE_FLOWCHART_PUNCHED_TAPE = 72;
    public static final int TYPE_FLOWCHART_SEQUENTIAL_ACCESS_STORAGE = 73;
    public static final int TYPE_FLOWCHART_STORED_DATA = 66;
    public static final int TYPE_FLOWCHART_TERMINATOR = 64;
    public static final int TYPE_FOLDED_CORNER = 30;
    public static final int TYPE_HEART = 23;
    public static final int TYPE_HEXAGON = 6;
    public static final int TYPE_HORIZONTAL_SCROLL = 37;
    public static final int TYPE_LEFT_ARROW = 44;
    public static final int TYPE_LEFT_ARROW_CALLOUT = 81;
    public static final int TYPE_LEFT_BRACE = 74;
    public static final int TYPE_LEFT_BRACKET = 76;
    public static final int TYPE_LEFT_RIGHT_ARROW = 48;
    public static final int TYPE_LEFT_RIGHT_ARROW_CALLOUT = 85;
    public static final int TYPE_LEFT_RIGHT_UP_ARROW = 51;
    public static final int TYPE_LEFT_UP_ARROW = 50;
    public static final int TYPE_LIGHTNING_BOLT = 31;
    public static final int TYPE_L_SHAPE = 18;
    private static final int TYPE_MAX = 91;
    public static final int TYPE_MOON = 21;
    public static final int TYPE_NOTCHED_RIGHT_ARROW = 60;
    public static final int TYPE_NO_SYMBOL = 36;
    public static final int TYPE_OVAL = 1;
    public static final int TYPE_OVAL_CALLOUT = 80;
    public static final int TYPE_PARALLELOGRAM = 7;
    public static final int TYPE_PENTAGON = 10;
    public static final int TYPE_PIE = 24;
    public static final int TYPE_PLAQUE = 32;
    public static final int TYPE_POLYGON = 89;
    public static final int TYPE_POLYLINE = 88;
    public static final int TYPE_QUAD_ARROW = 52;
    public static final int TYPE_QUAD_ARROW_CALLOUT = 87;
    public static final int TYPE_RECTANGLE = 4;
    public static final int TYPE_RECTANGULAR_CALLOUT = 78;
    public static final int TYPE_REGULAR_PENTAGON = 11;
    public static final int TYPE_RIGHT_ARROW = 45;
    public static final int TYPE_RIGHT_ARROW_CALLOUT = 83;
    public static final int TYPE_RIGHT_BRACE = 75;
    public static final int TYPE_RIGHT_BRACKET = 77;
    public static final int TYPE_RIGHT_TRIANGLE = 3;
    public static final int TYPE_ROUNDED_RECTANGLE = 5;
    public static final int TYPE_ROUNDED_RECTANGULAR_CALLOUT = 79;
    public static final int TYPE_SMILEY_FACE = 22;
    public static final int TYPE_STRIPED_RIGHT_ARROW = 59;
    public static final int TYPE_SUN = 41;
    public static final int TYPE_TEXT_COMPOSING_END = 0;
    public static final int TYPE_TEXT_COMPOSING_START = 1;
    public static final int TYPE_TRAPEZOID = 9;
    public static final int TYPE_TRIANGLE = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UP_ARROW = 46;
    public static final int TYPE_UP_ARROW_CALLOUT = 82;
    public static final int TYPE_UP_DOWN_ARROW = 49;
    public static final int TYPE_UP_DOWN_ARROW_CALLOUT = 86;
    public static final int TYPE_UP_RIBBON = 33;
    public static final int TYPE_U_TURN_ARROW = 61;
    public static final int TYPE_VERTICAL_SCROLL = 38;
    public static final int TYPE_WAVE = 42;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final int AUTO_FIT_HORIZONTAL = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0003\b\u0088\u0001\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u0005H\u0007J\u0014\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\bo\u0010\u0003R\u000e\u0010p\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u008e\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectShape$Companion;", "", "<init>", "()V", "TYPE_UNKNOWN", "", "TYPE_OVAL", "TYPE_TRIANGLE", "TYPE_RIGHT_TRIANGLE", "TYPE_RECTANGLE", "TYPE_ROUNDED_RECTANGLE", "TYPE_HEXAGON", "TYPE_PARALLELOGRAM", "TYPE_DIAMOND", "TYPE_TRAPEZOID", "TYPE_PENTAGON", "TYPE_REGULAR_PENTAGON", "TYPE_4_POINThideContextMenusetObn_STAR", "TYPE_5_POINT_STAR", "TYPE_8_POINT_STAR", "TYPE_10_POINT_STAR", "TYPE_32_POINT_STAR", "TYPE_CROSS", "TYPE_L_SHAPE", "TYPE_CHEVRON", "TYPE_ARC", "TYPE_MOON", "TYPE_SMILEY_FACE", "TYPE_HEART", "TYPE_PIE", "TYPE_CHORD", "TYPE_CAN", "TYPE_CUBE", "TYPE_EXPLOSION_1", "TYPE_EXPLOSION_2", "TYPE_FOLDED_CORNER", "TYPE_LIGHTNING_BOLT", "TYPE_PLAQUE", "TYPE_UP_RIBBON", "TYPE_DOWN_RIBBON", "TYPE_DONUT", "TYPE_NO_SYMBOL", "TYPE_HORIZONTAL_SCROLL", "TYPE_VERTICAL_SCROLL", "TYPE_BLOCK_ARC", "TYPE_BEVEL", "TYPE_SUN", "TYPE_WAVE", "TYPE_DOUBLE_WAVE", "TYPE_LEFT_ARROW", "TYPE_RIGHT_ARROW", "TYPE_UP_ARROW", "TYPE_DOWN_ARROW", "TYPE_LEFT_RIGHT_ARROW", "TYPE_UP_DOWN_ARROW", "TYPE_LEFT_UP_ARROW", "TYPE_LEFT_RIGHT_UP_ARROW", "TYPE_QUAD_ARROW", "TYPE_BENT_ARROW", "TYPE_BENT_UP_ARROW", "TYPE_CURVED_LEFT_ARROW", "TYPE_CURVED_RIGHT_ARROW", "TYPE_CURVED_UP_ARROW", "TYPE_CURVED_DOWN_ARROW", "TYPE_STRIPED_RIGHT_ARROW", "TYPE_NOTCHED_RIGHT_ARROW", "TYPE_U_TURN_ARROW", "TYPE_CIRCULAR_ARROW", "TYPE_FLOWCHART_MANUAL_INPUT", "TYPE_FLOWCHART_TERMINATOR", "TYPE_FLOWCHART_PREDEFINED_PROCESS", "TYPE_FLOWCHART_STORED_DATA", "TYPE_FLOWCHART_DELAY", "TYPE_FLOWCHART_CARD", "TYPE_FLOWCHART_OFF_PAGE_CONNECTOR", "TYPE_FLOWCHART_DISPLAY", "TYPE_FLOWCHART_DOCUMENT", "TYPE_FLOWCHART_PUNCHED_TAPE", "TYPE_FLOWCHART_SEQUENTIAL_ACCESS_STORAGE", "TYPE_LEFT_BRACE", "TYPE_RIGHT_BRACE", "TYPE_LEFT_BRACKET", "TYPE_RIGHT_BRACKET", "TYPE_RECTANGULAR_CALLOUT", "TYPE_ROUNDED_RECTANGULAR_CALLOUT", "TYPE_OVAL_CALLOUT", "TYPE_LEFT_ARROW_CALLOUT", "TYPE_UP_ARROW_CALLOUT", "TYPE_RIGHT_ARROW_CALLOUT", "TYPE_DOWN_ARROW_CALLOUT", "TYPE_LEFT_RIGHT_ARROW_CALLOUT", "TYPE_UP_DOWN_ARROW_CALLOUT", "TYPE_QUAD_ARROW_CALLOUT", "TYPE_POLYLINE", "TYPE_POLYGON", "TYPE_CURVE", "TYPE_MAX", "TYPE_TEXT_COMPOSING_START", "TYPE_TEXT_COMPOSING_END", "FILL_TYPE_TRANSPARENT", "FILL_TYPE_NORMAL", "FILL_TYPE_LIGHTENLESS", "FILL_TYPE_LIGHTEN", "FILL_TYPE_DARKENLESS", "FILL_TYPE_DARKEN", "FILL_TYPE_MAX", "GRAVITY_TOP", "GRAVITY_CENTER", "GRAVITY_BOTTOM", "AUTO_FIT_NONE", "AUTO_FIT_HORIZONTAL", "getAUTO_FIT_HORIZONTAL$annotations", "AUTO_FIT_VERTICAL", "AUTO_FIT_BOTH", "ELLIPSIS_NONE", "ELLIPSIS_DOTS", "ELLIPSIS_TRIANGLE", "IME_ACTION_UNSPECIFIED", "IME_ACTION_NONE", "IME_ACTION_GO", "IME_ACTION_SEARCH", "IME_ACTION_DONE", "IME_ACTION_SEND", "IME_ACTION_NEXT", "IME_ACTION_PREVIOUS", "IMEACTION_PREVIOUS", "INPUT_TYPE_NONE", "INPUT_TYPE_TEXT", "INPUT_TYPE_NUMBER", "INPUT_TYPE_PHONE", "INPUT_TYPE_DATETIME", "CURSOR_POS_START", "CURSOR_POS_END", "TEXT_AREA_TYPE_MARGIN", "TEXT_AREA_TYPE_FREE", "TEXT_AREA_TYPE_PATH", "HINT_TEXT_STYLE_NONE", "HINT_TEXT_STYLE_BOLD", "HINT_TEXT_STYLE_ITALIC", "HINT_TEXT_STYLE_UNDERLINE", "HINT_TEXT_STYLE_MASK", "NULL_STRING", "", "EMPTY_STRING", "setInitialCursorPos", "", "initialCursorPos", "ObjectShape_setInitialCursorPos", "", "cursorPos", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSpenObjectShape.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectShape.kt\ncom/samsung/android/sdk/pen/document/SpenObjectShape$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2647:1\n1#2:2648\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final boolean ObjectShape_setInitialCursorPos(int cursorPos) {
            return SpenObjectShape.ObjectShape_setInitialCursorPos(cursorPos);
        }

        @Deprecated(message = "Increase the horizontal size of the object to completely fill the container.\n      Supported to only SpenObjectTextBox.\n      \n      ")
        public static /* synthetic */ void getAUTO_FIT_HORIZONTAL$annotations() {
        }

        @JvmStatic
        public final void setInitialCursorPos(int initialCursorPos) {
            if (initialCursorPos != 0 && initialCursorPos != 1) {
                throw new IllegalArgumentException("E_INVALID_ARG");
            }
            if (!ObjectShape_setInitialCursorPos(initialCursorPos)) {
                throw new IllegalArgumentException("E_INVALID_ARG");
            }
        }

        private Companion() {
        }
    }

    public SpenObjectShape(int i, int i2) {
        super(i);
    }

    private final native boolean ObjectShape_adjustIndentLevelParagraph(int handle, int startParaIndex, int endParaIndex, int indentOffset, int direction, int maxIndent);

    private final native boolean ObjectShape_appendObjectSpan(int handle, SpenObjectSpan objectSpan);

    private final native boolean ObjectShape_appendParagraph(int handle, SpenTextParagraphBase paragraph);

    private final native boolean ObjectShape_appendSpan(int handle, SpenTextSpanBase span);

    private final native boolean ObjectShape_clearObjectSpan(int handle);

    private final native boolean ObjectShape_contain(int handle, PointF point);

    private final native boolean ObjectShape_copyText(int handle, SpenObjectBase source, int sourceHandle, int startIndex, int endIndex);

    private final native ArrayList<SpenObjectSpan> ObjectShape_findObjectSpan(int handle, int startPos, int endPos);

    private final native ArrayList<SpenTextParagraphBase> ObjectShape_findParagraph(int handle, int startPos, int endPos, int paragraphFilterType);

    private final native ArrayList<SpenTextSpanBase> ObjectShape_findSpan(int handle, int startPos, int endPos, int spanTypeFilter);

    private final native String ObjectShape_getAdvancedPenSetting(int handle);

    private final native int ObjectShape_getAutoFitOption(int handle);

    private final native float ObjectShape_getBottomBaseMargin(int handle);

    private final native float ObjectShape_getBottomMargin(int handle);

    private final native PointF ObjectShape_getControlPoint(int handle, int index);

    private final native int ObjectShape_getControlPointCount(int handle);

    private final native PointF ObjectShape_getControlPointWithRotation(int handle, int index, float degree);

    private final native int ObjectShape_getCursorPos(int handle);

    private final native int ObjectShape_getEllipsisType(int handle);

    private final native boolean ObjectShape_getFillEffect(int handle, SpenFillEffectBase effect);

    private final native int ObjectShape_getFillEffectType(int handle);

    private final native int ObjectShape_getFillPath(int handle, int index, SpenPath path);

    private final native int ObjectShape_getFillPathCount(int handle);

    private final native int ObjectShape_getFillPathWithRotation(int handle, int index, float degree, SpenPath path);

    private final native int ObjectShape_getGravity(int handle);

    private final native String ObjectShape_getHintText(int handle);

    private final native int ObjectShape_getHintTextColor(int handle);

    private final native float ObjectShape_getHintTextFontSize(int handle);

    private final native int ObjectShape_getHintTextStyle(int handle);

    private final native int ObjectShape_getIMEActionType(int handle);

    private final native float ObjectShape_getLeftBaseMargin(int handle);

    private final native float ObjectShape_getLeftMargin(int handle);

    private final native ArrayList<SpenObjectSpan> ObjectShape_getObjectSpan(int handle);

    private final native SpenObjectSpan ObjectShape_getObjectSpanAtTextIndex(int handle, int index);

    private final native ArrayList<SpenTextParagraphBase> ObjectShape_getParagraph(int handle);

    private final native boolean ObjectShape_getPath(int handle, SpenPath path);

    private final native boolean ObjectShape_getPathWithRotation(int handle, float degree, SpenPath path);

    private final native String ObjectShape_getPenName(int handle);

    private final native float ObjectShape_getRightBaseMargin(int handle);

    private final native float ObjectShape_getRightMargin(int handle);

    private final native int ObjectShape_getSelectedEnd(int handle);

    private final native int ObjectShape_getSelectedStart(int handle);

    private final native int ObjectShape_getShapeType(int handle);

    private final native ArrayList<SpenTextSpanBase> ObjectShape_getSpan(int handle);

    private final native String ObjectShape_getText(int handle);

    private final native int ObjectShape_getTextAlignment(int handle);

    private final native int ObjectShape_getTextAreaType(int handle);

    private final native int[] ObjectShape_getTextComposition(int handle);

    private final native int ObjectShape_getTextInputType(int handle);

    private final native int ObjectShape_getTextLimit(int handle);

    private final native int ObjectShape_getTextSectionLength(int handle, int sectionIndex);

    private final native int ObjectShape_getTextSectionStart(int handle, int sectionIndex);

    private final native float ObjectShape_getTopBaseMargin(int handle);

    private final native float ObjectShape_getTopMargin(int handle);

    private final native ArrayList<SpenTextParagraphBase> ObjectShape_getUnparsedParagraph(int handle);

    private final native float ObjectShape_getVerticalPan(int handle);

    private final native boolean ObjectShape_init(int handle, int type, SpenPath path, boolean isTemplateObject);

    private final native boolean ObjectShape_init2(int handle, int type, SpenPath path, RectF region, float rotation, boolean isRotatedPath);

    private final native boolean ObjectShape_insertText(int handle, String text, int position);

    private final native boolean ObjectShape_insertText2(int handle, int position, SpenObjectBase source, int sourceHandle, int sourceStart, int length);

    private final native boolean ObjectShape_insertText3(int handle, String text, int position, int expandParagraphFilter);

    private final native boolean ObjectShape_insertTextAtCursor(int handle, String text);

    private final native boolean ObjectShape_isFlippedHorizontally(int handle);

    private final native boolean ObjectShape_isFlippedVertically(int handle);

    private final native boolean ObjectShape_isHintTextVisiable(int handlev);

    private final native boolean ObjectShape_isTextEditable(int handle);

    private final native boolean ObjectShape_isTextReadOnlyEnabled(int handle);

    private final native boolean ObjectShape_isTextVisible(int handle);

    private final native boolean ObjectShape_moveControlPoint(int handle, int index, PointF point);

    private final native boolean ObjectShape_removeAllText(int handle);

    private final native boolean ObjectShape_removeObjectSpan(int handle, SpenObjectSpan objectSpan);

    private final native boolean ObjectShape_removeParagraph(int handle, SpenTextParagraphBase paragraph);

    private final native boolean ObjectShape_removeParagraph2(int handle, int start, int end, int paragraphFilterType);

    private final native boolean ObjectShape_removeSpan(int handle, SpenTextSpanBase span);

    private final native boolean ObjectShape_removeSpan2(int handle, int spanTypeFilter);

    private final native boolean ObjectShape_removeText(int handle, int startIndex, int length);

    private final native boolean ObjectShape_replaceText(int handle, String text, int staetIndex, int length);

    private final native boolean ObjectShape_replaceText2(int handle, SpenObjectBase source, int sourceHandle, int startIndex, int length);

    private final native boolean ObjectShape_resetFillEffect(int handle);

    private final native boolean ObjectShape_setAdvancedPenSetting(int handle, String penStyle);

    private final native boolean ObjectShape_setAutoFitOption(int handle, int textAutoFit);

    private final native boolean ObjectShape_setCursorPos(int handle, int position);

    private final native boolean ObjectShape_setEditingByUser(int handle, boolean isEditing);

    private final native boolean ObjectShape_setEllipsisType(int handle, int type);

    private final native boolean ObjectShape_setFillEffect(int handle, SpenFillEffectBase effect);

    private final native boolean ObjectShape_setGravity(int handle, int textGravity);

    private final native boolean ObjectShape_setHintText(int handle, String hintText, boolean skipHistory);

    private final native boolean ObjectShape_setHintTextColor(int handle, int color);

    private final native boolean ObjectShape_setHintTextFontSize(int handle, float size);

    private final native boolean ObjectShape_setHintTextStyle(int handle, int size);

    private final native boolean ObjectShape_setHintTextVisibility(int handle, boolean visible);

    private final native boolean ObjectShape_setIMEActionType(int handle, int type);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean ObjectShape_setInitialCursorPos(int i);

    private final native boolean ObjectShape_setMargin(int handle, float left, float top, float right, float bottom);

    private final native boolean ObjectShape_setParagraph(int handle, ArrayList<SpenTextParagraphBase> paragraph);

    private final native boolean ObjectShape_setPath(int handle, SpenPath path);

    private final native boolean ObjectShape_setPenName(int handle, String penName);

    private final native boolean ObjectShape_setSelection(int handle, int start, int end);

    private final native boolean ObjectShape_setShapeType(int handle, int type);

    private final native boolean ObjectShape_setSpan(int handle, ArrayList<SpenTextSpanBase> span);

    private final native boolean ObjectShape_setText(int handle, String text);

    private final native boolean ObjectShape_setTextAlignment(int handle, int align);

    private final native boolean ObjectShape_setTextAreaType(int handle, int type);

    private final native boolean ObjectShape_setTextComposingState(int handle, int composingState);

    private final native boolean ObjectShape_setTextComposition(int handle, int startIndex, int endIndex);

    private final native boolean ObjectShape_setTextEditable(int handle, boolean editable);

    private final native boolean ObjectShape_setTextInputType(int handle, int type);

    private final native boolean ObjectShape_setTextLimit(int handle, int textLimit);

    private final native boolean ObjectShape_setTextReadOnlyEnabled(int handle, boolean enable);

    private final native boolean ObjectShape_setTextSectionData(int handle, int sectionIndex, int sectionStart, int sectionLength);

    private final native boolean ObjectShape_setTextVisibility(int handle, boolean enable);

    private final native boolean ObjectShape_setTextWithHistory(int handle, String text, boolean skipHistory);

    private final native boolean ObjectShape_setVerticalPan(int handle, float position);

    @JvmStatic
    public static final void setInitialCursorPos(int i) {
        INSTANCE.setInitialCursorPos(i);
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectShape(" + this + ") is already closed");
    }

    public final void adjustIndentLevelParagraph(int startParaIndex, int endParaIndex, int indentOffset, int direction, int maxIndent) {
        if (ObjectShape_adjustIndentLevelParagraph(getMHandle(), startParaIndex, endParaIndex, indentOffset, direction, maxIndent)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendObjectSpan(@Nullable SpenObjectSpan objectSpan) {
        if (ObjectShape_appendObjectSpan(getMHandle(), objectSpan)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendTextParagraph(@Nullable SpenTextParagraphBase paragraph) {
        if (ObjectShape_appendParagraph(getMHandle(), paragraph)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendTextSpan(@Nullable SpenTextSpanBase span) {
        if (ObjectShape_appendSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean clearObjectSpan() {
        return ObjectShape_clearObjectSpan(getMHandle());
    }

    public final boolean contain(@Nullable PointF point) {
        return ObjectShape_contain(getMHandle(), point);
    }

    public final void copyText(@Nullable SpenObjectBase source, int startIndex, int endIndex) {
        if (source == null) {
            throw new IllegalArgumentException("invalid source");
        }
        if (ObjectShape_copyText(getMHandle(), source, source.getMHandle(), startIndex, endIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final ArrayList<SpenObjectSpan> findObjectSpan(int startPos, int endPos) {
        return ObjectShape_findObjectSpan(getMHandle(), startPos, endPos);
    }

    @Nullable
    public final ArrayList<SpenTextParagraphBase> findTextParagraph(int startPos, int endPos, int paragraphFilterType) {
        return ObjectShape_findParagraph(getMHandle(), startPos, endPos, paragraphFilterType);
    }

    @Nullable
    public final ArrayList<SpenTextSpanBase> findTextSpan(int startPos, int endPos) {
        return ObjectShape_findSpan(getMHandle(), startPos, endPos, 16777215);
    }

    @Nullable
    public final String getAdvancedPenSetting() {
        return ObjectShape_getAdvancedPenSetting(getMHandle());
    }

    public int getAutoFitOption() {
        return ObjectShape_getAutoFitOption(getMHandle());
    }

    public final float getBottomBaseMargin() {
        return ObjectShape_getBottomBaseMargin(getMHandle());
    }

    public final float getBottomMargin() {
        return ObjectShape_getBottomMargin(getMHandle());
    }

    @NotNull
    public final PointF getControlPoint(int index) {
        if (index < 0 || index >= getControlPointCount()) {
            throw new IndexOutOfBoundsException("E_OUT_OF_RANGE");
        }
        return ObjectShape_getControlPoint(getMHandle(), index);
    }

    public final int getControlPointCount() {
        return ObjectShape_getControlPointCount(getMHandle());
    }

    public final int getCursorPosition() {
        return ObjectShape_getCursorPos(getMHandle());
    }

    public final int getEllipsisType() {
        return ObjectShape_getEllipsisType(getMHandle());
    }

    public final void getFillEffect(@Nullable SpenFillEffectBase effect) {
        if (ObjectShape_getFillEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final int getFillEffectType() {
        return ObjectShape_getFillEffectType(getMHandle());
    }

    public final void getFillPath(int index, @Nullable SpenPath path) {
        if (path == null) {
            throw new IllegalArgumentException("path is null");
        }
        if (ObjectShape_getFillPath(getMHandle(), index, path) == -1) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public final int getFillPathCount() {
        return ObjectShape_getFillPathCount(getMHandle());
    }

    public final int getGravity() {
        return ObjectShape_getGravity(getMHandle());
    }

    @Nullable
    public final String getHintText() {
        return ObjectShape_getHintText(getMHandle());
    }

    public final int getHintTextColor() {
        return ObjectShape_getHintTextColor(getMHandle());
    }

    public final float getHintTextFontSize() {
        return ObjectShape_getHintTextFontSize(getMHandle());
    }

    public final int getHintTextStyle() {
        return ObjectShape_getHintTextStyle(getMHandle());
    }

    public final int getImeActionType() {
        return ObjectShape_getIMEActionType(getMHandle());
    }

    public final float getLeftBaseMargin() {
        return ObjectShape_getLeftBaseMargin(getMHandle());
    }

    public final float getLeftMargin() {
        return ObjectShape_getLeftMargin(getMHandle());
    }

    @Nullable
    public final ArrayList<SpenObjectSpan> getObjectSpan() {
        return ObjectShape_getObjectSpan(getMHandle());
    }

    @NotNull
    public final SpenObjectSpan getObjectSpanAtTextIndex(int index) {
        return ObjectShape_getObjectSpanAtTextIndex(getMHandle(), index);
    }

    public final void getPath(@Nullable SpenPath path) {
        if (path == null) {
            throw new IllegalArgumentException("path is null");
        }
        if (ObjectShape_getPath(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShapeBase
    @Nullable
    public String getPenName() {
        return ObjectShape_getPenName(getMHandle());
    }

    public final float getRightBaseMargin() {
        return ObjectShape_getRightBaseMargin(getMHandle());
    }

    public final float getRightMargin() {
        return ObjectShape_getRightMargin(getMHandle());
    }

    public final int getSelectedEnd() {
        return ObjectShape_getSelectedEnd(getMHandle());
    }

    public final int getSelectedStart() {
        return ObjectShape_getSelectedStart(getMHandle());
    }

    public final int getShapeType() {
        return ObjectShape_getShapeType(getMHandle());
    }

    @Nullable
    public final String getText() {
        return ObjectShape_getText(getMHandle());
    }

    public int getTextAlignment() {
        return ObjectShape_getTextAlignment(getMHandle());
    }

    public final int getTextAreaType() {
        return ObjectShape_getTextAreaType(getMHandle());
    }

    @NotNull
    public final int[] getTextComposition() {
        return ObjectShape_getTextComposition(getMHandle());
    }

    public final boolean getTextEditable() {
        return ObjectShape_isTextEditable(getMHandle());
    }

    public final int getTextInputType() {
        return ObjectShape_getTextInputType(getMHandle());
    }

    public final int getTextLimit() {
        return ObjectShape_getTextLimit(getMHandle());
    }

    @Nullable
    public final ArrayList<SpenTextParagraphBase> getTextParagraph() {
        return ObjectShape_getParagraph(getMHandle());
    }

    public final int getTextSectionLength(int sectionIndex) {
        return ObjectShape_getTextSectionLength(getMHandle(), sectionIndex);
    }

    public final int getTextSectionStart(int sectionIndex) {
        return ObjectShape_getTextSectionStart(getMHandle(), sectionIndex);
    }

    @Nullable
    public final ArrayList<SpenTextSpanBase> getTextSpan() {
        return ObjectShape_getSpan(getMHandle());
    }

    public final float getTopBaseMargin() {
        return ObjectShape_getTopBaseMargin(getMHandle());
    }

    public final float getTopMargin() {
        return ObjectShape_getTopMargin(getMHandle());
    }

    @NotNull
    public final ArrayList<SpenTextParagraphBase> getUnparsedParagraphs() {
        return ObjectShape_getUnparsedParagraph(getMHandle());
    }

    public final float getVerticalPan() {
        return ObjectShape_getVerticalPan(getMHandle());
    }

    public final void insertText(int position, @Nullable SpenObjectBase source, int startIndex, int length) {
        if (source == null) {
            throw new IllegalArgumentException("invalid source");
        }
        if (ObjectShape_insertText2(getMHandle(), position, source, source.getMHandle(), startIndex, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertTextAtCursor(@Nullable String text) {
        if (ObjectShape_insertTextAtCursor(getMHandle(), text)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isFlippedHorizontally() {
        return ObjectShape_isFlippedHorizontally(getMHandle());
    }

    public final boolean isFlippedVertically() {
        return ObjectShape_isFlippedVertically(getMHandle());
    }

    public final boolean isHintTextEnabled() {
        return ObjectShape_isHintTextVisiable(getMHandle());
    }

    public final boolean isTextReadOnlyEnabled() {
        return ObjectShape_isTextReadOnlyEnabled(getMHandle());
    }

    public final boolean isTextVisible() {
        return ObjectShape_isTextVisible(getMHandle());
    }

    public final void moveControlPoint(int index, @Nullable PointF position) {
        if (index < 0 || index >= getControlPointCount()) {
            throw new IndexOutOfBoundsException("E_OUT_OF_RANGE");
        }
        if (ObjectShape_moveControlPoint(getMHandle(), index, position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeAllText() {
        if (ObjectShape_removeAllText(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeObjectSpan(@Nullable SpenObjectSpan objectSpan) {
        if (ObjectShape_removeObjectSpan(getMHandle(), objectSpan)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeText(int startPosition, int length) {
        if (ObjectShape_removeText(getMHandle(), startPosition, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeTextParagraph(@Nullable SpenTextParagraphBase paragraph) {
        if (ObjectShape_removeParagraph(getMHandle(), paragraph)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeTextSpan(@Nullable SpenTextSpanBase span) {
        if (ObjectShape_removeSpan(getMHandle(), span)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void replaceText(@Nullable SpenObjectBase source, int startIndex, int length) {
        if (source == null) {
            throw new IllegalArgumentException("invalid source");
        }
        if (ObjectShape_replaceText2(getMHandle(), source, source.getMHandle(), startIndex, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void resetFillEffect() {
        ObjectShape_resetFillEffect(getMHandle());
    }

    public final void setAdvancedPenSetting(@Nullable String str) {
        if (ObjectShape_setAdvancedPenSetting(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setAutoFitOption(int i) {
        if (ObjectShape_setAutoFitOption(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCursorPosition(int i) {
        if (ObjectShape_setCursorPos(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setEditingByUser(boolean isEditing) {
        if (ObjectShape_setEditingByUser(getMHandle(), isEditing)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setEllipsisType(int i) {
        if (ObjectShape_setEllipsisType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFillEffect(@Nullable SpenFillEffectBase effect) {
        if (ObjectShape_setFillEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setGravity(int i) {
        if (ObjectShape_setGravity(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintText(@Nullable String str) {
        if (ObjectShape_setHintText(getMHandle(), str, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextColor(int i) {
        if (ObjectShape_setHintTextColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextEnabled(boolean z) {
        if (ObjectShape_setHintTextVisibility(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextFontSize(float f) {
        if (ObjectShape_setHintTextFontSize(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintTextStyle(int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException("Hint style is invalid");
        }
        if (ObjectShape_setHintTextStyle(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImeActionType(int i) {
        if (ObjectShape_setIMEActionType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMargin(float left, float top, float right, float bottom) {
        if (ObjectShape_setMargin(getMHandle(), left, top, right, bottom)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPath(@Nullable SpenPath path) {
        if (path == null) {
            throw new IllegalArgumentException("path is null");
        }
        if (ObjectShape_setPath(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setPenName(@Nullable String str) {
        if (ObjectShape_setPenName(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSelection(int start, int end) {
        if (ObjectShape_setSelection(getMHandle(), start, end)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setShapeType(int i) {
        if (i < 0 || i >= 91) {
            throw new IllegalArgumentException("Unknown type");
        }
        if (ObjectShape_setShapeType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setText(@Nullable String str) {
        if (ObjectShape_setText(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setTextAlignment(int i) {
        if (ObjectShape_setTextAlignment(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextAreaType(int i) {
        if (ObjectShape_setTextAreaType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextComposingState(int composingState) {
        if (ObjectShape_setTextComposingState(getMHandle(), composingState)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextComposition(int startIndex, int endIndex) {
        if (ObjectShape_setTextComposition(getMHandle(), startIndex, endIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextEditable(boolean z) {
        if (ObjectShape_setTextEditable(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextInputType(int i) {
        if (ObjectShape_setTextInputType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean setTextLimit(int textLimit) {
        boolean zObjectShape_setTextLimit = ObjectShape_setTextLimit(getMHandle(), textLimit);
        if (!zObjectShape_setTextLimit) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectShape_setTextLimit;
    }

    public final void setTextParagraph(@Nullable ArrayList<SpenTextParagraphBase> arrayList) {
        if (arrayList != null) {
            Iterator<SpenTextParagraphBase> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextParagraphBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextParagraphBase spenTextParagraphBase = next;
                if (spenTextParagraphBase.getStart() < 0 || spenTextParagraphBase.getEnd() < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of SpenTextParagraphBase should have positive value");
                    return;
                }
            }
        }
        if (ObjectShape_setParagraph(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextReadOnlyEnabled(boolean z) {
        if (ObjectShape_setTextReadOnlyEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextSectionData(int sectionIndex, int sectionStart, int sectionLength) {
        if (ObjectShape_setTextSectionData(getMHandle(), sectionIndex, sectionStart, sectionLength)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextSpan(@Nullable ArrayList<SpenTextSpanBase> arrayList) {
        if (arrayList != null) {
            Iterator<SpenTextSpanBase> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getStart() < 0 || spenTextSpanBase.getEnd() < 0) {
                    SpenError.ThrowUncheckedException(7, "startPos and endPos of SpenTextSpanBase should have positive value");
                    return;
                }
            }
        }
        if (ObjectShape_setSpan(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextVisibility(boolean enable) {
        if (ObjectShape_setTextVisibility(getMHandle(), enable)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setVerticalPan(float f) {
        if (ObjectShape_setVerticalPan(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectShape() {
        super(7);
    }

    @Nullable
    public final ArrayList<SpenTextParagraphBase> findTextParagraph(int startPos, int endPos) {
        return findTextParagraph(startPos, endPos, 16777215);
    }

    @Nullable
    public final ArrayList<SpenTextSpanBase> findTextSpan(int startPos, int endPos, int spanTypeFilter) {
        return ObjectShape_findSpan(getMHandle(), startPos, endPos, spanTypeFilter);
    }

    public SpenObjectShape(int i) {
        super(7);
        if (ObjectShape_init(getMHandle(), i, null, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeTextParagraph(int startParagraphIndex, int endParagraphIndex, int paragraphFilterType) {
        if (paragraphFilterType > 0 && paragraphFilterType <= 2047) {
            if (ObjectShape_removeParagraph2(getMHandle(), startParagraphIndex, endParagraphIndex, paragraphFilterType)) {
                return;
            }
            throwUncheckedException(SpenError.getError());
            return;
        }
        throw new IllegalArgumentException("paragraphFilterType is out of range");
    }

    public final void removeTextSpan(int spanTypeFilter) {
        if (ObjectShape_removeSpan2(getMHandle(), spanTypeFilter)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHintText(@Nullable String hintText, boolean skipHistory) {
        if (ObjectShape_setHintText(getMHandle(), hintText, skipHistory)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setText(@Nullable String text, boolean skipHistory) {
        if (ObjectShape_setTextWithHistory(getMHandle(), text, skipHistory)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final PointF getControlPoint(int index, float degree) {
        if (index >= 0 && index < getControlPointCount()) {
            return ObjectShape_getControlPointWithRotation(getMHandle(), index, degree);
        }
        throw new IndexOutOfBoundsException("E_OUT_OF_RANGE");
    }

    public final void getFillPath(int index, float degree, @Nullable SpenPath path) {
        if (ObjectShape_getFillPathWithRotation(getMHandle(), index, degree, path) == -1) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public final void getPath(float degree, @Nullable SpenPath path) {
        if (path != null) {
            if (ObjectShape_getPathWithRotation(getMHandle(), degree, path)) {
                return;
            }
            throwUncheckedException(SpenError.getError());
            return;
        }
        throw new IllegalArgumentException("path is null");
    }

    public final void replaceText(@Nullable String text, int startPosition, int length) {
        if (ObjectShape_replaceText(getMHandle(), text, startPosition, length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectShape(int i, boolean z) {
        super(7);
        if (ObjectShape_init(getMHandle(), i, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertText(@Nullable String text, int position, int expandParagraphFilter) {
        if (ObjectShape_insertText3(getMHandle(), text, position, expandParagraphFilter)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertText(@Nullable String text, int position, boolean expandParagraph) {
        if (ObjectShape_insertText3(getMHandle(), text, position, expandParagraph ? SpenTextParagraphBase.FILTER_PARAGRAPH_ALL : SpenTextParagraphBase.FILTER_PARAGRAPH_PREDEFINED_STYLE_SET)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectShape(@Nullable SpenPath spenPath) {
        super(7);
        if (ObjectShape_init(getMHandle(), 0, spenPath, false)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertText(@Nullable String text, int position) {
        if (text == null || ObjectShape_insertText(getMHandle(), new Regex("\u0000").replace(text, ""), position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectShape(@Nullable SpenPath spenPath, boolean z) {
        super(7);
        if (ObjectShape_init(getMHandle(), 0, spenPath, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectShape(int i, @Nullable SpenPath spenPath, @Nullable RectF rectF, float f, boolean z) {
        super(7);
        if (ObjectShape_init2(getMHandle(), i, spenPath, rectF, f, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
