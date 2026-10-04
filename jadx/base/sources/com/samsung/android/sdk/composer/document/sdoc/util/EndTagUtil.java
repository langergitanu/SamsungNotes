package com.samsung.android.sdk.composer.document.sdoc.util;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.nimbusds.jose.HeaderParameterNames;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.composer.document.sdoc.textspan.SpenTextSpan;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020dH\u0016J\u0012\u0010f\u001a\u00020d2\b\u0010g\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010h\u001a\u00020dJ\u0006\u0010i\u001a\u00020dJ,\u0010j\u001a\u00020d2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010k\u001a\u0004\u0018\u00010,2\b\u0010l\u001a\u0004\u0018\u00010,2\b\u0010m\u001a\u0004\u0018\u00010,J\u0006\u0010n\u001a\u00020dJ&\u0010o\u001a\u00020\b2\u001e\u0010p\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u000106j\f\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u0001`8J\u0018\u0010q\u001a\u00020d2\b\u0010r\u001a\u0004\u0018\u00010\u00032\u0006\u0010s\u001a\u00020\bJ\u0010\u0010t\u001a\u00020d2\b\u0010u\u001a\u0004\u0018\u00010\u0003J\u0010\u0010v\u001a\u00020d2\b\u0010u\u001a\u0004\u0018\u00010\u0003J\u0018\u0010w\u001a\u00020d2\b\u0010u\u001a\u0004\u0018\u00010\u00032\u0006\u0010x\u001a\u00020\bJ\u0012\u0010y\u001a\u00020\b2\b\u0010z\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010q\u001a\u00020d2\u0006\u0010{\u001a\u00020|H\u0002J\u0018\u0010w\u001a\u00020d2\u0006\u0010{\u001a\u00020|2\u0006\u0010x\u001a\u00020\bH\u0002J\u0010\u0010}\u001a\u00020d2\u0006\u0010{\u001a\u00020|H\u0002J\u0010\u0010~\u001a\u00020d2\u0006\u0010{\u001a\u00020|H\u0002J\u0010\u0010\u007f\u001a\u00020d2\u0006\u0010{\u001a\u00020|H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\f2\u0006\u0010{\u001a\u00020|2\u0006\u0010m\u001a\u00020\u0003H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u000e\u0010#\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u000e\u001a\u0004\u0018\u00010,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\"\u00100\u001a\u0004\u0018\u00010,2\b\u0010\u000e\u001a\u0004\u0018\u00010,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\"\u00102\u001a\u0004\u0018\u00010,2\b\u0010\u000e\u001a\u0004\u0018\u00010,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u000e\u00104\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00105\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u000106j\n\u0012\u0004\u0012\u000207\u0018\u0001`8X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010:\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000106j\n\u0012\u0004\u0012\u000209\u0018\u0001`82\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000106j\n\u0012\u0004\u0012\u000209\u0018\u0001`8@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0012R\u0014\u0010C\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0012R$\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010\u001d\"\u0004\bH\u0010\u001fR$\u0010I\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010\u001fR$\u0010L\u001a\u00020\f2\u0006\u0010E\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010\u001d\"\u0004\bN\u0010\u001fR\u0011\u0010O\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bO\u0010PR$\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u0010\u0012\"\u0004\bT\u0010(R(\u0010V\u001a\u0004\u0018\u00010\u00032\b\u0010U\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010\u0005R$\u0010[\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010P\"\u0004\b\\\u0010]RL\u0010_\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u000106j\n\u0012\u0004\u0012\u000207\u0018\u0001`82\u001a\u0010^\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u000106j\n\u0012\u0004\u0012\u000207\u0018\u0001`88F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010<\"\u0004\ba\u0010b¨\u0006\u0082\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/util/EndTagUtil;", "Lcom/samsung/android/sdk/composer/document/sdoc/util/ComponentUtil;", "savePath", "", "<init>", "(Ljava/lang/String;)V", "mFilePath", "mSetModifiedTime", "", "mSetCreatedTime", "mSetFileModifiedTime", "mStartPosition", "", "mFavoriteFlag", "value", "", "size", "getSize", "()I", "mPropertyFlag", "mFieldCheckFlag", "fileRevision", "getFileRevision", "mModifiedTime", "minimumFormatVersion", "getMinimumFormatVersion", "mCreatedTime", "uncompressedSize", "getUncompressedSize", "()J", "setUncompressedSize", "(J)V", "mTitle", "fileCreatedTime", "getFileCreatedTime", "mFileModifiedTime", "mMadeOsType", "titleAlignment", "getTitleAlignment", "setTitleAlignment", "(I)V", "mAppVersion", "encryptionSize", "getEncryptionSize", "", "encryptionIv", "getEncryptionIv", "()[B", "encryptionSalt", "getEncryptionSalt", "encryptionKey", "getEncryptionKey", "mDocumentType", "mReminderDataSet", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/util/ReminderDataUtil;", "Lkotlin/collections/ArrayList;", "Lcom/samsung/android/sdk/composer/document/sdoc/textspan/SpenTextSpan;", "titleSpan", "getTitleSpan", "()Ljava/util/ArrayList;", "fileNames", "", "getFileNames", "()[Ljava/lang/String;", "propertyFlag", "getPropertyFlag", "fieldCheckFlag", "getFieldCheckFlag", "time", "modifiedTime", "getModifiedTime", "setModifiedTime", GroupContract.Group.CREATED_TIME, "getCreatedTime", "setCreatedTime", "fileModifiedTime", "getFileModifiedTime", "setFileModifiedTime", "isEncrypted", "()Z", "type", "documentType", "getDocumentType", "setDocumentType", "text", "title", DynamicActionBarProvider.METHOD_GET_DATA, "()Ljava/lang/String;", "setTitle", "flag", "isFavorite", "setFavorite", "(Z)V", "data", "reminderData", "getReminderData", "setReminderData", "(Ljava/util/ArrayList;)V", "writeFile", "", "readFile", "changeCacheDir", "newPath", "resetFileRevision", "increaseFileRevision", "setEncryptionInfo", "salt", HeaderParameterNames.INITIALIZATION_VECTOR, "key", "removeEncryptionInfo", "setTitleSpan", XmlErrorCodes.LIST, "writeBytes", "path", "appendMode", "resetStartPosition", "filePath", Constants.ARG_UPDATE, "parse", "checkUnsupportedVersionException", "isSameSpanInList", "span", "raf", "Ljava/io/RandomAccessFile;", "readDocumentType", "readTitleSpanData", "readReminderData", "searchStringOfFile", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEndTagUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EndTagUtil.kt\ncom/samsung/android/sdk/composer/document/sdoc/util/EndTagUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,982:1\n1#2:983\n*E\n"})
public final class EndTagUtil extends ComponentUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DATA_FILE_NAME_END_TAG = "endtag.dat";
    private static final int FIELD_FLAG_DOCUMENT_TYPE = 2;
    private static final int FIELD_FLAG_ENCRYPTION_INFO = 1;
    private static final int FIELD_FLAG_REMINDER_DATA = 4;
    private static final int FIELD_FLAG_TITLE_SPAN = 16;
    private static final int FIELD_FLAG_TITLE_SPAN_INVALID = 8;
    private static final int MINIMUM_FORMAT_VERSION = 19;
    private static final int OS_TYPE_ANDROID = 1;
    private static final int OS_TYPE_UWP = 2;
    private static final int OS_TYPE_WIN32 = 0;
    private static final int PROPERTY_FLAG_FAVORITE = 2;
    private static final int PROPERTY_FLAG_LOCK = 1;

    @NotNull
    private static final String TAG = "SDocEndTag";

    @Nullable
    private byte[] encryptionIv;

    @Nullable
    private byte[] encryptionKey;

    @Nullable
    private byte[] encryptionSalt;
    private int encryptionSize;
    private long fileCreatedTime;
    private int fileRevision;

    @Nullable
    private String mAppVersion;
    private long mCreatedTime;
    private int mDocumentType;
    private boolean mFavoriteFlag;
    private int mFieldCheckFlag;
    private long mFileModifiedTime;

    @Nullable
    private String mFilePath;
    private long mModifiedTime;
    private int mPropertyFlag;

    @Nullable
    private ArrayList<ReminderDataUtil> mReminderDataSet;
    private boolean mSetCreatedTime;
    private boolean mSetFileModifiedTime;
    private boolean mSetModifiedTime;
    private long mStartPosition;

    @Nullable
    private String mTitle;
    private int minimumFormatVersion;
    private int size;

    @Nullable
    private ArrayList<SpenTextSpan> titleSpan;
    private long uncompressedSize;
    private int mMadeOsType = 1;
    private int titleAlignment = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/util/EndTagUtil$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DATA_FILE_NAME_END_TAG", "MINIMUM_FORMAT_VERSION", "", "OS_TYPE_WIN32", "OS_TYPE_ANDROID", "OS_TYPE_UWP", "PROPERTY_FLAG_LOCK", "PROPERTY_FLAG_FAVORITE", "FIELD_FLAG_ENCRYPTION_INFO", "FIELD_FLAG_DOCUMENT_TYPE", "FIELD_FLAG_REMINDER_DATA", "FIELD_FLAG_TITLE_SPAN_INVALID", "FIELD_FLAG_TITLE_SPAN", "makeFile", "", "buf", "", "size", "filePath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nEndTagUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EndTagUtil.kt\ncom/samsung/android/sdk/composer/document/sdoc/util/EndTagUtil$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,982:1\n1#2:983\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0058 A[EDGE_INSN: B:39:0x0058->B:22:0x0058 BREAK  A[LOOP:1: B:11:0x0036->B:42:?], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0055 -> B:21:0x0056). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void makeFile(@org.jetbrains.annotations.NotNull byte[] r8, int r9, @org.jetbrains.annotations.Nullable java.lang.String r10) throws com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException, java.io.IOException {
            /*
                r7 = this;
                java.lang.String r0 = "buf"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                int r0 = r9 + (-25)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r2 = r0
            Ld:
                if (r2 >= r9) goto L21
                r3 = r8[r2]
                short r3 = (short) r3
                short r3 = kotlin.UShort.m22496constructorimpl(r3)
                r4 = 65535(0xffff, float:9.1834E-41)
                r3 = r3 & r4
                char r3 = (char) r3
                r1.append(r3)
                int r2 = r2 + 1
                goto Ld
            L21:
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "Document for SAMSUNG Note"
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                if (r1 != 0) goto L64
                int r0 = r9 + (-1024)
                r1 = 0
                if (r0 >= 0) goto L34
                r3 = r9
                goto L56
            L34:
                r3 = 1024(0x400, float:1.435E-42)
            L36:
                r4 = -1
                if (r0 <= r4) goto L58
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.US_ASCII
                java.lang.String r6 = "US_ASCII"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                java.lang.String r6 = new java.lang.String
                r6.<init>(r8, r0, r3, r5)
                r5 = 6
                int r5 = kotlin.text.StringsKt.m14131E(r2, r1, r5, r6)
                if (r5 == r4) goto L4e
                int r0 = r0 + r5
                goto L59
            L4e:
                if (r0 != 0) goto L52
                r0 = r4
                goto L59
            L52:
                int r0 = r0 - r3
                if (r0 >= 0) goto L36
                int r3 = r3 + r0
            L56:
                r0 = r1
                goto L36
            L58:
                r0 = r1
            L59:
                if (r0 < 0) goto L5c
                goto L64
            L5c:
                com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException r8 = new com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException
                java.lang.String r9 = "Fail to load sdoc file. It is invalid file type."
                r8.<init>(r9)
                throw r8
            L64:
                int r1 = r0 + (-4)
                r1 = r8[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                int r1 = r1 << 24
                int r2 = r0 + (-3)
                r2 = r8[r2]
                r2 = r2 & 255(0xff, float:3.57E-43)
                int r2 = r2 << 16
                r1 = r1 | r2
                int r2 = r0 + (-2)
                r2 = r8[r2]
                r2 = r2 & 255(0xff, float:3.57E-43)
                int r2 = r2 << 8
                r1 = r1 | r2
                int r2 = r0 + (-1)
                r2 = r8[r2]
                r2 = r2 & 255(0xff, float:3.57E-43)
                r1 = r1 | r2
                int r0 = r0 - r1
                java.io.FileOutputStream r1 = new java.io.FileOutputStream
                r1.<init>(r10)
                int r9 = r9 - r0
                r1.write(r8, r0, r9)     // Catch: java.lang.Throwable -> L93
                r1.close()
                return
            L93:
                r8 = move-exception
                r1.close()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.composer.document.sdoc.util.EndTagUtil.Companion.makeFile(byte[], int, java.lang.String):void");
        }

        private Companion() {
        }
    }

    public EndTagUtil(@Nullable String str) {
        this.mFilePath = AbstractC0541b.m756B(str, "/endtag.dat");
    }

    private final int getFieldCheckFlag() {
        this.mFieldCheckFlag = 0;
        if (this.encryptionIv != null && this.encryptionSalt != null && this.encryptionKey != null) {
            this.mFieldCheckFlag = 1;
        }
        if (this.mDocumentType != 0) {
            this.mFieldCheckFlag |= 2;
        }
        ArrayList<ReminderDataUtil> arrayList = this.mReminderDataSet;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0) {
                this.mFieldCheckFlag |= 4;
            }
        }
        ArrayList<SpenTextSpan> arrayList2 = this.titleSpan;
        if (arrayList2 != null) {
            Intrinsics.checkNotNull(arrayList2);
            if (arrayList2.size() > 0) {
                this.mFieldCheckFlag |= 16;
            }
        }
        return this.mFieldCheckFlag;
    }

    private final int getPropertyFlag() {
        this.mPropertyFlag = 0;
        if (this.mFavoriteFlag) {
            this.mPropertyFlag = 2;
        }
        return this.mPropertyFlag;
    }

    private final boolean isSameSpanInList(SpenTextSpan span) {
        ArrayList<SpenTextSpan> arrayList;
        if (span != null && (arrayList = this.titleSpan) != null) {
            Intrinsics.checkNotNull(arrayList);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ArrayList<SpenTextSpan> arrayList2 = this.titleSpan;
                Intrinsics.checkNotNull(arrayList2);
                SpenTextSpan spenTextSpan = arrayList2.get(i);
                Intrinsics.checkNotNullExpressionValue(spenTextSpan, "get(...)");
                if (spenTextSpan.isSame(span)) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final void makeFile(@NotNull byte[] bArr, int i, @Nullable String str) throws SpenSDocUnsupportedFileException, IOException {
        INSTANCE.makeFile(bArr, i, str);
    }

    private final void readDocumentType(RandomAccessFile raf) {
        if ((this.mFieldCheckFlag & 2) != 0) {
            this.mDocumentType = raf.readInt();
            if (getCurrentFormatVersion() < 12) {
                this.mDocumentType++;
            }
        }
    }

    private final void readReminderData(RandomAccessFile raf) throws IOException {
        if ((this.mFieldCheckFlag & 4) == 4) {
            int i = raf.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                ReminderDataUtil reminderDataUtil = new ReminderDataUtil();
                long filePointer = raf.getFilePointer();
                int i4 = raf.readInt();
                reminderDataUtil.reminderUuid = readString(raf);
                reminderDataUtil.time = raf.readLong();
                ArrayList<ReminderDataUtil> arrayList = this.mReminderDataSet;
                Intrinsics.checkNotNull(arrayList);
                arrayList.add(reminderDataUtil);
                raf.seek(filePointer + ((long) i4));
            }
        }
    }

    private final void readTitleSpanData(RandomAccessFile raf) throws IOException {
        if ((this.mFieldCheckFlag & 16) == 16) {
            if (this.titleSpan == null) {
                this.titleSpan = new ArrayList<>();
            }
            ArrayList<SpenTextSpan> arrayList = this.titleSpan;
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            int i = raf.readInt();
            AbstractC0541b.m755A(i, "readFile() titleSpan count : ", TAG);
            for (int i2 = 0; i2 < i; i2++) {
                raf.readInt();
                int i4 = raf.readInt();
                Log.d(TAG, "readFile() titleSpan type : " + i4);
                SpenTextSpan spenTextSpan = new SpenTextSpan(i4);
                spenTextSpan.readBinary(raf);
                ArrayList<SpenTextSpan> arrayList2 = this.titleSpan;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(spenTextSpan);
            }
        }
    }

    private final long searchStringOfFile(RandomAccessFile raf, String key) {
        try {
            int length = key.length();
            byte[] bArr = new byte[1024];
            long length2 = raf.length() - ((long) 1024);
            if (length2 < 0) {
                length2 = 0;
            }
            raf.seek(length2);
            while (raf.read(bArr, 0, 1024) > -1) {
                Charset US_ASCII = StandardCharsets.US_ASCII;
                Intrinsics.checkNotNullExpressionValue(US_ASCII, "US_ASCII");
                int iM14131E = StringsKt.m14131E(key, 0, 6, new String(bArr, US_ASCII));
                if (iM14131E != -1) {
                    return length2 + ((long) iM14131E);
                }
                if (length2 <= 0) {
                    break;
                }
                length2 -= (long) (1025 - length);
                if (length2 < 0) {
                    length2 = 0;
                }
                raf.seek(length2);
            }
            return -1L;
        } catch (Exception e) {
            Log.e(TAG, "searchStringofFile()" + e);
            return -1L;
        }
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil
    public void changeCacheDir(@Nullable String newPath) {
        if (newPath == null) {
            Log.i(TAG, "changeCacheDir() - newPath is null");
        } else {
            this.mFilePath = newPath.concat("/endtag.dat");
        }
    }

    /* JADX INFO: renamed from: getCreatedTime, reason: from getter */
    public final long getMCreatedTime() {
        return this.mCreatedTime;
    }

    /* JADX INFO: renamed from: getDocumentType, reason: from getter */
    public final int getMDocumentType() {
        return this.mDocumentType;
    }

    @Nullable
    public final byte[] getEncryptionIv() {
        return this.encryptionIv;
    }

    @Nullable
    public final byte[] getEncryptionKey() {
        return this.encryptionKey;
    }

    @Nullable
    public final byte[] getEncryptionSalt() {
        return this.encryptionSalt;
    }

    public final int getEncryptionSize() {
        return this.encryptionSize;
    }

    public final long getFileCreatedTime() {
        return this.fileCreatedTime;
    }

    /* JADX INFO: renamed from: getFileModifiedTime, reason: from getter */
    public final long getMFileModifiedTime() {
        return this.mFileModifiedTime;
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil
    @NotNull
    public String[] getFileNames() {
        return new String[]{this.mFilePath};
    }

    public final int getFileRevision() {
        return this.fileRevision;
    }

    public final int getMinimumFormatVersion() {
        return this.minimumFormatVersion;
    }

    /* JADX INFO: renamed from: getModifiedTime, reason: from getter */
    public final long getMModifiedTime() {
        return this.mModifiedTime;
    }

    @Nullable
    public final ArrayList<ReminderDataUtil> getReminderData() {
        AbstractC0541b.m755A(getCurrentFormatVersion(), "getReminderData() start! ", TAG);
        return this.mReminderDataSet;
    }

    public final int getSize() {
        return this.size;
    }

    @Nullable
    /* JADX INFO: renamed from: getTitle, reason: from getter */
    public final String getMTitle() {
        return this.mTitle;
    }

    public final int getTitleAlignment() {
        return this.titleAlignment;
    }

    @Nullable
    public final ArrayList<SpenTextSpan> getTitleSpan() {
        return this.titleSpan;
    }

    public final long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public final void increaseFileRevision() {
        this.fileRevision++;
        setChanged(true);
    }

    public final boolean isEncrypted() {
        return this.encryptionSize > 0 && this.encryptionKey != null;
    }

    /* JADX INFO: renamed from: isFavorite, reason: from getter */
    public final boolean getMFavoriteFlag() {
        return this.mFavoriteFlag;
    }

    public final void parse(@Nullable String filePath, boolean checkUnsupportedVersionException) {
        long length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
        try {
            long j = 25;
            randomAccessFile.seek(randomAccessFile.length() - j);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) (UShort.m22496constructorimpl(randomAccessFile.readByte()) & UShort.MAX_VALUE));
            }
            if (Intrinsics.areEqual(sb.toString(), ComponentUtil.END_FILE_TAG_SDOC)) {
                length = randomAccessFile.length() - j;
            } else {
                length = searchStringOfFile(randomAccessFile, ComponentUtil.END_FILE_TAG_SDOC);
                if (length < 0) {
                    throw new SpenSDocUnsupportedFileException("Fail to load sdoc file. It is invalid file type.");
                }
            }
            randomAccessFile.seek(length - ((long) 4));
            randomAccessFile.seek(length - ((long) randomAccessFile.readInt()));
            parse(randomAccessFile, checkUnsupportedVersionException);
            randomAccessFile.close();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil
    public void readFile() throws IOException {
        Log.d(TAG, "readFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mFilePath, "r");
        try {
            randomAccessFile.seek(randomAccessFile.length() - ((long) 25));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) (UShort.m22496constructorimpl(randomAccessFile.readByte()) & UShort.MAX_VALUE));
            }
            if (!Intrinsics.areEqual(sb.toString(), ComponentUtil.END_FILE_TAG_SDOC)) {
                throw new IOException("Fail to load end tag data file. It is invalid.");
            }
            randomAccessFile.seek(0L);
            parse(randomAccessFile, true);
            randomAccessFile.close();
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public final void removeEncryptionInfo() {
        this.encryptionSize = 0;
        this.encryptionSalt = null;
        this.encryptionIv = null;
        this.encryptionKey = null;
    }

    public final void resetFileRevision() {
        this.fileRevision = 0;
        setChanged(true);
    }

    public final void resetStartPosition(@Nullable String filePath) {
        long length;
        Log.d(TAG, "resetStartPosition() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
        try {
            long j = 25;
            randomAccessFile.seek(randomAccessFile.length() - j);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 25; i++) {
                sb.append((char) (UShort.m22496constructorimpl(randomAccessFile.readByte()) & UShort.MAX_VALUE));
            }
            if (Intrinsics.areEqual(sb.toString(), ComponentUtil.END_FILE_TAG_SDOC)) {
                length = randomAccessFile.length() - j;
            } else {
                length = searchStringOfFile(randomAccessFile, ComponentUtil.END_FILE_TAG_SDOC);
                if (length < 0) {
                    throw new SpenSDocUnsupportedFileException("Fail to load sdoc file. It is invalid file type.");
                }
            }
            randomAccessFile.seek(length - ((long) 4));
            randomAccessFile.seek(length - ((long) randomAccessFile.readInt()));
            this.mStartPosition = randomAccessFile.getFilePointer();
            randomAccessFile.close();
            Log.d(TAG, "resetStartPosition() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public final void setCreatedTime(long j) {
        if (j < 0) {
            return;
        }
        this.mSetCreatedTime = true;
        this.mCreatedTime = j;
        setChanged(true);
    }

    public final void setDocumentType(int i) {
        this.mDocumentType = i;
        setChanged(true);
    }

    public final void setEncryptionInfo(int size, @Nullable byte[] salt, @Nullable byte[] iv, @Nullable byte[] key) {
        this.encryptionSize = size;
        this.encryptionSalt = salt;
        this.encryptionIv = iv;
        this.encryptionKey = key;
        setChanged(true);
    }

    public final void setFavorite(boolean z) {
        if (this.mFavoriteFlag == z) {
            return;
        }
        this.mFavoriteFlag = z;
        setChanged(true);
    }

    public final void setFileModifiedTime(long j) {
        if (j < 0) {
            return;
        }
        this.mSetFileModifiedTime = true;
        this.mFileModifiedTime = j;
        setChanged(true);
    }

    public final void setModifiedTime(long j) {
        if (j < 0) {
            return;
        }
        this.mSetModifiedTime = true;
        this.mModifiedTime = j;
        setChanged(true);
    }

    public final void setReminderData(@Nullable ArrayList<ReminderDataUtil> arrayList) {
        AbstractC0541b.m755A(getCurrentFormatVersion(), "setReminderData() start! ", TAG);
        this.mReminderDataSet = arrayList;
        setChanged(true);
    }

    public final void setTitle(@Nullable String str) {
        Log.d(TAG, "setTitle() start!");
        this.mTitle = str;
        setChanged(true);
    }

    public final void setTitleAlignment(int i) {
        this.titleAlignment = i;
    }

    public final boolean setTitleSpan(@Nullable ArrayList<SpenTextSpan> list) {
        if (list == null) {
            ArrayList<SpenTextSpan> arrayList = this.titleSpan;
            if (arrayList == null) {
                return true;
            }
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            this.titleSpan = null;
            setChanged(true);
            return true;
        }
        if (this.titleSpan == null) {
            this.titleSpan = new ArrayList<>();
        } else {
            int i = 0;
            while (i < list.size() && isSameSpanInList(list.get(i))) {
                i++;
            }
            if (i == list.size()) {
                return true;
            }
            ArrayList<SpenTextSpan> arrayList2 = this.titleSpan;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.clear();
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            SpenTextSpan spenTextSpan = list.get(i2);
            if (spenTextSpan != null) {
                SpenTextSpan spenTextSpan2 = new SpenTextSpan(spenTextSpan.getType());
                spenTextSpan2.copy(spenTextSpan);
                ArrayList<SpenTextSpan> arrayList3 = this.titleSpan;
                Intrinsics.checkNotNull(arrayList3);
                arrayList3.add(spenTextSpan2);
            }
        }
        setChanged(true);
        return true;
    }

    public final void setUncompressedSize(long j) {
        this.uncompressedSize = j;
    }

    public final void update(@Nullable String filePath) {
        Log.d(TAG, "update() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, InternalZipConstants.WRITE_MODE);
        try {
            long j = this.mStartPosition;
            if (j != 0) {
                randomAccessFile.setLength(j);
            }
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            Log.d(TAG, "update() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public final void writeBytes(@Nullable String path, boolean appendMode) throws IOException {
        Log.d(TAG, "writeBytes() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, InternalZipConstants.WRITE_MODE);
        if (appendMode) {
            try {
                this.mStartPosition = randomAccessFile.length();
            } catch (IOException unused) {
                randomAccessFile.close();
            }
        } else {
            this.mStartPosition = 0L;
        }
        try {
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            Log.d(TAG, "writeBytes() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.util.ComponentUtil
    public void writeFile() throws IOException {
        Log.d(TAG, "writeFile() start");
        RandomAccessFile randomAccessFile = new RandomAccessFile(AbstractC0541b.m756B(this.mFilePath, ".bak"), InternalZipConstants.WRITE_MODE);
        this.mStartPosition = 0L;
        try {
            writeBytes(randomAccessFile);
            randomAccessFile.close();
            Log.d(TAG, "writeFile() end");
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    private final void writeBytes(RandomAccessFile raf) throws IOException {
        int binarySize;
        raf.seek(this.mStartPosition);
        int i = 0;
        raf.writeInt(0);
        raf.writeInt(0);
        raf.writeInt(0);
        raf.writeInt(getPropertyFlag());
        raf.writeInt(getFieldCheckFlag());
        raf.writeInt(this.fileRevision);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mSetModifiedTime) {
            this.mSetModifiedTime = false;
        } else {
            this.mModifiedTime = jCurrentTimeMillis;
        }
        raf.writeLong(this.mModifiedTime);
        raf.writeInt(19);
        if (this.mSetCreatedTime) {
            this.mSetCreatedTime = false;
        } else if (this.mCreatedTime <= 0) {
            this.mCreatedTime = jCurrentTimeMillis;
        }
        raf.writeLong(this.mCreatedTime);
        raf.writeLong(this.uncompressedSize);
        writeString(raf, this.mTitle);
        if (this.fileCreatedTime <= 0) {
            this.fileCreatedTime = jCurrentTimeMillis;
        }
        raf.writeLong(this.fileCreatedTime);
        if (this.mSetFileModifiedTime) {
            this.mSetFileModifiedTime = false;
        } else {
            this.mFileModifiedTime = jCurrentTimeMillis;
        }
        raf.writeLong(this.mFileModifiedTime);
        raf.writeInt(this.mMadeOsType);
        raf.writeInt(this.titleAlignment);
        writeString(raf, this.mAppVersion);
        long filePointer = raf.getFilePointer() - this.mStartPosition;
        int i2 = this.encryptionSize;
        if (i2 > 0 && this.encryptionIv != null && this.encryptionSalt != null && this.encryptionKey != null) {
            raf.writeInt(i2);
            byte[] bArr = this.encryptionSalt;
            Intrinsics.checkNotNull(bArr);
            raf.writeInt(bArr.length);
            raf.write(this.encryptionSalt);
            byte[] bArr2 = this.encryptionIv;
            Intrinsics.checkNotNull(bArr2);
            raf.writeInt(bArr2.length);
            raf.write(this.encryptionIv);
            byte[] bArr3 = this.encryptionKey;
            Intrinsics.checkNotNull(bArr3);
            raf.writeInt(bArr3.length);
            raf.write(this.encryptionKey);
        }
        int i4 = this.mDocumentType;
        if (i4 != 0) {
            raf.writeInt(i4);
        }
        ArrayList<ReminderDataUtil> arrayList = this.mReminderDataSet;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0) {
                ArrayList<ReminderDataUtil> arrayList2 = this.mReminderDataSet;
                Intrinsics.checkNotNull(arrayList2);
                raf.writeInt(arrayList2.size());
                ArrayList<ReminderDataUtil> arrayList3 = this.mReminderDataSet;
                Intrinsics.checkNotNull(arrayList3);
                Iterator<ReminderDataUtil> it = arrayList3.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    ReminderDataUtil next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    ReminderDataUtil reminderDataUtil = next;
                    long filePointer2 = raf.getFilePointer();
                    raf.writeInt(0);
                    writeString(raf, reminderDataUtil.reminderUuid);
                    raf.writeLong(reminderDataUtil.time);
                    long filePointer3 = raf.getFilePointer();
                    raf.seek(filePointer2);
                    raf.writeInt((int) (filePointer3 - filePointer2));
                    raf.seek(filePointer3);
                }
            }
        }
        ArrayList<SpenTextSpan> arrayList4 = this.titleSpan;
        if (arrayList4 != null) {
            Intrinsics.checkNotNull(arrayList4);
            if (arrayList4.size() > 0) {
                long filePointer4 = raf.getFilePointer();
                raf.writeInt(0);
                ArrayList<SpenTextSpan> arrayList5 = this.titleSpan;
                Intrinsics.checkNotNull(arrayList5);
                AbstractC0541b.m755A(arrayList5.size(), "writeFile() titleSpanSize : ", TAG);
                ArrayList<SpenTextSpan> arrayList6 = this.titleSpan;
                Intrinsics.checkNotNull(arrayList6);
                Iterator<SpenTextSpan> it2 = arrayList6.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    SpenTextSpan next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    SpenTextSpan spenTextSpan = next2;
                    if (spenTextSpan.getType() != 18 && spenTextSpan.getType() != 17 && spenTextSpan.getType() != 20 && (binarySize = spenTextSpan.getBinarySize()) > 0) {
                        raf.writeInt(binarySize);
                        spenTextSpan.writeBinary(raf);
                        i++;
                    }
                }
                long filePointer5 = raf.getFilePointer();
                raf.seek(filePointer4);
                raf.writeInt(i);
                raf.seek(filePointer5);
            }
        }
        raf.writeInt(((int) (raf.getFilePointer() - this.mStartPosition)) + 4);
        raf.writeBytes(ComponentUtil.END_FILE_TAG_SDOC);
        raf.seek(this.mStartPosition);
        int length = (int) (raf.length() - this.mStartPosition);
        this.size = length;
        raf.writeInt(length);
        raf.writeInt(31);
        raf.writeInt((int) filePointer);
    }

    private final void parse(RandomAccessFile raf, boolean checkUnsupportedVersionException) throws SpenSDocUnsupportedFileException, SpenSDocUnsupportedVersionException, IOException {
        Log.d(TAG, "parse() - check [" + checkUnsupportedVersionException + "]");
        this.mReminderDataSet = new ArrayList<>();
        this.mStartPosition = raf.getFilePointer();
        this.size = raf.readInt();
        setCurrentFormatVersion(raf.readInt());
        if (getCurrentFormatVersion() >= 6) {
            int i = raf.readInt();
            int i2 = raf.readInt();
            this.mPropertyFlag = i2;
            if ((i2 & 1) != 0) {
                this.mDocumentType = 1;
            }
            this.mFavoriteFlag = (i2 & 2) != 0;
            this.mFieldCheckFlag = raf.readInt();
            this.fileRevision = raf.readInt();
            this.mModifiedTime = raf.readLong();
            int i4 = raf.readInt();
            this.minimumFormatVersion = i4;
            if (checkUnsupportedVersionException && 31 < i4) {
                throw new SpenSDocUnsupportedVersionException(AbstractC0541b.m767i(this.minimumFormatVersion, "current code version[31] can not support this file[", "]."));
            }
            if (getCurrentFormatVersion() >= 8) {
                this.mCreatedTime = raf.readLong();
            }
            if (getCurrentFormatVersion() >= 9) {
                this.uncompressedSize = raf.readLong();
            }
            if (getCurrentFormatVersion() >= 11) {
                this.mTitle = readString(raf);
            }
            if (getCurrentFormatVersion() >= 24) {
                this.fileCreatedTime = raf.readLong();
            }
            if (getCurrentFormatVersion() >= 24) {
                this.mFileModifiedTime = raf.readLong();
            }
            if (getCurrentFormatVersion() >= 26) {
                this.mMadeOsType = raf.readInt();
            }
            if (getCurrentFormatVersion() >= 30) {
                this.titleAlignment = raf.readInt();
            }
            if (getCurrentFormatVersion() >= 31) {
                this.mAppVersion = readString(raf);
            }
            raf.seek(this.mStartPosition + ((long) i));
            if ((this.mFieldCheckFlag & 1) != 0) {
                this.encryptionSize = raf.readInt();
                int i5 = raf.readInt();
                byte[] bArr = new byte[i5];
                this.encryptionSalt = bArr;
                int i6 = raf.read(bArr);
                if (i6 != i5) {
                    Log.d(TAG, AbstractC0622a.m1164j(i5, i6, "readFile() - E1 read fail. expected [", "], actually [", "]"));
                }
                int i7 = raf.readInt();
                byte[] bArr2 = new byte[i7];
                this.encryptionIv = bArr2;
                int i8 = raf.read(bArr2);
                if (i8 != i7) {
                    Log.d(TAG, AbstractC0622a.m1164j(i7, i8, "readFile() - E2 read fail. expected [", "], actually [", "]"));
                }
                int i9 = raf.readInt();
                byte[] bArr3 = new byte[i9];
                this.encryptionKey = bArr3;
                int i10 = raf.read(bArr3);
                if (i10 != i9) {
                    Log.d(TAG, AbstractC0622a.m1164j(i9, i10, "readFile() - E3 read fail. expected [", "], actually [", "]"));
                }
            }
            readDocumentType(raf);
            readReminderData(raf);
            readTitleSpanData(raf);
            Log.d(TAG, "readFile() end");
            return;
        }
        throw new SpenSDocUnsupportedFileException(AbstractC0541b.m767i(getCurrentFormatVersion(), "Unsupported format version[", "]!!"));
    }
}
