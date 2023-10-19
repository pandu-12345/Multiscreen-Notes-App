package com.example.fragment_app.Data.Entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity("NOTES_LIST")
@Parcelize
data class Notes(
   var title:String, var des:String, @PrimaryKey(true)
    var id:Int=0):Parcelable
