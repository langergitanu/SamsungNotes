package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\bR\u0018\u0000 ´\u00012\u00020\u0001:\u0004³\u0001´\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0002\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB7\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0002\u0010\u0012B?\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0013BK\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0002\u0010\u0016BS\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0017J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0001H\u0016J1\u0010e\u001a\u00020c2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010fJE\u0010e\u001a\u00020c2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010gJ \u0010h\u001a\u00020c2\b\u0010i\u001a\u0004\u0018\u00010\r2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020-J0\u0010h\u001a\u00020c2\b\u0010i\u001a\u0004\u0018\u00010\r2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u0002032\u0006\u0010m\u001a\u000203J\u0010\u0010n\u001a\u00020c2\u0006\u0010o\u001a\u00020-H\u0002J\u001b\u0010p\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 JD\u0010r\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0082 ¢\u0006\u0002\u0010sJL\u0010t\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 ¢\u0006\u0002\u0010uJX\u0010v\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0082 ¢\u0006\u0002\u0010wJ`\u0010x\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010y\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 ¢\u0006\u0002\u0010zJ\u001b\u0010{\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0011\u0010|\u001a\u00020\b2\u0006\u0010q\u001a\u00020-H\u0082 J\u001b\u0010}\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0082 J\u0013\u0010~\u001a\u0004\u0018\u00010\b2\u0006\u0010q\u001a\u00020-H\u0082 J;\u0010\u007f\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0082 ¢\u0006\u0003\u0010\u0080\u0001JR\u0010\u0081\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0082 ¢\u0006\u0003\u0010\u0082\u0001J\"\u0010\u0083\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010q\u001a\u00020-H\u0082 ¢\u0006\u0003\u0010\u0084\u0001J\u0014\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020-H\u0082 J\u0014\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010q\u001a\u00020-H\u0082 J\u0014\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020-H\u0082 J\u0014\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020-H\u0082 J,\u0010\u0089\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010i\u001a\u0004\u0018\u00010\r2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020-H\u0082 J<\u0010\u008a\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\b\u0010i\u001a\u0004\u0018\u00010\r2\u0006\u0010j\u001a\u0002032\u0006\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u0002032\u0006\u0010m\u001a\u000203H\u0082 J\u001a\u0010\u008b\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010,\u001a\u00020-H\u0082 J\u0012\u0010\u008c\u0001\u001a\u00020-2\u0006\u0010q\u001a\u00020-H\u0082 J\u001b\u0010\u008d\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0007\u0010\u008e\u0001\u001a\u000203H\u0082 J\u0012\u0010\u008f\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020-H\u0082 J\u001b\u0010\u0090\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0007\u0010\u0091\u0001\u001a\u00020-H\u0082 J\u0012\u0010\u0092\u0001\u001a\u00020-2\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010\u0093\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00109\u001a\u00020\u0005H\u0082 J\u0012\u0010\u0094\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010\u0095\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010N\u001a\u000203H\u0082 J$\u0010\u0096\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0007\u0010\u0097\u0001\u001a\u0002032\u0007\u0010\u0098\u0001\u001a\u000203H\u0082 J#\u0010\u0099\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010d\u001a\u00020\u00012\u0007\u0010\u009a\u0001\u001a\u00020-H\u0082 J$\u0010\u009b\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0007\u0010\u0097\u0001\u001a\u0002032\u0007\u0010\u0098\u0001\u001a\u000203H\u0082 J\u001a\u0010\u009c\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010=\u001a\u00020-H\u0082 J\u0012\u0010\u009d\u0001\u001a\u00020-2\u0006\u0010q\u001a\u00020-H\u0082 J\u0014\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020-H\u0082 J\u0014\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u000f2\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010 \u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00109\u001a\u00020\u0005H\u0082 J\u0012\u0010¡\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010¢\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00109\u001a\u00020\u0005H\u0082 J\u0012\u0010£\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010¤\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010D\u001a\u000203H\u0082 J\u0012\u0010¥\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010¦\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010H\u001a\u00020-H\u0082 J\u0012\u0010§\u0001\u001a\u00020-2\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010¨\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u0010R\u001a\u000203H\u0082 J\u0012\u0010©\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010ª\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00109\u001a\u00020\u0005H\u0082 J\u0012\u0010«\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-H\u0082 J\u001b\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0007\u0010\u00ad\u0001\u001a\u00020-H\u0082 J\u0012\u0010®\u0001\u001a\u00020-2\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010¯\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0082 J\u0012\u0010°\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020-H\u0082 J\u001a\u0010±\u0001\u001a\u00020\u00052\u0006\u0010q\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0082 J\u0012\u0010²\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020-H\u0082 R(\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\tR(\u0010\u001c\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\tR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b&\u0010#R\u0013\u0010'\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b*\u0010#R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b+\u0010#R&\u0010,\u001a\u00020-2\b\b\u0001\u0010,\u001a\u00020-8G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00104\u001a\u0002032\u0006\u00102\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0006R$\u0010=\u001a\u00020-2\u0006\u0010=\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010/\"\u0004\b?\u00101R$\u0010@\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010;\"\u0004\bA\u0010\u0006R$\u0010B\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010;\"\u0004\bC\u0010\u0006R$\u0010E\u001a\u0002032\u0006\u0010D\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00106\"\u0004\bG\u00108R$\u0010H\u001a\u00020I2\u0006\u0010H\u001a\u00020I8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010O\u001a\u0002032\u0006\u0010N\u001a\u0002038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u00106\"\u0004\bQ\u00108R$\u0010S\u001a\u0002032\u0006\u0010R\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u00106\"\u0004\bU\u00108R$\u0010V\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010;\"\u0004\bW\u0010\u0006R$\u0010X\u001a\u00020-2\u0006\u0010X\u001a\u00020-8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101R$\u0010[\u001a\u0002032\u0006\u00102\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u00106\"\u0004\b]\u00108R$\u0010_\u001a\u0002032\u0006\u0010^\u001a\u0002038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u00106\"\u0004\ba\u00108¨\u0006µ\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "penName", "", "(Ljava/lang/String;)V", "(Ljava/lang/String;Z)V", "points", "", "Landroid/graphics/PointF;", "pressures", "", "timestamps", "", "(Ljava/lang/String;[Landroid/graphics/PointF;[F[I)V", "(Ljava/lang/String;[Landroid/graphics/PointF;[F[IZ)V", "tilts", "orientations", "(Ljava/lang/String;[Landroid/graphics/PointF;[F[I[F[F)V", "(Ljava/lang/String;[Landroid/graphics/PointF;[F[I[F[FZ)V", "getPenName", "()Ljava/lang/String;", "setPenName", "penStyle", "advancedPenSetting", "getAdvancedPenSetting", "setAdvancedPenSetting", "getPoints", "()[Landroid/graphics/PointF;", "xPoints", "getXPoints", "()[F", "yPoints", "getYPoints", "getPressures", "timeStamps", "getTimeStamps", "()[I", "getTilts", "getOrientations", "color", "", "getColor", "()I", "setColor", "(I)V", "size", "", "penSize", "getPenSize", "()F", "setPenSize", "(F)V", "enable", "isCurveEnabled", "()Z", "setCurveEnabled", "toolType", "getToolType", "setToolType", "isEraserEnabled", "setEraserEnabled", "isFixedWidthEnabled", "setFixedWidthEnabled", "width", "fixedWidth", "getFixedWidth", "setFixedWidth", "dashType", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke$PenDashType;", "getDashType", "()Lcom/samsung/android/sdk/pen/document/SpenObjectStroke$PenDashType;", "setDashType", "(Lcom/samsung/android/sdk/pen/document/SpenObjectStroke$PenDashType;)V", "degree", Key.ROTATION, "getRotation", "setRotation", TypedValues.Cycle.S_WAVE_OFFSET, "dashOffset", "getDashOffset", "setDashOffset", "isFixedOpacityEnabled", "setFixedOpacityEnabled", "patternIndex", "getPatternIndex", "setPatternIndex", "particleSize", "getParticleSize", "setParticleSize", WiggleAnimationConfig.KEY_SCALE, "patternScale", "getPatternScale", "setPatternScale", "copy", "", "source", "setPoints", "([Landroid/graphics/PointF;[F[I)V", "([Landroid/graphics/PointF;[F[I[F[F)V", "addPoint", "pos", "pressure", "timestamp", "tilt", "orientation", "throwUncheckedException", "errno", "ObjectStroke_init1", "handle", "ObjectStroke_init3", "(ILjava/lang/String;[Landroid/graphics/PointF;[F[I)Z", "ObjectStroke_init4", "(ILjava/lang/String;[Landroid/graphics/PointF;[F[IZ)Z", "ObjectStroke_init5", "(ILjava/lang/String;[Landroid/graphics/PointF;[F[I[F[F)Z", "ObjectStroke_init6", "orienations", "(ILjava/lang/String;[Landroid/graphics/PointF;[F[I[F[FZ)Z", "ObjectStroke_setPenName", "ObjectStroke_getPenName", "ObjectStroke_setAdvancedPenSetting", "ObjectStroke_getAdvancedPenSetting", "ObjectStroke_setPoints", "(I[Landroid/graphics/PointF;[F[I)Z", "ObjectStroke_setPoints2", "(I[Landroid/graphics/PointF;[F[I[F[F)Z", "ObjectStroke_getPoints", "(I)[Landroid/graphics/PointF;", "ObjectStroke_getPressures", "ObjectStroke_getTimeStamps", "ObjectStroke_getTilts", "ObjectStroke_getOrientations", "ObjectStroke_addPoint4", "ObjectStroke_addPoint5", "ObjectStroke_setColor", "ObjectStroke_getColor", "ObjectStroke_setPenSize", "lineWidth", "ObjectStroke_getPenSize", "ObjectStroke_setInputType", "inputType", "ObjectStroke_getInputType", "ObjectStroke_enableCurve", "ObjectStroke_isCurvable", "ObjectStroke_setRotation", "ObjectStroke_move", "dX", "dY", "ObjectStroke_copy", "sourceHandle", "ObjectStroke_resize", "ObjectStroke_setToolType", "ObjectStroke_getToolType", "ObjectStroke_getXPoints", "ObjectStroke_getYPoints", "ObjectStroke_setEraserEnabled", "ObjectStroke_isEraserEnabled", "ObjectStroke_setFixedWidthEnabled", "ObjectStroke_isFixedWidthEnabled", "ObjectStroke_setFixedWidth", "ObjectStroke_getFixedWidth", "ObjectStroke_setDashType", "ObjectStroke_getDashType", "ObjectStroke_setDashOffset", "ObjectStroke_getDashOffset", "ObjectStroke_setFixedOpacityEnabled", "ObjectStroke_isFixedOpacityEnabled", "ObjectStroke_setPatternIndex", "index", "ObjectStroke_getPatternIndex", "ObjectStroke_setParticleSize", "ObjectStroke_getParticleSize", "ObjectStroke_setPatternScale", "ObjectStroke_getPatternScale", "PenDashType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectStroke extends SpenObjectBase {
    public static final int TOOL_TYPE_ERASER = 4;
    public static final int TOOL_TYPE_FINGER = 1;
    public static final int TOOL_TYPE_MOUSE = 3;
    public static final int TOOL_TYPE_SPEN = 2;
    public static final int TOOL_TYPE_UNKNOWN = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectStroke$PenDashType;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUOUS_LINE", "DASHED_LINE", "DASHED_SPACE_LINE", "LONG_DASHED_DOTTED_LINE", "LONG_DASHED_DOUBLE_DOTTED_LINE", "LONG_DASHED_TRIPLE_DOTTED_LINE", "DOTTED_LINE", "LONG_DASHED_SHORT_DASHED_LINE", "LONG_DASHED_DOULBE_SHORT_DASHED_LINE", "DASHED_DOTTED_LINE", "DOUBLE_DASHED_DOTTED_LINE", "DASHED_DOUBLE_DOTTED_LINE", "DOUBLE_DASHED_DOUBLE_DOTTED_LINE", "DASHED_TRIPLE_DOTTED_LINE", "DOUBLE_DASHED_TRIPLE_DOTTED_LINE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class PenDashType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PenDashType[] $VALUES;
        public static final PenDashType CONTINUOUS_LINE = new PenDashType("CONTINUOUS_LINE", 0);
        public static final PenDashType DASHED_LINE = new PenDashType("DASHED_LINE", 1);
        public static final PenDashType DASHED_SPACE_LINE = new PenDashType("DASHED_SPACE_LINE", 2);
        public static final PenDashType LONG_DASHED_DOTTED_LINE = new PenDashType("LONG_DASHED_DOTTED_LINE", 3);
        public static final PenDashType LONG_DASHED_DOUBLE_DOTTED_LINE = new PenDashType("LONG_DASHED_DOUBLE_DOTTED_LINE", 4);
        public static final PenDashType LONG_DASHED_TRIPLE_DOTTED_LINE = new PenDashType("LONG_DASHED_TRIPLE_DOTTED_LINE", 5);
        public static final PenDashType DOTTED_LINE = new PenDashType("DOTTED_LINE", 6);
        public static final PenDashType LONG_DASHED_SHORT_DASHED_LINE = new PenDashType("LONG_DASHED_SHORT_DASHED_LINE", 7);
        public static final PenDashType LONG_DASHED_DOULBE_SHORT_DASHED_LINE = new PenDashType("LONG_DASHED_DOULBE_SHORT_DASHED_LINE", 8);
        public static final PenDashType DASHED_DOTTED_LINE = new PenDashType("DASHED_DOTTED_LINE", 9);
        public static final PenDashType DOUBLE_DASHED_DOTTED_LINE = new PenDashType("DOUBLE_DASHED_DOTTED_LINE", 10);
        public static final PenDashType DASHED_DOUBLE_DOTTED_LINE = new PenDashType("DASHED_DOUBLE_DOTTED_LINE", 11);
        public static final PenDashType DOUBLE_DASHED_DOUBLE_DOTTED_LINE = new PenDashType("DOUBLE_DASHED_DOUBLE_DOTTED_LINE", 12);
        public static final PenDashType DASHED_TRIPLE_DOTTED_LINE = new PenDashType("DASHED_TRIPLE_DOTTED_LINE", 13);
        public static final PenDashType DOUBLE_DASHED_TRIPLE_DOTTED_LINE = new PenDashType("DOUBLE_DASHED_TRIPLE_DOTTED_LINE", 14);

        private static final /* synthetic */ PenDashType[] $values() {
            return new PenDashType[]{CONTINUOUS_LINE, DASHED_LINE, DASHED_SPACE_LINE, LONG_DASHED_DOTTED_LINE, LONG_DASHED_DOUBLE_DOTTED_LINE, LONG_DASHED_TRIPLE_DOTTED_LINE, DOTTED_LINE, LONG_DASHED_SHORT_DASHED_LINE, LONG_DASHED_DOULBE_SHORT_DASHED_LINE, DASHED_DOTTED_LINE, DOUBLE_DASHED_DOTTED_LINE, DASHED_DOUBLE_DOTTED_LINE, DOUBLE_DASHED_DOUBLE_DOTTED_LINE, DASHED_TRIPLE_DOTTED_LINE, DOUBLE_DASHED_TRIPLE_DOTTED_LINE};
        }

        static {
            PenDashType[] penDashTypeArr$values = $values();
            $VALUES = penDashTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(penDashTypeArr$values);
        }

        private PenDashType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<PenDashType> getEntries() {
            return $ENTRIES;
        }

        public static PenDashType valueOf(String str) {
            return (PenDashType) Enum.valueOf(PenDashType.class, str);
        }

        public static PenDashType[] values() {
            return (PenDashType[]) $VALUES.clone();
        }
    }

    public SpenObjectStroke() {
        super(1);
    }

    private final native boolean ObjectStroke_addPoint4(int handle, PointF pos, float pressure, int timestamp);

    private final native boolean ObjectStroke_addPoint5(int handle, PointF pos, float pressure, int timestamp, float tilt, float orientation);

    private final native boolean ObjectStroke_copy(int handle, SpenObjectBase source, int sourceHandle);

    private final native boolean ObjectStroke_enableCurve(int handle, boolean enable);

    private final native String ObjectStroke_getAdvancedPenSetting(int handle);

    private final native int ObjectStroke_getColor(int handle);

    private final native float ObjectStroke_getDashOffset(int handle);

    private final native int ObjectStroke_getDashType(int handle);

    private final native float ObjectStroke_getFixedWidth(int handle);

    private final native int ObjectStroke_getInputType(int handle);

    private final native float[] ObjectStroke_getOrientations(int handle);

    private final native float ObjectStroke_getParticleSize(int handle);

    private final native int ObjectStroke_getPatternIndex(int handle);

    private final native float ObjectStroke_getPatternScale(int handle);

    private final native String ObjectStroke_getPenName(int handle);

    private final native float ObjectStroke_getPenSize(int handle);

    private final native PointF[] ObjectStroke_getPoints(int handle);

    private final native float[] ObjectStroke_getPressures(int handle);

    private final native float[] ObjectStroke_getTilts(int handle);

    private final native int[] ObjectStroke_getTimeStamps(int handle);

    private final native int ObjectStroke_getToolType(int handle);

    private final native float[] ObjectStroke_getXPoints(int handle);

    private final native float[] ObjectStroke_getYPoints(int handle);

    private final native boolean ObjectStroke_init1(int handle, String penName);

    private final native boolean ObjectStroke_init3(int handle, String penName, PointF[] points, float[] pressures, int[] timeStamps);

    private final native boolean ObjectStroke_init4(int handle, String penName, PointF[] points, float[] pressures, int[] timeStamps, boolean isTemplateObject);

    private final native boolean ObjectStroke_init5(int handle, String penName, PointF[] points, float[] pressures, int[] timeStamps, float[] tilts, float[] orientations);

    private final native boolean ObjectStroke_init6(int handle, String penName, PointF[] points, float[] pressures, int[] timeStamps, float[] tilts, float[] orienations, boolean isTemplateObject);

    private final native boolean ObjectStroke_isCurvable(int handle);

    private final native boolean ObjectStroke_isEraserEnabled(int handle);

    private final native boolean ObjectStroke_isFixedOpacityEnabled(int handle);

    private final native boolean ObjectStroke_isFixedWidthEnabled(int handle);

    private final native boolean ObjectStroke_move(int handle, float dX, float dY);

    private final native boolean ObjectStroke_resize(int handle, float dX, float dY);

    private final native boolean ObjectStroke_setAdvancedPenSetting(int handle, String penStyle);

    private final native boolean ObjectStroke_setColor(int handle, int color);

    private final native boolean ObjectStroke_setDashOffset(int handle, float offset);

    private final native boolean ObjectStroke_setDashType(int handle, int dashType);

    private final native boolean ObjectStroke_setEraserEnabled(int handle, boolean enable);

    private final native boolean ObjectStroke_setFixedOpacityEnabled(int handle, boolean enable);

    private final native boolean ObjectStroke_setFixedWidth(int handle, float width);

    private final native boolean ObjectStroke_setFixedWidthEnabled(int handle, boolean enable);

    private final native boolean ObjectStroke_setInputType(int handle, int inputType);

    private final native boolean ObjectStroke_setParticleSize(int handle, float size);

    private final native boolean ObjectStroke_setPatternIndex(int handle, int index);

    private final native boolean ObjectStroke_setPatternScale(int handle, float size);

    private final native boolean ObjectStroke_setPenName(int handle, String penName);

    private final native boolean ObjectStroke_setPenSize(int handle, float lineWidth);

    private final native boolean ObjectStroke_setPoints(int handle, PointF[] points, float[] pressures, int[] timeStamps);

    private final native boolean ObjectStroke_setPoints2(int handle, PointF[] points, float[] pressures, int[] timeStamps, float[] tilts, float[] orientations);

    private final native boolean ObjectStroke_setRotation(int handle, float degree);

    private final native boolean ObjectStroke_setToolType(int handle, int toolType);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectStroke(" + this + ") is already closed");
    }

    public final void addPoint(@Nullable PointF pos, float pressure, int timestamp) {
        if (ObjectStroke_addPoint4(getMHandle(), pos, pressure, timestamp)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectStroke_copy(getMHandle(), source, source.getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAdvancedPenSetting() {
        return ObjectStroke_getAdvancedPenSetting(getMHandle());
    }

    @ColorInt
    public final int getColor() {
        return ObjectStroke_getColor(getMHandle());
    }

    public final float getDashOffset() {
        return ObjectStroke_getDashOffset(getMHandle());
    }

    @NotNull
    public final PenDashType getDashType() {
        return PenDashType.values()[ObjectStroke_getDashType(getMHandle())];
    }

    public final float getFixedWidth() {
        return ObjectStroke_getFixedWidth(getMHandle());
    }

    @Nullable
    public final float[] getOrientations() {
        return ObjectStroke_getOrientations(getMHandle());
    }

    public final float getParticleSize() {
        return ObjectStroke_getParticleSize(getMHandle());
    }

    public final int getPatternIndex() {
        return ObjectStroke_getPatternIndex(getMHandle());
    }

    public final float getPatternScale() {
        return ObjectStroke_getPatternScale(getMHandle());
    }

    @Nullable
    public final String getPenName() {
        return ObjectStroke_getPenName(getMHandle());
    }

    public final float getPenSize() {
        return ObjectStroke_getPenSize(getMHandle());
    }

    @Nullable
    public final PointF[] getPoints() {
        float[] fArrObjectStroke_getXPoints = ObjectStroke_getXPoints(getMHandle());
        float[] fArrObjectStroke_getYPoints = ObjectStroke_getYPoints(getMHandle());
        if (fArrObjectStroke_getXPoints == null || fArrObjectStroke_getYPoints == null || fArrObjectStroke_getXPoints.length == 0 || fArrObjectStroke_getYPoints.length == 0) {
            return null;
        }
        int length = fArrObjectStroke_getXPoints.length;
        PointF[] pointFArr = new PointF[length];
        for (int i = 0; i < length; i++) {
            pointFArr[i] = new PointF(0.0f, 0.0f);
        }
        for (int i2 = 0; i2 < length; i2++) {
            pointFArr[i2] = new PointF(fArrObjectStroke_getXPoints[i2], fArrObjectStroke_getYPoints[i2]);
        }
        return pointFArr;
    }

    @Nullable
    public final float[] getPressures() {
        return ObjectStroke_getPressures(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public float getRotation() {
        return super.getRotation();
    }

    @Nullable
    public final float[] getTilts() {
        return ObjectStroke_getTilts(getMHandle());
    }

    @Nullable
    public final int[] getTimeStamps() {
        return ObjectStroke_getTimeStamps(getMHandle());
    }

    public final int getToolType() {
        return ObjectStroke_getToolType(getMHandle());
    }

    @Nullable
    public final float[] getXPoints() {
        return ObjectStroke_getXPoints(getMHandle());
    }

    @Nullable
    public final float[] getYPoints() {
        return ObjectStroke_getYPoints(getMHandle());
    }

    public final boolean isCurveEnabled() {
        return ObjectStroke_isCurvable(getMHandle());
    }

    public final boolean isEraserEnabled() {
        return ObjectStroke_isEraserEnabled(getMHandle());
    }

    public final boolean isFixedOpacityEnabled() {
        return ObjectStroke_isFixedOpacityEnabled(getMHandle());
    }

    public final boolean isFixedWidthEnabled() {
        return ObjectStroke_isFixedWidthEnabled(getMHandle());
    }

    public final void setAdvancedPenSetting(@Nullable String str) {
        if (ObjectStroke_setAdvancedPenSetting(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setColor(@ColorInt int i) {
        if (ObjectStroke_setColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCurveEnabled(boolean z) {
        if (ObjectStroke_enableCurve(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDashOffset(float f) {
        if (ObjectStroke_setDashOffset(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDashType(@NotNull PenDashType dashType) {
        Intrinsics.checkNotNullParameter(dashType, "dashType");
        if (ObjectStroke_setDashType(getMHandle(), dashType.ordinal())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setEraserEnabled(boolean z) {
        if (ObjectStroke_setEraserEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFixedOpacityEnabled(boolean z) {
        if (ObjectStroke_setFixedOpacityEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFixedWidth(float f) {
        if (ObjectStroke_setFixedWidth(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFixedWidthEnabled(boolean z) {
        if (ObjectStroke_setFixedWidthEnabled(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setParticleSize(float f) {
        if (ObjectStroke_setParticleSize(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPatternIndex(int i) {
        if (ObjectStroke_setPatternIndex(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPatternScale(float f) {
        if (ObjectStroke_setPatternScale(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPenName(@Nullable String str) {
        if (ObjectStroke_setPenName(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPenSize(float f) {
        if (ObjectStroke_setPenSize(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPoints(@Nullable PointF[] points, @Nullable float[] pressures, @Nullable int[] timestamps) {
        setPoints(points, pressures, timestamps, null, null);
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRotation(float f) {
        if (ObjectStroke_setRotation(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setToolType(int i) {
        if (ObjectStroke_setToolType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(boolean z) {
        super(1);
        if (ObjectStroke_init4(getMHandle(), null, null, null, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPoints(@Nullable PointF[] points, @Nullable float[] pressures, @Nullable int[] timestamps, @Nullable float[] tilts, @Nullable float[] orientations) {
        boolean zObjectStroke_setPoints2;
        if (points == null) {
            zObjectStroke_setPoints2 = ObjectStroke_setPoints2(getMHandle(), points, pressures, timestamps, tilts, orientations);
        } else {
            int length = points.length;
            Intrinsics.checkNotNull(pressures);
            if (length == pressures.length) {
                int length2 = points.length;
                Intrinsics.checkNotNull(timestamps);
                if (length2 != timestamps.length) {
                    SpenError.ThrowUncheckedException(7);
                }
                if ((tilts == null && orientations != null) || ((tilts != null && orientations == null) || (tilts != null && orientations != null && (points.length != tilts.length || points.length != orientations.length)))) {
                    SpenError.ThrowUncheckedException(7);
                }
                zObjectStroke_setPoints2 = ObjectStroke_setPoints2(getMHandle(), points, pressures, timestamps, tilts, orientations);
            }
        }
        if (zObjectStroke_setPoints2) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void addPoint(@Nullable PointF pos, float pressure, int timestamp, float tilt, float orientation) {
        if (ObjectStroke_addPoint5(getMHandle(), pos, pressure, timestamp, tilt, orientation)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str) {
        super(1);
        if (ObjectStroke_init1(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str, boolean z) {
        super(1);
        if (ObjectStroke_init4(getMHandle(), str, null, null, null, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str, @Nullable PointF[] pointFArr, @Nullable float[] fArr, @Nullable int[] iArr) {
        super(1);
        if (pointFArr != null && fArr != null && iArr != null && (pointFArr.length != fArr.length || pointFArr.length != iArr.length)) {
            SpenError.ThrowUncheckedException(7);
        }
        if (ObjectStroke_init3(getMHandle(), str, pointFArr, fArr, iArr)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str, @Nullable PointF[] pointFArr, @Nullable float[] fArr, @Nullable int[] iArr, boolean z) {
        super(1);
        if (pointFArr != null && fArr != null && iArr != null && (pointFArr.length != fArr.length || pointFArr.length != iArr.length)) {
            SpenError.ThrowUncheckedException(7);
        }
        if (ObjectStroke_init4(getMHandle(), str, pointFArr, fArr, iArr, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str, @Nullable PointF[] pointFArr, @Nullable float[] fArr, @Nullable int[] iArr, @Nullable float[] fArr2, @Nullable float[] fArr3) {
        super(1);
        if (pointFArr != null && fArr != null && iArr != null && fArr2 != null && fArr3 != null && (pointFArr.length != fArr.length || pointFArr.length != iArr.length || pointFArr.length != fArr2.length || pointFArr.length != fArr3.length)) {
            throwUncheckedException(7);
        }
        if (fArr2 == null && fArr3 != null) {
            throwUncheckedException(7);
        }
        if (fArr2 != null && fArr3 == null) {
            throwUncheckedException(7);
        }
        if (ObjectStroke_init5(getMHandle(), str, pointFArr, fArr, iArr, fArr2, fArr3)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectStroke(@Nullable String str, @Nullable PointF[] pointFArr, @Nullable float[] fArr, @Nullable int[] iArr, @Nullable float[] fArr2, @Nullable float[] fArr3, boolean z) {
        super(1);
        if (pointFArr != null && fArr != null && iArr != null && fArr2 != null && fArr3 != null && (pointFArr.length != fArr.length || pointFArr.length != iArr.length || pointFArr.length != fArr2.length || pointFArr.length != fArr3.length)) {
            throwUncheckedException(7);
        }
        if (fArr2 == null && fArr3 != null) {
            throwUncheckedException(7);
        }
        if (fArr2 != null && fArr3 == null) {
            throwUncheckedException(7);
        }
        if (ObjectStroke_init6(getMHandle(), str, pointFArr, fArr, iArr, fArr2, fArr3, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
