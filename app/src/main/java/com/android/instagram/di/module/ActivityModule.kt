package com.android.instagram.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.instagram.data.repository.DummyRepository
import com.android.instagram.data.repository.UserRepository
import com.android.instagram.ui.base.BaseActivity
import com.android.instagram.ui.dummy.DummyViewModel
import com.android.instagram.ui.login.LoginViewModel
import com.android.instagram.ui.splash.SplashViewModel
import com.android.instagram.utils.ViewModelProviderFactory
import com.android.instagram.utils.network.NetworkHelper
import com.android.instagram.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideDummyViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        dummyRepository: DummyRepository
    ): DummyViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(DummyViewModel::class) {
            DummyViewModel(schedulerProvider, compositeDisposable, networkHelper, dummyRepository)
        }).get(DummyViewModel::class.java)


    @Provides
    fun provideLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        userRepository: UserRepository,
        networkHelper: NetworkHelper
    ): LoginViewModel = ViewModelProviders.of(activity, ViewModelProviderFactory(LoginViewModel::class) {

        LoginViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
    }).get(LoginViewModel::class.java)

}