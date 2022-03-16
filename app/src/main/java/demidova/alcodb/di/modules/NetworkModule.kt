package demidova.alcodb.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import demidova.alcodb.network.AlcoApiService
import demidova.alcodb.network.NetworkStatus
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Named(NAMED_BASE_URL)
    fun provideBaseURL(): String {
        return "https://www.thecocktaildb.com/api/json/v1/1/"
    }

    @Provides
    @Singleton
    fun alcoApiService(retrofit: Retrofit): AlcoApiService {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    @Singleton
    fun retrofit(gson: Gson, okHttpClient: OkHttpClient,@Named(NAMED_BASE_URL) baseURL: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkStatus(context: Context): NetworkStatus {
        return NetworkStatus(context)
    }

    companion object {

        private const val NAMED_BASE_URL = "baseUrl"
    }
}