package com.samsung.android.sdk.pen.document;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.senl.p148nt.app.account.SamsungAccountLoginForLockActivity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0003\b\u0084\u0001\b\u0016\u0018\u0000 ª\u00022\u00020\u0001:\u0002ª\u0002B\u0011\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0012J\u0012\u0010U\u001a\u00020\u001d2\b\u0010Q\u001a\u0004\u0018\u00010BH\u0017J\u0015\u0010\u0083\u0001\u001a\u00020\u00122\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0003H\u0016J\u001c\u0010\u0086\u0001\u001a\u00020\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0016J\u0019\u0010\u0088\u0001\u001a\u00020\u001d2\u0007\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020#J\u001b\u0010\u008b\u0001\u001a\u00020\u001d2\u0007\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020#H\u0016J\u000f\u0010\u008c\u0001\u001a\u00020\u00122\u0006\u0010x\u001a\u00020yJ\u000f\u0010\u008d\u0001\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0003J\u001c\u0010\u008e\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\b\u0010\u0006\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0090\u0001\u001a\u00020B2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u001a\u0010\u0091\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010\u0006\u001a\u00020\u0003J\u0012\u0010\u0092\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0093\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0094\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0095\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0096\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u001c\u0010\u0097\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\b\u0010\u0006\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0098\u0001\u001a\u00020B2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u0099\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u009a\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u001a\u0010\u009b\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010\u0006\u001a\u00020\u0003J\u0012\u0010\u009c\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u009d\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010\u009e\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ)\u0010\u009f\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u000f\u0010\u0006\u001a\u000b\u0012\u0004\u0012\u00020B\u0018\u00010 \u0001¢\u0006\u0003\u0010¡\u0001J\u001f\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020B0 \u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B¢\u0006\u0003\u0010£\u0001J\u0012\u0010¤\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010¥\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u001d\u0010¦\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\t\u0010\u0006\u001a\u0005\u0018\u00010§\u0001J\u0013\u0010¨\u0001\u001a\u00030§\u00012\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010©\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\u0012\u0010ª\u0001\u001a\u00020\u001d2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BJ\t\u0010«\u0001\u001a\u00020\u001dH\u0016J\t\u0010¬\u0001\u001a\u00020\u001dH\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020\u001d2\u0007\u0010®\u0001\u001a\u00020\u0000H\u0016J\u0007\u0010¯\u0001\u001a\u00020\u0012J\u0007\u0010°\u0001\u001a\u00020\u0003J\t\u0010±\u0001\u001a\u00020\u001dH\u0014J\u0012\u0010²\u0001\u001a\u00020\u001d2\u0007\u0010³\u0001\u001a\u00020\u0003H\u0002J\u0013\u0010´\u0001\u001a\u00020\u001d2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010¶\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J&\u0010·\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u0087\u0001\u001a\u00020\u0012H\u0082 J\u0013\u0010¸\u0001\u001a\u00020\u000e2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¹\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0082 J\u0013\u0010º\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010»\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0012H\u0082 J\u0013\u0010¼\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010½\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0082 J\u0013\u0010¾\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¿\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010,\u001a\u00020#H\u0082 J\u0013\u0010À\u0001\u001a\u00020#2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010Á\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0082 J\u0013\u0010Â\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010Ã\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0082 J\u0013\u0010Ä\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010Å\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0082 J\u0013\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010Ç\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0082 J\u0013\u0010È\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010É\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0082 J\u0013\u0010Ê\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010Ë\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010Ì\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Í\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010Î\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010BH\u0082 J\u0013\u0010Ï\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010Ð\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\b\u0010H\u001a\u0004\u0018\u00010BH\u0082 J\u0013\u0010Ñ\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010Ò\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010Ó\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0082 J\u0013\u0010Ô\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J(\u0010Õ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\b\u0010\u0006\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010Ö\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J&\u0010×\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010\u0006\u001a\u00020\u0003H\u0082 J\u001e\u0010Ø\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J>\u0010Ù\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u000f\u0010\u0006\u001a\u000b\u0012\u0004\u0012\u00020B\u0018\u00010 \u00012\u0007\u0010Ú\u0001\u001a\u00020\u0003H\u0082 ¢\u0006\u0003\u0010Û\u0001J+\u0010Ü\u0001\u001a\t\u0012\u0004\u0012\u00020B0 \u00012\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 ¢\u0006\u0003\u0010Ý\u0001J2\u0010Þ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\t\u0010\u0006\u001a\u0005\u0018\u00010§\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0003H\u0082 J\u001f\u0010ß\u0001\u001a\u00030§\u00012\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010à\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010á\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010â\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ã\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ä\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010å\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010æ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ç\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J%\u0010è\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010é\u0001\u001a\u00020\u00032\u0007\u0010ê\u0001\u001a\u00020\u0000H\u0082 J(\u0010ë\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\b\u0010\u0006\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ì\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J&\u0010í\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u0006\u0010\u0006\u001a\u00020\u0003H\u0082 J\u001e\u0010î\u0001\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J>\u0010ï\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010B2\u000f\u0010\u0006\u001a\u000b\u0012\u0004\u0012\u00020B\u0018\u00010 \u00012\u0007\u0010Ú\u0001\u001a\u00020\u0003H\u0082 ¢\u0006\u0003\u0010Û\u0001J-\u0010ð\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010 \u00012\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u008f\u0001\u001a\u00020BH\u0082 ¢\u0006\u0003\u0010Ý\u0001J.\u0010ñ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u008f\u0001\u001a\u00020B2\u0007\u0010\u0006\u001a\u00030§\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0003H\u0082 J!\u0010ò\u0001\u001a\u0005\u0018\u00010§\u00012\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ó\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ô\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010õ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ö\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010÷\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ø\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ù\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u001e\u0010ú\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u0013\u0010û\u0001\u001a\u00020\u001d2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010ü\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001e\u0010ý\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\t\u0010þ\u0001\u001a\u0004\u0018\u00010BH\u0082 J\u0013\u0010ÿ\u0001\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0080\u0002\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0081\u0002\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0015\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u000e2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J%\u0010\u0083\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u0084\u0002\u001a\u00020#2\u0007\u0010\u0085\u0002\u001a\u00020#H\u0082 J%\u0010\u0086\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u0087\u0002\u001a\u00020#2\u0007\u0010\u0088\u0002\u001a\u00020#H\u0082 J%\u0010\u0089\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u008a\u0002\u001a\u00020\u00032\u0007\u0010\u008b\u0002\u001a\u00020\u0000H\u0082 J%\u0010\u008c\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020#H\u0082 J\u0013\u0010\u008d\u0002\u001a\u00020#2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u008e\u0002\u001a\u00020#2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J%\u0010\u008f\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u0089\u0001\u001a\u00020#2\u0007\u0010\u008a\u0001\u001a\u00020#H\u0082 J\u0013\u0010\u0090\u0002\u001a\u00020#2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0091\u0002\u001a\u00020#2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0092\u0002\u001a\u00020[2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0093\u0002\u001a\u00020[2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010\u0094\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010\u0095\u0002\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0096\u0002\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0097\u0002\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0098\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u0099\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009a\u0002\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009b\u0002\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010\u009c\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u0012H\u0082 J\u0013\u0010\u009d\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009e\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010\u009f\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010 \u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010¡\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010x\u001a\u00020yH\u0082 J\u0013\u0010¢\u0002\u001a\u00020y2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001d\u0010£\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\b\u0010q\u001a\u0004\u0018\u00010rH\u0082 J\u0013\u0010¤\u0002\u001a\u00020r2\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u0013\u0010¥\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001c\u0010¦\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0007\u0010§\u0002\u001a\u00020\u0012H\u0082 J\u0013\u0010¨\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u0003H\u0082 J\u001b\u0010©\u0002\u001a\u00020\u00122\u0007\u0010µ\u0001\u001a\u00020\u00032\u0006\u0010\u007f\u001a\u00020\u0012H\u0082 R\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u0005R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010%R$\u0010-\u001a\u00020#2\u0006\u0010,\u001a\u00020#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010%\"\u0004\b/\u00100R$\u00102\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R$\u00105\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R$\u00108\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R$\u0010;\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R$\u0010>\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0017R(\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010I\u001a\u0004\u0018\u00010B2\b\u0010H\u001a\u0004\u0018\u00010B8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR\u0011\u0010L\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bM\u0010\u0015R\u0011\u0010N\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bO\u0010\tR\u0014\u0010P\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0015R(\u0010R\u001a\u0004\u0018\u00010B2\b\u0010Q\u001a\u0004\u0018\u00010B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010E\"\u0004\bT\u0010GR\u0011\u0010V\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bW\u0010\tR\u0016\u0010X\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0010R\u0011\u0010Z\u001a\u00020[8F¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0011\u0010^\u001a\u00020[8F¢\u0006\u0006\u001a\u0004\b_\u0010]R\u0011\u0010`\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\ba\u0010ER$\u0010b\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\t\"\u0004\bd\u0010\u0005R\u0011\u0010e\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\be\u0010\u0015R\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\tR\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\tR$\u0010k\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bl\u0010\u0015\"\u0004\bm\u0010\u0017R\u0011\u0010n\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bn\u0010\u0015R\u0011\u0010o\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bo\u0010\u0015R\u0011\u0010p\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\bp\u0010\u0015R(\u0010s\u001a\u0004\u0018\u00010r2\b\u0010q\u001a\u0004\u0018\u00010r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0011\u0010x\u001a\u00020y8F¢\u0006\u0006\u001a\u0004\bz\u0010{R$\u0010|\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b}\u0010\u0015\"\u0004\b~\u0010\u0017R'\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u0010\u007f\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010\u0015\"\u0005\b\u0082\u0001\u0010\u0017¨\u0006«\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "", "type", "", "<init>", "(I)V", "value", "mType", "getMType", "()I", "mHandle", "getMHandle", "getType", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "record", "", "replayable", "getReplayable", "()Z", "setReplayable", "(Z)V", "isVisible", "visible", "getVisible", "setVisible", "setVisibility", "", "option", "resizeOption", "getResizeOption", "setResizeOption", "minWidth", "", "getMinWidth", "()F", "minHeight", "getMinHeight", "maxWidth", "getMaxWidth", "maxHeight", "getMaxHeight", "degree", Key.ROTATION, "getRotation", "setRotation", "(F)V", "enable", "rotatable", "getRotatable", "setRotatable", "outOfViewEnabled", "getOutOfViewEnabled", "setOutOfViewEnabled", "selectable", "getSelectable", "setSelectable", "movable", "getMovable", "setMovable", "flipEnabled", "getFlipEnabled", "setFlipEnabled", "info", "", "sorInfo", "getSorInfo", "()Ljava/lang/String;", "setSorInfo", "(Ljava/lang/String;)V", "link", "sorPackageLink", "getSorPackageLink", "setSorPackageLink", "templateProperty", "getTemplateProperty", SamsungAccountLoginForLockActivity.SAMSUNG_ACCOUNT_USER_ID, "getUserId", "isChanged", "filePath", "attachedFile", "getAttachedFile", "setAttachedFile", "attachFile", "runtimeHandle", "getRuntimeHandle", "drawnRect", "getDrawnRect", "appendTime", "", "getAppendTime", "()J", "modifiedTime", "getModifiedTime", "id", "getId", "layoutType", "getLayoutType", "setLayoutType", "isBelongableToSpan", "pageIndex", "getPageIndex", "layerId", "getLayerId", "isLock", "lockState", "getLockState", "setLockState", "isEditingByCoedit", "isAllContentFileAvailable", "isPdfDummyObject", "bitmap", "Landroid/graphics/Bitmap;", "capturedBitmap", "getCapturedBitmap", "()Landroid/graphics/Bitmap;", "setCapturedBitmap", "(Landroid/graphics/Bitmap;)V", "pivot", "Landroid/graphics/PointF;", "getPivot", "()Landroid/graphics/PointF;", "removable", "getRemovable", "setRemovable", "isFocused", "focused", "getFocused", "setFocused", "equals", "other", "hashCode", "setRect", "regionOnly", "setMinSize", "width", "height", "setMaxSize", "setPivot", "setUserId", "setSorDataString", "key", "getSorDataString", "setSorDataInt", "getSorDataInt", "hasSorDataString", "hasSorDataInt", "removeSorDataString", "removeSorDataInt", "setExtraDataString", "getExtraDataString", "hasExtraDataString", "removeExtraDataString", "setExtraDataInt", "getExtraDataInt", "hasExtraDataInt", "removeExtraDataInt", "setExtraDataStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getExtraDataStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "hasExtraDataStringArray", "removeExtraDataStringArray", "setExtraDataByteArray", "", "getExtraDataByteArray", "hasExtraDataByteArray", "removeExtraDataByteArray", "clearChangedFlag", "detachFile", "copy", "source", "belongsToSpan", "getHandle", "finalize", "throwUncheckedException", "errno", "ObjectBase_finalize", "handle", "ObjectBase_getType", "ObjectBase_setRect", "ObjectBase_getRect", "ObjectBase_setReplayable", "ObjectBase_isReplayable", "ObjectBase_setVisibility", "ObjectBase_isVisible", "ObjectBase_setResizeOption", "ObjectBase_getResizeOption", "ObjectBase_setRotation", "ObjectBase_getRotation", "ObjectBase_enableRotation", "ObjectBase_isRotatable", "ObjectBase_enableClip", "ObjectBase_isClippable", "ObjectBase_enableSelection", "ObjectBase_isSelectable", "ObjectBase_enableMovement", "ObjectBase_isMovable", "ObjectBase_setFlipEnabled", "ObjectBase_isFlipEnabled", "ObjectBase_setReplayTimeStamp", "timeStamp", "ObjectBase_getReplayTimeStamp", "ObjectBase_setSorInfo", "ObjectBase_getSorInfo", "ObjectBase_setSorPackageLink", "ObjectBase_getSorPackageLink", "ObjectBase_getTemplateProperty", "ObjectBase_setUserId", "ObjectBase_getUserId", "ObjectBase_setExtraDataString", "ObjectBase_getExtraDataString", "ObjectBase_setExtraDataInt", "ObjectBase_getExtraDataInt", "ObjectBase_setExtraDataStringArray", "valueCount", "(ILjava/lang/String;[Ljava/lang/String;I)Z", "ObjectBase_getExtraDataStringArray", "(ILjava/lang/String;)[Ljava/lang/String;", "ObjectBase_setExtraDataByteArray", "ObjectBase_getExtraDataByteArray", "ObjectBase_hasExtraDataString", "ObjectBase_hasExtraDataInt", "ObjectBase_hasExtraDataStringArray", "ObjectBase_hasExtraDataByteArray", "ObjectBase_removeExtraDataString", "ObjectBase_removeExtraDataInt", "ObjectBase_removeExtraDataStringArray", "ObjectBase_removeExtraDataByteArray", "ObjectBase_copyExtraData", "sourceHandle", "sourceObject", "ObjectBase_setSorDataString", "ObjectBase_getSorDataString", "ObjectBase_setSorDataInt", "ObjectBase_getSorDataInt", "ObjectBase_setSorDataStringArray", "ObjectBase_getSorDataStringArray", "ObjectBase_setSorDataByteArray", "ObjectBase_getSorDataByteArray", "ObjectBase_hasSorDataString", "ObjectBase_hasSorDataInt", "ObjectBase_hasSorDataStringArray", "ObjectBase_hasSorDataByteArray", "ObjectBase_removeSorDataString", "ObjectBase_removeSorDataInt", "ObjectBase_removeSorDataStringArray", "ObjectBase_removeSorDataByteArray", "ObjectBase_clearChangedFlag", "ObjectBase_isChanged", "ObjectBase_attachFile", "filepath", "ObjectBase_detachFile", "ObjectBase_getAttachedFile", "ObjectBase_getRuntimeHandle", "ObjectBase_getDrawnRect", "ObjectBase_move", "deltaX", "deltaY", "ObjectBase_resize", "deltaW", "deltaH", "ObjectBase_copy", "sourcehandle", "base", "ObjectBase_setMinSize", "ObjectBase_getMinWidth", "ObjectBase_getMinHeight", "ObjectBase_setMaxSize", "ObjectBase_getMaxWidth", "ObjectBase_getMaxHeight", "ObjectBase_getAppendTime", "ObjectBase_getModifiedTime", "ObjectBase_setLayoutType", "lyoutType", "ObjectBase_getLayoutType", "ObjectBase_getId", "ObjectBase_belongsToSpan", "ObjectBase_isBelongableToSpan", "ObjectBase_getPageIndex", "ObjectBase_getLayerId", "ObjectBase_setLockState", "ObjectBase_getLockState", "ObjectBase_isEditingByCoedit", "ObjectBase_isAllContentFileAvailable", "ObjectBase_isPdfDummyObject", "ObjectBase_setPivot", "ObjectBase_getPivot", "ObjectBase_setCapturedThumbnailBitmap", "ObjectBase_getCapturedThumbnailBitmap", "ObjectBase_isRemovable", "ObjectBase_setRemovable", "isRemovable", "ObjectBase_isFocused", "ObjectBase_setFocused", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectBase.kt\ncom/samsung/android/sdk/pen/document/SpenObjectBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1668:1\n1#2:1669\n*E\n"})
public class SpenObjectBase {
    public static final int LAYOUT_BLOCK = 2;
    public static final int LAYOUT_FLOW = 1;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_UNDEFINED = 3;
    public static final float OBJECT_MINIMUM_SIZE = 10.0f;
    public static final int RESIZE_OPTION_DISABLE = 2;
    public static final int RESIZE_OPTION_FREE = 0;
    public static final int RESIZE_OPTION_KEEP_RATIO = 1;
    public static final float SPEN_INFINITY_FLOAT = Float.MAX_VALUE;
    public static final int SPEN_INFINITY_INT = Integer.MAX_VALUE;
    public static final int STATE_CANCELED = 7;
    public static final int STATE_DONE = 4;
    public static final int STATE_EXCEPTION = 6;
    public static final int STATE_FAIL = 5;
    public static final int STATE_INIT = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_READY = 2;
    public static final int STATE_RUNNING = 3;
    public static final int TYPE_CODE_BLOCK = 23;
    public static final int TYPE_CONTAINER = 4;
    public static final int TYPE_DEPRECATED_DUMMY_STROKE = 9;
    public static final int TYPE_DEPRECATED_TABLE = 12;
    public static final int TYPE_FORMULA = 11;
    public static final int TYPE_IMAGE = 3;
    public static final int TYPE_LINE = 8;
    public static final int TYPE_LINK = 17;
    public static final int TYPE_MATH = 21;
    public static final int TYPE_MAX = 24;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_PAINTING = 14;
    public static final int TYPE_PLOT = 20;
    public static final int TYPE_SHAPE = 7;
    public static final int TYPE_STROKE = 1;
    public static final int TYPE_STROKE_BRUSH = 18;
    public static final int TYPE_STROKE_DEV_VERSION = 15;
    public static final int TYPE_STROKE_GROUP = 100;
    public static final int TYPE_TABLE = 22;
    public static final int TYPE_TEXT_BOX = 2;
    public static final int TYPE_UNKNOWN = 19;
    public static final int TYPE_VIDEO = 16;
    public static final int TYPE_VOICE = 10;
    public static final int TYPE_WEB = 13;
    private int mHandle = -1;
    private int mType;

