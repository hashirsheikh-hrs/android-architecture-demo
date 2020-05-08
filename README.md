## android-architecture-demo

Demo with following utilities.

```gradle
//retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.8.1'
    implementation "com.squareup.retrofit2:converter-moshi:2.4.0"
    implementation 'com.squareup.okhttp3:logging-interceptor:4.5.0'

    //room start
    def room_version = '2.2.5'
    implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    implementation "androidx.room:room-ktx:$room_version" //support for kotlin coroutines
    testImplementation "androidx.room:room-testing:$room_version"

    //livedata viewmodel start
    def lifecycle_version = "2.2.0"
    def arch_version = "2.1.0"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // Saved state module for ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
    testImplementation "androidx.arch.core:core-testing:$arch_version"

    def coroutVer = "1.3.0"
    //coroutiens
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutVer"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutVer"

    //glide
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    kapt 'com.github.bumptech.glide:compiler:4.11.0'

    //moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.9.2")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.2")

    //dagger
    def dagger_version = "2.27"
    implementation "com.google.dagger:dagger:$dagger_version"
    kapt "com.google.dagger:dagger-compiler:$dagger_version"
```

##If somewhere I am wrong anyone can take a pull and submit pull request with comments.

I tried to implement MVVM-repository pattern with clean architecture concept.

Thanks
