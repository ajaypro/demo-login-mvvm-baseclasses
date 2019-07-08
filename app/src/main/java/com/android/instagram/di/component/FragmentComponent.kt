package com.android.instagram.di.component

import com.android.instagram.di.FragmentScope
import com.android.instagram.di.module.FragmentModule
import com.android.instagram.ui.dummies.DummiesFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: DummiesFragment)
}