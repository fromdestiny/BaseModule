package petaz.co.kr.sallim9dan.base

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException

abstract class BasePresenter<T> {
    private var disposables: CompositeDisposable? = CompositeDisposable()
    abstract var view: T?

    @CallSuper
    open fun onCreate() {}

    @CallSuper
    open fun onResume() {}

    @CallSuper
    open fun onPause() {}

    @CallSuper
    open fun onStop() {}

    @CallSuper
    fun onDestroy() {
        disposables?.clear()
        disposables = null
        view = null
    }

    protected fun isTimeoutError(throwable: Throwable): Boolean {
        return throwable is SocketTimeoutException
    }

//    protected fun getPageParams(pagination: Pagination<Pageable>): MutableMap<String, String> {
//        val params: MutableMap<String, String> = mutableMapOf()
//        params[ApiQueryParam.PAGE] = pagination.pageNum.toString()
//        params[ApiQueryParam.PER_PAGE] = pagination.pageSize.toString()
//        return params
//    }

    protected fun addToDisposable(disposable: Disposable) {
        disposables?.add(disposable)
    }
    protected fun clearToDisposable(){
        disposables?.clear()
    }
}