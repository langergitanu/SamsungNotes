package com.samsung.android.app.sdk.deepsky.textextraction.action.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.scsp.common.Header;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J@\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u0019H\u0016R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/ScheduleAction;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/action/data/Action;", "context", "Landroid/content/Context;", Bixby2Constants.BIXBY_PARAM_IMAGE_URI, "Landroid/net/Uri;", "info", "Lcom/google/gson/JsonObject;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/google/gson/JsonObject;)V", "iconUri", "getIconUri", "()Landroid/net/Uri;", Header.LOCATION, "", "getLocation", "()Ljava/lang/String;", "location$delegate", "Lkotlin/Lazy;", Privacy.KEY_NOTES, "getNotes", "notes$delegate", "title", DynamicActionBarProvider.METHOD_GET_DATA, "checkValidTime", "Lkotlin/Pair;", "", "time", "getStringTimeToInt", "", "key", "initLocation", "initNotes", "putEndTime", "", "calendarIntent", "Landroid/content/Intent;", "putStartTime", "putTimeToIntent", "year", "month", "day", "hour", VElementFormulasCmd.FMIN, "runAction", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScheduleAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleAction.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/action/data/ScheduleAction\n+ 2 CharSequence.kt\nandroidx/core/text/CharSequenceKt\n*L\n1#1,173:1\n28#2:174\n*S KotlinDebug\n*F\n+ 1 ScheduleAction.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/action/data/ScheduleAction\n*L\n121#1:174\n*E\n"})
public final class ScheduleAction extends Action {

    /* JADX INFO: renamed from: AM */
    @NotNull
    private static final String f4742AM = "am";

    @NotNull
    public static final String CALENDAR_PACKAGE_URI = "content://com.android.calendar/events";

    @NotNull
    private static final String JSON_KEY_END_DAY = "EndDay";

    @NotNull
    private static final String JSON_KEY_END_MONTH = "EndMonth";

    @NotNull
    private static final String JSON_KEY_END_PLACE = "EndPlace";

    @NotNull
    private static final String JSON_KEY_END_TIME = "EndTime";

    @NotNull
    private static final String JSON_KEY_END_YEAR = "EndYear";

    @NotNull
    private static final String JSON_KEY_RESERVATION_NUMBER = "ReservationNumber";

    @NotNull
    private static final String JSON_KEY_START_DAY = "StartDay";

    @NotNull
    private static final String JSON_KEY_START_MONTH = "StartMonth";

    @NotNull
    private static final String JSON_KEY_START_PLACE = "StartPlace";

    @NotNull
    private static final String JSON_KEY_START_TIME = "StartTime";

    @NotNull
    private static final String JSON_KEY_START_YEAR = "StartYear";

    @NotNull
    private static final String JSON_KEY_TITLE = "Title";

    /* JADX INFO: renamed from: NA */
    @NotNull
    private static final String f4743NA = "N/A";

    /* JADX INFO: renamed from: PM */
    @NotNull
    private static final String f4744PM = "pm";

    @NotNull
    private static final String TAG = "ScheduleAction";

    @NotNull
    private static final String TIME_DELIMITERS = ":";

    @NotNull
    private final Uri iconUri;

