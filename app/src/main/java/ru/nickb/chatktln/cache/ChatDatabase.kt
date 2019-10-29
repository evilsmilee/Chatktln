package ru.nickb.chatktln.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import ru.nickb.chatktln.cache.friends.FriendsDao
import ru.nickb.chatktln.domain.friends.FriendEntity

@Database(entities = [FriendEntity::class], version = 2, exportSchema = false)
abstract class ChatDatabase: RoomDatabase() {
    abstract val friendsDao: FriendsDao

    companion object {
        @Volatile
        private var INSTANCE: ChatDatabase? = null

        fun getInstance(context: Context): ChatDatabase {

            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                        ChatDatabase::class.java,
                            "chat_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }

            return instance
        }
    }
}