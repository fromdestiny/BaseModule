package petaz.co.kr.sallim9dan.data.model

import com.squareup.moshi.Json
//GRADE 1 (좋음) , 2 (보통) , 3(나쁨), 4(매우나쁨)
data class  Dust(@Json(name = "dataTime") var dataTime: String =""
                , @Json(name = "mangName") var mangName: String=""
                   //아황산가스 농도 (ppm)
                , @Json(name = "so2Value") var so2Value: String=""
                    //일산화탄소 농도 (ppm)
                , @Json(name = "coValue") var coValue: String=""
                    //오존 농도 (ppm)
                , @Json(name = "o3Value") var o3Value: String=""
                   //일산화질소 농도
                , @Json(name = "no2Value") var no2Value: String=""
                   //미세먼지 PM10
                , @Json(name = "pm10Value") var pm10Value: String=""
                   //PM10 24시간 예측농도
                , @Json(name = "pm10Value24") var pm10Value24: String=""
                , @Json(name = "pm25Value") var pm25Value: String=""
                , @Json(name = "pm25Value24") var pm25Value24: String=""
                   //통합 대기환경 수치
                , @Json(name = "khaiValue") var khaiValue: String=""
                    //통합 대기환경 지수
                , @Json(name = "khaiGrade") var khaiGrade: String=""
                    //아황산가스 지수
                , @Json(name = "so2Grade") var so2Grade: String=""
                    //일산화탄소 지수
                , @Json(name = "coGrade") var coGrade: String=""
                , @Json(name = "o3Grade") var o3Grade: String=""
                , @Json(name = "no2Grade") var no2Grade: String=""
                , @Json(name = "pm10Grade") var pm10Grade: String=""
                , @Json(name = "pm25Grade") var pm25Grade: String=""
                , @Json(name = "pm10Grade1h") var pm10Grade1h: String=""
                , @Json(name = "pm25Grade1h") var pm25Grade1h: String=""

)