    /* JADX INFO: renamed from: location$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy location;

    /* JADX INFO: renamed from: notes$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy notes;

    @NotNull
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduleAction(@NotNull Context context, @NotNull Uri imageUri, @NotNull JsonObject info) {
        super(context, imageUri, info);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        Intrinsics.checkNotNullParameter(info, "info");
        this.iconUri = getResourceUri(C7039R.drawable.capsule_calendar, context);
        String string = context.getString(C7039R.string.add_to_calendar);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.add_to_calendar)");
        this.title = string;
        this.notes = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.action.data.ScheduleAction$notes$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return this.this$0.initNotes();
            }
        });
        this.location = LazyKt.lazy(new Function0<String>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.action.data.ScheduleAction$location$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return this.this$0.initLocation();
            }
        });
    }

    private final Pair<String, Boolean> checkValidTime(String time) {
        if (time == null || time.length() == 0) {
            return new Pair<>("00:00", Boolean.FALSE);
        }
        if (StringsKt.m14162r(time, f4743NA)) {
            return new Pair<>("00:00", Boolean.FALSE);
        }
        Pattern patternCompile = Pattern.compile("[am|pm]", 2);
        Pattern patternForPm = Pattern.compile(f4744PM, 2);
        String strReplaceAll = patternCompile.matcher(time).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(strReplaceAll, "matcher.replaceAll(\"\")");
        String string = StringsKt.trim((CharSequence) strReplaceAll).toString();
        Intrinsics.checkNotNullExpressionValue(patternForPm, "patternForPm");
        return new Pair<>(string, Boolean.valueOf(new Regex(patternForPm).containsMatchIn(time)));
    }

    private final String getLocation() {
        return (String) this.location.getValue();
    }

    private final String getNotes() {
        return (String) this.notes.getValue();
    }

    private final int getStringTimeToInt(String key) {
        JsonElement jsonElement = getInfo().get(key);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null || Intrinsics.areEqual(asString, f4743NA) || !TextUtils.isDigitsOnly(asString)) {
            return -1;
        }
        return Integer.parseInt(asString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String initLocation() {
        JsonElement jsonElement = getInfo().get(JSON_KEY_START_PLACE);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null) {
            asString = f4743NA;
        }
        JsonElement jsonElement2 = getInfo().get(JSON_KEY_END_PLACE);
        String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
        if (asString2 == null) {
            asString2 = f4743NA;
        }
        return StringsKt.trim((CharSequence) StringsKt.m14139M(asString + " " + asString2, f4743NA, "")).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String initNotes() {
        JsonElement jsonElement = getInfo().get(JSON_KEY_RESERVATION_NUMBER);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        if (asString == null) {
            asString = f4743NA;
        }
        return Intrinsics.areEqual(asString, f4743NA) ? "" : asString;
    }

    private final void putEndTime(Intent calendarIntent) {
        int i;
        int i2;
        int stringTimeToInt = getStringTimeToInt(JSON_KEY_END_YEAR);
        int stringTimeToInt2 = getStringTimeToInt(JSON_KEY_END_MONTH);
        int stringTimeToInt3 = getStringTimeToInt(JSON_KEY_END_DAY);
        JsonElement jsonElement = getInfo().get(JSON_KEY_END_TIME);
        Pair<String, Boolean> pairCheckValidTime = checkValidTime(jsonElement != null ? jsonElement.getAsString() : null);
        String strComponent1 = pairCheckValidTime.component1();
        boolean zBooleanValue = pairCheckValidTime.component2().booleanValue();
        int i4 = 0;
        if (Intrinsics.areEqual(strComponent1, f4743NA)) {
            i = 0;
        } else {
            List listSplit$default = StringsKt__StringsKt.split$default(strComponent1, new String[]{":"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                int i5 = Integer.parseInt((String) listSplit$default.get(0));
                if (i5 < 12 && zBooleanValue) {
                    i5 += 12;
                }
                i4 = i5;
                i2 = Integer.parseInt((String) listSplit$default.get(1));
            } else {
                i2 = 0;
            }
            i = i4;
            i4 = i2;
        }
        putTimeToIntent(stringTimeToInt, stringTimeToInt2, stringTimeToInt3, i, i4, calendarIntent, "endTime");
    }

    private final void putStartTime(Intent calendarIntent) {
        int i;
        int i2;
        int stringTimeToInt = getStringTimeToInt(JSON_KEY_START_YEAR);
        int stringTimeToInt2 = getStringTimeToInt(JSON_KEY_START_MONTH);
        int stringTimeToInt3 = getStringTimeToInt(JSON_KEY_START_DAY);
        JsonElement jsonElement = getInfo().get(JSON_KEY_START_TIME);
        String asString = jsonElement != null ? jsonElement.getAsString() : null;
        Pair<String, Boolean> pairCheckValidTime = checkValidTime(asString);
        String strComponent1 = pairCheckValidTime.component1();
        boolean zBooleanValue = pairCheckValidTime.component2().booleanValue();
        int i4 = 0;
        if (Intrinsics.areEqual(strComponent1, f4743NA)) {
            i = 0;
        } else {
            List listSplit$default = StringsKt__StringsKt.split$default(strComponent1, new String[]{":"}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                i4 = Integer.parseInt((String) listSplit$default.get(0));
                if (i4 < 12 && zBooleanValue) {
                    i4 += 12;
                }
                i2 = Integer.parseInt((String) listSplit$default.get(1));
            } else {
                i2 = 0;
            }
            i = i2;
        }
        Log.d(TAG, AbstractC0541b.m775q("valid Time = ", strComponent1, " (original data was ", asString, ")"));
        putTimeToIntent(stringTimeToInt, stringTimeToInt2, stringTimeToInt3, i4, i, calendarIntent, "beginTime");
    }

    private final void putTimeToIntent(int year, int month, int day, int hour, int min, Intent calendarIntent, String key) {
        if (CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(min)}).contains(-1)) {
            return;
        }
        try {
            calendarIntent.putExtra(key, LocalDateTime.of(year, month, day, hour, min).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        } catch (DateTimeException e) {
            Log.e(TAG, "Exception during convert date/time : " + e);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.samsung.android.app.sdk.deepsky.textextraction.action.data.Action
    public boolean runAction() {
        LibLogger.m5432i(TAG, "runAction");
        Intent intent = new Intent("android.intent.action.INSERT", Uri.parse(CALENDAR_PACKAGE_URI));
        JsonElement jsonElement = getInfo().get(JSON_KEY_TITLE);
        if (jsonElement != null) {
            Intrinsics.checkNotNullExpressionValue(jsonElement, "get(JSON_KEY_TITLE)");
            intent.putExtra("title", jsonElement.getAsString());
        }
        intent.putExtra("eventLocation", getLocation());
        putStartTime(intent);
        putEndTime(intent);
        intent.putExtra("description", getNotes());
        intent.putExtra("allDay", false);
        intent.setFlags(268435456);
        getContext().startActivity(intent);
        return true;
    }
}
