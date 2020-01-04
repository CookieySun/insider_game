package kktyu.xyz.insidergame

import androidx.lifecycle.ViewModel

class ThemeConfirmationViewModel : ViewModel() {
    var theme = ""
    var buttonText = ""

    fun setButtonText(isLast: Boolean) {
        buttonText = when {
            isLast -> "マスター確認"
            else -> "次の人へ"
        }
    }
}