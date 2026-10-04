package com.samsung.android.sdk.composer.document.sdoc;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedImageLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenExceedTextLimitException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocCancelException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.composer.document.sdoc.util.EndTagUtil;
import com.samsung.android.sdk.composer.document.sdoc.util.LockUtil;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.util.LogUtil;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u007f\b\u0016\u0018\u0000 ®\u00022\u00020\u0001:\u0012¦\u0002§\u0002¨\u0002©\u0002ª\u0002«\u0002¬\u0002\u00ad\u0002®\u0002B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B9\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fB?\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0002\u0010\u000fBA\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0002\u0010\u0012B3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0002\u0010\u0013JM\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0004J\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u000eJ\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u0019J\u0006\u00104\u001a\u00020\u000eJ\u001a\u0010=\u001a\u00020\u00192\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?J\u0006\u0010G\u001a\u00020\u0019J\u0006\u0010H\u001a\u00020\u0019J \u0010W\u001a\u00020\u00192\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020\b0Yj\b\u0012\u0004\u0012\u00020\b`ZH\u0002J\b\u0010[\u001a\u00020\u0019H\u0002J\u0006\u0010c\u001a\u00020\u0019J\u0006\u0010d\u001a\u00020\u0019J\u0010\u0010e\u001a\u00020\u000e2\b\u0010f\u001a\u0004\u0018\u00010gJ\u001b\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gH\u0082 J\u0010\u0010j\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010gJ\u0018\u0010k\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010l\u001a\u00020\u0011J\u0010\u0010m\u001a\u00020\u00192\b\u0010f\u001a\u0004\u0018\u00010gJ\u0006\u0010n\u001a\u00020\u0019J\u000e\u0010q\u001a\u00020g2\u0006\u0010l\u001a\u00020\u0011J\u0016\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020\u00112\u0006\u0010+\u001a\u00020wJ\u000e\u0010x\u001a\u00020\u00192\u0006\u0010v\u001a\u00020\u0011J\u000e\u0010y\u001a\u00020\u00192\u0006\u0010+\u001a\u00020zJ\u0010\u0010{\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gJ\u0006\u0010~\u001a\u00020\u000eJ\u0012\u0010\u0089\u0001\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0089\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\u0012\u0010\u008c\u0001\u001a\u00020\u00192\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u008c\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\u0007\u0010\u008d\u0001\u001a\u00020\u0019J\u0012\u0010\u008e\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\u0007\u0010\u0091\u0001\u001a\u00020\u0019J6\u0010\u0092\u0001\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u000eH\u0007¢\u0006\u0003\u0010\u0094\u0001J9\u0010\u0092\u0001\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0006\u0010U\u001a\u00020R2\u0006\u0010Q\u001a\u00020R¢\u0006\u0003\u0010\u0095\u0001JB\u0010\u0092\u0001\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020R2\u0006\u0010Q\u001a\u00020R¢\u0006\u0003\u0010\u0096\u0001JB\u0010\u0097\u0001\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020R2\u0006\u0010Q\u001a\u00020R¢\u0006\u0003\u0010\u0096\u0001J\u0007\u0010\u0098\u0001\u001a\u00020\u0019J.\u0010\u0099\u0001\u001a\u00020\u00192\u001a\u0010r\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bJ&\u0010\u009a\u0001\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bJ\u001b\u0010\u009b\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u009d\u0001\u001a\u00020\u0011J\u001d\u0010\u009e\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u009f\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\n\u0010\u009d\u0001\u001a\u0005\u0018\u00010 \u0001J\u0012\u0010¡\u0001\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¢\u0001\u001a\u00020\b2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0013\u0010£\u0001\u001a\u00030 \u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¤\u0001\u001a\u00020\u000e2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¥\u0001\u001a\u00020\u000e2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¦\u0001\u001a\u00020\u000e2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010§\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¨\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010©\u0001\u001a\u00020\u00192\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bJ1\u0010®\u0001\u001a\u00020\u00192\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\b2\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u0001`ZJ$\u0010\u00ad\u0001\u001a\u0014\u0012\u0005\u0012\u00030«\u00010Yj\t\u0012\u0005\u0012\u00030«\u0001`Z2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010´\u0001\u001a\u00020\b2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bJ\u0012\u0010¶\u0001\u001a\u00020\u000e2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bJ\u0007\u0010»\u0001\u001a\u00020\u000eJ\u0007\u0010¼\u0001\u001a\u00020\u000eJ\u0007\u0010½\u0001\u001a\u00020\u0019J\u0007\u0010¾\u0001\u001a\u00020\u0011J\u0012\u0010¿\u0001\u001a\u00020\u00192\u0007\u0010À\u0001\u001a\u00020\u0011H\u0002J+\u0010Á\u0001\u001a\u00020\u00112\u0007\u0010Â\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082 J\u0012\u0010Ã\u0001\u001a\u00020\u00192\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010Ä\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000eH\u0082 J\u0012\u0010Å\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010Æ\u0001\u001a\u0002062\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010Ç\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000eH\u0082 J\u0012\u0010È\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010É\u0001\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010Ê\u0001\u001a\u00020R2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010Ë\u0001\u001a\u00020R2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010Ì\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u0011H\u0082 J\u0012\u0010Í\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010Î\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001c\u0010Ï\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0082 J%\u0010Ð\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0093\u0001\u001a\u00020\u000eH\u0082 J,\u0010Ñ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010U\u001a\u00020R2\u0006\u0010Q\u001a\u00020RH\u0082 J5\u0010Ò\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0093\u0001\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020R2\u0006\u0010Q\u001a\u00020RH\u0082 J\u001c\u0010Ó\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gH\u0082 J$\u0010Ô\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010l\u001a\u00020\u0011H\u0082 J\u001c\u0010Õ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gH\u0082 J\u0012\u0010Ö\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010×\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001c\u0010Ø\u0001\u001a\u0004\u0018\u00010g2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010l\u001a\u00020\u0011H\u0082 J&\u0010Ù\u0001\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\"\u0010Ú\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010v\u001a\u00020\u00112\u0006\u0010+\u001a\u00020wH\u0082 J\u001a\u0010Û\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010v\u001a\u00020\u0011H\u0082 J\u0012\u0010Ü\u0001\u001a\u00020?2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010Ý\u0001\u001a\u00020?2\u0006\u0010i\u001a\u00020\u0011H\u0082 J&\u0010Þ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?H\u0082 J\u0012\u0010ß\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001c\u0010à\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\b\u0010I\u001a\u0004\u0018\u00010?H\u0082 J\u0012\u0010á\u0001\u001a\u00020?2\u0006\u0010i\u001a\u00020\u0011H\u0082 J9\u0010â\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u001a\u0010r\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bH\u0082 J1\u0010ã\u0001\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001a\u0010ä\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010+\u001a\u00020zH\u0082 J1\u0010å\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u0001`ZH\u0082 J$\u0010æ\u0001\u001a\u0014\u0012\u0005\u0012\u00030«\u00010Yj\t\u0012\u0005\u0012\u00030«\u0001`Z2\u0006\u0010i\u001a\u00020\u0011H\u0082 J1\u0010ç\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030°\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u0001`ZH\u0082 J$\u0010è\u0001\u001a\u0014\u0012\u0005\u0012\u00030°\u00010Yj\t\u0012\u0005\u0012\u00030°\u0001`Z2\u0006\u0010i\u001a\u00020\u0011H\u0082 J&\u0010é\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u009d\u0001\u001a\u00020\u0011H\u0082 J(\u0010ê\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\bH\u0082 J2\u0010ë\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\b2\n\u0010ì\u0001\u001a\u0005\u0018\u00010 \u00012\u0007\u0010í\u0001\u001a\u00020\u0011H\u0082 J\u001d\u0010î\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ï\u0001\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001e\u0010ð\u0001\u001a\u00030 \u00012\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ñ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ò\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ó\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ô\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010õ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010ö\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010÷\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001d\u0010ø\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001b\u0010ù\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0082 J\u001d\u0010ú\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001b\u0010û\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0082 J\u0012\u0010ü\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001d\u0010ý\u0001\u001a\u0004\u0018\u00010\b2\u0006\u0010i\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0082 J\u001c\u0010þ\u0001\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u00112\b\u0010f\u001a\u0004\u0018\u00010gH\u0082 J\u0012\u0010ÿ\u0001\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010\u0080\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0081\u0002\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010\u0082\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0083\u0002\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001d\u0010\u0084\u0002\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u00112\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u001d\u0010\u0085\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010µ\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010\u0086\u0002\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0087\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0088\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0089\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u008a\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u008b\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u008c\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u008d\u0002\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u008e\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010\u008f\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000eH\u0082 J<\u0010\u0090\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\b2\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u0001`ZH\u0082 J/\u0010\u0091\u0002\u001a\u0014\u0012\u0005\u0012\u00030«\u00010Yj\t\u0012\u0005\u0012\u00030«\u0001`Z2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010\u0092\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0093\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0094\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0095\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0096\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0097\u0002\u001a\u00020R2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0098\u0002\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u0099\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u009a\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001d\u0010\u009b\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\bH\u0082 J\u0012\u0010\u009d\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u009e\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010\u009f\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010 \u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010¡\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010¢\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010£\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u0012\u0010¤\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u0011H\u0082 J\u001a\u0010¥\u0002\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,H\u0082 R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u00100\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b0\u0010%R\u0011\u00101\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b1\u0010%R\u0011\u00102\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b2\u0010%R\u0011\u00103\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b3\u0010%R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R$\u0010:\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010%\"\u0004\b;\u0010<R\u0011\u0010A\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0011\u0010F\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bF\u0010%R(\u0010J\u001a\u0004\u0018\u00010?2\b\u0010I\u001a\u0004\u0018\u00010?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010C\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\bV\u0010TR$\u0010]\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bb\u0010%R\u0011\u0010o\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bp\u0010_R%\u0010r\u001a\u0016\u0012\u0004\u0012\u00020g\u0018\u00010Yj\n\u0012\u0004\u0012\u00020g\u0018\u0001`Z8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0011\u0010|\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b|\u0010%R\u0011\u0010}\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b}\u0010%R'\u0010\u0080\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010_\"\u0005\b\u0082\u0001\u0010aR\u0013\u0010\u0083\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010_R'\u0010\u0085\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010_\"\u0005\b\u0087\u0001\u0010aR\u0012\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010_R\u0013\u0010\u008f\u0001\u001a\u00020R8F¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010TRU\u0010¬\u0001\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u0001`Z2\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030«\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u0001`Z8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u00ad\u0001\u0010t\"\u0006\b®\u0001\u0010¯\u0001RU\u0010±\u0001\u001a\u0018\u0012\u0005\u0012\u00030°\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u0001`Z2\u001d\u0010ª\u0001\u001a\u0018\u0012\u0005\u0012\u00030°\u0001\u0018\u00010Yj\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u0001`Z8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b²\u0001\u0010t\"\u0006\b³\u0001\u0010¯\u0001R\u0013\u0010·\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010_R\u0013\u0010¹\u0001\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010%R\u0013\u0010º\u0001\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010%¨\u0006¯\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "", "<init>", "()V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fileFullPath", "", "confirmResult", "passwordList", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "restoreUnsavedData", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Z)V", "mode", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)V", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)V", "mHandle", "SDOC_TEMP_PATH", "mTempFilePath", "mTempDirPath", "init", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;ZI)V", "preConstruct", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "decryptSdoc", "password", "postConstruct", "checkTempDirectory", "finalize", "close", "removeCache", "isClosed", "()Z", ClientCookie.DISCARD_ATTR, "reserveDiscard", "enable", "reload", "setSDocHistoryListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$SDocHistoryListener;", "undoInSdoc", "redoInSdoc", "clearHistory", "isUndoable", "isRedoable", "isUndoing", "isRedoing", "commitHistory", "title", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "flag", "isFavorite", "setFavorite", "(Z)V", "selectRegion", "begin", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$CursorInfo;", "end", "selectedRegionBegin", "getSelectedRegionBegin", "()Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$CursorInfo;", "selectedRegionEnd", "getSelectedRegionEnd", "isSelected", "clearCursorPosition", "clearSelection", "cursor", "cursorPosition", "getCursorPosition", "setCursorPosition", "(Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$CursorInfo;)V", "cachePath", "getCachePath", "()Ljava/lang/String;", "modifiedTime", "", "getModifiedTime", "()J", GroupContract.Group.CREATED_TIME, "getCreatedTime", "addExtraZipFileList", "filePathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearExtraZipFileList", "type", "documentType", "getDocumentType", "()I", "setDocumentType", "(I)V", "isLocked", "lock", "unlock", "containContent", "content", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "SDoc_containContent", "handle", "appendContent", "insertContent", "index", "removeContent", "removeAllContent", "contentCount", "getContentCount", "getContent", "contentList", "getContentList", "()Ljava/util/ArrayList;", "registContentListener", "cookie", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ContentEventListener;", "unregistContentListener", "setContentTextChangedListener", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ContentTextChangedListener;", "getContentIndex", "isContentChanged", "isContentChangedByApp", "clearChangedFlag", "count", "thumbnailMaxCount", "getThumbnailMaxCount", "setThumbnailMaxCount", "thumbnailCount", "getThumbnailCount", "textMaxCount", "getTextMaxCount", "setTextMaxCount", "getMode", "bindFile", "filePath", "id", "releaseFile", "clearAllBoundFiles", "getBoundFilePath", "boundFilesSize", "getBoundFilesSize", "quickSave", "save", "fixCache", "(Ljava/lang/String;[Ljava/lang/String;Z)V", "(Ljava/lang/String;[Ljava/lang/String;JJ)V", "(Ljava/lang/String;[Ljava/lang/String;ZJJ)V", "saveEx", "stopSave", "backupContentList", "restoreContentList", "setExtraDataInt", "key", "value", "setExtraDataString", "setExtraDataByteArray", "", "getExtraDataInt", "getExtraDataString", "getExtraDataByteArray", "hasExtraDataInt", "hasExtraDataString", "hasExtraDataByteArray", "removeExtraDataInt", "removeExtraDataString", "removeExtraDataByteArray", Constants.JTAG_DATA_LIST, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$SearchData;", "searchData", "getSearchData", "setSearchData", "(Ljava/util/ArrayList;)V", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ReminderData;", "reminderData", "getReminderData", "setReminderData", "getNewVoiceName", "name", "findVoiceName", "textLength", "getTextLength", "isTransaction", "isSaving", "beginTransaction", "endTransaction", "removeEmptyContentHandwriting", "getHandle", "throwUncheckedException", "errno", "SDoc_init", "cacheDirPath", "SDoc_finalize", "SDoc_close", "SDoc_discard", "SDoc_getTitle", "SDoc_setFavorite", "SDoc_isFavorite", "SDoc_getCachePath", "SDoc_getModifiedTime", "SDoc_getCreatedTime", "SDoc_setDocumentType", "SDoc_getDocumentType", "SDoc_quickSave", "SDoc_save1", "SDoc_save2", "SDoc_save3", "SDoc_save4", "SDoc_appendContent", "SDoc_insertContent", "SDoc_removeContent", "SDoc_removeAllContent", "SDoc_getContentCount", "SDoc_getContent", "SDoc_getContentList", "SDoc_registContentEventListener", "SDoc_unregistContentEventListener", "SDoc_getSelectedRegionBegin", "SDoc_getSelectedRegionEnd", "SDoc_SelectRegion", "SDoc_isSelected", "SDoc_setCursorPosition", "SDoc_getCursorPosition", "SDoc_backupContentList", "SDoc_restoreContentList", "SDoc_setContentTextChangedListener", "SDoc_setSearchData", "SDoc_getSearchData", "SDoc_setReminderData", "SDoc_getReminderData", "SDoc_setExtraDataInt", "SDoc_setExtraDataString", "SDoc_setExtraDataByteArray", "array", "arrayCount", "SDoc_getExtraDataInt", "SDoc_getExtraDataString", "SDoc_getExtraDataByteArray", "SDoc_hasExtraDataInt", "SDoc_hasExtraDataString", "SDoc_hasExtraDataByteArray", "SDoc_removeExtraDataInt", "SDoc_removeExtraDataString", "SDoc_removeExtraDataByteArray", "SDoc_isContentChanged", "SDoc_bindFile1", "SDoc_bindFile2", "SDoc_releaseFile1", "SDoc_releaseFile2", "SDoc_clearAllBoundFiles", "SDoc_getBoundFilePath", "SDoc_getContentIndex", "SDoc_clearChangedFlag", "SDoc_setThumbnailMaxCount", "SDoc_getThumbnailMaxCount", "SDoc_setTextMaxCount", "SDoc_getTextMaxCount", "SDoc_getNewVoiceName", "SDoc_findVoiceName", "SDoc_getThumbnailCount", "SDoc_lock", "SDoc_unlock", "SDoc_isLocked", "SDoc_isClosed", "SDoc_clearCursorInfo", "SDoc_clearSelection", "SDoc_getTextLength", "SDoc_stopSave", "SDoc_reserveDiscard", "SDoc_setSearchData2", "SDoc_getSearchData2", "SDoc_isContentChangedByApp", "SDoc_isTransaction", "SDoc_beginTransaction", "SDoc_endTransaction", "SDoc_isSaving", "SDoc_getBoundFilesSize", "SDoc_getMode", "SDoc_removeEmptyContentHandwriting", "SDoc_reload", "SDoc_setAppVersion", "version", "SDoc_clearHistory", "SDoc_undo", "SDoc_redo", "SDoc_isUndoable", "SDoc_isRedoable", "SDoc_isUndoing", "SDoc_isRedoing", "SDoc_commitHistory", "SDoc_setSDocHistoryListener", "CursorInfo", "SearchData", "TextSearchData", "ReminderData", "UpdateInfo", "ContentEventListener", "ContentTextChangedListener", "SDocHistoryListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSDoc.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSDoc.kt\ncom/samsung/android/sdk/composer/document/sdoc/SpenSDoc\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2591:1\n1#2:2592\n*E\n"})
public class SpenSDoc {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String EXTRA_VALUE_LOCK_CONFIRMED = "CONFIRMED_PASSWORD";
    private static final int LOCKED_SDOC = 1;
    private static final int LOCKED_SNB = 3;
    private static final int LOCKED_SPD = 2;
    private static final int LOCKED_TMEMO = 4;

