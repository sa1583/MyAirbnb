package fastcampus.aop.part2.airbnb

import retrofit2.Call
import retrofit2.http.GET

interface HouseService {
    @GET("/v3/76646ee3-25e8-449a-9956-02ba7366b173")
    fun getHouseList(): Call<HouseDto>
}