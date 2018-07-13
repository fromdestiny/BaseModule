package petaz.co.kr.sallim9dan

import dagger.Component
import petaz.co.kr.sallim9dan.module.ApiModule

@UserScope
@Component(dependencies = [(AppComponent::class)], modules = [(ApiModule::class)])
interface ServiceComponent {
    //fun inject(context: MyService)
}