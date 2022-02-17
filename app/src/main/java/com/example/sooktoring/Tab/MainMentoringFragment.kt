package com.example.sooktoring.Tab

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sooktoring.Model.userModel
import com.example.sooktoring.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.main_club_fragment.*
import kotlinx.android.synthetic.main.main_mentoring_fragment.*
import kotlinx.android.synthetic.main.main_mentoring_fragment.view.*
import kotlinx.android.synthetic.main.mentor_home.view.*

class MainMentoringFragment : Fragment() {

    var firestore: FirebaseFirestore? = null
    var uid : String? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        var view = inflater.inflate(R.layout.main_mentoring_fragment, container, false)
        firestore = FirebaseFirestore.getInstance()
        uid = FirebaseAuth.getInstance().currentUser?.uid

        view.part01_recycler.adapter = DetailViewRecyclerViewAdapter()
        view.part01_recycler.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        view.part02_recycler.adapter = DetailViewRecyclerViewAdapter2()
        view.part02_recycler.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        view.part03_recycler.adapter = DetailViewRecyclerViewAdapter3()
        view.part03_recycler.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        view.part04_recycler.adapter = DetailViewRecyclerViewAdapter4()
        view.part04_recycler.layoutManager = LinearLayoutManager(activity).also { it.orientation = LinearLayoutManager.HORIZONTAL }

        val spaceDecoration = VerticalSpaceItemDecoration(20)
        view.part01_recycler.addItemDecoration(spaceDecoration)
        view.part02_recycler.addItemDecoration(spaceDecoration)
        view.part03_recycler.addItemDecoration(spaceDecoration)
        view.part04_recycler.addItemDecoration(spaceDecoration)


