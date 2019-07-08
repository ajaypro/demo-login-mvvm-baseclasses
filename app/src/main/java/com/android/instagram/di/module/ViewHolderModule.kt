package com.android.instagram.di.module

import androidx.lifecycle.LifecycleRegistry
import com.android.instagram.di.ViewModelScope
import com.android.instagram.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}