    @NotNull
    private static final String TAG = "SpenSDoc";
    private static final int UNLOCKED_SDOC = 0;

    @NotNull
    private final String SDOC_TEMP_PATH;
    private int mHandle;

    @Nullable
    private String mTempDirPath;

    @Nullable
    private String mTempFilePath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "EXTRA_VALUE_LOCK_CONFIRMED", "UNLOCKED_SDOC", "", "LOCKED_SDOC", "LOCKED_SPD", "LOCKED_SNB", "LOCKED_TMEMO", "deleteFile", "", "dir", "Ljava/io/File;", "forceRenameTo", "curPath", "newPath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void deleteFile(File dir) throws IOException {
            File[] fileArrListFiles;
            if (dir.isDirectory() && (fileArrListFiles = dir.listFiles()) != null) {
                Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it.hasNext()) {
                    File file = (File) it.next();
                    Intrinsics.checkNotNull(file);
                    deleteFile(file);
                }
            }
            if (!dir.delete()) {
                throw new IOException(AbstractC0541b.m773o("Fail to delete [", LogUtil.logPath(dir.getPath()), "]"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void forceRenameTo(String curPath, String newPath) throws IOException {
            if (curPath == null || newPath == null) {
                Log.e(SpenSDoc.TAG, "forceRenameTo() - Invalid argument.");
                return;
            }
            if (Intrinsics.areEqual(curPath, newPath)) {
                AbstractC4539a.m3207q("forceRenameTo() - cur path is same as new path. [", LogUtil.logPath(curPath), "]", SpenSDoc.TAG);
                return;
            }
            File file = new File(curPath);
            if (!file.exists()) {
                throw new IOException(AbstractC0541b.m773o("forceRenameTo() - Fail to get current path File. [", LogUtil.logPath(curPath), "]"));
            }
            String str = newPath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
            File file2 = new File(str);
            File file3 = new File(newPath);
            if (file3.exists() && !file3.renameTo(file2)) {
                throw new IOException(AbstractC0541b.m775q("forceRenameTo() - Cannot rename origin dest file [", LogUtil.logPath(newPath), "] to [", LogUtil.logPath(str), "]"));
            }
            if (!file.renameTo(file3)) {
                throw new IOException(AbstractC0541b.m775q("forceRenameTo() - Cannot rename temp file [", LogUtil.logPath(curPath), "] to [", LogUtil.logPath(newPath), "]"));
            }
            if (file2.exists()) {
                deleteFile(file2);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014JZ\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\t2\u0006\u0010\f\u001a\u00020\u000bH&JZ\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\t2\u0006\u0010\f\u001a\u00020\u000bH&J:\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001e\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u0001`\t2\u0006\u0010\f\u001a\u00020\u000bH&J\"\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH&¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ContentEventListener;", "", "onContentAdded", "", "sdoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "contentList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "Lkotlin/collections/ArrayList;", "indexList", "", "type", "onContentRemoved", "onContentChanged", "updateInfoList", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$UpdateInfo;", "onThumbnailAddable", "addable", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ContentEventListener {
        public static final int CHANGED_CONTENT = 0;
        public static final int CHANGED_SPAN = 3;
        public static final int CHANGED_TASK = 1;
        public static final int CHANGED_TEXT = 2;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int TYPE_REDO = 2;
        public static final int TYPE_SET = 0;
        public static final int TYPE_UNDO = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ContentEventListener$Companion;", "", "<init>", "()V", "TYPE_SET", "", "TYPE_UNDO", "TYPE_REDO", "CHANGED_CONTENT", "CHANGED_TASK", "CHANGED_TEXT", "CHANGED_SPAN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CHANGED_CONTENT = 0;
            public static final int CHANGED_SPAN = 3;
            public static final int CHANGED_TASK = 1;
            public static final int CHANGED_TEXT = 2;
            public static final int TYPE_REDO = 2;
            public static final int TYPE_SET = 0;
            public static final int TYPE_UNDO = 1;

            private Companion() {
            }
        }

        void onContentAdded(@Nullable SpenSDoc sdoc, @Nullable ArrayList<SpenContentBase> contentList, @Nullable ArrayList<Integer> indexList, int type);

        void onContentChanged(@Nullable SpenSDoc sdoc, @Nullable ArrayList<UpdateInfo> updateInfoList, int type);

        void onContentRemoved(@Nullable SpenSDoc sdoc, @Nullable ArrayList<SpenContentBase> contentList, @Nullable ArrayList<Integer> indexList, int type);

        void onThumbnailAddable(@Nullable SpenSDoc sdoc, boolean addable, int type);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ContentTextChangedListener;", "", "onExceedSDocTextLimit", "", "sdoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "content", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "isExceed", "", "onExceedSDocTitleLimit", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ContentTextChangedListener {
        void onExceedSDocTextLimit(@Nullable SpenSDoc sdoc, @Nullable SpenContentText content, boolean isExceed);

        void onExceedSDocTitleLimit(@Nullable SpenSDoc sdoc, @Nullable SpenContentText content, boolean isExceed);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$CursorInfo;", "", "<init>", "()V", "_index", "", "_pos", "(II)V", "index", "pos", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CursorInfo {

        @JvmField
        public int index;

        @JvmField
        public int pos;

        public CursorInfo() {
        }

        public CursorInfo(int i, int i2) {
            this.index = i;
            this.pos = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$ReminderData;", "", "<init>", "()V", "reminderUUID", "", "time", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ReminderData {

        @JvmField
        @Nullable
        public String reminderUUID;

        @JvmField
        public long time;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$SDocHistoryListener;", "", "onUndoable", "", "sdoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "isUndoable", "", "onRedoable", "isRedoable", "onSDocChanged", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SDocHistoryListener {
        void onRedoable(@Nullable SpenSDoc sdoc, boolean isRedoable);

        void onSDocChanged(@Nullable SpenSDoc sdoc);

        void onUndoable(@Nullable SpenSDoc sdoc, boolean isUndoable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$SearchData;", "", "<init>", "()V", DBSchema.StrokeSearch.HAS_VISUALCUE, "", "rect", "Landroid/graphics/Rect;", "text", "", "filePath", "pageWidth", "", "customData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SearchData {
        public static final int CONTENT_TYPE = 0;

        @NotNull
        public static final String CONTENT_TYPE_STROKE = "stroke";

        @NotNull
        public static final String CONTENT_TYPE_TEXTBOX = "textbox";

        @JvmField
        @Nullable
        public HashMap<Integer, String> customData;

        @JvmField
        @Nullable
        public String filePath;

        @JvmField
        public boolean hasVisualCue;

        @JvmField
        public int pageWidth;

        @JvmField
        @Nullable
        public Rect rect;

        @JvmField
        @Nullable
        public String text;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$TextSearchData;", "", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "contentIndex", "getContentIndex", "setContentIndex", "subIndex", "getSubIndex", "setSubIndex", "beginPos", "getBeginPos", "setBeginPos", "endPos", "getEndPos", "setEndPos", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextSearchData {
        public static final int SEARCH_TYPE_HANDWRITING_TEXTBOX = 2;
        public static final int SEARCH_TYPE_NONE = 0;
        public static final int SEARCH_TYPE_TEXT = 1;
        public static final int SEARCH_TYPE_VOICE_TITLE = 3;
        public static final int SEARCH_TYPE_WEB_TITLE = 4;

        @Nullable
        private String text;
        private int type;
        private int contentIndex = -1;
        private int subIndex = -1;
        private int beginPos = -1;
        private int endPos = -1;

        public final int getBeginPos() {
            return this.beginPos;
        }

        public final int getContentIndex() {
            return this.contentIndex;
        }

        public final int getEndPos() {
            return this.endPos;
        }

        public final int getSubIndex() {
            return this.subIndex;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public final int getType() {
            return this.type;
        }

        public final void setBeginPos(int i) {
            this.beginPos = i;
        }

        public final void setContentIndex(int i) {
            this.contentIndex = i;
        }

        public final void setEndPos(int i) {
            this.endPos = i;
        }

        public final void setSubIndex(int i) {
            this.subIndex = i;
        }

        public final void setText(@Nullable String str) {
            this.text = str;
        }

        public final void setType(int i) {
            this.type = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc$UpdateInfo;", "", "<init>", "()V", "content", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "getContent", "()Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "setContent", "(Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "type", "getType", "setType", "start", "getStart", "setStart", "before", "getBefore", "setBefore", "count", "getCount", "setCount", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class UpdateInfo {
        private int before;

        @Nullable
        private SpenContentBase content;
        private int count;
        private int index;
        private int start;
        private int type;

        public final int getBefore() {
            return this.before;
        }

        @Nullable
        public final SpenContentBase getContent() {
            return this.content;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getType() {
            return this.type;
        }

        public final void setBefore(int i) {
            this.before = i;
        }

        public final void setContent(@Nullable SpenContentBase spenContentBase) {
            this.content = spenContentBase;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }

        public final void setType(int i) {
            this.type = i;
        }
    }

    private SpenSDoc() {
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
    }

    private final native boolean SDoc_SelectRegion(int handle, CursorInfo begin, CursorInfo end);

    private final native boolean SDoc_appendContent(int handle, SpenContentBase content);

    private final native boolean SDoc_backupContentList(int handle, ArrayList<SpenContentBase> contentList, String filePath);

    private final native boolean SDoc_beginTransaction(int handle);

    private final native int SDoc_bindFile1(int handle, String filePath);

    private final native int SDoc_bindFile2(int handle, int id);

    private final native boolean SDoc_clearAllBoundFiles(int handle);

    private final native boolean SDoc_clearChangedFlag(int handle);

    private final native boolean SDoc_clearCursorInfo(int handle);

    private final native boolean SDoc_clearHistory(int handle);

    private final native boolean SDoc_clearSelection(int handle);

    private final native boolean SDoc_close(int handle, boolean removeCache);

    private final native boolean SDoc_commitHistory(int handle);

    private final native boolean SDoc_containContent(int handle, SpenContentBase content);

    private final native boolean SDoc_discard(int handle);

    private final native boolean SDoc_endTransaction(int handle);

    private final native void SDoc_finalize(int handle);

    private final native boolean SDoc_findVoiceName(int handle, String name);

    private final native String SDoc_getBoundFilePath(int handle, int id);

    private final native long SDoc_getBoundFilesSize(int handle);

    private final native String SDoc_getCachePath(int handle);

    private final native SpenContentBase SDoc_getContent(int handle, int index);

    private final native int SDoc_getContentCount(int handle);

    private final native int SDoc_getContentIndex(int handle, SpenContentBase content);

    private final native ArrayList<SpenContentBase> SDoc_getContentList(int handle);

    private final native long SDoc_getCreatedTime(int handle);

    private final native CursorInfo SDoc_getCursorPosition(int handle);

    private final native int SDoc_getDocumentType(int handle);

    private final native byte[] SDoc_getExtraDataByteArray(int handle, String key);

    private final native int SDoc_getExtraDataInt(int handle, String key);

    private final native String SDoc_getExtraDataString(int handle, String key);

    private final native int SDoc_getMode(int handle);

    private final native long SDoc_getModifiedTime(int handle);

    private final native String SDoc_getNewVoiceName(int handle, String name);

    private final native ArrayList<ReminderData> SDoc_getReminderData(int handle);

    private final native ArrayList<SearchData> SDoc_getSearchData(int handle);

    private final native ArrayList<SearchData> SDoc_getSearchData2(int handle, String filePath);

    private final native CursorInfo SDoc_getSelectedRegionBegin(int handle);

    private final native CursorInfo SDoc_getSelectedRegionEnd(int handle);

    private final native int SDoc_getTextLength(int handle);

    private final native int SDoc_getTextMaxCount(int handle);

    private final native int SDoc_getThumbnailCount(int handle);

    private final native int SDoc_getThumbnailMaxCount(int handle);

    private final native SpenContentText SDoc_getTitle(int handle);

    private final native boolean SDoc_hasExtraDataByteArray(int handle, String key);

    private final native boolean SDoc_hasExtraDataInt(int handle, String key);

    private final native boolean SDoc_hasExtraDataString(int handle, String key);

    private final native int SDoc_init(String cacheDirPath, String fileFullPath, boolean restoreUnsavedData, int mode);

    private final native boolean SDoc_insertContent(int handle, SpenContentBase content, int index);

    private final native boolean SDoc_isClosed(int handle);

    private final native boolean SDoc_isContentChanged(int handle);

    private final native boolean SDoc_isContentChangedByApp(int handle);

    private final native boolean SDoc_isFavorite(int handle);

    private final native boolean SDoc_isLocked(int handle);

    private final native boolean SDoc_isRedoable(int handle);

    private final native boolean SDoc_isRedoing(int handle);

    private final native boolean SDoc_isSaving(int handle);

    private final native boolean SDoc_isSelected(int handle);

    private final native boolean SDoc_isTransaction(int handle);

    private final native boolean SDoc_isUndoable(int handle);

    private final native boolean SDoc_isUndoing(int handle);

    private final native boolean SDoc_lock(int handle);

    private final native boolean SDoc_quickSave(int handle);

    private final native boolean SDoc_redo(int handle);

    private final native boolean SDoc_registContentEventListener(int handle, int cookie, ContentEventListener listener);

    private final native boolean SDoc_releaseFile1(int handle, String filePath);

    private final native boolean SDoc_releaseFile2(int handle, int id);

    private final native boolean SDoc_reload(int handle);

    private final native boolean SDoc_removeAllContent(int handle);

    private final native boolean SDoc_removeContent(int handle, SpenContentBase content);

    private final native boolean SDoc_removeEmptyContentHandwriting(int handle);

    private final native boolean SDoc_removeExtraDataByteArray(int handle, String key);

    private final native boolean SDoc_removeExtraDataInt(int handle, String key);

    private final native boolean SDoc_removeExtraDataString(int handle, String key);

    private final native boolean SDoc_reserveDiscard(int handle, boolean flag);

    private final native ArrayList<SpenContentBase> SDoc_restoreContentList(int handle, String filePath);

    private final native boolean SDoc_save1(int handle, String fileFullPath);

    private final native boolean SDoc_save2(int handle, String fileFullPath, boolean fixCache);

    private final native boolean SDoc_save3(int handle, String fileFullPath, long createdTime, long modifiedTime);

    private final native boolean SDoc_save4(int handle, String fileFullPath, boolean fixCache, long createdTime, long modifiedTime);

    private final native boolean SDoc_setAppVersion(int handle, String version);

    private final native boolean SDoc_setContentTextChangedListener(int handle, ContentTextChangedListener listener);

    private final native boolean SDoc_setCursorPosition(int handle, CursorInfo cursor);

    private final native boolean SDoc_setDocumentType(int handle, int type);

    private final native boolean SDoc_setExtraDataByteArray(int handle, String key, byte[] array, int arrayCount);

    private final native boolean SDoc_setExtraDataInt(int handle, String key, int value);

    private final native boolean SDoc_setExtraDataString(int handle, String key, String value);

    private final native boolean SDoc_setFavorite(int handle, boolean flag);

    private final native boolean SDoc_setReminderData(int handle, ArrayList<ReminderData> dataList);

    private final native boolean SDoc_setSDocHistoryListener(int handle, SDocHistoryListener listener);

    private final native boolean SDoc_setSearchData(int handle, ArrayList<SearchData> dataList);

    private final native boolean SDoc_setSearchData2(int handle, String filePath, ArrayList<SearchData> dataList);

    private final native boolean SDoc_setTextMaxCount(int handle, int count);

    private final native boolean SDoc_setThumbnailMaxCount(int handle, int count);

    private final native boolean SDoc_stopSave(int handle);

    private final native boolean SDoc_undo(int handle);

    private final native boolean SDoc_unlock(int handle);

    private final native boolean SDoc_unregistContentEventListener(int handle, int cookie);

    private final void addExtraZipFileList(ArrayList<String> filePathList) {
    }

    private final synchronized void checkTempDirectory() {
        File file = new File(this.mTempDirPath);
        if (!file.exists() && !file.mkdir()) {
            Log.e(TAG, "Fail to create temp directory.");
            throw new IOException("Fail to create temp directory.");
        }
    }

    private final void clearExtraZipFileList() {
    }

    private final void decryptSdoc(String fileFullPath, String password) throws SpenSDocInvalidPasswordException {
        if (fileFullPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        String str = this.mTempDirPath;
        String strSubstring = fileFullPath.substring(StringsKt.m14131E("/", 0, 6, fileFullPath), StringsKt.m14131E(Extension.DOT, 0, 6, fileFullPath));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String str2 = str + strSubstring + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
        this.mTempFilePath = str2;
        Intrinsics.checkNotNull(str2);
        LockUtil.decrypt(fileFullPath, str2, password);
        File file = new File(this.mTempFilePath);
        if (!file.exists()) {
            throw new SpenSDocInvalidPasswordException("decryptSdoc() - fail to unlock file");
        }
        try {
            new EndTagUtil(null).parse(this.mTempFilePath, true);
        } catch (SpenSDocUnsupportedFileException unused) {
            if (!file.delete()) {
                Log.d(TAG, "decryptSdoc() - fail to delete temporary file.");
            }
            throw new SpenSDocInvalidPasswordException("decryptSdoc() - decrypt fail.");
        }
    }

    private final void init(Context context, String fileFullPath, String confirmResult, String[] passwordList, boolean restoreUnsavedData, int mode) throws Exception {
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (fileFullPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        StringBuilder sbM2229t = AbstractC2821a.m2229t("init() - fileFullPath = [", LogUtil.logPath(fileFullPath), "], [", confirmResult != null, "], mode = [");
        sbM2229t.append(mode);
        sbM2229t.append("]");
        Log.d(TAG, sbM2229t.toString());
        this.mTempDirPath = AbstractC0541b.m756B(context.getFilesDir().getAbsolutePath(), this.SDOC_TEMP_PATH);
        preConstruct(fileFullPath, confirmResult, passwordList);
        String str = this.mTempFilePath;
        if (str != null) {
            Intrinsics.checkNotNull(str);
            fileFullPath = str;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.mHandle = SDoc_init(absolutePath, fileFullPath, restoreUnsavedData, mode);
        postConstruct();
        if (this.mHandle == -1) {
            int error = SpenError.getError();
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenSDoc(" + this + ") is already closed");
            }
            switch (error) {
                case 11:
                    throw new IOException();
                case 12:
                    throw new SpenSDocUnsupportedVersionException("E_UNSUPPORTED_VERSION : It can not support SDoc version");
                case 13:
                    throw new SpenSDocUnsupportedFileException("E_UNSUPPORTED_TYPE : It does not correspond to the SDoc file format");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    break;
            }
        }
        try {
            SDoc_setAppVersion(this.mHandle, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception unused) {
            Log.e(TAG, "init() - Fail to get app version.");
            SDoc_setAppVersion(this.mHandle, "Unknown");
        }
    }

    private final void postConstruct() {
        if (this.mTempFilePath != null) {
            File file = new File(this.mTempFilePath);
            if (file.exists() && !file.delete()) {
                Log.d(TAG, "load() - fail to delete temporary file.");
            }
            this.mTempFilePath = null;
        }
    }

    private final void preConstruct(String fileFullPath, String confirmResult, String[] passwordList) throws Exception {
        Log.d(TAG, "preConstruct()");
        if (!new File(fileFullPath).exists()) {
            Log.d(TAG, "preConstruct() - new");
            return;
        }
        EndTagUtil endTagUtil = new EndTagUtil(null);
        endTagUtil.parse(fileFullPath, true);
        long createdTime = endTagUtil.getMCreatedTime();
        long modifiedTime = endTagUtil.getMModifiedTime();
        StringBuilder sbM1323p = AbstractC1974b.m1323p(createdTime, "preConstruct() - ct = ", ", mt = ");
        sbM1323p.append(modifiedTime);
        Log.d(TAG, sbM1323p.toString());
        if (endTagUtil.getMDocumentType() != 1) {
            Log.d(TAG, "preConstruct() - normal");
            return;
        }
        int documentType = endTagUtil.getMDocumentType();
        int currentFormatVersion = endTagUtil.getCurrentFormatVersion();
        boolean zIsEncrypted = endTagUtil.isEncrypted();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(documentType, currentFormatVersion, "preConstruct() - Locked file [", "], [", "], [");
        sbM1173s.append(zIsEncrypted);
        sbM1173s.append("]");
        Log.d(TAG, sbM1173s.toString());
        if (confirmResult == null || !Intrinsics.areEqual(confirmResult, "CONFIRMED_PASSWORD")) {
            throw new SpenSDocInvalidPasswordException("preConstruct() - open locked file without confirmation");
        }
        if (endTagUtil.isEncrypted()) {
            if (passwordList == null || passwordList.length < 2) {
                throw new SpenSDocInvalidPasswordException("preConstruct() - open locked file with no password");
            }
            String str = passwordList[0];
            if (str == null || str.length() == 0) {
                throw new SpenSDocInvalidPasswordException("preConstruct() - open locked file with no password2");
            }
            checkTempDirectory();
            try {
                Log.i(TAG, "preConstruct - step 1");
                decryptSdoc(fileFullPath, str);
            } catch (Exception e) {
                Log.d(TAG, "preConstruct - step 1 fail. " + e);
                String str2 = passwordList[1];
                if (str2 == null || str2.length() == 0 || str2.compareTo(str) == 0) {
                    throw e;
                }
                Log.i(TAG, "preConstruct - step 2");
                decryptSdoc(fileFullPath, str2);
            }
        }
    }

    public static /* synthetic */ void save$default(SpenSDoc spenSDoc, String str, String[] strArr, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        spenSDoc.save(str, strArr, z);
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenSDoc(" + this + ") is already closed");
    }

    public final void appendContent(@Nullable SpenContentBase content) throws SpenExceedTextLimitException, SpenExceedImageLimitException {
        if (SDoc_appendContent(this.mHandle, content)) {
            return;
        }
        if (SpenError.getError() == 20) {
            throw new SpenExceedImageLimitException("Exceed image limit");
        }
        if (SpenError.getError() == 21) {
            throw new SpenExceedTextLimitException("Exceed text limit");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void backupContentList(@Nullable ArrayList<SpenContentBase> contentList, @Nullable String filePath) throws IOException {
        if (SDoc_backupContentList(this.mHandle, contentList, filePath)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean beginTransaction() {
        return SDoc_beginTransaction(this.mHandle);
    }

    public final int bindFile(@Nullable String filePath) throws IOException {
        int iSDoc_bindFile1 = SDoc_bindFile1(this.mHandle, filePath);
        if (iSDoc_bindFile1 != -1) {
            return iSDoc_bindFile1;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
        return iSDoc_bindFile1;
    }

    public final void clearAllBoundFiles() {
        if (SDoc_clearAllBoundFiles(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean clearChangedFlag() {
        return SDoc_clearChangedFlag(this.mHandle);
    }

    public final void clearCursorPosition() {
        if (SDoc_clearCursorInfo(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void clearHistory() {
        SDoc_clearHistory(this.mHandle);
    }

    public final void clearSelection() {
        if (SDoc_clearSelection(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void close() throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!SDoc_close(i, false)) {
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 19) {
                throw new SpenAlreadyClosedException("SpenSDoc(" + this + ") is already closed.");
            }
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mHandle = -1;
    }

    public final boolean commitHistory() {
        return SDoc_commitHistory(this.mHandle);
    }

    public final boolean containContent(@Nullable SpenContentBase content) {
        return SDoc_containContent(this.mHandle, content);
    }

    public final void discard() throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!SDoc_discard(i)) {
            if (SpenError.getError() == 11) {
                throw new IOException();
            }
            throwUncheckedException(SpenError.getError());
        }
        this.mHandle = -1;
    }

    public final boolean endTransaction() {
        return SDoc_endTransaction(this.mHandle);
    }

    public final void finalize() {
        int i = this.mHandle;
        if (i != -1) {
            SDoc_finalize(i);
        }
        this.mHandle = -1;
    }

    public final boolean findVoiceName(@Nullable String name) {
        return SDoc_findVoiceName(this.mHandle, name);
    }

    @Nullable
    public final String getBoundFilePath(int id) {
        String strSDoc_getBoundFilePath = SDoc_getBoundFilePath(this.mHandle, id);
        if (strSDoc_getBoundFilePath == null) {
            throwUncheckedException(SpenError.getError());
        }
        return strSDoc_getBoundFilePath;
    }

    public final long getBoundFilesSize() {
        return SDoc_getBoundFilesSize(this.mHandle);
    }

    @NotNull
    public final String getCachePath() {
        return SDoc_getCachePath(this.mHandle);
    }

    @NotNull
    public final SpenContentBase getContent(int index) {
        SpenContentBase spenContentBaseSDoc_getContent = SDoc_getContent(this.mHandle, index);
        if (spenContentBaseSDoc_getContent == null) {
            throwUncheckedException(SpenError.getError());
        }
        Intrinsics.checkNotNull(spenContentBaseSDoc_getContent);
        return spenContentBaseSDoc_getContent;
    }

    public final int getContentCount() {
        return SDoc_getContentCount(this.mHandle);
    }

    public final int getContentIndex(@Nullable SpenContentBase content) {
        if (content != null) {
            return SDoc_getContentIndex(this.mHandle, content);
        }
        Log.i(TAG, "content is null");
        return -2;
    }

    @Nullable
    public final ArrayList<SpenContentBase> getContentList() {
        ArrayList<SpenContentBase> arrayListSDoc_getContentList = SDoc_getContentList(this.mHandle);
        if (arrayListSDoc_getContentList == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListSDoc_getContentList;
    }

    public final long getCreatedTime() {
        return SDoc_getCreatedTime(this.mHandle);
    }

    @Nullable
    public final CursorInfo getCursorPosition() {
        return SDoc_getCursorPosition(this.mHandle);
    }

    public final int getDocumentType() {
        return SDoc_getDocumentType(this.mHandle);
    }

    @NotNull
    public final byte[] getExtraDataByteArray(@Nullable String key) {
        if (key != null) {
            return SDoc_getExtraDataByteArray(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final int getExtraDataInt(@Nullable String key) {
        if (key != null) {
            return SDoc_getExtraDataInt(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @NotNull
    public final String getExtraDataString(@Nullable String key) {
        if (key != null) {
            return SDoc_getExtraDataString(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    /* JADX INFO: renamed from: getHandle, reason: from getter */
    public final int getMHandle() {
        return this.mHandle;
    }

    public final int getMode() {
        return SDoc_getMode(this.mHandle);
    }

    public final long getModifiedTime() {
        return SDoc_getModifiedTime(this.mHandle);
    }

    @NotNull
    public final String getNewVoiceName(@Nullable String name) {
        String strSDoc_getNewVoiceName = SDoc_getNewVoiceName(this.mHandle, name);
        if (strSDoc_getNewVoiceName == null) {
            throwUncheckedException(SpenError.getError());
        }
        return strSDoc_getNewVoiceName;
    }

    @Nullable
    public final ArrayList<ReminderData> getReminderData() {
        return SDoc_getReminderData(this.mHandle);
    }

    @Nullable
    public final ArrayList<SearchData> getSearchData() {
        return SDoc_getSearchData(this.mHandle);
    }

    @NotNull
    public final CursorInfo getSelectedRegionBegin() {
        return SDoc_getSelectedRegionBegin(this.mHandle);
    }

    @NotNull
    public final CursorInfo getSelectedRegionEnd() {
        return SDoc_getSelectedRegionEnd(this.mHandle);
    }

    public final int getTextLength() {
        return SDoc_getTextLength(this.mHandle);
    }

    public final int getTextMaxCount() {
        return SDoc_getTextMaxCount(this.mHandle);
    }

    public final int getThumbnailCount() {
        return SDoc_getThumbnailCount(this.mHandle);
    }

    public final int getThumbnailMaxCount() {
        return SDoc_getThumbnailMaxCount(this.mHandle);
    }

    @Nullable
    public final SpenContentText getTitle() {
        return SDoc_getTitle(this.mHandle);
    }

    public final boolean hasExtraDataByteArray(@Nullable String key) {
        if (key != null) {
            return SDoc_hasExtraDataByteArray(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final boolean hasExtraDataInt(@Nullable String key) {
        if (key != null) {
            return SDoc_hasExtraDataInt(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final boolean hasExtraDataString(@Nullable String key) {
        if (key != null) {
            return SDoc_hasExtraDataString(this.mHandle, key);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void insertContent(@Nullable SpenContentBase content, int index) throws SpenExceedTextLimitException, SpenExceedImageLimitException {
        if (SDoc_insertContent(this.mHandle, content, index)) {
            return;
        }
        if (SpenError.getError() == 20) {
            throw new SpenExceedImageLimitException("Exceed image limit");
        }
        if (SpenError.getError() == 21) {
            throw new SpenExceedTextLimitException("Exceed text limit");
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean isClosed() {
        return SDoc_isClosed(this.mHandle);
    }

    public final boolean isContentChanged() {
        return SDoc_isContentChanged(this.mHandle);
    }

    public final boolean isContentChangedByApp() {
        return SDoc_isContentChangedByApp(this.mHandle);
    }

    public final boolean isFavorite() {
        return SDoc_isFavorite(this.mHandle);
    }

    public final boolean isLocked() {
        Log.d(TAG, "isLocked");
        return SDoc_isLocked(this.mHandle);
    }

    public final boolean isRedoable() {
        return SDoc_isRedoable(this.mHandle);
    }

    public final boolean isRedoing() {
        return SDoc_isRedoing(this.mHandle);
    }

    public final boolean isSaving() {
        return SDoc_isSaving(this.mHandle);
    }

    public final boolean isSelected() {
        return SDoc_isSelected(this.mHandle);
    }

    public final boolean isTransaction() {
        return SDoc_isTransaction(this.mHandle);
    }

    public final boolean isUndoable() {
        return SDoc_isUndoable(this.mHandle);
    }

    public final boolean isUndoing() {
        return SDoc_isUndoing(this.mHandle);
    }

    public final void lock() {
        Log.d(TAG, "lock");
        if (SDoc_lock(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void quickSave() throws IOException {
        if (SDoc_quickSave(this.mHandle)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void redoInSdoc() {
        if (SDoc_redo(this.mHandle)) {
            return;
        }
        SpenError.getError();
        throwUncheckedException(SpenError.getError());
    }

    public final void registContentListener(int cookie, @NotNull ContentEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (SDoc_registContentEventListener(this.mHandle, cookie, listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void releaseFile(@Nullable String filePath) throws IOException {
        if (SDoc_releaseFile1(this.mHandle, filePath)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void reload() throws IOException {
        if (SDoc_reload(this.mHandle)) {
            return;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeAllContent() {
        if (SDoc_removeAllContent(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeContent(@Nullable SpenContentBase content) {
        if (SDoc_removeContent(this.mHandle, content)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeEmptyContentHandwriting() {
        if (SDoc_removeEmptyContentHandwriting(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataByteArray(@Nullable String key) {
        if (SDoc_removeExtraDataByteArray(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataInt(@Nullable String key) {
        if (SDoc_removeExtraDataInt(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void removeExtraDataString(@Nullable String key) {
        if (SDoc_removeExtraDataString(this.mHandle, key)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void reserveDiscard(boolean enable) {
        if (SDoc_reserveDiscard(this.mHandle, enable)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final ArrayList<SpenContentBase> restoreContentList(@Nullable String filePath) throws IOException {
        ArrayList<SpenContentBase> arrayListSDoc_restoreContentList = SDoc_restoreContentList(this.mHandle, filePath);
        if (arrayListSDoc_restoreContentList != null) {
            return arrayListSDoc_restoreContentList;
        }
        if (SpenError.getError() == 11) {
            throw new IOException();
        }
        throwUncheckedException(SpenError.getError());
        return arrayListSDoc_restoreContentList;
    }

    @JvmOverloads
    public final void save(@Nullable String str, @Nullable String[] strArr) throws IOException {
        save$default(this, str, strArr, false, 4, null);
    }

    public final void saveEx(@Nullable String fileFullPath, @Nullable String[] passwordList, boolean fixCache, long createdTime, long modifiedTime) throws SpenSDocCancelException, IOException {
        Intrinsics.checkNotNull(fileFullPath);
        AbstractC6670b.m4757r("saveEx() - [", LogUtil.logPath(fileFullPath), "]", TAG);
        if (SDoc_getDocumentType(this.mHandle) != 1) {
            if (SDoc_save4(this.mHandle, fileFullPath, fixCache, createdTime, modifiedTime)) {
                return;
            }
            int error = SpenError.getError();
            if (error == 11) {
                throw new IOException();
            }
            if (error == 22) {
                throw new SpenSDocCancelException("Save cancel.");
            }
            throwUncheckedException(SpenError.getError());
            return;
        }
        if (passwordList == null || passwordList.length < 2) {
            throw new IllegalArgumentException("saveEx() - invalid argument1");
        }
        checkTempDirectory();
        String str = fileFullPath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
        if (!SDoc_save4(this.mHandle, str, fixCache, createdTime, modifiedTime)) {
            int error2 = SpenError.getError();
            if (error2 == 11) {
                throw new IOException();
            }
            if (error2 == 22) {
                throw new SpenSDocCancelException("Save cancel.");
            }
            throwUncheckedException(SpenError.getError());
        }
        try {
            String str2 = passwordList[0];
            Intrinsics.checkNotNull(str2);
            LockUtil.encrypt(str, str2);
            INSTANCE.forceRenameTo(str, fileFullPath);
        } catch (Exception unused) {
            File file = new File(str);
            if (file.exists()) {
                INSTANCE.deleteFile(file);
            }
            throw new IOException("saveEx() - Fail to lock file");
        }
    }

    public final void selectRegion(@Nullable CursorInfo begin, @Nullable CursorInfo end) {
        if (begin == null || end == null) {
            SpenError.ThrowUncheckedException(7);
        }
        if (SDoc_SelectRegion(this.mHandle, begin, end)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setContentTextChangedListener(@NotNull ContentTextChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (SDoc_setContentTextChangedListener(this.mHandle, listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCursorPosition(@Nullable CursorInfo cursorInfo) {
        if (SDoc_setCursorPosition(this.mHandle, cursorInfo)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setDocumentType(int i) {
        if (SDoc_setDocumentType(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataByteArray(@Nullable String key, @Nullable byte[] value) {
        if (key == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (value != null) {
            if (SDoc_setExtraDataByteArray(this.mHandle, key, value, value.length)) {
                return;
            }
            throwUncheckedException(SpenError.getError());
        } else {
            if (SDoc_setExtraDataByteArray(this.mHandle, key, value, 0)) {
                return;
            }
            throwUncheckedException(SpenError.getError());
        }
    }

    public final void setExtraDataInt(@Nullable String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (SDoc_setExtraDataInt(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setExtraDataString(@Nullable String key, @Nullable String value) {
        if (key == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (SDoc_setExtraDataString(this.mHandle, key, value)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setFavorite(boolean z) {
        if (SDoc_setFavorite(this.mHandle, z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setReminderData(@Nullable ArrayList<ReminderData> arrayList) {
        if (SDoc_setReminderData(this.mHandle, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSDocHistoryListener(@NotNull SDocHistoryListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (SDoc_setSDocHistoryListener(this.mHandle, listener)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setSearchData(@Nullable ArrayList<SearchData> arrayList) {
        if (SDoc_setSearchData(this.mHandle, arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setTextMaxCount(int i) {
        if (SDoc_setTextMaxCount(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailMaxCount(int i) {
        if (SDoc_setThumbnailMaxCount(this.mHandle, i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void stopSave() {
        if (SDoc_stopSave(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void undoInSdoc() {
        if (SDoc_undo(this.mHandle)) {
            return;
        }
        SpenError.getError();
        throwUncheckedException(SpenError.getError());
    }

    public final void unlock() {
        Log.d(TAG, "unlock");
        if (SDoc_unlock(this.mHandle)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void unregistContentListener(int cookie) {
        if (SDoc_unregistContentEventListener(this.mHandle, cookie)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final ArrayList<SearchData> getSearchData(@Nullable String filePath) {
        return SDoc_getSearchData2(this.mHandle, filePath);
    }

    @JvmOverloads
    public final void save(@Nullable String fileFullPath, @Nullable String[] passwordList, boolean fixCache) throws IOException {
        if (fileFullPath == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        AbstractC6670b.m4757r("save2() - [", LogUtil.logPath(fileFullPath), "]", TAG);
        if (SDoc_getDocumentType(this.mHandle) != 1) {
            if (SDoc_save2(this.mHandle, fileFullPath, fixCache)) {
                return;
            }
            if (SpenError.getError() == 11) {
                throw new IOException();
            }
            throwUncheckedException(SpenError.getError());
            return;
        }
        if (passwordList == null || passwordList.length < 2) {
            throw new IllegalArgumentException("save2() - invalid argument1");
        }
        String str = passwordList[0];
        if (str == null) {
            throw new IllegalArgumentException("save2() - invalid argument2");
        }
        checkTempDirectory();
        String str2 = fileFullPath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
        if (!SDoc_save2(this.mHandle, str2, fixCache)) {
            if (SpenError.getError() == 11) {
                throw new IOException();
            }
            throwUncheckedException(SpenError.getError());
        }
        try {
            LockUtil.encrypt(str2, str);
            INSTANCE.forceRenameTo(str2, fileFullPath);
        } catch (Exception unused) {
            File file = new File(str2);
            if (file.exists()) {
                INSTANCE.deleteFile(file);
            }
            throw new IOException("save2() - Fail to lock file");
        }
    }

    public final void setSearchData(@Nullable String filePath, @Nullable ArrayList<SearchData> dataList) {
        if (SDoc_setSearchData2(this.mHandle, filePath, dataList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    private SpenSDoc(Context context) {
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
        Log.d(TAG, "SpenSDoc1()");
    }

    public final int bindFile(int id) {
        int iSDoc_bindFile2 = SDoc_bindFile2(this.mHandle, id);
        if (iSDoc_bindFile2 == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return iSDoc_bindFile2;
    }

    public final void releaseFile(int id) {
        if (SDoc_releaseFile2(this.mHandle, id)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenSDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String[] strArr) throws Exception {
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
        Intrinsics.checkNotNull(str);
        Log.d(TAG, "SpenSDoc2() - fileFullPath = [" + LogUtil.logPath(str) + "], [" + (str2 != null) + "]");
        init(context, str, str2, strArr, false, 0);
    }

    public final void close(boolean removeCache) throws IOException {
        int i = this.mHandle;
        if (i == -1) {
            return;
        }
        if (!SDoc_close(i, removeCache)) {
            if (SpenError.getError() != 11) {
                throwUncheckedException(SpenError.getError());
            } else {
                throw new IOException();
            }
        }
        this.mHandle = -1;
    }

    public SpenSDoc(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, boolean z) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
        StringBuilder sbM2229t = AbstractC2821a.m2229t("SpenSDoc3() - fileFullPath = [", LogUtil.logPath(str), "], [", str2 != null, "], restoreUnsavedData = [");
        sbM2229t.append(z);
        sbM2229t.append("]");
        Log.d(TAG, sbM2229t.toString());
        init(context, str, str2, strArr, z, 0);
    }

    public SpenSDoc(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String[] strArr, int i) throws Exception {
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
        Intrinsics.checkNotNull(str);
        StringBuilder sbM2229t = AbstractC2821a.m2229t("SpenSDoc4() - fileFullPath = [", LogUtil.logPath(str), "], [", str2 != null, "], mode = [");
        sbM2229t.append(i);
        sbM2229t.append("]");
        Log.d(TAG, sbM2229t.toString());
        init(context, str, str2, strArr, false, i);
    }

    public final void save(@Nullable String fileFullPath, @Nullable String[] passwordList, long createdTime, long modifiedTime) throws IOException {
        save(fileFullPath, passwordList, false, createdTime, modifiedTime);
    }

    public final void save(@Nullable String fileFullPath, @Nullable String[] passwordList, boolean fixCache, long createdTime, long modifiedTime) throws IOException {
        Intrinsics.checkNotNull(fileFullPath);
        AbstractC6670b.m4757r("save4() - [", LogUtil.logPath(fileFullPath), "]", TAG);
        if (SDoc_getDocumentType(this.mHandle) == 1) {
            if (passwordList != null && passwordList.length >= 2) {
                String str = passwordList[0];
                if (str != null) {
                    checkTempDirectory();
                    String str2 = fileFullPath + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
                    if (!SDoc_save4(this.mHandle, str2, fixCache, createdTime, modifiedTime)) {
                        if (SpenError.getError() != 11) {
                            throwUncheckedException(SpenError.getError());
                        } else {
                            throw new IOException();
                        }
                    }
                    try {
                        LockUtil.encrypt(str2, str);
                        INSTANCE.forceRenameTo(str2, fileFullPath);
                        return;
                    } catch (Exception unused) {
                        File file = new File(str2);
                        if (file.exists()) {
                            INSTANCE.deleteFile(file);
                        }
                        throw new IOException("save4() - Fail to lock file");
                    }
                }
                throw new IllegalArgumentException("save4() - invalid argument2");
            }
            throw new IllegalArgumentException("save4() - invalid argument1");
        }
        if (SDoc_save4(this.mHandle, fileFullPath, fixCache, createdTime, modifiedTime)) {
            return;
        }
        if (SpenError.getError() != 11) {
            throwUncheckedException(SpenError.getError());
            return;
        }
        throw new IOException();
    }

    public SpenSDoc(@NotNull Context context, @NotNull String fileFullPath, @Nullable String[] strArr, int i) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileFullPath, "fileFullPath");
        this.mHandle = -1;
        this.SDOC_TEMP_PATH = "/SPenSDK30/SdocTemp";
        Log.d(TAG, AbstractC1974b.m1319l("SpenSDoc5() - fileFullPath = [", i, LogUtil.logPath(fileFullPath), "], mode = [", "]"));
        init(context, fileFullPath, "CONFIRMED_PASSWORD", strArr, false, i);
    }
}
