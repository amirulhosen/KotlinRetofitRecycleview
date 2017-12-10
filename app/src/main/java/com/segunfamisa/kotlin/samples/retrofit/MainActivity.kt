package com.segunfamisa.kotlin.samples.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.ItemClickSupport
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.SearchRepositoryProvider
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.adapter.listAdapter
import com.segunfamisa.kotlin.samples.retrofit.data.kotlin.notificationModel.VoiceActingRoleItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var voiceActingRole: List<VoiceActingRoleItem>? = null
    lateinit var recyclerView: RecyclerView
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//getting recyclerview from xml
        recyclerView = findViewById(R.id.recycleView) as RecyclerView
        progress = findViewById(R.id.progress) as ProgressBar
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val repository = SearchRepositoryProvider.provideSearchRepository()

        compositeDisposable.add(
                repository.searchUsers("Lagos", "Java")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result ->
                            progress.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                            val adapter = listAdapter(result.voiceActingRole,this)
                            voiceActingRole = result.voiceActingRole;
                            //now adding the adapter to recyclerview
                            recyclerView.adapter = adapter
                            recyclerView.adapter.notifyDataSetChanged()
                            Log.d("Result", "There are ${result.voiceActingRole} Java developers in Lagos")
                        }, { error ->
                            error.printStackTrace()
                        })
        )

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(
                object : ItemClickSupport.OnItemClickListener {
                    override fun onItemClicked(recyclerView: RecyclerView?, position: Int, v: View?) {
                      Toast.makeText(this@MainActivity, voiceActingRole!![position].anime!!.name,Toast.LENGTH_LONG).show()
                    }
                }
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }
}
