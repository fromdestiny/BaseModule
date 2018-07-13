package petaz.co.kr.sallim9dan

import dagger.Component
import petaz.co.kr.sallim9dan.MainActivity
import petaz.co.kr.sallim9dan.module.ActivityModule
import petaz.co.kr.sallim9dan.module.ActivityPresenterModule

@UserScope
@Component(dependencies = [(AppComponent::class)], modules = [(ActivityPresenterModule::class), (ActivityModule::class)]
)
interface ActivityComponent {
    fun inject(context: MainActivity)
}