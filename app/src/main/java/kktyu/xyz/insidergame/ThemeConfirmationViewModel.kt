package kktyu.xyz.insidergame

import androidx.lifecycle.ViewModel

class ThemeConfirmationViewModel : ViewModel() {
    fun setButtonText(isLast: Boolean): String = when {
        isLast -> "マスター確認"
        else -> "次の人へ"
    }
}