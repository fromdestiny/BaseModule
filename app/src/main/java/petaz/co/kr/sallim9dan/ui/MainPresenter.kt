package petaz.co.kr.sallim9dan

import android.content.Context
import android.support.v7.app.AppCompatActivity
import petaz.co.kr.sallim9dan.module.ApiModule
import petaz.co.kr.sallim9dan.base.BasePresenter
import petaz.co.kr.sallim9dan.base.LoadingType
import petaz.co.kr.sallim9dan.data.ApiService
import javax.inject.Inject


class MainPresenter constructor(context: AppCompatActivity) : BasePresenter<MainPresenter.View>() {

    @Inject
    lateinit var api: ApiService


    override var view: View? = context as View
    private var loadingType: LoadingType = LoadingType.NONE
    //private val pagination: Pagination<RepositoryResponse> = Pagination.newInstance()


    init {
        DaggerPresenterComponent.builder()
                .appComponent(MyApp.getAppComponent(context))
                .apiModule(ApiModule())
                .build().inject(this)
//        weatherRepository = DustRepository("", "", listOfNotNull(), arrayListOf())

    }


    fun refresh() {
        clearToDisposable()
    }

    fun getCurrentDust(sidoName: String, sggName: String, umdName: String) {

//        if (TextUtils.isEmpty(sidoName) && TextUtils.isEmpty(sggName) && TextUtils.isEmpty(umdName)) {
//            view?.showErrorView(view?.getContext()!!.getString(R.string.not_find_current_location))
//            Timber.e("cannot found from address VIEW")
//        } else {
//            view?.run {
//                if (loadingType == LoadingType.MORE) {
//                    showMoreProgress()
//                } else {
//                    showProgress()
//                }
//
//                db.collection(StaticValues.CURRENTDUST)
//                        .document(sidoName + sggName + umdName)
//                        .get()
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful) {
//                                var document: DocumentSnapshot = task.result
//
//                                Timber.e("getCurrentDust 1")
//                                if (document != null && document.exists()) {
//
//                                    Timber.e("getCurrentDust 2")
//                                    val currentDust = document.toObject(CurrentDust::class.java)
//
//                                    if (currentDust != null) {
//                                        Timber.e("getCurrentDust 3")
//                                        val dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:00")
//                                        var currentTime = DateTime.now().toString(dtf)
//
//                                        Timber.e("Check DB TIME  %s", currentDust.dust?.dataTime)
//                                        Timber.e("Check currentTime  %s", currentTime)
//                                        if (TextUtils.equals(currentTime, currentDust.dust?.dataTime)) {
//                                            //Note SETVIEW
//                                            view?.hideProgress()
//                                            view?.setCurrentDustView(currentDust)
//
//
//                                        } else {
//                                            //Note FIND 측정소
//                                            findApiCurrentDust(currentDust)
//
//                                        }
//                                    } else {
//                                        //Note FIND FULL LOGIC
//                                        findApiTmXTmY(sidoName, sggName, umdName)
//                                    }
//                                } else {
//                                    //Note FIND FULL LOGIC
//                                    findApiTmXTmY(sidoName, sggName, umdName)
//
//
//                                }
//                            } else {
//
//
//                                //Note FIND FULL LOGIC
//                                Timber.e("error %s", task.exception)
//                                findApiTmXTmY(sidoName, sggName, umdName)
//                            }
//                        }
//            }
//        }
    }

    private fun findApiCurrentDust() {
//        addToDisposable(RxObservableConverter
//                //.forNetwork(api.getDataCenter("1", "244148.546388", "412423.75772", "3VR08CsncWK65NEwVUHy7MloIF%2B3T7YA8gn9SreDpOO5lct6Nf1K11ODdmsn26LSNQs4egwZ1JUIKKiS6jw6tA%3D%3D"))
//                .forNetwork(api.getDust("1", currentDust.stationName, "3VR08CsncWK65NEwVUHy7MloIF%2B3T7YA8gn9SreDpOO5lct6Nf1K11ODdmsn26LSNQs4egwZ1JUIKKiS6jw6tA%3D%3D"))
//                .subscribe({
//                    if (it.getTotalCount() > 0) {
//                        //note have data
//                        currentDust.dust = it.list[0]
//
//                        writeCurrentDust(currentDust)
//
//
//
//                        view?.hideProgress()
//                        view?.setCurrentDustView(currentDust)
//                        Timber.e("findApiCurrentDust")
//                    } else {
//                        Timber.e("findApiCurrentDust no result")
//                        view?.showErrorView(view?.getContext()!!.getString(R.string.not_find_station))
//                    }
//                }
//                        , {
//                    view?.showErrorView(view?.getContext()!!.getString(R.string.server_error))
//
//                    Timber.e("findApiCurrentDust throw %s", it.message)
//                }
//                )
//        )
    }


    interface View {
        fun getContext(): Context
        fun showProgress()

        fun hideProgress()
        fun showErrorView(msg: String)
    }

}