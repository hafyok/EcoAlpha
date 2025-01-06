import com.example.ecoalpha.data.BinCardInfo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("42764000")
    fun getCardData(): Call<BinCardInfo>
}