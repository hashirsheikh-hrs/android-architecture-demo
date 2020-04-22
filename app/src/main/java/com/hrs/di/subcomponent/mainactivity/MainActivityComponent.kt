package com.hrs.di.subcomponent.mainactivity

import com.hrs.presentation.mainactivity.firstfragment.FirstFragment
import com.hrs.presentation.mainactivity.MainActivity
import dagger.Subcomponent

@MainActivityScope
@Subcomponent
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create(): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    fun inject(fragment: FirstFragment)

//    fun inject(fragment: SecondFragment)
}