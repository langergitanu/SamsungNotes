package com.samsung.android.support.senl.p148nt.word.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.CancellationSignal;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.facade.RecognitionFacade;
import com.samsung.android.support.senl.p148nt.word.common.ParagraphAttrToOfficeHelper;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.data.WNoteData;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p005A3.C0016a;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000 \u008b\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0004\u008a\u0001\u008b\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010.\u001a\u00028\u0000H$¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u000bH$J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u0012H\u0014J\b\u00105\u001a\u000202H\u0014J\b\u00106\u001a\u00020\u0015H\u0002J \u00107\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0088\u0001\u00108\u001a\u0002022\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)2&\u0010;\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u00120<j\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u0012`=2\"\u0010>\u001a\u001e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120<j\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0012`=H\u0002J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AH$J\u0018\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bJ\u008e\u0001\u0010H\u001a\u0004\u0018\u00010\u000b2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020L2\u001a\u0010M\u001a\u0016\u0012\u0004\u0012\u00020N\u0018\u00010'j\n\u0012\u0004\u0012\u00020N\u0018\u0001`)2\u0006\u0010O\u001a\u00020P2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2&\u0010;\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u00120<j\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u0012`=2\u0006\u0010R\u001a\u00020\u0012H\u0002J>\u0010S\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010A2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010T\u001a\u0004\u0018\u00010\u000b2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012H\u0002J8\u0010W\u001a\u0002022\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\u00100'j\b\u0012\u0004\u0012\u00020\u0010`)2\u0006\u0010U\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020Z2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0018\u0010[\u001a\u0002022\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010'H\u0016J\u0018\u0010\\\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bJ8\u0010]\u001a\u0012\u0012\u0004\u0012\u00020^0'j\b\u0012\u0004\u0012\u00020^`)2\u0006\u0010Y\u001a\u00020Z2\u0016\u0010_\u001a\u0012\u0012\u0004\u0012\u00020^0'j\b\u0012\u0004\u0012\u00020^`)H\u0002J\u009c\u0001\u0010`\u001a\u0002022\u0006\u0010I\u001a\u00020A2\u0016\u0010a\u001a\u00120bR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010K\u001a\u00020L2\u001a\u0010M\u001a\u0016\u0012\u0004\u0012\u00020N\u0018\u00010'j\n\u0012\u0004\u0012\u00020N\u0018\u0001`)2\u0006\u0010O\u001a\u00020P2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2&\u0010;\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u00120<j\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u0012`=2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010c\u001a\u0002022\u0006\u0010Y\u001a\u00020Z2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0002J(\u0010d\u001a\u0002022\u0006\u0010Y\u001a\u00020Z2\u0006\u0010R\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u0012H\u0002J\u0018\u0010e\u001a\u0002022\u0006\u0010J\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020ZH\u0002JL\u0010f\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010A2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010R\u001a\u00020\u00122\u0016\u0010a\u001a\u00120bR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0012H\u0002JQ\u0010g\u001a\u0002022\"\u0010X\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`)\u0018\u00010h2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020Z2\u0006\u0010R\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010iJ\u008c\u0001\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020L2\u001a\u0010M\u001a\u0016\u0012\u0004\u0012\u00020N\u0018\u00010'j\n\u0012\u0004\u0012\u00020N\u0018\u0001`)2\u0006\u0010O\u001a\u00020P2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2&\u0010;\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u00120<j\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u0012`=2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0018\u0010m\u001a\u00020E2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0002J'\u0010n\u001a\u0004\u0018\u00010E2\u0006\u0010o\u001a\u00028\u00002\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u000202H\u0002J \u0010r\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010Y\u001a\u00020ZH\u0002J(\u0010s\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u000bH\u0004J\u0018\u0010v\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020Z2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010w\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020ZH\u0002J\"\u0010x\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H$J\"\u0010y\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0012H$J\n\u0010z\u001a\u0004\u0018\u00010\u000bH$J\u001f\u0010{\u001a\u0002022\u0006\u0010o\u001a\u00028\u00002\b\u0010|\u001a\u0004\u0018\u00010}H$¢\u0006\u0002\u0010~J6\u0010\u007f\u001a\u0002022\u001a\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`)2\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010R\u001a\u00020\u0012H$Jk\u0010\u0080\u0001\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010L2\u001b\u0010\u0081\u0001\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)2\b\u0010Y\u001a\u0004\u0018\u00010Z2'\u0010\u0082\u0001\u001a\"\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0012\u0018\u00010<j\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0012\u0018\u0001`=2\u0006\u0010B\u001a\u00020\u0015H$J@\u0010\u0083\u0001\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010A2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010J\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00122\u0007\u0010\u0084\u0001\u001a\u00020\u00122\b\u0010T\u001a\u0004\u0018\u00010\u000bH$JP\u0010\u0085\u0001\u001a\u0002022\b\u0010I\u001a\u0004\u0018\u00010A2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010R\u001a\u00020\u00122\u0018\u0010a\u001a\u0014\u0018\u00010bR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010U\u001a\u00020\u00122\u0007\u0010\u0084\u0001\u001a\u00020\u0012H$J\u0019\u0010\u0086\u0001\u001a\u0002022\u0006\u0010Y\u001a\u00020Z2\u0006\u0010J\u001a\u00020\u0012H\u0014J+\u0010\u0087\u0001\u001a\u00120bR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010R\u001a\u00020\u0012H$J\u0016\u0010\u0088\u0001\u001a\u0004\u0018\u00010E2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010EH\u0014R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00028\u00008\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00018\u00018\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u001c\u0010 \u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010!8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010'j\n\u0012\u0004\u0012\u00020(\u0018\u0001`)X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010'j\n\u0012\u0004\u0012\u00020+\u0018\u0001`)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010C\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u008c\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "OfficeDocument", "OfficeElement", "", "context", "Landroid/content/Context;", "mDocParams", "Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;", "wNoteData", "Lcom/samsung/android/support/senl/nt/word/data/WNoteData;", "notePath", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/word/data/OfficeParams;Lcom/samsung/android/support/senl/nt/word/data/WNoteData;Ljava/lang/String;)V", "results", "", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/data/TextInfo;", "prevHeight", "", "cropHeight", "isContinuousPage", "", "indexTextbox", "mCancellationSignal", "Landroid/os/CancellationSignal;", "getMCancellationSignal", "()Landroid/os/CancellationSignal;", "setMCancellationSignal", "(Landroid/os/CancellationSignal;)V", "mOffice", "Ljava/lang/Object;", "mOfficeElement", "mHelper", "Lcom/samsung/android/support/senl/nt/word/common/ParagraphAttrToOfficeHelper;", "modeExport", "lineCountBefore", "currentLine", "isAlive", "mObjectBases", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "mStrokes", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "mInsertHelper", "Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper;", "createDocument", "()Ljava/lang/Object;", "getTag", "updateMargin", "", "widthNote", "heightNote", "configLib", "taskIsDead", "getExtractTextResult", "getObjectNeedAdd", "objectsPage", "objectBases", "spanIndex", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "spanIndexPage", "initHelper", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "addVoice", "objectSpanOfPage", "exportFixedSizePage", "Ljava/io/File;", "fileName", "shareDir", "addObjectSpanFixedSizePage", ExternalDataConstants.Column.BODY_TEXT, "indexPage", "bodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "objectsFromSpan", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "indexOfSpan", "", "objects", "currentHeight", "addBodyTextFixedSizePage", "contentPage", "turn", "numberOfExports", "addRecognizeTextFixedSizePage", "textInfos", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "sortObjectSpan", "exportContinuousPage", "setThumbnailRects", "Landroid/graphics/RectF;", "inputThumbnailRects", "addObjectSpanContinuousPage", "continueIndex", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView$ContinueIndex;", "addBackgroundPage", "addHandwritingPage", "addVoiceDataToViewPage", "addBodyTextContinuousPage", "addRecognizeTextContinuousPage", "", "([Ljava/util/ArrayList;IILcom/samsung/android/sdk/pen/worddoc/SpenWPage;I)V", "addObjectSpan", "spenBodyTextContext", "content", "createFile", "makeOfficeFile", "doc", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;", "close", "getObjectsFixedPage", "getObjectsContinuousPage", "countLinesBefore", "data", "hasHandWriting", "hasBackground", "addBackground", "addHandwriting", "getFileExtension", "writeToFile", "output", "Ljava/io/BufferedOutputStream;", "(Ljava/lang/Object;Ljava/io/BufferedOutputStream;)V", "addRecognizeText", "addItemsOfPage", "objectsOfPage", "objectsIndex", "addBodyText", "maxTurn", "addBodyTextContinuous", "addVoiceDataToView", "getContinueIndex", "insertFile", "officeFile", "ContinueIndex", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOfficeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OfficeView.kt\ncom/samsung/android/support/senl/nt/word/base/OfficeView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1#2:719\n*E\n"})
public abstract class OfficeView<OfficeDocument, OfficeElement> {
    private static final char LINE_BREAK = '\n';
    private static final int MAXIMUM_NUMBER_OF_EXPORTS = 2;

    @NotNull
    private static final String PAGE = "Page : ";

    @NotNull
    public static final String TAG = "OfficeView";

    @JvmField
    public static int mElementId;
    private static int mNumId;
    private boolean addVoice;

    @JvmField
    @NotNull
    public Context context;

    @JvmField
    public int cropHeight;

    @JvmField
    protected int currentLine;

    @JvmField
    public int indexTextbox;

    @JvmField
    public boolean isAlive;

    @JvmField
    public boolean isContinuousPage;

    @JvmField
    protected int lineCountBefore;

    @Nullable
    private CancellationSignal mCancellationSignal;

    @JvmField
    @NotNull
    public OfficeParams mDocParams;

    @JvmField
    @Nullable
    protected ParagraphAttrToOfficeHelper<?, ?> mHelper;

    @JvmField
    @NotNull
    public FileInsertHelper mInsertHelper;

    @Nullable
    private ArrayList<SpenObjectBase> mObjectBases;

    @JvmField
    protected OfficeDocument mOffice;

    @JvmField
    @Nullable
    protected OfficeElement mOfficeElement;

    @Nullable
    private ArrayList<SpenObjectStroke> mStrokes;

    @JvmField
    public int modeExport;

    @NotNull
    private String notePath;

    @JvmField
    @NotNull
    public final ArrayList<SpenObjectBase> objectSpanOfPage;

    @JvmField
    public int prevHeight;

    @JvmField
    @Nullable
    public List<TextInfo> results;

    @JvmField
    @NotNull
    public WNoteData wNoteData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int COLOR_GRAY99 = Color.parseColor("#fcfcfc");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0007J\b\u0010\u0015\u001a\u00020\u0013H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/OfficeView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAXIMUM_NUMBER_OF_EXPORTS", "", "LINE_BREAK", "", "PAGE", "COLOR_GRAY99", "mElementId", "mNumId", "getMNumId", "()I", "setMNumId", "(I)V", "setElementId", "", "elementId", "increaseElementId", "increaseNumId", "getPageThumbnailRect", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "bodyTextRectF", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getMNumId() {
            return OfficeView.mNumId;
        }

        @NotNull
        public final ArrayList<RectF> getPageThumbnailRect(@NotNull SpenWNote note, @NotNull RectF bodyTextRectF) {
            ArrayList<SpenWPage.PDFData> pdfData;
            Intrinsics.checkNotNullParameter(note, "note");
            Intrinsics.checkNotNullParameter(bodyTextRectF, "bodyTextRectF");
            ArrayList<RectF> arrayList = new ArrayList<>();
            int pageDefaultWidth = note.getPageDefaultWidth();
            if (note.getPageMode() == SpenWNote.PageMode.SINGLE && pageDefaultWidth != 0) {
                int height = DocumentPageRatio.PAGE_RATIO.getHeight(pageDefaultWidth);
                int i = 0;
                SpenWPage page = note.getPage(0);
                if (page.hasPDF() && (pdfData = page.getPdfData()) != null) {
                    Iterator<SpenWPage.PDFData> it = pdfData.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        SpenWPage.PDFData next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        SpenWPage.PDFData pDFData = next;
                        arrayList.add(pDFData.rect);
                        i = (int) pDFData.rect.bottom;
                    }
                }
                int iCoerceAtLeast = (int) RangesKt.coerceAtLeast(page.getDrawnRectOfAllObject().bottom, bodyTextRectF.bottom);
                while (i < iCoerceAtLeast) {
                    i += height;
                    arrayList.add(new RectF(0.0f, i, note.getWidth(), i));
                }
                AbstractC0000a.m3D(arrayList.size(), "getPageThumbnailRect# ", OfficeView.TAG);
            }
            return arrayList;
        }

        @JvmStatic
        public final void increaseElementId() {
            OfficeView.mElementId++;
        }

        @JvmStatic
        public final void increaseNumId() {
            setMNumId(getMNumId() + 1);
        }

        @JvmStatic
        public final void setElementId(int elementId) {
            OfficeView.mElementId = elementId;
        }

        public final void setMNumId(int i) {
            OfficeView.mNumId = i;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/OfficeView$ContinueIndex;", "", TextConst.KEY_START_INDEX, "", TextConst.KEY_END_INDEX, "height", "", "<init>", "(Lcom/samsung/android/support/senl/nt/word/base/OfficeView;IIF)V", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ContinueIndex {

        @JvmField
        public int endIndex;

        @JvmField
        public float height;

        @JvmField
        public int startIndex;

        public ContinueIndex(int i, int i2, float f) {
            this.startIndex = i;
            this.endIndex = i2;
            this.height = f;
        }
    }

    public OfficeView(@NotNull Context context, @NotNull OfficeParams mDocParams, @NotNull WNoteData wNoteData, @NotNull String notePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mDocParams, "mDocParams");
        Intrinsics.checkNotNullParameter(wNoteData, "wNoteData");
        Intrinsics.checkNotNullParameter(notePath, "notePath");
        this.context = context;
        this.mDocParams = mDocParams;
        this.wNoteData = wNoteData;
        this.notePath = notePath;
        this.mCancellationSignal = new CancellationSignal();
        this.modeExport = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_EXPORT, 0);
        this.currentLine = -1;
        this.isAlive = true;
        this.mInsertHelper = new FileInsertHelper(this, this.context);
        this.addVoice = true;
        this.objectSpanOfPage = new ArrayList<>();
        this.isContinuousPage = this.wNoteData.getSpenWNoteP().getPageMode() != SpenWNote.PageMode.LIST;
        configLib();
        this.mOffice = createDocument();
    }

    private final void addBackgroundPage(SpenWPage spenWPage, int indexPage, int currentHeight) {
        if (hasBackground(spenWPage)) {
            addBackground(spenWPage, indexPage, currentHeight);
        }
    }

    private final void addBodyTextContinuousPage(SpenObjectTextBox bodyText, SpenBodyTextContext bodyTextContext, int currentHeight, OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex, int turn, int numberOfExports) {
        if (bodyText == null || bodyText.getText() == null) {
            return;
        }
        addBodyTextContinuous(bodyText, bodyTextContext, currentHeight, continueIndex, turn, numberOfExports);
    }

    private final void addBodyTextFixedSizePage(SpenObjectTextBox bodyText, SpenBodyTextContext bodyTextContext, String contentPage, int indexPage, int turn, int numberOfExports) {
        if (bodyText == null || bodyText.getText() == null || contentPage == null) {
            return;
        }
        addBodyText(bodyText, bodyTextContext, indexPage, turn, numberOfExports, contentPage);
    }

    private final void addHandwritingPage(SpenWPage spenWPage, int currentHeight, int indexPage, int turn) {
        if ((hasHandWriting(spenWPage, currentHeight) && this.modeExport == 1) || (this.modeExport == 2 && turn == 2)) {
            addHandwriting(spenWPage, indexPage, currentHeight);
        }
    }

    private final void addObjectSpan(SpenBodyTextContext spenBodyTextContext, ArrayList<SpenObjectSpan> objectsFromSpan, int[] indexOfSpan, ArrayList<SpenObjectBase> objects, HashMap<SpenObjectBase, Integer> spanIndex, String content, int prevHeight, int currentHeight) {
        int i;
        if (objectsFromSpan == null) {
            return;
        }
        if (StringsKt.m14162r(content, UnicodeUtils.OBJECT_REPLACEMENT)) {
            Matcher matcher = Pattern.compile(UnicodeUtils.OBJECT_REPLACEMENT).matcher(content);
            i = 0;
            for (int i2 = 0; matcher.find() && i2 <= content.length(); i2++) {
                i++;
            }
        } else {
            i = 0;
        }
        int iCoerceAtLeast = indexOfSpan[0];
        int i4 = indexOfSpan[1];
        int i5 = i + iCoerceAtLeast;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i4 < objectsFromSpan.size()) {
                SpenObjectSpan spenObjectSpan = objectsFromSpan.get(i4);
                Intrinsics.checkNotNullExpressionValue(spenObjectSpan, "get(...)");
                SpenObjectSpan spenObjectSpan2 = spenObjectSpan;
                RectF objectRect = spenBodyTextContext.getObjectRect(spenObjectSpan2.getObject());
                float f = objectRect.top;
                if (f > currentHeight) {
                    break;
                }
                double d = ((objectRect.bottom - f) / 2) + f;
                if (this.isContinuousPage && (d <= prevHeight || d > currentHeight)) {
                    if (d > currentHeight) {
                        iCoerceAtLeast++;
                    }
                }
                objects.add(spenObjectSpan2.getObject());
                spanIndex.put(spenObjectSpan2.getObject(), Integer.valueOf(i4));
                i4++;
                iCoerceAtLeast = RangesKt.coerceAtLeast(iCoerceAtLeast - 1, 0);
            }
        }
        indexOfSpan[0] = iCoerceAtLeast;
        indexOfSpan[1] = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addObjectSpanContinuousPage(SpenObjectTextBox bodyText, OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex, SpenBodyTextContext bodyTextContext, ArrayList<SpenObjectSpan> objectsFromSpan, int[] indexOfSpan, ArrayList<SpenObjectBase> objects, HashMap<SpenObjectBase, Integer> spanIndex, int currentHeight) {
        String text;
        String str;
        int i = continueIndex.startIndex;
        int i2 = continueIndex.endIndex;
        if (i2 != 0 && (text = bodyText.getText()) != null) {
            String strSubstring = text.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            str = strSubstring == null ? "" : strSubstring;
        }
        addObjectSpan(bodyTextContext, objectsFromSpan, indexOfSpan, objects, spanIndex, str, this.prevHeight, currentHeight);
    }

    private final String addObjectSpanFixedSizePage(SpenObjectTextBox bodyText, int indexPage, SpenBodyTextContext bodyTextContext, ArrayList<SpenObjectSpan> objectsFromSpan, int[] indexOfSpan, ArrayList<SpenObjectBase> objects, HashMap<SpenObjectBase, Integer> spanIndex, int currentHeight) {
        if (bodyText.getText() == null) {
            return null;
        }
        int textSectionStart = bodyText.getTextSectionStart(indexPage);
        int textSectionLength = bodyText.getTextSectionLength(indexPage) + textSectionStart;
        if (textSectionStart == -1 || textSectionLength == 0) {
            return null;
        }
        String text = bodyText.getText();
        Intrinsics.checkNotNull(text);
        if (textSectionLength > text.length()) {
            return null;
        }
        String text2 = bodyText.getText();
        Intrinsics.checkNotNull(text2);
        String strSubstring = text2.substring(textSectionStart, textSectionLength);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        addObjectSpan(bodyTextContext, objectsFromSpan, indexOfSpan, objects, spanIndex, strSubstring, this.prevHeight, currentHeight);
        return strSubstring;
    }

    private final void addRecognizeTextContinuousPage(ArrayList<TextInfo>[] textInfos, int indexPage, int turn, SpenWPage spenWPage, int currentHeight) {
        ArrayList<TextInfo> arrayList;
        if (textInfos == null || (arrayList = textInfos[indexPage]) == null) {
            return;
        }
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.isEmpty() || turn != 1) {
            return;
        }
        addRecognizeText(textInfos[indexPage], spenWPage, currentHeight);
    }

    private final void addRecognizeTextFixedSizePage(ArrayList<TextInfo> textInfos, int turn, SpenWPage spenWPage, int currentHeight) {
        if (textInfos.isEmpty() || turn != 1) {
            return;
        }
        addRecognizeText(textInfos, spenWPage, currentHeight);
    }

    private final void addVoiceDataToViewPage(int indexPage, SpenWPage spenWPage) {
        if (indexPage == 0) {
            ArrayList<SpenVoiceData> voiceDataList = this.wNoteData.getSpenWNoteP().getVoiceDataList();
            Integer numValueOf = voiceDataList != null ? Integer.valueOf(voiceDataList.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() > 0) {
                addVoiceDataToView(spenWPage, indexPage);
            }
        }
    }

    private final void close() {
        CancellationSignal cancellationSignal;
        Logger.m10999d(getTag(), "close()");
        try {
            if (taskIsDead() && (cancellationSignal = this.mCancellationSignal) != null) {
                Intrinsics.checkNotNull(cancellationSignal);
                cancellationSignal.cancel();
            }
            this.wNoteData.getCaptureEngine().close();
        } catch (Exception e) {
            AbstractC8014b.m7207i("Error close() : ", e, getTag());
        }
    }

    private final File createFile(String shareDir, String fileName) {
        File file = new File(AbstractC2821a.m2221l(shareDir, File.separator, fileName, getFileExtension()));
        int i = 1;
        while (file.exists()) {
            String str = File.separator;
            String fileExtension = getFileExtension();
            StringBuilder sb = new StringBuilder();
            sb.append(shareDir);
            sb.append(str);
            sb.append(fileName);
            sb.append(" (");
            sb.append(i);
            file = new File(AbstractC0622a.m1170p(")", fileExtension, sb));
            i++;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int exportContinuousPage$lambda$5$lambda$4(SpenObjectBase spenObjectBase, SpenObjectBase spenObjectBase2) {
        if (spenObjectBase.getRect().top == spenObjectBase2.getRect().top) {
            return 0;
        }
        return spenObjectBase.getRect().top < spenObjectBase2.getRect().top ? -1 : 1;
    }

    private final List<TextInfo> getExtractTextResult(String notePath, int modeExport) {
        List<TextInfo>[] listArr = {null};
        if (notePath.length() > 0 && modeExport != 1) {
            boolean[] zArr = {false};
            new SenlThreadFactory(TAG).newThread(new RunnableC0218a(listArr, this, notePath, zArr, 20)).start();
            while (this.isAlive && !zArr[0]) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                    this.isAlive = false;
                }
            }
            Logger.m10999d(getTag(), "End recognize");
        }
        return listArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExtractTextResult$lambda$0(List[] listArr, OfficeView officeView, String str, boolean[] zArr) {
        try {
            listArr[0] = new RecognitionFacade().recognizeLine(officeView.context, str, officeView.mCancellationSignal);
        } catch (Exception e) {
            Logger.m10999d(officeView.getTag(), "Recognize error : " + e);
        }
        zArr[0] = true;
    }

    private final void getObjectNeedAdd(ArrayList<SpenObjectBase> objectsPage, ArrayList<SpenObjectBase> objectBases, HashMap<SpenObjectBase, Integer> spanIndex, HashMap<SpenObjectBase, Integer> spanIndexPage) {
        if (objectBases != null) {
            Iterator<SpenObjectBase> it = objectBases.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenObjectBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenObjectBase spenObjectBase = next;
                if (spenObjectBase.getType() == 4) {
                    getObjectNeedAdd(objectsPage, ((SpenObjectContainer) spenObjectBase).getObjectList(), spanIndex, spanIndexPage);
                } else {
                    objectsPage.add(spenObjectBase);
                    if (spanIndex.get(spenObjectBase) != null) {
                        spanIndexPage.put(spenObjectBase, Integer.valueOf(objectsPage.size() - 1));
                        this.objectSpanOfPage.add(spenObjectBase);
                    }
                }
            }
        }
    }

    private final ArrayList<SpenObjectBase> getObjectsContinuousPage(int prevHeight, int currentHeight) {
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        ArrayList<SpenObjectBase> arrayList2 = this.mObjectBases;
        if (arrayList2 != null) {
            Iterator<SpenObjectBase> it = arrayList2.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenObjectBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenObjectBase spenObjectBase = next;
                RectF rect = spenObjectBase.getRect();
                if (rect != null) {
                    float f = rect.top;
                    double d = ((rect.bottom - f) / 2) + f;
                    if (d > prevHeight && d <= currentHeight) {
                        if (spenObjectBase.getType() == 1) {
                            ArrayList<SpenObjectStroke> arrayList3 = this.mStrokes;
                            Intrinsics.checkNotNull(arrayList3);
                            Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectStroke");
                            arrayList3.add((SpenObjectStroke) spenObjectBase);
                        } else {
                            arrayList.add(spenObjectBase);
                        }
                        it.remove();
                    } else if (f > prevHeight) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    private final ArrayList<SpenObjectBase> getObjectsFixedPage(SpenWPage spenWPage) {
        ArrayList<SpenObjectBase> objectList = spenWPage.getObjectList();
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenObjectBase spenObjectBase = next;
            if (spenObjectBase.getType() != 1) {
                arrayList.add(spenObjectBase);
            } else {
                ArrayList<SpenObjectStroke> arrayList2 = this.mStrokes;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add((SpenObjectStroke) spenObjectBase);
            }
        }
        return arrayList;
    }

    private final boolean hasBackground(SpenWPage spenWPage) {
        if (spenWPage.hasPDF()) {
            return true;
        }
        return ((spenWPage.getBackgroundColor() == 0 || spenWPage.getBackgroundColor() == -1 || spenWPage.getBackgroundColor() == COLOR_GRAY99) && spenWPage.getTemplateType() == 0) ? false : true;
    }

    private final boolean hasHandWriting(SpenWPage spenWPage, int currentHeight) {
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = this.isContinuousPage ? this.prevHeight : 0;
        rectF.right = spenWPage.getWidth();
        if (!this.isContinuousPage) {
            currentHeight = spenWPage.getHeight();
        }
        rectF.bottom = currentHeight;
        return !spenWPage.findObjectInRect(1, rectF, true).isEmpty();
    }

    @JvmStatic
    public static final void increaseElementId() {
        INSTANCE.increaseElementId();
    }

    @JvmStatic
    public static final void increaseNumId() {
        INSTANCE.increaseNumId();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final File makeOfficeFile(OfficeDocument doc, String fileName, String shareDir) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        Logger.m10999d(getTag(), "make office File");
        File fileCreateFile = createFile(shareDir, fileName);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateFile));
            try {
                try {
                    writeToFile(doc, bufferedOutputStream);
                    Logger.m10999d(getTag(), "make office file success ");
                    try {
                        bufferedOutputStream.close();
                        return fileCreateFile;
                    } catch (IOException e) {
                        AbstractC8014b.m7198D("close stream error: ", e.getMessage(), getTag());
                        return fileCreateFile;
                    }
                } catch (Exception e2) {
                    e = e2;
                    Logger.m11000e(getTag(), "make office fail " + e.getMessage());
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                            AbstractC8014b.m7198D("close stream error: ", e3.getMessage(), getTag());
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e5) {
                        AbstractC8014b.m7198D("close stream error: ", e5.getMessage(), getTag());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream2 != null) {
            }
            throw th;
        }
    }

    @JvmStatic
    public static final void setElementId(int i) {
        INSTANCE.setElementId(i);
    }

    private final ArrayList<RectF> setThumbnailRects(SpenWPage spenWPage, ArrayList<RectF> inputThumbnailRects) {
        int width = spenWPage.getWidth();
        OfficeParams officeParams = this.mDocParams;
        int i = (width * officeParams.height) / officeParams.width;
        int height = 0;
        RectF rectF = new RectF(0.0f, 0, spenWPage.getWidth(), spenWPage.getHeight());
        while (height < spenWPage.getHeight()) {
            height += i;
            if (height > spenWPage.getHeight()) {
                inputThumbnailRects.add(rectF);
                height = spenWPage.getHeight();
            } else {
                rectF.bottom = height;
                inputThumbnailRects.add(rectF);
            }
        }
        return inputThumbnailRects;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortObjectSpan$lambda$2(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
        return Intrinsics.compare(spenObjectSpan.getTextIndex(), spenObjectSpan2.getTextIndex());
    }

    private final boolean taskIsDead() {
        if (!Thread.currentThread().isInterrupted() && this.isAlive) {
            return false;
        }
        this.isAlive = false;
        Logger.m10999d(getTag(), "Export task is interrupted");
        return true;
    }

    public abstract void addBackground(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight);

    public abstract void addBodyText(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int indexPage, int turn, int maxTurn, @Nullable String contentPage);

    public abstract void addBodyTextContinuous(@Nullable SpenObjectTextBox bodyText, @Nullable SpenBodyTextContext bodyTextContext, int currentHeight, @Nullable OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex, int turn, int maxTurn);

    public abstract void addHandwriting(@Nullable SpenWPage spenWPage, int indexPage, int currentHeight);

    public abstract void addItemsOfPage(@Nullable SpenBodyTextContext bodyTextContext, @Nullable ArrayList<SpenObjectBase> objectsOfPage, @Nullable SpenWPage spenWPage, @Nullable HashMap<SpenObjectBase, Integer> objectsIndex, boolean addVoice);

    public abstract void addRecognizeText(@Nullable ArrayList<TextInfo> textInfos, @Nullable SpenWPage spenWPage, int currentHeight);

    public void addVoiceDataToView(@NotNull SpenWPage spenWPage, int indexPage) {
        Intrinsics.checkNotNullParameter(spenWPage, "spenWPage");
    }

    public void configLib() {
        try {
            System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
            System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
            System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
        } catch (Exception e) {
            Logger.m11001e(getTag(), "configLib: " + e.getMessage(), e);
        }
    }

    public final int countLinesBefore(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int length = data.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (data.charAt(i2) == '\n') {
                i++;
            }
        }
        return i;
    }

    public abstract OfficeDocument createDocument();

    /* JADX WARN: Removed duplicated region for block: B:44:0x016d  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File exportContinuousPage(@NotNull String fileName, @NotNull String shareDir) {
        OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex;
        HashMap<SpenObjectBase, Integer> map;
        ArrayList<SpenObjectSpan> arrayList;
        int i;
        int i2;
        ArrayList<SpenObjectBase> arrayList2;
        HashMap<SpenObjectBase, Integer> map2;
        int i4;
        int i5;
        SpenWPage spenWPage;
        int i6;
        OfficeView<OfficeDocument, OfficeElement> officeView = this;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(shareDir, "shareDir");
        Logger.m10999d(officeView.getTag(), "Start export continuous page");
        officeView.results = officeView.getExtractTextResult(officeView.notePath, officeView.modeExport);
        SpenWPage page = officeView.wNoteData.getPage(0);
        if (page == null) {
            return null;
        }
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(officeView.context);
        spenBodyTextContext.setDocument(officeView.wNoteData.getSpenWNoteP());
        spenBodyTextContext.measureText();
        ArrayList<RectF> pageThumbnailRect = INSTANCE.getPageThumbnailRect(officeView.wNoteData.getSpenWNoteP(), spenBodyTextContext.getMeasuredFitRect(0));
        ArrayList<SpenObjectBase> objectList = page.getObjectList();
        officeView.mObjectBases = objectList;
        if (objectList != null) {
            Collections.sort(objectList, new C0016a(13));
        }
        officeView.initHelper(officeView.wNoteData.getSpenWNoteP().getBodyText());
        if (pageThumbnailRect.isEmpty()) {
            pageThumbnailRect = officeView.setThumbnailRects(page, pageThumbnailRect);
        }
        if (officeView.mStrokes == null) {
            officeView.mStrokes = new ArrayList<>();
        }
        ArrayList<SpenObjectBase> arrayList3 = new ArrayList<>();
        HashMap<SpenObjectBase, Integer> map3 = new HashMap<>();
        ArrayList<SpenObjectSpan> objectSpan = officeView.wNoteData.getSpenWNoteP().getBodyText() != null ? officeView.wNoteData.getSpenWNoteP().getBodyText().getObjectSpan() : null;
        officeView.sortObjectSpan(objectSpan);
        int[] iArr = new int[2];
        ArrayList<TextInfo>[] textExtractInfosContinuousPage = !pageThumbnailRect.isEmpty() ? SpenWPageHelper.INSTANCE.getTextExtractInfosContinuousPage(officeView.results, pageThumbnailRect) : null;
        Iterator<RectF> it = pageThumbnailRect.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i7 = 0;
        int i8 = 0;
        while (it.hasNext()) {
            RectF next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RectF rectF = next;
            officeView.objectSpanOfPage.clear();
            ArrayList<SpenObjectStroke> arrayList4 = officeView.mStrokes;
            Intrinsics.checkNotNull(arrayList4);
            arrayList4.clear();
            int i9 = (int) (rectF.bottom - rectF.top);
            officeView.cropHeight = i9;
            int i10 = i7 + i9;
            officeView.updateMargin(page.getWidth(), officeView.cropHeight);
            ArrayList<SpenObjectBase> objectsContinuousPage = officeView.getObjectsContinuousPage(officeView.prevHeight, i10);
            HashMap<SpenObjectBase, Integer> map4 = new HashMap<>();
            Iterator<RectF> it2 = it;
            OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex2 = officeView.getContinueIndex(spenBodyTextContext, i10);
            if (officeView.wNoteData.getSpenWNoteP().getBodyText().getText() != null) {
                SpenBodyTextContext spenBodyTextContext2 = spenBodyTextContext;
                i = 2;
                officeView.addObjectSpanContinuousPage(officeView.wNoteData.getSpenWNoteP().getBodyText(), continueIndex2, spenBodyTextContext2, objectSpan, iArr, objectsContinuousPage, map4, i10);
                ArrayList<SpenObjectSpan> arrayList5 = objectSpan;
                continueIndex = continueIndex2;
                map = map4;
                arrayList = arrayList5;
                spenBodyTextContext = spenBodyTextContext2;
            } else {
                ArrayList<SpenObjectSpan> arrayList6 = objectSpan;
                continueIndex = continueIndex2;
                map = map4;
                arrayList = arrayList6;
                i = 2;
            }
            int i11 = i10;
            int[] iArr2 = iArr;
            if (!arrayList3.isEmpty()) {
                arrayList3.clear();
            }
            if (!map3.isEmpty()) {
                map3.clear();
            }
            officeView.getObjectNeedAdd(arrayList3, objectsContinuousPage, map, map3);
            ArrayList<SpenObjectStroke> arrayList7 = officeView.mStrokes;
            int i12 = 1;
            if (arrayList7 == null) {
                i2 = 1;
            } else if (officeView.modeExport != i || arrayList7 == null) {
                i6 = 1;
                i2 = i6;
            } else {
                Intrinsics.checkNotNull(arrayList7);
                if (!arrayList7.isEmpty()) {
                    i6 = i;
                }
                i2 = i6;
            }
            if (1 <= i2) {
                while (true) {
                    officeView.mOfficeElement = null;
                    if (officeView.taskIsDead()) {
                        break;
                    }
                    officeView.addBackgroundPage(page, 0, i11);
                    if (officeView.taskIsDead()) {
                        break;
                    }
                    SpenBodyTextContext spenBodyTextContext3 = spenBodyTextContext;
                    officeView.addBodyTextContinuousPage(officeView.wNoteData.getSpenWNoteP().getBodyText(), spenBodyTextContext3, i11, continueIndex, i12, i2);
                    int i13 = i2;
                    OfficeView<OfficeDocument, OfficeElement>.ContinueIndex continueIndex3 = continueIndex;
                    if (taskIsDead()) {
                        officeView = this;
                        spenBodyTextContext = spenBodyTextContext3;
                        arrayList2 = arrayList3;
                        map2 = map3;
                        i4 = i8;
                        break;
                    }
                    int i14 = i12;
                    int i15 = i11;
                    officeView = this;
                    SpenWPage spenWPage2 = page;
                    ArrayList<TextInfo>[] arrayListArr = textExtractInfosContinuousPage;
                    int i16 = i8;
                    officeView.addRecognizeTextContinuousPage(arrayListArr, i16, i14, spenWPage2, i15);
                    textExtractInfosContinuousPage = arrayListArr;
                    if (officeView.taskIsDead()) {
                        spenBodyTextContext = spenBodyTextContext3;
                        i4 = i16;
                        arrayList2 = arrayList3;
                        i5 = i15;
                        spenWPage = spenWPage2;
                        map2 = map3;
                        break;
                    }
                    spenBodyTextContext = spenBodyTextContext3;
                    i4 = i16;
                    arrayList2 = arrayList3;
                    i5 = i15;
                    spenWPage = spenWPage2;
                    map2 = map3;
                    officeView.addItemsOfPage(spenBodyTextContext, arrayList2, spenWPage, map2, !officeView.addVoice);
                    if (officeView.taskIsDead()) {
                        break;
                    }
                    officeView.addHandwritingPage(spenWPage, i5, 0, i14);
                    if (officeView.taskIsDead()) {
                        break;
                    }
                    officeView.addItemsOfPage(spenBodyTextContext, arrayList2, spenWPage, map2, officeView.addVoice);
                    if (officeView.taskIsDead()) {
                        break;
                    }
                    officeView.addVoiceDataToViewPage(i4, spenWPage);
                    officeView.indexTextbox = 0;
                    if (i14 != i13) {
                        i12 = i14 + 1;
                        map3 = map2;
                        i8 = i4;
                        i2 = i13;
                        continueIndex = continueIndex3;
                        page = spenWPage;
                        i11 = i5;
                        arrayList3 = arrayList2;
                    }
                }
            } else {
                arrayList2 = arrayList3;
                map2 = map3;
                i4 = i8;
                i5 = i11;
                spenWPage = page;
            }
            officeView.prevHeight = i5;
            page = spenWPage;
            map3 = map2;
            i8 = i4 + 1;
            objectSpan = arrayList;
            iArr = iArr2;
            i7 = i5;
            arrayList3 = arrayList2;
            it = it2;
        }
        if (officeView.taskIsDead()) {
            Logger.m10999d(officeView.getTag(), "Task is dead, return null");
            return null;
        }
        if (officeView.taskIsDead()) {
            Logger.m10999d(officeView.getTag(), "Task is dead, return null");
            return null;
        }
        officeView.close();
        File fileInsertFile = officeView.insertFile(officeView.makeOfficeFile(officeView.mOffice, fileName, shareDir));
        Logger.m10999d(officeView.getTag(), "End export continuous page");
        return fileInsertFile;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x011a, code lost:
    
        r6 = r2;
        r15 = r4;
        r17 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x011e, code lost:
    
        r2 = r13;
        r4 = r14;
        r16 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final File exportFixedSizePage(@NotNull String fileName, @NotNull String shareDir) {
        SpenWPage spenWPage;
        int i;
        int[] iArr;
        HashMap<SpenObjectBase, Integer> map;
        ArrayList<SpenObjectSpan> arrayList;
        int i2;
        String strAddObjectSpanFixedSizePage;
        SpenObjectTextBox spenObjectTextBox;
        int i4;
        boolean z;
        int i5;
        int i6;
        ArrayList<SpenObjectSpan> arrayList2;
        ArrayList<SpenObjectBase> arrayList3;
        HashMap<SpenObjectBase, Integer> map2;
        int i7;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(shareDir, "shareDir");
        Logger.m10999d(getTag(), "Start export fixed size page");
        this.results = getExtractTextResult(this.notePath, this.modeExport);
        boolean z2 = true;
        int pageCount = this.wNoteData.getPageCount() - 1;
        SpenObjectTextBox bodyText = this.wNoteData.getSpenWNoteP().getBodyText();
        initHelper(bodyText);
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(this.context);
        spenBodyTextContext.setDocument(this.wNoteData.getSpenWNoteP());
        spenBodyTextContext.measureText();
        if (this.mStrokes == null) {
            this.mStrokes = new ArrayList<>();
        }
        ArrayList<SpenObjectBase> arrayList4 = new ArrayList<>();
        HashMap<SpenObjectBase, Integer> map3 = new HashMap<>();
        ArrayList<SpenObjectSpan> objectSpan = bodyText != null ? bodyText.getObjectSpan() : null;
        sortObjectSpan(objectSpan);
        int[] iArr2 = new int[2];
        int i8 = 0;
        SpenBodyTextContext spenBodyTextContext2 = spenBodyTextContext;
        int i9 = 0;
        while (i9 < pageCount) {
            this.objectSpanOfPage.clear();
            ArrayList<SpenObjectStroke> arrayList5 = this.mStrokes;
            if (arrayList5 != null) {
                arrayList5.clear();
            }
            SpenWPage page = this.wNoteData.getPage(i9);
            if (page == null) {
                spenObjectTextBox = bodyText;
                i5 = i9;
                arrayList2 = objectSpan;
                iArr = iArr2;
                z = z2;
                arrayList3 = arrayList4;
                map2 = map3;
            } else {
                int height = page.getHeight() + i8;
                updateMargin(page.getWidth(), page.getHeight());
                ArrayList<SpenObjectBase> objectsFixedPage = getObjectsFixedPage(page);
                HashMap<SpenObjectBase, Integer> map4 = new HashMap<>();
                if (bodyText == null || bodyText.getText() == null) {
                    spenWPage = page;
                    i = 2;
                    iArr = iArr2;
                    map = map4;
                    arrayList = objectSpan;
                    i2 = height;
                    strAddObjectSpanFixedSizePage = null;
                } else {
                    spenWPage = page;
                    i = 2;
                    strAddObjectSpanFixedSizePage = addObjectSpanFixedSizePage(bodyText, i9, spenBodyTextContext2, objectSpan, iArr2, objectsFixedPage, map4, height);
                    arrayList = objectSpan;
                    i2 = height;
                    iArr = iArr2;
                    map = map4;
                }
                if (!arrayList4.isEmpty()) {
                    arrayList4.clear();
                }
                if (!map3.isEmpty()) {
                    map3.clear();
                }
                getObjectNeedAdd(arrayList4, objectsFixedPage, map, map3);
                ArrayList<TextInfo> textExtractInfosFixedPage = SpenWPageHelper.INSTANCE.getTextExtractInfosFixedPage(this.results, spenWPage);
                ArrayList<SpenObjectStroke> arrayList6 = this.mStrokes;
                spenObjectTextBox = bodyText;
                if (arrayList6 == null) {
                    i4 = 1;
                } else if (this.modeExport != i || arrayList6 == null) {
                    i7 = 1;
                    i4 = i7;
                } else {
                    Intrinsics.checkNotNull(arrayList6);
                    if (!arrayList6.isEmpty()) {
                        i7 = i;
                    }
                    i4 = i7;
                }
                if (1 <= i4) {
                    int i10 = 1;
                    while (true) {
                        this.mOfficeElement = null;
                        if (!taskIsDead()) {
                            addBackgroundPage(spenWPage, i9, i2);
                            if (!taskIsDead()) {
                                i6 = i2;
                                int i11 = i9;
                                SpenBodyTextContext spenBodyTextContext3 = spenBodyTextContext2;
                                String str = strAddObjectSpanFixedSizePage;
                                arrayList2 = arrayList;
                                ArrayList<TextInfo> arrayList7 = textExtractInfosFixedPage;
                                int i12 = i10;
                                addBodyTextFixedSizePage(spenObjectTextBox, spenBodyTextContext3, str, i11, i12, i4);
                                int i13 = i4;
                                spenBodyTextContext2 = spenBodyTextContext3;
                                i5 = i11;
                                if (!taskIsDead()) {
                                    addRecognizeTextFixedSizePage(arrayList7, i12, spenWPage, i6);
                                    if (!taskIsDead()) {
                                        z = true;
                                        SpenWPage spenWPage2 = spenWPage;
                                        arrayList3 = arrayList4;
                                        map2 = map3;
                                        addItemsOfPage(spenBodyTextContext2, arrayList3, spenWPage2, map2, !this.addVoice);
                                        spenBodyTextContext2 = spenBodyTextContext2;
                                        if (!taskIsDead()) {
                                            addHandwritingPage(spenWPage2, i6, i5, i12);
                                            if (!taskIsDead()) {
                                                addItemsOfPage(spenBodyTextContext2, arrayList3, spenWPage2, map2, this.addVoice);
                                                spenBodyTextContext2 = spenBodyTextContext2;
                                                if (!taskIsDead()) {
                                                    addVoiceDataToViewPage(i5, spenWPage2);
                                                    this.indexTextbox = 0;
                                                    if (i12 == i13) {
                                                        break;
                                                    }
                                                    spenWPage = spenWPage2;
                                                    i10 = i12 + 1;
                                                    arrayList4 = arrayList3;
                                                    i9 = i5;
                                                    i4 = i13;
                                                    map3 = map2;
                                                    textExtractInfosFixedPage = arrayList7;
                                                    i2 = i6;
                                                    arrayList = arrayList2;
                                                    strAddObjectSpanFixedSizePage = str;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    z = true;
                    i5 = i9;
                    i6 = i2;
                    arrayList2 = arrayList;
                    arrayList3 = arrayList4;
                    map2 = map3;
                }
                this.prevHeight = i6;
                i8 = i6;
            }
            arrayList4 = arrayList3;
            map3 = map2;
            iArr2 = iArr;
            z2 = z;
            objectSpan = arrayList2;
            i9 = i5 + 1;
            bodyText = spenObjectTextBox;
        }
        if (taskIsDead()) {
            Logger.m10999d(getTag(), "Task is dead, return null");
            return null;
        }
        close();
        File fileInsertFile = insertFile(makeOfficeFile(this.mOffice, fileName, shareDir));
        Logger.m10999d(getTag(), "End export fixed size page");
        return fileInsertFile;
    }

    @NotNull
    public abstract OfficeView<OfficeDocument, OfficeElement>.ContinueIndex getContinueIndex(@Nullable SpenBodyTextContext bodyTextContext, int currentHeight);

    @Nullable
    public abstract String getFileExtension();

    @Nullable
    public final CancellationSignal getMCancellationSignal() {
        return this.mCancellationSignal;
    }

    @NotNull
    public abstract String getTag();

    public abstract void initHelper(@Nullable SpenObjectTextBox textBox);

    @Nullable
    public File insertFile(@Nullable File officeFile) {
        if (officeFile != null) {
            return this.mInsertHelper.insertFile(officeFile);
        }
        return null;
    }

    public final void setMCancellationSignal(@Nullable CancellationSignal cancellationSignal) {
        this.mCancellationSignal = cancellationSignal;
    }

    public void sortObjectSpan(@Nullable ArrayList<SpenObjectSpan> objectsFromSpan) {
        if (objectsFromSpan != null) {
            CollectionsKt.sortWith(objectsFromSpan, new C0016a(14));
        }
    }

    public abstract void writeToFile(OfficeDocument doc, @Nullable BufferedOutputStream output);

    public void updateMargin(int widthNote, int heightNote) {
    }
}
