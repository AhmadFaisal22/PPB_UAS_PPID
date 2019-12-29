package com.example.tugasppb.page_berita

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasppb.R
import com.example.tugasppb.model.ListBerita
import com.example.tugasppb.network.APIUtils
import com.example.tugasppb.network.RetrofitClient
import com.example.tugasppb.utils.ReqBody
import com.example.tugasppb.utils.ThreadPolicy
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_berita_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaDetail : AppCompatActivity() {
    lateinit var bottomDialog: BeritaForm
    var berita: ListBerita? = null
    var position: Int? = null
    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("data", berita)
        returnIntent.putExtra("position", position)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThreadPolicy.call()
        init()
        setContentView(R.layout.activity_berita_detail)
        setFunction()
        setToolbar()
        setToLayout()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun init() {
        berita = intent.getSerializableExtra("data") as ListBerita;
        position = intent.getIntExtra("position", 0)
    }

    fun setFunction() {
        fabEdit.setOnClickListener {
            bottomDialog = BeritaForm(
                { item: ListBerita ->
                    berita!!.title = item.title
                    berita!!.desc = item.desc
                    berita!!.date = item.date
                    berita!!.image = item.image
                    udpateBerita(item)
                    setToLayout()
                    Snackbar.make(coordinator, "Sukses Menambahkan", Snackbar.LENGTH_SHORT).show()
                }
                , "Ubah Berita", berita)
            bottomDialog.show(supportFragmentManager, bottomDialog!!.tag)
        }
    }


    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setToLayout() {
        findViewById<TextView>(R.id.title).text = berita!!.title
        Picasso.get().load(RetrofitClient.BASE_URL + "images/" + berita!!.image).into(image);
        desc.text = berita!!.desc
    }

    fun udpateBerita(item: ListBerita) {
        Log.d("ini===========",item.toString())
        var Call: Call<ArrayList<ListBerita>> ? = null;
        if (item.image != "null") {
            Call = APIUtils.beritaService.updBerita(
                ReqBody.setText(item.title),
                ReqBody.setText(item.desc),
                ReqBody.setText(item.date),
                ReqBody.setImage(this, Uri.parse(item.image)),
                ReqBody.setText(item.id!!)
            )
        }else{
            Call = APIUtils.beritaService.updBeritaNoImage(
                ReqBody.setText(item.title),
                ReqBody.setText(item.desc),
                ReqBody.setText(item.date),
                ReqBody.setText("empty"),
                ReqBody.setText(item.id!!)
            )
        }
        Call!!. enqueue (object :
            Callback<ArrayList<ListBerita>> {
            override fun onFailure(call: Call<ArrayList<ListBerita>>, t: Throwable) {
                Log.d("gagal oi", "---------------" + t.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<ListBerita>>,
                response: Response<ArrayList<ListBerita>>
            ) {
                berita = response.body()!!.get(0)
                setToLayout()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            Berita.PICK_IMAGE -> {
                data?.let {
                    bottomDialog.resultPickImage(it)
                }
            }
        }

    }
}
