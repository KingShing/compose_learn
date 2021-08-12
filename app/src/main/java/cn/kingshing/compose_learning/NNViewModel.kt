package cn.kingshing.compose_learning

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 *
 * Created by kingshingyeh on 2021/8/11.
 */
class NNViewModel : ViewModel() {
    /**
     * 是否是黑肤
     */
    var isSkinBlack by mutableStateOf(true)
}