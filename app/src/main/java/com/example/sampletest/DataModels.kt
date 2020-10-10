package com.example.sampletest

import com.google.gson.annotations.SerializedName


data class Example(
    @SerializedName("username")
    var username: String?,

    @SerializedName("displayname")
    var displayname: String?,

    @SerializedName("text")
    var text: String?,

    @SerializedName("postedAt")
    var postedAt: String?,

    @SerializedName("postLevel")
    var postLevel: Int,

    @SerializedName("likes")
    var likes: Int,

    @SerializedName("shares")
    var shares: Int,

    @SerializedName("replies")
    var replies: List<Example>
)


data class Reply(
    @SerializedName("username")
    var username: String,

    @SerializedName("displayname")
    var displayname: String,

    @SerializedName("text")
    var text: String,

    @SerializedName("postedAt")
    var postedAt: String,

    @SerializedName("likes")
    var likes: Int,

    @SerializedName("shares")
    var shares: Int,

    @SerializedName("postLevel")
    var postLevel: Int,

    @SerializedName("replies")
    var replies: List<Reply>
)