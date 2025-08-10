package quiz.di

import quiz.model.QuizRepository
import quiz.repository.QuizRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import api.TriviaApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizRepositoryModule {

    @Provides
    @Singleton
    fun provideQuizRepository(apiService: TriviaApiService): QuizRepository {
        return QuizRepositoryImpl(apiService)
    }
}