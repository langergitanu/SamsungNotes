package com.samsung.android.sdk.pen.document;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.changedInfo.SpenLayerChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenLayerInsertedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenPageChangedInfo;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b*\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0003\b\u0092\u0001\u0018\u0000 ã\u00022\u00020\u0001:\u000eÝ\u0002Þ\u0002ß\u0002à\u0002á\u0002â\u0002ã\u0002B-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB7\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\rJ\u0013\u0010T\u001a\u00020 2\b\u0010U\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010V\u001a\u00020\u0005H\u0016J\b\u0010W\u001a\u00020XH\u0004J\u0010\u0010Y\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010\u0019J\u0006\u0010[\u001a\u00020XJ\u000e\u0010\\\u001a\u00020\u00192\u0006\u0010]\u001a\u00020\u0005J\u000e\u0010^\u001a\u00020\u00052\u0006\u0010_\u001a\u00020 J\u0016\u0010^\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u00052\u0006\u0010_\u001a\u00020 J\u000e\u0010a\u001a\u00020\u00192\u0006\u0010b\u001a\u00020\u0005J\u000e\u0010c\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0019J\u0010\u0010d\u001a\u00020 2\b\u0010Z\u001a\u0004\u0018\u00010\u0019J\u0018\u0010e\u001a\u0004\u0018\u00010\u00192\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gJ \u0010e\u001a\u0004\u0018\u00010\u00192\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020g2\u0006\u0010H\u001a\u00020gJ&\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gJ.\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020g2\u0006\u0010H\u001a\u00020gJ+\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010l¢\u0006\u0002\u0010nJ(\u0010o\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\b\u0010p\u001a\u0004\u0018\u00010:2\u0006\u0010q\u001a\u00020 J\u0010\u0010r\u001a\u00020X2\b\u00100\u001a\u0004\u0018\u00010$J\u0010\u0010s\u001a\u00020X2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u00103\u001a\u00020X2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010t\u001a\u00020 J\u001a\u0010u\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\b2\b\u0010w\u001a\u0004\u0018\u00010\bJ%\u0010x\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\b2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010l¢\u0006\u0002\u0010yJ\u001a\u0010z\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\b2\b\u0010w\u001a\u0004\u0018\u00010{J\u0018\u0010|\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\b2\u0006\u0010w\u001a\u00020\u0005J\u0012\u0010}\u001a\u0004\u0018\u00010\b2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0010\u0010~\u001a\u00020\u00052\b\u0010v\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010l2\b\u0010v\u001a\u0004\u0018\u00010\b¢\u0006\u0003\u0010\u0080\u0001J\u0013\u0010\u0081\u0001\u001a\u0004\u0018\u00010{2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0082\u0001\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0083\u0001\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0084\u0001\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0085\u0001\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0086\u0001\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0087\u0001\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0088\u0001\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0011\u0010\u0089\u0001\u001a\u00020X2\b\u0010v\u001a\u0004\u0018\u00010\bJ\u0007\u0010\u008a\u0001\u001a\u00020XJ\u0007\u0010\u008b\u0001\u001a\u00020XJ\u0007\u0010\u008c\u0001\u001a\u00020XJ\u000f\u0010\u008d\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u0005J\u0017\u0010\u008e\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005J\u000f\u0010\u008f\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u0005J\u0018\u0010\u0090\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u0091\u0001\u001a\u00020\u0005J\u000f\u0010\u0092\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u0005J\u000f\u0010\u0093\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0005J\u000f\u0010\u0094\u0001\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005J\u001a\u0010\u0095\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\bJ\u000f\u0010\u0097\u0001\u001a\u00020\b2\u0006\u0010`\u001a\u00020\u0005J\u0018\u0010\u0098\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u0099\u0001\u001a\u00020 J\u000f\u0010\u009a\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u0018\u0010\u009b\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020 J\u000f\u0010\u009d\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u0018\u0010\u009e\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009f\u0001\u001a\u00020\u0005J\u000f\u0010 \u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0005J\u0007\u0010¡\u0001\u001a\u00020 J\u000f\u0010¢\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u001c\u0010£\u0001\u001a\u00020X2\u0007\u0010¤\u0001\u001a\u00020\u00052\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001J\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010`\u001a\u00020\u0005J\u0013\u0010¨\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001J\u0013\u0010«\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001J\u0013\u0010¬\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010\u00ad\u0001J\u0013\u0010®\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010\u00ad\u0001J\u0013\u0010¯\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010°\u0001J\u0013\u0010±\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010°\u0001J\u0016\u0010²\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010³\u00010l¢\u0006\u0003\u0010´\u0001J\u0016\u0010µ\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010³\u00010l¢\u0006\u0003\u0010´\u0001J\u0016\u0010¶\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010³\u00010l¢\u0006\u0003\u0010´\u0001J\u0016\u0010·\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010³\u00010l¢\u0006\u0003\u0010´\u0001J\u0007\u0010¸\u0001\u001a\u00020XJ\u0007\u0010¹\u0001\u001a\u00020XJ\u0013\u0010º\u0001\u001a\u00020X2\n\u0010»\u0001\u001a\u0005\u0018\u00010³\u0001J\u0013\u0010¼\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010½\u0001J\u0013\u0010¾\u0001\u001a\u00020X2\n\u0010©\u0001\u001a\u0005\u0018\u00010½\u0001J\u0012\u0010¿\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010À\u0001\u001a\u00020\u0005J#\u0010Á\u0001\u001a\u00020X2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aJ\u0012\u0010Â\u0001\u001a\u00020X2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\bJ\u0011\u0010Ä\u0001\u001a\u00020X2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0007\u0010Å\u0001\u001a\u00020XJ\u0007\u0010Æ\u0001\u001a\u00020XJ\u0010\u0010Æ\u0001\u001a\u00020X2\u0007\u0010Ç\u0001\u001a\u00020 J\u0018\u0010È\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010É\u0001\u001a\u00020 J\u000f\u0010Ê\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u0007\u0010Ë\u0001\u001a\u00020 J\u0007\u0010Ì\u0001\u001a\u00020 J\u0013\u0010Ì\u0001\u001a\u00020 2\n\u0010»\u0001\u001a\u0005\u0018\u00010³\u0001J\u0018\u0010Í\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010Î\u0001\u001a\u00020 J\u000f\u0010Ï\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u001b\u0010Ð\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001J\u0012\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00012\u0006\u0010`\u001a\u00020\u0005J\u0018\u0010Ô\u0001\u001a\u00020X2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020 J\u000f\u0010Õ\u0001\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005J\u0007\u0010Ö\u0001\u001a\u00020 J\u0012\u0010×\u0001\u001a\u00020X2\u0007\u0010Ø\u0001\u001a\u00020\u0005H\u0002J\n\u0010Ù\u0001\u001a\u00020XH\u0082 J0\u0010Ú\u0001\u001a\u00020\u00052\t\u0010Û\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\bH\u0082 J:\u0010Ý\u0001\u001a\u00020\u00052\t\u0010Û\u0001\u001a\u0004\u0018\u00010\b2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0082 J\n\u0010Þ\u0001\u001a\u00020\u0005H\u0082 J\n\u0010ß\u0001\u001a\u00020\u0005H\u0082 J\n\u0010à\u0001\u001a\u00020\u0010H\u0082 J\u0014\u0010á\u0001\u001a\u00020 2\b\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0082 J\n\u0010â\u0001\u001a\u00020 H\u0082 J\u0014\u0010ã\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010]\u001a\u00020\u0005H\u0082 J\u001e\u0010ä\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0082 J\u0012\u0010å\u0001\u001a\u00020\u00052\u0006\u0010_\u001a\u00020 H\u0082 J\u001a\u0010æ\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u00052\u0006\u0010_\u001a\u00020 H\u0082 J\u0014\u0010ç\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010b\u001a\u00020\u0005H\u0082 J\u0014\u0010è\u0001\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010\u0019H\u0082 J%\u0010é\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010À\u0001\u001a\u00020\u00052\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0082 J-\u0010ê\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010À\u0001\u001a\u00020\u00052\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020g2\u0006\u0010H\u001a\u00020gH\u0082 J7\u0010ë\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0007\u0010À\u0001\u001a\u00020\u00052\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0082 J?\u0010ì\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0007\u0010À\u0001\u001a\u00020\u00052\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020g2\u0006\u0010H\u001a\u00020gH\u0082 JF\u0010í\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0007\u0010À\u0001\u001a\u00020\u00052\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010l2\u0007\u0010î\u0001\u001a\u00020\u0005H\u0082 ¢\u0006\u0003\u0010ï\u0001J9\u0010ð\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a2\u0007\u0010À\u0001\u001a\u00020\u00052\b\u0010p\u001a\u0004\u0018\u00010:2\u0006\u0010q\u001a\u00020 H\u0082 J\n\u0010ñ\u0001\u001a\u00020\u0005H\u0082 J\u0014\u0010ò\u0001\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010$H\u0082 J\u0015\u0010ó\u0001\u001a\u00020 2\t\u0010ô\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\f\u0010õ\u0001\u001a\u0004\u0018\u00010$H\u0082 J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010÷\u0001\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0005H\u0082 J\n\u0010ø\u0001\u001a\u00020\u0005H\u0082 J\u0012\u0010ù\u0001\u001a\u00020 2\u0006\u00105\u001a\u00020\u0005H\u0082 J\n\u0010ú\u0001\u001a\u00020\u0005H\u0082 J\n\u0010û\u0001\u001a\u00020 H\u0082 J\f\u0010ü\u0001\u001a\u0004\u0018\u00010:H\u0082 J\n\u0010ý\u0001\u001a\u00020 H\u0082 J\n\u0010þ\u0001\u001a\u00020 H\u0082 J\u001e\u0010ÿ\u0001\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\b2\b\u0010w\u001a\u0004\u0018\u00010\bH\u0082 J\u001c\u0010\u0080\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\b2\u0006\u0010w\u001a\u00020\u0005H\u0082 J3\u0010\u0081\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\b2\u000e\u0010w\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010l2\u0007\u0010\u0082\u0002\u001a\u00020\u0005H\u0082 ¢\u0006\u0003\u0010\u0083\u0002J'\u0010\u0084\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\b2\b\u0010w\u001a\u0004\u0018\u00010{2\u0007\u0010\u0082\u0002\u001a\u00020\u0005H\u0082 J\u0016\u0010\u0085\u0002\u001a\u0004\u0018\u00010\b2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u0086\u0002\u001a\u00020\u00052\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\"\u0010\u0087\u0002\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010l2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 ¢\u0006\u0003\u0010\u0080\u0001J\u0016\u0010\u0088\u0002\u001a\u0004\u0018\u00010{2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u0089\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008a\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008b\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008c\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008d\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008e\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u008f\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\u0014\u0010\u0090\u0002\u001a\u00020 2\b\u0010v\u001a\u0004\u0018\u00010\bH\u0082 J\n\u0010\u0091\u0002\u001a\u00020 H\u0082 J\n\u0010\u0092\u0002\u001a\u00020 H\u0082 J\u0012\u0010\u0093\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001a\u0010\u0094\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005H\u0082 J\u0012\u0010\u0095\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001b\u0010\u0096\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u0091\u0001\u001a\u00020\u0005H\u0082 J\u0012\u0010\u0097\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\n\u0010\u0098\u0002\u001a\u00020\u0005H\u0082 J\u0012\u0010\u0099\u0002\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u0012\u0010\u009a\u0002\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u0005H\u0082 J\n\u0010\u009b\u0002\u001a\u00020\u0005H\u0082 J\u001d\u0010\u009c\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010\u009d\u0002\u001a\u00020\b2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001b\u0010\u009e\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009f\u0002\u001a\u00020 H\u0082 J\u0012\u0010 \u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u0016\u0010¡\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010°\u0001H\u0082 J\u0016\u0010¢\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010°\u0001H\u0082 J\n\u0010£\u0002\u001a\u00020 H\u0082 J\n\u0010¤\u0002\u001a\u00020 H\u0082 J\u001b\u0010¥\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0018\u00010lH\u0082 ¢\u0006\u0003\u0010´\u0001J\u001b\u0010¦\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0018\u00010lH\u0082 ¢\u0006\u0003\u0010´\u0001J\u001b\u0010§\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0018\u00010lH\u0082 ¢\u0006\u0003\u0010´\u0001J\u001b\u0010¨\u0002\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0018\u00010lH\u0082 ¢\u0006\u0003\u0010´\u0001J\u0012\u0010©\u0002\u001a\u00020X2\u0006\u0010C\u001a\u00020\u0005H\u0082 J\n\u0010ª\u0002\u001a\u00020\u0005H\u0082 J\n\u0010«\u0002\u001a\u00020XH\u0082 J\n\u0010¬\u0002\u001a\u00020XH\u0082 J\u0016\u0010\u00ad\u0002\u001a\u00020 2\n\u0010»\u0001\u001a\u0005\u0018\u00010³\u0001H\u0082 J\u0016\u0010®\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010½\u0001H\u0082 J\u0016\u0010¯\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010½\u0001H\u0082 J\u001e\u0010°\u0002\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020:\u0018\u0001`\u001aH\u0082 J'\u0010±\u0002\u001a\u00020 2\u001b\u0010²\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0082 J'\u0010³\u0002\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020:\u0018\u0001`\u001a2\u0007\u0010À\u0001\u001a\u00020\u0005H\u0082 J\u001b\u0010´\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020 H\u0082 J\u0012\u0010µ\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001b\u0010¶\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010·\u0002\u001a\u00020\u0005H\u0082 J\u0012\u0010¸\u0002\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u0005H\u0082 J\n\u0010¹\u0002\u001a\u00020 H\u0082 J\u0012\u0010º\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001f\u0010»\u0002\u001a\u00020 2\u0007\u0010¤\u0001\u001a\u00020\u00052\n\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0082 J\u0014\u0010¼\u0002\u001a\u0004\u0018\u00010\b2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u0014\u0010½\u0002\u001a\u00020 2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\n\u0010¾\u0002\u001a\u00020 H\u0082 J\u0013\u0010¿\u0002\u001a\u00020 2\u0007\u0010À\u0002\u001a\u00020 H\u0082 J\u0014\u0010Á\u0002\u001a\u00020 2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J\u0015\u0010Â\u0002\u001a\u00020 2\t\u0010ô\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\f\u0010Ã\u0002\u001a\u0004\u0018\u00010\bH\u0082 J\n\u0010Ä\u0002\u001a\u00020 H\u0082 J\n\u0010Å\u0002\u001a\u00020 H\u0082 J\u0014\u0010Æ\u0002\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010$H\u0082 J\n\u0010Ç\u0002\u001a\u00020$H\u0082 J\u0012\u0010È\u0002\u001a\u00020 2\u0006\u0010P\u001a\u00020 H\u0082 J\n\u0010É\u0002\u001a\u00020 H\u0082 J\u0012\u0010Ê\u0002\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0005H\u0082 J\n\u0010Ë\u0002\u001a\u00020\u0005H\u0082 J\u001b\u0010Ì\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010É\u0001\u001a\u00020 H\u0082 J\u0012\u0010Í\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u0016\u0010Î\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0082 J\u0016\u0010Ï\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0082 J\u0016\u0010Ð\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0082 J\u0016\u0010Ñ\u0002\u001a\u00020 2\n\u0010©\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0082 J\n\u0010Ò\u0002\u001a\u00020 H\u0082 J\n\u0010Ó\u0002\u001a\u00020 H\u0082 J\u0016\u0010Ô\u0002\u001a\u00020 2\n\u0010»\u0001\u001a\u0005\u0018\u00010³\u0001H\u0082 J\n\u0010Õ\u0002\u001a\u00020 H\u0082 J\n\u0010Ö\u0002\u001a\u00020 H\u0082 J\u001b\u0010×\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010Î\u0001\u001a\u00020 H\u0082 J\u0012\u0010Ø\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 J\u001c\u0010Ù\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0082 J\u001c\u0010Ú\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0082 J\u001b\u0010Û\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020 H\u0082 J\u0012\u0010Ü\u0002\u001a\u00020 2\u0006\u0010`\u001a\u00020\u0005H\u0082 R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b/\u0010)R(\u00101\u001a\u0004\u0018\u00010$2\b\u00100\u001a\u0004\u0018\u00010$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010&\"\u0004\b3\u00104R&\u00106\u001a\u00020\u00052\b\b\u0001\u00105\u001a\u00020\u00058G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010-R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b=\u0010!R%\u0010>\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020:\u0018\u0001`\u001a8F¢\u0006\u0006\u001a\u0004\b?\u0010\u001cR\u0011\u0010@\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bA\u0010\u0012R\u0011\u0010B\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bB\u0010!R$\u0010C\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0012\"\u0004\bE\u0010-R%\u0010F\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020:\u0018\u0001`\u001a8F¢\u0006\u0006\u001a\u0004\bG\u0010\u001cR$\u0010I\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0012\"\u0004\bK\u0010-R\u0011\u0010L\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bL\u0010!R\u0011\u0010M\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bN\u0010\u0012R\u0011\u0010O\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bO\u0010!R$\u0010Q\u001a\u00020 2\u0006\u0010P\u001a\u00020 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010!\"\u0004\bR\u0010S¨\u0006ä\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "", "context", "Landroid/content/Context;", "width", "", "height", "filePath", "", "<init>", "(Landroid/content/Context;IILjava/lang/String;)V", "password", "mode", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V", "mContext", "mHandle", "", "getWidth", "()I", "getHeight", "lastEditedTime", "getLastEditedTime", "()J", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "getObjectList", "()Ljava/util/ArrayList;", "orientation", "getOrientation", "isObjectLoaded", "", "()Z", "isAllObjectsLoaded", "backgroundImage", "Landroid/graphics/Bitmap;", "getBackgroundImage", "()Landroid/graphics/Bitmap;", "backgroundImagePath", "getBackgroundImagePath", "()Ljava/lang/String;", "backgroundImageMode", "getBackgroundImageMode", "setBackgroundImageMode", "(I)V", "foregroundImagePath", "getForegroundImagePath", "bitmap", "foregroundImage", "getForegroundImage", "setForegroundImage", "(Landroid/graphics/Bitmap;)V", "color", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "drawnRectOfAllObject", "Landroid/graphics/RectF;", "getDrawnRectOfAllObject", "()Landroid/graphics/RectF;", "isChanged", "historyUpdateRect", "getHistoryUpdateRect", "layerCount", "getLayerCount", "isRedoable", "undoLimit", "getUndoLimit", "setUndoLimit", "objectRectList", "getObjectRectList", "threshold", "anchorImageThreshold", "getAnchorImageThreshold", "setAnchorImageThreshold", "isGroupingHistory", "currentLayerId", "getCurrentLayerId", "isUndoable", "replayable", "isReplayable", "setReplayable", "(Z)V", "equals", "other", "hashCode", "finalize", "", "appendObject", "obj", "removeAllObject", "getObject", "index", "getObjectCount", "includeInvisible", "id", "getObjectByRuntimeHandle", "runtimeHandle", "getObjectIndex", "isObjectContained", "findTopObjectAtPosition", "x", "", "y", "findObjectAtPosition", "findObjectInClosedCurve", "points", "", "Landroid/graphics/PointF;", "([Landroid/graphics/PointF;)Ljava/util/ArrayList;", "findObjectInRect", "rectf", "allAreas", "setVolatileBackgroundImage", "setBackgroundImage", "hasBackgroundImage", "setExtraDataString", "key", "value", "setExtraDataStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "setExtraDataByteArray", "", "setExtraDataInt", "getExtraDataString", "getExtraDataInt", "getExtraDataStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "getExtraDataByteArray", "hasExtraDataString", "hasExtraDataInt", "hasExtraDataStringArray", "hasExtraDataByteArray", "removeExtraDataString", "removeExtraDataInt", "removeExtraDataStringArray", "removeExtraDataByteArray", "loadObject", "loadAllObjects", "unloadObject", "appendLayer", "insertLayer", "removeLayer", "moveLayerIndex", "step", "setCurrentLayer", "getLayerIndex", "getLayerIdByIndex", "setLayerName", "name", "getLayerName", "setLayerEventForwardEnabled", "enable", "isLayerEventForwardEnabled", "setLayerVisibility", "visible", "isLayerVisible", "setLayerTransparency", "alpha", "getLayerTransparency", "hasDirtyBitmap", "isLayerHasDirtyBitmap", "mergeLayers", "destId", "srcIdList", "", "getLayerThumbnailPath", "registerPageEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingPageEventListener;", "deregisterPageEventListener", "registerLayerEventListener", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingLayerEventListener;", "deregisterLayerEventListener", "registerObjectListener", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ObjectListener;", "deregisterObjectListener", "undo", "Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "()[Lcom/samsung/android/sdk/pen/document/SpenHistoryUpdateInfo;", "redo", "undoAll", "redoAll", "clearHistory", "clearRedoHistory", "commitHistory", "userData", "registerHistoryListener", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$HistoryListener;", "deregisterHistoryListener", "createObject", "type", "appendObjectList", "save", "filepath", "attachToFile", ClientCookie.DISCARD_ATTR, "close", "removeCache", "setLayerLockState", "flagLock", "getLayerLockState", "beginHistoryGroup", "endHistoryGroup", "setLayerAlphaLock", "alphaLock", "isLayerAlphaLock", "setLayerShadowEffect", "effect", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ShadowEffect;", "getLayerShadowEffect", "setLayerShadowEffectVisibility", "isLayerShadowEffectVisible", "cancelHistoryGroup", "throwUncheckedException", "errno", "PaintingDoc_finalize", "PaintingDoc_Construct1", "cacheDirPath", "bgPath", "PaintingDoc_Construct2", "PaintingDoc_GetWidth", "PaintingDoc_GetHeight", "PaintingDoc_GetLastEditedTime", "PaintingDoc_AppendObject", "PaintingDoc_RemoveAllObject", "PaintingDoc_GetObject", "PaintingDoc_GetObjectList", "PaintingDoc_GetObjectCount", "PaintingDoc_GetObjectCount2", "PaintingDoc_GetObjectByRuntimeHandle", "PaintingDoc_GetObjectIndex", "PaintingDoc_FindTopObjectAtPosition", "PaintingDoc_FindTopObjectAtPositionWithThreshold", "PaintingDoc_FindObjectAtPosition", "PaintingDoc_FindObjectAtPositionWithThreshold", "PaintingDoc_FindObjectInClosedCurve", "length", "(I[Landroid/graphics/PointF;I)Ljava/util/ArrayList;", "PaintingDoc_FindObjectInRect", "PaintingDoc_GetOrientation", "PaintingDoc_SetVolatileBackgroundImage", "PaintingDoc_SetBackgroundImage", "sourceUri", "PaintingDoc_GetBackgroundImage", "PaintingDoc_GetBackgroundImagePath", "PaintingDoc_SetBackgroundImageMode", "PaintingDoc_GetBackgroundImageMode", "PaintingDoc_SetBackgroundColor", "PaintingDoc_GetBackgroundColor", "PaintingDoc_HasBackgroundImage", "PaintingDoc_GetRectOfAllObject", "PaintingDoc_IsChanged", "PaintingDoc_IsObjectLoaded", "PaintingDoc_SetExtraDataString", "PaintingDoc_SetExtraDataInt", "PaintingDoc_SetExtraDataStringArray", "valueCount", "(Ljava/lang/String;[Ljava/lang/String;I)Z", "PaintingDoc_SetExtraDataByteArray", "PaintingDoc_GetExtraDataString", "PaintingDoc_GetExtraDataInt", "PaintingDoc_GetExtraDataStringArray", "PaintingDoc_GetExtraDataByteArray", "PaintingDoc_HasExtraDataString", "PaintingDoc_HasExtraDataInt", "PaintingDoc_HasExtraDataStringArray", "PaintingDoc_HasExtraDataByteArray", "PaintingDoc_RemoveExtraDataString", "PaintingDoc_RemoveExtraDataInt", "PaintingDoc_RemoveExtraDataStringArray", "PaintingDoc_RemoveExtraDataByteArray", "PaintingDoc_LoadObject", "PaintingDoc_UnloadObject", "PaintingDoc_AppendLayer", "PaintingDoc_InsertLayer", "PaintingDoc_RemoveLayer", "PaintingDoc_MoveLayerIndex", "PaintingDoc_SetCurrentLayer", "PaintingDoc_GetCurrentLayerId", "PaintingDoc_GetLayerIndex", "PaintingDoc_GetLayerIdByIndex", "PaintingDoc_GetLayerCount", "PaintingDoc_SetLayerName", "PaintingDoc_GetLayerName", "PaintingDoc_EnableLayerEventForward", "flag", "PaintingDoc_IsLayerEventForwardable", "PaintingDoc_RegisterObjectListener", "PaintingDoc_DeregisterObjectListener", "PaintingDoc_isUndoable", "PaintingDoc_isRedoable", "PaintingDoc_undo", "PaintingDoc_redo", "PaintingDoc_undoAll", "PaintingDoc_redoAll", "PaintingDoc_setUndoLimit", "PaintingDoc_getUndoLimit", "PaintingDoc_clearHistory", "PaintingDoc_clearRedoHistory", "PaintingDoc_commitHistory", "PaintingDoc_registerHistoryListener", "PaintingDoc_deregisterHistoryListener", "PaintingDoc_GetHistoryUpdateRect", "PaintingDoc_AppendObjectList", XmlErrorCodes.LIST, "PaintingDoc_GetObjectRectList", "PaintingDoc_setLayerVisibility", "PaintingDoc_isLayerVisible", "PaintingDoc_SetLayerTransparency", "transparency", "PaintingDoc_GetLayerTransparency", "PaintingDoc_HasDirtyBitmap", "PaintingDoc_IsLayerHasDirtyBitmap", "PaintingDoc_MergeLayers", "PaintingDoc_GetLayerThumbnailPath", "PaintingDoc_save", "PaintingDoc_discard", "PaintingDoc_close", "clearCache", "PaintingDoc_attachToFile", "PaintingDoc_SetForegroundImage", "PaintingDoc_GetForegroundImagePath", "PaintingDoc_LoadAllObjects", "PaintingDoc_IsAllObjectsLoaded", "PaintingDoc_SetForegroundImage2", "PaintingDoc_GetForegroundImage", "PaintingDoc_SetReplayable", "PaintingDoc_IsReplayable", "PaintingDoc_SetAnchorImageThreshold", "PaintingDoc_GetAnchorImageThreshold", "PaintingDoc_SetLayerLockState", "PaintingDoc_GetLayerLockState", "PaintingDoc_RegisterPageEventListener", "PaintingDoc_DeregisterPageEventListener", "PaintingDoc_RegisterLayerEventListener", "PaintingDoc_DeregisterLayerEventListener", "PaintingDoc_BeginHistoryGroup", "PaintingDoc_EndHistoryGroup", "PaintingDoc_EndHistoryGroup2", "PaintingDoc_CancelHistoryGroup", "PaintingDoc_IsGroupingHistory", "PaintingDoc_SetLayerAlphaLock", "PaintingDoc_IsLayerAlphaLock", "PaintingDoc_SetLayerShadowEffect", "PaintingDoc_GetLayerShadowEffect", "PaintingDoc_SetLayerShadowEffectVisibility", "PaintingDoc_IsLayerShadowEffectVisible", "ShadowEffect", "PaintingPageEventListener", "PaintingLayerEventListener", "ObjectListener", "ObjectEventListener", "HistoryListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaintingDoc.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaintingDoc.kt\ncom/samsung/android/sdk/pen/document/SpenPaintingDoc\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2879:1\n1#2:2880\n*E\n"})
public final class SpenPaintingDoc {
    public static final int BACKGROUND_IMAGE_MODE_CENTER = 0;
    public static final int BACKGROUND_IMAGE_MODE_FIT = 2;
    public static final int BACKGROUND_IMAGE_MODE_STRETCH = 1;
    public static final int BACKGROUND_IMAGE_MODE_TILE = 3;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int FIND_TYPE_ALL = 255;
    private static final int FIND_TYPE_STROKE = 1;
    public static final int HISTORY_MANAGER_MODE_MULTIPLE_VIEW = 1;
    public static final int HISTORY_MANAGER_MODE_SINGLE_VIEW = 0;
    public static final int MODE_READ_ONLY = 0;
    public static final int MODE_WRITABLE = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;

    @Nullable
    private Context mContext;
    private long mHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$Companion;", "", "<init>", "()V", "MODE_READ_ONLY", "", "MODE_WRITABLE", "FIND_TYPE_STROKE", "FIND_TYPE_ALL", "ORIENTATION_PORTRAIT", "ORIENTATION_LANDSCAPE", "HISTORY_MANAGER_MODE_SINGLE_VIEW", "HISTORY_MANAGER_MODE_MULTIPLE_VIEW", "BACKGROUND_IMAGE_MODE_CENTER", "BACKGROUND_IMAGE_MODE_STRETCH", "BACKGROUND_IMAGE_MODE_FIT", "BACKGROUND_IMAGE_MODE_TILE", "isBuildTypeEngMode", "", "()Z", "isValid", "filePath", "", "getHeight", "getWidth", "PaintingDoc_IsValid", "PaintingDoc_GetSizeHeight", "PaintingDoc_GetSizeWidth", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final int PaintingDoc_GetSizeHeight(String filePath) {
            return SpenPaintingDoc.PaintingDoc_GetSizeHeight(filePath);
        }

        @JvmStatic
        private final int PaintingDoc_GetSizeWidth(String filePath) {
            return SpenPaintingDoc.PaintingDoc_GetSizeWidth(filePath);
        }

        @JvmStatic
        private final boolean PaintingDoc_IsValid(String filePath) {
            return SpenPaintingDoc.PaintingDoc_IsValid(filePath);
        }

        private final boolean isBuildTypeEngMode() {
            return Intrinsics.areEqual("eng", Build.TYPE);
        }

        @JvmStatic
        public final int getHeight(@Nullable String filePath) {
            int iPaintingDoc_GetSizeHeight = PaintingDoc_GetSizeHeight(filePath);
            if (iPaintingDoc_GetSizeHeight == -1) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            }
            return iPaintingDoc_GetSizeHeight;
        }

        @JvmStatic
        public final int getWidth(@Nullable String filePath) {
            int iPaintingDoc_GetSizeWidth = PaintingDoc_GetSizeWidth(filePath);
            if (iPaintingDoc_GetSizeWidth == -1) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            }
            return iPaintingDoc_GetSizeWidth;
        }

        public final boolean isValid(@Nullable String filePath) {
            return PaintingDoc_IsValid(filePath);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$HistoryListener;", "", "onCommit", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "onUndoable", "undoable", "", "onRedoable", "redoable", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface HistoryListener {
        void onCommit(@NotNull SpenPaintingDoc paintingDoc);

        void onRedoable(@NotNull SpenPaintingDoc paintingDoc, boolean redoable);

        void onUndoable(@NotNull SpenPaintingDoc paintingDoc, boolean undoable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ObjectEventListener;", "", "onAdd", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "inputType", "", "onRemove", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ObjectEventListener {
        @Nullable
        boolean[] onAdd(@Nullable SpenPaintingDoc paintingDoc, @Nullable int[] inputType);

        @Nullable
        boolean[] onRemove(@Nullable SpenPaintingDoc paintingDoc, @Nullable int[] inputType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000bH&J6\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ObjectListener;", "", "onObjectAdded", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "type", "", "onObjectRemoved", "onObjectChanged", "objectChangedInfo", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ObjectListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_REDO = 2;
        public static final int TYPE_SET = 0;
        public static final int TYPE_UNDO = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ObjectListener$Companion;", "", "<init>", "()V", "TYPE_SET", "", "TYPE_UNDO", "TYPE_REDO", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int TYPE_REDO = 2;
            public static final int TYPE_SET = 0;
            public static final int TYPE_UNDO = 1;

            private Companion() {
            }
        }

        void onObjectAdded(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<SpenObjectBase> objectList, int type);

        void onObjectChanged(@Nullable SpenPaintingDoc paintingDoc, @Nullable SpenObjectChangedInfo objectChangedInfo, int type);

        void onObjectRemoved(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<SpenObjectBase> objectList, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J:\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\r2\u0006\u0010\b\u001a\u00020\tH&Jz\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\r2\u001e\u0010\u0010\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\r2\u0006\u0010\b\u001a\u00020\tH&J:\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\r2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingLayerEventListener;", "", "onLayerInserted", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "info", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenLayerInsertedInfo;", "type", "", "onLayerRemoved", "layerIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onLayerIndexMoved", "beforeIndexList", "afterIndexList", "onLayerChanged", "changedInfoList", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenLayerChangedInfo;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PaintingLayerEventListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_COMMIT = 0;
        public static final int TYPE_REDO = 2;
        public static final int TYPE_REMOVE = 3;
        public static final int TYPE_SUBMIT = 4;
        public static final int TYPE_UNDO = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingLayerEventListener$Companion;", "", "<init>", "()V", "TYPE_COMMIT", "", "TYPE_UNDO", "TYPE_REDO", "TYPE_REMOVE", "TYPE_SUBMIT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int TYPE_COMMIT = 0;
            public static final int TYPE_REDO = 2;
            public static final int TYPE_REMOVE = 3;
            public static final int TYPE_SUBMIT = 4;
            public static final int TYPE_UNDO = 1;

            private Companion() {
            }
        }

        void onLayerChanged(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<SpenLayerChangedInfo> changedInfoList, int type);

        void onLayerIndexMoved(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<Integer> layerIdList, @Nullable ArrayList<Integer> beforeIndexList, @Nullable ArrayList<Integer> afterIndexList, int type);

        void onLayerInserted(@Nullable SpenPaintingDoc paintingDoc, @Nullable SpenLayerInsertedInfo info, int type);

        void onLayerRemoved(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<Integer> layerIdList, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ:\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingPageEventListener;", "", "onPageChanged", "", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "changedInfoList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenPageChangedInfo;", "Lkotlin/collections/ArrayList;", "type", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PaintingPageEventListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_COMMIT = 0;
        public static final int TYPE_REDO = 2;
        public static final int TYPE_REMOVE = 3;
        public static final int TYPE_SUBMIT = 4;
        public static final int TYPE_UNDO = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$PaintingPageEventListener$Companion;", "", "<init>", "()V", "TYPE_COMMIT", "", "TYPE_UNDO", "TYPE_REDO", "TYPE_REMOVE", "TYPE_SUBMIT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int TYPE_COMMIT = 0;
            public static final int TYPE_REDO = 2;
            public static final int TYPE_REMOVE = 3;
            public static final int TYPE_SUBMIT = 4;
            public static final int TYPE_UNDO = 1;

            private Companion() {
            }
        }

        void onPageChanged(@Nullable SpenPaintingDoc paintingDoc, @Nullable ArrayList<SpenPageChangedInfo> changedInfoList, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc$ShadowEffect;", "", "<init>", "()V", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/PointF;", "variance", "", "color", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ShadowEffect {

        @JvmField
        public float variance;

        @JvmField
        @NotNull
        public PointF offset = new PointF(0.0f, 0.0f);

        @ColorInt
        @JvmField
        public int color = -16777216;
    }

    public SpenPaintingDoc(@Nullable Context context, int i, int i2, @Nullable String str) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context");
        }
        this.mContext = context;
        if (((str == null || str.length() == 0 || !INSTANCE.isValid(str)) ? PaintingDoc_Construct1(context.getFilesDir().getAbsolutePath(), i, i2, null) : PaintingDoc_Construct2(context.getFilesDir().getAbsolutePath(), str, null, i, 1)) == 0) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error != 19) {
                SpenError.ThrowUncheckedException(SpenError.getError());
                return;
            }
            throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
        }
    }

    private final native boolean PaintingDoc_AppendLayer(int id);

    private final native boolean PaintingDoc_AppendObject(SpenObjectBase obj);

    private final native boolean PaintingDoc_AppendObjectList(ArrayList<SpenObjectBase> list);

    private final native boolean PaintingDoc_BeginHistoryGroup();

    private final native boolean PaintingDoc_CancelHistoryGroup();

    private final native int PaintingDoc_Construct1(String cacheDirPath, int width, int height, String bgPath);

    private final native int PaintingDoc_Construct2(String cacheDirPath, String filepath, String password, int width, int mode);

    private final native boolean PaintingDoc_DeregisterLayerEventListener(PaintingLayerEventListener listener);

    private final native boolean PaintingDoc_DeregisterObjectListener(ObjectListener listener);

    private final native boolean PaintingDoc_DeregisterPageEventListener(PaintingPageEventListener listener);

    private final native boolean PaintingDoc_EnableLayerEventForward(int id, boolean flag);

    private final native boolean PaintingDoc_EndHistoryGroup();

    private final native boolean PaintingDoc_EndHistoryGroup2(SpenHistoryUpdateInfo userData);

    private final native ArrayList<SpenObjectBase> PaintingDoc_FindObjectAtPosition(int type, float x, float y2);

    private final native ArrayList<SpenObjectBase> PaintingDoc_FindObjectAtPositionWithThreshold(int type, float x, float y2, float threshold);

    private final native ArrayList<SpenObjectBase> PaintingDoc_FindObjectInClosedCurve(int type, PointF[] points, int length);

    private final native ArrayList<SpenObjectBase> PaintingDoc_FindObjectInRect(int type, RectF rectf, boolean allAreas);

    private final native SpenObjectBase PaintingDoc_FindTopObjectAtPosition(int type, float x, float y2);

    private final native SpenObjectBase PaintingDoc_FindTopObjectAtPositionWithThreshold(int type, float x, float y2, float threshold);

    private final native int PaintingDoc_GetAnchorImageThreshold();

    private final native int PaintingDoc_GetBackgroundColor();

    private final native Bitmap PaintingDoc_GetBackgroundImage();

    private final native int PaintingDoc_GetBackgroundImageMode();

    private final native String PaintingDoc_GetBackgroundImagePath();

    private final native int PaintingDoc_GetCurrentLayerId();

    private final native byte[] PaintingDoc_GetExtraDataByteArray(String key);

    private final native int PaintingDoc_GetExtraDataInt(String key);

    private final native String PaintingDoc_GetExtraDataString(String key);

    private final native String[] PaintingDoc_GetExtraDataStringArray(String key);

    private final native Bitmap PaintingDoc_GetForegroundImage();

    private final native String PaintingDoc_GetForegroundImagePath();

    private final native int PaintingDoc_GetHeight();

    private final native ArrayList<RectF> PaintingDoc_GetHistoryUpdateRect();

    private final native long PaintingDoc_GetLastEditedTime();

    private final native int PaintingDoc_GetLayerCount();

    private final native int PaintingDoc_GetLayerIdByIndex(int index);

    private final native int PaintingDoc_GetLayerIndex(int id);

    private final native boolean PaintingDoc_GetLayerLockState(int id);

    private final native String PaintingDoc_GetLayerName(int id);

    private final native boolean PaintingDoc_GetLayerShadowEffect(int id, ShadowEffect effect);

    private final native String PaintingDoc_GetLayerThumbnailPath(int id);

    private final native int PaintingDoc_GetLayerTransparency(int id);

    private final native SpenObjectBase PaintingDoc_GetObject(int index);

    private final native SpenObjectBase PaintingDoc_GetObjectByRuntimeHandle(int runtimeHandle);

    private final native int PaintingDoc_GetObjectCount(boolean includeInvisible);

    private final native int PaintingDoc_GetObjectCount2(int id, boolean includeInvisible);

    private final native int PaintingDoc_GetObjectIndex(SpenObjectBase obj);

    private final native ArrayList<SpenObjectBase> PaintingDoc_GetObjectList();

    private final native ArrayList<RectF> PaintingDoc_GetObjectRectList(int type);

    private final native int PaintingDoc_GetOrientation();

    private final native RectF PaintingDoc_GetRectOfAllObject();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int PaintingDoc_GetSizeHeight(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int PaintingDoc_GetSizeWidth(String str);

    private final native int PaintingDoc_GetWidth();

    private final native boolean PaintingDoc_HasBackgroundImage();

    private final native boolean PaintingDoc_HasDirtyBitmap();

    private final native boolean PaintingDoc_HasExtraDataByteArray(String key);

    private final native boolean PaintingDoc_HasExtraDataInt(String key);

    private final native boolean PaintingDoc_HasExtraDataString(String key);

    private final native boolean PaintingDoc_HasExtraDataStringArray(String key);

    private final native boolean PaintingDoc_InsertLayer(int id, int index);

    private final native boolean PaintingDoc_IsAllObjectsLoaded();

    private final native boolean PaintingDoc_IsChanged();

    private final native boolean PaintingDoc_IsGroupingHistory();

    private final native boolean PaintingDoc_IsLayerAlphaLock(int id);

    private final native boolean PaintingDoc_IsLayerEventForwardable(int id);

    private final native boolean PaintingDoc_IsLayerHasDirtyBitmap(int id);

    private final native boolean PaintingDoc_IsLayerShadowEffectVisible(int id);

    private final native boolean PaintingDoc_IsObjectLoaded();

    private final native boolean PaintingDoc_IsReplayable();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean PaintingDoc_IsValid(String str);

    private final native boolean PaintingDoc_LoadAllObjects();

    private final native boolean PaintingDoc_LoadObject();

    private final native boolean PaintingDoc_MergeLayers(int destId, int[] srcIdList);

    private final native boolean PaintingDoc_MoveLayerIndex(int id, int step);

    private final native boolean PaintingDoc_RegisterLayerEventListener(PaintingLayerEventListener listener);

    private final native boolean PaintingDoc_RegisterObjectListener(ObjectListener listener);

    private final native boolean PaintingDoc_RegisterPageEventListener(PaintingPageEventListener listener);

    private final native boolean PaintingDoc_RemoveAllObject();

    private final native boolean PaintingDoc_RemoveExtraDataByteArray(String key);

    private final native boolean PaintingDoc_RemoveExtraDataInt(String key);

    private final native boolean PaintingDoc_RemoveExtraDataString(String key);

    private final native boolean PaintingDoc_RemoveExtraDataStringArray(String key);

    private final native boolean PaintingDoc_RemoveLayer(int id);

    private final native boolean PaintingDoc_SetAnchorImageThreshold(int threshold);

    private final native boolean PaintingDoc_SetBackgroundColor(int color);

    private final native boolean PaintingDoc_SetBackgroundImage(String sourceUri);

    private final native boolean PaintingDoc_SetBackgroundImageMode(int mode);

    private final native boolean PaintingDoc_SetCurrentLayer(int id);

    private final native boolean PaintingDoc_SetExtraDataByteArray(String key, byte[] value, int valueCount);

    private final native boolean PaintingDoc_SetExtraDataInt(String key, int value);

    private final native boolean PaintingDoc_SetExtraDataString(String key, String value);

    private final native boolean PaintingDoc_SetExtraDataStringArray(String key, String[] value, int valueCount);

    private final native boolean PaintingDoc_SetForegroundImage(String sourceUri);

    private final native boolean PaintingDoc_SetForegroundImage2(Bitmap bitmap);

    private final native boolean PaintingDoc_SetLayerAlphaLock(int id, boolean alphaLock);

    private final native boolean PaintingDoc_SetLayerLockState(int id, boolean flagLock);

    private final native boolean PaintingDoc_SetLayerName(int id, String name);

    private final native boolean PaintingDoc_SetLayerShadowEffect(int id, ShadowEffect effect);

    private final native boolean PaintingDoc_SetLayerShadowEffectVisibility(int id, boolean visible);

    private final native boolean PaintingDoc_SetLayerTransparency(int id, int transparency);

    private final native boolean PaintingDoc_SetReplayable(boolean replayable);

    private final native boolean PaintingDoc_SetVolatileBackgroundImage(Bitmap bitmap);

    private final native boolean PaintingDoc_UnloadObject();

    private final native boolean PaintingDoc_attachToFile(String filePath);

    private final native void PaintingDoc_clearHistory();

    private final native void PaintingDoc_clearRedoHistory();

    private final native boolean PaintingDoc_close(boolean clearCache);

    private final native boolean PaintingDoc_commitHistory(SpenHistoryUpdateInfo userData);

    private final native boolean PaintingDoc_deregisterHistoryListener(HistoryListener listener);

    private final native boolean PaintingDoc_discard();

    private final native void PaintingDoc_finalize();

    private final native int PaintingDoc_getUndoLimit();

    private final native boolean PaintingDoc_isLayerVisible(int id);

    private final native boolean PaintingDoc_isRedoable();

    private final native boolean PaintingDoc_isUndoable();

    private final native SpenHistoryUpdateInfo[] PaintingDoc_redo();

    private final native SpenHistoryUpdateInfo[] PaintingDoc_redoAll();

    private final native boolean PaintingDoc_registerHistoryListener(HistoryListener listener);

    private final native boolean PaintingDoc_save(String filePath);

    private final native boolean PaintingDoc_setLayerVisibility(int id, boolean visible);

    private final native void PaintingDoc_setUndoLimit(int undoLimit);

    private final native SpenHistoryUpdateInfo[] PaintingDoc_undo();

    private final native SpenHistoryUpdateInfo[] PaintingDoc_undoAll();

    @JvmStatic
    public static final int getHeight(@Nullable String str) {
        return INSTANCE.getHeight(str);
    }

    @JvmStatic
    public static final int getWidth(@Nullable String str) {
        return INSTANCE.getWidth(str);
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed");
    }

    public final void appendLayer(int id) {
        if (PaintingDoc_AppendLayer(id)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendObject(@Nullable SpenObjectBase obj) {
        if (obj == null || (obj.getType() != 1 && obj.getType() != 18)) {
            throwUncheckedException(7);
        }
        if (PaintingDoc_AppendObject(obj)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void appendObjectList(@Nullable ArrayList<SpenObjectBase> objectList) {
        if (PaintingDoc_AppendObjectList(objectList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void attachToFile(@Nullable String filePath) throws IOException {
        if (PaintingDoc_attachToFile(filePath)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 11) {
            throw new IOException();
        }
        if (error != 19) {
            SpenError.ThrowUncheckedException(SpenError.getError());
            return;
        }
        throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
    }

    public final boolean beginHistoryGroup() {
        return PaintingDoc_BeginHistoryGroup();
    }

    public final boolean cancelHistoryGroup() {
        return PaintingDoc_CancelHistoryGroup();
    }

    public final void clearHistory() {
        PaintingDoc_clearHistory();
    }

    public final void clearRedoHistory() {
        PaintingDoc_clearRedoHistory();
    }

    public final void close() throws IOException {
        if (this.mHandle == -1) {
            return;
        }
        if (!PaintingDoc_close(false)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1L;
        this.mContext = null;
    }

    public final void commitHistory(@Nullable SpenHistoryUpdateInfo userData) {
        if (PaintingDoc_commitHistory(userData)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final SpenObjectBase createObject(int type) {
        if (type == 1) {
            return SpenObjectFactory.createObject(type);
        }
        Log.w("SpenPaintingDoc", "createObject() - invalid object type[" + type + "]. TYPE_STROKE is allowed only");
        return null;
    }

    public final void deregisterHistoryListener(@Nullable HistoryListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Invalid listener");
        }
        if (PaintingDoc_deregisterHistoryListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void deregisterLayerEventListener(@Nullable PaintingLayerEventListener listener) {
        if (PaintingDoc_DeregisterLayerEventListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void deregisterObjectListener(@Nullable ObjectListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Invalid listener");
        }
        if (PaintingDoc_DeregisterObjectListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void deregisterPageEventListener(@Nullable PaintingPageEventListener listener) {
        if (PaintingDoc_DeregisterPageEventListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void discard() throws IOException {
        if (this.mHandle == -1) {
            return;
        }
        if (!PaintingDoc_discard()) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1L;
        this.mContext = null;
    }

    public final boolean endHistoryGroup() {
        return PaintingDoc_EndHistoryGroup();
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SpenPaintingDoc) && this.mHandle == ((SpenPaintingDoc) other).mHandle;
    }

    public final void finalize() {
        PaintingDoc_finalize();
        this.mHandle = -1L;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectAtPosition(float x, float y2) {
        ArrayList<SpenObjectBase> arrayListPaintingDoc_FindObjectAtPosition = PaintingDoc_FindObjectAtPosition(255, x, y2);
        if (arrayListPaintingDoc_FindObjectAtPosition == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListPaintingDoc_FindObjectAtPosition);
        return arrayListPaintingDoc_FindObjectAtPosition;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectInClosedCurve(@Nullable PointF[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ArrayList<SpenObjectBase> arrayListPaintingDoc_FindObjectInClosedCurve = PaintingDoc_FindObjectInClosedCurve(255, points, points.length);
        if (arrayListPaintingDoc_FindObjectInClosedCurve == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListPaintingDoc_FindObjectInClosedCurve);
        return arrayListPaintingDoc_FindObjectInClosedCurve;
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectInRect(@Nullable RectF rectf, boolean allAreas) {
        ArrayList<SpenObjectBase> arrayListPaintingDoc_FindObjectInRect = PaintingDoc_FindObjectInRect(255, rectf, allAreas);
        if (arrayListPaintingDoc_FindObjectInRect == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListPaintingDoc_FindObjectInRect);
        return arrayListPaintingDoc_FindObjectInRect;
    }

    @Nullable
    public final SpenObjectBase findTopObjectAtPosition(float x, float y2) {
        return PaintingDoc_FindTopObjectAtPosition(255, x, y2);
    }

    public final int getAnchorImageThreshold() {
        return PaintingDoc_GetAnchorImageThreshold();
    }

    @ColorInt
    public final int getBackgroundColor() {
        return PaintingDoc_GetBackgroundColor();
    }

    @Nullable
    public final Bitmap getBackgroundImage() {
        return PaintingDoc_GetBackgroundImage();
    }

    public final int getBackgroundImageMode() {
        return PaintingDoc_GetBackgroundImageMode();
    }

    @Nullable
    public final String getBackgroundImagePath() {
        return PaintingDoc_GetBackgroundImagePath();
    }

    public final int getCurrentLayerId() {
        return PaintingDoc_GetCurrentLayerId();
    }

    @Nullable
    public final RectF getDrawnRectOfAllObject() {
        return PaintingDoc_GetRectOfAllObject();
    }

    @Nullable
    public final byte[] getExtraDataByteArray(@Nullable String key) {
        return PaintingDoc_GetExtraDataByteArray(key);
    }

    public final int getExtraDataInt(@Nullable String key) {
        return PaintingDoc_GetExtraDataInt(key);
    }

    @Nullable
    public final String getExtraDataString(@Nullable String key) {
        return PaintingDoc_GetExtraDataString(key);
    }

    @Nullable
    public final String[] getExtraDataStringArray(@Nullable String key) {
        return PaintingDoc_GetExtraDataStringArray(key);
    }

    @Nullable
    public final Bitmap getForegroundImage() {
        return PaintingDoc_GetForegroundImage();
    }

    @Nullable
    public final String getForegroundImagePath() {
        return PaintingDoc_GetForegroundImagePath();
    }

    @Nullable
    public final ArrayList<RectF> getHistoryUpdateRect() {
        return PaintingDoc_GetHistoryUpdateRect();
    }

    public final long getLastEditedTime() {
        return PaintingDoc_GetLastEditedTime();
    }

    public final int getLayerCount() {
        return PaintingDoc_GetLayerCount();
    }

    public final int getLayerIdByIndex(int index) {
        int iPaintingDoc_GetLayerIdByIndex = PaintingDoc_GetLayerIdByIndex(index);
        if (iPaintingDoc_GetLayerIdByIndex == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iPaintingDoc_GetLayerIdByIndex;
    }

    public final int getLayerIndex(int id) {
        int iPaintingDoc_GetLayerIndex = PaintingDoc_GetLayerIndex(id);
        if (iPaintingDoc_GetLayerIndex == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iPaintingDoc_GetLayerIndex;
    }

    public final boolean getLayerLockState(int id) {
        return PaintingDoc_GetLayerLockState(id);
    }

    @NotNull
    public final String getLayerName(int id) {
        if (PaintingDoc_GetLayerIndex(id) == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return PaintingDoc_GetLayerName(id);
    }

    @Nullable
    public final ShadowEffect getLayerShadowEffect(int id) {
        ShadowEffect shadowEffect = new ShadowEffect();
        if (PaintingDoc_GetLayerShadowEffect(id, shadowEffect)) {
            return shadowEffect;
        }
        throwUncheckedException(SpenError.getError());
        return null;
    }

    @Nullable
    public final String getLayerThumbnailPath(int id) {
        return PaintingDoc_GetLayerThumbnailPath(id);
    }

    public final int getLayerTransparency(int id) {
        return PaintingDoc_GetLayerTransparency(id);
    }

    @NotNull
    public final SpenObjectBase getObject(int index) {
        SpenObjectBase spenObjectBasePaintingDoc_GetObject = PaintingDoc_GetObject(index);
        if (spenObjectBasePaintingDoc_GetObject == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenObjectBasePaintingDoc_GetObject);
        return spenObjectBasePaintingDoc_GetObject;
    }

    @NotNull
    public final SpenObjectBase getObjectByRuntimeHandle(int runtimeHandle) {
        SpenObjectBase spenObjectBasePaintingDoc_GetObjectByRuntimeHandle = PaintingDoc_GetObjectByRuntimeHandle(runtimeHandle);
        if (spenObjectBasePaintingDoc_GetObjectByRuntimeHandle == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenObjectBasePaintingDoc_GetObjectByRuntimeHandle);
        return spenObjectBasePaintingDoc_GetObjectByRuntimeHandle;
    }

    public final int getObjectCount(boolean includeInvisible) {
        return PaintingDoc_GetObjectCount(includeInvisible);
    }

    public final int getObjectIndex(@NotNull SpenObjectBase obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        int iPaintingDoc_GetObjectIndex = PaintingDoc_GetObjectIndex(obj);
        if (iPaintingDoc_GetObjectIndex == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iPaintingDoc_GetObjectIndex;
    }

    @Nullable
    public final ArrayList<SpenObjectBase> getObjectList() {
        ArrayList<SpenObjectBase> arrayListPaintingDoc_GetObjectList = PaintingDoc_GetObjectList();
        if (arrayListPaintingDoc_GetObjectList == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListPaintingDoc_GetObjectList;
    }

    @Nullable
    public final ArrayList<RectF> getObjectRectList() {
        ArrayList<RectF> arrayListPaintingDoc_GetObjectRectList = PaintingDoc_GetObjectRectList(255);
        if (arrayListPaintingDoc_GetObjectRectList == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListPaintingDoc_GetObjectRectList;
    }

    public final int getOrientation() {
        int iPaintingDoc_GetOrientation = PaintingDoc_GetOrientation();
        if (iPaintingDoc_GetOrientation == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iPaintingDoc_GetOrientation;
    }

    public final int getUndoLimit() {
        return PaintingDoc_getUndoLimit();
    }

    public final boolean hasBackgroundImage() {
        return PaintingDoc_HasBackgroundImage();
    }

    public final boolean hasDirtyBitmap() {
        return PaintingDoc_HasDirtyBitmap();
    }

    public final boolean hasExtraDataByteArray(@Nullable String key) {
        return PaintingDoc_HasExtraDataByteArray(key);
    }

    public final boolean hasExtraDataInt(@Nullable String key) {
        return PaintingDoc_HasExtraDataInt(key);
    }

    public final boolean hasExtraDataString(@Nullable String key) {
        return PaintingDoc_HasExtraDataString(key);
    }

    public final boolean hasExtraDataStringArray(@Nullable String key) {
        return PaintingDoc_HasExtraDataStringArray(key);
    }

    public int hashCode() {
        return (int) this.mHandle;
    }

    public final void insertLayer(int id, int index) {
        if (PaintingDoc_InsertLayer(id, index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isAllObjectsLoaded() {
        return PaintingDoc_IsAllObjectsLoaded();
    }

    public final boolean isChanged() {
        return PaintingDoc_IsChanged();
    }

    public final boolean isGroupingHistory() {
        return PaintingDoc_IsGroupingHistory();
    }

    public final boolean isLayerAlphaLock(int id) {
        return PaintingDoc_IsLayerAlphaLock(id);
    }

    public final boolean isLayerEventForwardEnabled(int id) {
        if (PaintingDoc_GetLayerIndex(id) == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return PaintingDoc_IsLayerEventForwardable(id);
    }

    public final boolean isLayerHasDirtyBitmap(int id) {
        return PaintingDoc_IsLayerHasDirtyBitmap(id);
    }

    public final boolean isLayerShadowEffectVisible(int id) {
        return PaintingDoc_IsLayerShadowEffectVisible(id);
    }

    public final boolean isLayerVisible(int id) {
        if (PaintingDoc_GetLayerIndex(id) == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return PaintingDoc_isLayerVisible(id);
    }

    public final boolean isObjectContained(@Nullable SpenObjectBase obj) {
        return PaintingDoc_GetObjectIndex(obj) != -1;
    }

    public final boolean isObjectLoaded() {
        return PaintingDoc_IsObjectLoaded();
    }

    public final boolean isRedoable() {
        return PaintingDoc_isRedoable();
    }

    public final boolean isReplayable() {
        return PaintingDoc_IsReplayable();
    }

    public final boolean isUndoable() {
        return PaintingDoc_isUndoable();
    }

    public final void loadAllObjects() {
        if (PaintingDoc_LoadAllObjects()) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throwUncheckedException(SpenError.getError());
        } else {
            throwUncheckedException(SpenError.getError());
        }
    }

    public final void loadObject() {
        if (PaintingDoc_LoadObject()) {
            return;
        }
        int error = SpenError.getError();
        if (error == 10 || error == 11) {
            throwUncheckedException(SpenError.getError());
        } else {
            throwUncheckedException(SpenError.getError());
        }
    }

    public final void mergeLayers(int destId, @Nullable int[] srcIdList) {
        if (PaintingDoc_MergeLayers(destId, srcIdList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void moveLayerIndex(int id, int step) {
        if (PaintingDoc_MoveLayerIndex(id, step)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final SpenHistoryUpdateInfo[] redo() {
        SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrPaintingDoc_redo = PaintingDoc_redo();
        if (spenHistoryUpdateInfoArrPaintingDoc_redo == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenHistoryUpdateInfoArrPaintingDoc_redo);
        return spenHistoryUpdateInfoArrPaintingDoc_redo;
    }

    @NotNull
    public final SpenHistoryUpdateInfo[] redoAll() {
        SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrPaintingDoc_redoAll = PaintingDoc_redoAll();
        if (spenHistoryUpdateInfoArrPaintingDoc_redoAll == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenHistoryUpdateInfoArrPaintingDoc_redoAll);
        return spenHistoryUpdateInfoArrPaintingDoc_redoAll;
    }

    public final void registerHistoryListener(@Nullable HistoryListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Invalid listener");
        }
        if (PaintingDoc_registerHistoryListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void registerLayerEventListener(@Nullable PaintingLayerEventListener listener) {
        if (PaintingDoc_RegisterLayerEventListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void registerObjectListener(@Nullable ObjectListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Invalid listener");
        }
        if (PaintingDoc_RegisterObjectListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void registerPageEventListener(@Nullable PaintingPageEventListener listener) {
        if (PaintingDoc_RegisterPageEventListener(listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeAllObject() {
        if (PaintingDoc_RemoveAllObject()) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataByteArray(@Nullable String key) {
        if (PaintingDoc_RemoveExtraDataByteArray(key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataInt(@Nullable String key) {
        if (PaintingDoc_RemoveExtraDataInt(key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataString(@Nullable String key) {
        if (PaintingDoc_RemoveExtraDataString(key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataStringArray(@Nullable String key) {
        if (PaintingDoc_RemoveExtraDataStringArray(key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeLayer(int id) {
        if (PaintingDoc_RemoveLayer(id)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void save(@Nullable String filepath) throws IOException {
        if (filepath == null) {
            throw new IllegalArgumentException("Invalid filepath");
        }
        if (PaintingDoc_save(filepath)) {
            return;
        }
        int error = SpenError.getError();
        if (error == 11) {
            throw new IOException();
        }
        if (error != 19) {
            SpenError.ThrowUncheckedException(SpenError.getError());
            return;
        }
        throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
    }

    public final void setAnchorImageThreshold(int i) {
        if (PaintingDoc_SetAnchorImageThreshold(i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundColor(@ColorInt int i) {
        if (PaintingDoc_SetBackgroundColor(i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImage(@Nullable String filePath) {
        if (PaintingDoc_SetBackgroundImage(filePath)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundImageMode(int i) {
        if (PaintingDoc_SetBackgroundImageMode(i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCurrentLayer(int id) {
        if (PaintingDoc_SetCurrentLayer(id)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataByteArray(@Nullable String key, @Nullable byte[] value) {
        if (value == null ? PaintingDoc_SetExtraDataByteArray(key, value, 0) : PaintingDoc_SetExtraDataByteArray(key, value, value.length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataInt(@Nullable String key, int value) {
        if (PaintingDoc_SetExtraDataInt(key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataString(@Nullable String key, @Nullable String value) {
        if (PaintingDoc_SetExtraDataString(key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataStringArray(@Nullable String key, @Nullable String[] value) {
        if (value == null ? PaintingDoc_SetExtraDataStringArray(key, value, 0) : PaintingDoc_SetExtraDataStringArray(key, value, value.length)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setForegroundImage(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recyled.");
        }
        if (PaintingDoc_SetForegroundImage2(bitmap)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerAlphaLock(int id, boolean alphaLock) {
        PaintingDoc_SetLayerAlphaLock(id, alphaLock);
    }

    public final void setLayerEventForwardEnabled(int id, boolean enable) {
        if (PaintingDoc_EnableLayerEventForward(id, enable)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerLockState(int id, boolean flagLock) {
        PaintingDoc_SetLayerLockState(id, flagLock);
    }

    public final void setLayerName(int id, @Nullable String name) {
        if (PaintingDoc_SetLayerName(id, name)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerShadowEffect(int id, @Nullable ShadowEffect effect) {
        if (effect == null) {
            throw new IllegalArgumentException("effect is null");
        }
        if (PaintingDoc_SetLayerShadowEffect(id, effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerShadowEffectVisibility(int id, boolean visible) {
        if (PaintingDoc_SetLayerShadowEffectVisibility(id, visible)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerTransparency(int id, int alpha) {
        if (PaintingDoc_SetLayerTransparency(id, alpha)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLayerVisibility(int id, boolean visible) {
        if (PaintingDoc_setLayerVisibility(id, visible)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setReplayable(boolean z) {
        if (PaintingDoc_SetReplayable(z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setUndoLimit(int i) {
        PaintingDoc_setUndoLimit(i);
    }

    public final void setVolatileBackgroundImage(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recyled.");
        }
        if (PaintingDoc_SetVolatileBackgroundImage(bitmap)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final SpenHistoryUpdateInfo[] undo() {
        SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrPaintingDoc_undo = PaintingDoc_undo();
        if (spenHistoryUpdateInfoArrPaintingDoc_undo == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenHistoryUpdateInfoArrPaintingDoc_undo);
        return spenHistoryUpdateInfoArrPaintingDoc_undo;
    }

    @NotNull
    public final SpenHistoryUpdateInfo[] undoAll() {
        SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrPaintingDoc_undoAll = PaintingDoc_undoAll();
        if (spenHistoryUpdateInfoArrPaintingDoc_undoAll == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenHistoryUpdateInfoArrPaintingDoc_undoAll);
        return spenHistoryUpdateInfoArrPaintingDoc_undoAll;
    }

    public final void unloadObject() {
        if (PaintingDoc_UnloadObject()) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean endHistoryGroup(@Nullable SpenHistoryUpdateInfo userData) {
        return PaintingDoc_EndHistoryGroup2(userData);
    }

    @Nullable
    public final SpenObjectBase findTopObjectAtPosition(float x, float y2, float threshold) {
        return PaintingDoc_FindTopObjectAtPositionWithThreshold(255, x, y2, threshold);
    }

    public final int getHeight() {
        return PaintingDoc_GetHeight();
    }

    public final int getObjectCount(int id, boolean includeInvisible) {
        return PaintingDoc_GetObjectCount2(id, includeInvisible);
    }

    public final int getWidth() {
        return PaintingDoc_GetWidth();
    }

    @NotNull
    public final ArrayList<SpenObjectBase> findObjectAtPosition(float x, float y2, float threshold) {
        ArrayList<SpenObjectBase> arrayListPaintingDoc_FindObjectAtPositionWithThreshold = PaintingDoc_FindObjectAtPositionWithThreshold(255, x, y2, threshold);
        if (arrayListPaintingDoc_FindObjectAtPositionWithThreshold == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(arrayListPaintingDoc_FindObjectAtPositionWithThreshold);
        return arrayListPaintingDoc_FindObjectAtPositionWithThreshold;
    }

    public final void setForegroundImage(@Nullable String filePath) {
        if (PaintingDoc_SetForegroundImage(filePath)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void close(boolean removeCache) throws IOException {
        if (this.mHandle == -1) {
            return;
        }
        if (!PaintingDoc_close(removeCache)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error != 19) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            } else {
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
        }
        this.mHandle = -1L;
        this.mContext = null;
    }

    public SpenPaintingDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, int i, int i2) throws IOException, SpenUnsupportedTypeException {
        if (context != null) {
            this.mContext = context;
            if (PaintingDoc_Construct2(context.getFilesDir().getAbsolutePath(), str, str2, i, i2) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the PatingDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenPaintingDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Invalid context");
    }
}