    public SpenObjectBase(int i) {
        this.mType = i;
    }

    private final native boolean ObjectBase_attachFile(int handle, String filepath);

    private final native boolean ObjectBase_belongsToSpan(int handle);

    private final native void ObjectBase_clearChangedFlag(int handle);

    private final native boolean ObjectBase_copy(int handle, int sourcehandle, SpenObjectBase base);

    private final native boolean ObjectBase_copyExtraData(int handle, int sourceHandle, SpenObjectBase sourceObject);

    private final native boolean ObjectBase_detachFile(int handle);

    private final native boolean ObjectBase_enableClip(int handle, boolean enable);

    private final native boolean ObjectBase_enableMovement(int handle, boolean enable);

    private final native boolean ObjectBase_enableRotation(int handle, boolean enable);

    private final native boolean ObjectBase_enableSelection(int handle, boolean enable);

    private final native void ObjectBase_finalize(int handle);

    private final native long ObjectBase_getAppendTime(int handle);

    private final native String ObjectBase_getAttachedFile(int handle);

    private final native Bitmap ObjectBase_getCapturedThumbnailBitmap(int handle);

    private final native RectF ObjectBase_getDrawnRect(int handle);

    private final native byte[] ObjectBase_getExtraDataByteArray(int handle, String key);

