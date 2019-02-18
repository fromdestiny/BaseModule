package petaz.co.kr.sallim9dan

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import petaz.co.kr.sallim9dan.base.BasePresenter
import petaz.co.kr.sallim9dan.base.PresenterActivity
import petaz.co.kr.sallim9dan.module.ActivityModule
import petaz.co.kr.sallim9dan.module.ActivityPresenterModule
import javax.inject.Inject

class MainActivity : PresenterActivity<MainPresenter.View>(), MainPresenter.View {


    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getPresenter(): BasePresenter<MainPresenter.View>? {
        return  presenter
    }

    override fun inject() {
        DaggerActivityComponent.builder()
                .appComponent(MyApp.getAppComponent(this))
                .activityModule(ActivityModule(this))
                .activityPresenterModule(ActivityPresenterModule())
                .build().inject(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgress() {
    }



    override fun hideProgress() {
    }



    override fun showErrorView(msg: String) {
    }




}
