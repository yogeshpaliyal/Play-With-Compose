package com.vivek.clubhouseclone.data.model

import com.vivek.clubhouseclone.R

data class User(
    val id: Int,
    val photo: Int,
    val name: String,
    val followers: Int,
    val following: Int,
    val about: String,
    val twitter: String,
    val instagram: String,
)

fun getMyProfile(): User {
    return User(
        id = 0,
        photo = R.drawable.profile,
        name = "Vivek",
        followers = 10,
        following = 1000,
        about = "This is Vivek Sharma",
        twitter = "V9vek",
        instagram = "v9vek"
    )
}

fun getUsers(): MutableList<User> {
    return mutableListOf(
        User(
            id = 1,
            photo = R.drawable.user_1,
            name = "Josh",
            followers = 1000,
            following = 10,
            about = "This is Jake Wharton",
            twitter = "Jake_Wharton",
            instagram = "Jake_Wharton"
        ),
        User(
            id = 2,
            photo = R.drawable.user_2,
            name = "Christine",
            followers = 200,
            following = 20,
            about = "This is Mitch Tabian",
            twitter = "Mitch_Tabian",
            instagram = "Mitch_Tabian"
        ),
        User(
            id = 3,
            photo = R.drawable.user_3,
            name = "Maggie",
            followers = 340,
            following = 2,
            about = "This is Philipp Lackner",
            twitter = "Philipp_Lackner",
            instagram = "Philipp_Lackner"
        ),
        User(
            id = 4,
            photo = R.drawable.user_4,
            name = "Perez",
            followers = 2040,
            following = 12,
            about = "This is Florian Walther",
            twitter = "Florian_Walther",
            instagram = "Florian_Walther"
        ),

        User(
            id = 5,
            photo = R.drawable.user_5,
            name = "Ryan",
            followers = 3540,
            following = 123,
            about = "This is Ryan",
            twitter = "Ryan",
            instagram = "Ryan"
        ),
    )
}

fun getOtherSpeakers(): MutableList<User> {
    return mutableListOf(
        User(
            id = 6,
            photo = R.drawable.user_1,
            name = "Josh",
            followers = 1000,
            following = 10,
            about = "This is Josh",
            twitter = "Josh_Wharton",
            instagram = "Josh_Wharton"
        ),
        User(
            id = 7,
            photo = R.drawable.user_2,
            name = "Christine",
            followers = 200,
            following = 20,
            about = "This is Christine",
            twitter = "Christine",
            instagram = "Christine"
        ),
        User(
            id = 8,
            photo = R.drawable.user_3,
            name = "Maggie",
            followers = 340,
            following = 2,
            about = "This is Maggie",
            twitter = "Maggie",
            instagram = "Maggie"
        ),
        User(
            id = 9,
            photo = R.drawable.user_4,
            name = "Perez",
            followers = 2040,
            following = 12,
            about = "This is Perez",
            twitter = "Perez",
            instagram = "Perez"
        ),
        User(
            id = 10,
            photo = R.drawable.user_5,
            name = "Ryan",
            followers = 3540,
            following = 123,
            about = "This is Ryan",
            twitter = "Ryan",
            instagram = "Ryan"
        ),
        User(
            id = 11,
            photo = R.drawable.user_6,
            name = "Jake",
            followers = 1000,
            following = 10,
            about = "This is Jake Wharton",
            twitter = "Jake_Wharton",
            instagram = "Jake_Wharton"
        ),
        User(
            id = 12,
            photo = R.drawable.user_7,
            name = "Mitch",
            followers = 200,
            following = 20,
            about = "This is Mitch Tabian",
            twitter = "Mitch_Tabian",
            instagram = "Mitch_Tabian"
        ),
        User(
            id = 13,
            photo = R.drawable.user_8,
            name = "Philipp",
            followers = 340,
            following = 2,
            about = "This is Philipp Lackner",
            twitter = "Philipp_Lackner",
            instagram = "Philipp_Lackner"
        ),
        User(
            id = 14,
            photo = R.drawable.user_9,
            name = "Florian",
            followers = 2040,
            following = 12,
            about = "This is Florian Walther",
            twitter = "Florian_Walther",
            instagram = "Florian_Walther"
        ),
        User(
            id = 15,
            photo = R.drawable.user_10,
            name = "Ryan",
            followers = 3540,
            following = 123,
            about = "This is Ryan",
            twitter = "Ryan",
            instagram = "Ryan"
        ),
    )
}