    private final native int ObjectBase_getExtraDataInt(int handle, String key);

    private final native String ObjectBase_getExtraDataString(int handle, String key);

    private final native String[] ObjectBase_getExtraDataStringArray(int handle, String key);

    private final native String ObjectBase_getId(int handle);

    private final native int ObjectBase_getLayerId(int handle);

    private final native int ObjectBase_getLayoutType(int handle);

    private final native boolean ObjectBase_getLockState(int handle);

    private final native float ObjectBase_getMaxHeight(int handle);

    private final native float ObjectBase_getMaxWidth(int handle);

    private final native float ObjectBase_getMinHeight(int handle);

    private final native float ObjectBase_getMinWidth(int handle);

    private final native long ObjectBase_getModifiedTime(int handle);

    private final native int ObjectBase_getPageIndex(int handle);

    private final native PointF ObjectBase_getPivot(int handle);

    private final native RectF ObjectBase_getRect(int handle);

    private final native int ObjectBase_getReplayTimeStamp(int handle);

    private final native int ObjectBase_getResizeOption(int handle);

    private final native float ObjectBase_getRotation(int handle);

    private final native int ObjectBase_getRuntimeHandle(int handle);

    private final native byte[] ObjectBase_getSorDataByteArray(int handle, String key);

    private final native int ObjectBase_getSorDataInt(int handle, String key);

