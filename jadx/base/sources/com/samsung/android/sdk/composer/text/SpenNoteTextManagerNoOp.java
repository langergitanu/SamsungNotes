package com.samsung.android.sdk.composer.text;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenSuggestionSpan;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 î\u00012\u00020\u0001:\u0002î\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J$\u0010 \u001a\u00020\u00052\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J*\u0010'\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010\t\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010\t\u001a\u000206H\u0016J\u0018\u00108\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010\t\u001a\u000206H\u0016J\u0018\u00109\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010\t\u001a\u000206H\u0016J\u0012\u0010>\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u0002052\b\u0010C\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010D\u001a\u00020\u001c2\u0006\u0010B\u001a\u0002052\b\u0010C\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010E\u001a\u00020\u001c2\b\u0010C\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010F\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020/H\u0016J\b\u0010J\u001a\u00020\u0005H\u0016J\u001a\u0010K\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010L\u001a\u000205H\u0016J\u0018\u0010M\u001a\u0002052\u0006\u0010?\u001a\u00020@2\u0006\u0010N\u001a\u00020-H\u0016J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u001a\u0010R\u001a\u0004\u0018\u00010/2\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u000205H\u0016J\u001a\u0010T\u001a\u0004\u0018\u00010/2\u0006\u0010?\u001a\u00020@2\u0006\u0010S\u001a\u000205H\u0016J\u0010\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u001cH\u0016J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u001cH\u0016J\b\u0010`\u001a\u00020\u0005H\u0016J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u001cH\u0016J\b\u0010c\u001a\u00020\u0005H\u0016J\b\u0010d\u001a\u00020\u0005H\u0016J\u0012\u0010n\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010oH\u0016J\u0010\u0010p\u001a\u00020\u00052\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010q\u001a\u00020\u0005H\u0016J\u0010\u0010r\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010s\u001a\u0004\u0018\u00010/2\u0006\u0010t\u001a\u00020\u001cH\u0016J\u0012\u0010u\u001a\u0004\u0018\u00010/2\u0006\u0010t\u001a\u00020\u001cH\u0016J\u0010\u0010v\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010w\u001a\u00020\u00052\u0006\u0010\t\u001a\u000206H\u0016J\b\u0010x\u001a\u00020\u0005H\u0016J\u0010\u0010y\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u001cH\u0016J\b\u0010{\u001a\u00020\u0005H\u0016J\b\u0010|\u001a\u00020\u0005H\u0016J!\u0010}\u001a\u00020\u001c2\u0006\u0010~\u001a\u0002052\u0006\u0010\u007f\u001a\u0002052\u0007\u0010\u0080\u0001\u001a\u00020hH\u0016J)\u0010}\u001a\u00020\u001c2\u0017\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u0002050\"j\b\u0012\u0004\u0012\u000205`$2\u0006\u0010\u007f\u001a\u000205H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J&\u0010\u0082\u0001\u001a\u00020\u001c2\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u0004\u0012\u000205\u0018\u00010\"j\n\u0012\u0004\u0012\u000205\u0018\u0001`$H\u0016J\u0015\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J6\u0010\u0087\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u0002052\u0007\u0010\u0088\u0001\u001a\u0002052\u0007\u0010\u0080\u0001\u001a\u00020h2\b\u0010\u0089\u0001\u001a\u00030\u0086\u00012\u0006\u0010]\u001a\u000205H\u0016J?\u0010\u0087\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u0002052\u0019\u0010\u008a\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u008b\u00010\"j\t\u0012\u0005\u0012\u00030\u008b\u0001`$2\b\u0010\u0089\u0001\u001a\u00030\u0086\u00012\u0006\u0010]\u001a\u000205H\u0016J$\u0010\u0087\u0001\u001a\u0002052\u0007\u0010\u008c\u0001\u001a\u0002052\u0007\u0010\u008d\u0001\u001a\u00020\u001c2\u0007\u0010\u0089\u0001\u001a\u00020@H\u0016J\u001c\u0010\u008e\u0001\u001a\u0002052\u0007\u0010\u0083\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u008b\u0001H\u0016J$\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u0002052\u0007\u0010\u0088\u0001\u001a\u0002052\u0007\u0010\u0080\u0001\u001a\u00020hH\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u001c2\u0007\u0010\u0092\u0001\u001a\u000205H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\u001c2\u0007\u0010\u0095\u0001\u001a\u000205H\u0016J\u001d\u0010\u0096\u0001\u001a\u0002052\b\u0010\u0097\u0001\u001a\u00030\u0086\u00012\b\u0010\u0098\u0001\u001a\u00030\u008b\u0001H\u0016J%\u0010\u0099\u0001\u001a\u00020\u001c2\b\u0010\u0097\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u009a\u0001\u001a\u0002052\u0007\u0010\u0088\u0001\u001a\u000205H\u0016J\u001a\u0010\u009b\u0001\u001a\u00020\u00052\u0007\u0010\u0092\u0001\u001a\u0002052\u0006\u0010L\u001a\u000205H\u0016J\u001a\u0010\u009c\u0001\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J\u0013\u0010\u009d\u0001\u001a\u00020\u00052\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010 \u0001\u001a\u0002052\u0007\u0010\u008c\u0001\u001a\u000205H\u0016J\u0012\u0010¡\u0001\u001a\u0002052\u0007\u0010\u0092\u0001\u001a\u000205H\u0016J\u0012\u0010¢\u0001\u001a\u0002052\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J\u0011\u0010£\u0001\u001a\u0002052\u0006\u0010N\u001a\u00020-H\u0016J\u0011\u0010¤\u0001\u001a\u0002052\u0006\u0010N\u001a\u00020-H\u0016J\u001e\u0010¥\u0001\u001a\u0004\u0018\u00010/2\b\u0010\u008f\u0001\u001a\u00030\u008b\u00012\u0007\u0010¦\u0001\u001a\u00020hH\u0016J\u0012\u0010§\u0001\u001a\u00020\u00052\u0007\u0010¨\u0001\u001a\u00020\u001cH\u0016J\t\u0010©\u0001\u001a\u00020\u001cH\u0016J\u0016\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0012\u0010®\u0001\u001a\u00020\u00052\u0007\u0010¯\u0001\u001a\u00020\u001cH\u0016J$\u0010°\u0001\u001a\u00020\u00052\u0007\u0010±\u0001\u001a\u0002052\u0007\u0010²\u0001\u001a\u0002052\u0007\u0010³\u0001\u001a\u00020\u001cH\u0016J\u001c\u0010´\u0001\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@2\u0007\u0010³\u0001\u001a\u00020\u001cH\u0016J\u001b\u0010º\u0001\u001a\u00020\u00052\u0007\u0010»\u0001\u001a\u0002052\u0007\u0010¼\u0001\u001a\u000205H\u0016J\t\u0010½\u0001\u001a\u00020\u0005H\u0016J\t\u0010¾\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010Ã\u0001\u001a\u0002052\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J\u0012\u0010Ä\u0001\u001a\u0002052\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J\u0011\u0010Å\u0001\u001a\u00020#2\u0006\u0010I\u001a\u00020/H\u0016J \u0010Æ\u0001\u001a\u0011\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010Ç\u00012\u0006\u0010I\u001a\u00020/H\u0016J\u001a\u0010È\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010#0É\u00012\u0006\u0010I\u001a\u00020/H\u0016J\"\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020/0Ë\u00012\u0007\u0010Ì\u0001\u001a\u0002052\u0007\u0010Í\u0001\u001a\u000205H\u0016J\u0013\u0010Î\u0001\u001a\u00020/2\b\u0010Ï\u0001\u001a\u00030\u0086\u0001H\u0016J\u0012\u0010Ð\u0001\u001a\u00020\u00052\u0007\u0010Ñ\u0001\u001a\u00020#H\u0016J\u0013\u0010Ò\u0001\u001a\u00020\u00052\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0016Jc\u0010Õ\u0001\u001a\u00020\u00052X\u0010Ö\u0001\u001aS\u0012\u0016\u0012\u00140)¢\u0006\u000f\bØ\u0001\u0012\n\bÙ\u0001\u0012\u0005\b\b(Ú\u0001\u0012\u0016\u0012\u001405¢\u0006\u000f\bØ\u0001\u0012\n\bÙ\u0001\u0012\u0005\b\b(Û\u0001\u0012\u0016\u0012\u001405¢\u0006\u000f\bØ\u0001\u0012\n\bÙ\u0001\u0012\u0005\b\b(Ü\u0001\u0012\u0004\u0012\u00020\u001c\u0018\u00010×\u0001H\u0016J3\u0010Ý\u0001\u001a\u001a\u0012\u0007\u0012\u0005\u0018\u00010ß\u0001\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0018\u00010Þ\u00012\u0007\u0010à\u0001\u001a\u0002052\u0007\u0010\u0083\u0001\u001a\u000205H\u0016J%\u0010á\u0001\u001a\u00020\u00052\b\u0010â\u0001\u001a\u00030ã\u00012\u0007\u0010ä\u0001\u001a\u00020\u001c2\u0007\u0010å\u0001\u001a\u00020\u001cH\u0016J%\u0010æ\u0001\u001a\u00020\u00052\b\u0010â\u0001\u001a\u00030ã\u00012\u0007\u0010ä\u0001\u001a\u00020\u001c2\u0007\u0010å\u0001\u001a\u00020\u001cH\u0016J8\u0010ç\u0001\u001a\u00020\u00052\b\u0010è\u0001\u001a\u00030é\u00012\u0007\u0010ê\u0001\u001a\u0002052\u0007\u0010ë\u0001\u001a\u0002052\b\u0010Ï\u0001\u001a\u00030\u0086\u00012\u0007\u0010ä\u0001\u001a\u00020\u001cH\u0016J@\u0010ì\u0001\u001a\u00020\u00052\b\u0010è\u0001\u001a\u00030é\u00012\"\u0010í\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0012\u0005\u0012\u00030\u0086\u00010Þ\u00010É\u00012\u0007\u0010ä\u0001\u001a\u00020\u001cH\u0016R\u0016\u0010:\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010P\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR$\u0010U\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010XR\u0014\u0010]\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R$\u0010e\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\be\u0010Q\"\u0004\bf\u0010XR$\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020h8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR)\u0010¶\u0001\u001a\u0002052\u0007\u0010µ\u0001\u001a\u0002058V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b·\u0001\u0010_\"\u0006\b¸\u0001\u0010¹\u0001R\u0016\u0010¿\u0001\u001a\u0002058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010_R\u0016\u0010Á\u0001\u001a\u0002058VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010_¨\u0006ï\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenNoteTextManagerNoOp;", "Lcom/samsung/android/sdk/composer/text/ISpenNoteTextManager;", "<init>", "()V", "setDocument", "", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "onPopulateAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "setNativeHandle", "handle", "", "close", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/widget/listener/SpenTextManagerActionListener;", "setSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "setCursorChangedListener", "Lcom/samsung/android/sdk/pen/text/SpenCursorChangedListener;", "setControlObjectListener", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "setTextLimitListener", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "setTextInputBlock", "setBlock", "", "setEditable", "enable", "setHashTagEnabled", "setTagList", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setHyperTextEnabled", "setDoubleTapSelectionEnabled", "setCursorAnchorPosition", "composingText", "", "view", "Landroid/view/View;", "viewPosition", "Landroid/graphics/PointF;", "cursorAnchorRect", "Landroid/graphics/RectF;", "onAttachedToWindow", "onParentTouchEvent", "Landroid/view/MotionEvent;", "onKeyDown", "keyCode", "", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getSelectedObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "finishComposingText", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "onControlObjectClicked", "tooltype", "objectBase", "onControlObjectLongClicked", "onControlObjectButtonClicked", "onSuggestionTextClicked", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "rect", "onViewClicked", "onInsertLineFeed", "count", "getCurosrIndex", "position", "setCursorBlink", "isCursorBlinking", "()Z", "getCursorRect", "cursorPos", "getCursorRectOnScreenCoordinates", "autoBlinkOffOnWindowFocusChanged", "getAutoBlinkOffOnWindowFocusChanged", "setAutoBlinkOffOnWindowFocusChanged", "(Z)V", "onWindowFocusChanged", "hasWindowFocus", "onFocusChanged", "gainFocus", "textSizeDelta", "getTextSizeDelta", "()I", "updateHashTagPosition", "onLayout", "changed", "onConfigurationChanged", "updateSuggestionPopup", "isAutoFocusEnabled", "setAutoFocusEnabled", WiggleAnimationConfig.KEY_SCALE, "", "textScale", "getTextScale", "()F", "setTextScale", "(F)V", "setTextScaleListener", "Lcom/samsung/android/sdk/pen/text/SpenTextScaleListener;", "onTextScaleChanged", "showTextContextMenu", "setSelectionContextMenuForceEnabled", "getStartCursorHandleRect", "onViewCoordinates", "getEndCursorHandleRect", "setTextGradientSelectionEnabled", "sendKeyEvent", "lockBodyTextPage", "setFixedContentHeightEnabled", "bool", "unlockBodyTextPage", "updateBodyTextPage", "moveBodyTextTo", "srcPageIndex", "dstPageIndex", "documentPixel", "srcPageIndexList", "removeBodyTextFrom", "pageIndex", "pageIndexList", "copyBodyTextFrom", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "insertBodyTextTo", "pageHeight", "insertObject", "pageList", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "cursorIndex", "newParagraph", "calculateInsertedTextCountWhenInsertEmptyBodyTextTo", "page", "insertEmptyBodyTextTo", "insertPageBreakIntoBodyText", "textIndex", "clearBodyTextIn", "clearBodyTextByParagraphIndex", "paraIndex", "calculateOverflowPageCount", "objectText", "wpage", "reduceFontSizeToFitPage", "pageWidth", "updateBodyObjectSpanPosition", "setCursorOnScreen", "setCursorObstacleRect", "obstacleRect", "Landroid/graphics/Rect;", "getPageIndexByCursorOfBodyText", "getPageIndexByTextOfBodyText", "getStartCursorIndexByPage", "getLineCountFromBodyTextBottom", "getCursorIndexToInsertIntoBodyText", "getLineRectOfBodyText", "y", "setShowSoftInputDisabled", "disable", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onShowSoftInput", Constants.IntentExtraValue.SHOW, "onCursorChanged", "start", "end", "editable", "onCursorObjectChanged", "len", "cursorSelectionMaxLength", "getCursorSelectionMaxLength", "setCursorSelectionMaxLength", "(I)V", "setSelectionRange", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "startAiTextFormat", "stopAiTextFormat", "cursorSelectionStartOnScreenInBodyText", "getCursorSelectionStartOnScreenInBodyText", "cursorSelectionEndOnScreenInBodyText", "getCursorSelectionEndOnScreenInBodyText", "getTextStartByPage", "getTextCountByPage", "getTextByRectInBodytext", "getCursorRangeByRectInBodytext", "Landroid/util/Pair;", "getTextByRectInTextbox", "", "getTextContentRectsByCursorRangeInBodytext", "", "curStart", "curEnd", "getTextBoxMeasuredRect", ExternalDataConstants.Column.TEXT_BOX, "addPrivateImeSettings", "options", "setPreCommitRegex", "regex", "Lkotlin/text/Regex;", "setPreCommitCheckFunction", "func", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "text", "composingStart", "composingEnd", "getObjectEditable", "Lkotlin/Triple;", "Landroid/text/Editable;", "nativeID", "appendObjectSpan", "objectSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "animationEnabled", "commitHistory", "removeObjectSpan", "setTableCellContent", "objectTable", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "rowIndex", "columnIndex", "setTableCellsContent", "cellDataList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNoteTextManagerNoOp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNoteTextManagerNoOp.kt\ncom/samsung/android/sdk/composer/text/SpenNoteTextManagerNoOp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,425:1\n1#2:426\n*E\n"})
public final class SpenNoteTextManagerNoOp implements ISpenNoteTextManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/text/SpenNoteTextManagerNoOp$Companion;", "", "<init>", "()V", "calculateTextSizeDelta", "", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "currentSizeDelta", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int calculateTextSizeDelta(@Nullable SpenDisplay display, int currentSizeDelta) {
            return 0;
        }

        private Companion() {
        }
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void addPrivateImeSettings(@NotNull String options) {
        Intrinsics.checkNotNullParameter(options, "options");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void appendObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int calculateInsertedTextCountWhenInsertEmptyBodyTextTo(int pageIndex, @NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int calculateOverflowPageCount(@NotNull SpenObjectTextBox objectText, @NotNull SpenWPage wpage) {
        Intrinsics.checkNotNullParameter(objectText, "objectText");
        Intrinsics.checkNotNullParameter(wpage, "wpage");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean clearBodyTextByParagraphIndex(int paraIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean clearBodyTextIn(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void close() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public SpenObjectTextBox copyBodyTextFrom(int pageIndex) {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void finishComposingText(@Nullable SpenObjectShape objectShape) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    /* JADX INFO: renamed from: getAutoBlinkOffOnWindowFocusChanged */
    public boolean getMIsAutoBlinkOffOnWindowFocusChanged() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public int getCurosrIndex(@NotNull SpenObjectShape objectShape, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        Intrinsics.checkNotNullParameter(position, "position");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorIndexToInsertIntoBodyText(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public Pair<Integer, Integer> getCursorRangeByRectInBodytext(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getCursorRect(@NotNull SpenObjectShape objectShape, int cursorPos) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getCursorRectOnScreenCoordinates(@NotNull SpenObjectShape objectShape, int cursorPos) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        return null;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionEndOnScreenInBodyText() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionMaxLength() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getCursorSelectionStartOnScreenInBodyText() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getEndCursorHandleRect(boolean onViewCoordinates) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getLineCountFromBodyTextBottom(@NotNull PointF position) {
        Intrinsics.checkNotNullParameter(position, "position");
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @Nullable
    public RectF getLineRectOfBodyText(@NotNull SpenWPage page, float y2) {
        Intrinsics.checkNotNullParameter(page, "page");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public Triple<Editable, Integer, Integer> getObjectEditable(int nativeID, int pageIndex) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getPageIndexByCursorOfBodyText(int cursorIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getPageIndexByTextOfBodyText(int textIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public SpenObjectBase getSelectedObject() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getStartCursorHandleRect(boolean onViewCoordinates) {
        return null;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getStartCursorIndexByPage(int pageIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @NotNull
    public RectF getTextBoxMeasuredRect(@NotNull SpenObjectTextBox textBox) {
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        return textBox.getRect();
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @NotNull
    public String getTextByRectInBodytext(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return "";
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @NotNull
    public List<String> getTextByRectInTextbox(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return CollectionsKt.emptyList();
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    @NotNull
    public List<RectF> getTextContentRectsByCursorRangeInBodytext(int curStart, int curEnd) {
        return new ArrayList(0);
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getTextCountByPage(int pageIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public float getTextScale() {
        return 0.0f;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public int getTextSizeDelta() {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int getTextStartByPage(int pageIndex) {
        return 0;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public int insertBodyTextTo(int cursorIndex, boolean newParagraph, @NotNull SpenObjectShape insertObject) {
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        return cursorIndex;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertEmptyBodyTextTo(int pageIndex, int pageHeight, float documentPixel) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertPageBreakIntoBodyText(int textIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean isAutoFocusEnabled() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean isCursorBlinking() {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void lockBodyTextPage() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean moveBodyTextTo(int srcPageIndex, int dstPageIndex, float documentPixel) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onAttachedToWindow() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onCheckIsTextEditor() {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onConfigurationChanged() {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectButtonClicked(@Nullable SpenObjectBase objectBase) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectClicked(int tooltype, @Nullable SpenObjectBase objectBase) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectLongClicked(int tooltype, @Nullable SpenObjectBase objectBase) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onCursorChanged(int start, int end, boolean editable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onCursorObjectChanged(@Nullable SpenObjectShape objectShape, boolean editable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onFocusChanged(boolean gainFocus) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onInsertLineFeed(@Nullable SpenObjectShape objectShape, int count) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onLayout(boolean changed) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onParentTouchEvent(@Nullable MotionEvent event) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onShowSoftInput(boolean show) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onSuggestionTextClicked(@Nullable SpenSuggestionSpan span, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onTextScaleChanged(float scale) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onViewClicked() {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onWindowFocusChanged(boolean hasWindowFocus) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean reduceFontSizeToFitPage(@NotNull SpenObjectTextBox objectText, int pageWidth, int pageHeight) {
        Intrinsics.checkNotNullParameter(objectText, "objectText");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean removeBodyTextFrom(int pageIndex) {
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void removeObjectSpan(@NotNull SpenObjectSpan objectSpan, boolean animationEnabled, boolean commitHistory) {
        Intrinsics.checkNotNullParameter(objectSpan, "objectSpan");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void sendKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setActionListener(@Nullable SpenTextManagerActionListener listener) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setAutoBlinkOffOnWindowFocusChanged(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setAutoFocusEnabled(boolean z) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setControlObjectListener(@Nullable SpenControlObjectListener listener) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorAnchorPosition(@NotNull View view, @Nullable CharSequence composingText, @NotNull PointF viewPosition, @NotNull RectF cursorAnchorRect) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewPosition, "viewPosition");
        Intrinsics.checkNotNullParameter(cursorAnchorRect, "cursorAnchorRect");
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorBlink(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorChangedListener(@Nullable SpenCursorChangedListener listener) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorObstacleRect(@NotNull Rect obstacleRect) {
        Intrinsics.checkNotNullParameter(obstacleRect, "obstacleRect");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorOnScreen(@NotNull SpenObjectShape objectShape, int pageIndex) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setCursorSelectionMaxLength(int i) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setDocument(@Nullable SpenWNote doc) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setDoubleTapSelectionEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setEditable(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setFixedContentHeightEnabled(boolean bool) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setHashTagEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setHyperTextEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager, com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setNativeHandle(long handle) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setPreCommitCheckFunction(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> func) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setPreCommitRegex(@NotNull Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "regex");
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setSelectionContextMenuForceEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setSelectionRange(int min, int max) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setShowSoftInputDisabled(boolean disable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setSoftInputListener(@Nullable SpenSoftInputListener listener) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setTableCellContent(@NotNull SpenObjectTable objectTable, int rowIndex, int columnIndex, @NotNull SpenObjectTextBox textBox, boolean animationEnabled) {
        Intrinsics.checkNotNullParameter(objectTable, "objectTable");
        Intrinsics.checkNotNullParameter(textBox, "textBox");
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void setTableCellsContent(@NotNull SpenObjectTable objectTable, @NotNull List<Triple<Integer, Integer, SpenObjectTextBox>> cellDataList, boolean animationEnabled) {
        Intrinsics.checkNotNullParameter(objectTable, "objectTable");
        Intrinsics.checkNotNullParameter(cellDataList, "cellDataList");
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTagList(@Nullable ArrayList<String> list) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextGradientSelectionEnabled(boolean enable) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextInputBlock(boolean setBlock) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextLimitListener(@Nullable SpenTextLimitListener listener) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextScale(float f) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextScaleListener(@Nullable SpenTextScaleListener listener) {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void showTextContextMenu() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void startAiTextFormat() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void stopAiTextFormat() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void unlockBodyTextPage() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void updateBodyObjectSpanPosition(int textIndex, int count) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public void updateBodyTextPage() {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void updateHashTagPosition() {
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void updateSuggestionPopup() {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertBodyTextTo(int pageIndex, int pageHeight, float documentPixel, @NotNull SpenObjectTextBox insertObject, int textSizeDelta) {
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean moveBodyTextTo(@NotNull ArrayList<Integer> srcPageIndexList, int dstPageIndex) {
        Intrinsics.checkNotNullParameter(srcPageIndexList, "srcPageIndexList");
        return false;
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean removeBodyTextFrom(@Nullable ArrayList<Integer> pageIndexList) {
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorAnchorPosition(@Nullable CharSequence composingText) {
    }

    @Override // com.samsung.android.sdk.composer.text.ISpenNoteTextManager
    public boolean insertBodyTextTo(int pageIndex, @NotNull ArrayList<SpenWPage> pageList, @NotNull SpenObjectTextBox insertObject, int textSizeDelta) {
        Intrinsics.checkNotNullParameter(pageList, "pageList");
        Intrinsics.checkNotNullParameter(insertObject, "insertObject");
        return false;
    }
}
