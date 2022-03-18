package fastcampus.aop.part2.airbnb

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/24aa3eb8-e4fe-42df-a5a4-af86b604dde7")
    fun getHouseList(): Call<HouseDto>
}