    private final native String ObjectBase_getSorDataString(int handle, String key);

    private final native String[] ObjectBase_getSorDataStringArray(int handle, String key);

    private final native String ObjectBase_getSorInfo(int handle);

    private final native String ObjectBase_getSorPackageLink(int handle);

    private final native boolean ObjectBase_getTemplateProperty(int handle);

    private final native int ObjectBase_getType(int handle);

    private final native int ObjectBase_getUserId(int handle);

    private final native boolean ObjectBase_hasExtraDataByteArray(int handle, String key);

    private final native boolean ObjectBase_hasExtraDataInt(int handle, String key);

    private final native boolean ObjectBase_hasExtraDataString(int handle, String key);

    private final native boolean ObjectBase_hasExtraDataStringArray(int handle, String key);

    private final native boolean ObjectBase_hasSorDataByteArray(int handle, String key);

    private final native boolean ObjectBase_hasSorDataInt(int handle, String key);

    private final native boolean ObjectBase_hasSorDataString(int handle, String key);

    private final native boolean ObjectBase_hasSorDataStringArray(int handle, String key);

    private final native boolean ObjectBase_isAllContentFileAvailable(int handle);

    private final native boolean ObjectBase_isBelongableToSpan(int handle);

    private final native boolean ObjectBase_isChanged(int handle);

