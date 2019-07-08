package com.android.instagram.ui.dummy

import com.android.instagram.data.repository.DummyRepository
import com.android.instagram.ui.base.BaseViewModel
import com.android.instagram.utils.network.NetworkHelper
import com.android.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class DummyViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val dummyRepository: DummyRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        // do something
    }
}