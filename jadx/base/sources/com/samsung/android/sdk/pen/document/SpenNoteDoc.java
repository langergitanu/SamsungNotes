package com.samsung.android.sdk.pen.document;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.util.SpenLogInjector;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 í\u00012\u00020\u0001:\u0004ì\u0001í\u0001B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tB+\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u000bB+\b\u0012\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u000fB-\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u0012B-\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u0015B7\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u0017B7\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u0018B5\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u0002\u0010\u001bB?\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u0002\u0010\u001cJ\u0013\u0010L\u001a\u00020\u001a2\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010N\u001a\u00020\u0007H\u0016J\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020PJ\u001a\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u001a2\b\b\u0002\u0010S\u001a\u00020\u001aH\u0007J\u0010\u0010T\u001a\u00020P2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010U\u001a\u00020\u001aJ\u0016\u0010V\u001a\u00020P2\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0014J \u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0011J\u001a\u0010]\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u00112\b\u0010_\u001a\u0004\u0018\u00010\u0011J\u0018\u0010`\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u00112\u0006\u0010_\u001a\u00020\u0007J%\u0010a\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u00112\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010b¢\u0006\u0002\u0010cJ\u001a\u0010d\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u00112\b\u0010_\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020\u00112\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010g\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u001b\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00110b2\b\u0010^\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010iJ\u0010\u0010j\u001a\u00020e2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u000e\u0010k\u001a\u00020\u001a2\u0006\u0010^\u001a\u00020\u0011J\u0010\u0010l\u001a\u00020\u001a2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010m\u001a\u00020\u001a2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010n\u001a\u00020\u001a2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010o\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010p\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010q\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0010\u0010r\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\b\u0010s\u001a\u0004\u0018\u00010tJ\"\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020\u00072\b\u0010v\u001a\u0004\u0018\u00010\u00112\u0006\u0010w\u001a\u00020\u0007J\u0018\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010x\u001a\u0004\u0018\u00010t2\u0006\u0010y\u001a\u00020\u0007J*\u0010x\u001a\u0004\u0018\u00010t2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\b\u0010v\u001a\u0004\u0018\u00010\u00112\u0006\u0010w\u001a\u00020\u0007J \u0010x\u001a\u0004\u0018\u00010t2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010z\u001a\u00020P2\u0006\u0010y\u001a\u00020\u0007J\u0018\u0010{\u001a\u00020P2\b\u0010|\u001a\u0004\u0018\u00010t2\u0006\u0010}\u001a\u00020\u0007J\u0010\u0010~\u001a\u0004\u0018\u00010\u00112\u0006\u0010y\u001a\u00020\u0007J\u0011\u0010\u007f\u001a\u00020\u00072\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0011J\u000f\u0010\u0081\u0001\u001a\u00020t2\u0006\u0010y\u001a\u00020\u0007J\u001b\u0010\u0082\u0001\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0011\u0010\u0083\u0001\u001a\u00020P2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0013\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0011\u0010\u0085\u0001\u001a\u00020\u001a2\b\u0010^\u001a\u0004\u0018\u00010\u0011J\u0014\u0010\u0086\u0001\u001a\u00020P2\t\u0010\f\u001a\u0005\u0018\u00010\u0087\u0001H\u0007J\u0014\u0010\u0086\u0001\u001a\u00020P2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0011H\u0007J\u0011\u0010\u0089\u0001\u001a\u00020P2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001b\u0010\u0086\u0001\u001a\u00020P2\t\u0010\f\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u001aJ\u0019\u0010\u0086\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u00020\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u001aJ\u0018\u0010\u0089\u0001\u001a\u00020P2\u0006\u0010\u0010\u001a\u00020\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u001aJ,\u0010\u008b\u0001\u001a\u00020P2\u001b\u0010\u008c\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001j\n\u0012\u0005\u0012\u00030\u008e\u0001`\u008f\u00012\u0006\u0010\u0010\u001a\u00020\u0011JF\u0010\u008b\u0001\u001a\u00020P2\u001f\u0010\u008c\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u008d\u0001j\f\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u0001`\u008f\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001J#\u0010\u0093\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001j\n\u0012\u0005\u0012\u00030\u008e\u0001`\u008f\u00012\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u0095\u0001\u001a\u00020t2\u0006\u0010y\u001a\u00020\u0007J\u0018\u0010\u0096\u0001\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0007J\t\u0010\u0098\u0001\u001a\u00020PH\u0004J\u0012\u0010\u0099\u0001\u001a\u00020P2\u0007\u0010\u009a\u0001\u001a\u00020\u0007H\u0002J6\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J9\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\f\u001a\u0005\u0018\u00010\u009e\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 J:\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 JC\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\f\u001a\u0005\u0018\u00010\u009e\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 JD\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 JK\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0082 JC\u0010\u009b\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 J=\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u001aH\u0082 J\u0013\u0010£\u0001\u001a\u00020P2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¤\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u001c\u0010¥\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u001aH\u0082 J$\u0010§\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u001aH\u0082 J\u0013\u0010¨\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010©\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010«\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u001c\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\f\u001a\u00030\u009e\u0001H\u0082 J\u001c\u0010®\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\f\u001a\u00030 \u0001H\u0082 J\u001e\u0010¯\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0011H\u0082 J\u0013\u0010±\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010²\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010³\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u001d\u0010´\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.H\u0082 J\u0013\u0010µ\u0001\u001a\u00020.2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J#\u0010¶\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0014H\u0082 J\u0013\u0010·\u0001\u001a\u00020\u00142\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¸\u0001\u001a\u00020\u00142\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u001d\u0010¹\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u0011H\u0082 J\u0013\u0010º\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J-\u0010»\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\b\u0010\\\u001a\u0004\u0018\u00010\u0011H\u0082 J\u0013\u0010¼\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010½\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010¾\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J'\u0010¿\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u00112\b\u0010_\u001a\u0004\u0018\u00010\u0011H\u0082 J%\u0010À\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u00112\u0006\u0010_\u001a\u00020\u0007H\u0082 J<\u0010Á\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u00112\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010b2\u0007\u0010Â\u0001\u001a\u00020\u0007H\u0082 ¢\u0006\u0003\u0010Ã\u0001J0\u0010Ä\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u00112\b\u0010_\u001a\u0004\u0018\u00010e2\u0007\u0010Â\u0001\u001a\u00020\u0007H\u0082 J\u001d\u0010Å\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Æ\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J)\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110b2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 ¢\u0006\u0003\u0010È\u0001J\u001d\u0010É\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ê\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ë\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ì\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Í\u0001\u001a\u00020e2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Î\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ï\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ð\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ñ\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J%\u0010Ò\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J1\u0010Ò\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u00072\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 J-\u0010Õ\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0082 J9\u0010Õ\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u00072\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0007H\u0082 J\u001b\u0010Ö\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0082 J%\u0010×\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010|\u001a\u0004\u0018\u00010t2\u0006\u0010}\u001a\u00020\u0007H\u0082 J\u001d\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0082 J\u001e\u0010Ù\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Ú\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0082 J\u0013\u0010Û\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010Ü\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J(\u0010Ý\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u00112\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010Þ\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u0013\u0010ß\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u001f\u0010à\u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u001d\u0010á\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010^\u001a\u0004\u0018\u00010\u0011H\u0082 J\u0013\u0010â\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J\u0013\u0010ã\u0001\u001a\u00020\u00072\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0082 J8\u0010ä\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u001b\u0010\u008c\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001j\n\u0012\u0005\u0012\u00030\u008e\u0001`\u008f\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0082 J/\u0010å\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001j\n\u0012\u0005\u0012\u00030\u008e\u0001`\u008f\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0082 J&\u0010æ\u0001\u001a\u0004\u0018\u00010t2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010ç\u0001\u001a\u00020t2\u0006\u0010y\u001a\u00020\u0007H\u0082 J%\u0010è\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\f\u001a\u00030é\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u001aH\u0082 J&\u0010è\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010\u008a\u0001\u001a\u00020\u001aH\u0082 J&\u0010è\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u001aH\u0082 J&\u0010ê\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0007\u0010\u008a\u0001\u001a\u00020\u001aH\u0082 JR\u0010ä\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u001f\u0010\u008c\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u008d\u0001j\f\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u0001`\u008f\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H\u0082 J&\u0010ë\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010y\u001a\u00020\u0007H\u0082 R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b&\u0010#R(\u0010'\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b+\u0010,R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b8\u00106R(\u0010:\u001a\u0004\u0018\u00010\u00112\b\u00109\u001a\u0004\u0018\u00010\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010!\"\u0004\b<\u0010*R\u0011\u0010=\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b>\u0010#R\u0011\u0010?\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b@\u0010#R\u0011\u0010A\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bB\u0010!R\u0011\u0010C\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bD\u0010!R\u0011\u0010E\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bF\u0010#R\u0011\u0010G\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bH\u0010#R\u0011\u0010I\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bI\u0010,R\u0011\u0010J\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bK\u0010#¨\u0006î\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "", "<init>", "()V", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/content/Context;II)V", "orientation", "(Landroid/content/Context;III)V", "stream", "Ljava/io/InputStream;", "mode", "(Landroid/content/Context;Ljava/io/InputStream;II)V", "filePath", "", "(Landroid/content/Context;Ljava/lang/String;II)V", Key.ROTATION, "", "(Landroid/content/Context;Ljava/lang/String;DI)V", "password", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;II)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;DI)V", "discardUnsavedData", "", "(Landroid/content/Context;Ljava/lang/String;IIZ)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IIZ)V", "mContext", "mHandle", "id", "getId", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "getRotation", "getOrientation", "coverImagePath", "getCoverImagePath", "setCoverImagePath", "(Ljava/lang/String;)V", "isAllPageTextOnly", "()Z", "info", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc$AuthorInfo;", "authorInfo", "getAuthorInfo", "()Lcom/samsung/android/sdk/pen/document/SpenNoteDoc$AuthorInfo;", "setAuthorInfo", "(Lcom/samsung/android/sdk/pen/document/SpenNoteDoc$AuthorInfo;)V", "geoTagLatitude", "getGeoTagLatitude", "()D", "geoTagLongitude", "getGeoTagLongitude", "name", "appName", "getAppName", "setAppName", "appMajorVersion", "getAppMajorVersion", "appMinorVersion", "getAppMinorVersion", "appPatchName", "getAppPatchName", "internalDirectory", "getInternalDirectory", "lastEditedPageIndex", "getLastEditedPageIndex", "pageCount", "getPageCount", "isChanged", "attachedFileCount", "getAttachedFileCount", "equals", "other", "hashCode", ClientCookie.DISCARD_ATTR, "", "close", "removeCache", "updateCacheState", "setCoverImage", "hasTaggedPage", "setGeoTag", "latitude", "longitude", "setAppVersion", "majorVersion", "minorVersion", "patchName", "setExtraDataString", "key", "value", "setExtraDataInt", "setExtraDataStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "setExtraDataByteArray", "", "getExtraDataString", "getExtraDataInt", "getExtraDataStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "getExtraDataByteArray", "hasExtraDataString", "hasExtraDataInt", "hasExtraDataStringArray", "hasExtraDataByteArray", "removeExtraDataString", "removeExtraDataInt", "removeExtraDataStringArray", "removeExtraDataByteArray", "appendPage", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "backgroundColor", "backgroundImagePath", "backgourndImageMode", "insertPage", "pageIndex", "removePage", "movePageIndex", "page", "step", "getPageIdByIndex", "getPageIndexById", "pageId", "getPage", "attachFile", "detachFile", "getAttachedFile", "hasAttachedFile", "save", "Ljava/io/OutputStream;", "filepath", "attachToFile", "compatibleMode", "backupObjectList", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "horizontalDelta", "", "verticalDelta", "restoreObjectList", "copyPage", "sourcePage", "transferPage", "destNote", "finalize", "throwUncheckedException", "errno", "NoteDoc_init", "handle", "cacheDirPath", "Ljava/io/ByteArrayInputStream;", "fd", "Ljava/io/FileDescriptor;", "NoteDoc_initSaveHistory", "isSaveHistory", "NoteDoc_finalize", "NoteDoc_discard", "NoteDoc_close", "clearCache", "NoteDoc_close2", "NoteDoc_getId", "NoteDoc_getWidth", "NoteDoc_getHeight", "NoteDoc_getRotation", "NoteDoc_getOrientation", "NoteDoc_getOrientation2", "NoteDoc_getOrientation3", "NoteDoc_setCoverImage", "uri", "NoteDoc_getCoverImagePath", "NoteDoc_hasTaggedPage", "NoteDoc_isAllPageTextOnly", "NoteDoc_setAuthorInfo", "NoteDoc_getAuthorInfo", "NoteDoc_setGeoTag", "NoteDoc_getGeoTagLatitude", "NoteDoc_getGeoTagLongitude", "NoteDoc_setAppName", "NoteDoc_getAppName", "NoteDoc_setAppVersion", "NoteDoc_getAppMajorVersion", "NoteDoc_getAppMinorVersion", "NoteDoc_getAppPatchName", "NoteDoc_setExtraDataString", "NoteDoc_setExtraDataInt", "NoteDoc_setExtraDataStringArray", "valueCount", "(ILjava/lang/String;[Ljava/lang/String;I)Z", "NoteDoc_setExtraDataByteArray", "NoteDoc_getExtraDataString", "NoteDoc_getExtraDataInt", "NoteDoc_getExtraDataStringArray", "(ILjava/lang/String;)[Ljava/lang/String;", "NoteDoc_hasExtraDataString", "NoteDoc_hasExtraDataInt", "NoteDoc_hasExtraDataStringArray", "NoteDoc_hasExtraDataByteArray", "NoteDoc_getExtraDataByteArray", "NoteDoc_removeExtraDataString", "NoteDoc_removeExtraDataInt", "NoteDoc_removeExtraDataStringArray", "NoteDoc_removeExtraDataByteArray", "NoteDoc_appendPage", "color", "path", "NoteDoc_insertPage", "NoteDoc_removePage", "NoteDoc_movePageIndex", "NoteDoc_getPageIdByIndex", "NoteDoc_getPageIndexById", "NoteDoc_getPage", "NoteDoc_getPageCount", "NoteDoc_isChanged", "NoteDoc_attachFile", "NoteDoc_detachFile", "NoteDoc_getAttachedFileCount", "NoteDoc_getAttachedFile", "NoteDoc_hasAttachedFile", "NoteDoc_getInternalDirectory", "NoteDoc_getLastEditedPageIndex", "NoteDoc_backupObjectList", "NoteDoc_restoreObjectList", "NoteDoc_copyPage", "source", "NoteDoc_save", "Ljava/io/ByteArrayOutputStream;", "NoteDoc_attachToFile", "NoteDoc_transferPage", "AuthorInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteDoc {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MODE_READ_ONLY = 0;
    public static final int MODE_WRITABLE = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    private static boolean sIsFeatureChecked;
    private static boolean sIsLogEnabled;
    private static int sSdkVersionCode;

    @Nullable
    private static WeakReference<Context> sWeakContext;

    @Nullable
    private Context mContext;
    private int mHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenNoteDoc$AuthorInfo;", "", "<init>", "()V", "name", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "email", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AuthorInfo {

        @JvmField
        @Nullable
        public String email;

        @JvmField
        @Nullable
        public String imageUri;

        @JvmField
        @Nullable
        public String name;

        @JvmField
        @Nullable
        public String phoneNumber;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenNoteDoc$Companion;", "", "<init>", "()V", "ORIENTATION_PORTRAIT", "", "ORIENTATION_LANDSCAPE", "MODE_READ_ONLY", "MODE_WRITABLE", "sWeakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "sIsLogEnabled", "", "sIsFeatureChecked", "sSdkVersionCode", "insertLog", "", ExtensionConst.KEY_PARAM_FEATURE, "", "extra", "value", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void insertLog(String feature, String extra, int value) {
            try {
                WeakReference weakReference = SpenNoteDoc.sWeakContext;
                Intrinsics.checkNotNull(weakReference);
                Context context = (Context) weakReference.get();
                if (context == null) {
                    Log.w("SpenSdk", "Cannot log. lost context");
                    return;
                }
                if (!SpenNoteDoc.sIsFeatureChecked) {
                    SpenNoteDoc.sIsLogEnabled = Intrinsics.areEqual("TRUE", FloatingFeatureWrapper.create(context).getString("SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE"));
                    SpenNoteDoc.sIsFeatureChecked = true;
                }
                if (SpenNoteDoc.sIsLogEnabled) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", SpenLogInjector.SPEN_APP_ID);
                    contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, context.getPackageName() + ContentUtils.HASH_SYMBOL + SpenNoteDoc.sSdkVersionCode);
                    contentValues.put("extra", extra);
                    contentValues.put("value", Integer.valueOf(value));
                    Intent intent = new Intent();
                    intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
                    intent.putExtra("data", contentValues);
                    intent.setPackage("com.samsung.android.providers.context");
                    context.sendBroadcast(intent);
                }
            } catch (PlatformException | Error | Exception unused) {
            }
        }

        private Companion() {
        }
    }

    private SpenNoteDoc() {
    }

    private final native SpenPageDoc NoteDoc_appendPage(int handle, int width, int height);

    private final native SpenPageDoc NoteDoc_appendPage(int handle, int color, String path, int mode);

    private final native boolean NoteDoc_attachFile(int handle, String key, String filepath);

    private final native boolean NoteDoc_attachToFile(int handle, String filePath, boolean compatibleMode);

    private final native boolean NoteDoc_backupObjectList(int handle, ArrayList<SpenObjectBase> objectList, String filePath);

    private final native boolean NoteDoc_backupObjectList(int handle, ArrayList<SpenObjectBase> objectList, String filePath, float horizontalDelta, float verticalDelta);

    private final native boolean NoteDoc_close(int handle, boolean clearCache);

    private final native boolean NoteDoc_close2(int handle, boolean clearCache, boolean updateCacheState);

    private final native SpenPageDoc NoteDoc_copyPage(int handle, SpenPageDoc source, int pageIndex);

    private final native boolean NoteDoc_detachFile(int handle, String key);

    private final native boolean NoteDoc_discard(int handle);

    private final native void NoteDoc_finalize(int handle);

    private final native int NoteDoc_getAppMajorVersion(int handle);

    private final native int NoteDoc_getAppMinorVersion(int handle);

    private final native String NoteDoc_getAppName(int handle);

    private final native String NoteDoc_getAppPatchName(int handle);

    private final native String NoteDoc_getAttachedFile(int handle, String key);

    private final native int NoteDoc_getAttachedFileCount(int handle);

    private final native AuthorInfo NoteDoc_getAuthorInfo(int handle);

    private final native String NoteDoc_getCoverImagePath(int handle);

    private final native byte[] NoteDoc_getExtraDataByteArray(int handle, String key);

    private final native int NoteDoc_getExtraDataInt(int handle, String key);

    private final native String NoteDoc_getExtraDataString(int handle, String key);

    private final native String[] NoteDoc_getExtraDataStringArray(int handle, String key);

    private final native double NoteDoc_getGeoTagLatitude(int handle);

    private final native double NoteDoc_getGeoTagLongitude(int handle);

    private final native int NoteDoc_getHeight(int handle);

    private final native String NoteDoc_getId(int handle);

    private final native String NoteDoc_getInternalDirectory(int handle);

    private final native int NoteDoc_getLastEditedPageIndex(int handle);

    private final native int NoteDoc_getOrientation(int handle);

    private final native int NoteDoc_getOrientation2(int handle, ByteArrayInputStream stream);

    private final native int NoteDoc_getOrientation3(int handle, FileDescriptor stream);

    private final native SpenPageDoc NoteDoc_getPage(int handle, int pageIndex);

    private final native int NoteDoc_getPageCount(int handle);

    private final native String NoteDoc_getPageIdByIndex(int handle, int pageIndex);

    private final native int NoteDoc_getPageIndexById(int handle, String pageId);

    private final native int NoteDoc_getRotation(int handle);

    private final native int NoteDoc_getWidth(int handle);

    private final native boolean NoteDoc_hasAttachedFile(int handle, String key);

    private final native boolean NoteDoc_hasExtraDataByteArray(int handle, String key);

    private final native boolean NoteDoc_hasExtraDataInt(int handle, String key);

    private final native boolean NoteDoc_hasExtraDataString(int handle, String key);

    private final native boolean NoteDoc_hasExtraDataStringArray(int handle, String key);

    private final native boolean NoteDoc_hasTaggedPage(int handle);

    private final native int NoteDoc_init(int handle, String cacheDirPath, int orientation, int width, int height);

    private final native int NoteDoc_init(int handle, String cacheDirPath, ByteArrayInputStream stream, int width, int mode);

    private final native int NoteDoc_init(int handle, String cacheDirPath, ByteArrayInputStream stream, String password, int width, int mode);

    private final native int NoteDoc_init(int handle, String cacheDirPath, FileDescriptor fd, int width, int mode);

    private final native int NoteDoc_init(int handle, String cacheDirPath, FileDescriptor fd, String password, int width, int mode);

    private final native int NoteDoc_init(int handle, String cacheDirPath, String filepath, String password, double rotation, int mode);

    private final native int NoteDoc_init(int handle, String cacheDirPath, String filepath, String password, int width, int mode, boolean discardUnsavedData);

    private final native int NoteDoc_initSaveHistory(int handle, String cacheDirPath, int orientation, int width, int height, boolean isSaveHistory);

    private final native SpenPageDoc NoteDoc_insertPage(int handle, int pageIndex, int width, int height);

    private final native SpenPageDoc NoteDoc_insertPage(int handle, int pageIndex, int color, String path, int mode);

    private final native boolean NoteDoc_isAllPageTextOnly(int handle);

    private final native boolean NoteDoc_isChanged(int handle);

    private final native boolean NoteDoc_movePageIndex(int handle, SpenPageDoc page, int step);

    private final native boolean NoteDoc_removeExtraDataByteArray(int handle, String key);

    private final native boolean NoteDoc_removeExtraDataInt(int handle, String key);

    private final native boolean NoteDoc_removeExtraDataString(int handle, String key);

    private final native boolean NoteDoc_removeExtraDataStringArray(int handle, String key);

    private final native boolean NoteDoc_removePage(int handle, int pageIndex);

    private final native ArrayList<SpenObjectBase> NoteDoc_restoreObjectList(int handle, String filePath);

    private final native boolean NoteDoc_save(int handle, ByteArrayOutputStream stream, boolean compatibleMode);

    private final native boolean NoteDoc_save(int handle, FileDescriptor fd, boolean compatibleMode);

    private final native boolean NoteDoc_save(int handle, String filePath, boolean compatibleMode);

    private final native boolean NoteDoc_setAppName(int handle, String name);

    private final native boolean NoteDoc_setAppVersion(int handle, int majorVersion, int minorVersion, String patchName);

    private final native boolean NoteDoc_setAuthorInfo(int handle, AuthorInfo info);

    private final native boolean NoteDoc_setCoverImage(int handle, String uri);

    private final native boolean NoteDoc_setExtraDataByteArray(int handle, String key, byte[] value, int valueCount);

    private final native boolean NoteDoc_setExtraDataInt(int handle, String key, int value);

    private final native boolean NoteDoc_setExtraDataString(int handle, String key, String value);

    private final native boolean NoteDoc_setExtraDataStringArray(int handle, String key, String[] value, int valueCount);

    private final native boolean NoteDoc_setGeoTag(int handle, double latitude, double longitude);

    private final native boolean NoteDoc_transferPage(int handle, SpenNoteDoc destNote, int pageIndex);

    public static /* synthetic */ void close$default(SpenNoteDoc spenNoteDoc, boolean z, boolean z2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z2 = true;
        }
        spenNoteDoc.close(z, z2);
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed");
    }

    @Nullable
    public final SpenPageDoc appendPage() {
        SpenPageDoc spenPageDocNoteDoc_appendPage = NoteDoc_appendPage(this.mHandle, -1, null, 0);
        if (spenPageDocNoteDoc_appendPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_appendPage;
    }

    public final void attachFile(@Nullable String key, @Nullable String filePath) {
        if (NoteDoc_attachFile(this.mHandle, key, filePath)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #attachToFile(String, boolean)}.")
    public final void attachToFile(@NotNull String filePath) throws IOException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (NoteDoc_attachToFile(this.mHandle, filePath, true)) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    public final void backupObjectList(@NotNull ArrayList<SpenObjectBase> objectList, @NotNull String filePath) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (NoteDoc_backupObjectList(this.mHandle, objectList, filePath)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @JvmOverloads
    public final void close(boolean z) {
        close$default(this, z, false, 2, null);
    }

    @Nullable
    public final SpenPageDoc copyPage(@NotNull SpenPageDoc sourcePage, int pageIndex) {
        Intrinsics.checkNotNullParameter(sourcePage, "sourcePage");
        SpenPageDoc spenPageDocNoteDoc_copyPage = NoteDoc_copyPage(this.mHandle, sourcePage, pageIndex);
        if (spenPageDocNoteDoc_copyPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_copyPage;
    }

    public final void detachFile(@Nullable String key) {
        if (NoteDoc_detachFile(this.mHandle, key)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void discard() throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!NoteDoc_discard(i)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1;
        this.mContext = null;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof SpenNoteDoc) && this.mHandle == ((SpenNoteDoc) other).mHandle;
    }

    public final void finalize() {
        Log.i("Model_SpenNoteDoc", "finalize() : " + getMHandle());
        NoteDoc_finalize(this.mHandle);
        this.mHandle = -1;
    }

    public final int getAppMajorVersion() {
        return NoteDoc_getAppMajorVersion(this.mHandle);
    }

    public final int getAppMinorVersion() {
        return NoteDoc_getAppMinorVersion(this.mHandle);
    }

    @Nullable
    public final String getAppName() {
        return NoteDoc_getAppName(this.mHandle);
    }

    @NotNull
    public final String getAppPatchName() {
        return NoteDoc_getAppPatchName(this.mHandle);
    }

    @Nullable
    public final String getAttachedFile(@Nullable String key) {
        String strNoteDoc_getAttachedFile = NoteDoc_getAttachedFile(this.mHandle, key);
        if (strNoteDoc_getAttachedFile == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return strNoteDoc_getAttachedFile;
    }

    public final int getAttachedFileCount() {
        return NoteDoc_getAttachedFileCount(this.mHandle);
    }

    @Nullable
    public final AuthorInfo getAuthorInfo() {
        return NoteDoc_getAuthorInfo(this.mHandle);
    }

    @Nullable
    public final String getCoverImagePath() {
        return NoteDoc_getCoverImagePath(this.mHandle);
    }

    @NotNull
    public final byte[] getExtraDataByteArray(@Nullable String key) {
        return NoteDoc_getExtraDataByteArray(this.mHandle, key);
    }

    public final int getExtraDataInt(@Nullable String key) {
        return NoteDoc_getExtraDataInt(this.mHandle, key);
    }

    @NotNull
    public final String getExtraDataString(@Nullable String key) {
        return NoteDoc_getExtraDataString(this.mHandle, key);
    }

    @NotNull
    public final String[] getExtraDataStringArray(@Nullable String key) {
        return NoteDoc_getExtraDataStringArray(this.mHandle, key);
    }

    public final double getGeoTagLatitude() {
        return NoteDoc_getGeoTagLatitude(this.mHandle);
    }

    public final double getGeoTagLongitude() {
        return NoteDoc_getGeoTagLongitude(this.mHandle);
    }

    public final int getHeight() {
        return NoteDoc_getHeight(this.mHandle);
    }

    @NotNull
    public final String getId() {
        return NoteDoc_getId(this.mHandle);
    }

    @NotNull
    public final String getInternalDirectory() {
        return NoteDoc_getInternalDirectory(this.mHandle);
    }

    public final int getLastEditedPageIndex() {
        return NoteDoc_getLastEditedPageIndex(this.mHandle);
    }

    public final int getOrientation() {
        int iNoteDoc_getOrientation = NoteDoc_getOrientation(this.mHandle);
        if (iNoteDoc_getOrientation == -1) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return iNoteDoc_getOrientation;
    }

    @NotNull
    public final SpenPageDoc getPage(int pageIndex) {
        SpenPageDoc spenPageDocNoteDoc_getPage = NoteDoc_getPage(this.mHandle, pageIndex);
        if (spenPageDocNoteDoc_getPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenPageDocNoteDoc_getPage);
        return spenPageDocNoteDoc_getPage;
    }

    public final int getPageCount() {
        return NoteDoc_getPageCount(this.mHandle);
    }

    @Nullable
    public final String getPageIdByIndex(int pageIndex) {
        String strNoteDoc_getPageIdByIndex = NoteDoc_getPageIdByIndex(this.mHandle, pageIndex);
        if (strNoteDoc_getPageIdByIndex == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return strNoteDoc_getPageIdByIndex;
    }

    public final int getPageIndexById(@Nullable String pageId) {
        int iNoteDoc_getPageIndexById = NoteDoc_getPageIndexById(this.mHandle, pageId);
        if (iNoteDoc_getPageIndexById == -1) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return iNoteDoc_getPageIndexById;
    }

    public final int getRotation() {
        return NoteDoc_getRotation(this.mHandle);
    }

    public final int getWidth() {
        return NoteDoc_getWidth(this.mHandle);
    }

    public final boolean hasAttachedFile(@Nullable String key) {
        return NoteDoc_hasAttachedFile(this.mHandle, key);
    }

    public final boolean hasExtraDataByteArray(@Nullable String key) {
        return NoteDoc_hasExtraDataByteArray(this.mHandle, key);
    }

    public final boolean hasExtraDataInt(@Nullable String key) {
        return NoteDoc_hasExtraDataInt(this.mHandle, key);
    }

    public final boolean hasExtraDataString(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return NoteDoc_hasExtraDataString(this.mHandle, key);
    }

    public final boolean hasExtraDataStringArray(@Nullable String key) {
        return NoteDoc_hasExtraDataStringArray(this.mHandle, key);
    }

    public final boolean hasTaggedPage() {
        return NoteDoc_hasTaggedPage(this.mHandle);
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getMHandle() {
        return this.mHandle;
    }

    @Nullable
    public final SpenPageDoc insertPage(int pageIndex) {
        SpenPageDoc spenPageDocNoteDoc_insertPage = NoteDoc_insertPage(this.mHandle, pageIndex, -1, null, 0);
        if (spenPageDocNoteDoc_insertPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_insertPage;
    }

    public final boolean isAllPageTextOnly() {
        return NoteDoc_isAllPageTextOnly(this.mHandle);
    }

    public final boolean isChanged() {
        return NoteDoc_isChanged(this.mHandle);
    }

    public final void movePageIndex(@Nullable SpenPageDoc page, int step) {
        if (NoteDoc_movePageIndex(this.mHandle, page, step)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataByteArray(@Nullable String key) {
        if (NoteDoc_removeExtraDataByteArray(this.mHandle, key)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataInt(@Nullable String key) {
        if (NoteDoc_removeExtraDataInt(this.mHandle, key)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataString(@Nullable String key) {
        if (NoteDoc_removeExtraDataString(this.mHandle, key)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataStringArray(@Nullable String key) {
        if (NoteDoc_removeExtraDataStringArray(this.mHandle, key)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void removePage(int pageIndex) {
        if (NoteDoc_removePage(this.mHandle, pageIndex)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @NotNull
    public final ArrayList<SpenObjectBase> restoreObjectList(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return NoteDoc_restoreObjectList(this.mHandle, filePath);
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #save(OutputStream, boolean)}.")
    public final void save(@Nullable OutputStream stream) throws IOException {
        boolean zNoteDoc_save;
        if (stream instanceof ByteArrayOutputStream) {
            zNoteDoc_save = NoteDoc_save(this.mHandle, (ByteArrayOutputStream) stream, true);
        } else {
            if (!(stream instanceof FileOutputStream)) {
                SpenError.ThrowUncheckedException(7, "The parameter 'stream' is unsupported type. This method supports only ByteArrayOutputStream and FileOutputStream");
                return;
            }
            int i = this.mHandle;
            FileDescriptor fd = ((FileOutputStream) stream).getFD();
            Intrinsics.checkNotNullExpressionValue(fd, "getFD(...)");
            zNoteDoc_save = NoteDoc_save(i, fd, true);
        }
        if (zNoteDoc_save) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    public final void setAppName(@Nullable String str) {
        if (NoteDoc_setAppName(this.mHandle, str)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setAppVersion(int majorVersion, int minorVersion, @Nullable String patchName) {
        if (NoteDoc_setAppVersion(this.mHandle, majorVersion, minorVersion, patchName)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setAuthorInfo(@Nullable AuthorInfo authorInfo) {
        if (NoteDoc_setAuthorInfo(this.mHandle, authorInfo)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setCoverImage(@Nullable String filePath) {
        if (NoteDoc_setCoverImage(this.mHandle, filePath)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setCoverImagePath(@Nullable String str) {
        if (NoteDoc_setCoverImage(this.mHandle, str)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setExtraDataByteArray(@Nullable String key, @Nullable byte[] value) {
        if (value != null) {
            if (NoteDoc_setExtraDataByteArray(this.mHandle, key, value, value.length)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        } else {
            if (NoteDoc_setExtraDataByteArray(this.mHandle, key, value, 0)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public final void setExtraDataInt(@Nullable String key, int value) {
        if (NoteDoc_setExtraDataInt(this.mHandle, key, value)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setExtraDataString(@Nullable String key, @Nullable String value) {
        if (NoteDoc_setExtraDataString(this.mHandle, key, value)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void setExtraDataStringArray(@Nullable String key, @Nullable String[] value) {
        if (value != null) {
            if (NoteDoc_setExtraDataStringArray(this.mHandle, key, value, value.length)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        } else {
            if (NoteDoc_setExtraDataStringArray(this.mHandle, key, value, 0)) {
                return;
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public final void setGeoTag(double latitude, double longitude) {
        if (NoteDoc_setGeoTag(this.mHandle, latitude, longitude)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public final void transferPage(@NotNull SpenNoteDoc destNote, int pageIndex) {
        Intrinsics.checkNotNullParameter(destNote, "destNote");
        if (NoteDoc_transferPage(this.mHandle, destNote, pageIndex)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    public SpenNoteDoc(@Nullable Context context, int i, int i2) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        this.mContext = context;
        sWeakContext = new WeakReference<>(context);
        if (sSdkVersionCode == 0) {
            sSdkVersionCode = new Spen().getVersionCode();
        }
        AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
        INSTANCE.insertLog(null, "SpenNoteDoc()", 1);
        if ((i > i2 ? NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), 1, i, i2) : NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), 0, i, i2)) == 0) {
            int error = SpenError.getError();
            if (error != 11) {
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (AbstractC2322a.m1607A(absolutePath)) {
                String strM756B = AbstractC0541b.m756B(absolutePath, "/SPenSDK30");
                if (!AbstractC2322a.m1607A(strM756B)) {
                    AbstractC4539a.m3207q("[", strM756B, "] is not exist", "Model_SpenNoteDoc");
                }
            } else {
                AbstractC4539a.m3207q("[", absolutePath, "] is not exist", "Model_SpenNoteDoc");
            }
            throw new IOException();
        }
    }

    public final void close() throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!NoteDoc_close(i, false)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1;
        this.mContext = null;
    }

    @Nullable
    public final SpenPageDoc appendPage(int backgroundColor, @Nullable String backgroundImagePath, int backgourndImageMode) {
        SpenPageDoc spenPageDocNoteDoc_appendPage = NoteDoc_appendPage(this.mHandle, backgroundColor, backgroundImagePath, backgourndImageMode);
        if (spenPageDocNoteDoc_appendPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_appendPage;
    }

    public final void backupObjectList(@Nullable ArrayList<SpenObjectBase> objectList, @Nullable String filePath, float horizontalDelta, float verticalDelta) {
        if (NoteDoc_backupObjectList(this.mHandle, objectList, filePath, horizontalDelta, verticalDelta)) {
            return;
        }
        SpenError.ThrowUncheckedException(SpenError.getError());
    }

    @Nullable
    public final SpenPageDoc insertPage(int pageIndex, int backgroundColor, @Nullable String backgroundImagePath, int backgourndImageMode) {
        SpenPageDoc spenPageDocNoteDoc_insertPage = NoteDoc_insertPage(this.mHandle, pageIndex, backgroundColor, backgroundImagePath, backgourndImageMode);
        if (spenPageDocNoteDoc_insertPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_insertPage;
    }

    @Nullable
    public final SpenPageDoc appendPage(int width, int height) {
        SpenPageDoc spenPageDocNoteDoc_appendPage = NoteDoc_appendPage(this.mHandle, width, height);
        if (spenPageDocNoteDoc_appendPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_appendPage;
    }

    public final void attachToFile(@NotNull String filePath, boolean compatibleMode) throws IOException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (NoteDoc_attachToFile(this.mHandle, filePath, compatibleMode)) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    @Nullable
    public final SpenPageDoc insertPage(int pageIndex, int width, int height) {
        SpenPageDoc spenPageDocNoteDoc_insertPage = NoteDoc_insertPage(this.mHandle, pageIndex, width, height);
        if (spenPageDocNoteDoc_insertPage == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return spenPageDocNoteDoc_insertPage;
    }

    @JvmOverloads
    public final void close(boolean removeCache, boolean updateCacheState) throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!NoteDoc_close2(i, removeCache, updateCacheState)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error != 19) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            } else {
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
        this.mHandle = -1;
        this.mContext = null;
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link #save(String, boolean)}.")
    public final void save(@Nullable String filepath) throws IOException {
        if (NoteDoc_save(this.mHandle, filepath, true)) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    public final void save(@Nullable OutputStream stream, boolean compatibleMode) throws IOException {
        boolean zNoteDoc_save;
        if (stream instanceof ByteArrayOutputStream) {
            zNoteDoc_save = NoteDoc_save(this.mHandle, (ByteArrayOutputStream) stream, compatibleMode);
        } else if (stream instanceof FileOutputStream) {
            int i = this.mHandle;
            FileDescriptor fd = ((FileOutputStream) stream).getFD();
            Intrinsics.checkNotNullExpressionValue(fd, "getFD(...)");
            zNoteDoc_save = NoteDoc_save(i, fd, compatibleMode);
        } else {
            SpenError.ThrowUncheckedException(7, "The parameter 'stream' is unsupported type. This method supports only ByteArrayOutputStream and FileOutputStream");
            return;
        }
        if (zNoteDoc_save) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    public final void save(@NotNull String filepath, boolean compatibleMode) {
        Intrinsics.checkNotNullParameter(filepath, "filepath");
        if (NoteDoc_save(this.mHandle, filepath, compatibleMode)) {
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
        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
    }

    public SpenNoteDoc(@Nullable Context context, int i, int i2, int i4) throws IOException {
        if (context != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 2);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), i, i2, i4) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    private SpenNoteDoc(Context context, InputStream inputStream, int i, int i2) throws IOException, SpenUnsupportedTypeException {
        int iNoteDoc_init;
        if (context != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 3);
            if (inputStream instanceof ByteArrayInputStream) {
                iNoteDoc_init = NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), (ByteArrayInputStream) inputStream, i, i2);
            } else if (inputStream instanceof FileInputStream) {
                iNoteDoc_init = NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), ((FileInputStream) inputStream).getFD(), i, i2);
            } else {
                SpenError.ThrowUncheckedException(7, "The parameter 'stream' is unsupported type. This method supports only ByteArrayInputStream and FileInputStream");
                return;
            }
            if (iNoteDoc_init == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, int i, int i2) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (str != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 4);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, null, i, i2, false) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, double d, int i) throws IOException, SpenUnsupportedTypeException {
        if (context != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 5);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, (String) null, d, i) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, int i, int i2) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (str != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 6);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, str2, i, i2, false) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, double d, int i) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (str != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 7);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, str2, d, i) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, int i, int i2, boolean z) throws IOException, SpenUnsupportedTypeException {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (str != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 8);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, null, i, i2, z) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public SpenNoteDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, int i, int i2, boolean z) throws IOException, SpenUnsupportedTypeException {
        if (context != null) {
            this.mContext = context;
            sWeakContext = new WeakReference<>(context);
            if (sSdkVersionCode == 0) {
                sSdkVersionCode = new Spen().getVersionCode();
            }
            AbstractC2322a.m1631u(getMHandle(), "init() : ", "Model_SpenNoteDoc");
            INSTANCE.insertLog(null, "SpenNoteDoc()", 9);
            if (NoteDoc_init(this.mHandle, context.getFilesDir().getAbsolutePath(), str, str2, i, i2, z) == 0) {
                int error = SpenError.getError();
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 13) {
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                }
                if (error == 17) {
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                }
                if (error != 19) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
