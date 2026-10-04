package com.samsung.android.sdk.pen.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.control.SpenControlObjectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenSpellCorrectionSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenSuggestionSpan;
import com.samsung.android.sdk.pen.text.SpenCursorChangedListener;
import com.samsung.android.sdk.pen.text.SpenFontManager;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.text.SpenTextLimitListener;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.sdk.pen.text.SpenTextUtils;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection;
import com.samsung.android.sdk.pen.util.SpenMagnifier;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.widget.SpenHashTag;
import com.samsung.android.sdk.pen.widget.edittext.SpenTextSearch;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013C2.AbstractC0053a;
import p031G2.C0109b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 Û\u00012\u00020\u0001:\u0002Û\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0007H\u0016J\b\u0010C\u001a\u00020>H\u0016J\u0012\u0010D\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010F\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010I\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010J\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020(H\u0016J\u0010\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J\u0010\u0010P\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J$\u0010Q\u001a\u00020>2\u001a\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J\u0010\u0010W\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J\u0012\u0010X\u001a\u00020>2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J*\u0010X\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0016J\b\u0010_\u001a\u00020>H\u0016J\u0012\u0010`\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010aH\u0016J\u0018\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020*2\u0006\u0010?\u001a\u00020dH\u0016J\u0018\u0010e\u001a\u00020(2\u0006\u0010c\u001a\u00020*2\u0006\u0010?\u001a\u00020dH\u0016J\u0018\u0010f\u001a\u00020(2\u0006\u0010c\u001a\u00020*2\u0006\u0010?\u001a\u00020dH\u0016J\u0018\u0010g\u001a\u00020(2\u0006\u0010c\u001a\u00020*2\u0006\u0010?\u001a\u00020dH\u0016J\b\u0010h\u001a\u00020(H\u0016J\u0012\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020lH\u0016J\n\u0010m\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010n\u001a\u00020>2\u0006\u0010o\u001a\u00020(H\u0016J \u0010p\u001a\u00020>2\u0006\u0010q\u001a\u00020*2\u0006\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u00020(H\u0016J\u001a\u0010t\u001a\u00020>2\b\u0010u\u001a\u0004\u0018\u00010\"2\u0006\u0010s\u001a\u00020(H\u0016J@\u0010z\u001a\u00020*2\b\u0010{\u001a\u0004\u0018\u00010T2\b\u0010z\u001a\u0004\u0018\u00010T2\u0006\u0010|\u001a\u00020}2\u001a\u0010~\u001a\u0016\u0012\u0004\u0012\u00020\u007f\u0018\u00010Sj\n\u0012\u0004\u0012\u00020\u007f\u0018\u0001`UH\u0002J\t\u0010\u0080\u0001\u001a\u00020>H\u0002J%\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u00012\u0006\u0010o\u001a\u00020(H\u0002J/\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0085\u0001\u001a\u00030\u0083\u00012\b\u0010\u0086\u0001\u001a\u00030\u0083\u00012\b\u0010\u0087\u0001\u001a\u00030\u0083\u00012\u0006\u0010o\u001a\u00020(H\u0002J#\u0010\u0088\u0001\u001a\u00020>2\u0006\u0010u\u001a\u00020\"2\u0007\u0010\u0089\u0001\u001a\u00020*2\u0007\u0010\u008a\u0001\u001a\u00020*H\u0002J:\u0010\u008b\u0001\u001a\u00020>2\u0007\u0010\u008c\u0001\u001a\u00020T2\u0007\u0010\u008d\u0001\u001a\u00020*2\u0007\u0010\u008e\u0001\u001a\u00020*2\b\u0010u\u001a\u0004\u0018\u00010\"2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0002JL\u0010\u0091\u0001\u001a\u00020>2\u0007\u0010\u008c\u0001\u001a\u00020T2\u0007\u0010\u008d\u0001\u001a\u00020*2\u0007\u0010\u008e\u0001\u001a\u00020*2\b\u0010u\u001a\u0004\u0018\u00010\"2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\u0007\u0010\u0092\u0001\u001a\u00020^2\u0007\u0010\u0093\u0001\u001a\u00020\\H\u0002J8\u0010\u0094\u0001\u001a\u00020>2\b\u0010u\u001a\u0004\u0018\u00010\"2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u0007\u0010\u0092\u0001\u001a\u00020^2\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020^0\u0097\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020>H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020>2\u0007\u0010\u009a\u0001\u001a\u00020*H\u0002J\u0013\u0010\u009b\u0001\u001a\u00020>2\b\u0010u\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010\u009c\u0001\u001a\u00020(2\u0007\u0010\u009d\u0001\u001a\u00020*2\b\u0010u\u001a\u0004\u0018\u00010wH\u0016J\u001c\u0010\u009e\u0001\u001a\u00020(2\u0007\u0010\u009d\u0001\u001a\u00020*2\b\u0010u\u001a\u0004\u0018\u00010wH\u0016J\u0013\u0010\u009f\u0001\u001a\u00020(2\b\u0010u\u001a\u0004\u0018\u00010wH\u0016J\u001e\u0010 \u0001\u001a\u00020>2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010¡\u00012\u0007\u0010\u0092\u0001\u001a\u00020^H\u0016J\t\u0010¢\u0001\u001a\u00020>H\u0016J\u001c\u0010£\u0001\u001a\u00020>2\b\u0010u\u001a\u0004\u0018\u00010\"2\u0007\u0010¤\u0001\u001a\u00020*H\u0016J\u001a\u0010¥\u0001\u001a\u00020*2\u0006\u0010u\u001a\u00020\"2\u0007\u0010¦\u0001\u001a\u00020\\H\u0016J\u0011\u0010§\u0001\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J\u0011\u0010¨\u0001\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0002J\u001c\u0010¬\u0001\u001a\u0004\u0018\u00010^2\u0006\u0010u\u001a\u00020\"2\u0007\u0010\u00ad\u0001\u001a\u00020*H\u0016J\u001c\u0010®\u0001\u001a\u0004\u0018\u00010^2\u0006\u0010u\u001a\u00020\"2\u0007\u0010\u00ad\u0001\u001a\u00020*H\u0016J\u0012\u0010³\u0001\u001a\u00020>2\u0007\u0010´\u0001\u001a\u00020(H\u0016J\u0012\u0010µ\u0001\u001a\u00020>2\u0007\u0010¶\u0001\u001a\u00020(H\u0016J\t\u0010·\u0001\u001a\u00020>H\u0002J\t\u0010¸\u0001\u001a\u00020>H\u0002J\t\u0010¹\u0001\u001a\u00020>H\u0002J\t\u0010½\u0001\u001a\u00020>H\u0016J\u0012\u0010¾\u0001\u001a\u00020>2\u0007\u0010¿\u0001\u001a\u00020(H\u0016J\t\u0010À\u0001\u001a\u00020>H\u0016J\t\u0010Á\u0001\u001a\u00020>H\u0016J\t\u0010Ä\u0001\u001a\u00020>H\u0002J\u0013\u0010Ë\u0001\u001a\u00020>2\b\u0010E\u001a\u0004\u0018\u00010\u001cH\u0016J\u0013\u0010Ì\u0001\u001a\u00020>2\b\u0010Å\u0001\u001a\u00030\u0083\u0001H\u0016J\t\u0010Í\u0001\u001a\u00020>H\u0016J\u0011\u0010Î\u0001\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J\u0014\u0010Ï\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010Ð\u0001\u001a\u00020(H\u0016J\u0014\u0010Ñ\u0001\u001a\u0004\u0018\u00010^2\u0007\u0010Ð\u0001\u001a\u00020(H\u0016J\u0011\u0010Ò\u0001\u001a\u00020>2\u0006\u0010O\u001a\u00020(H\u0016J3\u0010Ó\u0001\u001a\u001a\u0012\u0007\u0012\u0005\u0018\u00010Õ\u0001\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010Ô\u00012\u0007\u0010Ö\u0001\u001a\u00020*2\u0007\u0010×\u0001\u001a\u00020*H\u0016J\u001a\u0010Ø\u0001\u001a\u00020>2\t\u0010E\u001a\u0005\u0018\u00010Ù\u0001H\u0000¢\u0006\u0003\bÚ\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020*X\u0082D¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u0016\u0010v\u001a\u0004\u0018\u00010w8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bx\u0010yR\u0017\u0010©\u0001\u001a\u00020(8VX\u0096\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0017\u0010«\u0001\u001a\u00020(8BX\u0082\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010ª\u0001R)\u0010¯\u0001\u001a\u00020(2\u0006\u0010O\u001a\u00020(8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b°\u0001\u0010ª\u0001\"\u0006\b±\u0001\u0010²\u0001R\u0017\u0010º\u0001\u001a\u00020*8VX\u0096\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R)\u0010Â\u0001\u001a\u00020(2\u0006\u0010O\u001a\u00020(8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÂ\u0001\u0010ª\u0001\"\u0006\bÃ\u0001\u0010²\u0001R,\u0010Æ\u0001\u001a\u00030\u0083\u00012\b\u0010Å\u0001\u001a\u00030\u0083\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001¨\u0006Ü\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenTextManager;", "Lcom/samsung/android/sdk/pen/widget/SpenITextManager;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mNativeTextManager", "", "mView", "mActivity", "Landroid/app/Activity;", "mInputManager", "Lcom/samsung/android/sdk/pen/text/SpenInputManager;", "getMInputManager", "()Lcom/samsung/android/sdk/pen/text/SpenInputManager;", "setMInputManager", "(Lcom/samsung/android/sdk/pen/text/SpenInputManager;)V", "mCursorChangedListener", "Lcom/samsung/android/sdk/pen/text/SpenCursorChangedListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/widget/listener/SpenTextManagerActionListener;", "mControlObjectListener", "Lcom/samsung/android/sdk/pen/control/SpenControlObjectListener;", "mSuggestionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$SuggestionListener;", "mSetSelectionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$SetSelectionListener;", "mTextScaleListener", "Lcom/samsung/android/sdk/pen/text/SpenTextScaleListener;", "mHashTag", "Lcom/samsung/android/sdk/pen/widget/SpenHashTag;", "mTextSearch", "Lcom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch;", "mCursorObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "mMagnifier", "Lcom/samsung/android/sdk/pen/util/SpenMagnifier;", "mHandler", "Landroid/os/Handler;", "mIsEditable", "", "mCurStart", "", "mCurEnd", "mIsCursorBlinkOffByFocus", "mHasWindowFocus", "mIsAutoBlinkOffOnWindowFocusChanged", "mGainFocus", "mBackCallback", "", "mIsBackCallbackRegister", "mTextSizeDelta", "mBlinkOffRunnable", "Ljava/lang/Runnable;", "getMBlinkOffRunnable", "()Ljava/lang/Runnable;", "setMBlinkOffRunnable", "(Ljava/lang/Runnable;)V", "mUpdateSuggestionPopup", "getMUpdateSuggestionPopup", "setMUpdateSuggestionPopup", "onPopulateAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "setNativeHandle", "handle", "close", "setActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "setCursorChangedListener", "setControlObjectListener", "setTextLimitListener", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "setTextInputBlock", "setBlock", "setEditable", "enable", "setHashTagEnabled", "setTagList", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setHyperTextEnabled", "setDoubleTapSelectionEnabled", "setCursorAnchorPosition", "composingText", "", "viewPosition", "Landroid/graphics/PointF;", "cursorAnchorRect", "Landroid/graphics/RectF;", "onAttachedToWindow", "onParentTouchEvent", "Landroid/view/MotionEvent;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyPreIme", "onKeyShortcut", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "getActivity", "onShowSoftInput", Constants.IntentExtraValue.SHOW, "onCursorChanged", "start", "end", "editable", "onCursorObjectChanged", "objectShape", "selectedObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getSelectedObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "searchText", "originText", "measureWidths", "", "out", "Lcom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch$SearchInfo;", "onSelectionAreaLongPressed", "onShowMagnifier", "x", "", "y", "srcCenterX", "srcCenterY", "magnifierY", "onItemClicked", "type", "paragraphIndex", "onHyperTextClicked", "hypertext", "hypertextType", "datetimeType", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "onHyperTextClickedWithRectAndPoint", "rect", "touchPoint", "onSpellCorrectionTextClicked", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSpellCorrectionSpan;", "rectList", "", "onMaxSelectionTextLengthReached", "onVibrate", "vibrationPattern", "finishComposingText", "onControlObjectClicked", "tooltype", "onControlObjectLongClicked", "onControlObjectButtonClicked", "onSuggestionTextClicked", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "onViewClicked", "onInsertLineFeed", "count", "getCurosrIndex", "position", "setCursorBlink", "setCursorBlinkImpl", "isCursorBlinking", "()Z", "isCursorBlinkEnabled", "getCursorRect", "cursorPos", "getCursorRectOnScreenCoordinates", "autoBlinkOffOnWindowFocusChanged", "getAutoBlinkOffOnWindowFocusChanged", "setAutoBlinkOffOnWindowFocusChanged", "(Z)V", "onWindowFocusChanged", "hasWindowFocus", "onFocusChanged", "gainFocus", "blinkOff", "blinkOn", "hideHashTagBubble", "textSizeDelta", "getTextSizeDelta", "()I", "updateHashTagPosition", "onLayout", "changed", "onConfigurationChanged", "updateSuggestionPopup", "isAutoFocusEnabled", "setAutoFocusEnabled", "updateFontManager", WiggleAnimationConfig.KEY_SCALE, "textScale", "getTextScale", "()F", "setTextScale", "(F)V", "setTextScaleListener", "onTextScaleChanged", "showTextContextMenu", "setSelectionContextMenuForceEnabled", "getStartCursorHandleRect", "onViewCoordinates", "getEndCursorHandleRect", "setTextGradientSelectionEnabled", "getObjectEditable", "Lkotlin/Triple;", "Landroid/text/Editable;", "nativeID", "pageIndex", "setPerformContextMenuActionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$PerformContextMenuActionListener;", "setPerformContextMenuActionListener$SDK_fullRelease", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenTextManager implements SpenITextManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_TEXT_SIZE_DELTA = Integer.MIN_VALUE;
    private static final int DELAY_TIME_BLINK_OFF = 300;
    private static final long DELAY_TIME_HIDE_SOFT_INPUT = 200;
    private static final long DELAY_TIME_SET_CURSOR_ANCHOR_POSITION = 200;
    private static final int DELAY_TIME_UPDATE_SUGGESTION_POPUP = 600;
    private static final int MSG_SET_CURSOR_ANCHOR_ON_COMPOSING_TEXT = 2;
    private static final int MSG_SET_CURSOR_ANCHOR_UPDATE = 1;

    @NotNull
    private static final String TAG = "SpenTextManager";

    @Nullable
    private SpenTextManagerActionListener mActionListener;

    @Nullable
    private Activity mActivity;

    @Nullable
    private Object mBackCallback;

    @NotNull
    private Runnable mBlinkOffRunnable;

    @Nullable
    private SpenControlObjectListener mControlObjectListener;

    @Nullable
    private SpenCursorChangedListener mCursorChangedListener;

    @Nullable
    private SpenObjectShape mCursorObject;

    @Nullable
    private Handler mHandler;

    @Nullable
    private SpenHashTag mHashTag;

    @Nullable
    private SpenInputManager mInputManager;
    private boolean mIsBackCallbackRegister;
    private boolean mIsCursorBlinkOffByFocus;
    private boolean mIsEditable;

    @Nullable
    private SpenMagnifier mMagnifier;
    private long mNativeTextManager;

    @Nullable
    private SpenInputManager.SetSelectionListener mSetSelectionListener;

    @Nullable
    private SpenInputManager.SuggestionListener mSuggestionListener;

    @Nullable
    private SpenTextScaleListener mTextScaleListener;

    @Nullable
    private SpenTextSearch mTextSearch;

    @NotNull
    private Runnable mUpdateSuggestionPopup;

    @Nullable
    private View mView;
    private int mCurStart = -1;
    private int mCurEnd = -1;
    private boolean mHasWindowFocus = true;
    private boolean mIsAutoBlinkOffOnWindowFocusChanged = true;
    private boolean mGainFocus = true;
    private final int mTextSizeDelta = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0083 J\u0011\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0083 J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0083 J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0083 J)\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0083 J\u0019\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0083 J\u0019\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010$\u001a\u00020\"H\u0083 J\u0011\u0010%\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0083 J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0019\u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0083 J\u0011\u0010)\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\nH\u0083 J1\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0083 J\u001b\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0083 J!\u00101\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0083 J\u0011\u00102\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0019\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00104\u001a\u00020\u001eH\u0083 J\u0011\u00105\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0011\u00106\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0083 J\u0019\u00107\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0083 J\u001b\u00108\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00109\u001a\u00020\"H\u0083 J\u001b\u0010:\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\n2\u0006\u00109\u001a\u00020\"H\u0083 J\u0019\u0010;\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0083 J)\u0010<\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0083 J\u001b\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010CH\u0083 J1\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010E2\u0006\u0010A\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010F\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/SpenTextManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEFAULT_TEXT_SIZE_DELTA", "", "DELAY_TIME_BLINK_OFF", "DELAY_TIME_SET_CURSOR_ANCHOR_POSITION", "", "DELAY_TIME_HIDE_SOFT_INPUT", "DELAY_TIME_UPDATE_SUGGESTION_POPUP", "MSG_SET_CURSOR_ANCHOR_UPDATE", "MSG_SET_CURSOR_ANCHOR_ON_COMPOSING_TEXT", "Native_init", "", "nativeTextManager", "textManager", "Lcom/samsung/android/sdk/pen/widget/SpenTextManager;", "Native_finalize", "Native_getCursorRect", "Landroid/graphics/RectF;", "objectHandle", "cursorPos", "Native_getCursorRectOnScreenCoordinates", "Native_getCursorIndex", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "x", "", "y", "Native_setHyperTextEnabled", "enable", "", "Native_setCursorBlink", "blink", "Native_isCursorBlinkEnabled", "Native_setDoubleTapSelectionEnabled", "Native_getTextSizeDelta", "Native_setAutoScrollEnabled", "Native_isAutoScrollEnabled", "Native_highlightSuggestion", "suggestionType", "start", "end", "color", "Native_setSuggestionText", "suggestionText", "Native_setSelection", "Native_scrollToCursor", "Native_setTextScale", WiggleAnimationConfig.KEY_SCALE, "Native_getTextScale", "Native_showTextContextMenu", "Native_setSelectionContextMenuForceEnabled", "Native_getStartCursorHandleRect", "onScreen", "Native_getEndCursorHandleRect", "Native_setTextGradientSelectionEnabled", "Native_onKeyEvent", "action", "keyCode", "metaState", "Native_onCheckObjectChangedBySelf", "mNativeTextManager", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Native_getPageSection", "Lkotlin/Pair;", "pageIndex", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeTextManager) {
            SpenTextManager.Native_finalize(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getCursorIndex(long nativeTextManager, SpenObjectShape objectShape, float x, float y2) {
            return SpenTextManager.Native_getCursorIndex(nativeTextManager, objectShape, x, y2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getCursorRect(long nativeTextManager, int objectHandle, int cursorPos) {
            return SpenTextManager.Native_getCursorRect(nativeTextManager, objectHandle, cursorPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getCursorRectOnScreenCoordinates(long nativeTextManager, int objectHandle, int cursorPos) {
            return SpenTextManager.Native_getCursorRectOnScreenCoordinates(nativeTextManager, objectHandle, cursorPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getEndCursorHandleRect(long nativeTextManager, boolean onScreen) {
            return SpenTextManager.Native_getEndCursorHandleRect(nativeTextManager, onScreen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Pair<Integer, Integer> Native_getPageSection(long mNativeTextManager, SpenObjectShape objectShape, int pageIndex) {
            return SpenTextManager.Native_getPageSection(mNativeTextManager, objectShape, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getStartCursorHandleRect(long nativeTextManager, boolean onScreen) {
            return SpenTextManager.Native_getStartCursorHandleRect(nativeTextManager, onScreen);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getTextScale(long nativeTextManager) {
            return SpenTextManager.Native_getTextScale(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getTextSizeDelta(long nativeTextManager) {
            return SpenTextManager.Native_getTextSizeDelta(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_highlightSuggestion(long nativeTextManager, int suggestionType, int start, int end, int color) {
            SpenTextManager.Native_highlightSuggestion(nativeTextManager, suggestionType, start, end, color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeTextManager, SpenTextManager textManager) {
            SpenTextManager.Native_init(nativeTextManager, textManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isAutoScrollEnabled(long nativeTextManager) {
            return SpenTextManager.Native_isAutoScrollEnabled(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isCursorBlinkEnabled(long nativeTextManager) {
            return SpenTextManager.Native_isCursorBlinkEnabled(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onCheckObjectChangedBySelf(long mNativeTextManager, SpenObjectBase obj) {
            return SpenTextManager.Native_onCheckObjectChangedBySelf(mNativeTextManager, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_onKeyEvent(long nativeTextManager, int action, int keyCode, int metaState) {
            return SpenTextManager.Native_onKeyEvent(nativeTextManager, action, keyCode, metaState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_scrollToCursor(long nativeTextManager) {
            SpenTextManager.Native_scrollToCursor(nativeTextManager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAutoScrollEnabled(long nativeTextManager, boolean enable) {
            SpenTextManager.Native_setAutoScrollEnabled(nativeTextManager, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setCursorBlink(long nativeTextManager, boolean blink) {
            SpenTextManager.Native_setCursorBlink(nativeTextManager, blink);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setDoubleTapSelectionEnabled(long nativeTextManager, boolean enable) {
            SpenTextManager.Native_setDoubleTapSelectionEnabled(nativeTextManager, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHyperTextEnabled(long nativeTextManager, boolean enable) {
            SpenTextManager.Native_setHyperTextEnabled(nativeTextManager, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelection(long nativeTextManager, int start, int end) {
            SpenTextManager.Native_setSelection(nativeTextManager, start, end);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSelectionContextMenuForceEnabled(long nativeTextManager, boolean enable) {
            SpenTextManager.Native_setSelectionContextMenuForceEnabled(nativeTextManager, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setSuggestionText(long nativeTextManager, String suggestionText) {
            SpenTextManager.Native_setSuggestionText(nativeTextManager, suggestionText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextGradientSelectionEnabled(long nativeTextManager, boolean enable) {
            SpenTextManager.Native_setTextGradientSelectionEnabled(nativeTextManager, enable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setTextScale(long nativeTextManager, float scale) {
            SpenTextManager.Native_setTextScale(nativeTextManager, scale);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_showTextContextMenu(long nativeTextManager) {
            SpenTextManager.Native_showTextContextMenu(nativeTextManager);
        }

        private Companion() {
        }
    }

    public SpenTextManager(@Nullable View view) {
        final int i = 0;
        this.mBlinkOffRunnable = new Runnable(this) { // from class: com.samsung.android.sdk.pen.widget.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenTextManager f5125b;

            {
                this.f5125b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f5125b.blinkOff();
                        break;
                    default:
                        this.f5125b.updateSuggestionPopup();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mUpdateSuggestionPopup = new Runnable(this) { // from class: com.samsung.android.sdk.pen.widget.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenTextManager f5125b;

            {
                this.f5125b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f5125b.blinkOff();
                        break;
                    default:
                        this.f5125b.updateSuggestionPopup();
                        break;
                }
            }
        };
        SpenInputManager spenInputManager = new SpenInputManager(view);
        this.mInputManager = spenInputManager;
        spenInputManager.setActionListener(new SpenInputManager.InputManagerActionListener() { // from class: com.samsung.android.sdk.pen.widget.SpenTextManager.1
            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.InputManagerActionListener
            public void onBeforeTextChangedByKeyboard() {
                SpenTextManagerActionListener spenTextManagerActionListener = SpenTextManager.this.mActionListener;
                if (spenTextManagerActionListener != null) {
                    spenTextManagerActionListener.onBeforeTextChangedByKeyBoard();
                }
            }

            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.InputManagerActionListener
            public boolean onCheckObjectChangedByTextManager(SpenObjectBase obj) {
                return SpenTextManager.INSTANCE.Native_onCheckObjectChangedBySelf(SpenTextManager.this.mNativeTextManager, obj);
            }

            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.InputManagerActionListener
            public void onCommitContent(InputContentInfoCompat inputContentInfo) {
                SpenTextManagerActionListener spenTextManagerActionListener = SpenTextManager.this.mActionListener;
                if (spenTextManagerActionListener != null) {
                    spenTextManagerActionListener.onCommitContent(inputContentInfo);
                }
            }

            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.InputManagerActionListener
            public boolean onCommitWhitespace() {
                return SpenTextManager.INSTANCE.Native_onKeyEvent(SpenTextManager.this.mNativeTextManager, 0, 62, 0);
            }

            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.InputManagerActionListener
            public void onComposingText(CharSequence text) {
                Handler handler;
                View view2 = SpenTextManager.this.mView;
                if (view2 != null) {
                    SpenTextManager spenTextManager = SpenTextManager.this;
                    SpenConfiguration.Companion companion = SpenConfiguration.INSTANCE;
                    Context context = view2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    if (!companion.isVSTDevice(context) || (handler = spenTextManager.mHandler) == null) {
                        return;
                    }
                    handler.removeMessages(1);
                    handler.removeMessages(2);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.obj = text;
                    handler.sendMessageDelayed(messageObtain, 200L);
                }
            }
        });
        if (view != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mHashTag = new SpenHashTag(view, context);
        }
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.setHashTagListener(new SpenHashTag.HashTagListener() { // from class: com.samsung.android.sdk.pen.widget.SpenTextManager.3
                @Override // com.samsung.android.sdk.pen.widget.SpenHashTag.HashTagListener
                public RectF getScreenTextRect(SpenObjectShape objectShape, int startPos, int endPos) {
                    return objectShape == null ? new RectF() : SpenTextManager.INSTANCE.Native_getCursorRectOnScreenCoordinates(SpenTextManager.this.mNativeTextManager, objectShape.getRuntimeHandle(), endPos);
                }

                @Override // com.samsung.android.sdk.pen.widget.SpenHashTag.HashTagListener
                public void onHashTagAdded(String tagStr) {
                    SpenTextManagerActionListener spenTextManagerActionListener = SpenTextManager.this.mActionListener;
                    if (spenTextManagerActionListener != null) {
                        spenTextManagerActionListener.onHashTagAdded(tagStr);
                    } else {
                        Log.e(SpenTextManager.TAG, "onHashTagAdded - ActionListener is null");
                    }
                }
            });
        }
        this.mSuggestionListener = new SpenInputManager.SuggestionListener() { // from class: com.samsung.android.sdk.pen.widget.SpenTextManager.4
            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.SuggestionListener
            public void onHighlightSuggestion(int suggestionType, int start, int end, int color) {
                SpenTextManager.INSTANCE.Native_highlightSuggestion(SpenTextManager.this.mNativeTextManager, suggestionType, start, end, color);
            }

            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.SuggestionListener
            public void onTextSuggestion(String suggestionText) {
                SpenTextManager.INSTANCE.Native_setSuggestionText(SpenTextManager.this.mNativeTextManager, suggestionText);
            }
        };
        this.mSetSelectionListener = new SpenInputManager.SetSelectionListener() { // from class: com.samsung.android.sdk.pen.widget.SpenTextManager.5
            @Override // com.samsung.android.sdk.pen.text.SpenInputManager.SetSelectionListener
            public void onSetSelection(int start, int end) {
                if (start == end) {
                    Log.d(SpenTextManager.TAG, "onSetSelection skip!");
                } else {
                    SpenTextManager.INSTANCE.Native_setSelection(SpenTextManager.this.mNativeTextManager, start, end);
                }
            }
        };
        SpenInputManager spenInputManager2 = this.mInputManager;
        if (spenInputManager2 != null) {
            spenInputManager2.setSuggestionListener(this.mSuggestionListener);
            spenInputManager2.setSelectionListener(this.mSetSelectionListener);
        }
        this.mTextSearch = new SpenTextSearch();
        this.mView = view;
        this.mActivity = getActivity();
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.sdk.pen.widget.SpenTextManager.7
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                int i4 = msg.what;
                if (i4 == 1) {
                    SpenTextManager.this.setCursorAnchorPosition(null);
                } else if (i4 == 2) {
                    Object obj = msg.obj;
                    if (obj != null ? obj instanceof CharSequence : true) {
                        SpenTextManager.this.setCursorAnchorPosition((CharSequence) obj);
                    }
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 35) {
            this.mBackCallback = new C0109b(this, 2);
        }
        updateFontManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getCursorIndex(long j, SpenObjectShape spenObjectShape, float f, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getCursorRect(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getCursorRectOnScreenCoordinates(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getEndCursorHandleRect(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Pair<Integer, Integer> Native_getPageSection(long j, SpenObjectShape spenObjectShape, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getStartCursorHandleRect(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getTextScale(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getTextSizeDelta(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_highlightSuggestion(long j, int i, int i2, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SpenTextManager spenTextManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isAutoScrollEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isCursorBlinkEnabled(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onCheckObjectChangedBySelf(long j, SpenObjectBase spenObjectBase);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_onKeyEvent(long j, int i, int i2, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_scrollToCursor(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAutoScrollEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setCursorBlink(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setDoubleTapSelectionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHyperTextEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelection(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSelectionContextMenuForceEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setSuggestionText(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextGradientSelectionEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setTextScale(long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_showTextContextMenu(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(SpenTextManager spenTextManager) {
        SpenInputManager spenInputManager = spenTextManager.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blinkOff() {
        boolean zIsCursorBlinking = isCursorBlinking();
        this.mIsCursorBlinkOffByFocus = zIsCursorBlinking;
        AbstractC6670b.m4759t("blinkOff : ", TAG, zIsCursorBlinking);
        if (this.mIsCursorBlinkOffByFocus) {
            setCursorBlinkImpl(false);
        }
    }

    private final void blinkOn() {
        AbstractC6670b.m4759t("blinkOn : ", TAG, this.mIsCursorBlinkOffByFocus);
        if (this.mIsCursorBlinkOffByFocus) {
            setCursorBlinkImpl(true);
            this.mIsCursorBlinkOffByFocus = false;
        }
    }

    private final Activity getActivity() {
        View view = this.mView;
        for (Context context = view != null ? view.getContext() : null; context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private final void hideHashTagBubble() {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.hideConfirmView();
        }
    }

    private final boolean isCursorBlinkEnabled() {
        return INSTANCE.Native_isCursorBlinkEnabled(this.mNativeTextManager);
    }

    private final void onHyperTextClicked(String hypertext, int hypertextType, int datetimeType, SpenObjectShape objectShape, SpenHyperTextSpan span) {
        AbstractC0541b.m783y(hypertextType, datetimeType, "onHyperTextClicked : ", SQLKeyword.COMMA, TAG);
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onHyperTextClicked(hypertext, hypertextType, datetimeType, objectShape, span);
        }
    }

    private final void onHyperTextClickedWithRectAndPoint(String hypertext, int hypertextType, int datetimeType, SpenObjectShape objectShape, SpenHyperTextSpan span, RectF rect, PointF touchPoint) {
        AbstractC0541b.m783y(hypertextType, datetimeType, "onHyperTextClickedWithRectAndPoint : ", SQLKeyword.COMMA, TAG);
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onHyperTextClickedWithRectAndPoint(hypertext, hypertextType, datetimeType, objectShape, span, rect, touchPoint);
        }
    }

    private final void onItemClicked(SpenObjectShape objectShape, int type, int paragraphIndex) {
        AbstractC0541b.m783y(type, paragraphIndex, "onItemClicked : ", SQLKeyword.COMMA, TAG);
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onItemClicked(objectShape, type, paragraphIndex);
        }
    }

    private final void onMaxSelectionTextLengthReached() {
        Log.d(TAG, "onMaxSelectionTextLengthReached()");
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onMaxSelectionTextLengthReached();
        }
    }

    private final void onSelectionAreaLongPressed() {
        Log.d(TAG, "onSelectionAreaLongPressed");
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onSelectionAreaLongPressed();
        }
    }

    private final void onShowMagnifier(float x, float y2, boolean show) {
        View view;
        if (this.mMagnifier == null && (view = this.mView) != null) {
            this.mMagnifier = new SpenMagnifier(view);
        }
        if (show) {
            SpenMagnifier spenMagnifier = this.mMagnifier;
            if (spenMagnifier != null) {
                spenMagnifier.show(x, y2);
                return;
            }
            return;
        }
        SpenMagnifier spenMagnifier2 = this.mMagnifier;
        if (spenMagnifier2 != null) {
            spenMagnifier2.dismiss();
        }
    }

    private final void onSpellCorrectionTextClicked(SpenObjectShape objectShape, SpenSpellCorrectionSpan span, RectF rect, List<RectF> rectList) {
        if (objectShape == null || span == null) {
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(span.getStart(), span.getEnd(), "onSpellCorrectionTextClicked - [", "~", "], ");
        sbM1173s.append(rect);
        Log.d(TAG, sbM1173s.toString());
        SpenTextManagerActionListener spenTextManagerActionListener = this.mActionListener;
        if (spenTextManagerActionListener != null) {
            spenTextManagerActionListener.onSpellCorrectionTextClicked(objectShape, span, rect, rectList);
        }
    }

    private final void onVibrate(int vibrationPattern) {
        View view = this.mView;
        Intrinsics.checkNotNull(view);
        SpenTextUtils.performHapticFeedback(view, vibrationPattern);
    }

    private final int searchText(String originText, String searchText, float[] measureWidths, ArrayList<SpenTextSearch.SearchInfo> out) {
        SpenTextSearch spenTextSearch = this.mTextSearch;
        if (spenTextSearch != null) {
            return spenTextSearch.search(originText, searchText, measureWidths, out);
        }
        return 0;
    }

    private final void setCursorBlinkImpl(boolean enable) {
        AbstractC4539a.m3208r("setCursorBlinkImpl :", TAG, enable);
        INSTANCE.Native_setCursorBlink(this.mNativeTextManager, enable);
    }

    private final void updateFontManager() {
        View view = this.mView;
        if (view != null) {
            SpenFontManager.setSystemFontPath(view.getContext());
        }
        SpenFontManager.setLocaleList();
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void close() {
        Activity activity;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        long j = this.mNativeTextManager;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeTextManager = 0L;
        }
        SpenMagnifier spenMagnifier = this.mMagnifier;
        if (spenMagnifier != null) {
            spenMagnifier.dismiss();
            this.mMagnifier = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mCursorObject = null;
        this.mActionListener = null;
        this.mCursorChangedListener = null;
        this.mSuggestionListener = null;
        this.mSetSelectionListener = null;
        this.mControlObjectListener = null;
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.close();
            this.mHashTag = null;
        }
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.close();
            this.mInputManager = null;
        }
        if (Build.VERSION.SDK_INT >= 35 && this.mBackCallback != null && this.mIsBackCallbackRegister && (activity = this.mActivity) != null && (onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher()) != null) {
            Object obj = this.mBackCallback;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.window.OnBackInvokedCallback");
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(AbstractC0053a.m114f(obj));
        }
        this.mView = null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void finishComposingText(@Nullable SpenObjectShape objectShape) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.finishComposingText(objectShape);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    /* JADX INFO: renamed from: getAutoBlinkOffOnWindowFocusChanged, reason: from getter */
    public boolean getMIsAutoBlinkOffOnWindowFocusChanged() {
        return this.mIsAutoBlinkOffOnWindowFocusChanged;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public int getCurosrIndex(@NotNull SpenObjectShape objectShape, @NotNull PointF position) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        Intrinsics.checkNotNullParameter(position, "position");
        return INSTANCE.Native_getCursorIndex(this.mNativeTextManager, objectShape, position.x, position.y);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getCursorRect(@NotNull SpenObjectShape objectShape, int cursorPos) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        return INSTANCE.Native_getCursorRect(this.mNativeTextManager, objectShape.getRuntimeHandle(), cursorPos);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getCursorRectOnScreenCoordinates(@NotNull SpenObjectShape objectShape, int cursorPos) {
        Intrinsics.checkNotNullParameter(objectShape, "objectShape");
        return INSTANCE.Native_getCursorRectOnScreenCoordinates(this.mNativeTextManager, objectShape.getRuntimeHandle(), cursorPos);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getEndCursorHandleRect(boolean onViewCoordinates) {
        long j = this.mNativeTextManager;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getEndCursorHandleRect(j, onViewCoordinates);
    }

    @NotNull
    public final Runnable getMBlinkOffRunnable() {
        return this.mBlinkOffRunnable;
    }

    @Nullable
    public final SpenInputManager getMInputManager() {
        return this.mInputManager;
    }

    @NotNull
    public final Runnable getMUpdateSuggestionPopup() {
        return this.mUpdateSuggestionPopup;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public Triple<Editable, Integer, Integer> getObjectEditable(int nativeID, int pageIndex) {
        SpenInputManager spenInputManager;
        SpenObjectShape mObjectText;
        if (this.mNativeTextManager != 0 && (spenInputManager = this.mInputManager) != null && (mObjectText = spenInputManager.getMObjectText()) != null && mObjectText.getRuntimeHandle() == nativeID) {
            Companion companion = INSTANCE;
            long j = this.mNativeTextManager;
            SpenInputManager spenInputManager2 = this.mInputManager;
            Pair pairNative_getPageSection = companion.Native_getPageSection(j, spenInputManager2 != null ? spenInputManager2.getMObjectText() : null, pageIndex);
            if (pairNative_getPageSection != null) {
                SpenInputManager spenInputManager3 = this.mInputManager;
                return new Triple<>(spenInputManager3 != null ? spenInputManager3.getMEditable() : null, pairNative_getPageSection.getFirst(), Integer.valueOf(((Number) pairNative_getPageSection.getSecond()).intValue() + ((Number) pairNative_getPageSection.getFirst()).intValue()));
            }
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public SpenObjectBase getSelectedObject() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public RectF getStartCursorHandleRect(boolean onViewCoordinates) {
        long j = this.mNativeTextManager;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getStartCursorHandleRect(j, onViewCoordinates);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public float getTextScale() {
        return INSTANCE.Native_getTextScale(this.mNativeTextManager);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public int getTextSizeDelta() {
        int i = this.mTextSizeDelta;
        return i != Integer.MIN_VALUE ? i : INSTANCE.Native_getTextSizeDelta(this.mNativeTextManager);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean isAutoFocusEnabled() {
        return INSTANCE.Native_isAutoScrollEnabled(this.mNativeTextManager);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean isCursorBlinking() {
        return isCursorBlinkEnabled() || this.mIsCursorBlinkOffByFocus;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onAttachedToWindow() {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.onAttachedToWindow();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onConfigurationChanged() {
        updateFontManager();
        hideHashTagBubble();
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager == null || !spenInputManager.isSuggestionPopupShowing()) {
            return;
        }
        spenInputManager.dismissSuggestionPopup(false);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mUpdateSuggestionPopup);
            handler.postDelayed(this.mUpdateSuggestionPopup, 600L);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectButtonClicked(@Nullable SpenObjectBase objectShape) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemButtonClicked(objectShape);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectClicked(int tooltype, @Nullable SpenObjectBase objectShape) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemClicked(tooltype, objectShape);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onControlObjectLongClicked(int tooltype, @Nullable SpenObjectBase objectShape) {
        SpenControlObjectListener spenControlObjectListener = this.mControlObjectListener;
        if (spenControlObjectListener != null) {
            return spenControlObjectListener.onItemLongClicked(tooltype, objectShape);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            return spenInputManager.onCreateInputConnection(outAttrs);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onCursorChanged(int start, int end, boolean editable) {
        Activity activity;
        if (this.mCurStart == start && this.mCurEnd == end) {
            Log.i(TAG, "onCursorChanged: cursor was not changed. Skip!");
            return;
        }
        this.mCurStart = start;
        this.mCurEnd = end;
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            if (spenInputManager.getWNote() != null) {
                SpenWNote wNote = spenInputManager.getWNote();
                Intrinsics.checkNotNull(wNote);
                if (!SpenTextUtils.isUndoRedoIncompletely(wNote)) {
                    if (start == end) {
                        SpenHashTag spenHashTag = this.mHashTag;
                        if (spenHashTag != null) {
                            spenHashTag.updateHashTag(this.mCursorObject, start);
                        }
                    } else {
                        SpenHashTag spenHashTag2 = this.mHashTag;
                        if (spenHashTag2 != null) {
                            spenHashTag2.updateHashTag();
                        }
                    }
                }
            }
            spenInputManager.setSelection(start, end);
        }
        if (Build.VERSION.SDK_INT >= 35 && this.mBackCallback != null && (activity = this.mActivity) != null) {
            if (this.mIsEditable && editable && this.mCurStart != this.mCurEnd && !this.mIsBackCallbackRegister) {
                Log.i(TAG, "onCursorChanged: register OnBackInvokedCallback");
                OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
                Object obj = this.mBackCallback;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.window.OnBackInvokedCallback");
                onBackInvokedDispatcher.registerOnBackInvokedCallback(1000000, AbstractC0053a.m114f(obj));
                this.mIsBackCallbackRegister = true;
            } else if (this.mCurStart == this.mCurEnd && this.mIsBackCallbackRegister) {
                Log.i(TAG, "onCursorChanged: unregister OnBackInvokedCallback");
                OnBackInvokedDispatcher onBackInvokedDispatcher2 = activity.getOnBackInvokedDispatcher();
                Object obj2 = this.mBackCallback;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.window.OnBackInvokedCallback");
                onBackInvokedDispatcher2.unregisterOnBackInvokedCallback(AbstractC0053a.m114f(obj2));
                this.mIsBackCallbackRegister = false;
            }
        }
        SpenCursorChangedListener spenCursorChangedListener = this.mCursorChangedListener;
        if (spenCursorChangedListener != null) {
            spenCursorChangedListener.onChanged(start, end);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
            handler.removeMessages(2);
            handler.sendEmptyMessageDelayed(1, 200L);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onCursorObjectChanged(@Nullable SpenObjectShape objectShape, boolean editable) {
        SpenCursorChangedListener spenCursorChangedListener;
        if (objectShape == null && this.mCursorObject != null && (spenCursorChangedListener = this.mCursorChangedListener) != null) {
            spenCursorChangedListener.onChanged(-1, -1);
        }
        this.mCursorObject = objectShape;
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            if (!this.mIsEditable || !editable) {
                objectShape = null;
            }
            spenInputManager.setObjectText(objectShape);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onFocusChanged(boolean gainFocus) {
        if (this.mNativeTextManager == 0 || this.mHandler == null) {
            return;
        }
        AbstractC6670b.m4759t("onFocusChanged : ", TAG, gainFocus);
        if (this.mGainFocus != gainFocus) {
            this.mGainFocus = gainFocus;
            if (gainFocus) {
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.mBlinkOffRunnable);
                }
                blinkOn();
                return;
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(this.mBlinkOffRunnable, 300L);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onInsertLineFeed(@Nullable SpenObjectShape objectShape, int count) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.onInsertLineFeed(objectShape, count);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (INSTANCE.Native_onKeyEvent(this.mNativeTextManager, event.getAction(), keyCode, event.getMetaState())) {
            Log.i(TAG, "onKeyDown consume the event");
            return true;
        }
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            return spenInputManager.onKeyDown(keyCode, event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        SpenInputManager spenInputManager;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Build.VERSION.SDK_INT >= 35 || (spenInputManager = this.mInputManager) == null) {
            return false;
        }
        return spenInputManager.onKeyPreIme(keyCode, event);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            return spenInputManager.onKeyShortcut(keyCode, event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            return spenInputManager.onKeyUp(keyCode, event);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onLayout(boolean changed) {
        if (changed) {
            updateHashTagPosition();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 200L);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onParentTouchEvent(@Nullable MotionEvent event) {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.onParentTouchEvent(event);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.onPopulateAccessibilityEvent(event);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onShowSoftInput(boolean show) {
        View view = this.mView;
        if (view != null) {
            if (show) {
                SpenInputManager spenInputManager = this.mInputManager;
                if (spenInputManager != null) {
                    spenInputManager.showSoftInput();
                    return;
                }
                return;
            }
            if (SpenInputManager.INSTANCE.isInputMethodShown(view.getContext())) {
                SpenInputManager spenInputManager2 = this.mInputManager;
                if (spenInputManager2 != null) {
                    spenInputManager2.hideSoftInput(200L);
                }
            } else {
                Log.d(TAG, "onShowSoftInput(false) is skipped!");
            }
            SpenHashTag spenHashTag = this.mHashTag;
            if (spenHashTag != null) {
                spenHashTag.updateHashTag();
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onSuggestionTextClicked(@Nullable SpenSuggestionSpan span, @NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.onSuggestionTextClicked(span, rect);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onTextScaleChanged(float scale) {
        SpenTextScaleListener spenTextScaleListener = this.mTextScaleListener;
        if (spenTextScaleListener != null) {
            spenTextScaleListener.onTextScaleChanged(scale);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onViewClicked() {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.viewClicked();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        View view;
        if (this.mNativeTextManager == 0 || this.mHandler == null || (view = this.mView) == null || !view.isFocused()) {
            return;
        }
        boolean z = this.mIsAutoBlinkOffOnWindowFocusChanged;
        if (!z) {
            AbstractC6670b.m4758s("onWindowFocusChanged : ", ", isAutoBlinkOff :", TAG, hasWindowFocus, z);
            return;
        }
        AbstractC6670b.m4759t("onWindowFocusChanged : ", TAG, hasWindowFocus);
        if (this.mHasWindowFocus != hasWindowFocus) {
            this.mHasWindowFocus = hasWindowFocus;
            if (hasWindowFocus) {
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.mBlinkOffRunnable);
                }
                blinkOn();
                return;
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.postDelayed(this.mBlinkOffRunnable, 300L);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setActionListener(@Nullable SpenTextManagerActionListener listener) {
        this.mActionListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setAutoBlinkOffOnWindowFocusChanged(boolean z) {
        AbstractC4539a.m3208r("setAutoBlinkOffOnWindowFocusChanged : ", TAG, z);
        this.mIsAutoBlinkOffOnWindowFocusChanged = z;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setAutoFocusEnabled(boolean z) {
        AbstractC4539a.m3208r("setAutoFocusEnabled : ", TAG, z);
        INSTANCE.Native_setAutoScrollEnabled(this.mNativeTextManager, z);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setControlObjectListener(@Nullable SpenControlObjectListener listener) {
        this.mControlObjectListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorAnchorPosition(@Nullable CharSequence composingText) {
        SpenObjectBase selectedObject;
        RectF cursorRectOnScreenCoordinates;
        View view = this.mView;
        if (view == null || (selectedObject = getSelectedObject()) == null) {
            return;
        }
        SpenObjectShape spenObjectShape = selectedObject instanceof SpenObjectShape ? (SpenObjectShape) selectedObject : null;
        if (spenObjectShape == null) {
            return;
        }
        int cursorPosition = spenObjectShape.getCursorPosition() != -1 ? spenObjectShape.getCursorPosition() : spenObjectShape.getSelectedEnd();
        if (cursorPosition >= 0 && (cursorRectOnScreenCoordinates = getCursorRectOnScreenCoordinates(spenObjectShape, cursorPosition)) != null) {
            view.getLocationOnScreen(new int[2]);
            setCursorAnchorPosition(view, composingText, new PointF(r2[0], r2[1]), cursorRectOnScreenCoordinates);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorBlink(boolean enable) {
        AbstractC4539a.m3208r("setCursorBlink :", TAG, enable);
        if (!enable) {
            onShowSoftInput(false);
        }
        setCursorBlinkImpl(enable);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorChangedListener(@Nullable SpenCursorChangedListener listener) {
        this.mCursorChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setDoubleTapSelectionEnabled(boolean enable) {
        AbstractC6670b.m4759t("setDoubleTapSelectionEnabled : ", TAG, enable);
        INSTANCE.Native_setDoubleTapSelectionEnabled(this.mNativeTextManager, enable);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setEditable(boolean enable) {
        AbstractC6670b.m4759t("setEditable :", TAG, enable);
        if (this.mIsEditable != enable) {
            this.mIsEditable = enable;
            SpenInputManager spenInputManager = this.mInputManager;
            if (spenInputManager != null) {
                if (!enable) {
                    spenInputManager.setObjectText(null);
                } else {
                    spenInputManager.setObjectText(this.mCursorObject);
                    spenInputManager.setSelection(this.mCurStart, this.mCurEnd);
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setHashTagEnabled(boolean enable) {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.setEnabled(enable);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setHyperTextEnabled(boolean enable) {
        AbstractC6670b.m4759t("setHyperTextEnabled : ", TAG, enable);
        INSTANCE.Native_setHyperTextEnabled(this.mNativeTextManager, enable);
    }

    public final void setMBlinkOffRunnable(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.mBlinkOffRunnable = runnable;
    }

    public final void setMInputManager(@Nullable SpenInputManager spenInputManager) {
        this.mInputManager = spenInputManager;
    }

    public final void setMUpdateSuggestionPopup(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.mUpdateSuggestionPopup = runnable;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setNativeHandle(long handle) {
        this.mNativeTextManager = handle;
        INSTANCE.Native_init(handle, this);
    }

    public final void setPerformContextMenuActionListener$SDK_fullRelease(@Nullable SpenInputManager.PerformContextMenuActionListener listener) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.setPerformContextMenuActionListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setSelectionContextMenuForceEnabled(boolean enable) {
        INSTANCE.Native_setSelectionContextMenuForceEnabled(this.mNativeTextManager, enable);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setSoftInputListener(@Nullable SpenSoftInputListener listener) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.setSoftInputListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTagList(@Nullable ArrayList<String> list) {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.setTagList(list);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextGradientSelectionEnabled(boolean enable) {
        long j = this.mNativeTextManager;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setTextGradientSelectionEnabled(j, enable);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextInputBlock(boolean setBlock) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.setTextInputBlock(setBlock);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextLimitListener(@Nullable SpenTextLimitListener listener) {
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            spenInputManager.setTextLimitListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextScale(float f) {
        Log.d(TAG, "setTextScale = " + f);
        INSTANCE.Native_setTextScale(this.mNativeTextManager, f);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setTextScaleListener(@Nullable SpenTextScaleListener listener) {
        this.mTextScaleListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void showTextContextMenu() {
        INSTANCE.Native_showTextContextMenu(this.mNativeTextManager);
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void updateHashTagPosition() {
        SpenHashTag spenHashTag = this.mHashTag;
        if (spenHashTag != null) {
            spenHashTag.updateConfirmViewPosition();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void updateSuggestionPopup() {
        RectF cursorRectOnScreenCoordinates;
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager != null) {
            INSTANCE.Native_scrollToCursor(this.mNativeTextManager);
            SpenObjectBase selectedObject = getSelectedObject();
            if (selectedObject == null || !(selectedObject instanceof SpenObjectShape)) {
                return;
            }
            SpenObjectShape spenObjectShape = (SpenObjectShape) selectedObject;
            int cursorPosition = spenObjectShape.getCursorPosition() != -1 ? spenObjectShape.getCursorPosition() : spenObjectShape.getSelectedEnd();
            if (cursorPosition < 0 || (cursorRectOnScreenCoordinates = getCursorRectOnScreenCoordinates(spenObjectShape, cursorPosition)) == null) {
                return;
            }
            spenInputManager.updateSuggestionPopup(cursorRectOnScreenCoordinates, true);
        }
    }

    private final void onShowMagnifier(float srcCenterX, float srcCenterY, float magnifierY, boolean show) {
        View view;
        if (this.mMagnifier == null && (view = this.mView) != null) {
            this.mMagnifier = new SpenMagnifier(view);
        }
        if (show) {
            SpenMagnifier spenMagnifier = this.mMagnifier;
            if (spenMagnifier != null) {
                spenMagnifier.show(srcCenterX, srcCenterY, magnifierY);
                return;
            }
            return;
        }
        SpenMagnifier spenMagnifier2 = this.mMagnifier;
        if (spenMagnifier2 != null) {
            spenMagnifier2.dismiss();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.SpenITextManager
    public void setCursorAnchorPosition(@NotNull View view, @Nullable CharSequence composingText, @NotNull PointF viewPosition, @NotNull RectF cursorAnchorRect) {
        SpenInputConnection inputConnection;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewPosition, "viewPosition");
        Intrinsics.checkNotNullParameter(cursorAnchorRect, "cursorAnchorRect");
        SpenInputManager spenInputManager = this.mInputManager;
        if (spenInputManager == null || (inputConnection = spenInputManager.getInputConnection()) == null) {
            return;
        }
        SpenTextUtils.updateCursorAnchorInfo(view, inputConnection, composingText, viewPosition, cursorAnchorRect);
    }
}
