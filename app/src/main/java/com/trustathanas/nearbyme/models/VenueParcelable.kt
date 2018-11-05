package com.trustathanas.nearbyme.models

import android.os.Parcel
import android.os.Parcelable

class VenueParcelable(val venueId: String, val venueName: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(venueId)
        dest.writeString(venueName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VenueParcelable> {
        override fun createFromParcel(parcel: Parcel): VenueParcelable {
            return VenueParcelable(parcel)
        }

        override fun newArray(size: Int): Array<VenueParcelable?> {
            return arrayOfNulls(size)
        }
    }
}