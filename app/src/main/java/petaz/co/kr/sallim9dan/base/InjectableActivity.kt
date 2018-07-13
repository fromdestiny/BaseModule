package petaz.co.kr.sallim9dan.base

import android.os.Bundle

abstract class InjectableActivity : BaseActivity() {
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()
    }
}