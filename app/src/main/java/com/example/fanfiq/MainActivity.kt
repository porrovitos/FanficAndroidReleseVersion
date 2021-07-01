package com.example.fanfiq


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fanfiq.adapters.AddAdapter
import com.example.fanfiq.adapters.AllFanficAdapter
import com.example.fanfiq.models.AddModel
import com.example.fanfiq.models.OneFinfic
import com.example.fanfiq.requests.CreateFanficRequest
import com.example.fanfiq.requests.LoginRequest
import com.example.fanfiq.requests.RegistrationRequest
import com.example.fanfiq.responses.CreateFanficResponse
import com.example.fanfiq.responses.GetAllFanficsResponse
import com.example.fanfiq.responses.LoginResponse
import com.example.fanfiq.responses.RegistrationResponse
import com.example.fanfiq.utils.SessionManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.row_show_fanfic.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), AllFanficAdapter.OnItemClickListener {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    var createFanficList = mutableListOf<AddModel>()
    var LoadFanficList = mutableListOf<OneFinfic>()
    var adapter: AllFanficAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkConnection()
    }

    fun checkConnection() {
        val manager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
        val networkInfo = manager.activeNetworkInfo;

        sessionManager = SessionManager(this)

        if (networkInfo == null) {
            setFrag(R.id.connectionFragment)
        } else {
            if (sessionManager.fetchAuthToken() != "logout") {
                setFrag(R.id.navigation_home)
                navMenu(true)
            }
        }


    }

    fun logout() {
        sessionManager.saveAuthToken("logout")
        navMenu(false)
        setFrag(R.id.navigation_sigin)
    }

    fun TitleAndText(title: String, text: String, clear: Boolean) {
        var listview: ListView = findViewById(R.id.ListViewWithAllCreate)
        if (!clear) {
            val titleString: EditText = findViewById(R.id.input_subtitle_add)
            val textString: EditText = findViewById(R.id.input_subtext_add)
            titleString.text.clear()
            textString.text.clear()
            createFanficList.add(AddModel(title = title, text = text))
        } else {
            createFanficList.clear()
        }
        listview.adapter = AddAdapter(
                this,
                R.layout.row_add_fanfic,
                createFanficList)
    }

    fun login(username: String, password: String) {
        apiClient = ApiClient()
        apiClient.getApiService().login(LoginRequest(username = username, password = password))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        setFrag(R.id.errorFragment)
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        val loginResponse = response.body()
                        val loginResponseStatus = response.raw()
                        if (loginResponseStatus.code == 200) {
                            if (loginResponse != null) {
                                sessionManager.saveAuthToken(loginResponse.authToken)
                                sessionManager.saveEmail(loginResponse.user.email)
                                sessionManager.saveUsername(loginResponse.user.username)
                                setFrag(R.id.navigation_home)
                                navMenu(true)
                            }
                        } else {
                            val text = "Erro to login"
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)

                            toast.show()
                        }
                    }
                })
    }

    internal fun registration(username: String, password: String, email: String) {
        apiClient = ApiClient()
        apiClient.getApiService().registration(RegistrationRequest(username = username, password = password, email = email))
                .enqueue(object : Callback<RegistrationResponse> {
                    override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                        setFrag(R.id.errorFragment)
                    }

                    override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                        val RegistrationResponseStatus = response.raw()

                        if (RegistrationResponseStatus?.code == 200) {
                            setFrag(R.id.navigation_sigin)
                        } else {
                            val text = "Erro to register/ Change NickName or Email"
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)

                            toast.show()
                        }
                    }
                })
    }

    fun navMenu(show: Boolean) {

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        if (show) {
            navView.visibility = View.VISIBLE
        } else {
            navView.visibility = View.INVISIBLE
        }
    }

    fun setFrag(nextFrag: Int) {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigateUp()
        navController.navigate(nextFrag)
    }

    fun createFanfic(fanfic_name: String) {
        apiClient = ApiClient()
        var username = sessionManager.fetchUsername().toString()
        var fanfic = createFanficBody()
        apiClient.getApiService().createFanfic(CreateFanficRequest(fanfic_name = fanfic_name, creator_username = username, fanfic = fanfic))
                .enqueue(object : Callback<CreateFanficResponse> {
                    override fun onFailure(call: Call<CreateFanficResponse>, t: Throwable) {
                        setFrag(R.id.errorFragment)
                    }

                    override fun onResponse(call: Call<CreateFanficResponse>, response: Response<CreateFanficResponse>) {
                        val RegistrationResponseStatus = response.raw()

                        if (RegistrationResponseStatus?.code == 200) {
                            val titleString: EditText = findViewById(R.id.input_subtitle_add)
                            val nameString: EditText = findViewById(R.id.input_create_fancif_name)
                            val textString: EditText = findViewById(R.id.input_subtext_add)

                            titleString.text.clear()
                            nameString.text.clear()
                            textString.text.clear()
                            TitleAndText("", "", true)
                        } else {
                            val text = "Erro to save"
                            val duration = Toast.LENGTH_SHORT
                            val toast = Toast.makeText(applicationContext, text, duration)
                            toast.show()
                        }
                    }
                })
    }

    fun createFanficBody(): String {
        var fanficBody = ""
        for (i in createFanficList) {
            fanficBody += i.title
            fanficBody += ":;!"
            fanficBody += i.text
            fanficBody += ":;!"
        }
        return fanficBody
    }

    fun getFanfics() {
        apiClient = ApiClient()
        apiClient.getApiService().getAllFanfics()
                .enqueue(object : Callback<List<GetAllFanficsResponse>> {
                    override fun onFailure(call: Call<List<GetAllFanficsResponse>>, t: Throwable) {
                        setFrag(R.id.errorFragment)
                    }

                    override fun onResponse(call: Call<List<GetAllFanficsResponse>>, response: Response<List<GetAllFanficsResponse>>) {
                        val RegistrationResponseStatus = response.raw()
                        if (RegistrationResponseStatus?.code == 200) {
                            shapingRecyclerViewAllFanfic(response.body())
                            val fanficsAdapter = AllFanficAdapter(LoadFanficList, this@MainActivity)
                            fanfics_home.adapter = fanficsAdapter
                            fanfics_home.layoutManager = LinearLayoutManager(this@MainActivity)
                        } else {
                        }
                    }
                })
    }

    fun shapingRecyclerViewAllFanfic(body: List<GetAllFanficsResponse>?) {
        body?.forEach {
            val fanficText = setDetailsFanfic(it.fanfic)
            LoadFanficList.add(OneFinfic(name = it.fanfic_name, dateTime = it.creation_date, author = it.creator_username, id = it.id, fanfic = fanficText))
        }
    }

    override fun onItemClick(id: Int, itemView: View) {
        if (itemView.fanfic_text_show.isVisible) {
            itemView.fanfic_text_show.visibility = View.GONE
        } else {
            itemView.fanfic_text_show.visibility = View.VISIBLE
        }
    }

    fun setDetailsFanfic(fanfic: String?): String {
        var body = ""
        var i = 1
        var fanficBody = fanfic?.split(":;!")?.toTypedArray()
        fanficBody?.forEach {
            if (i % 2 == 0) {
                body += "  $it"
                body += "\n"
            } else {
                body += it
                body += "\n"
            }
            i++
        }
        return body
    }
}