package com.samsung.android.sdk.pen.text;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TextKeyListener;
import android.text.style.BackgroundColorSpan;
import android.text.style.SuggestionSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedTextInfo;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenComposingSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenPredefinedStyleParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenSuggestionSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.engine.util.SpenEngineUtil;
import com.samsung.android.sdk.pen.text.SpenInputManager;
import com.samsung.android.sdk.pen.text.SpenSuggestionPopup;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.spen.libwrapper.KeyEventWrapper;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p017D1.C0061b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¡\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001]\u0018\u0000 Î\u00012\u00020\u0001:\u000eÈ\u0001É\u0001Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020JJU\u0010V\u001a\u00020T2M\u0010W\u001aI\u0012\u0013\u0012\u00110M¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020\u0013\u0018\u00010LJ\u0006\u0010_\u001a\u00020TJ\u0010\u0010`\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010,J\u0010\u0010b\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010.J\u0010\u0010c\u001a\u00020T2\b\u0010d\u001a\u0004\u0018\u000104J\u0010\u0010e\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010:J\u0010\u0010f\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010<J\u0010\u0010g\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010>J\u0010\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020\u0013H\u0002J\u000e\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020\u0013J\u001c\u0010l\u001a\u00020T2\b\u0010m\u001a\u0004\u0018\u00010D2\b\u0010n\u001a\u0004\u0018\u00010oH\u0002J\u0010\u0010p\u001a\u00020T2\b\u0010q\u001a\u0004\u0018\u00010\u0017J\u0010\u0010r\u001a\u00020T2\b\u0010s\u001a\u0004\u0018\u00010\tJ\u0006\u0010t\u001a\u00020TJ\u0006\u0010u\u001a\u00020TJ\u000e\u0010v\u001a\u00020T2\u0006\u0010w\u001a\u00020xJ\u0010\u0010y\u001a\u00020T2\b\u0010m\u001a\u0004\u0018\u00010DJ\u0006\u0010z\u001a\u00020TJ\u0010\u0010{\u001a\u0004\u0018\u00010D2\u0006\u0010|\u001a\u00020\u0013J\u0006\u0010}\u001a\u00020\u0007J\u0006\u0010~\u001a\u00020\u0007J\u0006\u0010\u007f\u001a\u00020\u0007J\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u0019\u0010\u0081\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u0007J\u0010\u0010\u0084\u0001\u001a\u00020T2\u0007\u0010\u0085\u0001\u001a\u00020\u0013J\u0007\u0010\u0086\u0001\u001a\u00020\u0013J\u001a\u0010\u0087\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u0013J\u001a\u0010\u008c\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u001a\u0010\u008d\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u001a\u0010\u008e\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u0012\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\u0011\u0010\u0093\u0001\u001a\u00020T2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\t\u0010\u0094\u0001\u001a\u00020TH\u0002J\t\u0010\u0095\u0001\u001a\u00020TH\u0002J\u0013\u0010\u0096\u0001\u001a\u00020T2\b\u0010m\u001a\u0004\u0018\u00010DH\u0002J\t\u0010\u0097\u0001\u001a\u00020TH\u0002J\t\u0010\u0098\u0001\u001a\u00020TH\u0002J,\u0010\u0099\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u00072\u0006\u0010m\u001a\u00020DH\u0002J\u001b\u0010\u009e\u0001\u001a\u00020\u00132\u0007\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u0013H\u0002J\u0012\u0010¡\u0001\u001a\u00020\u00132\u0007\u0010\u009f\u0001\u001a\u00020\u0007H\u0002J\t\u0010¢\u0001\u001a\u00020\u0007H\u0002J\t\u0010£\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010\u0093\u0001\u001a\u00020\u00132\u0007\u0010\u0088\u0001\u001a\u00020\u00072\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010¤\u0001\u001a\u00020\u00132\u0007\u0010¥\u0001\u001a\u00020\u0007H\u0002J\u0019\u0010¦\u0001\u001a\u00020\u00132\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u0007J\u001b\u0010§\u0001\u001a\u00020T2\u0007\u0010¨\u0001\u001a\u00020D2\u0007\u0010©\u0001\u001a\u00020DH\u0002J\u0011\u0010ª\u0001\u001a\u00020T2\b\u0010\u0089\u0001\u001a\u00030«\u0001J\t\u0010¬\u0001\u001a\u00020TH\u0002J\u0012\u0010¬\u0001\u001a\u00020T2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\tJ\u001b\u0010®\u0001\u001a\u00020T2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0013\u0010°\u0001\u001a\u00020\u00072\b\u0010±\u0001\u001a\u00030²\u0001H\u0002J\t\u0010³\u0001\u001a\u00020TH\u0002J$\u0010³\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u009a\u0001\u001a\u00020\u00072\u0007\u0010´\u0001\u001a\u00020\u0007H\u0002J\u001b\u0010µ\u0001\u001a\u00020T2\u0007\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0083\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010¶\u0001\u001a\u00020\u0013J\u0010\u0010·\u0001\u001a\u00020T2\u0007\u0010¸\u0001\u001a\u00020\u0013J\u001a\u0010¹\u0001\u001a\u00020T2\b\u0010º\u0001\u001a\u00030»\u00012\u0007\u0010¼\u0001\u001a\u00020\u0013J\u001d\u0010½\u0001\u001a\u00020T2\n\u0010±\u0001\u001a\u0005\u0018\u00010¾\u00012\b\u0010¿\u0001\u001a\u00030»\u0001J%\u0010À\u0001\u001a\u00020T2\u0007\u0010Á\u0001\u001a\u00020\u00072\u0007\u0010Â\u0001\u001a\u00020\u00072\b\u0010m\u001a\u0004\u0018\u00010DH\u0002J\t\u0010Ã\u0001\u001a\u00020TH\u0002J\u0010\u0010Ä\u0001\u001a\u00020T2\u0007\u0010Å\u0001\u001a\u00020\u0013J\u0014\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010Ç\u0001\u001a\u00020\u0017H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0016\u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0018\u00010&R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010K\u001aI\u0012\u0013\u0012\u00110M¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(R\u0012\u0004\u0012\u00020\u0013\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0004\n\u0002\u0010^R\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ï\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager;", "", "mView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mDebugLevel", "", "mObjectText", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "getMObjectText", "()Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "setMObjectText", "(Lcom/samsung/android/sdk/pen/document/SpenObjectShape;)V", "mBackupSpanList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "Lkotlin/collections/ArrayList;", "mIsEditingByUser", "", "mIsInsertingLineFeed", "mIsShiftDpadSelection", "value", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "wNote", "getWNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "mEditable", "Landroid/text/Editable;", "getMEditable", "()Landroid/text/Editable;", "setMEditable", "(Landroid/text/Editable;)V", "Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection;", "inputConnection", "getInputConnection", "()Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection;", "mChangeWatcher", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$ChangeWatcher;", "mKeyListener", "Landroid/text/method/KeyListener;", "mAccessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "mSoftInputListener", "Lcom/samsung/android/sdk/pen/text/SpenSoftInputListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$InputManagerActionListener;", "mObjectEventListener", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$ObjectEventListener;", "mHistoryEventListener", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$HistoryEventListener;", "mSuggestionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$SuggestionListener;", "mSuggestionPopup", "Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup;", "mSuggestionPopupListener", "Lcom/samsung/android/sdk/pen/text/SpenSuggestionPopup$ActionListener;", "mSetSelectionListener", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$SetSelectionListener;", "mTextLimitListener", "Lcom/samsung/android/sdk/pen/text/SpenTextLimitListener;", "mPerformContextMenuAction", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$PerformContextMenuActionListener;", "mAutoCorrectionHighlightColor", "mIsTextInputBlocked", "mIsTextComposingStateStarted", "mHasComposingSpan", "mAddPrivateImeSettings", "", "getMAddPrivateImeSettings", "()Ljava/lang/String;", "setMAddPrivateImeSettings", "(Ljava/lang/String;)V", "mPreCommitRegex", "Lkotlin/text/Regex;", "mPreCommitCheckFunction", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "composingStart", "composingEnd", "setPreCommitRegex", "", "preCommitRegex", "setPreCommitCheckFunction", "func", "mBodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "mBodyTextContextDocument", "mIsInputBlockedDueToNoteHeightLimit", "mPreUpdateTextListener", "com/samsung/android/sdk/pen/text/SpenInputManager$mPreUpdateTextListener$1", "Lcom/samsung/android/sdk/pen/text/SpenInputManager$mPreUpdateTextListener$1;", "close", "setSoftInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "setSuggestionListener", "action", "setSelectionListener", "setTextLimitListener", "setPerformContextMenuActionListener", "blockTextInput", "blocked", "setTextInputBlock", "setBlock", "updateEditable", "str", "info", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedTextInfo;", "setDocument", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "setObjectText", "textObj", "viewClicked", "showSoftInput", "hideSoftInput", "delay", "", "appendText", "removeText", "getText", "selectedText", "getSelectionStart", "getSelectionEnd", "getComposingSpanStart", "getComposingSpanEnd", "setSelection", "start", "end", "selectAll", "showContext", "canSelectAllText", "onKeyPreIme", "keyCode", "event", "Landroid/view/KeyEvent;", "onBackPressed", "onKeyDown", "onKeyUp", "onKeyShortcut", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "sendKeyEvent", "initEditable", "initInputConnection", "initKeyListener", "setChangeWatcher", "removeChangeWatcher", "updateContent", "before", "surroundingTextLength", "mTextComposingListener", "Lcom/samsung/android/sdk/pen/text/inputmethod/SpenInputConnection$TextComposingListener;", "removeBullet", "paraIdx", "withEnter", "removeIndent", "makeImeOption", "makeInputType", "removeComposingSpan", "removeType", "hasComposingSpan", "printLog", "tag", "msg", "onPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "finishComposingText", "objectShape", "onInsertLineFeed", "count", "getUnderlineColor", "span", "Landroid/text/style/SuggestionSpan;", "removeSuggestionSpan", "after", "removeSuggestionSpanByObject", "isSuggestionPopupShowing", "dismissSuggestionPopup", "clearHighLight", "updateSuggestionPopup", "cursorRect", "Landroid/graphics/RectF;", "clearHighLightOnDismiss", "onSuggestionTextClicked", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSuggestionSpan;", "rect", "replaceTextByEditable", "st", "en", "restartInputConnection", "setFixedContentHeightEnabled", "enable", "copyNote", "srcNote", "InputManagerActionListener", "SuggestionListener", "SetSelectionListener", "PerformContextMenuActionListener", "PreUpdateTextListener", "ChangeWatcher", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenInputManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenInputManager.kt\ncom/samsung/android/sdk/pen/text/SpenInputManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1788:1\n1#2:1789\n*E\n"})
public final class SpenInputManager {

    @NotNull
    private static final String AUTO_COMPLETION_SUGGESTION_KEY_STRING = "suggestionText";

    @NotNull
    private static final String AUTO_COMPLETION_SUGGESTION_PRIVATE_CMD = "com.samsung.android.honeyboard.action.AUTO_COMPLETION_SUGGESTION";
    private static final int AUTO_CORRECTION_HIGHLIGHT_COLOR = 3388901;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenInputManager";
    private static final int TYPE_COMPOSING_ALL = 98304;

    @Nullable
    private SpenInputConnection inputConnection;

    @Nullable
    private AccessibilityManager mAccessibilityManager;

    @Nullable
    private InputManagerActionListener mActionListener;

    @Nullable
    private ArrayList<SpenTextSpanBase> mBackupSpanList;

    @Nullable
    private SpenBodyTextContext mBodyTextContext;

    @Nullable
    private SpenWNote mBodyTextContextDocument;

    @Nullable
    private ChangeWatcher mChangeWatcher;
    private int mDebugLevel;

    @Nullable
    private Editable mEditable;
    private boolean mHasComposingSpan;

    @Nullable
    private SpenWNote.HistoryEventListener mHistoryEventListener;
    private boolean mIsEditingByUser;
    private boolean mIsInputBlockedDueToNoteHeightLimit;
    private boolean mIsInsertingLineFeed;
    private boolean mIsShiftDpadSelection;
    private boolean mIsTextComposingStateStarted;
    private boolean mIsTextInputBlocked;

    @Nullable
    private KeyListener mKeyListener;

    @Nullable
    private SpenWNote.ObjectEventListener mObjectEventListener;

    @Nullable
    private SpenObjectShape mObjectText;

    @Nullable
    private PerformContextMenuActionListener mPerformContextMenuAction;

    @Nullable
    private Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> mPreCommitCheckFunction;

    @Nullable
    private SetSelectionListener mSetSelectionListener;

    @Nullable
    private SpenSoftInputListener mSoftInputListener;

    @Nullable
    private SuggestionListener mSuggestionListener;

    @Nullable
    private SpenSuggestionPopup mSuggestionPopup;

    @Nullable
    private SpenSuggestionPopup.ActionListener mSuggestionPopupListener;

    @NotNull
    private final SpenInputConnection.TextComposingListener mTextComposingListener;

    @Nullable
    private SpenTextLimitListener mTextLimitListener;

    @Nullable
    private View mView;

    @Nullable
    private SpenWNote wNote;
    private int mAutoCorrectionHighlightColor = AUTO_CORRECTION_HIGHLIGHT_COLOR;

    @NotNull
    private String mAddPrivateImeSettings = "";

    @NotNull
    private Regex mPreCommitRegex = new Regex("(?s)^.{10,}$");

    @NotNull
    private SpenInputManager$mPreUpdateTextListener$1 mPreUpdateTextListener = new SpenInputManager$mPreUpdateTextListener$1(this);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0016J<\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J,\u0010\u001b\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J,\u0010\u001d\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$ChangeWatcher;", "Landroid/text/TextWatcher;", "Landroid/text/SpanWatcher;", "<init>", "(Lcom/samsung/android/sdk/pen/text/SpenInputManager;)V", "mBeforeText", "", "beforeTextChanged", "", "buffer", "start", "", "before", "after", "onTextChanged", "text", "afterTextChanged", "Landroid/text/Editable;", "onSpanChanged", "buf", "Landroid/text/Spannable;", "what", "", "oldStart", "oldEnd", "newStart", "newEnd", "onSpanAdded", "end", "onSpanRemoved", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ChangeWatcher implements TextWatcher, SpanWatcher {

        @Nullable
        private CharSequence mBeforeText;

        public ChangeWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable buffer) {
            SpenInputConnection inputConnection = SpenInputManager.this.getInputConnection();
            if (inputConnection != null) {
                inputConnection.setDeletedSurroundingTextLength(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence buffer, int start, int before, int after) {
            InputManagerActionListener inputManagerActionListener;
            AccessibilityManager accessibilityManager = SpenInputManager.this.mAccessibilityManager;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                this.mBeforeText = String.valueOf(buffer);
            }
            if (SpenInputManager.this.mIsEditingByUser && (inputManagerActionListener = SpenInputManager.this.mActionListener) != null) {
                inputManagerActionListener.onBeforeTextChangedByKeyboard();
            }
            SpenInputManager.this.removeSuggestionSpan(start, before, after);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(@Nullable Spannable buf, @Nullable Object what, int start, int end) {
            if (what == null) {
                SpenInputManager.this.printLog(SpenInputManager.TAG, AbstractC0622a.m1164j(start, end, "onSpanAdded() start : ", ", end : ", ", what : null"));
                return;
            }
            SpenInputManager spenInputManager = SpenInputManager.this;
            String simpleName = what.getClass().getSimpleName();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(start, end, "onSpanAdded() start : ", ", end : ", ", what : ");
            sbM1173s.append(simpleName);
            spenInputManager.printLog(SpenInputManager.TAG, sbM1173s.toString());
            SpenObjectShape mObjectText = SpenInputManager.this.getMObjectText();
            if (mObjectText != null) {
                SpenInputManager spenInputManager2 = SpenInputManager.this;
                if (what instanceof UnderlineSpan) {
                    int composingSpanStart = spenInputManager2.getComposingSpanStart();
                    int composingSpanEnd = spenInputManager2.getComposingSpanEnd();
                    if ((composingSpanStart == -1 && composingSpanEnd == -1) || spenInputManager2.hasComposingSpan(composingSpanStart, composingSpanEnd)) {
                        return;
                    }
                    spenInputManager2.mHasComposingSpan = true;
                    SpenComposingSpan spenComposingSpan = new SpenComposingSpan();
                    spenComposingSpan.setPosition(composingSpanStart, composingSpanEnd);
                    spenComposingSpan.setExpansion(3);
                    spenComposingSpan.setComposingStyleEnabled(true);
                    mObjectText.appendTextSpan(spenComposingSpan);
                    return;
                }
                if (!(what instanceof SuggestionSpan)) {
                    if (what instanceof BackgroundColorSpan) {
                        SpenComposingBackgroundColorSpan spenComposingBackgroundColorSpan = new SpenComposingBackgroundColorSpan();
                        spenComposingBackgroundColorSpan.setColor(((BackgroundColorSpan) what).getBackgroundColor());
                        spenComposingBackgroundColorSpan.setPosition(start, end);
                        mObjectText.appendTextSpan(spenComposingBackgroundColorSpan);
                        return;
                    }
                    return;
                }
                SuggestionSpan suggestionSpan = (SuggestionSpan) what;
                int flags = suggestionSpan.getFlags();
                int underlineColor = spenInputManager2.getUnderlineColor(suggestionSpan);
                if ((flags & 4) != 0) {
                    spenInputManager2.mAutoCorrectionHighlightColor = underlineColor;
                }
                SpenSuggestionSpan spenSuggestionSpan = new SpenSuggestionSpan();
                spenSuggestionSpan.setPosition(start, end);
                spenSuggestionSpan.setExpansion(2);
                spenSuggestionSpan.setUnderlineColor(underlineColor);
                spenSuggestionSpan.setSuggestionType(flags);
                if ((flags & 3) != 0) {
                    String[] suggestions = suggestionSpan.getSuggestions();
                    spenSuggestionSpan.setSuggestions(new ArrayList<>(CollectionsKt.listOf(Arrays.copyOf(suggestions, suggestions.length))));
                }
                mObjectText.appendTextSpan(spenSuggestionSpan);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(@Nullable Spannable buf, @Nullable Object what, int oldStart, int oldEnd, int newStart, int newEnd) {
            SpenObjectShape mObjectText = SpenInputManager.this.getMObjectText();
            if (mObjectText != null) {
                SpenInputManager spenInputManager = SpenInputManager.this;
                Intrinsics.checkNotNull(buf);
                Intrinsics.checkNotNull(what);
                int newCursorPosition = SpenEngineUtil.getNewCursorPosition(buf, what, oldStart, oldEnd, newStart, newEnd);
                if (newCursorPosition != -1) {
                    spenInputManager.printLog(SpenInputManager.TAG, AbstractC1038a.m1214o(newCursorPosition, mObjectText.getCursorPosition(), "onSpanChanged() newCursorPos : ", ", cursorPos : "));
                }
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(@Nullable Spannable buf, @Nullable Object what, int start, int end) {
            if (what != null) {
                SpenInputManager spenInputManager = SpenInputManager.this;
                String simpleName = what.getClass().getSimpleName();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(start, end, "onSpanRemoved() start : ", ", end : ", ", what : ");
                sbM1173s.append(simpleName);
                spenInputManager.printLog(SpenInputManager.TAG, sbM1173s.toString());
                if (what instanceof BackgroundColorSpan) {
                    SpenInputManager.this.removeComposingSpan(32768);
                } else if (what instanceof SuggestionSpan) {
                    SpenInputManager.this.removeSuggestionSpanByObject(start, end);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int after) {
            SpenInputConnection inputConnection;
            try {
                if (before == after && after == 0) {
                    Log.i(SpenInputManager.TAG, "onTextChanged - There's no change. Skip!");
                    return;
                }
                if (SpenInputManager.this.getMObjectText() == null || !SpenInputManager.this.mIsEditingByUser || SpenInputManager.this.mIsTextInputBlocked) {
                    return;
                }
                InputManagerActionListener inputManagerActionListener = SpenInputManager.this.mActionListener;
                if ((inputManagerActionListener != null && inputManagerActionListener.onCheckObjectChangedByTextManager(SpenInputManager.this.getMObjectText())) || SpenInputManager.this.mIsInputBlockedDueToNoteHeightLimit || (inputConnection = SpenInputManager.this.getInputConnection()) == null) {
                    return;
                }
                int surroundingTextLength = inputConnection.getSurroundingTextLength();
                Intrinsics.checkNotNull(text);
                int i = start + after;
                String string = text.subSequence(start, i).toString();
                if (string.length() > 0 && string.codePointAt(0) == 0) {
                    Log.i(SpenInputManager.TAG, "onTextChanged - reject change!");
                    boolean z = SpenInputManager.this.mIsEditingByUser;
                    SpenInputManager.this.mIsEditingByUser = false;
                    Editable mEditable = SpenInputManager.this.getMEditable();
                    Intrinsics.checkNotNull(mEditable);
                    mEditable.delete(start, i);
                    SpenInputManager.this.mIsEditingByUser = z;
                    return;
                }
                SpenInputManager.this.printLog(SpenInputManager.TAG, "onTextChanged surroundingTextLength : " + surroundingTextLength + ", str : " + string);
                SpenObjectShape mObjectText = SpenInputManager.this.getMObjectText();
                Intrinsics.checkNotNull(mObjectText);
                mObjectText.setTextComposition(SpenInputManager.this.getComposingSpanStart(), SpenInputManager.this.getComposingSpanEnd());
                if (string.length() == 1 && Character.isWhitespace(string.charAt(0))) {
                    SpenInputManager.this.removeComposingSpan(65536);
                }
                SpenInputManager.this.updateContent(start, before, surroundingTextLength, string);
                AccessibilityManager accessibilityManager = SpenInputManager.this.mAccessibilityManager;
                if (accessibilityManager == null || !accessibilityManager.isEnabled() || SpenInputManager.this.mView == null) {
                    return;
                }
                SpenTextUtils.sendAccessibilityEventTypeViewTextChanged(SpenInputManager.this.mView, this.mBeforeText, start, before, after);
                this.mBeforeText = null;
            } catch (SpenAlreadyClosedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "AUTO_CORRECTION_HIGHLIGHT_COLOR", "", "TYPE_COMPOSING_ALL", "AUTO_COMPLETION_SUGGESTION_PRIVATE_CMD", "AUTO_COMPLETION_SUGGESTION_KEY_STRING", "isInputMethodShown", "", "context", "Landroid/content/Context;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00a6 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25 */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9, types: [int] */
        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:51:0x0074
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean isInputMethodShown(@org.jetbrains.annotations.Nullable android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.Int"
                java.lang.String r1 = "SpenInputManager"
                r2 = 0
                if (r8 != 0) goto L8
                goto L47
            L8:
                int r3 = android.os.Build.VERSION.SDK_INT     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                r4 = 30
                r5 = 0
                if (r3 < r4) goto L37
                java.lang.String r0 = "window"
                java.lang.Object r8 = r8.getSystemService(r0)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                boolean r0 = r8 instanceof android.view.WindowManager     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                if (r0 == 0) goto L20
                r5 = r8
                android.view.WindowManager r5 = (android.view.WindowManager) r5     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                goto L20
            L1d:
                r8 = move-exception
                goto La8
            L20:
                if (r5 == 0) goto L47
                android.view.WindowMetrics r8 = p018D2.AbstractC0071a.m179m(r5)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                if (r8 == 0) goto L47
                android.view.WindowInsets r8 = p018D2.AbstractC0071a.m175i(r8)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                if (r8 == 0) goto L47
                int r0 = androidx.core.content.p110pm.AbstractC2362a.m1666c()     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                boolean r8 = androidx.core.view.AbstractC2475t.m1885q(r8, r0)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                return r8
            L37:
                java.lang.String r3 = "input_method"
                java.lang.Object r8 = r8.getSystemService(r3)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                boolean r3 = r8 instanceof android.view.inputmethod.InputMethodManager     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                if (r3 == 0) goto L44
                android.view.inputmethod.InputMethodManager r8 = (android.view.inputmethod.InputMethodManager) r8     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
                goto L45
            L44:
                r8 = r5
            L45:
                if (r8 != 0) goto L48
            L47:
                return r2
            L48:
                java.lang.Class r3 = r8.getClass()     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62
                java.lang.String r4 = "getSIPVisibleHeight"
                java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62
                java.lang.Object r3 = r3.invoke(r8, r5)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62 java.lang.IllegalAccessException -> L64 java.lang.reflect.InvocationTargetException -> L66
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62 java.lang.IllegalAccessException -> L64 java.lang.reflect.InvocationTargetException -> L66
                java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62 java.lang.IllegalAccessException -> L64 java.lang.reflect.InvocationTargetException -> L66
                int r3 = r3.intValue()     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L62 java.lang.IllegalAccessException -> L64 java.lang.reflect.InvocationTargetException -> L66
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L68 java.lang.reflect.InvocationTargetException -> L6e java.lang.NoSuchMethodException -> L74
                goto L79
            L62:
                r3 = r2
                goto L74
            L64:
                r3 = r2
                goto L68
            L66:
                r3 = r2
                goto L6e
            L68:
                java.lang.String r4 = "getCurrentSIPHeight() : IllegalAccessException"
                android.util.Log.e(r1, r4)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L74
                goto L79
            L6e:
                java.lang.String r4 = "getCurrentSIPHeight() : InvocationTargetException"
                android.util.Log.e(r1, r4)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L74
                goto L79
            L74:
                java.lang.String r4 = "getCurrentSIPHeight() : NoSuchMethodException"
                android.util.Log.e(r1, r4)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
            L79:
                java.lang.Class r4 = r8.getClass()     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L9f
                java.lang.String r6 = "getInputMethodWindowVisibleHeight"
                java.lang.reflect.Method r4 = r4.getMethod(r6, r5)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L9f
                java.lang.Object r8 = r4.invoke(r8, r5)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L99 java.lang.NoSuchMethodException -> L9f
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r0)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L99 java.lang.NoSuchMethodException -> L9f
                java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L99 java.lang.NoSuchMethodException -> L9f
                int r3 = r8.intValue()     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L99 java.lang.NoSuchMethodException -> L9f
                kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.IllegalAccessException -> L93 java.lang.reflect.InvocationTargetException -> L99 java.lang.NoSuchMethodException -> L9f
                goto La4
            L93:
                java.lang.String r8 = "getInputMethodWindowVisibleHeight() : IllegalAccessException"
                android.util.Log.e(r1, r8)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L9f
                goto La4
            L99:
                java.lang.String r8 = "getInputMethodWindowVisibleHeight() : InvocationTargetException"
                android.util.Log.e(r1, r8)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d java.lang.NoSuchMethodException -> L9f
                goto La4
            L9f:
                java.lang.String r8 = "getInputMethodWindowVisibleHeight() : NoSuchMethodException"
                android.util.Log.e(r1, r8)     // Catch: com.samsung.android.spen.libwrapper.utils.PlatformException -> L1d
            La4:
                if (r3 <= 0) goto La7
                r2 = 1
            La7:
                return r2
            La8:
                r8.printStackTrace()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.text.SpenInputManager.Companion.isInputMethodShown(android.content.Context):boolean");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$InputManagerActionListener;", "", "onComposingText", "", "text", "", "onCommitContent", "inputContentInfo", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "onCommitWhitespace", "", "onCheckObjectChangedByTextManager", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "onBeforeTextChangedByKeyboard", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface InputManagerActionListener {
        void onBeforeTextChangedByKeyboard();

        boolean onCheckObjectChangedByTextManager(@Nullable SpenObjectBase obj);

        void onCommitContent(@Nullable InputContentInfoCompat inputContentInfo);

        boolean onCommitWhitespace();

        void onComposingText(@Nullable CharSequence text);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$PerformContextMenuActionListener;", "", "onPerformContextMenuAction", "", "id", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PerformContextMenuActionListener {
        boolean onPerformContextMenuAction(int id);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bb\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$PreUpdateTextListener;", "", "onInsertText", "", "str", "", "start", "", "expandPara", "onInsertTextCursor", "onReplaceText", "before", "onRemoveText", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PreUpdateTextListener {
        boolean onInsertText(@NotNull String str, int start, boolean expandPara);

        boolean onInsertTextCursor(@NotNull String str);

        boolean onRemoveText(int start, int before);

        boolean onReplaceText(@NotNull String str, int start, int before);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$SetSelectionListener;", "", "onSetSelection", "", "start", "", "end", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SetSelectionListener {
        void onSetSelection(int start, int end);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/text/SpenInputManager$SuggestionListener;", "", "onHighlightSuggestion", "", "suggestionType", "", "start", "end", "color", "onTextSuggestion", SpenInputManager.AUTO_COMPLETION_SUGGESTION_KEY_STRING, "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SuggestionListener {
        void onHighlightSuggestion(int suggestionType, int start, int end, int color);

        void onTextSuggestion(@Nullable String suggestionText);
    }

    public SpenInputManager(@Nullable View view) {
        Context context;
        this.mView = view;
        View view2 = this.mView;
        Object systemService = (view2 == null || (context = view2.getContext()) == null) ? null : context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.mAccessibilityManager = (AccessibilityManager) systemService;
        Log.i(TAG, "init()");
        this.mDebugLevel = SpenDisplay.INSTANCE.getDebugLevel();
        this.mTextComposingListener = new SpenInputConnection.TextComposingListener() { // from class: com.samsung.android.sdk.pen.text.SpenInputManager$mTextComposingListener$1
            private final void setTextComposingState(int composingState) {
                SpenObjectShape mObjectText;
                if (this.this$0.mIsTextInputBlocked || (mObjectText = this.this$0.getMObjectText()) == null) {
                    return;
                }
                mObjectText.setTextComposingState(composingState);
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onBeginBatchEdit() {
                SpenInputConnection inputConnection = this.this$0.getInputConnection();
                if (inputConnection != null && inputConnection.getBatchEditNesting() == 1) {
                    this.this$0.mIsEditingByUser = true;
                    SpenObjectShape mObjectText = this.this$0.getMObjectText();
                    if (mObjectText != null) {
                        SpenInputManager spenInputManager = this.this$0;
                        spenInputManager.printLog("SpenInputManager", "onBeginBatchEdit - setEditingByUser to true");
                        mObjectText.setEditingByUser(true);
                        if (!spenInputManager.mHasComposingSpan) {
                            if (spenInputManager.mIsTextComposingStateStarted) {
                                setTextComposingState(0);
                                spenInputManager.mIsTextComposingStateStarted = false;
                            }
                            spenInputManager.mIsTextComposingStateStarted = true;
                            setTextComposingState(1);
                        }
                    }
                }
                return true;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public void onCommitCorrection(CorrectionInfo info) {
                SpenInputManager.SuggestionListener suggestionListener;
                SpenInputManager spenInputManager;
                SpenInputConnection inputConnection;
                if (info == null || this.this$0.getInputConnection() == null || (suggestionListener = this.this$0.mSuggestionListener) == null || (inputConnection = (spenInputManager = this.this$0).getInputConnection()) == null) {
                    return;
                }
                int selectionEnd = Selection.getSelectionEnd(inputConnection.getEditable()) - info.getOldText().length();
                suggestionListener.onHighlightSuggestion(4, selectionEnd, info.getNewText().length() + selectionEnd, spenInputManager.mAutoCorrectionHighlightColor);
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onCommitText(CharSequence text) {
                SpenInputManager.InputManagerActionListener inputManagerActionListener;
                this.this$0.removeComposingSpan(98304);
                if (text != null && text.length() == 1 && Character.isWhitespace(text.charAt(0)) && (inputManagerActionListener = this.this$0.mActionListener) != null && inputManagerActionListener.onCommitWhitespace()) {
                    this.this$0.printLog("SpenInputManager", "commitText() CommittingSpace");
                    return true;
                }
                if (text != null && text.length() == 1 && SpenTextUtils.isEnter(text, 0)) {
                    int selectionStart = Selection.getSelectionStart(this.this$0.getMEditable());
                    int selectionEnd = Selection.getSelectionEnd(this.this$0.getMEditable());
                    this.this$0.printLog("SpenInputManager", AbstractC1038a.m1214o(selectionStart, selectionEnd, "onCommitText, start:", ", end:"));
                    if (selectionStart == selectionEnd && (selectionStart == 0 || SpenTextUtils.isEnter(this.this$0.getMEditable(), selectionStart - 1))) {
                        Editable mEditable = this.this$0.getMEditable();
                        Intrinsics.checkNotNull(mEditable);
                        if (selectionStart < mEditable.length() && !SpenTextUtils.isEnter(this.this$0.getMEditable(), selectionStart)) {
                            return false;
                        }
                        SpenInputManager spenInputManager = this.this$0;
                        return spenInputManager.removeBullet(SpenTextUtils.getEnterCount(spenInputManager.getMObjectText(), selectionStart, true), true);
                    }
                }
                return false;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onComposingText(CharSequence text, int newCursorPosition) {
                SpenObjectShape mObjectText = this.this$0.getMObjectText();
                if (mObjectText != null) {
                    mObjectText.setCursorPosition(newCursorPosition);
                }
                SpenInputManager.InputManagerActionListener inputManagerActionListener = this.this$0.mActionListener;
                if (inputManagerActionListener == null) {
                    return true;
                }
                inputManagerActionListener.onComposingText(text);
                return true;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onDeleteSurroundingText(int start, int end, int after) {
                ArrayList arrayList;
                SpenInputManager spenInputManager = this.this$0;
                SpenObjectShape mObjectText = spenInputManager.getMObjectText();
                spenInputManager.mBackupSpanList = mObjectText != null ? mObjectText.getTextSpan() : null;
                if (end - start <= 0 || (arrayList = this.this$0.mBackupSpanList) == null) {
                    return false;
                }
                SpenInputManager spenInputManager2 = this.this$0;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    SpenTextSpanBase spenTextSpanBase = (SpenTextSpanBase) next;
                    if (spenTextSpanBase.getStart() != end) {
                        arrayList2.add(spenTextSpanBase);
                    }
                }
                arrayList.removeAll(arrayList2);
                if (spenInputManager2.mDebugLevel > 0) {
                    Log.i("SpenInputManager", "deleteSurroundingText() backupSpanList size = " + arrayList.size());
                    Iterator it2 = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        SpenTextSpanBase spenTextSpanBase2 = (SpenTextSpanBase) next2;
                        AbstractC0000a.m26w(AbstractC0622a.m1173s(spenTextSpanBase2.getStart(), spenTextSpanBase2.getEnd(), "deleteSurroundingText() backupSpanList start = ", ", end = ", ", spanType = "), "SpenInputManager", spenTextSpanBase2.getType());
                    }
                }
                arrayList2.clear();
                return false;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onEndBatchEdit() {
                SpenInputConnection inputConnection = this.this$0.getInputConnection();
                if (inputConnection == null || inputConnection.getBatchEditNesting() != 0) {
                    return true;
                }
                SpenObjectShape mObjectText = this.this$0.getMObjectText();
                if (mObjectText != null) {
                    SpenInputManager spenInputManager = this.this$0;
                    spenInputManager.printLog("SpenInputManager", "onEndBatchEdit - setEditingByUser to false");
                    mObjectText.setEditingByUser(false);
                    if (!spenInputManager.mHasComposingSpan) {
                        setTextComposingState(0);
                        spenInputManager.mIsTextComposingStateStarted = false;
                    }
                }
                SpenTextUtils.updateSelection(this.this$0.mView, this.this$0.getInputConnection(), this.this$0.getMEditable());
                this.this$0.mIsEditingByUser = false;
                return true;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public void onFinishComposingText() {
                this.this$0.removeComposingSpan(98304);
                this.this$0.mHasComposingSpan = false;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onPerformContextMenuAction(int id) {
                AbstractC2322a.m1631u(id, "onPerformContextMenuAction() : ", "SpenInputManager");
                SpenInputManager.PerformContextMenuActionListener performContextMenuActionListener = this.this$0.mPerformContextMenuAction;
                if (performContextMenuActionListener != null) {
                    performContextMenuActionListener.onPerformContextMenuAction(id);
                }
                SpenSoftInputListener spenSoftInputListener = this.this$0.mSoftInputListener;
                if (spenSoftInputListener != null) {
                    return spenSoftInputListener.onPerformContextMenuAction(id);
                }
                return false;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public boolean onPrivateIMECommand(String action, Bundle data) {
                if (action == null || data == null || !Intrinsics.areEqual(action, "com.samsung.android.honeyboard.action.AUTO_COMPLETION_SUGGESTION")) {
                    return false;
                }
                SpenInputManager.SuggestionListener suggestionListener = this.this$0.mSuggestionListener;
                if (suggestionListener == null) {
                    return true;
                }
                suggestionListener.onTextSuggestion(data.getString("suggestionText"));
                return true;
            }

            @Override // com.samsung.android.sdk.pen.text.inputmethod.SpenInputConnection.TextComposingListener
            public void onSetSelection(int start, int end) {
                AbstractC6670b.m4744e(start, end, "onSetSelection() : start - ", ", end - ", "SpenInputManager");
                SpenObjectShape mObjectText = this.this$0.getMObjectText();
                if (mObjectText != null) {
                    SpenInputManager.SetSelectionListener setSelectionListener = this.this$0.mSetSelectionListener;
                    if (setSelectionListener != null) {
                        setSelectionListener.onSetSelection(start, end);
                    }
                    if (end < 0 || start != end) {
                        return;
                    }
                    try {
                        mObjectText.setCursorPosition(end);
                    } catch (IllegalArgumentException unused) {
                        Log.i("SpenInputManager", "onSetSelection() : IllegalArgumentException.");
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blockTextInput(boolean blocked) {
        InputFilter[] filters;
        Editable editable = this.mEditable;
        if (editable == null || (filters = editable.getFilters()) == null) {
            return;
        }
        InputFilter inputFilter = filters[0];
        Intrinsics.checkNotNull(inputFilter, "null cannot be cast to non-null type com.samsung.android.sdk.pen.text.SpenTextFilter");
        ((SpenTextFilter) inputFilter).setTextInputBlock(blocked);
    }

    private final SpenWNote copyNote(SpenWNote srcNote) {
        try {
            View view = this.mView;
            Intrinsics.checkNotNull(view);
            SpenWNote spenWNote = new SpenWNote(view.getContext(), null, srcNote.getPageMode(), srcNote.getOrientation(), srcNote.getPageDefaultWidth(), false);
            spenWNote.setPageDefaultHeight(srcNote.getPageDefaultHeight());
            spenWNote.setBodyTextFontSizeDelta(srcNote.getBodyTextFontSizeDelta());
            int pageCount = srcNote.getPageCount();
            for (int i = 0; i < pageCount; i++) {
                spenWNote.appendPage(srcNote.getPageDefaultWidth(), srcNote.getPageDefaultHeight());
            }
            return spenWNote;
        } catch (IOException e) {
            Log.i(TAG, "copyNote# " + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishComposingText() {
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.initialize();
            spenInputConnection.finishComposingText();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getUnderlineColor(SuggestionSpan span) {
        try {
            Object objInvoke = Class.forName("android.text.style.SuggestionSpan").getMethod("getUnderlineColor", null).invoke(span, null);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private final void initEditable() {
        String str;
        boolean z;
        Log.i(TAG, "initEditable()");
        this.mChangeWatcher = new ChangeWatcher();
        boolean z2 = false;
        if (this.mEditable == null) {
            Editable editableNewEditable = Editable.Factory.getInstance().newEditable("");
            this.mEditable = editableNewEditable;
            Selection.setSelection(editableNewEditable, 0);
        } else {
            removeChangeWatcher();
        }
        View view = this.mView;
        if (view == null) {
            Log.e(TAG, "mView can not be null.");
            return;
        }
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape == null) {
            Log.e(TAG, "mObjectText can not be null.");
            return;
        }
        Editable editable = this.mEditable;
        if (editable == null) {
            Log.e(TAG, "mEditable can not be null.");
            return;
        }
        finishComposingText();
        TextKeyListener.clear(editable);
        SpenTextFilter spenTextFilter = new SpenTextFilter(view.getContext(), spenObjectShape.getTextLimit(), view);
        spenTextFilter.setTextLimitListener(this.mTextLimitListener);
        editable.setFilters(new InputFilter[]{spenTextFilter});
        String text = spenObjectShape.getText();
        initKeyListener(text);
        if (text != null) {
            int cursorPosition = spenObjectShape.getCursorPosition();
            if (cursorPosition < 0) {
                cursorPosition = spenObjectShape.getSelectedStart();
                if (cursorPosition < 0) {
                    cursorPosition = 0;
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            if (cursorPosition > text.length()) {
                cursorPosition = text.length();
            }
            if (!z) {
                spenObjectShape.setCursorPosition(cursorPosition);
            }
            String strSubstring = text.substring(0, cursorPosition);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = text.substring(cursorPosition, text.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            str = strSubstring2;
            text = strSubstring;
            z2 = z;
        } else {
            str = null;
        }
        SpenTextUtils.initEditable(editable, text, str);
        view.setFocusableInTouchMode(true);
        initInputConnection();
        setChangeWatcher();
        if (z2) {
            Log.i(TAG, "initEditable() - by selection");
            setSelection(spenObjectShape.getSelectedStart(), spenObjectShape.getSelectedEnd());
        }
    }

    private final void initInputConnection() {
        Log.i(TAG, "initInputConnection()");
        if (this.inputConnection == null) {
            this.inputConnection = new SpenInputConnection(this.mView, this.mTextComposingListener, this.mPreCommitCheckFunction, this.mPreCommitRegex);
        }
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.setEditable(this.mEditable);
            spenInputConnection.setKeyListener(this.mKeyListener);
        }
    }

    private final void initKeyListener(String str) {
        this.mKeyListener = SpenTextUtils.getKeyListener(str);
    }

    @JvmStatic
    public static final boolean isInputMethodShown(@Nullable Context context) {
        return INSTANCE.isInputMethodShown(context);
    }

    private final int makeImeOption() {
        SpenObjectShape spenObjectShape = this.mObjectText;
        switch (spenObjectShape != null ? spenObjectShape.getImeActionType() : 1) {
        }
        return 1;
    }

    private final int makeInputType() {
        SpenObjectShape spenObjectShape = this.mObjectText;
        int i = 0;
        int textInputType = spenObjectShape != null ? spenObjectShape.getTextInputType() : 0;
        if (textInputType != 0) {
            i = 2;
            if (textInputType != 2) {
                i = 3;
                if (textInputType != 3) {
                    i = 4;
                    if (textInputType != 4) {
                        return 1;
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateInputConnection$lambda$36(SpenInputManager spenInputManager, InputContentInfoCompat inputContentInfo, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        Log.i(TAG, "onCommitContent() flags = " + i);
        if ((i & 1) != 0) {
            InputManagerActionListener inputManagerActionListener = spenInputManager.mActionListener;
            if (inputManagerActionListener != null) {
                inputManagerActionListener.onCommitContent(inputContentInfo);
            }
            return true;
        }
        InputManagerActionListener inputManagerActionListener2 = spenInputManager.mActionListener;
        if (inputManagerActionListener2 == null) {
            return false;
        }
        inputManagerActionListener2.onCommitContent(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printLog(String tag, String msg) {
        if (this.mDebugLevel > 0) {
            Log.d(tag, msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeBullet(int paraIdx, boolean withEnter) {
        SpenObjectShape spenObjectShape = this.mObjectText;
        boolean z = false;
        if (spenObjectShape != null) {
            SpenBulletParagraph bulletParagraph = SpenTextUtils.getBulletParagraph(spenObjectShape, paraIdx);
            if (bulletParagraph == null) {
                return false;
            }
            spenObjectShape.removeTextParagraph(bulletParagraph);
            z = true;
            if (withEnter) {
                SpenPredefinedStyleParagraph predefinedStyleParagraph = SpenTextUtils.getPredefinedStyleParagraph(spenObjectShape, paraIdx);
                if (predefinedStyleParagraph == null) {
                    return true;
                }
                if (predefinedStyleParagraph.getStyleType() != predefinedStyleParagraph.getFollowingStyleType()) {
                    predefinedStyleParagraph.setStyleType(predefinedStyleParagraph.getFollowingStyleType());
                    spenObjectShape.appendTextParagraph(predefinedStyleParagraph);
                }
            }
        }
        return z;
    }

    private final void removeChangeWatcher() {
        Editable editable = this.mEditable;
        if (editable != null) {
            Iterator it = ArrayIteratorKt.iterator((ChangeWatcher[]) editable.getSpans(0, editable.length(), ChangeWatcher.class));
            while (it.hasNext()) {
                editable.removeSpan((ChangeWatcher) it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeComposingSpan(int removeType) {
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape == null) {
            return false;
        }
        spenObjectShape.removeTextSpan(removeType);
        return true;
    }

    private final boolean removeIndent(int paraIdx) {
        SpenIndentLevelParagraph indentLevelParagraph;
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape == null || (indentLevelParagraph = SpenTextUtils.getIndentLevelParagraph(spenObjectShape, paraIdx)) == null) {
            return false;
        }
        spenObjectShape.removeTextParagraph(indentLevelParagraph);
        return true;
    }

    private final void removeSuggestionSpan() {
        Editable editable = this.mEditable;
        if (editable != null) {
            removeSuggestionSpan(0, editable.length(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSuggestionSpanByObject(int start, int end) {
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan;
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape == null || (arrayListFindTextSpan = spenObjectShape.findTextSpan(start, end)) == null || arrayListFindTextSpan.isEmpty()) {
            return;
        }
        Iterator<SpenTextSpanBase> it = arrayListFindTextSpan.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenTextSpanBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextSpanBase spenTextSpanBase = next;
            if (spenTextSpanBase.getType() == 21 && (spenTextSpanBase.getStart() == start || spenTextSpanBase.getEnd() == end)) {
                spenObjectShape.removeTextSpan(spenTextSpanBase);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceTextByEditable(int st, int en, String str) {
        SpenInputConnection spenInputConnection;
        Editable editable = this.mEditable;
        if (editable == null || (spenInputConnection = this.inputConnection) == null) {
            return;
        }
        if (st < 0 || en < 0 || st >= editable.length() || en > editable.length()) {
            int length = editable.length();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(st, en, "replaceTextByEditable wrong index: st:", ", en:", ", mEditable length:");
            sbM1173s.append(length);
            Log.e(TAG, sbM1173s.toString());
            return;
        }
        spenInputConnection.beginBatchEdit();
        spenInputConnection.beginDelete();
        editable.replace(st, en, str);
        spenInputConnection.endDelete();
        spenInputConnection.endBatchEdit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartInputConnection() {
        View view = this.mView;
        if (view != null) {
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).restartInput(this.mView);
        }
    }

    private final void setChangeWatcher() {
        Log.i(TAG, "setChangeWatcher()");
        Editable editable = this.mEditable;
        if (editable != null) {
            int length = editable.length();
            removeChangeWatcher();
            if (this.mChangeWatcher == null) {
                this.mChangeWatcher = new ChangeWatcher();
            }
            editable.setSpan(this.mChangeWatcher, 0, length, 6553618);
            KeyListener keyListener = this.mKeyListener;
            if (keyListener != null) {
                editable.setSpan(keyListener, 0, length, 18);
            }
        }
    }

    private static final Unit setDocument$lambda$17(SpenInputManager spenInputManager) {
        SpenBodyTextContext spenBodyTextContext = spenInputManager.mBodyTextContext;
        if (spenBodyTextContext != null) {
            spenBodyTextContext.close();
            spenInputManager.mBodyTextContext = null;
        }
        SpenWNote spenWNote = spenInputManager.mBodyTextContextDocument;
        if (spenWNote == null) {
            return null;
        }
        spenWNote.close(true);
        spenInputManager.mBodyTextContextDocument = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContent(int start, int before, int surroundingTextLength, String str) {
        SpenObjectShape spenObjectShape;
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection == null || (spenObjectShape = this.mObjectText) == null) {
            return;
        }
        if (before != 0) {
            if (str.length() == 0) {
                if (!spenInputConnection.isTextChanged()) {
                    spenInputConnection.setSurroundingTextLength(surroundingTextLength + before);
                    return;
                }
                printLog(TAG, AbstractC0622a.m1164j(start, before, "onTextChanged removeText(", SQLKeyword.COMMA, ")"));
                if (this.mPreUpdateTextListener.onRemoveText(start, before)) {
                    spenObjectShape.removeText(start, before);
                    spenObjectShape.setCursorPosition(start);
                    return;
                }
                return;
            }
            if (surroundingTextLength == 0) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(start, before, "onTextChanged replaceText(", SQLKeyword.COMMA, "), str : ");
                sbM1173s.append(str);
                printLog(TAG, sbM1173s.toString());
                if (this.mPreUpdateTextListener.onReplaceText(str, start, before)) {
                    spenObjectShape.replaceText(str, start, before);
                    return;
                }
                return;
            }
            StringBuilder sbM1173s2 = AbstractC0622a.m1173s(start, surroundingTextLength, "onTextChanged replaceText(", SQLKeyword.COMMA, "), str : ");
            sbM1173s2.append(str);
            printLog(TAG, sbM1173s2.toString());
            if (this.mPreUpdateTextListener.onReplaceText(str, start, surroundingTextLength)) {
                spenObjectShape.replaceText(str, start, surroundingTextLength);
            }
            spenInputConnection.setSurroundingTextLength(0);
            return;
        }
        int deletedSurroundingTextLength = spenInputConnection.getDeletedSurroundingTextLength();
        int length = str.length();
        StringBuilder sbM1173s3 = AbstractC0622a.m1173s(surroundingTextLength, deletedSurroundingTextLength, "onTextChanged surroundingTextLength : ", ", deletedSurroundingLength : ", ", str.length() : ");
        sbM1173s3.append(length);
        printLog(TAG, sbM1173s3.toString());
        if (spenInputConnection.getSurroundingTextLength() != 0) {
            StringBuilder sbM1173s4 = AbstractC0622a.m1173s(start, surroundingTextLength, "onTextChanged replaceText(", SQLKeyword.COMMA, "), str = ");
            sbM1173s4.append(str);
            printLog(TAG, sbM1173s4.toString());
            if (this.mPreUpdateTextListener.onReplaceText(str, start, surroundingTextLength)) {
                spenObjectShape.replaceText(str, start, surroundingTextLength);
            }
            spenInputConnection.setSurroundingTextLength(0);
            return;
        }
        if (deletedSurroundingTextLength <= 0 || deletedSurroundingTextLength > str.length()) {
            printLog(TAG, AbstractC2322a.m1616f(start, "onTextChanged insertText at ", ", str : ", str));
            if (this.mPreUpdateTextListener.onInsertText(str, start, !this.mIsInsertingLineFeed)) {
                spenObjectShape.insertText(str, start, this.mIsInsertingLineFeed ? SpenTextParagraphBase.FILTER_PARAGRAPH_PREDEFINED_STYLE_SET : SpenTextParagraphBase.FILTER_PARAGRAPH_ALL);
                return;
            }
            return;
        }
        int cursorPosition = spenObjectShape.getCursorPosition();
        String strSubstring = str.substring(0, deletedSurroundingTextLength);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        printLog(TAG, "onTextChanged insertTextAtCursor(), cursor : " + cursorPosition + ", str : " + strSubstring);
        if (this.mPreUpdateTextListener.onInsertTextCursor(str)) {
            spenObjectShape.insertTextAtCursor(str);
        }
        ArrayList<SpenTextSpanBase> arrayList = this.mBackupSpanList;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                int length2 = str.length() - deletedSurroundingTextLength;
                Iterator<SpenTextSpanBase> it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    SpenTextSpanBase next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    SpenTextSpanBase spenTextSpanBase = next;
                    spenTextSpanBase.setPosition(spenTextSpanBase.getStart(), spenTextSpanBase.getEnd() + length2);
                    spenObjectShape.appendTextSpan(spenTextSpanBase);
                }
                arrayList.clear();
                this.mBackupSpanList = null;
            }
            spenInputConnection.setDeletedSurroundingTextLength(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEditable(String str, SpenObjectChangedTextInfo info) {
        Editable editable;
        if (str == null || info == null || (editable = this.mEditable) == null) {
            return;
        }
        if ((str.length() + info.before) - info.count != editable.length()) {
            Log.i(TAG, "updateEditable full");
            SpenTextUtils.updateEditable(editable, str);
        } else {
            AbstractC11014a.m12329n(info.count, ") - replace.", TAG, AbstractC0622a.m1173s(info.index, info.before, "updateEditable(", SQLKeyword.COMMA, SQLKeyword.COMMA));
            int i = info.index;
            editable.replace(i, info.before + i, str, i, i + info.count);
        }
    }

    public final void appendText(@Nullable String str) {
        Log.i(TAG, "appendText()");
        Editable editable = this.mEditable;
        if (editable != null) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart > selectionEnd) {
                selectionEnd = selectionStart;
                selectionStart = selectionEnd;
            }
            editable.replace(selectionStart, selectionEnd, str);
            int selectionEnd2 = Selection.getSelectionEnd(editable);
            setSelection(selectionEnd2, selectionEnd2);
        }
    }

    public final boolean canSelectAllText() {
        int length;
        Editable editable = this.mEditable;
        if (editable == null || (length = editable.length()) == 0) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        if (selectionStart > selectionEnd) {
            selectionEnd = selectionStart;
            selectionStart = selectionEnd;
        }
        return (selectionStart == 0 && selectionEnd == length) ? false : true;
    }

    public final void close() {
        Log.i(TAG, "close()");
        Editable editable = this.mEditable;
        if (editable != null) {
            removeChangeWatcher();
            InputFilter[] filters = editable.getFilters();
            if (filters != null) {
                InputFilter inputFilter = filters[0];
                Intrinsics.checkNotNull(inputFilter, "null cannot be cast to non-null type com.samsung.android.sdk.pen.text.SpenTextFilter");
                ((SpenTextFilter) inputFilter).close();
            }
        }
        this.mKeyListener = null;
        this.mSoftInputListener = null;
        this.mActionListener = null;
        this.mSuggestionListener = null;
        this.mSetSelectionListener = null;
        this.mSuggestionPopupListener = null;
        SpenWNote spenWNote = this.wNote;
        if (spenWNote != null) {
            SpenWNote.ObjectEventListener objectEventListener = this.mObjectEventListener;
            if (objectEventListener != null) {
                Intrinsics.checkNotNull(objectEventListener);
                spenWNote.deregisterObjectEventListener(objectEventListener);
                this.mObjectEventListener = null;
            }
            SpenWNote.HistoryEventListener historyEventListener = this.mHistoryEventListener;
            if (historyEventListener != null) {
                Intrinsics.checkNotNull(historyEventListener);
                spenWNote.deregisterHistoryEventListener(historyEventListener);
                this.mHistoryEventListener = null;
            }
        }
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.finishComposingText();
            spenInputConnection.close();
            this.inputConnection = null;
        }
        SpenSuggestionPopup spenSuggestionPopup = this.mSuggestionPopup;
        if (spenSuggestionPopup != null) {
            spenSuggestionPopup.close();
            this.mSuggestionPopup = null;
        }
        this.mView = null;
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext != null) {
            spenBodyTextContext.close();
            this.mBodyTextContext = null;
        }
        SpenWNote spenWNote2 = this.mBodyTextContextDocument;
        if (spenWNote2 != null) {
            spenWNote2.close(true);
            this.mBodyTextContextDocument = null;
        }
    }

    public final void dismissSuggestionPopup(boolean clearHighLight) {
        SpenSuggestionPopup spenSuggestionPopup = this.mSuggestionPopup;
        if (spenSuggestionPopup != null) {
            spenSuggestionPopup.clearHighlightOnDismiss(clearHighLight);
            spenSuggestionPopup.dismiss();
        }
    }

    public final int getComposingSpanEnd() {
        Editable editable = this.mEditable;
        if (editable != null) {
            return BaseInputConnection.getComposingSpanEnd(editable);
        }
        return -1;
    }

    public final int getComposingSpanStart() {
        Editable editable = this.mEditable;
        if (editable != null) {
            return BaseInputConnection.getComposingSpanStart(editable);
        }
        return -1;
    }

    @Nullable
    public final SpenInputConnection getInputConnection() {
        return this.inputConnection;
    }

    @NotNull
    public final String getMAddPrivateImeSettings() {
        return this.mAddPrivateImeSettings;
    }

    @Nullable
    public final Editable getMEditable() {
        return this.mEditable;
    }

    @Nullable
    public final SpenObjectShape getMObjectText() {
        return this.mObjectText;
    }

    public final int getSelectionEnd() {
        Editable editable = this.mEditable;
        if (editable != null) {
            return Selection.getSelectionEnd(editable);
        }
        return -1;
    }

    public final int getSelectionStart() {
        Editable editable = this.mEditable;
        if (editable != null) {
            return Selection.getSelectionStart(editable);
        }
        return -1;
    }

    @Nullable
    public final String getText(boolean selectedText) {
        Editable editable = this.mEditable;
        if (editable == null) {
            return null;
        }
        if (!selectedText) {
            return editable.toString();
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart > selectionEnd) {
            selectionEnd = selectionStart;
            selectionStart = selectionEnd;
        }
        String strSubstring = editable.toString().substring(selectionStart, selectionEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Nullable
    public final SpenWNote getWNote() {
        return this.wNote;
    }

    public final boolean hasComposingSpan(int start, int end) {
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan;
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape != null && (arrayListFindTextSpan = spenObjectShape.findTextSpan(start, end)) != null && !arrayListFindTextSpan.isEmpty()) {
            Iterator<SpenTextSpanBase> it = arrayListFindTextSpan.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenTextSpanBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenTextSpanBase spenTextSpanBase = next;
                if (spenTextSpanBase.getType() == 16) {
                    if (spenTextSpanBase.getStart() == start && spenTextSpanBase.getEnd() == end) {
                        return true;
                    }
                    spenObjectShape.removeTextSpan(spenTextSpanBase);
                }
            }
        }
        return false;
    }

    public final void hideSoftInput(long delay) {
        Log.i(TAG, "hideSoftInput()");
        SpenSoftInputListener spenSoftInputListener = this.mSoftInputListener;
        if (spenSoftInputListener != null) {
            if (delay > 0) {
                spenSoftInputListener.onShowSoftInput(false, delay);
            } else {
                spenSoftInputListener.onShowSoftInput(false);
            }
        }
    }

    public final boolean isSuggestionPopupShowing() {
        SpenSuggestionPopup spenSuggestionPopup = this.mSuggestionPopup;
        if (spenSuggestionPopup != null) {
            return spenSuggestionPopup.isShowing();
        }
        return false;
    }

    public final boolean onBackPressed() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (selectionStart > selectionEnd) {
            selectionEnd = selectionStart;
            selectionStart = selectionEnd;
        }
        if (selectionStart == selectionEnd) {
            return false;
        }
        setSelection(selectionEnd, selectionEnd);
        SpenObjectShape spenObjectShape = this.mObjectText;
        if (spenObjectShape == null) {
            return true;
        }
        spenObjectShape.setCursorPosition(selectionEnd);
        return true;
    }

    @NotNull
    public final InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        Log.i(TAG, "onCreateInputConnection()");
        int iMakeImeOption = makeImeOption();
        int iMakeInputType = makeInputType();
        outAttrs.actionLabel = null;
        outAttrs.label = "SPenSDK";
        outAttrs.privateImeOptions = AbstractC0541b.m772n("customInputConnection=true;disableDirectWriting=true;", this.mAddPrivateImeSettings);
        outAttrs.imeOptions = iMakeImeOption | 268435456 | outAttrs.imeOptions;
        outAttrs.inputType = iMakeInputType;
        if (iMakeInputType != 0) {
            outAttrs.inputType = iMakeInputType | 16384;
        }
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.clearBatchEdit();
        } else {
            spenInputConnection = new SpenInputConnection(this.mView, this.mTextComposingListener, this.mPreCommitCheckFunction, this.mPreCommitRegex);
        }
        this.inputConnection = spenInputConnection;
        outAttrs.initialSelStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        outAttrs.initialSelEnd = selectionEnd;
        AbstractC6670b.m4744e(outAttrs.initialSelStart, selectionEnd, "onCreateInputConnection() initialSelStart = ", ", initialSelEnd = ", TAG);
        EditorInfoCompat.setContentMimeTypes(outAttrs, new String[]{Constants.MIME_IMAGE, Constants.MIME_GIF});
        C0061b c0061b = new C0061b(this, 23);
        SpenInputConnection spenInputConnection2 = this.inputConnection;
        Intrinsics.checkNotNull(spenInputConnection2);
        InputConnection inputConnectionCreateWrapper = InputConnectionCompat.createWrapper(spenInputConnection2, outAttrs, c0061b);
        Intrinsics.checkNotNullExpressionValue(inputConnectionCreateWrapper, "createWrapper(...)");
        return inputConnectionCreateWrapper;
    }

    public final void onInsertLineFeed(@Nullable SpenObjectShape objectShape, int count) {
        SpenInputConnection spenInputConnection;
        if (this.mEditable == null || objectShape == null || (spenInputConnection = this.inputConnection) == null) {
            return;
        }
        if (Intrinsics.areEqual(objectShape, this.mObjectText)) {
            initEditable();
        } else {
            setObjectText(objectShape);
        }
        this.mIsInsertingLineFeed = true;
        spenInputConnection.beginBatchEdit();
        SpenTextUtils.insertLineFeed(this.mEditable, count);
        spenInputConnection.endBatchEdit();
        this.mIsInsertingLineFeed = false;
    }

    public final boolean onKeyDown(int keyCode, @NotNull KeyEvent event) {
        SpenSoftInputListener spenSoftInputListener;
        Intrinsics.checkNotNullParameter(event, "event");
        printLog(TAG, "onKeyDown() " + keyCode);
        if (this.mObjectText == null) {
            Log.i(TAG, "onKeyDown - mObjectText is null");
            return false;
        }
        Editable editable = this.mEditable;
        if (editable == null) {
            Log.i(TAG, "onKeyDown - mEditable is null");
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        if (keyCode == 23) {
            showSoftInput();
        } else {
            if (keyCode == 61) {
                return false;
            }
            if (keyCode != 112) {
                if (keyCode != 66) {
                    if (keyCode != 67) {
                        if (keyCode == KeyEventWrapper.KEYCODE_CLIPBOARD && (spenSoftInputListener = this.mSoftInputListener) != null) {
                            spenSoftInputListener.onShowClipboard(true);
                        }
                    } else if (selectionStart == selectionEnd && (selectionStart == 0 || SpenTextUtils.isEnter(this.mEditable, selectionStart - 1))) {
                        int enterCount = SpenTextUtils.getEnterCount(this.mObjectText, selectionStart, true);
                        if (removeBullet(enterCount, false) || removeIndent(enterCount)) {
                            return true;
                        }
                    }
                } else if (selectionStart == selectionEnd && (selectionStart == 0 || SpenTextUtils.isEnter(this.mEditable, selectionStart - 1))) {
                    Editable editable2 = this.mEditable;
                    Intrinsics.checkNotNull(editable2);
                    if ((selectionStart == editable2.length() || SpenTextUtils.isEnter(this.mEditable, selectionStart)) && removeBullet(SpenTextUtils.getEnterCount(this.mObjectText, selectionStart, true), true)) {
                        return true;
                    }
                }
            } else if (selectionStart == selectionEnd && SpenTextUtils.isEnter(this.mEditable, selectionStart)) {
                int enterCount2 = SpenTextUtils.getEnterCount(this.mObjectText, selectionStart + 1, true);
                if (removeIndent(enterCount2) || removeBullet(enterCount2, false)) {
                    return true;
                }
            }
        }
        if (event.isShiftPressed()) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    this.mIsShiftDpadSelection = true;
                    break;
            }
        }
        return sendKeyEvent(keyCode, event);
    }

    public final boolean onKeyPreIme(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (keyCode == 4 && event.getAction() == 0) {
            return onBackPressed();
        }
        return false;
    }

    public final boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenSoftInputListener spenSoftInputListener = this.mSoftInputListener;
        if (spenSoftInputListener != null) {
            return spenSoftInputListener.onKeyShortcut(keyCode, event);
        }
        return false;
    }

    public final boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Log.i(TAG, "onKeyUp() " + keyCode);
        if (keyCode == 61) {
            return true;
        }
        View view = this.mView;
        if (view != null) {
            Configuration configuration = view.getResources().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
            if (configuration.keyboard == 1 && this.mIsShiftDpadSelection && (keyCode == 59 || keyCode == 60)) {
                return false;
            }
        }
        KeyListener keyListener = this.mKeyListener;
        if (keyListener != null) {
            return keyListener.onKeyUp(this.mView, this.mEditable, keyCode, event);
        }
        return false;
    }

    public final void onPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.getText().add(this.mEditable);
    }

    public final void onSuggestionTextClicked(@Nullable SpenSuggestionSpan span, @NotNull RectF rect) {
        View view;
        Editable editable;
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (this.mEditable == null || span == null || span.getSuggestionType() == 4 || span.getSuggestionType() == 4096 || span.getSuggestionType() == 8192 || (view = this.mView) == null || (editable = this.mEditable) == null) {
            return;
        }
        if (span.getStart() < 0 || span.getEnd() < 0 || span.getStart() >= editable.length() || span.getEnd() > editable.length()) {
            int start = span.getStart();
            int end = span.getEnd();
            int length = editable.length();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(start, end, "onSuggestionTextClicked wrong index: spanStart:", ", spanEnd:", ", mEditable length:");
            sbM1173s.append(length);
            Log.e(TAG, sbM1173s.toString());
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Point point = new Point(((int) rect.left) + iArr[0], ((int) rect.bottom) + iArr[1]);
        String strSubstring = String.valueOf(this.mEditable).substring(span.getStart(), span.getEnd());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        SpenSuggestionPopup spenSuggestionPopup = this.mSuggestionPopup;
        if (spenSuggestionPopup != null) {
            spenSuggestionPopup.update(span, point, strSubstring);
        } else {
            spenSuggestionPopup = new SpenSuggestionPopup(view, span, point, strSubstring);
            spenSuggestionPopup.setSuggestionListener(this.mSuggestionListener);
            spenSuggestionPopup.setActionListener(this.mSuggestionPopupListener);
        }
        this.mSuggestionPopup = spenSuggestionPopup;
        spenSuggestionPopup.show(true);
    }

    public final void removeText() {
        Log.i(TAG, "removeText()");
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.beginDelete();
        }
        Editable editable = this.mEditable;
        if (editable != null) {
            if (selectionStart != selectionEnd) {
                if (selectionStart < selectionEnd) {
                    editable.delete(selectionStart, selectionEnd);
                    setSelection(selectionStart, selectionStart);
                } else {
                    editable.delete(selectionEnd, selectionStart);
                    setSelection(selectionEnd, selectionEnd);
                }
            } else if (selectionStart > 0) {
                int i = 1;
                if (selectionStart > 1 && SpenInputEmojiUtil.isHighSurrogate(editable.charAt(selectionStart - 2))) {
                    i = 2;
                }
                editable.delete(selectionStart - i, selectionStart);
            }
        }
        SpenInputConnection spenInputConnection2 = this.inputConnection;
        if (spenInputConnection2 != null) {
            spenInputConnection2.endDelete();
        }
    }

    public final void selectAll(boolean showContext) {
        Log.i(TAG, "selectAll()");
        Editable editable = this.mEditable;
        if (editable == null) {
            Log.e(TAG, "mEditable can not be null.");
            return;
        }
        int length = editable.length();
        if (length != 0) {
            setSelection(0, length);
        }
    }

    public final void sendKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.sendKeyEvent(event);
        }
    }

    public final void setActionListener(@Nullable InputManagerActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setDocument(@Nullable final SpenWNote note) {
        Log.i(TAG, "setDocument()");
        SpenWNote spenWNote = this.wNote;
        if (spenWNote != null) {
            SpenWNote.ObjectEventListener objectEventListener = this.mObjectEventListener;
            if (objectEventListener != null) {
                spenWNote.deregisterObjectEventListener(objectEventListener);
                this.mObjectEventListener = null;
            }
            SpenWNote.HistoryEventListener historyEventListener = this.mHistoryEventListener;
            if (historyEventListener != null) {
                spenWNote.deregisterHistoryEventListener(historyEventListener);
                this.mHistoryEventListener = null;
            }
        }
        this.wNote = note;
        if (note != null) {
            SpenWNote.ObjectEventListener objectEventListener2 = new SpenWNote.ObjectEventListener() { // from class: com.samsung.android.sdk.pen.text.SpenInputManager$setDocument$2$1
                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectAdded(SpenWPage page, ArrayList<SpenObjectBase> objectList, int historyEventType) {
                    Intrinsics.checkNotNullParameter(objectList, "objectList");
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectChanged(SpenWPage page, SpenObjectChangedInfo changedInfo, int historyEventType) {
                    SpenObjectBase spenObjectBase;
                    SpenInputManager.InputManagerActionListener inputManagerActionListener;
                    Intrinsics.checkNotNullParameter(changedInfo, "changedInfo");
                    if ((!this.this$0.mIsEditingByUser || (inputManagerActionListener = this.this$0.mActionListener) == null || inputManagerActionListener.onCheckObjectChangedByTextManager(changedInfo.objectBase)) && (spenObjectBase = changedInfo.objectBase) != null) {
                        boolean z = true;
                        if (changedInfo.type == 1 && (changedInfo instanceof SpenObjectChangedTextInfo)) {
                            Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                            SpenObjectShape spenObjectShape = (SpenObjectShape) spenObjectBase;
                            if (this.this$0.getMObjectText() == null || !Intrinsics.areEqual(spenObjectShape, this.this$0.getMObjectText())) {
                                return;
                            }
                            SpenObjectChangedTextInfo spenObjectChangedTextInfo = (SpenObjectChangedTextInfo) changedInfo;
                            int i = spenObjectChangedTextInfo.textChangedType;
                            if (i == 1 || i == 6) {
                                if (this.this$0.getInputConnection() != null) {
                                    boolean zIsCoediting = note.isCoediting();
                                    if (historyEventType != 1 && historyEventType != 2) {
                                        z = false;
                                    }
                                    if (!zIsCoediting || z) {
                                        this.this$0.finishComposingText();
                                    }
                                }
                                String text = spenObjectShape.getText();
                                if (text == null) {
                                    text = "";
                                }
                                if (this.this$0.getMEditable() == null) {
                                    return;
                                }
                                this.this$0.blockTextInput(false);
                                this.this$0.updateEditable(text, spenObjectChangedTextInfo);
                                SpenInputManager spenInputManager = this.this$0;
                                spenInputManager.blockTextInput(spenInputManager.mIsTextInputBlocked);
                                SpenObjectShape mObjectText = this.this$0.getMObjectText();
                                Intrinsics.checkNotNull(mObjectText);
                                int cursorPosition = mObjectText.getCursorPosition();
                                if (cursorPosition == -1 || cursorPosition == Selection.getSelectionEnd(this.this$0.getMEditable())) {
                                    return;
                                }
                                this.this$0.setSelection(cursorPosition, cursorPosition);
                            }
                        }
                    }
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
                public void onObjectRemoved(SpenWPage page, ArrayList<SpenObjectBase> objectList, int historyEventType) {
                    Intrinsics.checkNotNullParameter(objectList, "objectList");
                }
            };
            this.mObjectEventListener = objectEventListener2;
            Intrinsics.checkNotNull(objectEventListener2);
            note.registerObjectEventListener(objectEventListener2);
            SpenWNote.HistoryEventListener historyEventListener2 = new SpenWNote.HistoryEventListener() { // from class: com.samsung.android.sdk.pen.text.SpenInputManager$setDocument$2$2
                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onPreSubmit(SpenWNote note2, SpenObjectBase objectBase, int start, int before, int count) {
                    if (this.this$0.mIsEditingByUser) {
                        return;
                    }
                    int composingSpanStart = this.this$0.getComposingSpanStart();
                    if (start > this.this$0.getComposingSpanEnd() || composingSpanStart > start) {
                        return;
                    }
                    this.this$0.finishComposingText();
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onCommit(SpenWNote note2) {
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onRedo(SpenWNote note2) {
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onUndo(SpenWNote note2) {
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onRedoable(SpenWNote note2, boolean redoable) {
                }

                @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
                public void onUndoable(SpenWNote note2, boolean undoable) {
                }
            };
            this.mHistoryEventListener = historyEventListener2;
            SpenWNote spenWNote2 = this.wNote;
            if (spenWNote2 != null) {
                spenWNote2.registerHistoryEventListener(historyEventListener2);
            }
            this.mSuggestionPopupListener = new SpenSuggestionPopup.ActionListener() { // from class: com.samsung.android.sdk.pen.text.SpenInputManager$setDocument$2$4
                @Override // com.samsung.android.sdk.pen.text.SpenSuggestionPopup.ActionListener
                public void onDeleteClicked(int start, int end) {
                    this.this$0.replaceTextByEditable(start, end, "");
                }

                @Override // com.samsung.android.sdk.pen.text.SpenSuggestionPopup.ActionListener
                public void onItemClicked(SpenSuggestionSpan newSpan, String newStr, int start, int end) {
                    Editable mEditable;
                    SpenInputManager spenInputManager;
                    View view;
                    if (newSpan == null || (mEditable = this.this$0.getMEditable()) == null || (view = (spenInputManager = this.this$0).mView) == null) {
                        return;
                    }
                    spenInputManager.replaceTextByEditable(start, end, newStr);
                    if (newSpan.getSuggestionType() == 1) {
                        mEditable.setSpan(new SuggestionSpan(view.getContext(), (String[]) newSpan.getSuggestions().toArray(new String[0]), newSpan.getSuggestionType()), newSpan.getStart(), newSpan.getEnd(), 33);
                    }
                }
            };
            SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
            if (spenBodyTextContext != null) {
                SpenWNote spenWNoteCopyNote = copyNote(note);
                this.mBodyTextContextDocument = spenWNoteCopyNote;
                spenBodyTextContext.setDocument(spenWNoteCopyNote);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setFixedContentHeightEnabled(boolean enable) {
        if (enable) {
            View view = this.mView;
            if (view == null || this.mBodyTextContext != null) {
                return;
            }
            this.mBodyTextContext = new SpenBodyTextContext(view.getContext());
            return;
        }
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext != null) {
            spenBodyTextContext.close();
        }
        this.mBodyTextContext = null;
        SpenWNote spenWNote = this.mBodyTextContextDocument;
        if (spenWNote != null) {
            spenWNote.close(true);
        }
        this.mBodyTextContextDocument = null;
    }

    public final void setMAddPrivateImeSettings(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mAddPrivateImeSettings = str;
    }

    public final void setMEditable(@Nullable Editable editable) {
        this.mEditable = editable;
    }

    public final void setMObjectText(@Nullable SpenObjectShape spenObjectShape) {
        this.mObjectText = spenObjectShape;
    }

    public final void setObjectText(@Nullable SpenObjectShape textObj) {
        if (textObj != null) {
            if (Intrinsics.areEqual(textObj, this.mObjectText)) {
                return;
            }
            removeSuggestionSpan();
            SpenSuggestionPopup spenSuggestionPopup = this.mSuggestionPopup;
            if (spenSuggestionPopup != null) {
                spenSuggestionPopup.close();
                this.mSuggestionPopup = null;
            }
            Log.i(TAG, "setObjectText()");
            this.mObjectText = textObj;
            restartInputConnection();
            initEditable();
            return;
        }
        Log.e(TAG, "textObj is null.");
        finishComposingText();
        removeSuggestionSpan();
        SpenSuggestionPopup spenSuggestionPopup2 = this.mSuggestionPopup;
        if (spenSuggestionPopup2 != null) {
            spenSuggestionPopup2.close();
            this.mSuggestionPopup = null;
        }
        removeChangeWatcher();
        this.mChangeWatcher = null;
        Editable editable = this.mEditable;
        if (editable != null) {
            editable.clear();
            Selection.setSelection(editable, 0);
        }
        this.mObjectText = null;
        restartInputConnection();
    }

    public final void setPerformContextMenuActionListener(@Nullable PerformContextMenuActionListener listener) {
        this.mPerformContextMenuAction = listener;
    }

    public final void setPreCommitCheckFunction(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Boolean> func) {
        this.mPreCommitCheckFunction = func;
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.setMPreCommitCheckFunction(func);
        }
    }

    public final void setPreCommitRegex(@NotNull Regex preCommitRegex) {
        Intrinsics.checkNotNullParameter(preCommitRegex, "preCommitRegex");
        this.mPreCommitRegex = preCommitRegex;
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection != null) {
            spenInputConnection.setMPreCommitRegex(preCommitRegex);
        }
    }

    public final void setSelection(int start, int end) {
        Editable editable;
        Log.i(TAG, AbstractC0622a.m1164j(start, end, "setSelection(", SQLKeyword.COMMA, ")"));
        if (start < 0 || end < 0 || this.mObjectText == null || (editable = this.mEditable) == null) {
            return;
        }
        int length = editable.length();
        if (length < start || length < end) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(length, start, "setSelection() index out of bounds..editable length = ", ", start = ", ", end = ");
            sbM1173s.append(end);
            Log.e(TAG, sbM1173s.toString());
        } else {
            Selection.setSelection(editable, start, end);
            if (this.mIsEditingByUser) {
                return;
            }
            SpenTextUtils.updateSelection(this.mView, this.inputConnection, editable);
        }
    }

    public final void setSelectionListener(@Nullable SetSelectionListener listener) {
        this.mSetSelectionListener = listener;
    }

    public final void setSoftInputListener(@Nullable SpenSoftInputListener listener) {
        Log.i(TAG, "setSoftInputListener()");
        this.mSoftInputListener = listener;
    }

    public final void setSuggestionListener(@Nullable SuggestionListener action) {
        this.mSuggestionListener = action;
    }

    public final void setTextInputBlock(boolean setBlock) {
        if (this.mIsTextInputBlocked == setBlock) {
            return;
        }
        AbstractC4539a.m3208r("setTextInputBlock=", TAG, setBlock);
        if (setBlock) {
            finishComposingText();
        }
        this.mIsTextInputBlocked = setBlock;
        blockTextInput(setBlock);
    }

    public final void setTextLimitListener(@Nullable SpenTextLimitListener listener) {
        this.mTextLimitListener = listener;
    }

    public final void showSoftInput() {
        View view;
        Log.i(TAG, "showSoftInput()");
        SpenSoftInputListener spenSoftInputListener = this.mSoftInputListener;
        if (spenSoftInputListener != null) {
            View view2 = this.mView;
            if (view2 != null && !view2.isFocused() && (view = this.mView) != null) {
                view.requestFocus();
            }
            spenSoftInputListener.onShowSoftInput(true);
        }
    }

    public final void updateSuggestionPopup(@NotNull RectF cursorRect, boolean clearHighLightOnDismiss) {
        SpenSuggestionPopup spenSuggestionPopup;
        Intrinsics.checkNotNullParameter(cursorRect, "cursorRect");
        View view = this.mView;
        if (view == null || (spenSuggestionPopup = this.mSuggestionPopup) == null || spenSuggestionPopup.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Point point = new Point(((int) cursorRect.left) + iArr[0], ((int) cursorRect.bottom) + iArr[1]);
        spenSuggestionPopup.clearHighlightOnDismiss(clearHighLightOnDismiss);
        spenSuggestionPopup.updatePosition(point);
        spenSuggestionPopup.show(false);
    }

    public final void viewClicked() {
        Log.i(TAG, "viewClicked()");
        View view = this.mView;
        if (view != null) {
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).viewClicked(this.mView);
        }
    }

    private final boolean sendKeyEvent(int keyCode, KeyEvent event) {
        KeyListener keyListener;
        Editable editable;
        SpenInputConnection spenInputConnection = this.inputConnection;
        if (spenInputConnection == null || (keyListener = this.mKeyListener) == null || (editable = this.mEditable) == null) {
            return false;
        }
        boolean z = keyCode == 67 || keyCode == 112;
        if (z) {
            spenInputConnection.beginDelete();
        }
        spenInputConnection.beginBatchEdit();
        boolean zOnKeyDown = keyListener.onKeyDown(this.mView, editable, keyCode, event);
        spenInputConnection.endBatchEdit();
        if (z) {
            spenInputConnection.endDelete();
        }
        return zOnKeyDown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSuggestionSpan(int start, int before, int after) {
        Editable editable = this.mEditable;
        if (editable != null) {
            Iterator it = ArrayIteratorKt.iterator((SuggestionSpan[]) editable.getSpans(start, start + before, SuggestionSpan.class));
            while (it.hasNext()) {
                SuggestionSpan suggestionSpan = (SuggestionSpan) it.next();
                int spanEnd = editable.getSpanEnd(suggestionSpan);
                if (!this.mIsEditingByUser || spanEnd != start || (before > 0 && after == 0)) {
                    editable.removeSpan(suggestionSpan);
                }
            }
        }
    }

    public final void finishComposingText(@Nullable SpenObjectShape objectShape) {
        if (objectShape == null || !Intrinsics.areEqual(objectShape, this.mObjectText)) {
            return;
        }
        finishComposingText();
    }
}