    private final native boolean ObjectBase_isClippable(int handle);

    private final native boolean ObjectBase_isEditingByCoedit(int handle);

    private final native boolean ObjectBase_isFlipEnabled(int handle);

    private final native boolean ObjectBase_isFocused(int handle);

    private final native boolean ObjectBase_isMovable(int handle);

    private final native boolean ObjectBase_isPdfDummyObject(int handle);

    private final native boolean ObjectBase_isRemovable(int handle);

    private final native boolean ObjectBase_isReplayable(int handle);

    private final native boolean ObjectBase_isRotatable(int handle);

    private final native boolean ObjectBase_isSelectable(int handle);

    private final native boolean ObjectBase_isVisible(int handle);

    private final native boolean ObjectBase_move(int handle, float deltaX, float deltaY);

    private final native boolean ObjectBase_removeExtraDataByteArray(int handle, String key);

    private final native boolean ObjectBase_removeExtraDataInt(int handle, String key);

    private final native boolean ObjectBase_removeExtraDataString(int handle, String key);

    private final native boolean ObjectBase_removeExtraDataStringArray(int handle, String key);

    private final native boolean ObjectBase_removeSorDataByteArray(int handle, String key);

    private final native boolean ObjectBase_removeSorDataInt(int handle, String key);

    private final native boolean ObjectBase_removeSorDataString(int handle, String key);

