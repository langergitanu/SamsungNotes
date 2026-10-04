package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bR\u0018\u0000 Î\u00012\u00020\u0001:\bË\u0001Ì\u0001Í\u0001Î\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tB9\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0002\u0010\u0010J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\rH\u0016J\u001e\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u0016\u0010B\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?J\u001e\u0010D\u001a\u00020:2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J.\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u0016\u0010J\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J&\u0010K\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007J\u001e\u0010N\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001cJ\u0016\u0010P\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u0016\u0010Q\u001a\u00020:2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\rJ\u000e\u0010S\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010U\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bJ\u001e\u0010Y\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0005J\u0016\u0010[\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J&\u0010U\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J2\u0010\\\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u00010]j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u0001`_J\u0016\u0010`\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\rJ\u0016\u0010b\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\rJ\u000e\u0010c\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007J\u0016\u0010d\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\rJ\u0016\u0010f\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\rJ\u000e\u0010g\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0007J\u0016\u0010h\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rJ\u0016\u0010i\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rJ\u0016\u0010j\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rJ\u000e\u0010k\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007J\u0016\u0010l\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0007J\u0016\u0010n\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rJ\u0016\u0010o\u001a\u00020:2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rJ\u0016\u0010p\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rJ\u0016\u0010q\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rJ:\u0010r\u001a\u00020:22\u0010s\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u00010]j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u0001`_J\u001c\u0010t\u001a\b\u0018\u00010uR\u00020\u00002\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u0016\u0010v\u001a\u00020:2\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010w\u001a\u00020:2\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010x\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010y\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0007J\u0016\u0010z\u001a\u00020:2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u0007J*\u0010|\u001a\u0016\u0012\u0004\u0012\u00020}\u0018\u00010]j\n\u0012\u0004\u0012\u00020}\u0018\u0001`_2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u001a\u0010~\u001a\u0016\u0012\u0004\u0012\u00020}\u0018\u00010]j\n\u0012\u0004\u0012\u00020}\u0018\u0001`_J\u001a\u0010\u007f\u001a\u0016\u0012\u0004\u0012\u00020M\u0018\u00010]j\n\u0012\u0004\u0012\u00020M\u0018\u0001`_J\u001b\u0010\u0080\u0001\u001a\u0016\u0012\u0004\u0012\u00020M\u0018\u00010]j\n\u0012\u0004\u0012\u00020M\u0018\u0001`_J\u0012\u0010\u0081\u0001\u001a\u00020:2\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J+\u0010\u0083\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 JK\u0010\u0083\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0082 J\u0013\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J+\u0010\u0087\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J#\u0010\u0088\u0001\u001a\u00020?2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J+\u0010\u0089\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J;\u0010\u008a\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0082 J#\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J3\u0010\u008c\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007H\u0082 J+\u0010\u008d\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001cH\u0082 J#\u0010\u008e\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J#\u0010\u008f\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\rH\u0082 J\u001b\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0091\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0092\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J#\u0010\u0093\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0082 J+\u0010\u0094\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0005H\u0082 J#\u0010\u0095\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J7\u0010\u0096\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0097\u0001\u001a\u00020\u00072\u0007\u0010\u0098\u0001\u001a\u00020\u00072\u0007\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020\u0007H\u0082 J;\u0010\u009b\u0001\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^0]j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^`_2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J#\u0010\u009c\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rH\u0082 J#\u0010\u009d\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rH\u0082 J\u001b\u0010\u009e\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J#\u0010\u009f\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rH\u0082 J#\u0010 \u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rH\u0082 J\u001b\u0010¡\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J\u001b\u0010¢\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010>\u001a\u00020?H\u0082 J#\u0010£\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rH\u0082 J#\u0010¤\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rH\u0082 J#\u0010¥\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rH\u0082 J\u001b\u0010¦\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J\u0013\u0010§\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¨\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J#\u0010©\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\rH\u0082 J\u001b\u0010ª\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0082 J#\u0010«\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rH\u0082 J#\u0010¬\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\rH\u0082 J#\u0010\u00ad\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rH\u0082 J#\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\rH\u0082 JG\u0010¯\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u000722\u0010s\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u00010]j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070^\u0018\u0001`_H\u0082 J)\u0010°\u0001\u001a\b\u0018\u00010uR\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J#\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007H\u0082 J\u001c\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010³\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010´\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J#\u0010µ\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0082 J\u001b\u0010¶\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J#\u0010·\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\rH\u0082 J\u001b\u0010¨\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J\u001b\u0010¸\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rH\u0082 J\u001b\u0010¹\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0082 J#\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\u0082 J\u0013\u0010»\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¼\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J7\u0010½\u0001\u001a\u0016\u0012\u0004\u0012\u00020}\u0018\u00010]j\n\u0012\u0004\u0012\u00020}\u0018\u0001`_2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0082 J'\u0010¾\u0001\u001a\u0016\u0012\u0004\u0012\u00020}\u0018\u00010]j\n\u0012\u0004\u0012\u00020}\u0018\u0001`_2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J#\u0010¿\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010\n\u001a\u00020\u0007H\u0082 J\u001b\u0010À\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0082 J\u0013\u0010Á\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u001b\u0010Â\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0082 J\u0013\u0010Ã\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u001b\u0010Ä\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0082 J\u0013\u0010Å\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u001b\u0010Æ\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0082 J\u0013\u0010Ç\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J'\u0010È\u0001\u001a\u0016\u0012\u0004\u0012\u00020M\u0018\u00010]j\n\u0012\u0004\u0012\u00020M\u0018\u0001`_2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J'\u0010É\u0001\u001a\u0016\u0012\u0004\u0012\u00020M\u0018\u00010]j\n\u0012\u0004\u0012\u00020M\u0018\u0001`_2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010Ê\u0001\u001a\u00020\r2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0082 R\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010)R\u0011\u0010-\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b.\u0010\u0018R$\u0010/\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u00102R$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u00102R$\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010)¨\u0006Ï\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "<init>", "()V", "rect", "Landroid/graphics/RectF;", "rowCnt", "", "columnCnt", "(Landroid/graphics/RectF;II)V", "position", "Landroid/graphics/PointF;", "initRowHeight", "", "initColumnWidth", "maxWidth", "(Landroid/graphics/PointF;IIFFF)V", "rowsCount", "getRowsCount", "()I", "columnsCount", "getColumnsCount", "minRowHeight", "getMinRowHeight", "()F", "minColumnWidth", "getMinColumnWidth", "enable", "", "headingColumnEnabled", "getHeadingColumnEnabled", "()Z", "setHeadingColumnEnabled", "(Z)V", "headingRowEnabled", "getHeadingRowEnabled", "setHeadingRowEnabled", "color", "headingBackgroundColor", "getHeadingBackgroundColor", "setHeadingBackgroundColor", "(I)V", "defaultCellBackgroundColor", "getDefaultCellBackgroundColor", "setDefaultCellBackgroundColor", "scrollX", "getScrollX", "maxHeight", "getMaxHeight", "setMaxHeight", "(F)V", "getMaxWidth", "setMaxWidth", "tableAutoFit", "autoFitOption", "getAutoFitOption", "setAutoFitOption", "setMaxSize", "", "width", "height", "setContentText", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "rowIndex", "columnIndex", "getContentObject", "hasContentObject", "setCellBackgroundColor", "setCellsBackgroundColor", "startRowIndex", "startColumnIndex", "endRowIndex", "endColumnIndex", "getCellBackgroundColor", "setCellBorderStyle", "style", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "setEditable", "editable", "isEditable", "appendRowOrColumn", "size", "deleteColumn", "deleteRow", "mergeCells", "splitCells", "startPoint", "endPoint", "setMargin", "marginRect", "getMargin", "getSelectedCellPositions", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "setRowHeight", "newHeight", "setRowHeightWithTableAdjustment", "getRowHeight", "setColumnWidth", "newWidth", "setColumnWidthWithTableAdjustment", "getColumnWidth", "insertRow", "insertColumn", "setMaxRowHeight", "getMaxRowHeight", "setMinRowHeight", "minHeight", "insertRowAbove", "insertRowBelow", "insertColumnAfter", "insertColumnBefore", "selectCells", "cellList", "getCell", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$TableCell;", "setBorderStyle", "setDefaultCellBorderStyle", "setMaxColumnWidth", "getMaxColumnWidth", "setMinColumnWidth", "minWidth", "getCellBorderPath", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderPath;", "getBorderPath", "getBorderStyles", "getDefaultCellBorderStyles", "throwUncheckedException", "errno", "ObjectTable_init", "handle", "ObjectTable_getRowsCount", "ObjectTable_getColumnsCount", "ObjectTable_setContentText", "ObjectTable_getContentObject", "ObjectTable_setCellBackgroundColor", "ObjectTable_setCellsBackgroundColor", "ObjectTable_getCellBackgroundColor", "ObjectTable_setCellBorderStyle", "ObjectTable_setEditable", "ObjectTable_isEditable", "ObjectTable_appendRowOrColumn", "ObjectTable_deleteColumn", "ObjectTable_deleteRow", "ObjectTable_mergeCells", "ObjectTable_splitCells", "ObjectTable_setMargin", "ObjectTable_getMargin", "ObjectTable_mergeCellIndexs", "startRow", "startColumn", "endRow", "endColumn", "ObjectTable_getSelectedCellPositions", "ObjectTable_setRowHeight", "ObjectTable_setRowHeightWithTableAdjustment", "ObjectTable_getRowHeight", "ObjectTable_setColumnWidth", "ObjectTable_setColumnWidthWithTableAdjustment", "ObjectTable_getColumnWidth", "ObjectTable_hasContentObject", "ObjectTable_insertRow", "ObjectTable_insertColumn", "ObjectTable_setMaxRowHeight", "ObjectTable_getMaxRowHeight", "ObjectTable_getMinRowHeight", "ObjectTable_getMinColumnWidth", "ObjectTable_setMinRowHeight", "ObjectTable_getMinRowHeightByIndex", "ObjectTable_insertRowAbove", "ObjectTable_insertRowBelow", "ObjectTable_insertColumnAfter", "ObjectTable_insertColumnBefore", "ObjectTable_selectCells", "ObjectTable_getCell", "ObjectTable_setBorderStyle", "ObjectTable_setAutoFitOption", "option", "ObjectTable_getAutoFitOption", "ObjectTable_setMaxColumnWidth", "ObjectTable_getMaxColumnWidth", "ObjectTable_setMinColumnWidth", "ObjectTable_setMaxHeight", "ObjectTable_setMaxWidth", "ObjectTable_setMaxSize", "ObjectTable_getMaxHeight", "ObjectTable_getMaxWidth", "ObjectTable_getCellBorderPath", "ObjectTable_getBorderPath", "ObjectTable_setDefaultCellBorderStyle", "ObjectTable_setHeadingColumnEnabled", "ObjectTable_isHeadingColumnEnabled", "ObjectTable_setHeadingRowEnabled", "ObjectTable_isHeadingRowEnabled", "ObjectTable_setHeadingBackgroundColor", "ObjectTable_getHeadingBackgroundColor", "ObjectTable_setDefaultCellBackgroundColor", "ObjectTable_getDefaultCellBackgroundColor", "ObjectTable_getBorderStyles", "ObjectTable_getDefaultCellBorderStyles", "ObjectTable_getScrollX", "BorderStyle", "BorderPath", "TableCell", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectTable extends SpenObjectShape {
    public static final int APPEND_COLUMN_LEFT = 0;
    public static final int APPEND_COLUMN_RIGHT = 1;
    public static final int APPEND_ROW_BOTTOM = 3;
    public static final int APPEND_ROW_TOP = 2;
    public static final int AUTO_FIT_BOTH = 3;
    public static final int AUTO_FIT_HORIZONTAL = 1;
    public static final int AUTO_FIT_NONE = 0;
    public static final int AUTO_FIT_VERTICAL = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int BORDER_LEFT = 1;
    private static int BORDER_TOP = 2;
    private static int BORDER_RIGHT = 4;
    private static int BORDER_BOTTOM = 8;
    private static int BORDER_ALL = 15;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderPath;", "", "<init>", "()V", "style", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "getStyle", "()Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "setStyle", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;)V", "start", "Landroid/graphics/PointF;", "getStart", "()Landroid/graphics/PointF;", "setStart", "(Landroid/graphics/PointF;)V", "end", "getEnd", "setEnd", "position", "", "getPosition", "()I", "setPosition", "(I)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BorderPath {
        private int position;

        @NotNull
        private BorderStyle style = new BorderStyle();

        @NotNull
        private PointF start = new PointF();

        @NotNull
        private PointF end = new PointF();

        @NotNull
        public final PointF getEnd() {
            return this.end;
        }

        public final int getPosition() {
            return this.position;
        }

        @NotNull
        public final PointF getStart() {
            return this.start;
        }

        @NotNull
        public final BorderStyle getStyle() {
            return this.style;
        }

        public final void setEnd(@NotNull PointF pointF) {
            Intrinsics.checkNotNullParameter(pointF, "<set-?>");
            this.end = pointF;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        public final void setStart(@NotNull PointF pointF) {
            Intrinsics.checkNotNullParameter(pointF, "<set-?>");
            this.start = pointF;
        }

        public final void setStyle(@NotNull BorderStyle borderStyle) {
            Intrinsics.checkNotNullParameter(borderStyle, "<set-?>");
            this.style = borderStyle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTable$BorderStyle;", "", "<init>", "()V", "color", "", "getColor", "()I", "setColor", "(I)V", "width", "", "getWidth", "()F", "setWidth", "(F)V", "startRadius", "getStartRadius", "setStartRadius", "endRadius", "getEndRadius", "setEndRadius", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class BorderStyle {
        private int color;
        private float endRadius;
        private float startRadius;
        private float width;

        public final int getColor() {
            return this.color;
        }

        public final float getEndRadius() {
            return this.endRadius;
        }

        public final float getStartRadius() {
            return this.startRadius;
        }

        public final float getWidth() {
            return this.width;
        }

        public final void setColor(int i) {
            this.color = i;
        }

        public final void setEndRadius(float f) {
            this.endRadius = f;
        }

        public final void setStartRadius(float f) {
            this.startRadius = f;
        }

        public final void setWidth(float f) {
            this.width = f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTable$Companion;", "", "<init>", "()V", "BORDER_LEFT", "", "getBORDER_LEFT", "()I", "setBORDER_LEFT", "(I)V", "BORDER_TOP", "getBORDER_TOP", "setBORDER_TOP", "BORDER_RIGHT", "getBORDER_RIGHT", "setBORDER_RIGHT", "BORDER_BOTTOM", "getBORDER_BOTTOM", "setBORDER_BOTTOM", "BORDER_ALL", "getBORDER_ALL", "setBORDER_ALL", "APPEND_COLUMN_LEFT", "APPEND_COLUMN_RIGHT", "APPEND_ROW_TOP", "APPEND_ROW_BOTTOM", "AUTO_FIT_NONE", "AUTO_FIT_HORIZONTAL", "AUTO_FIT_VERTICAL", "AUTO_FIT_BOTH", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getBORDER_ALL() {
            return SpenObjectTable.BORDER_ALL;
        }

        public final int getBORDER_BOTTOM() {
            return SpenObjectTable.BORDER_BOTTOM;
        }

        public final int getBORDER_LEFT() {
            return SpenObjectTable.BORDER_LEFT;
        }

        public final int getBORDER_RIGHT() {
            return SpenObjectTable.BORDER_RIGHT;
        }

        public final int getBORDER_TOP() {
            return SpenObjectTable.BORDER_TOP;
        }

        public final void setBORDER_ALL(int i) {
            SpenObjectTable.BORDER_ALL = i;
        }

        public final void setBORDER_BOTTOM(int i) {
            SpenObjectTable.BORDER_BOTTOM = i;
        }

        public final void setBORDER_LEFT(int i) {
            SpenObjectTable.BORDER_LEFT = i;
        }

        public final void setBORDER_RIGHT(int i) {
            SpenObjectTable.BORDER_RIGHT = i;
        }

        public final void setBORDER_TOP(int i) {
            SpenObjectTable.BORDER_TOP = i;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u001aH\u0004J\u0011\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0011\u0010$\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0082 J\u0011\u0010&\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectTable$TableCell;", "", "<init>", "(Lcom/samsung/android/sdk/pen/document/SpenObjectTable;)V", "nativeHandle", "", "rowIndex", "getRowIndex", "()I", "columnIndex", "getColumnIndex", "rowSpan", "getRowSpan", "columnSpan", "getColumnSpan", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "backgroundColor", "getBackgroundColor", "editable", "", "getEditable", "()Z", "setTextAutoFitOption", "", "option", "finalize", "TableCell_getRowIndex", "handle", "TableCell_getColumnIndex", "TableCell_getRowSpan", "TableCell_getColumnSpan", "TableCell_getRect", "TableCell_getBackgroundColor", "TableCell_getEditable", "TableCell_setTextAutoFitOption", "TableCell_finalize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class TableCell {
        private int nativeHandle = -1;

        private TableCell() {
        }

        private final native void TableCell_finalize(int handle);

        private final native int TableCell_getBackgroundColor(int handle);

        private final native int TableCell_getColumnIndex(int handle);

        private final native int TableCell_getColumnSpan(int handle);

        private final native boolean TableCell_getEditable(int handle);

        private final native RectF TableCell_getRect(int handle);

        private final native int TableCell_getRowIndex(int handle);

        private final native int TableCell_getRowSpan(int handle);

        private final native boolean TableCell_setTextAutoFitOption(int handle, int option);

        public final void finalize() {
            TableCell_finalize(this.nativeHandle);
            this.nativeHandle = -1;
        }

        public final int getBackgroundColor() {
            return TableCell_getBackgroundColor(this.nativeHandle);
        }

        public final int getColumnIndex() {
            return TableCell_getColumnIndex(this.nativeHandle);
        }

        public final int getColumnSpan() {
            return TableCell_getColumnSpan(this.nativeHandle);
        }

        public final boolean getEditable() {
            return TableCell_getEditable(this.nativeHandle);
        }

        @NotNull
        public final RectF getRect() {
            return TableCell_getRect(this.nativeHandle);
        }

        public final int getRowIndex() {
            return TableCell_getRowIndex(this.nativeHandle);
        }

        public final int getRowSpan() {
            return TableCell_getRowSpan(this.nativeHandle);
        }

        public final void setTextAutoFitOption(int option) {
            if (TableCell_setTextAutoFitOption(this.nativeHandle, option)) {
                return;
            }
            SpenObjectTable.this.throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectTable() {
        super(22, 4);
    }

    private final native boolean ObjectTable_appendRowOrColumn(int handle, int position, float size);

    private final native boolean ObjectTable_deleteColumn(int handle, int columnIndex);

    private final native boolean ObjectTable_deleteRow(int handle, int rowIndex);

    private final native int ObjectTable_getAutoFitOption(int handle);

    private final native ArrayList<BorderPath> ObjectTable_getBorderPath(int handle);

    private final native ArrayList<BorderStyle> ObjectTable_getBorderStyles(int handle);

    private final native TableCell ObjectTable_getCell(int handle, int rowIndex, int columnIndex);

    private final native int ObjectTable_getCellBackgroundColor(int handle, int rowIndex, int columnIndex);

    private final native ArrayList<BorderPath> ObjectTable_getCellBorderPath(int handle, int rowIndex, int columnIndex);

    private final native float ObjectTable_getColumnWidth(int handle, int columnIndex);

    private final native int ObjectTable_getColumnsCount(int handle);

    private final native SpenObjectTextBox ObjectTable_getContentObject(int handle, int rowIndex, int columnIndex);

    private final native int ObjectTable_getDefaultCellBackgroundColor(int handle);

    private final native ArrayList<BorderStyle> ObjectTable_getDefaultCellBorderStyles(int handle);

    private final native int ObjectTable_getHeadingBackgroundColor(int handle);

    private final native RectF ObjectTable_getMargin(int handle, int rowIndex, int columnIndex);

    private final native float ObjectTable_getMaxColumnWidth(int handle, int columnIndex);

    private final native float ObjectTable_getMaxHeight(int handle);

    private final native float ObjectTable_getMaxRowHeight(int handle, int rowIndex);

    private final native float ObjectTable_getMaxWidth(int handle);

    private final native float ObjectTable_getMinColumnWidth(int handle);

    private final native float ObjectTable_getMinColumnWidth(int handle, int columnIndex);

    private final native float ObjectTable_getMinRowHeight(int handle);

    private final native float ObjectTable_getMinRowHeightByIndex(int handle, int rowIndex);

    private final native float ObjectTable_getRowHeight(int handle, int rowIndex);

    private final native int ObjectTable_getRowsCount(int handle);

    private final native float ObjectTable_getScrollX(int handle);

    private final native ArrayList<Pair<Integer, Integer>> ObjectTable_getSelectedCellPositions(int handle);

    private final native boolean ObjectTable_hasContentObject(int handle, SpenObjectTextBox textBox);

    private final native boolean ObjectTable_init(int handle, PointF position, int rowCnt, int columnCnt, float initRowHeight, float initColumnWidth, float maxHeight, float maxWidth);

    private final native boolean ObjectTable_init(int handle, RectF rect, int rowCnt, int columnCnt);

    private final native boolean ObjectTable_insertColumn(int handle, int columnIndex, float width);

    private final native boolean ObjectTable_insertColumnAfter(int handle, int columnIndex, float width);

    private final native boolean ObjectTable_insertColumnBefore(int handle, int columnIndex, float width);

    private final native boolean ObjectTable_insertRow(int handle, int rowIndex, float height);

    private final native boolean ObjectTable_insertRowAbove(int handle, int rowIndex, float height);

    private final native boolean ObjectTable_insertRowBelow(int handle, int rowIndex, float height);

    private final native boolean ObjectTable_isEditable(int handle, int rowIndex, int columnIndex);

    private final native boolean ObjectTable_isHeadingColumnEnabled(int handle);

    private final native boolean ObjectTable_isHeadingRowEnabled(int handle);

    private final native boolean ObjectTable_mergeCellIndexs(int handle, int startRow, int startColumn, int endRow, int endColumn);

    private final native boolean ObjectTable_mergeCells(int handle, RectF rect);

    private final native boolean ObjectTable_selectCells(int handle, ArrayList<Pair<Integer, Integer>> cellList);

    private final native boolean ObjectTable_setAutoFitOption(int handle, int option);

    private final native boolean ObjectTable_setBorderStyle(int handle, BorderStyle style, int position);

    private final native boolean ObjectTable_setCellBackgroundColor(int handle, int color, int rowIndex, int columnIndex);

    private final native boolean ObjectTable_setCellBorderStyle(int handle, int rowIndex, int columnIndex, BorderStyle style, int position);

    private final native boolean ObjectTable_setCellsBackgroundColor(int handle, int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex, int color);

    private final native boolean ObjectTable_setColumnWidth(int handle, int columnIndex, float width);

    private final native boolean ObjectTable_setColumnWidthWithTableAdjustment(int handle, int columnIndex, float width);

    private final native boolean ObjectTable_setContentText(int handle, SpenObjectTextBox textBox, int rowIndex, int columnIndex);

    private final native boolean ObjectTable_setDefaultCellBackgroundColor(int handle, int color);

    private final native boolean ObjectTable_setDefaultCellBorderStyle(int handle, BorderStyle style, int position);

    private final native boolean ObjectTable_setEditable(int handle, int rowIndex, int columnIndex, boolean editable);

    private final native boolean ObjectTable_setHeadingBackgroundColor(int handle, int color);

    private final native boolean ObjectTable_setHeadingColumnEnabled(int handle, boolean enable);

    private final native boolean ObjectTable_setHeadingRowEnabled(int handle, boolean enable);

    private final native boolean ObjectTable_setMargin(int handle, int rowIndex, int columnIndex, RectF marginRect);

    private final native boolean ObjectTable_setMaxColumnWidth(int handle, int columnIndex, float maxWidth);

    private final native boolean ObjectTable_setMaxHeight(int handle, float maxHeight);

    private final native boolean ObjectTable_setMaxRowHeight(int handle, int rowIndex, float maxHeight);

    private final native boolean ObjectTable_setMaxSize(int handle, float maxWidth, float maxHeight);

    private final native boolean ObjectTable_setMaxWidth(int handle, float maxWidth);

    private final native boolean ObjectTable_setMinColumnWidth(int handle, int columnIndex, float minWidth);

    private final native boolean ObjectTable_setMinRowHeight(int handle, int rowIndex, float minHeight);

    private final native boolean ObjectTable_setRowHeight(int handle, int rowIndex, float height);

    private final native boolean ObjectTable_setRowHeightWithTableAdjustment(int handle, int rowIndex, float height);

    private final native boolean ObjectTable_splitCells(int handle, PointF startPoint, PointF endPoint);

    /* JADX INFO: Access modifiers changed from: private */
    public final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectTable(" + this + ") is already closed");
    }

    public final void appendRowOrColumn(int position, float size) {
        if (ObjectTable_appendRowOrColumn(getMHandle(), position, size)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean deleteColumn(int columnIndex) {
        return ObjectTable_deleteColumn(getMHandle(), columnIndex);
    }

    public final boolean deleteRow(int rowIndex) {
        return ObjectTable_deleteRow(getMHandle(), rowIndex);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShape
    public int getAutoFitOption() {
        return ObjectTable_getAutoFitOption(getMHandle());
    }

    @Nullable
    public final ArrayList<BorderPath> getBorderPath() {
        return ObjectTable_getBorderPath(getMHandle());
    }

    @Nullable
    public final ArrayList<BorderStyle> getBorderStyles() {
        return ObjectTable_getBorderStyles(getMHandle());
    }

    @Nullable
    public final TableCell getCell(int rowIndex, int columnIndex) {
        return ObjectTable_getCell(getMHandle(), rowIndex, columnIndex);
    }

    public final int getCellBackgroundColor(int rowIndex, int columnIndex) {
        return ObjectTable_getCellBackgroundColor(getMHandle(), rowIndex, columnIndex);
    }

    @Nullable
    public final ArrayList<BorderPath> getCellBorderPath(int rowIndex, int columnIndex) {
        return ObjectTable_getCellBorderPath(getMHandle(), rowIndex, columnIndex);
    }

    public final float getColumnWidth(int columnIndex) {
        return ObjectTable_getColumnWidth(getMHandle(), columnIndex);
    }

    public final int getColumnsCount() {
        return ObjectTable_getColumnsCount(getMHandle());
    }

    @NotNull
    public final SpenObjectTextBox getContentObject(int rowIndex, int columnIndex) {
        return ObjectTable_getContentObject(getMHandle(), rowIndex, columnIndex);
    }

    public final int getDefaultCellBackgroundColor() {
        return ObjectTable_getDefaultCellBackgroundColor(getMHandle());
    }

    @Nullable
    public final ArrayList<BorderStyle> getDefaultCellBorderStyles() {
        return ObjectTable_getDefaultCellBorderStyles(getMHandle());
    }

    public final int getHeadingBackgroundColor() {
        return ObjectTable_getHeadingBackgroundColor(getMHandle());
    }

    public final boolean getHeadingColumnEnabled() {
        return ObjectTable_isHeadingColumnEnabled(getMHandle());
    }

    public final boolean getHeadingRowEnabled() {
        return ObjectTable_isHeadingRowEnabled(getMHandle());
    }

    @NotNull
    public final RectF getMargin(int rowIndex, int columnIndex) {
        return ObjectTable_getMargin(getMHandle(), rowIndex, columnIndex);
    }

    public final float getMaxColumnWidth(int columnIndex) {
        return ObjectTable_getMaxColumnWidth(getMHandle(), columnIndex);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public float getMaxHeight() {
        return ObjectTable_getMaxHeight(getMHandle());
    }

    public final float getMaxRowHeight(int rowIndex) {
        return ObjectTable_getMaxRowHeight(getMHandle(), rowIndex);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public float getMaxWidth() {
        return ObjectTable_getMaxWidth(getMHandle());
    }

    public final float getMinColumnWidth() {
        return ObjectTable_getMinColumnWidth(getMHandle());
    }

    public final float getMinRowHeight() {
        return ObjectTable_getMinRowHeight(getMHandle());
    }

    public final float getRowHeight(int rowIndex) {
        return ObjectTable_getRowHeight(getMHandle(), rowIndex);
    }

    public final int getRowsCount() {
        return ObjectTable_getRowsCount(getMHandle());
    }

    public final float getScrollX() {
        return ObjectTable_getScrollX(getMHandle());
    }

    @Nullable
    public final ArrayList<Pair<Integer, Integer>> getSelectedCellPositions() {
        return ObjectTable_getSelectedCellPositions(getMHandle());
    }

    public final boolean hasContentObject(@NotNull SpenObjectTextBox textBox) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        return ObjectTable_hasContentObject(getMHandle(), textBox);
    }

    public final void insertColumn(int columnIndex, float width) {
        if (ObjectTable_insertColumn(getMHandle(), columnIndex, width)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertColumnAfter(int columnIndex, float width) {
        if (ObjectTable_insertColumnAfter(getMHandle(), columnIndex, width)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertColumnBefore(int columnIndex, float width) {
        if (ObjectTable_insertColumnBefore(getMHandle(), columnIndex, width)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertRow(int rowIndex, float height) {
        if (ObjectTable_insertRow(getMHandle(), rowIndex, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertRowAbove(int rowIndex, float height) {
        if (ObjectTable_insertRowAbove(getMHandle(), rowIndex, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void insertRowBelow(int rowIndex, float height) {
        if (ObjectTable_insertRowBelow(getMHandle(), rowIndex, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isEditable(int rowIndex, int columnIndex) {
        return ObjectTable_isEditable(getMHandle(), rowIndex, columnIndex);
    }

    public final boolean mergeCells(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return ObjectTable_mergeCells(getMHandle(), rect);
    }

    public final void selectCells(@Nullable ArrayList<Pair<Integer, Integer>> cellList) {
        if (ObjectTable_selectCells(getMHandle(), cellList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShape
    public void setAutoFitOption(int i) {
        if (ObjectTable_setAutoFitOption(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBorderStyle(@NotNull BorderStyle style, int position) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (ObjectTable_setBorderStyle(getMHandle(), style, position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCellBackgroundColor(int color, int rowIndex, int columnIndex) {
        if (ObjectTable_setCellBackgroundColor(getMHandle(), color, rowIndex, columnIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCellBorderStyle(int rowIndex, int columnIndex, @NotNull BorderStyle style, int position) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (ObjectTable_setCellBorderStyle(getMHandle(), rowIndex, columnIndex, style, position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCellsBackgroundColor(int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex, int color) {
        if (ObjectTable_setCellsBackgroundColor(getMHandle(), startRowIndex, startColumnIndex, endRowIndex, endColumnIndex, color)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setColumnWidth(int columnIndex, float newWidth) {
        if (ObjectTable_setColumnWidth(getMHandle(), columnIndex, newWidth)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setColumnWidthWithTableAdjustment(int columnIndex, float newWidth) {
        if (ObjectTable_setColumnWidthWithTableAdjustment(getMHandle(), columnIndex, newWidth)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setContentText(@NotNull SpenObjectTextBox textBox, int rowIndex, int columnIndex) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        if (ObjectTable_setContentText(getMHandle(), textBox, rowIndex, columnIndex)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDefaultCellBackgroundColor(int i) {
        if (ObjectTable_setDefaultCellBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDefaultCellBorderStyle(@NotNull BorderStyle style, int position) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (ObjectTable_setDefaultCellBorderStyle(getMHandle(), style, position)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setEditable(int rowIndex, int columnIndex, boolean editable) {
        if (ObjectTable_setEditable(getMHandle(), rowIndex, columnIndex, editable)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHeadingBackgroundColor(int i) {
        if (ObjectTable_setHeadingBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHeadingColumnEnabled(boolean z) {
        if (ObjectTable_setHeadingColumnEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setHeadingRowEnabled(boolean z) {
        if (ObjectTable_setHeadingRowEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMargin(int rowIndex, int columnIndex, @NotNull RectF marginRect) {
        Intrinsics.checkNotNullParameter(marginRect, "marginRect");
        if (ObjectTable_setMargin(getMHandle(), rowIndex, columnIndex, marginRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMaxColumnWidth(int columnIndex, float maxWidth) {
        if (ObjectTable_setMaxColumnWidth(getMHandle(), columnIndex, maxWidth)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setMaxHeight(float f) {
        if (ObjectTable_setMaxHeight(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMaxRowHeight(int rowIndex, float maxHeight) {
        if (ObjectTable_setMaxRowHeight(getMHandle(), rowIndex, maxHeight)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setMaxSize(float width, float height) {
        if (ObjectTable_setMaxSize(getMHandle(), width, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setMaxWidth(float f) {
        if (ObjectTable_setMaxWidth(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMinColumnWidth(int columnIndex, float minWidth) {
        if (ObjectTable_setMinColumnWidth(getMHandle(), columnIndex, minWidth)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMinRowHeight(int rowIndex, float minHeight) {
        if (ObjectTable_setMinRowHeight(getMHandle(), rowIndex, minHeight)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRowHeight(int rowIndex, float newHeight) {
        if (ObjectTable_setRowHeight(getMHandle(), rowIndex, newHeight)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRowHeightWithTableAdjustment(int rowIndex, float newHeight) {
        if (ObjectTable_setRowHeightWithTableAdjustment(getMHandle(), rowIndex, newHeight)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean splitCells(@NotNull PointF startPoint, @NotNull PointF endPoint) {
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        return ObjectTable_splitCells(getMHandle(), startPoint, endPoint);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenObjectTable(@NotNull RectF rect, int i, int i2) {
        super(22, 4);
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ObjectTable_init(getMHandle(), rect, i, i2)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final float getMinColumnWidth(int columnIndex) {
        return ObjectTable_getMinColumnWidth(getMHandle(), columnIndex);
    }

    public final float getMinRowHeight(int rowIndex) {
        return ObjectTable_getMinRowHeightByIndex(getMHandle(), rowIndex);
    }

    public final boolean mergeCells(int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex) {
        return ObjectTable_mergeCellIndexs(getMHandle(), startRowIndex, startColumnIndex, endRowIndex, endColumnIndex);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenObjectTable(@NotNull PointF position, int i, int i2, float f, float f4, float f5) {
        super(22, 4);
        Intrinsics.checkNotNullParameter(position, "position");
        if (ObjectTable_init(getMHandle(), position, i, i2, f, f4, 0.0f, f5)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
