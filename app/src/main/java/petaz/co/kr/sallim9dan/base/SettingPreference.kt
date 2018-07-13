package petaz.co.kr.sallim9dan

import android.content.Context
import android.text.TextUtils
import petaz.co.kr.sallim9dan.base.CachedPreference
import timber.log.Timber

private const val PUSH_ENABLE = "push_enable"
private const val ADDRESS_LIST = "address_list"

/**
 * @author Leopold
 */
class SettingPreference(context: Context) : CachedPreference(context, "MYAPP") {

    fun setPushEnable(enable: Boolean) {
        put(PUSH_ENABLE, enable)
    }

    fun isPushEnable(): Boolean {
        return get(PUSH_ENABLE, false) as Boolean
    }


    fun getSavedList() : MutableList<String>{
        val addressList = get(ADDRESS_LIST , "") as String
        return TextUtils.split(addressList,",").filter { !TextUtils.isEmpty(it) }.toMutableList()
    }
    fun putSaveList(address : String){
        val fromPref = get(ADDRESS_LIST , "") as String
        val addressList = TextUtils.split(fromPref,",").toList()
        val size = addressList.filter { return@filter TextUtils.equals(it,address) }
        if(size.isEmpty()){
            put(ADDRESS_LIST , TextUtils.concat(fromPref,",",address))
        }
    }

    fun putRemoveList(address : String){
        val fromPref = get(ADDRESS_LIST , "") as String
        var addressList = TextUtils.split(fromPref,",").toList()
        val size = addressList.filter { return@filter !TextUtils.equals(it,address) }

        put(ADDRESS_LIST , size.joinToString())

    }

}