    private final native boolean ObjectBase_removeSorDataStringArray(int handle, String key);

    private final native boolean ObjectBase_resize(int handle, float deltaW, float deltaH);

    private final native boolean ObjectBase_setCapturedThumbnailBitmap(int handle, Bitmap bitmap);

    private final native boolean ObjectBase_setExtraDataByteArray(int handle, String key, byte[] value, int valueCount);

    private final native boolean ObjectBase_setExtraDataInt(int handle, String key, int value);

    private final native boolean ObjectBase_setExtraDataString(int handle, String key, String value);

    private final native boolean ObjectBase_setExtraDataStringArray(int handle, String key, String[] value, int valueCount);

    private final native boolean ObjectBase_setFlipEnabled(int handle, boolean enable);

    private final native boolean ObjectBase_setFocused(int handle, boolean isFocused);

    private final native boolean ObjectBase_setLayoutType(int handle, int lyoutType);

    private final native boolean ObjectBase_setLockState(int handle, boolean isLock);

    private final native boolean ObjectBase_setMaxSize(int handle, float width, float height);

    private final native boolean ObjectBase_setMinSize(int handle, float width, float height);

    private final native boolean ObjectBase_setPivot(int handle, PointF pivot);

    private final native boolean ObjectBase_setRect(int handle, RectF rect, boolean regionOnly);

    private final native boolean ObjectBase_setRemovable(int handle, boolean isRemovable);

    private final native boolean ObjectBase_setReplayTimeStamp(int handle, int timeStamp);

    private final native boolean ObjectBase_setReplayable(int handle, boolean record);

    private final native boolean ObjectBase_setResizeOption(int handle, int option);

    private final native boolean ObjectBase_setRotation(int handle, float degree);

    private final native boolean ObjectBase_setSorDataByteArray(int handle, String key, byte[] value, int valueCount);

    private final native boolean ObjectBase_setSorDataInt(int handle, String key, int value);

    private final native boolean ObjectBase_setSorDataString(int handle, String key, String value);

    private final native boolean ObjectBase_setSorDataStringArray(int handle, String key, String[] value, int valueCount);

    private final native boolean ObjectBase_setSorInfo(int handle, String info);

    private final native boolean ObjectBase_setSorPackageLink(int handle, String link);

    private final native boolean ObjectBase_setUserId(int handle, int userId);

