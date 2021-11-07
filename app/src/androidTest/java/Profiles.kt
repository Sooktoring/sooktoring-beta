import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sooktoring.R
import com.google.firebase.auth.ktx.userProfileChangeRequest

class Profiles (){

}

class ProfileAdapter(val profileList: Arraylist<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {
    val view= LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    return CustomViewHolder(view).apply
}

val profile : Profiles = userProfileList.get(curPos) {

}

override fun getItemCount(): Int {
    return profileList.size
}

inner class CustomViewHolder(itemView: View, time) : RecyclerView.viewdtoddlfeo
inner class CustomViewHolder() {

}
        val profile=itemView.findViewMyId<TextView>(R.id.textView)