        return view
    }

    inner class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = verticalSpaceHeight
        }
    }

    inner class DetailViewRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var UserModel : ArrayList<userModel> = arrayListOf()


        init {
            firestore?.collection("userInfo")?.orderBy("careerTag")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                UserModel.clear()

                //contentUidList.clear()

                //Sometimes, This code return null of querySnapshot when it signout
                if(querySnapshot == null) return@addSnapshotListener

                for(snapshot in querySnapshot!!.documents){
                    var item = snapshot.toObject(userModel::class.java)
                    if(item?.careerTag == "UXUI")
                        UserModel.add(item!!)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            var view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_home, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            //User Career
            viewholder.mentor_tv_career.text = UserModel!![position].career

            //User Name
            viewholder.mentor_tv_name.text = UserModel!![position].uname

            //ProfileImages
            if (UserModel!![position].imageUrl == null) {
                viewholder.mentor_iv_profile.setImageResource(R.drawable.ic_init_profile)
            } else {
                Glide.with(holder.itemView.context).load(UserModel!![position].imageUrl).into(viewholder.mentor_iv_profile)
            }

            //rank
            viewholder.mentor_tv_user_rank.text = UserModel!![position].urank

            //rankimg
            if (UserModel!![position].urank == "눈덩이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.ic_noondung)
            } else if (UserModel!![position].urank == "눈송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_snowflower)
            } else if (UserModel!![position].urank == "퀸송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_queensong)
            }
        }

        override fun getItemCount(): Int {
            return UserModel.size
        }
    }



    inner class DetailViewRecyclerViewAdapter2 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var UserModel : ArrayList<userModel> = arrayListOf()


        init {
            firestore?.collection("userInfo")?.orderBy("careerTag")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                UserModel.clear()

                //contentUidList.clear()

                //Sometimes, This code return null of querySnapshot when it signout
                if(querySnapshot == null) return@addSnapshotListener

                for(snapshot in querySnapshot!!.documents){
                    var item = snapshot.toObject(userModel::class.java)
                    if(item?.careerTag == "ADV")
                        UserModel.add(item!!)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            var view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_home, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            //User Career
            viewholder.mentor_tv_career.text = UserModel!![position].career

            //User Name
            viewholder.mentor_tv_name.text = UserModel!![position].uname

            //ProfileImages
            if (UserModel!![position].imageUrl == null) {
                viewholder.mentor_iv_profile.setImageResource(R.drawable.ic_init_profile)
            } else {
                Glide.with(holder.itemView.context).load(UserModel!![position].imageUrl).into(viewholder.mentor_iv_profile)
            }

            //rank
            viewholder.mentor_tv_user_rank.text = UserModel!![position].urank

            //rankimg
            if (UserModel!![position].urank == "눈덩이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.ic_noondung)
            } else if (UserModel!![position].urank == "눈송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_snowflower)
            } else if (UserModel!![position].urank == "퀸송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_queensong)
            }
        }

        override fun getItemCount(): Int {
            return UserModel.size
        }

    }


    inner class DetailViewRecyclerViewAdapter3 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var UserModel : ArrayList<userModel> = arrayListOf()


        init {
            firestore?.collection("userInfo")?.orderBy("careerTag")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                UserModel.clear()

                //contentUidList.clear()

                //Sometimes, This code return null of querySnapshot when it signout
                if(querySnapshot == null) return@addSnapshotListener

                for(snapshot in querySnapshot!!.documents){
                    var item = snapshot.toObject(userModel::class.java)
                    if(item?.careerTag == "BRAND")
                        UserModel.add(item!!)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            var view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_home, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            //User Career
            viewholder.mentor_tv_career.text = UserModel!![position].career

            //User Name
            viewholder.mentor_tv_name.text = UserModel!![position].uname

            //ProfileImages
            if (UserModel!![position].imageUrl == null) {
                viewholder.mentor_iv_profile.setImageResource(R.drawable.ic_init_profile)
            } else {
                Glide.with(holder.itemView.context).load(UserModel!![position].imageUrl).into(viewholder.mentor_iv_profile)
            }

            //rank
            viewholder.mentor_tv_user_rank.text = UserModel!![position].urank

            //rankimg
            if (UserModel!![position].urank == "눈덩이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.ic_noondung)
            } else if (UserModel!![position].urank == "눈송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_snowflower)
            } else if (UserModel!![position].urank == "퀸송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_queensong)
            }
        }

        override fun getItemCount(): Int {
            return UserModel.size
        }
    }


    inner class DetailViewRecyclerViewAdapter4 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var UserModel : ArrayList<userModel> = arrayListOf()


        init {
            firestore?.collection("userInfo")?.orderBy("careerTag")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                UserModel.clear()

                //contentUidList.clear()

                //Sometimes, This code return null of querySnapshot when it signout
                if(querySnapshot == null) return@addSnapshotListener

                for(snapshot in querySnapshot!!.documents){
                    var item = snapshot.toObject(userModel::class.java)
                    if(item?.careerTag == "FREE")
                        UserModel.add(item!!)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            var view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_home, parent, false)
            return CustomViewHolder(view)
        }

        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewholder = (holder as CustomViewHolder).itemView

            //User Career
            viewholder.mentor_tv_career.text = UserModel!![position].career

            //User Name
            viewholder.mentor_tv_name.text = UserModel!![position].uname

            //ProfileImages
            if (UserModel!![position].imageUrl == null) {
                viewholder.mentor_iv_profile.setImageResource(R.drawable.ic_init_profile)
            } else {
                Glide.with(holder.itemView.context).load(UserModel!![position].imageUrl).into(viewholder.mentor_iv_profile)
            }

            //rank
            viewholder.mentor_tv_user_rank.text = UserModel!![position].urank

            //rankimg
            if (UserModel!![position].urank == "눈덩이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.ic_noondung)
            } else if (UserModel!![position].urank == "눈송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_snowflower)
            } else if (UserModel!![position].urank == "퀸송이") {
                viewholder.mentor_iv_user_rank.setImageResource(R.drawable.img_queensong)
            }
        }

        override fun getItemCount(): Int {
            return UserModel.size
        }

    }


}