    private final native boolean ObjectBase_setVisibility(int handle, boolean visible);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectBase(" + this + ") is already closed");
    }

    @Deprecated(message = "Use attachedFile instead.")
    public void attachFile(@Nullable String filePath) {
        setAttachedFile(filePath);
    }

    public final boolean belongsToSpan() {
        return ObjectBase_belongsToSpan(this.mHandle);
    }

    public void clearChangedFlag() {
        ObjectBase_clearChangedFlag(this.mHandle);
    }

    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectBase_copy(this.mHandle, source.mHandle, source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void detachFile() {
        if (ObjectBase_detachFile(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SpenObjectBase) && this.mHandle == ((SpenObjectBase) other).mHandle;
    }

    public void finalize() {
        ObjectBase_finalize(this.mHandle);
        this.mHandle = -1;
    }

    public final long getAppendTime() {
        return ObjectBase_getAppendTime(this.mHandle);
    }

    @Nullable
    public String getAttachedFile() {
        return ObjectBase_getAttachedFile(this.mHandle);
    }

    @Nullable
    public final Bitmap getCapturedBitmap() {
        return ObjectBase_getCapturedThumbnailBitmap(this.mHandle);
    }

    @Nullable
    public RectF getDrawnRect() {
        return ObjectBase_getDrawnRect(this.mHandle);
    }

    @NotNull
    public final byte[] getExtraDataByteArray(@Nullable String key) {
        return ObjectBase_getExtraDataByteArray(this.mHandle, key);
    }

    public final int getExtraDataInt(@Nullable String key) {
        return ObjectBase_getExtraDataInt(this.mHandle, key);
    }

    @NotNull
    public final String getExtraDataString(@Nullable String key) {
        return ObjectBase_getExtraDataString(this.mHandle, key);
    }

    @NotNull
    public final String[] getExtraDataStringArray(@Nullable String key) {
        return ObjectBase_getExtraDataStringArray(this.mHandle, key);
    }

    public final boolean getFlipEnabled() {
        return ObjectBase_isFlipEnabled(this.mHandle);
    }

    public final boolean getFocused() {
        return ObjectBase_isFocused(this.mHandle);
    }

    /* JADX INFO: renamed from: getHandle, reason: from getter */
    public final int getMHandle() {
        return this.mHandle;
    }

    @NotNull
    public final String getId() {
        return ObjectBase_getId(this.mHandle);
    }

    public final int getLayerId() {
        return ObjectBase_getLayerId(this.mHandle);
    }

    public final int getLayoutType() {
        return ObjectBase_getLayoutType(this.mHandle);
    }

    public final boolean getLockState() {
        return ObjectBase_getLockState(this.mHandle);
    }

    public final int getMHandle() {
        return this.mHandle;
    }

    public final int getMType() {
        return this.mType;
    }

    public float getMaxHeight() {
        return ObjectBase_getMaxHeight(this.mHandle);
    }

    public float getMaxWidth() {
        return ObjectBase_getMaxWidth(this.mHandle);
    }

    public final float getMinHeight() {
        return ObjectBase_getMinHeight(this.mHandle);
    }

    public final float getMinWidth() {
        return ObjectBase_getMinWidth(this.mHandle);
    }

    public final long getModifiedTime() {
        return ObjectBase_getModifiedTime(this.mHandle);
    }

    public final boolean getMovable() {
        return ObjectBase_isMovable(this.mHandle);
    }

    public final boolean getOutOfViewEnabled() {
        return ObjectBase_isClippable(this.mHandle);
    }

    public final int getPageIndex() {
        return ObjectBase_getPageIndex(this.mHandle);
    }

    @NotNull
    public final PointF getPivot() {
        return ObjectBase_getPivot(this.mHandle);
    }

    @NotNull
    public RectF getRect() {
        return ObjectBase_getRect(this.mHandle);
    }

    public final boolean getRemovable() {
        return ObjectBase_isRemovable(this.mHandle);
    }

    public final boolean getReplayable() {
        return ObjectBase_isReplayable(this.mHandle);
    }

    public final int getResizeOption() {
        return ObjectBase_getResizeOption(this.mHandle);
    }

    public final boolean getRotatable() {
        return ObjectBase_isRotatable(this.mHandle);
    }

    public float getRotation() {
        return ObjectBase_getRotation(this.mHandle);
    }

    public final int getRuntimeHandle() {
        return ObjectBase_getRuntimeHandle(this.mHandle);
    }

    public final boolean getSelectable() {
        return ObjectBase_isSelectable(this.mHandle);
    }

    public final int getSorDataInt(@Nullable String key) {
        return ObjectBase_getSorDataInt(this.mHandle, key);
    }

    @NotNull
    public final String getSorDataString(@Nullable String key) {
        return ObjectBase_getSorDataString(this.mHandle, key);
    }

    @Nullable
    public final String getSorInfo() {
        return ObjectBase_getSorInfo(this.mHandle);
    }

    @Nullable
    public final String getSorPackageLink() {
        return ObjectBase_getSorPackageLink(this.mHandle);
    }

    public final boolean getTemplateProperty() {
        return ObjectBase_getTemplateProperty(this.mHandle);
    }

    public int getType() {
        return ObjectBase_getType(this.mHandle);
    }

    public final int getUserId() {
        return ObjectBase_getUserId(this.mHandle);
    }

    public final boolean getVisible() {
        return ObjectBase_isVisible(this.mHandle);
    }

    public final boolean hasExtraDataByteArray(@Nullable String key) {
        return ObjectBase_hasExtraDataByteArray(this.mHandle, key);
    }

    public final boolean hasExtraDataInt(@Nullable String key) {
        return ObjectBase_hasExtraDataInt(this.mHandle, key);
    }

    public final boolean hasExtraDataString(@Nullable String key) {
        return ObjectBase_hasExtraDataString(this.mHandle, key);
    }

    public final boolean hasExtraDataStringArray(@Nullable String key) {
        return ObjectBase_hasExtraDataStringArray(this.mHandle, key);
    }

    public final boolean hasSorDataInt(@Nullable String key) {
        return ObjectBase_hasSorDataInt(this.mHandle, key);
    }

    public final boolean hasSorDataString(@Nullable String key) {
        return ObjectBase_hasSorDataString(this.mHandle, key);
    }

    public int hashCode() {
        return this.mHandle;
    }

    public final boolean isAllContentFileAvailable() {
        return ObjectBase_isAllContentFileAvailable(this.mHandle);
    }

    public final boolean isBelongableToSpan() {
        return ObjectBase_isBelongableToSpan(this.mHandle);
    }

    public boolean isChanged() {
        return ObjectBase_isChanged(this.mHandle);
    }

    public final boolean isEditingByCoedit() {
        return ObjectBase_isEditingByCoedit(this.mHandle);
    }

    public final boolean isPdfDummyObject() {
        return ObjectBase_isPdfDummyObject(this.mHandle);
    }

    public final void removeExtraDataByteArray(@Nullable String key) {
        if (ObjectBase_removeExtraDataByteArray(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataInt(@Nullable String key) {
        if (ObjectBase_removeExtraDataInt(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataString(@Nullable String key) {
        if (ObjectBase_removeExtraDataString(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataStringArray(@Nullable String key) {
        if (ObjectBase_removeExtraDataStringArray(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeSorDataInt(@Nullable String key) {
        if (ObjectBase_removeSorDataInt(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeSorDataString(@Nullable String key) {
        if (ObjectBase_removeSorDataString(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setAttachedFile(@Nullable String str) {
        if (ObjectBase_attachFile(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCapturedBitmap(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectBase_setCapturedThumbnailBitmap(this.mHandle, bitmap)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataByteArray(@Nullable String key, @Nullable byte[] value) {
        if (value == null ? ObjectBase_setExtraDataByteArray(this.mHandle, key, value, 0) : ObjectBase_setExtraDataByteArray(this.mHandle, key, value, value.length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataInt(@Nullable String key, int value) {
        if (ObjectBase_setExtraDataInt(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataString(@Nullable String key, @Nullable String value) {
        if (ObjectBase_setExtraDataString(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataStringArray(@Nullable String key, @Nullable String[] value) {
        if (value == null ? ObjectBase_setExtraDataStringArray(this.mHandle, key, value, 0) : ObjectBase_setExtraDataStringArray(this.mHandle, key, value, value.length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFlipEnabled(boolean z) {
        if (ObjectBase_setFlipEnabled(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFocused(boolean z) {
        if (ObjectBase_setFocused(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayoutType(int i) {
        if (ObjectBase_setLayoutType(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLockState(boolean z) {
        if (ObjectBase_setLockState(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setMaxSize(float width, float height) {
        if (ObjectBase_setMaxSize(this.mHandle, width, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMinSize(float width, float height) {
        if (ObjectBase_setMinSize(this.mHandle, width, height)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setMovable(boolean z) {
        if (ObjectBase_enableMovement(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setOutOfViewEnabled(boolean z) {
        if (ObjectBase_enableClip(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean setPivot(@NotNull PointF pivot) {
        Intrinsics.checkNotNullParameter(pivot, "pivot");
        boolean zObjectBase_setPivot = ObjectBase_setPivot(this.mHandle, pivot);
        if (!zObjectBase_setPivot) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectBase_setPivot;
    }

    public void setRect(@Nullable RectF rect, boolean regionOnly) {
        if (ObjectBase_setRect(this.mHandle, rect, regionOnly)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRemovable(boolean z) {
        if (ObjectBase_setRemovable(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setReplayable(boolean z) {
        if (ObjectBase_setReplayable(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setResizeOption(int i) {
        if (ObjectBase_setResizeOption(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setRotatable(boolean z) {
        if (ObjectBase_enableRotation(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setRotation(float f) {
        if (ObjectBase_setRotation(this.mHandle, f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSelectable(boolean z) {
        if (ObjectBase_enableSelection(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSorDataInt(@Nullable String key, int value) {
        if (ObjectBase_setSorDataInt(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSorDataString(@Nullable String key, @Nullable String value) {
        if (ObjectBase_setSorDataString(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSorInfo(@Nullable String str) {
        if (ObjectBase_setSorInfo(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSorPackageLink(@Nullable String str) {
        if (ObjectBase_setSorPackageLink(this.mHandle, str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean setUserId(int userId) {
        return ObjectBase_setUserId(this.mHandle, userId);
    }

    public final void setVisibility(boolean visible) {
        setVisible(visible);
    }

    public final void setVisible(boolean z) {
        if (ObjectBase_setVisibility(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
