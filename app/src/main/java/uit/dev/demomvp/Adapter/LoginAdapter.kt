package uit.dev.demomvp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import java.util.ArrayList

import uit.dev.demomvp.Model.User
import uit.dev.demomvp.R

/**
 * Created by Administrator on 09/12/2017.
 */

class LoginAdapter(private val context: Context, internal var arrayUser: ArrayList<User>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayUser.size
    }

    override fun getItem(position: Int): Any {
        return arrayUser[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private inner class ViewHolder {
        internal var tvEmail: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v: View? = null
        val user = arrayUser[position]
        val viewHolder: ViewHolder
        if (convertView == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_login, parent, false)
            viewHolder = ViewHolder()
            viewHolder.tvEmail = v!!.findViewById<View>(R.id.tvEmail) as TextView

            viewHolder.tvEmail!!.text = user.email
            v.tag = viewHolder
        } else {
            v = convertView
            viewHolder = v.tag as ViewHolder
            viewHolder.tvEmail!!.text = user.email
            v.tag = viewHolder
        }

        return v

    }
}
