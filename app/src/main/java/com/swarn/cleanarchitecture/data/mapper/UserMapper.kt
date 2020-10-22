package com.swarn.cleanarchitecture.data.mapper

import com.swarn.cleanarchitecture.data.response.UserResponse
import com.swarn.cleanarchitecture.domain.model.User
import javax.inject.Inject

/**
 * @author Swarn Singh.
 */
class UserMapper @Inject constructor() {

    fun map(userResponse: UserResponse): User {
        return User(
            address = User.Address(
                city = userResponse.address.city,
                street = userResponse.address.street,
                suite = userResponse.address.suite,
                zipcode = userResponse.address.zipcode,
                geo = User.Address.Geo(
                    lat = userResponse.address.geo.lat,
                    lng = userResponse.address.geo.lng
                )
            ),
            company = User.Company(
                bs = userResponse.company.bs,
                catchPhrase = userResponse.company.catchPhrase,
                name = userResponse.company.name
            ),
            email = userResponse.email,
            id = userResponse.id,
            username = userResponse.username,
            phone = userResponse.phone,
            name = userResponse.name,
            website = userResponse.website
        )
    }

}