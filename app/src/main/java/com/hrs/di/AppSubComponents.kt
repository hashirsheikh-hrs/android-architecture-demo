package com.hrs.di

import com.hrs.di.subcomponent.mainactivity.MainActivityComponent
import dagger.Module

@Module(subcomponents = [MainActivityComponent::class])
class AppSubComponents {
}