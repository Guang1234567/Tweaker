package com.rw.tweaks.prefs.secure.specific

import android.content.Context
import android.provider.Settings
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.preference.DialogPreference
import com.rw.tweaks.R
import com.rw.tweaks.util.ISecurePreference
import com.rw.tweaks.util.ISpecificPreference
import com.rw.tweaks.util.SecurePreference
import com.rw.tweaks.util.SettingsType

class SMSLimitsPreference(context: Context, attrs: AttributeSet) : DialogPreference(context, attrs), ISecurePreference by SecurePreference(context), ISpecificPreference {
    override var type: SettingsType = SettingsType.GLOBAL
    override val keys: Array<String> = arrayOf(
        Settings.Global.SMS_OUTGOING_CHECK_INTERVAL_MS,
        Settings.Global.SMS_OUTGOING_CHECK_MAX_COUNT
    )

    init {
        key = "sms_limits"

        setTitle(R.string.feature_sms_limit)
        setSummary(R.string.feature_sms_limit_desc)

        dialogTitle = title
        dialogMessage = summary
        setIcon(R.drawable.message_text_lock)
        iconColor = ContextCompat.getColor(context, R.color.pref_color_6)

        init(this)
    }
}