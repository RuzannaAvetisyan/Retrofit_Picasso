package ruzanna.game.retrofit_glide_picasso

import com.google.gson.annotations.SerializedName

class Photo(
        @SerializedName("albumId") var albumId: Int?,
        @SerializedName("id") var id: Int?,
        @SerializedName("title") var title: String?,
        @SerializedName("url") var url: String?,
        @SerializedName("thumbnailUrl") var thumbnailUrl: String?
)